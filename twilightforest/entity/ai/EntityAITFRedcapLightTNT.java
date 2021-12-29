// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.EnumHand;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockTNT;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import twilightforest.entity.EntityTFRedcap;
import net.minecraft.util.math.BlockPos;

public class EntityAITFRedcapLightTNT extends EntityAITFRedcapBase
{
    private float pursueSpeed;
    private int delay;
    private BlockPos tntPos;
    
    public EntityAITFRedcapLightTNT(final EntityTFRedcap hostEntity, final float speed) {
        super(hostEntity);
        this.tntPos = null;
        this.pursueSpeed = speed;
        this.func_75248_a(3);
    }
    
    public boolean func_75250_a() {
        if (!ForgeEventFactory.getMobGriefingEvent(this.redcap.field_70170_p, (Entity)this.redcap)) {
            return false;
        }
        if (this.delay > 0) {
            --this.delay;
            return false;
        }
        final BlockPos nearbyTNT = this.findBlockTNTNearby(8);
        if (nearbyTNT != null) {
            this.tntPos = nearbyTNT;
            return true;
        }
        return false;
    }
    
    public boolean func_75253_b() {
        return this.redcap.field_70170_p.func_180495_p(this.tntPos).func_177230_c() == Blocks.field_150335_W;
    }
    
    public void func_75249_e() {
        this.redcap.func_184201_a(EntityEquipmentSlot.MAINHAND, this.redcap.heldFlint);
    }
    
    public void func_75251_c() {
        this.redcap.func_70661_as().func_75499_g();
        this.redcap.func_184201_a(EntityEquipmentSlot.MAINHAND, this.redcap.heldPick);
        this.delay = 20;
        this.tntPos = null;
    }
    
    public void func_75246_d() {
        this.redcap.func_70671_ap().func_75650_a((double)this.tntPos.func_177958_n(), (double)this.tntPos.func_177956_o(), (double)this.tntPos.func_177952_p(), 30.0f, (float)this.redcap.func_70646_bf());
        if (this.redcap.func_174818_b(this.tntPos) < 5.76) {
            this.redcap.func_70642_aH();
            Blocks.field_150335_W.func_176206_d(this.redcap.field_70170_p, this.tntPos, Blocks.field_150335_W.func_176223_P().func_177226_a((IProperty)BlockTNT.field_176246_a, (Comparable)true));
            this.redcap.func_184609_a(EnumHand.MAIN_HAND);
            this.redcap.field_70170_p.func_180501_a(this.tntPos, Blocks.field_150350_a.func_176223_P(), 2);
            this.redcap.func_70661_as().func_75499_g();
        }
        else {
            this.redcap.func_70661_as().func_75492_a((double)this.tntPos.func_177958_n(), (double)this.tntPos.func_177956_o(), (double)this.tntPos.func_177952_p(), (double)this.pursueSpeed);
        }
    }
}
