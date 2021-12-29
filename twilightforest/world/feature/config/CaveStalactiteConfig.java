// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature.config;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class CaveStalactiteConfig implements IFeatureConfig
{
    public static final Codec<CaveStalactiteConfig> caveStalactiteCodec;
    public final BlockState blockState;
    public final float sizeFactor;
    public final int maxLength;
    public final int minHeight;
    public final boolean hang;
    
    public CaveStalactiteConfig(final BlockState state, final float size, final int length, final int height, final boolean hang) {
        this.blockState = state;
        this.sizeFactor = size;
        this.maxLength = length;
        this.minHeight = height;
        this.hang = hang;
    }
    
    static {
        caveStalactiteCodec = RecordCodecBuilder.create(instance -> instance.group((App)BlockState.field_235877_b_.fieldOf("state").forGetter(obj -> obj.blockState), (App)Codec.FLOAT.fieldOf("size_factor").orElse((Object)0.0f).forGetter(obj -> obj.sizeFactor), (App)Codec.INT.fieldOf("max_length").orElse((Object)(-1)).forGetter(obj -> obj.maxLength), (App)Codec.INT.fieldOf("min_height").orElse((Object)(-1)).forGetter(obj -> obj.minHeight), (App)Codec.BOOL.fieldOf("hanging").orElse((Object)false).forGetter(obj -> obj.hang)).apply((Applicative)instance, CaveStalactiteConfig::new));
    }
}
