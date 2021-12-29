// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import twilightforest.block.CastleBlock;
import twilightforest.TwilightForestMod;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.Lists;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.item.HangingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.item.PaintingEntity;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.VineBlock;
import twilightforest.entity.TFEntities;
import twilightforest.loot.TFTreasure;
import net.minecraft.state.properties.Half;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.EntityType;
import twilightforest.structures.TFStructureHelper;
import net.minecraft.state.Property;
import net.minecraft.block.LadderBlock;
import javax.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.util.RotationUtil;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import java.util.Iterator;
import java.nio.IntBuffer;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.util.math.BlockPos;
import java.util.ArrayList;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.lang.invoke.MethodHandles;
import twilightforest.structures.TFStructureComponentOld;

public class TowerWingComponent extends TFStructureComponentOld
{
    private static final MethodHandles.Lookup LOOKUP;
    private static final Method HangingEntity_updateFacingWithBoundingBox;
    private static final MethodHandle handle_HangingEntity_updateFacingWithBoundingBox;
    public int size;
    protected int height;
    protected Class<? extends TowerRoofComponent> roofType;
    protected ArrayList<BlockPos> openings;
    protected int highestOpening;
    protected boolean[] openingTowards;
    
    public TowerWingComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(LichTowerPieces.TFLTWin, nbt);
    }
    
    public TowerWingComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.openings = new ArrayList<BlockPos>();
        this.openingTowards = new boolean[] { false, false, true, false };
        this.size = nbt.func_74762_e("towerSize");
        this.height = nbt.func_74762_e("towerHeight");
        this.readOpeningsFromArray(nbt.func_74759_k("doorInts"));
        this.highestOpening = nbt.func_74762_e("highestOpening");
        this.openingTowards[0] = nbt.func_74767_n("openingTowards0");
        this.openingTowards[1] = nbt.func_74767_n("openingTowards1");
        this.openingTowards[2] = nbt.func_74767_n("openingTowards2");
        this.openingTowards[3] = nbt.func_74767_n("openingTowards3");
    }
    
    protected TowerWingComponent(final IStructurePieceType type, final TFFeature feature, final int i) {
        super(type, feature, i);
        this.openings = new ArrayList<BlockPos>();
        this.openingTowards = new boolean[] { false, false, true, false };
        this.highestOpening = 0;
    }
    
    protected TowerWingComponent(final IStructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(type, feature, i);
        this.openings = new ArrayList<BlockPos>();
        this.openingTowards = new boolean[] { false, false, true, false };
        this.size = pSize;
        this.height = pHeight;
        this.func_186164_a(direction);
        this.highestOpening = 0;
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    private int[] getDoorsAsIntArray() {
        final IntBuffer ibuffer = IntBuffer.allocate(this.openings.size() * 3);
        for (final BlockPos door : this.openings) {
            ibuffer.put(door.func_177958_n());
            ibuffer.put(door.func_177956_o());
            ibuffer.put(door.func_177952_p());
        }
        return ibuffer.array();
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("towerSize", this.size);
        tagCompound.func_74768_a("towerHeight", this.height);
        tagCompound.func_74783_a("doorInts", this.getDoorsAsIntArray());
        tagCompound.func_74768_a("highestOpening", this.highestOpening);
        tagCompound.func_74757_a("openingTowards0", this.openingTowards[0]);
        tagCompound.func_74757_a("openingTowards1", this.openingTowards[1]);
        tagCompound.func_74757_a("openingTowards2", this.openingTowards[2]);
        tagCompound.func_74757_a("openingTowards3", this.openingTowards[3]);
    }
    
    private void readOpeningsFromArray(final int[] intArray) {
        for (int i = 0; i < intArray.length; i += 3) {
            final BlockPos door = new BlockPos(intArray[i], intArray[i + 1], intArray[i + 2]);
            this.openings.add(door);
        }
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.makeARoof(parent, list, rand);
        this.makeABeard(parent, list, rand);
        if (this.size > 4) {
            for (final Rotation towerRotation : RotationUtil.ROTATIONS) {
                if (towerRotation != Rotation.CLOCKWISE_180) {
                    final int[] dest = this.getValidOpening(rand, towerRotation);
                    if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], this.size - 2, this.height - 4, towerRotation) && this.size > 8 && !this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], this.size - 4, this.height - 6, towerRotation)) {
                        this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], this.size - 6, this.height - 12, towerRotation);
                    }
                }
            }
        }
    }
    
    public boolean makeTowerWing(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        if (wingHeight < 6) {
            return false;
        }
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (rand.nextInt(6) == 0) {
            return this.makeBridge(list, rand, index, x, y, z, wingSize, wingHeight, rotation);
        }
        final TowerWingComponent wing = new TowerWingComponent(LichTowerPieces.TFLTWin, this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructurePiece intersect = StructurePiece.func_74883_a((List)list, wing.field_74887_e);
        if (intersect == null || intersect == this) {
            list.add(wing);
            wing.func_74861_a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return rand.nextInt(3) > 0 && this.makeBridge(list, rand, index, x, y, z, wingSize, wingHeight, rotation);
    }
    
    protected boolean makeBridge(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 3, direction);
        if (wingSize == 3 && wingHeight > 10) {
            wingHeight = 6 + rand.nextInt(5);
        }
        final TowerBridgeComponent bridge = new TowerBridgeComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        StructurePiece intersect = StructurePiece.func_74883_a((List)list, bridge.field_74887_e);
        if (intersect != null && intersect != this) {
            return false;
        }
        intersect = StructurePiece.func_74883_a((List)list, bridge.getWingBB());
        if (intersect == null || intersect == this) {
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    public void addOpening(final int dx, final int dy, final int dz, final Rotation direction) {
        this.openingTowards[direction.ordinal()] = true;
        if (dy > this.highestOpening) {
            this.highestOpening = dy;
        }
        this.openings.add(new BlockPos(dx, dy, dz));
    }
    
    public void addOpening(final int dx, final int dy, final int dz, final Direction facing) {
        this.addOpening(dx, dy, dz, RotationUtil.getRelativeRotation(this.func_186165_e(), facing));
    }
    
    public void makeABeard(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        final boolean attached = parent.func_74874_b().field_78895_b < this.field_74887_e.field_78895_b;
        final int index = this.func_74877_c();
        TowerBeardComponent beard;
        if (attached) {
            beard = new TowerBeardAttachedComponent(this.getFeatureType(), index + 1, this);
        }
        else {
            beard = new TowerBeardComponent(LichTowerPieces.TFLTBea, this.getFeatureType(), index + 1, this);
        }
        list.add(beard);
        beard.func_74861_a((StructurePiece)this, (List)list, rand);
    }
    
    public void makeARoof(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        final boolean attached = parent.func_74874_b().field_78894_e > this.field_74887_e.field_78894_e;
        if (attached) {
            this.makeAttachedRoof(list, rand);
        }
        else {
            this.makeFreestandingRoof(list, rand);
        }
    }
    
    protected void makeAttachedRoof(final List<StructurePiece> list, final Random rand) {
        final int index = this.func_74877_c();
        if (this.roofType == null && rand.nextInt(32) != 0) {
            this.tryToFitRoof(list, rand, new TowerRoofGableForwardsComponent(this.getFeatureType(), index + 1, this));
        }
        if (this.roofType == null && rand.nextInt(8) != 0) {
            this.tryToFitRoof(list, rand, new TowerRoofSlabForwardsComponent(this.getFeatureType(), index + 1, this));
        }
        if (this.roofType == null && rand.nextInt(32) != 0) {
            final TowerRoofComponent roof = new TowerRoofAttachedSlabComponent(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final TowerRoofComponent roof = new TowerRoofFenceComponent(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
    }
    
    protected void tryToFitRoof(final List<StructurePiece> list, final Random rand, final TowerRoofComponent roof) {
        if (roof.fits(this, list)) {
            list.add(roof);
            roof.func_74861_a((StructurePiece)this, (List)list, rand);
            this.roofType = roof.getClass();
        }
    }
    
    protected void makeFreestandingRoof(final List<StructurePiece> list, final Random rand) {
        final int index = this.func_74877_c();
        if (this.roofType == null && rand.nextInt(8) != 0) {
            final TowerRoofComponent roof = new TowerRoofPointyOverhangComponent(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final TowerRoofComponent roof = new TowerRoofStairsOverhangComponent(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final TowerRoofComponent roof = new TowerRoofStairsComponent(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null && rand.nextInt(53) != 0) {
            final TowerRoofComponent roof = new TowerRoofSlabComponent(LichTowerPieces.TFLTRS, this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final TowerRoofComponent roof = new TowerRoofFenceComponent(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
    }
    
    public boolean func_230383_a_(final ISeedReader worldIn, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_74882_a(worldIn, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, TFStructureComponentOld.getStrongholdStones());
        this.func_74878_a(worldIn, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        if (this.highestOpening > 1) {
            this.makeStairs(worldIn, rand, sbb);
        }
        this.decorateThisTower(worldIn, sbb);
        this.makeWindows(worldIn, sbb, this.size < 4);
        this.makeOpenings(worldIn, sbb);
        return true;
    }
    
    protected void makeOpeningMarkers(final ISeedReader world, final Random rand, final int numMarkers, final MutableBoundingBox sbb) {
        if (this.size > 4) {
            final BlockState woolWhite = Blocks.field_196556_aL.func_176223_P();
            final BlockState woolOrange = Blocks.field_196557_aM.func_176223_P();
            final BlockState woolMagenta = Blocks.field_196558_aN.func_176223_P();
            final BlockState woolLightBlue = Blocks.field_196559_aO.func_176223_P();
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, Rotation.NONE);
                this.func_175811_a(world, woolWhite, spot[0], spot[1], spot[2], sbb);
            }
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, Rotation.CLOCKWISE_90);
                this.func_175811_a(world, woolOrange, spot[0], spot[1], spot[2], sbb);
            }
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, Rotation.CLOCKWISE_180);
                this.func_175811_a(world, woolMagenta, spot[0], spot[1], spot[2], sbb);
            }
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, Rotation.COUNTERCLOCKWISE_90);
                this.func_175811_a(world, woolLightBlue, spot[0], spot[1], spot[2], sbb);
            }
        }
    }
    
    protected void decorateThisTower(final ISeedReader world, final MutableBoundingBox sbb) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 * (this.field_74887_e.field_78896_c * 756839));
        if (this.size > 3) {
            if (this.isDeadEnd()) {
                this.decorateDeadEnd(world, decoRNG, sbb);
            }
            else {
                this.decorateStairTower(world, decoRNG, sbb);
            }
        }
    }
    
    protected void decorateDeadEnd(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        final BlockState birchPlanks = Blocks.field_196666_p.func_176223_P();
        final int floors = (this.height - 1) / 5;
        final int floorHeight = this.height / floors;
        for (int i = 1; i < floors; ++i) {
            for (int x = 1; x < this.size - 1; ++x) {
                for (int z = 1; z < this.size - 1; ++z) {
                    this.func_175811_a(world, birchPlanks, x, i * floorHeight, z, sbb);
                }
            }
        }
        if (floors > 1) {
            Rotation ladderDir = Rotation.COUNTERCLOCKWISE_90;
            this.decorateFloor(world, rand, 0, 1, floorHeight, ladderDir, null, sbb);
            for (int j = 1; j < floors - 1; ++j) {
                final int bottom = 1 + floorHeight * j;
                final int top = floorHeight * (j + 1);
                final Rotation downLadderDir = ladderDir;
                ladderDir = ladderDir.func_185830_a(Rotation.CLOCKWISE_90);
                this.decorateFloor(world, rand, j, bottom, top, ladderDir, downLadderDir, sbb);
            }
            this.decorateFloor(world, rand, floors, 1 + floorHeight * (floors - 1), this.height - 1, null, ladderDir, sbb);
        }
        else {
            this.decorateFloor(world, rand, 0, 1, this.height - 1, null, null, sbb);
        }
    }
    
    protected void decorateFloor(final ISeedReader world, final Random rand, final int floor, final int bottom, final int top, @Nullable final Rotation ladderUpDir, @Nullable final Rotation ladderDownDir, final MutableBoundingBox sbb) {
        final BlockState ladder = Blocks.field_150468_ap.func_176223_P();
        if (ladderUpDir != null) {
            final BlockState ladderUp = (BlockState)ladder.func_206870_a((Property)LadderBlock.field_176382_a, (Comparable)ladderUpDir.func_185831_a(Direction.EAST));
            final int dx = this.getLadderX(ladderUpDir);
            final int dz = this.getLadderZ(ladderUpDir);
            for (int dy = bottom; dy < top; ++dy) {
                this.func_175811_a(world, ladderUp, dx, dy, dz, sbb);
            }
        }
        if (ladderDownDir != null) {
            final BlockState ladderDown = (BlockState)ladder.func_206870_a((Property)LadderBlock.field_176382_a, (Comparable)ladderDownDir.func_185831_a(Direction.EAST));
            final int dx = this.getLadderX(ladderDownDir);
            final int dz = this.getLadderZ(ladderDownDir);
            for (int dy = bottom - 1; dy < bottom + 2; ++dy) {
                this.func_175811_a(world, ladderDown, dx, dy, dz, sbb);
            }
        }
        if (rand.nextInt(7) == 0 && ladderDownDir == null) {
            this.decorateWell(world, rand, bottom, sbb);
        }
        else if (rand.nextInt(7) == 0 && ladderDownDir == null) {
            this.decorateSkeletonRoom(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(6) == 0 && ladderDownDir == null) {
            this.decorateZombieRoom(world, rand, bottom, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(5) == 0 && ladderDownDir == null) {
            this.decorateCactusRoom(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(4) == 0 && ladderDownDir != null) {
            this.decorateTreasureChest(world, bottom, top, sbb);
        }
        else if (rand.nextInt(5) == 0) {
            this.decorateSpiderWebs(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(12) == 0 && ladderDownDir != null) {
            this.decorateSolidRock(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(3) == 0) {
            this.decorateFullLibrary(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else {
            this.decorateLibrary(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
    }
    
    protected void decorateWell(final ISeedReader world, final Random rand, final int bottom, final MutableBoundingBox sbb) {
        final int cx = this.size / 2;
        final BlockState waterOrLava = (rand.nextInt(4) == 0) ? Blocks.field_150353_l.func_176223_P() : Blocks.field_150355_j.func_176223_P();
        if (this.size > 5) {
            final BlockState stoneBricks = Blocks.field_196696_di.func_176223_P();
            final BlockState stoneSlabs = TFStructureHelper.stoneSlab;
            this.func_175811_a(world, stoneBricks, cx - 1, bottom, cx - 1, sbb);
            this.func_175811_a(world, stoneSlabs, cx - 1, bottom + 1, cx - 1, sbb);
            this.func_175811_a(world, stoneBricks, cx, bottom, cx - 1, sbb);
            this.func_175811_a(world, stoneBricks, cx + 1, bottom, cx - 1, sbb);
            this.func_175811_a(world, stoneSlabs, cx + 1, bottom + 1, cx - 1, sbb);
            this.func_175811_a(world, stoneBricks, cx - 1, bottom, cx, sbb);
            this.func_175811_a(world, waterOrLava, cx, bottom, cx, sbb);
            this.func_175811_a(world, stoneBricks, cx + 1, bottom, cx, sbb);
            this.func_175811_a(world, stoneBricks, cx - 1, bottom, cx + 1, sbb);
            this.func_175811_a(world, stoneSlabs, cx - 1, bottom + 1, cx + 1, sbb);
            this.func_175811_a(world, stoneBricks, cx, bottom, cx + 1, sbb);
            this.func_175811_a(world, stoneBricks, cx + 1, bottom, cx + 1, sbb);
            this.func_175811_a(world, stoneSlabs, cx + 1, bottom + 1, cx + 1, sbb);
        }
        this.func_175811_a(world, waterOrLava, cx, bottom - 1, cx, sbb);
    }
    
    protected void decorateSkeletonRoom(final ISeedReader world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final MutableBoundingBox sbb) {
        this.setSpawner(world, this.size / 2, bottom + 2, this.size / 2, sbb, (EntityType<?>)EntityType.field_200741_ag);
        final ArrayList<BlockPos> chainList = new ArrayList<BlockPos>();
        chainList.add(new BlockPos(this.size / 2, bottom + 2, this.size / 2));
        for (int i = 0; i < this.size + 2; ++i) {
            final BlockPos chain = new BlockPos(2 + rand.nextInt(this.size - 4), this.height - 2, 2 + rand.nextInt(this.size - 4));
            if (!this.chainCollides(chain, chainList)) {
                for (int dy = bottom; dy < top; ++dy) {
                    this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), chain.func_177958_n(), dy, chain.func_177952_p(), sbb);
                }
                chainList.add(chain);
            }
        }
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                if ((dx == 1 || dx == this.size - 2 || dz == 1 || dz == this.size - 2) && !this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir)) {
                    this.func_175811_a(world, Blocks.field_196553_aF.func_176223_P(), dx, top - 1, dz, sbb);
                }
            }
        }
    }
    
    protected void decorateZombieRoom(final ISeedReader world, final Random rand, final int bottom, final Rotation ladderUpDir, final Rotation ladderDownDir, final MutableBoundingBox sbb) {
        this.setSpawner(world, this.size / 2, bottom + 2, this.size / 2, sbb, (EntityType<?>)EntityType.field_200725_aD);
        final BlockState ironBars = Blocks.field_150411_aY.func_176223_P();
        final BlockState soulSand = Blocks.field_150425_aM.func_176223_P();
        final BlockState brownMushroom = Blocks.field_150338_P.func_176223_P();
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                if (!this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(5) == 0) {
                    this.func_175811_a(world, brownMushroom, dx, bottom, dz, sbb);
                }
            }
        }
        final ArrayList<BlockPos> slabList = new ArrayList<BlockPos>();
        slabList.add(new BlockPos(this.size / 2, bottom + 2, this.size / 2));
        for (int i = 0; i < this.size - 1; ++i) {
            final BlockPos slab = new BlockPos(2 + rand.nextInt(this.size - 4), this.height - 2, 2 + rand.nextInt(this.size - 4));
            if (!this.chainCollides(slab, slabList)) {
                this.func_175811_a(world, ironBars, slab.func_177958_n(), bottom, slab.func_177952_p(), sbb);
                this.func_175811_a(world, TFStructureHelper.birchSlab, slab.func_177958_n(), bottom + 1, slab.func_177952_p(), sbb);
                this.func_175811_a(world, soulSand, slab.func_177958_n(), bottom + 2, slab.func_177952_p(), sbb);
                slabList.add(slab);
            }
        }
    }
    
    protected void decorateCactusRoom(final ISeedReader world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final MutableBoundingBox sbb) {
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                this.func_175811_a(world, Blocks.field_150354_m.func_176223_P(), dx, bottom - 1, dz, sbb);
                if (!this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(4) == 0) {
                    this.func_175811_a(world, Blocks.field_196555_aI.func_176223_P(), dx, bottom, dz, sbb);
                }
            }
        }
        final ArrayList<BlockPos> cactusList = new ArrayList<BlockPos>();
        cactusList.add(new BlockPos(this.size / 2, bottom + 2, this.size / 2));
        for (int i = 0; i < this.size + 12; ++i) {
            final BlockPos cactus = new BlockPos(2 + rand.nextInt(this.size - 4), this.height - 2, 2 + rand.nextInt(this.size - 4));
            if (!this.chainCollides(cactus, cactusList)) {
                for (int dy = bottom; dy < top; ++dy) {
                    this.func_175811_a(world, Blocks.field_150434_aF.func_176223_P(), cactus.func_177958_n(), dy, cactus.func_177952_p(), sbb);
                }
                cactusList.add(cactus);
            }
        }
    }
    
    protected void decorateTreasureChest(final ISeedReader world, final int bottom, final int top, final MutableBoundingBox sbb) {
        final int cx = this.size / 2;
        final BlockState stoneBrick = Blocks.field_196696_di.func_176223_P();
        final BlockState stoneBrickStairs = Blocks.field_150390_bg.func_176223_P();
        final BlockState topStoneBrickStairs = (BlockState)stoneBrickStairs.func_206870_a((Property)StairsBlock.field_176308_b, (Comparable)Half.TOP);
        this.func_175811_a(world, stoneBrick, cx, bottom, cx, sbb);
        this.func_175811_a(world, stoneBrick, cx, top - 1, cx, sbb);
        if (this.size < 6) {
            this.surroundBlockCardinalRotated(world, stoneBrickStairs, cx, bottom, cx, sbb);
            this.surroundBlockCardinalRotated(world, topStoneBrickStairs, cx, top - 1, cx, sbb);
        }
        else {
            this.surroundBlockCardinalRotated(world, stoneBrickStairs, cx, bottom, cx, sbb);
            this.surroundBlockCorners(world, stoneBrick, cx, bottom, cx, sbb);
            for (int cy = bottom + 1; cy < top - 1; ++cy) {
                this.surroundBlockCorners(world, stoneBrick, cx, cy, cx, sbb);
            }
            this.surroundBlockCardinalRotated(world, topStoneBrickStairs, cx, top - 1, cx, sbb);
            this.surroundBlockCorners(world, stoneBrick, cx, top - 1, cx, sbb);
        }
        this.placeTreasureAtCurrentPosition(world, cx, bottom + 1, cx, TFTreasure.tower_room, sbb);
    }
    
    protected void decorateSpiderWebs(final ISeedReader world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final MutableBoundingBox sbb) {
        for (int dy = bottom; dy < top; ++dy) {
            final int chance = top - dy + 2;
            for (int dx = 1; dx <= this.size - 2; ++dx) {
                for (int dz = 1; dz <= this.size - 2; ++dz) {
                    if (!this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(chance) == 0) {
                        this.func_175811_a(world, Blocks.field_196553_aF.func_176223_P(), dx, dy, dz, sbb);
                    }
                }
            }
        }
        if (rand.nextInt(5) == 0) {
            EntityType<?> spiderName = null;
            switch (rand.nextInt(4)) {
                case 3: {
                    spiderName = (EntityType<?>)EntityType.field_200794_h;
                    break;
                }
                case 2: {
                    spiderName = TFEntities.swarm_spider;
                    break;
                }
                case 1: {
                    spiderName = TFEntities.hedge_spider;
                    break;
                }
                default: {
                    spiderName = (EntityType<?>)EntityType.field_200748_an;
                    break;
                }
            }
            this.setSpawner(world, this.size / 2, bottom + 2, this.size / 2, sbb, spiderName);
        }
        else {
            this.decorateFurniture(world, rand, bottom, this.size - 2, sbb);
        }
    }
    
    protected void decorateFurniture(final ISeedReader world, final Random rand, final int bottom, final int freeSpace, final MutableBoundingBox sbb) {
        if (rand.nextInt(3) > 0) {
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), this.size / 2, bottom, this.size / 2, sbb);
            this.func_175811_a(world, Blocks.field_196663_cq.func_176223_P(), this.size / 2, bottom + 1, this.size / 2, sbb);
        }
        final BlockState spruceStairs = Blocks.field_150485_bF.func_176223_P();
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.func_175811_a(world, (BlockState)spruceStairs.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.WEST), this.size / 2 + 1, bottom, this.size / 2, sbb);
        }
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.func_175811_a(world, (BlockState)spruceStairs.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.NORTH), this.size / 2, bottom, this.size / 2 + 1, sbb);
        }
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.func_175811_a(world, (BlockState)spruceStairs.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.EAST), this.size / 2 - 1, bottom, this.size / 2, sbb);
        }
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.func_175811_a(world, (BlockState)spruceStairs.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.SOUTH), this.size / 2, bottom, this.size / 2 - 1, sbb);
        }
    }
    
    protected void decorateSolidRock(final ISeedReader world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final MutableBoundingBox sbb) {
        for (int dy = bottom; dy < top; ++dy) {
            for (int dx = 1; dx <= this.size - 2; ++dx) {
                for (int dz = 1; dz <= this.size - 2; ++dz) {
                    if (!this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(9) != 0) {
                        this.func_175811_a(world, Blocks.field_150348_b.func_176223_P(), dx, dy, dz, sbb);
                    }
                }
            }
        }
    }
    
    protected void decorateLibrary(final ISeedReader world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final MutableBoundingBox sbb) {
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                for (int dy = bottom; dy < top - 1; ++dy) {
                    if ((dx == 1 || dx == this.size - 2 || dz == 1 || dz == this.size - 2) && !this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir)) {
                        this.func_175811_a(world, Blocks.field_150342_X.func_176223_P(), dx, dy, dz, sbb);
                    }
                }
            }
        }
        if (rand.nextInt(2) == 0 && this.size > 5) {
            this.decorateLibraryTreasure(world, rand, top, ladderUpDir, ladderDownDir, sbb);
        }
        if (rand.nextInt(2) == 0 && this.size > 5) {
            this.decorateFurniture(world, rand, bottom, this.size - 2, sbb);
        }
    }
    
    protected void decorateLibraryTreasure(final ISeedReader world, final Random rand, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final MutableBoundingBox sbb) {
        switch (rand.nextInt(4)) {
            default: {
                if (!this.isLadderPos(2, 1, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, 2, top - 2, 1, TFTreasure.tower_library, sbb);
                    break;
                }
            }
            case 1: {
                if (!this.isLadderPos(this.size - 2, 2, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, this.size - 2, top - 2, 2, TFTreasure.tower_library, sbb);
                    break;
                }
            }
            case 2: {
                if (!this.isLadderPos(this.size - 3, this.size - 2, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, this.size - 3, top - 2, this.size - 2, TFTreasure.tower_library, sbb);
                    break;
                }
            }
            case 3: {
                if (!this.isLadderPos(1, this.size - 3, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, 1, top - 2, this.size - 3, TFTreasure.tower_library, sbb);
                    break;
                }
                break;
            }
        }
    }
    
    protected void decorateFullLibrary(final ISeedReader world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final MutableBoundingBox sbb) {
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                for (int dy = bottom; dy < top; ++dy) {
                    if (((dx % 2 != 0 && ((dz >= dx && dz <= this.size - dx - 1) || (dz >= this.size - dx - 1 && dz <= dx))) || (dz % 2 != 0 && ((dx >= dz && dx <= this.size - dz - 1) || (dx >= this.size - dz - 1 && dx <= dz)))) && !this.isWindowPos(dx, dy, dz) && !this.isOpeningPos(dx, dy, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir)) {
                        this.func_175811_a(world, Blocks.field_150342_X.func_176223_P(), dx, dy, dz, sbb);
                    }
                }
            }
        }
        if (rand.nextInt(2) == 0 && this.size > 5) {
            this.decorateLibraryTreasure(world, rand, top, ladderUpDir, ladderDownDir, sbb);
        }
    }
    
    protected void decorateTrap(final ISeedReader world, final int bottom, final int top, final MutableBoundingBox sbb) {
        for (int dx = 2; dx <= this.size - 3; ++dx) {
            for (int dz = 2; dz <= this.size - 3; ++dz) {
                if (dx == 2 || dx == this.size - 3 || dz == 2 || dz == this.size - 3) {
                    this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), dx, -1, dz, sbb);
                }
            }
        }
        for (int dy = bottom - 2; dy < top - 2; ++dy) {
            this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 1, dy, 1, sbb);
            this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), 1, dy, this.size - 2, sbb);
            this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), this.size - 2, dy, 1, sbb);
            this.func_175811_a(world, Blocks.field_150335_W.func_176223_P(), this.size - 2, dy, this.size - 2, sbb);
        }
    }
    
    protected boolean isWindowPos(final int x, final int z) {
        return (x == 1 && z == this.size / 2) || (x == this.size - 2 && z == this.size / 2) || (x == this.size / 2 && z == 1) || (x == this.size / 2 && z == this.size - 2);
    }
    
    protected boolean isWindowPos(final int x, final int y, final int z) {
        int checkYDir = -1;
        if (x == 1 && z == this.size / 2) {
            checkYDir = 2;
        }
        else if (x == this.size - 2 && z == this.size / 2) {
            checkYDir = 0;
        }
        else if (x == this.size / 2 && z == 1) {
            checkYDir = 3;
        }
        else if (x == this.size / 2 && z == this.size - 2) {
            checkYDir = 1;
        }
        return checkYDir > -1 && !this.openingTowards[checkYDir] && (y == 2 || y == 3 || (this.height > 8 && (y == this.height - 3 || y == this.height - 4)));
    }
    
    protected boolean isOpeningPos(final int x, final int y, final int z) {
        for (final BlockPos door : this.openings) {
            final BlockPos.Mutable inside = new BlockPos.Mutable(door.func_177958_n(), door.func_177956_o(), door.func_177952_p());
            if (inside.func_177958_n() == 0) {
                inside.func_189536_c(Direction.EAST);
            }
            else if (inside.func_177958_n() == this.size - 1) {
                inside.func_189536_c(Direction.WEST);
            }
            else if (inside.func_177952_p() == 0) {
                inside.func_189536_c(Direction.SOUTH);
            }
            else if (inside.func_177952_p() == this.size - 1) {
                inside.func_189536_c(Direction.NORTH);
            }
            if (inside.func_177958_n() == x && inside.func_177952_p() == z && (inside.func_177956_o() == y || inside.func_177956_o() + 1 == y)) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean isLadderPos(final int x, final int z, final Rotation ladderUpDir, final Rotation ladderDownDir) {
        return (ladderUpDir != null && x == this.getLadderX(ladderUpDir) && z == this.getLadderZ(ladderUpDir)) || (ladderDownDir != null && x == this.getLadderX(ladderDownDir) && z == this.getLadderZ(ladderDownDir));
    }
    
    protected int getLadderX(final Rotation ladderDir) {
        switch (ladderDir) {
            case NONE: {
                return this.size - 2;
            }
            case CLOCKWISE_90: {
                return this.size / 2 + 1;
            }
            case CLOCKWISE_180: {
                return 1;
            }
            case COUNTERCLOCKWISE_90: {
                return this.size / 2 - 1;
            }
            default: {
                return this.size / 2;
            }
        }
    }
    
    protected int getLadderZ(final Rotation ladderDir) {
        switch (ladderDir) {
            case NONE: {
                return this.size / 2 - 1;
            }
            case CLOCKWISE_90: {
                return this.size - 2;
            }
            case CLOCKWISE_180: {
                return this.size / 2 + 1;
            }
            case COUNTERCLOCKWISE_90: {
                return 1;
            }
            default: {
                return this.size / 2;
            }
        }
    }
    
    protected void decorateStairTower(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        if (this.height - this.highestOpening > 8) {
            final int base = this.highestOpening + 3;
            final int floors = (this.height - base) / 5;
            final int floorHeight = (this.height - base) / floors;
            for (int i = 0; i < floors; ++i) {
                for (int x = 1; x < this.size - 1; ++x) {
                    for (int z = 1; z < this.size - 1; ++z) {
                        this.func_175811_a(world, TFStructureHelper.birchPlanks, x, i * floorHeight + base, z, sbb);
                    }
                }
            }
            Rotation ladderDir = Rotation.NONE;
            final int dx = this.getLadderX(ladderDir);
            final int dz = this.getLadderZ(ladderDir);
            final BlockState defaultState = (BlockState)Blocks.field_150468_ap.func_176223_P().func_206870_a((Property)LadderBlock.field_176382_a, (Comparable)ladderDir.func_185831_a(Direction.EAST));
            for (int dy = 1; dy < 3; ++dy) {
                this.func_175811_a(world, defaultState, dx, base - dy, dz, sbb);
            }
            for (int j = 0; j < floors - 1; ++j) {
                final int bottom = base + 1 + floorHeight * j;
                final int top = base + floorHeight * (j + 1);
                final Rotation downLadderDir = ladderDir;
                ladderDir = ladderDir.func_185830_a(Rotation.CLOCKWISE_90);
                this.decorateFloor(world, rand, j, bottom, top, ladderDir, downLadderDir, sbb);
            }
            this.decorateFloor(world, rand, floors, base + 1 + floorHeight * (floors - 1), this.height - 1, null, ladderDir, sbb);
            if (base > 8) {
                switch (rand.nextInt(4)) {
                    case 0: {
                        this.decorateChandelier(world, rand, base + 1, sbb);
                        break;
                    }
                    case 1: {
                        this.decorateHangingChains(world, rand, base + 1, sbb);
                        break;
                    }
                    case 2: {
                        this.decorateFloatingBooks(world, rand, base + 1, sbb);
                        break;
                    }
                    case 3: {
                        this.decorateFloatingVines(world, rand, base + 1, sbb);
                        break;
                    }
                }
            }
        }
        else if (this.size > 5) {
            switch (rand.nextInt(4)) {
                case 0: {
                    this.decorateChandelier(world, rand, this.height, sbb);
                    break;
                }
                case 1: {
                    this.decorateHangingChains(world, rand, this.height, sbb);
                    break;
                }
                case 2: {
                    this.decorateFloatingBooks(world, rand, this.height, sbb);
                    break;
                }
                case 3: {
                    this.decorateFloatingVines(world, rand, this.height, sbb);
                    break;
                }
            }
        }
        else if (this.size > 3) {
            switch (rand.nextInt(3)) {
                case 0: {
                    this.decorateHangingChains(world, rand, this.height, sbb);
                    break;
                }
                case 1: {
                    this.decorateFloatingBooks(world, rand, this.height, sbb);
                    break;
                }
                case 2: {
                    this.decorateFloatingVines(world, rand, this.height, sbb);
                    break;
                }
            }
        }
        this.decorateStairFloor(world, rand, sbb);
    }
    
    protected void decorateStairFloor(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        if (this.size > 5) {
            if (rand.nextInt(3) == 0) {
                this.decorateStairWell(world, rand, sbb);
            }
            else if (rand.nextInt(3) > 0 || this.size >= 15) {
                this.decoratePlanter(world, rand, sbb);
            }
        }
    }
    
    protected void decorateChandelier(final ISeedReader world, final Random rand, final int decoTop, final MutableBoundingBox sbb) {
        if (decoTop < 8 || this.size < 8) {
            return;
        }
        final int cx = this.size / 2;
        final int cy = decoTop - rand.nextInt(decoTop - 7) - 2;
        final int cz = this.size / 2;
        final BlockState oakFence = Blocks.field_180407_aO.func_176223_P();
        this.surroundBlockCardinal(world, oakFence, cx, cy, cz, sbb);
        this.surroundBlockCardinal(world, oakFence, cx, cy + 1, cz, sbb);
        for (int y = cy; y < decoTop - 1; ++y) {
            this.func_175811_a(world, oakFence, cx, y, cz, sbb);
        }
    }
    
    protected void decorateHangingChains(final ISeedReader world, final Random rand, final int decoTop, final MutableBoundingBox sbb) {
        final ArrayList<BlockPos> chainList = new ArrayList<BlockPos>();
        for (int i = 0; i < this.size + 2; ++i) {
            final int filled = (this.size < 15) ? 2 : 4;
            final BlockPos chain = new BlockPos(filled + rand.nextInt(this.size - filled * 2), decoTop - 2, filled + rand.nextInt(this.size - filled * 2));
            if (!this.chainCollides(chain, chainList)) {
                final int length = 1 + rand.nextInt(decoTop - 7);
                this.decorateOneChain(world, rand, chain.func_177958_n(), decoTop, length, chain.func_177952_p(), sbb);
                chainList.add(chain);
            }
        }
    }
    
    protected boolean chainCollides(final BlockPos coords, final List<BlockPos> list) {
        for (final BlockPos existing : list) {
            if (coords.func_177952_p() == existing.func_177952_p() && Math.abs(coords.func_177958_n() - existing.func_177958_n()) <= 1) {
                return true;
            }
            if (coords.func_177958_n() == existing.func_177958_n() && Math.abs(coords.func_177952_p() - existing.func_177952_p()) <= 1) {
                return true;
            }
        }
        return false;
    }
    
    protected void decorateOneChain(final ISeedReader world, final Random rand, final int dx, final int decoTop, final int length, final int dz, final MutableBoundingBox sbb) {
        for (int y = 1; y <= length; ++y) {
            this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx, decoTop - y - 1, dz, sbb);
        }
        BlockState ballBlock = null;
        switch (rand.nextInt(10)) {
            case 0: {
                ballBlock = Blocks.field_150339_S.func_176223_P();
                break;
            }
            case 1: {
                ballBlock = Blocks.field_150342_X.func_176223_P();
                break;
            }
            case 2: {
                ballBlock = Blocks.field_150424_aL.func_176223_P();
                break;
            }
            case 3: {
                ballBlock = Blocks.field_150425_aM.func_176223_P();
                break;
            }
            case 4: {
                ballBlock = Blocks.field_150359_w.func_176223_P();
                break;
            }
            case 5: {
                ballBlock = Blocks.field_150368_y.func_176223_P();
                break;
            }
            case 6: {
                ballBlock = Blocks.field_196688_de.func_176223_P();
                break;
            }
            default: {
                ballBlock = Blocks.field_150426_aN.func_176223_P();
                break;
            }
        }
        this.func_175811_a(world, ballBlock, dx, decoTop - length - 2, dz, sbb);
    }
    
    protected void decorateFloatingBooks(final ISeedReader world, final Random rand, final int decoTop, final MutableBoundingBox sbb) {
        final ArrayList<BlockPos> shelfList = new ArrayList<BlockPos>();
        for (int i = 0; i < this.size + 2; ++i) {
            final int filled = (this.size < 15) ? 2 : 4;
            final BlockPos shelf = new BlockPos(filled + rand.nextInt(this.size - filled * 2), decoTop - 2, filled + rand.nextInt(this.size - filled * 2));
            if (!this.chainCollides(shelf, shelfList)) {
                int y;
                for (int bottom = 2 + rand.nextInt(decoTop - 7), top = y = rand.nextInt(bottom - 1) + 2; y <= bottom; ++y) {
                    this.func_175811_a(world, Blocks.field_150342_X.func_176223_P(), shelf.func_177958_n(), decoTop - y, shelf.func_177952_p(), sbb);
                }
                shelfList.add(shelf);
            }
        }
    }
    
    protected void decorateFloatingVines(final ISeedReader world, final Random rand, final int decoTop, final MutableBoundingBox sbb) {
        final BlockState mossyCobbleStone = Blocks.field_150341_Y.func_176223_P();
        final BlockState vine = Blocks.field_150395_bd.func_176223_P();
        final BlockState vineNorth = (BlockState)vine.func_206870_a((Property)VineBlock.field_176273_b, (Comparable)true);
        final BlockState vineSouth = (BlockState)vine.func_206870_a((Property)VineBlock.field_176279_N, (Comparable)true);
        final BlockState vineEast = (BlockState)vine.func_206870_a((Property)VineBlock.field_176278_M, (Comparable)true);
        final BlockState vineWest = (BlockState)vine.func_206870_a((Property)VineBlock.field_176280_O, (Comparable)true);
        final ArrayList<BlockPos> mossList = new ArrayList<BlockPos>();
        for (int i = 0; i < this.size + 2; ++i) {
            final int filled = (this.size < 15) ? 2 : 4;
            final BlockPos moss = new BlockPos(filled + rand.nextInt(this.size - filled * 2), decoTop - 2, filled + rand.nextInt(this.size - filled * 2));
            if (!this.chainCollides(moss, mossList)) {
                int y;
                for (int bottom = 2 + rand.nextInt(decoTop - 7), top = y = rand.nextInt(bottom - 1) + 2; y <= bottom; ++y) {
                    this.func_175811_a(world, mossyCobbleStone, moss.func_177958_n(), decoTop - y, moss.func_177952_p(), sbb);
                    this.func_175811_a(world, vineEast, moss.func_177958_n() + 1, decoTop - y, moss.func_177952_p(), sbb);
                    this.func_175811_a(world, vineWest, moss.func_177958_n() - 1, decoTop - y, moss.func_177952_p(), sbb);
                    this.func_175811_a(world, vineSouth, moss.func_177958_n(), decoTop - y, moss.func_177952_p() + 1, sbb);
                    this.func_175811_a(world, vineNorth, moss.func_177958_n(), decoTop - y, moss.func_177952_p() - 1, sbb);
                }
                mossList.add(moss);
            }
        }
        for (int y2 = this.highestOpening + 3; y2 < decoTop - 1; ++y2) {
            for (int x = 1; x < this.size - 1; ++x) {
                if (rand.nextInt(3) == 0) {
                    this.func_175811_a(world, vineSouth, x, y2, 1, sbb);
                }
                if (rand.nextInt(3) == 0) {
                    this.func_175811_a(world, vineNorth, x, y2, this.size - 2, sbb);
                }
            }
            for (int z = 1; z < this.size - 1; ++z) {
                if (rand.nextInt(3) == 0) {
                    this.func_175811_a(world, vineEast, 1, y2, z, sbb);
                }
                if (rand.nextInt(3) == 0) {
                    this.func_175811_a(world, vineWest, this.size - 2, y2, z, sbb);
                }
            }
        }
    }
    
    protected void decoratePlanter(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        this.surroundBlockCardinal(world, TFStructureHelper.stoneSlab, cx, 1, cz, sbb);
        if (this.size > 7) {
            this.surroundBlockCorners(world, TFStructureHelper.stoneSlabDouble, cx, 1, cz, sbb);
        }
        this.func_175811_a(world, Blocks.field_196658_i.func_176223_P(), cx, 1, cz, sbb);
        final int i = rand.nextInt(6);
        final boolean isTree = i > 4;
        final BlockState plant = isTree ? TFStructureHelper.randomSapling(i) : TFStructureHelper.randomMushroom(i);
        this.func_175811_a(world, plant, cx, 2, cz, sbb);
        final BlockPos pos = this.getBlockPosWithOffset(cx, 2, cz);
        final BlockState whatHappened = this.func_175807_a((IBlockReader)world, cx, 2, cz, sbb);
        if (whatHappened.func_177230_c() == plant.func_177230_c() || whatHappened.func_177230_c() == Blocks.field_150350_a) {
            this.func_175811_a(world, Blocks.field_150457_bL.func_176223_P(), cx, 2, cz, sbb);
        }
    }
    
    protected void decorateStairWell(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        final int cy = 1;
        final BlockState waterOrLava = (rand.nextInt(4) == 0) ? Blocks.field_150353_l.func_176223_P() : Blocks.field_150355_j.func_176223_P();
        final BlockState stoneSlab = Blocks.field_222401_hJ.func_176223_P();
        final BlockState stoneBrick = Blocks.field_196696_di.func_176223_P();
        if (this.size > 7) {
            this.func_175811_a(world, stoneBrick, cx - 1, cy, cz - 1, sbb);
            this.func_175811_a(world, stoneSlab, cx - 1, cy + 1, cz - 1, sbb);
            this.func_175811_a(world, stoneBrick, cx, cy, cz - 1, sbb);
            this.func_175811_a(world, stoneBrick, cx + 1, cy, cz - 1, sbb);
            this.func_175811_a(world, stoneSlab, cx + 1, cy + 1, cz - 1, sbb);
            this.func_175811_a(world, stoneBrick, cx - 1, cy, cz, sbb);
            this.func_175811_a(world, waterOrLava, cx, cy, cz, sbb);
            this.func_175811_a(world, stoneBrick, cx + 1, cy, cz, sbb);
            this.func_175811_a(world, stoneBrick, cx - 1, cy, cz + 1, sbb);
            this.func_175811_a(world, stoneSlab, cx - 1, cy + 1, cz + 1, sbb);
            this.func_175811_a(world, stoneBrick, cx, cy, cz + 1, sbb);
            this.func_175811_a(world, stoneBrick, cx + 1, cy, cz + 1, sbb);
            this.func_175811_a(world, stoneSlab, cx + 1, cy + 1, cz + 1, sbb);
        }
        this.func_175811_a(world, waterOrLava, cx, cy - 1, cz, sbb);
    }
    
    public boolean isDeadEnd() {
        return this.openings.size() == 1;
    }
    
    protected void makeOpenings(final ISeedReader world, final MutableBoundingBox sbb) {
        for (final BlockPos door : this.openings) {
            this.makeDoorOpening(world, door.func_177958_n(), door.func_177956_o(), door.func_177952_p(), sbb);
        }
    }
    
    protected void makeDoorOpening(final ISeedReader world, final int dx, final int dy, final int dz, final MutableBoundingBox sbb) {
        this.func_175811_a(world, TowerWingComponent.AIR, dx, dy, dz, sbb);
        this.func_175811_a(world, TowerWingComponent.AIR, dx, dy + 1, dz, sbb);
        if (this.func_175807_a((IBlockReader)world, dx, dy + 2, dz, sbb).func_177230_c() != Blocks.field_150350_a) {
            final BlockState state = TFStructureHelper.stoneSlabDouble;
            this.func_175811_a(world, state, dx, dy + 2, dz, sbb);
        }
    }
    
    public int[] getValidOpening(final Random rand, final Rotation direction) {
        int wLength = this.size - 2;
        int offset = 1;
        if (this.size == 15) {
            wLength = 11;
            offset = 2;
        }
        if (direction == Rotation.NONE || direction == Rotation.CLOCKWISE_180) {
            final int rx = (direction == Rotation.NONE) ? (this.size - 1) : 0;
            final int rz = offset + rand.nextInt(wLength);
            final int ry = this.getYByStairs(rz, rand, direction);
            return new int[] { rx, ry, rz };
        }
        if (direction == Rotation.CLOCKWISE_90 || direction == Rotation.COUNTERCLOCKWISE_90) {
            final int rx = offset + rand.nextInt(wLength);
            final int rz = (direction == Rotation.CLOCKWISE_90) ? (this.size - 1) : 0;
            final int ry = this.getYByStairs(rx, rand, direction);
            return new int[] { rx, ry, rz };
        }
        return new int[] { 0, 0, 0 };
    }
    
    protected int getYByStairs(final int rx, final Random rand, final Rotation direction) {
        int rise = 1;
        int base = 0;
        if (this.size == 15) {
            rise = 10;
            base = ((direction == Rotation.NONE || direction == Rotation.CLOCKWISE_180) ? 23 : 28);
        }
        if (this.size == 9) {
            rise = 6;
            base = ((direction == Rotation.NONE || direction == Rotation.CLOCKWISE_180) ? 2 : 5);
        }
        if (this.size == 7) {
            rise = 4;
            base = ((direction == Rotation.NONE || direction == Rotation.CLOCKWISE_180) ? 2 : 4);
        }
        if (this.size == 5) {
            rise = 4;
            switch (direction) {
                case NONE: {
                    base = 3;
                    break;
                }
                case CLOCKWISE_90: {
                    base = 2;
                    break;
                }
                case CLOCKWISE_180: {
                    base = 5;
                    break;
                }
                case COUNTERCLOCKWISE_90: {
                    base = 4;
                    break;
                }
            }
        }
        final int flights = (this.height - 6 - base) / rise + 1;
        if (base > 0 && flights > 0) {
            final int flightChosen = rand.nextInt(flights);
            int dy = flightChosen * rise + base;
            if (this.size == 15) {
                dy -= ((direction == Rotation.NONE || direction == Rotation.COUNTERCLOCKWISE_90) ? ((rx - 2) / 2) : ((this.size - rx - 3) / 2));
            }
            else {
                dy -= ((direction == Rotation.NONE || direction == Rotation.COUNTERCLOCKWISE_90) ? ((rx - 1) / 2) : ((this.size - rx - 2) / 2));
            }
            if (dy < 1) {
                dy = 1;
            }
            return dy;
        }
        return 0;
    }
    
    protected void makeWindows(final ISeedReader world, final MutableBoundingBox sbb, final boolean real) {
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            final boolean realWindows = real && !this.openingTowards[rotation.ordinal()];
            this.makeWindowBlock(world, this.size - 1, 2, this.size / 2, rotation, sbb, realWindows);
            this.makeWindowBlock(world, this.size - 1, 3, this.size / 2, rotation, sbb, realWindows);
            this.makeWindowBase(world, this.size - 1, 1, this.size / 2, rotation, sbb);
            if (this.height > 8) {
                this.makeWindowBlock(world, this.size - 1, this.height - 3, this.size / 2, rotation, sbb, realWindows);
                this.makeWindowBlock(world, this.size - 1, this.height - 4, this.size / 2, rotation, sbb, realWindows);
                this.makeWindowBase(world, this.size - 1, this.height - 5, this.size / 2, rotation, sbb);
            }
        }
    }
    
    protected void makeWindowBlock(final ISeedReader world, final int x, final int y, final int z, final Rotation rotation, final MutableBoundingBox sbb, final boolean realWindows) {
        final Direction temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final Block outside = this.func_175807_a((IBlockReader)world, x + 1, y, z, sbb).func_177230_c();
        final Block inside = this.func_175807_a((IBlockReader)world, x - 1, y, z, sbb).func_177230_c();
        if (realWindows && inside == Blocks.field_150350_a && outside == Blocks.field_150350_a) {
            this.func_175811_a(world, Blocks.field_150410_aZ.func_176223_P(), x, y, z, sbb);
        }
        else {
            this.func_175811_a(world, Blocks.field_150347_e.func_176223_P(), x, y, z, sbb);
        }
        this.func_186164_a(temp);
    }
    
    protected void makeWindowBase(final ISeedReader world, final int x, final int y, final int z, final Rotation rotation, final MutableBoundingBox sbb) {
        final Direction temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final BlockState state = TFStructureHelper.stoneSlabDouble;
        this.func_175811_a(world, state, x, y, z, sbb);
        this.func_186164_a(temp);
    }
    
    protected boolean makeStairs(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        if (this.size == 15) {
            return this.makeStairs15(world, rand, sbb);
        }
        if (this.size == 9) {
            return this.makeStairs9(world, rand, sbb);
        }
        if (this.size == 7) {
            return this.makeStairs7(world, rand, sbb);
        }
        return this.size == 5 && this.makeStairs5(world, rand, sbb);
    }
    
    protected boolean makeStairs5(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        final int rise = 1;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs5flight(world, sbb, i * rise, this.getRotation(Rotation.NONE, i * 3), true);
        }
        return true;
    }
    
    protected void makeStairs5flight(final ISeedReader world, final MutableBoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final Direction temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final BlockState bottomSlab = useBirchWood ? TFStructureHelper.birchSlab : TFStructureHelper.stoneSlab;
        final BlockState topSlab = useBirchWood ? TFStructureHelper.birchSlabTop : TFStructureHelper.stoneSlabTop;
        this.func_175811_a(world, bottomSlab, 2, 1 + height, 3, sbb);
        this.func_175811_a(world, topSlab, 3, 1 + height, 3, sbb);
        this.func_186164_a(temp);
    }
    
    protected boolean makeStairs7(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        this.func_175811_a(world, TFStructureHelper.birchSlab, 1, 1, 4, sbb);
        this.func_175811_a(world, TFStructureHelper.birchSlabTop, 1, 1, 5, sbb);
        this.func_175811_a(world, TFStructureHelper.stoneSlab, 5, 1, 2, sbb);
        this.func_175811_a(world, TFStructureHelper.stoneSlabTop, 5, 1, 1, sbb);
        final int rise = 2;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs7flight(world, sbb, 1 + i * rise, this.getRotation(Rotation.NONE, i * 3), true);
            this.makeStairs7flight(world, sbb, 1 + i * rise, this.getRotation(Rotation.CLOCKWISE_180, i * 3), false);
        }
        return true;
    }
    
    protected void makeStairs7flight(final ISeedReader world, final MutableBoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final Direction temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final BlockState slabBottom = useBirchWood ? TFStructureHelper.birchSlab : TFStructureHelper.stoneSlab;
        final BlockState slabTop = useBirchWood ? TFStructureHelper.birchSlabTop : TFStructureHelper.stoneSlabTop;
        this.func_175811_a(world, slabBottom, 2, 1 + height, 5, sbb);
        this.func_175811_a(world, slabTop, 3, 1 + height, 5, sbb);
        this.func_175811_a(world, slabBottom, 4, 2 + height, 5, sbb);
        this.func_175811_a(world, slabTop, 5, 2 + height, 5, sbb);
        this.func_186164_a(temp);
    }
    
    protected boolean makeStairs9(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        this.func_175811_a(world, TFStructureHelper.birchSlab, 1, 1, 6, sbb);
        this.func_175811_a(world, TFStructureHelper.birchSlabTop, 1, 1, 7, sbb);
        this.func_175811_a(world, TFStructureHelper.stoneSlab, 7, 1, 2, sbb);
        this.func_175811_a(world, TFStructureHelper.stoneSlabTop, 7, 1, 1, sbb);
        final int rise = 3;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs9flight(world, sbb, 1 + i * rise, this.getRotation(Rotation.NONE, i * 3), true);
            this.makeStairs9flight(world, sbb, 1 + i * rise, this.getRotation(Rotation.CLOCKWISE_180, i * 3), false);
        }
        return true;
    }
    
    protected void makeStairs9flight(final ISeedReader world, final MutableBoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final Direction temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final BlockState slabBot = useBirchWood ? TFStructureHelper.birchSlab : TFStructureHelper.stoneSlab;
        final BlockState slabTop = useBirchWood ? TFStructureHelper.birchSlabTop : TFStructureHelper.stoneSlabTop;
        this.func_175811_a(world, slabBot, 2, 1 + height, 7, sbb);
        this.func_175811_a(world, slabTop, 3, 1 + height, 7, sbb);
        this.func_175811_a(world, slabBot, 4, 2 + height, 7, sbb);
        this.func_175811_a(world, slabTop, 5, 2 + height, 7, sbb);
        this.func_175811_a(world, slabBot, 6, 3 + height, 7, sbb);
        this.func_175811_a(world, slabTop, 7, 3 + height, 7, sbb);
        this.func_186164_a(temp);
    }
    
    protected boolean makeStairs15(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        final BlockState planks = Blocks.field_196666_p.func_176223_P();
        final BlockState oakFence = Blocks.field_180407_aO.func_176223_P();
        final BlockState birchSlab = TFStructureHelper.birchSlab;
        final BlockState stoneSlab = TFStructureHelper.stoneSlab;
        final BlockState doubleStoneSlab = TFStructureHelper.stoneSlabDouble;
        this.func_175811_a(world, birchSlab, 1, 1, 9, sbb);
        this.func_175811_a(world, birchSlab, 2, 1, 9, sbb);
        this.func_175811_a(world, planks, 1, 1, 10, sbb);
        this.func_175811_a(world, planks, 2, 1, 10, sbb);
        this.func_175811_a(world, birchSlab, 1, 2, 11, sbb);
        this.func_175811_a(world, birchSlab, 2, 2, 11, sbb);
        this.func_175811_a(world, planks, 1, 2, 12, sbb);
        this.func_175811_a(world, planks, 2, 2, 12, sbb);
        this.func_175811_a(world, planks, 1, 2, 13, sbb);
        this.func_175811_a(world, planks, 2, 2, 13, sbb);
        this.func_175811_a(world, planks, 3, 2, 11, sbb);
        this.func_175811_a(world, oakFence, 3, 3, 11, sbb);
        this.func_175811_a(world, oakFence, 3, 4, 11, sbb);
        this.func_175811_a(world, planks, 3, 1, 10, sbb);
        this.func_175811_a(world, oakFence, 3, 2, 10, sbb);
        this.func_175811_a(world, oakFence, 3, 3, 10, sbb);
        this.func_175811_a(world, planks, 3, 1, 9, sbb);
        this.func_175811_a(world, oakFence, 3, 2, 9, sbb);
        this.func_175811_a(world, stoneSlab, 13, 1, 5, sbb);
        this.func_175811_a(world, stoneSlab, 12, 1, 5, sbb);
        this.func_175811_a(world, doubleStoneSlab, 13, 1, 4, sbb);
        this.func_175811_a(world, doubleStoneSlab, 12, 1, 4, sbb);
        this.func_175811_a(world, stoneSlab, 13, 2, 3, sbb);
        this.func_175811_a(world, stoneSlab, 12, 2, 3, sbb);
        this.func_175811_a(world, doubleStoneSlab, 13, 2, 2, sbb);
        this.func_175811_a(world, doubleStoneSlab, 12, 2, 2, sbb);
        this.func_175811_a(world, doubleStoneSlab, 13, 2, 1, sbb);
        this.func_175811_a(world, doubleStoneSlab, 12, 2, 1, sbb);
        this.func_175811_a(world, doubleStoneSlab, 11, 2, 3, sbb);
        this.func_175811_a(world, oakFence, 11, 3, 3, sbb);
        this.func_175811_a(world, oakFence, 11, 4, 3, sbb);
        this.func_175811_a(world, doubleStoneSlab, 11, 1, 4, sbb);
        this.func_175811_a(world, oakFence, 11, 2, 4, sbb);
        this.func_175811_a(world, oakFence, 11, 3, 4, sbb);
        this.func_175811_a(world, doubleStoneSlab, 11, 1, 5, sbb);
        this.func_175811_a(world, oakFence, 11, 2, 5, sbb);
        final int rise = 5;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs15flight(world, rand, sbb, 2 + i * rise, this.getRotation(Rotation.NONE, i * 3), true);
            this.makeStairs15flight(world, rand, sbb, 2 + i * rise, this.getRotation(Rotation.CLOCKWISE_180, i * 3), false);
        }
        return true;
    }
    
    private Rotation getRotation(final Rotation startRotation, final int rotations) {
        final int totalIncrements = startRotation.ordinal() + rotations;
        return RotationUtil.ROTATIONS[totalIncrements & 0x3];
    }
    
    protected void makeStairs15flight(final ISeedReader world, final Random rand, final MutableBoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final Direction temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final BlockState oakFence = Blocks.field_180407_aO.func_176223_P();
        final BlockState slabBot = useBirchWood ? TFStructureHelper.birchSlab : TFStructureHelper.stoneSlab;
        final BlockState slabTop = useBirchWood ? TFStructureHelper.birchSlabTop : TFStructureHelper.stoneSlabTop;
        final BlockState slabDoub = useBirchWood ? TFStructureHelper.birchPlanks : TFStructureHelper.stoneSlabDouble;
        this.func_175811_a(world, slabBot, 3, 1 + height, 13, sbb);
        this.func_175809_a(world, sbb, rand, 0.9f, 4, 1 + height, 13, slabTop);
        this.func_175811_a(world, slabBot, 5, 2 + height, 13, sbb);
        this.func_175811_a(world, slabTop, 6, 2 + height, 13, sbb);
        this.func_175811_a(world, slabBot, 7, 3 + height, 13, sbb);
        this.func_175811_a(world, slabTop, 8, 3 + height, 13, sbb);
        this.func_175811_a(world, slabBot, 9, 4 + height, 13, sbb);
        this.func_175809_a(world, sbb, rand, 0.9f, 10, 4 + height, 13, slabTop);
        this.func_175809_a(world, sbb, rand, 0.9f, 11, 5 + height, 13, slabBot);
        this.func_175811_a(world, slabTop, 12, 5 + height, 13, sbb);
        this.func_175811_a(world, slabTop, 13, 5 + height, 13, sbb);
        this.func_175809_a(world, sbb, rand, 0.9f, 3, 1 + height, 12, slabBot);
        this.func_175811_a(world, slabTop, 4, 1 + height, 12, sbb);
        this.func_175811_a(world, slabBot, 5, 2 + height, 12, sbb);
        this.func_175811_a(world, slabTop, 6, 2 + height, 12, sbb);
        this.func_175809_a(world, sbb, rand, 0.9f, 7, 3 + height, 12, slabBot);
        this.func_175811_a(world, slabTop, 8, 3 + height, 12, sbb);
        this.func_175811_a(world, slabBot, 9, 4 + height, 12, sbb);
        this.func_175809_a(world, sbb, rand, 0.9f, 10, 4 + height, 12, slabTop);
        this.func_175811_a(world, slabBot, 11, 5 + height, 12, sbb);
        this.func_175811_a(world, slabTop, 12, 5 + height, 12, sbb);
        this.func_175811_a(world, slabTop, 13, 5 + height, 12, sbb);
        this.func_175811_a(world, slabDoub, 4, 1 + height, 11, sbb);
        this.func_175811_a(world, slabDoub, 5, 2 + height, 11, sbb);
        this.func_175809_a(world, sbb, rand, 0.9f, 6, 2 + height, 11, slabTop);
        this.func_175811_a(world, slabDoub, 7, 3 + height, 11, sbb);
        this.func_175809_a(world, sbb, rand, 0.9f, 8, 3 + height, 11, slabTop);
        this.func_175811_a(world, slabDoub, 9, 4 + height, 11, sbb);
        this.func_175811_a(world, slabTop, 10, 4 + height, 11, sbb);
        this.func_175811_a(world, slabDoub, 11, 5 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 4, 2 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 5, 3 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 6, 3 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 7, 4 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 8, 4 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 9, 5 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 10, 5 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 11, 6 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 4, 3 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 6, 4 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 8, 5 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 10, 6 + height, 11, sbb);
        this.func_175811_a(world, oakFence, 11, 7 + height, 11, sbb);
        this.func_186164_a(temp);
    }
    
    protected void generatePaintingsOnWall(final ISeedReader world, final Random rand, final int howMany, final int floorLevel, final Direction direction, final int minSize, final MutableBoundingBox sbb) {
        for (int i = 0; i < howMany; ++i) {
            final BlockPos pCoords = this.getRandomWallSpot(rand, floorLevel, direction, sbb);
            final PaintingType art = this.getPaintingOfSize(rand, minSize);
            final PaintingEntity painting = new PaintingEntity(EntityType.field_200782_V, (World)world.func_201672_e());
            try {
                TowerWingComponent.handle_HangingEntity_updateFacingWithBoundingBox.invoke(painting, direction);
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            painting.field_70522_e = art;
            painting.func_70107_b((double)pCoords.func_177958_n(), (double)pCoords.func_177956_o(), (double)pCoords.func_177952_p());
            if (this.checkPainting(world, painting)) {
                world.func_217376_c((Entity)painting);
            }
        }
    }
    
    protected PaintingType getPaintingOfSize(final Random rand, final int minSize) {
        final ArrayList<PaintingType> valid = new ArrayList<PaintingType>();
        for (final PaintingType art : ForgeRegistries.PAINTING_TYPES) {
            if (art.func_200834_b() >= minSize || art.func_200832_c() >= minSize) {
                valid.add(art);
            }
        }
        if (valid.size() > 0) {
            return valid.get(rand.nextInt(valid.size()));
        }
        return null;
    }
    
    protected boolean checkPainting(final ISeedReader world, final PaintingEntity painting) {
        if (painting == null) {
            return false;
        }
        final AxisAlignedBB largerBox = painting.func_174813_aQ();
        if (!world.func_226665_a__((Entity)painting, largerBox)) {
            return false;
        }
        final List<Entity> collidingEntities = this.getEntitiesInAABB(world, largerBox);
        for (final Entity entityOnList : collidingEntities) {
            if (entityOnList instanceof HangingEntity) {
                return false;
            }
        }
        return true;
    }
    
    public List<Entity> getEntitiesInAABB(final ISeedReader world, final AxisAlignedBB boundingBox) {
        final List<Entity> list = Lists.newArrayList();
        final int i = MathHelper.func_76128_c((boundingBox.field_72340_a - 2.0) / 16.0);
        final int j = MathHelper.func_76128_c((boundingBox.field_72336_d + 2.0) / 16.0);
        final int k = MathHelper.func_76128_c((boundingBox.field_72339_c - 2.0) / 16.0);
        final int l = MathHelper.func_76128_c((boundingBox.field_72334_f + 2.0) / 16.0);
        for (int i2 = i; i2 <= j; ++i2) {
            for (int j2 = k; j2 <= l; ++j2) {
                final IChunk chunk = world.func_217348_a(i2, j2, ChunkStatus.field_222606_b);
                if (chunk instanceof ChunkPrimer) {
                    ((ChunkPrimer)chunk).func_201652_l().forEach(nbt -> {
                        final Entity entity = EntityType.func_220335_a(nbt, (World)world.func_201672_e(), e -> e);
                        if (entity != null && boundingBox.func_72326_a(entity.func_174813_aQ())) {
                            list.add(entity);
                        }
                        return;
                    });
                }
            }
        }
        return list;
    }
    
    protected BlockPos getRandomWallSpot(final Random rand, final int floorLevel, final Direction direction, final MutableBoundingBox sbb) {
        int minX = this.field_74887_e.field_78897_a + 2;
        int maxX = this.field_74887_e.field_78893_d - 2;
        final int minY = this.field_74887_e.field_78895_b + floorLevel + 2;
        final int maxY = this.field_74887_e.field_78894_e - 2;
        int minZ = this.field_74887_e.field_78896_c + 2;
        int maxZ = this.field_74887_e.field_78892_f - 2;
        if (direction == Direction.SOUTH) {
            minZ = this.field_74887_e.field_78896_c;
            maxZ = this.field_74887_e.field_78896_c;
        }
        else if (direction == Direction.WEST) {
            maxX = this.field_74887_e.field_78893_d;
            minX = this.field_74887_e.field_78893_d;
        }
        else if (direction == Direction.NORTH) {
            maxZ = this.field_74887_e.field_78892_f;
            minZ = this.field_74887_e.field_78892_f;
        }
        else if (direction == Direction.EAST) {
            minX = this.field_74887_e.field_78897_a;
            maxX = this.field_74887_e.field_78897_a;
        }
        for (int i = 0; i < 30; ++i) {
            final int cx = minX + ((maxX > minX) ? rand.nextInt(maxX - minX) : 0);
            final int cy = minY + ((maxY > minY) ? rand.nextInt(maxY - minY) : 0);
            final int cz = minZ + ((maxZ > minZ) ? rand.nextInt(maxZ - minZ) : 0);
            final BlockPos blockPos = new BlockPos(cx, cy, cz).func_177972_a(direction);
            if (sbb.func_175898_b((Vector3i)blockPos)) {
                return blockPos;
            }
        }
        TwilightForestMod.LOGGER.info("ComponentTFTowerWing#getRandomWallSpot - We didn't find a valid random spot on the wall.");
        return null;
    }
    
    protected void makeGlyphBranches(final ISeedReader world, final Random rand, final BlockState colour, final MutableBoundingBox sbb) {
        final Rotation rotation = RotationUtil.ROTATIONS[rand.nextInt(4)];
        final int startHeight = rand.nextInt((int)(this.height * 0.66f));
        final int startZ = 3 + rand.nextInt(this.size - 6);
        final int dx = this.getXWithOffsetRotated(0, startZ, rotation);
        final int dz = this.getZWithOffsetRotated(0, startZ, rotation);
        if (sbb.func_175898_b((Vector3i)new BlockPos(dx, this.field_74887_e.field_78895_b + 1, dz))) {
            for (int dy = this.func_74862_a(startHeight); dy > 0; --dy) {
                final BlockPos pos = new BlockPos(dx, dy, dz);
                if (!(world.func_180495_p(pos).func_177230_c() instanceof CastleBlock)) {
                    break;
                }
                world.func_180501_a(pos, colour, 2);
            }
        }
        final int leftOffset = startZ - (1 + rand.nextInt(3));
        final int leftHeight = rand.nextInt(this.height - startHeight);
        if (leftOffset >= 0) {
            for (int z = startZ; z > leftOffset; --z) {
                this.setBlockStateRotated(world, colour, 0, startHeight, z, rotation, sbb);
            }
            for (int y = startHeight; y < startHeight + leftHeight; ++y) {
                this.setBlockStateRotated(world, colour, 0, y, leftOffset, rotation, sbb);
            }
        }
        final int rightOffset = startZ + (1 + rand.nextInt(3));
        final int rightHeight = rand.nextInt(this.height - startHeight);
        if (rightOffset < this.size - 1) {
            for (int z2 = startZ; z2 < rightOffset; ++z2) {
                this.setBlockStateRotated(world, colour, 0, startHeight, z2, rotation, sbb);
            }
            for (int y2 = startHeight; y2 < startHeight + rightHeight; ++y2) {
                this.setBlockStateRotated(world, colour, 0, y2, rightOffset, rotation, sbb);
            }
        }
    }
    
    static {
        LOOKUP = MethodHandles.lookup();
        HangingEntity_updateFacingWithBoundingBox = ObfuscationReflectionHelper.findMethod((Class)HangingEntity.class, "func_174859_a", new Class[] { Direction.class });
        MethodHandle tmp_handle_HangingEntity_updateFacingWithBoundingBox = null;
        try {
            tmp_handle_HangingEntity_updateFacingWithBoundingBox = TowerWingComponent.LOOKUP.unreflect(TowerWingComponent.HangingEntity_updateFacingWithBoundingBox);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        handle_HangingEntity_updateFacingWithBoundingBox = tmp_handle_HangingEntity_updateFacingWithBoundingBox;
    }
}
