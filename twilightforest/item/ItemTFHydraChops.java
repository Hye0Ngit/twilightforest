// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import javax.annotation.Nonnull;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.EnumRarity;

public class ItemTFHydraChops extends ItemTFFood
{
    private static final EnumRarity RARITY;
    
    public ItemTFHydraChops(final int amount, final float saturation) {
        super(amount, saturation, true);
    }
    
    public ItemStack func_77654_b(final ItemStack itemStack, final World world, final EntityLivingBase living) {
        if (living instanceof EntityPlayerMP && ((EntityPlayerMP)living).func_71024_bL().func_75116_a() <= 0) {
            TFAdvancements.CONSUME_HYDRA_CHOP.trigger((EntityPlayerMP)living);
        }
        return super.func_77654_b(itemStack, world, living);
    }
    
    @Nonnull
    public EnumRarity func_77613_e(final ItemStack stack) {
        return stack.func_77948_v() ? ((EnumRarity.RARE.compareTo((Enum)ItemTFHydraChops.RARITY) > 0) ? EnumRarity.RARE : ItemTFHydraChops.RARITY) : ItemTFHydraChops.RARITY;
    }
    
    static {
        RARITY = EnumRarity.UNCOMMON;
    }
}
