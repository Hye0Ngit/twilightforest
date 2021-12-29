// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockFarmland;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.IGrowable;
import net.minecraft.block.Block;

public class BlockTFUberousSoil extends Block implements IGrowable, ModelRegisterCallback
{
    private static final AxisAlignedBB AABB;
    
    protected BlockTFUberousSoil() {
        super(Material.field_151578_c);
        this.func_149713_g(255);
        this.func_149711_c(0.6f);
        this.func_149672_a(SoundType.field_185849_b);
        this.func_149675_a(true);
        this.field_149783_u = true;
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Deprecated
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return BlockTFUberousSoil.AABB;
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public BlockFaceShape func_193383_a(final IBlockAccess worldIn, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        return (face == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    public Item func_180660_a(final IBlockState state, final Random rand, final int fortune) {
        return Item.func_150898_a(Blocks.field_150346_d);
    }
    
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState state, final Random rand) {
        final Material aboveMaterial = world.func_180495_p(pos.func_177984_a()).func_185904_a();
        if (aboveMaterial.func_76220_a()) {
            world.func_175656_a(pos, Blocks.field_150346_d.func_176223_P());
        }
    }
    
    public boolean canSustainPlant(final IBlockState state, final IBlockAccess world, final BlockPos pos, final EnumFacing direction, final IPlantable plantable) {
        if (direction != EnumFacing.UP) {
            return false;
        }
        final EnumPlantType plantType = plantable.getPlantType(world, pos.func_177972_a(direction));
        return plantType == EnumPlantType.Crop || plantType == EnumPlantType.Plains || plantType == EnumPlantType.Cave;
    }
    
    @Deprecated
    public void func_189540_a(final IBlockState state, final World world, final BlockPos pos, final Block neighbor, final BlockPos fromPos) {
        final IBlockState above = world.func_180495_p(pos.func_177984_a());
        final Material aboveMaterial = above.func_185904_a();
        if (aboveMaterial.func_76220_a()) {
            world.func_175656_a(pos, Blocks.field_150346_d.func_176223_P());
        }
        if (above.func_177230_c() instanceof IPlantable) {
            final IPlantable plant = (IPlantable)above.func_177230_c();
            if (plant.getPlantType((IBlockAccess)world, pos.func_177984_a()) == EnumPlantType.Crop) {
                world.func_175656_a(pos, Blocks.field_150458_ak.func_176223_P().func_177226_a((IProperty)BlockFarmland.field_176531_a, (Comparable)2));
            }
            else if (plant.getPlantType((IBlockAccess)world, pos.func_177984_a()) == EnumPlantType.Plains) {
                world.func_175656_a(pos, Blocks.field_150349_c.func_176223_P());
            }
            else {
                world.func_175656_a(pos, Blocks.field_150346_d.func_176223_P());
            }
            ItemDye.func_179234_a(new ItemStack(Items.field_151100_aR), world, pos.func_177984_a());
            ItemDye.func_179234_a(new ItemStack(Items.field_151100_aR), world, pos.func_177984_a());
            ItemDye.func_179234_a(new ItemStack(Items.field_151100_aR), world, pos.func_177984_a());
            ItemDye.func_179234_a(new ItemStack(Items.field_151100_aR), world, pos.func_177984_a());
            world.func_175718_b(2005, pos.func_177984_a(), 0);
        }
    }
    
    public boolean func_176473_a(final World world, final BlockPos pos, final IBlockState state, final boolean isClient) {
        return true;
    }
    
    public boolean func_180670_a(final World world, final Random rand, final BlockPos pos, final IBlockState state) {
        return true;
    }
    
    public void func_176474_b(final World world, final Random rand, BlockPos pos, final IBlockState state) {
        pos = pos.func_177972_a(EnumFacing.field_176754_o[rand.nextInt(EnumFacing.field_176754_o.length)]);
        final Block blockAt = world.func_180495_p(pos).func_177230_c();
        if (world.func_175623_d(pos.func_177984_a()) && (blockAt == Blocks.field_150346_d || blockAt == Blocks.field_150349_c || blockAt == Blocks.field_150458_ak)) {
            world.func_175656_a(pos, this.func_176223_P());
        }
    }
    
    static {
        AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.9375, 1.0);
    }
}
