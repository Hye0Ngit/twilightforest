// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.world.TFGenCanopyTree;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import java.util.Random;

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
    public int wallBlockID;
    public int wallBlockMeta;
    public int wallVar0ID;
    public int wallVar0Meta;
    public float wallVarRarity;
    public int headBlockID;
    public int headBlockMeta;
    public int rootBlockID;
    public int rootBlockMeta;
    public int pillarBlockID;
    public int pillarBlockMeta;
    public int doorBlockID;
    public int doorBlockMeta;
    public float doorRarity;
    public int torchBlockID;
    public int torchBlockMeta;
    public float torchRarity;
    protected int rawWidth;
    protected int rawDepth;
    protected int[] storage;
    public static final int OUT_OF_BOUNDS = Integer.MIN_VALUE;
    public static final int OOB = Integer.MIN_VALUE;
    public static final int ROOM = 5;
    public static final int DOOR = 6;
    Random rand;
    
    public TFMaze(final int cellsWidth, final int cellsDepth) {
        this.oddBias = 3;
        this.evenBias = 1;
        this.tall = 3;
        this.head = 0;
        this.roots = 0;
        this.wallBlockID = TFBlocks.mazestone.field_71990_ca;
        this.wallBlockMeta = 2;
        this.rootBlockID = TFBlocks.mazestone.field_71990_ca;
        this.rootBlockMeta = 0;
        this.torchBlockID = Block.field_72069_aq.field_71990_ca;
        this.pillarBlockID = -1;
        this.torchBlockMeta = 0;
        this.torchRarity = 0.75f;
        this.doorRarity = 0.0f;
        this.width = cellsWidth;
        this.depth = cellsDepth;
        this.rawWidth = this.width * 2 + 1;
        this.rawDepth = this.depth * 2 + 1;
        this.storage = new int[this.rawWidth * this.rawDepth];
        this.rand = new Random();
    }
    
    public int getCell(final int x, final int z) {
        return this.getRaw(x * 2 + 1, z * 2 + 1);
    }
    
    public void putCell(final int x, final int z, final int value) {
        this.putRaw(x * 2 + 1, z * 2 + 1, value);
    }
    
    public boolean cellEquals(final int x, final int z, final int value) {
        return this.getCell(x, z) == value;
    }
    
    public int getWall(final int sx, final int sz, final int dx, final int dz) {
        if (dx == sx + 1 && dz == sz) {
            return this.getRaw(sx * 2 + 2, sz * 2 + 1);
        }
        if (dx == sx - 1 && dz == sz) {
            return this.getRaw(sx * 2 + 0, sz * 2 + 1);
        }
        if (dx == sx && dz == sz + 1) {
            return this.getRaw(sx * 2 + 1, sz * 2 + 2);
        }
        if (dx == sx && dz == sz - 1) {
            return this.getRaw(sx * 2 + 1, sz * 2 + 0);
        }
        System.out.println("Wall check out of bounds; s = " + sx + ", " + sz + "; d = " + dx + ", " + dz);
        return Integer.MIN_VALUE;
    }
    
    public void putWall(final int sx, final int sz, final int dx, final int dz, final int value) {
        if (dx == sx + 1 && dz == sz) {
            this.putRaw(sx * 2 + 2, sz * 2 + 1, value);
        }
        if (dx == sx - 1 && dz == sz) {
            this.putRaw(sx * 2 + 0, sz * 2 + 1, value);
        }
        if (dx == sx && dz == sz + 1) {
            this.putRaw(sx * 2 + 1, sz * 2 + 2, value);
        }
        if (dx == sx && dz == sz - 1) {
            this.putRaw(sx * 2 + 1, sz * 2 + 0, value);
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
    
    protected int getRaw(final int rawx, final int rawz) {
        if (rawx < 0 || rawx >= this.rawWidth || rawz < 0 || rawz >= this.rawDepth) {
            return Integer.MIN_VALUE;
        }
        return this.storage[rawz * this.rawWidth + rawx];
    }
    
    public void setSeed(final long newSeed) {
        this.rand.setSeed(newSeed);
    }
    
    public void copyToWorld(final World world, final int dx, final int dy, final int dz) {
        this.worldX = dx;
        this.worldY = dy;
        this.worldZ = dz;
        for (int x = 0; x < this.rawWidth; ++x) {
            for (int z = 0; z < this.rawDepth; ++z) {
                if (this.getRaw(x, z) == 0) {
                    final int mdx = dx + x / 2 * (this.evenBias + this.oddBias);
                    final int mdz = dz + z / 2 * (this.evenBias + this.oddBias);
                    if (this.isEven(x) && this.isEven(z)) {
                        if (this.type == 4 && this.shouldTree(x, z)) {
                            new TFGenCanopyTree().func_76484_a(world, this.rand, mdx, dy, mdz);
                        }
                        else {
                            for (int y = 0; y < this.head; ++y) {
                                this.putHeadBlock(world, mdx, dy + this.tall + y, mdz);
                            }
                            for (int y = 0; y < this.tall; ++y) {
                                this.putWallBlock(world, mdx, dy + y, mdz);
                            }
                            for (int y = 1; y <= this.roots; ++y) {
                                this.putRootBlock(world, mdx, dy - y, mdz);
                            }
                        }
                    }
                    if (this.isEven(x) && !this.isEven(z)) {
                        for (int even = 0; even < this.evenBias; ++even) {
                            for (int odd = 1; odd <= this.oddBias; ++odd) {
                                for (int y2 = 0; y2 < this.head; ++y2) {
                                    this.putHeadBlock(world, mdx + even, dy + this.tall + y2, mdz + odd);
                                }
                                for (int y2 = 0; y2 < this.tall; ++y2) {
                                    this.putWallBlock(world, mdx + even, dy + y2, mdz + odd);
                                }
                                for (int y2 = 1; y2 <= this.roots; ++y2) {
                                    this.putRootBlock(world, mdx + even, dy - y2, mdz + odd);
                                }
                            }
                        }
                    }
                    if (!this.isEven(x) && this.isEven(z)) {
                        for (int even = 0; even < this.evenBias; ++even) {
                            for (int odd = 1; odd <= this.oddBias; ++odd) {
                                for (int y2 = 0; y2 < this.head; ++y2) {
                                    this.putHeadBlock(world, mdx + odd, dy + this.tall + y2, mdz + even);
                                }
                                for (int y2 = 0; y2 < this.tall; ++y2) {
                                    this.putWallBlock(world, mdx + odd, dy + y2, mdz + even);
                                }
                                for (int y2 = 1; y2 <= this.roots; ++y2) {
                                    this.putRootBlock(world, mdx + odd, dy - y2, mdz + even);
                                }
                            }
                        }
                    }
                }
            }
        }
        this.placeTorches(world);
    }
    
    public void carveToWorld(final World world, final int dx, final int dy, final int dz) {
        this.worldX = dx;
        this.worldY = dy;
        this.worldZ = dz;
        for (int x = 0; x < this.rawWidth; ++x) {
            for (int z = 0; z < this.rawDepth; ++z) {
                if (this.getRaw(x, z) != 0) {
                    final int mdx = dx + x / 2 * (this.evenBias + this.oddBias);
                    final int mdz = dz + z / 2 * (this.evenBias + this.oddBias);
                    if (this.isEven(x) && this.isEven(z)) {
                        for (int y = 0; y < this.tall; ++y) {
                            this.carveBlock(world, mdx, dy + y, mdz);
                        }
                    }
                    else if (this.isEven(x) && !this.isEven(z)) {
                        for (int i = 1; i <= this.oddBias; ++i) {
                            for (int y2 = 0; y2 < this.tall; ++y2) {
                                this.carveBlock(world, mdx, dy + y2, mdz + i);
                            }
                        }
                    }
                    else if (!this.isEven(x) && this.isEven(z)) {
                        for (int i = 1; i <= this.oddBias; ++i) {
                            for (int y2 = 0; y2 < this.tall; ++y2) {
                                this.carveBlock(world, mdx + i, dy + y2, mdz);
                            }
                        }
                    }
                    else if (!this.isEven(x) && !this.isEven(z)) {
                        for (int mx = 1; mx <= this.oddBias; ++mx) {
                            for (int mz = 1; mz <= this.oddBias; ++mz) {
                                for (int y3 = 0; y3 < this.tall; ++y3) {
                                    this.carveBlock(world, mdx + mx, dy + y3, mdz + mz);
                                }
                            }
                        }
                    }
                }
            }
        }
        this.placeTorches(world);
    }
    
    public void copyToStructure(final World world, final int dx, final int dy, final int dz, final StructureTFComponent component, final StructureBoundingBox sbb) {
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
                            this.putCanopyTree(world, mdx, dy, mdz, component, sbb);
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
                    if (this.isEven(x) && this.isEven(z) && this.shouldTorch(x, z) && component.func_74866_a(world, mdx, mdy, mdz2, sbb) == this.wallBlockID) {
                        component.func_74864_a(world, this.torchBlockID, this.torchBlockMeta, mdx, mdy, mdz2, sbb);
                    }
                }
            }
        }
    }
    
    protected void makeWallThing(final World world, final int dy, final StructureTFComponent component, final StructureBoundingBox sbb, final int mdx, final int mdz, final int even, final int odd) {
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
    
    protected void putPillarBlock(final World world, final int x, final int y, final int z, final StructureTFComponent component, final StructureBoundingBox sbb) {
        component.func_74864_a(world, this.pillarBlockID, this.pillarBlockMeta, x, y, z, sbb);
    }
    
    protected void putWallBlock(final World world, final int x, final int y, final int z) {
        world.func_72832_d(x, y, z, this.wallBlockID, this.wallBlockMeta, 2);
    }
    
    protected void putWallBlock(final World world, final int x, final int y, final int z, final StructureTFComponent component, final StructureBoundingBox sbb) {
        if (this.wallVarRarity > 0.0f && this.rand.nextFloat() < this.wallVarRarity) {
            component.func_74864_a(world, this.wallVar0ID, this.wallVar0Meta, x, y, z, sbb);
        }
        else {
            component.func_74864_a(world, this.wallBlockID, this.wallBlockMeta, x, y, z, sbb);
        }
    }
    
    protected void putDoorBlock(final World world, final int x, final int y, final int z, final StructureTFComponent component, final StructureBoundingBox sbb) {
        component.func_74864_a(world, this.doorBlockID, this.doorBlockMeta, x, y, z, sbb);
    }
    
    protected void carveBlock(final World world, final int x, final int y, final int z) {
        world.func_72832_d(x, y, z, 0, 0, 2);
    }
    
    protected void putHeadBlock(final World world, final int x, final int y, final int z) {
        world.func_72832_d(x, y, z, this.headBlockID, this.headBlockMeta, 2);
    }
    
    protected void putHeadBlock(final World world, final int x, final int y, final int z, final StructureTFComponent component, final StructureBoundingBox sbb) {
        component.func_74864_a(world, this.headBlockID, this.headBlockMeta, x, y, z, sbb);
    }
    
    protected void putRootBlock(final World world, final int x, final int y, final int z) {
        world.func_72832_d(x, y, z, this.rootBlockID, this.rootBlockMeta, 2);
    }
    
    protected void putRootBlock(final World world, final int x, final int y, final int z, final StructureTFComponent component, final StructureBoundingBox sbb) {
        component.func_74864_a(world, this.rootBlockID, this.rootBlockMeta, x, y, z, sbb);
    }
    
    protected void putCanopyTree(final World world, final int x, final int y, final int z, final StructureTFComponent component, final StructureBoundingBox sbb) {
        final int wx = component.func_74865_a(x, z);
        final int wy = component.func_74862_a(y);
        final int wz = component.func_74873_b(x, z);
        if (sbb.func_78890_b(wx, wy, wz)) {
            new TFGenCanopyTree().func_76484_a(world, this.rand, wx, wy, wz);
        }
    }
    
    public final boolean isEven(final int n) {
        return n % 2 == 0;
    }
    
    public void placeTorches(final World world) {
        final int torchHeight = 1;
        for (int x = 0; x < this.rawWidth; ++x) {
            for (int z = 0; z < this.rawDepth; ++z) {
                if (this.getRaw(x, z) == 0) {
                    final int mdx = this.worldX + x / 2 * (this.evenBias + this.oddBias);
                    final int mdy = this.worldY + torchHeight;
                    final int mdz = this.worldZ + z / 2 * (this.evenBias + this.oddBias);
                    if (this.isEven(x) && this.isEven(z) && this.shouldTorch(x, z) && world.func_72798_a(mdx, mdy, mdz) == this.wallBlockID) {
                        world.func_72832_d(mdx, mdy, mdz, this.torchBlockID, this.torchBlockMeta, 2);
                    }
                }
            }
        }
    }
    
    public boolean shouldTorch(final int rx, final int rz) {
        return this.getRaw(rx + 1, rz) != Integer.MIN_VALUE && this.getRaw(rx - 1, rz) != Integer.MIN_VALUE && this.getRaw(rx, rz + 1) != Integer.MIN_VALUE && this.getRaw(rx, rz - 1) != Integer.MIN_VALUE && (this.getRaw(rx + 1, rz) != 0 || this.getRaw(rx - 1, rz) != 0) && (this.getRaw(rx, rz + 1) != 0 || this.getRaw(rx, rz - 1) != 0) && this.rand.nextFloat() <= this.torchRarity;
    }
    
    public boolean shouldPillar(final int rx, final int rz) {
        return this.pillarBlockID != -1 && this.getRaw(rx + 1, rz) != Integer.MIN_VALUE && this.getRaw(rx - 1, rz) != Integer.MIN_VALUE && this.getRaw(rx, rz + 1) != Integer.MIN_VALUE && this.getRaw(rx, rz - 1) != Integer.MIN_VALUE && (this.getRaw(rx + 1, rz) != 0 || this.getRaw(rx - 1, rz) != 0) && (this.getRaw(rx, rz + 1) != 0 || this.getRaw(rx, rz - 1) != 0);
    }
    
    public boolean shouldTree(final int rx, final int rz) {
        return ((rx == 0 || rx == this.rawWidth - 1) && (this.getRaw(rx, rz + 1) != 0 || this.getRaw(rx, rz - 1) != 0)) || ((rz == 0 || rz == this.rawDepth - 1) && (this.getRaw(rx + 1, rz) != 0 || this.getRaw(rx - 1, rz) != 0)) || this.rand.nextInt(50) == 0;
    }
    
    int getWorldX(final int x) {
        return this.worldX + x * (this.evenBias + this.oddBias) + 1;
    }
    
    int getWorldZ(final int z) {
        return this.worldZ + z * (this.evenBias + this.oddBias) + 1;
    }
    
    public void carveRoom0(final int cx, final int cz) {
        this.putCell(cx, cz, 5);
        this.putCell(cx + 1, cz, 5);
        this.putWall(cx, cz, cx + 1, cz, 5);
        this.putCell(cx - 1, cz, 5);
        this.putWall(cx, cz, cx - 1, cz, 5);
        this.putCell(cx, cz + 1, 5);
        this.putWall(cx, cz, cx, cz + 1, 5);
        this.putCell(cx, cz - 1, 5);
        this.putWall(cx, cz, cx, cz - 1, 5);
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
