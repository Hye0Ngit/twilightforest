import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFBossSpawner extends rl
{
    protected BlockTFBossSpawner(final int i) {
        super(i, 65, ls.e);
    }
    
    public ow a_() {
        return new TileEntityTFBossSpawner();
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
    
    void spawnANaga(final fq world, final int dx, final int dy, final int dz) {
        final EntityTFNaga naga = new EntityTFNaga(world);
        naga.setHome(dx, dy, dz);
        naga.c((double)(dx + 4), (double)dy, (double)dz, world.w.nextFloat() * 360.0f, 0.0f);
        world.b((se)naga);
    }
}
