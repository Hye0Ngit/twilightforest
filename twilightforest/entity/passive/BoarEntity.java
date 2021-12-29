// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PigEntity;

public class BoarEntity extends PigEntity
{
    public BoarEntity(final EntityType<? extends BoarEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    public PigEntity func_241840_a(final ServerWorld world, final AgeableEntity entityanimal) {
        return (PigEntity)TFEntities.wild_boar.func_200721_a((World)world);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.BOAR_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.BOAR_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.BOAR_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState blockIn) {
        this.func_184185_a(TFSounds.BOAR_STEP, 0.15f, 1.0f);
    }
}
