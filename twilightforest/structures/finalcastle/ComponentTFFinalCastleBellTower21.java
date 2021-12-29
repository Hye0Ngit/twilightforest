// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.state.IBlockState;
import twilightforest.util.RotationUtil;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFForceField;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.Rotation;
import twilightforest.structures.StructureTFComponentOld;
import twilightforest.block.BlockTFCastleMagic;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFFinalCastleBellTower21 extends ComponentTFFinalCastleMazeTower13
{
    private static final int FLOORS = 8;
    
    public ComponentTFFinalCastleBellTower21() {
    }
    
    public ComponentTFFinalCastleBellTower21(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final EnumFacing direction) {
        super(feature, rand, i, x, y, z, 8, 1, BlockTFCastleMagic.VALID_COLORS.get(1), direction);
        this.size = 21;
        final int floors = 8;
        this.height = floors * 8 + 1;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox2(x, y, z, -6, -8, -this.size / 2, this.size - 1, this.height, this.size - 1, direction);
        this.openings.clear();
        this.addOpening(0, 9, this.size / 2, Rotation.CLOCKWISE_180);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        final ComponentTFFinalCastleBellFoundation21 foundation = new ComponentTFFinalCastleBellFoundation21(this.getFeatureType(), rand, 4, this);
        list.add(foundation);
        foundation.func_74861_a(this, list, rand);
        final StructureTFComponentOld roof = new ComponentTFFinalCastleRoof13Crenellated(this.getFeatureType(), rand, 4, this);
        list.add(roof);
        roof.func_74861_a((StructureComponent)this, (List)list, rand);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        final IBlockState fieldBlock = TFBlocks.force_field.func_176223_P().func_177226_a((IProperty)BlockTFForceField.COLOR, (Comparable)BlockTFForceField.VALID_COLORS.get(4));
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            int y = 48;
            for (int x = 5; x < this.size - 4; x += 2) {
                this.fillBlocksRotated(world, sbb, x, y, 0, x, y + 14, 0, fieldBlock, rotation);
            }
            y = 24;
            for (int x = 1; x < this.size - 1; x += 8) {
                this.fillBlocksRotated(world, sbb, x, y, 0, x, y + 14, 0, fieldBlock, rotation);
                this.fillBlocksRotated(world, sbb, x + 2, y, 0, x + 2, y + 14, 0, fieldBlock, rotation);
            }
        }
        this.placeSignAtCurrentPosition(world, 7, 9, 8, "Parkour area 2", "mini-boss 1", sbb);
        return true;
    }
}
