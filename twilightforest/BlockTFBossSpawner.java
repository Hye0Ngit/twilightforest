// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class BlockTFBossSpawner extends agy
{
    protected BlockTFBossSpawner(final int i) {
        super(i, 65, acn.f);
        this.c(20.0f);
        this.b(10.0f);
    }
    
    public kw getBlockEntity(final int meta) {
        if (meta == 0) {
            return (kw)new TileEntityTFNagaSpawner();
        }
        if (meta == 1) {
            return (kw)new TileEntityTFLichSpawner();
        }
        return null;
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return 0;
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public boolean a() {
        return false;
    }
    
    public kw u_() {
        return null;
    }
}
