// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.capabilities.shield.IShieldCapability;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import twilightforest.entity.boss.LichEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;

public enum RenderEffect
{
    SHIELDS {
        @Override
        public boolean shouldRender(final LivingEntity entity, final boolean firstPerson) {
            return !(entity instanceof LichEntity) && entity.getCapability((Capability)CapabilityList.SHIELDS).map(c -> c.shieldsLeft() > 0).orElse(false);
        }
        
        @Override
        public void render(final LivingEntity entity, final EntityModel<? extends LivingEntity> renderer, final double x, final double y, final double z, final float partialTicks, final boolean firstPerson) {
            RenderSystem.pushMatrix();
            RenderSystem.translated(x, y, z);
            RenderSystem.rotatef(180.0f, 1.0f, 0.0f, 0.0f);
            RenderSystem.translatef(0.0f, 0.5f - entity.func_70047_e(), 0.0f);
            RenderSystem.enableBlend();
            RenderSystem.disableCull();
            RenderSystem.blendFunc(770, 771);
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            RenderSystem.popMatrix();
        }
    };
    
    static final RenderEffect[] VALUES;
    
    public boolean shouldRender(final LivingEntity entity, final boolean firstPerson) {
        return false;
    }
    
    public void render(final LivingEntity entity, final EntityModel<? extends LivingEntity> renderer, final double x, final double y, final double z, final float partialTicks, final boolean firstPerson) {
    }
    
    static {
        VALUES = values();
    }
}
