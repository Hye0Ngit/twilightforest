// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

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

public class DarkTowerEntranceComponent extends DarkTowerWingComponent
{
    public DarkTowerEntranceComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(DarkTowerPieces.TFDTEnt, nbt);
    }
    
    protected DarkTowerEntranceComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(DarkTowerPieces.TFDTEnt, feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        super.func_74861_a(parent, list, rand);
        this.addOpening(this.size / 2, 1, 0, Rotation.CLOCKWISE_90, EnumDarkTowerDoor.REAPPEARING);
        this.addOpening(this.size / 2, 1, this.size - 1, Rotation.COUNTERCLOCKWISE_90, EnumDarkTowerDoor.REAPPEARING);
    }
    
    @Override
    public void makeABeard(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
    }
    
    @Override
    public void makeARoof(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.func_175811_a(world, this.deco.accentState, x, -1, z, sbb);
            }
        }
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.makeOpenings(world, sbb);
        return true;
    }
}
