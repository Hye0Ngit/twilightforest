// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketUpdateShield implements IMessage
{
    private int entityID;
    private int temporaryShields;
    private int permanentShields;
    
    public PacketUpdateShield() {
    }
    
    public PacketUpdateShield(final int id, final IShieldCapability cap) {
        this.entityID = id;
        this.temporaryShields = cap.temporaryShieldsLeft();
        this.permanentShields = cap.permanentShieldsLeft();
    }
    
    public PacketUpdateShield(final Entity entity, final IShieldCapability cap) {
        this(entity.func_145782_y(), cap);
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.entityID = buf.readInt();
        this.temporaryShields = buf.readInt();
        this.permanentShields = buf.readInt();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.entityID);
        buf.writeInt(this.temporaryShields);
        buf.writeInt(this.permanentShields);
    }
    
    public static class Handler implements IMessageHandler<PacketUpdateShield, IMessage>
    {
        public IMessage onMessage(final PacketUpdateShield message, final MessageContext ctx) {
            Minecraft.func_71410_x().func_152344_a((Runnable)new Runnable() {
                @Override
                public void run() {
                    final Entity entity = Minecraft.func_71410_x().field_71441_e.func_73045_a(message.entityID);
                    if (entity instanceof EntityLivingBase) {
                        final IShieldCapability cap = (IShieldCapability)entity.getCapability((Capability)CapabilityList.SHIELDS, (EnumFacing)null);
                        if (cap != null) {
                            cap.setShields(message.temporaryShields, true);
                            cap.setShields(message.permanentShields, false);
                        }
                    }
                }
            });
            return null;
        }
    }
}
