// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.TwilightForestMod;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import twilightforest.structures.TFStructureComponentOld;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class FinalCastleEntranceTowerComponent extends FinalCastleMazeTower13Component
{
    public FinalCastleEntranceTowerComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCEnTo, nbt);
    }
    
    public FinalCastleEntranceTowerComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction) {
        super(FinalCastlePieces.TFFCEnTo, feature, rand, i, x, y, z, 3, 2, ((Block)TFBlocks.castle_rune_brick_pink.get()).func_176223_P(), direction);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final FinalCastleFoundation13Component foundation = new FinalCastleFoundation13Component(FinalCastlePieces.TFFCToF13, this.getFeatureType(), rand, 4, this);
        list.add(foundation);
        foundation.func_74861_a(this, list, rand);
        final TFStructureComponentOld roof = new FinalCastleRoof13PeakedComponent(this.getFeatureType(), rand, 4, this);
        list.add(roof);
        roof.func_74861_a((StructurePiece)this, (List)list, rand);
        final int missingFloors = (this.field_74887_e.field_78895_b - 127) / 8;
        final int bottomFloors = missingFloors / 2;
        final int middleFloors = missingFloors - bottomFloors;
        Direction facing = Rotation.CLOCKWISE_90.func_185831_a(this.func_186165_e());
        final int howFar = 20;
        if (!this.buildSideTower(list, rand, middleFloors + 1, facing, howFar)) {
            facing = Rotation.COUNTERCLOCKWISE_90.func_185831_a(this.func_186165_e());
            if (!this.buildSideTower(list, rand, middleFloors + 1, facing, howFar)) {
                facing = Rotation.NONE.func_185831_a(this.func_186165_e());
                if (!this.buildSideTower(list, rand, middleFloors + 1, facing, howFar)) {}
            }
        }
        final FinalCastleEntranceBottomTowerComponent eTower = new FinalCastleEntranceBottomTowerComponent(this.getFeatureType(), rand, this.func_74877_c() + 1, this.field_74887_e.field_78897_a + 6, this.field_74887_e.field_78895_b - middleFloors * 8, this.field_74887_e.field_78896_c + 6, bottomFloors + 1, bottomFloors, facing.func_176734_d());
        list.add(eTower);
        eTower.func_74861_a(this, list, rand);
        BlockPos opening = this.getValidOpeningCC(rand, facing);
        opening = opening.func_177979_c(middleFloors * 8);
        final BlockPos bc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), 1, facing);
        final FinalCastleBridgeComponent bridge = new FinalCastleBridgeComponent(this.getFeatureType(), this.func_74877_c() + 1, bc.func_177958_n(), bc.func_177956_o(), bc.func_177952_p(), howFar - 7, facing);
        list.add(bridge);
        bridge.func_74861_a(this, list, rand);
    }
    
    private boolean buildSideTower(final List<StructurePiece> list, final Random rand, final int middleFloors, final Direction facing, final int howFar) {
        final BlockPos opening = this.getValidOpeningCC(rand, facing);
        final BlockPos tc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), howFar, facing);
        final FinalCastleEntranceSideTowerComponent eTower = new FinalCastleEntranceSideTowerComponent(this.getFeatureType(), rand, this.func_74877_c() + 1, tc.func_177958_n(), tc.func_177956_o(), tc.func_177952_p(), middleFloors, middleFloors - 1, facing);
        final MutableBoundingBox mutableBoundingBox;
        final MutableBoundingBox largerBB = mutableBoundingBox = new MutableBoundingBox(eTower.func_74874_b());
        mutableBoundingBox.field_78897_a -= 6;
        final MutableBoundingBox mutableBoundingBox2 = largerBB;
        mutableBoundingBox2.field_78896_c -= 6;
        final MutableBoundingBox mutableBoundingBox3 = largerBB;
        mutableBoundingBox3.field_78893_d += 6;
        final MutableBoundingBox mutableBoundingBox4 = largerBB;
        mutableBoundingBox4.field_78892_f += 6;
        final StructurePiece intersect = StructurePiece.func_74883_a((List)list, largerBB);
        if (intersect == null) {
            list.add(eTower);
            eTower.func_74861_a(this, list, rand);
            final BlockPos bc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), 1, facing);
            final FinalCastleBridgeComponent bridge = new FinalCastleBridgeComponent(this.getFeatureType(), this.func_74877_c() + 1, bc.func_177958_n(), bc.func_177956_o(), bc.func_177952_p(), howFar - 7, facing);
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
            this.addOpening(opening.func_177958_n(), opening.func_177956_o() + 1, opening.func_177952_p(), facing);
            return true;
        }
        TwilightForestMod.LOGGER.info("side entrance tower blocked");
        return false;
    }
    
    @Override
    public BlockPos getValidOpeningCC(final Random rand, final Direction facing) {
        final BlockPos opening = super.getValidOpeningCC(rand, facing);
        return new BlockPos(opening.func_177958_n(), 0, opening.func_177952_p());
    }
}
