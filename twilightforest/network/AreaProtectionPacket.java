// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import java.util.Iterator;
import net.minecraft.world.World;
import twilightforest.entity.ProtectionBoxEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.world.ClientWorld;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;

public class AreaProtectionPacket
{
    private final MutableBoundingBox sbb;
    private final BlockPos pos;
    
    public AreaProtectionPacket(final MutableBoundingBox sbb, final BlockPos pos) {
        this.sbb = sbb;
        this.pos = pos;
    }
    
    public AreaProtectionPacket(final PacketBuffer buf) {
        this.sbb = new MutableBoundingBox(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt());
        this.pos = buf.func_179259_c();
    }
    
    public void encode(final PacketBuffer buf) {
        buf.writeInt(this.sbb.field_78897_a);
        buf.writeInt(this.sbb.field_78895_b);
        buf.writeInt(this.sbb.field_78896_c);
        buf.writeInt(this.sbb.field_78893_d);
        buf.writeInt(this.sbb.field_78894_e);
        buf.writeInt(this.sbb.field_78892_f);
        buf.writeLong(this.pos.func_218275_a());
    }
    
    public static class Handler
    {
        public static boolean onMessage(final AreaProtectionPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final ClientWorld world = Minecraft.func_71410_x().field_71441_e;
                    Handler.addProtectionBox(world, message.sbb);
                    for (int i = 0; i < 20; ++i) {
                        final double vx = world.field_73012_v.nextGaussian() * 0.02;
                        final double vy = world.field_73012_v.nextGaussian() * 0.02;
                        final double vz = world.field_73012_v.nextGaussian() * 0.02;
                        final double x = message.pos.func_177958_n() + 0.5 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat();
                        final double y = message.pos.func_177956_o() + 0.5 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat();
                        final double z = message.pos.func_177952_p() + 0.5 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat();
                        world.func_195594_a((IParticleData)TFParticleType.PROTECTION.get(), x, y, z, vx, vy, vz);
                    }
                }
            });
            return true;
        }
        
        static void addProtectionBox(final ClientWorld world, final MutableBoundingBox sbb) {
            for (final Entity entity : world.func_217416_b()) {
                if (entity instanceof ProtectionBoxEntity) {
                    final ProtectionBoxEntity protectionBox = (ProtectionBoxEntity)entity;
                    if (protectionBox.lifeTime > 0 && protectionBox.matches(sbb)) {
                        protectionBox.resetLifetime();
                        return;
                    }
                    continue;
                }
            }
            world.func_217376_c((Entity)new ProtectionBoxEntity((World)world, sbb));
        }
    }
}
