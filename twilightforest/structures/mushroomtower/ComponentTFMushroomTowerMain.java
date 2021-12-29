// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.lichtower.ComponentTFTowerRoof;
import twilightforest.structures.lichtower.ComponentTFTowerWing;
import twilightforest.structures.StructureTFComponent;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMushroomTowerMain extends ComponentTFMushroomTowerWing
{
    public ComponentTFMushroomTowerMain() {
    }
    
    public ComponentTFMushroomTowerMain(final World world, final Random rand, final int index, final int x, final int y, final int z) {
        this(world, rand, index, x + 15, y + 4, z + 15, 2);
    }
    
    public ComponentTFMushroomTowerMain(final World world, final Random rand, final int index, final int x, final int y, final int z, final int rotation) {
        super(index, x, y, z, 15, 8 + rand.nextInt(3) * 4, rotation);
        if (this.deco == null) {
            this.deco = new StructureDecoratorMushroomTower();
        }
    }
    
    protected ComponentTFMushroomTowerMain(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, 2);
        this.hasBase = true;
        int mainDir = -1;
        if (this.func_74877_c() < 3) {
            for (int i = 0; i < 6; ++i) {
                mainDir = this.makeAscenderTower(list, rand);
                if (mainDir != -1) {
                    break;
                }
            }
            for (int i = 0; i < 4; ++i) {
                if (i != mainDir) {
                    final int[] dest = this.getValidOpening(rand, i);
                    final int childHeight = (rand.nextInt(2) + rand.nextInt(2) + 2) * 4 + 1;
                    this.makeBridge(list, rand, this.func_74877_c() + 1, dest[0], dest[1], dest[2], this.size - 4, childHeight, i);
                }
            }
        }
        else {
            this.makeARoof(parent, list, rand);
        }
    }
    
    private int makeAscenderTower(final List list, final Random rand) {
        final int mainDir = rand.nextInt(4);
        final int[] dest = this.getValidOpening(rand, mainDir);
        final int childHeight = this.height - dest[1] + (rand.nextInt(2) + rand.nextInt(2) + 3) * 4 + 1;
        final boolean madeIt = this.makeBridge(list, rand, this.func_74877_c() + 1, dest[0], dest[1], dest[2], this.size - 4, childHeight, mainDir, true);
        if (madeIt) {
            System.out.println("Main tower made a bridge to another tower");
            return mainDir;
        }
        System.out.println("Main tower failed to branch off at index " + this.field_74886_g);
        return -1;
    }
    
    @Override
    public void makeARoof(final StructureComponent parent, final List list, final Random rand) {
        final ComponentTFTowerRoof roof = new ComponentTFTowerRoofMushroom(this.func_74877_c() + 1, this, 1.6f);
        list.add(roof);
        roof.func_74861_a((StructureComponent)this, list, rand);
    }
    
    @Override
    protected void makeDoorOpening(final World world, final int dx, final int dy, final int dz, final StructureBoundingBox sbb) {
        super.makeDoorOpening(world, dx, dy, dz, sbb);
        if (dx == 0) {
            this.func_151550_a(world, Blocks.field_150350_a, 0, dx + 1, dy + 0, dz, sbb);
            this.func_151550_a(world, Blocks.field_150350_a, 0, dx + 1, dy + 1, dz, sbb);
        }
        if (dx == this.size - 1) {
            this.func_151550_a(world, Blocks.field_150350_a, 0, dx - 1, dy + 0, dz, sbb);
            this.func_151550_a(world, Blocks.field_150350_a, 0, dx - 1, dy + 1, dz, sbb);
        }
        if (dz == 0) {
            this.func_151550_a(world, Blocks.field_150350_a, 0, dx, dy + 0, dz + 1, sbb);
            this.func_151550_a(world, Blocks.field_150350_a, 0, dx, dy + 1, dz + 1, sbb);
        }
        if (dz == this.size - 1) {
            this.func_151550_a(world, Blocks.field_150350_a, 0, dx, dy + 0, dz - 1, sbb);
            this.func_151550_a(world, Blocks.field_150350_a, 0, dx, dy + 1, dz - 1, sbb);
        }
    }
}
