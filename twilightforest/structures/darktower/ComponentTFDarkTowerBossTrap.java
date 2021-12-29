// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import twilightforest.block.TFBlocks;
import twilightforest.structures.StructureTFComponent;
import java.util.Random;
import java.util.List;

public class ComponentTFDarkTowerBossTrap extends ComponentTFDarkTowerWing
{
    protected ComponentTFDarkTowerBossTrap(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
        this.spawnListIndex = -1;
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, 2);
        this.makeABeard(parent, list, rand);
        for (int i = 0; i < 4; ++i) {
            if (i != 2) {
                if (!rand.nextBoolean()) {
                    final int[] dest = this.getValidOpening(rand, i);
                    dest[1] = 1;
                    this.makeTowerBalcony(list, rand, this.c(), dest[0], dest[1], dest[2], i);
                }
            }
        }
    }
    
    @Override
    public void makeARoof(final aiq parent, final List list, final Random rand) {
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final age sbb) {
        final Random decoRNG = new Random(world.H() + this.f.a * 321534781 ^ (long)(this.f.c * 756839));
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.makeOpenings(world, sbb);
        this.addBossTrapFloors(world, decoRNG, sbb, 4, this.height - 1);
        this.destroyTower(world, decoRNG, 5, this.height + 2, 5, 4, sbb);
        this.destroyTower(world, decoRNG, 0, this.height, 0, 3, sbb);
        this.destroyTower(world, decoRNG, 0, this.height, 8, 4, sbb);
        this.destroyTower(world, decoRNG, 5, 6, 5, 2, sbb);
        this.a(world, sbb, 1, 0, 1, this.size / 2, 0, this.size - 2, this.deco.blockID, this.deco.blockMeta, 0, 0, false);
        this.a(world, sbb, 1, 1, 1, this.size / 2, 1, this.size - 2, 0, 0, 0, 0, false);
        this.a(world, TFBlocks.towerDevice.cF, 10, 5, 1, 5, sbb);
        this.a(world, aqw.aA.cF, 0, 5, 1, 6, sbb);
        this.a(world, aqw.aA.cF, 0, 5, 1, 7, sbb);
        this.a(world, aqw.aA.cF, 0, 5, 1, 8, sbb);
        this.a(world, aqw.aA.cF, 0, 4, 1, 8, sbb);
        this.a(world, aqw.aA.cF, 0, 3, 1, 8, sbb);
        this.a(world, aqw.aR.cF, 0, 2, 1, 8, sbb);
        return true;
    }
    
    protected void addBossTrapFloors(final abv world, final Random rand, final age sbb, final int bottom, final int top) {
        this.makeFullFloor(world, sbb, 3, 4, 4);
        this.addStairsDown(world, sbb, 3, 4, this.size - 2, 4);
        this.addStairsDown(world, sbb, 3, 4, this.size - 3, 4);
        this.addStairsDown(world, sbb, 1, this.height - 1, this.size - 2, 4);
        this.addStairsDown(world, sbb, 1, this.height - 1, this.size - 3, 4);
    }
}
