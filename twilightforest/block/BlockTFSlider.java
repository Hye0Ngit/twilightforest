// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import twilightforest.client.ModelUtils;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFSlideBlock;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockRotatedPillar;

public class BlockTFSlider extends BlockRotatedPillar implements ModelRegisterCallback
{
    public static final IProperty<Integer> DELAY;
    private static final int TICK_TIME = 80;
    private static final int OFFSET_TIME = 20;
    private static final int PLAYER_RANGE = 32;
    private static final float BLOCK_DAMAGE = 5.0f;
    private static final AxisAlignedBB Y_BB;
    private static final AxisAlignedBB Z_BB;
    private static final AxisAlignedBB X_BB;
    
    protected BlockTFSlider() {
        super(Material.field_151573_f, MapColor.field_151664_l);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(2.0f);
        this.func_149752_b(10.0f);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFSlider.field_176298_M, (Comparable)EnumFacing.Axis.Y).func_177226_a((IProperty)BlockTFSlider.DELAY, (Comparable)0));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockTFSlider.field_176298_M, BlockTFSlider.DELAY });
    }
    
    public int func_176201_c(final IBlockState state) {
        return super.func_176201_c(state) | (int)state.func_177229_b((IProperty)BlockTFSlider.DELAY);
    }
    
    public IBlockState func_176203_a(final int meta) {
        return super.func_176203_a(meta).func_177226_a((IProperty)BlockTFSlider.DELAY, (Comparable)(meta & 0x3));
    }
    
    @Deprecated
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        switch ((EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFSlider.field_176298_M)) {
            default: {
                return BlockTFSlider.Y_BB;
            }
            case X: {
                return BlockTFSlider.X_BB;
            }
            case Z: {
                return BlockTFSlider.Z_BB;
            }
        }
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
        return BlockFaceShape.UNDEFINED;
    }
    
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState state, final Random random) {
        if (!world.field_72995_K && this.isConnectedInRange(world, pos)) {
            final EntityTFSlideBlock slideBlock = new EntityTFSlideBlock(world, pos.func_177958_n() + 0.5, pos.func_177956_o(), pos.func_177952_p() + 0.5, state);
            world.func_72838_d((Entity)slideBlock);
        }
        this.scheduleBlockUpdate(world, pos);
    }
    
    public boolean isConnectedInRange(final World world, final BlockPos pos) {
        final EnumFacing.Axis axis = (EnumFacing.Axis)world.func_180495_p(pos).func_177229_b((IProperty)BlockTFSlider.field_176298_M);
        switch (axis) {
            case Y: {
                return this.anyPlayerInRange(world, pos) || this.isConnectedInRangeRecursive(world, pos, EnumFacing.UP) || this.isConnectedInRangeRecursive(world, pos, EnumFacing.DOWN);
            }
            case X: {
                return this.anyPlayerInRange(world, pos) || this.isConnectedInRangeRecursive(world, pos, EnumFacing.WEST) || this.isConnectedInRangeRecursive(world, pos, EnumFacing.EAST);
            }
            case Z: {
                return this.anyPlayerInRange(world, pos) || this.isConnectedInRangeRecursive(world, pos, EnumFacing.NORTH) || this.isConnectedInRangeRecursive(world, pos, EnumFacing.SOUTH);
            }
            default: {
                return this.anyPlayerInRange(world, pos);
            }
        }
    }
    
    private boolean isConnectedInRangeRecursive(final World world, final BlockPos pos, final EnumFacing dir) {
        final BlockPos dPos = pos.func_177972_a(dir);
        return world.func_180495_p(pos) == world.func_180495_p(dPos) && (this.anyPlayerInRange(world, dPos) || this.isConnectedInRangeRecursive(world, dPos, dir));
    }
    
    private boolean anyPlayerInRange(final World world, final BlockPos pos) {
        return world.func_184137_a(pos.func_177958_n() + 0.5, pos.func_177956_o() + 0.5, pos.func_177952_p() + 0.5, 32.0, false) != null;
    }
    
    public void scheduleBlockUpdate(final World world, final BlockPos pos) {
        final int offset = (int)world.func_180495_p(pos).func_177229_b((IProperty)BlockTFSlider.DELAY);
        final int update = 80 - (int)(world.func_72820_D() - offset * 20) % 80;
        world.func_175684_a(pos, (Block)this, update);
    }
    
    public void func_176213_c(final World world, final BlockPos pos, final IBlockState state) {
        this.scheduleBlockUpdate(world, pos);
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        list.add((Object)new ItemStack((Block)this, 1, 0));
        list.add((Object)new ItemStack((Block)this, 1, 1));
        list.add((Object)new ItemStack((Block)this, 1, 2));
        list.add((Object)new ItemStack((Block)this, 1, 3));
    }
    
    public void func_180634_a(final World world, final BlockPos pos, final IBlockState state, final Entity entity) {
        entity.func_70097_a(DamageSource.field_76377_j, 5.0f);
        if (entity instanceof EntityLivingBase) {
            final double kx = (pos.func_177958_n() + 0.5 - entity.field_70165_t) * 2.0;
            final double kz = (pos.func_177952_p() + 0.5 - entity.field_70161_v) * 2.0;
            ((EntityLivingBase)entity).func_70653_a((Entity)null, 2.0f, kx, kz);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final IStateMapper stateMapper = (IStateMapper)new StateMap.Builder().func_178442_a(new IProperty[] { BlockTFSlider.DELAY }).func_178441_a();
        ModelLoader.setCustomStateMapper((Block)this, stateMapper);
        for (int i = 0; i < 4; ++i) {
            ModelUtils.registerToState((Block)this, i, this.func_176223_P(), stateMapper);
        }
    }
    
    static {
        DELAY = (IProperty)PropertyInteger.func_177719_a("delay", 0, 3);
        Y_BB = new AxisAlignedBB(0.3125, 0.0, 0.3125, 0.6875, 1.0, 0.6875);
        Z_BB = new AxisAlignedBB(0.3125, 0.3125, 0.0, 0.6875, 0.6875, 1.0);
        X_BB = new AxisAlignedBB(0.0, 0.3125, 0.3125, 1.0, 0.6875, 0.6875);
    }
}
