// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.worldgen.ConfiguredFeatures;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.TwilightForestMod;
import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.structure.StructurePiece;

public class TFMaze
{
    public int width;
    public int depth;
    public int oddBias;
    public int evenBias;
    public int tall;
    public int head;
    public int roots;
    public int worldX;
    public int worldY;
    public int worldZ;
    public int type;
    public StructurePiece.BlockSelector wallBlocks;
    public BlockState wallBlockState;
    public BlockState headBlockState;
    public BlockState rootBlockState;
    public BlockState pillarBlockState;
    public BlockState doorBlockState;
    public float doorRarity;
    public BlockState torchBlockState;
    public float torchRarity;
    protected int rawWidth;
    protected int rawDepth;
    protected int[] storage;
    public static final int OUT_OF_BOUNDS = Integer.MIN_VALUE;
    public static final int OOB = Integer.MIN_VALUE;
    public static final int ROOM = 5;
    public static final int DOOR = 6;
    public Random rand;
    
    public TFMaze(final int cellsWidth, final int cellsDepth) {
        this.oddBias = 3;
        this.evenBias = 1;
        this.tall = 3;
        this.head = 0;
        this.roots = 0;
        this.wallBlockState = ((Block)TFBlocks.maze_stone_chiseled.get()).func_176223_P();
        this.rootBlockState = ((Block)TFBlocks.maze_stone.get()).func_176223_P();
        this.torchBlockState = Blocks.field_150478_aa.func_176223_P();
        this.pillarBlockState = null;
        this.torchRarity = 0.75f;
        this.doorRarity = 0.0f;
        this.width = cellsWidth;
        this.depth = cellsDepth;
        this.rawWidth = this.width * 2 + 1;
        this.rawDepth = this.depth * 2 + 1;
        this.storage = new int[this.rawWidth * this.rawDepth];
        this.rand = new Random();
    }
    
    private int getCell(final int x, final int z) {
        return this.getRaw(x * 2 + 1, z * 2 + 1);
    }
    
    private void putCell(final int x, final int z, final int value) {
        this.putRaw(x * 2 + 1, z * 2 + 1, value);
    }
    
    private boolean cellEquals(final int x, final int z, final int value) {
        return this.getCell(x, z) == value;
    }
    
    private int getWall(final int sx, final int sz, final int dx, final int dz) {
        if (dx == sx + 1 && dz == sz) {
            return this.getRaw(sx * 2 + 2, sz * 2 + 1);
        }
        if (dx == sx - 1 && dz == sz) {
            return this.getRaw(sx * 2, sz * 2 + 1);
        }
        if (dx == sx && dz == sz + 1) {
            return this.getRaw(sx * 2 + 1, sz * 2 + 2);
        }
        if (dx == sx && dz == sz - 1) {
            return this.getRaw(sx * 2 + 1, sz * 2);
        }
        TwilightForestMod.LOGGER.info("Wall check out of bounds; s = {}, {}; d = {}, {}", (Object)sx, (Object)sz, (Object)dx, (Object)dz);
        return Integer.MIN_VALUE;
    }
    
    public void putWall(final int sx, final int sz, final int dx, final int dz, final int value) {
        if (dx == sx + 1 && dz == sz) {
            this.putRaw(sx * 2 + 2, sz * 2 + 1, value);
        }
        if (dx == sx - 1 && dz == sz) {
            this.putRaw(sx * 2, sz * 2 + 1, value);
        }
        if (dx == sx && dz == sz + 1) {
            this.putRaw(sx * 2 + 1, sz * 2 + 2, value);
        }
        if (dx == sx && dz == sz - 1) {
            this.putRaw(sx * 2 + 1, sz * 2, value);
        }
    }
    
    public boolean isWall(final int sx, final int sz, final int dx, final int dz) {
        return this.getWall(sx, sz, dx, dz) == 0;
    }
    
    public void putRaw(final int rawx, final int rawz, final int value) {
        if (rawx >= 0 && rawx < this.rawWidth && rawz >= 0 && rawz < this.rawDepth) {
            this.storage[rawz * this.rawWidth + rawx] = value;
        }
    }
    
    private int getRaw(final int rawx, final int rawz) {
        if (rawx < 0 || rawx >= this.rawWidth || rawz < 0 || rawz >= this.rawDepth) {
            return Integer.MIN_VALUE;
        }
        return this.storage[rawz * this.rawWidth + rawx];
    }
    
    public void setSeed(final long newSeed) {
        this.rand.setSeed(newSeed);
    }
    
