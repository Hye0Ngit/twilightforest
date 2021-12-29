// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import twilightforest.inventory.ContainerTFUncrafting;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketUncraftingGui implements IMessage
{
    private int type;
    
    public PacketUncraftingGui(final int type) {
        this.type = type;
    }
    
    public PacketUncraftingGui() {
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.type = buf.readInt();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.type);
    }
    
    public static class Handler implements IMessageHandler<PacketUncraftingGui, IMessage>
    {
        public IMessage onMessage(final PacketUncraftingGui message, final MessageContext ctx) {
            final EntityPlayerMP player = ctx.getServerHandler().field_147369_b;
            player.func_71121_q().func_152344_a((Runnable)new Runnable() {
                @Override
                public void run() {
                    final Container container = player.field_71070_bA;
                    if (container instanceof ContainerTFUncrafting) {
                        final ContainerTFUncrafting uncrafting = (ContainerTFUncrafting)container;
                        switch (message.type) {
                            case 0: {
                                final ContainerTFUncrafting containerTFUncrafting = uncrafting;
                                ++containerTFUncrafting.unrecipeInCycle;
                                break;
                            }
                            case 1: {
                                final ContainerTFUncrafting containerTFUncrafting2 = uncrafting;
                                --containerTFUncrafting2.unrecipeInCycle;
                                break;
                            }
                            case 2: {
                                final ContainerTFUncrafting containerTFUncrafting3 = uncrafting;
                                ++containerTFUncrafting3.ingredientsInCycle;
                                break;
                            }
                            case 3: {
                                final ContainerTFUncrafting containerTFUncrafting4 = uncrafting;
                                --containerTFUncrafting4.ingredientsInCycle;
                                break;
                            }
                            case 4: {
                                final ContainerTFUncrafting containerTFUncrafting5 = uncrafting;
                                ++containerTFUncrafting5.recipeInCycle;
                                break;
                            }
                            case 5: {
                                final ContainerTFUncrafting containerTFUncrafting6 = uncrafting;
                                --containerTFUncrafting6.recipeInCycle;
                                break;
                            }
                        }
                        if (message.type < 4) {
                            uncrafting.func_75130_a(uncrafting.tinkerInput);
                        }
                        if (message.type >= 4) {
                            uncrafting.func_75130_a((IInventory)uncrafting.assemblyMatrix);
                        }
                    }
                }
            });
            return null;
        }
    }
}
