// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import twilightforest.structures.StructureTFComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentTFTowerBridge extends ComponentTFTowerWing
{
    int dSize;
    int dHeight;
    
    public ComponentTFTowerBridge() {
    }
    
    protected ComponentTFTowerBridge(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, 3, 3, direction);
        this.dSize = pSize;
        this.dHeight = pHeight;
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        final int[] dest = { 2, 1, 1 };
        this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], this.dSize, this.dHeight, 0);
    }
    
    public StructureBoundingBox getWingBB() {
        final int[] dest = this.offsetTowerCoords(2, 1, 1, this.dSize, this.getCoordBaseMode());
        return StructureTFComponent.getComponentToAddBoundingBox(dest[0], dest[1], dest[2], 0, 0, 0, this.dSize - 1, this.dHeight - 1, this.dSize - 1, this.getCoordBaseMode());
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int x = 0; x < 3; ++x) {
            this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, x, 2, 0, sbb);
            this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, x, 2, 2, sbb);
            this.func_74864_a(world, Block.field_72007_bm.field_71990_ca, 0, x, 1, 0, sbb);
            this.func_74864_a(world, Block.field_72007_bm.field_71990_ca, 0, x, 1, 2, sbb);
            this.func_74864_a(world, Block.field_72007_bm.field_71990_ca, 0, x, 0, 0, sbb);
            this.func_74864_a(world, Block.field_72007_bm.field_71990_ca, 0, x, 0, 1, sbb);
            this.func_74864_a(world, Block.field_72007_bm.field_71990_ca, 0, x, 0, 2, sbb);
            this.func_74864_a(world, Block.field_72007_bm.field_71990_ca, 0, x, -1, 1, sbb);
        }
        this.func_74864_a(world, Block.field_72007_bm.field_71990_ca, 0, -1, -1, 1, sbb);
        this.func_74864_a(world, Block.field_72007_bm.field_71990_ca, 0, 3, -1, 1, sbb);
        this.func_74878_a(world, sbb, 0, 1, 1, 2, 2, 1);
        return true;
    }
}
