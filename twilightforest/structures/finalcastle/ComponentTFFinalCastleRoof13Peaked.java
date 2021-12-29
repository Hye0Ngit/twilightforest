// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.util.RotationUtil;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFFinalCastleRoof13Peaked extends StructureTFComponentOld
{
    public ComponentTFFinalCastleRoof13Peaked() {
    }
    
    public ComponentTFFinalCastleRoof13Peaked(final TFFeature feature, final Random rand, final int i, final StructureTFComponentOld sideTower) {
        super(feature, i);
        final int height = 18;
        this.func_186164_a(sideTower.func_186165_e());
        this.field_74887_e = new StructureBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78894_e - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78894_e + height - 1, sideTower.func_74874_b().field_78892_f + 2);
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int i = 0; i < 3; ++i) {
            this.func_175804_a(world, sbb, 1, i, i, 15, i, i, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 1, i, 16 - i, 15, i, 16 - i, this.deco.roofState, this.deco.roofState, false);
        }
        for (int i = 0; i < 3; ++i) {
            int dz = 3 + i;
            this.func_175804_a(world, sbb, 2, 5 + (i - 1) * 2, dz, 14, 4 + i * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 1, 1, dz, 1, 5 + (i - 1) * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 1, 5 + (i - 1) * 2, dz - 1, 1, 4 + i * 2, dz, this.deco.blockState, this.deco.blockState, false);
            this.func_175804_a(world, sbb, 15, 1, dz, 15, 5 + (i - 1) * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 15, 5 + (i - 1) * 2, dz - 1, 15, 4 + i * 2, dz, this.deco.blockState, this.deco.blockState, false);
            dz = 13 - i;
            this.func_175804_a(world, sbb, 2, 5 + (i - 1) * 2, dz, 14, 4 + i * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 1, 1, dz, 1, 5 + (i - 1) * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 1, 5 + (i - 1) * 2, dz, 1, 4 + i * 2, dz + 1, this.deco.blockState, this.deco.blockState, false);
            this.func_175804_a(world, sbb, 15, 1, dz, 15, 5 + (i - 1) * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 15, 5 + (i - 1) * 2, dz, 15, 4 + i * 2, dz + 1, this.deco.blockState, this.deco.blockState, false);
        }
        for (int i = 0; i < 3; ++i) {
            int dz = 6 + i;
            this.func_175804_a(world, sbb, 2, 12 + (i - 1) * 3, dz, 14, 11 + i * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 1, 1, dz, 1, 12 + (i - 1) * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 1, 12 + (i - 1) * 3, dz - 1, 1, 11 + i * 3, dz, this.deco.blockState, this.deco.blockState, false);
            this.func_175804_a(world, sbb, 15, 1, dz, 15, 12 + (i - 1) * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 15, 12 + (i - 1) * 3, dz - 1, 15, 11 + i * 3, dz, this.deco.blockState, this.deco.blockState, false);
            dz = 10 - i;
            this.func_175804_a(world, sbb, 2, 12 + (i - 1) * 3, dz, 14, 11 + i * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 1, 1, dz, 1, 12 + (i - 1) * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 1, 12 + (i - 1) * 3, dz, 1, 11 + i * 3, dz + 1, this.deco.blockState, this.deco.blockState, false);
            this.func_175804_a(world, sbb, 15, 1, dz, 15, 12 + (i - 1) * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.func_175804_a(world, sbb, 15, 12 + (i - 1) * 3, dz, 15, 11 + i * 3, dz + 1, this.deco.blockState, this.deco.blockState, false);
        }
        this.func_175804_a(world, sbb, 1, 18, 8, 5, 18, 8, this.deco.roofState, this.deco.roofState, false);
        this.func_175804_a(world, sbb, 11, 18, 8, 14, 18, 8, this.deco.roofState, this.deco.roofState, false);
        this.func_175804_a(world, sbb, 0, 17, 8, 1, 19, 8, this.deco.roofState, this.deco.roofState, false);
        this.func_175804_a(world, sbb, 15, 17, 8, 16, 19, 8, this.deco.roofState, this.deco.roofState, false);
        for (final Rotation rotation : new Rotation[] { Rotation.CLOCKWISE_90, Rotation.COUNTERCLOCKWISE_90 }) {
            this.fillBlocksRotated(world, sbb, 4, 0, 1, 12, 1, 1, this.deco.blockState, rotation);
            for (int j = 3; j < 13; j += 2) {
                this.fillBlocksRotated(world, sbb, j, -1, 1, j, 2, 1, this.deco.blockState, rotation);
            }
        }
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 0, -1, 0, 3, 2, 3, this.deco.blockState, rotation);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 2, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 2, -2, 1, rotation, sbb);
        }
        return true;
    }
}
