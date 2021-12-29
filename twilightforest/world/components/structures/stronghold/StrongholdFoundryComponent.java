// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class StrongholdFoundryComponent extends StructureTFStrongholdComponent
{
    int entranceLevel;
    boolean deepslateVer;
    
    public StrongholdFoundryComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSFo, nbt);
        this.deepslateVer = nbt.m_128471_("deepslateVer");
        this.entranceLevel = nbt.m_128451_("entranceLevel");
    }
    
    public StrongholdFoundryComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSFo, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("entranceLevel", this.entranceLevel);
        tagCompound.m_128379_("deepslateVer", this.deepslateVer);
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        this.deepslateVer = new Random().nextBoolean();
        if (y > -15) {
            this.entranceLevel = 3;
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -20, 0, 18, 25, 18, facing);
        }
        if (y < -21) {
            this.entranceLevel = 1;
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -6, 0, 18, 25, 18, facing);
        }
        this.entranceLevel = 2;
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -13, 0, 18, 25, 18, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
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
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 25, 17, rand, this.deco.randomBlocks);
        this.m_73441_(world, sbb, 1, 0, 1, 16, 4, 16, Blocks.f_49991_.m_49966_(), Blocks.f_49991_.m_49966_(), false);
        this.m_73464_(world, sbb, 1, 19, 1, 16, 19, 16, false, rand, this.deco.randomBlocks);
        this.m_73535_(world, sbb, 2, 19, 2, 15, 19, 15);
        this.m_73464_(world, sbb, 1, 12, 1, 16, 12, 16, false, rand, this.deco.randomBlocks);
        this.m_73535_(world, sbb, 2, 12, 2, 15, 12, 15);
        this.m_73464_(world, sbb, 1, 5, 1, 16, 5, 16, false, rand, this.deco.randomBlocks);
        this.m_73535_(world, sbb, 2, 5, 2, 15, 5, 15);
        this.m_73464_(world, sbb, 1, 1, 1, 1, 24, 2, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 2, 1, 1, 2, 24, 1, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 16, 1, 1, 16, 24, 2, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 15, 1, 1, 15, 24, 1, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 1, 1, 15, 1, 24, 16, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 2, 1, 16, 2, 24, 16, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 16, 1, 15, 16, 24, 16, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 15, 1, 16, 15, 24, 16, false, rand, this.deco.randomBlocks);
        final Random massRandom = new Random(rand.nextLong());
        for (int x = 4; x < 14; ++x) {
            for (int z = 4; z < 14; ++z) {
                for (int y = 8; y < 23; ++y) {
                    final float c = Math.abs(x - 8.5f) + Math.abs(z - 8.5f) + Math.abs(y - 18.0f);
                    final float r = 5.5f + (massRandom.nextFloat() - massRandom.nextFloat()) * 3.5f;
                    if (c < r) {
                        this.m_73434_(world, this.deepslateVer ? Blocks.f_152550_.m_49966_() : Blocks.f_50069_.m_49966_(), x, y, z, sbb);
                    }
                }
            }
        }
        for (int i = 0; i < 400; ++i) {
            final int dx = massRandom.nextInt(9) + 5;
            final int dz = massRandom.nextInt(9) + 5;
            final int dy = massRandom.nextInt(13) + 10;
            if (this.m_73398_((BlockGetter)world, dx, dy, dz, sbb).m_60734_() != Blocks.f_50016_) {
                for (int y2 = 0; y2 < 3; ++y2) {
                    this.m_73434_(world, this.deepslateVer ? Blocks.f_152550_.m_49966_() : Blocks.f_50069_.m_49966_(), dx, dy - y2, dz, sbb);
                }
            }
        }
        for (int i = 0; i < 8; ++i) {
            this.addOreToMass(world, sbb, massRandom, this.deepslateVer ? Blocks.f_152473_.m_49966_() : Blocks.f_50173_.m_49966_());
        }
        for (int i = 0; i < 8; ++i) {
            this.addOreToMass(world, sbb, massRandom, this.deepslateVer ? Blocks.f_152468_.m_49966_() : Blocks.f_49996_.m_49966_());
        }
        for (int i = 0; i < 6; ++i) {
            this.addOreToMass(world, sbb, massRandom, this.deepslateVer ? Blocks.f_152467_.m_49966_() : Blocks.f_49995_.m_49966_());
        }
        for (int i = 0; i < 2; ++i) {
            this.addOreToMass(world, sbb, massRandom, this.deepslateVer ? Blocks.f_50701_.m_49966_() : Blocks.f_50141_.m_49966_());
        }
        for (int i = 0; i < 2; ++i) {
            this.addOreToMass(world, sbb, massRandom, this.deepslateVer ? Blocks.f_152479_.m_49966_() : Blocks.f_50264_.m_49966_());
        }
        for (int i = 0; i < 4; ++i) {
            this.addOreToMass(world, sbb, massRandom, this.deepslateVer ? Blocks.f_152474_.m_49966_() : Blocks.f_50089_.m_49966_());
        }
        for (int i = 0; i < 6; ++i) {
            this.addOreToMass(world, sbb, massRandom, this.deepslateVer ? Blocks.f_152506_.m_49966_() : Blocks.f_152505_.m_49966_());
        }
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void addOreToMass(final WorldGenLevel world, final BoundingBox sbb, final Random massRandom, final BlockState state) {
        for (int i = 0; i < 10; ++i) {
            final int dx = massRandom.nextInt(9) + 5;
            final int dz = massRandom.nextInt(9) + 5;
            final int dy = massRandom.nextInt(13) + 10;
            if (this.m_73398_((BlockGetter)world, dx, dy, dz, sbb).m_60734_() != Blocks.f_50016_) {
                this.m_73434_(world, state, dx, dy, dz, sbb);
                break;
            }
        }
    }
}
