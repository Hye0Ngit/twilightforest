// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class ChangeBiomePacket
{
    private final BlockPos pos;
    private final ResourceLocation biomeId;
    
    public ChangeBiomePacket(final BlockPos pos, final ResourceLocation id) {
        this.pos = pos;
        this.biomeId = id;
    }
    
    public ChangeBiomePacket(final PacketBuffer buf) {
        this.pos = new BlockPos(buf.readInt(), 0, buf.readInt());
        this.biomeId = buf.func_192575_l();
    }
    
    public void encode(final PacketBuffer buf) {
        buf.writeInt(this.pos.func_177958_n());
        buf.writeInt(this.pos.func_177952_p());
        buf.func_192572_a(this.biomeId);
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
                    final ClientWorld world = Minecraft.func_71410_x().field_71441_e;
                    final Chunk chunkAt = (Chunk)world.func_217349_x(message.pos);
                    final Biome targetBiome = (Biome)world.func_241828_r().func_243612_b(Registry.field_239720_u_).func_82594_a(message.biomeId);
                    for (int dy = 0; dy < 255; dy += 4) {
                        final int x = message.pos.func_177958_n() >> 2 & HORIZONTAL_MASK;
                        final int y = MathHelper.func_76125_a(dy >> 2, 0, VERTICAL_MASK);
                        final int z = message.pos.func_177952_p() >> 2 & HORIZONTAL_MASK;
                        chunkAt.func_225549_i_().field_227054_f_[y << WIDTH_BITS + WIDTH_BITS | z << WIDTH_BITS | x] = targetBiome;
                    }
                    world.func_228323_e_(message.pos.func_177958_n() >> 4, message.pos.func_177952_p() >> 4);
                    for (int k = 0; k < 16; ++k) {
                        world.func_217427_b(message.pos.func_177958_n() >> 4, k, message.pos.func_177952_p() >> 4);
                    }
                }
            });
            return true;
        }
    }
}
