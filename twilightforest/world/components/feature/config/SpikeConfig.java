// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.config;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class SpikeConfig implements FeatureConfiguration
{
    public static final Codec<SpikeConfig> CODEC;
    public final BlockStateProvider blockState;
    public final IntProvider lengthBounds;
    public final IntProvider tipClearance;
    public final boolean hang;
    
    public SpikeConfig(final BlockStateProvider state, final IntProvider lengthBounds, final IntProvider groundClearance, final boolean hang) {
        this.blockState = state;
        this.lengthBounds = lengthBounds;
        this.tipClearance = groundClearance;
        this.hang = hang;
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)BlockStateProvider.f_68747_.fieldOf("state").forGetter(c -> c.blockState), (App)IntProvider.m_146545_(1, 64).fieldOf("length_bounds").forGetter(c -> c.lengthBounds), (App)IntProvider.m_146545_(0, 10).fieldOf("tip_clearance").forGetter(c -> c.tipClearance), (App)Codec.BOOL.fieldOf("hanging").orElse((Object)true).forGetter(c -> c.hang)).apply((Applicative)instance, SpikeConfig::new));
    }
}
