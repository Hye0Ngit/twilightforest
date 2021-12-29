// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentTFLeafSphere extends StructureTFComponent
{
    int rad;
    
    protected ComponentTFLeafSphere(final int index, final int x, final int y, final int z, final int radius) {
        super(index);
        this.setCoordBaseMode(0);
        this.field_74887_e = new StructureBoundingBox(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius);
        this.rad = radius;
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
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
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.field_71990_ca, 0, sx + dx, sy + dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.field_71990_ca, 0, sx + dx, sy + dy, sz - dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.field_71990_ca, 0, sx - dx, sy + dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.field_71990_ca, 0, sx - dx, sy + dy, sz - dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.field_71990_ca, 0, sx + dx, sy - dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.field_71990_ca, 0, sx + dx, sy - dy, sz - dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.field_71990_ca, 0, sx - dx, sy - dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves.field_71990_ca, 0, sx - dx, sy - dy, sz - dz, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    protected void placeBlockIfEmpty(final World world, final int blockID, final int meta, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        if (this.func_74866_a(world, x, y, z, sbb) == 0) {
            this.func_74864_a(world, blockID, meta, x, y, z, sbb);
        }
    }
}
