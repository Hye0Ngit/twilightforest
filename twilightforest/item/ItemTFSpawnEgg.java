// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.block.Block;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.entity.TFCreatures;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemMonsterPlacer;

public class ItemTFSpawnEgg extends ItemMonsterPlacer
{
    protected ItemTFSpawnEgg(final int par1) {
        super(par1);
        this.func_77627_a(true);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_82790_a(final ItemStack par1ItemStack, final int par2) {
        final EntityEggInfo var3 = TFCreatures.entityEggs.get(par1ItemStack.func_77960_j());
        return (var3 != null) ? ((par2 == 0) ? var3.field_75611_b : var3.field_75612_c) : 16777215;
    }
    
    @SideOnly(Side.CLIENT)
    public String func_77628_j(final ItemStack par1ItemStack) {
        String prefix = ("" + StatCollector.func_74838_a(this.func_77658_a() + ".name")).trim();
        final String entityname = TFCreatures.getStringFromID(par1ItemStack.func_77960_j());
        if (entityname != null) {
            prefix = prefix + " " + StatCollector.func_74838_a(String.format("entity.%s.%s.name", "TwilightForest", entityname));
        }
        return prefix;
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, int par4, int par5, int par6, final int par7, final float par8, final float par9, final float par10) {
        if (par3World.field_72995_K) {
            return true;
        }
        final int var11 = par3World.func_72798_a(par4, par5, par6);
        par4 += Facing.field_71586_b[par7];
        par5 += Facing.field_71587_c[par7];
        par6 += Facing.field_71585_d[par7];
        double var12 = 0.0;
        if ((par7 == 1 && var11 == Block.field_72031_aZ.field_71990_ca) || var11 == Block.field_72098_bB.field_71990_ca) {
            var12 = 0.5;
        }
        final Entity entity = spawnCreature(par3World, par1ItemStack.func_77960_j(), par4 + 0.5, par5 + var12, par6 + 0.5);
        if (entity != null) {
            if (entity instanceof EntityLiving && par1ItemStack.func_82837_s()) {
                ((EntityLiving)entity).func_94058_c(par1ItemStack.func_82833_r());
            }
            if (!par2EntityPlayer.field_71075_bZ.field_75098_d) {
                --par1ItemStack.field_77994_a;
            }
        }
        return true;
    }
    
    public static Entity spawnCreature(final World par0World, final int par1, final double par2, final double par4, final double par6) {
        if (!TFCreatures.entityEggs.containsKey(par1)) {
            return null;
        }
        final Entity entityToSpawn = TFCreatures.createEntityByID(par1, par0World);
        if (entityToSpawn != null) {
            entityToSpawn.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            ((EntityLiving)entityToSpawn).func_82163_bD();
            par0World.func_72838_d(entityToSpawn);
            ((EntityLiving)entityToSpawn).func_70642_aH();
        }
        return entityToSpawn;
    }
    
    public void func_77633_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        for (final EntityEggInfo var5 : TFCreatures.entityEggs.values()) {
            par3List.add(new ItemStack(par1, 1, var5.field_75613_a));
        }
    }
    
    public Icon func_77618_c(final int par1, final int par2) {
        return Item.field_77815_bC.func_77618_c(par1, par2);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
    }
}
