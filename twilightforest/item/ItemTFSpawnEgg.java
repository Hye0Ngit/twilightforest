// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.Iterator;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.entity.TFCreatures;

public class ItemTFSpawnEgg extends uw
{
    protected ItemTFSpawnEgg(final int par1) {
        super(par1);
        this.a(true);
        this.a((tj)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public int a(final ur par1ItemStack, final int par2) {
        final lw var3 = TFCreatures.entityEggs.get(par1ItemStack.j());
        return (var3 != null) ? ((par2 == 0) ? var3.b : var3.c) : 16777215;
    }
    
    @SideOnly(Side.CLIENT)
    public String l(final ur par1ItemStack) {
        String prefix = ("" + bm.a(this.a() + ".name")).trim();
        final String entityname = TFCreatures.getStringFromID(par1ItemStack.j());
        if (entityname != null) {
            prefix = prefix + " " + bm.a("entity." + entityname + ".name");
        }
        return prefix;
    }
    
    public boolean a(final ur par1ItemStack, final qx par2EntityPlayer, final yc par3World, int par4, int par5, int par6, final int par7, final float par8, final float par9, final float par10) {
        if (par3World.I) {
            return true;
        }
        final int var11 = par3World.a(par4, par5, par6);
        par4 += r.b[par7];
        par5 += r.c[par7];
        par6 += r.d[par7];
        double var12 = 0.0;
        if ((par7 == 1 && var11 == amq.bc.cm) || var11 == amq.bE.cm) {
            var12 = 0.5;
        }
        if (spawnCreature(par3World, par1ItemStack.j(), par4 + 0.5, par5 + var12, par6 + 0.5) != null && !par2EntityPlayer.cd.d) {
            --par1ItemStack.a;
        }
        return true;
    }
    
    public static lq spawnCreature(final yc par0World, final int par1, final double par2, final double par4, final double par6) {
        if (!TFCreatures.entityEggs.containsKey(par1)) {
            return null;
        }
        final lq entityToSpawn = TFCreatures.createEntityByID(par1, par0World);
        if (entityToSpawn != null) {
            entityToSpawn.b(par2, par4, par6, par0World.t.nextFloat() * 360.0f, 0.0f);
            ((md)entityToSpawn).bG();
            par0World.d(entityToSpawn);
            ((md)entityToSpawn).aO();
        }
        return entityToSpawn;
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        for (final lw var5 : TFCreatures.entityEggs.values()) {
            par3List.add(new ur(par1, 1, var5.a));
        }
    }
}
