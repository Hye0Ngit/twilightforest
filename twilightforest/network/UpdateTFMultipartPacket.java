// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.world.level.Level;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraftforge.entity.PartEntity;
import net.minecraft.network.syncher.SynchedEntityData;
import twilightforest.entity.TFPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.FriendlyByteBuf;

public class UpdateTFMultipartPacket
{
    private int id;
    private FriendlyByteBuf buffer;
    private Entity entity;
    
    public UpdateTFMultipartPacket(final FriendlyByteBuf buf) {
        this.id = buf.readInt();
        this.buffer = buf;
    }
    
    public UpdateTFMultipartPacket(final Entity entity) {
        this.entity = entity;
    }
    
    public void encode(final FriendlyByteBuf buf) {
        buf.writeInt(this.entity.m_142049_());
        final PartEntity<?>[] parts = (PartEntity<?>[])this.entity.getParts();
        if (parts != null) {
            for (final PartEntity<?> part : parts) {
                if (part instanceof final TFPart tfPart2) {
                    final TFPart<?> tfPart = tfPart2;
                    tfPart.writeData(buf);
                    final boolean dirty = tfPart.m_20088_().m_135352_();
                    buf.writeBoolean(dirty);
                    if (dirty) {
                        SynchedEntityData.m_135358_(tfPart.m_20088_().m_135378_(), buf);
                    }
                }
            }
        }
    }
    
    public static class Handler
    {
        public static boolean onMessage(final UpdateTFMultipartPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final Level world = (Level)Minecraft.m_91087_().f_91073_;
                    if (world == null) {
                        return;
                    }
                    final Entity ent = world.m_6815_(message.id);
                    if (ent != null && ent.isMultipartEntity()) {
                        final PartEntity<?>[] parts = (PartEntity<?>[])ent.getParts();
                        if (parts == null) {
                            return;
                        }
                        for (final PartEntity<?> part : parts) {
                            if (part instanceof final TFPart tfPart2) {
                                final TFPart<?> tfPart = tfPart2;
                                tfPart.readData(message.buffer);
                                if (message.buffer.readBoolean()) {
                                    final List<SynchedEntityData.DataItem<?>> data = SynchedEntityData.m_135361_(message.buffer);
                                    if (data != null) {
                                        tfPart.m_20088_().m_135356_((List)data);
                                    }
                                }
                            }
                        }
                    }
                }
            });
            return true;
        }
    }
}
