// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.resources.ResourceLocation;

public class HydraHead extends HydraPart
{
    public static final ResourceLocation RENDERER;
    private static final EntityDataAccessor<Float> DATA_MOUTH_POSITION;
    private static final EntityDataAccessor<Float> DATA_MOUTH_POSITION_LAST;
    private static final EntityDataAccessor<Byte> DATA_STATE;
    
    public HydraHead(final Hydra hydra) {
        super(hydra, 4.0f, 4.0f);
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public ResourceLocation renderer() {
        return HydraHead.RENDERER;
    }
    
    @Override
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)HydraHead.DATA_MOUTH_POSITION, (Object)0.0f);
        this.f_19804_.m_135372_((EntityDataAccessor)HydraHead.DATA_MOUTH_POSITION_LAST, (Object)0.0f);
        this.f_19804_.m_135372_((EntityDataAccessor)HydraHead.DATA_STATE, (Object)0);
    }
    
    public float getMouthOpen() {
        return (float)this.f_19804_.m_135370_((EntityDataAccessor)HydraHead.DATA_MOUTH_POSITION);
    }
    
    public float getMouthOpenLast() {
        return (float)this.f_19804_.m_135370_((EntityDataAccessor)HydraHead.DATA_MOUTH_POSITION_LAST);
    }
    
    public HydraHeadContainer.State getState() {
        return HydraHeadContainer.State.values()[(byte)this.f_19804_.m_135370_((EntityDataAccessor)HydraHead.DATA_STATE)];
    }
    
    public void setMouthOpen(final float openness) {
        this.f_19804_.m_135381_((EntityDataAccessor)HydraHead.DATA_MOUTH_POSITION_LAST, (Object)this.getMouthOpen());
        this.f_19804_.m_135381_((EntityDataAccessor)HydraHead.DATA_MOUTH_POSITION, (Object)openness);
    }
    
    public void setState(final HydraHeadContainer.State state) {
        this.f_19804_.m_135381_((EntityDataAccessor)HydraHead.DATA_STATE, (Object)(byte)state.ordinal());
    }
    
    static {
        RENDERER = TwilightForestMod.prefix("hydra_head");
        DATA_MOUTH_POSITION = SynchedEntityData.m_135353_((Class)HydraHead.class, EntityDataSerializers.f_135029_);
        DATA_MOUTH_POSITION_LAST = SynchedEntityData.m_135353_((Class)HydraHead.class, EntityDataSerializers.f_135029_);
        DATA_STATE = SynchedEntityData.m_135353_((Class)HydraHead.class, EntityDataSerializers.f_135027_);
    }
}
