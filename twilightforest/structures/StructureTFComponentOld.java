// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockPlanks;
import net.minecraft.world.biome.Biome;
import twilightforest.util.StructureBoundingBoxUtils;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.function.Predicate;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.block.BlockStandingSign;
import java.util.Iterator;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.util.BlockSnapshot;
import java.util.List;
import net.minecraft.block.BlockTripWireHook;
import twilightforest.loot.TFTreasure;
import java.util.Random;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import javax.annotation.Nullable;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import net.minecraft.block.state.IBlockState;

@Deprecated
public abstract class StructureTFComponentOld extends StructureTFComponent
{
    protected static final IBlockState AIR;
    private static final StructureTFStrongholdStones strongholdStones;
    
    public StructureTFComponentOld() {
    }
    
    public StructureTFComponentOld(final TFFeature feature, final int i) {
        super(i);
        this.feature = feature;
    }
    
    @Override
    public TFFeature getFeatureType() {
        return this.feature;
    }
    
    public void func_186164_a(@Nullable final EnumFacing facing) {
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
    
    public static StructureBoundingBox getComponentToAddBoundingBox(final int x, final int y, final int z, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, @Nullable final EnumFacing dir) {
        switch (dir) {
            default: {
                return new StructureBoundingBox(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case SOUTH: {
                return new StructureBoundingBox(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case WEST: {
                return new StructureBoundingBox(x - maxZ + minZ, y + minY, z + minX, x + minZ, y + maxY + minY, z + maxX + minX);
            }
            case NORTH: {
                return new StructureBoundingBox(x - maxX - minX, y + minY, z - maxZ - minZ, x - minX, y + maxY + minY, z - minZ);
            }
            case EAST: {
                return new StructureBoundingBox(x + minZ, y + minY, z - maxX, x + maxZ + minZ, y + maxY + minY, z + minX);
            }
        }
    }
    
    public static StructureBoundingBox getComponentToAddBoundingBox2(final int x, final int y, final int z, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final EnumFacing dir) {
        switch (dir) {
            default: {
                return new StructureBoundingBox(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case SOUTH: {
                return new StructureBoundingBox(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case WEST: {
                return new StructureBoundingBox(x - maxZ - minZ, y + minY, z + minX, x - minZ, y + maxY + minY, z + maxX + minX);
            }
            case NORTH: {
                return new StructureBoundingBox(x - maxX - minX, y + minY, z - maxZ - minZ, x - minX, y + maxY + minY, z - minZ);
            }
            case EAST: {
                return new StructureBoundingBox(x + minZ, y + minY, z - maxX, x + maxZ + minZ, y + maxY + minY, z - minX);
            }
        }
    }
    
    protected TileEntityMobSpawner setSpawner(final World world, final int x, final int y, final int z, final StructureBoundingBox sbb, final ResourceLocation monsterID) {
        TileEntityMobSpawner tileEntitySpawner = null;
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vec3i)pos) && world.func_180495_p(pos).func_177230_c() != Blocks.field_150474_ac) {
            world.func_180501_a(pos, Blocks.field_150474_ac.func_176223_P(), 2);
            tileEntitySpawner = (TileEntityMobSpawner)world.func_175625_s(pos);
            if (tileEntitySpawner != null) {
                tileEntitySpawner.func_145881_a().func_190894_a(monsterID);
            }
        }
        return tileEntitySpawner;
    }
    
    protected void surroundBlockCardinal(final World world, final IBlockState block, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        this.func_175811_a(world, block, x + 0, y, z - 1, sbb);
        this.func_175811_a(world, block, x + 0, y, z + 1, sbb);
        this.func_175811_a(world, block, x - 1, y, z + 0, sbb);
        this.func_175811_a(world, block, x + 1, y, z + 0, sbb);
    }
    
    protected void surroundBlockCardinalRotated(final World world, final IBlockState block, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        this.func_175811_a(world, block.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.NORTH), x + 0, y, z - 1, sbb);
        this.func_175811_a(world, block.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.SOUTH), x + 0, y, z + 1, sbb);
        this.func_175811_a(world, block.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.WEST), x - 1, y, z + 0, sbb);
        this.func_175811_a(world, block.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.EAST), x + 1, y, z + 0, sbb);
    }
    
    protected void surroundBlockCorners(final World world, final IBlockState block, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        this.func_175811_a(world, block, x - 1, y, z - 1, sbb);
        this.func_175811_a(world, block, x - 1, y, z + 1, sbb);
        this.func_175811_a(world, block, x + 1, y, z - 1, sbb);
        this.func_175811_a(world, block, x + 1, y, z + 1, sbb);
    }
    
    protected TileEntityMobSpawner setSpawnerRotated(final World world, final int x, final int y, final int z, final Rotation rotation, final ResourceLocation monsterID, final StructureBoundingBox sbb) {
        final EnumFacing oldBase = this.fakeBaseMode(rotation);
        final TileEntityMobSpawner ret = this.setSpawner(world, x, y, z, sbb, monsterID);
        this.func_186164_a(oldBase);
        return ret;
    }
    
    protected void placeTreasureAtCurrentPosition(final World world, final Random rand, final int x, final int y, final int z, final TFTreasure treasureType, final StructureBoundingBox sbb) {
        this.placeTreasureAtCurrentPosition(world, rand, x, y, z, treasureType, false, sbb);
    }
    
    protected void placeTreasureAtCurrentPosition(final World world, final Random rand, final int x, final int y, final int z, final TFTreasure treasureType, final boolean trapped, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vec3i)pos) && world.func_180495_p(pos).func_177230_c() != (trapped ? Blocks.field_150447_bR : Blocks.field_150486_ae)) {
            treasureType.generateChest(world, pos, trapped);
        }
    }
    
    protected void placeTreasureRotated(final World world, final int x, final int y, final int z, final Rotation rotation, final TFTreasure treasureType, final StructureBoundingBox sbb) {
        this.placeTreasureRotated(world, x, y, z, rotation, treasureType, false, sbb);
    }
    
    protected void placeTreasureRotated(final World world, final int x, final int y, final int z, final Rotation rotation, final TFTreasure treasureType, final boolean trapped, final StructureBoundingBox sbb) {
        final int dx = this.getXWithOffsetRotated(x, z, rotation);
        final int dy = this.func_74862_a(y);
        final int dz = this.getZWithOffsetRotated(x, z, rotation);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vec3i)pos) && world.func_180495_p(pos).func_177230_c() != (trapped ? Blocks.field_150447_bR : Blocks.field_150486_ae)) {
            treasureType.generateChest(world, pos, trapped);
        }
    }
    
    protected void placeTripwire(final World world, final int x, final int y, final int z, final int size, final EnumFacing facing, final StructureBoundingBox sbb) {
        final int dx = facing.func_82601_c();
        final int dz = facing.func_82599_e();
        world.captureBlockSnapshots = true;
        final IBlockState tripwireHook = Blocks.field_150479_bC.func_176223_P();
        this.func_175811_a(world, tripwireHook.func_177226_a((IProperty)BlockTripWireHook.field_176264_a, (Comparable)facing.func_176734_d()), x, y, z, sbb);
        this.func_175811_a(world, tripwireHook.func_177226_a((IProperty)BlockTripWireHook.field_176264_a, (Comparable)facing), x + dx * size, y, z + dz * size, sbb);
        final IBlockState tripwire = Blocks.field_150473_bD.func_176223_P();
        for (int i = 1; i < size; ++i) {
            this.func_175811_a(world, tripwire, x + dx * i, y, z + dz * i, sbb);
        }
        world.captureBlockSnapshots = false;
        final List<BlockSnapshot> blockSnapshots = (List<BlockSnapshot>)world.capturedBlockSnapshots.clone();
        world.capturedBlockSnapshots.clear();
        for (final BlockSnapshot snap : blockSnapshots) {
            final int updateFlag = snap.getFlag();
            final IBlockState oldBlock = snap.getReplacedBlock();
            final IBlockState newBlock = world.func_180495_p(snap.getPos());
            newBlock.func_177230_c().func_176213_c(world, snap.getPos(), newBlock);
            world.markAndNotifyBlock(snap.getPos(), (Chunk)null, oldBlock, newBlock, updateFlag);
        }
    }
    
    protected void placeSignAtCurrentPosition(final World world, final int x, final int y, final int z, final String string0, final String string1, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vec3i)pos) && world.func_180495_p(pos).func_177230_c() != Blocks.field_150472_an) {
            world.func_180501_a(pos, Blocks.field_150472_an.func_176223_P().func_177226_a((IProperty)BlockStandingSign.field_176413_a, (Comparable)(this.func_186165_e().func_176736_b() * 4)), 2);
            final TileEntitySign teSign = (TileEntitySign)world.func_175625_s(pos);
            if (teSign != null) {
                teSign.field_145915_a[1] = (ITextComponent)new TextComponentString(string0);
                teSign.field_145915_a[2] = (ITextComponent)new TextComponentString(string1);
            }
        }
    }
    
    protected void placeSignAtCurrentPosition(final World world, final int x, final int y, final int z, final StructureBoundingBox sbb, final String... text) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vec3i)pos) && world.func_180495_p(pos).func_177230_c() != Blocks.field_150472_an) {
            world.func_180501_a(pos, Blocks.field_150472_an.func_176223_P().func_177226_a((IProperty)BlockStandingSign.field_176413_a, (Comparable)(this.func_186165_e().func_176736_b() * 4)), 2);
            final TileEntitySign teSign = (TileEntitySign)world.func_175625_s(pos);
            if (teSign != null) {
                for (int min = Math.min(text.length, teSign.field_145915_a.length), i = 0; i < min; ++i) {
                    teSign.field_145915_a[i] = (ITextComponent)new TextComponentString(text[i]);
                }
            }
        }
    }
    
    protected int[] offsetTowerCoords(final int x, final int y, final int z, final int towerSize, final EnumFacing direction) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (direction == EnumFacing.SOUTH) {
            return new int[] { dx + 1, dy - 1, dz - towerSize / 2 };
        }
        if (direction == EnumFacing.WEST) {
            return new int[] { dx + towerSize / 2, dy - 1, dz + 1 };
        }
        if (direction == EnumFacing.NORTH) {
            return new int[] { dx - 1, dy - 1, dz + towerSize / 2 };
        }
        if (direction == EnumFacing.EAST) {
            return new int[] { dx - towerSize / 2, dy - 1, dz - 1 };
        }
        return new int[] { x, y, z };
    }
    
    protected BlockPos offsetTowerCCoords(final int x, final int y, final int z, final int towerSize, final EnumFacing direction) {
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
        final EnumFacing enumfacing = this.func_186165_e();
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
        final EnumFacing enumfacing = this.func_186165_e();
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
    
    private EnumFacing fakeBaseMode(final Rotation rotationsCW) {
        final EnumFacing oldBaseMode = this.func_186165_e();
        if (oldBaseMode != null) {
            EnumFacing pretendBaseMode = oldBaseMode;
            pretendBaseMode = rotationsCW.func_185831_a(pretendBaseMode);
            this.func_186164_a(pretendBaseMode);
        }
        return oldBaseMode;
    }
    
    protected int getXWithOffsetRotated(final int x, final int z, final Rotation rotationsCW) {
        final EnumFacing oldMode = this.fakeBaseMode(rotationsCW);
        final int ret = this.func_74865_a(x, z);
        this.func_186164_a(oldMode);
        return ret;
    }
    
    protected int getZWithOffsetRotated(final int x, final int z, final Rotation rotationsCW) {
        final EnumFacing oldMode = this.fakeBaseMode(rotationsCW);
        final int ret = this.func_74873_b(x, z);
        this.func_186164_a(oldMode);
        return ret;
    }
    
    protected void setBlockStateRotated(final World world, final IBlockState state, final int x, final int y, final int z, final Rotation rotationsCW, final StructureBoundingBox sbb) {
        final EnumFacing oldMode = this.fakeBaseMode(rotationsCW);
        this.func_175811_a(world, state, x, y, z, sbb);
        this.func_186164_a(oldMode);
    }
    
    public IBlockState func_175807_a(final World world, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        return super.func_175807_a(world, x, y, z, sbb);
    }
    
    protected void func_175811_a(final World worldIn, final IBlockState blockstateIn, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        super.func_175811_a(worldIn, blockstateIn, x, y, z, sbb);
    }
    
    public IBlockState getBlockStateFromPosRotated(final World world, final int x, final int y, final int z, final StructureBoundingBox sbb, final Rotation rotationsCW) {
        final EnumFacing oldMode = this.fakeBaseMode(rotationsCW);
        final IBlockState ret = this.func_175807_a(world, x, y, z, sbb);
        this.func_186164_a(oldMode);
        return ret;
    }
    
    protected void fillBlocksRotated(final World world, final StructureBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final IBlockState state, final Rotation rotation) {
        final EnumFacing oldBase = this.fakeBaseMode(rotation);
        this.func_175804_a(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, state, state, false);
        this.func_186164_a(oldBase);
    }
    
    protected void randomlyFillBlocksRotated(final World worldIn, final StructureBoundingBox boundingboxIn, final Random rand, final float chance, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final IBlockState blockstate1, final IBlockState blockstate2, final Rotation rotation) {
        final EnumFacing oldBase = this.fakeBaseMode(rotation);
        final int minimumLightLevel = 15;
        this.func_189914_a(worldIn, boundingboxIn, rand, chance, minX, minY, minZ, maxX, maxY, maxZ, blockstate1, blockstate2, false, 15);
        this.func_186164_a(oldBase);
    }
    
    public void replaceAirAndLiquidDownwardsRotated(final World world, final IBlockState state, final int x, final int y, final int z, final Rotation rotation, final StructureBoundingBox sbb) {
        final EnumFacing oldBaseMode = this.fakeBaseMode(rotation);
        this.func_175808_b(world, state, x, y, z, sbb);
        this.func_186164_a(oldBaseMode);
    }
    
    protected void fillAirRotated(final World world, final StructureBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final Rotation rotation) {
        final EnumFacing oldBaseMode = this.fakeBaseMode(rotation);
        this.func_74878_a(world, sbb, minX, minY, minZ, maxX, maxY, maxZ);
        this.func_186164_a(oldBaseMode);
    }
    
    protected void fillWithAir(final World world, final StructureBoundingBox boundingBox, final int xMin, final int yMin, final int zMin, final int xMax, final int yMax, final int zMax, final Predicate<IBlockState> predicate) {
        this.fillWithBlocks(world, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, Blocks.field_150350_a.func_176223_P(), predicate);
    }
    
    protected void fillWithBlocks(final World world, final StructureBoundingBox boundingBox, final int xMin, final int yMin, final int zMin, final int xMax, final int yMax, final int zMax, final IBlockState state, final Predicate<IBlockState> predicate) {
        this.fillWithBlocks(world, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, state, state, predicate);
    }
    
    protected void fillWithBlocks(final World world, final StructureBoundingBox boundingBox, final int xMin, final int yMin, final int zMin, final int xMax, final int yMax, final int zMax, final IBlockState borderState, final IBlockState interiorState, final Predicate<IBlockState> predicate) {
        for (int y = yMin; y <= yMax; ++y) {
            for (int x = xMin; x <= xMax; ++x) {
                for (int z = zMin; z <= zMax; ++z) {
                    if (predicate.test(this.func_175807_a(world, x, y, z, boundingBox))) {
                        final boolean isBorder = (yMin != yMax && (y == yMin || y == yMax)) || (xMin != xMax && (x == xMin || x == xMax)) || (zMin != zMax && (z == zMin || z == zMax));
                        this.func_175811_a(world, isBorder ? borderState : interiorState, x, y, z, boundingBox);
                    }
                }
            }
        }
    }
    
    protected static StructureComponent.BlockSelector getStrongholdStones() {
        return StructureTFComponentOld.strongholdStones;
    }
    
    protected EnumFacing getStructureRelativeRotation(final Rotation rotationsCW) {
        return rotationsCW.func_185831_a(this.func_186165_e());
    }
    
    public void nullifySkyLightForBoundingBox(final World world) {
        this.nullifySkyLight(world, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1, this.field_74887_e.field_78896_c - 1, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78894_e + 1, this.field_74887_e.field_78892_f + 1);
    }
    
    protected void nullifySkyLightAtCurrentPosition(final World world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        this.nullifySkyLight(world, this.func_74865_a(sx, sz), this.func_74862_a(sy), this.func_74873_b(sx, sz), this.func_74865_a(dx, dz), this.func_74862_a(dy), this.func_74873_b(dx, dz));
    }
    
    protected void nullifySkyLight(final World world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        for (int x = sx; x <= dx; ++x) {
            for (int z = sz; z <= dz; ++z) {
                for (int y = sy; y <= dy; ++y) {
                    world.func_175653_a(EnumSkyBlock.SKY, new BlockPos(x, y, z), 0);
                }
            }
        }
    }
    
    protected int getAverageGroundLevel(final World world, final StructureBoundingBox sbb) {
        int totalHeight = 0;
        int heightCount = 0;
        for (int bz = this.field_74887_e.field_78896_c; bz <= this.field_74887_e.field_78892_f; ++bz) {
            for (int by = this.field_74887_e.field_78897_a; by <= this.field_74887_e.field_78893_d; ++by) {
                final BlockPos pos = new BlockPos(by, 64, bz);
                if (sbb.func_175898_b((Vec3i)pos)) {
                    totalHeight += Math.max(world.func_175672_r(pos).func_177956_o(), world.field_73011_w.func_76557_i());
                    ++heightCount;
                }
            }
        }
        if (heightCount == 0) {
            return -1;
        }
        return totalHeight / heightCount;
    }
    
    protected int findGroundLevel(final World world, final StructureBoundingBox sbb, final int start, final Predicate<IBlockState> predicate) {
        final Vec3i center = StructureBoundingBoxUtils.getCenter(sbb);
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(center.func_177958_n(), 0, center.func_177952_p());
        for (int y = start; y > 0; --y) {
            pos.func_185336_p(y);
            if (predicate.test(world.func_180495_p((BlockPos)pos))) {
                return y;
            }
        }
        return 0;
    }
    
    protected boolean isBoundingBoxOutsideBiomes(final World world, final StructureBoundingBox sbb, final Predicate<Biome> predicate) {
        final int minX = this.field_74887_e.field_78897_a - 1;
        final int minZ = this.field_74887_e.field_78896_c - 1;
        final int maxX = this.field_74887_e.field_78893_d + 1;
        final int maxZ = this.field_74887_e.field_78892_f + 1;
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int x = minX; x <= maxX; ++x) {
            for (int z = minZ; z <= maxZ; ++z) {
                if (!predicate.test(world.func_180494_b((BlockPos)pos.func_181079_c(x, 0, z)))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Nullable
    public static StructureComponent findIntersectingExcluding(final List<StructureComponent> list, final StructureBoundingBox toCheck, final StructureComponent exclude) {
        for (final StructureComponent structurecomponent : list) {
            if (structurecomponent != exclude && structurecomponent.func_74874_b() != null && structurecomponent.func_74874_b().func_78884_a(toCheck)) {
                return structurecomponent;
            }
        }
        return null;
    }
    
    public BlockPos getBlockPosWithOffset(final int x, final int y, final int z) {
        return new BlockPos(this.func_74865_a(x, z), this.func_74862_a(y), this.func_74873_b(x, z));
    }
    
    protected static IBlockState getStairState(final IBlockState stairState, final EnumFacing direction, final Rotation rotation, final boolean isTopHalf) {
        return stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)direction).func_177226_a((IProperty)BlockStairs.field_176308_b, (Comparable)(isTopHalf ? BlockStairs.EnumHalf.TOP : BlockStairs.EnumHalf.BOTTOM));
    }
    
    protected static IBlockState getSlabState(final IBlockState inputBlockState, final BlockPlanks.EnumType type, final BlockSlab.EnumBlockHalf half) {
        return inputBlockState.func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)type).func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)half);
    }
    
    static {
        AIR = Blocks.field_150350_a.func_176223_P();
        strongholdStones = new StructureTFStrongholdStones();
    }
}
