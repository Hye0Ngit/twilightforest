// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import java.util.Iterator;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFTrollCaveConnect extends ComponentTFTrollCaveMain
{
    public ComponentTFTrollCaveConnect() {
    }
    
    public ComponentTFTrollCaveConnect(final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final int direction) {
        super(index);
        this.size = caveSize;
        this.height = caveHeight;
        this.setCoordBaseMode(direction);
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        if (this.func_74877_c() < 3) {
            for (int i = 0; i < 4; ++i) {
                final ChunkCoordinates dest = this.getValidOpening(rand, 2, i);
                if (rand.nextBoolean() || !this.makeGardenCave(list, rand, this.func_74877_c() + 1, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, 30, 15, i)) {
                    this.makeSmallerCave(list, rand, this.func_74877_c() + 1, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, 20, 15, i);
                }
            }
        }
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.isBoundingBoxOutOfHighlands(world, sbb)) {
            return false;
        }
        this.hollowCaveMiddle(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        for (int i = 0; i < 32; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.5f, true, dest.field_71574_a, 3, dest.field_71573_c, sbb);
        }
        for (int i = 0; i < 8; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.5f, false, dest.field_71574_a, 3, dest.field_71573_c, sbb);
        }
        return true;
    }
    
    protected boolean makeGardenCave(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final ChunkCoordinates dest = this.offsetTowerCCoords(x, y, z, caveSize, direction);
        final ComponentTFTrollCaveGarden cave = new ComponentTFTrollCaveGarden(index, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, caveSize, caveHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, cave.func_74874_b());
        final StructureComponent otherGarden = this.findNearbyGarden(list, cave.func_74874_b());
        if ((intersect == null || intersect == this) && otherGarden == null) {
            list.add(cave);
            cave.func_74861_a(list.get(0), list, rand);
            return true;
        }
        return false;
    }
    
    private StructureComponent findNearbyGarden(final List<StructureComponent> list, final StructureBoundingBox boundingBox) {
        final StructureBoundingBox structureBoundingBox;
        final StructureBoundingBox largeBox = structureBoundingBox = new StructureBoundingBox(boundingBox);
        structureBoundingBox.field_78897_a -= 40;
        final StructureBoundingBox structureBoundingBox2 = largeBox;
        structureBoundingBox2.field_78895_b -= 40;
        final StructureBoundingBox structureBoundingBox3 = largeBox;
        structureBoundingBox3.field_78896_c -= 40;
        final StructureBoundingBox structureBoundingBox4 = largeBox;
        structureBoundingBox4.field_78893_d += 40;
        final StructureBoundingBox structureBoundingBox5 = largeBox;
        structureBoundingBox5.field_78894_e += 40;
        final StructureBoundingBox structureBoundingBox6 = largeBox;
        structureBoundingBox6.field_78892_f += 40;
        for (final StructureComponent component : list) {
            if (component instanceof ComponentTFTrollCaveGarden && component.func_74874_b().func_78884_a(largeBox)) {
                return component;
            }
        }
        return null;
    }
}
