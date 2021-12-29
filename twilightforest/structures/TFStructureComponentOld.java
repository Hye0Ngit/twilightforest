// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.SlabBlock;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.properties.Half;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.biome.Biome;
import twilightforest.util.StructureBoundingBoxUtils;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import java.util.function.Predicate;
import java.util.Random;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.TripWireHookBlock;
import net.minecraft.state.properties.ChestType;
import net.minecraft.block.ChestBlock;
import twilightforest.TwilightForestMod;
import net.minecraft.world.IWorld;
import twilightforest.loot.TFTreasure;
import net.minecraft.state.Property;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import javax.annotation.Nullable;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.block.BlockState;

@Deprecated
public abstract class TFStructureComponentOld extends TFStructureComponent
{
    protected static final BlockState AIR;
    private static final StrongholdStones strongholdStones;
    
    public TFStructureComponentOld(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
    }
    
    public TFStructureComponentOld(final IStructurePieceType type, final TFFeature feature, final int i) {
        super(type, i);
        this.feature = feature;
    }
    
    @Override
    public TFFeature getFeatureType() {
        return this.feature;
    }
    
    public void func_186164_a(@Nullable final Direction facing) {
        this.field_74885_f = facing;
        this.field_186168_b = Mirror.NONE;
        if (facing == null) {
            this.field_186169_c = Rotation.NONE;
        }
        else {
            switch (facing) {
                case SOUTH: {
                    this.field_186169_c = Rotation.CLOCKWISE_180;
                    break;
                }
                case WEST: {
                    this.field_186169_c = Rotation.COUNTERCLOCKWISE_90;
                    break;
                }
                case EAST: {
                    this.field_186169_c = Rotation.CLOCKWISE_90;
                    break;
                }
                default: {
                    this.field_186169_c = Rotation.NONE;
                    break;
                }
            }
        }
    }
    
