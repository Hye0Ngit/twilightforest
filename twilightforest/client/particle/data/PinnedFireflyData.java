// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle.data;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.StringReader;
import net.minecraft.network.FriendlyByteBuf;
import java.util.function.Function;
import com.mojang.serialization.Codec;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleOptions;

public class PinnedFireflyData implements ParticleOptions
{
    public final int follow;
    
    public PinnedFireflyData(final int follow) {
        this.follow = follow;
    }
    
    public ParticleType<?> m_6012_() {
        return (ParticleType<?>)TFParticleType.FIREFLY_PINNED.get();
    }
    
    public static Codec<PinnedFireflyData> codecFirefly() {
        return (Codec<PinnedFireflyData>)Codec.INT.xmap((Function)PinnedFireflyData::new, obj -> obj.follow);
    }
    
    public void m_7711_(final FriendlyByteBuf buf) {
        buf.m_130130_(this.follow);
    }
    
    public String m_5942_() {
        return Integer.toString(this.follow);
    }
    
    public static class Deserializer implements ParticleOptions.Deserializer<PinnedFireflyData>
    {
        public PinnedFireflyData fromCommand(final ParticleType<PinnedFireflyData> type, final StringReader rdr) throws CommandSyntaxException {
            rdr.skipWhitespace();
            return new PinnedFireflyData(rdr.readInt());
        }
        
        public PinnedFireflyData fromNetwork(final ParticleType<PinnedFireflyData> type, final FriendlyByteBuf buf) {
            return new PinnedFireflyData(buf.m_130242_());
        }
    }
}
