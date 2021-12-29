import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFBossSpawner extends sz
{
    protected BlockTFBossSpawner(final int i) {
        super(i, 65, na.f);
    }
    
    public qj getBlockEntity(final int meta) {
        if (meta == 0) {
            return (qj)new TileEntityTFNagaSpawner();
        }
        if (meta == 1) {
            return (qj)new TileEntityTFLichSpawner();
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
    
    public qj a_() {
        return null;
    }
}
