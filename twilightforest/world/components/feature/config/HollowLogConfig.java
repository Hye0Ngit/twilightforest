// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.config;

import java.util.function.BiFunction;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import javax.annotation.Nullable;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

record HollowLogConfig(BlockState normal, @Nullable BlockState hollow) implements FeatureConfiguration {
    public static final Codec<HollowLogConfig> CODEC;
    
    static {
        CODEC = RecordCodecBuilder.create(p_67632_ -> p_67632_.group((App)BlockState.f_61039_.fieldOf("normal").forGetter(p_160757_ -> p_160757_.normal), (App)BlockState.f_61039_.fieldOf("hollow").forGetter(p_160751_ -> p_160751_.hollow)).apply((Applicative)p_67632_, (BiFunction)HollowLogConfig::new));
    }
}
