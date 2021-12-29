// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle.data;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.StringReader;
import net.minecraft.network.PacketBuffer;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.Codec;
import javax.annotation.Nonnull;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.IParticleData;

public class LeafParticleData implements IParticleData
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
    public ParticleType<?> func_197554_b() {
        return (ParticleType<?>)TFParticleType.FALLEN_LEAF.get();
    }
    
    public static Codec<LeafParticleData> codecLeaf() {
        return (Codec<LeafParticleData>)RecordCodecBuilder.create(instance -> instance.group((App)Codec.INT.fieldOf("r").forGetter(obj -> obj.r), (App)Codec.INT.fieldOf("g").forGetter(obj -> obj.g), (App)Codec.INT.fieldOf("b").forGetter(obj -> obj.b)).apply((Applicative)instance, LeafParticleData::new));
    }
    
    public void func_197553_a(@Nonnull final PacketBuffer buf) {
        buf.func_150787_b(this.r);
        buf.func_150787_b(this.g);
        buf.func_150787_b(this.b);
    }
    
    @Nonnull
    public String func_197555_a() {
        return String.format("%d %d %d", this.r, this.g, this.b);
    }
    
    public static class Deserializer implements IParticleData.IDeserializer<LeafParticleData>
    {
        @Nonnull
        public LeafParticleData deserialize(@Nonnull final ParticleType<LeafParticleData> type, @Nonnull final StringReader reader) throws CommandSyntaxException {
            reader.skipWhitespace();
            final int r = reader.readInt();
            reader.skipWhitespace();
            final int g = reader.readInt();
            reader.skipWhitespace();
            final int b = reader.readInt();
            return new LeafParticleData(r, g, b);
        }
        
        @Nonnull
        public LeafParticleData read(@Nonnull final ParticleType<LeafParticleData> type, final PacketBuffer buf) {
            return new LeafParticleData(buf.func_150792_a(), buf.func_150792_a(), buf.func_150792_a());
        }
    }
}
