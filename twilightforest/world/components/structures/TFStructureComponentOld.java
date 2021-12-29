// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.properties.Half;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.level.biome.Biome;
import twilightforest.util.BoundingBoxUtils;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.util.Mth;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import java.util.function.Predicate;
import java.util.Random;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TripWireHookBlock;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.ChestBlock;
import twilightforest.TwilightForestMod;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import java.util.function.Consumer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import javax.annotation.Nullable;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.world.level.block.state.BlockState;

@Deprecated
public abstract class TFStructureComponentOld extends TFStructureComponent
{
    protected static final BlockState AIR;
    private static final StrongholdStones strongholdStones;
    
    public TFStructureComponentOld(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
    }
    
    @Deprecated
    public TFStructureComponentOld(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z) {
        super(type, i, new BoundingBox(x, y, z, x, y, z));
        this.setFeature(feature);
    }
    
    public TFStructureComponentOld(final StructurePieceType type, final TFFeature feature, final int i, final BoundingBox box) {
        super(type, i, box);
        this.setFeature(feature);
    }
    
    public void m_73519_(@Nullable final Direction facing) {
        this.f_73377_ = facing;
        this.f_73378_ = Mirror.NONE;
        if (facing == null) {
            this.f_73379_ = Rotation.NONE;
        }
        else {
            switch (facing) {
                case SOUTH: {
                    this.f_73379_ = Rotation.CLOCKWISE_180;
                    break;
                }
                case WEST: {
                    this.f_73379_ = Rotation.COUNTERCLOCKWISE_90;
                    break;
                }
                case EAST: {
                    this.f_73379_ = Rotation.CLOCKWISE_90;
                    break;
                }
                default: {
                    this.f_73379_ = Rotation.NONE;
                    break;
                }
            }
        }
    }
    
