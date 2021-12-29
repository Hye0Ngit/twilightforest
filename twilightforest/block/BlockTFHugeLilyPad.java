// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.BlockHorizontal;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.Vec3i;
import net.minecraft.entity.item.EntityBoat;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.EnumPushReaction;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.block.BlockLiquid;
import java.util.Iterator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.enums.HugeLilypadPiece;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockBush;

public class BlockTFHugeLilyPad extends BlockBush implements ModelRegisterCallback
{
    public static final IProperty<EnumFacing> FACING;
    public static final IProperty<HugeLilypadPiece> PIECE;
    private static final AxisAlignedBB AABB;
    private boolean isSelfDestructing;
    
    protected BlockTFHugeLilyPad() {
        super(Material.field_151585_k);
        this.isSelfDestructing = false;
        this.func_149672_a(SoundType.field_185850_c);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFHugeLilyPad.FACING, (Comparable)EnumFacing.NORTH).func_177226_a((IProperty)BlockTFHugeLilyPad.PIECE, (Comparable)HugeLilypadPiece.NW));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFHugeLilyPad.FACING, BlockTFHugeLilyPad.PIECE });
    }
    
    public int func_176201_c(final IBlockState state) {
        return (((EnumFacing)state.func_177229_b((IProperty)BlockTFHugeLilyPad.FACING)).func_176736_b() | ((HugeLilypadPiece)state.func_177229_b((IProperty)BlockTFHugeLilyPad.PIECE)).ordinal() << 2) & 0xF;
    }
    
    @Deprecated
    public IBlockState func_176203_a(int meta) {
        meta &= 0xF;
        return this.func_176223_P().func_177226_a((IProperty)BlockTFHugeLilyPad.FACING, (Comparable)EnumFacing.func_176731_b(meta & 0x3)).func_177226_a((IProperty)BlockTFHugeLilyPad.PIECE, (Comparable)HugeLilypadPiece.values()[(meta & 0xC) >> 2]);
    }
    
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess source, final BlockPos pos) {
        return BlockTFHugeLilyPad.AABB;
    }
    
    public boolean func_176196_c(final World world, final BlockPos pos) {
        return world.func_180495_p(pos.func_177977_b()).func_177230_c() == Blocks.field_150355_j;
    }
    
    public void func_180663_b(final World world, final BlockPos pos, final IBlockState state) {
        if (!this.isSelfDestructing) {
            this.setGiantBlockToAir(world, pos, state);
        }
    }
    
    private void setGiantBlockToAir(final World world, final BlockPos pos, final IBlockState state) {
        this.isSelfDestructing = true;
        for (final BlockPos check : this.getAllMyBlocks(pos, state)) {
            final IBlockState stateThere = world.func_180495_p(check);
            if (stateThere.func_177230_c() == this) {
                world.func_175655_b(check, false);
            }
        }
        this.isSelfDestructing = false;
    }
    
    public boolean func_180671_f(final World world, final BlockPos pos, final IBlockState state) {
        for (final BlockPos check : this.getAllMyBlocks(pos, state)) {
            final IBlockState dStateBelow = world.func_180495_p(check.func_177977_b());
            if ((dStateBelow.func_177230_c() != Blocks.field_150355_j && dStateBelow.func_177230_c() != Blocks.field_150358_i) || (int)dStateBelow.func_177229_b((IProperty)BlockLiquid.field_176367_b) != 0) {
                return false;
            }
            if (world.func_180495_p(check).func_177230_c() != this) {
                return false;
            }
        }
        return true;
    }
    
    public List<BlockPos> getAllMyBlocks(final BlockPos pos, final IBlockState state) {
        final List<BlockPos> pieces = Lists.newArrayListWithCapacity(4);
        if (state.func_177230_c() == this) {
            BlockPos nwPos = pos;
            switch ((HugeLilypadPiece)state.func_177229_b((IProperty)BlockTFHugeLilyPad.PIECE)) {
                case NE: {
                    nwPos = nwPos.func_177976_e();
                    break;
                }
                case SE: {
                    nwPos = nwPos.func_177978_c().func_177976_e();
                    break;
                }
                case SW: {
                    nwPos = nwPos.func_177978_c();
                    break;
                }
            }
            pieces.add(nwPos);
            pieces.add(nwPos.func_177968_d());
            pieces.add(nwPos.func_177974_f());
            pieces.add(nwPos.func_177968_d().func_177974_f());
        }
        return pieces;
    }
    
    protected void func_176475_e(final World worldIn, final BlockPos pos, final IBlockState state) {
        if (!this.func_180671_f(worldIn, pos, state)) {
            worldIn.func_180501_a(pos, Blocks.field_150350_a.func_176223_P(), 3);
        }
    }
    
    @Deprecated
    public EnumPushReaction func_149656_h(final IBlockState state) {
        return EnumPushReaction.BLOCK;
    }
    
    @Deprecated
    public void func_185477_a(final IBlockState state, final World worldIn, final BlockPos pos, final AxisAlignedBB entityBox, final List<AxisAlignedBB> collidingBoxes, @Nullable final Entity entityIn, final boolean p_185477_7_) {
        if (!(entityIn instanceof EntityBoat)) {
            func_185492_a(pos, entityBox, (List)collidingBoxes, BlockTFHugeLilyPad.AABB);
        }
    }
    
    public void func_180634_a(final World worldIn, final BlockPos pos, final IBlockState state, final Entity entityIn) {
        super.func_180634_a(worldIn, pos, state, entityIn);
        if (entityIn instanceof EntityBoat) {
            worldIn.func_175655_b(new BlockPos((Vec3i)pos), true);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
    
    static {
        FACING = (IProperty)BlockHorizontal.field_185512_D;
        PIECE = (IProperty)PropertyEnum.func_177709_a("piece", (Class)HugeLilypadPiece.class);
        AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.015625, 1.0);
    }
}
