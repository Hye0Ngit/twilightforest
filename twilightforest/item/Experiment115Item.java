// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TwilightForestMod;
import twilightforest.util.TFStats;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;

public class Experiment115Item extends BlockItem
{
    public static final ResourceLocation THINK;
    public static final ResourceLocation FULL;
    
    public Experiment115Item(final Block block, final Item.Properties props) {
        super(block, props);
    }
    
    public InteractionResult m_6225_(final UseOnContext context) {
        final Player player = context.m_43723_();
        if (!player.m_6144_()) {
            final InteractionResult actionresulttype = this.m_40576_(new BlockPlaceContext(context));
            return (!actionresulttype.m_19077_() && this.m_41472_()) ? this.m_7203_(context.m_43725_(), context.m_43723_(), context.m_43724_()).m_19089_() : actionresulttype;
        }
        return InteractionResult.PASS;
    }
    
    public ItemStack m_5922_(final ItemStack stack, final Level level, final LivingEntity entity) {
        if (entity instanceof final ServerPlayer player) {
            player.m_36220_(TFStats.E115_SLICES_EATEN);
        }
        return super.m_5922_(stack, level, entity);
    }
    
    static {
        THINK = TwilightForestMod.prefix("think");
        FULL = TwilightForestMod.prefix("full");
    }
}
