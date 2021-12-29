// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import java.util.Random;
import net.minecraftforge.common.util.ITeleporter;
import twilightforest.world.NoReturnTeleporter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.Advancement;
import twilightforest.network.MissingAdvancementToastPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fmllegacy.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import twilightforest.util.PlayerHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.Direction;
import java.util.List;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.phys.AABB;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.tags.Tag;
import twilightforest.data.BlockTagGenerator;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import twilightforest.world.TFTeleporter;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.TFConfig;
import org.apache.commons.lang3.mutable.MutableInt;
import java.util.HashMap;
import javax.annotation.Nullable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import java.util.HashSet;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.HalfTransparentBlock;

public class TFPortalBlock extends HalfTransparentBlock implements LiquidBlockContainer
{
    public static final BooleanProperty DISALLOW_RETURN;
    private static final VoxelShape AABB;
    private static final int MIN_PORTAL_SIZE = 4;
    private static final int MAX_PORTAL_SIZE = 64;
    private static final HashSet<ServerPlayer> playersNotified;
    private static final TranslatableComponent PORTAL_UNWORTHY;
    
    public TFPortalBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)TFPortalBlock.DISALLOW_RETURN, (Comparable)false));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)TFPortalBlock.DISALLOW_RETURN });
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return TFPortalBlock.AABB;
    }
    
    @Deprecated
    public VoxelShape m_5939_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return state.m_61143_((Property)TFPortalBlock.DISALLOW_RETURN) ? TFPortalBlock.AABB : Shapes.m_83040_();
    }
    
    public FluidState m_5888_(final BlockState state) {
        return Fluids.f_76193_.m_75953_(1, false);
    }
    
    public boolean tryToCreatePortal(final Level world, final BlockPos pos, final ItemEntity catalyst, @Nullable final Player player) {
        final BlockState state = world.m_8055_(pos);
        if (this.canFormPortal(state) && world.m_8055_(pos.m_7495_()).m_60815_()) {
            final Map<BlockPos, Boolean> blocksChecked = new HashMap<BlockPos, Boolean>();
            blocksChecked.put(pos, true);
            final MutableInt size = new MutableInt(0);
            if (recursivelyValidatePortal(world, pos, blocksChecked, size, state) && size.intValue() >= 4) {
                if (TFConfig.COMMON_CONFIG.checkPortalDestination.get()) {
                    final boolean checkProgression = TFGenerationSettings.isProgressionEnforced(catalyst.f_19853_);
                    if (!TFTeleporter.isSafeAround(world, pos, (Entity)catalyst, checkProgression)) {
                        if (player != null) {
                            player.m_5661_((Component)new TranslatableComponent("twilightforest.twilight_portal.unsafe"), true);
                        }
                        return false;
                    }
                }
                catalyst.m_32055_().m_41774_(1);
                causeLightning(world, pos, (boolean)TFConfig.COMMON_CONFIG.portalLightning.get());
                for (final Map.Entry<BlockPos, Boolean> checkedPos : blocksChecked.entrySet()) {
                    if (checkedPos.getValue()) {
                        world.m_7731_((BlockPos)checkedPos.getKey(), ((TFPortalBlock)TFBlocks.TWILIGHT_PORTAL.get()).m_49966_(), 2);
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public boolean canFormPortal(final BlockState state) {
        return state.m_60620_((Tag)BlockTagGenerator.PORTAL_POOL) || (state.m_60734_() == this && (boolean)state.m_61143_((Property)TFPortalBlock.DISALLOW_RETURN));
    }
    
    private static void causeLightning(final Level world, final BlockPos pos, final boolean fake) {
        final LightningBolt bolt = new LightningBolt(EntityType.f_20465_, world);
        bolt.m_6034_(pos.m_123341_() + 0.5, (double)pos.m_123342_(), pos.m_123343_() + 0.5);
        bolt.m_20874_(fake);
        world.m_7967_((Entity)bolt);
        if (fake && world instanceof ServerLevel) {
            final double range = 3.0;
            final List<Entity> list = world.m_45976_((Class)Entity.class, new AABB(pos).m_82400_(range));
            for (final Entity victim : list) {
                if (!ForgeEventFactory.onEntityStruckByLightning(victim, bolt)) {
                    victim.m_8038_((ServerLevel)world, bolt);
                }
            }
        }
    }
    
    private static boolean recursivelyValidatePortal(final Level world, final BlockPos pos, final Map<BlockPos, Boolean> blocksChecked, final MutableInt portalSize, final BlockState poolBlock) {
        if (portalSize.incrementAndGet() > 64) {
            return false;
        }
        boolean isPoolProbablyEnclosed = true;
        for (int i = 0; i < 4 && portalSize.intValue() <= 64; ++i) {
            final BlockPos positionCheck = pos.m_142300_(Direction.m_122407_(i));
            if (!blocksChecked.containsKey(positionCheck)) {
                final BlockState state = world.m_8055_(positionCheck);
                if (state == poolBlock && world.m_8055_(positionCheck.m_7495_()).m_60815_()) {
                    blocksChecked.put(positionCheck, true);
                    if (isPoolProbablyEnclosed) {
                        isPoolProbablyEnclosed = recursivelyValidatePortal(world, positionCheck, blocksChecked, portalSize, poolBlock);
                    }
                }
                else {
                    if (!isGrassOrDirt(state) || !isNatureBlock(world.m_8055_(positionCheck.m_7494_()))) {
                        return false;
                    }
                    blocksChecked.put(positionCheck, false);
                }
            }
        }
        return isPoolProbablyEnclosed;
    }
    
    private static boolean isNatureBlock(final BlockState state) {
        return BlockTagGenerator.PORTAL_DECO.m_8110_((Object)state.m_60734_());
    }
    
    private static boolean isGrassOrDirt(final BlockState state) {
        return BlockTagGenerator.PORTAL_EDGE.m_8110_((Object)state.m_60734_());
    }
    
    @Deprecated
    public void m_6861_(final BlockState state, final Level world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        boolean good = world.m_8055_(pos.m_7495_()).m_60815_();
        for (final Direction facing : Direction.Plane.HORIZONTAL) {
            if (!good) {
                break;
            }
            final BlockState neighboringState = world.m_8055_(pos.m_142300_(facing));
            good = (isGrassOrDirt(neighboringState) || neighboringState == state);
        }
        if (!good) {
            world.m_46796_(2001, pos, Block.m_49956_(state));
            world.m_7731_(pos, Blocks.f_49990_.m_49966_(), 3);
        }
    }
    
    public void m_7892_(final BlockState state, final Level worldIn, final BlockPos pos, final Entity entity) {
        if (state == this.m_49966_()) {
            if (entity instanceof final ServerPlayer player) {
                if (!player.m_7500_() && !player.m_5833_()) {
                    final Advancement requirement = PlayerHelper.getAdvancement((Player)player, TFConfig.getPortalLockingAdvancement());
                    if (requirement != null && !PlayerHelper.doesPlayerHaveRequiredAdvancement((Player)player, requirement)) {
                        player.m_5661_((Component)TFPortalBlock.PORTAL_UNWORTHY, true);
                        if (!isPlayerNotifiedOfRequirement(player)) {
                            final DisplayInfo info = requirement.m_138320_();
                            TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), (Object)((info == null) ? new MissingAdvancementToastPacket((Component)new TranslatableComponent(".ui.advancement.no_title"), new ItemStack((ItemLike)TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE.get())) : new MissingAdvancementToastPacket(info.m_14977_(), info.m_14990_())));
                            playerNotifiedOfRequirement(player);
                        }
                        return;
                    }
                }
            }
            attemptSendEntity(entity, false, true);
        }
    }
    
    public static boolean isPlayerNotifiedOfRequirement(final ServerPlayer player) {
        return TFPortalBlock.playersNotified.contains(player);
    }
    
    public static void playerNotifiedOfRequirement(final ServerPlayer player) {
        TFPortalBlock.playersNotified.add(player);
    }
    
    private static ResourceKey<Level> getDestination(final Entity entity) {
        final ResourceKey<Level> twilightForest = (ResourceKey<Level>)ResourceKey.m_135785_(Registry.f_122819_, new ResourceLocation((String)TFConfig.COMMON_CONFIG.DIMENSION.portalDestinationID.get()));
        return (ResourceKey<Level>)(entity.m_20193_().m_46472_().m_135782_().equals((Object)twilightForest.m_135782_()) ? ResourceKey.m_135785_(Registry.f_122819_, new ResourceLocation((String)TFConfig.COMMON_CONFIG.originDimension.get())) : twilightForest);
    }
    
    public static void attemptSendEntity(final Entity entity, final boolean forcedEntry, final boolean makeReturnPortal) {
        if (!entity.m_6084_() || entity.f_19853_.f_46443_) {
            return;
        }
        if (entity.m_20159_() || entity.m_20160_() || !entity.m_6072_()) {
            return;
        }
        if (!forcedEntry && entity.f_19818_ > 0) {
            return;
        }
        entity.f_19818_ = 10;
        final ResourceKey<Level> destination = getDestination(entity);
        final ServerLevel serverWorld = entity.m_20193_().m_142572_().m_129880_((ResourceKey)destination);
        if (serverWorld == null) {
            return;
        }
        entity.changeDimension(serverWorld, (ITeleporter)(makeReturnPortal ? new TFTeleporter(forcedEntry) : new NoReturnTeleporter()));
        if (destination == ResourceKey.m_135785_(Registry.f_122819_, new ResourceLocation((String)TFConfig.COMMON_CONFIG.DIMENSION.portalDestinationID.get())) && entity instanceof ServerPlayer && forcedEntry) {
            final ServerPlayer playerMP = (ServerPlayer)entity;
            playerMP.m_9158_((ResourceKey)destination, playerMP.m_142538_(), playerMP.m_146908_(), true, false);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7100_(final BlockState stateIn, final Level worldIn, final BlockPos pos, final Random rand) {
        final int random = rand.nextInt(100);
        if ((boolean)stateIn.m_61143_((Property)TFPortalBlock.DISALLOW_RETURN) && random < 80) {
            return;
        }
        if (random == 0) {
            worldIn.m_7785_(pos.m_123341_() + 0.5, pos.m_123342_() + 0.5, pos.m_123343_() + 0.5, TFSounds.PORTAL_WOOSH, SoundSource.BLOCKS, 0.5f, rand.nextFloat() * 0.4f + 0.8f, false);
        }
        for (int i = 0; i < 4; ++i) {
            final double xPos = pos.m_123341_() + rand.nextFloat();
            final double yPos = pos.m_123342_() + 1.0;
            final double zPos = pos.m_123343_() + rand.nextFloat();
            final double xSpeed = (rand.nextFloat() - 0.5) * 0.5;
            final double ySpeed = rand.nextFloat();
            final double zSpeed = (rand.nextFloat() - 0.5) * 0.5;
            worldIn.m_7106_((ParticleOptions)ParticleTypes.f_123760_, xPos, yPos, zPos, xSpeed, ySpeed, zSpeed);
        }
    }
    
    public boolean m_6044_(final BlockGetter iBlockReader, final BlockPos blockPos, final BlockState blockState, final Fluid fluid) {
        return false;
    }
    
    public boolean m_7361_(final LevelAccessor iWorld, final BlockPos blockPos, final BlockState blockState, final FluidState fluidState) {
        return false;
    }
    
    static {
        DISALLOW_RETURN = BooleanProperty.m_61465_("is_one_way");
        AABB = Shapes.m_83064_(new AABB(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0));
        playersNotified = new HashSet<ServerPlayer>();
        PORTAL_UNWORTHY = new TranslatableComponent("twilightforest.ui.portal.unworthy");
    }
}
