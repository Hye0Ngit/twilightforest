// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Hand;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.player.PlayerEntity;
import twilightforest.TFSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class GlassSwordItem extends SwordItem
{
    public GlassSwordItem(final IItemTier toolMaterial, final Item.Properties props) {
        super(toolMaterial, 3, -2.4f, props);
    }
    
    public boolean func_77644_a(final ItemStack stack, final LivingEntity target, final LivingEntity attacker) {
        attacker.field_70170_p.func_184148_a((PlayerEntity)null, attacker.func_226277_ct_(), attacker.func_226278_cu_(), attacker.func_226281_cx_(), TFSounds.GLASS_SWORD_BREAK, attacker.func_184176_by(), 1.0f, 0.5f);
        target.field_70170_p.func_195594_a((IParticleData)new BlockParticleData(ParticleTypes.field_197611_d, Blocks.field_196807_gj.func_176223_P()), target.func_226277_ct_(), target.func_226278_cu_(), target.func_226281_cx_(), 1.0, 1.0, 1.0);
        stack.func_222118_a(stack.func_77958_k() + 1, attacker, user -> user.func_213334_d(Hand.MAIN_HAND));
        return true;
    }
    
    public void func_150895_a(final ItemGroup tab, final NonNullList<ItemStack> items) {
        super.func_150895_a(tab, (NonNullList)items);
        if (this.func_194125_a(tab)) {
            final ItemStack stack = new ItemStack((IItemProvider)this);
            final CompoundNBT tags = new CompoundNBT();
            tags.func_74757_a("Unbreakable", true);
            stack.func_77982_d(tags);
            items.add((Object)stack);
        }
    }
}
