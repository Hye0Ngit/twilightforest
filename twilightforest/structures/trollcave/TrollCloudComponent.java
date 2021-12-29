// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class TrollCloudComponent extends TFStructureComponentOld
{
    private int size;
    private int height;
    
    public TrollCloudComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(TrollCavePieces.TFTCloud, nbt);
        this.size = nbt.func_74762_e("size");
        this.height = nbt.func_74762_e("height");
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("size", this.size);
        tagCompound.func_74768_a("height", this.height);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeCloud(world, sbb, 0, 0, 0, this.size - 1, 6, this.size - 1);
        return true;
    }
    
    protected void placeCloud(final ISeedReader world, final MutableBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        this.func_175804_a(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, Blocks.field_196807_gj.func_176223_P(), Blocks.field_196807_gj.func_176223_P(), false);
        this.func_175804_a(world, sbb, minX + 2, minY + 2, minZ + 2, maxX - 2, maxY - 1, maxZ - 2, Blocks.field_150371_ca.func_176223_P(), Blocks.field_150371_ca.func_176223_P(), false);
    }
}
