// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.potions;

import twilightforest.TwilightForestMod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.GuiUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import java.util.UUID;
import net.minecraft.potion.Potion;

public class PotionFrosted extends Potion
{
    public static final UUID MODIFIER_UUID;
    private static final ResourceLocation sprite;
    
    public PotionFrosted(final boolean isBadEffectIn, final int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
    }
    
    @SideOnly(Side.CLIENT)
    public void renderHUDEffect(final PotionEffect effect, final Gui gui, final int x, final int y, final float z, final float alpha) {
        Minecraft.func_71410_x().field_71446_o.func_110577_a(PotionFrosted.sprite);
        GuiUtils.drawModalRectWithCustomSizedTexture(x + 3, y + 3, z, 0.0f, 0.0f, 18, 18, 18.0f, 18.0f);
    }
    
    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(final PotionEffect effect, final Gui gui, final int x, final int y, final float z) {
        Minecraft.func_71410_x().field_71446_o.func_110577_a(PotionFrosted.sprite);
        GuiUtils.drawModalRectWithCustomSizedTexture(x + 6, y + 7, z, 0.0f, 0.0f, 18, 18, 18.0f, 18.0f);
    }
    
    static {
        MODIFIER_UUID = UUID.fromString("CE9DBC2A-EE3F-43F5-9DF7-F7F1EE4915A9");
        sprite = TwilightForestMod.prefix("textures/gui/frosty.png");
    }
}
