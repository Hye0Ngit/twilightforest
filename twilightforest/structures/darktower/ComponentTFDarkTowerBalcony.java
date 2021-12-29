// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import twilightforest.structures.StructureTFComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFDarkTowerBalcony extends ComponentTFTowerWing
{
    public ComponentTFDarkTowerBalcony() {
    }
    
    protected ComponentTFDarkTowerBalcony(final TFFeature feature, final int i, final int x, final int y, final int z, final EnumFacing direction) {
        super(feature, i, x, y, z, 5, 5, direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175804_a(world, sbb, 0, 0, 0, 2, 0, 4, this.deco.accentState, Blocks.field_150350_a.func_176223_P(), false);
        this.func_175804_a(world, sbb, 0, 0, 1, 1, 0, 3, this.deco.blockState, Blocks.field_150350_a.func_176223_P(), false);
        this.func_175804_a(world, sbb, 0, 1, 0, 2, 1, 4, this.deco.fenceState, Blocks.field_150350_a.func_176223_P(), false);
        this.func_175811_a(world, this.deco.accentState, 2, 1, 0, sbb);
        this.func_175811_a(world, this.deco.accentState, 2, 1, 4, sbb);
        this.func_74878_a(world, sbb, 0, 1, 1, 1, 1, 3);
        return true;
    }
}
