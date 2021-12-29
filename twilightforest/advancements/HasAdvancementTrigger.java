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
import net.minecraft.advancements.Advancement;
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

public class HasAdvancementTrigger implements ICriterionTrigger<Instance>
{
    private static final ResourceLocation ID;
    private final Map<PlayerAdvancements, Listeners> listeners;
    
    public HasAdvancementTrigger() {
        this.listeners = Maps.newHashMap();
    }
    
    public ResourceLocation func_192163_a() {
        return HasAdvancementTrigger.ID;
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
        final ResourceLocation advancementId = new ResourceLocation(JsonUtils.func_151200_h(json, "advancement"));
        return new Instance(advancementId);
    }
    
    public void trigger(final EntityPlayerMP player, final Advancement advancement) {
        final Listeners listeners = this.listeners.get(player.func_192039_O());
        if (listeners != null) {
            listeners.trigger(advancement);
        }
    }
    
    static {
        ID = TwilightForestMod.prefix("has_advancement");
    }
    
    static class Instance extends AbstractCriterionInstance
    {
        private final ResourceLocation advancementLocation;
        
        Instance(final ResourceLocation advancementLocation) {
            super(HasAdvancementTrigger.ID);
            this.advancementLocation = advancementLocation;
        }
        
        boolean test(final Advancement advancement) {
            return this.advancementLocation.equals((Object)advancement.func_192067_g());
        }
    }
    
    private static class Listeners
    {
        private final PlayerAdvancements playerAdvancements;
        private final Set<ICriterionTrigger.Listener<Instance>> listeners;
        
        Listeners(final PlayerAdvancements playerAdvancements) {
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
        
        public void trigger(final Advancement advancement) {
            final List<ICriterionTrigger.Listener<Instance>> list = new ArrayList<ICriterionTrigger.Listener<Instance>>();
            for (final ICriterionTrigger.Listener<Instance> listener : this.listeners) {
                if (((Instance)listener.func_192158_a()).test(advancement)) {
                    list.add(listener);
                }
            }
            for (final ICriterionTrigger.Listener<Instance> listener : list) {
                listener.func_192159_a(this.playerAdvancements);
            }
        }
    }
}
