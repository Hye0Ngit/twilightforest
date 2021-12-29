// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.MathHelper;
import net.minecraft.world.WorldSavedData;
import twilightforest.TFMazeMapData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemMapBase;

public class ItemTFEmptyMazeMap extends ItemMapBase
{
    boolean mapOres;
    
    protected ItemTFEmptyMazeMap(final int par1, final boolean mapOres) {
        super(par1);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.mapOres = mapOres;
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final ItemStack mapItem = new ItemStack(this.mapOres ? TFItems.oreMap : TFItems.mazeMap, 1, par2World.func_72841_b("mazemap"));
        final String var5 = "mazemap_" + mapItem.func_77960_j();
        final TFMazeMapData mapData = new TFMazeMapData(var5);
        par2World.func_72823_a(var5, (WorldSavedData)mapData);
        mapData.field_76197_d = 0;
        final int step = 128 * (1 << mapData.field_76197_d);
        mapData.field_76201_a = (int)(Math.round(par3EntityPlayer.field_70165_t / step) * step) + 10;
        mapData.field_76199_b = (int)(Math.round(par3EntityPlayer.field_70161_v / step) * step) + 10;
        mapData.yCenter = MathHelper.func_76128_c(par3EntityPlayer.field_70163_u);
        mapData.field_76200_c = par2World.field_73011_w.field_76574_g;
        mapData.func_76185_a();
        --par1ItemStack.field_77994_a;
        if (mapItem.field_77993_c == TFItems.mazeMap.field_77779_bT) {
            par3EntityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightMazeMap);
        }
        if (mapItem.field_77993_c == TFItems.oreMap.field_77779_bT) {
            par3EntityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightOreMap);
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
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
