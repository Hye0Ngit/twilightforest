// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.Rotation;
import net.minecraft.block.BlockLog;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFFinalCastleBridge extends StructureTFComponentOld
{
    public ComponentTFFinalCastleBridge() {
    }
    
    public ComponentTFFinalCastleBridge(final TFFeature feature, final int i, final int x, final int y, final int z, final int length, final EnumFacing direction) {
        super(feature, i);
        this.func_186164_a(direction);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox2(x, y, z, 0, -1, -3, length - 1, 5, 6, direction);
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int length = (this.field_74885_f == EnumFacing.SOUTH || this.field_74885_f == EnumFacing.NORTH) ? (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) : (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c);
        this.func_74882_a(world, sbb, 0, 0, 0, length, 1, 6, false, rand, this.deco.randomBlocks);
        final IBlockState castlePillar = TFBlocks.castle_pillar.func_176223_P().func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)((this.field_186169_c == Rotation.NONE || this.field_186169_c == Rotation.CLOCKWISE_180) ? BlockLog.EnumAxis.X : BlockLog.EnumAxis.Z));
        this.func_175804_a(world, sbb, 0, 2, 0, length, 2, 0, castlePillar, castlePillar, false);
        this.func_175804_a(world, sbb, 0, 2, 6, length, 2, 6, castlePillar, castlePillar, false);
        for (int l3 = length / 3, i = 0; i < l3; ++i) {
            final int sl = l3 - (int)(MathHelper.func_76134_b((l3 - i) / (float)l3 * 1.6f) * l3);
            this.func_74882_a(world, sbb, i, -sl, 0, i, 0, 0, false, rand, this.deco.randomBlocks);
            this.func_74882_a(world, sbb, i, -sl, 6, i, 0, 6, false, rand, this.deco.randomBlocks);
            this.func_74882_a(world, sbb, length - i, -sl, 0, length - i, 0, 0, false, rand, this.deco.randomBlocks);
            this.func_74882_a(world, sbb, length - i, -sl, 6, length - i, 0, 6, false, rand, this.deco.randomBlocks);
        }
        this.func_175804_a(world, sbb, 0, 2, 1, 0, 7, 1, this.deco.pillarState, this.deco.pillarState, false);
        this.func_175804_a(world, sbb, 0, 2, 5, 0, 7, 5, this.deco.pillarState, this.deco.pillarState, false);
        this.func_175804_a(world, sbb, 0, 6, 2, 0, 6, 4, this.deco.accentState, this.deco.accentState, false);
        this.func_175811_a(world, this.deco.pillarState, 0, 7, 3, sbb);
        this.func_175804_a(world, sbb, length, 2, 1, length, 7, 1, this.deco.pillarState, this.deco.pillarState, false);
        this.func_175804_a(world, sbb, length, 2, 5, length, 7, 5, this.deco.pillarState, this.deco.pillarState, false);
        this.func_175804_a(world, sbb, length, 6, 2, length, 6, 4, this.deco.accentState, this.deco.accentState, false);
        this.func_175811_a(world, this.deco.pillarState, length, 7, 3, sbb);
        return true;
    }
}
