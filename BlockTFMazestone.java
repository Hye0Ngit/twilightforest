import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFMazestone extends ud
{
    static int[] mimicIDs;
    
    public BlockTFMazestone(final int id, final int texture) {
        super(id, texture, ls.e);
    }
    
    public int a(final int side, final int meta) {
        final ud mimic = ud.m[BlockTFMazestone.mimicIDs[meta]];
        if (mimic != null && mimic.a()) {
            return mimic.a(side);
        }
        return super.a(side, meta);
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public void a(final fq world, final hk entityplayer, final int x, final int y, final int z, final int meta) {
        final jm cei = entityplayer.Q();
        if (cei != null && hg.d[cei.c] instanceof ec) {
            cei.a(16, (lx)entityplayer);
        }
        final ud mimic = ud.m[BlockTFMazestone.mimicIDs[meta]];
        if (mimic != null) {
            mimic.a(world, entityplayer, x, y, z, 0);
        }
        else {
            super.a(world, entityplayer, x, y, z, meta);
        }
    }
    
    static {
        BlockTFMazestone.mimicIDs = new int[] { ud.v.bO, ud.y.bO, ud.aq.bO };
    }
}
