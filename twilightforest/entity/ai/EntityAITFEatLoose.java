// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.Entity;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.item.EntityItem;
import twilightforest.entity.passive.EntityTFQuestRam;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFEatLoose extends EntityAIBase
{
    private EntityTFQuestRam temptedQuestRam;
    private int temptID;
    private int delayTemptCounter;
    private EntityItem temptingItem;
    
    public EntityAITFEatLoose(final EntityTFQuestRam entityTFQuestRam, final int blockID) {
        this.temptedQuestRam = entityTFQuestRam;
        this.temptID = blockID;
        this.func_75248_a(0);
    }
    
    public boolean func_75250_a() {
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        this.temptingItem = null;
        final List nearbyItems = this.temptedQuestRam.field_70170_p.func_72872_a((Class)EntityItem.class, this.temptedQuestRam.field_70121_D.func_72314_b(2.0, 2.0, 2.0));
        for (final EntityItem itemNearby : nearbyItems) {
            if (itemNearby.func_92059_d().field_77993_c == this.temptID && !this.temptedQuestRam.isColorPresent(itemNearby.func_92059_d().func_77960_j()) && itemNearby.func_70089_S()) {
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
        this.temptedQuestRam.func_70661_as().func_75499_g();
        this.delayTemptCounter = 100;
    }
    
    public void func_75246_d() {
        this.temptedQuestRam.func_70671_ap().func_75651_a((Entity)this.temptingItem, 30.0f, (float)this.temptedQuestRam.func_70646_bf());
        if (this.temptedQuestRam.func_70068_e((Entity)this.temptingItem) < 6.25 && !this.temptedQuestRam.isColorPresent(this.temptingItem.func_92059_d().func_77960_j())) {
            this.temptingItem.func_70106_y();
            this.temptedQuestRam.func_70642_aH();
            this.temptedQuestRam.setColorPresent(this.temptingItem.func_92059_d().func_77960_j());
            this.temptedQuestRam.animateAddColor(this.temptingItem.func_92059_d().func_77960_j(), 50);
        }
    }
}
