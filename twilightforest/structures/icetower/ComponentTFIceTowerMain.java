// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import java.util.Iterator;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFIceTowerMain extends ComponentTFIceTowerWing
{
    public boolean hasBossWing;
    
    public ComponentTFIceTowerMain() {
        this.hasBossWing = false;
    }
    
    public ComponentTFIceTowerMain(final World world, final Random rand, final int index, final int x, final int y, final int z) {
        this(world, rand, index, x + 11, y + 40, z + 11, 2);
    }
    
    public ComponentTFIceTowerMain(final World world, final Random rand, final int index, final int x, final int y, final int z, final int rotation) {
        super(index, x, y, z, 11, 31 + rand.nextInt(3) * 10, rotation);
        this.hasBossWing = false;
        if (this.deco == null) {
            this.deco = new StructureDecoratorIceTower();
        }
    }
    
    protected ComponentTFIceTowerMain(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
        this.hasBossWing = false;
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74757_a("hasBossWing", this.hasBossWing);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.hasBossWing = par1NBTTagCompound.func_74767_n("hasBossWing");
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        super.func_74861_a(parent, list, rand);
        final StructureBoundingBox towerBB = StructureBoundingBox.func_78887_a();
        for (final StructureComponent structurecomponent : list) {
            towerBB.func_78888_b(structurecomponent.func_74874_b());
        }
        final ChunkCoordinates myDoor = this.openings.get(0);
        final ChunkCoordinates entranceDoor = new ChunkCoordinates(myDoor);
        if (myDoor.field_71574_a == 0) {
            final int length = this.func_74874_b().field_78897_a - towerBB.field_78897_a;
            if (length >= 0) {
                final ChunkCoordinates chunkCoordinates = entranceDoor;
                chunkCoordinates.field_71574_a -= length;
                this.makeEntranceBridge(list, rand, this.func_74877_c() + 1, myDoor.field_71574_a, myDoor.field_71572_b, myDoor.field_71573_c, length, 2);
            }
        }
        if (myDoor.field_71574_a == this.size - 1) {
            final ChunkCoordinates chunkCoordinates2 = entranceDoor;
            chunkCoordinates2.field_71574_a += towerBB.field_78893_d - this.func_74874_b().field_78893_d;
        }
        if (myDoor.field_71573_c == 0) {
            final ChunkCoordinates chunkCoordinates3 = entranceDoor;
            chunkCoordinates3.field_71573_c += towerBB.field_78896_c - this.func_74874_b().field_78896_c;
        }
        if (myDoor.field_71574_a == this.size - 1) {
            final ChunkCoordinates chunkCoordinates4 = entranceDoor;
            chunkCoordinates4.field_71573_c += towerBB.field_78892_f - this.func_74874_b().field_78892_f;
        }
        this.makeEntranceTower(list, rand, this.func_74877_c() + 1, entranceDoor.field_71574_a, entranceDoor.field_71572_b, entranceDoor.field_71573_c, 11, 11, this.getCoordBaseMode());
    }
    
    private void makeEntranceBridge(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int length, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final ChunkCoordinates dest = this.offsetTowerCCoords(x, y, z, 5, direction);
        final ComponentTFIceTowerBridge bridge = new ComponentTFIceTowerBridge(index, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, length, direction);
        list.add(bridge);
        bridge.func_74861_a(list.get(0), list, rand);
    }
    
    public boolean makeEntranceTower(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        final ComponentTFIceTowerWing entrance = new ComponentTFIceTowerEntrance(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.add(entrance);
        entrance.func_74861_a(list.get(0), list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
}
