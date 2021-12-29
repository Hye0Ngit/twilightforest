// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class BlockTFMazestone extends pb
{
    static int[] mimicIDs;
    
    public BlockTFMazestone(final int id, final int texture) {
        super(id, texture, acn.e);
        this.c(20.0f);
        this.b(5.0f);
        this.a(pb.h);
    }
    
    public int a(final int side, final int meta) {
        final pb mimic = pb.m[BlockTFMazestone.mimicIDs[meta]];
        if (mimic != null && mimic.a()) {
            return mimic.a_(side);
        }
        return super.a(side, meta);
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public void a(final xd world, final yw entityplayer, final int x, final int y, final int z, final int meta) {
        final aan cei = entityplayer.av();
        if (cei != null && yr.e[cei.c] instanceof da) {
            cei.a(16, (acq)entityplayer);
        }
        final pb mimic = pb.m[BlockTFMazestone.mimicIDs[meta]];
        if (mimic != null) {
            mimic.a(world, entityplayer, x, y, z, 0);
        }
        else {
            super.a(world, entityplayer, x, y, z, meta);
        }
    }
    
    static {
        BlockTFMazestone.mimicIDs = new int[] { pb.t.bO, pb.w.bO, pb.ao.bO, pb.bm.bO };
    }
}
