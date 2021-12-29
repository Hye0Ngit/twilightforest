// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import twilightforest.block.CastleBlock;
import twilightforest.TwilightForestMod;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ProtoChunk;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.util.Mth;
import com.google.common.collect.Lists;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.VineBlock;
import twilightforest.entity.TFEntities;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.StairBlock;
import java.util.List;
import net.minecraft.world.entity.EntityType;
import twilightforest.util.TFStructureHelper;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.LadderBlock;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.util.RotationUtil;
import net.minecraft.world.level.block.Rotation;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import java.util.Iterator;
import java.nio.IntBuffer;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import java.util.ArrayList;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.lang.invoke.MethodHandles;
import twilightforest.world.components.structures.TFStructureComponentOld;

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
    
    public TowerWingComponent(final ServerLevel level, final CompoundTag nbt) {
        this(LichTowerPieces.TFLTWin, nbt);
    }
    
    public TowerWingComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.openings = new ArrayList<BlockPos>();
        this.openingTowards = new boolean[] { false, false, true, false };
        this.size = nbt.m_128451_("towerSize");
        this.height = nbt.m_128451_("towerHeight");
        this.readOpeningsFromArray(nbt.m_128465_("doorInts"));
        this.highestOpening = nbt.m_128451_("highestOpening");
        this.openingTowards[0] = nbt.m_128471_("openingTowards0");
        this.openingTowards[1] = nbt.m_128471_("openingTowards1");
        this.openingTowards[2] = nbt.m_128471_("openingTowards2");
        this.openingTowards[3] = nbt.m_128471_("openingTowards3");
    }
    
    protected TowerWingComponent(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z) {
        super(type, feature, i, x, y, z);
        this.openings = new ArrayList<BlockPos>();
        this.openingTowards = new boolean[] { false, false, true, false };
        this.highestOpening = 0;
    }
    
    protected TowerWingComponent(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(type, feature, i, x, y, z);
        this.openings = new ArrayList<BlockPos>();
        this.openingTowards = new boolean[] { false, false, true, false };
        this.size = pSize;
        this.height = pHeight;
        this.m_73519_(direction);
        this.highestOpening = 0;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    private int[] getDoorsAsIntArray() {
        final IntBuffer ibuffer = IntBuffer.allocate(this.openings.size() * 3);
        for (final BlockPos door : this.openings) {
            ibuffer.put(door.m_123341_());
            ibuffer.put(door.m_123342_());
            ibuffer.put(door.m_123343_());
        }
        return ibuffer.array();
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("towerSize", this.size);
        tagCompound.m_128405_("towerHeight", this.height);
        tagCompound.m_128385_("doorInts", this.getDoorsAsIntArray());
        tagCompound.m_128405_("highestOpening", this.highestOpening);
        tagCompound.m_128379_("openingTowards0", this.openingTowards[0]);
        tagCompound.m_128379_("openingTowards1", this.openingTowards[1]);
        tagCompound.m_128379_("openingTowards2", this.openingTowards[2]);
        tagCompound.m_128379_("openingTowards3", this.openingTowards[3]);
    }
    
    private void readOpeningsFromArray(final int[] intArray) {
        for (int i = 0; i < intArray.length; i += 3) {
            final BlockPos door = new BlockPos(intArray[i], intArray[i + 1], intArray[i + 2]);
            this.openings.add(door);
        }
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
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
    
    public boolean makeTowerWing(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        if (wingHeight < 6) {
            return false;
        }
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (rand.nextInt(6) == 0) {
            return this.makeBridge(list, rand, index, x, y, z, wingSize, wingHeight, rotation);
        }
        final TowerWingComponent wing = new TowerWingComponent(LichTowerPieces.TFLTWin, this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructurePiece intersect = list.m_141921_(wing.f_73383_);
        if (intersect == null || intersect == this) {
            list.m_142679_((StructurePiece)wing);
            wing.m_142537_(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return rand.nextInt(3) > 0 && this.makeBridge(list, rand, index, x, y, z, wingSize, wingHeight, rotation);
    }
    
    protected boolean makeBridge(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 3, direction);
        if (wingSize == 3 && wingHeight > 10) {
            wingHeight = 6 + rand.nextInt(5);
        }
        final TowerBridgeComponent bridge = new TowerBridgeComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        StructurePiece intersect = list.m_141921_(bridge.f_73383_);
        if (intersect != null && intersect != this) {
            return false;
        }
        intersect = list.m_141921_(bridge.getWingBB());
        if (intersect == null || intersect == this) {
            list.m_142679_((StructurePiece)bridge);
            bridge.m_142537_(this, list, rand);
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
        this.addOpening(dx, dy, dz, RotationUtil.getRelativeRotation(this.m_73549_(), facing));
    }
    
    public void makeABeard(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        final boolean attached = parent.m_73547_().m_162396_() < this.f_73383_.m_162396_();
        final int index = this.m_73548_();
        TowerBeardComponent beard;
        if (attached) {
            beard = new TowerBeardAttachedComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        }
        else {
            beard = new TowerBeardComponent(LichTowerPieces.TFLTBea, this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        }
        list.m_142679_((StructurePiece)beard);
        beard.m_142537_((StructurePiece)this, list, rand);
    }
    
    public void makeARoof(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        final boolean attached = parent.m_73547_().m_162400_() > this.f_73383_.m_162400_();
        if (attached) {
            this.makeAttachedRoof(list, rand);
        }
        else {
            this.makeFreestandingRoof(list, rand);
        }
    }
    
    protected void makeAttachedRoof(final StructurePieceAccessor list, final Random rand) {
        final int index = this.m_73548_();
        if (this.roofType == null && rand.nextInt(32) != 0) {
            this.tryToFitRoof(list, rand, new TowerRoofGableForwardsComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_()));
        }
        if (this.roofType == null && rand.nextInt(8) != 0) {
            this.tryToFitRoof(list, rand, new TowerRoofSlabForwardsComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_()));
        }
        if (this.roofType == null && rand.nextInt(32) != 0) {
            final TowerRoofComponent roof = new TowerRoofAttachedSlabComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final TowerRoofComponent roof = new TowerRoofFenceComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            this.tryToFitRoof(list, rand, roof);
        }
    }
    
    protected void tryToFitRoof(final StructurePieceAccessor list, final Random rand, final TowerRoofComponent roof) {
        if (roof.fits(this, list)) {
            list.m_142679_((StructurePiece)roof);
            roof.m_142537_((StructurePiece)this, list, rand);
            this.roofType = roof.getClass();
        }
    }
    
    protected void makeFreestandingRoof(final StructurePieceAccessor list, final Random rand) {
        final int index = this.m_73548_();
        if (this.roofType == null && rand.nextInt(8) != 0) {
            final TowerRoofComponent roof = new TowerRoofPointyOverhangComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final TowerRoofComponent roof = new TowerRoofStairsOverhangComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final TowerRoofComponent roof = new TowerRoofStairsComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null && rand.nextInt(53) != 0) {
            final TowerRoofComponent roof = new TowerRoofSlabComponent(LichTowerPieces.TFLTRS, this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final TowerRoofComponent roof = new TowerRoofFenceComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            this.tryToFitRoof(list, rand, roof);
        }
    }
    
    public boolean m_7832_(final WorldGenLevel worldIn, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73464_(worldIn, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, TFStructureComponentOld.getStrongholdStones());
        this.m_73535_(worldIn, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        if (this.highestOpening > 1) {
            this.makeStairs(worldIn, rand, sbb);
        }
        this.decorateThisTower(worldIn, sbb);
        this.makeWindows(worldIn, sbb, this.size < 4);
        this.makeOpenings(worldIn, sbb);
        return true;
    }
    
    protected void makeOpeningMarkers(final WorldGenLevel world, final Random rand, final int numMarkers, final BoundingBox sbb) {
        if (this.size > 4) {
            final BlockState woolWhite = Blocks.f_50041_.m_49966_();
            final BlockState woolOrange = Blocks.f_50042_.m_49966_();
            final BlockState woolMagenta = Blocks.f_50096_.m_49966_();
            final BlockState woolLightBlue = Blocks.f_50097_.m_49966_();
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, Rotation.NONE);
                this.m_73434_(world, woolWhite, spot[0], spot[1], spot[2], sbb);
            }
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, Rotation.CLOCKWISE_90);
                this.m_73434_(world, woolOrange, spot[0], spot[1], spot[2], sbb);
            }
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, Rotation.CLOCKWISE_180);
                this.m_73434_(world, woolMagenta, spot[0], spot[1], spot[2], sbb);
            }
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, Rotation.COUNTERCLOCKWISE_90);
                this.m_73434_(world, woolLightBlue, spot[0], spot[1], spot[2], sbb);
            }
        }
    }
    
    protected void decorateThisTower(final WorldGenLevel world, final BoundingBox sbb) {
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L * (this.f_73383_.m_162398_() * 756839L));
        if (this.size > 3) {
            if (this.isDeadEnd()) {
                this.decorateDeadEnd(world, decoRNG, sbb);
            }
            else {
                this.decorateStairTower(world, decoRNG, sbb);
            }
        }
    }
    
    protected void decorateDeadEnd(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        final BlockState birchPlanks = Blocks.f_50742_.m_49966_();
        final int floors = (this.height - 1) / 5;
        final int floorHeight = this.height / floors;
        for (int i = 1; i < floors; ++i) {
            for (int x = 1; x < this.size - 1; ++x) {
                for (int z = 1; z < this.size - 1; ++z) {
                    this.m_73434_(world, birchPlanks, x, i * floorHeight, z, sbb);
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
                ladderDir = ladderDir.m_55952_(Rotation.CLOCKWISE_90);
                this.decorateFloor(world, rand, j, bottom, top, ladderDir, downLadderDir, sbb);
            }
            this.decorateFloor(world, rand, floors, 1 + floorHeight * (floors - 1), this.height - 1, null, ladderDir, sbb);
        }
        else {
            this.decorateFloor(world, rand, 0, 1, this.height - 1, null, null, sbb);
        }
    }
    
    protected void decorateFloor(final WorldGenLevel world, final Random rand, final int floor, final int bottom, final int top, @Nullable final Rotation ladderUpDir, @Nullable final Rotation ladderDownDir, final BoundingBox sbb) {
        final BlockState ladder = Blocks.f_50155_.m_49966_();
        if (ladderUpDir != null) {
            final BlockState ladderUp = (BlockState)ladder.m_61124_((Property)LadderBlock.f_54337_, (Comparable)ladderUpDir.m_55954_(Direction.EAST));
            final int dx = this.getLadderX(ladderUpDir);
            final int dz = this.getLadderZ(ladderUpDir);
            for (int dy = bottom; dy < top; ++dy) {
                this.m_73434_(world, ladderUp, dx, dy, dz, sbb);
            }
        }
        if (ladderDownDir != null) {
            final BlockState ladderDown = (BlockState)ladder.m_61124_((Property)LadderBlock.f_54337_, (Comparable)ladderDownDir.m_55954_(Direction.EAST));
            final int dx = this.getLadderX(ladderDownDir);
            final int dz = this.getLadderZ(ladderDownDir);
            for (int dy = bottom - 1; dy < bottom + 2; ++dy) {
                this.m_73434_(world, ladderDown, dx, dy, dz, sbb);
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
    
    protected void decorateWell(final WorldGenLevel world, final Random rand, final int bottom, final BoundingBox sbb) {
        final int cx = this.size / 2;
        final BlockState waterOrLava = (rand.nextInt(4) == 0) ? Blocks.f_49991_.m_49966_() : Blocks.f_49990_.m_49966_();
        if (this.size > 5) {
            final BlockState stoneBricks = Blocks.f_50222_.m_49966_();
            final BlockState stoneSlabs = TFStructureHelper.stoneSlab;
            this.m_73434_(world, stoneBricks, cx - 1, bottom, cx - 1, sbb);
            this.m_73434_(world, stoneSlabs, cx - 1, bottom + 1, cx - 1, sbb);
            this.m_73434_(world, stoneBricks, cx, bottom, cx - 1, sbb);
            this.m_73434_(world, stoneBricks, cx + 1, bottom, cx - 1, sbb);
            this.m_73434_(world, stoneSlabs, cx + 1, bottom + 1, cx - 1, sbb);
            this.m_73434_(world, stoneBricks, cx - 1, bottom, cx, sbb);
            this.m_73434_(world, waterOrLava, cx, bottom, cx, sbb);
            this.m_73434_(world, stoneBricks, cx + 1, bottom, cx, sbb);
            this.m_73434_(world, stoneBricks, cx - 1, bottom, cx + 1, sbb);
            this.m_73434_(world, stoneSlabs, cx - 1, bottom + 1, cx + 1, sbb);
            this.m_73434_(world, stoneBricks, cx, bottom, cx + 1, sbb);
            this.m_73434_(world, stoneBricks, cx + 1, bottom, cx + 1, sbb);
            this.m_73434_(world, stoneSlabs, cx + 1, bottom + 1, cx + 1, sbb);
        }
        this.m_73434_(world, waterOrLava, cx, bottom - 1, cx, sbb);
    }
    
    protected void decorateSkeletonRoom(final WorldGenLevel world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final BoundingBox sbb) {
        this.setSpawner(world, this.size / 2, bottom + 2, this.size / 2, sbb, (EntityType<?>)EntityType.f_20524_);
        final ArrayList<BlockPos> chainList = new ArrayList<BlockPos>();
        chainList.add(new BlockPos(this.size / 2, bottom + 2, this.size / 2));
        for (int i = 0; i < this.size + 2; ++i) {
            final BlockPos chain = new BlockPos(2 + rand.nextInt(this.size - 4), this.height - 2, 2 + rand.nextInt(this.size - 4));
            if (!this.chainCollides(chain, chainList)) {
                for (int dy = bottom; dy < top; ++dy) {
                    this.m_73434_(world, Blocks.f_50183_.m_49966_(), chain.m_123341_(), dy, chain.m_123343_(), sbb);
                }
                chainList.add(chain);
            }
        }
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                if ((dx == 1 || dx == this.size - 2 || dz == 1 || dz == this.size - 2) && !this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir)) {
                    this.m_73434_(world, Blocks.f_50033_.m_49966_(), dx, top - 1, dz, sbb);
                }
            }
        }
    }
    
    protected void decorateZombieRoom(final WorldGenLevel world, final Random rand, final int bottom, final Rotation ladderUpDir, final Rotation ladderDownDir, final BoundingBox sbb) {
        this.setSpawner(world, this.size / 2, bottom + 2, this.size / 2, sbb, (EntityType<?>)EntityType.f_20501_);
        final BlockState ironBars = Blocks.f_50183_.m_49966_();
        final BlockState soulSand = Blocks.f_50135_.m_49966_();
        final BlockState brownMushroom = Blocks.f_50072_.m_49966_();
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                if (!this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(5) == 0) {
                    this.m_73434_(world, brownMushroom, dx, bottom, dz, sbb);
                }
            }
        }
        final ArrayList<BlockPos> slabList = new ArrayList<BlockPos>();
        slabList.add(new BlockPos(this.size / 2, bottom + 2, this.size / 2));
        for (int i = 0; i < this.size - 1; ++i) {
            final BlockPos slab = new BlockPos(2 + rand.nextInt(this.size - 4), this.height - 2, 2 + rand.nextInt(this.size - 4));
            if (!this.chainCollides(slab, slabList)) {
                this.m_73434_(world, ironBars, slab.m_123341_(), bottom, slab.m_123343_(), sbb);
                this.m_73434_(world, TFStructureHelper.birchSlab, slab.m_123341_(), bottom + 1, slab.m_123343_(), sbb);
                this.m_73434_(world, soulSand, slab.m_123341_(), bottom + 2, slab.m_123343_(), sbb);
                slabList.add(slab);
            }
        }
    }
    
    protected void decorateCactusRoom(final WorldGenLevel world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final BoundingBox sbb) {
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                this.m_73434_(world, Blocks.f_49992_.m_49966_(), dx, bottom - 1, dz, sbb);
                if (!this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(4) == 0) {
                    this.m_73434_(world, Blocks.f_50036_.m_49966_(), dx, bottom, dz, sbb);
                }
            }
        }
        final ArrayList<BlockPos> cactusList = new ArrayList<BlockPos>();
        cactusList.add(new BlockPos(this.size / 2, bottom + 2, this.size / 2));
        for (int i = 0; i < this.size + 12; ++i) {
            final BlockPos cactus = new BlockPos(2 + rand.nextInt(this.size - 4), this.height - 2, 2 + rand.nextInt(this.size - 4));
            if (!this.chainCollides(cactus, cactusList)) {
                for (int dy = bottom; dy < top; ++dy) {
                    this.m_73434_(world, Blocks.f_50128_.m_49966_(), cactus.m_123341_(), dy, cactus.m_123343_(), sbb);
                }
                cactusList.add(cactus);
            }
        }
    }
    
    protected void decorateTreasureChest(final WorldGenLevel world, final int bottom, final int top, final BoundingBox sbb) {
        final int cx = this.size / 2;
        final BlockState stoneBrick = Blocks.f_50222_.m_49966_();
        final BlockState stoneBrickStairs = Blocks.f_50194_.m_49966_();
        final BlockState topStoneBrickStairs = (BlockState)stoneBrickStairs.m_61124_((Property)StairBlock.f_56842_, (Comparable)Half.TOP);
        this.m_73434_(world, stoneBrick, cx, bottom, cx, sbb);
        this.m_73434_(world, stoneBrick, cx, top - 1, cx, sbb);
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
        this.placeTreasureAtCurrentPosition(world, cx, bottom + 1, cx, TFTreasure.TOWER_ROOM, sbb);
    }
    
    protected void decorateSpiderWebs(final WorldGenLevel world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final BoundingBox sbb) {
        for (int dy = bottom; dy < top; ++dy) {
            final int chance = top - dy + 2;
            for (int dx = 1; dx <= this.size - 2; ++dx) {
                for (int dz = 1; dz <= this.size - 2; ++dz) {
                    if (!this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(chance) == 0) {
                        this.m_73434_(world, Blocks.f_50033_.m_49966_(), dx, dy, dz, sbb);
                    }
                }
            }
        }
        if (rand.nextInt(5) == 0) {
            EntityType entityType = switch (rand.nextInt(4)) {
                case 3 -> EntityType.f_20554_;
                case 2 -> TFEntities.SWARM_SPIDER;
                case 1 -> TFEntities.HEDGE_SPIDER;
                default -> EntityType.f_20479_;
            };
            final EntityType<?> spiderName = (EntityType<?>)entityType;
            this.setSpawner(world, this.size / 2, bottom + 2, this.size / 2, sbb, spiderName);
        }
        else {
            this.decorateFurniture(world, rand, bottom, this.size - 2, sbb);
        }
    }
    
    protected void decorateFurniture(final WorldGenLevel world, final Random rand, final int bottom, final int freeSpace, final BoundingBox sbb) {
        if (rand.nextInt(3) > 0) {
            this.m_73434_(world, Blocks.f_50132_.m_49966_(), this.size / 2, bottom, this.size / 2, sbb);
            this.m_73434_(world, Blocks.f_50167_.m_49966_(), this.size / 2, bottom + 1, this.size / 2, sbb);
        }
        final BlockState spruceStairs = Blocks.f_50269_.m_49966_();
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.m_73434_(world, (BlockState)spruceStairs.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.WEST), this.size / 2 + 1, bottom, this.size / 2, sbb);
        }
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.m_73434_(world, (BlockState)spruceStairs.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.NORTH), this.size / 2, bottom, this.size / 2 + 1, sbb);
        }
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.m_73434_(world, (BlockState)spruceStairs.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.EAST), this.size / 2 - 1, bottom, this.size / 2, sbb);
        }
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.m_73434_(world, (BlockState)spruceStairs.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.SOUTH), this.size / 2, bottom, this.size / 2 - 1, sbb);
        }
    }
    
    protected void decorateSolidRock(final WorldGenLevel world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final BoundingBox sbb) {
        for (int dy = bottom; dy < top; ++dy) {
            for (int dx = 1; dx <= this.size - 2; ++dx) {
                for (int dz = 1; dz <= this.size - 2; ++dz) {
                    if (!this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(9) != 0) {
                        this.m_73434_(world, Blocks.f_50069_.m_49966_(), dx, dy, dz, sbb);
                    }
                }
            }
        }
    }
    
    protected void decorateLibrary(final WorldGenLevel world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final BoundingBox sbb) {
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                for (int dy = bottom; dy < top - 1; ++dy) {
                    if ((dx == 1 || dx == this.size - 2 || dz == 1 || dz == this.size - 2) && !this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir)) {
                        this.m_73434_(world, Blocks.f_50078_.m_49966_(), dx, dy, dz, sbb);
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
    
    protected void decorateLibraryTreasure(final WorldGenLevel world, final Random rand, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final BoundingBox sbb) {
        switch (rand.nextInt(4)) {
            default: {
                if (!this.isLadderPos(2, 1, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, 2, top - 2, 1, TFTreasure.TOWER_LIBRARY, sbb);
                    break;
                }
            }
            case 1: {
                if (!this.isLadderPos(this.size - 2, 2, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, this.size - 2, top - 2, 2, TFTreasure.TOWER_LIBRARY, sbb);
                    break;
                }
            }
            case 2: {
                if (!this.isLadderPos(this.size - 3, this.size - 2, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, this.size - 3, top - 2, this.size - 2, TFTreasure.TOWER_LIBRARY, sbb);
                    break;
                }
            }
            case 3: {
                if (!this.isLadderPos(1, this.size - 3, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, 1, top - 2, this.size - 3, TFTreasure.TOWER_LIBRARY, sbb);
                    break;
                }
                break;
            }
        }
    }
    
    protected void decorateFullLibrary(final WorldGenLevel world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final BoundingBox sbb) {
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                for (int dy = bottom; dy < top; ++dy) {
                    if (((dx % 2 != 0 && ((dz >= dx && dz <= this.size - dx - 1) || (dz >= this.size - dx - 1 && dz <= dx))) || (dz % 2 != 0 && ((dx >= dz && dx <= this.size - dz - 1) || (dx >= this.size - dz - 1 && dx <= dz)))) && !this.isWindowPos(dx, dy, dz) && !this.isOpeningPos(dx, dy, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir)) {
                        this.m_73434_(world, Blocks.f_50078_.m_49966_(), dx, dy, dz, sbb);
                    }
                }
            }
        }
        if (rand.nextInt(2) == 0 && this.size > 5) {
            this.decorateLibraryTreasure(world, rand, top, ladderUpDir, ladderDownDir, sbb);
        }
    }
    
    protected void decorateTrap(final WorldGenLevel world, final int bottom, final int top, final BoundingBox sbb) {
        for (int dx = 2; dx <= this.size - 3; ++dx) {
            for (int dz = 2; dz <= this.size - 3; ++dz) {
                if (dx == 2 || dx == this.size - 3 || dz == 2 || dz == this.size - 3) {
                    this.m_73434_(world, Blocks.f_50077_.m_49966_(), dx, -1, dz, sbb);
                }
            }
        }
        for (int dy = bottom - 2; dy < top - 2; ++dy) {
            this.m_73434_(world, Blocks.f_50077_.m_49966_(), 1, dy, 1, sbb);
            this.m_73434_(world, Blocks.f_50077_.m_49966_(), 1, dy, this.size - 2, sbb);
            this.m_73434_(world, Blocks.f_50077_.m_49966_(), this.size - 2, dy, 1, sbb);
            this.m_73434_(world, Blocks.f_50077_.m_49966_(), this.size - 2, dy, this.size - 2, sbb);
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
            final BlockPos.MutableBlockPos inside = new BlockPos.MutableBlockPos(door.m_123341_(), door.m_123342_(), door.m_123343_());
            if (inside.m_123341_() == 0) {
                inside.m_122173_(Direction.EAST);
            }
            else if (inside.m_123341_() == this.size - 1) {
                inside.m_122173_(Direction.WEST);
            }
            else if (inside.m_123343_() == 0) {
                inside.m_122173_(Direction.SOUTH);
            }
            else if (inside.m_123343_() == this.size - 1) {
                inside.m_122173_(Direction.NORTH);
            }
            if (inside.m_123341_() == x && inside.m_123343_() == z && (inside.m_123342_() == y || inside.m_123342_() + 1 == y)) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean isLadderPos(final int x, final int z, final Rotation ladderUpDir, final Rotation ladderDownDir) {
        return (ladderUpDir != null && x == this.getLadderX(ladderUpDir) && z == this.getLadderZ(ladderUpDir)) || (ladderDownDir != null && x == this.getLadderX(ladderDownDir) && z == this.getLadderZ(ladderDownDir));
    }
    
    protected int getLadderX(final Rotation ladderDir) {
        return switch (ladderDir) {
            case NONE -> this.size - 2;
            case CLOCKWISE_90 -> this.size / 2 + 1;
            case CLOCKWISE_180 -> 1;
            case COUNTERCLOCKWISE_90 -> this.size / 2 - 1;
            default -> throw new IncompatibleClassChangeError();
        };
    }
    
    protected int getLadderZ(final Rotation ladderDir) {
        return switch (ladderDir) {
            case NONE -> this.size / 2 - 1;
            case CLOCKWISE_90 -> this.size - 2;
            case CLOCKWISE_180 -> this.size / 2 + 1;
            case COUNTERCLOCKWISE_90 -> 1;
            default -> throw new IncompatibleClassChangeError();
        };
    }
    
    protected void decorateStairTower(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        if (this.height - this.highestOpening > 8) {
            final int base = this.highestOpening + 3;
            final int floors = (this.height - base) / 5;
            final int floorHeight = (this.height - base) / floors;
            for (int i = 0; i < floors; ++i) {
                for (int x = 1; x < this.size - 1; ++x) {
                    for (int z = 1; z < this.size - 1; ++z) {
                        this.m_73434_(world, TFStructureHelper.birchPlanks, x, i * floorHeight + base, z, sbb);
                    }
                }
            }
            Rotation ladderDir = Rotation.NONE;
            final int dx = this.getLadderX(ladderDir);
            final int dz = this.getLadderZ(ladderDir);
            final BlockState defaultState = (BlockState)Blocks.f_50155_.m_49966_().m_61124_((Property)LadderBlock.f_54337_, (Comparable)ladderDir.m_55954_(Direction.EAST));
            for (int dy = 1; dy < 3; ++dy) {
                this.m_73434_(world, defaultState, dx, base - dy, dz, sbb);
            }
            for (int j = 0; j < floors - 1; ++j) {
                final int bottom = base + 1 + floorHeight * j;
                final int top = base + floorHeight * (j + 1);
                final Rotation downLadderDir = ladderDir;
                ladderDir = ladderDir.m_55952_(Rotation.CLOCKWISE_90);
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
    
    protected void decorateStairFloor(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        if (this.size > 5) {
            if (rand.nextInt(3) == 0) {
                this.decorateStairWell(world, rand, sbb);
            }
            else if (rand.nextInt(3) > 0 || this.size >= 15) {
                this.decoratePlanter(world, rand, sbb);
            }
        }
    }
    
    protected void decorateChandelier(final WorldGenLevel world, final Random rand, final int decoTop, final BoundingBox sbb) {
        if (decoTop < 8 || this.size < 8) {
            return;
        }
        final int cx = this.size / 2;
        final int cy = decoTop - rand.nextInt(decoTop - 7) - 2;
        final int cz = this.size / 2;
        final BlockState oakFence = Blocks.f_50132_.m_49966_();
        this.surroundBlockCardinal(world, oakFence, cx, cy, cz, sbb);
        this.surroundBlockCardinal(world, oakFence, cx, cy + 1, cz, sbb);
        for (int y = cy; y < decoTop - 1; ++y) {
            this.m_73434_(world, oakFence, cx, y, cz, sbb);
        }
    }
    
    protected void decorateHangingChains(final WorldGenLevel world, final Random rand, final int decoTop, final BoundingBox sbb) {
        final ArrayList<BlockPos> chainList = new ArrayList<BlockPos>();
        for (int i = 0; i < this.size + 2; ++i) {
            final int filled = (this.size < 15) ? 2 : 4;
            final BlockPos chain = new BlockPos(filled + rand.nextInt(this.size - filled * 2), decoTop - 2, filled + rand.nextInt(this.size - filled * 2));
            if (!this.chainCollides(chain, chainList)) {
                final int length = 1 + rand.nextInt(decoTop - 7);
                this.decorateOneChain(world, rand, chain.m_123341_(), decoTop, length, chain.m_123343_(), sbb);
                chainList.add(chain);
            }
        }
    }
    
    protected boolean chainCollides(final BlockPos coords, final List<BlockPos> list) {
        for (final BlockPos existing : list) {
            if (coords.m_123343_() == existing.m_123343_() && Math.abs(coords.m_123341_() - existing.m_123341_()) <= 1) {
                return true;
            }
            if (coords.m_123341_() == existing.m_123341_() && Math.abs(coords.m_123343_() - existing.m_123343_()) <= 1) {
                return true;
            }
        }
        return false;
    }
    
    protected void decorateOneChain(final WorldGenLevel world, final Random rand, final int dx, final int decoTop, final int length, final int dz, final BoundingBox sbb) {
        for (int y = 1; y <= length; ++y) {
            this.m_73434_(world, Blocks.f_50183_.m_49966_(), dx, decoTop - y - 1, dz, sbb);
        }
        BlockState blockState = switch (rand.nextInt(10)) {
            case 0 -> Blocks.f_50075_.m_49966_();
            case 1 -> Blocks.f_50078_.m_49966_();
            case 2 -> Blocks.f_50134_.m_49966_();
            case 3 -> Blocks.f_50135_.m_49966_();
            case 4 -> Blocks.f_50058_.m_49966_();
            case 5 -> Blocks.f_50060_.m_49966_();
            case 6 -> Blocks.f_50176_.m_49966_();
            default -> Blocks.f_50141_.m_49966_();
        };
        final BlockState ballBlock = blockState;
        this.m_73434_(world, ballBlock, dx, decoTop - length - 2, dz, sbb);
    }
    
    protected void decorateFloatingBooks(final WorldGenLevel world, final Random rand, final int decoTop, final BoundingBox sbb) {
        final ArrayList<BlockPos> shelfList = new ArrayList<BlockPos>();
        for (int i = 0; i < this.size + 2; ++i) {
            final int filled = (this.size < 15) ? 2 : 4;
            final BlockPos shelf = new BlockPos(filled + rand.nextInt(this.size - filled * 2), decoTop - 2, filled + rand.nextInt(this.size - filled * 2));
            if (!this.chainCollides(shelf, shelfList)) {
                int y;
                for (int bottom = 2 + rand.nextInt(decoTop - 7), top = y = rand.nextInt(bottom - 1) + 2; y <= bottom; ++y) {
                    this.m_73434_(world, Blocks.f_50078_.m_49966_(), shelf.m_123341_(), decoTop - y, shelf.m_123343_(), sbb);
                }
                shelfList.add(shelf);
            }
        }
    }
    
    protected void decorateFloatingVines(final WorldGenLevel world, final Random rand, final int decoTop, final BoundingBox sbb) {
        final BlockState mossyCobbleStone = Blocks.f_50079_.m_49966_();
        final BlockState vine = Blocks.f_50191_.m_49966_();
        final BlockState vineNorth = (BlockState)vine.m_61124_((Property)VineBlock.f_57834_, (Comparable)true);
        final BlockState vineSouth = (BlockState)vine.m_61124_((Property)VineBlock.f_57836_, (Comparable)true);
        final BlockState vineEast = (BlockState)vine.m_61124_((Property)VineBlock.f_57835_, (Comparable)true);
        final BlockState vineWest = (BlockState)vine.m_61124_((Property)VineBlock.f_57837_, (Comparable)true);
        final ArrayList<BlockPos> mossList = new ArrayList<BlockPos>();
        for (int i = 0; i < this.size + 2; ++i) {
            final int filled = (this.size < 15) ? 2 : 4;
            final BlockPos moss = new BlockPos(filled + rand.nextInt(this.size - filled * 2), decoTop - 2, filled + rand.nextInt(this.size - filled * 2));
            if (!this.chainCollides(moss, mossList)) {
                int y;
                for (int bottom = 2 + rand.nextInt(decoTop - 7), top = y = rand.nextInt(bottom - 1) + 2; y <= bottom; ++y) {
                    this.m_73434_(world, mossyCobbleStone, moss.m_123341_(), decoTop - y, moss.m_123343_(), sbb);
                    this.m_73434_(world, vineEast, moss.m_123341_() + 1, decoTop - y, moss.m_123343_(), sbb);
                    this.m_73434_(world, vineWest, moss.m_123341_() - 1, decoTop - y, moss.m_123343_(), sbb);
                    this.m_73434_(world, vineSouth, moss.m_123341_(), decoTop - y, moss.m_123343_() + 1, sbb);
                    this.m_73434_(world, vineNorth, moss.m_123341_(), decoTop - y, moss.m_123343_() - 1, sbb);
                }
                mossList.add(moss);
            }
        }
        for (int y2 = this.highestOpening + 3; y2 < decoTop - 1; ++y2) {
            for (int x = 1; x < this.size - 1; ++x) {
                if (rand.nextInt(3) == 0) {
                    this.m_73434_(world, vineSouth, x, y2, 1, sbb);
                }
                if (rand.nextInt(3) == 0) {
                    this.m_73434_(world, vineNorth, x, y2, this.size - 2, sbb);
                }
            }
            for (int z = 1; z < this.size - 1; ++z) {
                if (rand.nextInt(3) == 0) {
                    this.m_73434_(world, vineEast, 1, y2, z, sbb);
                }
                if (rand.nextInt(3) == 0) {
                    this.m_73434_(world, vineWest, this.size - 2, y2, z, sbb);
                }
            }
        }
    }
    
    protected void decoratePlanter(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        this.surroundBlockCardinal(world, TFStructureHelper.stoneSlab, cx, 1, cz, sbb);
        if (this.size > 7) {
            this.surroundBlockCorners(world, TFStructureHelper.stoneSlabDouble, cx, 1, cz, sbb);
        }
        this.m_73434_(world, Blocks.f_50440_.m_49966_(), cx, 1, cz, sbb);
        final int i = rand.nextInt(6);
        final boolean isTree = i > 4;
        final BlockState plant = isTree ? TFStructureHelper.randomSapling(i) : TFStructureHelper.randomMushroom(i);
        this.m_73434_(world, plant, cx, 2, cz, sbb);
        final BlockPos pos = this.getBlockPosWithOffset(cx, 2, cz);
        final BlockState whatHappened = this.m_73398_((BlockGetter)world, cx, 2, cz, sbb);
        if (whatHappened.m_60734_() == plant.m_60734_() || whatHappened.m_60734_() == Blocks.f_50016_) {
            this.m_73434_(world, Blocks.f_50276_.m_49966_(), cx, 2, cz, sbb);
        }
    }
    
    protected void decorateStairWell(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        final int cy = 1;
        final BlockState waterOrLava = (rand.nextInt(4) == 0) ? Blocks.f_49991_.m_49966_() : Blocks.f_49990_.m_49966_();
        final BlockState stoneSlab = Blocks.f_50405_.m_49966_();
        final BlockState stoneBrick = Blocks.f_50222_.m_49966_();
        if (this.size > 7) {
            this.m_73434_(world, stoneBrick, cx - 1, cy, cz - 1, sbb);
            this.m_73434_(world, stoneSlab, cx - 1, cy + 1, cz - 1, sbb);
            this.m_73434_(world, stoneBrick, cx, cy, cz - 1, sbb);
            this.m_73434_(world, stoneBrick, cx + 1, cy, cz - 1, sbb);
            this.m_73434_(world, stoneSlab, cx + 1, cy + 1, cz - 1, sbb);
            this.m_73434_(world, stoneBrick, cx - 1, cy, cz, sbb);
            this.m_73434_(world, waterOrLava, cx, cy, cz, sbb);
            this.m_73434_(world, stoneBrick, cx + 1, cy, cz, sbb);
            this.m_73434_(world, stoneBrick, cx - 1, cy, cz + 1, sbb);
            this.m_73434_(world, stoneSlab, cx - 1, cy + 1, cz + 1, sbb);
            this.m_73434_(world, stoneBrick, cx, cy, cz + 1, sbb);
            this.m_73434_(world, stoneBrick, cx + 1, cy, cz + 1, sbb);
            this.m_73434_(world, stoneSlab, cx + 1, cy + 1, cz + 1, sbb);
        }
        this.m_73434_(world, waterOrLava, cx, cy - 1, cz, sbb);
    }
    
    public boolean isDeadEnd() {
        return this.openings.size() == 1;
    }
    
    protected void makeOpenings(final WorldGenLevel world, final BoundingBox sbb) {
        for (final BlockPos door : this.openings) {
            this.makeDoorOpening(world, door.m_123341_(), door.m_123342_(), door.m_123343_(), sbb);
        }
    }
    
    protected void makeDoorOpening(final WorldGenLevel world, final int dx, final int dy, final int dz, final BoundingBox sbb) {
        this.m_73434_(world, TowerWingComponent.AIR, dx, dy, dz, sbb);
        this.m_73434_(world, TowerWingComponent.AIR, dx, dy + 1, dz, sbb);
        if (this.m_73398_((BlockGetter)world, dx, dy + 2, dz, sbb).m_60734_() != Blocks.f_50016_) {
            final BlockState state = TFStructureHelper.stoneSlabDouble;
            this.m_73434_(world, state, dx, dy + 2, dz, sbb);
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
            int n = switch (direction) {
                case NONE -> 3;
                case CLOCKWISE_90 -> 2;
                case CLOCKWISE_180 -> 5;
                case COUNTERCLOCKWISE_90 -> 4;
                default -> throw new IncompatibleClassChangeError();
            };
            base = n;
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
    
    protected void makeWindows(final WorldGenLevel world, final BoundingBox sbb, final boolean real) {
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
    
    protected void makeWindowBlock(final WorldGenLevel world, final int x, final int y, final int z, final Rotation rotation, final BoundingBox sbb, final boolean realWindows) {
        final Direction temp = this.m_73549_();
        this.m_73519_(rotation.m_55954_(temp));
        final Block outside = this.m_73398_((BlockGetter)world, x + 1, y, z, sbb).m_60734_();
        final Block inside = this.m_73398_((BlockGetter)world, x - 1, y, z, sbb).m_60734_();
        if (realWindows && inside == Blocks.f_50016_ && outside == Blocks.f_50016_) {
            this.m_73434_(world, Blocks.f_50185_.m_49966_(), x, y, z, sbb);
        }
        else {
            this.m_73434_(world, Blocks.f_50652_.m_49966_(), x, y, z, sbb);
        }
        this.m_73519_(temp);
    }
    
    protected void makeWindowBase(final WorldGenLevel world, final int x, final int y, final int z, final Rotation rotation, final BoundingBox sbb) {
        final Direction temp = this.m_73549_();
        this.m_73519_(rotation.m_55954_(temp));
        final BlockState state = TFStructureHelper.stoneSlabDouble;
        this.m_73434_(world, state, x, y, z, sbb);
        this.m_73519_(temp);
    }
    
    protected boolean makeStairs(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
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
    
    protected boolean makeStairs5(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        final int rise = 1;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs5flight(world, sbb, i * rise, this.getRotation(Rotation.NONE, i * 3), true);
        }
        return true;
    }
    
    protected void makeStairs5flight(final WorldGenLevel world, final BoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final Direction temp = this.m_73549_();
        this.m_73519_(rotation.m_55954_(temp));
        final BlockState bottomSlab = useBirchWood ? TFStructureHelper.birchSlab : TFStructureHelper.stoneSlab;
        final BlockState topSlab = useBirchWood ? TFStructureHelper.birchSlabTop : TFStructureHelper.stoneSlabTop;
        this.m_73434_(world, bottomSlab, 2, 1 + height, 3, sbb);
        this.m_73434_(world, topSlab, 3, 1 + height, 3, sbb);
        this.m_73519_(temp);
    }
    
    protected boolean makeStairs7(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        this.m_73434_(world, TFStructureHelper.birchSlab, 1, 1, 4, sbb);
        this.m_73434_(world, TFStructureHelper.birchSlabTop, 1, 1, 5, sbb);
        this.m_73434_(world, TFStructureHelper.stoneSlab, 5, 1, 2, sbb);
        this.m_73434_(world, TFStructureHelper.stoneSlabTop, 5, 1, 1, sbb);
        final int rise = 2;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs7flight(world, sbb, 1 + i * rise, this.getRotation(Rotation.NONE, i * 3), true);
            this.makeStairs7flight(world, sbb, 1 + i * rise, this.getRotation(Rotation.CLOCKWISE_180, i * 3), false);
        }
        return true;
    }
    
    protected void makeStairs7flight(final WorldGenLevel world, final BoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final Direction temp = this.m_73549_();
        this.m_73519_(rotation.m_55954_(temp));
        final BlockState slabBottom = useBirchWood ? TFStructureHelper.birchSlab : TFStructureHelper.stoneSlab;
        final BlockState slabTop = useBirchWood ? TFStructureHelper.birchSlabTop : TFStructureHelper.stoneSlabTop;
        this.m_73434_(world, slabBottom, 2, 1 + height, 5, sbb);
        this.m_73434_(world, slabTop, 3, 1 + height, 5, sbb);
        this.m_73434_(world, slabBottom, 4, 2 + height, 5, sbb);
        this.m_73434_(world, slabTop, 5, 2 + height, 5, sbb);
        this.m_73519_(temp);
    }
    
    protected boolean makeStairs9(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        this.m_73434_(world, TFStructureHelper.birchSlab, 1, 1, 6, sbb);
        this.m_73434_(world, TFStructureHelper.birchSlabTop, 1, 1, 7, sbb);
        this.m_73434_(world, TFStructureHelper.stoneSlab, 7, 1, 2, sbb);
        this.m_73434_(world, TFStructureHelper.stoneSlabTop, 7, 1, 1, sbb);
        final int rise = 3;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs9flight(world, sbb, 1 + i * rise, this.getRotation(Rotation.NONE, i * 3), true);
            this.makeStairs9flight(world, sbb, 1 + i * rise, this.getRotation(Rotation.CLOCKWISE_180, i * 3), false);
        }
        return true;
    }
    
    protected void makeStairs9flight(final WorldGenLevel world, final BoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final Direction temp = this.m_73549_();
        this.m_73519_(rotation.m_55954_(temp));
        final BlockState slabBot = useBirchWood ? TFStructureHelper.birchSlab : TFStructureHelper.stoneSlab;
        final BlockState slabTop = useBirchWood ? TFStructureHelper.birchSlabTop : TFStructureHelper.stoneSlabTop;
        this.m_73434_(world, slabBot, 2, 1 + height, 7, sbb);
        this.m_73434_(world, slabTop, 3, 1 + height, 7, sbb);
        this.m_73434_(world, slabBot, 4, 2 + height, 7, sbb);
        this.m_73434_(world, slabTop, 5, 2 + height, 7, sbb);
        this.m_73434_(world, slabBot, 6, 3 + height, 7, sbb);
        this.m_73434_(world, slabTop, 7, 3 + height, 7, sbb);
        this.m_73519_(temp);
    }
    
    protected boolean makeStairs15(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        final BlockState planks = Blocks.f_50742_.m_49966_();
        final BlockState oakFence = Blocks.f_50132_.m_49966_();
        final BlockState birchSlab = TFStructureHelper.birchSlab;
        final BlockState stoneSlab = TFStructureHelper.stoneSlab;
        final BlockState doubleStoneSlab = TFStructureHelper.stoneSlabDouble;
        this.m_73434_(world, birchSlab, 1, 1, 9, sbb);
        this.m_73434_(world, birchSlab, 2, 1, 9, sbb);
        this.m_73434_(world, planks, 1, 1, 10, sbb);
        this.m_73434_(world, planks, 2, 1, 10, sbb);
        this.m_73434_(world, birchSlab, 1, 2, 11, sbb);
        this.m_73434_(world, birchSlab, 2, 2, 11, sbb);
        this.m_73434_(world, planks, 1, 2, 12, sbb);
        this.m_73434_(world, planks, 2, 2, 12, sbb);
        this.m_73434_(world, planks, 1, 2, 13, sbb);
        this.m_73434_(world, planks, 2, 2, 13, sbb);
        this.m_73434_(world, planks, 3, 2, 11, sbb);
        this.m_73434_(world, oakFence, 3, 3, 11, sbb);
        this.m_73434_(world, oakFence, 3, 4, 11, sbb);
        this.m_73434_(world, planks, 3, 1, 10, sbb);
        this.m_73434_(world, oakFence, 3, 2, 10, sbb);
        this.m_73434_(world, oakFence, 3, 3, 10, sbb);
        this.m_73434_(world, planks, 3, 1, 9, sbb);
        this.m_73434_(world, oakFence, 3, 2, 9, sbb);
        this.m_73434_(world, stoneSlab, 13, 1, 5, sbb);
        this.m_73434_(world, stoneSlab, 12, 1, 5, sbb);
        this.m_73434_(world, doubleStoneSlab, 13, 1, 4, sbb);
        this.m_73434_(world, doubleStoneSlab, 12, 1, 4, sbb);
        this.m_73434_(world, stoneSlab, 13, 2, 3, sbb);
        this.m_73434_(world, stoneSlab, 12, 2, 3, sbb);
        this.m_73434_(world, doubleStoneSlab, 13, 2, 2, sbb);
        this.m_73434_(world, doubleStoneSlab, 12, 2, 2, sbb);
        this.m_73434_(world, doubleStoneSlab, 13, 2, 1, sbb);
        this.m_73434_(world, doubleStoneSlab, 12, 2, 1, sbb);
        this.m_73434_(world, doubleStoneSlab, 11, 2, 3, sbb);
        this.m_73434_(world, oakFence, 11, 3, 3, sbb);
        this.m_73434_(world, oakFence, 11, 4, 3, sbb);
        this.m_73434_(world, doubleStoneSlab, 11, 1, 4, sbb);
        this.m_73434_(world, oakFence, 11, 2, 4, sbb);
        this.m_73434_(world, oakFence, 11, 3, 4, sbb);
        this.m_73434_(world, doubleStoneSlab, 11, 1, 5, sbb);
        this.m_73434_(world, oakFence, 11, 2, 5, sbb);
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
    
    protected void makeStairs15flight(final WorldGenLevel world, final Random rand, final BoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final Direction temp = this.m_73549_();
        this.m_73519_(rotation.m_55954_(temp));
        final BlockState oakFence = Blocks.f_50132_.m_49966_();
        final BlockState slabBot = useBirchWood ? TFStructureHelper.birchSlab : TFStructureHelper.stoneSlab;
        final BlockState slabTop = useBirchWood ? TFStructureHelper.birchSlabTop : TFStructureHelper.stoneSlabTop;
        final BlockState slabDoub = useBirchWood ? TFStructureHelper.birchPlanks : TFStructureHelper.stoneSlabDouble;
        this.m_73434_(world, slabBot, 3, 1 + height, 13, sbb);
        this.m_73491_(world, sbb, rand, 0.9f, 4, 1 + height, 13, slabTop);
        this.m_73434_(world, slabBot, 5, 2 + height, 13, sbb);
        this.m_73434_(world, slabTop, 6, 2 + height, 13, sbb);
        this.m_73434_(world, slabBot, 7, 3 + height, 13, sbb);
        this.m_73434_(world, slabTop, 8, 3 + height, 13, sbb);
        this.m_73434_(world, slabBot, 9, 4 + height, 13, sbb);
        this.m_73491_(world, sbb, rand, 0.9f, 10, 4 + height, 13, slabTop);
        this.m_73491_(world, sbb, rand, 0.9f, 11, 5 + height, 13, slabBot);
        this.m_73434_(world, slabTop, 12, 5 + height, 13, sbb);
        this.m_73434_(world, slabTop, 13, 5 + height, 13, sbb);
        this.m_73491_(world, sbb, rand, 0.9f, 3, 1 + height, 12, slabBot);
        this.m_73434_(world, slabTop, 4, 1 + height, 12, sbb);
        this.m_73434_(world, slabBot, 5, 2 + height, 12, sbb);
        this.m_73434_(world, slabTop, 6, 2 + height, 12, sbb);
        this.m_73491_(world, sbb, rand, 0.9f, 7, 3 + height, 12, slabBot);
        this.m_73434_(world, slabTop, 8, 3 + height, 12, sbb);
        this.m_73434_(world, slabBot, 9, 4 + height, 12, sbb);
        this.m_73491_(world, sbb, rand, 0.9f, 10, 4 + height, 12, slabTop);
        this.m_73434_(world, slabBot, 11, 5 + height, 12, sbb);
        this.m_73434_(world, slabTop, 12, 5 + height, 12, sbb);
        this.m_73434_(world, slabTop, 13, 5 + height, 12, sbb);
        this.m_73434_(world, slabDoub, 4, 1 + height, 11, sbb);
        this.m_73434_(world, slabDoub, 5, 2 + height, 11, sbb);
        this.m_73491_(world, sbb, rand, 0.9f, 6, 2 + height, 11, slabTop);
        this.m_73434_(world, slabDoub, 7, 3 + height, 11, sbb);
        this.m_73491_(world, sbb, rand, 0.9f, 8, 3 + height, 11, slabTop);
        this.m_73434_(world, slabDoub, 9, 4 + height, 11, sbb);
        this.m_73434_(world, slabTop, 10, 4 + height, 11, sbb);
        this.m_73434_(world, slabDoub, 11, 5 + height, 11, sbb);
        this.m_73434_(world, oakFence, 4, 2 + height, 11, sbb);
        this.m_73434_(world, oakFence, 5, 3 + height, 11, sbb);
        this.m_73434_(world, oakFence, 6, 3 + height, 11, sbb);
        this.m_73434_(world, oakFence, 7, 4 + height, 11, sbb);
        this.m_73434_(world, oakFence, 8, 4 + height, 11, sbb);
        this.m_73434_(world, oakFence, 9, 5 + height, 11, sbb);
        this.m_73434_(world, oakFence, 10, 5 + height, 11, sbb);
        this.m_73434_(world, oakFence, 11, 6 + height, 11, sbb);
        this.m_73434_(world, oakFence, 4, 3 + height, 11, sbb);
        this.m_73434_(world, oakFence, 6, 4 + height, 11, sbb);
        this.m_73434_(world, oakFence, 8, 5 + height, 11, sbb);
        this.m_73434_(world, oakFence, 10, 6 + height, 11, sbb);
        this.m_73434_(world, oakFence, 11, 7 + height, 11, sbb);
        this.m_73519_(temp);
    }
    
    protected void generatePaintingsOnWall(final WorldGenLevel world, final Random rand, final int howMany, final int floorLevel, final Direction direction, final int minSize, final BoundingBox sbb) {
        for (int i = 0; i < howMany; ++i) {
            final BlockPos pCoords = this.getRandomWallSpot(rand, floorLevel, direction, sbb);
            final Motive art = this.getPaintingOfSize(rand, minSize);
            final Painting painting = new Painting(EntityType.f_20506_, (Level)world.m_6018_());
            try {
                TowerWingComponent.handle_HangingEntity_updateFacingWithBoundingBox.invoke(painting, direction);
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            painting.f_31902_ = art;
            painting.m_6034_((double)pCoords.m_123341_(), (double)pCoords.m_123342_(), (double)pCoords.m_123343_());
            if (this.checkPainting(world, painting)) {
                world.m_7967_((Entity)painting);
            }
        }
    }
    
    protected Motive getPaintingOfSize(final Random rand, final int minSize) {
        final ArrayList<Motive> valid = new ArrayList<Motive>();
        for (final Motive art : ForgeRegistries.PAINTING_TYPES) {
            if (art.m_31896_() >= minSize || art.m_31901_() >= minSize) {
                valid.add(art);
            }
        }
        if (valid.size() > 0) {
            return valid.get(rand.nextInt(valid.size()));
        }
        return null;
    }
    
    protected boolean checkPainting(final WorldGenLevel world, final Painting painting) {
        if (painting == null) {
            return false;
        }
        final AABB largerBox = painting.m_142469_();
        if (!world.m_45756_((Entity)painting, largerBox)) {
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
    
    public List<Entity> getEntitiesInAABB(final WorldGenLevel world, final AABB boundingBox) {
        final List<Entity> list = Lists.newArrayList();
        final int i = Mth.m_14107_((boundingBox.f_82288_ - 2.0) / 16.0);
        final int j = Mth.m_14107_((boundingBox.f_82291_ + 2.0) / 16.0);
        final int k = Mth.m_14107_((boundingBox.f_82290_ - 2.0) / 16.0);
        final int l = Mth.m_14107_((boundingBox.f_82293_ + 2.0) / 16.0);
        for (int i2 = i; i2 <= j; ++i2) {
            for (int j2 = k; j2 <= l; ++j2) {
                final ChunkAccess chunk = world.m_46819_(i2, j2, ChunkStatus.f_62315_);
                if (chunk instanceof final ProtoChunk protoChunk) {
                    protoChunk.m_63293_().forEach(nbt -> {
                        final Entity entity = EntityType.m_20645_(nbt, (Level)world.m_6018_(), e -> e);
                        if (entity != null && boundingBox.m_82381_(entity.m_142469_())) {
                            list.add(entity);
                        }
                        return;
                    });
                }
            }
        }
        return list;
    }
    
    protected BlockPos getRandomWallSpot(final Random rand, final int floorLevel, final Direction direction, final BoundingBox sbb) {
        int minX = this.f_73383_.m_162395_() + 2;
        int maxX = this.f_73383_.m_162399_() - 2;
        final int minY = this.f_73383_.m_162396_() + floorLevel + 2;
        final int maxY = this.f_73383_.m_162400_() - 2;
        int minZ = this.f_73383_.m_162398_() + 2;
        int maxZ = this.f_73383_.m_162401_() - 2;
        if (direction == Direction.SOUTH) {
            minZ = this.f_73383_.m_162398_();
            maxZ = this.f_73383_.m_162398_();
        }
        else if (direction == Direction.WEST) {
            maxX = this.f_73383_.m_162399_();
            minX = this.f_73383_.m_162399_();
        }
        else if (direction == Direction.NORTH) {
            maxZ = this.f_73383_.m_162401_();
            minZ = this.f_73383_.m_162401_();
        }
        else if (direction == Direction.EAST) {
            minX = this.f_73383_.m_162395_();
            maxX = this.f_73383_.m_162395_();
        }
        for (int i = 0; i < 30; ++i) {
            final int cx = minX + ((maxX > minX) ? rand.nextInt(maxX - minX) : 0);
            final int cy = minY + ((maxY > minY) ? rand.nextInt(maxY - minY) : 0);
            final int cz = minZ + ((maxZ > minZ) ? rand.nextInt(maxZ - minZ) : 0);
            final BlockPos blockPos = new BlockPos(cx, cy, cz).m_142300_(direction);
            if (sbb.m_71051_((Vec3i)blockPos)) {
                return blockPos;
            }
        }
        TwilightForestMod.LOGGER.info("ComponentTFTowerWing#getRandomWallSpot - We didn't find a valid random spot on the wall.");
        return null;
    }
    
    protected void makeGlyphBranches(final WorldGenLevel world, final Random rand, final BlockState colour, final BoundingBox sbb) {
        final Rotation rotation = RotationUtil.ROTATIONS[rand.nextInt(4)];
        final int startHeight = rand.nextInt((int)(this.height * 0.66f));
        final int startZ = 3 + rand.nextInt(this.size - 6);
        final int dx = this.getXWithOffsetRotated(0, startZ, rotation);
        final int dz = this.getZWithOffsetRotated(0, startZ, rotation);
        if (sbb.m_71051_((Vec3i)new BlockPos(dx, this.f_73383_.m_162396_() + 1, dz))) {
            for (int dy = this.m_73544_(startHeight); dy > 0; --dy) {
                final BlockPos pos = new BlockPos(dx, dy, dz);
                if (!(world.m_8055_(pos).m_60734_() instanceof CastleBlock)) {
                    break;
                }
                world.m_7731_(pos, colour, 2);
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
        HangingEntity_updateFacingWithBoundingBox = ObfuscationReflectionHelper.findMethod((Class)HangingEntity.class, "m_6022_", new Class[] { Direction.class });
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
