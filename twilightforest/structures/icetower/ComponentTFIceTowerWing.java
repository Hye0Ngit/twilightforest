// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import twilightforest.structures.lichtower.ComponentTFTowerRoof;
import java.util.Iterator;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import twilightforest.structures.StructureTFComponent;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFIceTowerWing extends ComponentTFTowerWing
{
    protected static final int SIZE = 11;
    private static final int RANGE = 17;
    boolean hasBase;
    
    public ComponentTFIceTowerWing() {
        this.hasBase = false;
    }
    
    protected ComponentTFIceTowerWing(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
        this.hasBase = false;
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74757_a("hasBase", this.hasBase);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.hasBase = par1NBTTagCompound.func_74767_n("hasBase");
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, 2);
        this.hasBase = this.shouldHaveBase(rand);
        if (this.func_74877_c() < 5) {
            final int dirOffset = rand.nextInt(4);
            for (int i = 0; i < 4; ++i) {
                final int dir = (dirOffset + i) % 4;
                final int[] dest = this.getValidOpening(rand, dir);
                if (this.func_74877_c() == 4 && parent instanceof ComponentTFIceTowerMain && !((ComponentTFIceTowerMain)parent).hasBossWing) {
                    final boolean hasBoss = this.makeBossTowerWing(list, rand, this.func_74877_c() + 1, dest[0], dest[1], dest[2], 15, 41, dir);
                    ((ComponentTFIceTowerMain)parent).hasBossWing = hasBoss;
                }
                else {
                    final int childHeight = (rand.nextInt(2) + rand.nextInt(2) + 2) * 10 + 1;
                    this.makeTowerWing(list, rand, this.func_74877_c() + 1, dest[0], dest[1], dest[2], 11, childHeight, dir);
                }
            }
        }
        this.makeARoof(parent, list, rand);
        if (!this.hasBase) {
            this.makeABeard(parent, list, rand);
        }
    }
    
    protected boolean shouldHaveBase(final Random rand) {
        return this.func_74877_c() == 0 || rand.nextBoolean();
    }
    
    private boolean isOutOfRange(final StructureComponent parent, final int nx, final int ny, final int nz, final int range) {
        return Math.abs(nx - parent.func_74874_b().func_78881_e()) > range || Math.abs(nz - parent.func_74874_b().func_78891_g()) > range;
    }
    
    @Override
    public boolean makeTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (this.isOutOfRange(list.get(0), dx[0], dx[1], dx[2], 17)) {
            return false;
        }
        final ComponentTFIceTowerWing wing = new ComponentTFIceTowerWing(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, wing.func_74874_b());
        if (intersect == null || intersect == this) {
            list.add(wing);
            wing.func_74861_a(list.get(0), list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    public boolean makeBossTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        final ComponentTFIceTowerWing wing = new ComponentTFIceTowerBossWing(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, wing.func_74874_b());
        if (intersect == null || intersect == this) {
            list.add(wing);
            wing.func_74861_a(list.get(0), list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    protected int getYByStairs(final int rx, final Random rand, final int direction) {
        final int floors = this.height / 10;
        return 11 + rand.nextInt(floors - 1) * 10;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.func_74882_a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, this.deco.randomBlocks);
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        if (this.hasBase) {
            for (int x = 0; x < this.size; ++x) {
                for (int z = 0; z < this.size; ++z) {
                    this.func_151554_b(world, this.deco.blockID, this.deco.blockMeta, x, -1, z, sbb);
                }
            }
        }
        this.nullifySkyLightForBoundingBox(world);
        this.makeFloorsForTower(world, decoRNG, sbb);
        this.makeOpenings(world, sbb);
        return true;
    }
    
    @Override
    public void nullifySkyLightForBoundingBox(final World world) {
        this.nullifySkyLight(world, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 1, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e - 1, this.field_74887_e.field_78892_f - 1);
    }
    
    protected void makeFloorsForTower(final World world, final Random decoRNG, final StructureBoundingBox sbb) {
        final int floors = this.height / 10;
        int ladderDir = 3;
        int downLadderDir = -1;
        final int floorHeight = 10;
        for (int i = 0; i < floors - 1; ++i) {
            this.placeFloor(world, decoRNG, sbb, floorHeight, i);
            downLadderDir = ladderDir;
            ladderDir = ++ladderDir % 4;
            this.decorateFloor(world, decoRNG, i, i * floorHeight, i * floorHeight + floorHeight, ladderDir, downLadderDir, sbb);
        }
        final int topFloor = floors - 1;
        this.decorateTopFloor(world, decoRNG, topFloor, topFloor * floorHeight, topFloor * floorHeight + floorHeight, ladderDir, downLadderDir, sbb);
    }
    
    protected void placeFloor(final World world, final Random rand, final StructureBoundingBox sbb, final int floorHeight, final int floor) {
        for (int x = 1; x < this.size - 1; ++x) {
            for (int z = 1; z < this.size - 1; ++z) {
                this.func_151550_a(world, this.deco.floorID, this.deco.floorMeta, x, floor * floorHeight + floorHeight, z, sbb);
            }
        }
    }
    
    @Override
    protected void makeDoorOpening(final World world, final int dx, final int dy, final int dz, final StructureBoundingBox sbb) {
        super.makeDoorOpening(world, dx, dy, dz, sbb);
        if (this.func_151548_a(world, dx, dy + 2, dz, sbb) != Blocks.field_150350_a) {
            this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, dx, dy + 2, dz, sbb);
        }
    }
    
    @Override
    protected void decorateFloor(final World world, final Random rand, final int floor, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        switch (rand.nextInt(8)) {
            case 0: {
                if (this.isNoDoorAreaRotated(9, bottom + 5, 1, 10, top + 1, 7, ladderUpDir)) {
                    this.decorateWraparoundWallSteps(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
                    break;
                }
            }
            case 1: {
                if (this.isNoDoorAreaRotated(7, bottom, 0, 10, top + 1, 10, ladderUpDir)) {
                    this.decorateFarWallSteps(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
                    break;
                }
            }
            case 2: {
                if (this.isNoDoorAreaRotated(9, bottom + 5, 1, 10, top + 1, 7, ladderUpDir)) {
                    this.decorateWraparoundWallStepsPillars(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
                    break;
                }
            }
            case 3: {
                this.decoratePlatform(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
                break;
            }
            case 4: {
                this.decoratePillarParkour(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
                break;
            }
            case 5: {
                this.decoratePillarPlatforms(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
                break;
            }
            case 6: {
                this.decoratePillarPlatformsOutside(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
                break;
            }
            default: {
                this.decorateQuadPillarStairs(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
                break;
            }
        }
    }
    
    private boolean isNoDoorAreaRotated(final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final int rotation) {
        boolean isClear = true;
        StructureBoundingBox exclusionBox = null;
        switch (rotation) {
            default: {
                exclusionBox = new StructureBoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
                break;
            }
            case 1: {
                exclusionBox = new StructureBoundingBox(this.size - 1 - maxZ, minY, minX, this.size - 1 - minZ, maxY, maxX);
                break;
            }
            case 2: {
                exclusionBox = new StructureBoundingBox(this.size - 1 - maxX, minY, this.size - 1 - maxZ, this.size - 1 - minX, maxY, this.size - 1 - minZ);
                break;
            }
            case 3: {
                exclusionBox = new StructureBoundingBox(minZ, minY, this.size - 1 - maxX, maxZ, maxY, this.size - 1 - minX);
                break;
            }
        }
        for (final ChunkCoordinates door : this.openings) {
            if (exclusionBox.func_78890_b(door.field_71574_a, door.field_71572_b, door.field_71573_c)) {
                isClear = false;
            }
        }
        return isClear;
    }
    
    protected void decorateTopFloor(final World world, final Random rand, final int floor, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        if (this.isDeadEnd()) {
            this.decorateTreasure(world, rand, bottom, top, ladderDownDir, sbb);
        }
        if (rand.nextBoolean()) {
            this.decoratePillarsCorners(world, rand, bottom, top, ladderDownDir, sbb);
        }
        else {
            this.decoratePillarsGrid(world, rand, bottom, top, ladderDownDir, sbb);
        }
    }
    
    private void decorateTreasure(final World world, final Random rand, final int bottom, final int top, final int ladderDownDir, final StructureBoundingBox sbb) {
        this.placeBlockRotated(world, Blocks.field_150447_bR, 0, 5, bottom + 1, 5, ladderDownDir, sbb);
    }
    
    private void decoratePillars(final World world, final Random rand, final int bottom, final int top, final int rotation, final StructureBoundingBox sbb) {
        this.fillBlocksRotated(world, sbb, 3, bottom + 1, 3, 3, top - 1, 3, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 1, 3, 7, top - 1, 3, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 1, 7, 3, top - 1, 7, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 1, 7, 7, top - 1, 7, this.deco.pillarID, this.deco.pillarMeta, rotation);
    }
    
    private void decoratePillarsGrid(final World world, final Random rand, final int bottom, final int top, final int rotation, final StructureBoundingBox sbb) {
        final int beamMetaNS = ((this.field_74885_f + rotation) % 2 == 0) ? 4 : 8;
        final int beamMetaEW = (beamMetaNS == 4) ? 8 : 4;
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 1, 3, bottom + 5, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 1, 7, bottom + 5, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 3, 9, bottom + 5, 3, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 7, 9, bottom + 5, 7, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.decoratePillars(world, rand, bottom, top, rotation, sbb);
    }
    
    private void decoratePillarsCorners(final World world, final Random rand, final int bottom, final int top, final int rotation, final StructureBoundingBox sbb) {
        final int beamMetaNS = ((this.field_74885_f + rotation) % 2 == 0) ? 4 : 8;
        final int beamMetaEW = (beamMetaNS == 4) ? 8 : 4;
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 1, 3, bottom + 5, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 1, 7, bottom + 5, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 3, 9, bottom + 5, 3, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 7, 9, bottom + 5, 7, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillAirRotated(world, sbb, 3, bottom + 5, 3, 7, bottom + 5, 7, rotation);
        this.decoratePillars(world, rand, bottom, top, rotation, sbb);
    }
    
    private void decorateFarWallSteps(final World world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        for (int z = 1; z < 10; ++z) {
            final int y = bottom + 10 - z / 2;
            this.placeBlockRotated(world, (z % 2 == 0) ? this.deco.pillarID : this.deco.platformID, (z % 2 == 0) ? this.deco.pillarMeta : this.deco.platformMeta, 9, y, z, ladderUpDir, sbb);
            for (int by = bottom + 1; by < y; ++by) {
                this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, 9, by, z, ladderUpDir, sbb);
            }
        }
        for (int z = 1; z < 10; ++z) {
            final int y = bottom + 1 + z / 2;
            this.placeBlockRotated(world, (z % 2 == 0) ? this.deco.platformID : this.deco.pillarID, (z % 2 == 0) ? this.deco.platformMeta : this.deco.pillarMeta, 8, y, z, ladderUpDir, sbb);
            for (int by = bottom + 1; by < y; ++by) {
                this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, 8, by, z, ladderUpDir, sbb);
            }
        }
        this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta, 7, bottom + 1, 1, ladderUpDir, sbb);
        for (int z = 2; z < 7; ++z) {
            this.placeBlockRotated(world, Blocks.field_150350_a, 0, 9, top, z, ladderUpDir, sbb);
        }
    }
    
    private void decorateWraparoundWallSteps(final World world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        for (int z = 1; z < 10; ++z) {
            final int y = bottom + 10 - z / 2;
            this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta + ((z % 2 == 0) ? 8 : 0), 9, y, z, ladderUpDir, sbb);
        }
        for (int x = 1; x < 9; ++x) {
            final int y = bottom + 2 + (x - 1) / 2;
            this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta + ((x % 2 == 0) ? 8 : 0), x, y, 9, ladderUpDir, sbb);
        }
        this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta + 8, 1, bottom + 1, 8, ladderUpDir, sbb);
        this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta, 1, bottom + 1, 7, ladderUpDir, sbb);
        for (int z = 2; z < 7; ++z) {
            this.placeBlockRotated(world, Blocks.field_150350_a, 0, 9, top, z, ladderUpDir, sbb);
        }
    }
    
    private void decorateWraparoundWallStepsPillars(final World world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        final int rotation = ladderDownDir;
        final int beamMetaNS = ((this.field_74885_f + rotation) % 2 == 0) ? 4 : 8;
        final int beamMetaEW = (beamMetaNS == 4) ? 8 : 4;
        this.decorateWraparoundWallSteps(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        this.decoratePillars(world, rand, bottom, top, rotation, sbb);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 1, 3, bottom + 5, 2, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 1, 7, bottom + 5, 2, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 8, bottom + 5, 3, 9, bottom + 5, 3, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 8, bottom + 5, 7, 9, bottom + 5, 7, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 2, 3, 2, bottom + 2, 3, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 6, 3, 2, bottom + 6, 3, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 4, 7, 2, bottom + 4, 7, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 8, 7, 2, bottom + 8, 7, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 6, 8, 3, bottom + 6, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 8, 8, 7, bottom + 8, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
    }
    
    private void decoratePlatform(final World world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        this.decoratePillars(world, rand, bottom, top, ladderDownDir, sbb);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 3, 7, bottom + 5, 7, this.deco.floorID, this.deco.floorMeta, ladderDownDir);
        for (int z = 6; z < 10; ++z) {
            final int y = bottom - 2 + z / 2;
            this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta + ((z % 2 == 1) ? 8 : 0), 1, y, z, ladderDownDir, sbb);
        }
        for (int x = 2; x < 6; ++x) {
            final int y = bottom + 2 + x / 2;
            this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta + ((x % 2 == 1) ? 8 : 0), x, y, 9, ladderDownDir, sbb);
        }
        this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta, 5, bottom + 5, 8, ladderDownDir, sbb);
        this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta, 5, bottom + 6, 2, ladderUpDir, sbb);
        for (int x = 5; x < 10; ++x) {
            final int y = bottom + 4 + x / 2;
            this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta + ((x % 2 == 1) ? 8 : 0), x, y, 1, ladderUpDir, sbb);
            if (x > 6) {
                this.placeBlockRotated(world, Blocks.field_150350_a, 0, x, top, 1, ladderUpDir, sbb);
            }
        }
        for (int z = 2; z < 5; ++z) {
            final int y = bottom + 8 + z / 2;
            this.placeBlockRotated(world, Blocks.field_150350_a, 0, 9, top, z, ladderUpDir, sbb);
            this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta + ((z % 2 == 1) ? 8 : 0), 9, y, z, ladderUpDir, sbb);
        }
    }
    
    private void decorateQuadPillarStairs(final World world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        this.decoratePillars(world, rand, bottom, top, ladderDownDir, sbb);
        for (int z = 6; z < 9; ++z) {
            final int y = bottom - 2 + z / 2;
            this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta + ((z % 2 == 1) ? 8 : 0), 2, y, z, ladderDownDir, sbb);
        }
        for (int x = 3; x < 9; ++x) {
            final int y = bottom + 1 + x / 2;
            this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta + ((x % 2 == 1) ? 8 : 0), x, y, 8, ladderDownDir, sbb);
        }
        for (int z = 7; z > 1; --z) {
            final int y = top - 2 - (z - 1) / 2;
            if (z < 4) {
                this.placeBlockRotated(world, Blocks.field_150350_a, 0, 8, top, z, ladderDownDir, sbb);
            }
            this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta + ((z % 2 == 1) ? 8 : 0), 8, y, z, ladderDownDir, sbb);
        }
        for (int x = 7; x > 3; --x) {
            final int y = top + 1 - (x - 1) / 2;
            this.placeBlockRotated(world, Blocks.field_150350_a, 0, x, top, 2, ladderDownDir, sbb);
            this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta + ((x % 2 == 1) ? 8 : 0), x, y, 2, ladderDownDir, sbb);
        }
    }
    
    private void decoratePillarPlatforms(final World world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        for (int i = 1; i < 10; ++i) {
            final int rotation = (ladderUpDir + i) % 4;
            this.fillBlocksRotated(world, sbb, 2, bottom + i, 2, 4, bottom + i, 4, this.deco.floorID, this.deco.floorMeta, rotation);
        }
        this.fillAirRotated(world, sbb, 2, top, 2, 8, top, 4, ladderUpDir);
        this.fillAirRotated(world, sbb, 2, top, 2, 4, top, 6, ladderUpDir);
        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, 7, top, 3, ladderUpDir, sbb);
        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, 3, top, 3, ladderUpDir, sbb);
        this.decoratePillars(world, rand, bottom, top, ladderUpDir, sbb);
    }
    
    private void decoratePillarPlatformsOutside(final World world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        for (int i = 1; i < 8; ++i) {
            final int rotation = (ladderUpDir + i) % 4;
            this.fillBlocksRotated(world, sbb, 1, bottom + i, 1, 3, bottom + i, 3, this.deco.platformID, this.deco.platformMeta, rotation);
            this.fillBlocksRotated(world, sbb, 4, bottom + i, 1, 6, bottom + i, 3, this.deco.floorID, this.deco.floorMeta, rotation);
        }
        final int rotation2 = (ladderUpDir + 2) % 4;
        this.fillAirRotated(world, sbb, 5, top, 8, 9, top, 9, rotation2);
        this.fillAirRotated(world, sbb, 8, top, 6, 9, top, 9, rotation2);
        this.fillBlocksRotated(world, sbb, 8, top - 2, 7, 9, top - 2, 7, this.deco.platformID, this.deco.platformMeta, rotation2);
        this.fillBlocksRotated(world, sbb, 8, top - 2, 8, 9, top - 2, 9, this.deco.floorID, this.deco.floorMeta, rotation2);
        this.fillBlocksRotated(world, sbb, 7, top - 1, 8, 7, top - 1, 9, this.deco.platformID, this.deco.platformMeta, rotation2);
        this.fillBlocksRotated(world, sbb, 6, top - 1, 8, 6, top - 1, 9, this.deco.platformID, this.deco.platformMeta | 0x8, rotation2);
        this.fillBlocksRotated(world, sbb, 5, top - 0, 8, 5, top - 0, 9, this.deco.platformID, this.deco.platformMeta, rotation2);
        this.decoratePillars(world, rand, bottom, top, ladderUpDir, sbb);
    }
    
    private void decoratePillarParkour(final World world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        final int rotation = ladderDownDir;
        final int beamMetaNS = ((this.field_74885_f + rotation) % 2 == 0) ? 4 : 8;
        final int beamMetaEW = (beamMetaNS == 4) ? 8 : 4;
        this.decoratePillars(world, rand, bottom, top, rotation, sbb);
        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, 5, bottom + 1, 5, rotation, sbb);
        this.fillBlocksRotated(world, sbb, 5, bottom + 2, 7, 5, bottom + 2, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 3, 7, 2, bottom + 3, 7, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 3, 8, 3, bottom + 3, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 7, 7, 2, bottom + 7, 7, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 7, 8, 3, bottom + 7, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillAirRotated(world, sbb, 3, bottom + 4, 7, 3, bottom + 6, 7, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 4, 5, 2, bottom + 4, 5, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 1, 3, bottom + 5, 2, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 3, 2, bottom + 5, 3, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillAirRotated(world, sbb, 3, bottom + 6, 3, 3, bottom + 8, 3, rotation);
        this.fillBlocksRotated(world, sbb, 5, bottom + 6, 1, 5, bottom + 6, 2, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillAirRotated(world, sbb, 7, bottom + 8, 3, 7, bottom + 10, 3, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 7, 1, 7, bottom + 7, 2, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 8, bottom + 7, 3, 9, bottom + 7, 3, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 8, bottom + 8, 5, 9, bottom + 8, 5, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 8, bottom + 9, 7, 9, bottom + 9, 7, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 9, 8, 7, bottom + 9, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillAirRotated(world, sbb, 2, top, 2, 8, top, 4, ladderUpDir);
        this.fillAirRotated(world, sbb, 2, top, 2, 4, top, 6, ladderUpDir);
    }
    
    @Override
    public void makeARoof(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final int index = this.func_74877_c();
        this.tryToFitRoof(list, rand, new ComponentTFIceTowerRoof(index + 1, this));
    }
    
    @Override
    public void makeABeard(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final int index = this.func_74877_c();
        final ComponentTFIceTowerBeard beard = new ComponentTFIceTowerBeard(index + 1, this);
        list.add(beard);
        beard.func_74861_a((StructureComponent)this, (List)list, rand);
    }
}
