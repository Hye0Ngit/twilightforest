// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import net.minecraft.init.Blocks;
import twilightforest.world.feature.TFGenBigMushgloom;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import twilightforest.world.feature.TFGenMyceliumBlob;

public class ComponentTFTrollCaveGarden extends ComponentTFTrollCaveMain
{
    private TFGenMyceliumBlob myceliumBlobGen;
    private TFGenMyceliumBlob dirtGen;
    private WorldGenBigMushroom bigMushroomGen;
    private TFGenBigMushgloom bigMushgloomGen;
    
    public ComponentTFTrollCaveGarden() {
        this.myceliumBlobGen = new TFGenMyceliumBlob(5);
        this.dirtGen = new TFGenMyceliumBlob(Blocks.field_150346_d, 5);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.bigMushgloomGen = new TFGenBigMushgloom();
    }
    
    public ComponentTFTrollCaveGarden(final TFFeature feature, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final EnumFacing direction) {
        super(feature, index);
        this.myceliumBlobGen = new TFGenMyceliumBlob(5);
        this.dirtGen = new TFGenMyceliumBlob(Blocks.field_150346_d, 5);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.bigMushgloomGen = new TFGenBigMushgloom();
        this.size = caveSize;
        this.height = caveHeight;
        this.func_186164_a(direction);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.isBoundingBoxOutsideBiomes(world, sbb, ComponentTFTrollCaveGarden.highlands)) {
            return false;
        }
        this.hollowCaveMiddle(world, sbb, rand, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.makeTreasureCrate(world, rand, sbb);
        for (int i = 0; i < 24; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generate(world, this.dirtGen, decoRNG, dest.func_177958_n(), 1, dest.func_177952_p(), sbb);
        }
        for (int i = 0; i < 16; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generate(world, this.myceliumBlobGen, decoRNG, dest.func_177958_n(), 1, dest.func_177952_p(), sbb);
        }
        for (int i = 0; i < 16; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generate(world, ComponentTFTrollCaveGarden.uberousGen, decoRNG, dest.func_177958_n(), 1, dest.func_177952_p(), sbb);
            this.generateAtSurface(world, ComponentTFTrollCaveGarden.uberousGen, decoRNG, dest.func_177958_n(), 60, dest.func_177952_p(), sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generate(world, this.bigMushgloomGen, decoRNG, dest.func_177958_n(), 1, dest.func_177952_p(), sbb);
        }
        for (int i = 0; i < 64; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generate(world, (WorldGenerator)this.bigMushroomGen, decoRNG, dest.func_177958_n(), 1, dest.func_177952_p(), sbb);
        }
        for (int i = 0; i < 128; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.7f, true, dest.func_177958_n(), 3, dest.func_177952_p(), sbb);
        }
        return true;
    }
    
    protected void generate(final World world, final WorldGenerator generator, final Random rand, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vec3i)pos)) {
            generator.func_180709_b(world, rand, pos);
        }
    }
}
