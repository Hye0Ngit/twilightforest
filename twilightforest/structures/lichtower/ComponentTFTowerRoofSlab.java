// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFTowerRoofSlab extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofSlab() {
    }
    
    public ComponentTFTowerRoofSlab(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int slabMeta = 2;
        return this.makePyramidCap(world, slabMeta, sbb);
    }
    
    protected boolean makePyramidCap(final World world, final int slabMeta, final StructureBoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min || x == max || z == min || z == max) {
                        this.func_151550_a(world, (Block)Blocks.field_150376_bx, slabMeta, x, y, z, sbb);
                    }
                    else {
                        this.func_151550_a(world, Blocks.field_150344_f, slabMeta, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    protected boolean makeConnectedCap(final World world, final int slabMeta, final StructureBoundingBox sbb) {
        for (int y = 0; y < this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max || z == min || z == max) {
                        this.func_151550_a(world, (Block)Blocks.field_150376_bx, slabMeta, x, y, z, sbb);
                    }
                    else {
                        this.func_151550_a(world, Blocks.field_150344_f, slabMeta, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
