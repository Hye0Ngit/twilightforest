// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

public class MapGenBase4096 extends acq
{
    public void generate(final abn par1IChunkProvider, final zv par2World, final int cx, final int cz, final short[] par5ArrayOfByte) {
        final int rangeVar = this.a;
        this.c = par2World;
        this.b.setSeed(par2World.F());
        final long long1 = this.b.nextLong();
        final long long2 = this.b.nextLong();
        for (int gx = cx - rangeVar; gx <= cx + rangeVar; ++gx) {
            for (int gz = cz - rangeVar; gz <= cz + rangeVar; ++gz) {
                final long var13 = gx * long1;
                final long var14 = gz * long2;
                this.b.setSeed(var13 ^ var14 ^ par2World.F());
                this.recursiveGenerate(par2World, gx, gz, cx, cz, par5ArrayOfByte);
            }
        }
    }
    
    protected void recursiveGenerate(final zv par1World, final int genX, final int genZ, final int centerX, final int centerZ, final short[] par6ArrayOfByte) {
    }
}
