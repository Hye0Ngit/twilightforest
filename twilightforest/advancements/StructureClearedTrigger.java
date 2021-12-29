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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import java.util.function.Function;
import com.google.common.collect.Maps;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class StructureClearedTrigger implements ICriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    private final Map<PlayerAdvancements, Listeners> listeners;
    
    public StructureClearedTrigger() {
        this.listeners = Maps.newHashMap();
    }
    
    public ResourceLocation func_192163_a() {
        return StructureClearedTrigger.ID;
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
        final String structureName = JsonUtils.func_151200_h(json, "structure");
        return new Instance(structureName);
    }
    
    public void trigger(final EntityPlayerMP player, final String structureName) {
        final Listeners listeners = this.listeners.get(player.func_192039_O());
        if (listeners != null) {
            listeners.trigger(structureName);
        }
    }
    
    static {
        ID = TwilightForestMod.prefix("structure_cleared");
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final String structureName;
        
        public Instance(final String structureName) {
            super(StructureClearedTrigger.ID);
            this.structureName = structureName;
        }
        
        boolean test(final String structureName) {
            return this.structureName.equals(structureName);
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
        
        public void trigger(final String structureName) {
            final List<ICriterionTrigger.Listener<Instance>> list = new ArrayList<ICriterionTrigger.Listener<Instance>>();
            for (final ICriterionTrigger.Listener<Instance> listener : this.listeners) {
                if (((Instance)listener.func_192158_a()).test(structureName)) {
                    list.add(listener);
                }
            }
            for (final ICriterionTrigger.Listener<Instance> listener : list) {
                listener.func_192159_a(this.playerAdvancements);
            }
        }
    }
}
