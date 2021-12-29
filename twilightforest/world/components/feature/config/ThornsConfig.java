// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.config;

import com.mojang.datafixers.kinds.Applicative;
import java.util.function.Function;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

record ThornsConfig(int maxSpread, int chanceOfBranch, int chanceOfLeaf, int chanceLeafIsRose) implements FeatureConfiguration {
    public static final Codec<ThornsConfig> CODEC;
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.INT.fieldOf("max_spread").forGetter((Function)ThornsConfig::maxSpread), (App)Codec.INT.fieldOf("chance_of_branch").forGetter((Function)ThornsConfig::chanceOfBranch), (App)Codec.INT.fieldOf("chance_of_leaf").forGetter((Function)ThornsConfig::chanceOfLeaf), (App)Codec.INT.fieldOf("chance_leaf_is_rose").forGetter((Function)ThornsConfig::chanceLeafIsRose)).apply((Applicative)instance, ThornsConfig::new));
    }
}
