// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import twilightforest.TwilightForestMod;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.critereon.ItemPredicate;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import java.util.function.Function;
import com.google.common.collect.Maps;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class ItemUseTrigger implements ICriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    private final Map<PlayerAdvancements, Listeners> listeners;
    
    public ItemUseTrigger() {
        this.listeners = Maps.newHashMap();
    }
    
    public ResourceLocation func_192163_a() {
        return ItemUseTrigger.ID;
    }
    
    public void func_192165_a(final PlayerAdvancements playerAdvancementsIn, final ICriterionTrigger.Listener<Instance> listener) {
        final Listeners listeners = this.listeners.computeIfAbsent(playerAdvancementsIn, Listeners::new);
        listeners.add(listener);
    }
    
    public void func_192164_b(final PlayerAdvancements playerAdvancementsIn, final ICriterionTrigger.Listener<Instance> listener) {
        final Listeners listeners = this.listeners.get(playerAdvancementsIn);
        if (listeners != null) {
            listeners.remove(listener);
            if (listeners.isEmpty()) {
                this.listeners.remove(playerAdvancementsIn);
            }
        }
    }
    
    public void func_192167_a(final PlayerAdvancements playerAdvancementsIn) {
        this.listeners.remove(playerAdvancementsIn);
    }
    
    public Instance deserializeInstance(final JsonObject json, final JsonDeserializationContext context) {
        final ItemPredicate item = ItemPredicate.func_192492_a(json.get("item"));
        final BlockPredicate block = BlockPredicate.deserialize(json.get("block"));
        return new Instance(item, block);
    }
    
    public void trigger(final EntityPlayerMP player, final ItemStack item, final World world, final BlockPos pos) {
        final Listeners listeners = this.listeners.get(player.func_192039_O());
        if (listeners != null) {
            listeners.trigger(item, world, pos);
        }
    }
    
    static {
        ID = TwilightForestMod.prefix("on_item_use");
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final ItemPredicate item;
        private final BlockPredicate block;
        
        public Instance(final ItemPredicate item, final BlockPredicate block) {
            super(ItemUseTrigger.ID);
            this.item = item;
            this.block = block;
        }
        
        public boolean test(final ItemStack item, final World world, final BlockPos pos) {
            return this.item.func_192493_a(item) && this.block.test(world, pos);
        }
    }
    
    static class Listeners
    {
        private final PlayerAdvancements playerAdvancements;
        private final Set<ICriterionTrigger.Listener<Instance>> listeners;
        
        public Listeners(final PlayerAdvancements playerAdvancements) {
            this.listeners = Sets.newHashSet();
            this.playerAdvancements = playerAdvancements;
        }
        
        public boolean isEmpty() {
            return this.listeners.isEmpty();
        }
        
        public void add(final ICriterionTrigger.Listener<Instance> listener) {
            this.listeners.add(listener);
        }
        
        public void remove(final ICriterionTrigger.Listener<Instance> listener) {
            this.listeners.remove(listener);
        }
        
        public void trigger(final ItemStack item, final World world, final BlockPos pos) {
            final List<ICriterionTrigger.Listener<Instance>> list = new ArrayList<ICriterionTrigger.Listener<Instance>>();
            for (final ICriterionTrigger.Listener<Instance> listener : this.listeners) {
                if (((Instance)listener.func_192158_a()).test(item, world, pos)) {
                    list.add(listener);
                }
            }
            for (final ICriterionTrigger.Listener<Instance> listener : list) {
                listener.func_192159_a(this.playerAdvancements);
            }
        }
    }
}
