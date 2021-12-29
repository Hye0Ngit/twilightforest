// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import java.util.Iterator;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import twilightforest.TwilightForestMod;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import java.util.function.Function;
import com.google.common.collect.Maps;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class QuestRamCompletionTrigger implements ICriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    private final Map<PlayerAdvancements, Listeners> listeners;
    
    public QuestRamCompletionTrigger() {
        this.listeners = Maps.newHashMap();
    }
    
    public ResourceLocation func_192163_a() {
        return QuestRamCompletionTrigger.ID;
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
        return new Instance();
    }
    
    public void trigger(final EntityPlayerMP player) {
        final Listeners listeners = this.listeners.get(player.func_192039_O());
        if (listeners != null) {
            listeners.trigger();
        }
    }
    
    static {
        ID = TwilightForestMod.prefix("complete_quest_ram");
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        public Instance() {
            super(QuestRamCompletionTrigger.ID);
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
        
        public void trigger() {
            for (final ICriterionTrigger.Listener<Instance> listener : Lists.newArrayList((Iterable)this.listeners)) {
                listener.func_192159_a(this.playerAdvancements);
            }
        }
    }
}
