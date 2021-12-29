// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.passive.AnimalEntity;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.item.DyeColor;
import java.util.Random;
import twilightforest.loot.TFTreasure;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.TFEntities;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.SheepEntity;

public class BighornEntity extends SheepEntity
{
    public BighornEntity(final EntityType<? extends BighornEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    public BighornEntity(final World world, final double x, final double y, final double z) {
        this(TFEntities.bighorn_sheep, world);
        this.func_70107_b(x, y, z);
    }
    
    public ResourceLocation func_184647_J() {
        if (this.func_70892_o()) {
            return this.func_200600_R().func_220348_g();
        }
        switch (this.func_175509_cj()) {
            default: {
                return TFTreasure.BIGHORN_SHEEP_WHITE;
            }
            case ORANGE: {
                return TFTreasure.BIGHORN_SHEEP_ORANGE;
            }
            case MAGENTA: {
                return TFTreasure.BIGHORN_SHEEP_MAGENTA;
            }
            case LIGHT_BLUE: {
                return TFTreasure.BIGHORN_SHEEP_LIGHT_BLUE;
            }
            case YELLOW: {
                return TFTreasure.BIGHORN_SHEEP_YELLOW;
            }
            case LIME: {
                return TFTreasure.BIGHORN_SHEEP_LIME;
            }
            case PINK: {
                return TFTreasure.BIGHORN_SHEEP_PINK;
            }
            case GRAY: {
                return TFTreasure.BIGHORN_SHEEP_GRAY;
            }
            case LIGHT_GRAY: {
                return TFTreasure.BIGHORN_SHEEP_LIGHT_GRAY;
            }
            case CYAN: {
                return TFTreasure.BIGHORN_SHEEP_CYAN;
            }
            case PURPLE: {
                return TFTreasure.BIGHORN_SHEEP_PURPLE;
            }
            case BLUE: {
                return TFTreasure.BIGHORN_SHEEP_BLUE;
            }
            case BROWN: {
                return TFTreasure.BIGHORN_SHEEP_BROWN;
            }
            case GREEN: {
                return TFTreasure.BIGHORN_SHEEP_GREEN;
            }
            case RED: {
                return TFTreasure.BIGHORN_SHEEP_RED;
            }
            case BLACK: {
                return TFTreasure.BIGHORN_SHEEP_BLACK;
            }
        }
    }
    
    private static DyeColor getRandomFleeceColor(final Random random) {
        return random.nextBoolean() ? DyeColor.BROWN : DyeColor.func_196056_a(random.nextInt(16));
    }
    
    @Nullable
    public ILivingEntityData func_213386_a(final IServerWorld worldIn, final DifficultyInstance difficulty, final SpawnReason reason, @Nullable ILivingEntityData livingdata, @Nullable final CompoundNBT dataTag) {
        livingdata = super.func_213386_a(worldIn, difficulty, reason, livingdata, dataTag);
        this.func_175512_b(getRandomFleeceColor(this.field_70170_p.field_73012_v));
        return livingdata;
    }
    
    public SheepEntity func_241840_a(final ServerWorld world, final AgeableEntity ageable) {
        if (!(ageable instanceof BighornEntity)) {
            TwilightForestMod.LOGGER.error("Code was called to breed a Bighorn with a non Bighorn! Cancelling!");
            return null;
        }
        final BighornEntity otherParent = (BighornEntity)ageable;
        final BighornEntity babySheep = (BighornEntity)TFEntities.bighorn_sheep.func_200721_a((World)world);
        babySheep.func_175512_b(this.func_175511_a((AnimalEntity)this, (AnimalEntity)otherParent));
        return babySheep;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.BIGHORN_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.BIGHORN_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.BIGHORN_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState block) {
        this.func_184185_a(TFSounds.BIGHORN_STEP, 0.15f, 1.0f);
    }
}
