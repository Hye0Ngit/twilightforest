import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFBossSpawner extends ags
{
    protected BlockTFBossSpawner(final int i) {
        super(i, 65, aci.e);
    }
    
    public kt u_() {
        return (kt)new TileEntityTFBossSpawner();
    }
    
    public int idDropped(final int i, final Random random) {
        return 0;
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public boolean a() {
        return false;
    }
    
    void spawnANaga(final wz world, final int dx, final int dy, final int dz) {
        final EntityTFNaga naga = new EntityTFNaga(world);
        naga.setHome(dx, dy, dz);
        naga.c((double)(dx + 4), (double)dy, (double)dz, world.r.nextFloat() * 360.0f, 0.0f);
        world.a((nk)naga);
    }
}
