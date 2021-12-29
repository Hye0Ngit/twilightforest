// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.world.World;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraftforge.entity.PartEntity;
import java.io.IOException;
import net.minecraft.network.datasync.EntityDataManager;
import twilightforest.entity.TFPartEntity;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketBuffer;

public class UpdateTFMultipartPacket
{
    private int id;
    private PacketBuffer buffer;
    private Entity entity;
    
    public UpdateTFMultipartPacket(final PacketBuffer buf) {
        this.id = buf.readInt();
        this.buffer = buf;
    }
    
    public UpdateTFMultipartPacket(final Entity entity) {
        this.entity = entity;
    }
    
    public void encode(final PacketBuffer buf) {
        try {
            buf.writeInt(this.entity.func_145782_y());
            final PartEntity<?>[] parts = (PartEntity<?>[])this.entity.getParts();
            if (parts != null) {
                for (final PartEntity<?> part : parts) {
                    if (part instanceof TFPartEntity) {
                        final TFPartEntity<?> tfPart = (TFPartEntity)part;
                        tfPart.writeData(buf);
                        final boolean dirty = tfPart.func_184212_Q().func_187223_a();
                        buf.writeBoolean(dirty);
                        if (dirty) {
                            EntityDataManager.func_187229_a(tfPart.func_184212_Q().func_187221_b(), buf);
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static class Handler
    {
        public static boolean onMessage(final UpdateTFMultipartPacket message, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    try {
                        final World world = (World)Minecraft.func_71410_x().field_71441_e;
                        if (world == null) {
                            return;
                        }
                        final Entity ent = world.func_73045_a(message.id);
                        if (ent != null && ent.isMultipartEntity()) {
                            final PartEntity<?>[] parts = (PartEntity<?>[])ent.getParts();
                            if (parts == null) {
                                return;
                            }
                            for (final PartEntity<?> part : parts) {
                                if (part instanceof TFPartEntity) {
                                    final TFPartEntity<?> tfPart = (TFPartEntity)part;
                                    tfPart.readData(message.buffer);
                                    if (message.buffer.readBoolean()) {
                                        final List<EntityDataManager.DataEntry<?>> data = EntityDataManager.func_187215_b(message.buffer);
                                        if (data != null) {
                                            tfPart.func_184212_Q().func_187218_a((List)data);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return true;
        }
    }
}
