// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraftforge.common.Tags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.tags.BlockTags;
import twilightforest.block.TFBlocks;
import java.util.function.Function;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.Item;
import net.minecraft.state.Property;
import twilightforest.block.CinderFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.MathHelper;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.FurnaceTileEntity;

public class CinderFurnaceTileEntity extends FurnaceTileEntity
{
    private static final int SMELT_LOG_FACTOR = 10;
    
    public void func_73660_a() {
        final boolean flag = this.isBurning();
        boolean flag2 = false;
        if (this.isBurning()) {
            --this.field_214018_j;
        }
        if (!this.field_145850_b.field_72995_K) {
            final ItemStack itemstack = (ItemStack)this.field_214012_a.get(1);
            if (this.isBurning() || (!itemstack.func_190926_b() && !((ItemStack)this.field_214012_a.get(0)).func_190926_b())) {
                final IRecipe<?> irecipe = (IRecipe<?>)this.field_145850_b.func_199532_z().func_215371_a(IRecipeType.field_222150_b, (IInventory)this, this.field_145850_b).orElse(null);
                if (!this.isBurning() && this.func_214008_b(irecipe)) {
                    this.field_214018_j = this.func_213997_a(itemstack);
                    this.field_214019_k = this.field_214018_j;
                    if (this.isBurning()) {
                        flag2 = true;
                        if (!itemstack.func_190926_b()) {
                            final Item item = itemstack.func_77973_b();
                            itemstack.func_190918_g(1);
                            if (itemstack.func_190926_b()) {
                                final ItemStack item2 = item.getContainerItem(itemstack);
                                this.field_214012_a.set(1, (Object)item2);
                            }
                        }
                    }
                }
                if (this.isBurning() && this.func_214008_b(irecipe)) {
                    this.field_214020_l += this.getCurrentSpeedMultiplier();
                    if (this.field_214020_l >= this.field_214021_m) {
                        this.field_214020_l = 0;
                        this.field_214021_m = this.getRecipeBurnTime();
                        this.smeltItem(irecipe);
                        flag2 = true;
                    }
                }
                else {
                    this.field_214020_l = 0;
                }
            }
            else if (!this.isBurning() && this.field_214020_l > 0) {
                this.field_214020_l = MathHelper.func_76125_a(this.field_214020_l - 2, 0, this.field_214021_m);
            }
            if (flag != this.isBurning()) {
                flag2 = true;
                this.field_145850_b.func_180501_a(this.field_174879_c, (BlockState)this.field_145850_b.func_180495_p(this.field_174879_c).func_206870_a((Property)CinderFurnaceBlock.LIT, (Comparable)this.isBurning()), 3);
            }
            if (this.isBurning() && this.field_214018_j % 5 == 0) {
                this.cinderizeNearbyLog();
            }
        }
        if (flag2) {
            this.func_70296_d();
        }
    }
    
    private boolean isBurning() {
        return this.field_214018_j > 0;
    }
    
    protected int getRecipeBurnTime() {
        return this.field_145850_b.func_199532_z().func_215371_a(IRecipeType.field_222150_b, (IInventory)this, this.field_145850_b).map(AbstractCookingRecipe::func_222137_e).orElse(200);
    }
    
