// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import java.util.Random;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Blocks;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import twilightforest.world.TFWorld;
import twilightforest.TFTeleporter;
import twilightforest.TFConfig;
import org.apache.commons.lang3.mutable.MutableInt;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.item.EntityItem;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockBreakable;

public class BlockTFPortal extends BlockBreakable
{
    public static final IProperty<Boolean> DISALLOW_RETURN;
    private static final AxisAlignedBB AABB;
    private static final AxisAlignedBB AABB_ITEM;
    private static final int MIN_PORTAL_SIZE = 4;
    private static final int MAX_PORTAL_SIZE = 64;
    
    public BlockTFPortal() {
        super(Material.field_151567_E, false);
        this.func_149711_c(-1.0f);
        this.func_149672_a(SoundType.field_185853_f);
        this.func_149715_a(0.75f);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFPortal.DISALLOW_RETURN, (Comparable)false));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFPortal.DISALLOW_RETURN });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((boolean)state.func_177229_b((IProperty)BlockTFPortal.DISALLOW_RETURN)) ? 1 : 0;
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFPortal.DISALLOW_RETURN, (Comparable)(meta == 1));
    }
    
    @Deprecated
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return BlockTFPortal.AABB;
    }
    
    @Deprecated
    public AxisAlignedBB func_180646_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return state.func_177229_b((IProperty)BlockTFPortal.DISALLOW_RETURN) ? BlockTFPortal.AABB : BlockTFPortal.field_185506_k;
    }
    
    @Deprecated
    public void func_185477_a(final IBlockState state, final World world, final BlockPos pos, final AxisAlignedBB entityBB, final List<AxisAlignedBB> blockBBs, @Nullable final Entity entity, final boolean isActualState) {
        func_185492_a(pos, entityBB, (List)blockBBs, (entity instanceof EntityItem) ? BlockTFPortal.AABB_ITEM : state.func_185890_d((IBlockAccess)world, pos));
    }
    
    @Deprecated
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public BlockFaceShape func_193383_a(final IBlockAccess worldIn, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }
    
    public boolean tryToCreatePortal(final World world, final BlockPos pos, final EntityItem catalyst, @Nullable final EntityPlayer player) {
        final IBlockState state = world.func_180495_p(pos);
        if (this.canFormPortal(state) && world.func_180495_p(pos.func_177977_b()).func_185917_h()) {
            final Map<BlockPos, Boolean> blocksChecked = new HashMap<BlockPos, Boolean>();
            blocksChecked.put(pos, true);
            final MutableInt size = new MutableInt(0);
            if (recursivelyValidatePortal(world, pos, blocksChecked, size, state) && size.intValue() >= 4) {
                if (TFConfig.checkPortalDestination) {
                    final TFTeleporter teleporter = TFTeleporter.getTeleporterForDim(catalyst.func_184102_h(), getDestination((Entity)catalyst));
                    final boolean checkProgression = TFWorld.isProgressionEnforced(catalyst.field_70170_p);
                    if (!teleporter.isSafeAround(pos, (Entity)catalyst, checkProgression)) {
                        if (player != null) {
                            player.func_146105_b((ITextComponent)new TextComponentTranslation("twilightforest.twilight_portal.unsafe", new Object[0]), true);
                        }
                        return false;
                    }
                }
                catalyst.func_92059_d().func_190918_g(1);
                causeLightning(world, pos, TFConfig.portalLightning);
                for (final Map.Entry<BlockPos, Boolean> checkedPos : blocksChecked.entrySet()) {
                    if (checkedPos.getValue()) {
                        world.func_180501_a((BlockPos)checkedPos.getKey(), TFBlocks.twilight_portal.func_176223_P(), 2);
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public boolean canFormPortal(final IBlockState state) {
        return state == Blocks.field_150355_j.func_176223_P() || (state.func_177230_c() == this && (boolean)state.func_177229_b((IProperty)BlockTFPortal.DISALLOW_RETURN));
    }
    
    private static void causeLightning(final World world, final BlockPos pos, final boolean fake) {
        final EntityLightningBolt bolt = new EntityLightningBolt(world, pos.func_177958_n() + 0.5, (double)pos.func_177956_o(), pos.func_177952_p() + 0.5, fake);
        world.func_72942_c((Entity)bolt);
        if (fake) {
            final double range = 3.0;
            final List<Entity> list = world.func_72872_a((Class)Entity.class, new AxisAlignedBB(pos).func_186662_g(range));
            for (final Entity victim : list) {
                if (!ForgeEventFactory.onEntityStruckByLightning(victim, bolt)) {
                    victim.func_70077_a(bolt);
                }
            }
        }
    }
    
    private static boolean recursivelyValidatePortal(final World world, final BlockPos pos, final Map<BlockPos, Boolean> blocksChecked, final MutableInt portalSize, final IBlockState requiredState) {
        if (portalSize.incrementAndGet() > 64) {
            return false;
        }
        boolean isPoolProbablyEnclosed = true;
        for (int i = 0; i < EnumFacing.field_176754_o.length && portalSize.intValue() <= 64; ++i) {
            final BlockPos positionCheck = pos.func_177972_a(EnumFacing.field_176754_o[i]);
            if (!blocksChecked.containsKey(positionCheck)) {
                final IBlockState state = world.func_180495_p(positionCheck);
                if (state == requiredState && world.func_180495_p(positionCheck.func_177977_b()).func_185917_h()) {
                    blocksChecked.put(positionCheck, true);
                    if (isPoolProbablyEnclosed) {
                        isPoolProbablyEnclosed = recursivelyValidatePortal(world, positionCheck, blocksChecked, portalSize, requiredState);
                    }
                }
                else {
                    if ((!isGrassOrDirt(state) || !isNatureBlock(world.func_180495_p(positionCheck.func_177984_a()))) && state.func_177230_c() != TFBlocks.uberous_soil) {
                        return false;
                    }
                    blocksChecked.put(positionCheck, false);
                }
            }
        }
        return isPoolProbablyEnclosed;
    }
    
    private static boolean isNatureBlock(final IBlockState state) {
        final Material mat = state.func_185904_a();
        return mat == Material.field_151585_k || mat == Material.field_151582_l || mat == Material.field_151584_j;
    }
    
    private static boolean isGrassOrDirt(final IBlockState state) {
        final Material mat = state.func_185904_a();
        return state.func_185917_h() && (mat == Material.field_151577_b || mat == Material.field_151578_c);
    }
    
    @Deprecated
    public void func_189540_a(final IBlockState state, final World world, final BlockPos pos, final Block notUsed, final BlockPos fromPos) {
        boolean good = world.func_180495_p(pos.func_177977_b()).func_185917_h();
        for (final EnumFacing facing : EnumFacing.field_176754_o) {
            if (!good) {
                break;
            }
            final IBlockState neighboringState = world.func_180495_p(pos.func_177972_a(facing));
            good = (isGrassOrDirt(neighboringState) || neighboringState == state);
        }
        if (!good) {
            world.func_175718_b(2001, pos, Block.func_176210_f(state));
            world.func_180501_a(pos, Blocks.field_150355_j.func_176223_P(), 3);
        }
    }
    
    public int func_149745_a(final Random random) {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    public void func_180634_a(final World world, final BlockPos pos, final IBlockState state, final Entity entity) {
        if (state == this.func_176223_P()) {
            attemptSendPlayer(entity, false);
        }
    }
    
    private static int getDestination(final Entity entity) {
        return (entity.field_71093_bK != TFConfig.dimension.dimensionID) ? TFConfig.dimension.dimensionID : TFConfig.originDimension;
    }
    
    public static void attemptSendPlayer(final Entity entity, final boolean forcedEntry) {
        if (entity.field_70128_L || entity.field_70170_p.field_72995_K) {
            return;
        }
        if (entity.func_184218_aH() || entity.func_184207_aI() || !entity.func_184222_aU()) {
            return;
        }
        if (!forcedEntry && entity.field_71088_bW > 0) {
            return;
        }
        entity.field_71088_bW = 10;
        final int destination = getDestination(entity);
        entity.changeDimension(destination, (ITeleporter)TFTeleporter.getTeleporterForDim(entity.func_184102_h(), destination));
        if (destination == TFConfig.dimension.dimensionID && entity instanceof EntityPlayerMP) {
            final EntityPlayerMP playerMP = (EntityPlayerMP)entity;
            playerMP.setSpawnChunk(new BlockPos((Entity)playerMP), true, TFConfig.dimension.dimensionID);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_180655_c(final IBlockState stateIn, final World worldIn, final BlockPos pos, final Random rand) {
        final int random = rand.nextInt(100);
        if ((boolean)stateIn.func_177229_b((IProperty)BlockTFPortal.DISALLOW_RETURN) && random < 80) {
            return;
        }
        if (random == 0) {
            worldIn.func_184134_a(pos.func_177958_n() + 0.5, pos.func_177956_o() + 0.5, pos.func_177952_p() + 0.5, SoundEvents.field_187810_eg, SoundCategory.BLOCKS, 0.5f, rand.nextFloat() * 0.4f + 0.8f, false);
        }
        for (int i = 0; i < 4; ++i) {
            final double xPos = pos.func_177958_n() + rand.nextFloat();
            final double yPos = pos.func_177956_o() + 1.0;
            final double zPos = pos.func_177952_p() + rand.nextFloat();
            final double xSpeed = (rand.nextFloat() - 0.5) * 0.5;
            final double ySpeed = rand.nextFloat();
            final double zSpeed = (rand.nextFloat() - 0.5) * 0.5;
            worldIn.func_175688_a(EnumParticleTypes.PORTAL, xPos, yPos, zPos, xSpeed, ySpeed, zSpeed, new int[0]);
        }
    }
    
    static {
        DISALLOW_RETURN = (IProperty)PropertyBool.func_177716_a("is_one_way");
        AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0);
        AABB_ITEM = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.4000000059604645, 1.0);
    }
}
