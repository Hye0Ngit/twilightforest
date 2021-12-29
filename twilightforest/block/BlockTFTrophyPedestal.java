// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyBool;
import com.google.common.base.Predicate;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import twilightforest.TwilightForestMod;
import java.util.Iterator;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.world.TFWorld;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import net.minecraftforge.fml.common.Optional;
import thaumcraft.api.crafting.IInfusionStabiliser;
import twilightforest.client.ModelRegisterCallbackCTM;
import net.minecraft.block.Block;

@Optional.Interface(modid = "thaumcraft", iface = "thaumcraft.api.crafting.IInfusionStabiliser")
public class BlockTFTrophyPedestal extends Block implements ModelRegisterCallbackCTM, IInfusionStabiliser
{
    public static final IProperty<EnumFacing> FACING;
    public static final IProperty<Boolean> LATENT;
    private static final AxisAlignedBB AABB;
    
    public BlockTFTrophyPedestal() {
        super(Material.field_151576_e);
        this.func_149711_c(2.0f);
        this.func_149752_b(2000.0f);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.func_176223_P().func_177226_a((IProperty)BlockTFTrophyPedestal.LATENT, (Comparable)true).func_177226_a((IProperty)BlockTFTrophyPedestal.FACING, (Comparable)EnumFacing.NORTH));
    }
    
    protected BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFTrophyPedestal.FACING, BlockTFTrophyPedestal.LATENT });
    }
    
    public int func_176201_c(final IBlockState state) {
        int meta = ((EnumFacing)state.func_177229_b((IProperty)BlockTFTrophyPedestal.FACING)).func_176736_b();
        if (state.func_177229_b((IProperty)BlockTFTrophyPedestal.LATENT)) {
            meta |= 0x4;
        }
        return meta;
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        IBlockState ret = this.func_176223_P();
        ret = ret.func_177226_a((IProperty)BlockTFTrophyPedestal.FACING, (Comparable)EnumFacing.func_176731_b(meta & 0x3));
        if ((meta & 0x4) > 0) {
            ret = ret.func_177226_a((IProperty)BlockTFTrophyPedestal.LATENT, (Comparable)true);
        }
        return ret;
    }
    
    @Deprecated
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return BlockTFTrophyPedestal.AABB;
    }
    
    @Deprecated
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public void func_189540_a(final IBlockState state, final World world, final BlockPos pos, final Block block, final BlockPos fromPos) {
        if (world.field_72995_K || !(boolean)state.func_177229_b((IProperty)BlockTFTrophyPedestal.LATENT) || !this.isTrophyOnTop(world, pos)) {
            return;
        }
        if (TFWorld.isProgressionEnforced(world)) {
            if (this.areNearbyPlayersEligible(world, pos)) {
                this.doPedestalEffect(world, pos, state);
            }
            this.warnIneligiblePlayers(world, pos);
        }
        else {
            this.doPedestalEffect(world, pos, state);
        }
        this.rewardNearbyPlayers(world, pos);
    }
    
    private boolean isTrophyOnTop(final World world, final BlockPos pos) {
        return world.func_180495_p(pos.func_177984_a()).func_177230_c() == TFBlocks.trophy;
    }
    
    private void warnIneligiblePlayers(final World world, final BlockPos pos) {
        for (final EntityPlayer player : world.func_72872_a((Class)EntityPlayer.class, new AxisAlignedBB(pos).func_186662_g(16.0))) {
            if (!this.isPlayerEligible(player)) {
                player.func_146105_b((ITextComponent)new TextComponentTranslation("twilightforest.trophy_pedestal.ineligible", new Object[0]), true);
            }
        }
    }
    
    private boolean areNearbyPlayersEligible(final World world, final BlockPos pos) {
        for (final EntityPlayer player : world.func_72872_a((Class)EntityPlayer.class, new AxisAlignedBB(pos).func_186662_g(16.0))) {
            if (this.isPlayerEligible(player)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isPlayerEligible(final EntityPlayer player) {
        return TwilightForestMod.proxy.doesPlayerHaveAdvancement(player, TwilightForestMod.prefix("progress_lich"));
    }
    
    private void doPedestalEffect(final World world, final BlockPos pos, final IBlockState state) {
        world.func_175656_a(pos, state.func_177226_a((IProperty)BlockTFTrophyPedestal.LATENT, (Comparable)false));
        this.removeNearbyShields(world, pos);
        world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187945_hs, SoundCategory.BLOCKS, 4.0f, 0.1f);
    }
    
    private void rewardNearbyPlayers(final World world, final BlockPos pos) {
        for (final EntityPlayerMP player : world.func_72872_a((Class)EntityPlayerMP.class, new AxisAlignedBB(pos).func_186662_g(16.0))) {
            TFAdvancements.PLACED_TROPHY_ON_PEDESTAL.trigger(player);
        }
    }
    
    private void removeNearbyShields(final World world, final BlockPos pos) {
        for (int sx = -5; sx <= 5; ++sx) {
            for (int sy = -5; sy <= 5; ++sy) {
                for (int sz = -5; sz <= 5; ++sz) {
                    if (world.func_180495_p(pos.func_177982_a(sx, sy, sz)).func_177230_c() == TFBlocks.stronghold_shield) {
                        world.func_175655_b(pos.func_177982_a(sx, sy, sz), false);
                    }
                }
            }
        }
    }
    
    @Deprecated
    public IBlockState func_180642_a(final World worldIn, final BlockPos pos, final EnumFacing facing, final float hitX, final float hitY, final float hitZ, final int meta, final EntityLivingBase placer) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFTrophyPedestal.FACING, (Comparable)placer.func_174811_aO().func_176734_d());
    }
    
    @Deprecated
    public float func_180647_a(final IBlockState state, final EntityPlayer player, final World world, final BlockPos pos) {
        return state.func_177229_b((IProperty)BlockTFTrophyPedestal.LATENT) ? -1.0f : super.func_180647_a(state, player, world, pos);
    }
    
    protected boolean func_149700_E() {
        return false;
    }
    
    public boolean canSilkHarvest(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player) {
        return false;
    }
    
    public int func_180651_a(final IBlockState state) {
        return 0;
    }
    
    public boolean canStabaliseInfusion(final World world, final BlockPos blockPos) {
        return true;
    }
    
    public void registerItemModel() {
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), 0, Loader.isModLoaded("ctm") ? new ModelResourceLocation(this.getRegistryName() + "_ctm", "latent=false") : new ModelResourceLocation(this.getRegistryName(), "latent=false"));
    }
    
    public IProperty<?>[] getIgnoredProperties() {
        return (IProperty<?>[])new IProperty[] { BlockTFTrophyPedestal.FACING };
    }
    
    static {
        FACING = (IProperty)PropertyDirection.func_177712_a("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
        LATENT = (IProperty)PropertyBool.func_177716_a("latent");
        AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 1.0, 0.9375);
    }
}
