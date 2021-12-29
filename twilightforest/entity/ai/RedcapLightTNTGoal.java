// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import java.util.EnumSet;
import net.minecraft.entity.ai.goal.Goal;
import twilightforest.entity.RedcapEntity;
import net.minecraft.util.math.BlockPos;

public class RedcapLightTNTGoal extends RedcapBaseGoal
{
    private float pursueSpeed;
    private int delay;
    private BlockPos tntPos;
    
    public RedcapLightTNTGoal(final RedcapEntity hostEntity, final float speed) {
        super(hostEntity);
        this.tntPos = null;
        this.pursueSpeed = speed;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
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
        this.redcap.func_184201_a(EquipmentSlotType.MAINHAND, this.redcap.heldFlint);
    }
    
    public void func_75251_c() {
        this.redcap.func_70661_as().func_75499_g();
        this.redcap.func_184201_a(EquipmentSlotType.MAINHAND, this.redcap.heldPick);
        this.delay = 20;
        this.tntPos = null;
    }
    
    public void func_75246_d() {
        this.redcap.func_70671_ap().func_75650_a((double)this.tntPos.func_177958_n(), (double)this.tntPos.func_177956_o(), (double)this.tntPos.func_177952_p(), 30.0f, (float)this.redcap.func_70646_bf());
        if (this.redcap.func_195048_a(Vector3d.func_237491_b_((Vector3i)this.tntPos)) < 5.76) {
            this.redcap.func_70642_aH();
            Blocks.field_150335_W.catchFire(Blocks.field_150335_W.func_176223_P(), this.redcap.field_70170_p, this.tntPos, Direction.UP, (LivingEntity)this.redcap);
            this.redcap.func_184609_a(Hand.MAIN_HAND);
            this.redcap.field_70170_p.func_180501_a(this.tntPos, Blocks.field_150350_a.func_176223_P(), 2);
            this.redcap.func_70661_as().func_75499_g();
        }
        else {
            this.redcap.func_70661_as().func_75492_a((double)this.tntPos.func_177958_n(), (double)this.tntPos.func_177956_o(), (double)this.tntPos.func_177952_p(), (double)this.pursueSpeed);
        }
    }
}
