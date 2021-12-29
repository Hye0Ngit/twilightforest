// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.BlockPos;
import java.util.List;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.block.Rotation;
import twilightforest.util.RotationUtil;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.biome.Biome;
import java.util.function.Predicate;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;

public class FinalCastleDungeonRoom31Component extends TowerWingComponent
{
    public int level;
    protected static final Predicate<Biome> plateauBiomes;
    
    public FinalCastleDungeonRoom31Component(final ServerLevel level, final CompoundTag nbt) {
        this(FinalCastlePieces.TFFCDunR31, nbt);
    }
    
    public FinalCastleDungeonRoom31Component(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
    }
    
    public FinalCastleDungeonRoom31Component(final StructurePieceType piece, final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction, final int level) {
        super(piece, feature, i, x, y, z);
        this.m_73519_(direction);
        this.spawnListIndex = 2;
        this.size = 31;
        this.height = 7;
        this.level = level;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -15, 0, -15, this.size - 1, this.height - 1, this.size - 1, Direction.SOUTH);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent instanceof final TFStructureComponentOld tfStructureComponentOld) {
            this.deco = tfStructureComponentOld.deco;
        }
        final int mySpread = this.m_73548_() - parent.m_73548_();
        final int maxSpread = (this.level == 1) ? 2 : 3;
        if (mySpread == maxSpread && !this.isExitBuildForLevel(parent)) {
            Rotation direction = RotationUtil.getRandomRotation(rand);
            for (int i = 0; i < 8 && !this.isExitBuildForLevel(parent); ++i) {
                direction = direction.m_55952_(RotationUtil.ROTATIONS[i & 0x3]);
                if (this.addDungeonExit(parent, list, rand, direction)) {
                    this.setExitBuiltForLevel(parent, true);
                }
            }
        }
        if (mySpread < maxSpread) {
            Rotation direction = RotationUtil.getRandomRotation(rand);
            for (int i = 0; i < 12; ++i) {
                direction = direction.m_55952_(RotationUtil.ROTATIONS[i & 0x3]);
                this.addDungeonRoom(parent, list, rand, direction, this.level);
            }
        }
    }
    
    private boolean isExitBuildForLevel(final StructurePiece parent) {
        return parent instanceof FinalCastleDungeonEntranceComponent && ((FinalCastleDungeonEntranceComponent)parent).hasExit;
    }
    
    private void setExitBuiltForLevel(final StructurePiece parent, final boolean exit) {
        if (parent instanceof final FinalCastleDungeonEntranceComponent finalCastleDungeonEntranceComponent) {
            finalCastleDungeonEntranceComponent.hasExit = exit;
        }
    }
    
    protected boolean addDungeonRoom(final StructurePiece parent, final StructurePieceAccessor list, final Random rand, Rotation rotation, final int level) {
        rotation = rotation.m_55952_(this.f_73379_);
        final BlockPos rc = this.getNewRoomCoords(rand, rotation);
        final FinalCastleDungeonRoom31Component dRoom = new FinalCastleDungeonRoom31Component(FinalCastlePieces.TFFCDunR31, this.getFeatureType(), rand, this.f_73384_ + 1, rc.m_123341_(), rc.m_123342_(), rc.m_123343_(), rotation.m_55954_(Direction.SOUTH), level);
        final BoundingBox largerBB = new BoundingBox(dRoom.m_73547_().m_162394_());
        final int expand = 0;
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            final StructurePiece intersect = TFStructureComponentOld.findIntersectingExcluding(start.m_73602_(), largerBB, this);
            if (intersect == null) {
                list.m_142679_((StructurePiece)dRoom);
                dRoom.m_142537_(parent, list, rand);
                return true;
            }
        }
        return false;
    }
    
    protected boolean addDungeonExit(final StructurePiece parent, final StructurePieceAccessor list, final Random rand, Rotation rotation) {
        rotation = rotation.m_55952_(this.f_73379_);
        final BlockPos rc = this.getNewRoomCoords(rand, rotation);
        final FinalCastleDungeonExitComponent dRoom = new FinalCastleDungeonExitComponent(this.getFeatureType(), rand, this.f_73384_ + 1, rc.m_123341_(), rc.m_123342_(), rc.m_123343_(), rotation.m_55954_(Direction.SOUTH), this.level);
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            final StructurePiece intersect = TFStructureComponentOld.findIntersectingExcluding(start.m_73602_(), dRoom.m_73547_(), this);
            if (intersect == null) {
                list.m_142679_((StructurePiece)dRoom);
                dRoom.m_142537_(this, list, rand);
                return true;
            }
        }
        return false;
    }
    
    private BlockPos getNewRoomCoords(final Random rand, final Rotation rotation) {
        int offset = rand.nextInt(15) - 9;
        if (rand.nextBoolean()) {
            offset += this.size;
        }
        return switch (rotation) {
            case CLOCKWISE_90 -> new BlockPos(this.f_73383_.m_162395_() + offset, this.f_73383_.m_162396_(), this.f_73383_.m_162401_() + 9);
            case CLOCKWISE_180 -> new BlockPos(this.f_73383_.m_162395_() - 9, this.f_73383_.m_162396_(), this.f_73383_.m_162398_() + offset);
            case COUNTERCLOCKWISE_90 -> new BlockPos(this.f_73383_.m_162395_() + offset, this.f_73383_.m_162396_(), this.f_73383_.m_162398_() - 9);
            default -> new BlockPos(this.f_73383_.m_162399_() + 9, this.f_73383_.m_162396_(), this.f_73383_.m_162398_() + offset);
        };
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (this.isBoundingBoxOutsideBiomes(world, FinalCastleDungeonRoom31Component.plateauBiomes)) {
            return false;
        }
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        this.fillWithAir(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, state -> state.m_60767_() == Material.f_76278_);
        final BlockState floor = ((Block)TFBlocks.CASTLE_BRICK.get()).m_49966_();
        final BlockState border = ((Block)TFBlocks.THICK_CASTLE_BRICK.get()).m_49966_();
        final Predicate<BlockState> replacing = state -> {
            final Material material = state.m_60767_();
            return material == Material.f_76278_ || material == Material.f_76296_;
        };
        final int cs = 7;
        this.fillWithBlocks(world, sbb, 7, -1, 7, this.size - 1 - 7, -1, this.size - 1 - 7, border, floor, replacing);
        this.fillWithBlocks(world, sbb, 7, this.height, 7, this.size - 1 - 7, this.height, this.size - 1 - 7, border, floor, replacing);
        final BlockState forceField = this.getForceFieldColor(decoRNG);
        final BlockState castleMagic = this.getRuneColor(forceField);
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 7, 0, 8, 7, this.height - 1, this.size - 2 - 7, forceField, rotation);
            for (int z = 7; z < this.size - 1 - 7; z += 4) {
                this.fillBlocksRotated(world, sbb, 7, 0, z, 7, this.height - 1, z, castleMagic, rotation);
                final int y = ((z - 7) % 8 == 0) ? decoRNG.nextInt(3) : (decoRNG.nextInt(3) + 4);
                this.fillBlocksRotated(world, sbb, 7, y, z + 1, 7, y, z + 3, castleMagic, rotation);
            }
        }
        return true;
    }
    
    protected BlockState getRuneColor(final BlockState forceFieldColor) {
        return (forceFieldColor == ((Block)TFBlocks.BLUE_FORCE_FIELD.get()).m_49966_()) ? ((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get()).m_49966_() : ((Block)TFBlocks.YELLOW_CASTLE_RUNE_BRICK.get()).m_49966_();
    }
    
    protected BlockState getForceFieldColor(final Random decoRNG) {
        final int i = decoRNG.nextInt(2) + 3;
        if (i == 3) {
            return ((Block)TFBlocks.GREEN_FORCE_FIELD.get()).m_49966_();
        }
        return ((Block)TFBlocks.BLUE_FORCE_FIELD.get()).m_49966_();
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BURY;
    }
    
    static {
        plateauBiomes = (biome -> true);
    }
}
