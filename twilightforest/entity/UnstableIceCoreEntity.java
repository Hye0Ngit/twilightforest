// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.item.DyeColor;
import twilightforest.block.TFBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import twilightforest.util.ColorUtil;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.entity.Pose;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class UnstableIceCoreEntity extends IceMobEntity
{
    private static final float EXPLOSION_RADIUS = 1.0f;
    
    public UnstableIceCoreEntity(final EntityType<? extends UnstableIceCoreEntity> type, final World world) {
        super(type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233821_d_, 0.23000000417232513).func_233815_a_(Attributes.field_233823_f_, 3.0);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.ICE_CORE_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.ICE_CORE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.ICE_CORE_DEATH;
    }
    
    public float func_213307_e(final Pose pose) {
        return this.func_213302_cg() * 0.6f;
    }
    
    protected void func_70609_aI() {
        ++this.field_70725_aQ;
        if (this.field_70725_aQ == 60) {
            if (!this.field_70170_p.field_72995_K) {
                final boolean mobGriefing = ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, (Entity)this);
                this.field_70170_p.func_217385_a((Entity)this, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), 1.0f, mobGriefing ? Explosion.Mode.BREAK : Explosion.Mode.DESTROY);
                if (mobGriefing) {
                    this.transformBlocks();
                }
            }
            this.field_70725_aQ = 19;
            super.func_70609_aI();
            this.field_70725_aQ = 60;
        }
    }
    
    private void transformBlocks() {
        final int range = 4;
        final BlockPos pos = new BlockPos((Vector3i)this.func_233580_cy_());
        for (int dx = -range; dx <= range; ++dx) {
            for (int dy = -range; dy <= range; ++dy) {
                for (int dz = -range; dz <= range; ++dz) {
                    final double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
                    final float randRange = range + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 2.0f;
                    if (distance < randRange) {
                        this.transformBlock(pos.func_177982_a(dx, dy, dz));
                    }
                }
            }
        }
    }
    
    private void transformBlock(final BlockPos pos) {
        final BlockState state = this.field_70170_p.func_180495_p(pos);
        final Block block = state.func_177230_c();
        if (block.func_149638_a() < 8.0f && state.func_185887_b((IBlockReader)this.field_70170_p, pos) >= 0.0f) {
            final int blockColor = state.func_185909_g((IBlockReader)this.field_70170_p, pos).field_76291_p;
            if (this.shouldTransformGlass(state, pos)) {
                this.field_70170_p.func_175656_a(pos, ColorUtil.STAINED_GLASS.getColor(getClosestDyeColor(blockColor)));
            }
            else if (this.shouldTransformClay(state, pos)) {
                this.field_70170_p.func_175656_a(pos, ColorUtil.TERRACOTTA.getColor(getClosestDyeColor(blockColor)));
            }
        }
    }
    
    private boolean shouldTransformClay(final BlockState state, final BlockPos pos) {
        return state.func_215686_e((IBlockReader)this.field_70170_p, pos);
    }
    
    private boolean shouldTransformGlass(final BlockState state, final BlockPos pos) {
        return state.func_177230_c() != Blocks.field_150350_a && this.isBlockNormalBounds(state, pos) && (!state.func_185904_a().func_76218_k() || state.func_185904_a() == Material.field_151584_j || state.func_177230_c() == Blocks.field_150432_aD || state.func_177230_c() == TFBlocks.aurora_block.get());
    }
    
    private boolean isBlockNormalBounds(final BlockState state, final BlockPos pos) {
        return Block.func_208062_a(state.func_196954_c((IBlockReader)this.field_70170_p, pos));
    }
    
    private static DyeColor getClosestDyeColor(final int blockColor) {
        final int red = blockColor >> 16 & 0xFF;
        final int green = blockColor >> 8 & 0xFF;
        final int blue = blockColor & 0xFF;
        DyeColor bestColor = DyeColor.WHITE;
        int bestDifference = 1024;
        for (final DyeColor color : DyeColor.values()) {
            final float[] iColor = color.func_193349_f();
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
    
    public int func_70641_bl() {
        return 8;
    }
}
