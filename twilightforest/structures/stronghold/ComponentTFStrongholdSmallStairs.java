// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.TFTreasure;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.nbt.NBTTagCompound;

public class ComponentTFStrongholdSmallStairs extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    public boolean hasTreasure;
    public boolean chestTrapped;
    
    public ComponentTFStrongholdSmallStairs() {
    }
    
    public ComponentTFStrongholdSmallStairs(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74757_a("enterBottom", this.enterBottom);
        par1NBTTagCompound.func_74757_a("hasTreasure", this.hasTreasure);
        par1NBTTagCompound.func_74757_a("chestTrapped", this.chestTrapped);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.enterBottom = par1NBTTagCompound.func_74767_n("enterBottom");
        this.hasTreasure = par1NBTTagCompound.func_74767_n("hasTreasure");
        this.chestTrapped = par1NBTTagCompound.func_74767_n("chestTrapped");
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final int facing, final int x, final int y, final int z) {
        if (y > 17) {
            this.enterBottom = false;
        }
        else if (y < 11) {
            this.enterBottom = true;
        }
        else {
            this.enterBottom = ((z & 0x1) == 0x0);
        }
        if (this.enterBottom) {
            return StructureBoundingBox.func_78889_a(x, y, z, -4, -1, 0, 9, 14, 9, facing);
        }
        return StructureBoundingBox.func_78889_a(x, y, z, -4, -8, 0, 9, 14, 9, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random random) {
        super.func_74861_a(parent, list, random);
        if (this.enterBottom) {
            this.addDoor(4, 1, 0);
            this.addNewComponent(parent, list, random, 0, 4, 8, 9);
        }
        else {
            this.addDoor(4, 8, 0);
            this.addNewComponent(parent, list, random, 0, 4, 1, 9);
        }
        this.hasTreasure = random.nextBoolean();
        this.chestTrapped = (random.nextInt(3) == 0);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 13, 8, rand, this.deco.randomBlocks);
        this.func_151556_a(world, sbb, 1, 7, 1, 7, 7, 7, this.deco.platformID, this.deco.platformMeta, Blocks.field_150350_a, 0, false);
        this.func_74878_a(world, sbb, 2, 7, 2, 6, 7, 6);
        final int rotation = this.enterBottom ? 0 : 2;
        for (int y = 1; y < 8; ++y) {
            for (int x = 3; x < 6; ++x) {
                this.placeBlockRotated(world, Blocks.field_150350_a, 0, x, y + 1, y, rotation, sbb);
                this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation), x, y, y, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, x, y - 1, y, rotation, sbb);
            }
        }
        if (this.hasTreasure) {
            this.placeTreasureRotated(world, 4, 1, 6, rotation, TFTreasure.stronghold_cache, this.chestTrapped, sbb);
            if (this.chestTrapped) {
                this.placeBlockRotated(world, Blocks.field_150335_W, 0, 4, 0, 6, rotation, sbb);
            }
            for (int z = 5; z < 8; ++z) {
                this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), 3, 1, z, rotation, sbb);
                this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation), 5, 1, z, rotation, sbb);
            }
            this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation), 4, 1, 5, rotation, sbb);
            this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), 4, 1, 7, rotation, sbb);
            this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation), 4, 2, 6, rotation, sbb);
        }
        if (this.enterBottom) {
            this.placeWallStatue(world, 4, 8, 1, 2, sbb);
        }
        else {
            this.placeWallStatue(world, 4, 8, 7, 0, sbb);
        }
        this.placeDoors(world, rand, sbb);
        return true;
    }
}
