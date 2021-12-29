// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class TowerBridgeComponent extends TowerWingComponent
{
    int dSize;
    int dHeight;
    
    public TowerBridgeComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(LichTowerPieces.TFLTBri, nbt);
    }
    
    protected TowerBridgeComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(LichTowerPieces.TFLTBri, feature, i, x, y, z, 3, 3, direction);
        this.dSize = pSize;
        this.dHeight = pHeight;
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        final int[] dest = { 2, 1, 1 };
        this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], this.dSize, this.dHeight, Rotation.NONE);
    }
    
    public MutableBoundingBox getWingBB() {
        final int[] dest = this.offsetTowerCoords(2, 1, 1, this.dSize, this.func_186165_e());
        return this.feature.getComponentToAddBoundingBox(dest[0], dest[1], dest[2], 0, 0, 0, this.dSize - 1, this.dHeight - 1, this.dSize - 1, this.func_186165_e());
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 0; x < 3; ++x) {
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x, 2, 0, sbb);
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x, 2, 2, sbb);
            this.func_175811_a(world, Blocks.field_196696_di.func_176223_P(), x, 1, 0, sbb);
            this.func_175811_a(world, Blocks.field_196696_di.func_176223_P(), x, 1, 2, sbb);
            this.func_175811_a(world, Blocks.field_196696_di.func_176223_P(), x, 0, 0, sbb);
            this.func_175811_a(world, Blocks.field_196696_di.func_176223_P(), x, 0, 1, sbb);
            this.func_175811_a(world, Blocks.field_196696_di.func_176223_P(), x, 0, 2, sbb);
            this.func_175811_a(world, Blocks.field_196696_di.func_176223_P(), x, -1, 1, sbb);
        }
        this.func_175811_a(world, Blocks.field_196696_di.func_176223_P(), -1, -1, 1, sbb);
        this.func_175811_a(world, Blocks.field_196696_di.func_176223_P(), 3, -1, 1, sbb);
        this.func_74878_a(world, sbb, 0, 1, 1, 2, 2, 1);
        return true;
    }
}
