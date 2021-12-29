// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import twilightforest.structures.StructureTFComponent;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFDarkTowerBalcony extends ComponentTFTowerWing
{
    public ComponentTFDarkTowerBalcony() {
    }
    
    protected ComponentTFDarkTowerBalcony(final int i, final int x, final int y, final int z, final int direction) {
        super(i, x, y, z, 5, 5, direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_151556_a(world, sbb, 0, 0, 0, 2, 0, 4, this.deco.accentID, this.deco.accentMeta, Blocks.field_150350_a, 0, false);
        this.func_151556_a(world, sbb, 0, 0, 1, 1, 0, 3, this.deco.blockID, this.deco.blockMeta, Blocks.field_150350_a, 0, false);
        this.func_151556_a(world, sbb, 0, 1, 0, 2, 1, 4, this.deco.fenceID, this.deco.fenceMeta, Blocks.field_150350_a, 0, false);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, 2, 1, 0, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, 2, 1, 4, sbb);
        this.func_74878_a(world, sbb, 0, 1, 1, 1, 1, 3);
        return true;
    }
}
