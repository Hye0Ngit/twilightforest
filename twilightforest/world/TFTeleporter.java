// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import java.util.HashMap;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.state.Property;
import twilightforest.TFConfig;
import twilightforest.block.TFPortalBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import java.util.function.Predicate;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.ISeedReader;
import twilightforest.TwilightForestMod;
import net.minecraft.world.World;
import java.util.Iterator;
import net.minecraft.util.Direction;
import java.util.HashSet;
import java.util.Set;
import twilightforest.block.TFBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.TicketType;
import com.google.common.collect.Maps;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.ChunkPos;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.PortalInfo;
import java.util.function.Function;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.Entity;
import it.unimi.dsi.fastutil.objects.Object2LongMap;
import net.minecraft.util.math.ColumnPos;
import net.minecraft.util.ResourceLocation;
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
    public PortalInfo getPortalInfo(final Entity entity, final ServerWorld dest, final Function<ServerWorld, PortalInfo> defaultPortalInfo) {
        PortalInfo pos;
        if ((pos = placeInExistingPortal(dest, entity, entity.func_233580_cy_(), entity instanceof PlayerEntity)) == null) {
            pos = moveToSafeCoords(dest, entity);
            makePortal(entity, dest, pos.field_222505_a);
            pos = placeInExistingPortal(dest, entity, new BlockPos(pos.field_222505_a), entity instanceof PlayerEntity);
        }
        return pos;
    }
    
    @Nullable
    private static PortalInfo placeInExistingPortal(final ServerWorld world, final Entity entity, final BlockPos pos, final boolean isPlayer) {
        int i = 200;
        boolean flag = true;
        BlockPos blockpos = BlockPos.field_177992_a;
        final ColumnPos columnPos = new ColumnPos(pos);
        if (!isPlayer && TFTeleporter.columnMap.containsKey((Object)columnPos)) {
            return null;
        }
        final PortalPosition portalPosition = TFTeleporter.destinationCoordinateCache.containsKey(world.func_234923_W_().func_240901_a_()) ? ((PortalPosition)TFTeleporter.destinationCoordinateCache.get(world.func_234923_W_().func_240901_a_()).get(columnPos)) : null;
        if (portalPosition != null) {
            blockpos = portalPosition.pos;
            portalPosition.lastUpdateTime = world.func_82737_E();
            flag = false;
        }
        else {
            double d0 = Double.MAX_VALUE;
            for (int i2 = -i; i2 <= i; ++i2) {
                for (int j1 = -i; j1 <= i; ++j1) {
                    if (world.func_175723_af().func_177746_a(pos.func_177982_a(i2, 0, j1))) {
                        final ChunkPos chunkPos = new ChunkPos(pos.func_177982_a(i2, 0, j1));
                        if (world.func_72863_F().field_217237_a.func_241090_h_(chunkPos)) {
                            final Chunk chunk = world.func_212866_a_(chunkPos.field_77276_a, chunkPos.field_77275_b);
                            BlockPos blockpos3;
                            for (BlockPos blockpos2 = pos.func_177982_a(i2, getScanHeight(world, pos) - pos.func_177956_o(), j1); blockpos2.func_177956_o() >= 0; blockpos2 = blockpos3) {
                                blockpos3 = blockpos2.func_177977_b();
                                if (d0 < 0.0 || blockpos2.func_177951_i((Vector3i)pos) < d0) {
                                    if (isPortal(chunk.func_180495_p(blockpos2))) {
                                        for (blockpos3 = blockpos2.func_177977_b(); isPortal(chunk.func_180495_p(blockpos3)); blockpos3 = blockpos3.func_177977_b()) {
                                            blockpos2 = blockpos3;
                                        }
                                        final double d2 = blockpos2.func_177951_i((Vector3i)pos);
                                        if (d0 < 0.0 || d2 < d0) {
                                            d0 = d2;
                                            blockpos = blockpos2;
                                            i = MathHelper.func_76123_f(MathHelper.func_76133_a(d2));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (blockpos.equals((Object)BlockPos.field_177992_a)) {
            final long factor = world.func_82737_E() + 300L;
            TFTeleporter.columnMap.put((Object)columnPos, factor);
            return null;
        }
        if (flag) {
            TFTeleporter.destinationCoordinateCache.putIfAbsent(world.func_234923_W_().func_240901_a_(), Maps.newHashMapWithExpectedSize(4096));
            TFTeleporter.destinationCoordinateCache.get(world.func_234923_W_().func_240901_a_()).put(columnPos, new PortalPosition(blockpos, world.func_82737_E()));
            world.func_72863_F().func_217228_a(TicketType.field_219493_f, new ChunkPos(blockpos), 3, (Object)new BlockPos(columnPos.field_219439_a, blockpos.func_177956_o(), columnPos.field_219440_b));
        }
        final BlockPos[] portalBorder = getBoundaryPositions(world, blockpos).toArray(new BlockPos[0]);
        final BlockPos borderPos = portalBorder[0];
        final double portalX = borderPos.func_177958_n() + 0.5;
        final double portalY = borderPos.func_177956_o() + 1.0;
        final double portalZ = borderPos.func_177952_p() + 0.5;
        return makePortalInfo(entity, portalX, portalY, portalZ);
    }
    
    private static int getScanHeight(final ServerWorld world, final BlockPos pos) {
        return getScanHeight(world, pos.func_177958_n(), pos.func_177952_p());
    }
    
    private static int getScanHeight(final ServerWorld world, final int x, final int z) {
        final int worldHeight = world.func_217301_I() - 1;
        final int chunkHeight = world.func_212866_a_(x >> 4, z >> 4).func_76625_h() + 15;
        return Math.min(worldHeight, chunkHeight);
    }
    
    private static boolean isPortal(final BlockState state) {
        return state.func_177230_c() == TFBlocks.twilight_portal.get();
    }
    
    private static Set<BlockPos> getBoundaryPositions(final ServerWorld world, final BlockPos start) {
        final Set<BlockPos> result = new HashSet<BlockPos>();
        final Set<BlockPos> checked = new HashSet<BlockPos>();
        checked.add(start);
        checkAdjacent(world, start, checked, result);
        return result;
    }
    
    private static void checkAdjacent(final ServerWorld world, final BlockPos pos, final Set<BlockPos> checked, final Set<BlockPos> result) {
        for (final Direction facing : Direction.Plane.HORIZONTAL) {
            final BlockPos offset = pos.func_177972_a(facing);
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
    
    private static boolean isPortalAt(final ServerWorld world, final BlockPos pos) {
        return isPortal(world.func_180495_p(pos));
    }
    
    private static PortalInfo moveToSafeCoords(final ServerWorld world, final Entity entity) {
        final boolean checkProgression = TFGenerationSettings.isProgressionEnforced((World)world);
        final BlockPos pos = entity.func_233580_cy_();
        if (isSafeAround((World)world, pos, entity, checkProgression)) {
            TwilightForestMod.LOGGER.debug("Portal destination looks safe!");
            return makePortalInfo(entity, entity.func_213303_ch());
        }
        TwilightForestMod.LOGGER.debug("Portal destination looks unsafe, rerouting!");
        BlockPos safeCoords = findSafeCoords(world, 200, pos, entity, checkProgression);
        if (safeCoords != null) {
            TwilightForestMod.LOGGER.debug("Safely rerouted!");
            return makePortalInfo(entity, safeCoords.func_177958_n(), entity.func_226278_cu_(), safeCoords.func_177952_p());
        }
        TwilightForestMod.LOGGER.info("Did not find a safe portal spot at first try, trying again with longer range.");
        safeCoords = findSafeCoords(world, 400, pos, entity, checkProgression);
        if (safeCoords != null) {
            TwilightForestMod.LOGGER.info("Safely rerouted to long range portal.  Return trip not guaranteed.");
            return makePortalInfo(entity, safeCoords.func_177958_n(), entity.func_226278_cu_(), safeCoords.func_177952_p());
        }
        TwilightForestMod.LOGGER.warn("Still did not find a safe portal spot.");
        return makePortalInfo(entity, entity.func_213303_ch());
    }
    
    public static boolean isSafeAround(final World world, final BlockPos pos, final Entity entity, final boolean checkProgression) {
        if (!isSafe(world, pos, entity, checkProgression)) {
            return false;
        }
        for (final Direction facing : Direction.Plane.HORIZONTAL) {
            if (!isSafe(world, pos.func_177967_a(facing, 16), entity, checkProgression)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isSafe(final World world, final BlockPos pos, final Entity entity, final boolean checkProgression) {
        return checkPos(world, pos) && (!checkProgression || checkBiome(world, pos, entity)) && checkStructure(world, pos);
    }
    
    private static boolean checkPos(final World world, final BlockPos pos) {
        return world.func_175723_af().func_177746_a(pos);
    }
    
    private static boolean checkStructure(final World world, final BlockPos pos) {
        final ChunkGeneratorTwilightBase generator = TFGenerationSettings.getChunkGenerator(world);
        return generator == null || !TFGenerationSettings.locateTFStructureInRange((ISeedReader)world, pos, 0).isPresent();
    }
    
    private static boolean checkBiome(final World world, final BlockPos pos, final Entity entity) {
        return TFGenerationSettings.isBiomeSafeFor(world.func_226691_t_(pos), entity);
    }
    
    @Nullable
    private static BlockPos findSafeCoords(final ServerWorld world, final int range, final BlockPos pos, final Entity entity, final boolean checkProgression) {
        for (int attempts = range / 8, x = 0; x < attempts; ++x) {
            for (int z = 0; z < attempts; ++z) {
                final BlockPos dPos = new BlockPos(pos.func_177958_n() + x * attempts - range / 2, 100, pos.func_177952_p() + z * attempts - range / 2);
                if (isSafeAround((World)world, dPos, entity, checkProgression)) {
                    return dPos;
                }
            }
        }
        return null;
    }
    
    private static void makePortal(final Entity entity, final ServerWorld world, final Vector3d pos) {
        loadSurroundingArea(world, pos);
        BlockPos spot = findPortalCoords(world, pos, blockPos -> isPortalAt(world, blockPos));
        final String name = entity.func_200200_C_().getString();
        if (spot != null) {
            TwilightForestMod.LOGGER.debug("Found existing portal for {} at {}", (Object)name, (Object)spot);
            cachePortalCoords(world, pos, spot);
            return;
        }
        spot = findPortalCoords(world, pos, blockpos -> isIdealForPortal(world, blockpos));
        if (spot != null) {
            TwilightForestMod.LOGGER.debug("Found ideal portal spot for {} at {}", (Object)name, (Object)spot);
            cachePortalCoords(world, pos, makePortalAt((World)world, spot));
            return;
        }
        TwilightForestMod.LOGGER.debug("Did not find ideal portal spot, shooting for okay one for {}", (Object)name);
        spot = findPortalCoords(world, pos, blockPos -> isOkayForPortal(world, blockPos));
        if (spot != null) {
            TwilightForestMod.LOGGER.debug("Found okay portal spot for {} at {}", (Object)name, (Object)spot);
            cachePortalCoords(world, pos, makePortalAt((World)world, spot));
            return;
        }
        TwilightForestMod.LOGGER.debug("Did not even find an okay portal spot, just making a random one for {}", (Object)name);
        final double yFactor = getYFactor(world);
        cachePortalCoords(world, pos, makePortalAt((World)world, new BlockPos(entity.func_226277_ct_(), entity.func_226278_cu_() * yFactor - 1.0, entity.func_226281_cx_())));
    }
    
    private static void loadSurroundingArea(final ServerWorld world, final Vector3d pos) {
        final int x = MathHelper.func_76128_c(pos.field_72450_a) >> 4;
        final int z = MathHelper.func_76128_c(pos.field_72448_b) >> 4;
        for (int dx = -2; dx <= 2; ++dx) {
            for (int dz = -2; dz <= 2; ++dz) {
                world.func_212866_a_(x + dx, z + dz);
            }
        }
    }
    
    @Nullable
    private static BlockPos findPortalCoords(final ServerWorld world, final Vector3d loc, final Predicate<BlockPos> predicate) {
        final double yFactor = getYFactor(world);
        final int entityX = MathHelper.func_76128_c(loc.field_72450_a);
        final int entityZ = MathHelper.func_76128_c(loc.field_72449_c);
        final BlockPos.Mutable pos = new BlockPos.Mutable();
        double spotWeight = -1.0;
        BlockPos spot = null;
        for (int range = 16, rx = entityX - range; rx <= entityX + range; ++rx) {
            final double xWeight = rx + 0.5 - loc.field_72450_a;
            for (int rz = entityZ - range; rz <= entityZ + range; ++rz) {
                final double zWeight = rz + 0.5 - loc.field_72449_c;
                for (int ry = getScanHeight(world, rx, rz); ry >= 0; --ry) {
                    if (world.func_175623_d((BlockPos)pos.func_181079_c(rx, ry, rz))) {
                        while (ry > 0 && world.func_175623_d((BlockPos)pos.func_181079_c(rx, ry - 1, rz))) {
                            --ry;
                        }
                        final double yWeight = ry + 0.5 - loc.field_72448_b * yFactor;
                        final double rPosWeight = xWeight * xWeight + yWeight * yWeight + zWeight * zWeight;
                        if ((spotWeight < 0.0 || rPosWeight < spotWeight) && predicate.test((BlockPos)pos)) {
                            spotWeight = rPosWeight;
                            spot = pos.func_185334_h();
                        }
                    }
                }
            }
        }
        return spot;
    }
    
    private static double getYFactor(final ServerWorld world) {
        return world.func_234923_W_().func_240901_a_().equals((Object)World.field_234918_g_.func_240901_a_()) ? 2.0 : 0.5;
    }
    
    private static void cachePortalCoords(final ServerWorld world, final Vector3d loc, final BlockPos pos) {
        final int x = MathHelper.func_76128_c(loc.field_72450_a);
        final int z = MathHelper.func_76128_c(loc.field_72449_c);
        TFTeleporter.destinationCoordinateCache.putIfAbsent(world.func_234923_W_().func_240901_a_(), Maps.newHashMapWithExpectedSize(4096));
        TFTeleporter.destinationCoordinateCache.get(world.func_234923_W_().func_240901_a_()).put(new ColumnPos(x, z), new PortalPosition(pos, world.func_82737_E()));
    }
    
    private static boolean isIdealForPortal(final ServerWorld world, final BlockPos pos) {
        for (int potentialZ = 0; potentialZ < 4; ++potentialZ) {
            for (int potentialX = 0; potentialX < 4; ++potentialX) {
                for (int potentialY = 0; potentialY < 4; ++potentialY) {
                    final BlockPos tPos = pos.func_177982_a(potentialX - 1, potentialY, potentialZ - 1);
                    final Material material = world.func_180495_p(tPos).func_185904_a();
                    if ((potentialY == 0 && material != Material.field_151577_b) || (potentialY >= 1 && !material.func_76222_j())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static BlockPos makePortalAt(final World world, BlockPos pos) {
        if (pos.func_177956_o() < 30) {
            pos = new BlockPos(pos.func_177958_n(), 30, pos.func_177952_p());
        }
        else if (pos.func_177956_o() > 118) {
            pos = new BlockPos(pos.func_177958_n(), 118, pos.func_177952_p());
        }
        final BlockState grass = Blocks.field_196658_i.func_176223_P();
        world.func_175656_a(pos.func_177976_e().func_177978_c(), grass);
        world.func_175656_a(pos.func_177978_c(), grass);
        world.func_175656_a(pos.func_177974_f().func_177978_c(), grass);
        world.func_175656_a(pos.func_177965_g(2).func_177978_c(), grass);
        world.func_175656_a(pos.func_177976_e(), grass);
        world.func_175656_a(pos.func_177965_g(2), grass);
        world.func_175656_a(pos.func_177976_e().func_177968_d(), grass);
        world.func_175656_a(pos.func_177965_g(2).func_177968_d(), grass);
        world.func_175656_a(pos.func_177976_e().func_177970_e(2), grass);
        world.func_175656_a(pos.func_177970_e(2), grass);
        world.func_175656_a(pos.func_177974_f().func_177970_e(2), grass);
        world.func_175656_a(pos.func_177965_g(2).func_177970_e(2), grass);
        final BlockState dirt = Blocks.field_150346_d.func_176223_P();
        world.func_175656_a(pos.func_177977_b(), dirt);
        world.func_175656_a(pos.func_177974_f().func_177977_b(), dirt);
        world.func_175656_a(pos.func_177968_d().func_177977_b(), dirt);
        world.func_175656_a(pos.func_177974_f().func_177968_d().func_177977_b(), dirt);
        final BlockState portal = (BlockState)((TFPortalBlock)TFBlocks.twilight_portal.get()).func_176223_P().func_206870_a((Property)TFPortalBlock.DISALLOW_RETURN, (Comparable)(TFTeleporter.locked || !(boolean)TFConfig.COMMON_CONFIG.shouldReturnPortalBeUsable.get()));
        world.func_180501_a(pos, portal, 2);
        world.func_180501_a(pos.func_177974_f(), portal, 2);
        world.func_180501_a(pos.func_177968_d(), portal, 2);
        world.func_180501_a(pos.func_177974_f().func_177968_d(), portal, 2);
        for (int dx = -1; dx <= 2; ++dx) {
            for (int dz = -1; dz <= 2; ++dz) {
                for (int dy = 1; dy <= 5; ++dy) {
                    world.func_217377_a(pos.func_177982_a(dx, dy, dz), false);
                }
            }
        }
        world.func_180501_a(pos.func_177976_e().func_177978_c().func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177978_c().func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177974_f().func_177978_c().func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177965_g(2).func_177978_c().func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177976_e().func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177965_g(2).func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177976_e().func_177968_d().func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177965_g(2).func_177968_d().func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177976_e().func_177970_e(2).func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177970_e(2).func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177974_f().func_177970_e(2).func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177965_g(2).func_177970_e(2).func_177984_a(), randNatureBlock(world.field_73012_v), 2);
        return pos;
    }
    
    private static BlockState randNatureBlock(final Random random) {
        final Block[] blocks = { Blocks.field_150338_P, Blocks.field_150337_Q, Blocks.field_150349_c, Blocks.field_196606_bd, Blocks.field_196605_bc };
        return blocks[random.nextInt(blocks.length)].func_176223_P();
    }
    
    private static boolean isOkayForPortal(final ServerWorld world, final BlockPos pos) {
        for (int potentialZ = 0; potentialZ < 4; ++potentialZ) {
            for (int potentialX = 0; potentialX < 4; ++potentialX) {
                for (int potentialY = 0; potentialY < 4; ++potentialY) {
                    final BlockPos tPos = pos.func_177982_a(potentialX - 1, potentialY, potentialZ - 1);
                    final Material material = world.func_180495_p(tPos).func_185904_a();
                    if ((potentialY == 0 && !material.func_76220_a() && !material.func_76224_d()) || (potentialY >= 1 && !material.func_76222_j())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static PortalInfo makePortalInfo(final Entity entity, final double x, final double y, final double z) {
        return makePortalInfo(entity, new Vector3d(x, y, z));
    }
    
    private static PortalInfo makePortalInfo(final Entity entity, final Vector3d pos) {
        return new PortalInfo(pos, Vector3d.field_186680_a, entity.field_70177_z, entity.field_70125_A);
    }
    
    public Entity placeEntity(final Entity entity, final ServerWorld currentWorld, final ServerWorld destWorld, final float yaw, final Function<Boolean, Entity> repositionEntity) {
        entity.field_70143_R = 0.0f;
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
