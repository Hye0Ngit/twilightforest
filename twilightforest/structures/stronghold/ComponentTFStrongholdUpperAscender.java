// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.nbt.NBTTagCompound;

public class ComponentTFStrongholdUpperAscender extends StructureTFStrongholdComponent
{
    boolean exitTop;
    
    public ComponentTFStrongholdUpperAscender() {
    }
    
    public ComponentTFStrongholdUpperAscender(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74757_a("exitTop", this.exitTop);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.exitTop = par1NBTTagCompound.func_74767_n("exitTop");
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final int facing, final int x, final int y, final int z) {
        if (y < 36) {
            this.exitTop = true;
            return StructureBoundingBox.func_78889_a(x, y, z, -2, -1, 0, 5, 10, 10, facing);
        }
        this.exitTop = false;
        return StructureBoundingBox.func_78889_a(x, y, z, -2, -6, 0, 5, 10, 10, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random random) {
        super.func_74861_a(parent, list, random);
        this.addNewUpperComponent(parent, list, random, 0, 2, this.exitTop ? 6 : 1, 10);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.func_74860_a(world, sbb)) {
            return false;
        }
        this.placeUpperStrongholdWalls(world, sbb, 0, 0, 0, 4, 9, 9, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, rand, 2, 2, this.exitTop ? 1 : 6, 0, sbb);
        this.placeSmallDoorwayAt(world, rand, 0, 2, this.exitTop ? 6 : 1, 9, sbb);
        if (this.exitTop) {
            this.makeStairsAt(world, 1, 3, 1, sbb);
            this.makeStairsAt(world, 2, 4, 1, sbb);
            this.makeStairsAt(world, 3, 5, 1, sbb);
            this.makeStairsAt(world, 4, 6, 1, sbb);
            this.makeStairsAt(world, 5, 7, 1, sbb);
            this.makePlatformAt(world, 5, 8, sbb);
        }
        else {
            this.makeStairsAt(world, 1, 6, 3, sbb);
            this.makeStairsAt(world, 2, 5, 3, sbb);
            this.makeStairsAt(world, 3, 4, 3, sbb);
            this.makeStairsAt(world, 4, 3, 3, sbb);
            this.makeStairsAt(world, 5, 2, 3, sbb);
            this.makePlatformAt(world, 5, 1, sbb);
        }
        return true;
    }
    
    private void makeStairsAt(final World world, final int y, final int z, final int facing, final StructureBoundingBox sbb) {
        if (this.func_151548_a(world, 0, y, z, sbb) != Blocks.field_150350_a || this.func_151548_a(world, 4, y, z, sbb) != Blocks.field_150350_a) {
            for (int x = 1; x < 4; ++x) {
                this.func_151550_a(world, Blocks.field_150390_bg, this.getStairMeta(facing), x, y, z, sbb);
            }
        }
    }
    
    private void makePlatformAt(final World world, final int y, final int z, final StructureBoundingBox sbb) {
        if (this.func_151548_a(world, 0, y, z, sbb) != Blocks.field_150350_a || this.func_151548_a(world, 4, y, z, sbb) != Blocks.field_150350_a) {
            for (int x = 1; x < 4; ++x) {
                this.func_151550_a(world, Blocks.field_150417_aV, 0, x, y, z, sbb);
            }
        }
    }
    
    @Override
    public boolean isComponentProtected() {
        return false;
    }
}
