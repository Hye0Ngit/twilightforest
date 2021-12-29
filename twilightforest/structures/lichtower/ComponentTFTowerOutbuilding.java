// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFTowerOutbuilding extends ComponentTFTowerWing
{
    public ComponentTFTowerOutbuilding() {
    }
    
    protected ComponentTFTowerOutbuilding(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void makeABeard(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
    }
    
    @Override
    public boolean makeTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation direction) {
        return y > 7 && super.makeTowerWing(list, rand, index, x, y, z, wingSize, wingHeight, direction);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final IBlockState cobblestone = Blocks.field_150347_e.func_176223_P();
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.func_175808_b(world, cobblestone, x, -1, z, sbb);
            }
        }
        return super.func_74875_a(world, rand, sbb);
    }
}
