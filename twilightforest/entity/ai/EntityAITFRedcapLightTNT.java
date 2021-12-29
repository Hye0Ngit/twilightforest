// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import twilightforest.entity.EntityTFRedcap;

public class EntityAITFRedcapLightTNT extends EntityAITFRedcapBase
{
    private float pursueSpeed;
    private int delayTemptCounter;
    private int tntX;
    private int tntY;
    private int tntZ;
    
    public EntityAITFRedcapLightTNT(final EntityTFRedcap hostEntity, final float speed) {
        this.me = hostEntity;
        this.pursueSpeed = speed;
        this.func_75248_a(3);
    }
    
    public boolean func_75250_a() {
        final ChunkCoordinates nearbyTNT = this.findBlockTNTNearby(8);
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        if (nearbyTNT != null) {
            this.tntX = nearbyTNT.field_71574_a;
            this.tntY = nearbyTNT.field_71572_b;
            this.tntZ = nearbyTNT.field_71573_c;
            return true;
        }
        return false;
    }
    
    public boolean func_75253_b() {
        return this.me.field_70170_p.func_72798_a(this.tntX, this.tntY, this.tntZ) == Block.field_72091_am.field_71990_ca;
    }
    
    public void func_75249_e() {
        this.me.func_70062_b(0, EntityTFRedcap.heldFlint);
    }
    
    public void func_75251_c() {
        this.me.func_70661_as().func_75499_g();
        this.me.func_70062_b(0, this.me.getPick());
        this.delayTemptCounter = 20;
    }
    
    public void func_75246_d() {
        this.me.func_70671_ap().func_75650_a((double)this.tntX, (double)this.tntY, (double)this.tntZ, 30.0f, (float)this.me.func_70646_bf());
        if (this.me.func_70011_f((double)this.tntX, (double)this.tntY, (double)this.tntZ) < 2.4) {
            this.me.func_70642_aH();
            Block.field_72091_am.func_71898_d(this.me.field_70170_p, this.tntX, this.tntY, this.tntZ, 1);
            this.me.field_70170_p.func_72832_d(this.tntX, this.tntY, this.tntZ, 0, 0, 2);
            this.me.func_70661_as().func_75499_g();
        }
        else {
            this.me.func_70661_as().func_75492_a((double)this.tntX, (double)this.tntY, (double)this.tntZ, this.pursueSpeed);
        }
    }
}
