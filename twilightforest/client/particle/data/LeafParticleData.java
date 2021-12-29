// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle.data;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.StringReader;
import net.minecraft.network.FriendlyByteBuf;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.Codec;
import javax.annotation.Nonnull;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleOptions;

public class LeafParticleData implements ParticleOptions
{
    public final int r;
    public final int g;
    public final int b;
    
    public LeafParticleData(final int r, final int g, final int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    @Nonnull
    public ParticleType<?> m_6012_() {
        return (ParticleType<?>)TFParticleType.FALLEN_LEAF.get();
    }
    
    public static Codec<LeafParticleData> codecLeaf() {
        return (Codec<LeafParticleData>)RecordCodecBuilder.create(instance -> instance.group((App)Codec.INT.fieldOf("r").forGetter(obj -> obj.r), (App)Codec.INT.fieldOf("g").forGetter(obj -> obj.g), (App)Codec.INT.fieldOf("b").forGetter(obj -> obj.b)).apply((Applicative)instance, LeafParticleData::new));
    }
    
    public void m_7711_(@Nonnull final FriendlyByteBuf buf) {
        buf.m_130130_(this.r);
        buf.m_130130_(this.g);
        buf.m_130130_(this.b);
    }
    
    @Nonnull
    public String m_5942_() {
        return String.format("%d %d %d", this.r, this.g, this.b);
    }
    
    public static class Deserializer implements ParticleOptions.Deserializer<LeafParticleData>
    {
        @Nonnull
        public LeafParticleData fromCommand(@Nonnull final ParticleType<LeafParticleData> type, @Nonnull final StringReader reader) throws CommandSyntaxException {
            reader.skipWhitespace();
            final int r = reader.readInt();
            reader.skipWhitespace();
            final int g = reader.readInt();
            reader.skipWhitespace();
            final int b = reader.readInt();
            return new LeafParticleData(r, g, b);
        }
        
        @Nonnull
        public LeafParticleData fromNetwork(@Nonnull final ParticleType<LeafParticleData> type, final FriendlyByteBuf buf) {
            return new LeafParticleData(buf.m_130242_(), buf.m_130242_(), buf.m_130242_());
        }
    }
}
