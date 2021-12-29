// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.Minecraft;
import twilightforest.TwilightForestMod;
import java.io.IOException;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import twilightforest.network.PacketUncraftingGui;
import twilightforest.network.TFPacketHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.inventory.Slot;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import twilightforest.block.TFBlocks;
import net.minecraft.inventory.Container;
import twilightforest.inventory.ContainerTFUncrafting;
import net.minecraft.world.World;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiTFGoblinCrafting extends GuiContainer
{
    private static final ResourceLocation textureLoc;
    
    public GuiTFGoblinCrafting(final InventoryPlayer inventory, final World world, final int x, final int y, final int z) {
        super((Container)new ContainerTFUncrafting(inventory, world, x, y, z));
    }
    
    public void func_73866_w_() {
        super.func_73866_w_();
        int id = 0;
        this.field_146292_n.add(new CycleButton(++id, this.field_147003_i + 40, this.field_147009_r + 22, true, false));
        this.field_146292_n.add(new CycleButton(++id, this.field_147003_i + 40, this.field_147009_r + 55, false, false));
        this.field_146292_n.add(new CycleButtonMini(++id, this.field_147003_i + 27, this.field_147009_r + 56, true));
        this.field_146292_n.add(new CycleButtonMini(++id, this.field_147003_i + 27, this.field_147009_r + 63, false));
        this.field_146292_n.add(new CycleButton(++id, this.field_147003_i + 121, this.field_147009_r + 22, true, true));
        this.field_146292_n.add(new CycleButton(++id, this.field_147003_i + 121, this.field_147009_r + 55, false, true));
    }
    
    public void func_73863_a(final int mouseX, final int mouseY, final float partialTicks) {
        this.func_146276_q_();
        super.func_73863_a(mouseX, mouseY, partialTicks);
        this.func_191948_b(mouseX, mouseY);
    }
    
    protected void func_146979_b(final int mouseX, final int mouseY) {
        this.field_146289_q.func_78276_b(I18n.func_135052_a(TFBlocks.uncrafting_table.func_149739_a() + ".name", new Object[0]), 8, 6, 4210752);
        this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
    }
    
    protected void func_146976_a(final float partialTicks, final int mouseX, final int mouseY) {
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_146297_k.func_110434_K().func_110577_a(GuiTFGoblinCrafting.textureLoc);
        final int frameX = (this.field_146294_l - this.field_146999_f) / 2;
        final int frameY = (this.field_146295_m - this.field_147000_g) / 2;
        this.func_73729_b(frameX, frameY, 0, 0, this.field_146999_f, this.field_147000_g);
        final ContainerTFUncrafting tfContainer = (ContainerTFUncrafting)this.field_147002_h;
        RenderHelper.func_74520_c();
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b((float)this.field_147003_i, (float)this.field_147009_r, 0.0f);
        for (int i = 0; i < 9; ++i) {
            final Slot uncrafting = tfContainer.func_75139_a(2 + i);
            final Slot assembly = tfContainer.func_75139_a(11 + i);
            if (uncrafting.func_75216_d()) {
                this.drawSlotAsBackground(uncrafting, assembly);
            }
        }
        GlStateManager.func_179121_F();
        final FontRenderer fontRendererObj = this.field_146297_k.field_71466_p;
        RenderHelper.func_74518_a();
        int costVal = tfContainer.getUncraftingCost();
        if (costVal > 0) {
            if (this.field_146297_k.field_71439_g.field_71068_ca < costVal && !this.field_146297_k.field_71439_g.field_71075_bZ.field_75098_d) {
                final int color = 10485760;
                final String cost = "" + costVal;
                fontRendererObj.func_175063_a(cost, (float)(frameX + 48 - fontRendererObj.func_78256_a(cost)), (float)(frameY + 38), color);
            }
            else {
                final int color = 8453920;
                final String cost = "" + costVal;
                fontRendererObj.func_175063_a(cost, (float)(frameX + 48 - fontRendererObj.func_78256_a(cost)), (float)(frameY + 38), color);
            }
        }
        costVal = tfContainer.getRecraftingCost();
        if (costVal > 0) {
            if (this.field_146297_k.field_71439_g.field_71068_ca < costVal && !this.field_146297_k.field_71439_g.field_71075_bZ.field_75098_d) {
                final int color = 10485760;
                final String cost = "" + costVal;
                fontRendererObj.func_175063_a(cost, (float)(frameX + 130 - fontRendererObj.func_78256_a(cost)), (float)(frameY + 38), color);
            }
            else {
                final int color = 8453920;
                final String cost = "" + costVal;
                fontRendererObj.func_175063_a(cost, (float)(frameX + 130 - fontRendererObj.func_78256_a(cost)), (float)(frameY + 38), color);
            }
        }
    }
    
    private void drawSlotAsBackground(final Slot backgroundSlot, final Slot appearSlot) {
        final int screenX = appearSlot.field_75223_e;
        final int screenY = appearSlot.field_75221_f;
        final ItemStack itemStackToRender = backgroundSlot.func_75211_c();
        this.field_73735_i = 50.0f;
        this.field_146296_j.field_77023_b = 50.0f;
        this.field_146296_j.func_175042_a(itemStackToRender, screenX, screenY);
        this.field_146296_j.func_180453_a(this.field_146289_q, itemStackToRender, screenX, screenY, "");
        final boolean itemBroken = ContainerTFUncrafting.isMarked(itemStackToRender);
        GlStateManager.func_179140_f();
        GlStateManager.func_179097_i();
        Gui.func_73734_a(screenX, screenY, screenX + 16, screenY + 16, itemBroken ? -2130736245 : -1618244725);
        GlStateManager.func_179145_e();
        GlStateManager.func_179126_j();
        this.field_146296_j.field_77023_b = 0.0f;
        this.field_73735_i = 0.0f;
    }
    
    protected void func_146284_a(final GuiButton button) throws IOException {
        super.func_146284_a(button);
        if (this.field_147002_h instanceof ContainerTFUncrafting) {
            final ContainerTFUncrafting uncrafting = (ContainerTFUncrafting)this.field_147002_h;
            if (button instanceof CycleButton) {
                final CycleButton cycleButton = (CycleButton)button;
                if (cycleButton.constructive) {
                    TFPacketHandler.CHANNEL.sendToServer((IMessage)new PacketUncraftingGui(cycleButton.up ? 4 : 5));
                    if (((CycleButton)button).up) {
                        final ContainerTFUncrafting containerTFUncrafting = uncrafting;
                        ++containerTFUncrafting.recipeInCycle;
                    }
                    else {
                        final ContainerTFUncrafting containerTFUncrafting2 = uncrafting;
                        --containerTFUncrafting2.recipeInCycle;
                    }
                    uncrafting.func_75130_a((IInventory)uncrafting.assemblyMatrix);
                }
                else {
                    TFPacketHandler.CHANNEL.sendToServer((IMessage)new PacketUncraftingGui(cycleButton.up ? 0 : 1));
                    if (((CycleButton)button).up) {
                        final ContainerTFUncrafting containerTFUncrafting3 = uncrafting;
                        ++containerTFUncrafting3.unrecipeInCycle;
                    }
                    else {
                        final ContainerTFUncrafting containerTFUncrafting4 = uncrafting;
                        --containerTFUncrafting4.unrecipeInCycle;
                    }
                    uncrafting.func_75130_a(uncrafting.tinkerInput);
                }
            }
            if (button instanceof CycleButtonMini) {
                TFPacketHandler.CHANNEL.sendToServer((IMessage)new PacketUncraftingGui(((CycleButtonMini)button).up ? 2 : 3));
                if (((CycleButtonMini)button).up) {
                    final ContainerTFUncrafting containerTFUncrafting5 = uncrafting;
                    ++containerTFUncrafting5.ingredientsInCycle;
                }
                else {
                    final ContainerTFUncrafting containerTFUncrafting6 = uncrafting;
                    --containerTFUncrafting6.ingredientsInCycle;
                }
                uncrafting.func_75130_a(uncrafting.tinkerInput);
            }
            this.field_146292_n.clear();
            this.func_73866_w_();
            this.func_73876_c();
        }
    }
    
    static {
        textureLoc = TwilightForestMod.getGuiTexture("guigoblintinkering.png");
    }
    
    private static class CycleButton extends GuiButton
    {
        private final boolean up;
        private final boolean constructive;
        
        CycleButton(final int buttonId, final int x, final int y, final boolean up, final boolean constructive) {
            super(buttonId, x, y, 14, 9, "");
            this.up = up;
            this.constructive = constructive;
        }
        
        public void func_191745_a(final Minecraft mc, final int mouseX, final int mouseY, final float partialTicks) {
            if (this.field_146125_m) {
                mc.func_110434_K().func_110577_a(GuiTFGoblinCrafting.textureLoc);
                GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
                this.field_146123_n = (mouseX >= this.field_146128_h && mouseY >= this.field_146129_i && mouseX < this.field_146128_h + this.field_146120_f && mouseY < this.field_146129_i + this.field_146121_g);
                int textureX = 176;
                int textureY = 0;
                if (this.field_146123_n) {
                    textureX += this.field_146120_f;
                }
                if (!this.up) {
                    textureY += this.field_146121_g;
                }
                this.func_73729_b(this.field_146128_h, this.field_146129_i, textureX, textureY, this.field_146120_f, this.field_146121_g);
            }
        }
    }
    
    private class CycleButtonMini extends GuiButton
    {
        private final boolean up;
        
        CycleButtonMini(final int buttonId, final int x, final int y, final boolean up) {
            super(buttonId, x, y, 8, 6, "");
            this.up = up;
        }
        
        public void func_191745_a(final Minecraft mc, final int mouseX, final int mouseY, final float partialTicks) {
            if (this.field_146125_m) {
                mc.func_110434_K().func_110577_a(GuiTFGoblinCrafting.textureLoc);
                GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
                this.field_146123_n = (mouseX >= this.field_146128_h && mouseY >= this.field_146129_i && mouseX < this.field_146128_h + this.field_146120_f && mouseY < this.field_146129_i + this.field_146121_g);
                int textureX = 176;
                int textureY = 41;
                if (this.field_146123_n) {
                    textureX += this.field_146120_f;
                }
                if (!this.up) {
                    textureY += this.field_146121_g;
                }
                this.func_73729_b(this.field_146128_h, this.field_146129_i, textureX, textureY, this.field_146120_f, this.field_146121_g);
            }
        }
    }
}
