// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class TowerOutbuildingComponent extends TowerWingComponent
{
    public TowerOutbuildingComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(LichTowerPieces.TFLTOut, nbt);
    }
    
    protected TowerOutbuildingComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(LichTowerPieces.TFLTOut, feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void makeABeard(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
    }
    
    @Override
    public boolean makeTowerWing(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation direction) {
        return y > 7 && super.makeTowerWing(list, rand, index, x, y, z, wingSize, wingHeight, direction);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState cobblestone = Blocks.field_150347_e.func_176223_P();
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.func_175808_b(world, cobblestone, x, -1, z, sbb);
            }
        }
        return super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
    }
}
