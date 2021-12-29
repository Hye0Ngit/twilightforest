import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFMazestone extends vz
{
    static int[] mimicIDs;
    
    public BlockTFMazestone(final int id, final int texture) {
        super(id, texture, na.e);
    }
    
    public int a(final int side, final int meta) {
        final vz mimic = vz.m[BlockTFMazestone.mimicIDs[meta]];
        if (mimic != null && mimic.a()) {
            return mimic.a(side);
        }
        return super.a(side, meta);
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public void a(final ge world, final ih entityplayer, final int x, final int y, final int z, final int meta) {
        final kp cei = entityplayer.U();
        if (cei != null && id.d[cei.c] instanceof eq) {
            cei.a(16, (ne)entityplayer);
        }
        final vz mimic = vz.m[BlockTFMazestone.mimicIDs[meta]];
        if (mimic != null) {
            mimic.a(world, entityplayer, x, y, z, 0);
        }
        else {
            super.a(world, entityplayer, x, y, z, meta);
        }
    }
    
    static {
        BlockTFMazestone.mimicIDs = new int[] { vz.t.bO, vz.w.bO, vz.ao.bO };
    }
}
