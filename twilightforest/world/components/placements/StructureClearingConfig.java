// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.placements;

import com.mojang.datafixers.kinds.Applicative;
import java.util.function.Function;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.DecoratorConfiguration;

record StructureClearingConfig(boolean occupiesSurface, boolean occupiesUnderground, int additionalClearance) implements DecoratorConfiguration {
    public static final Codec<StructureClearingConfig> CODEC;
    
    private static DataResult<StructureClearingConfig> validate(final StructureClearingConfig config) {
        return (DataResult<StructureClearingConfig>)((config.occupiesSurface() || config.occupiesUnderground()) ? DataResult.success((Object)config) : DataResult.error("Feature Decorator cannot occupy neither surface nor underground"));
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.BOOL.fieldOf("occupies_surface").forGetter((Function)StructureClearingConfig::occupiesSurface), (App)Codec.BOOL.fieldOf("occupies_underground").forGetter((Function)StructureClearingConfig::occupiesUnderground), (App)Codec.INT.fieldOf("additional_clearance").forGetter((Function)StructureClearingConfig::additionalClearance)).apply((Applicative)instance, StructureClearingConfig::new)).flatXmap((Function)StructureClearingConfig::validate, (Function)StructureClearingConfig::validate);
    }
}
