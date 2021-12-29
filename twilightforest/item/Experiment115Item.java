// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.BlockItem;

public class Experiment115Item extends BlockItem
{
    public static final ResourceLocation THINK;
    public static final ResourceLocation FULL;
    
    public Experiment115Item(final Block block, final Item.Properties props) {
        super(block, props);
    }
    
    public ActionResultType func_195939_a(final ItemUseContext context) {
        final PlayerEntity player = context.func_195999_j();
        if (!player.func_225608_bj_()) {
            final ActionResultType actionresulttype = this.func_195942_a(new BlockItemUseContext(context));
            return (!actionresulttype.func_226246_a_() && this.func_219971_r()) ? this.func_77659_a(context.func_195991_k(), context.func_195999_j(), context.func_221531_n()).func_188397_a() : actionresulttype;
        }
        return ActionResultType.PASS;
    }
    
    static {
        THINK = TwilightForestMod.prefix("think");
        FULL = TwilightForestMod.prefix("full");
    }
}
