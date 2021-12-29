// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.ChatFormatting;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Iterator;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.CommonComponents;
import com.google.common.collect.Lists;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.client.gui.components.Button;
import java.util.List;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.MultiLineLabel;
import net.minecraft.client.gui.screens.Screen;

public class OptifineWarningScreen extends Screen
{
    private final Screen lastScreen;
    private int ticksUntilEnable;
    private MultiLineLabel message;
    private MultiLineLabel suggestions;
    private static final Component text;
    private static final MutableComponent url;
    private final List<Button> exitButton;
    
    protected OptifineWarningScreen(final Screen screen) {
        super((Component)new TranslatableComponent("twilightforest.gui.optifine.title"));
        this.ticksUntilEnable = 200;
        this.message = MultiLineLabel.f_94331_;
        this.suggestions = MultiLineLabel.f_94331_;
        this.exitButton = Lists.newArrayList();
        this.lastScreen = screen;
    }
    
    public Component m_142562_() {
        return (Component)CommonComponents.m_178398_(super.m_142562_(), OptifineWarningScreen.text);
    }
    
    protected void m_7856_() {
        super.m_7856_();
        this.exitButton.clear();
        this.exitButton.add(new Button(this.f_96543_ / 2 - 75, this.f_96544_ * 3 / 4, 150, 20, CommonComponents.f_130659_, p_213002_1_ -> Minecraft.m_91087_().m_91152_(this.lastScreen)));
        for (final Button button : this.exitButton) {
            button.f_93623_ = false;
        }
        this.message = MultiLineLabel.m_94341_(this.f_96547_, (FormattedText)OptifineWarningScreen.text, this.f_96543_ - 50);
        this.suggestions = MultiLineLabel.m_94341_(this.f_96547_, (FormattedText)OptifineWarningScreen.url, this.f_96543_ - 50);
    }
    
    public void m_6305_(final PoseStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {
        this.m_7333_(matrixStack);
        m_93215_(matrixStack, this.f_96547_, this.f_96539_, this.f_96543_ / 2, 30, 16777215);
        this.message.m_6276_(matrixStack, this.f_96543_ / 2, 70);
        this.suggestions.m_6276_(matrixStack, this.f_96543_ / 2, 160);
        super.m_6305_(matrixStack, mouseX, mouseY, partialTicks);
        for (final Button button : this.exitButton) {
            button.m_6305_(matrixStack, mouseX, mouseY, partialTicks);
        }
    }
    
    public void m_96624_() {
        super.m_96624_();
        final int ticksUntilEnable = this.ticksUntilEnable - 1;
        this.ticksUntilEnable = ticksUntilEnable;
        if (ticksUntilEnable == 0) {
            for (final Button button : this.exitButton) {
                button.f_93623_ = true;
            }
        }
    }
    
    public boolean m_6913_() {
        return this.ticksUntilEnable <= 0;
    }
    
    public void m_7379_() {
        Minecraft.m_91087_().m_91152_(this.lastScreen);
    }
    
    public boolean m_6375_(final double pMouseX, final double pMouseY, final int pButton) {
        if (pMouseY > 160.0 && pMouseY < 170.0) {
            final Style style = this.getClickedComponentStyleAt((int)pMouseX);
            if (style != null && style.m_131182_() != null && style.m_131182_().m_130622_() == ClickEvent.Action.OPEN_URL) {
                this.m_5561_(style);
                return false;
            }
        }
        return super.m_6375_(pMouseX, pMouseY, pButton);
    }
    
    @Nullable
    private Style getClickedComponentStyleAt(final int xPos) {
        final int wid = Minecraft.m_91087_().f_91062_.m_92852_((FormattedText)OptifineWarningScreen.url);
        final int left = this.f_96543_ / 2 - wid / 2;
        final int right = this.f_96543_ / 2 + wid / 2;
        return (xPos >= left && xPos <= right) ? Minecraft.m_91087_().f_91062_.m_92865_().m_92386_((FormattedText)OptifineWarningScreen.url, xPos - left) : null;
    }
    
    static {
        text = (Component)new TranslatableComponent("twilightforest.gui.optifine.message");
        (url = (MutableComponent)new TranslatableComponent("twilightforest.gui.optifine.suggestions")).m_130938_(style -> style.m_131140_(ChatFormatting.GREEN).setUnderlined(Boolean.valueOf(true)).m_131142_(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://gist.github.com/alkyaly/02830c560d15256855bc529e1e232e88")));
    }
}
