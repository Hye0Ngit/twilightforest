// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import java.util.Iterator;
import twilightforest.advancements.TFAdvancements;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.world.registration.TFFeature;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import java.util.ArrayList;
import net.minecraft.world.BossEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerPlayer;
import java.util.List;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.entity.monster.Monster;

public class PlateauBoss extends Monster
{
    private final ServerBossEvent bossInfo;
    private final List<ServerPlayer> hurtBy;
    
    public PlateauBoss(final EntityType<? extends PlateauBoss> type, final Level world) {
        super((EntityType)type, world);
        this.bossInfo = new ServerBossEvent(this.m_5446_(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS);
        this.hurtBy = new ArrayList<ServerPlayer>();
        this.f_21364_ = 647;
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_();
    }
    
    protected void m_8099_() {
    }
    
    public void m_8107_() {
        if (!this.f_19853_.f_46443_) {
            this.bossInfo.m_142711_(this.m_21223_() / this.m_21233_());
        }
    }
    
    public boolean m_6785_(final double p_213397_1_) {
        return false;
    }
    
    public void m_6043_() {
        if (this.f_19853_.m_46791_() == Difficulty.PEACEFUL) {
            if (!this.m_21536_()) {
                this.f_19853_.m_46597_(this.m_21534_(), ((Block)TFBlocks.FINAL_BOSS_BOSS_SPAWNER.get()).m_49966_());
            }
            this.m_146870_();
        }
        else {
            super.m_6043_();
        }
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        final Entity 7639_ = source.m_7639_();
        if (7639_ instanceof final ServerPlayer player) {
            if (!this.hurtBy.contains(player)) {
                this.hurtBy.add(player);
            }
        }
        return super.m_6469_(source, amount);
    }
    
    public void m_6667_(final DamageSource cause) {
        super.m_6667_(cause);
        if (!this.f_19853_.f_46443_) {
            TFGenerationSettings.markStructureConquered(this.f_19853_, new BlockPos((Vec3i)this.m_142538_()), TFFeature.FINAL_CASTLE);
            for (final ServerPlayer player : this.hurtBy) {
                TFAdvancements.HURT_BOSS.trigger(player, (Entity)this);
            }
        }
    }
    
    public void m_6593_(@Nullable final Component name) {
        super.m_6593_(name);
        this.bossInfo.m_6456_(this.m_5446_());
    }
    
    public void m_6457_(final ServerPlayer player) {
        super.m_6457_(player);
        this.bossInfo.m_6543_(player);
    }
    
    public void m_6452_(final ServerPlayer player) {
        super.m_6452_(player);
        this.bossInfo.m_6539_(player);
    }
    
    public void m_7380_(final CompoundTag compound) {
        final BlockPos home = this.m_21534_();
        compound.m_128365_("Home", (Tag)this.m_20063_(new double[] { home.m_123341_(), home.m_123342_(), home.m_123343_() }));
        compound.m_128379_("HasHome", this.m_21536_());
        super.m_7380_(compound);
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        if (compound.m_128425_("Home", 9)) {
            final ListTag nbttaglist = compound.m_128437_("Home", 6);
            final int hx = (int)nbttaglist.m_128772_(0);
            final int hy = (int)nbttaglist.m_128772_(1);
            final int hz = (int)nbttaglist.m_128772_(2);
            this.m_21446_(new BlockPos(hx, hy, hz), 30);
        }
        if (!compound.m_128471_("HasHome")) {
            this.m_21536_();
        }
        if (this.m_8077_()) {
            this.bossInfo.m_6456_(this.m_5446_());
        }
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_6072_() {
        return false;
    }
}
