// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;
import twilightforest.entity.monster.Redcap;
import net.minecraft.core.BlockPos;

public class RedcapLightTNTGoal extends RedcapBaseGoal
{
    private float pursueSpeed;
    private int delay;
    private BlockPos tntPos;
    
    public RedcapLightTNTGoal(final Redcap hostEntity, final float speed) {
        super(hostEntity);
        this.tntPos = null;
        this.pursueSpeed = speed;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean m_8036_() {
        if (!ForgeEventFactory.getMobGriefingEvent(this.redcap.f_19853_, (Entity)this.redcap)) {
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
    
    public boolean m_8045_() {
        return this.redcap.f_19853_.m_8055_(this.tntPos).m_60734_() == Blocks.f_50077_;
    }
    
    public void m_8056_() {
        this.redcap.m_8061_(EquipmentSlot.MAINHAND, this.redcap.heldFlint);
    }
    
    public void m_8041_() {
        this.redcap.m_21573_().m_26573_();
        this.redcap.m_8061_(EquipmentSlot.MAINHAND, this.redcap.heldPick);
        this.delay = 20;
        this.tntPos = null;
    }
    
    public void m_8037_() {
        this.redcap.m_21563_().m_24950_((double)this.tntPos.m_123341_(), (double)this.tntPos.m_123342_(), (double)this.tntPos.m_123343_(), 30.0f, (float)this.redcap.m_8132_());
        if (this.redcap.m_20238_(Vec3.m_82528_((Vec3i)this.tntPos)) < 5.76) {
            this.redcap.m_8032_();
            Blocks.f_50077_.catchFire(Blocks.f_50077_.m_49966_(), this.redcap.f_19853_, this.tntPos, Direction.UP, (LivingEntity)this.redcap);
            this.redcap.m_6674_(InteractionHand.MAIN_HAND);
            this.redcap.f_19853_.m_7731_(this.tntPos, Blocks.f_50016_.m_49966_(), 2);
            this.redcap.m_21573_().m_26573_();
        }
        else {
            this.redcap.m_21573_().m_26519_((double)this.tntPos.m_123341_(), (double)this.tntPos.m_123342_(), (double)this.tntPos.m_123343_(), (double)this.pursueSpeed);
        }
    }
}
