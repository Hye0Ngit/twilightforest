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

public class ItemTFFieryPick extends wo
{
    protected ItemTFFieryPick(final int par1, final wf par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((uy)TFItems.creativeTab);
    }
    
    public boolean a(final wg par1ItemStack, final zv par2World, final int blockID, final int x, final int y, final int z, final ng par7EntityLiving) {
        if (super.a(par1ItemStack, par2World, blockID, x, y, z, par7EntityLiving)) {
            final int meta = par2World.h(x, y, z);
            final ArrayList items = aou.r[blockID].getBlockDropped(par2World, x, y, z, meta, 0);
            for (final wg input : items) {
                final wg result = ya.a().getSmeltingResult(input);
                if (result != null) {
                    if (!par2World.I) {
                        final float floatXP = ya.a().c(result.c);
                        int smeltXP = (int)floatXP;
                        if (floatXP > smeltXP && par2World.s.nextFloat() < floatXP - smeltXP) {
                            ++smeltXP;
                        }
                        while (smeltXP > 0) {
                            final int splitXP = nc.a(smeltXP);
                            smeltXP -= splitXP;
                            par2World.d((mp)new nc(par2World, x + 0.5, y + 0.5, z + 0.5, splitXP));
                        }
                        par2World.d((mp)new rb(par2World, x + 0.5, y + 0.5, z + 0.5, result.m()));
                        TwilightForestMod.eventListener.supressDrop(input);
                    }
                    else {
                        for (int var1 = 0; var1 < 5; ++var1) {
                            final double rx = we.e.nextGaussian() * 0.02;
                            final double ry = we.e.nextGaussian() * 0.02;
                            final double rz = we.e.nextGaussian() * 0.02;
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
    
    public boolean a(final wg par1ItemStack, final ng par2EntityLiving, final ng par3EntityLiving) {
        final boolean result = super.a(par1ItemStack, par2EntityLiving, par3EntityLiving);
        if (result && !par2EntityLiving.E()) {
            if (par2EntityLiving.q.I) {
                for (int var1 = 0; var1 < 20; ++var1) {
                    final double var2 = we.e.nextGaussian() * 0.02;
                    final double var3 = we.e.nextGaussian() * 0.02;
                    final double var4 = we.e.nextGaussian() * 0.02;
                    final double var5 = 10.0;
                    par2EntityLiving.q.a("flame", par2EntityLiving.u + we.e.nextFloat() * par2EntityLiving.O * 2.0f - par2EntityLiving.O - var2 * var5, par2EntityLiving.v + we.e.nextFloat() * par2EntityLiving.P - var3 * var5, par2EntityLiving.w + we.e.nextFloat() * par2EntityLiving.O * 2.0f - par2EntityLiving.O - var4 * var5, var2, var3, var4);
                }
            }
            else {
                par2EntityLiving.d(15);
            }
        }
        return result;
    }
    
    public wr f(final wg par1ItemStack) {
        return wr.c;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final wg par1ItemStack, final sk par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add("Auto-smelting");
    }
    
    public boolean a(final wg par1ItemStack, final wg par2ItemStack) {
        return par2ItemStack.c == TFItems.fieryIngot.cp || super.a(par1ItemStack, par2ItemStack);
    }
    
    public boolean a(final aou par1Block) {
        return par1Block == aou.at || super.a(par1Block);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
