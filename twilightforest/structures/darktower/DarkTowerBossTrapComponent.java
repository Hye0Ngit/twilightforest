// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import twilightforest.block.TFBlocks;
import twilightforest.block.GhastTrapBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.util.RotationUtil;
import net.minecraft.util.Rotation;
import twilightforest.structures.TFStructureComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DarkTowerBossTrapComponent extends DarkTowerWingComponent
{
    public DarkTowerBossTrapComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(DarkTowerPieces.TFDTBT, nbt);
    }
    
    protected DarkTowerBossTrapComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(DarkTowerPieces.TFDTBT, feature, i, x, y, z, pSize, pHeight, direction);
        this.spawnListIndex = -1;
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.makeABeard(parent, list, rand);
        for (final Rotation i : RotationUtil.ROTATIONS) {
            if (i != Rotation.CLOCKWISE_180) {
                if (!rand.nextBoolean()) {
                    final int[] dest = this.getValidOpening(rand, i);
                    dest[1] = 1;
                    this.makeTowerBalcony(list, rand, this.func_74877_c(), dest[0], dest[1], dest[2], i);
                }
            }
        }
    }
    
    @Override
    public void makeARoof(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.makeOpenings(world, sbb);
        this.addBossTrapFloors(world, sbb);
        this.destroyTower(world, decoRNG, 5, this.height + 2, 5, 4, sbb);
        this.destroyTower(world, decoRNG, 0, this.height, 0, 3, sbb);
        this.destroyTower(world, decoRNG, 0, this.height, 8, 4, sbb);
        this.destroyTower(world, decoRNG, 5, 6, 5, 2, sbb);
        this.func_175804_a(world, sbb, 1, 0, 1, this.size / 2, 0, this.size - 2, this.deco.blockState, Blocks.field_150350_a.func_176223_P(), false);
        this.func_175804_a(world, sbb, 1, 1, 1, this.size / 2, 1, this.size - 2, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
        this.func_175811_a(world, ((GhastTrapBlock)TFBlocks.ghast_trap.get()).func_176223_P(), 5, 1, 5, sbb);
        this.func_175811_a(world, Blocks.field_150488_af.func_176223_P(), 5, 1, 6, sbb);
        this.func_175811_a(world, Blocks.field_150488_af.func_176223_P(), 5, 1, 7, sbb);
        this.func_175811_a(world, Blocks.field_150488_af.func_176223_P(), 5, 1, 8, sbb);
        this.func_175811_a(world, Blocks.field_150488_af.func_176223_P(), 4, 1, 8, sbb);
        this.func_175811_a(world, Blocks.field_150488_af.func_176223_P(), 3, 1, 8, sbb);
        this.func_175811_a(world, Blocks.field_196663_cq.func_176223_P(), 2, 1, 8, sbb);
        return true;
    }
    
    protected void addBossTrapFloors(final ISeedReader world, final MutableBoundingBox sbb) {
        this.makeFullFloor(world, sbb, 4);
        this.addStairsDown(world, sbb, Rotation.COUNTERCLOCKWISE_90, 4, this.size - 2, 4);
        this.addStairsDown(world, sbb, Rotation.COUNTERCLOCKWISE_90, 4, this.size - 3, 4);
        this.addStairsDown(world, sbb, Rotation.CLOCKWISE_90, this.height - 1, this.size - 2, 4);
        this.addStairsDown(world, sbb, Rotation.CLOCKWISE_90, this.height - 1, this.size - 3, 4);
    }
}
