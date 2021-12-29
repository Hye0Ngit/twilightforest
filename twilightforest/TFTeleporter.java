// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFPortal;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import java.util.function.Predicate;
import java.util.HashSet;
import java.util.Set;
import twilightforest.block.TFBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import twilightforest.world.ChunkGeneratorTFBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import twilightforest.world.TFWorld;
import net.minecraft.entity.Entity;
import java.util.Iterator;
import net.minecraft.world.WorldServer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Teleporter;

public class TFTeleporter extends Teleporter
{
    public static TFTeleporter getTeleporterForDim(final MinecraftServer server, final int dim) {
        final WorldServer ws = server.func_71218_a(dim);
        for (final Teleporter t : ws.customTeleporters) {
            if (t instanceof TFTeleporter) {
                return (TFTeleporter)t;
            }
        }
        final TFTeleporter tp = new TFTeleporter(ws);
        ws.customTeleporters.add(tp);
        return tp;
    }
    
    private TFTeleporter(final WorldServer dest) {
        super(dest);
    }
    
    public void func_180266_a(final Entity entity, final float facing) {
        if (!this.func_180620_b(entity, facing)) {
            this.moveToSafeCoords(entity);
            this.func_85188_a(entity);
            this.func_180620_b(entity, facing);
        }
    }
    
    private void moveToSafeCoords(final Entity entity) {
        final boolean checkProgression = TFWorld.isProgressionEnforced((World)this.field_85192_a);
        final BlockPos pos = new BlockPos(entity);
        if (this.isSafeAround(pos, entity, checkProgression)) {
            return;
        }
        TwilightForestMod.LOGGER.debug("Portal destination looks unsafe, rerouting!");
        BlockPos safeCoords = this.findSafeCoords(200, pos, entity, checkProgression);
        if (safeCoords != null) {
            entity.func_70012_b((double)safeCoords.func_177958_n(), entity.field_70163_u, (double)safeCoords.func_177952_p(), 90.0f, 0.0f);
            TwilightForestMod.LOGGER.debug("Safely rerouted!");
            return;
        }
        TwilightForestMod.LOGGER.info("Did not find a safe portal spot at first try, trying again with longer range.");
        safeCoords = this.findSafeCoords(400, pos, entity, checkProgression);
        if (safeCoords != null) {
            entity.func_70012_b((double)safeCoords.func_177958_n(), entity.field_70163_u, (double)safeCoords.func_177952_p(), 90.0f, 0.0f);
            TwilightForestMod.LOGGER.info("Safely rerouted to long range portal.  Return trip not guaranteed.");
            return;
        }
        TwilightForestMod.LOGGER.warn("Still did not find a safe portal spot.");
    }
    
    @Nullable
    private BlockPos findSafeCoords(final int range, final BlockPos pos, final Entity entity, final boolean checkProgression) {
        for (int attempts = range / 8, i = 0; i < attempts; ++i) {
            final BlockPos dPos = new BlockPos(pos.func_177958_n() + this.field_77187_a.nextInt(range) - this.field_77187_a.nextInt(range), 100, pos.func_177952_p() + this.field_77187_a.nextInt(range) - this.field_77187_a.nextInt(range));
            if (this.isSafeAround(dPos, entity, checkProgression)) {
                return dPos;
            }
        }
        return null;
    }
    
