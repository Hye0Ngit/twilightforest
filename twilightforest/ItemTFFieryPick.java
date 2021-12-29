// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItemTFFieryPick extends ut
{
    protected ItemTFFieryPick(final int par1, final ul par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public boolean a(final um par1ItemStack, final xv par2World, final int blockID, final int x, final int y, final int z, final md par7EntityLiving) {
        if (super.a(par1ItemStack, par2World, blockID, x, y, z, par7EntityLiving)) {
            final int meta = par2World.h(x, y, z);
            final ArrayList items = amj.p[blockID].getBlockDropped(par2World, x, y, z, meta, 0);
            for (final um input : items) {
                final um result = wd.a().getSmeltingResult(input);
                if (result != null) {
                    if (!par2World.J) {
                        final float floatXP = wd.a().c(result.c);
                        int smeltXP = (int)floatXP;
                        if (floatXP > smeltXP && par2World.u.nextFloat() < floatXP - smeltXP) {
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
                            final double rx = ItemTFFieryPick.d.nextGaussian() * 0.02;
                            final double ry = ItemTFFieryPick.d.nextGaussian() * 0.02;
                            final double rz = ItemTFFieryPick.d.nextGaussian() * 0.02;
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
    
    public boolean a(final um par1ItemStack, final md par2EntityLiving, final md par3EntityLiving) {
        final boolean result = super.a(par1ItemStack, par2EntityLiving, par3EntityLiving);
        if (result && !par2EntityLiving.F()) {
            if (par2EntityLiving.p.J) {
                for (int var1 = 0; var1 < 20; ++var1) {
                    final double var2 = ItemTFFieryPick.d.nextGaussian() * 0.02;
                    final double var3 = ItemTFFieryPick.d.nextGaussian() * 0.02;
                    final double var4 = ItemTFFieryPick.d.nextGaussian() * 0.02;
                    final double var5 = 10.0;
                    par2EntityLiving.p.a("flame", par2EntityLiving.t + ItemTFFieryPick.d.nextFloat() * par2EntityLiving.N * 2.0f - par2EntityLiving.N - var2 * var5, par2EntityLiving.u + ItemTFFieryPick.d.nextFloat() * par2EntityLiving.O - var3 * var5, par2EntityLiving.v + ItemTFFieryPick.d.nextFloat() * par2EntityLiving.N * 2.0f - par2EntityLiving.N - var4 * var5, var2, var3, var4);
                }
            }
            else {
                par2EntityLiving.c(15);
            }
        }
        return result;
    }
    
    public uw e(final um par1ItemStack) {
        return uw.c;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final um par1ItemStack, final qx par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add("Auto-smelting");
    }
    
    public boolean a(final um par1ItemStack, final um par2ItemStack) {
        return par2ItemStack.c == TFItems.fieryIngot.cg || super.a(par1ItemStack, par2ItemStack);
    }
}
