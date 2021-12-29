// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.TwilightForestMod;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import twilightforest.structures.StructureTFComponentOld;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.block.BlockTFCastleMagic;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFFinalCastleEntranceTower extends ComponentTFFinalCastleMazeTower13
{
    public ComponentTFFinalCastleEntranceTower() {
    }
    
    public ComponentTFFinalCastleEntranceTower(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final EnumFacing direction) {
        super(feature, rand, i, x, y, z, 3, 2, BlockTFCastleMagic.VALID_COLORS.get(0), direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        final ComponentTFFinalCastleFoundation13 foundation = new ComponentTFFinalCastleFoundation13(this.getFeatureType(), rand, 4, this);
        list.add(foundation);
        foundation.func_74861_a(this, list, rand);
        final StructureTFComponentOld roof = new ComponentTFFinalCastleRoof13Peaked(this.getFeatureType(), rand, 4, this);
        list.add(roof);
        roof.func_74861_a((StructureComponent)this, (List)list, rand);
        final int missingFloors = (this.field_74887_e.field_78895_b - 127) / 8;
        final int bottomFloors = missingFloors / 2;
        final int middleFloors = missingFloors - bottomFloors;
        EnumFacing facing = Rotation.CLOCKWISE_90.func_185831_a(this.func_186165_e());
        final int howFar = 20;
        if (!this.buildSideTower(list, rand, middleFloors + 1, facing, howFar)) {
            facing = Rotation.COUNTERCLOCKWISE_90.func_185831_a(this.func_186165_e());
            if (!this.buildSideTower(list, rand, middleFloors + 1, facing, howFar)) {
                facing = Rotation.NONE.func_185831_a(this.func_186165_e());
                if (!this.buildSideTower(list, rand, middleFloors + 1, facing, howFar)) {}
            }
        }
        final ComponentTFFinalCastleEntranceBottomTower eTower = new ComponentTFFinalCastleEntranceBottomTower(this.getFeatureType(), rand, this.func_74877_c() + 1, this.field_74887_e.field_78897_a + 6, this.field_74887_e.field_78895_b - middleFloors * 8, this.field_74887_e.field_78896_c + 6, bottomFloors + 1, bottomFloors, facing.func_176734_d());
        list.add(eTower);
        eTower.func_74861_a(this, list, rand);
        BlockPos opening = this.getValidOpeningCC(rand, facing);
        opening = opening.func_177979_c(middleFloors * 8);
        final BlockPos bc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), 1, facing);
        final ComponentTFFinalCastleBridge bridge = new ComponentTFFinalCastleBridge(this.getFeatureType(), this.func_74877_c() + 1, bc.func_177958_n(), bc.func_177956_o(), bc.func_177952_p(), howFar - 7, facing);
        list.add(bridge);
        bridge.func_74861_a(this, list, rand);
    }
    
    private boolean buildSideTower(final List<StructureComponent> list, final Random rand, final int middleFloors, final EnumFacing facing, final int howFar) {
        final BlockPos opening = this.getValidOpeningCC(rand, facing);
        final BlockPos tc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), howFar, facing);
        final ComponentTFFinalCastleEntranceSideTower eTower = new ComponentTFFinalCastleEntranceSideTower(this.getFeatureType(), rand, this.func_74877_c() + 1, tc.func_177958_n(), tc.func_177956_o(), tc.func_177952_p(), middleFloors, middleFloors - 1, facing);
        final StructureBoundingBox structureBoundingBox;
        final StructureBoundingBox largerBB = structureBoundingBox = new StructureBoundingBox(eTower.func_74874_b());
        structureBoundingBox.field_78897_a -= 6;
        final StructureBoundingBox structureBoundingBox2 = largerBB;
        structureBoundingBox2.field_78896_c -= 6;
        final StructureBoundingBox structureBoundingBox3 = largerBB;
        structureBoundingBox3.field_78893_d += 6;
        final StructureBoundingBox structureBoundingBox4 = largerBB;
        structureBoundingBox4.field_78892_f += 6;
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, largerBB);
        if (intersect == null) {
            list.add(eTower);
            eTower.func_74861_a(this, list, rand);
            final BlockPos bc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), 1, facing);
            final ComponentTFFinalCastleBridge bridge = new ComponentTFFinalCastleBridge(this.getFeatureType(), this.func_74877_c() + 1, bc.func_177958_n(), bc.func_177956_o(), bc.func_177952_p(), howFar - 7, facing);
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
            this.addOpening(opening.func_177958_n(), opening.func_177956_o() + 1, opening.func_177952_p(), facing);
            return true;
        }
        TwilightForestMod.LOGGER.info("side entrance tower blocked");
        return false;
    }
    
    @Override
    public BlockPos getValidOpeningCC(final Random rand, final EnumFacing facing) {
        final BlockPos opening = super.getValidOpeningCC(rand, facing);
        return new BlockPos(opening.func_177958_n(), 0, opening.func_177952_p());
    }
}
