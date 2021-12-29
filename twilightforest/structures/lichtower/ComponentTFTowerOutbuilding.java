// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentTFTowerOutbuilding extends ComponentTFTowerWing
{
    public ComponentTFTowerOutbuilding() {
    }
    
    protected ComponentTFTowerOutbuilding(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void makeABeard(final StructureComponent parent, final List list, final Random rand) {
    }
    
    @Override
    public boolean makeTowerWing(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int direction) {
        return y > 7 && super.makeTowerWing(list, rand, index, x, y, z, wingSize, wingHeight, direction);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.func_74870_b(world, Block.field_71978_w.field_71990_ca, 0, x, -1, z, sbb);
            }
        }
        return super.func_74875_a(world, rand, sbb);
    }
}
