// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import twilightforest.block.BlockTFCastleMagic;
import twilightforest.block.TFBlocks;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockVine;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.util.ResourceLocation;
import twilightforest.util.TFEntityNames;
import twilightforest.loot.TFTreasure;
import net.minecraft.block.BlockStairs;
import twilightforest.util.VanillaEntityNames;
import net.minecraft.block.BlockStoneSlab;
import twilightforest.structures.StructureTFHelper;
import net.minecraft.block.BlockLadder;
import javax.annotation.Nullable;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import twilightforest.util.RotationUtil;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import java.util.Iterator;
import java.nio.IntBuffer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import net.minecraft.util.math.BlockPos;
import java.util.ArrayList;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFTowerWing extends StructureTFComponentOld
{
    public int size;
    protected int height;
    protected Class<? extends ComponentTFTowerRoof> roofType;
    protected ArrayList<BlockPos> openings;
    protected int highestOpening;
    protected boolean[] openingTowards;
    
    public ComponentTFTowerWing() {
        this.openings = new ArrayList<BlockPos>();
        this.openingTowards = new boolean[] { false, false, true, false };
    }
    
    protected ComponentTFTowerWing(final TFFeature feature, final int i) {
        super(feature, i);
        this.openings = new ArrayList<BlockPos>();
        this.openingTowards = new boolean[] { false, false, true, false };
        this.highestOpening = 0;
    }
    
    protected ComponentTFTowerWing(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i);
        this.openings = new ArrayList<BlockPos>();
        this.openingTowards = new boolean[] { false, false, true, false };
        this.size = pSize;
        this.height = pHeight;
        this.func_186164_a(direction);
        this.highestOpening = 0;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("towerSize", this.size);
        tagCompound.func_74768_a("towerHeight", this.height);
        tagCompound.func_74783_a("doorInts", this.getDoorsAsIntArray());
        tagCompound.func_74768_a("highestOpening", this.highestOpening);
        tagCompound.func_74757_a("openingTowards0", this.openingTowards[0]);
        tagCompound.func_74757_a("openingTowards1", this.openingTowards[1]);
        tagCompound.func_74757_a("openingTowards2", this.openingTowards[2]);
        tagCompound.func_74757_a("openingTowards3", this.openingTowards[3]);
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
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.size = tagCompound.func_74762_e("towerSize");
        this.height = tagCompound.func_74762_e("towerHeight");
        this.readOpeningsFromArray(tagCompound.func_74759_k("doorInts"));
        this.highestOpening = tagCompound.func_74762_e("highestOpening");
        this.openingTowards[0] = tagCompound.func_74767_n("openingTowards0");
        this.openingTowards[1] = tagCompound.func_74767_n("openingTowards1");
        this.openingTowards[2] = tagCompound.func_74767_n("openingTowards2");
        this.openingTowards[3] = tagCompound.func_74767_n("openingTowards3");
    }
    
    private void readOpeningsFromArray(final int[] intArray) {
        for (int i = 0; i < intArray.length; i += 3) {
            final BlockPos door = new BlockPos(intArray[i], intArray[i + 1], intArray[i + 2]);
            this.openings.add(door);
        }
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
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
    
    public boolean makeTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        if (wingHeight < 6) {
            return false;
        }
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (rand.nextInt(6) == 0) {
            return this.makeBridge(list, rand, index, x, y, z, wingSize, wingHeight, rotation);
        }
        final ComponentTFTowerWing wing = new ComponentTFTowerWing(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, wing.field_74887_e);
        if (intersect == null || intersect == this) {
            list.add(wing);
            wing.func_74861_a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return rand.nextInt(3) > 0 && this.makeBridge(list, rand, index, x, y, z, wingSize, wingHeight, rotation);
    }
    
    protected boolean makeBridge(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, int wingHeight, final Rotation rotation) {
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 3, direction);
        if (wingSize == 3 && wingHeight > 10) {
            wingHeight = 6 + rand.nextInt(5);
        }
        final ComponentTFTowerBridge bridge = new ComponentTFTowerBridge(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        StructureComponent intersect = StructureComponent.func_74883_a((List)list, bridge.field_74887_e);
        if (intersect != null && intersect != this) {
            return false;
        }
        intersect = StructureComponent.func_74883_a((List)list, bridge.getWingBB());
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
    
    public void addOpening(final int dx, final int dy, final int dz, final EnumFacing facing) {
        this.addOpening(dx, dy, dz, RotationUtil.getRelativeRotation(this.func_186165_e(), facing));
    }
    
    public void makeABeard(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final boolean attached = parent.func_74874_b().field_78895_b < this.field_74887_e.field_78895_b;
        final int index = this.func_74877_c();
        ComponentTFTowerBeard beard;
        if (attached) {
            beard = new ComponentTFTowerBeardAttached(this.getFeatureType(), index + 1, this);
        }
        else {
            beard = new ComponentTFTowerBeard(this.getFeatureType(), index + 1, this);
        }
        list.add(beard);
        beard.func_74861_a((StructureComponent)this, (List)list, rand);
    }
    
    public void makeARoof(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final boolean attached = parent.func_74874_b().field_78894_e > this.field_74887_e.field_78894_e;
        if (attached) {
            this.makeAttachedRoof(list, rand);
        }
        else {
            this.makeFreestandingRoof(list, rand);
        }
    }
    
    protected void makeAttachedRoof(final List<StructureComponent> list, final Random rand) {
        final int index = this.func_74877_c();
        if (this.roofType == null && rand.nextInt(32) != 0) {
            this.tryToFitRoof(list, rand, new ComponentTFTowerRoofGableForwards(this.getFeatureType(), index + 1, this));
        }
        if (this.roofType == null && rand.nextInt(8) != 0) {
            this.tryToFitRoof(list, rand, new ComponentTFTowerRoofSlabForwards(this.getFeatureType(), index + 1, this));
        }
        if (this.roofType == null && rand.nextInt(32) != 0) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofAttachedSlab(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofFence(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
    }
    
    protected void tryToFitRoof(final List<StructureComponent> list, final Random rand, final ComponentTFTowerRoof roof) {
        if (roof.fits(this, list, rand)) {
            list.add(roof);
            roof.func_74861_a((StructureComponent)this, (List)list, rand);
            this.roofType = roof.getClass();
        }
    }
    
    protected void makeFreestandingRoof(final List<StructureComponent> list, final Random rand) {
        final int index = this.func_74877_c();
        if (this.roofType == null && rand.nextInt(8) != 0) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofPointyOverhang(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofStairsOverhang(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofStairs(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null && rand.nextInt(53) != 0) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofSlab(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofFence(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74882_a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, StructureTFComponentOld.getStrongholdStones());
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.nullifySkyLightForBoundingBox(world);
        if (this.highestOpening > 1) {
            this.makeStairs(world, rand, sbb);
        }
        this.decorateThisTower(world, rand, sbb);
        this.makeWindows(world, rand, sbb, this.size < 4);
        this.makeOpenings(world, sbb);
        return true;
    }
    
    protected void makeOpeningMarkers(final World world, final Random rand, final int numMarkers, final StructureBoundingBox sbb) {
        if (this.size > 4) {
            final IBlockState woolWhite = Blocks.field_150325_L.func_176223_P().func_177226_a((IProperty)BlockColored.field_176581_a, (Comparable)EnumDyeColor.WHITE);
            final IBlockState woolOrange = Blocks.field_150325_L.func_176223_P().func_177226_a((IProperty)BlockColored.field_176581_a, (Comparable)EnumDyeColor.ORANGE);
            final IBlockState woolMagenta = Blocks.field_150325_L.func_176223_P().func_177226_a((IProperty)BlockColored.field_176581_a, (Comparable)EnumDyeColor.MAGENTA);
            final IBlockState woolLightBlue = Blocks.field_150325_L.func_176223_P().func_177226_a((IProperty)BlockColored.field_176581_a, (Comparable)EnumDyeColor.LIGHT_BLUE);
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
    
    protected void decorateThisTower(final World world, final Random rand, final StructureBoundingBox sbb) {
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
    
    protected void decorateDeadEnd(final World world, final Random rand, final StructureBoundingBox sbb) {
        final IBlockState birchPlanks = Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
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
    
    protected void decorateFloor(final World world, final Random rand, final int floor, final int bottom, final int top, @Nullable final Rotation ladderUpDir, @Nullable final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        final IBlockState ladder = Blocks.field_150468_ap.func_176223_P();
        if (ladderUpDir != null) {
            final IBlockState ladderUp = ladder.func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)ladderUpDir.func_185831_a(EnumFacing.EAST));
            final int dx = this.getLadderX(ladderUpDir);
            final int dz = this.getLadderZ(ladderUpDir);
            for (int dy = bottom; dy < top; ++dy) {
                this.func_175811_a(world, ladderUp, dx, dy, dz, sbb);
            }
        }
        if (ladderDownDir != null) {
            final IBlockState ladderDown = ladder.func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)ladderDownDir.func_185831_a(EnumFacing.EAST));
            final int dx = this.getLadderX(ladderDownDir);
            final int dz = this.getLadderZ(ladderDownDir);
            for (int dy = bottom - 1; dy < bottom + 2; ++dy) {
                this.func_175811_a(world, ladderDown, dx, dy, dz, sbb);
            }
        }
        if (rand.nextInt(7) == 0 && ladderDownDir == null) {
            this.decorateWell(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(7) == 0 && ladderDownDir == null) {
            this.decorateSkeletonRoom(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(6) == 0 && ladderDownDir == null) {
            this.decorateZombieRoom(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(5) == 0 && ladderDownDir == null) {
            this.decorateCactusRoom(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(4) == 0 && ladderDownDir != null) {
            this.decorateTreasureChest(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
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
    
    protected void decorateWell(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        final int cy = bottom;
        final IBlockState waterOrLava = (rand.nextInt(4) == 0) ? Blocks.field_150353_l.func_176223_P() : Blocks.field_150355_j.func_176223_P();
        if (this.size > 5) {
            final IBlockState stoneBricks = Blocks.field_150417_aV.func_176223_P();
            final IBlockState stoneSlabs = StructureTFHelper.stoneSlab.func_177226_a((IProperty)BlockStoneSlab.field_176556_M, (Comparable)BlockStoneSlab.EnumType.SMOOTHBRICK);
            this.func_175811_a(world, stoneBricks, cx - 1, cy + 0, cz - 1, sbb);
            this.func_175811_a(world, stoneSlabs, cx - 1, cy + 1, cz - 1, sbb);
            this.func_175811_a(world, stoneBricks, cx + 0, cy + 0, cz - 1, sbb);
            this.func_175811_a(world, stoneBricks, cx + 1, cy + 0, cz - 1, sbb);
            this.func_175811_a(world, stoneSlabs, cx + 1, cy + 1, cz - 1, sbb);
            this.func_175811_a(world, stoneBricks, cx - 1, cy + 0, cz + 0, sbb);
            this.func_175811_a(world, waterOrLava, cx + 0, cy + 0, cz + 0, sbb);
            this.func_175811_a(world, stoneBricks, cx + 1, cy + 0, cz + 0, sbb);
            this.func_175811_a(world, stoneBricks, cx - 1, cy + 0, cz + 1, sbb);
            this.func_175811_a(world, stoneSlabs, cx - 1, cy + 1, cz + 1, sbb);
            this.func_175811_a(world, stoneBricks, cx + 0, cy + 0, cz + 1, sbb);
            this.func_175811_a(world, stoneBricks, cx + 1, cy + 0, cz + 1, sbb);
            this.func_175811_a(world, stoneSlabs, cx + 1, cy + 1, cz + 1, sbb);
        }
        this.func_175811_a(world, waterOrLava, cx + 0, cy - 1, cz + 0, sbb);
    }
    
    protected void decorateSkeletonRoom(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        this.setSpawner(world, this.size / 2, bottom + 2, this.size / 2, sbb, VanillaEntityNames.SKELETON);
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
                    this.func_175811_a(world, Blocks.field_150321_G.func_176223_P(), dx, top - 1, dz, sbb);
                }
            }
        }
    }
    
    protected void decorateZombieRoom(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        this.setSpawner(world, this.size / 2, bottom + 2, this.size / 2, sbb, VanillaEntityNames.ZOMBIE);
        final IBlockState ironBars = Blocks.field_150411_aY.func_176223_P();
        final IBlockState soulSand = Blocks.field_150425_aM.func_176223_P();
        final IBlockState brownMushroom = Blocks.field_150338_P.func_176223_P();
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
                this.func_175811_a(world, ironBars, slab.func_177958_n(), bottom + 0, slab.func_177952_p(), sbb);
                this.func_175811_a(world, StructureTFHelper.birchSlab, slab.func_177958_n(), bottom + 1, slab.func_177952_p(), sbb);
                this.func_175811_a(world, soulSand, slab.func_177958_n(), bottom + 2, slab.func_177952_p(), sbb);
                slabList.add(slab);
            }
        }
    }
    
    protected void decorateCactusRoom(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                this.func_175811_a(world, Blocks.field_150354_m.func_176223_P(), dx, bottom - 1, dz, sbb);
                if (!this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(4) == 0) {
                    this.func_175811_a(world, Blocks.field_150330_I.func_176223_P(), dx, bottom, dz, sbb);
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
    
    protected void decorateTreasureChest(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        final IBlockState stoneBrick = Blocks.field_150417_aV.func_176223_P();
        final IBlockState stoneBrickStairs = Blocks.field_150390_bg.func_176223_P();
        final IBlockState topStoneBrickStairs = stoneBrickStairs.func_177226_a((IProperty)BlockStairs.field_176308_b, (Comparable)BlockStairs.EnumHalf.TOP);
        this.func_175811_a(world, stoneBrick, cx, bottom, cz, sbb);
        this.func_175811_a(world, stoneBrick, cx, top - 1, cz, sbb);
        if (this.size < 6) {
            this.surroundBlockCardinalRotated(world, stoneBrickStairs, cx, bottom, cz, sbb);
            this.surroundBlockCardinalRotated(world, topStoneBrickStairs, cx, top - 1, cz, sbb);
        }
        else {
            this.surroundBlockCardinalRotated(world, stoneBrickStairs, cx, bottom, cz, sbb);
            this.surroundBlockCorners(world, stoneBrick, cx, bottom, cz, sbb);
            for (int cy = bottom + 1; cy < top - 1; ++cy) {
                this.surroundBlockCorners(world, stoneBrick, cx, cy, cz, sbb);
            }
            this.surroundBlockCardinalRotated(world, topStoneBrickStairs, cx, top - 1, cz, sbb);
            this.surroundBlockCorners(world, stoneBrick, cx, top - 1, cz, sbb);
        }
        this.placeTreasureAtCurrentPosition(world, rand, cx, bottom + 1, cz, TFTreasure.tower_room, sbb);
    }
    
    protected void decorateSpiderWebs(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        for (int dy = bottom; dy < top; ++dy) {
            final int chance = top - dy + 2;
            for (int dx = 1; dx <= this.size - 2; ++dx) {
                for (int dz = 1; dz <= this.size - 2; ++dz) {
                    if (!this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(chance) == 0) {
                        this.func_175811_a(world, Blocks.field_150321_G.func_176223_P(), dx, dy, dz, sbb);
                    }
                }
            }
        }
        if (rand.nextInt(5) == 0) {
            ResourceLocation spiderName = null;
            switch (rand.nextInt(4)) {
                case 3: {
                    spiderName = VanillaEntityNames.CAVE_SPIDER;
                    break;
                }
                case 2: {
                    spiderName = TFEntityNames.SWARM_SPIDER;
                    break;
                }
                case 1: {
                    spiderName = TFEntityNames.HEDGE_SPIDER;
                    break;
                }
                default: {
                    spiderName = VanillaEntityNames.SPIDER;
                    break;
                }
            }
            this.setSpawner(world, this.size / 2, bottom + 2, this.size / 2, sbb, spiderName);
        }
        else {
            this.decorateFurniture(world, rand, bottom, this.size - 2, sbb);
        }
    }
    
    protected void decorateFurniture(final World world, final Random rand, final int bottom, final int freeSpace, final StructureBoundingBox sbb) {
        if (rand.nextInt(3) > 0) {
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), this.size / 2, bottom, this.size / 2, sbb);
            this.func_175811_a(world, Blocks.field_150452_aw.func_176223_P(), this.size / 2, bottom + 1, this.size / 2, sbb);
        }
        final IBlockState spruceStairs = Blocks.field_150485_bF.func_176223_P();
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.func_175811_a(world, spruceStairs.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.WEST), this.size / 2 + 1, bottom, this.size / 2, sbb);
        }
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.func_175811_a(world, spruceStairs.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.NORTH), this.size / 2, bottom, this.size / 2 + 1, sbb);
        }
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.func_175811_a(world, spruceStairs.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.EAST), this.size / 2 - 1, bottom, this.size / 2, sbb);
        }
        if (rand.nextInt(3) == 0 && freeSpace > 1) {
            this.func_175811_a(world, spruceStairs.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.SOUTH), this.size / 2, bottom, this.size / 2 - 1, sbb);
        }
    }
    
    protected void decorateSolidRock(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
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
    
    protected void decorateLibrary(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
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
            this.decorateLibraryTreasure(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        if (rand.nextInt(2) == 0 && this.size > 5) {
            this.decorateFurniture(world, rand, bottom, this.size - 2, sbb);
        }
    }
    
    protected void decorateLibraryTreasure(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        switch (rand.nextInt(4)) {
            default: {
                if (!this.isLadderPos(2, 1, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, rand, 2, top - 2, 1, TFTreasure.tower_library, sbb);
                    break;
                }
            }
            case 1: {
                if (!this.isLadderPos(this.size - 2, 2, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, rand, this.size - 2, top - 2, 2, TFTreasure.tower_library, sbb);
                    break;
                }
            }
            case 2: {
                if (!this.isLadderPos(this.size - 3, this.size - 2, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, rand, this.size - 3, top - 2, this.size - 2, TFTreasure.tower_library, sbb);
                    break;
                }
            }
            case 3: {
                if (!this.isLadderPos(1, this.size - 3, ladderUpDir, ladderDownDir)) {
                    this.placeTreasureAtCurrentPosition(world, rand, 1, top - 2, this.size - 3, TFTreasure.tower_library, sbb);
                    break;
                }
                break;
            }
        }
    }
    
    protected void decorateFullLibrary(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
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
            this.decorateLibraryTreasure(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
    }
    
    protected void decorateTrap(final World world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
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
            final BlockPos.MutableBlockPos inside = new BlockPos.MutableBlockPos(door);
            if (inside.func_177958_n() == 0) {
                inside.func_189536_c(EnumFacing.EAST);
            }
            else if (inside.func_177958_n() == this.size - 1) {
                inside.func_189536_c(EnumFacing.WEST);
            }
            else if (inside.func_177952_p() == 0) {
                inside.func_189536_c(EnumFacing.SOUTH);
            }
            else if (inside.func_177952_p() == this.size - 1) {
                inside.func_189536_c(EnumFacing.NORTH);
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
    
    protected void decorateStairTower(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.height - this.highestOpening > 8) {
            final int base = this.highestOpening + 3;
            final int floors = (this.height - base) / 5;
            final int floorHeight = (this.height - base) / floors;
            for (int i = 0; i < floors; ++i) {
                for (int x = 1; x < this.size - 1; ++x) {
                    for (int z = 1; z < this.size - 1; ++z) {
                        this.func_175811_a(world, StructureTFHelper.birchPlanks, x, i * floorHeight + base, z, sbb);
                    }
                }
            }
            Rotation ladderDir = Rotation.NONE;
            final int dx = this.getLadderX(ladderDir);
            final int dz = this.getLadderZ(ladderDir);
            final IBlockState defaultState = Blocks.field_150468_ap.func_176223_P().func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)ladderDir.func_185831_a(EnumFacing.EAST));
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
    
    protected void decorateStairFloor(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.size > 5) {
            if (rand.nextInt(3) == 0) {
                this.decorateStairWell(world, rand, sbb);
            }
            else if (rand.nextInt(3) > 0 || this.size >= 15) {
                this.decoratePlanter(world, rand, sbb);
            }
        }
    }
    
    protected void decorateChandelier(final World world, final Random rand, final int decoTop, final StructureBoundingBox sbb) {
        if (decoTop < 8 || this.size < 8) {
            return;
        }
        final int cx = this.size / 2;
        final int cy = decoTop - rand.nextInt(decoTop - 7) - 2;
        final int cz = this.size / 2;
        final IBlockState oakFence = Blocks.field_180407_aO.func_176223_P();
        this.surroundBlockCardinal(world, oakFence, cx, cy, cz, sbb);
        this.surroundBlockCardinal(world, oakFence, cx, cy + 1, cz, sbb);
        for (int y = cy; y < decoTop - 1; ++y) {
            this.func_175811_a(world, oakFence, cx, y, cz, sbb);
        }
    }
    
    protected void decorateHangingChains(final World world, final Random rand, final int decoTop, final StructureBoundingBox sbb) {
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
    
    protected void decorateOneChain(final World world, final Random rand, final int dx, final int decoTop, final int length, final int dz, final StructureBoundingBox sbb) {
        for (int y = 1; y <= length; ++y) {
            this.func_175811_a(world, Blocks.field_150411_aY.func_176223_P(), dx, decoTop - y - 1, dz, sbb);
        }
        IBlockState ballBlock = null;
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
                ballBlock = Blocks.field_150418_aU.func_176223_P().func_177226_a((IProperty)BlockSilverfish.field_176378_a, (Comparable)BlockSilverfish.EnumType.STONEBRICK);
                break;
            }
            default: {
                ballBlock = Blocks.field_150426_aN.func_176223_P();
                break;
            }
        }
        this.func_175811_a(world, ballBlock, dx, decoTop - length - 2, dz, sbb);
    }
    
    protected void decorateFloatingBooks(final World world, final Random rand, final int decoTop, final StructureBoundingBox sbb) {
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
    
    protected void decorateFloatingVines(final World world, final Random rand, final int decoTop, final StructureBoundingBox sbb) {
        final IBlockState mossyCobbleStone = Blocks.field_150341_Y.func_176223_P();
        final IBlockState vine = Blocks.field_150395_bd.func_176223_P();
        final IBlockState vineNorth = vine.func_177226_a((IProperty)BlockVine.field_176273_b, (Comparable)true);
        final IBlockState vineSouth = vine.func_177226_a((IProperty)BlockVine.field_176279_N, (Comparable)true);
        final IBlockState vineEast = vine.func_177226_a((IProperty)BlockVine.field_176278_M, (Comparable)true);
        final IBlockState vineWest = vine.func_177226_a((IProperty)BlockVine.field_176280_O, (Comparable)true);
        final ArrayList<BlockPos> mossList = new ArrayList<BlockPos>();
        for (int i = 0; i < this.size + 2; ++i) {
            final int filled = (this.size < 15) ? 2 : 4;
            final BlockPos moss = new BlockPos(filled + rand.nextInt(this.size - filled * 2), decoTop - 2, filled + rand.nextInt(this.size - filled * 2));
            if (!this.chainCollides(moss, mossList)) {
                int y;
                for (int bottom = 2 + rand.nextInt(decoTop - 7), top = y = rand.nextInt(bottom - 1) + 2; y <= bottom; ++y) {
                    this.func_175811_a(world, mossyCobbleStone, moss.func_177958_n(), decoTop - y, moss.func_177952_p(), sbb);
                    this.func_175811_a(world, vineEast, moss.func_177958_n() + 1, decoTop - y, moss.func_177952_p() + 0, sbb);
                    this.func_175811_a(world, vineWest, moss.func_177958_n() - 1, decoTop - y, moss.func_177952_p() + 0, sbb);
                    this.func_175811_a(world, vineSouth, moss.func_177958_n() + 0, decoTop - y, moss.func_177952_p() + 1, sbb);
                    this.func_175811_a(world, vineNorth, moss.func_177958_n() + 0, decoTop - y, moss.func_177952_p() - 1, sbb);
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
    
    protected void decoratePlanter(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        this.surroundBlockCardinal(world, StructureTFHelper.stoneSlab, cx, 1, cz, sbb);
        if (this.size > 7) {
            this.surroundBlockCorners(world, StructureTFHelper.stoneSlabDouble, cx, 1, cz, sbb);
        }
        this.func_175811_a(world, Blocks.field_150349_c.func_176223_P(), cx, 1, cz, sbb);
        final int i = rand.nextInt(6);
        final boolean isTree = i > 4;
        final IBlockState plant = isTree ? StructureTFHelper.randomSapling(i) : StructureTFHelper.randomMushroom(i);
        this.func_175811_a(world, plant, cx, 2, cz, sbb);
        final BlockPos pos = this.getBlockPosWithOffset(cx, 2, cz);
        if (isTree) {
            ((BlockSapling)Blocks.field_150345_g).func_176478_d(world, pos, plant, world.field_73012_v);
        }
        else {
            plant.func_177230_c().func_180650_b(world, pos, plant, world.field_73012_v);
        }
        final IBlockState whatHappened = this.func_175807_a(world, cx, 2, cz, sbb);
        if (whatHappened.func_177230_c() == plant.func_177230_c() || whatHappened.func_177230_c() == Blocks.field_150350_a) {
            this.func_175811_a(world, Blocks.field_150457_bL.func_176223_P(), cx, 2, cz, sbb);
        }
    }
    
    protected void decorateStairWell(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        final int cy = 1;
        final IBlockState waterOrLava = (rand.nextInt(4) == 0) ? Blocks.field_150353_l.func_176223_P() : Blocks.field_150355_j.func_176223_P();
        final IBlockState stoneSlab = Blocks.field_150333_U.func_176223_P().func_177226_a((IProperty)BlockStoneSlab.field_176556_M, (Comparable)BlockStoneSlab.EnumType.SMOOTHBRICK);
        final IBlockState stoneBrick = Blocks.field_150417_aV.func_176223_P();
        if (this.size > 7) {
            this.func_175811_a(world, stoneBrick, cx - 1, cy + 0, cz - 1, sbb);
            this.func_175811_a(world, stoneSlab, cx - 1, cy + 1, cz - 1, sbb);
            this.func_175811_a(world, stoneBrick, cx + 0, cy + 0, cz - 1, sbb);
            this.func_175811_a(world, stoneBrick, cx + 1, cy + 0, cz - 1, sbb);
            this.func_175811_a(world, stoneSlab, cx + 1, cy + 1, cz - 1, sbb);
            this.func_175811_a(world, stoneBrick, cx - 1, cy + 0, cz + 0, sbb);
            this.func_175811_a(world, waterOrLava, cx + 0, cy + 0, cz + 0, sbb);
            this.func_175811_a(world, stoneBrick, cx + 1, cy + 0, cz + 0, sbb);
            this.func_175811_a(world, stoneBrick, cx - 1, cy + 0, cz + 1, sbb);
            this.func_175811_a(world, stoneSlab, cx - 1, cy + 1, cz + 1, sbb);
            this.func_175811_a(world, stoneBrick, cx + 0, cy + 0, cz + 1, sbb);
            this.func_175811_a(world, stoneBrick, cx + 1, cy + 0, cz + 1, sbb);
            this.func_175811_a(world, stoneSlab, cx + 1, cy + 1, cz + 1, sbb);
        }
        this.func_175811_a(world, waterOrLava, cx + 0, cy - 1, cz + 0, sbb);
    }
    
    public boolean isDeadEnd() {
        return this.openings.size() == 1;
    }
    
    public boolean hasExitsOnAllWalls() {
        int exits = 0;
        for (int i = 0; i < 4; ++i) {
            exits += (this.openingTowards[i] ? 1 : 0);
        }
        return exits == 4;
    }
    
    public boolean hasStairs() {
        return this.highestOpening > 1;
    }
    
    protected void makeOpenings(final World world, final StructureBoundingBox sbb) {
        for (final BlockPos door : this.openings) {
            this.makeDoorOpening(world, door.func_177958_n(), door.func_177956_o(), door.func_177952_p(), sbb);
        }
    }
    
    protected void makeDoorOpening(final World world, final int dx, final int dy, final int dz, final StructureBoundingBox sbb) {
        this.func_175811_a(world, ComponentTFTowerWing.AIR, dx, dy + 0, dz, sbb);
        this.func_175811_a(world, ComponentTFTowerWing.AIR, dx, dy + 1, dz, sbb);
        if (this.func_175807_a(world, dx, dy + 2, dz, sbb).func_177230_c() != Blocks.field_150350_a) {
            final IBlockState state = StructureTFHelper.stoneSlabDouble;
            this.func_175811_a(world, state, dx, dy + 2, dz, sbb);
        }
        if (dx == 0) {
            this.updateLight(world, dx - 1, dy + 0, dz);
            this.updateLight(world, dx - 1, dy + 1, dz);
        }
        if (dx == this.size - 1) {
            this.updateLight(world, dx + 1, dy + 0, dz);
            this.updateLight(world, dx + 1, dy + 1, dz);
        }
        if (dz == 0) {
            this.updateLight(world, dx, dy + 0, dz - 1);
            this.updateLight(world, dx, dy + 1, dz - 1);
        }
        if (dz == this.size - 1) {
            this.updateLight(world, dx, dy + 0, dz + 1);
            this.updateLight(world, dx, dy + 1, dz + 1);
        }
    }
    
    protected void updateLight(final World world, final int dx, final int dy, final int dz) {
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
    
    protected void makeWindows(final World world, final Random rand, final StructureBoundingBox sbb, final boolean real) {
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
    
    protected void makeWindowBlock(final World world, final int x, final int y, final int z, final Rotation rotation, final StructureBoundingBox sbb, final boolean realWindows) {
        final EnumFacing temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final Block outside = this.func_175807_a(world, x + 1, y, z, sbb).func_177230_c();
        final Block inside = this.func_175807_a(world, x - 1, y, z, sbb).func_177230_c();
        if (realWindows && inside == Blocks.field_150350_a && outside == Blocks.field_150350_a) {
            this.func_175811_a(world, Blocks.field_150410_aZ.func_176223_P(), x, y, z, sbb);
        }
        else {
            this.func_175811_a(world, Blocks.field_150347_e.func_176223_P(), x, y, z, sbb);
        }
        this.func_186164_a(temp);
    }
    
    protected void makeWindowBase(final World world, final int x, final int y, final int z, final Rotation rotation, final StructureBoundingBox sbb) {
        final EnumFacing temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final IBlockState state = StructureTFHelper.stoneSlabDouble;
        this.func_175811_a(world, state, x, y, z, sbb);
        this.func_186164_a(temp);
    }
    
    protected boolean makeStairs(final World world, final Random rand, final StructureBoundingBox sbb) {
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
    
    protected boolean makeStairs5(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int rise = 1;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs5flight(world, rand, sbb, i * rise, this.getRotation(Rotation.NONE, i * 3), true);
        }
        return true;
    }
    
    protected void makeStairs5flight(final World world, final Random rand, final StructureBoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final EnumFacing temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final IBlockState bottomSlab = useBirchWood ? StructureTFHelper.birchSlab : StructureTFHelper.stoneSlab;
        final IBlockState topSlab = useBirchWood ? StructureTFHelper.birchSlabTop : StructureTFHelper.stoneSlabTop;
        this.func_175811_a(world, bottomSlab, 2, 1 + height, 3, sbb);
        this.func_175811_a(world, topSlab, 3, 1 + height, 3, sbb);
        this.func_186164_a(temp);
    }
    
    protected boolean makeStairs7(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175811_a(world, StructureTFHelper.birchSlab, 1, 1, 4, sbb);
        this.func_175811_a(world, StructureTFHelper.birchSlabTop, 1, 1, 5, sbb);
        this.func_175811_a(world, StructureTFHelper.stoneSlab, 5, 1, 2, sbb);
        this.func_175811_a(world, StructureTFHelper.stoneSlabTop, 5, 1, 1, sbb);
        final int rise = 2;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs7flight(world, rand, sbb, 1 + i * rise, this.getRotation(Rotation.NONE, i * 3), true);
            this.makeStairs7flight(world, rand, sbb, 1 + i * rise, this.getRotation(Rotation.CLOCKWISE_180, i * 3), false);
        }
        return true;
    }
    
    protected void makeStairs7flight(final World world, final Random rand, final StructureBoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final EnumFacing temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final IBlockState slabBottom = useBirchWood ? StructureTFHelper.birchSlab : StructureTFHelper.stoneSlab;
        final IBlockState slabTop = useBirchWood ? StructureTFHelper.birchSlabTop : StructureTFHelper.stoneSlabTop;
        this.func_175811_a(world, slabBottom, 2, 1 + height, 5, sbb);
        this.func_175811_a(world, slabTop, 3, 1 + height, 5, sbb);
        this.func_175811_a(world, slabBottom, 4, 2 + height, 5, sbb);
        this.func_175811_a(world, slabTop, 5, 2 + height, 5, sbb);
        this.func_186164_a(temp);
    }
    
    protected boolean makeStairs9(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175811_a(world, StructureTFHelper.birchSlab, 1, 1, 6, sbb);
        this.func_175811_a(world, StructureTFHelper.birchSlabTop, 1, 1, 7, sbb);
        this.func_175811_a(world, StructureTFHelper.stoneSlab, 7, 1, 2, sbb);
        this.func_175811_a(world, StructureTFHelper.stoneSlabTop, 7, 1, 1, sbb);
        final int rise = 3;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs9flight(world, rand, sbb, 1 + i * rise, this.getRotation(Rotation.NONE, i * 3), true);
            this.makeStairs9flight(world, rand, sbb, 1 + i * rise, this.getRotation(Rotation.CLOCKWISE_180, i * 3), false);
        }
        return true;
    }
    
    protected void makeStairs9flight(final World world, final Random rand, final StructureBoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final EnumFacing temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final IBlockState slabBot = useBirchWood ? StructureTFHelper.birchSlab : StructureTFHelper.stoneSlab;
        final IBlockState slabTop = useBirchWood ? StructureTFHelper.birchSlabTop : StructureTFHelper.stoneSlabTop;
        this.func_175811_a(world, slabBot, 2, 1 + height, 7, sbb);
        this.func_175811_a(world, slabTop, 3, 1 + height, 7, sbb);
        this.func_175811_a(world, slabBot, 4, 2 + height, 7, sbb);
        this.func_175811_a(world, slabTop, 5, 2 + height, 7, sbb);
        this.func_175811_a(world, slabBot, 6, 3 + height, 7, sbb);
        this.func_175811_a(world, slabTop, 7, 3 + height, 7, sbb);
        this.func_186164_a(temp);
    }
    
    protected boolean makeStairs15(final World world, final Random rand, final StructureBoundingBox sbb) {
        final IBlockState planks = Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        final IBlockState oakFence = Blocks.field_180407_aO.func_176223_P();
        final IBlockState birchSlab = StructureTFHelper.birchSlab;
        final IBlockState stoneSlab = StructureTFHelper.stoneSlab;
        final IBlockState doubleStoneSlab = StructureTFHelper.stoneSlabDouble;
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
    
    protected void makeStairs15flight(final World world, final Random rand, final StructureBoundingBox sbb, final int height, final Rotation rotation, final boolean useBirchWood) {
        final EnumFacing temp = this.func_186165_e();
        this.func_186164_a(rotation.func_185831_a(temp));
        final IBlockState oakFence = Blocks.field_180407_aO.func_176223_P();
        final IBlockState slabBot = useBirchWood ? StructureTFHelper.birchSlab : StructureTFHelper.stoneSlab;
        final IBlockState slabTop = useBirchWood ? StructureTFHelper.birchSlabTop : StructureTFHelper.stoneSlabTop;
        final IBlockState slabDoub = useBirchWood ? StructureTFHelper.birchPlanks : StructureTFHelper.stoneSlabDouble;
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
    
    protected void generatePaintingsOnWall(final World world, final Random rand, final int howMany, final int floorLevel, final EnumFacing direction, final int minSize, final StructureBoundingBox sbb) {
        for (int i = 0; i < howMany; ++i) {
            final BlockPos pCoords = this.getRandomWallSpot(rand, floorLevel, direction, sbb);
            final EntityPainting.EnumArt art = this.getPaintingOfSize(rand, minSize);
            final EntityPainting painting = new EntityPainting(world, pCoords, direction);
            painting.field_70522_e = art;
            painting.func_70107_b((double)pCoords.func_177958_n(), (double)pCoords.func_177956_o(), (double)pCoords.func_177952_p());
            if (this.checkPainting(world, painting, sbb)) {
                world.func_72838_d((Entity)painting);
            }
        }
    }
    
    protected EntityPainting.EnumArt getPaintingOfSize(final Random rand, final int minSize) {
        final ArrayList<EntityPainting.EnumArt> valid = new ArrayList<EntityPainting.EnumArt>();
        for (final EntityPainting.EnumArt art : EntityPainting.EnumArt.values()) {
            if (art.field_75703_B >= minSize || art.field_75704_C >= minSize) {
                valid.add(art);
            }
        }
        if (valid.size() > 0) {
            return valid.get(rand.nextInt(valid.size()));
        }
        return null;
    }
    
    protected boolean checkPainting(final World world, final EntityPainting painting, final StructureBoundingBox sbb) {
        if (painting == null) {
            return false;
        }
        final AxisAlignedBB largerBox = painting.func_174813_aQ();
        if (!world.func_184144_a((Entity)painting, largerBox).isEmpty()) {
            return false;
        }
        final List<Entity> collidingEntities = world.func_72839_b((Entity)painting, largerBox);
        for (final Entity entityOnList : collidingEntities) {
            if (entityOnList instanceof EntityHanging) {
                return false;
            }
        }
        return true;
    }
    
    protected BlockPos getRandomWallSpot(final Random rand, final int floorLevel, final EnumFacing direction, final StructureBoundingBox sbb) {
        int minX = this.field_74887_e.field_78897_a + 2;
        int maxX = this.field_74887_e.field_78893_d - 2;
        final int minY = this.field_74887_e.field_78895_b + floorLevel + 2;
        final int maxY = this.field_74887_e.field_78894_e - 2;
        int minZ = this.field_74887_e.field_78896_c + 2;
        int maxZ = this.field_74887_e.field_78892_f - 2;
        if (direction == EnumFacing.SOUTH) {
            minZ = this.field_74887_e.field_78896_c;
            maxZ = this.field_74887_e.field_78896_c;
        }
        else if (direction == EnumFacing.WEST) {
            maxX = this.field_74887_e.field_78893_d;
            minX = this.field_74887_e.field_78893_d;
        }
        else if (direction == EnumFacing.NORTH) {
            maxZ = this.field_74887_e.field_78892_f;
            minZ = this.field_74887_e.field_78892_f;
        }
        else if (direction == EnumFacing.EAST) {
            minX = this.field_74887_e.field_78897_a;
            maxX = this.field_74887_e.field_78897_a;
        }
        for (int i = 0; i < 30; ++i) {
            final int cx = minX + ((maxX > minX) ? rand.nextInt(maxX - minX) : 0);
            final int cy = minY + ((maxY > minY) ? rand.nextInt(maxY - minY) : 0);
            final int cz = minZ + ((maxZ > minZ) ? rand.nextInt(maxZ - minZ) : 0);
            final BlockPos blockPos = new BlockPos(cx, cy, cz).func_177972_a(direction);
            if (sbb.func_175898_b((Vec3i)blockPos)) {
                return blockPos;
            }
        }
        return null;
    }
    
    protected void makeGlyphBranches(final World world, final Random rand, final EnumDyeColor colour, final StructureBoundingBox sbb) {
        final Rotation rotation = RotationUtil.ROTATIONS[rand.nextInt(4)];
        final int startHeight = rand.nextInt((int)(this.height * 0.66f));
        final int startZ = 3 + rand.nextInt(this.size - 6);
        final IBlockState magicBlock = TFBlocks.castle_rune_brick.func_176223_P().func_177226_a((IProperty)BlockTFCastleMagic.COLOR, (Comparable)colour);
        final int dx = this.getXWithOffsetRotated(0, startZ, rotation);
        final int dz = this.getZWithOffsetRotated(0, startZ, rotation);
        if (sbb.func_175898_b((Vec3i)new BlockPos(dx, this.field_74887_e.field_78895_b + 1, dz))) {
            for (int dy = this.func_74862_a(startHeight); dy > 0; --dy) {
                final BlockPos pos = new BlockPos(dx, dy, dz);
                if (world.func_180495_p(pos).func_177230_c() != TFBlocks.castle_brick) {
                    break;
                }
                world.func_180501_a(pos, magicBlock, 2);
            }
        }
        final int leftOffset = startZ - (1 + rand.nextInt(3));
        final int leftHeight = rand.nextInt(this.height - startHeight);
        if (leftOffset >= 0) {
            for (int z = startZ; z > leftOffset; --z) {
                this.setBlockStateRotated(world, magicBlock, 0, startHeight, z, rotation, sbb);
            }
            for (int y = startHeight; y < startHeight + leftHeight; ++y) {
                this.setBlockStateRotated(world, magicBlock, 0, y, leftOffset, rotation, sbb);
            }
        }
        final int rightOffset = startZ + (1 + rand.nextInt(3));
        final int rightHeight = rand.nextInt(this.height - startHeight);
        if (rightOffset < this.size - 1) {
            for (int z2 = startZ; z2 < rightOffset; ++z2) {
                this.setBlockStateRotated(world, magicBlock, 0, startHeight, z2, rotation, sbb);
            }
            for (int y2 = startHeight; y2 < startHeight + rightHeight; ++y2) {
                this.setBlockStateRotated(world, magicBlock, 0, y2, rightOffset, rotation, sbb);
            }
        }
    }
}
