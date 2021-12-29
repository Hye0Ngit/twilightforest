// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.properties.PropertyBool;
import twilightforest.client.ModelUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import twilightforest.network.TFPacketHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import twilightforest.network.PacketAnnihilateBlock;
import net.minecraft.item.Item;
import java.util.Random;
import twilightforest.world.ChunkGeneratorTFBase;
import twilightforest.world.TFWorld;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFCastleDoor extends Block implements ModelRegisterCallback
{
    public static final IProperty<Boolean> ACTIVE;
    public static final IProperty<Integer> LOCK_INDEX;
    private final boolean isVanished;
    private static final AxisAlignedBB REAPPEARING_BB;
    
    public BlockTFCastleDoor(final boolean isVanished) {
        super(isVanished ? Material.field_151592_s : Material.field_151576_e, isVanished ? MapColor.field_151660_b : MapColor.field_151679_y);
        this.func_149711_c(100.0f);
        this.func_149752_b(35.0f);
        this.isVanished = isVanished;
        this.field_149786_r = (isVanished ? 0 : 255);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFCastleDoor.ACTIVE, (Comparable)false));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFCastleDoor.ACTIVE, BlockTFCastleDoor.LOCK_INDEX });
    }
    
    public int func_176201_c(final IBlockState state) {
        int meta = (int)state.func_177229_b((IProperty)BlockTFCastleDoor.LOCK_INDEX);
        meta |= (state.func_177229_b((IProperty)BlockTFCastleDoor.ACTIVE) ? 8 : 0);
        return meta;
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFCastleDoor.ACTIVE, (Comparable)((meta & 0x8) != 0x0)).func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, (Comparable)(meta & 0x3));
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return !this.isVanished;
    }
    
    @Deprecated
    public boolean func_149686_d(final IBlockState state) {
        return !this.isVanished;
    }
    
    @Deprecated
    public BlockFaceShape func_193383_a(final IBlockAccess worldIn, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        return this.isVanished ? BlockFaceShape.UNDEFINED : super.func_193383_a(worldIn, state, pos, face);
    }
    
    @Deprecated
    public AxisAlignedBB func_180646_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return this.isVanished ? BlockTFCastleDoor.field_185506_k : super.func_180646_a(state, world, pos);
    }
    
    @Deprecated
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return this.isVanished ? BlockTFCastleDoor.REAPPEARING_BB : super.func_185496_a(state, world, pos);
    }
    
    public boolean func_176205_b(final IBlockAccess blockAccess, final BlockPos pos) {
        return this.isVanished;
    }
    
    public boolean func_180639_a(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer playerIn, final EnumHand hand, final EnumFacing side, final float hitX, final float hitY, final float hitZ) {
        return this.onActivation(world, pos, state);
    }
    
    @Deprecated
    public void func_189540_a(final IBlockState state, final World world, final BlockPos pos, final Block block, final BlockPos fromPos) {
        if (!(block instanceof BlockTFCastleDoor) && world.func_175640_z(pos)) {
            this.onActivation(world, pos, state);
        }
    }
    
    private boolean onActivation(final World world, final BlockPos pos, final IBlockState state) {
        if (this.isVanished || (boolean)state.func_177229_b((IProperty)BlockTFCastleDoor.ACTIVE)) {
            return false;
        }
        if (isBlockLocked(world, pos)) {
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187750_dc, SoundCategory.BLOCKS, 1.0f, 0.3f);
        }
        else {
            changeToActiveBlock(world, pos, state);
        }
        return true;
    }
    
    private static void changeToActiveBlock(final World world, final BlockPos pos, final IBlockState originState) {
        changeActiveState(world, pos, true, originState);
        playVanishSound(world, pos);
        world.func_175684_a(pos, originState.func_177230_c(), 2 + world.field_73012_v.nextInt(5));
    }
    
    private static void changeActiveState(final World world, final BlockPos pos, final boolean active, final IBlockState originState) {
        if (originState.func_177230_c() instanceof BlockTFCastleDoor) {
            world.func_180501_a(pos, originState.func_177226_a((IProperty)BlockTFCastleDoor.ACTIVE, (Comparable)active), 3);
            world.func_175704_b(pos, pos);
            world.func_175722_b(pos, originState.func_177230_c(), false);
        }
    }
    
    private static boolean isBlockLocked(final World world, final BlockPos pos) {
        if (!world.field_72995_K) {
            final ChunkGeneratorTFBase generator = TFWorld.getChunkGenerator(world);
            return generator != null && generator.isStructureLocked(pos, (int)world.func_180495_p(pos).func_177229_b((IProperty)BlockTFCastleDoor.LOCK_INDEX));
        }
        return false;
    }
    
    public int func_149738_a(final World world) {
        return 5;
    }
    
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState state, final Random rand) {
        if (world.field_72995_K) {
            return;
        }
        if (this.isVanished) {
            if (state.func_177229_b((IProperty)BlockTFCastleDoor.ACTIVE)) {
                world.func_175656_a(pos, TFBlocks.castle_door.func_176223_P().func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, state.func_177229_b((IProperty)BlockTFCastleDoor.LOCK_INDEX)));
                playVanishSound(world, pos);
            }
            else {
                changeToActiveBlock(world, pos, state);
            }
        }
        else if (state.func_177229_b((IProperty)BlockTFCastleDoor.ACTIVE)) {
            world.func_175656_a(pos, getOtherBlock(this).func_176223_P().func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, state.func_177229_b((IProperty)BlockTFCastleDoor.LOCK_INDEX)));
            world.func_175684_a(pos, getOtherBlock(this), 80);
            playReappearSound(world, pos);
            this.sendAnnihilateBlockPacket(world, pos);
            for (final EnumFacing e : EnumFacing.field_82609_l) {
                checkAndActivateCastleDoor(world, pos.func_177972_a(e));
            }
        }
    }
    
    public Item func_180660_a(final IBlockState state, final Random rand, final int fortune) {
        return TFItems.castle_door;
    }
    
    public int func_180651_a(final IBlockState state) {
        return (int)state.func_177229_b((IProperty)BlockTFCastleDoor.LOCK_INDEX);
    }
    
    private void sendAnnihilateBlockPacket(final World world, final BlockPos pos) {
        final IMessage message = (IMessage)new PacketAnnihilateBlock(pos);
        final NetworkRegistry.TargetPoint targetPoint = new NetworkRegistry.TargetPoint(world.field_73011_w.getDimension(), (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), 64.0);
        TFPacketHandler.CHANNEL.sendToAllAround(message, targetPoint);
    }
    
    private static void playVanishSound(final World world, final BlockPos pos) {
        world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187646_bt, SoundCategory.BLOCKS, 0.125f, world.field_73012_v.nextFloat() * 0.25f + 1.75f);
    }
    
    private static void playReappearSound(final World world, final BlockPos pos) {
        world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187646_bt, SoundCategory.BLOCKS, 0.125f, world.field_73012_v.nextFloat() * 0.25f + 1.25f);
    }
    
    private static Block getOtherBlock(final Block block) {
        return (block == TFBlocks.castle_door) ? TFBlocks.castle_door_vanished : TFBlocks.castle_door;
    }
    
    public static void checkAndActivateCastleDoor(final World world, final BlockPos pos) {
        final IBlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() == TFBlocks.castle_door && !(boolean)state.func_177229_b((IProperty)BlockTFCastleDoor.ACTIVE) && !isBlockLocked(world, pos)) {
            changeToActiveBlock(world, pos, state);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_180655_c(final IBlockState state, final World world, final BlockPos pos, final Random random) {
        if (state.func_177229_b((IProperty)BlockTFCastleDoor.ACTIVE)) {}
        for (int i = 0; i < 1; ++i) {}
    }
    
    private void sparkle(final World worldIn, final BlockPos pos, final Random rand) {
        final Random random = rand;
        final double d0 = 0.0625;
        for (int i = 0; i < 6; ++i) {
            double d2 = pos.func_177958_n() + random.nextFloat();
            double d3 = pos.func_177956_o() + random.nextFloat();
            double d4 = pos.func_177952_p() + random.nextFloat();
            if (i == 0 && !worldIn.func_180495_p(pos.func_177984_a()).func_185914_p()) {
                d3 = pos.func_177956_o() + 0.0625 + 1.0;
            }
            if (i == 1 && !worldIn.func_180495_p(pos.func_177977_b()).func_185914_p()) {
                d3 = pos.func_177956_o() - 0.0625;
            }
            if (i == 2 && !worldIn.func_180495_p(pos.func_177968_d()).func_185914_p()) {
                d4 = pos.func_177952_p() + 0.0625 + 1.0;
            }
            if (i == 3 && !worldIn.func_180495_p(pos.func_177978_c()).func_185914_p()) {
                d4 = pos.func_177952_p() - 0.0625;
            }
            if (i == 4 && !worldIn.func_180495_p(pos.func_177974_f()).func_185914_p()) {
                d2 = pos.func_177958_n() + 0.0625 + 1.0;
            }
            if (i == 5 && !worldIn.func_180495_p(pos.func_177976_e()).func_185914_p()) {
                d2 = pos.func_177958_n() - 0.0625;
            }
            if (d2 < pos.func_177958_n() || d2 > pos.func_177958_n() + 1 || d3 < 0.0 || d3 > pos.func_177956_o() + 1 || d4 < pos.func_177952_p() || d4 > pos.func_177952_p() + 1) {
                worldIn.func_175688_a(EnumParticleTypes.REDSTONE, d2, d3, d4, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return this.isVanished ? BlockRenderLayer.TRANSLUCENT : BlockRenderLayer.CUTOUT;
    }
    
    @SideOnly(Side.CLIENT)
    @Deprecated
    public boolean func_176225_a(final IBlockState blockState, final IBlockAccess blockAccess, final BlockPos pos, final EnumFacing side) {
        return !(blockAccess.func_180495_p(pos.func_177972_a(side)).func_177230_c() instanceof BlockTFCastleDoor) && super.func_176225_a(blockState, blockAccess, pos, side);
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        if (this == TFBlocks.castle_door) {
            for (int i = 0; i < BlockTFCastleDoor.LOCK_INDEX.func_177700_c().size(); ++i) {
                list.add((Object)new ItemStack((Block)this, 1, i));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        if (!this.isVanished) {
            ModelUtils.registerToStateSingleVariant(this, BlockTFCastleDoor.LOCK_INDEX);
        }
    }
    
    public ItemStack func_185473_a(final World world, final BlockPos pos, final IBlockState state) {
        return new ItemStack(TFItems.castle_door, 1, this.func_180651_a(state));
    }
    
    protected ItemStack func_180643_i(final IBlockState state) {
        return new ItemStack(TFItems.castle_door, 1, this.func_180651_a(state));
    }
    
    static {
        ACTIVE = (IProperty)PropertyBool.func_177716_a("active");
        LOCK_INDEX = (IProperty)PropertyInteger.func_177719_a("lock_index", 0, 3);
        REAPPEARING_BB = new AxisAlignedBB(0.375, 0.375, 0.375, 0.625, 0.625, 0.625);
    }
}
