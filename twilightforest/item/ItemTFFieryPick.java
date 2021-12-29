// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import twilightforest.TwilightForestMod;

public class ItemTFFieryPick extends uy
{
    protected ItemTFFieryPick(final int par1, final uq par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((tj)TFItems.creativeTab);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public boolean a(final ur par1ItemStack, final yc par2World, final int blockID, final int x, final int y, final int z, final md par7EntityLiving) {
        if (super.a(par1ItemStack, par2World, blockID, x, y, z, par7EntityLiving)) {
            final int meta = par2World.h(x, y, z);
            final ArrayList items = amq.p[blockID].getBlockDropped(par2World, x, y, z, meta, 0);
            for (final ur input : items) {
                final ur result = wj.a().getSmeltingResult(input);
                if (result != null) {
                    if (!par2World.I) {
                        final float floatXP = wj.a().c(result.c);
                        int smeltXP = (int)floatXP;
                        if (floatXP > smeltXP && par2World.t.nextFloat() < floatXP - smeltXP) {
                            ++smeltXP;
                        }
                        while (smeltXP > 0) {
                            final int splitXP = lz.a(smeltXP);
                            smeltXP -= splitXP;
                            par2World.d((lq)new lz(par2World, x + 0.5, y + 0.5, z + 0.5, splitXP));
                        }
                        par2World.d((lq)new px(par2World, x + 0.5, y + 0.5, z + 0.5, result.l()));
                        TwilightForestMod.eventListener.supressDrop(input);
                    }
                    else {
                        for (int var1 = 0; var1 < 5; ++var1) {
                            final double rx = up.d.nextGaussian() * 0.02;
                            final double ry = up.d.nextGaussian() * 0.02;
                            final double rz = up.d.nextGaussian() * 0.02;
                            final double magnitude = 20.0;
                            par2World.a("flame", x + 0.5 + rx * magnitude, y + 0.5 + ry * magnitude, z + 0.5 + rz * magnitude, -rx, -ry, -rz);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean a(final ur par1ItemStack, final md par2EntityLiving, final md par3EntityLiving) {
        final boolean result = super.a(par1ItemStack, par2EntityLiving, par3EntityLiving);
        if (result && !par2EntityLiving.F()) {
            if (par2EntityLiving.p.I) {
                for (int var1 = 0; var1 < 20; ++var1) {
                    final double var2 = up.d.nextGaussian() * 0.02;
                    final double var3 = up.d.nextGaussian() * 0.02;
                    final double var4 = up.d.nextGaussian() * 0.02;
                    final double var5 = 10.0;
                    par2EntityLiving.p.a("flame", par2EntityLiving.t + up.d.nextFloat() * par2EntityLiving.N * 2.0f - par2EntityLiving.N - var2 * var5, par2EntityLiving.u + up.d.nextFloat() * par2EntityLiving.O - var3 * var5, par2EntityLiving.v + up.d.nextFloat() * par2EntityLiving.N * 2.0f - par2EntityLiving.N - var4 * var5, var2, var3, var4);
                }
            }
            else {
                par2EntityLiving.c(15);
            }
        }
        return result;
    }
    
    public vb f(final ur par1ItemStack) {
        return vb.c;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ur par1ItemStack, final qx par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add("Auto-smelting");
    }
    
    public boolean a(final ur par1ItemStack, final ur par2ItemStack) {
        return par2ItemStack.c == TFItems.fieryIngot.cj || super.a(par1ItemStack, par2ItemStack);
    }
}
