// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFTowerBridge extends ComponentTFTowerWing
{
    int dSize;
    int dHeight;
    
    public ComponentTFTowerBridge() {
    }
    
    protected ComponentTFTowerBridge(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i, x, y, z, 3, 3, direction);
        this.dSize = pSize;
        this.dHeight = pHeight;
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final int[] dest = { 2, 1, 1 };
        this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], this.dSize, this.dHeight, Rotation.NONE);
    }
    
    public StructureBoundingBox getWingBB() {
        final int[] dest = this.offsetTowerCoords(2, 1, 1, this.dSize, this.func_186165_e());
        return StructureTFComponentOld.getComponentToAddBoundingBox(dest[0], dest[1], dest[2], 0, 0, 0, this.dSize - 1, this.dHeight - 1, this.dSize - 1, this.func_186165_e());
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int x = 0; x < 3; ++x) {
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x, 2, 0, sbb);
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x, 2, 2, sbb);
            this.func_175811_a(world, Blocks.field_150417_aV.func_176223_P(), x, 1, 0, sbb);
            this.func_175811_a(world, Blocks.field_150417_aV.func_176223_P(), x, 1, 2, sbb);
            this.func_175811_a(world, Blocks.field_150417_aV.func_176223_P(), x, 0, 0, sbb);
            this.func_175811_a(world, Blocks.field_150417_aV.func_176223_P(), x, 0, 1, sbb);
            this.func_175811_a(world, Blocks.field_150417_aV.func_176223_P(), x, 0, 2, sbb);
            this.func_175811_a(world, Blocks.field_150417_aV.func_176223_P(), x, -1, 1, sbb);
        }
        this.func_175811_a(world, Blocks.field_150417_aV.func_176223_P(), -1, -1, 1, sbb);
        this.func_175811_a(world, Blocks.field_150417_aV.func_176223_P(), 3, -1, 1, sbb);
        this.func_74878_a(world, sbb, 0, 1, 1, 2, 2, 1);
        return true;
    }
}
