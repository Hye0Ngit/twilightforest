// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;

public class ItemTFHydraChops extends ItemTFFood
{
    public ItemTFHydraChops(final int par2, final float par3, final boolean par4) {
        super(par2, par3, par4);
    }
    
    @Override
    public ItemStack func_77654_b(final ItemStack itemStack, final World world, final EntityPlayer player) {
        if (player.func_71024_bL().func_75116_a() <= 0) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightHydraChop);
        }
        return super.func_77654_b(itemStack, world, player);
    }
}
