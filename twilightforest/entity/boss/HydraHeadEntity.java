// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.client.renderer.entity.HydraHeadRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.network.datasync.DataParameter;

public class HydraHeadEntity extends HydraPartEntity
{
    private static final DataParameter<Float> DATA_MOUTH_POSITION;
    private static final DataParameter<Float> DATA_MOUTH_POSITION_LAST;
    private static final DataParameter<Byte> DATA_STATE;
    
    public HydraHeadEntity(final HydraEntity hydra) {
        super(hydra, 4.0f, 4.0f);
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public EntityRenderer<?> renderer(final EntityRendererManager manager) {
        return new HydraHeadRenderer(manager);
    }
    
    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)HydraHeadEntity.DATA_MOUTH_POSITION, (Object)0.0f);
        this.field_70180_af.func_187214_a((DataParameter)HydraHeadEntity.DATA_MOUTH_POSITION_LAST, (Object)0.0f);
        this.field_70180_af.func_187214_a((DataParameter)HydraHeadEntity.DATA_STATE, (Object)0);
    }
    
    public float getMouthOpen() {
        return (float)this.field_70180_af.func_187225_a((DataParameter)HydraHeadEntity.DATA_MOUTH_POSITION);
    }
    
    public float getMouthOpenLast() {
        return (float)this.field_70180_af.func_187225_a((DataParameter)HydraHeadEntity.DATA_MOUTH_POSITION_LAST);
    }
    
    public HydraHeadContainer.State getState() {
        return HydraHeadContainer.State.values()[(byte)this.field_70180_af.func_187225_a((DataParameter)HydraHeadEntity.DATA_STATE)];
    }
    
    public void setMouthOpen(final float openness) {
        this.field_70180_af.func_187227_b((DataParameter)HydraHeadEntity.DATA_MOUTH_POSITION_LAST, (Object)this.getMouthOpen());
        this.field_70180_af.func_187227_b((DataParameter)HydraHeadEntity.DATA_MOUTH_POSITION, (Object)openness);
    }
    
    public void setState(final HydraHeadContainer.State state) {
        this.field_70180_af.func_187227_b((DataParameter)HydraHeadEntity.DATA_STATE, (Object)(byte)state.ordinal());
    }
    
    static {
        DATA_MOUTH_POSITION = EntityDataManager.func_187226_a((Class)HydraHeadEntity.class, DataSerializers.field_187193_c);
        DATA_MOUTH_POSITION_LAST = EntityDataManager.func_187226_a((Class)HydraHeadEntity.class, DataSerializers.field_187193_c);
        DATA_STATE = EntityDataManager.func_187226_a((Class)HydraHeadEntity.class, DataSerializers.field_187191_a);
    }
}
