// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.entity.TFCreatures;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenWitchHut extends TFGenerator
{
    @Override
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        return this.generateTinyHut(world, rand, x, y, z);
    }
    
    public boolean generateTinyHut(final World world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 5, 7, 6)) {
            return false;
        }
        this.putBlock(world, x + 1, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(world, x + 2, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(world, x + 3, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(world, x + 5, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(world, x + 0, y + 0, z + 2, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 1, y + 0, z + 2, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 5, y + 0, z + 2, this.randStone(rand, 1), true);
        this.putBlock(world, x + 0, y + 0, z + 3, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 5, y + 0, z + 3, this.randStone(rand, 1), true);
        this.putBlock(world, x + 0, y + 0, z + 4, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 1, y + 0, z + 4, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 5, y + 0, z + 4, this.randStone(rand, 1), true);
        this.putBlock(world, x + 1, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(world, x + 2, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(world, x + 3, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(world, x + 5, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(world, x + 1, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(world, x + 3, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(world, x + 5, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(world, x + 0, y + 1, z + 2, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 1, y + 1, z + 2, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 5, y + 1, z + 2, this.randStone(rand, 2), true);
        this.putBlock(world, x + 0, y + 1, z + 3, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 1, z + 4, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 1, y + 1, z + 4, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 5, y + 1, z + 4, this.randStone(rand, 2), true);
        this.putBlock(world, x + 1, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(world, x + 3, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(world, x + 5, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(world, x + 1, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(world, x + 2, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(world, x + 3, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(world, x + 4, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(world, x + 5, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(world, x + 0, y + 2, z + 2, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 1, y + 2, z + 2, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 5, y + 2, z + 2, this.randStone(rand, 3), true);
        this.putBlock(world, x + 0, y + 2, z + 3, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 5, y + 2, z + 3, this.randStone(rand, 3), true);
        this.putBlock(world, x + 0, y + 2, z + 4, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 1, y + 2, z + 4, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 5, y + 2, z + 4, this.randStone(rand, 1), true);
        this.putBlock(world, x + 1, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(world, x + 2, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(world, x + 3, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(world, x + 4, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(world, x + 5, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(world, x + 0, y + 3, z + 2, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 3, z + 3, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 3, z + 4, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 2, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(world, x + 3, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(world, x + 4, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(world, x + 2, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(world, x + 3, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(world, x + 4, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(world, x + 0, y + 4, z + 3, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 3, y + 4, z + 1, this.randStone(rand, 5), true);
        this.putBlock(world, x + 3, y + 4, z + 5, this.randStone(rand, 5), true);
        this.putBlock(world, x + 0, y + 5, z + 3, Block.field_72081_al.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 6, z + 3, Block.field_72081_al.field_71990_ca, true);
        this.putBlockAndMetadata(world, x + 0, y + 2, z + 0, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 0, y + 2, z + 1, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 0, y + 2, z + 5, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 0, y + 2, z + 6, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 0, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 1, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 2, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 3, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 4, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 5, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 6, y + 2, z + 6, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 0, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 1, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 2, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 4, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 5, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 6, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 0, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 1, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 2, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 3, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 4, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 5, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 3, z + 6, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 4, z + 0, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 0, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 1, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 2, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 3, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 4, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 5, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 4, z + 6, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 1, y + 4, z + 6, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 4, z + 0, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 0, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 1, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 2, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 3, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 4, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 5, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 4, z + 6, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 5, y + 4, z + 6, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 5, z + 0, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 5, z + 1, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 5, z + 0, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 5, z + 1, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 0, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 1, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 2, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 3, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 4, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 5, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 5, z + 6, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 5, z + 5, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 2, y + 5, z + 6, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 5, z + 5, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 4, y + 5, z + 6, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 0, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 1, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 2, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 4, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 5, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 6, z + 6, Block.field_72085_aj.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 7, z + 0, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlockAndMetadata(world, x + 3, y + 7, z + 6, Block.field_72079_ak.field_71990_ca, 2, true);
        this.putBlock(world, x + 1, y - 1, z + 3, Block.field_72012_bb.field_71990_ca, true);
        this.putBlock(world, x + 1, y + 0, z + 3, Block.field_72067_ar.field_71990_ca, true);
        world.func_72832_d(x + 3, y + 1, z + 3, Block.field_72065_as.field_71990_ca, 0, 2);
        final TileEntityMobSpawner ms = (TileEntityMobSpawner)world.func_72796_p(x + 3, y + 1, z + 3);
        ms.func_98049_a().func_98272_a(TFCreatures.getSpawnerNameFor("Skeleton Druid"));
        return true;
    }
}
