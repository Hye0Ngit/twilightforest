// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFGenTallGrass extends WorldGenerator
{
    private int tallGrassID;
    private int tallGrassMetadata;
    private int amount;
    
    public TFGenTallGrass(final int blockID, final int meta, final int amount) {
        this.amount = amount;
        this.tallGrassID = blockID;
        this.tallGrassMetadata = meta;
    }
    
    public boolean func_76484_a(final World par1World, final Random par2Random, final int x, int y, final int z) {
        Block block = null;
        do {
            block = Block.field_71973_m[par1World.func_72798_a(x, y, z)];
            if (block != null && !block.isLeaves(par1World, x, y, z)) {
                break;
            }
        } while (--y > 0);
        for (int i = 0; i < this.amount; ++i) {
            final int dx = x + par2Random.nextInt(8) - par2Random.nextInt(8);
            final int dy = y + par2Random.nextInt(4) - par2Random.nextInt(4);
            final int dz = z + par2Random.nextInt(8) - par2Random.nextInt(8);
            if (par1World.func_72799_c(dx, dy, dz) && Block.field_71973_m[this.tallGrassID].func_71854_d(par1World, dx, dy, dz)) {
                par1World.func_72832_d(dx, dy, dz, this.tallGrassID, this.tallGrassMetadata, 2);
            }
        }
        return true;
    }
}
