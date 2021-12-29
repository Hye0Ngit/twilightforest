// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import twilightforest.TFFeature;
import net.minecraft.util.MathHelper;
import twilightforest.world.WorldProviderTwilightForest;
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
    
    protected ItemTFEmptyMazeMap(final boolean mapOres) {
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
        if (par2World.field_73011_w instanceof WorldProviderTwilightForest && TFFeature.getFeatureForRegion(MathHelper.func_76128_c(par3EntityPlayer.field_70165_t) >> 4, MathHelper.func_76128_c(par3EntityPlayer.field_70161_v) >> 4, par2World) == TFFeature.labyrinth) {
            final ChunkCoordinates mc = TFFeature.getNearestCenterXYZ(MathHelper.func_76128_c(par3EntityPlayer.field_70165_t) >> 4, MathHelper.func_76128_c(par3EntityPlayer.field_70161_v) >> 4, par2World);
            mapData.field_76201_a = mc.field_71574_a;
            mapData.field_76199_b = mc.field_71573_c;
            mapData.yCenter = MathHelper.func_76128_c(par3EntityPlayer.field_70163_u);
        }
        else {
            mapData.field_76201_a = (int)(Math.round(par3EntityPlayer.field_70165_t / step) * step) + 10;
            mapData.field_76199_b = (int)(Math.round(par3EntityPlayer.field_70161_v / step) * step) + 10;
            mapData.yCenter = MathHelper.func_76128_c(par3EntityPlayer.field_70163_u);
        }
        mapData.field_76200_c = par2World.field_73011_w.field_76574_g;
        mapData.func_76185_a();
        --par1ItemStack.field_77994_a;
        if (mapItem.func_77973_b() == TFItems.mazeMap) {
            par3EntityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightMazeMap);
        }
        if (mapItem.func_77973_b() == TFItems.oreMap) {
            par3EntityPlayer.func_71029_a((StatBase)TFAchievementPage.twilightOreMap);
        }
        if (par1ItemStack.field_77994_a <= 0) {
            return mapItem;
        }
        if (!par3EntityPlayer.field_71071_by.func_70441_a(mapItem.func_77946_l())) {
            par3EntityPlayer.func_71019_a(mapItem, false);
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
