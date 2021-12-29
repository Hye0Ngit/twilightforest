// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.util.Rotation;
import net.minecraft.block.state.IBlockState;
import twilightforest.util.RotationUtil;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFCastleMagic;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFFinalCastleRoof48Crenellated extends StructureTFComponentOld
{
    public ComponentTFFinalCastleRoof48Crenellated() {
    }
    
    public ComponentTFFinalCastleRoof48Crenellated(final TFFeature feature, final Random rand, final int i, final StructureTFComponentOld keep) {
        super(feature, i);
        final int height = 5;
        this.func_186164_a(keep.func_186165_e());
        this.field_74887_e = new StructureBoundingBox(keep.func_74874_b().field_78897_a - 2, keep.func_74874_b().field_78894_e - 1, keep.func_74874_b().field_78896_c - 2, keep.func_74874_b().field_78893_d + 2, keep.func_74874_b().field_78894_e + height - 1, keep.func_74874_b().field_78892_f + 2);
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final IBlockState castleMagic = TFBlocks.castle_rune_brick.func_176223_P().func_177226_a((IProperty)BlockTFCastleMagic.COLOR, (Comparable)BlockTFCastleMagic.VALID_COLORS.get(3));
        this.func_175804_a(world, sbb, 2, 2, 2, 50, 2, 50, castleMagic, castleMagic, false);
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 3, 1, 1, 45, 3, 1, this.deco.blockState, rotation);
            for (int i = 10; i < 41; i += 5) {
                this.fillBlocksRotated(world, sbb, i, 1, 0, i + 2, 5, 2, this.deco.blockState, rotation);
                this.setBlockStateRotated(world, this.deco.blockState, i + 1, 0, 1, rotation, sbb);
            }
        }
        return true;
    }
}
