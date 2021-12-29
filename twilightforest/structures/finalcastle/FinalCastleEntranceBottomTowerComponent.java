// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

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

public class FinalCastleEntranceBottomTowerComponent extends FinalCastleMazeTower13Component
{
    public FinalCastleEntranceBottomTowerComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCEnBoTo, nbt);
    }
    
    public FinalCastleEntranceBottomTowerComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final int floors, final int entranceFloor, final Direction direction) {
        super(FinalCastlePieces.TFFCEnBoTo, feature, rand, i, x, y, z, floors, entranceFloor, ((Block)TFBlocks.castle_rune_brick_pink.get()).func_176223_P(), direction);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size - 1, 1, this.size / 2, Rotation.NONE);
        this.addStairs(list, rand, this.func_74877_c() + 1, 0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, 0, Rotation.COUNTERCLOCKWISE_90);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, this.size - 1, Rotation.CLOCKWISE_90);
    }
    
    private boolean addStairs(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        this.addOpening(x, y, z, rotation);
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dx = this.offsetTowerCCoords(x, y, z, 0, direction);
        final FinalCastleEntranceStairsComponent stairs = new FinalCastleEntranceStairsComponent(this.getFeatureType(), index, dx.func_177958_n(), dx.func_177956_o(), dx.func_177952_p(), direction);
        list.add(stairs);
        stairs.func_74861_a(list.get(0), list, rand);
        return true;
    }
    
    @Override
    protected boolean hasAccessibleRoof() {
        return false;
    }
}
