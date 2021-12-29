// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraftforge.fmllegacy.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import twilightforest.network.ChangeBiomePacket;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.core.Vec3i;
import twilightforest.util.WorldUtil;
import net.minecraft.resources.ResourceKey;
import twilightforest.world.registration.biomes.BiomeKeys;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TransLogCoreBlock extends SpecialMagicLogBlock
{
    public TransLogCoreBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Override
    void performTreeEffect(final Level world, final BlockPos pos, final Random rand) {
        final int WIDTH_BITS = (int)Math.round(Math.log(16.0) / Math.log(2.0)) - 2;
        final int HEIGHT_BITS = (int)Math.round(Math.log(256.0) / Math.log(2.0)) - 2;
        final int HORIZONTAL_MASK = (1 << WIDTH_BITS) - 1;
        final int VERTICAL_MASK = (1 << HEIGHT_BITS) - 1;
        final Biome targetBiome = (Biome)world.m_5962_().m_175515_(Registry.f_122885_).m_6246_((ResourceKey)BiomeKeys.ENCHANTED_FOREST);
        for (int i = 0; i < 16; ++i) {
            final BlockPos dPos = WorldUtil.randomOffset(rand, pos, 16, 0, 16);
            if (dPos.m_123331_((Vec3i)pos) <= 256.0) {
                final Biome biomeAt = world.m_46857_(dPos);
                if (biomeAt != targetBiome) {
                    final LevelChunk chunkAt = world.m_6325_(dPos.m_123341_() >> 4, dPos.m_123343_() >> 4);
                    final int x = dPos.m_123341_() >> 2 & HORIZONTAL_MASK;
                    final int z = dPos.m_123343_() >> 2 & HORIZONTAL_MASK;
                    if (chunkAt.m_6221_().f_62112_[z << WIDTH_BITS | x] != targetBiome) {
                        for (int dy = 0; dy < 255; dy += 4) {
                            final int y = Mth.m_14045_(dy >> 2, 0, VERTICAL_MASK);
                            chunkAt.m_6221_().f_62112_[y << WIDTH_BITS + WIDTH_BITS | z << WIDTH_BITS | x] = targetBiome;
                        }
                        if (world instanceof ServerLevel) {
                            this.sendChangedBiome(chunkAt, dPos, targetBiome);
                            break;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    private void sendChangedBiome(final LevelChunk chunk, final BlockPos pos, final Biome biome) {
        final ChangeBiomePacket message = new ChangeBiomePacket(pos, biome.getRegistryName());
        TFPacketHandler.CHANNEL.send(PacketDistributor.TRACKING_CHUNK.with(() -> chunk), (Object)message);
    }
    
    @Override
    protected void playSound(final Level level, final BlockPos pos, final Random rand) {
        level.m_5594_((Player)null, pos, TFSounds.TRANSFORMATION_CORE, SoundSource.BLOCKS, 0.1f, rand.nextFloat() * 2.0f);
    }
}
