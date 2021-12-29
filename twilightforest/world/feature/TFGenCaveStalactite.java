// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import java.util.ArrayList;
import net.minecraft.world.gen.feature.IFeatureConfig;
import java.util.function.BiConsumer;
import twilightforest.IMCHandler;
import twilightforest.TwilightForestMod;
import twilightforest.TFConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.IWorld;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.WeightedRandom;
import java.util.Random;
import com.mojang.serialization.Codec;
import java.util.List;
import twilightforest.world.feature.config.CaveStalactiteConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenCaveStalactite extends Feature<CaveStalactiteConfig>
{
    private static final List<StalactiteEntry> largeHillStalactites;
    private static final List<StalactiteEntry> mediumHillStalactites;
    private static final List<StalactiteEntry> smallHillStalactites;
    
    public TFGenCaveStalactite(final Codec<CaveStalactiteConfig> configIn) {
        super((Codec)configIn);
    }
    
    public static CaveStalactiteConfig makeRandomOreStalactite(final Random rand, final int hillSize) {
        if (hillSize >= 3 || (hillSize >= 2 && rand.nextInt(5) == 0)) {
            return ((StalactiteEntry)WeightedRandom.func_76271_a(rand, (List)TFGenCaveStalactite.largeHillStalactites)).stalactite;
        }
        if (hillSize >= 2 || (hillSize >= 1 && rand.nextInt(5) == 0)) {
            return ((StalactiteEntry)WeightedRandom.func_76271_a(rand, (List)TFGenCaveStalactite.mediumHillStalactites)).stalactite;
        }
        return ((StalactiteEntry)WeightedRandom.func_76271_a(rand, (List)TFGenCaveStalactite.smallHillStalactites)).stalactite;
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random random, final BlockPos pos, final CaveStalactiteConfig config) {
        int ceiling = Integer.MAX_VALUE;
        int floor = -1;
        final BlockPos.Mutable iterPos = new BlockPos.Mutable(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        int ty = pos.func_177956_o();
        while (ty < 256) {
            iterPos.func_185336_p(ty);
            final Material m = world.func_180495_p((BlockPos)iterPos).func_185904_a();
            if (m == Material.field_151579_a) {
                ++ty;
            }
            else {
                if (m != Material.field_151578_c && m != Material.field_151576_e) {
                    return false;
                }
                ceiling = ty;
                break;
            }
        }
        if (ceiling == Integer.MAX_VALUE) {
            return false;
        }
        ty = pos.func_177956_o();
        while (ty > 4) {
            iterPos.func_185336_p(ty);
            final Material m = world.func_180495_p((BlockPos)iterPos).func_185904_a();
            if (m == Material.field_151579_a) {
                --ty;
            }
            else {
                if (m != Material.field_151578_c && m != Material.field_151576_e && !config.hang && m != Material.field_151586_h && !config.hang && m != Material.field_151587_i) {
                    return false;
                }
                floor = ty;
                break;
            }
        }
        int length = (int)((ceiling - floor) * config.sizeFactor * random.nextFloat());
        if (config.maxLength > -1 && length > config.maxLength) {
            length = config.maxLength;
        }
        return (config.minHeight <= -1 || ceiling - floor - length >= config.minHeight) && this.makeSpike((IWorld)world, random, new BlockPos(pos.func_177958_n(), config.hang ? ceiling : floor, pos.func_177952_p()), length, config);
    }
    
    public boolean makeSpike(final IWorld world, final Random random, final BlockPos pos, final int maxLength, final CaveStalactiteConfig config) {
        for (int diameter = (int)(maxLength / 4.5), dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                final int absx = Math.abs(dx);
                final int absz = Math.abs(dz);
                final int dist = (int)(Math.max(absx, absz) + Math.min(absx, absz) * 0.5);
                int spikeLength = 0;
                if (dist == 0) {
                    spikeLength = maxLength;
                }
                if (dist > 0) {
                    spikeLength = random.nextInt((int)(maxLength / (dist + 0.25)));
                }
                final int dir = config.hang ? -1 : 1;
                if (!world.func_180495_p(pos.func_177982_a(dx, -dir, dz)).func_185904_a().func_76220_a()) {
                    spikeLength = 0;
                }
                for (int dy = 0; dy != spikeLength * dir; dy += dir) {
                    this.func_230367_a_((IWorldWriter)world, pos.func_177982_a(dx, dy, dz), config.blockState);
                }
            }
        }
        return true;
    }
    
    public static void addStalactite(final int hillSize, final BlockState blockState, final float size, final int maxLength, final int minHeight, final int itemWeight) {
        if (itemWeight > 0) {
            addStalactite(hillSize, new StalactiteEntry(blockState, size, maxLength, minHeight, itemWeight));
        }
    }
    
    private static void addStalactite(final int hillSize, final StalactiteEntry entry) {
        if (hillSize <= 1) {
            TFGenCaveStalactite.smallHillStalactites.add(entry);
        }
        if (hillSize <= 2) {
            TFGenCaveStalactite.mediumHillStalactites.add(entry);
        }
        TFGenCaveStalactite.largeHillStalactites.add(entry);
    }
    
    private static void addDefaultStalactites() {
        addStalactite(3, Blocks.field_150482_ag.func_176223_P(), 0.5f, 4, 16, 30);
        addStalactite(3, Blocks.field_150369_x.func_176223_P(), 0.8f, 8, 1, 30);
        addStalactite(3, Blocks.field_150412_bA.func_176223_P(), 0.5f, 3, 12, 15);
        addStalactite(2, Blocks.field_150352_o.func_176223_P(), 0.6f, 6, 1, 20);
        addStalactite(2, Blocks.field_150450_ax.func_176223_P(), 0.8f, 8, 1, 40);
        addStalactite(1, Blocks.field_150366_p.func_176223_P(), 0.7f, 8, 1, 24);
        addStalactite(1, Blocks.field_150365_q.func_176223_P(), 0.8f, 12, 1, 24);
        addStalactite(1, Blocks.field_150426_aN.func_176223_P(), 0.5f, 8, 1, 12);
    }
    
    public static void loadStalactites() {
        TFGenCaveStalactite.smallHillStalactites.clear();
        TFGenCaveStalactite.mediumHillStalactites.clear();
        TFGenCaveStalactite.largeHillStalactites.clear();
        TFConfig.COMMON_CONFIG.DIMENSION.hollowHillStalactites.load();
        if (TFConfig.COMMON_CONFIG.DIMENSION.hollowHillStalactites.useConfigOnly.get()) {
            if (TFGenCaveStalactite.smallHillStalactites.isEmpty()) {
                TwilightForestMod.LOGGER.info("Not all hollow hills are populated with the config, adding fallback");
                addStalactite(1, Blocks.field_150348_b.func_176223_P(), 0.7f, 8, 1, 1);
            }
            return;
        }
        addDefaultStalactites();
        IMCHandler.getStalactites().forEach((BiConsumer)TFGenCaveStalactite::addStalactite);
    }
    
    static {
        largeHillStalactites = new ArrayList<StalactiteEntry>();
        mediumHillStalactites = new ArrayList<StalactiteEntry>();
        smallHillStalactites = new ArrayList<StalactiteEntry>();
    }
    
    public static class StalactiteEntry extends WeightedRandom.Item
    {
        final CaveStalactiteConfig stalactite;
        
        StalactiteEntry(final CaveStalactiteConfig stalactite, final int itemWeight) {
            super(itemWeight);
            this.stalactite = stalactite;
        }
        
        public StalactiteEntry(final BlockState blockState, final float size, final int maxLength, final int minHeight, final int itemWeight) {
            this(new CaveStalactiteConfig(blockState, size, maxLength, minHeight, true), itemWeight);
        }
    }
}
