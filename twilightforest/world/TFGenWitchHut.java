// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.entity.TFCreatures;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenWitchHut extends TFGenerator
{
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        return this.generateTinyHut(world, rand, x, y, z);
    }
    
    public boolean generateTinyHut(final World world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 5, 7, 6)) {
            return false;
        }
        this.setBlock(world, x + 1, y + 0, z + 1, this.randStone(rand, 1));
        this.setBlock(world, x + 2, y + 0, z + 1, this.randStone(rand, 1));
        this.setBlock(world, x + 3, y + 0, z + 1, this.randStone(rand, 1));
        this.setBlock(world, x + 5, y + 0, z + 1, this.randStone(rand, 1));
        this.setBlock(world, x + 0, y + 0, z + 2, Blocks.field_150336_V);
        this.setBlock(world, x + 1, y + 0, z + 2, Blocks.field_150336_V);
        this.setBlock(world, x + 5, y + 0, z + 2, this.randStone(rand, 1));
        this.setBlock(world, x + 0, y + 0, z + 3, Blocks.field_150336_V);
        this.setBlock(world, x + 5, y + 0, z + 3, this.randStone(rand, 1));
        this.setBlock(world, x + 0, y + 0, z + 4, Blocks.field_150336_V);
        this.setBlock(world, x + 1, y + 0, z + 4, Blocks.field_150336_V);
        this.setBlock(world, x + 5, y + 0, z + 4, this.randStone(rand, 1));
        this.setBlock(world, x + 1, y + 0, z + 5, this.randStone(rand, 1));
        this.setBlock(world, x + 2, y + 0, z + 5, this.randStone(rand, 1));
        this.setBlock(world, x + 3, y + 0, z + 5, this.randStone(rand, 1));
        this.setBlock(world, x + 5, y + 0, z + 5, this.randStone(rand, 1));
        this.setBlock(world, x + 1, y + 1, z + 1, this.randStone(rand, 2));
        this.setBlock(world, x + 3, y + 1, z + 1, this.randStone(rand, 2));
        this.setBlock(world, x + 5, y + 1, z + 1, this.randStone(rand, 2));
        this.setBlock(world, x + 0, y + 1, z + 2, Blocks.field_150336_V);
        this.setBlock(world, x + 1, y + 1, z + 2, Blocks.field_150336_V);
        this.setBlock(world, x + 5, y + 1, z + 2, this.randStone(rand, 2));
        this.setBlock(world, x + 0, y + 1, z + 3, Blocks.field_150336_V);
        this.setBlock(world, x + 0, y + 1, z + 4, Blocks.field_150336_V);
        this.setBlock(world, x + 1, y + 1, z + 4, Blocks.field_150336_V);
        this.setBlock(world, x + 5, y + 1, z + 4, this.randStone(rand, 2));
        this.setBlock(world, x + 1, y + 1, z + 5, this.randStone(rand, 2));
        this.setBlock(world, x + 3, y + 1, z + 5, this.randStone(rand, 2));
        this.setBlock(world, x + 5, y + 1, z + 5, this.randStone(rand, 2));
        this.setBlock(world, x + 1, y + 2, z + 1, this.randStone(rand, 3));
        this.setBlock(world, x + 2, y + 2, z + 1, this.randStone(rand, 3));
        this.setBlock(world, x + 3, y + 2, z + 1, this.randStone(rand, 3));
        this.setBlock(world, x + 4, y + 2, z + 1, this.randStone(rand, 3));
        this.setBlock(world, x + 5, y + 2, z + 1, this.randStone(rand, 3));
        this.setBlock(world, x + 0, y + 2, z + 2, Blocks.field_150336_V);
        this.setBlock(world, x + 1, y + 2, z + 2, Blocks.field_150336_V);
        this.setBlock(world, x + 5, y + 2, z + 2, this.randStone(rand, 3));
        this.setBlock(world, x + 0, y + 2, z + 3, Blocks.field_150336_V);
        this.setBlock(world, x + 5, y + 2, z + 3, this.randStone(rand, 3));
        this.setBlock(world, x + 0, y + 2, z + 4, Blocks.field_150336_V);
        this.setBlock(world, x + 1, y + 2, z + 4, Blocks.field_150336_V);
        this.setBlock(world, x + 5, y + 2, z + 4, this.randStone(rand, 1));
        this.setBlock(world, x + 1, y + 2, z + 5, this.randStone(rand, 3));
        this.setBlock(world, x + 2, y + 2, z + 5, this.randStone(rand, 3));
        this.setBlock(world, x + 3, y + 2, z + 5, this.randStone(rand, 3));
        this.setBlock(world, x + 4, y + 2, z + 5, this.randStone(rand, 3));
        this.setBlock(world, x + 5, y + 2, z + 5, this.randStone(rand, 3));
        this.setBlock(world, x + 0, y + 3, z + 2, Blocks.field_150336_V);
        this.setBlock(world, x + 0, y + 3, z + 3, Blocks.field_150336_V);
        this.setBlock(world, x + 0, y + 3, z + 4, Blocks.field_150336_V);
        this.setBlock(world, x + 2, y + 3, z + 1, this.randStone(rand, 4));
        this.setBlock(world, x + 3, y + 3, z + 1, this.randStone(rand, 4));
        this.setBlock(world, x + 4, y + 3, z + 1, this.randStone(rand, 4));
        this.setBlock(world, x + 2, y + 3, z + 5, this.randStone(rand, 4));
        this.setBlock(world, x + 3, y + 3, z + 5, this.randStone(rand, 4));
        this.setBlock(world, x + 4, y + 3, z + 5, this.randStone(rand, 4));
        this.setBlock(world, x + 0, y + 4, z + 3, Blocks.field_150336_V);
        this.setBlock(world, x + 3, y + 4, z + 1, this.randStone(rand, 5));
        this.setBlock(world, x + 3, y + 4, z + 5, this.randStone(rand, 5));
        this.setBlock(world, x + 0, y + 5, z + 3, Blocks.field_150336_V);
        this.setBlock(world, x + 0, y + 6, z + 3, Blocks.field_150336_V);
        this.setBlockAndMetadata(world, x + 0, y + 2, z + 0, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 0, y + 2, z + 1, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 0, y + 2, z + 5, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 0, y + 2, z + 6, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 6, y + 2, z + 0, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 6, y + 2, z + 1, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 6, y + 2, z + 2, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 6, y + 2, z + 3, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 6, y + 2, z + 4, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 6, y + 2, z + 5, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 6, y + 2, z + 6, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 1, y + 3, z + 0, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 1, y + 3, z + 1, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 1, y + 3, z + 2, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 1, y + 3, z + 4, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 1, y + 3, z + 5, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 1, y + 3, z + 6, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 5, y + 3, z + 0, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 5, y + 3, z + 1, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 5, y + 3, z + 2, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 5, y + 3, z + 3, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 5, y + 3, z + 4, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 5, y + 3, z + 5, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 5, y + 3, z + 6, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 1, y + 4, z + 0, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 2, y + 4, z + 0, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 2, y + 4, z + 1, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 2, y + 4, z + 2, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 2, y + 4, z + 3, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 2, y + 4, z + 4, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 2, y + 4, z + 5, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 2, y + 4, z + 6, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 1, y + 4, z + 6, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 5, y + 4, z + 0, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 4, y + 4, z + 0, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 4, y + 4, z + 1, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 4, y + 4, z + 2, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 4, y + 4, z + 3, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 4, y + 4, z + 4, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 4, y + 4, z + 5, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 4, y + 4, z + 6, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 5, y + 4, z + 6, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 2, y + 5, z + 0, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 2, y + 5, z + 1, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 4, y + 5, z + 0, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 4, y + 5, z + 1, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 3, y + 5, z + 0, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 3, y + 5, z + 1, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 3, y + 5, z + 2, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 3, y + 5, z + 3, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 3, y + 5, z + 4, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 3, y + 5, z + 5, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 3, y + 5, z + 6, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 2, y + 5, z + 5, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 2, y + 5, z + 6, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 4, y + 5, z + 5, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 4, y + 5, z + 6, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 3, y + 6, z + 0, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 3, y + 6, z + 1, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 3, y + 6, z + 2, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 3, y + 6, z + 4, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 3, y + 6, z + 5, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 3, y + 6, z + 6, (Block)Blocks.field_150334_T, 2);
        this.setBlockAndMetadata(world, x + 3, y + 7, z + 0, (Block)Blocks.field_150333_U, 2);
        this.setBlockAndMetadata(world, x + 3, y + 7, z + 6, (Block)Blocks.field_150333_U, 2);
        this.setBlock(world, x + 1, y - 1, z + 3, Blocks.field_150424_aL);
        this.setBlock(world, x + 1, y + 0, z + 3, (Block)Blocks.field_150480_ab);
        world.func_147465_d(x + 3, y + 1, z + 3, Blocks.field_150474_ac, 0, 2);
        final TileEntityMobSpawner ms = (TileEntityMobSpawner)world.func_147438_o(x + 3, y + 1, z + 3);
        ms.func_145881_a().func_98272_a(TFCreatures.getSpawnerNameFor("Skeleton Druid"));
        return true;
    }
}