    private void cinderizeNearbyLog() {
        final Random rand = this.func_145831_w().field_73012_v;
        final int dx = rand.nextInt(2) - rand.nextInt(2);
        final int dy = rand.nextInt(2) - rand.nextInt(2);
        final int dz = rand.nextInt(2) - rand.nextInt(2);
        final BlockPos pos = this.func_174877_v().func_177982_a(dx, dy, dz);
        if (this.field_145850_b.func_175667_e(pos)) {
            final Block nearbyBlock = this.func_145831_w().func_180495_p(pos).func_177230_c();
            if (nearbyBlock != TFBlocks.cinder_log.get() && BlockTags.field_200031_h.func_230235_a_((Object)nearbyBlock)) {
                this.func_145831_w().func_180501_a(pos, this.getCinderLog(dx, dy, dz), 2);
                this.func_145831_w().func_217379_c(2004, pos, 0);
                this.func_145831_w().func_217379_c(2004, pos, 0);
                this.func_145831_w().func_184133_a((PlayerEntity)null, pos, SoundEvents.field_187643_bs, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
        }
    }
    
    private BlockState getCinderLog(final int dx, final int dy, final int dz) {
        Direction.Axis direction;
        if (dz == 0 && dx != 0) {
            direction = ((dy == 0) ? Direction.Axis.X : Direction.Axis.Z);
        }
        else if (dx == 0 && dz != 0) {
            direction = ((dy == 0) ? Direction.Axis.Z : Direction.Axis.X);
        }
        else if (dx == 0 && dz == 0) {
            direction = Direction.Axis.Y;
        }
        else {
            direction = ((dy == 0) ? Direction.Axis.Y : null);
        }
        return (BlockState)((direction != null) ? ((RotatedPillarBlock)TFBlocks.cinder_log.get()).func_176223_P().func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)direction) : ((Block)TFBlocks.cinder_wood.get()).func_176223_P());
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
                    if (this.field_145850_b.func_175667_e(pos) && this.func_145831_w().func_180495_p(pos).func_177230_c() == TFBlocks.cinder_log.get()) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    protected boolean func_214008_b(final IRecipe<?> recipe) {
        if (((ItemStack)this.field_214012_a.get(0)).func_190926_b()) {
            return false;
        }
        final ItemStack itemstack = recipe.func_77571_b();
        if (itemstack.func_190926_b()) {
            return false;
        }
        final ItemStack itemstack2 = (ItemStack)this.field_214012_a.get(2);
        if (itemstack2.func_190926_b()) {
            return true;
        }
        if (!itemstack2.func_77969_a(itemstack)) {
            return false;
        }
        final int result = itemstack2.func_190916_E() + this.getMaxOutputStacks((ItemStack)this.field_214012_a.get(0), itemstack);
        return result <= this.func_70297_j_() && result <= itemstack2.func_77976_d();
    }
    
    public int getMaxOutputStacks(final ItemStack input, final ItemStack output) {
        if (this.canMultiply(input, output)) {
            return output.func_190916_E() * this.getCurrentMaxSmeltMultiplier();
        }
        return output.func_190916_E();
    }
    
    public void smeltItem(final IRecipe<?> recipe) {
        if (this.func_214008_b(recipe)) {
            final ItemStack itemstack = (ItemStack)this.field_214012_a.get(0);
            final ItemStack itemstack2 = recipe.func_77571_b();
            itemstack2.func_190920_e(itemstack2.func_190916_E() * this.getCurrentSmeltMultiplier());
            final ItemStack itemstack3 = (ItemStack)this.field_214012_a.get(2);
            if (itemstack3.func_190926_b()) {
                this.field_214012_a.set(2, (Object)itemstack2.func_77946_l());
            }
            else if (itemstack3.func_77973_b() == itemstack2.func_77973_b()) {
                itemstack3.func_190917_f(itemstack2.func_190916_E());
            }
            if (itemstack.func_77973_b() == Blocks.field_196577_ad.func_199767_j() && !((ItemStack)this.field_214012_a.get(1)).func_190926_b() && ((ItemStack)this.field_214012_a.get(1)).func_77973_b() == Items.field_151133_ar) {
                this.field_214012_a.set(1, (Object)new ItemStack((IItemProvider)Items.field_151131_as));
            }
            itemstack.func_190918_g(1);
        }
    }
    
    private boolean canMultiply(final ItemStack input, final ItemStack output) {
        return ItemTags.field_200038_h.func_230235_a_((Object)input.func_77973_b()) || Tags.Items.ORES.func_230235_a_((Object)input.func_77973_b());
    }
    
    private int getCurrentSmeltMultiplier() {
        return this.getCurrentMultiplier(10);
    }
    
    private int getCurrentMaxSmeltMultiplier() {
        return (int)Math.ceil(this.countNearbyLogs() / 10.0f);
    }
}
