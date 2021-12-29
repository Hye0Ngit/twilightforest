// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class BlockTFBossSpawner extends aju
{
    protected BlockTFBossSpawner(final int i) {
        super(i, 65, agb.f);
        this.c(20.0f);
        this.b(10.0f);
    }
    
    public anq a(final xv var1) {
        return null;
    }
    
    public anq createNewTileEntity(final xv world, final int metadata) {
        if (metadata == 0) {
            return (anq)new TileEntityTFNagaSpawner();
        }
        if (metadata == 1) {
            return (anq)new TileEntityTFLichSpawner();
        }
        if (metadata == 2) {
            return (anq)new TileEntityTFHydraSpawner();
        }
        return null;
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return 0;
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public boolean c() {
        return false;
    }
}
