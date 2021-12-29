// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;

public class EntityTFHydraHead extends EntityTFHydraPart
{
    private static final DataParameter<Float> DATA_MOUTH_POSITION;
    private static final DataParameter<Byte> DATA_STATE;
    
    public EntityTFHydraHead(final World world) {
        super(world);
        this.field_70158_ak = true;
    }
    
    public EntityTFHydraHead(final EntityTFHydra hydra, final String name, final float width, final float height) {
        super(hydra, name, width, height);
    }
    
    public int func_70646_bf() {
        return 500;
    }
    
    protected void func_70609_aI() {
        ++this.field_70725_aQ;
    }
    
    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFHydraHead.DATA_MOUTH_POSITION, (Object)0.0f);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFHydraHead.DATA_STATE, (Object)0);
    }
    
    public float getMouthOpen() {
        return (float)this.field_70180_af.func_187225_a((DataParameter)EntityTFHydraHead.DATA_MOUTH_POSITION);
    }
    
    public HydraHeadContainer.State getState() {
        return HydraHeadContainer.State.values()[(byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFHydraHead.DATA_STATE)];
    }
    
    public void setMouthOpen(final float openness) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFHydraHead.DATA_MOUTH_POSITION, (Object)openness);
    }
    
    public void setState(final HydraHeadContainer.State state) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFHydraHead.DATA_STATE, (Object)(byte)state.ordinal());
    }
    
    static {
        DATA_MOUTH_POSITION = EntityDataManager.func_187226_a((Class)EntityTFHydraHead.class, DataSerializers.field_187193_c);
        DATA_STATE = EntityDataManager.func_187226_a((Class)EntityTFHydraHead.class, DataSerializers.field_187191_a);
    }
}
