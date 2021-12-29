// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.block.BlockLog;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFCinderLog;
import twilightforest.block.TFBlocks;
import net.minecraft.item.Item;
import twilightforest.block.BlockTFCinderFurnace;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

public class TileEntityTFCinderFurnace extends TileEntityFurnace
{
    private static final int SMELT_LOG_FACTOR = 10;
    
    public void func_73660_a() {
        final boolean flag = this.func_145950_i();
        boolean flag2 = false;
        if (this.func_145950_i()) {
            --this.field_145956_a;
        }
        if (!this.field_145850_b.field_72995_K) {
            final ItemStack itemstack = (ItemStack)this.field_145957_n.get(1);
            if (this.func_145950_i() || (!itemstack.func_190926_b() && !((ItemStack)this.field_145957_n.get(0)).func_190926_b())) {
                if (!this.func_145950_i() && this.canSmelt()) {
                    this.field_145956_a = func_145952_a(itemstack);
                    this.field_145963_i = this.field_145956_a;
                    if (this.func_145950_i()) {
                        flag2 = true;
                        if (!itemstack.func_190926_b()) {
                            final Item item = itemstack.func_77973_b();
                            itemstack.func_190918_g(1);
                            if (itemstack.func_190926_b()) {
                                final ItemStack item2 = item.getContainerItem(itemstack);
                                this.field_145957_n.set(1, (Object)item2);
                            }
                        }
                    }
                }
                if (this.func_145950_i() && this.canSmelt()) {
                    this.field_174906_k += this.getCurrentSpeedMultiplier();
                    if (this.field_174906_k >= this.field_174905_l) {
                        this.field_174906_k = 0;
                        this.field_174905_l = this.func_174904_a((ItemStack)this.field_145957_n.get(0));
                        this.func_145949_j();
                        flag2 = true;
                    }
                }
                else {
                    this.field_174906_k = 0;
                }
            }
            else if (!this.func_145950_i() && this.field_174906_k > 0) {
                this.field_174906_k = MathHelper.func_76125_a(this.field_174906_k - 2, 0, this.field_174905_l);
            }
            if (flag != this.func_145950_i()) {
                flag2 = true;
                BlockTFCinderFurnace.setState(this.func_145950_i(), this.field_145850_b, this.field_174879_c);
            }
            if (this.func_145950_i() && this.field_145956_a % 5 == 0) {
                this.cinderizeNearbyLog();
            }
        }
        if (flag2) {
            this.func_70296_d();
        }
    }
    