    public void copyToStructure(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final int dx, final int dy, final int dz, final TFStructureComponentOld component, final MutableBoundingBox sbb) {
        for (int x = 0; x < this.rawWidth; ++x) {
            for (int z = 0; z < this.rawDepth; ++z) {
                if (this.getRaw(x, z) == 0) {
                    int mdx = dx + x / 2 * (this.evenBias + this.oddBias);
                    int mdz = dz + z / 2 * (this.evenBias + this.oddBias);
                    if (this.evenBias > 1) {
                        --mdx;
                        --mdz;
                    }
                    if (this.isEven(x) && this.isEven(z)) {
                        if (this.type == 4 && this.shouldTree(x, z)) {
                            this.putCanopyTree(world, generator, mdx, dy, mdz, component, sbb);
                        }
                        else {
                            for (int even = 0; even < this.evenBias; ++even) {
                                for (int even2 = 0; even2 < this.evenBias; ++even2) {
                                    for (int y = 0; y < this.head; ++y) {
                                        this.putHeadBlock(world, mdx + even, dy + this.tall + y, mdz + even2, component, sbb);
                                    }
                                    for (int y = 0; y < this.tall; ++y) {
                                        if (this.shouldPillar(x, z)) {
                                            this.putPillarBlock(world, mdx + even, dy + y, mdz + even2, component, sbb);
                                        }
                                        else {
                                            this.putWallBlock(world, mdx + even, dy + y, mdz + even2, component, sbb);
                                        }
                                    }
                                    for (int y = 1; y <= this.roots; ++y) {
                                        this.putRootBlock(world, mdx + even, dy - y, mdz + even2, component, sbb);
                                    }
                                }
                            }
                        }
                    }
                    if (this.isEven(x) && !this.isEven(z)) {
                        for (int even = 0; even < this.evenBias; ++even) {
                            for (int odd = 1; odd <= this.oddBias; ++odd) {
                                this.makeWallThing(world, dy, component, sbb, mdx, mdz, even, odd);
                            }
                        }
                    }
                    if (!this.isEven(x) && this.isEven(z)) {
                        for (int even = 0; even < this.evenBias; ++even) {
                            for (int odd = 1; odd <= this.oddBias; ++odd) {
                                this.makeWallThing(world, dy, component, sbb, mdx, mdz, odd, even);
                            }
                        }
                    }
                }
                else if (this.getRaw(x, z) == 6) {
                    int mdx = dx + x / 2 * (this.evenBias + this.oddBias);
                    int mdz = dz + z / 2 * (this.evenBias + this.oddBias);
                    if (this.evenBias > 1) {
                        --mdx;
                        --mdz;
                    }
                    if (this.isEven(x) && !this.isEven(z)) {
                        for (int even = 0; even < this.evenBias; ++even) {
                            for (int odd = 1; odd <= this.oddBias; ++odd) {
                                for (int y = 0; y < this.head; ++y) {
                                    this.putHeadBlock(world, mdx + even, dy + this.tall + y, mdz + odd, component, sbb);
                                }
                                for (int y = 0; y < this.tall; ++y) {
                                    this.putDoorBlock(world, mdx + even, dy + y, mdz + odd, component, sbb);
                                }
                                for (int y = 1; y <= this.roots; ++y) {
                                    this.putRootBlock(world, mdx + even, dy - y, mdz + odd, component, sbb);
                                }
                            }
                        }
                    }
                    if (!this.isEven(x) && this.isEven(z)) {
                        for (int even = 0; even < this.evenBias; ++even) {
                            for (int odd = 1; odd <= this.oddBias; ++odd) {
                                for (int y = 0; y < this.head; ++y) {
                                    this.putHeadBlock(world, mdx + odd, dy + this.tall + y, mdz + even, component, sbb);
                                }
                                for (int y = 0; y < this.tall; ++y) {
                                    this.putDoorBlock(world, mdx + odd, dy + y, mdz + even, component, sbb);
                                }
                                for (int y = 1; y <= this.roots; ++y) {
                                    this.putRootBlock(world, mdx + odd, dy - y, mdz + even, component, sbb);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int x = 0; x < this.rawWidth; ++x) {
            for (int z = 0; z < this.rawDepth; ++z) {
                if (this.getRaw(x, z) == 0) {
                    final int mdx = dx + x / 2 * (this.evenBias + this.oddBias);
                    final int mdy = dy + 1;
                    final int mdz2 = dz + z / 2 * (this.evenBias + this.oddBias);
                    if (this.isEven(x) && this.isEven(z) && this.shouldTorch(x, z) && component.func_175807_a((IBlockReader)world, mdx, mdy, mdz2, sbb).func_177230_c() == this.wallBlockState.func_177230_c()) {
                        component.func_175811_a(world, this.torchBlockState, mdx, mdy, mdz2, sbb);
                    }
                }
            }
        }
    }
    
    private void makeWallThing(final ISeedReader world, final int dy, final TFStructureComponentOld component, final MutableBoundingBox sbb, final int mdx, final int mdz, final int even, final int odd) {
        for (int y = 0; y < this.head; ++y) {
            this.putHeadBlock(world, mdx + even, dy + this.tall + y, mdz + odd, component, sbb);
        }
        for (int y = 0; y < this.tall; ++y) {
            this.putWallBlock(world, mdx + even, dy + y, mdz + odd, component, sbb);
        }
        for (int y = 1; y <= this.roots; ++y) {
            this.putRootBlock(world, mdx + even, dy - y, mdz + odd, component, sbb);
        }
    }
    
    private void putPillarBlock(final ISeedReader world, final int x, final int y, final int z, final TFStructureComponentOld component, final MutableBoundingBox sbb) {
        component.func_175811_a(world, this.pillarBlockState, x, y, z, sbb);
    }
    
    private void putWallBlock(final ISeedReader world, final int x, final int y, final int z) {
        world.func_180501_a(new BlockPos(x, y, z), this.wallBlockState, 2);
    }
    
    private void putWallBlock(final ISeedReader world, final int x, final int y, final int z, final TFStructureComponentOld component, final MutableBoundingBox sbb) {
        if (this.wallBlocks != null) {
            this.wallBlocks.func_75062_a(this.rand, x, y, z, true);
            component.func_175811_a(world, this.wallBlocks.func_180780_a(), x, y, z, sbb);
        }
        else {
            component.func_175811_a(world, this.wallBlockState, x, y, z, sbb);
        }
    }
    
    private void putDoorBlock(final ISeedReader world, final int x, final int y, final int z, final TFStructureComponentOld component, final MutableBoundingBox sbb) {
        component.func_175811_a(world, this.doorBlockState, x, y, z, sbb);
    }
    
    private void carveBlock(final ISeedReader world, final int x, final int y, final int z) {
        world.func_180501_a(new BlockPos(x, y, z), Blocks.field_150350_a.func_176223_P(), 2);
    }
    
    private void putHeadBlock(final ISeedReader world, final int x, final int y, final int z) {
        world.func_180501_a(new BlockPos(x, y, z), this.headBlockState, 2);
    }
    
    private void putHeadBlock(final ISeedReader world, final int x, final int y, final int z, final TFStructureComponentOld component, final MutableBoundingBox sbb) {
        component.func_175811_a(world, this.headBlockState, x, y, z, sbb);
    }
    
    private void putRootBlock(final ISeedReader world, final int x, final int y, final int z) {
        world.func_180501_a(new BlockPos(x, y, z), this.rootBlockState, 2);
    }
    
    private void putRootBlock(final ISeedReader world, final int x, final int y, final int z, final TFStructureComponentOld component, final MutableBoundingBox sbb) {
        component.func_175811_a(world, this.rootBlockState, x, y, z, sbb);
    }
    
    private void putCanopyTree(final ISeedReader world, final ChunkGenerator generator, final int x, final int y, final int z, final TFStructureComponentOld component, final MutableBoundingBox sbb) {
        final BlockPos pos = component.getBlockPosWithOffset(x, y, z);
        if (sbb.func_175898_b((Vector3i)pos)) {
            ConfiguredFeatures.CANOPY_TREE_BASE.func_242765_a(world, generator, this.rand, pos);
        }
    }
    
    private boolean isEven(final int n) {
        return n % 2 == 0;
    }
    
    private void placeTorches(final ISeedReader world) {
        final int torchHeight = 1;
        for (int x = 0; x < this.rawWidth; ++x) {
            for (int z = 0; z < this.rawDepth; ++z) {
                if (this.getRaw(x, z) == 0) {
                    final int mdx = this.worldX + x / 2 * (this.evenBias + this.oddBias);
                    final int mdy = this.worldY + torchHeight;
                    final int mdz = this.worldZ + z / 2 * (this.evenBias + this.oddBias);
                    final BlockPos pos = new BlockPos(mdx, mdy, mdz);
                    if (this.isEven(x) && this.isEven(z) && this.shouldTorch(x, z) && world.func_180495_p(pos).func_177230_c() == this.wallBlockState.func_177230_c()) {
                        world.func_180501_a(pos, this.torchBlockState, 2);
                    }
                }
            }
        }
    }
    
    public boolean shouldTorch(final int rx, final int rz) {
        return this.getRaw(rx + 1, rz) != Integer.MIN_VALUE && this.getRaw(rx - 1, rz) != Integer.MIN_VALUE && this.getRaw(rx, rz + 1) != Integer.MIN_VALUE && this.getRaw(rx, rz - 1) != Integer.MIN_VALUE && (this.getRaw(rx + 1, rz) != 0 || this.getRaw(rx - 1, rz) != 0) && (this.getRaw(rx, rz + 1) != 0 || this.getRaw(rx, rz - 1) != 0) && this.rand.nextFloat() <= this.torchRarity;
    }
    
    public boolean shouldPillar(final int rx, final int rz) {
        return this.pillarBlockState != null && this.getRaw(rx + 1, rz) != Integer.MIN_VALUE && this.getRaw(rx - 1, rz) != Integer.MIN_VALUE && this.getRaw(rx, rz + 1) != Integer.MIN_VALUE && this.getRaw(rx, rz - 1) != Integer.MIN_VALUE && (this.getRaw(rx + 1, rz) != 0 || this.getRaw(rx - 1, rz) != 0) && (this.getRaw(rx, rz + 1) != 0 || this.getRaw(rx, rz - 1) != 0);
    }
    
    public boolean shouldTree(final int rx, final int rz) {
        return ((rx == 0 || rx == this.rawWidth - 1) && (this.getRaw(rx, rz + 1) != 0 || this.getRaw(rx, rz - 1) != 0)) || ((rz == 0 || rz == this.rawDepth - 1) && (this.getRaw(rx + 1, rz) != 0 || this.getRaw(rx - 1, rz) != 0)) || this.rand.nextInt(50) == 0;
    }
    
    public void carveRoom1(final int cx, final int cz) {
        final int rx = cx * 2 + 1;
        final int rz = cz * 2 + 1;
        for (int i = -2; i <= 2; ++i) {
            for (int j = -2; j <= 2; ++j) {
                this.putRaw(rx + i, rz + j, 5);
            }
        }
        this.putCell(rx, rz + 1, 0);
        this.putCell(rx, rz - 1, 0);
        this.putCell(rx + 1, rz, 0);
        this.putCell(rx - 1, rz, 0);
        if (this.getRaw(rx, rz + 4) != Integer.MIN_VALUE) {
            this.putRaw(rx, rz + 3, 5);
        }
        if (this.getRaw(rx, rz - 4) != Integer.MIN_VALUE) {
            this.putRaw(rx, rz - 3, 5);
        }
        if (this.getRaw(rx + 4, rz) != Integer.MIN_VALUE) {
            this.putRaw(rx + 3, rz, 5);
        }
        if (this.getRaw(rx - 4, rz) != Integer.MIN_VALUE) {
            this.putRaw(rx - 3, rz, 5);
        }
    }
    
    public void add4Exits() {
        final int hx = this.rawWidth / 2 + 1;
        final int hz = this.rawDepth / 2 + 1;
        this.putRaw(hx, 0, 5);
        this.putRaw(hx, this.rawDepth - 1, 5);
        this.putRaw(0, hz, 5);
        this.putRaw(this.rawWidth - 1, hz, 5);
    }
    
    public void generateRecursiveBacktracker(final int sx, final int sz) {
        this.rbGen(sx, sz);
    }
    
    public void rbGen(final int sx, final int sz) {
        this.putCell(sx, sz, 1);
        int unvisited = 0;
        if (this.cellEquals(sx + 1, sz, 0)) {
            ++unvisited;
        }
        if (this.cellEquals(sx - 1, sz, 0)) {
            ++unvisited;
        }
        if (this.cellEquals(sx, sz + 1, 0)) {
            ++unvisited;
        }
        if (this.cellEquals(sx, sz - 1, 0)) {
            ++unvisited;
        }
        if (unvisited == 0) {
            return;
        }
        int rn = this.rand.nextInt(unvisited);
        int dx;
        int dz = dx = 0;
        if (this.cellEquals(sx + 1, sz, 0)) {
            if (rn == 0) {
                dx = sx + 1;
                dz = sz;
            }
            --rn;
        }
        if (this.cellEquals(sx - 1, sz, 0)) {
            if (rn == 0) {
                dx = sx - 1;
                dz = sz;
            }
            --rn;
        }
        if (this.cellEquals(sx, sz + 1, 0)) {
            if (rn == 0) {
                dx = sx;
                dz = sz + 1;
            }
            --rn;
        }
        if (this.cellEquals(sx, sz - 1, 0) && rn == 0) {
            dx = sx;
            dz = sz - 1;
        }
        if (this.rand.nextFloat() <= this.doorRarity) {
            this.putWall(sx, sz, dx, dz, 6);
        }
        else {
            this.putWall(sx, sz, dx, dz, 2);
        }
        this.rbGen(dx, dz);
        this.rbGen(sx, sz);
        this.rbGen(sx, sz);
    }
}
