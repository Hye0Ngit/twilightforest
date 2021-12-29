// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import twilightforest.entity.TowerwoodBorerEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.world.GameRules;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;

public class InfestedTowerwoodBlock extends FlammableBlock
{
    public InfestedTowerwoodBlock(final int flammability, final int spreadSpeed, final AbstractBlock.Properties props) {
        super(flammability, spreadSpeed, props);
    }
    
    @Deprecated
    public void func_220062_a(final BlockState state, final ServerWorld world, final BlockPos pos, final ItemStack stack) {
        super.func_220062_a(state, world, pos, stack);
        if (!world.field_72995_K && world.func_82736_K().func_223586_b(GameRules.field_223603_f) && EnchantmentHelper.func_77506_a(Enchantments.field_185306_r, stack) == 0) {
            final TowerwoodBorerEntity termite = new TowerwoodBorerEntity(TFEntities.tower_termite, (World)world);
            termite.func_70012_b(pos.func_177958_n() + 0.5, (double)pos.func_177956_o(), pos.func_177952_p() + 0.5, 0.0f, 0.0f);
            world.func_217376_c((Entity)termite);
            termite.func_70656_aK();
        }
    }
}
