// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.surfacebuilders;

import com.mojang.datafixers.kinds.App;
import net.minecraft.util.ExtraCodecs;
import com.mojang.datafixers.Products;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import java.util.function.Supplier;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;

public abstract class DelegatingSurfaceBuilder<ConfigWrapper extends DelegatingConfig> extends SurfaceBuilder<ConfigWrapper>
{
    public DelegatingSurfaceBuilder(final Codec<ConfigWrapper> pCodec) {
        super((Codec)pCodec);
    }
    
    public static class DelegatingConfig implements SurfaceBuilderConfiguration
    {
        protected final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilderSupplier;
        protected final ConfiguredSurfaceBuilder<?> surfaceBuilder;
        
        public DelegatingConfig(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilderSupplier) {
            this.surfaceBuilderSupplier = surfaceBuilderSupplier;
            this.surfaceBuilder = this.surfaceBuilderSupplier.get();
        }
        
        public final BlockState m_6743_() {
            return this.surfaceBuilder.m_74770_().m_6743_();
        }
        
        public final BlockState m_6744_() {
            return this.surfaceBuilder.m_74770_().m_6744_();
        }
        
        public final BlockState m_142434_() {
            return this.surfaceBuilder.m_74770_().m_142434_();
        }
        
        public static <SchemaGoal extends DelegatingConfig> Products.P1<RecordCodecBuilder.Mu<SchemaGoal>, Supplier<ConfiguredSurfaceBuilder<?>>> startCodec(final RecordCodecBuilder.Instance<SchemaGoal> instance) {
            return (Products.P1<RecordCodecBuilder.Mu<SchemaGoal>, Supplier<ConfiguredSurfaceBuilder<?>>>)instance.group((App)ConfiguredSurfaceBuilder.f_74763_.fieldOf("wrapped_surface_builder").flatXmap(ExtraCodecs.m_181037_(), ExtraCodecs.m_181037_()).forGetter(schemaGoal -> schemaGoal.surfaceBuilderSupplier));
        }
    }
}
