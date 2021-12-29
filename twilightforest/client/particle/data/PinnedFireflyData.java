// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle.data;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.StringReader;
import net.minecraft.network.PacketBuffer;
import java.util.function.Function;
import com.mojang.serialization.Codec;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.IParticleData;

public class PinnedFireflyData implements IParticleData
{
    public final int follow;
    
    public PinnedFireflyData(final int follow) {
        this.follow = follow;
    }
    
    public ParticleType<?> func_197554_b() {
        return (ParticleType<?>)TFParticleType.FIREFLY_PINNED.get();
    }
    
    public static Codec<PinnedFireflyData> codecFirefly() {
        return (Codec<PinnedFireflyData>)Codec.INT.xmap((Function)PinnedFireflyData::new, obj -> obj.follow);
    }
    
    public void func_197553_a(final PacketBuffer buf) {
        buf.func_150787_b(this.follow);
    }
    
    public String func_197555_a() {
        return Integer.toString(this.follow);
    }
    
    public static class Deserializer implements IParticleData.IDeserializer<PinnedFireflyData>
    {
        public PinnedFireflyData deserialize(final ParticleType<PinnedFireflyData> type, final StringReader rdr) throws CommandSyntaxException {
            rdr.skipWhitespace();
            return new PinnedFireflyData(rdr.readInt());
        }
        
        public PinnedFireflyData read(final ParticleType<PinnedFireflyData> type, final PacketBuffer buf) {
            return new PinnedFireflyData(buf.func_150792_a());
        }
    }
}
