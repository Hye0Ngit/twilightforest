// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.capabilities.shield.IShieldCapability;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import twilightforest.entity.boss.Lich;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.LivingEntity;

public enum RenderEffect
{
    SHIELDS {
        @Override
        public boolean shouldRender(final LivingEntity entity, final boolean firstPerson) {
            return !(entity instanceof Lich) && entity.getCapability((Capability)CapabilityList.SHIELDS).map(c -> c.shieldsLeft() > 0).orElse(false);
        }
        
        @Override
        public void render(final LivingEntity entity, final EntityModel<? extends LivingEntity> renderer, final double x, final double y, final double z, final float partialTicks, final boolean firstPerson) {
            final PoseStack ms = RenderSystem.m_157191_();
            ms.m_85836_();
            ms.m_85837_(x, y, z);
            ms.m_85837_(0.0, (double)(0.5f - entity.m_20192_()), 0.0);
            RenderSystem.m_69478_();
            RenderSystem.m_69464_();
            RenderSystem.m_69405_(770, 771);
            RenderSystem.m_69481_();
            RenderSystem.m_69461_();
            ms.m_85849_();
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
