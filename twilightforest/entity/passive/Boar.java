// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;

public class Boar extends Pig
{
    public Boar(final EntityType<? extends Boar> type, final Level world) {
        super((EntityType)type, world);
    }
    
    public Pig m_142606_(final ServerLevel world, final AgeableMob entityanimal) {
        return (Pig)TFEntities.BOAR.m_20615_((Level)world);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.BOAR_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.BOAR_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.BOAR_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState blockIn) {
        this.m_5496_(TFSounds.BOAR_STEP, 0.15f, 1.0f);
    }
}
