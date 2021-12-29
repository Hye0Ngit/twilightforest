// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.world.World;

public class EntityTFHydraHead extends EntityTFHydraPart
{
    public EntityTFHydraHead(final World world) {
        super(world);
        this.field_70158_ak = true;
    }
    
    public EntityTFHydraHead(final EntityTFHydra hydra, final String s, final float f, final float f1) {
        super(hydra, s, f, f1);
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
        this.field_70180_af.func_75682_a(18, (Object)0);
        this.field_70180_af.func_75682_a(19, (Object)0);
    }
    
    public float getMouthOpen() {
        return (this.field_70180_af.func_75683_a(18) & 0xFF) / 255.0f;
    }
    
    public int getState() {
        return this.field_70180_af.func_75683_a(19) & 0xFF;
    }
    
    public void setMouthOpen(float openness) {
        if (openness < 0.0f) {
            openness = 0.0f;
        }
        if (openness > 1.0f) {
            openness = 1.0f;
        }
        int openByte = Math.round(openness * 255.0f);
        openByte &= 0xFF;
        this.field_70180_af.func_75692_b(18, (Object)(byte)openByte);
    }
    
    public void setState(int state) {
        state &= 0xFF;
        this.field_70180_af.func_75692_b(19, (Object)(byte)state);
    }
}