    private void cinderizeNearbyLog() {
        final Random rand = this.func_145831_w().field_73012_v;
        final int dx = rand.nextInt(2) - rand.nextInt(2);
        final int dy = rand.nextInt(2) - rand.nextInt(2);
        final int dz = rand.nextInt(2) - rand.nextInt(2);
        final BlockPos pos = this.func_174877_v().func_177982_a(dx, dy, dz);
        if (this.field_145850_b.func_175667_e(pos)) {
            final Block nearbyBlock = this.func_145831_w().func_180495_p(pos).func_177230_c();
            if (nearbyBlock != TFBlocks.cinder_log && this.isLog(nearbyBlock)) {
                this.func_145831_w().func_180501_a(pos, TFBlocks.cinder_log.func_176223_P().func_177226_a((IProperty)BlockTFCinderLog.field_176299_a, (Comparable)this.getCinderFacing(dx, dy, dz)), 2);
                this.func_145831_w().func_175718_b(2004, pos, 0);
                this.func_145831_w().func_175718_b(2004, pos, 0);
                this.func_145831_w().func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187643_bs, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
        }
    }
    
    private BlockLog.EnumAxis getCinderFacing(final int dx, final int dy, final int dz) {
        if (dz == 0 && dx != 0) {
            return (dy == 0) ? BlockLog.EnumAxis.X : BlockLog.EnumAxis.Z;
        }
        if (dx == 0 && dz != 0) {
            return (dy == 0) ? BlockLog.EnumAxis.Z : BlockLog.EnumAxis.X;
        }
        if (dx == 0 && dz == 0) {
            return BlockLog.EnumAxis.Y;
        }
        return (dy == 0) ? BlockLog.EnumAxis.Y : BlockLog.EnumAxis.NONE;
    }
    
    private boolean isLog(final Block nearbyBlock) {
        final int[] oreIDs2;
        final int[] oreIDs = oreIDs2 = OreDictionary.getOreIDs(new ItemStack(nearbyBlock));
        for (final int id : oreIDs2) {
            if (id == OreDictionary.getOreID("logWood")) {
                return true;
            }
        }
        return false;
    }
    
    private int getCurrentSpeedMultiplier() {
        return this.getCurrentMultiplier(2);
    }
    
    private int getCurrentMultiplier(final int factor) {
        final int logs = this.countNearbyLogs();
        if (logs < factor) {
            return 1;
        }
        return logs / factor + ((this.field_145850_b.field_73012_v.nextInt(factor) < logs % factor) ? 1 : 0);
    }
    
    private int countNearbyLogs() {
        int count = 0;
        for (int dx = -1; dx <= 1; ++dx) {
            for (int dy = -1; dy <= 1; ++dy) {
                for (int dz = -1; dz <= 1; ++dz) {
                    final BlockPos pos = this.func_174877_v().func_177982_a(dx, dy, dz);
                    if (this.field_145850_b.func_175667_e(pos) && this.func_145831_w().func_180495_p(pos).func_177230_c() == TFBlocks.cinder_log) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    private boolean canSmelt() {
        if (((ItemStack)this.field_145957_n.get(0)).func_190926_b()) {
            return false;
        }
        final ItemStack itemstack = FurnaceRecipes.func_77602_a().func_151395_a((ItemStack)this.field_145957_n.get(0));
        if (itemstack.func_190926_b()) {
            return false;
        }
        final ItemStack itemstack2 = (ItemStack)this.field_145957_n.get(2);
        if (itemstack2.func_190926_b()) {
            return true;
        }
        if (!itemstack2.func_77969_a(itemstack)) {
            return false;
        }
        final int result = itemstack2.func_190916_E() + this.getMaxOutputStacks((ItemStack)this.field_145957_n.get(0), itemstack);
        return result <= this.func_70297_j_() && result <= itemstack2.func_77976_d();
    }
    
    public int getMaxOutputStacks(final ItemStack input, final ItemStack output) {
        if (this.canMultiply(input, output)) {
            return output.func_190916_E() * this.getCurrentMaxSmeltMultiplier();
        }
        return output.func_190916_E();
    }
    
    public void func_145949_j() {
        if (this.canSmelt()) {
            final ItemStack itemstack = (ItemStack)this.field_145957_n.get(0);
            final ItemStack itemstack2 = FurnaceRecipes.func_77602_a().func_151395_a(itemstack);
            itemstack2.func_190920_e(itemstack2.func_190916_E() * this.getCurrentSmeltMultiplier());
            final ItemStack itemstack3 = (ItemStack)this.field_145957_n.get(2);
            if (itemstack3.func_190926_b()) {
                this.field_145957_n.set(2, (Object)itemstack2.func_77946_l());
            }
            else if (itemstack3.func_77973_b() == itemstack2.func_77973_b()) {
                itemstack3.func_190917_f(itemstack2.func_190916_E());
            }
            if (itemstack.func_77973_b() == Item.func_150898_a(Blocks.field_150360_v) && itemstack.func_77960_j() == 1 && !((ItemStack)this.field_145957_n.get(1)).func_190926_b() && ((ItemStack)this.field_145957_n.get(1)).func_77973_b() == Items.field_151133_ar) {
                this.field_145957_n.set(1, (Object)new ItemStack(Items.field_151131_as));
            }
            itemstack.func_190918_g(1);
        }
    }
    
    private boolean canMultiply(final ItemStack input, final ItemStack output) {
        final int[] oreIDs2;
        final int[] oreIDs = oreIDs2 = OreDictionary.getOreIDs(input);
        for (final int id : oreIDs2) {
            if (OreDictionary.getOreName(id).startsWith("ore") || id == OreDictionary.getOreID("logWood")) {
                return true;
            }
        }
        return false;
    }
    
    private int getCurrentSmeltMultiplier() {
        return this.getCurrentMultiplier(10);
    }
    
    private int getCurrentMaxSmeltMultiplier() {
        return (int)Math.ceil(this.countNearbyLogs() / 10.0f);
    }
}
