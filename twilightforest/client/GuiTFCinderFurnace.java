// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.World;
import net.minecraft.inventory.Container;
import twilightforest.inventory.ContainerTFCinderFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import twilightforest.tileentity.TileEntityTFCinderFurnace;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;

@SideOnly(Side.CLIENT)
public class GuiTFCinderFurnace extends GuiContainer
{
    private static final ResourceLocation furnaceGuiTextures;
    private TileEntityTFCinderFurnace tileFurnace;
    
    public GuiTFCinderFurnace(final InventoryPlayer inventory, final TileEntityTFCinderFurnace furnace) {
        super((Container)new ContainerTFCinderFurnace(inventory, furnace));
        this.tileFurnace = furnace;
    }
    
    public GuiTFCinderFurnace(final InventoryPlayer inventory, final World world, final int x, final int y, final int z) {
        this(inventory, (TileEntityTFCinderFurnace)world.func_147438_o(x, y, z));
    }
    
    protected void func_146979_b(final int p_146979_1_, final int p_146979_2_) {
        final String s = this.tileFurnace.func_145818_k_() ? this.tileFurnace.func_145825_b() : I18n.func_135052_a(this.tileFurnace.func_145825_b(), new Object[0]);
        this.field_146289_q.func_78276_b(s, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(s) / 2, 6, 4210752);
        this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
    }
    
    protected void func_146976_a(final float p_146976_1_, final int p_146976_2_, final int p_146976_3_) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_146297_k.func_110434_K().func_110577_a(GuiTFCinderFurnace.furnaceGuiTextures);
        final int k = (this.field_146294_l - this.field_146999_f) / 2;
        final int l = (this.field_146295_m - this.field_147000_g) / 2;
        this.func_73729_b(k, l, 0, 0, this.field_146999_f, this.field_147000_g);
        if (this.tileFurnace.isBurning()) {
            int i1 = this.tileFurnace.getBurnTimeRemainingScaled(13);
            this.func_73729_b(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
            i1 = this.tileFurnace.getCookProgressScaled(24);
            this.func_73729_b(k + 79, l + 34, 176, 14, i1 + 1, 16);
        }
    }
    
    static {
        furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
    }
}
