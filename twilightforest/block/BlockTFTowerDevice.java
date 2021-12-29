// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.BlockRenderLayer;
import twilightforest.client.ModelUtils;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import twilightforest.tileentity.TileEntityTFCReactorActive;
import twilightforest.tileentity.TileEntityTFGhastTrapActive;
import twilightforest.tileentity.TileEntityTFAntibuilder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import java.util.Arrays;
import twilightforest.tileentity.TileEntityTFGhastTrapInactive;
import twilightforest.tileentity.TileEntityTFTowerBuilder;
import twilightforest.enums.TowerTranslucentVariant;
import java.util.Random;
import java.util.Iterator;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.Set;
import java.util.HashSet;
import net.minecraft.world.Explosion;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.enums.TowerDeviceVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFTowerDevice extends Block implements ModelRegisterCallback
{
    public static final IProperty<TowerDeviceVariant> VARIANT;
    
    public BlockTFTowerDevice() {
        super(Material.field_151575_d, MapColor.field_151658_d);
        this.func_149711_c(10.0f);
        this.func_149752_b(35.0f);
        this.func_149672_a(SoundType.field_185848_a);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.REAPPEARING_INACTIVE));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFTowerDevice.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.values()[meta]);
    }
    
    public int func_149738_a(final World world) {
        return 15;
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        list.add((Object)new ItemStack((Block)this, 1, TowerDeviceVariant.REAPPEARING_INACTIVE.ordinal()));
        list.add((Object)new ItemStack((Block)this, 1, TowerDeviceVariant.VANISH_INACTIVE.ordinal()));
        list.add((Object)new ItemStack((Block)this, 1, TowerDeviceVariant.VANISH_LOCKED.ordinal()));
        list.add((Object)new ItemStack((Block)this, 1, TowerDeviceVariant.VANISH_UNLOCKED.ordinal()));
        list.add((Object)new ItemStack((Block)this, 1, TowerDeviceVariant.BUILDER_INACTIVE.ordinal()));
        list.add((Object)new ItemStack((Block)this, 1, TowerDeviceVariant.ANTIBUILDER.ordinal()));
        list.add((Object)new ItemStack((Block)this, 1, TowerDeviceVariant.GHASTTRAP_INACTIVE.ordinal()));
        list.add((Object)new ItemStack((Block)this, 1, TowerDeviceVariant.REACTOR_INACTIVE.ordinal()));
    }
    
    public boolean func_180639_a(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player, final EnumHand hand, final EnumFacing side, final float hitX, final float hitY, final float hitZ) {
        final TowerDeviceVariant variant = (TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT);
        if (variant == TowerDeviceVariant.VANISH_INACTIVE) {
            if (areBlocksLocked((IBlockAccess)world, pos)) {
                world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187883_gR, SoundCategory.BLOCKS, 1.0f, 0.3f);
            }
            else {
                changeToActiveVanishBlock(world, pos, TowerDeviceVariant.VANISH_ACTIVE);
            }
            return true;
        }
        if (variant == TowerDeviceVariant.REAPPEARING_INACTIVE) {
            if (areBlocksLocked((IBlockAccess)world, pos)) {
                world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187883_gR, SoundCategory.BLOCKS, 1.0f, 0.3f);
            }
            else {
                changeToActiveVanishBlock(world, pos, TowerDeviceVariant.REAPPEARING_ACTIVE);
            }
            return true;
        }
        return false;
    }
    
    public float getExplosionResistance(final World world, final BlockPos pos, @Nullable final Entity exploder, final Explosion explosion) {
        switch ((TowerDeviceVariant)world.func_180495_p(pos).func_177229_b((IProperty)BlockTFTowerDevice.VARIANT)) {
            case VANISH_INACTIVE: {
                return 6000.0f;
            }
            case VANISH_LOCKED: {
                return 6000000.0f;
            }
            default: {
                return super.getExplosionResistance(world, pos, exploder, explosion);
            }
        }
    }
    
    @Deprecated
    public float func_176195_g(final IBlockState state, final World world, final BlockPos pos) {
        switch ((TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT)) {
            case VANISH_INACTIVE:
            case VANISH_LOCKED:
            case REAPPEARING_ACTIVE:
            case VANISH_ACTIVE:
            case VANISH_UNLOCKED: {
                return -1.0f;
            }
            default: {
                return super.func_176195_g(state, world, pos);
            }
        }
    }
    
    public boolean canEntityDestroy(final IBlockState state, final IBlockAccess world, final BlockPos pos, final Entity entity) {
        switch ((TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT)) {
            case VANISH_INACTIVE: {
                return !areBlocksLocked(world, pos);
            }
            case VANISH_LOCKED: {
                return false;
            }
            default: {
                return super.canEntityDestroy(state, world, pos, entity);
            }
        }
    }
    
    private static boolean areBlocksLocked(final IBlockAccess world, final BlockPos pos) {
        final Set<BlockPos> checked = new HashSet<BlockPos>();
        checked.add(pos);
        return areBlocksLocked(world, pos, checked);
    }
    
    private static boolean areBlocksLocked(final IBlockAccess world, final BlockPos pos, final Set<BlockPos> checked) {
        for (final EnumFacing facing : EnumFacing.values()) {
            final BlockPos offset = pos.func_177972_a(facing);
            if (checked.add(offset)) {
                final IBlockState state = world.func_180495_p(offset);
                if (state.func_177230_c() == TFBlocks.tower_device) {
                    if (state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT) == TowerDeviceVariant.VANISH_LOCKED) {
                        return true;
                    }
                    if (areBlocksLocked(world, offset, checked)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static void unlockBlock(final World world, final BlockPos pos) {
        final IBlockState thereState = world.func_180495_p(pos);
        if (thereState.func_177230_c() == TFBlocks.tower_device || thereState.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT) == TowerDeviceVariant.VANISH_LOCKED) {
            changeToBlockState(world, pos, thereState.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.VANISH_UNLOCKED));
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187885_gS, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
    }
    
    private static void changeToBlockState(final World world, final BlockPos pos, final IBlockState state) {
        final Block thereBlock = world.func_180495_p(pos).func_177230_c();
        if (thereBlock == TFBlocks.tower_device || thereBlock == TFBlocks.tower_translucent) {
            world.func_180501_a(pos, state, 3);
            world.func_175704_b(pos, pos);
            world.func_175722_b(pos, thereBlock, false);
        }
    }
    
    public void func_176213_c(final World world, final BlockPos pos, final IBlockState state) {
        if (world.field_72995_K) {
            return;
        }
        if (state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT) == TowerDeviceVariant.BUILDER_INACTIVE && world.func_175640_z(pos)) {
            changeToBlockState(world, pos, state.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.BUILDER_ACTIVE));
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187885_gS, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
    }
    
    @Deprecated
    public void func_189540_a(final IBlockState state, final World world, final BlockPos pos, final Block block, final BlockPos fromPos) {
        if (world.field_72995_K) {
            return;
        }
        final TowerDeviceVariant variant = (TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT);
        if (variant == TowerDeviceVariant.VANISH_INACTIVE && world.func_175640_z(pos) && !areBlocksLocked((IBlockAccess)world, pos)) {
            changeToActiveVanishBlock(world, pos, TowerDeviceVariant.VANISH_ACTIVE);
        }
        if (variant == TowerDeviceVariant.REAPPEARING_INACTIVE && world.func_175640_z(pos) && !areBlocksLocked((IBlockAccess)world, pos)) {
            changeToActiveVanishBlock(world, pos, TowerDeviceVariant.REAPPEARING_ACTIVE);
        }
        if (variant == TowerDeviceVariant.BUILDER_INACTIVE && world.func_175640_z(pos)) {
            changeToBlockState(world, pos, state.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.BUILDER_ACTIVE));
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187885_gS, SoundCategory.BLOCKS, 0.3f, 0.6f);
            world.func_175684_a(pos, (Block)this, 4);
        }
        if (variant == TowerDeviceVariant.BUILDER_ACTIVE && !world.func_175640_z(pos)) {
            changeToBlockState(world, pos, state.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE));
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187883_gR, SoundCategory.BLOCKS, 0.3f, 0.6f);
            world.func_175684_a(pos, (Block)this, 4);
        }
        if (variant == TowerDeviceVariant.BUILDER_TIMEOUT && !world.func_175640_z(pos)) {
            changeToBlockState(world, pos, state.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE));
        }
        if (variant == TowerDeviceVariant.GHASTTRAP_INACTIVE && this.isInactiveTrapCharged(world, pos) && world.func_175640_z(pos)) {
            for (final EntityPlayerMP player : world.func_72872_a((Class)EntityPlayerMP.class, new AxisAlignedBB(pos).func_186662_g(6.0))) {
                TFAdvancements.ACTIVATED_GHAST_TRAP.trigger(player);
            }
            changeToBlockState(world, pos, state.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.GHASTTRAP_ACTIVE));
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187885_gS, SoundCategory.BLOCKS, 0.3f, 0.6f);
            world.func_175684_a(pos, (Block)this, 4);
        }
        if (variant == TowerDeviceVariant.REACTOR_INACTIVE && this.isReactorReady(world, pos)) {
            changeToBlockState(world, pos, state.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.REACTOR_ACTIVE));
        }
    }
    
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState state, final Random random) {
        if (world.field_72995_K) {
            return;
        }
        final TowerDeviceVariant variant = (TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT);
        if (variant == TowerDeviceVariant.VANISH_ACTIVE || variant == TowerDeviceVariant.REAPPEARING_ACTIVE) {
            if (variant == TowerDeviceVariant.VANISH_ACTIVE) {
                world.func_175698_g(pos);
            }
            else {
                world.func_175656_a(pos, TFBlocks.tower_translucent.func_176223_P().func_177226_a((IProperty)BlockTFTowerTranslucent.VARIANT, (Comparable)TowerTranslucentVariant.REAPPEARING_INACTIVE));
                world.func_175684_a(pos, TFBlocks.tower_translucent, 80);
            }
            world.func_175722_b(pos, (Block)this, false);
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187638_cR, SoundCategory.BLOCKS, 0.3f, 0.5f);
            for (final EnumFacing e : EnumFacing.field_82609_l) {
                checkAndActivateVanishBlock(world, pos.func_177972_a(e));
            }
        }
        if (variant == TowerDeviceVariant.BUILDER_ACTIVE && world.func_175640_z(pos)) {
            this.letsBuild(world, pos);
        }
        if (variant == TowerDeviceVariant.BUILDER_INACTIVE || variant == TowerDeviceVariant.BUILDER_TIMEOUT) {
            for (final EnumFacing e : EnumFacing.field_82609_l) {
                checkAndActivateVanishBlock(world, pos.func_177972_a(e));
            }
        }
    }
    
    private void letsBuild(final World world, final BlockPos pos) {
        final TileEntityTFTowerBuilder tileEntity = (TileEntityTFTowerBuilder)world.func_175625_s(pos);
        if (tileEntity != null && !tileEntity.makingBlocks) {
            tileEntity.startBuilding();
        }
    }
    
    private boolean isInactiveTrapCharged(final World world, final BlockPos pos) {
        final TileEntityTFGhastTrapInactive tileEntity = (TileEntityTFGhastTrapInactive)world.func_175625_s(pos);
        return tileEntity != null && tileEntity.isCharged();
    }
    
    private boolean isReactorReady(final World world, final BlockPos pos) {
        return Arrays.stream(EnumFacing.field_82609_l).allMatch(e -> world.func_180495_p(pos.func_177972_a(e)).func_177230_c() == Blocks.field_150451_bX);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_180655_c(final IBlockState state, final World world, final BlockPos pos, final Random random) {
        final TowerDeviceVariant variant = (TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT);
        if (variant == TowerDeviceVariant.VANISH_ACTIVE || variant == TowerDeviceVariant.REAPPEARING_ACTIVE || variant == TowerDeviceVariant.BUILDER_ACTIVE) {
            this.sparkle(world, pos);
        }
    }
    
    public void sparkle(final World worldIn, final BlockPos pos) {
        final Random random = worldIn.field_73012_v;
        final double d0 = 0.0625;
        for (int i = 0; i < 6; ++i) {
            double d2 = pos.func_177958_n() + random.nextFloat();
            double d3 = pos.func_177956_o() + random.nextFloat();
            double d4 = pos.func_177952_p() + random.nextFloat();
            if (i == 0 && !worldIn.func_180495_p(pos.func_177984_a()).func_185914_p()) {
                d3 = pos.func_177956_o() + d0 + 1.0;
            }
            if (i == 1 && !worldIn.func_180495_p(pos.func_177977_b()).func_185914_p()) {
                d3 = pos.func_177956_o() - d0;
            }
            if (i == 2 && !worldIn.func_180495_p(pos.func_177968_d()).func_185914_p()) {
                d4 = pos.func_177952_p() + d0 + 1.0;
            }
            if (i == 3 && !worldIn.func_180495_p(pos.func_177978_c()).func_185914_p()) {
                d4 = pos.func_177952_p() - d0;
            }
            if (i == 4 && !worldIn.func_180495_p(pos.func_177974_f()).func_185914_p()) {
                d2 = pos.func_177958_n() + d0 + 1.0;
            }
            if (i == 5 && !worldIn.func_180495_p(pos.func_177976_e()).func_185914_p()) {
                d2 = pos.func_177958_n() - d0;
            }
            if (d2 < pos.func_177958_n() || d2 > pos.func_177958_n() + 1 || d3 < 0.0 || d3 > pos.func_177956_o() + 1 || d4 < pos.func_177952_p() || d4 > pos.func_177952_p() + 1) {
                worldIn.func_175688_a(EnumParticleTypes.REDSTONE, d2, d3, d4, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    public static void checkAndActivateVanishBlock(final World world, final BlockPos pos) {
        final IBlockState state = world.func_180495_p(pos);
        final Block block = state.func_177230_c();
        if (block == TFBlocks.tower_device && (state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT) == TowerDeviceVariant.VANISH_INACTIVE || state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT) == TowerDeviceVariant.VANISH_UNLOCKED) && !areBlocksLocked((IBlockAccess)world, pos)) {
            changeToActiveVanishBlock(world, pos, TowerDeviceVariant.VANISH_ACTIVE);
        }
        else if (block == TFBlocks.tower_device && state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT) == TowerDeviceVariant.REAPPEARING_INACTIVE && !areBlocksLocked((IBlockAccess)world, pos)) {
            changeToActiveVanishBlock(world, pos, TowerDeviceVariant.REAPPEARING_ACTIVE);
        }
        else if (block == TFBlocks.tower_translucent && state.func_177229_b((IProperty)BlockTFTowerTranslucent.VARIANT) == TowerTranslucentVariant.BUILT_INACTIVE) {
            changeToActiveVanishBlock(world, pos, TowerTranslucentVariant.BUILT_ACTIVE);
        }
    }
    
    public static void changeToActiveVanishBlock(final World world, final BlockPos pos, final TowerDeviceVariant variant) {
        changeToActiveVanishBlock(world, pos, TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)variant));
    }
    
    public static void changeToActiveVanishBlock(final World world, final BlockPos pos, final TowerTranslucentVariant variant) {
        changeToActiveVanishBlock(world, pos, TFBlocks.tower_translucent.func_176223_P().func_177226_a((IProperty)BlockTFTowerTranslucent.VARIANT, (Comparable)variant));
    }
    
    private static void changeToActiveVanishBlock(final World world, final BlockPos pos, final IBlockState state) {
        changeToBlockState(world, pos, state);
        world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187638_cR, SoundCategory.BLOCKS, 0.3f, 0.6f);
        world.func_175684_a(pos, state.func_177230_c(), getTickRateFor(state, world.field_73012_v));
    }
    
    private static int getTickRateFor(final IBlockState state, final Random rand) {
        if (state.func_177230_c() == TFBlocks.tower_device && (state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT) == TowerDeviceVariant.VANISH_ACTIVE || state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT) == TowerDeviceVariant.REAPPEARING_ACTIVE)) {
            return 2 + rand.nextInt(5);
        }
        if (state.func_177230_c() == TFBlocks.tower_translucent && state.func_177229_b((IProperty)BlockTFTowerTranslucent.VARIANT) == TowerTranslucentVariant.BUILT_ACTIVE) {
            return 10;
        }
        return 15;
    }
    
    public int func_149750_m(final IBlockState state) {
        switch ((TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT)) {
            case REAPPEARING_ACTIVE:
            case VANISH_ACTIVE:
            case BUILDER_ACTIVE: {
                return 4;
            }
            case ANTIBUILDER: {
                return 10;
            }
            case GHASTTRAP_ACTIVE:
            case REACTOR_ACTIVE: {
                return 15;
            }
            default: {
                return 0;
            }
        }
    }
    
    public boolean hasTileEntity(final IBlockState state) {
        switch ((TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT)) {
            case BUILDER_ACTIVE:
            case ANTIBUILDER:
            case GHASTTRAP_ACTIVE:
            case REACTOR_ACTIVE:
            case GHASTTRAP_INACTIVE: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public TileEntity createTileEntity(final World world, final IBlockState state) {
        switch ((TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT)) {
            case BUILDER_ACTIVE: {
                return new TileEntityTFTowerBuilder();
            }
            case ANTIBUILDER: {
                return new TileEntityTFAntibuilder();
            }
            case GHASTTRAP_INACTIVE: {
                return new TileEntityTFGhastTrapInactive();
            }
            case GHASTTRAP_ACTIVE: {
                return new TileEntityTFGhastTrapActive();
            }
            case REACTOR_ACTIVE: {
                return new TileEntityTFCReactorActive();
            }
            default: {
                return null;
            }
        }
    }
    
    public Item func_180660_a(final IBlockState state, final Random random, final int fortune) {
        switch ((TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT)) {
            case ANTIBUILDER: {
                return Items.field_190931_a;
            }
            default: {
                return Item.func_150898_a((Block)this);
            }
        }
    }
    
    @Deprecated
    protected boolean func_149700_E() {
        return false;
    }
    
    public boolean canSilkHarvest(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player) {
        return false;
    }
    
    public int func_180651_a(IBlockState state) {
        switch ((TowerDeviceVariant)state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT)) {
            case REAPPEARING_ACTIVE: {
                state = state.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.REAPPEARING_INACTIVE);
                break;
            }
            case BUILDER_ACTIVE:
            case BUILDER_TIMEOUT: {
                state = state.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE);
                break;
            }
            case VANISH_ACTIVE: {
                state = state.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.VANISH_INACTIVE);
                break;
            }
            case GHASTTRAP_ACTIVE: {
                state = state.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.GHASTTRAP_INACTIVE);
                break;
            }
            case REACTOR_ACTIVE: {
                state = state.func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.REACTOR_INACTIVE);
                break;
            }
        }
        return this.func_176201_c(state);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant(this, BlockTFTowerDevice.VARIANT);
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)TowerDeviceVariant.class);
    }
}
