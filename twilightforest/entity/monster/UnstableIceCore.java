// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.item.DyeColor;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.util.ColorUtil;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class UnstableIceCore extends BaseIceMob
{
    private static final float EXPLOSION_RADIUS = 1.0f;
    
    public UnstableIceCore(final EntityType<? extends UnstableIceCore> type, final Level world) {
        super(type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(2, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(3, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(3, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22279_, 0.23000000417232513).m_22268_(Attributes.f_22281_, 3.0);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.ICE_CORE_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.ICE_CORE_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.ICE_CORE_DEATH;
    }
    
    public float m_20236_(final Pose pose) {
        return this.m_20206_() * 0.6f;
    }
    
    protected void m_6153_() {
        ++this.f_20919_;
        if (this.f_20919_ == 60) {
            if (!this.f_19853_.f_46443_) {
                final boolean mobGriefing = ForgeEventFactory.getMobGriefingEvent(this.f_19853_, (Entity)this);
                this.f_19853_.m_46511_((Entity)this, this.m_20185_(), this.m_20186_(), this.m_20189_(), 1.0f, mobGriefing ? Explosion.BlockInteraction.BREAK : Explosion.BlockInteraction.DESTROY);
                if (mobGriefing) {
                    this.transformBlocks();
                }
            }
            this.f_20919_ = 19;
            super.m_6153_();
            this.f_20919_ = 60;
        }
    }
    
    private void transformBlocks() {
        final int range = 4;
        final BlockPos pos = new BlockPos((Vec3i)this.m_142538_());
        for (int dx = -range; dx <= range; ++dx) {
            for (int dy = -range; dy <= range; ++dy) {
                for (int dz = -range; dz <= range; ++dz) {
                    final double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
                    final float randRange = range + (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 2.0f;
                    if (distance < randRange) {
                        this.transformBlock(pos.m_142082_(dx, dy, dz));
                    }
                }
            }
        }
    }
    
    private void transformBlock(final BlockPos pos) {
        final BlockState state = this.f_19853_.m_8055_(pos);
        final Block block = state.m_60734_();
        if (block.m_7325_() < 8.0f && state.m_60800_((BlockGetter)this.f_19853_, pos) >= 0.0f) {
            final int blockColor = state.m_60780_((BlockGetter)this.f_19853_, pos).f_76396_;
            if (this.shouldTransformGlass(state, pos)) {
                this.f_19853_.m_46597_(pos, ColorUtil.STAINED_GLASS.getColor(getClosestDyeColor(blockColor)));
            }
            else if (this.shouldTransformClay(state, pos)) {
                this.f_19853_.m_46597_(pos, ColorUtil.TERRACOTTA.getColor(getClosestDyeColor(blockColor)));
            }
        }
    }
    
    private boolean shouldTransformClay(final BlockState state, final BlockPos pos) {
        return state.m_60796_((BlockGetter)this.f_19853_, pos);
    }
    
    private boolean shouldTransformGlass(final BlockState state, final BlockPos pos) {
        return state.m_60734_() != Blocks.f_50016_ && this.isBlockNormalBounds(state, pos) && (!state.m_60767_().m_76337_() || state.m_60767_() == Material.f_76274_ || state.m_60734_() == Blocks.f_50126_ || state.m_60734_() == TFBlocks.AURORA_BLOCK.get());
    }
    
    private boolean isBlockNormalBounds(final BlockState state, final BlockPos pos) {
        return Block.m_49916_(state.m_60808_((BlockGetter)this.f_19853_, pos));
    }
    
    private static DyeColor getClosestDyeColor(final int blockColor) {
        final int red = blockColor >> 16 & 0xFF;
        final int green = blockColor >> 8 & 0xFF;
        final int blue = blockColor & 0xFF;
        DyeColor bestColor = DyeColor.WHITE;
        int bestDifference = 1024;
        for (final DyeColor color : DyeColor.values()) {
            final float[] iColor = color.m_41068_();
            final int iRed = (int)(iColor[0] * 255.0f);
            final int iGreen = (int)(iColor[1] * 255.0f);
            final int iBlue = (int)(iColor[2] * 255.0f);
            final int difference = Math.abs(red - iRed) + Math.abs(green - iGreen) + Math.abs(blue - iBlue);
            if (difference < bestDifference) {
                bestColor = color;
                bestDifference = difference;
            }
        }
        return bestColor;
    }
    
    public int m_5792_() {
        return 8;
    }
}
