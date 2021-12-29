// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.animal.Animal;
import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.item.DyeColor;
import java.util.Random;
import twilightforest.loot.TFTreasure;
import net.minecraft.resources.ResourceLocation;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;

public class Bighorn extends Sheep
{
    public Bighorn(final EntityType<? extends Bighorn> type, final Level world) {
        super((EntityType)type, world);
    }
    
    public Bighorn(final Level world, final double x, final double y, final double z) {
        this(TFEntities.BIGHORN_SHEEP, world);
        this.m_6034_(x, y, z);
    }
    
    public ResourceLocation m_7582_() {
        if (this.m_29875_()) {
            return this.m_6095_().m_20677_();
        }
        return switch (this.m_29874_()) {
            case ORANGE -> TFTreasure.BIGHORN_SHEEP_ORANGE;
            case MAGENTA -> TFTreasure.BIGHORN_SHEEP_MAGENTA;
            case LIGHT_BLUE -> TFTreasure.BIGHORN_SHEEP_LIGHT_BLUE;
            case YELLOW -> TFTreasure.BIGHORN_SHEEP_YELLOW;
            case LIME -> TFTreasure.BIGHORN_SHEEP_LIME;
            case PINK -> TFTreasure.BIGHORN_SHEEP_PINK;
            case GRAY -> TFTreasure.BIGHORN_SHEEP_GRAY;
            case LIGHT_GRAY -> TFTreasure.BIGHORN_SHEEP_LIGHT_GRAY;
            case CYAN -> TFTreasure.BIGHORN_SHEEP_CYAN;
            case PURPLE -> TFTreasure.BIGHORN_SHEEP_PURPLE;
            case BLUE -> TFTreasure.BIGHORN_SHEEP_BLUE;
            case BROWN -> TFTreasure.BIGHORN_SHEEP_BROWN;
            case GREEN -> TFTreasure.BIGHORN_SHEEP_GREEN;
            case RED -> TFTreasure.BIGHORN_SHEEP_RED;
            case BLACK -> TFTreasure.BIGHORN_SHEEP_BLACK;
            default -> TFTreasure.BIGHORN_SHEEP_WHITE;
        };
    }
    
    private static DyeColor getRandomFleeceColor(final Random random) {
        return random.nextBoolean() ? DyeColor.BROWN : DyeColor.m_41053_(random.nextInt(16));
    }
    
    @Nullable
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficulty, final MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable final CompoundTag dataTag) {
        livingdata = super.m_6518_(worldIn, difficulty, reason, livingdata, dataTag);
        this.m_29855_(getRandomFleeceColor(this.f_19853_.f_46441_));
        return livingdata;
    }
    
    public Sheep m_142606_(final ServerLevel world, final AgeableMob ageable) {
        if (!(ageable instanceof Bighorn)) {
            TwilightForestMod.LOGGER.error("Code was called to breed a Bighorn with a non Bighorn! Cancelling!");
            return null;
        }
        final Bighorn otherParent = (Bighorn)ageable;
        final Bighorn babySheep = (Bighorn)TFEntities.BIGHORN_SHEEP.m_20615_((Level)world);
        babySheep.m_29855_(this.m_29823_((Animal)this, (Animal)otherParent));
        return babySheep;
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.BIGHORN_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.BIGHORN_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.BIGHORN_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState block) {
        this.m_5496_(TFSounds.BIGHORN_STEP, 0.15f, 1.0f);
    }
}
