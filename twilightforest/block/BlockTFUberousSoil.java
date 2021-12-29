// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.IGrowable;
import net.minecraft.block.Block;

public class BlockTFUberousSoil extends Block implements IGrowable
{
    protected BlockTFUberousSoil() {
        super(Material.field_151578_c);
        this.func_149676_a(0.0f, 0.0f, 0.0f, 1.0f, 0.9375f, 1.0f);
        this.func_149713_g(255);
        this.func_149711_c(0.6f);
        this.func_149672_a(BlockTFUberousSoil.field_149767_g);
        this.func_149675_a(true);
        this.func_149658_d("TwilightForest:uberous_soil");
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public Item func_149650_a(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Blocks.field_150346_d.func_149650_a(0, p_149650_2_, p_149650_3_);
    }
    
    public void func_149674_a(final World world, final int x, final int y, final int z, final Random rand) {
        final Material aboveMaterial = world.func_147439_a(x, y + 1, z).func_149688_o();
        if (aboveMaterial.func_76220_a()) {
            world.func_147449_b(x, y, z, Blocks.field_150346_d);
        }
    }
    
    public boolean canSustainPlant(final IBlockAccess world, final int x, final int y, final int z, final ForgeDirection direction, final IPlantable plantable) {
        final EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
        return plantType == EnumPlantType.Crop || plantType == EnumPlantType.Plains || plantType == EnumPlantType.Cave;
    }
    
    public void func_149695_a(final World world, final int x, final int y, final int z, final Block neighbor) {
        final Block above = world.func_147439_a(x, y + 1, z);
        final Material aboveMaterial = above.func_149688_o();
        if (aboveMaterial.func_76220_a()) {
            world.func_147449_b(x, y, z, Blocks.field_150346_d);
        }
        if (above instanceof IPlantable) {
            final IPlantable plant = (IPlantable)above;
            if (plant.getPlantType((IBlockAccess)world, x, y + 1, z) == EnumPlantType.Crop) {
                world.func_147465_d(x, y, z, Blocks.field_150458_ak, 2, 2);
            }
            else if (plant.getPlantType((IBlockAccess)world, x, y + 1, z) == EnumPlantType.Plains) {
                world.func_147449_b(x, y, z, (Block)Blocks.field_150349_c);
            }
            else {
                world.func_147449_b(x, y, z, Blocks.field_150346_d);
            }
            ItemDye.applyBonemeal(new ItemStack(Items.field_151100_aR), world, x, y + 1, z, (EntityPlayer)null);
            ItemDye.applyBonemeal(new ItemStack(Items.field_151100_aR), world, x, y + 1, z, (EntityPlayer)null);
            ItemDye.applyBonemeal(new ItemStack(Items.field_151100_aR), world, x, y + 1, z, (EntityPlayer)null);
            ItemDye.applyBonemeal(new ItemStack(Items.field_151100_aR), world, x, y + 1, z, (EntityPlayer)null);
            if (!world.field_72995_K) {
                world.func_72926_e(2005, x, y + 1, z, 0);
            }
        }
    }
    
    public boolean func_149851_a(final World world, final int x, final int y, final int z, final boolean var5) {
        return true;
    }
    
    public boolean func_149852_a(final World world, final Random rand, final int x, final int y, final int z) {
        return true;
    }
    
    public void func_149853_b(final World world, final Random rand, final int x, final int y, final int z) {
        int gx = x;
        final int gy = y;
        int gz = z;
        if (rand.nextBoolean()) {
            gx += (rand.nextBoolean() ? 1 : -1);
        }
        else {
            gz += (rand.nextBoolean() ? 1 : -1);
        }
        final Block blockAt = world.func_147439_a(gx, gy, gz);
        if (world.func_147437_c(gx, gy + 1, gz) && (blockAt == Blocks.field_150346_d || blockAt == Blocks.field_150349_c || blockAt == Blocks.field_150458_ak)) {
            world.func_147449_b(gx, gy, gz, (Block)this);
        }
    }
}
