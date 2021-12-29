// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import java.util.HashMap;
import net.minecraft.world.level.block.Block;
import java.util.Random;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.TFConfig;
import twilightforest.block.TFPortalBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import java.util.function.Predicate;
import net.minecraft.world.phys.Vec3;
import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.util.WorldUtil;
import twilightforest.TwilightForestMod;
import net.minecraft.world.level.Level;
import twilightforest.world.registration.TFGenerationSettings;
import java.util.Iterator;
import net.minecraft.core.Direction;
import java.util.HashSet;
import java.util.Set;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.server.level.TicketType;
import com.google.common.collect.Maps;
import net.minecraft.util.Mth;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.ChunkPos;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.portal.PortalInfo;
import java.util.function.Function;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import it.unimi.dsi.fastutil.objects.Object2LongMap;
import net.minecraft.server.level.ColumnPos;
import net.minecraft.resources.ResourceLocation;
import java.util.Map;
import net.minecraftforge.common.util.ITeleporter;

public class TFTeleporter implements ITeleporter
{
    private static final Map<ResourceLocation, Map<ColumnPos, PortalPosition>> destinationCoordinateCache;
    private static final Object2LongMap<ColumnPos> columnMap;
    private static boolean locked;
    
    public TFTeleporter(final boolean locked) {
        TFTeleporter.locked = locked;
    }
    
    @Nullable
    public PortalInfo getPortalInfo(final Entity entity, final ServerLevel dest, final Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        PortalInfo pos;
        if ((pos = placeInExistingPortal(dest, entity, entity.m_142538_(), entity instanceof Player)) == null) {
            pos = moveToSafeCoords(dest, entity);
            this.makePortal(entity, dest, pos.f_77676_);
            pos = placeInExistingPortal(dest, entity, new BlockPos(pos.f_77676_), entity instanceof Player);
        }
        return pos;
    }
    
