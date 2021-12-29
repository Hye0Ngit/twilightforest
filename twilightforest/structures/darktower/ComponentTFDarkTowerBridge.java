// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import twilightforest.structures.StructureTFComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFDarkTowerBridge extends ComponentTFTowerWing
{
    private int dSize;
    private int dHeight;
    
    public ComponentTFDarkTowerBridge() {
    }
    
    protected ComponentTFDarkTowerBridge(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i, x, y, z, 5, 5, direction);
        this.dSize = pSize;
        this.dHeight = pHeight;
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        this.makeTowerWing(list, rand, this.func_74877_c(), 4, 1, 2, this.dSize, this.dHeight, Rotation.NONE);
    }
    
    @Override
    public boolean makeTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        if (wingHeight < 6) {
            return false;
        }
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (dx[1] + wingHeight > 255) {
            return false;
        }
        final ComponentTFTowerWing wing = new ComponentTFDarkTowerWing(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, wing.func_74874_b());
        if (intersect == null || intersect == this) {
            list.add(wing);
            wing.func_74861_a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175804_a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, this.deco.blockState, this.deco.blockState, false);
        for (int x = 0; x < this.size; ++x) {
            this.func_175811_a(world, this.deco.accentState, x, 0, 0, sbb);
            this.func_175811_a(world, this.deco.accentState, x, this.height - 1, 0, sbb);
            this.func_175811_a(world, this.deco.accentState, x, 0, this.size - 1, sbb);
            this.func_175811_a(world, this.deco.accentState, x, this.height - 1, this.size - 1, sbb);
        }
        this.nullifySkyLightForBoundingBox(world);
        this.func_74878_a(world, sbb, 0, 1, 1, this.size - 1, this.height - 2, this.size - 2);
        return true;
    }
    
    public StructureBoundingBox getWingBB() {
        final int[] dest = this.offsetTowerCoords(4, 1, 2, this.dSize, this.func_186165_e());
        return StructureTFComponentOld.getComponentToAddBoundingBox(dest[0], dest[1], dest[2], 0, 0, 0, this.dSize - 1, this.dHeight - 1, this.dSize - 1, this.func_186165_e());
    }
}
