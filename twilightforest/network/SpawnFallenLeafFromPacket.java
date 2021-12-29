// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.world.level.Level;
import net.minecraft.core.particles.ParticleOptions;
import twilightforest.client.particle.data.LeafParticleData;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.Minecraft;
import java.util.Random;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.BlockPos;

public class SpawnFallenLeafFromPacket
{
    private final BlockPos pos;
    private final Vec3 motion;
    
    public SpawnFallenLeafFromPacket(final FriendlyByteBuf buf) {
        this.pos = buf.m_130135_();
        this.motion = new Vec3(buf.readDouble(), buf.readDouble(), buf.readDouble());
    }
    
    public SpawnFallenLeafFromPacket(final BlockPos pos, final Vec3 motion) {
        this.pos = pos;
        this.motion = motion;
    }
    
    public void encode(final FriendlyByteBuf buf) {
        buf.m_130064_(this.pos);
        buf.writeDouble(this.motion.f_82479_);
        buf.writeDouble(this.motion.f_82480_);
        buf.writeDouble(this.motion.f_82481_);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final SpawnFallenLeafFromPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final Random rand = new Random();
                    final Level world = (Level)Minecraft.m_91087_().f_91073_;
                    final int color = Minecraft.m_91087_().m_91298_().m_92577_(Blocks.f_50050_.m_49966_(), (BlockAndTintGetter)world, message.pos, 0);
                    final int r = Mth.m_14045_((color >> 16 & 0xFF) + rand.nextInt(34) - 17, 0, 255);
                    final int g = Mth.m_14045_((color >> 8 & 0xFF) + rand.nextInt(34) - 17, 0, 255);
                    final int b = Mth.m_14045_((color & 0xFF) + rand.nextInt(34) - 17, 0, 255);
                    world.m_7106_((ParticleOptions)new LeafParticleData(r, g, b), (double)(message.pos.m_123341_() + world.f_46441_.nextFloat()), (double)message.pos.m_123342_(), (double)(message.pos.m_123343_() + world.f_46441_.nextFloat()), world.f_46441_.nextFloat() * -0.5f * message.motion.m_7096_(), (double)(world.f_46441_.nextFloat() * 0.5f + 0.25f), world.f_46441_.nextFloat() * -0.5f * message.motion.m_7094_());
                }
            });
            return true;
        }
    }
}
