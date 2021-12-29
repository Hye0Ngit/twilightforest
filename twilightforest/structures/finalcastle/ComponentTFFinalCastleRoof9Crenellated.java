// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFFinalCastleRoof9Crenellated extends StructureTFComponentOld
{
    public ComponentTFFinalCastleRoof9Crenellated() {
    }
    
    public ComponentTFFinalCastleRoof9Crenellated(final TFFeature feature, final Random rand, final int i, final StructureTFComponentOld sideTower) {
        super(feature, i);
        final int height = 5;
        this.func_186164_a(sideTower.func_186165_e());
        this.field_74887_e = new StructureBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78894_e - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78894_e + height - 1, sideTower.func_74874_b().field_78892_f + 2);
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 0, -1, 0, 2, 3, 2, this.deco.blockState, rotation);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 2, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 2, -2, 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 3, 0, 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 3, 1, 1, rotation, sbb);
            this.fillBlocksRotated(world, sbb, 4, 0, 0, 5, 3, 2, this.deco.blockState, rotation);
            this.setBlockStateRotated(world, this.deco.blockState, 6, 0, 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 6, 1, 1, rotation, sbb);
            this.fillBlocksRotated(world, sbb, 7, 0, 0, 8, 3, 2, this.deco.blockState, rotation);
            this.setBlockStateRotated(world, this.deco.blockState, 9, 0, 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 9, 1, 1, rotation, sbb);
        }
        return true;
    }
}
