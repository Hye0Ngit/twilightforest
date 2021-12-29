// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.gui.components.toasts.Toast;

record LockedBiomeToast(ItemStack item) implements Toast {
    public Toast.Visibility m_7172_(final PoseStack stack, final ToastComponent component, final long timer) {
        RenderSystem.m_157456_(0, LockedBiomeToast.f_94893_);
        RenderSystem.m_157429_(1.0f, 1.0f, 1.0f, 1.0f);
        component.m_93228_(stack, 0, 0, 0, 0, this.m_7828_(), this.m_94899_());
        component.m_94929_().m_91291_().m_115123_(this.item, 6, 8);
        component.m_94929_().f_91062_.m_92889_(stack, (Component)new TranslatableComponent("twilightforest.ui.biome_locked"), 25.0f, 7.0f, -256);
        component.m_94929_().f_91062_.m_92889_(stack, (Component)new TranslatableComponent("twilightforest.ui.biome_locked_2"), 25.0f, 18.0f, 16777215);
        return (timer >= 10000L) ? Toast.Visibility.HIDE : Toast.Visibility.SHOW;
    }
}
