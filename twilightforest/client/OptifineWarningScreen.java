// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.Minecraft;
import java.util.Iterator;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.util.text.ITextProperties;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.gui.IBidiRenderer;
import net.minecraft.client.gui.screen.Screen;

public class OptifineWarningScreen extends Screen
{
    private final Screen lastScreen;
    private int ticksUntilEnable;
    private IBidiRenderer field_243276_q;
    private static final ITextComponent message;
    
    protected OptifineWarningScreen(final Screen screen) {
        super((ITextComponent)new TranslationTextComponent("twilightforest.gui.optifine.title"));
        this.ticksUntilEnable = 60;
        this.field_243276_q = IBidiRenderer.field_243257_a;
        this.lastScreen = screen;
    }
    
    public String func_231167_h_() {
        return super.func_231167_h_() + ". " + OptifineWarningScreen.message.getString();
    }
    
    protected void func_231160_c_() {
        super.func_231160_c_();
        this.func_230480_a_((Widget)new Button(this.field_230708_k_ / 2 - 75, this.field_230709_l_ * 3 / 4, 150, 20, DialogTexts.field_240636_g_, p_213002_1_ -> Minecraft.func_71410_x().func_147108_a(this.lastScreen)));
        this.field_243276_q = IBidiRenderer.func_243258_a(this.field_230712_o_, (ITextProperties)OptifineWarningScreen.message, this.field_230708_k_ - 50);
    }
    
    public void func_230430_a_(final MatrixStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {
        this.func_230446_a_(matrixStack);
        func_238472_a_(matrixStack, this.field_230712_o_, this.field_230704_d_, this.field_230708_k_ / 2, 30, 16777215);
        this.field_243276_q.func_241863_a(matrixStack, this.field_230708_k_ / 2, 70);
        super.func_230430_a_(matrixStack, mouseX, mouseY, partialTicks);
    }
    
    public void func_231023_e_() {
        super.func_231023_e_();
        final int ticksUntilEnable = this.ticksUntilEnable - 1;
        this.ticksUntilEnable = ticksUntilEnable;
        if (ticksUntilEnable == 0) {
            for (final Widget widget : this.field_230710_m_) {
                widget.field_230693_o_ = true;
            }
        }
    }
    
    public boolean func_231178_ax__() {
        return false;
    }
    
    static {
        message = (ITextComponent)new TranslationTextComponent("twilightforest.gui.optifine.message");
    }
}
