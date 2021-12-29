// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import twilightforest.tileentity.TileEntityTFHydraSpawner;
import twilightforest.tileentity.TileEntityTFLichSpawner;
import twilightforest.tileentity.TileEntityTFNagaSpawner;

public class BlockTFBossSpawner extends akb
{
    protected BlockTFBossSpawner(final int i) {
        super(i, 65, agi.f);
        this.c(20.0f);
        this.b(10.0f);
    }
    
    public any a(final yc var1) {
        return null;
    }
    
    public any createNewTileEntity(final yc world, final int metadata) {
        if (metadata == 0) {
            return (any)new TileEntityTFNagaSpawner();
        }
        if (metadata == 1) {
            return (any)new TileEntityTFLichSpawner();
        }
        if (metadata == 2) {
            return (any)new TileEntityTFHydraSpawner();
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
