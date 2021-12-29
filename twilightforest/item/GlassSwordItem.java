// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.nbt.Tag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.ItemLike;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import twilightforest.TFSounds;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;

public class GlassSwordItem extends SwordItem
{
    public GlassSwordItem(final Tier toolMaterial, final Item.Properties props) {
        super(toolMaterial, 3, -2.4f, props);
    }
    
    public boolean m_7579_(final ItemStack stack, final LivingEntity target, final LivingEntity attacker) {
        attacker.f_19853_.m_6263_((Player)null, attacker.m_20185_(), attacker.m_20186_(), attacker.m_20189_(), TFSounds.GLASS_SWORD_BREAK, attacker.m_5720_(), 1.0f, 0.5f);
        target.f_19853_.m_7106_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, Blocks.f_50147_.m_49966_()), target.m_20185_(), target.m_20186_(), target.m_20189_(), 1.0, 1.0, 1.0);
        stack.m_41622_(stack.m_41776_() + 1, attacker, user -> user.m_21190_(InteractionHand.MAIN_HAND));
        return true;
    }
    
    public void m_6787_(final CreativeModeTab tab, final NonNullList<ItemStack> items) {
        super.m_6787_(tab, (NonNullList)items);
        if (this.m_41389_(tab)) {
            final ItemStack stack = new ItemStack((ItemLike)this);
            final CompoundTag tags = new CompoundTag();
            tags.m_128379_("Unbreakable", true);
            final ListTag lore = new ListTag();
            lore.add((Object)StringTag.m_129297_("{\"translate\":\"item.twilightforest.glass_sword.tooltip.1\",\"italic\":false,\"color\":\"gray\"}"));
            final CompoundTag display = new CompoundTag();
            display.m_128365_("Lore", (Tag)lore);
            tags.m_128365_("display", (Tag)display);
            stack.m_41751_(tags);
            items.add((Object)stack);
        }
    }
}
