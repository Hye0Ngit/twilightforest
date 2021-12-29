// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.monster.TowerwoodBorer;
import twilightforest.entity.TFEntities;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class InfestedTowerwoodBlock extends FlammableBlock
{
    public InfestedTowerwoodBlock(final int flammability, final int spreadSpeed, final BlockBehaviour.Properties props) {
        super(flammability, spreadSpeed, props);
    }
    
    @Deprecated
    public void m_8101_(final BlockState state, final ServerLevel world, final BlockPos pos, final ItemStack stack) {
        super.m_8101_(state, world, pos, stack);
        if (!world.f_46443_ && world.m_46469_().m_46207_(GameRules.f_46136_) && EnchantmentHelper.m_44843_(Enchantments.f_44985_, stack) == 0) {
            final TowerwoodBorer termite = new TowerwoodBorer(TFEntities.TOWERWOOD_BORER, (Level)world);
            termite.m_7678_(pos.m_123341_() + 0.5, (double)pos.m_123342_(), pos.m_123343_() + 0.5, 0.0f, 0.0f);
            world.m_7967_((Entity)termite);
            termite.m_21373_();
        }
    }
}
