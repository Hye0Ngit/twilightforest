// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.world.World;
import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketAnnihilateBlock implements IMessage
{
    private BlockPos pos;
    
    public PacketAnnihilateBlock() {
    }
    
    public PacketAnnihilateBlock(final BlockPos pos) {
        this.pos = pos;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.pos = BlockPos.func_177969_a(buf.readLong());
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeLong(this.pos.func_177986_g());
    }
    
    public static class Handler implements IMessageHandler<PacketAnnihilateBlock, IMessage>
    {
        public IMessage onMessage(final PacketAnnihilateBlock message, final MessageContext ctx) {
            Minecraft.func_71410_x().func_152344_a((Runnable)new Runnable() {
                @Override
                public void run() {
                    final World world = (World)Minecraft.func_71410_x().field_71441_e;
                    for (int dx = 0; dx < 4; ++dx) {
                        for (int dy = 0; dy < 4; ++dy) {
                            for (int dz = 0; dz < 4; ++dz) {
                                final double x = message.pos.func_177958_n() + (dx + 0.5) / 4.0;
                                final double y = message.pos.func_177956_o() + (dy + 0.5) / 4.0;
                                final double z = message.pos.func_177952_p() + (dz + 0.5) / 4.0;
                                final double vx = world.field_73012_v.nextGaussian() * 0.2;
                                final double vy = world.field_73012_v.nextGaussian() * 0.2;
                                final double vz = world.field_73012_v.nextGaussian() * 0.2;
                                TwilightForestMod.proxy.spawnParticle(TFParticleType.ANNIHILATE, x, y, z, vx, vy, vz);
                            }
                        }
                    }
                }
            });
            return null;
        }
    }
}