    public static MutableBoundingBox getComponentToAddBoundingBox2(final int x, final int y, final int z, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final Direction dir) {
        switch (dir) {
            default: {
                return new MutableBoundingBox(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case WEST: {
                return new MutableBoundingBox(x - maxZ - minZ, y + minY, z + minX, x - minZ, y + maxY + minY, z + maxX + minX);
            }
            case NORTH: {
                return new MutableBoundingBox(x - maxX - minX, y + minY, z - maxZ - minZ, x - minX, y + maxY + minY, z - minZ);
            }
            case EAST: {
                return new MutableBoundingBox(x + minZ, y + minY, z - maxX, x + maxZ + minZ, y + maxY + minY, z - minX);
            }
        }
    }
    
    protected MobSpawnerTileEntity setSpawner(final ISeedReader world, final int x, final int y, final int z, final MutableBoundingBox sbb, final EntityType<?> monsterID) {
        MobSpawnerTileEntity tileEntitySpawner = null;
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vector3i)pos) && world.func_180495_p(pos).func_177230_c() != Blocks.field_150474_ac) {
            world.func_180501_a(pos, Blocks.field_150474_ac.func_176223_P(), 2);
            tileEntitySpawner = (MobSpawnerTileEntity)world.func_175625_s(pos);
            if (tileEntitySpawner != null) {
                tileEntitySpawner.func_145881_a().func_200876_a((EntityType)monsterID);
            }
        }
        return tileEntitySpawner;
    }
    
    protected void surroundBlockCardinal(final ISeedReader world, final BlockState block, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        this.func_175811_a(world, block, x, y, z - 1, sbb);
        this.func_175811_a(world, block, x, y, z + 1, sbb);
        this.func_175811_a(world, block, x - 1, y, z, sbb);
        this.func_175811_a(world, block, x + 1, y, z, sbb);
    }
    
    protected void surroundBlockCardinalRotated(final ISeedReader world, final BlockState block, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        this.func_175811_a(world, (BlockState)block.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.NORTH), x, y, z - 1, sbb);
        this.func_175811_a(world, (BlockState)block.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.SOUTH), x, y, z + 1, sbb);
        this.func_175811_a(world, (BlockState)block.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.WEST), x - 1, y, z, sbb);
        this.func_175811_a(world, (BlockState)block.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.EAST), x + 1, y, z, sbb);
    }
    
    protected void surroundBlockCorners(final ISeedReader world, final BlockState block, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        this.func_175811_a(world, block, x - 1, y, z - 1, sbb);
        this.func_175811_a(world, block, x - 1, y, z + 1, sbb);
        this.func_175811_a(world, block, x + 1, y, z - 1, sbb);
        this.func_175811_a(world, block, x + 1, y, z + 1, sbb);
    }
    
    protected MobSpawnerTileEntity setSpawnerRotated(final ISeedReader world, final int x, final int y, final int z, final Rotation rotation, final EntityType<?> monsterID, final MutableBoundingBox sbb) {
        final Direction oldBase = this.fakeBaseMode(rotation);
        final MobSpawnerTileEntity ret = this.setSpawner(world, x, y, z, sbb, monsterID);
        this.func_186164_a(oldBase);
        return ret;
    }
    
    protected void placeTreasureAtCurrentPosition(final ISeedReader world, final int x, final int y, final int z, final TFTreasure treasureType, final MutableBoundingBox sbb) {
        this.placeTreasureAtCurrentPosition(world, x, y, z, treasureType, false, sbb);
    }
    
    protected void placeTreasureAtCurrentPosition(final ISeedReader world, final int x, final int y, final int z, final TFTreasure treasureType, final boolean trapped, final MutableBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vector3i)pos) && world.func_180495_p(pos).func_177230_c() != (trapped ? Blocks.field_150447_bR : Blocks.field_150486_ae)) {
            treasureType.generateChest((IWorld)world, pos, this.func_186165_e(), trapped);
        }
    }
    
    protected void placeTreasureRotated(final ISeedReader world, final int x, final int y, final int z, final Direction facing, final Rotation rotation, final TFTreasure treasureType, final MutableBoundingBox sbb) {
        this.placeTreasureRotated(world, x, y, z, facing, rotation, treasureType, false, sbb);
    }
    
    protected void placeTreasureRotated(final ISeedReader world, final int x, final int y, final int z, Direction facing, final Rotation rotation, final TFTreasure treasureType, final boolean trapped, final MutableBoundingBox sbb) {
        if (facing == null) {
            TwilightForestMod.LOGGER.error("Loot Chest at {}, {}, {} has null direction, setting it to north", (Object)x, (Object)y, (Object)z);
            facing = Direction.NORTH;
        }
        final int dx = this.getXWithOffsetRotated(x, z, rotation);
        final int dy = this.func_74862_a(y);
        final int dz = this.getZWithOffsetRotated(x, z, rotation);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vector3i)pos) && world.func_180495_p(pos).func_177230_c() != (trapped ? Blocks.field_150447_bR : Blocks.field_150486_ae)) {
            treasureType.generateChest((IWorld)world, pos, facing, trapped);
        }
    }
    
    protected void manualTreaurePlacement(final ISeedReader world, final int x, final int y, final int z, final Direction facing, final TFTreasure treasureType, final boolean trapped, final MutableBoundingBox sbb) {
        final int lootx = this.func_74865_a(x, z);
        final int looty = this.func_74862_a(y);
        final int lootz = this.func_74873_b(x, z);
        final BlockPos lootPos = new BlockPos(lootx, looty, lootz);
        this.func_175811_a(world, (BlockState)((BlockState)(trapped ? Blocks.field_150447_bR : Blocks.field_150486_ae).func_176223_P().func_206870_a((Property)ChestBlock.field_196314_b, (Comparable)ChestType.LEFT)).func_206870_a((Property)ChestBlock.field_176459_a, (Comparable)facing), x, y, z, sbb);
        treasureType.generateChestContents(world, lootPos);
    }
    
    protected void setDoubleLootChest(final ISeedReader world, final int x, final int y, final int z, final int otherx, final int othery, final int otherz, Direction facing, final TFTreasure treasureType, final MutableBoundingBox sbb, final boolean trapped) {
        if (facing == null) {
            TwilightForestMod.LOGGER.error("Loot Chest at {}, {}, {} has null direction, setting it to north", (Object)x, (Object)y, (Object)z);
            facing = Direction.NORTH;
        }
        final int lootx = this.func_74865_a(x, z);
        final int looty = this.func_74862_a(y);
        final int lootz = this.func_74873_b(x, z);
        final BlockPos lootPos = new BlockPos(lootx, looty, lootz);
        this.func_175811_a(world, (BlockState)((BlockState)(trapped ? Blocks.field_150447_bR : Blocks.field_150486_ae).func_176223_P().func_206870_a((Property)ChestBlock.field_196314_b, (Comparable)ChestType.LEFT)).func_206870_a((Property)ChestBlock.field_176459_a, (Comparable)facing), x, y, z, sbb);
        this.func_175811_a(world, (BlockState)((BlockState)(trapped ? Blocks.field_150447_bR : Blocks.field_150486_ae).func_176223_P().func_206870_a((Property)ChestBlock.field_196314_b, (Comparable)ChestType.RIGHT)).func_206870_a((Property)ChestBlock.field_176459_a, (Comparable)facing), otherx, othery, otherz, sbb);
        treasureType.generateChestContents(world, lootPos);
    }
    
    protected void placeTripwire(final ISeedReader world, final int x, final int y, final int z, final int size, final Direction facing, final MutableBoundingBox sbb) {
        final int dx = facing.func_82601_c();
        final int dz = facing.func_82599_e();
        final BlockState tripwireHook = Blocks.field_150479_bC.func_176223_P();
        this.func_175811_a(world, (BlockState)tripwireHook.func_206870_a((Property)TripWireHookBlock.field_176264_a, (Comparable)facing.func_176734_d()), x, y, z, sbb);
        this.func_175811_a(world, (BlockState)tripwireHook.func_206870_a((Property)TripWireHookBlock.field_176264_a, (Comparable)facing), x + dx * size, y, z + dz * size, sbb);
        final BlockState tripwire = Blocks.field_150473_bD.func_176223_P();
        for (int i = 1; i < size; ++i) {
            this.func_175811_a(world, tripwire, x + dx * i, y, z + dz * i, sbb);
        }
    }
    
    protected void placeSignAtCurrentPosition(final ISeedReader world, final int x, final int y, final int z, final String string0, final String string1, final MutableBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vector3i)pos) && world.func_180495_p(pos).func_177230_c() != Blocks.field_222384_bX) {
            world.func_180501_a(pos, (BlockState)Blocks.field_222384_bX.func_176223_P().func_206870_a((Property)StandingSignBlock.field_176413_a, (Comparable)(this.func_186165_e().func_176736_b() * 4)), 2);
            final SignTileEntity teSign = (SignTileEntity)world.func_175625_s(pos);
            if (teSign != null) {
                teSign.func_212365_a(1, (ITextComponent)new StringTextComponent(string0));
                teSign.func_212365_a(2, (ITextComponent)new StringTextComponent(string1));
            }
        }
    }
    
    protected int[] offsetTowerCoords(final int x, final int y, final int z, final int towerSize, final Direction direction) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
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
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
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
    
    protected int func_74865_a(final int x, final int z) {
        final Direction enumfacing = this.func_186165_e();
        if (enumfacing == null) {
            return x;
        }
        switch (enumfacing) {
            case SOUTH: {
                return this.field_74887_e.field_78897_a + x;
            }
            case WEST: {
                return this.field_74887_e.field_78893_d - z;
            }
            case NORTH: {
                return this.field_74887_e.field_78893_d - x;
            }
            case EAST: {
                return this.field_74887_e.field_78897_a + z;
            }
            default: {
                return x;
            }
        }
    }
    
    protected int func_74873_b(final int x, final int z) {
        final Direction enumfacing = this.func_186165_e();
        if (enumfacing == null) {
            return z;
        }
        switch (enumfacing) {
            case SOUTH: {
                return this.field_74887_e.field_78896_c + z;
            }
            case WEST: {
                return this.field_74887_e.field_78896_c + x;
            }
            case NORTH: {
                return this.field_74887_e.field_78892_f - z;
            }
            case EAST: {
                return this.field_74887_e.field_78892_f - x;
            }
            default: {
                return z;
            }
        }
    }
    
    private Direction fakeBaseMode(final Rotation rotationsCW) {
        final Direction oldBaseMode = this.func_186165_e();
        if (oldBaseMode != null) {
            Direction pretendBaseMode = oldBaseMode;
            pretendBaseMode = rotationsCW.func_185831_a(pretendBaseMode);
            this.func_186164_a(pretendBaseMode);
        }
        return oldBaseMode;
    }
    
    protected int getXWithOffsetRotated(final int x, final int z, final Rotation rotationsCW) {
        final Direction oldMode = this.fakeBaseMode(rotationsCW);
        final int ret = this.func_74865_a(x, z);
        this.func_186164_a(oldMode);
        return ret;
    }
    
    protected int getZWithOffsetRotated(final int x, final int z, final Rotation rotationsCW) {
        final Direction oldMode = this.fakeBaseMode(rotationsCW);
        final int ret = this.func_74873_b(x, z);
        this.func_186164_a(oldMode);
        return ret;
    }
    
    protected void setBlockStateRotated(final ISeedReader world, final BlockState state, final int x, final int y, final int z, final Rotation rotationsCW, final MutableBoundingBox sbb) {
        final Direction oldMode = this.fakeBaseMode(rotationsCW);
        this.func_175811_a(world, state, x, y, z, sbb);
        this.func_186164_a(oldMode);
    }
    
    protected BlockState func_175807_a(final IBlockReader world, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        return super.func_175807_a(world, x, y, z, sbb);
    }
    
    @Override
    protected void func_175811_a(final ISeedReader worldIn, final BlockState blockstateIn, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        super.func_175811_a(worldIn, blockstateIn, x, y, z, sbb);
    }
    
    public BlockState getBlockStateFromPosRotated(final ISeedReader world, final int x, final int y, final int z, final MutableBoundingBox sbb, final Rotation rotationsCW) {
        final Direction oldMode = this.fakeBaseMode(rotationsCW);
        final BlockState ret = this.func_175807_a((IBlockReader)world, x, y, z, sbb);
        this.func_186164_a(oldMode);
        return ret;
    }
    
    protected void fillBlocksRotated(final ISeedReader world, final MutableBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final BlockState state, final Rotation rotation) {
        final Direction oldBase = this.fakeBaseMode(rotation);
        this.func_175804_a(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, state, state, false);
        this.func_186164_a(oldBase);
    }
    
    protected void randomlyFillBlocksRotated(final ISeedReader worldIn, final MutableBoundingBox boundingboxIn, final Random rand, final float chance, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final BlockState blockstate1, final BlockState blockstate2, final Rotation rotation) {
        final Direction oldBase = this.fakeBaseMode(rotation);
        final boolean minimumLightLevel = true;
        this.func_189914_a(worldIn, boundingboxIn, rand, chance, minX, minY, minZ, maxX, maxY, maxZ, blockstate1, blockstate2, false, true);
        this.func_186164_a(oldBase);
    }
    
    public void replaceAirAndLiquidDownwardsRotated(final ISeedReader world, final BlockState state, final int x, final int y, final int z, final Rotation rotation, final MutableBoundingBox sbb) {
        final Direction oldBaseMode = this.fakeBaseMode(rotation);
        this.func_175808_b(world, state, x, y, z, sbb);
        this.func_186164_a(oldBaseMode);
    }
    
    protected void fillAirRotated(final ISeedReader world, final MutableBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final Rotation rotation) {
        final Direction oldBaseMode = this.fakeBaseMode(rotation);
        this.func_74878_a(world, sbb, minX, minY, minZ, maxX, maxY, maxZ);
        this.func_186164_a(oldBaseMode);
    }
    
    protected void fillWithAir(final ISeedReader world, final MutableBoundingBox boundingBox, final int xMin, final int yMin, final int zMin, final int xMax, final int yMax, final int zMax, final Predicate<BlockState> predicate) {
        this.fillWithBlocks(world, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, Blocks.field_150350_a.func_176223_P(), predicate);
    }
    
    protected void fillWithBlocks(final ISeedReader world, final MutableBoundingBox boundingBox, final int xMin, final int yMin, final int zMin, final int xMax, final int yMax, final int zMax, final BlockState state, final Predicate<BlockState> predicate) {
        this.fillWithBlocks(world, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, state, state, predicate);
    }
    
    protected void fillWithBlocks(final ISeedReader world, final MutableBoundingBox boundingBox, final int xMin, final int yMin, final int zMin, final int xMax, final int yMax, final int zMax, final BlockState borderState, final BlockState interiorState, final Predicate<BlockState> predicate) {
        for (int y = yMin; y <= yMax; ++y) {
            for (int x = xMin; x <= xMax; ++x) {
                for (int z = zMin; z <= zMax; ++z) {
                    if (predicate.test(this.func_175807_a((IBlockReader)world, x, y, z, boundingBox))) {
                        final boolean isBorder = (yMin != yMax && (y == yMin || y == yMax)) || (xMin != xMax && (x == xMin || x == xMax)) || (zMin != zMax && (z == zMin || z == zMax));
                        this.func_175811_a(world, isBorder ? borderState : interiorState, x, y, z, boundingBox);
                    }
                }
            }
        }
    }
    
    protected static StructurePiece.BlockSelector getStrongholdStones() {
        return TFStructureComponentOld.strongholdStones;
    }
    
    protected Direction getStructureRelativeRotation(final Rotation rotationsCW) {
        return rotationsCW.func_185831_a(this.func_186165_e());
    }
    
    protected int getAverageGroundLevel(final ISeedReader world, final ChunkGenerator generator, final MutableBoundingBox sbb) {
        int totalHeight = 0;
        int heightCount = 0;
        for (int bz = this.field_74887_e.field_78896_c; bz <= this.field_74887_e.field_78892_f; ++bz) {
            for (int by = this.field_74887_e.field_78897_a; by <= this.field_74887_e.field_78893_d; ++by) {
                final BlockPos pos = new BlockPos(by, 64, bz);
                if (sbb.func_175898_b((Vector3i)pos)) {
                    totalHeight += Math.max(world.func_205770_a(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos).func_177956_o(), generator.func_205470_d());
                    ++heightCount;
                }
            }
        }
        if (heightCount == 0) {
            return -1;
        }
        return totalHeight / heightCount;
    }
    
    protected int findGroundLevel(final ISeedReader world, final MutableBoundingBox sbb, final int start, final Predicate<BlockState> predicate) {
        final Vector3i center = StructureBoundingBoxUtils.getCenter(sbb);
        final BlockPos.Mutable pos = new BlockPos.Mutable(center.func_177958_n(), 0, center.func_177952_p());
        for (int y = start; y > 0; --y) {
            pos.func_185336_p(y);
            if (predicate.test(world.func_180495_p((BlockPos)pos))) {
                return y;
            }
        }
        return 0;
    }
    
    protected boolean isBoundingBoxOutsideBiomes(final ISeedReader world, final Predicate<Biome> predicate) {
        final int minX = this.field_74887_e.field_78897_a - 1;
        final int minZ = this.field_74887_e.field_78896_c - 1;
        final int maxX = this.field_74887_e.field_78893_d + 1;
        final int maxZ = this.field_74887_e.field_78892_f + 1;
        final BlockPos.Mutable pos = new BlockPos.Mutable();
        for (int x = minX; x <= maxX; ++x) {
            for (int z = minZ; z <= maxZ; ++z) {
                if (!predicate.test(world.func_226691_t_((BlockPos)pos.func_181079_c(x, 0, z)))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Nullable
    public static StructurePiece findIntersectingExcluding(final List<StructurePiece> list, final MutableBoundingBox toCheck, final StructurePiece exclude) {
        for (final StructurePiece structurecomponent : list) {
            if (structurecomponent != exclude && structurecomponent.func_74874_b() != null && structurecomponent.func_74874_b().func_78884_a(toCheck)) {
                return structurecomponent;
            }
        }
        return null;
    }
    
    public BlockPos getBlockPosWithOffset(final int x, final int y, final int z) {
        return new BlockPos(this.func_74865_a(x, z), this.func_74862_a(y), this.func_74873_b(x, z));
    }
    
    protected static BlockState getStairState(final BlockState stairState, final Direction direction, final boolean isTopHalf) {
        return (BlockState)((BlockState)stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)direction)).func_206870_a((Property)StairsBlock.field_176308_b, (Comparable)(isTopHalf ? Half.TOP : Half.BOTTOM));
    }
    
    protected static BlockState getSlabState(final BlockState inputBlockState, final SlabType half) {
        return (BlockState)inputBlockState.func_206870_a((Property)SlabBlock.field_196505_a, (Comparable)half);
    }
    
    static {
        AIR = Blocks.field_150350_a.func_176223_P();
        strongholdStones = new StrongholdStones();
    }
}
