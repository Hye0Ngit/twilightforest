import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFMazestone extends ox
{
    static int[] mimicIDs;
    
    public BlockTFMazestone(final int id, final int texture) {
        super(id, texture, aci.e);
    }
    
    public int a(final int side, final int meta) {
        final ox mimic = ox.m[BlockTFMazestone.mimicIDs[meta]];
        if (mimic != null && mimic.a()) {
            return mimic.a_(side);
        }
        return super.a(side, meta);
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public void a(final wz world, final yr entityplayer, final int x, final int y, final int z, final int meta) {
        final aai cei = entityplayer.av();
        if (cei != null && ym.e[cei.c] instanceof cy) {
            cei.a(16, (acl)entityplayer);
        }
        final ox mimic = ox.m[BlockTFMazestone.mimicIDs[meta]];
        if (mimic != null) {
            mimic.a(world, entityplayer, x, y, z, 0);
        }
        else {
            super.a(world, entityplayer, x, y, z, meta);
        }
    }
    
    static {
        BlockTFMazestone.mimicIDs = new int[] { ox.t.bO, ox.w.bO, ox.ao.bO };
    }
}
