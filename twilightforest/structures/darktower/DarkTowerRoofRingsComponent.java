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

public class DarkTowerRoofRingsComponent extends DarkTowerRoofComponent
{
    public DarkTowerRoofRingsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(DarkTowerPieces.TFDTRR, nbt);
    }
    
    public DarkTowerRoofRingsComponent(final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(DarkTowerPieces.TFDTRR, feature, i, wing);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        for (int y = 1; y < 10; ++y) {
            this.func_175811_a(world, this.deco.blockState, this.size / 2, y, this.size / 2, sbb);
        }
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 10, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 1, 1, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 1, 1, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 1, this.size / 2 - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, 1, this.size / 2 + 1, sbb);
        this.makeARing(world, 6, sbb);
        this.makeARing(world, 8, sbb);
        return true;
    }
    
    protected void makeARing(final ISeedReader world, final int y, final MutableBoundingBox sbb) {
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 2, y, this.size / 2 + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 2, y, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 2, y, this.size / 2 - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 2, y, this.size / 2 + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 2, y, this.size / 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 2, y, this.size / 2 - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 1, y, this.size / 2 - 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, y, this.size / 2 - 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 1, y, this.size / 2 - 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 + 1, y, this.size / 2 + 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2, y, this.size / 2 + 2, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size / 2 - 1, y, this.size / 2 + 2, sbb);
    }
}
