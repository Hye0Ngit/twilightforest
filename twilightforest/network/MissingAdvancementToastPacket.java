// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.network;

import net.minecraft.client.gui.components.toasts.Toast;
import twilightforest.client.MissingAdvancementToast;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class MissingAdvancementToastPacket
{
    private final Component title;
    private final ItemStack icon;
    
    public MissingAdvancementToastPacket(final Component title, final ItemStack icon) {
        this.title = title;
        this.icon = icon;
    }
    
    public MissingAdvancementToastPacket(final FriendlyByteBuf buf) {
        this.title = buf.m_130238_();
        this.icon = buf.m_130267_();
    }
    
    public void encode(final FriendlyByteBuf buf) {
        buf.m_130083_(this.title);
        buf.m_130055_(this.icon);
    }
    
    public static boolean handle(final MissingAdvancementToastPacket packet, final Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork((Runnable)new Runnable() {
            @Override
            public void run() {
                Minecraft.m_91087_().m_91300_().m_94922_((Toast)new MissingAdvancementToast(packet.title, packet.icon));
            }
        });
        return true;
    }
}