    public final boolean isSafeAround(final BlockPos pos, final Entity entity, final boolean checkProgression) {
        if (!this.isSafe(pos, entity, checkProgression)) {
            return false;
        }
        for (final EnumFacing facing : EnumFacing.Plane.HORIZONTAL) {
            if (!this.isSafe(pos.func_177967_a(facing, 16), entity, checkProgression)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isSafe(final BlockPos pos, final Entity entity, final boolean checkProgression) {
        return this.checkPos(pos) && (!checkProgression || this.checkBiome(pos, entity)) && this.checkStructure(pos);
    }
    
    private boolean checkPos(final BlockPos pos) {
        return this.field_85192_a.func_175723_af().func_177746_a(pos);
    }
    
    private boolean checkStructure(final BlockPos pos) {
        final ChunkGeneratorTFBase generator = TFWorld.getChunkGenerator((World)this.field_85192_a);
        if (generator != null) {
            if (!this.field_85192_a.func_175667_e(pos)) {
                generator.func_180514_a(null, pos.func_177958_n() >> 4, pos.func_177952_p() >> 4);
            }
            return !generator.isBlockInFullStructure(pos.func_177958_n(), pos.func_177952_p());
        }
        return true;
    }
    
    private boolean checkBiome(final BlockPos pos, final Entity entity) {
        return TFWorld.isBiomeSafeFor(this.field_85192_a.func_180494_b(pos), entity);
    }
    
    public boolean func_180620_b(final Entity entity, final float rotationYaw) {
        int i = 200;
        double d0 = -1.0;
        final int j = MathHelper.func_76128_c(entity.field_70165_t);
        final int k = MathHelper.func_76128_c(entity.field_70161_v);
        boolean flag = true;
        BlockPos blockpos = BlockPos.field_177992_a;
        final long l = ChunkPos.func_77272_a(j, k);
        if (this.field_85191_c.containsKey(l)) {
            final Teleporter.PortalPosition portalPosition = (Teleporter.PortalPosition)this.field_85191_c.get(l);
            d0 = 0.0;
            blockpos = (BlockPos)portalPosition;
            portalPosition.field_85087_d = this.field_85192_a.func_82737_E();
            flag = false;
        }
        else {
            final BlockPos blockpos2 = new BlockPos(entity);
            for (int i2 = -i; i2 <= i; ++i2) {
                for (int j2 = -i; j2 <= i; ++j2) {
                    if (this.field_85192_a.func_175723_af().func_177746_a(blockpos2.func_177982_a(i2, 0, j2))) {
                        final ChunkPos chunkPos = new ChunkPos(blockpos2.func_177982_a(i2, 0, j2));
                        if (this.field_85192_a.func_190526_b(chunkPos.field_77276_a, chunkPos.field_77275_b)) {
                            final Chunk chunk = this.field_85192_a.func_72964_e(chunkPos.field_77276_a, chunkPos.field_77275_b);
                            BlockPos blockpos4;
                            for (BlockPos blockpos3 = blockpos2.func_177982_a(i2, this.getScanHeight(blockpos2) - blockpos2.func_177956_o(), j2); blockpos3.func_177956_o() >= 0; blockpos3 = blockpos4) {
                                blockpos4 = blockpos3.func_177977_b();
                                if (d0 < 0.0 || blockpos3.func_177951_i((Vec3i)blockpos2) < d0) {
                                    if (isPortal(chunk.func_177435_g(blockpos3))) {
                                        for (blockpos4 = blockpos3.func_177977_b(); isPortal(chunk.func_177435_g(blockpos4)); blockpos4 = blockpos4.func_177977_b()) {
                                            blockpos3 = blockpos4;
                                        }
                                        final double d2 = blockpos3.func_177951_i((Vec3i)blockpos2);
                                        if (d0 < 0.0 || d2 < d0) {
                                            d0 = d2;
                                            blockpos = blockpos3;
                                            i = MathHelper.func_76123_f(MathHelper.func_76133_a(d2));
                                        }
                                    }
                                }
                            }
                            if (!this.field_85192_a.func_184164_w().func_152621_a(chunkPos.field_77276_a, chunkPos.field_77275_b)) {
                                this.field_85192_a.func_72863_F().func_189549_a(chunk);
                            }
                        }
                    }
                }
            }
        }
        if (d0 >= 0.0) {
            if (flag) {
                this.field_85191_c.put(l, (Object)new Teleporter.PortalPosition((Teleporter)this, blockpos, this.field_85192_a.func_82737_E()));
            }
            final BlockPos[] portalBorder = this.getBoundaryPositions(blockpos).toArray(new BlockPos[0]);
            final BlockPos borderPos = portalBorder[this.field_77187_a.nextInt(portalBorder.length)];
            final double portalX = borderPos.func_177958_n() + 0.5;
            final double portalY = borderPos.func_177956_o() + 1.0;
            final double portalZ = borderPos.func_177952_p() + 0.5;
            final double field_70159_w = 0.0;
            entity.field_70179_y = field_70159_w;
            entity.field_70181_x = field_70159_w;
            entity.field_70159_w = field_70159_w;
            if (entity instanceof EntityPlayerMP) {
                ((EntityPlayerMP)entity).field_71135_a.func_147364_a(portalX, portalY, portalZ, entity.field_70177_z, entity.field_70125_A);
            }
            else {
                entity.func_70012_b(portalX, portalY, portalZ, entity.field_70177_z, entity.field_70125_A);
            }
            return true;
        }
        return false;
    }
    
    private int getScanHeight(final BlockPos pos) {
        return this.getScanHeight(pos.func_177958_n(), pos.func_177952_p());
    }
    
    private int getScanHeight(final int x, final int z) {
        final int worldHeight = this.field_85192_a.func_72940_L() - 1;
        final int chunkHeight = this.field_85192_a.func_72964_e(x >> 4, z >> 4).func_76625_h() + 15;
        return Math.min(worldHeight, chunkHeight);
    }
    
    private static boolean isPortal(final IBlockState state) {
        return state.func_177230_c() == TFBlocks.twilight_portal;
    }
    
    private Set<BlockPos> getBoundaryPositions(final BlockPos start) {
        final Set<BlockPos> result = new HashSet<BlockPos>();
        final Set<BlockPos> checked = new HashSet<BlockPos>();
        checked.add(start);
        this.checkAdjacent(start, checked, result);
        return result;
    }
    
    private void checkAdjacent(final BlockPos pos, final Set<BlockPos> checked, final Set<BlockPos> result) {
        for (final EnumFacing facing : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos offset = pos.func_177972_a(facing);
            if (!checked.add(offset)) {
                continue;
            }
            if (this.isPortalAt(offset)) {
                this.checkAdjacent(offset, checked, result);
            }
            else {
                result.add(offset);
            }
        }
    }
    
    private boolean isPortalAt(final BlockPos pos) {
        return isPortal(this.field_85192_a.func_180495_p(pos));
    }
    
    public boolean func_85188_a(final Entity entity) {
        this.loadSurroundingArea(entity);
        BlockPos spot = this.findPortalCoords(entity, this::isPortalAt);
        final String name = entity.func_70005_c_();
        if (spot != null) {
            TwilightForestMod.LOGGER.debug("Found existing portal for {} at {}", (Object)name, (Object)spot);
            this.cachePortalCoords(entity, spot);
            return true;
        }
        spot = this.findPortalCoords(entity, this::isIdealForPortal);
        if (spot != null) {
            TwilightForestMod.LOGGER.debug("Found ideal portal spot for {} at {}", (Object)name, (Object)spot);
            this.cachePortalCoords(entity, this.makePortalAt((World)this.field_85192_a, spot));
            return true;
        }
        TwilightForestMod.LOGGER.debug("Did not find ideal portal spot, shooting for okay one for {}", (Object)name);
        spot = this.findPortalCoords(entity, this::isOkayForPortal);
        if (spot != null) {
            TwilightForestMod.LOGGER.debug("Found okay portal spot for {} at {}", (Object)name, (Object)spot);
            this.cachePortalCoords(entity, this.makePortalAt((World)this.field_85192_a, spot));
            return true;
        }
        TwilightForestMod.LOGGER.debug("Did not even find an okay portal spot, just making a random one for {}", (Object)name);
        final double yFactor = this.getYFactor();
        this.cachePortalCoords(entity, this.makePortalAt((World)this.field_85192_a, new BlockPos(entity.field_70165_t, entity.field_70163_u * yFactor - 1.0, entity.field_70161_v)));
        return false;
    }
    
    private void loadSurroundingArea(final Entity entity) {
        final int x = MathHelper.func_76128_c(entity.field_70165_t) >> 4;
        final int z = MathHelper.func_76128_c(entity.field_70161_v) >> 4;
        for (int dx = -2; dx <= 2; ++dx) {
            for (int dz = -2; dz <= 2; ++dz) {
                this.field_85192_a.func_72964_e(x + dx, z + dz);
            }
        }
    }
    
    private double getYFactor() {
        return (this.field_85192_a.field_73011_w.getDimension() == TFConfig.originDimension) ? 2.0 : 0.5;
    }
    
    @Nullable
    private BlockPos findPortalCoords(final Entity entity, final Predicate<BlockPos> predicate) {
        final double yFactor = this.getYFactor();
        final int entityX = MathHelper.func_76128_c(entity.field_70165_t);
        final int entityZ = MathHelper.func_76128_c(entity.field_70161_v);
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        double spotWeight = -1.0;
        BlockPos spot = null;
        for (int range = 16, rx = entityX - range; rx <= entityX + range; ++rx) {
            final double xWeight = rx + 0.5 - entity.field_70165_t;
            for (int rz = entityZ - range; rz <= entityZ + range; ++rz) {
                final double zWeight = rz + 0.5 - entity.field_70161_v;
                for (int ry = this.getScanHeight(rx, rz); ry >= 0; --ry) {
                    if (this.field_85192_a.func_175623_d((BlockPos)pos.func_181079_c(rx, ry, rz))) {
                        while (ry > 0 && this.field_85192_a.func_175623_d((BlockPos)pos.func_181079_c(rx, ry - 1, rz))) {
                            --ry;
                        }
                        final double yWeight = ry + 0.5 - entity.field_70163_u * yFactor;
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
    
    private boolean isIdealForPortal(final BlockPos pos) {
        for (int potentialZ = 0; potentialZ < 4; ++potentialZ) {
            for (int potentialX = 0; potentialX < 4; ++potentialX) {
                for (int potentialY = 0; potentialY < 4; ++potentialY) {
                    final BlockPos tPos = pos.func_177982_a(potentialX - 1, potentialY, potentialZ - 1);
                    final Material material = this.field_85192_a.func_180495_p(tPos).func_185904_a();
                    if ((potentialY == 0 && material != Material.field_151577_b) || (potentialY >= 1 && !material.func_76222_j())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean isOkayForPortal(final BlockPos pos) {
        for (int potentialZ = 0; potentialZ < 4; ++potentialZ) {
            for (int potentialX = 0; potentialX < 4; ++potentialX) {
                for (int potentialY = 0; potentialY < 4; ++potentialY) {
                    final BlockPos tPos = pos.func_177982_a(potentialX - 1, potentialY, potentialZ - 1);
                    final Material material = this.field_85192_a.func_180495_p(tPos).func_185904_a();
                    if ((potentialY == 0 && !material.func_76220_a() && !material.func_76224_d()) || (potentialY >= 1 && !material.func_76222_j())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private void cachePortalCoords(final Entity entity, final BlockPos pos) {
        final int x = MathHelper.func_76128_c(entity.field_70165_t);
        final int z = MathHelper.func_76128_c(entity.field_70161_v);
        this.field_85191_c.put(ChunkPos.func_77272_a(x, z), (Object)new Teleporter.PortalPosition((Teleporter)this, pos, this.field_85192_a.func_82737_E()));
    }
    
    private BlockPos makePortalAt(final World world, BlockPos pos) {
        if (pos.func_177956_o() < 30) {
            pos = new BlockPos(pos.func_177958_n(), 30, pos.func_177952_p());
        }
        else if (pos.func_177956_o() > 118) {
            pos = new BlockPos(pos.func_177958_n(), 118, pos.func_177952_p());
        }
        final IBlockState grass = Blocks.field_150349_c.func_176223_P();
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
        final IBlockState dirt = Blocks.field_150346_d.func_176223_P();
        world.func_175656_a(pos.func_177977_b(), dirt);
        world.func_175656_a(pos.func_177974_f().func_177977_b(), dirt);
        world.func_175656_a(pos.func_177968_d().func_177977_b(), dirt);
        world.func_175656_a(pos.func_177974_f().func_177968_d().func_177977_b(), dirt);
        final IBlockState portal = TFBlocks.twilight_portal.func_176223_P().func_177226_a((IProperty)BlockTFPortal.DISALLOW_RETURN, (Comparable)!TFConfig.shouldReturnPortalBeUsable);
        world.func_180501_a(pos, portal, 2);
        world.func_180501_a(pos.func_177974_f(), portal, 2);
        world.func_180501_a(pos.func_177968_d(), portal, 2);
        world.func_180501_a(pos.func_177974_f().func_177968_d(), portal, 2);
        for (int dx = -1; dx <= 2; ++dx) {
            for (int dz = -1; dz <= 2; ++dz) {
                for (int dy = 1; dy <= 5; ++dy) {
                    world.func_175698_g(pos.func_177982_a(dx, dy, dz));
                }
            }
        }
        world.func_180501_a(pos.func_177976_e().func_177978_c().func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177978_c().func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177974_f().func_177978_c().func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177965_g(2).func_177978_c().func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177976_e().func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177965_g(2).func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177976_e().func_177968_d().func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177965_g(2).func_177968_d().func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177976_e().func_177970_e(2).func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177970_e(2).func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177974_f().func_177970_e(2).func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        world.func_180501_a(pos.func_177965_g(2).func_177970_e(2).func_177984_a(), this.randNatureBlock(world.field_73012_v), 2);
        return pos;
    }
    
    private IBlockState randNatureBlock(final Random random) {
        final Block[] blocks = { (Block)Blocks.field_150338_P, (Block)Blocks.field_150337_Q, (Block)Blocks.field_150329_H, (Block)Blocks.field_150328_O, (Block)Blocks.field_150327_N };
        return blocks[random.nextInt(blocks.length)].func_176223_P();
    }
}
