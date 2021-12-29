// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import twilightforest.entity.boss.IceBombEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.Entity;
import twilightforest.TFSounds;
import java.util.EnumSet;
import twilightforest.entity.boss.AlphaYetiEntity;
import net.minecraft.entity.ai.goal.Goal;

public class YetiRampageGoal extends Goal
{
    private AlphaYetiEntity yeti;
    private int currentTimeOut;
    private int currentDuration;
    private int maxTantrumTimeOut;
    private int tantrumDuration;
    
    public YetiRampageGoal(final AlphaYetiEntity entityTFYetiAlpha, final int timeout, final int duration) {
        this.yeti = entityTFYetiAlpha;
        this.currentTimeOut = timeout;
        this.maxTantrumTimeOut = timeout;
        this.tantrumDuration = duration;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
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
        this.yeti.func_184185_a(TFSounds.ALPHAYETI_ROAR, 4.0f, 0.5f + this.yeti.func_70681_au().nextFloat() * 0.5f);
    }
    
    public boolean func_75253_b() {
        return this.currentDuration > 0;
    }
    
    public void func_75246_d() {
        --this.currentDuration;
        if (this.yeti.func_70638_az() != null) {
            this.yeti.func_70671_ap().func_75651_a((Entity)this.yeti.func_70638_az(), 10.0f, (float)this.yeti.func_70646_bf());
        }
        if (this.yeti.func_233570_aj_()) {
            this.yeti.func_213293_j(0.0, 0.4, 0.0);
        }
        this.yeti.destroyBlocksInAABB(this.yeti.func_174813_aQ().func_72314_b(1.0, 2.0, 1.0).func_72317_d(0.0, 2.0, 0.0));
        if (this.currentDuration % 20 == 0) {
            this.yeti.makeRandomBlockFall();
        }
        if (this.currentDuration % 40 == 0) {
            this.yeti.makeBlockAboveTargetFall();
        }
        if (this.currentDuration < 40 && this.currentDuration % 10 == 0) {
            this.yeti.makeNearbyBlockFall();
        }
        if (this.currentDuration % 10 == 0) {
            final IceBombEntity ice = new IceBombEntity(TFEntities.thrown_ice, this.yeti.field_70170_p, (LivingEntity)this.yeti);
            final Vector3d vec = new Vector3d((double)(0.5f + this.yeti.func_70681_au().nextFloat() * 0.5f), (double)(0.5f + this.yeti.func_70681_au().nextFloat() * 0.3f), 0.0).func_178785_b(this.yeti.func_70681_au().nextFloat() * 360.0f);
            ice.func_70186_c(vec.field_72450_a, vec.field_72448_b, vec.field_72449_c, 0.4f + this.yeti.func_70681_au().nextFloat() * 0.3f, 0.0f);
            this.yeti.func_184185_a(TFSounds.ALPHAYETI_ICE, 1.0f, 1.0f / (this.yeti.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.yeti.field_70170_p.func_217376_c((Entity)ice);
        }
    }
    
    public void func_75251_c() {
        this.currentTimeOut = this.maxTantrumTimeOut;
        this.yeti.setRampaging(false);
        this.yeti.setTired(true);
    }
}
