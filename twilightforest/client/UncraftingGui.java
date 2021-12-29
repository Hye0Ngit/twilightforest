// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.network.chat.TextComponent;
import twilightforest.TwilightForestMod;
import net.minecraft.world.Container;
import twilightforest.network.UncraftingGuiPacket;
import twilightforest.network.TFPacketHandler;
import net.minecraft.client.gui.components.Button;
import net.minecraft.tags.Tag;
import twilightforest.data.ItemTagGenerator;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.Font;
import net.minecraft.world.inventory.Slot;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import twilightforest.TFConfig;
import net.minecraft.client.resources.language.I18n;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import twilightforest.inventory.UncraftingContainer;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

public class UncraftingGui extends AbstractContainerScreen<UncraftingContainer>
{
    private static final ResourceLocation textureLoc;
    
    public UncraftingGui(final UncraftingContainer container, final Inventory player, final Component name) {
        super((AbstractContainerMenu)container, player, name);
    }
    
    protected void m_7856_() {
        super.m_7856_();
        this.m_142416_((GuiEventListener)new CycleButton(this.f_97735_ + 40, this.f_97736_ + 22, true, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(0));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.f_97732_;
            ++uncraftingContainer.unrecipeInCycle;
            ((UncraftingContainer)this.f_97732_).m_6199_(((UncraftingContainer)this.f_97732_).tinkerInput);
        }));
        this.m_142416_((GuiEventListener)new CycleButton(this.f_97735_ + 40, this.f_97736_ + 55, false, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(1));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.f_97732_;
            --uncraftingContainer.unrecipeInCycle;
            ((UncraftingContainer)this.f_97732_).m_6199_(((UncraftingContainer)this.f_97732_).tinkerInput);
        }));
        this.m_142416_((GuiEventListener)new CycleButtonMini(this.f_97735_ + 27, this.f_97736_ + 56, true, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(2));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.f_97732_;
            ++uncraftingContainer.ingredientsInCycle;
            ((UncraftingContainer)this.f_97732_).m_6199_(((UncraftingContainer)this.f_97732_).tinkerInput);
        }));
        this.m_142416_((GuiEventListener)new CycleButtonMini(this.f_97735_ + 27, this.f_97736_ + 63, false, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(3));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.f_97732_;
            --uncraftingContainer.ingredientsInCycle;
            ((UncraftingContainer)this.f_97732_).m_6199_(((UncraftingContainer)this.f_97732_).tinkerInput);
        }));
        this.m_142416_((GuiEventListener)new CycleButton(this.f_97735_ + 121, this.f_97736_ + 22, true, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(4));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.f_97732_;
            ++uncraftingContainer.unrecipeInCycle;
            ((UncraftingContainer)this.f_97732_).m_6199_((Container)((UncraftingContainer)this.f_97732_).assemblyMatrix);
        }));
        this.m_142416_((GuiEventListener)new CycleButton(this.f_97735_ + 121, this.f_97736_ + 55, false, button -> {
            TFPacketHandler.CHANNEL.sendToServer((Object)new UncraftingGuiPacket(5));
            final UncraftingContainer uncraftingContainer = (UncraftingContainer)this.f_97732_;
            --uncraftingContainer.unrecipeInCycle;
            ((UncraftingContainer)this.f_97732_).m_6199_((Container)((UncraftingContainer)this.f_97732_).assemblyMatrix);
        }));
    }
    
    public void m_6305_(final PoseStack ms, final int mouseX, final int mouseY, final float partialTicks) {
        this.m_7333_(ms);
        super.m_6305_(ms, mouseX, mouseY, partialTicks);
        this.m_7025_(ms, mouseX, mouseY);
    }
    
    protected void m_7027_(final PoseStack ms, final int mouseX, final int mouseY) {
        this.f_96547_.m_92883_(ms, I18n.m_118938_(((Block)TFBlocks.UNCRAFTING_TABLE.get()).m_7705_(), new Object[0]), 6.0f, 6.0f, 4210752);
        if (TFConfig.COMMON_CONFIG.UNCRAFTING_STUFFS.disableUncrafting.get()) {
            this.f_96547_.m_92889_(ms, (Component)new TranslatableComponent("container.uncrafting_table.disabled").m_130940_(ChatFormatting.DARK_RED), 6.0f, (float)(this.f_97727_ - 96 + 2), 4210752);
        }
        else {
            this.f_96547_.m_92883_(ms, I18n.m_118938_("container.inventory", new Object[0]), 7.0f, (float)(this.f_97727_ - 96 + 2), 4210752);
        }
    }
    
    protected void m_7286_(final PoseStack ms, final float partialTicks, final int mouseX, final int mouseY) {
        RenderSystem.m_157429_(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.m_157179_(0, UncraftingGui.textureLoc);
        final int frameX = (this.f_96543_ - this.f_97726_) / 2;
        final int frameY = (this.f_96544_ - this.f_97727_) / 2;
        this.m_93228_(ms, frameX, frameY, 0, 0, this.f_97726_, this.f_97727_);
        final UncraftingContainer tfContainer = (UncraftingContainer)this.f_97732_;
        ms.m_85836_();
        ms.m_85837_((double)this.f_97735_, (double)this.f_97736_, 0.0);
        for (int i = 0; i < 9; ++i) {
            final Slot uncrafting = tfContainer.m_38853_(2 + i);
            final Slot assembly = tfContainer.m_38853_(11 + i);
            if (uncrafting.m_6657_()) {
                this.drawSlotAsBackground(ms, uncrafting, assembly);
            }
        }
        ms.m_85849_();
        final Font fontRendererObj = this.f_96541_.f_91062_;
        int costVal = tfContainer.getUncraftingCost();
        if (costVal > 0) {
            final String cost = "" + costVal;
            int color;
            if (this.f_96541_.f_91074_.f_36078_ < costVal && !this.f_96541_.f_91074_.m_150110_().f_35937_) {
                color = 10485760;
            }
            else {
                color = 8453920;
            }
            fontRendererObj.m_92750_(ms, cost, (float)(frameX + 48 - fontRendererObj.m_92895_(cost)), (float)(frameY + 38), color);
        }
        costVal = tfContainer.getRecraftingCost();
        if (costVal > 0) {
            final String cost = "" + costVal;
            int color;
            if (this.f_96541_.f_91074_.f_36078_ < costVal && !this.f_96541_.f_91074_.m_150110_().f_35937_) {
                color = 10485760;
            }
            else {
                color = 8453920;
            }
            fontRendererObj.m_92750_(ms, cost, (float)(frameX + 130 - fontRendererObj.m_92895_(cost)), (float)(frameY + 38), color);
        }
    }
    
    private void drawSlotAsBackground(final PoseStack ms, final Slot backgroundSlot, final Slot appearSlot) {
        final int screenX = appearSlot.f_40220_ + this.f_97735_;
        final int screenY = appearSlot.f_40221_ + this.f_97736_;
        final ItemStack itemStackToRender = backgroundSlot.m_7993_();
        this.f_96542_.f_115093_ = 50.0f;
        this.f_96542_.m_115123_(itemStackToRender, screenX, screenY);
        this.f_96542_.m_115174_(this.f_96547_, itemStackToRender, screenX, screenY, "");
        final boolean itemBroken = UncraftingContainer.isMarked(itemStackToRender);
        RenderSystem.m_69465_();
        GuiComponent.m_93172_(ms, appearSlot.f_40220_, appearSlot.f_40221_, appearSlot.f_40220_ + 16, appearSlot.f_40221_ + 16, itemBroken ? -2130736245 : -1618244725);
        RenderSystem.m_69482_();
        this.f_96542_.f_115093_ = 0.0f;
    }
    
    protected void m_7025_(final PoseStack pPoseStack, final int pX, final int pY) {
        final UncraftingContainer container = (UncraftingContainer)this.f_97732_;
        for (int i = 0; i < 9; ++i) {
            if (container.m_142621_().m_41619_() && ((Slot)container.f_38839_.get(2 + i)).m_6657_() && this.f_97734_ == container.f_38839_.get(11 + i)) {
                this.m_6057_(pPoseStack, ((Slot)container.f_38839_.get(2 + i)).m_7993_(), pX, pY);
            }
        }
        if (((Slot)container.f_38839_.get(0)).m_6657_() && ((Slot)container.f_38839_.get(0)).m_7993_().m_150922_((Tag)ItemTagGenerator.BANNED_UNCRAFTABLES) && container.f_38839_.get(0).equals(this.f_97734_)) {
            this.m_96602_(pPoseStack, (Component)new TranslatableComponent("container.uncrafting_table.disabled_item").m_130940_(ChatFormatting.RED), pX, pY);
        }
        else {
            super.m_7025_(pPoseStack, pX, pY);
        }
    }
    
    static {
        textureLoc = TwilightForestMod.getGuiTexture("guigoblintinkering.png");
    }
    
    private static class CycleButton extends Button
    {
        private final boolean up;
        
        CycleButton(final int x, final int y, final boolean up, final Button.OnPress onClick) {
            super(x, y, 14, 9, TextComponent.f_131282_, onClick);
            this.up = up;
        }
        
        public void m_6303_(final PoseStack ms, final int mouseX, final int mouseY, final float partialTicks) {
            if (this.f_93624_) {
                RenderSystem.m_157179_(0, UncraftingGui.textureLoc);
                RenderSystem.m_157429_(1.0f, 1.0f, 1.0f, 1.0f);
                this.f_93622_ = (mouseX >= this.f_93620_ && mouseY >= this.f_93621_ && mouseX < this.f_93620_ + this.f_93618_ && mouseY < this.f_93621_ + this.f_93619_);
                int textureX = 176;
                int textureY = 0;
                if (this.f_93622_) {
                    textureX += this.f_93618_;
                }
                if (!this.up) {
                    textureY += this.f_93619_;
                }
                this.m_93228_(ms, this.f_93620_, this.f_93621_, textureX, textureY, this.f_93618_, this.f_93619_);
            }
        }
    }
    
    private static class CycleButtonMini extends Button
    {
        private final boolean up;
        
        CycleButtonMini(final int x, final int y, final boolean up, final Button.OnPress onClick) {
            super(x, y, 8, 6, TextComponent.f_131282_, onClick);
            this.up = up;
        }
        
        public void m_6303_(final PoseStack ms, final int mouseX, final int mouseY, final float partialTicks) {
            if (this.f_93624_) {
                RenderSystem.m_157179_(0, UncraftingGui.textureLoc);
                RenderSystem.m_157429_(1.0f, 1.0f, 1.0f, 1.0f);
                this.f_93622_ = (mouseX >= this.f_93620_ && mouseY >= this.f_93621_ && mouseX < this.f_93620_ + this.f_93618_ && mouseY < this.f_93621_ + this.f_93619_);
                int textureX = 176;
                int textureY = 41;
                if (this.f_93622_) {
                    textureX += this.f_93618_;
                }
                if (!this.up) {
                    textureY += this.f_93619_;
                }
                this.m_93228_(ms, this.f_93620_, this.f_93621_, textureX, textureY, this.f_93618_, this.f_93619_);
            }
        }
    }
}
