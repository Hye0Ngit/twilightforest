// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import java.util.Iterator;
import twilightforest.entity.EntityTFProtectionBox;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketAreaProtection implements IMessage
{
    private StructureBoundingBox sbb;
    private BlockPos pos;
    
    public PacketAreaProtection() {
    }
    
    public PacketAreaProtection(final StructureBoundingBox sbb, final BlockPos pos) {
        this.sbb = sbb;
        this.pos = pos;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.sbb = new StructureBoundingBox(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt());
        this.pos = BlockPos.func_177969_a(buf.readLong());
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.sbb.field_78897_a);
        buf.writeInt(this.sbb.field_78895_b);
        buf.writeInt(this.sbb.field_78896_c);
        buf.writeInt(this.sbb.field_78893_d);
        buf.writeInt(this.sbb.field_78894_e);
        buf.writeInt(this.sbb.field_78892_f);
        buf.writeLong(this.pos.func_177986_g());
    }
    
    public static class Handler implements IMessageHandler<PacketAreaProtection, IMessage>
    {
        public IMessage onMessage(final PacketAreaProtection message, final MessageContext ctx) {
            Minecraft.func_71410_x().func_152344_a((Runnable)new Runnable() {
                @Override
                public void run() {
                    final World world = (World)Minecraft.func_71410_x().field_71441_e;
                    Handler.addProtectionBox(world, message.sbb);
                    for (int i = 0; i < 20; ++i) {
                        final double vx = world.field_73012_v.nextGaussian() * 0.02;
                        final double vy = world.field_73012_v.nextGaussian() * 0.02;
                        final double vz = world.field_73012_v.nextGaussian() * 0.02;
                        final double x = message.pos.func_177958_n() + 0.5 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat();
                        final double y = message.pos.func_177956_o() + 0.5 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat();
                        final double z = message.pos.func_177952_p() + 0.5 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat();
                        TwilightForestMod.proxy.spawnParticle(TFParticleType.PROTECTION, x, y, z, vx, vy, vz);
                    }
                }
            });
            return null;
        }
        
        static void addProtectionBox(final World world, final StructureBoundingBox sbb) {
            for (final Entity entity : world.field_73007_j) {
                if (entity instanceof EntityTFProtectionBox) {
                    final EntityTFProtectionBox protectionBox = (EntityTFProtectionBox)entity;
                    if (protectionBox.matches(sbb)) {
                        protectionBox.resetLifetime();
                        return;
                    }
                    continue;
                }
            }
            world.func_72942_c((Entity)new EntityTFProtectionBox(world, sbb));
        }
    }
}
