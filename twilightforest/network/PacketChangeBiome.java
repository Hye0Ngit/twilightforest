// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketChangeBiome implements IMessage
{
    private BlockPos pos;
    private byte biomeId;
    
    public PacketChangeBiome() {
    }
    
    public PacketChangeBiome(final BlockPos pos, final Biome biome) {
        this.pos = pos;
        this.biomeId = (byte)Biome.func_185362_a(biome);
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.pos = new BlockPos(buf.readInt(), 0, buf.readInt());
        this.biomeId = buf.readByte();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.pos.func_177958_n());
        buf.writeInt(this.pos.func_177952_p());
        buf.writeByte((int)this.biomeId);
    }
    
    public static class Handler implements IMessageHandler<PacketChangeBiome, IMessage>
    {
        public IMessage onMessage(final PacketChangeBiome message, final MessageContext ctx) {
            Minecraft.func_71410_x().func_152344_a((Runnable)new Runnable() {
                @Override
                public void run() {
                    final World world = (World)Minecraft.func_71410_x().field_71441_e;
                    final Chunk chunkAt = world.func_175726_f(message.pos);
                    chunkAt.func_76605_m()[(message.pos.func_177952_p() & 0xF) << 4 | (message.pos.func_177958_n() & 0xF)] = message.biomeId;
                    world.func_175704_b(message.pos, message.pos.func_177981_b(255));
                }
            });
            return null;
        }
    }
}
