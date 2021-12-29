// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.Entity;
import net.minecraft.world.IWorld;
import net.minecraft.entity.SpawnReason;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class TowerBroodlingEntity extends SwarmSpiderEntity
{
    public TowerBroodlingEntity(final EntityType<? extends TowerBroodlingEntity> type, final World world) {
        this(type, world, true);
    }
    
    public TowerBroodlingEntity(final EntityType<? extends TowerBroodlingEntity> type, final World world, final boolean spawnMore) {
        super(type, world, spawnMore);
        this.field_70728_aV = 3;
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return SwarmSpiderEntity.registerAttributes().func_233815_a_(Attributes.field_233818_a_, 7.0).func_233815_a_(Attributes.field_233823_f_, 4.0);
    }
    
    @Override
    protected SoundEvent func_184639_G() {
        return TFSounds.BROODLING_AMBIENT;
    }
    
    @Override
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.BROODLING_HURT;
    }
    
    @Override
    protected SoundEvent func_184615_bR() {
        return TFSounds.BROODLING_DEATH;
    }
    
    @Override
    protected void func_180429_a(final BlockPos pos, final BlockState blockIn) {
        this.func_184185_a(TFSounds.BROODLING_STEP, 0.15f, 1.0f);
    }
    
    @Override
    protected boolean spawnAnother() {
        final SwarmSpiderEntity another = new TowerBroodlingEntity(TFEntities.tower_broodling, this.field_70170_p, false);
        final double sx = this.func_226277_ct_() + (this.field_70146_Z.nextBoolean() ? 0.9 : -0.9);
        final double sy = this.func_226278_cu_();
        final double sz = this.func_226281_cx_() + (this.field_70146_Z.nextBoolean() ? 0.9 : -0.9);
        another.func_70012_b(sx, sy, sz, this.field_70146_Z.nextFloat() * 360.0f, 0.0f);
        if (!another.func_213380_a((IWorld)this.field_70170_p, SpawnReason.MOB_SUMMONED)) {
            another.func_70106_y();
            return false;
        }
        this.field_70170_p.func_217376_c((Entity)another);
        another.func_70656_aK();
        return true;
    }
}
