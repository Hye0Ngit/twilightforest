// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;

public class MapGenBase4096 extends MapGenBase
{
    public void generate(final IChunkProvider par1IChunkProvider, final World par2World, final int cx, final int cz, final short[] par5ArrayOfByte) {
        final int rangeVar = this.field_75040_a;
        this.field_75039_c = par2World;
        this.field_75038_b.setSeed(par2World.func_72905_C());
        final long long1 = this.field_75038_b.nextLong();
        final long long2 = this.field_75038_b.nextLong();
        for (int gx = cx - rangeVar; gx <= cx + rangeVar; ++gx) {
            for (int gz = cz - rangeVar; gz <= cz + rangeVar; ++gz) {
                final long var13 = gx * long1;
                final long var14 = gz * long2;
                this.field_75038_b.setSeed(var13 ^ var14 ^ par2World.func_72905_C());
                this.recursiveGenerate(par2World, gx, gz, cx, cz, par5ArrayOfByte);
            }
        }
    }
    
    protected void recursiveGenerate(final World par1World, final int genX, final int genZ, final int centerX, final int centerZ, final short[] par6ArrayOfByte) {
    }
}