    public static BoundingBox getComponentToAddBoundingBox2(final int x, final int y, final int z, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final Direction dir) {
        return switch (dir) {
            case WEST -> new BoundingBox(x - maxZ - minZ, y + minY, z + minX, x - minZ, y + maxY + minY, z + maxX + minX);
            case NORTH -> new BoundingBox(x - maxX - minX, y + minY, z - maxZ - minZ, x - minX, y + maxY + minY, z - minZ);
            case EAST -> new BoundingBox(x + minZ, y + minY, z - maxX, x + maxZ + minZ, y + maxY + minY, z - minX);
            default -> new BoundingBox(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
        };
    }
    
    protected void setSpawner(final WorldGenLevel world, final Vec3i pos, final BoundingBox sbb, final EntityType<?> monsterID) {
        this.setSpawner(world, pos.m_123341_(), pos.m_123342_(), pos.m_123343_(), sbb, monsterID, v -> {});
    }
    
    protected void setSpawner(final WorldGenLevel world, final int x, final int y, final int z, final BoundingBox sbb, final EntityType<?> monsterID) {
        this.setSpawner(world, x, y, z, sbb, monsterID, v -> {});
    }
    
    protected void setSpawner(final WorldGenLevel world, final int x, final int y, final int z, final BoundingBox sbb, final EntityType<?> monsterID, final Consumer<SpawnerBlockEntity> spawnerModifier) {
        final int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        final int dz = this.m_73525_(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.m_71051_((Vec3i)pos)) {
            if (world.m_8055_(pos).m_60734_() != Blocks.f_50085_) {
                world.m_7731_(pos, Blocks.f_50085_.m_49966_(), 2);
            }
            final BlockEntity 7702_;
            final BlockEntity tileEntitySpawner = 7702_ = world.m_7702_(pos);
            if (7702_ instanceof final SpawnerBlockEntity spawner) {
                spawner.m_59801_().m_45462_((EntityType)monsterID);
                spawnerModifier.accept(spawner);
            }
        }
    }
    
    protected void surroundBlockCardinal(final WorldGenLevel world, final BlockState block, final int x, final int y, final int z, final BoundingBox sbb) {
        this.m_73434_(world, block, x, y, z - 1, sbb);
        this.m_73434_(world, block, x, y, z + 1, sbb);
        this.m_73434_(world, block, x - 1, y, z, sbb);
        this.m_73434_(world, block, x + 1, y, z, sbb);
    }
    
    protected void surroundBlockCardinalRotated(final WorldGenLevel world, final BlockState block, final int x, final int y, final int z, final BoundingBox sbb) {
        this.m_73434_(world, (BlockState)block.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.NORTH), x, y, z - 1, sbb);
        this.m_73434_(world, (BlockState)block.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.SOUTH), x, y, z + 1, sbb);
        this.m_73434_(world, (BlockState)block.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.WEST), x - 1, y, z, sbb);
        this.m_73434_(world, (BlockState)block.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.EAST), x + 1, y, z, sbb);
    }
    
    protected void surroundBlockCorners(final WorldGenLevel world, final BlockState block, final int x, final int y, final int z, final BoundingBox sbb) {
        this.m_73434_(world, block, x - 1, y, z - 1, sbb);
        this.m_73434_(world, block, x - 1, y, z + 1, sbb);
        this.m_73434_(world, block, x + 1, y, z - 1, sbb);
        this.m_73434_(world, block, x + 1, y, z + 1, sbb);
    }
    
    protected void setSpawnerRotated(final WorldGenLevel world, final int x, final int y, final int z, final Rotation rotation, final EntityType<?> monsterID, final BoundingBox sbb) {
        final Direction oldBase = this.fakeBaseMode(rotation);
        this.setSpawner(world, x, y, z, sbb, monsterID);
        this.m_73519_(oldBase);
    }
    
    protected void placeTreasureAtCurrentPosition(final WorldGenLevel world, final int x, final int y, final int z, final TFTreasure treasureType, final BoundingBox sbb) {
        this.placeTreasureAtCurrentPosition(world, x, y, z, treasureType, false, sbb);
    }
    
    protected void placeTreasureAtCurrentPosition(final WorldGenLevel world, final int x, final int y, final int z, final TFTreasure treasureType, final boolean trapped, final BoundingBox sbb) {
        final int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        final int dz = this.m_73525_(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.m_71051_((Vec3i)pos) && world.m_8055_(pos).m_60734_() != (trapped ? Blocks.f_50325_ : Blocks.f_50087_)) {
            treasureType.generateChest(world, pos, this.m_73549_(), trapped);
        }
    }
    
    protected void placeTreasureRotated(final WorldGenLevel world, final int x, final int y, final int z, final Direction facing, final Rotation rotation, final TFTreasure treasureType, final BoundingBox sbb) {
        this.placeTreasureRotated(world, x, y, z, facing, rotation, treasureType, false, sbb);
    }
    
    protected void placeTreasureRotated(final WorldGenLevel world, final int x, final int y, final int z, Direction facing, final Rotation rotation, final TFTreasure treasureType, final boolean trapped, final BoundingBox sbb) {
        if (facing == null) {
            TwilightForestMod.LOGGER.error("Loot Chest at {}, {}, {} has null direction, setting it to north", (Object)x, (Object)y, (Object)z);
            facing = Direction.NORTH;
        }
        final int dx = this.getXWithOffsetRotated(x, z, rotation);
        final int dy = this.m_73544_(y);
        final int dz = this.getZWithOffsetRotated(x, z, rotation);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.m_71051_((Vec3i)pos) && world.m_8055_(pos).m_60734_() != (trapped ? Blocks.f_50325_ : Blocks.f_50087_)) {
            treasureType.generateChest(world, pos, facing, trapped);
        }
    }
    
    protected void manualTreaurePlacement(final WorldGenLevel world, final int x, final int y, final int z, final Direction facing, final TFTreasure treasureType, final boolean trapped, final BoundingBox sbb) {
        final int lootx = this.m_73392_(x, z);
        final int looty = this.m_73544_(y);
        final int lootz = this.m_73525_(x, z);
        final BlockPos lootPos = new BlockPos(lootx, looty, lootz);
        this.m_73434_(world, (BlockState)((BlockState)(trapped ? Blocks.f_50325_ : Blocks.f_50087_).m_49966_().m_61124_((Property)ChestBlock.f_51479_, (Comparable)ChestType.LEFT)).m_61124_((Property)ChestBlock.f_51478_, (Comparable)facing), x, y, z, sbb);
        treasureType.generateChestContents(world, lootPos);
    }
    
    protected void setDoubleLootChest(final WorldGenLevel world, final int x, final int y, final int z, final int otherx, final int othery, final int otherz, Direction facing, final TFTreasure treasureType, final BoundingBox sbb, final boolean trapped) {
        if (facing == null) {
            TwilightForestMod.LOGGER.error("Loot Chest at {}, {}, {} has null direction, setting it to north", (Object)x, (Object)y, (Object)z);
            facing = Direction.NORTH;
        }
        final int lootx = this.m_73392_(x, z);
        final int looty = this.m_73544_(y);
        final int lootz = this.m_73525_(x, z);
        final BlockPos lootPos = new BlockPos(lootx, looty, lootz);
        this.m_73434_(world, (BlockState)((BlockState)(trapped ? Blocks.f_50325_ : Blocks.f_50087_).m_49966_().m_61124_((Property)ChestBlock.f_51479_, (Comparable)ChestType.LEFT)).m_61124_((Property)ChestBlock.f_51478_, (Comparable)facing), x, y, z, sbb);
        this.m_73434_(world, (BlockState)((BlockState)(trapped ? Blocks.f_50325_ : Blocks.f_50087_).m_49966_().m_61124_((Property)ChestBlock.f_51479_, (Comparable)ChestType.RIGHT)).m_61124_((Property)ChestBlock.f_51478_, (Comparable)facing), otherx, othery, otherz, sbb);
        treasureType.generateChestContents(world, lootPos);
    }
    
    protected void placeTripwire(final WorldGenLevel world, final int x, final int y, final int z, final int size, final Direction facing, final BoundingBox sbb) {
        final int dx = facing.m_122429_();
        final int dz = facing.m_122431_();
        final BlockState tripwireHook = Blocks.f_50266_.m_49966_();
        this.m_73434_(world, (BlockState)tripwireHook.m_61124_((Property)TripWireHookBlock.f_57667_, (Comparable)facing.m_122424_()), x, y, z, sbb);
        this.m_73434_(world, (BlockState)tripwireHook.m_61124_((Property)TripWireHookBlock.f_57667_, (Comparable)facing), x + dx * size, y, z + dz * size, sbb);
        final BlockState tripwire = Blocks.f_50267_.m_49966_();
        for (int i = 1; i < size; ++i) {
            this.m_73434_(world, tripwire, x + dx * i, y, z + dz * i, sbb);
        }
    }
    
    protected void placeSignAtCurrentPosition(final WorldGenLevel world, final int x, final int y, final int z, final String string0, final String string1, final BoundingBox sbb) {
        final int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        final int dz = this.m_73525_(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.m_71051_((Vec3i)pos) && world.m_8055_(pos).m_60734_() != Blocks.f_50095_) {
            world.m_7731_(pos, (BlockState)Blocks.f_50095_.m_49966_().m_61124_((Property)StandingSignBlock.f_56987_, (Comparable)(this.m_73549_().m_122416_() * 4)), 2);
            final SignBlockEntity teSign = (SignBlockEntity)world.m_7702_(pos);
            if (teSign != null) {
                teSign.m_59732_(1, (Component)new TextComponent(string0));
                teSign.m_59732_(2, (Component)new TextComponent(string1));
            }
        }
    }
    
    protected int[] offsetTowerCoords(final int x, final int y, final int z, final int towerSize, final Direction direction) {
        final int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        final int dz = this.m_73525_(x, z);
        if (direction == Direction.SOUTH) {
            return new int[] { dx + 1, dy - 1, dz - towerSize / 2 };
        }
        if (direction == Direction.WEST) {
            return new int[] { dx + towerSize / 2, dy - 1, dz + 1 };
        }
        if (direction == Direction.NORTH) {
            return new int[] { dx - 1, dy - 1, dz + towerSize / 2 };
        }
        if (direction == Direction.EAST) {
            return new int[] { dx - towerSize / 2, dy - 1, dz - 1 };
        }
        return new int[] { x, y, z };
    }
    
    protected BlockPos offsetTowerCCoords(final int x, final int y, final int z, final int towerSize, final Direction direction) {
        final int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        final int dz = this.m_73525_(x, z);
        switch (direction) {
            case SOUTH: {
                return new BlockPos(dx + 1, dy - 1, dz - towerSize / 2);
            }
            case WEST: {
                return new BlockPos(dx + towerSize / 2, dy - 1, dz + 1);
            }
            case NORTH: {
                return new BlockPos(dx - 1, dy - 1, dz + towerSize / 2);
            }
            case EAST: {
                return new BlockPos(dx - towerSize / 2, dy - 1, dz - 1);
            }
            default: {
                return new BlockPos(x, y, z);
            }
        }
    }
    
    protected int m_73392_(final int x, final int z) {
        final Direction enumfacing = this.m_73549_();
        if (enumfacing == null) {
            return x;
        }
        return switch (enumfacing) {
            case SOUTH -> this.f_73383_.m_162395_() + x;
            case WEST -> this.f_73383_.m_162399_() - z;
            case NORTH -> this.f_73383_.m_162399_() - x;
            case EAST -> this.f_73383_.m_162395_() + z;
            default -> x;
        };
    }
    
    protected int m_73525_(final int x, final int z) {
        final Direction enumfacing = this.m_73549_();
        if (enumfacing == null) {
            return z;
        }
        return switch (enumfacing) {
            case SOUTH -> this.f_73383_.m_162398_() + z;
            case WEST -> this.f_73383_.m_162398_() + x;
            case NORTH -> this.f_73383_.m_162401_() - z;
            case EAST -> this.f_73383_.m_162401_() - x;
            default -> z;
        };
    }
    
    private Direction fakeBaseMode(final Rotation rotationsCW) {
        final Direction oldBaseMode = this.m_73549_();
        if (oldBaseMode != null) {
            Direction pretendBaseMode = oldBaseMode;
            pretendBaseMode = rotationsCW.m_55954_(pretendBaseMode);
            this.m_73519_(pretendBaseMode);
        }
        return oldBaseMode;
    }
    
    protected int getXWithOffsetRotated(final int x, final int z, final Rotation rotationsCW) {
        final Direction oldMode = this.fakeBaseMode(rotationsCW);
        final int ret = this.m_73392_(x, z);
        this.m_73519_(oldMode);
        return ret;
    }
    
    protected int getZWithOffsetRotated(final int x, final int z, final Rotation rotationsCW) {
        final Direction oldMode = this.fakeBaseMode(rotationsCW);
        final int ret = this.m_73525_(x, z);
        this.m_73519_(oldMode);
        return ret;
    }
    
    protected void setBlockStateRotated(final WorldGenLevel world, final BlockState state, final int x, final int y, final int z, final Rotation rotationsCW, final BoundingBox sbb) {
        final Direction oldMode = this.fakeBaseMode(rotationsCW);
        this.m_73434_(world, state, x, y, z, sbb);
        this.m_73519_(oldMode);
    }
    
    protected BlockState m_73398_(final BlockGetter world, final int x, final int y, final int z, final BoundingBox sbb) {
        return super.m_73398_(world, x, y, z, sbb);
    }
    
    @Override
    protected void m_73434_(final WorldGenLevel worldIn, final BlockState blockstateIn, final int x, final int y, final int z, final BoundingBox sbb) {
        super.m_73434_(worldIn, blockstateIn, x, y, z, sbb);
    }
    
    public BlockState getBlockStateFromPosRotated(final WorldGenLevel world, final int x, final int y, final int z, final BoundingBox sbb, final Rotation rotationsCW) {
        final Direction oldMode = this.fakeBaseMode(rotationsCW);
        final BlockState ret = this.m_73398_((BlockGetter)world, x, y, z, sbb);
        this.m_73519_(oldMode);
        return ret;
    }
    
    protected void fillBlocksRotated(final WorldGenLevel world, final BoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final BlockState state, final Rotation rotation) {
        final Direction oldBase = this.fakeBaseMode(rotation);
        this.m_73441_(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, state, state, false);
        this.m_73519_(oldBase);
    }
    
    protected void randomlyFillBlocksRotated(final WorldGenLevel worldIn, final BoundingBox boundingboxIn, final Random rand, final float chance, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final BlockState blockstate1, final BlockState blockstate2, final Rotation rotation) {
        final Direction oldBase = this.fakeBaseMode(rotation);
        final boolean minimumLightLevel = true;
        this.m_73476_(worldIn, boundingboxIn, rand, chance, minX, minY, minZ, maxX, maxY, maxZ, blockstate1, blockstate2, false, true);
        this.m_73519_(oldBase);
    }
    
    public void replaceAirAndLiquidDownwardsRotated(final WorldGenLevel world, final BlockState state, final int x, final int y, final int z, final Rotation rotation, final BoundingBox sbb) {
        final Direction oldBaseMode = this.fakeBaseMode(rotation);
        this.m_73528_(world, state, x, y, z, sbb);
        this.m_73519_(oldBaseMode);
    }
    
    protected void fillAirRotated(final WorldGenLevel world, final BoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final Rotation rotation) {
        final Direction oldBaseMode = this.fakeBaseMode(rotation);
        this.m_73535_(world, sbb, minX, minY, minZ, maxX, maxY, maxZ);
        this.m_73519_(oldBaseMode);
    }
    
    protected void fillWithAir(final WorldGenLevel world, final BoundingBox boundingBox, final int xMin, final int yMin, final int zMin, final int xMax, final int yMax, final int zMax, final Predicate<BlockState> predicate) {
        this.fillWithBlocks(world, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, Blocks.f_50016_.m_49966_(), predicate);
    }
    
    protected void fillWithBlocks(final WorldGenLevel world, final BoundingBox boundingBox, final int xMin, final int yMin, final int zMin, final int xMax, final int yMax, final int zMax, final BlockState state, final Predicate<BlockState> predicate) {
        this.fillWithBlocks(world, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, state, state, predicate);
    }
    
    protected void fillWithBlocks(final WorldGenLevel world, final BoundingBox boundingBox, final int xMin, final int yMin, final int zMin, final int xMax, final int yMax, final int zMax, final BlockState borderState, final BlockState interiorState, final Predicate<BlockState> predicate) {
        for (int y = yMin; y <= yMax; ++y) {
            for (int x = xMin; x <= xMax; ++x) {
                for (int z = zMin; z <= zMax; ++z) {
                    if (predicate.test(this.m_73398_((BlockGetter)world, x, y, z, boundingBox))) {
                        final boolean isBorder = (yMin != yMax && (y == yMin || y == yMax)) || (xMin != xMax && (x == xMin || x == xMax)) || (zMin != zMax && (z == zMin || z == zMax));
                        this.m_73434_(world, isBorder ? borderState : interiorState, x, y, z, boundingBox);
                    }
                }
            }
        }
    }
    
    protected static StructurePiece.BlockSelector getStrongholdStones() {
        return TFStructureComponentOld.strongholdStones;
    }
    
    protected Direction getStructureRelativeRotation(final Rotation rotationsCW) {
        return rotationsCW.m_55954_(this.m_73549_());
    }
    
    protected int getAverageGroundLevel(final WorldGenLevel world, final ChunkGenerator generator, final BoundingBox boundingBox) {
        int yTotal = 0;
        int count = 0;
        final int yStart = Mth.m_14045_(generator.m_6337_(), this.f_73383_.m_162396_(), this.f_73383_.m_162400_());
        for (int z = this.f_73383_.m_162398_(); z <= this.f_73383_.m_162401_(); ++z) {
            for (int x = this.f_73383_.m_162395_(); x <= this.f_73383_.m_162399_(); ++x) {
                final BlockPos pos = new BlockPos(x, yStart, z);
                if (boundingBox.m_71051_((Vec3i)pos)) {
                    final BlockPos topPos = world.m_5452_(Heightmap.Types.WORLD_SURFACE_WG, pos);
                    yTotal += Math.max(topPos.m_123342_(), generator.m_142051_((LevelHeightAccessor)world));
                    ++count;
                }
            }
        }
        if (count == 0) {
            return Integer.MIN_VALUE;
        }
        return yTotal / count;
    }
    
    protected int findGroundLevel(final WorldGenLevel world, final BoundingBox sbb, final int start, final Predicate<BlockState> predicate) {
        final Vec3i center = BoundingBoxUtils.getCenter(sbb);
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(center.m_123341_(), 0, center.m_123343_());
        for (int y = start; y > 0; --y) {
            pos.m_142448_(y);
            if (predicate.test(world.m_8055_((BlockPos)pos))) {
                return y;
            }
        }
        return 0;
    }
    
    protected boolean isBoundingBoxOutsideBiomes(final WorldGenLevel world, final Predicate<Biome> predicate) {
        final int minX = this.f_73383_.m_162395_() - 1;
        final int minZ = this.f_73383_.m_162398_() - 1;
        final int maxX = this.f_73383_.m_162399_() + 1;
        final int maxZ = this.f_73383_.m_162401_() + 1;
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int x = minX; x <= maxX; ++x) {
            for (int z = minZ; z <= maxZ; ++z) {
                if (!predicate.test(world.m_46857_((BlockPos)pos.m_122178_(x, 0, z)))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Nullable
    public static StructurePiece findIntersectingExcluding(final List<StructurePiece> list, final BoundingBox toCheck, final StructurePiece exclude) {
        for (final StructurePiece structurecomponent : list) {
            if (structurecomponent != exclude && structurecomponent.m_73547_() != null && structurecomponent.m_73547_().m_71049_(toCheck)) {
                return structurecomponent;
            }
        }
        return null;
    }
    
    public BlockPos getBlockPosWithOffset(final int x, final int y, final int z) {
        return new BlockPos(this.m_73392_(x, z), this.m_73544_(y), this.m_73525_(x, z));
    }
    
    protected static BlockState getStairState(final BlockState stairState, final Direction direction, final boolean isTopHalf) {
        return (BlockState)((BlockState)stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)direction)).m_61124_((Property)StairBlock.f_56842_, (Comparable)(isTopHalf ? Half.TOP : Half.BOTTOM));
    }
    
    protected static BlockState getSlabState(final BlockState inputBlockState, final SlabType half) {
        return (BlockState)inputBlockState.m_61124_((Property)SlabBlock.f_56353_, (Comparable)half);
    }
    
    static {
        AIR = Blocks.f_50016_.m_49966_();
        strongholdStones = new StrongholdStones();
    }
}
