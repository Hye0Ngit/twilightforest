// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.Iterator;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.entity.TFCreatures;

public class ItemTFSpawnEgg extends wm
{
    protected ItemTFSpawnEgg(final int par1) {
        super(par1);
        this.a(true);
        this.a((uy)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public int a(final wg par1ItemStack, final int par2) {
        final mw var3 = TFCreatures.entityEggs.get(par1ItemStack.k());
        return (var3 != null) ? ((par2 == 0) ? var3.b : var3.c) : 16777215;
    }
    
    @SideOnly(Side.CLIENT)
    public String l(final wg par1ItemStack) {
        String prefix = ("" + bo.a(this.a() + ".name")).trim();
        final String entityname = TFCreatures.getStringFromID(par1ItemStack.k());
        if (entityname != null) {
            prefix = prefix + " " + bo.a(String.format("entity.%s.%s.name", "TwilightForest", entityname));
        }
        return prefix;
    }
    
    public boolean a(final wg par1ItemStack, final sk par2EntityPlayer, final zv par3World, int par4, int par5, int par6, final int par7, final float par8, final float par9, final float par10) {
        if (par3World.I) {
            return true;
        }
        final int var11 = par3World.a(par4, par5, par6);
        par4 += s.b[par7];
        par5 += s.c[par7];
        par6 += s.d[par7];
        double var12 = 0.0;
        if ((par7 == 1 && var11 == aou.bd.cz) || var11 == aou.bF.cz) {
            var12 = 0.5;
        }
        if (spawnCreature(par3World, par1ItemStack.k(), par4 + 0.5, par5 + var12, par6 + 0.5) != null && !par2EntityPlayer.ce.d) {
            --par1ItemStack.a;
        }
        return true;
    }
    
    public static mp spawnCreature(final zv par0World, final int par1, final double par2, final double par4, final double par6) {
        if (!TFCreatures.entityEggs.containsKey(par1)) {
            return null;
        }
        final mp entityToSpawn = TFCreatures.createEntityByID(par1, par0World);
        if (entityToSpawn != null) {
            entityToSpawn.b(par2, par4, par6, par0World.s.nextFloat() * 360.0f, 0.0f);
            ((ng)entityToSpawn).bJ();
            par0World.d(entityToSpawn);
            ((ng)entityToSpawn).aR();
        }
        return entityToSpawn;
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        for (final mw var5 : TFCreatures.entityEggs.values()) {
            par3List.add(new wg(par1, 1, var5.a));
        }
    }
    
    public lx a(final int par1, final int par2) {
        return we.bD.a(par1, par2);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
    }
}
