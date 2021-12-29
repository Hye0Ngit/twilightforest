// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.storage.MapData;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.world.WorldSavedData;
import twilightforest.TFMagicMapData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemMapBase;

public class ItemTFEmptyMagicMap extends ItemMapBase
{
    protected ItemTFEmptyMagicMap(final int par1) {
        super(par1);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final ItemStack mapItem = new ItemStack(TFItems.magicMap, 1, par2World.func_72841_b("magicmap"));
        final String mapName = "magicmap_" + mapItem.func_77960_j();
        final MapData mapData = new TFMagicMapData(mapName);
        par2World.func_72823_a(mapName, (WorldSavedData)mapData);
        mapData.field_76197_d = 4;
        final int step = 128 * (1 << mapData.field_76197_d);
        mapData.field_76201_a = (int)(Math.round(par3EntityPlayer.field_70165_t / step) * step);
        mapData.field_76199_b = (int)(Math.round(par3EntityPlayer.field_70161_v / step) * step);
        mapData.field_76200_c = (byte)par2World.field_73011_w.field_76574_g;
        mapData.func_76185_a();
        --par1ItemStack.field_77994_a;
        if (mapItem.field_77993_c == TFItems.magicMap.field_77779_bT) {
            par3EntityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightMagicMap);
        }
        if (par1ItemStack.field_77994_a <= 0) {
            return mapItem;
        }
        if (!par3EntityPlayer.field_71071_by.func_70441_a(mapItem.func_77946_l())) {
            par3EntityPlayer.func_71021_b(mapItem);
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
    }
}
