// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import twilightforest.block.entity.spawner.FinalBossSpawnerBlockEntity;
import twilightforest.block.entity.spawner.AlphaYetiSpawnerBlockEntity;
import twilightforest.block.entity.spawner.MinoshroomSpawnerBlockEntity;
import twilightforest.block.entity.spawner.SnowQueenSpawnerBlockEntity;
import twilightforest.block.entity.spawner.KnightPhantomSpawnerBlockEntity;
import twilightforest.block.entity.spawner.UrGhastSpawnerBlockEntity;
import twilightforest.block.entity.spawner.HydraSpawnerBlockEntity;
import twilightforest.block.entity.spawner.LichSpawnerBlockEntity;
import twilightforest.block.entity.spawner.NagaSpawnerBlockEntity;
import net.minecraftforge.fmllegacy.RegistryObject;
import java.util.Objects;
import twilightforest.block.entity.TFBlockEntities;
import java.util.Locale;
import javax.annotation.Nullable;
import twilightforest.block.entity.spawner.BossSpawnerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import java.util.function.Supplier;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.util.StringRepresentable;

public enum BossVariant implements StringRepresentable, SkullBlock.Type
{
    NAGA(gold, (Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>>)naga_SPAWNER::get), 
    LICH(gold2, (Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>>)lich_SPAWNER::get), 
    HYDRA(gold3, (Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>>)hydra_SPAWNER::get), 
    UR_GHAST(gold4, (Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>>)ur_GHAST_SPAWNER::get), 
    KNIGHT_PHANTOM(iron, (Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>>)knight_PHANTOM_SPAWNER::get), 
    SNOW_QUEEN(gold5, (Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>>)snow_QUEEN_SPAWNER::get), 
    MINOSHROOM(iron2, (Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>>)minoshroom_SPAWNER::get), 
    ALPHA_YETI(iron3, (Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>>)alpha_YETI_SPAWNER::get), 
    QUEST_RAM(TrophyType.IRONWOOD, (Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>>)null), 
    FINAL_BOSS(gold6, (Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>>)final_BOSS_SPAWNER::get);
    
    private final TrophyType trophyType;
    private final Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>> blockEntityType;
    public static final BossVariant[] VARIANTS;
    
    private BossVariant(final TrophyType trophyType, final Supplier<BlockEntityType<? extends BossSpawnerBlockEntity<?>>> blockEntityType) {
        this.trophyType = trophyType;
        this.blockEntityType = blockEntityType;
    }
    
    public String m_7912_() {
        return this.name().toLowerCase(Locale.ROOT);
    }
    
    public TrophyType getTrophyType() {
        return this.trophyType;
    }
    
    @Nullable
    public BlockEntityType<? extends BossSpawnerBlockEntity<?>> getType() {
        return (BlockEntityType<? extends BossSpawnerBlockEntity<?>>)((this.blockEntityType != null) ? ((BlockEntityType)this.blockEntityType.get()) : null);
    }
    
    static {
        final String s = "NAGA";
        final int n = 0;
        final TrophyType gold = TrophyType.GOLD;
        final RegistryObject<BlockEntityType<NagaSpawnerBlockEntity>> naga_SPAWNER = TFBlockEntities.NAGA_SPAWNER;
        Objects.requireNonNull(naga_SPAWNER);
        final String s2 = "LICH";
        final int n2 = 1;
        final TrophyType gold2 = TrophyType.GOLD;
        final RegistryObject<BlockEntityType<LichSpawnerBlockEntity>> lich_SPAWNER = TFBlockEntities.LICH_SPAWNER;
        Objects.requireNonNull(lich_SPAWNER);
        final String s3 = "HYDRA";
        final int n3 = 2;
        final TrophyType gold3 = TrophyType.GOLD;
        final RegistryObject<BlockEntityType<HydraSpawnerBlockEntity>> hydra_SPAWNER = TFBlockEntities.HYDRA_SPAWNER;
        Objects.requireNonNull(hydra_SPAWNER);
        final String s4 = "UR_GHAST";
        final int n4 = 3;
        final TrophyType gold4 = TrophyType.GOLD;
        final RegistryObject<BlockEntityType<UrGhastSpawnerBlockEntity>> ur_GHAST_SPAWNER = TFBlockEntities.UR_GHAST_SPAWNER;
        Objects.requireNonNull(ur_GHAST_SPAWNER);
        final String s5 = "KNIGHT_PHANTOM";
        final int n5 = 4;
        final TrophyType iron = TrophyType.IRON;
        final RegistryObject<BlockEntityType<KnightPhantomSpawnerBlockEntity>> knight_PHANTOM_SPAWNER = TFBlockEntities.KNIGHT_PHANTOM_SPAWNER;
        Objects.requireNonNull(knight_PHANTOM_SPAWNER);
        final String s6 = "SNOW_QUEEN";
        final int n6 = 5;
        final TrophyType gold5 = TrophyType.GOLD;
        final RegistryObject<BlockEntityType<SnowQueenSpawnerBlockEntity>> snow_QUEEN_SPAWNER = TFBlockEntities.SNOW_QUEEN_SPAWNER;
        Objects.requireNonNull(snow_QUEEN_SPAWNER);
        final String s7 = "MINOSHROOM";
        final int n7 = 6;
        final TrophyType iron2 = TrophyType.IRON;
        final RegistryObject<BlockEntityType<MinoshroomSpawnerBlockEntity>> minoshroom_SPAWNER = TFBlockEntities.MINOSHROOM_SPAWNER;
        Objects.requireNonNull(minoshroom_SPAWNER);
        final String s8 = "ALPHA_YETI";
        final int n8 = 7;
        final TrophyType iron3 = TrophyType.IRON;
        final RegistryObject<BlockEntityType<AlphaYetiSpawnerBlockEntity>> alpha_YETI_SPAWNER = TFBlockEntities.ALPHA_YETI_SPAWNER;
        Objects.requireNonNull(alpha_YETI_SPAWNER);
        final String s9 = "FINAL_BOSS";
        final int n9 = 9;
        final TrophyType gold6 = TrophyType.GOLD;
        final RegistryObject<BlockEntityType<FinalBossSpawnerBlockEntity>> final_BOSS_SPAWNER = TFBlockEntities.FINAL_BOSS_SPAWNER;
        Objects.requireNonNull(final_BOSS_SPAWNER);
        VARIANTS = values();
    }
    
    public enum TrophyType
    {
        GOLD("trophy"), 
        IRON("trophy_minor"), 
        IRONWOOD("trophy_quest");
        
        private final String modelName;
        
        private TrophyType(final String modelName) {
            this.modelName = modelName;
        }
        
        public String getModelName() {
            return this.modelName;
        }
    }
}
