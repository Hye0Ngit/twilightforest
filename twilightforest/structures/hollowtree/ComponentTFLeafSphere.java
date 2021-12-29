// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFLeafSphere extends StructureTFComponent
{
    int radius;
    
    public ComponentTFLeafSphere() {
    }
    
    protected ComponentTFLeafSphere(final int index, final int x, final int y, final int z, final int radius) {
        super(index);
        this.setCoordBaseMode(0);
        this.field_74887_e = new StructureBoundingBox(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius);
        this.radius = radius;
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("leafRadius", this.radius);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.radius = par1NBTTagCompound.func_74762_e("leafRadius");
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int sx = this.radius;
        final int sy = this.radius;
        final int sz = this.radius;
        for (byte dx = 0; dx <= this.radius; ++dx) {
            for (byte dy = 0; dy <= this.radius; ++dy) {
                for (byte dz = 0; dz <= this.radius; ++dz) {
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
                    if (dist <= this.radius) {
                        this.placeBlockIfEmpty(world, TFBlocks.leaves, 0, sx + dx, sy + dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves, 0, sx + dx, sy + dy, sz - dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves, 0, sx - dx, sy + dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves, 0, sx - dx, sy + dy, sz - dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves, 0, sx + dx, sy - dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves, 0, sx + dx, sy - dy, sz - dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves, 0, sx - dx, sy - dy, sz + dz, sbb);
                        this.placeBlockIfEmpty(world, TFBlocks.leaves, 0, sx - dx, sy - dy, sz - dz, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    protected void placeBlockIfEmpty(final World world, final Block blockID, final int meta, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        if (this.func_151548_a(world, x, y, z, sbb) == Blocks.field_150350_a) {
            this.func_151550_a(world, blockID, meta, x, y, z, sbb);
        }
    }
}
