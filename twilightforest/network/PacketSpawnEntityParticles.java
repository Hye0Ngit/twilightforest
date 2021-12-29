// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import twilightforest.TwilightForestMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import java.util.Random;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import twilightforest.client.particle.TFParticleType;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketSpawnEntityParticles implements IMessage
{
    private TFParticleType type;
    private double x;
    private double y;
    private double z;
    private float width;
    private float height;
    private int count;
    
    public PacketSpawnEntityParticles() {
    }
    
    public PacketSpawnEntityParticles(final TFParticleType type, final Entity entity, final int count) {
        this.type = type;
        this.x = entity.field_70165_t;
        this.y = entity.field_70163_u;
        this.z = entity.field_70161_v;
        this.width = entity.field_70130_N;
        this.height = entity.field_70131_O;
        this.count = count;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.type = TFParticleType.values()[buf.readInt()];
        this.x = buf.readDouble();
        this.y = buf.readDouble();
        this.z = buf.readDouble();
        this.width = buf.readFloat();
        this.height = buf.readFloat();
        this.count = buf.readInt();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.type.ordinal());
        buf.writeDouble(this.x);
        buf.writeDouble(this.y);
        buf.writeDouble(this.z);
        buf.writeFloat(this.width);
        buf.writeFloat(this.height);
        buf.writeInt(this.count);
    }
    
    public static class Handler implements IMessageHandler<PacketSpawnEntityParticles, IMessage>
    {
        private final Random random;
        
        public Handler() {
            this.random = new Random();
        }
        
        public IMessage onMessage(final PacketSpawnEntityParticles message, final MessageContext ctx) {
            Minecraft.func_71410_x().func_152344_a(() -> {
                for (int i = 0; i < message.count; ++i) {
                    final double x = message.x + this.random.nextFloat() * message.width * 2.0 - message.width;
                    final double y = message.y + this.random.nextFloat() * message.height;
                    final double z = message.z + this.random.nextFloat() * message.width * 2.0 - message.width;
                    TwilightForestMod.proxy.spawnParticle(message.type, x, y, z, 0.0, 0.0, 0.0);
                }
                return;
            });
            return null;
        }
    }
}
