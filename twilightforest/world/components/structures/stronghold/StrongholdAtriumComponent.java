// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import twilightforest.world.registration.ConfiguredFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class StrongholdAtriumComponent extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    
    public StrongholdAtriumComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSAt, nbt);
        this.enterBottom = nbt.m_128471_("enterBottom");
    }
    
    public StrongholdAtriumComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSAt, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128379_("enterBottom", this.enterBottom);
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        if (y > -15) {
            this.enterBottom = false;
        }
        else if (y < -21) {
            this.enterBottom = true;
        }
        else {
            this.enterBottom = ((z & 0x1) == 0x0);
        }
        if (this.enterBottom) {
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 18, 14, 18, facing);
        }
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -8, 0, 18, 14, 18, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        if (this.enterBottom) {
            this.addDoor(4, 1, 0);
            this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 13, 8, -1);
        }
        else {
            this.addDoor(13, 8, 0);
            this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 4, 1, -1);
        }
        this.addNewComponent(parent, list, random, Rotation.NONE, 13, 1, 18);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 8, 18);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 13, 17, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 1, 6, 1, 16, 7, 16, false, rand, this.deco.randomBlocks);
        this.m_73441_(world, sbb, 5, 8, 5, 12, 8, 12, this.deco.fenceState, StrongholdAtriumComponent.AIR, false);
        this.m_73535_(world, sbb, 6, 6, 6, 11, 8, 11);
        this.placeBalconyPillar(world, sbb, Rotation.NONE);
        this.placeBalconyPillar(world, sbb, Rotation.CLOCKWISE_90);
        this.placeBalconyPillar(world, sbb, Rotation.CLOCKWISE_180);
        this.placeBalconyPillar(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.m_73464_(world, sbb, 1, 1, 1, 1, 12, 2, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 2, 1, 1, 2, 12, 1, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 16, 1, 1, 16, 12, 2, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 15, 1, 1, 15, 12, 1, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 1, 1, 15, 1, 12, 16, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 2, 1, 16, 2, 12, 16, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 16, 1, 15, 16, 12, 16, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 15, 1, 16, 15, 12, 16, false, rand, this.deco.randomBlocks);
        final BlockState grass = Blocks.f_50440_.m_49966_();
        this.m_73476_(world, sbb, rand, 0.5f, 6, 0, 6, 11, 0, 11, grass, grass, false, false);
        this.m_73441_(world, sbb, 7, 0, 7, 10, 0, 10, grass, StrongholdAtriumComponent.AIR, false);
        this.spawnATree(world, generator, rand.nextInt(5), 8, 1, 8, sbb);
        this.placeCornerStatue(world, 2, 8, 2, 0, sbb);
        this.placeCornerStatue(world, 2, 1, 15, 1, sbb);
        this.placeCornerStatue(world, 15, 1, 2, 2, sbb);
        this.placeCornerStatue(world, 15, 8, 15, 3, sbb);
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void spawnATree(final WorldGenLevel world, final ChunkGenerator generator, final int treeNum, final int x, final int y, final int z, final BoundingBox sbb) {
        final BlockPos pos = this.getBlockPosWithOffset(x, y, z);
        if (sbb.m_71051_((Vec3i)pos)) {
            ConfiguredFeature configuredFeature = switch (treeNum) {
                case 1 -> Features.f_126954_;
                case 2 -> Features.f_126950_;
                case 3 -> ConfiguredFeatures.TWILIGHT_OAK_BASE;
                case 4 -> ConfiguredFeatures.RAINBOW_OAK_TREE_BASE;
                default -> Features.f_126948_;
            };
            final ConfiguredFeature<?, ?> treeGen = (ConfiguredFeature<?, ?>)configuredFeature;
            for (int i = 0; i < 100; ++i) {
                if (treeGen.m_65385_(world, generator, world.m_5822_(), pos)) {
                    break;
                }
            }
        }
    }
    
    private void placeBalconyPillar(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation) {
        this.fillBlocksRotated(world, sbb, 5, 1, 5, 5, 12, 5, this.deco.pillarState, rotation);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), false), 5, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), false), 6, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), true), 5, 5, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), true), 6, 5, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), true), 5, 12, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), true), 6, 12, 5, rotation, sbb);
    }
}
