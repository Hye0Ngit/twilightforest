// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.Entity;
import java.util.Iterator;
import java.util.List;
import twilightforest.entity.passive.EntityTFQuestRam;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFFindLoose extends EntityAIBase
{
    private EntityCreature temptedEntity;
    private int temptID;
    private float pursueSpeed;
    private int delayTemptCounter;
    private EntityItem temptingItem;
    
    public EntityAITFFindLoose(final EntityTFQuestRam entityTFQuestRam, final float speed, final int blockID) {
        this.temptedEntity = (EntityCreature)entityTFQuestRam;
        this.pursueSpeed = speed;
        this.temptID = blockID;
        this.func_75248_a(3);
    }
    
    public boolean func_75250_a() {
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        this.temptingItem = null;
        final List nearbyItems = this.temptedEntity.field_70170_p.func_72872_a((Class)EntityItem.class, this.temptedEntity.field_70121_D.func_72314_b(16.0, 4.0, 16.0));
        for (final EntityItem itemNearby : nearbyItems) {
            if (itemNearby.func_92059_d().field_77993_c == this.temptID && itemNearby.func_70089_S()) {
                this.temptingItem = itemNearby;
                break;
            }
        }
        return this.temptingItem != null;
    }
    
    public boolean func_75253_b() {
        return this.func_75250_a();
    }
    
    public void func_75249_e() {
    }
    
    public void func_75251_c() {
        this.temptingItem = null;
        this.temptedEntity.func_70661_as().func_75499_g();
        this.delayTemptCounter = 100;
    }
    
    public void func_75246_d() {
        this.temptedEntity.func_70671_ap().func_75651_a((Entity)this.temptingItem, 30.0f, (float)this.temptedEntity.func_70646_bf());
        if (this.temptedEntity.func_70068_e((Entity)this.temptingItem) < 6.25) {
            this.temptedEntity.func_70661_as().func_75499_g();
        }
        else {
            this.temptedEntity.func_70661_as().func_75492_a(this.temptingItem.field_70165_t, this.temptingItem.field_70163_u, this.temptingItem.field_70161_v, this.pursueSpeed);
        }
    }
}
