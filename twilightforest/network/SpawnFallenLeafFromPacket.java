// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.world.World;
import net.minecraft.particles.IParticleData;
import twilightforest.client.particle.data.LeafParticleData;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import java.util.Random;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;

public class SpawnFallenLeafFromPacket
{
    private final BlockPos pos;
    private final Vector3d motion;
    
    public SpawnFallenLeafFromPacket(final PacketBuffer buf) {
        this.pos = buf.func_179259_c();
        this.motion = new Vector3d(buf.readDouble(), buf.readDouble(), buf.readDouble());
    }
    
    public SpawnFallenLeafFromPacket(final BlockPos pos, final Vector3d motion) {
        this.pos = pos;
        this.motion = motion;
    }
    
    public void encode(final PacketBuffer buf) {
        buf.func_179255_a(this.pos);
        buf.writeDouble(this.motion.field_72450_a);
        buf.writeDouble(this.motion.field_72448_b);
        buf.writeDouble(this.motion.field_72449_c);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final SpawnFallenLeafFromPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final Random rand = new Random();
                    final World world = (World)Minecraft.func_71410_x().field_71441_e;
                    final int color = Minecraft.func_71410_x().func_184125_al().func_228054_a_(Blocks.field_196642_W.func_176223_P(), (IBlockDisplayReader)world, message.pos, 0);
                    final int r = MathHelper.func_76125_a((color >> 16 & 0xFF) + rand.nextInt(34) - 17, 0, 255);
                    final int g = MathHelper.func_76125_a((color >> 8 & 0xFF) + rand.nextInt(34) - 17, 0, 255);
                    final int b = MathHelper.func_76125_a((color & 0xFF) + rand.nextInt(34) - 17, 0, 255);
                    world.func_195594_a((IParticleData)new LeafParticleData(r, g, b), (double)(message.pos.func_177958_n() + world.field_73012_v.nextFloat()), (double)message.pos.func_177956_o(), (double)(message.pos.func_177952_p() + world.field_73012_v.nextFloat()), world.field_73012_v.nextFloat() * -0.5f * message.motion.func_82615_a(), (double)(world.field_73012_v.nextFloat() * 0.5f + 0.25f), world.field_73012_v.nextFloat() * -0.5f * message.motion.func_82616_c());
                }
            });
            return true;
        }
    }
}
