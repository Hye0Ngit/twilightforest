// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.structures.lichtower.TowerWingComponent;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DarkTowerRoofFourPostComponent extends DarkTowerRoofComponent
{
    public DarkTowerRoofFourPostComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(DarkTowerPieces.TFDTRFP, nbt);
    }
    
    public DarkTowerRoofFourPostComponent(final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(DarkTowerPieces.TFDTRFP, feature, i, wing);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.makeSmallAntenna(world, sbb, 4, this.size - 2, this.size - 2);
        this.makeSmallAntenna(world, sbb, 5, 1, this.size - 2);
        this.makeSmallAntenna(world, sbb, 6, this.size - 2, 1);
        this.makeSmallAntenna(world, sbb, 7, 1, 1);
        return true;
    }
    
    private void makeSmallAntenna(final ISeedReader world, final MutableBoundingBox sbb, final int height, final int x, final int z) {
        for (int y = 1; y < height; ++y) {
            this.func_175811_a(world, this.deco.blockState, x, y, z, sbb);
        }
        this.func_175811_a(world, this.deco.accentState, x, height, z, sbb);
        this.func_175811_a(world, this.deco.accentState, x, height + 1, z, sbb);
        this.func_175811_a(world, this.deco.accentState, x + 1, height + 1, z, sbb);
        this.func_175811_a(world, this.deco.accentState, x - 1, height + 1, z, sbb);
        this.func_175811_a(world, this.deco.accentState, x, height + 1, z + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, x, height + 1, z - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, x, height + 2, z, sbb);
    }
}
