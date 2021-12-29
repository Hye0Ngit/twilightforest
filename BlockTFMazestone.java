import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFMazestone extends yy
{
    static int[] mimicIDs;
    
    public BlockTFMazestone(final int id, final int texture) {
        super(id, texture, p.e);
    }
    
    public int a(final int side, final int meta) {
        final yy mimic = yy.k[BlockTFMazestone.mimicIDs[meta]];
        if (mimic != null && mimic.a()) {
            return mimic.b(side);
        }
        return super.a(side, meta);
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public void a(final ry world, final vi entityplayer, final int x, final int y, final int z, final int meta) {
        final dk cei = entityplayer.aH();
        if (cei != null && acy.d[cei.c] instanceof ads) {
            cei.a(16, (nq)entityplayer);
        }
        final yy mimic = yy.k[BlockTFMazestone.mimicIDs[meta]];
        if (mimic != null) {
            mimic.a(world, entityplayer, x, y, z, 0);
        }
        else {
            super.a(world, entityplayer, x, y, z, meta);
        }
    }
    
    static {
        BlockTFMazestone.mimicIDs = new int[] { yy.t.bM, yy.w.bM, yy.ao.bM };
    }
}
