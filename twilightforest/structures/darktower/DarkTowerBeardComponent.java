// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import twilightforest.structures.lichtower.TowerWingComponent;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class DarkTowerBeardComponent extends TFStructureComponentOld
{
    protected int size;
    protected int height;
    
    public DarkTowerBeardComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(DarkTowerPieces.TFDTBea, nbt);
        this.size = nbt.func_74762_e("beardSize");
        this.height = nbt.func_74762_e("beardHeight");
    }
    
    public DarkTowerBeardComponent(final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(DarkTowerPieces.TFDTBea, feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = this.size / 2;
        this.field_74887_e = new MutableBoundingBox(wing.func_74874_b().field_78897_a, wing.func_74874_b().field_78895_b - this.height, wing.func_74874_b().field_78896_c, wing.func_74874_b().field_78893_d, wing.func_74874_b().field_78895_b, wing.func_74874_b().field_78892_f);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("beardSize", this.size);
        tagCompound.func_74768_a("beardHeight", this.height);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.makeDarkBeard(world, sbb, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        return true;
    }
    
    protected void makeDarkBeard(final ISeedReader world, final MutableBoundingBox sbb, final int minX, final int minZ, final int maxX, final int maxY, final int maxZ) {
        final BlockState frameState = ((Block)TFBlocks.tower_wood_encased.get()).func_176223_P();
        for (int x = minX; x <= maxX; ++x) {
            for (int z = minZ; z <= maxZ; ++z) {
                if (x == minX || x == maxX || z == minZ || z == maxZ) {
                    int length = Math.min(Math.abs(x - this.height) - 1, Math.abs(z - this.height) - 1);
                    if (length == this.height - 1) {
                        ++length;
                    }
                    if (length == -1) {
                        length = 1;
                    }
                    for (int y = maxY; y >= this.height - length; --y) {
                        this.func_175811_a(world, frameState, x, y, z, sbb);
                    }
                }
            }
        }
    }
}
