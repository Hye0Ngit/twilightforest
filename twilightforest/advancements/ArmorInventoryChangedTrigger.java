// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.advancements.criterion.CriterionInstance;
import twilightforest.TwilightForestMod;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.loot.ConditionArrayParser;
import com.google.gson.JsonObject;
import java.util.function.Function;
import com.google.common.collect.Maps;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class ArmorInventoryChangedTrigger implements ICriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    private final Map<PlayerAdvancements, Listeners> listeners;
    
    public ArmorInventoryChangedTrigger() {
        this.listeners = Maps.newHashMap();
    }
    
    public ResourceLocation func_192163_a() {
        return ArmorInventoryChangedTrigger.ID;
    }
    
    public void func_192165_a(final PlayerAdvancements playerAdvancements, final ICriterionTrigger.Listener<Instance> listener) {
        final Listeners listeners = this.listeners.computeIfAbsent(playerAdvancements, Listeners::new);
        listeners.add(listener);
    }
    
    public void func_192164_b(final PlayerAdvancements playerAdvancements, final ICriterionTrigger.Listener<Instance> listener) {
        final Listeners listeners = this.listeners.get(playerAdvancements);
        if (listeners != null) {
            listeners.remove(listener);
            if (listeners.isEmpty()) {
                this.listeners.remove(playerAdvancements);
            }
        }
    }
    
    public void func_192167_a(final PlayerAdvancements playerAdvancements) {
        this.listeners.remove(playerAdvancements);
    }
    
    public Instance deserialize(final JsonObject json, final ConditionArrayParser condition) {
        final EntityPredicate.AndPredicate player = EntityPredicate.AndPredicate.func_234587_a_(json, "player", condition);
        final ItemPredicate from = ItemPredicate.func_192492_a(json.get("from"));
        final ItemPredicate to = ItemPredicate.func_192492_a(json.get("to"));
        return new Instance(player, from, to);
    }
    
    public void trigger(final ServerPlayerEntity player, final ItemStack from, final ItemStack to) {
        final Listeners listeners = this.listeners.get(player.func_192039_O());
        if (listeners != null) {
            listeners.trigger(from, to);
        }
    }
    
    static {
        ID = TwilightForestMod.prefix("armor_changed");
    }
    
    public static class Instance extends CriterionInstance
    {
        private final ItemPredicate from;
        private final ItemPredicate to;
        
        public Instance(final EntityPredicate.AndPredicate player, final ItemPredicate from, final ItemPredicate to) {
            super(ArmorInventoryChangedTrigger.ID, player);
            this.from = from;
            this.to = to;
        }
        
        public boolean test(final ItemStack from, final ItemStack to) {
            return this.from.func_192493_a(from) && this.to.func_192493_a(to);
        }
        
        public ResourceLocation func_192244_a() {
            return ArmorInventoryChangedTrigger.ID;
        }
    }
    
    static class Listeners
    {
        private final PlayerAdvancements playerAdvancements;
        private final Set<ICriterionTrigger.Listener<Instance>> listeners;
        
        public Listeners(final PlayerAdvancements playerAdvancementsIn) {
            this.listeners = Sets.newHashSet();
            this.playerAdvancements = playerAdvancementsIn;
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
        
        public void trigger(final ItemStack from, final ItemStack to) {
            final List<ICriterionTrigger.Listener<Instance>> list = new ArrayList<ICriterionTrigger.Listener<Instance>>();
            for (final ICriterionTrigger.Listener<Instance> listener : this.listeners) {
                if (((Instance)listener.func_192158_a()).test(from, to)) {
                    list.add(listener);
                }
            }
            for (final ICriterionTrigger.Listener<Instance> listener : list) {
                listener.func_192159_a(this.playerAdvancements);
            }
        }
    }
}
