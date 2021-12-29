// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import java.util.Iterator;
import net.minecraft.world.level.Level;
import twilightforest.entity.ProtectionBox;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.multiplayer.ClientLevel;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

public class AreaProtectionPacket
{
    private final BoundingBox sbb;
    private final BlockPos pos;
    
    public AreaProtectionPacket(final BoundingBox sbb, final BlockPos pos) {
        this.sbb = sbb;
        this.pos = pos;
    }
    
    public AreaProtectionPacket(final FriendlyByteBuf buf) {
        this.sbb = new BoundingBox(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt());
        this.pos = buf.m_130135_();
    }
    
    public void encode(final FriendlyByteBuf buf) {
        buf.writeInt(this.sbb.m_162395_());
        buf.writeInt(this.sbb.m_162396_());
        buf.writeInt(this.sbb.m_162398_());
        buf.writeInt(this.sbb.m_162399_());
        buf.writeInt(this.sbb.m_162400_());
        buf.writeInt(this.sbb.m_162401_());
        buf.writeLong(this.pos.m_121878_());
    }
    
    public static class Handler
    {
        public static boolean onMessage(final AreaProtectionPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final ClientLevel world = Minecraft.m_91087_().f_91073_;
                    Handler.addProtectionBox(world, message.sbb);
                    for (int i = 0; i < 20; ++i) {
                        final double vx = world.f_46441_.nextGaussian() * 0.02;
                        final double vy = world.f_46441_.nextGaussian() * 0.02;
                        final double vz = world.f_46441_.nextGaussian() * 0.02;
                        final double x = message.pos.m_123341_() + 0.5 + world.f_46441_.nextFloat() - world.f_46441_.nextFloat();
                        final double y = message.pos.m_123342_() + 0.5 + world.f_46441_.nextFloat() - world.f_46441_.nextFloat();
                        final double z = message.pos.m_123343_() + 0.5 + world.f_46441_.nextFloat() - world.f_46441_.nextFloat();
                        world.m_7106_((ParticleOptions)TFParticleType.PROTECTION.get(), x, y, z, vx, vy, vz);
                    }
                }
            });
            return true;
        }
        
        static void addProtectionBox(final ClientLevel world, final BoundingBox sbb) {
            for (final Entity entity : world.m_104735_()) {
                if (entity instanceof final ProtectionBox protectionBox) {
                    if (protectionBox.lifeTime > 0 && protectionBox.matches(sbb)) {
                        protectionBox.resetLifetime();
                        return;
                    }
                    continue;
                }
            }
            world.m_7967_((Entity)new ProtectionBox((Level)world, sbb));
        }
    }
}
