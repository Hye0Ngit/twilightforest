// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

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
        this.hasBase = (this.func_74877_c() == 0 || rand.nextBoolean());
        if (this.func_74877_c() < 5) {
            for (int i = 0; i < 4; ++i) {
                final int[] dest = this.getValidOpening(rand, i);
                final int childHeight = (rand.nextInt(2) + rand.nextInt(2) + 2) * 10 + 1;
                this.makeTowerWing(list, rand, this.func_74877_c() + 1, dest[0], dest[1], dest[2], 11, childHeight, i);
            }
        }
    }
    
    private boolean isOutOfRange(final StructureComponent parent, final int nx, final int ny, final int nz, final int range) {
        return Math.abs(nx - parent.func_74874_b().func_78881_e()) > range || Math.abs(nz - parent.func_74874_b().func_78891_g()) > range;
    }
    
    @Override
    public boolean makeTowerWing(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        if (wingHeight < 6) {
            return false;
        }
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (this.isOutOfRange(list.get(0), dx[0], dx[1], dx[2], 17)) {
            return false;
        }
        final ComponentTFIceTowerWing wing = new ComponentTFIceTowerWing(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a(list, wing.func_74874_b());
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
        this.func_74872_a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, this.deco.blockID, this.deco.blockMeta, 0, 0, false);
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        if (this.hasBase) {
            for (int x = 0; x < this.size; ++x) {
                for (int z = 0; z < this.size; ++z) {
                    this.func_74870_b(world, this.deco.blockID, this.deco.blockMeta, x, -1, z, sbb);
                }
            }
        }
        this.nullifySkyLightForBoundingBox(world);
        this.makeFloorsForTower(world, decoRNG, sbb);
        this.makeOpenings(world, sbb);
        return true;
    }
    
    private void makeFloorsForTower(final World world, final Random decoRNG, final StructureBoundingBox sbb) {
        final int floors = this.height / 10;
        int ladderDir = 3;
        int downLadderDir = -1;
        final int floorHeight = 10;
        for (int i = 0; i < floors - 1; ++i) {
            for (int x = 1; x < this.size - 1; ++x) {
                for (int z = 1; z < this.size - 1; ++z) {
                    this.func_74864_a(world, this.deco.floorID, this.deco.floorMeta, x, i * floorHeight + floorHeight, z, sbb);
                }
            }
            downLadderDir = ladderDir;
            ladderDir = ++ladderDir % 4;
            this.decorateFloor(world, decoRNG, i, i * floorHeight, i * floorHeight + floorHeight, ladderDir, downLadderDir, sbb);
        }
    }
    
    @Override
    protected void makeDoorOpening(final World world, final int dx, final int dy, final int dz, final StructureBoundingBox sbb) {
        super.makeDoorOpening(world, dx, dy, dz, sbb);
        if (this.func_74866_a(world, dx, dy + 2, dz, sbb) != 0) {
            this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, dx, dy + 2, dz, sbb);
        }
    }
    
    @Override
    protected void decorateFloor(final World world, final Random rand, final int floor, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        this.decorateWraparoundWallSteps(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
    }
    
    private void decorateFarWallSteps(final World world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final StructureBoundingBox sbb) {
        for (int z = 1; z < 10; ++z) {
            final int y = bottom + 10 - z / 2;
            this.placeBlockRotated(world, (z % 2 == 0) ? this.deco.blockID : this.deco.platformID, (z % 2 == 0) ? this.deco.blockMeta : this.deco.platformMeta, 9, y, z, ladderUpDir, sbb);
            for (int by = bottom + 1; by < y; ++by) {
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 9, by, z, ladderUpDir, sbb);
            }
        }
        for (int z = 1; z < 10; ++z) {
            final int y = bottom + 1 + z / 2;
            this.placeBlockRotated(world, (z % 2 == 0) ? this.deco.platformID : this.deco.blockID, (z % 2 == 0) ? this.deco.platformMeta : this.deco.blockMeta, 8, y, z, ladderUpDir, sbb);
            for (int by = bottom + 1; by < y; ++by) {
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 8, by, z, ladderUpDir, sbb);
            }
        }
        this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta, 7, bottom + 1, 1, ladderUpDir, sbb);
        for (int z = 2; z < 7; ++z) {
            this.placeBlockRotated(world, 0, 0, 9, top, z, ladderUpDir, sbb);
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
            this.placeBlockRotated(world, 0, 0, 9, top, z, ladderUpDir, sbb);
        }
    }
}
