// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.Entity;
import twilightforest.entity.boss.EntityTFYetiAlpha;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFYetiRampage extends EntityAIBase
{
    private EntityTFYetiAlpha yeti;
    private int currentTimeOut;
    private int currentDuration;
    private int maxTantrumTimeOut;
    private int tantrumDuration;
    
    public EntityAITFYetiRampage(final EntityTFYetiAlpha entityTFYetiAlpha, final int timeout, final int duration) {
        this.yeti = entityTFYetiAlpha;
        this.currentTimeOut = timeout;
        this.maxTantrumTimeOut = timeout;
        this.tantrumDuration = duration;
        this.func_75248_a(5);
    }
    
    public boolean func_75250_a() {
        if (this.yeti.func_70638_az() != null && this.yeti.canRampage()) {
            --this.currentTimeOut;
        }
        return this.currentTimeOut <= 0;
    }
    
    public void func_75249_e() {
        this.currentDuration = this.tantrumDuration;
        this.yeti.setRampaging(true);
    }
    
    public boolean func_75253_b() {
        return this.currentDuration > 0;
    }
    
    public void func_75246_d() {
        --this.currentDuration;
        if (this.yeti.func_70638_az() != null) {
            this.yeti.func_70671_ap().func_75651_a((Entity)this.yeti.func_70638_az(), 10.0f, (float)this.yeti.func_70646_bf());
        }
        if (this.yeti.field_70122_E) {
            this.yeti.field_70159_w = 0.0;
            this.yeti.field_70179_y = 0.0;
            this.yeti.field_70181_x = 0.4000000059604645;
        }
        this.yeti.destroyBlocksInAABB(this.yeti.field_70121_D.func_72314_b(1.0, 2.0, 1.0).func_72317_d(0.0, 2.0, 0.0));
        if (this.currentDuration % 20 == 0) {
            this.yeti.makeRandomBlockFall();
        }
        if (this.currentDuration % 40 == 0) {
            this.yeti.makeBlockAboveTargetFall();
        }
        if (this.currentDuration < 40 && this.currentDuration % 10 == 0) {
            this.yeti.makeNearbyBlockFall();
        }
    }
    
    public void func_75251_c() {
        this.currentTimeOut = this.maxTantrumTimeOut;
        this.yeti.setRampaging(false);
        this.yeti.setTired(true);
    }
}
