// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.TFSounds;
import twilightforest.entity.boss.EntityTFYetiAlpha;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFYetiTired extends EntityAIBase
{
    private EntityTFYetiAlpha yeti;
    private int tiredDuration;
    private int tiredTimer;
    
    public EntityAITFYetiTired(final EntityTFYetiAlpha entityTFYetiAlpha, final int i) {
        this.yeti = entityTFYetiAlpha;
        this.tiredDuration = i;
        this.func_75248_a(5);
    }
    
    public boolean func_75250_a() {
        return this.yeti.isTired();
    }
    
    public boolean func_75253_b() {
        return this.tiredTimer < this.tiredDuration;
    }
    
    public boolean func_75252_g() {
        return false;
    }
    
    public void func_75249_e() {
        this.tiredTimer = 0;
    }
    
    public void func_75251_c() {
        this.tiredTimer = 0;
        this.yeti.setTired(false);
    }
    
    public void func_75246_d() {
        if (++this.tiredTimer % 10 == 0) {
            this.yeti.func_184185_a(TFSounds.ALPHAYETI_PANT, 4.0f, 0.5f + this.yeti.func_70681_au().nextFloat() * 0.5f);
        }
    }
}
