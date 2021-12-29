// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.Mth;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ChangeBiomePacket
{
    private final BlockPos pos;
    private final ResourceLocation biomeId;
    
    public ChangeBiomePacket(final BlockPos pos, final ResourceLocation id) {
        this.pos = pos;
        this.biomeId = id;
    }
    
    public ChangeBiomePacket(final FriendlyByteBuf buf) {
        this.pos = new BlockPos(buf.readInt(), 0, buf.readInt());
        this.biomeId = buf.m_130281_();
    }
    
    public void encode(final FriendlyByteBuf buf) {
        buf.writeInt(this.pos.m_123341_());
        buf.writeInt(this.pos.m_123343_());
        buf.m_130085_(this.biomeId);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final ChangeBiomePacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final int WIDTH_BITS = (int)Math.round(Math.log(16.0) / Math.log(2.0)) - 2;
                    final int HEIGHT_BITS = (int)Math.round(Math.log(256.0) / Math.log(2.0)) - 2;
                    final int HORIZONTAL_MASK = (1 << WIDTH_BITS) - 1;
                    final int VERTICAL_MASK = (1 << HEIGHT_BITS) - 1;
                    final ClientLevel world = Minecraft.m_91087_().f_91073_;
                    final LevelChunk chunkAt = (LevelChunk)world.m_46865_(message.pos);
                    final Biome targetBiome = (Biome)world.m_5962_().m_175515_(Registry.f_122885_).m_7745_(message.biomeId);
                    for (int dy = 0; dy < 255; dy += 4) {
                        final int x = message.pos.m_123341_() >> 2 & HORIZONTAL_MASK;
                        final int y = Mth.m_14045_(dy >> 2, 0, VERTICAL_MASK);
                        final int z = message.pos.m_123343_() >> 2 & HORIZONTAL_MASK;
                        chunkAt.m_6221_().f_62112_[y << WIDTH_BITS + WIDTH_BITS | z << WIDTH_BITS | x] = targetBiome;
                    }
                    world.m_6325_(message.pos.m_123341_() >> 4, message.pos.m_123343_() >> 4);
                    for (int k = 0; k < 16; ++k) {
                        world.m_104793_(message.pos.m_123341_() >> 4, k, message.pos.m_123343_() >> 4);
                    }
                }
            });
            return true;
        }
    }
}
