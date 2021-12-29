// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import java.util.Iterator;
import net.minecraft.util.math.BlockPos;
import java.util.ArrayList;
import net.minecraft.world.ISeedReader;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import twilightforest.structures.TFStructureComponentOld;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class FinalCastleWreckedTowerComponent extends FinalCastleDamagedTowerComponent
{
    public FinalCastleWreckedTowerComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCWrT, nbt);
    }
    
    public FinalCastleWreckedTowerComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction) {
        super(FinalCastlePieces.TFFCWrT, feature, rand, i, x, y, z, direction);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final FinalCastleFoundation13Component thorns = new FinalCastleFoundation13ComponentThorns(this.getFeatureType(), rand, 0, this);
        list.add(thorns);
        thorns.func_74861_a(this, list, rand);
    }
    
    @Override
    public BlockState getGlyphColour() {
        return ((Block)TFBlocks.castle_rune_brick_blue.get()).func_176223_P();
    }
    
    @Override
    protected void determineBlockDestroyed(final ISeedReader world, final ArrayList<DestroyArea> areas, final int y, final int x, final int z) {
        boolean isInside = false;
        final BlockPos pos = new BlockPos(x, y, z);
        for (final DestroyArea dArea : areas) {
            if (dArea != null && dArea.isVecInside(pos)) {
                isInside = true;
            }
        }
        if (!isInside) {
            world.func_217377_a(pos, false);
        }
    }
    
    @Override
    protected ArrayList<DestroyArea> makeInitialDestroyList(final Random rand) {
        final ArrayList<DestroyArea> areas = new ArrayList<DestroyArea>(2);
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        return areas;
    }
}
