// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.IInventory;
import twilightforest.inventory.UncraftingContainer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.PacketBuffer;

public class UncraftingGuiPacket
{
    private int type;
    
    public UncraftingGuiPacket(final int type) {
        this.type = type;
    }
    
    public UncraftingGuiPacket(final PacketBuffer buf) {
        this.type = buf.readInt();
    }
    
    public void encode(final PacketBuffer buf) {
        buf.writeInt(this.type);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final UncraftingGuiPacket message, final Supplier<NetworkEvent.Context> ctx) {
            final ServerPlayerEntity player = ctx.get().getSender();
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final Container container = player.field_71070_bA;
                    if (container instanceof UncraftingContainer) {
                        final UncraftingContainer uncrafting = (UncraftingContainer)container;
                        switch (message.type) {
                            case 0: {
                                final UncraftingContainer uncraftingContainer = uncrafting;
                                ++uncraftingContainer.unrecipeInCycle;
                                break;
                            }
                            case 1: {
                                final UncraftingContainer uncraftingContainer2 = uncrafting;
                                --uncraftingContainer2.unrecipeInCycle;
                                break;
                            }
                            case 2: {
                                final UncraftingContainer uncraftingContainer3 = uncrafting;
                                ++uncraftingContainer3.ingredientsInCycle;
                                break;
                            }
                            case 3: {
                                final UncraftingContainer uncraftingContainer4 = uncrafting;
                                --uncraftingContainer4.ingredientsInCycle;
                                break;
                            }
                            case 4: {
                                final UncraftingContainer uncraftingContainer5 = uncrafting;
                                ++uncraftingContainer5.recipeInCycle;
                                break;
                            }
                            case 5: {
                                final UncraftingContainer uncraftingContainer6 = uncrafting;
                                --uncraftingContainer6.recipeInCycle;
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
            return true;
        }
    }
}
