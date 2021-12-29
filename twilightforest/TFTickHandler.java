// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.stats.StatBase;
import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTFPortal;
import net.minecraft.util.MathHelper;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import cpw.mods.fml.common.IScheduledTickHandler;

public class TFTickHandler implements IScheduledTickHandler
{
    private EnumSet ticks;
    
    public TFTickHandler() {
        this.ticks = EnumSet.of(TickType.PLAYER);
    }
    
    public void tickStart(final EnumSet type, final Object... tickData) {
        final EntityPlayer player = (EntityPlayer)tickData[0];
        final World world = player.field_70170_p;
        double rangeToCheck = 32.0;
        if (TwilightForestMod.disablePortalCreation) {
            return;
        }
        if (TwilightForestMod.adminOnlyPortals) {
            if (!MinecraftServer.func_71276_C().func_71203_ab().func_72376_i().contains(player.field_71092_bJ.toLowerCase())) {
                return;
            }
            rangeToCheck = 4.0;
        }
        if (world != null && player != null && (world.field_73011_w.field_76574_g == 0 || world.field_73011_w.field_76574_g == TwilightForestMod.dimensionID || TwilightForestMod.allowPortalsInOtherDimensions)) {
            final List itemList = world.func_72872_a((Class)EntityItem.class, player.field_70121_D.func_72314_b(rangeToCheck, rangeToCheck, rangeToCheck));
            for (final EntityItem entityItem : itemList) {
                if (entityItem.func_92059_d().field_77993_c == Item.field_77702_n.field_77779_bT && world.func_72875_a(entityItem.field_70121_D, Material.field_76244_g)) {
                    final Random rand = new Random();
                    for (int k = 0; k < 2; ++k) {
                        final double d = rand.nextGaussian() * 0.02;
                        final double d2 = rand.nextGaussian() * 0.02;
                        final double d3 = rand.nextGaussian() * 0.02;
                        world.func_72869_a("spell", entityItem.field_70165_t, entityItem.field_70163_u + 0.2, entityItem.field_70161_v, d, d2, d3);
                    }
                    final int dx = MathHelper.func_76128_c(entityItem.field_70165_t);
                    final int dy = MathHelper.func_76128_c(entityItem.field_70163_u);
                    final int dz = MathHelper.func_76128_c(entityItem.field_70161_v);
                    if (!((BlockTFPortal)TFBlocks.portal).tryToCreatePortal(world, dx, dy, dz)) {
                        continue;
                    }
                    player.func_71029_a((StatBase)TFAchievementPage.twilightPortal);
                }
            }
        }
    }
    
    public void tickEnd(final EnumSet type, final Object... tickData) {
    }
    
    public EnumSet ticks() {
        return this.ticks;
    }
    
    public String getLabel() {
        return "Twilight Forest tick";
    }
    
    public int nextTickSpacing() {
        return 20;
    }
}
