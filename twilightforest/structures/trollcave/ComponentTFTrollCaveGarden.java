// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.StructureTFComponent;
import net.minecraft.init.Blocks;
import twilightforest.world.TFGenBigMushgloom;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import twilightforest.world.TFGenMyceliumBlob;

public class ComponentTFTrollCaveGarden extends ComponentTFTrollCaveMain
{
    TFGenMyceliumBlob myceliumBlobGen;
    TFGenMyceliumBlob dirtGen;
    WorldGenBigMushroom bigMushroomGen;
    TFGenBigMushgloom bigMushgloomGen;
    
    public ComponentTFTrollCaveGarden() {
        this.myceliumBlobGen = new TFGenMyceliumBlob(5);
        this.dirtGen = new TFGenMyceliumBlob(Blocks.field_150346_d, 5);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.bigMushgloomGen = new TFGenBigMushgloom();
    }
    
    public ComponentTFTrollCaveGarden(final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final int direction) {
        super(index);
        this.myceliumBlobGen = new TFGenMyceliumBlob(5);
        this.dirtGen = new TFGenMyceliumBlob(Blocks.field_150346_d, 5);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.bigMushgloomGen = new TFGenBigMushgloom();
        this.size = caveSize;
        this.height = caveHeight;
        this.setCoordBaseMode(direction);
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.isBoundingBoxOutOfHighlands(world, sbb)) {
            return false;
        }
        this.hollowCaveMiddle(world, sbb, rand, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.makeTreasureCrate(world, rand, sbb);
        for (int i = 0; i < 24; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generate(world, this.dirtGen, decoRNG, dest.field_71574_a, 1, dest.field_71573_c, sbb);
        }
        for (int i = 0; i < 16; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generate(world, this.myceliumBlobGen, decoRNG, dest.field_71574_a, 1, dest.field_71573_c, sbb);
        }
        for (int i = 0; i < 16; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generate(world, ComponentTFTrollCaveGarden.uberousGen, decoRNG, dest.field_71574_a, 1, dest.field_71573_c, sbb);
            this.generateAtSurface(world, ComponentTFTrollCaveGarden.uberousGen, decoRNG, dest.field_71574_a, 60, dest.field_71573_c, sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generate(world, this.bigMushgloomGen, decoRNG, dest.field_71574_a, 1, dest.field_71573_c, sbb);
        }
        for (int i = 0; i < 64; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generate(world, (WorldGenerator)this.bigMushroomGen, decoRNG, dest.field_71574_a, 1, dest.field_71573_c, sbb);
        }
        for (int i = 0; i < 128; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.7f, true, dest.field_71574_a, 3, dest.field_71573_c, sbb);
        }
        return true;
    }
    
    protected void generate(final World world, final WorldGenerator generator, final Random rand, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (sbb.func_78890_b(dx, dy, dz)) {
            generator.func_76484_a(world, rand, dx, dy, dz);
        }
    }
}
