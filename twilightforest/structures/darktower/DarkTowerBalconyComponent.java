// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.structures.TFStructureComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.lichtower.TowerWingComponent;

public class DarkTowerBalconyComponent extends TowerWingComponent
{
    public DarkTowerBalconyComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(DarkTowerPieces.TFDTBal, nbt);
    }
    
    protected DarkTowerBalconyComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction direction) {
        super(DarkTowerPieces.TFDTBal, feature, i, x, y, z, 5, 5, direction);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_175804_a(world, sbb, 0, 0, 0, 2, 0, 4, this.deco.accentState, Blocks.field_150350_a.func_176223_P(), false);
        this.func_175804_a(world, sbb, 0, 0, 1, 1, 0, 3, this.deco.blockState, Blocks.field_150350_a.func_176223_P(), false);
        this.func_175804_a(world, sbb, 0, 1, 0, 2, 1, 4, this.deco.fenceState, Blocks.field_150350_a.func_176223_P(), false);
        this.func_175811_a(world, this.deco.accentState, 2, 1, 0, sbb);
        this.func_175811_a(world, this.deco.accentState, 2, 1, 4, sbb);
        this.func_74878_a(world, sbb, 0, 1, 1, 1, 1, 3);
        return true;
    }
}
