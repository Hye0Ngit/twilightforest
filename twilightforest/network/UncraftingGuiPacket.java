// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.Container;
import twilightforest.inventory.UncraftingContainer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;

public class UncraftingGuiPacket
{
    private int type;
    
    public UncraftingGuiPacket(final int type) {
        this.type = type;
    }
    
    public UncraftingGuiPacket(final FriendlyByteBuf buf) {
        this.type = buf.readInt();
    }
    
    public void encode(final FriendlyByteBuf buf) {
        buf.writeInt(this.type);
    }
    
    public static class Handler
    {
        public static boolean onMessage(final UncraftingGuiPacket message, final Supplier<NetworkEvent.Context> ctx) {
            final ServerPlayer player = ctx.get().getSender();
            ctx.get().enqueueWork((Runnable)new Runnable() {
                @Override
                public void run() {
                    final AbstractContainerMenu container = player.f_36096_;
                    if (container instanceof final UncraftingContainer uncrafting) {
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
                            uncrafting.m_6199_(uncrafting.tinkerInput);
                        }
                        if (message.type >= 4) {
                            uncrafting.m_6199_((Container)uncrafting.assemblyMatrix);
                        }
                    }
                }
            });
            return true;
        }
    }
}
