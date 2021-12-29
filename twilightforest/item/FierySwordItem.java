// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class FierySwordItem extends SwordItem
{
    public FierySwordItem(final IItemTier toolMaterial, final Item.Properties props) {
        super(toolMaterial, 3, -2.4f, props);
    }
    
    public boolean func_77644_a(final ItemStack stack, final LivingEntity target, final LivingEntity attacker) {
        final boolean result = super.func_77644_a(stack, target, attacker);
        if (result && !target.field_70170_p.field_72995_K && !target.func_230279_az_()) {
            target.func_70015_d(15);
        }
        else {
            for (int var1 = 0; var1 < 20; ++var1) {
                final double px = target.func_226277_ct_() + FierySwordItem.field_77697_d.nextFloat() * target.func_213311_cf() * 2.0f - target.func_213311_cf();
                final double py = target.func_226278_cu_() + FierySwordItem.field_77697_d.nextFloat() * target.func_213302_cg();
                final double pz = target.func_226281_cx_() + FierySwordItem.field_77697_d.nextFloat() * target.func_213311_cf() * 2.0f - target.func_213311_cf();
                target.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197631_x, px, py, pz, 0.02, 0.02, 0.02);
            }
        }
        return result;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add((ITextComponent)new TranslationTextComponent(this.func_77658_a() + ".tooltip"));
    }
}