    @Nullable
    private static PortalInfo placeInExistingPortal(final ServerLevel world, final Entity entity, final BlockPos pos, final boolean isPlayer) {
        int i = 200;
        boolean flag = true;
        BlockPos blockpos = BlockPos.f_121853_;
        final ColumnPos columnPos = new ColumnPos(pos);
        if (!isPlayer && TFTeleporter.columnMap.containsKey((Object)columnPos)) {
            return null;
        }
        final PortalPosition portalPosition = TFTeleporter.destinationCoordinateCache.containsKey(world.m_46472_().m_135782_()) ? ((PortalPosition)TFTeleporter.destinationCoordinateCache.get(world.m_46472_().m_135782_()).get(columnPos)) : null;
        if (portalPosition != null) {
            blockpos = portalPosition.pos;
            portalPosition.lastUpdateTime = world.m_46467_();
            flag = false;
        }
        else {
            double d0 = Double.MAX_VALUE;
            for (int i2 = -i; i2 <= i; ++i2) {
                for (int j1 = -i; j1 <= i; ++j1) {
                    if (world.m_6857_().m_61937_(pos.m_142082_(i2, 0, j1))) {
                        final ChunkPos chunkPos = new ChunkPos(pos.m_142082_(i2, 0, j1));
                        if (world.m_7726_().f_8325_.m_140425_(chunkPos)) {
                            final LevelChunk chunk = world.m_6325_(chunkPos.f_45578_, chunkPos.f_45579_);
                            BlockPos blockpos3;
                            for (BlockPos blockpos2 = pos.m_142082_(i2, getScanHeight(world, pos) - pos.m_123342_(), j1); blockpos2.m_123342_() >= 0; blockpos2 = blockpos3) {
                                blockpos3 = blockpos2.m_7495_();
                                if (d0 < 0.0 || blockpos2.m_123331_((Vec3i)pos) < d0) {
                                    if (isPortal(chunk.m_8055_(blockpos2))) {
                                        for (blockpos3 = blockpos2.m_7495_(); isPortal(chunk.m_8055_(blockpos3)); blockpos3 = blockpos3.m_7495_()) {
                                            blockpos2 = blockpos3;
                                        }
                                        final float d2 = (float)blockpos2.m_123331_((Vec3i)pos);
                                        if (d0 < 0.0 || d2 < d0) {
                                            d0 = d2;
                                            blockpos = blockpos2;
                                            i = Mth.m_14167_(Mth.m_14116_(d2));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (blockpos.equals((Object)BlockPos.f_121853_)) {
            final long factor = world.m_46467_() + 300L;
            TFTeleporter.columnMap.put((Object)columnPos, factor);
            return null;
        }
        if (flag) {
            TFTeleporter.destinationCoordinateCache.putIfAbsent(world.m_46472_().m_135782_(), Maps.newHashMapWithExpectedSize(4096));
            TFTeleporter.destinationCoordinateCache.get(world.m_46472_().m_135782_()).put(columnPos, new PortalPosition(blockpos, world.m_46467_()));
            world.m_7726_().m_8387_(TicketType.f_9447_, new ChunkPos(blockpos), 3, (Object)new BlockPos(columnPos.f_140723_, blockpos.m_123342_(), columnPos.f_140724_));
        }
        final BlockPos[] portalBorder = getBoundaryPositions(world, blockpos).toArray(new BlockPos[0]);
        final BlockPos borderPos = portalBorder[0];
        final double portalX = borderPos.m_123341_() + 0.5;
        final double portalY = borderPos.m_123342_() + 1.0;
        final double portalZ = borderPos.m_123343_() + 0.5;
        return makePortalInfo(entity, portalX, portalY, portalZ);
    }
    
    private static int getScanHeight(final ServerLevel world, final BlockPos pos) {
        return getScanHeight(world, pos.m_123341_(), pos.m_123343_());
    }
    
    private static int getScanHeight(final ServerLevel world, final int x, final int z) {
        final int worldHeight = world.m_151558_() - 1;
        final int chunkHeight = world.m_6325_(x >> 4, z >> 4).m_62098_() + 15;
        return Math.min(worldHeight, chunkHeight);
    }
    
    private static boolean isPortal(final BlockState state) {
        return state.m_60734_() == TFBlocks.TWILIGHT_PORTAL.get();
    }
    
    private static Set<BlockPos> getBoundaryPositions(final ServerLevel world, final BlockPos start) {
        final Set<BlockPos> result = new HashSet<BlockPos>();
        final Set<BlockPos> checked = new HashSet<BlockPos>();
        checked.add(start);
        checkAdjacent(world, start, checked, result);
        return result;
    }
    
    private static void checkAdjacent(final ServerLevel world, final BlockPos pos, final Set<BlockPos> checked, final Set<BlockPos> result) {
        for (final Direction facing : Direction.Plane.HORIZONTAL) {
            final BlockPos offset = pos.m_142300_(facing);
            if (!checked.add(offset)) {
                continue;
            }
            if (isPortalAt(world, offset)) {
                checkAdjacent(world, offset, checked, result);
            }
            else {
                result.add(offset);
            }
        }
    }
    
    private static boolean isPortalAt(final ServerLevel world, final BlockPos pos) {
        return isPortal(world.m_8055_(pos));
    }
    
    private static PortalInfo moveToSafeCoords(final ServerLevel world, final Entity entity) {
        final boolean checkProgression = TFGenerationSettings.isProgressionEnforced((Level)world);
        final BlockPos pos = entity.m_142538_();
        if (isSafeAround((Level)world, pos, entity, checkProgression)) {
            TwilightForestMod.LOGGER.debug("Portal destination looks safe!");
            return makePortalInfo(entity, entity.m_20182_());
        }
        TwilightForestMod.LOGGER.debug("Portal destination looks unsafe, rerouting!");
        BlockPos safeCoords = findSafeCoords(world, 200, pos, entity, checkProgression);
        if (safeCoords != null) {
            TwilightForestMod.LOGGER.debug("Safely rerouted!");
            return makePortalInfo(entity, safeCoords.m_123341_(), entity.m_20186_(), safeCoords.m_123343_());
        }
        TwilightForestMod.LOGGER.info("Did not find a safe portal spot at first try, trying again with longer range.");
        safeCoords = findSafeCoords(world, 400, pos, entity, checkProgression);
        if (safeCoords != null) {
            TwilightForestMod.LOGGER.info("Safely rerouted to long range portal.  Return trip not guaranteed.");
            return makePortalInfo(entity, safeCoords.m_123341_(), entity.m_20186_(), safeCoords.m_123343_());
        }
        TwilightForestMod.LOGGER.warn("Still did not find a safe portal spot.");
        return makePortalInfo(entity, entity.m_20182_());
    }
    
    public static boolean isSafeAround(final Level world, final BlockPos pos, final Entity entity, final boolean checkProgression) {
        if (!isSafe(world, pos, entity, checkProgression)) {
            return false;
        }
        for (final Direction facing : Direction.Plane.HORIZONTAL) {
            if (!isSafe(world, pos.m_5484_(facing, 16), entity, checkProgression)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isSafe(final Level world, final BlockPos pos, final Entity entity, final boolean checkProgression) {
        return checkPos(world, pos) && (!checkProgression || checkBiome(world, pos, entity)) && checkStructure(world, pos);
    }
    
    private static boolean checkPos(final Level world, final BlockPos pos) {
        return world.m_6857_().m_61937_(pos);
    }
    
    private static boolean checkStructure(final Level world, final BlockPos pos) {
        final ChunkGeneratorTwilight generator = WorldUtil.getChunkGenerator((LevelAccessor)world);
        return generator == null || !TFGenerationSettings.locateTFStructureInRange((WorldGenLevel)world, pos, 0).isPresent();
    }
    
    private static boolean checkBiome(final Level world, final BlockPos pos, final Entity entity) {
        return TFGenerationSettings.isBiomeSafeFor(world.m_46857_(pos), entity);
    }
    
    @Nullable
    private static BlockPos findSafeCoords(final ServerLevel world, final int range, final BlockPos pos, final Entity entity, final boolean checkProgression) {
        for (int attempts = range / 8, x = 0; x < attempts; ++x) {
            for (int z = 0; z < attempts; ++z) {
                final BlockPos dPos = new BlockPos(pos.m_123341_() + x * attempts - range / 2, 100, pos.m_123343_() + z * attempts - range / 2);
                if (isSafeAround((Level)world, dPos, entity, checkProgression)) {
                    return dPos;
                }
            }
        }
        return null;
    }
    
    private void makePortal(final Entity entity, final ServerLevel world, final Vec3 pos) {
        loadSurroundingArea(world, pos);
        BlockPos spot = findPortalCoords(world, pos, blockPos -> isPortalAt(world, blockPos));
        final String name = entity.m_7755_().getString();
        if (spot != null) {
            TwilightForestMod.LOGGER.debug("Found existing portal for {} at {}", (Object)name, (Object)spot);
            cachePortalCoords(world, pos, spot);
            return;
        }
        spot = findPortalCoords(world, pos, blockpos -> isIdealForPortal(world, blockpos));
        if (spot != null) {
            TwilightForestMod.LOGGER.debug("Found ideal portal spot for {} at {}", (Object)name, (Object)spot);
            cachePortalCoords(world, pos, this.makePortalAt((Level)world, spot));
            return;
        }
        TwilightForestMod.LOGGER.debug("Did not find ideal portal spot, shooting for okay one for {}", (Object)name);
        spot = findPortalCoords(world, pos, blockPos -> isOkayForPortal(world, blockPos));
        if (spot != null) {
            TwilightForestMod.LOGGER.debug("Found okay portal spot for {} at {}", (Object)name, (Object)spot);
            cachePortalCoords(world, pos, this.makePortalAt((Level)world, spot));
            return;
        }
        TwilightForestMod.LOGGER.debug("Did not even find an okay portal spot, just making a random one for {}", (Object)name);
        final double yFactor = getYFactor(world);
        cachePortalCoords(world, pos, this.makePortalAt((Level)world, new BlockPos(entity.m_20185_(), entity.m_20186_() * yFactor - 1.0, entity.m_20189_())));
    }
    
    private static void loadSurroundingArea(final ServerLevel world, final Vec3 pos) {
        final int x = Mth.m_14107_(pos.f_82479_) >> 4;
        final int z = Mth.m_14107_(pos.f_82480_) >> 4;
        for (int dx = -2; dx <= 2; ++dx) {
            for (int dz = -2; dz <= 2; ++dz) {
                world.m_6325_(x + dx, z + dz);
            }
        }
    }
    
    @Nullable
    private static BlockPos findPortalCoords(final ServerLevel world, final Vec3 loc, final Predicate<BlockPos> predicate) {
        final double yFactor = getYFactor(world);
        final int entityX = Mth.m_14107_(loc.f_82479_);
        final int entityZ = Mth.m_14107_(loc.f_82481_);
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        double spotWeight = -1.0;
        BlockPos spot = null;
        for (int range = 16, rx = entityX - range; rx <= entityX + range; ++rx) {
            final double xWeight = rx + 0.5 - loc.f_82479_;
            for (int rz = entityZ - range; rz <= entityZ + range; ++rz) {
                final double zWeight = rz + 0.5 - loc.f_82481_;
                for (int ry = getScanHeight(world, rx, rz); ry >= world.m_141937_(); --ry) {
                    if (world.m_46859_((BlockPos)pos.m_122178_(rx, ry, rz))) {
                        while (ry > world.m_141937_() && world.m_46859_((BlockPos)pos.m_122178_(rx, ry - 1, rz))) {
                            --ry;
                        }
                        final double yWeight = ry + 0.5 - loc.f_82480_ * yFactor;
                        final double rPosWeight = xWeight * xWeight + yWeight * yWeight + zWeight * zWeight;
                        if ((spotWeight < 0.0 || rPosWeight < spotWeight) && predicate.test((BlockPos)pos)) {
                            spotWeight = rPosWeight;
                            spot = pos.m_7949_();
                        }
                    }
                }
            }
        }
        return spot;
    }
    
    private static double getYFactor(final ServerLevel world) {
        return world.m_46472_().m_135782_().equals((Object)Level.f_46428_.m_135782_()) ? 2.0 : 0.5;
    }
    
    private static void cachePortalCoords(final ServerLevel world, final Vec3 loc, final BlockPos pos) {
        final int x = Mth.m_14107_(loc.f_82479_);
        final int z = Mth.m_14107_(loc.f_82481_);
        TFTeleporter.destinationCoordinateCache.putIfAbsent(world.m_46472_().m_135782_(), Maps.newHashMapWithExpectedSize(4096));
        TFTeleporter.destinationCoordinateCache.get(world.m_46472_().m_135782_()).put(new ColumnPos(x, z), new PortalPosition(pos, world.m_46467_()));
    }
    
    private static boolean isIdealForPortal(final ServerLevel world, final BlockPos pos) {
        for (int potentialZ = 0; potentialZ < 4; ++potentialZ) {
            for (int potentialX = 0; potentialX < 4; ++potentialX) {
                for (int potentialY = 0; potentialY < 4; ++potentialY) {
                    final BlockPos tPos = pos.m_142082_(potentialX - 1, potentialY, potentialZ - 1);
                    final Material material = world.m_8055_(tPos).m_60767_();
                    if ((potentialY == 0 && material != Material.f_76315_) || (potentialY >= 1 && !material.m_76336_())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    protected BlockPos makePortalAt(final Level world, final BlockPos pos) {
        final BlockState grass = Blocks.f_50440_.m_49966_();
        world.m_46597_(pos.m_142125_().m_142127_(), grass);
        world.m_46597_(pos.m_142127_(), grass);
        world.m_46597_(pos.m_142126_().m_142127_(), grass);
        world.m_46597_(pos.m_142385_(2).m_142127_(), grass);
        world.m_46597_(pos.m_142125_(), grass);
        world.m_46597_(pos.m_142385_(2), grass);
        world.m_46597_(pos.m_142125_().m_142128_(), grass);
        world.m_46597_(pos.m_142385_(2).m_142128_(), grass);
        world.m_46597_(pos.m_142125_().m_142383_(2), grass);
        world.m_46597_(pos.m_142383_(2), grass);
        world.m_46597_(pos.m_142126_().m_142383_(2), grass);
        world.m_46597_(pos.m_142385_(2).m_142383_(2), grass);
        final BlockState dirt = Blocks.f_50493_.m_49966_();
        world.m_46597_(pos.m_7495_(), dirt);
        world.m_46597_(pos.m_142126_().m_7495_(), dirt);
        world.m_46597_(pos.m_142128_().m_7495_(), dirt);
        world.m_46597_(pos.m_142126_().m_142128_().m_7495_(), dirt);
        final BlockState portal = (BlockState)((TFPortalBlock)TFBlocks.TWILIGHT_PORTAL.get()).m_49966_().m_61124_((Property)TFPortalBlock.DISALLOW_RETURN, (Comparable)(TFTeleporter.locked || !(boolean)TFConfig.COMMON_CONFIG.shouldReturnPortalBeUsable.get()));
        world.m_7731_(pos, portal, 2);
        world.m_7731_(pos.m_142126_(), portal, 2);
        world.m_7731_(pos.m_142128_(), portal, 2);
        world.m_7731_(pos.m_142126_().m_142128_(), portal, 2);
        for (int dx = -1; dx <= 2; ++dx) {
            for (int dz = -1; dz <= 2; ++dz) {
                for (int dy = 1; dy <= 5; ++dy) {
                    world.m_7471_(pos.m_142082_(dx, dy, dz), false);
                }
            }
        }
        world.m_7731_(pos.m_142125_().m_142127_().m_7494_(), randNatureBlock(world.f_46441_), 2);
        world.m_7731_(pos.m_142127_().m_7494_(), randNatureBlock(world.f_46441_), 2);
        world.m_7731_(pos.m_142126_().m_142127_().m_7494_(), randNatureBlock(world.f_46441_), 2);
        world.m_7731_(pos.m_142385_(2).m_142127_().m_7494_(), randNatureBlock(world.f_46441_), 2);
        world.m_7731_(pos.m_142125_().m_7494_(), randNatureBlock(world.f_46441_), 2);
        world.m_7731_(pos.m_142385_(2).m_7494_(), randNatureBlock(world.f_46441_), 2);
        world.m_7731_(pos.m_142125_().m_142128_().m_7494_(), randNatureBlock(world.f_46441_), 2);
        world.m_7731_(pos.m_142385_(2).m_142128_().m_7494_(), randNatureBlock(world.f_46441_), 2);
        world.m_7731_(pos.m_142125_().m_142383_(2).m_7494_(), randNatureBlock(world.f_46441_), 2);
        world.m_7731_(pos.m_142383_(2).m_7494_(), randNatureBlock(world.f_46441_), 2);
        world.m_7731_(pos.m_142126_().m_142383_(2).m_7494_(), randNatureBlock(world.f_46441_), 2);
        world.m_7731_(pos.m_142385_(2).m_142383_(2).m_7494_(), randNatureBlock(world.f_46441_), 2);
        return pos;
    }
    
    private static BlockState randNatureBlock(final Random random) {
        final Block[] blocks = { Blocks.f_50072_, Blocks.f_50073_, Blocks.f_50034_, Blocks.f_50112_, Blocks.f_50111_ };
        return blocks[random.nextInt(blocks.length)].m_49966_();
    }
    
    private static boolean isOkayForPortal(final ServerLevel world, final BlockPos pos) {
        for (int potentialZ = 0; potentialZ < 4; ++potentialZ) {
            for (int potentialX = 0; potentialX < 4; ++potentialX) {
                for (int potentialY = 0; potentialY < 4; ++potentialY) {
                    final BlockPos tPos = pos.m_142082_(potentialX - 1, potentialY, potentialZ - 1);
                    final Material material = world.m_8055_(tPos).m_60767_();
                    if ((potentialY == 0 && !material.m_76333_() && !material.m_76332_()) || (potentialY >= 1 && !material.m_76336_())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static PortalInfo makePortalInfo(final Entity entity, final double x, final double y, final double z) {
        return makePortalInfo(entity, new Vec3(x, y, z));
    }
    
    private static PortalInfo makePortalInfo(final Entity entity, final Vec3 pos) {
        return new PortalInfo(pos, Vec3.f_82478_, entity.m_146908_(), entity.m_146909_());
    }
    
    public Entity placeEntity(final Entity entity, final ServerLevel currentWorld, final ServerLevel destWorld, final float yaw, final Function<Boolean, Entity> repositionEntity) {
        entity.f_19789_ = 0.0f;
        return repositionEntity.apply(false);
    }
    
    static {
        destinationCoordinateCache = new HashMap<ResourceLocation, Map<ColumnPos, PortalPosition>>();
        columnMap = (Object2LongMap)new Object2LongOpenHashMap();
    }
    
    static class PortalPosition
    {
        public final BlockPos pos;
        long lastUpdateTime;
        
        PortalPosition(final BlockPos pos, final long time) {
            this.pos = pos;
            this.lastUpdateTime = time;
        }
    }
}
