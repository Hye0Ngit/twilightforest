import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFLeafSphere extends ln
{
    int rad;
    
    protected ComponentTFLeafSphere(final int index, final int x, final int y, final int z, final int radius) {
        super(index);
        this.h = 0;
        this.g = new xv(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius);
        this.rad = radius;
    }
    
    public boolean a(final ge world, final Random rand, final xv sbb) {
        final int sx = this.rad;
        final int sy = this.rad;
        final int sz = this.rad;
        for (byte dx = 0; dx <= this.rad; ++dx) {
            for (byte dy = 0; dy <= this.rad; ++dy) {
                for (byte dz = 0; dz <= this.rad; ++dz) {
                    byte dist = 0;
                    if (dx >= dy && dx >= dz) {
                        dist = (byte)(dx + (byte)(Math.max(dy, dz) * 0.5 + Math.min(dy, dz) * 0.25));
                    }
                    else if (dy >= dx && dy >= dz) {
                        dist = (byte)(dy + (byte)(Math.max(dx, dz) * 0.5 + Math.min(dx, dz) * 0.25));
                    }
                    else {
                        dist = (byte)(dz + (byte)(Math.max(dx, dy) * 0.5 + Math.min(dx, dy) * 0.25));
                    }
                    if (dist <= this.rad) {
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.bO, 0, sx + dx, sy + dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.bO, 0, sx + dx, sy + dy, sz - dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.bO, 0, sx - dx, sy + dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.bO, 0, sx - dx, sy + dy, sz - dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.bO, 0, sx + dx, sy - dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.bO, 0, sx + dx, sy - dy, sz - dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.bO, 0, sx - dx, sy - dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.bO, 0, sx - dx, sy - dy, sz - dz, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    protected void placeBlockIfEmpty(final ge world, final int blockID, final int meta, final int x, final int y, final int z, final xv sbb) {
        if (this.a(world, x, y, z, sbb) == 0) {
            this.a(world, blockID, meta, x, y, z, sbb);
        }
    }
}
