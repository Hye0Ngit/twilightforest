// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import net.minecraft.core.Registry;
import net.minecraft.advancements.critereon.SerializationContext;
import twilightforest.TwilightForestMod;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.server.level.ServerPlayer;
import javax.annotation.Nullable;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;

public class KillBugTrigger extends SimpleCriterionTrigger<Instance>
{
    public static final ResourceLocation ID;
    
    public ResourceLocation m_7295_() {
        return KillBugTrigger.ID;
    }
    
    protected Instance createInstance(final JsonObject json, final EntityPredicate.Composite player, final DeserializationContext ctx) {
        final Block bug = deserializeBug(json);
        return new Instance(player, bug);
    }
    
    @Nullable
    private static Block deserializeBug(final JsonObject object) {
        if (object.has("bug")) {
            final ResourceLocation resourcelocation = new ResourceLocation(GsonHelper.m_13906_(object, "bug"));
            return (Block)ForgeRegistries.BLOCKS.getValue(resourcelocation);
        }
        return null;
    }
    
    public void trigger(final ServerPlayer player, final BlockState bug) {
        this.m_66234_(player, instance -> instance.matches(bug));
    }
    
    static {
        ID = TwilightForestMod.prefix("kill_bug");
    }
    
    public static class Instance extends AbstractCriterionTriggerInstance
    {
        @Nullable
        private final Block bugType;
        
        public Instance(final EntityPredicate.Composite player, @Nullable final Block bugType) {
            super(KillBugTrigger.ID, player);
            this.bugType = bugType;
        }
        
        public static Instance killBug(final Block bug) {
            return new Instance(EntityPredicate.Composite.f_36667_, bug);
        }
        
        public boolean matches(final BlockState bug) {
            return this.bugType == null || bug.m_60713_(this.bugType);
        }
        
        public JsonObject m_7683_(final SerializationContext ctx) {
            final JsonObject object = super.m_7683_(ctx);
            if (this.bugType != null) {
                object.addProperty("bug", Registry.f_122824_.m_7981_((Object)this.bugType).toString());
            }
            return object;
        }
    }
}
