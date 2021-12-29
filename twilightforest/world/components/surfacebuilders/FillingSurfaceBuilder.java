// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.surfacebuilders;

import com.mojang.datafixers.kinds.Applicative;
import java.util.function.Function;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkAccess;
import java.util.Random;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;

public class FillingSurfaceBuilder extends SurfaceBuilder<FillingSurfaceBuilderConfig>
{
    public FillingSurfaceBuilder(final Codec<FillingSurfaceBuilderConfig> config) {
        super((Codec)config);
    }
    
    public void apply(final Random random, final ChunkAccess chunkIn, final Biome biomeIn, final int x, final int z, final int startHeight, final double noise, final BlockState defaultBlock, final BlockState defaultFluid, final int seaLevel, final int minSurfaceLevel, final long seed, final FillingSurfaceBuilderConfig config) {
        final BlockState topState = config.m_6743_();
        final BlockState midState = config.m_6744_();
        final BlockState underWaterState = config.m_142434_();
        final BlockState filler = config.underFiller;
        final BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        final int noiseHeight = (int)(noise / 3.0 + 3.0 + random.nextDouble() * 0.25);
        if (noiseHeight == 0) {
            boolean flag = false;
            for (int y = startHeight; y >= chunkIn.m_141937_(); --y) {
                mutablePos.m_122178_(x, y, z);
                final BlockState priorState = chunkIn.m_8055_((BlockPos)mutablePos);
                if (priorState.m_60795_()) {
                    flag = false;
                }
                else if (priorState.m_60713_(defaultBlock.m_60734_())) {
                    if (!flag) {
                        BlockState newState;
                        if (y >= seaLevel) {
                            newState = Blocks.f_50016_.m_49966_();
                        }
                        else if (y == seaLevel - 1) {
                            newState = ((biomeIn.m_47505_((BlockPos)mutablePos) < 0.15f) ? Blocks.f_50126_.m_49966_() : defaultFluid);
                        }
                        else if (y >= seaLevel - (7 + noiseHeight)) {
                            newState = filler;
                        }
                        else {
                            newState = underWaterState;
                        }
                        chunkIn.m_6978_((BlockPos)mutablePos, newState, false);
                    }
                    flag = true;
                }
            }
        }
        else {
            BlockState newMidState = midState;
            int heightFromSurface = -1;
            for (int y2 = startHeight; y2 >= minSurfaceLevel; --y2) {
                mutablePos.m_122178_(x, y2, z);
                final BlockState priorState2 = chunkIn.m_8055_((BlockPos)mutablePos);
                if (priorState2.m_60795_()) {
                    heightFromSurface = -1;
                }
                else if (priorState2.m_60713_(defaultBlock.m_60734_())) {
                    if (heightFromSurface == -1) {
                        heightFromSurface = noiseHeight;
                        BlockState newTopState;
                        if (y2 >= seaLevel + 2) {
                            newTopState = topState;
                        }
                        else if (y2 >= seaLevel - 1) {
                            newMidState = midState;
                            newTopState = topState;
                        }
                        else if (y2 >= seaLevel - 4) {
                            newMidState = midState;
                            newTopState = midState;
                        }
                        else if (y2 >= seaLevel - (7 + noiseHeight)) {
                            newTopState = newMidState;
                        }
                        else {
                            newMidState = filler;
                            newTopState = underWaterState;
                        }
                        chunkIn.m_6978_((BlockPos)mutablePos, newTopState, false);
                    }
                    else if (heightFromSurface > 0) {
                        --heightFromSurface;
                        chunkIn.m_6978_((BlockPos)mutablePos, newMidState, false);
                    }
                    else {
                        chunkIn.m_6978_((BlockPos)mutablePos, filler, false);
                    }
                }
            }
        }
    }
    
    public static class FillingSurfaceBuilderConfig extends SurfaceBuilderBaseConfiguration
    {
        public static final Codec<FillingSurfaceBuilderConfig> CODEC;
        private final BlockState underFiller;
        
        public FillingSurfaceBuilderConfig(final BlockState topMaterial, final BlockState underMaterial, final BlockState underwaterMaterial, final BlockState underFiller) {
            super(topMaterial, underMaterial, underwaterMaterial);
            this.underFiller = underFiller;
        }
        
        static {
            CODEC = RecordCodecBuilder.create(instance -> instance.group((App)BlockState.f_61039_.fieldOf("top_material").forGetter((Function)SurfaceBuilderBaseConfiguration::m_6743_), (App)BlockState.f_61039_.fieldOf("under_material").forGetter((Function)SurfaceBuilderBaseConfiguration::m_6744_), (App)BlockState.f_61039_.fieldOf("underwater_material").forGetter((Function)SurfaceBuilderBaseConfiguration::m_142434_), (App)BlockState.f_61039_.fieldOf("ground_filler").forGetter(conf -> conf.underFiller)).apply((Applicative)instance, FillingSurfaceBuilderConfig::new));
        }
    }
}
