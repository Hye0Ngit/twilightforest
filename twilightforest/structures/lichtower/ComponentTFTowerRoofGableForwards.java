// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFTowerRoofGableForwards extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofGableForwards() {
    }
    
    public ComponentTFTowerRoofGableForwards(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size + 2;
        this.height = this.size;
        this.makeAttachedOverhangBB(wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int slabMeta = 2;
        final int slopeChange = this.slopeChangeForSize(this.size);
        for (int y = 0; y <= this.height; ++y) {
            int min;
            int max;
            if (y < slopeChange) {
                min = y;
                max = this.size - y - 1;
            }
            else {
                min = (y + slopeChange) / 2;
                max = this.size - (y + slopeChange) / 2 - 1;
            }
            for (int x = 0; x <= this.size - 2; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (z == min || z == max) {
                        this.func_74864_a(world, Block.field_71988_x.field_71990_ca, slabMeta, x, y, z, sbb);
                    }
                    else if (x < this.size - 2) {
                        this.func_74864_a(world, Block.field_71988_x.field_71990_ca, slabMeta, x, y, z, sbb);
                    }
                }
            }
        }
        final int top = this.size + 1 - slopeChange;
        final int zMid = this.size / 2;
        this.func_74864_a(world, Block.field_72092_bO.field_71990_ca, slabMeta | 0xA, this.size - 1, top - 1, zMid, sbb);
        this.func_74864_a(world, Block.field_72092_bO.field_71990_ca, slabMeta, 0, top, zMid, sbb);
        this.func_74864_a(world, Block.field_72092_bO.field_71990_ca, slabMeta, this.size - 3, top, zMid, sbb);
        this.func_74864_a(world, Block.field_71988_x.field_71990_ca, slabMeta, this.size - 2, top, zMid, sbb);
        this.func_74864_a(world, Block.field_71988_x.field_71990_ca, slabMeta, this.size - 1, top, zMid, sbb);
        this.func_74864_a(world, Block.field_71988_x.field_71990_ca, slabMeta, this.size - 1, top + 1, zMid, sbb);
        return true;
    }
    
    public int slopeChangeForSize(final int pSize) {
        if (this.size > 10) {
            return 3;
        }
        if (this.size > 6) {
            return 2;
        }
        return 1;
    }
}
