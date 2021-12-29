// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import java.util.Random;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public final class WorldUtil
{
    private WorldUtil() {
    }
    
    public static Iterable<BlockPos> getAllAround(final BlockPos center, final int range) {
        return BlockPos.func_177980_a(center.func_177982_a(-range, -range, -range), center.func_177982_a(range, range, range));
    }
    
    public static Iterable<BlockPos> getAllInBB(final AxisAlignedBB bb) {
        return BlockPos.func_177980_a(new BlockPos(bb.field_72340_a, bb.field_72338_b, bb.field_72339_c), new BlockPos(bb.field_72336_d, bb.field_72337_e, bb.field_72334_f));
    }
    
    public static BlockPos randomOffset(final Random random, final BlockPos pos, final int range) {
        return randomOffset(random, pos, range, range, range);
    }
    
    public static BlockPos randomOffset(final Random random, final BlockPos pos, final int rx, final int ry, final int rz) {
        final int dx = random.nextInt(rx * 2 + 1) - rx;
        final int dy = random.nextInt(ry * 2 + 1) - ry;
        final int dz = random.nextInt(rz * 2 + 1) - rz;
        return pos.func_177982_a(dx, dy, dz);
    }
}
