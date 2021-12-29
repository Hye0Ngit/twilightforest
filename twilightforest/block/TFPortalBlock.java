// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.IWorld;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import java.util.Random;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.RegistryKey;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import java.util.List;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.tags.ITag;
import twilightforest.data.BlockTagGenerator;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.entity.Entity;
import twilightforest.world.TFTeleporter;
import twilightforest.world.TFGenerationSettings;
import twilightforest.TFConfig;
import org.apache.commons.lang3.mutable.MutableInt;
import java.util.HashMap;
import javax.annotation.Nullable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.world.World;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.BreakableBlock;

public class TFPortalBlock extends BreakableBlock implements ILiquidContainer
{
    public static final BooleanProperty DISALLOW_RETURN;
    private static final VoxelShape AABB;
    private static final int MIN_PORTAL_SIZE = 4;
    private static final int MAX_PORTAL_SIZE = 64;
    
    public TFPortalBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)TFPortalBlock.DISALLOW_RETURN, (Comparable)false));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)TFPortalBlock.DISALLOW_RETURN });
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        return TFPortalBlock.AABB;
    }
    
    @Deprecated
    public VoxelShape func_220071_b(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        return state.func_177229_b((Property)TFPortalBlock.DISALLOW_RETURN) ? TFPortalBlock.AABB : VoxelShapes.func_197880_a();
    }
    
    public FluidState func_204507_t(final BlockState state) {
        return Fluids.field_204546_a.func_207207_a(1, false);
    }
    
    public boolean tryToCreatePortal(final World world, final BlockPos pos, final ItemEntity catalyst, @Nullable final PlayerEntity player) {
        final BlockState state = world.func_180495_p(pos);
        if (this.canFormPortal(state) && world.func_180495_p(pos.func_177977_b()).func_200132_m()) {
            final Map<BlockPos, Boolean> blocksChecked = new HashMap<BlockPos, Boolean>();
            blocksChecked.put(pos, true);
            final MutableInt size = new MutableInt(0);
            if (recursivelyValidatePortal(world, pos, blocksChecked, size, state) && size.intValue() >= 4) {
                if (TFConfig.COMMON_CONFIG.checkPortalDestination.get()) {
                    final boolean checkProgression = TFGenerationSettings.isProgressionEnforced(catalyst.field_70170_p);
                    if (!TFTeleporter.isSafeAround(world, pos, (Entity)catalyst, checkProgression)) {
                        if (player != null) {
                            player.func_146105_b((ITextComponent)new TranslationTextComponent("twilightforest.twilight_portal.unsafe"), true);
                        }
                        return false;
                    }
                }
                catalyst.func_92059_d().func_190918_g(1);
                causeLightning(world, pos, (boolean)TFConfig.COMMON_CONFIG.portalLightning.get());
                for (final Map.Entry<BlockPos, Boolean> checkedPos : blocksChecked.entrySet()) {
                    if (checkedPos.getValue()) {
                        world.func_180501_a((BlockPos)checkedPos.getKey(), ((TFPortalBlock)TFBlocks.twilight_portal.get()).func_176223_P(), 2);
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public boolean canFormPortal(final BlockState state) {
        return state.func_177230_c().func_203417_a((ITag)BlockTagGenerator.PORTAL_POOL) || (state.func_177230_c() == this && (boolean)state.func_177229_b((Property)TFPortalBlock.DISALLOW_RETURN));
    }
    
    private static void causeLightning(final World world, final BlockPos pos, final boolean fake) {
        final LightningBoltEntity bolt = new LightningBoltEntity(EntityType.field_200728_aG, world);
        bolt.func_70107_b(pos.func_177958_n() + 0.5, (double)pos.func_177956_o(), pos.func_177952_p() + 0.5);
        bolt.func_233623_a_(fake);
        world.func_217376_c((Entity)bolt);
        if (fake && world instanceof ServerWorld) {
            final double range = 3.0;
            final List<Entity> list = world.func_217357_a((Class)Entity.class, new AxisAlignedBB(pos).func_186662_g(range));
            for (final Entity victim : list) {
                if (!ForgeEventFactory.onEntityStruckByLightning(victim, bolt)) {
                    victim.func_241841_a((ServerWorld)world, bolt);
                }
            }
        }
    }
    
    private static boolean recursivelyValidatePortal(final World world, final BlockPos pos, final Map<BlockPos, Boolean> blocksChecked, final MutableInt portalSize, final BlockState poolBlock) {
        if (portalSize.incrementAndGet() > 64) {
            return false;
        }
        boolean isPoolProbablyEnclosed = true;
        for (int i = 0; i < 4 && portalSize.intValue() <= 64; ++i) {
            final BlockPos positionCheck = pos.func_177972_a(Direction.func_176731_b(i));
            if (!blocksChecked.containsKey(positionCheck)) {
                final BlockState state = world.func_180495_p(positionCheck);
                if (state == poolBlock && world.func_180495_p(positionCheck.func_177977_b()).func_200132_m()) {
                    blocksChecked.put(positionCheck, true);
                    if (isPoolProbablyEnclosed) {
                        isPoolProbablyEnclosed = recursivelyValidatePortal(world, positionCheck, blocksChecked, portalSize, poolBlock);
                    }
                }
                else {
                    if (!isGrassOrDirt(state) || !isNatureBlock(world.func_180495_p(positionCheck.func_177984_a()))) {
                        return false;
                    }
                    blocksChecked.put(positionCheck, false);
                }
            }
        }
        return isPoolProbablyEnclosed;
    }
    
    private static boolean isNatureBlock(final BlockState state) {
        return BlockTagGenerator.PORTAL_DECO.func_230235_a_((Object)state.func_177230_c());
    }
    
    private static boolean isGrassOrDirt(final BlockState state) {
        return BlockTagGenerator.PORTAL_EDGE.func_230235_a_((Object)state.func_177230_c());
    }
    
    @Deprecated
    public void func_220069_a(final BlockState state, final World world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        boolean good = world.func_180495_p(pos.func_177977_b()).func_200132_m();
        for (final Direction facing : Direction.Plane.HORIZONTAL) {
            if (!good) {
                break;
            }
            final BlockState neighboringState = world.func_180495_p(pos.func_177972_a(facing));
            good = (isGrassOrDirt(neighboringState) || neighboringState == state);
        }
        if (!good) {
            world.func_217379_c(2001, pos, Block.func_196246_j(state));
            world.func_180501_a(pos, Blocks.field_150355_j.func_176223_P(), 3);
        }
    }
    
    public void func_196262_a(final BlockState state, final World worldIn, final BlockPos pos, final Entity entity) {
        if (state == this.func_176223_P()) {
            attemptSendPlayer(entity, false);
        }
    }
    
    private static RegistryKey<World> getDestination(final Entity entity) {
        final RegistryKey<World> twilightForest = (RegistryKey<World>)RegistryKey.func_240903_a_(Registry.field_239699_ae_, new ResourceLocation((String)TFConfig.COMMON_CONFIG.DIMENSION.twilightForestID.get()));
        return (RegistryKey<World>)(entity.func_130014_f_().func_234923_W_().func_240901_a_().equals((Object)twilightForest.func_240901_a_()) ? RegistryKey.func_240903_a_(Registry.field_239699_ae_, new ResourceLocation((String)TFConfig.COMMON_CONFIG.originDimension.get())) : twilightForest);
    }
    
    public static void attemptSendPlayer(final Entity entity, final boolean forcedEntry) {
        if (!entity.func_70089_S() || entity.field_70170_p.field_72995_K) {
            return;
        }
        if (entity.func_184218_aH() || entity.func_184207_aI() || !entity.func_184222_aU()) {
            return;
        }
        if (!forcedEntry && entity.field_82153_h > 0) {
            return;
        }
        entity.field_82153_h = 10;
        final RegistryKey<World> destination = getDestination(entity);
        final ServerWorld serverWorld = entity.func_130014_f_().func_73046_m().func_71218_a((RegistryKey)destination);
        if (serverWorld == null) {
            return;
        }
        entity.changeDimension(serverWorld, (ITeleporter)new TFTeleporter(forcedEntry));
        if (destination == RegistryKey.func_240903_a_(Registry.field_239699_ae_, new ResourceLocation((String)TFConfig.COMMON_CONFIG.DIMENSION.twilightForestID.get())) && entity instanceof ServerPlayerEntity && forcedEntry) {
            final ServerPlayerEntity playerMP = (ServerPlayerEntity)entity;
            playerMP.func_242111_a((RegistryKey)destination, playerMP.func_233580_cy_(), playerMP.field_70177_z, true, false);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_180655_c(final BlockState stateIn, final World worldIn, final BlockPos pos, final Random rand) {
        final int random = rand.nextInt(100);
        if ((boolean)stateIn.func_177229_b((Property)TFPortalBlock.DISALLOW_RETURN) && random < 80) {
            return;
        }
        if (random == 0) {
            worldIn.func_184134_a(pos.func_177958_n() + 0.5, pos.func_177956_o() + 0.5, pos.func_177952_p() + 0.5, TFSounds.PORTAL_WOOSH, SoundCategory.BLOCKS, 0.5f, rand.nextFloat() * 0.4f + 0.8f, false);
        }
        for (int i = 0; i < 4; ++i) {
            final double xPos = pos.func_177958_n() + rand.nextFloat();
            final double yPos = pos.func_177956_o() + 1.0;
            final double zPos = pos.func_177952_p() + rand.nextFloat();
            final double xSpeed = (rand.nextFloat() - 0.5) * 0.5;
            final double ySpeed = rand.nextFloat();
            final double zSpeed = (rand.nextFloat() - 0.5) * 0.5;
            worldIn.func_195594_a((IParticleData)ParticleTypes.field_197599_J, xPos, yPos, zPos, xSpeed, ySpeed, zSpeed);
        }
    }
    
    public boolean func_204510_a(final IBlockReader iBlockReader, final BlockPos blockPos, final BlockState blockState, final Fluid fluid) {
        return false;
    }
    
    public boolean func_204509_a(final IWorld iWorld, final BlockPos blockPos, final BlockState blockState, final FluidState fluidState) {
        return false;
    }
    
    static {
        DISALLOW_RETURN = BooleanProperty.func_177716_a("is_one_way");
        AABB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0));
    }
}
