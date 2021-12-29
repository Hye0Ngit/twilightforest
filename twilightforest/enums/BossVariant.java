// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import twilightforest.tileentity.spawner.TileEntityTFFinalBossSpawner;
import twilightforest.tileentity.spawner.TileEntityTFAlphaYetiSpawner;
import twilightforest.tileentity.spawner.TileEntityTFMinoshroomSpawner;
import twilightforest.tileentity.spawner.TileEntityTFSnowQueenSpawner;
import twilightforest.tileentity.spawner.TileEntityTFKnightPhantomsSpawner;
import twilightforest.tileentity.spawner.TileEntityTFTowerBossSpawner;
import twilightforest.tileentity.spawner.TileEntityTFHydraSpawner;
import twilightforest.tileentity.spawner.TileEntityTFLichSpawner;
import twilightforest.tileentity.spawner.TileEntityTFNagaSpawner;
import java.util.Locale;
import javax.annotation.Nullable;
import twilightforest.tileentity.spawner.TileEntityTFBossSpawner;
import java.util.function.Supplier;
import net.minecraft.util.IStringSerializable;

public enum BossVariant implements IStringSerializable
{
    NAGA(TrophyType.GOLD, (Supplier<? extends TileEntityTFBossSpawner>)TileEntityTFNagaSpawner::new), 
    LICH(TrophyType.GOLD, (Supplier<? extends TileEntityTFBossSpawner>)TileEntityTFLichSpawner::new), 
    HYDRA(TrophyType.GOLD, (Supplier<? extends TileEntityTFBossSpawner>)TileEntityTFHydraSpawner::new), 
    UR_GHAST(TrophyType.GOLD, (Supplier<? extends TileEntityTFBossSpawner>)TileEntityTFTowerBossSpawner::new), 
    KNIGHT_PHANTOM(TrophyType.IRON, (Supplier<? extends TileEntityTFBossSpawner>)TileEntityTFKnightPhantomsSpawner::new), 
    SNOW_QUEEN(TrophyType.GOLD, (Supplier<? extends TileEntityTFBossSpawner>)TileEntityTFSnowQueenSpawner::new), 
    MINOSHROOM(TrophyType.IRON, (Supplier<? extends TileEntityTFBossSpawner>)TileEntityTFMinoshroomSpawner::new), 
    ALPHA_YETI(TrophyType.IRON, (Supplier<? extends TileEntityTFBossSpawner>)TileEntityTFAlphaYetiSpawner::new), 
    QUEST_RAM(TrophyType.IRONWOOD, (Supplier<? extends TileEntityTFBossSpawner>)null), 
    FINAL_BOSS(TrophyType.GOLD, (Supplier<? extends TileEntityTFBossSpawner>)TileEntityTFFinalBossSpawner::new);
    
    private final Supplier<? extends TileEntityTFBossSpawner> factory;
    private final TrophyType trophyType;
    public static final BossVariant[] VARIANTS;
    
    private BossVariant(final TrophyType trophyType, final Supplier<? extends TileEntityTFBossSpawner> factory) {
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
    public TileEntityTFBossSpawner getSpawner() {
        return (this.factory != null) ? ((TileEntityTFBossSpawner)this.factory.get()) : null;
    }
    
    public static BossVariant getVariant(final int id) {
        return (id >= 0 && id < BossVariant.VARIANTS.length) ? BossVariant.VARIANTS[id] : BossVariant.NAGA;
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
