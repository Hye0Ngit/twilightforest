// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import twilightforest.client.ModelUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import java.util.Random;
import java.util.Iterator;
import twilightforest.util.WorldUtil;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.pathfinding.PathNodeType;
import twilightforest.enums.Leaves3Variant;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.enums.ThornVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;

public class BlockTFThorns extends BlockTFConnectableRotatedPillar implements ModelRegisterCallback
{
    public static final IProperty<ThornVariant> VARIANT;
    private static final float THORN_DAMAGE = 4.0f;
    
    BlockTFThorns() {
        super(Material.field_151575_d, MapColor.field_151654_J, 10.0);
        this.func_149711_c(50.0f);
        this.func_149752_b(2000.0f);
        this.func_149672_a(SoundType.field_185848_a);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        if (this.hasVariant()) {
            this.func_180632_j(this.func_176223_P().func_177226_a((IProperty)BlockTFThorns.VARIANT, (Comparable)ThornVariant.BROWN));
        }
    }
    
    @Override
    protected IProperty[] getAdditionalProperties() {
        return new IProperty[] { BlockTFThorns.VARIANT };
    }
    
    protected boolean hasVariant() {
        return true;
    }
    
    public int func_176201_c(final IBlockState state) {
        return this.hasVariant() ? (super.func_176201_c(state) | ((ThornVariant)state.func_177229_b((IProperty)BlockTFThorns.VARIANT)).ordinal()) : super.func_176201_c(state);
    }
    
    public IBlockState func_176203_a(final int meta) {
        return this.hasVariant() ? super.func_176203_a(meta).func_177226_a((IProperty)BlockTFThorns.VARIANT, (Comparable)ThornVariant.values()[meta & 0x3]) : super.func_176203_a(meta);
    }
    
    public MapColor func_180659_g(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return (state.func_177229_b((IProperty)BlockTFThorns.VARIANT) == ThornVariant.GREEN) ? MapColor.field_151669_i : super.func_180659_g(state, world, pos);
    }
    
    @Override
    protected boolean canConnectTo(final IBlockState state, final IBlockState otherState, final IBlockAccess world, final BlockPos pos, final EnumFacing connectTo) {
        return otherState.func_177230_c() instanceof BlockTFThorns || otherState.func_177230_c() == TFBlocks.thorn_rose || (otherState.func_177230_c() == TFBlocks.twilight_leaves_3 && otherState.func_177229_b((IProperty)BlockTFLeaves3.VARIANT) == Leaves3Variant.THORN) || otherState.func_185904_a() == Material.field_151577_b || otherState.func_185904_a() == Material.field_151578_c || super.canConnectTo(state, otherState, world, pos, connectTo);
    }
    
    public int func_180651_a(final IBlockState state) {
        return this.hasVariant() ? ((ThornVariant)state.func_177229_b((IProperty)BlockTFThorns.VARIANT)).ordinal() : 0;
    }
    
    public PathNodeType getAiPathNodeType(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return PathNodeType.DAMAGE_CACTUS;
    }
    
    public void func_180634_a(final World world, final BlockPos pos, final IBlockState state, final Entity entity) {
        entity.func_70097_a(DamageSource.field_76367_g, 4.0f);
    }
    
    public void func_176199_a(final World world, final BlockPos pos, final Entity entity) {
        final IBlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() instanceof BlockTFThorns && state.func_177229_b((IProperty)BlockTFThorns.field_176298_M) == EnumFacing.Axis.Y) {
            this.func_180634_a(world, pos, state, entity);
        }
        super.func_176199_a(world, pos, entity);
    }
    
    public boolean removedByPlayer(final IBlockState state, final World world, final BlockPos pos, final EntityPlayer player, final boolean harvest) {
        if (!player.field_71075_bZ.field_75098_d) {
            if (!world.field_72995_K) {
                world.func_180501_a(pos, state, 2);
                this.doThornBurst(world, pos, state);
            }
        }
        else {
            world.func_175698_g(pos);
        }
        return true;
    }
    
    @Deprecated
    public EnumPushReaction func_149656_h(final IBlockState state) {
        return EnumPushReaction.BLOCK;
    }
    
    private void doThornBurst(final World world, final BlockPos pos, final IBlockState state) {
        switch ((EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFThorns.field_176298_M)) {
            case Y: {
                this.growThorns(world, pos, EnumFacing.UP);
                this.growThorns(world, pos, EnumFacing.DOWN);
                break;
            }
            case X: {
                this.growThorns(world, pos, EnumFacing.EAST);
                this.growThorns(world, pos, EnumFacing.WEST);
                break;
            }
            case Z: {
                this.growThorns(world, pos, EnumFacing.NORTH);
                this.growThorns(world, pos, EnumFacing.SOUTH);
                break;
            }
        }
        this.growThorns(world, pos, EnumFacing.func_176741_a(world.field_73012_v));
        this.growThorns(world, pos, EnumFacing.func_176741_a(world.field_73012_v));
        this.growThorns(world, pos, EnumFacing.func_176741_a(world.field_73012_v));
    }
    
    private void growThorns(final World world, final BlockPos pos, final EnumFacing dir) {
        for (int length = 1 + world.field_73012_v.nextInt(3), i = 1; i < length; ++i) {
            final BlockPos dPos = pos.func_177967_a(dir, i);
            if (!world.func_175623_d(dPos)) {
                break;
            }
            world.func_180501_a(dPos, this.func_176223_P().func_177226_a((IProperty)BlockTFThorns.field_176298_M, (Comparable)dir.func_176740_k()).func_177226_a((IProperty)BlockTFThorns.VARIANT, (Comparable)ThornVariant.GREEN), 2);
        }
    }
    
    public void func_180663_b(final World world, final BlockPos pos, final IBlockState state) {
        final int range = 4;
        final int exRange = range + 1;
        if (world.func_175697_a(pos, exRange)) {
            for (final BlockPos pos_ : WorldUtil.getAllAround(pos, range)) {
                final IBlockState state_ = world.func_180495_p(pos_);
                if (state_.func_177230_c().isLeaves(state_, (IBlockAccess)world, pos_)) {
                    state.func_177230_c().beginLeavesDecay(state_, world, pos_);
                }
            }
        }
    }
    
    public int func_149745_a(final Random random) {
        return 0;
    }
    
    public boolean canSustainLeaves(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return true;
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        for (int n = this.hasVariant() ? ThornVariant.values().length : 1, i = 0; i < n; ++i) {
            list.add((Object)new ItemStack((Block)this, 1, i));
        }
    }
    
    public BlockFaceShape func_193383_a(final IBlockAccess world, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        return (face.func_176740_k() != state.func_177229_b((IProperty)BlockTFThorns.field_176298_M)) ? BlockFaceShape.MIDDLE_POLE_THICK : BlockFaceShape.CENTER_BIG;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant((Block)this, BlockTFThorns.VARIANT);
    }
    
    @SideOnly(Side.CLIENT)
    @Deprecated
    public boolean func_176225_a(final IBlockState blockState, final IBlockAccess blockAccess, final BlockPos pos, final EnumFacing side) {
        return blockAccess.func_180495_p(pos.func_177972_a(side)).func_177230_c() instanceof BlockTFThorns || super.func_176225_a(blockState, blockAccess, pos, side);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)ThornVariant.class);
    }
}
