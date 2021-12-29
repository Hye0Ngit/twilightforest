// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Rotation;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFCastleMagic;
import twilightforest.block.BlockTFCastleDoor;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFFinalCastleStairTower extends ComponentTFTowerWing
{
    public ComponentTFFinalCastleStairTower() {
    }
    
    public ComponentTFFinalCastleStairTower(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i);
        this.func_186164_a(rotation);
        this.size = 9;
        this.height = 51;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -4, 0, -4, 8, 50, 8, EnumFacing.SOUTH);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        final ComponentTFFinalCastleRoof9Crenellated roof = new ComponentTFFinalCastleRoof9Crenellated(this.getFeatureType(), rand, 4, this);
        list.add(roof);
        roof.func_74861_a(this, list, rand);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.func_74882_a(world, sbb, 0, 0, 0, 8, 49, 8, false, rand, this.deco.randomBlocks);
        for (int numBranches = 6 + decoRNG.nextInt(4), i = 0; i < numBranches; ++i) {
            this.makeGlyphBranches(world, decoRNG, this.getGlyphMeta(), sbb);
        }
        for (int i = 1; i < 4; ++i) {
            this.func_74882_a(world, sbb, i, 0 - i * 2, i, 8 - i, 1 - i * 2, 8 - i, false, rand, this.deco.randomBlocks);
        }
        this.func_175811_a(world, this.deco.blockState, 4, -7, 4, sbb);
        final IBlockState castleDoor = TFBlocks.castle_door.func_176223_P().func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, (Comparable)BlockTFCastleMagic.VALID_COLORS.indexOf(this.getGlyphMeta()));
        this.func_175804_a(world, sbb, 0, 1, 1, 0, 3, 2, castleDoor, ComponentTFFinalCastleStairTower.AIR, false);
        Rotation rotation = Rotation.CLOCKWISE_90;
        for (int f = 0; f < 5; ++f) {
            rotation = rotation.func_185830_a(Rotation.CLOCKWISE_90);
            final int y = f * 3 + 1;
            for (int j = 0; j < 3; ++j) {
                final int sx = 3 + j;
                final int sy = y + j;
                final int sz = 1;
                this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), sx, sy, sz, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, sx, sy - 1, sz, rotation, sbb);
                this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), sx, sy, sz + 1, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, sx, sy - 1, sz + 1, rotation, sbb);
            }
            this.fillBlocksRotated(world, sbb, 6, y + 2, 1, 7, y + 2, 2, this.deco.blockState, rotation);
        }
        this.func_175804_a(world, sbb, 1, 18, 0, 2, 20, 0, castleDoor, ComponentTFFinalCastleStairTower.AIR, false);
        final IBlockState stairState = StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false);
        this.func_175804_a(world, sbb, 1, 17, 1, 3, 17, 3, this.deco.blockState, this.deco.blockState, false);
        this.func_175804_a(world, sbb, 1, 17, 4, 2, 17, 4, stairState, stairState, false);
        this.func_175804_a(world, sbb, 1, 16, 4, 2, 16, 4, this.deco.blockState, this.deco.blockState, false);
        this.func_175804_a(world, sbb, 1, 16, 5, 2, 16, 5, stairState, stairState, false);
        this.func_175804_a(world, sbb, 1, 15, 5, 2, 15, 5, this.deco.blockState, this.deco.blockState, false);
        this.func_175804_a(world, sbb, 1, 39, 0, 2, 41, 0, castleDoor, ComponentTFFinalCastleStairTower.AIR, false);
        rotation = Rotation.COUNTERCLOCKWISE_90;
        for (int f2 = 0; f2 < 7; ++f2) {
            rotation = rotation.func_185830_a(Rotation.CLOCKWISE_90);
            final int y2 = f2 * 3 + 18;
            for (int k = 0; k < 3; ++k) {
                final int sx2 = 3 + k;
                final int sy2 = y2 + k;
                final int sz2 = 1;
                this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), sx2, sy2, sz2, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, sx2, sy2 - 1, sz2, rotation, sbb);
                this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), sx2, sy2, sz2 + 1, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, sx2, sy2 - 1, sz2 + 1, rotation, sbb);
            }
            this.fillBlocksRotated(world, sbb, 6, y2 + 2, 1, 7, y2 + 2, 2, this.deco.blockState, rotation);
        }
        this.func_175804_a(world, sbb, 1, 38, 1, 3, 38, 5, this.deco.blockState, this.deco.blockState, false);
        this.func_175804_a(world, sbb, 3, 39, 1, 3, 39, 5, this.deco.fenceState, this.deco.fenceState, false);
        return true;
    }
    
    public EnumDyeColor getGlyphMeta() {
        return BlockTFCastleMagic.VALID_COLORS.get(1);
    }
}
