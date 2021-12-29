// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import twilightforest.structures.StructureTFComponent;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;

public class ComponentTFIceTowerEntrance extends ComponentTFIceTowerWing
{
    public ComponentTFIceTowerEntrance() {
    }
    
    public ComponentTFIceTowerEntrance(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    protected boolean shouldHaveBase(final Random rand) {
        return true;
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, 2);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size - 1, 1, this.size / 2, 0);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, 0, 3);
        this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, this.size - 1, 1);
        this.hasBase = this.shouldHaveBase(rand);
        this.makeARoof(parent, list, rand);
    }
    
    private boolean addStairs(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int rotation) {
        this.addOpening(x, y, z, rotation);
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final ChunkCoordinates dx = this.offsetTowerCCoords(x, y, z, this.size, direction);
        final ComponentTFIceTowerStairs entrance = new ComponentTFIceTowerStairs(index, dx.field_71574_a, dx.field_71572_b, dx.field_71573_c, this.size, this.height, direction);
        list.add(entrance);
        entrance.func_74861_a(list.get(0), list, rand);
        return true;
    }
    
    @Override
    public boolean makeTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        return false;
    }
    
    @Override
    protected void makeFloorsForTower(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.decoratePillarsCornersHigh(world, rand, 0, 11, 0, sbb);
    }
    
    protected void decoratePillarsCornersHigh(final World world, final Random rand, final int bottom, final int top, final int rotation, final StructureBoundingBox sbb) {
        final int beamMetaNS = ((this.field_74885_f + rotation) % 2 == 0) ? 4 : 8;
        final int beamMetaEW = (beamMetaNS == 4) ? 8 : 4;
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 1, 3, bottom + 5, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 1, 7, bottom + 5, 9, this.deco.pillarID, this.deco.pillarMeta + beamMetaEW, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 3, 9, bottom + 5, 3, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 7, 9, bottom + 5, 7, this.deco.pillarID, this.deco.pillarMeta + beamMetaNS, rotation);
        this.fillAirRotated(world, sbb, 3, bottom + 5, 3, 7, bottom + 5, 7, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 3, 3, top - 1, 3, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 3, 7, top - 1, 3, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 7, 3, top - 1, 7, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 7, 7, top - 1, 7, this.deco.pillarID, this.deco.pillarMeta, rotation);
    }
}
