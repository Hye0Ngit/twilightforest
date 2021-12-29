// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import twilightforest.tileentity.spawner.FinalBossSpawnerTileEntity;
import twilightforest.tileentity.spawner.AlphaYetiSpawnerTileEntity;
import twilightforest.tileentity.spawner.MinoshroomSpawnerTileEntity;
import twilightforest.tileentity.spawner.SnowQueenSpawnerTileEntity;
import twilightforest.tileentity.spawner.KnightPhantomSpawnerTileEntity;
import twilightforest.tileentity.spawner.TowerBossSpawnerTileEntity;
import twilightforest.tileentity.spawner.HydraSpawnerTileEntity;
import twilightforest.tileentity.spawner.LichSpawnerTileEntity;
import twilightforest.tileentity.spawner.NagaSpawnerTileEntity;
import java.util.Locale;
import javax.annotation.Nullable;
import twilightforest.tileentity.spawner.BossSpawnerTileEntity;
import java.util.function.Supplier;
import net.minecraft.block.SkullBlock;
import net.minecraft.util.IStringSerializable;

public enum BossVariant implements IStringSerializable, SkullBlock.ISkullType
{
    NAGA(TrophyType.GOLD, (Supplier<? extends BossSpawnerTileEntity<?>>)NagaSpawnerTileEntity::new), 
    LICH(TrophyType.GOLD, (Supplier<? extends BossSpawnerTileEntity<?>>)LichSpawnerTileEntity::new), 
    HYDRA(TrophyType.GOLD, (Supplier<? extends BossSpawnerTileEntity<?>>)HydraSpawnerTileEntity::new), 
    UR_GHAST(TrophyType.GOLD, (Supplier<? extends BossSpawnerTileEntity<?>>)TowerBossSpawnerTileEntity::new), 
    KNIGHT_PHANTOM(TrophyType.IRON, (Supplier<? extends BossSpawnerTileEntity<?>>)KnightPhantomSpawnerTileEntity::new), 
    SNOW_QUEEN(TrophyType.GOLD, (Supplier<? extends BossSpawnerTileEntity<?>>)SnowQueenSpawnerTileEntity::new), 
    MINOSHROOM(TrophyType.IRON, (Supplier<? extends BossSpawnerTileEntity<?>>)MinoshroomSpawnerTileEntity::new), 
    ALPHA_YETI(TrophyType.IRON, (Supplier<? extends BossSpawnerTileEntity<?>>)AlphaYetiSpawnerTileEntity::new), 
    QUEST_RAM(TrophyType.IRONWOOD, (Supplier<? extends BossSpawnerTileEntity<?>>)null), 
    FINAL_BOSS(TrophyType.GOLD, (Supplier<? extends BossSpawnerTileEntity<?>>)FinalBossSpawnerTileEntity::new);
    
    private final Supplier<? extends BossSpawnerTileEntity<?>> factory;
    private final TrophyType trophyType;
    public static final BossVariant[] VARIANTS;
    
    private BossVariant(final TrophyType trophyType, final Supplier<? extends BossSpawnerTileEntity<?>> factory) {
        this.factory = factory;
        this.trophyType = trophyType;
    }
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
    
    public TrophyType getTrophyType() {
        return this.trophyType;
    }
    
    public boolean hasSpawner() {
        return this.factory != null;
    }
    
    @Nullable
    public BossSpawnerTileEntity<?> getSpawner() {
        return (this.factory != null) ? ((BossSpawnerTileEntity)this.factory.get()) : null;
    }
    
    static {
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
