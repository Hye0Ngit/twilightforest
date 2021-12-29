// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.structures.TFStructureComponentOld;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Rotation;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class FinalCastleEntranceSideTowerComponent extends FinalCastleMazeTower13Component
{
    public FinalCastleEntranceSideTowerComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCEnSiTo, nbt);
    }
    
    public FinalCastleEntranceSideTowerComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final int floors, final int entranceFloor, final Direction direction) {
        super(FinalCastlePieces.TFFCEnSiTo, feature, rand, i, x, y, z, floors, entranceFloor, ((Block)TFBlocks.castle_rune_brick_pink.get()).func_176223_P(), direction);
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
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
    }
}
