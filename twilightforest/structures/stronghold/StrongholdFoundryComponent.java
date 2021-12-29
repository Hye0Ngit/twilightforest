// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.BlockState;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class StrongholdFoundryComponent extends StructureTFStrongholdComponent
{
    int entranceLevel;
    
    public StrongholdFoundryComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(StrongholdPieces.TFSFo, nbt);
        this.entranceLevel = nbt.func_74762_e("entranceLevel");
    }
    
    public StrongholdFoundryComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSFo, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("entranceLevel", this.entranceLevel);
    }
    
    @Override
    public MutableBoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        if (y > 17) {
            this.entranceLevel = 3;
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -20, 0, 18, 25, 18, facing);
        }
        if (y < 11) {
            this.entranceLevel = 1;
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -6, 0, 18, 25, 18, facing);
        }
        this.entranceLevel = 2;
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -13, 0, 18, 25, 18, facing);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(parent, list, random);
        switch (this.entranceLevel) {
            case 1: {
                this.addDoor(4, 6, 0);
                this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 13, 13);
                this.addNewComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 18, 13, 4);
                this.addNewComponent(parent, list, random, Rotation.NONE, 13, 20, 18);
                break;
            }
            case 2: {
                this.addDoor(4, 13, 0);
                this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 6, 13);
                this.addNewComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 18, 20, 4);
                this.addNewComponent(parent, list, random, Rotation.NONE, 13, 13, 18);
                break;
            }
            case 3: {
                this.addDoor(4, 20, 0);
                this.addNewComponent(parent, list, random, Rotation.NONE, 13, 6, 18);
                this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 13, 13);
                this.addNewComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 18, 13, 4);
                break;
            }
        }
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 25, 17, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 1, 0, 1, 16, 4, 16, Blocks.field_150353_l.func_176223_P(), Blocks.field_150353_l.func_176223_P(), false);
        this.func_74882_a(world, sbb, 1, 19, 1, 16, 19, 16, false, rand, this.deco.randomBlocks);
        this.func_74878_a(world, sbb, 2, 19, 2, 15, 19, 15);
        this.func_74882_a(world, sbb, 1, 12, 1, 16, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74878_a(world, sbb, 2, 12, 2, 15, 12, 15);
        this.func_74882_a(world, sbb, 1, 5, 1, 16, 5, 16, false, rand, this.deco.randomBlocks);
        this.func_74878_a(world, sbb, 2, 5, 2, 15, 5, 15);
        this.func_74882_a(world, sbb, 1, 1, 1, 1, 24, 2, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 2, 1, 1, 2, 24, 1, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 16, 1, 1, 16, 24, 2, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 15, 1, 1, 15, 24, 1, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 1, 1, 15, 1, 24, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 2, 1, 16, 2, 24, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 16, 1, 15, 16, 24, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 15, 1, 16, 15, 24, 16, false, rand, this.deco.randomBlocks);
        final Random massRandom = new Random(rand.nextLong());
        for (int x = 4; x < 14; ++x) {
            for (int z = 4; z < 14; ++z) {
                for (int y = 8; y < 23; ++y) {
                    final float c = Math.abs(x - 8.5f) + Math.abs(z - 8.5f) + Math.abs(y - 18.0f);
                    final float r = 5.5f + (massRandom.nextFloat() - massRandom.nextFloat()) * 3.5f;
                    if (c < r) {
                        this.func_175811_a(world, Blocks.field_150348_b.func_176223_P(), x, y, z, sbb);
                    }
                }
            }
        }
        for (int i = 0; i < 400; ++i) {
            final int dx = massRandom.nextInt(9) + 5;
            final int dz = massRandom.nextInt(9) + 5;
            final int dy = massRandom.nextInt(13) + 10;
            if (this.func_175807_a((IBlockReader)world, dx, dy, dz, sbb).func_177230_c() != Blocks.field_150350_a) {
                for (int y2 = 0; y2 < 3; ++y2) {
                    this.func_175811_a(world, Blocks.field_150348_b.func_176223_P(), dx, dy - y2, dz, sbb);
                }
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.addOreToMass(world, sbb, massRandom, Blocks.field_150450_ax.func_176223_P());
        }
        for (int i = 0; i < 8; ++i) {
            this.addOreToMass(world, sbb, massRandom, Blocks.field_150366_p.func_176223_P());
        }
        for (int i = 0; i < 6; ++i) {
            this.addOreToMass(world, sbb, massRandom, Blocks.field_150352_o.func_176223_P());
        }
        for (int i = 0; i < 2; ++i) {
            this.addOreToMass(world, sbb, massRandom, Blocks.field_150426_aN.func_176223_P());
        }
        for (int i = 0; i < 2; ++i) {
            this.addOreToMass(world, sbb, massRandom, Blocks.field_150412_bA.func_176223_P());
        }
        for (int i = 0; i < 4; ++i) {
            this.addOreToMass(world, sbb, massRandom, Blocks.field_150482_ag.func_176223_P());
        }
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void addOreToMass(final ISeedReader world, final MutableBoundingBox sbb, final Random massRandom, final BlockState state) {
        for (int i = 0; i < 10; ++i) {
            final int dx = massRandom.nextInt(9) + 5;
            final int dz = massRandom.nextInt(9) + 5;
            final int dy = massRandom.nextInt(13) + 10;
            if (this.func_175807_a((IBlockReader)world, dx, dy, dz, sbb).func_177230_c() != Blocks.field_150350_a) {
                this.func_175811_a(world, state, dx, dy, dz, sbb);
                break;
            }
        }
    }
}
