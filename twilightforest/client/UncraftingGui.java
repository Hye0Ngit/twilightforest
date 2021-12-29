// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;
import twilightforest.TwilightForestMod;
import net.minecraft.inventory.IInventory;
import twilightforest.network.UncraftingGuiPacket;
import twilightforest.network.TFPacketHandler;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.item.ItemStack;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.client.renderer.RenderHelper;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.resources.I18n;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import twilightforest.inventory.UncraftingContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;

public class UncraftingGui extends ContainerScreen<UncraftingContainer>
{
    private static final ResourceLocation textureLoc;
    
    public UncraftingGui(final UncraftingContainer container, final PlayerInventory player, final ITextComponent name) {
        super((Container)container, player, name);
    }
    
    protected void func_231160_c_() {
        super.func_231160_c_();
        this.func_230480_a_((Widget)new CycleButton(this.field_147003_i + 40, this.field_147009_r + 22, true, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(0));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.field_147002_h;
            ++uncraftingContainer.unrecipeInCycle;
            ((UncraftingContainer)this.field_147002_h).func_75130_a(((UncraftingContainer)this.field_147002_h).tinkerInput);
        }));
        this.func_230480_a_((Widget)new CycleButton(this.field_147003_i + 40, this.field_147009_r + 55, false, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(1));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.field_147002_h;
            --uncraftingContainer.unrecipeInCycle;
            ((UncraftingContainer)this.field_147002_h).func_75130_a(((UncraftingContainer)this.field_147002_h).tinkerInput);
        }));
        this.func_230480_a_((Widget)new CycleButtonMini(this.field_147003_i + 27, this.field_147009_r + 56, true, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(2));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.field_147002_h;
            ++uncraftingContainer.ingredientsInCycle;
            ((UncraftingContainer)this.field_147002_h).func_75130_a(((UncraftingContainer)this.field_147002_h).tinkerInput);
        }));
        this.func_230480_a_((Widget)new CycleButtonMini(this.field_147003_i + 27, this.field_147009_r + 63, false, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(3));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.field_147002_h;
            --uncraftingContainer.ingredientsInCycle;
            ((UncraftingContainer)this.field_147002_h).func_75130_a(((UncraftingContainer)this.field_147002_h).tinkerInput);
        }));
        this.func_230480_a_((Widget)new CycleButton(this.field_147003_i + 121, this.field_147009_r + 22, true, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(4));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.field_147002_h;
            ++uncraftingContainer.unrecipeInCycle;
            ((UncraftingContainer)this.field_147002_h).func_75130_a((IInventory)((UncraftingContainer)this.field_147002_h).assemblyMatrix);
        }));
        this.func_230480_a_((Widget)new CycleButton(this.field_147003_i + 121, this.field_147009_r + 55, false, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(5));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.field_147002_h;
            --uncraftingContainer.unrecipeInCycle;
            ((UncraftingContainer)this.field_147002_h).func_75130_a((IInventory)((UncraftingContainer)this.field_147002_h).assemblyMatrix);
        }));
    }
    
    public void func_230430_a_(final MatrixStack ms, final int mouseX, final int mouseY, final float partialTicks) {
        this.func_230446_a_(ms);
        super.func_230430_a_(ms, mouseX, mouseY, partialTicks);
        this.func_230459_a_(ms, mouseX, mouseY);
    }
    
    protected void func_230451_b_(final MatrixStack ms, final int mouseX, final int mouseY) {
        this.field_230712_o_.func_238421_b_(ms, I18n.func_135052_a(((Block)TFBlocks.uncrafting_table.get()).func_149739_a(), new Object[0]), 8.0f, 6.0f, 4210752);
        this.field_230712_o_.func_238421_b_(ms, I18n.func_135052_a("container.inventory", new Object[0]), 8.0f, (float)(this.field_147000_g - 96 + 2), 4210752);
    }
    
    protected void func_230450_a_(final MatrixStack ms, final float partialTicks, final int mouseX, final int mouseY) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_230706_i_.func_110434_K().func_110577_a(UncraftingGui.textureLoc);
        final int frameX = (this.field_230708_k_ - this.field_146999_f) / 2;
        final int frameY = (this.field_230709_l_ - this.field_147000_g) / 2;
        this.func_238474_b_(ms, frameX, frameY, 0, 0, this.field_146999_f, this.field_147000_g);
        final UncraftingContainer tfContainer = (UncraftingContainer)this.field_147002_h;
        ms.func_227860_a_();
        ms.func_227861_a_((double)this.field_147003_i, (double)this.field_147009_r, 0.0);
        for (int i = 0; i < 9; ++i) {
            final Slot uncrafting = tfContainer.func_75139_a(2 + i);
            final Slot assembly = tfContainer.func_75139_a(11 + i);
            if (uncrafting.func_75216_d()) {
                this.drawSlotAsBackground(ms, uncrafting, assembly);
            }
        }
        ms.func_227865_b_();
        final FontRenderer fontRendererObj = this.field_230706_i_.field_71466_p;
        RenderHelper.func_74518_a();
        int costVal = tfContainer.getUncraftingCost();
        if (costVal > 0) {
            final String cost = "" + costVal;
            int color;
            if (this.field_230706_i_.field_71439_g.field_71068_ca < costVal && !this.field_230706_i_.field_71439_g.field_71075_bZ.field_75098_d) {
                color = 10485760;
            }
            else {
                color = 8453920;
            }
            fontRendererObj.func_238405_a_(ms, cost, (float)(frameX + 48 - fontRendererObj.func_78256_a(cost)), (float)(frameY + 38), color);
        }
        costVal = tfContainer.getRecraftingCost();
        if (costVal > 0) {
            final String cost = "" + costVal;
            int color;
            if (this.field_230706_i_.field_71439_g.field_71068_ca < costVal && !this.field_230706_i_.field_71439_g.field_71075_bZ.field_75098_d) {
                color = 10485760;
            }
            else {
                color = 8453920;
            }
            fontRendererObj.func_238405_a_(ms, cost, (float)(frameX + 130 - fontRendererObj.func_78256_a(cost)), (float)(frameY + 38), color);
        }
    }
    
    private void drawSlotAsBackground(final MatrixStack ms, final Slot backgroundSlot, final Slot appearSlot) {
        final int screenX = appearSlot.field_75223_e + this.field_147003_i;
        final int screenY = appearSlot.field_75221_f + this.field_147009_r;
        final ItemStack itemStackToRender = backgroundSlot.func_75211_c();
        this.field_230707_j_.field_77023_b = 50.0f;
        this.field_230707_j_.func_175042_a(itemStackToRender, screenX, screenY);
        this.field_230707_j_.func_180453_a(this.field_230712_o_, itemStackToRender, screenX, screenY, "");
        final boolean itemBroken = UncraftingContainer.isMarked(itemStackToRender);
        RenderSystem.disableLighting();
        RenderSystem.disableDepthTest();
        AbstractGui.func_238467_a_(ms, appearSlot.field_75223_e, appearSlot.field_75221_f, appearSlot.field_75223_e + 16, appearSlot.field_75221_f + 16, itemBroken ? -2130736245 : -1618244725);
        RenderSystem.enableLighting();
        RenderSystem.enableDepthTest();
        this.field_230707_j_.field_77023_b = 0.0f;
    }
    
    static {
        textureLoc = TwilightForestMod.getGuiTexture("guigoblintinkering.png");
    }
    
    private static class CycleButton extends Button
    {
        private final boolean up;
        
        CycleButton(final int x, final int y, final boolean up, final Button.IPressable onClick) {
            super(x, y, 14, 9, StringTextComponent.field_240750_d_, onClick);
            this.up = up;
        }
        
        public void func_230431_b_(final MatrixStack ms, final int mouseX, final int mouseY, final float partialTicks) {
            if (this.field_230694_p_) {
                Minecraft.func_71410_x().func_110434_K().func_110577_a(UncraftingGui.textureLoc);
                RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
                this.field_230692_n_ = (mouseX >= this.field_230690_l_ && mouseY >= this.field_230691_m_ && mouseX < this.field_230690_l_ + this.field_230688_j_ && mouseY < this.field_230691_m_ + this.field_230689_k_);
                int textureX = 176;
                int textureY = 0;
                if (this.field_230692_n_) {
                    textureX += this.field_230688_j_;
                }
                if (!this.up) {
                    textureY += this.field_230689_k_;
                }
                this.func_238474_b_(ms, this.field_230690_l_, this.field_230691_m_, textureX, textureY, this.field_230688_j_, this.field_230689_k_);
            }
        }
    }
    
    private static class CycleButtonMini extends Button
    {
        private final boolean up;
        
        CycleButtonMini(final int x, final int y, final boolean up, final Button.IPressable onClick) {
            super(x, y, 8, 6, StringTextComponent.field_240750_d_, onClick);
            this.up = up;
        }
        
        public void func_230431_b_(final MatrixStack ms, final int mouseX, final int mouseY, final float partialTicks) {
            if (this.field_230694_p_) {
                Minecraft.func_71410_x().func_110434_K().func_110577_a(UncraftingGui.textureLoc);
                RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
                this.field_230692_n_ = (mouseX >= this.field_230690_l_ && mouseY >= this.field_230691_m_ && mouseX < this.field_230690_l_ + this.field_230688_j_ && mouseY < this.field_230691_m_ + this.field_230689_k_);
                int textureX = 176;
                int textureY = 41;
                if (this.field_230692_n_) {
                    textureX += this.field_230688_j_;
                }
                if (!this.up) {
                    textureY += this.field_230689_k_;
                }
                this.func_238474_b_(ms, this.field_230690_l_, this.field_230691_m_, textureX, textureY, this.field_230688_j_, this.field_230689_k_);
            }
        }
    }
}
