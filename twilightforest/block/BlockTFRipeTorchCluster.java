// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import java.util.Random;

public class BlockTFRipeTorchCluster extends BlockTFTrollRoot
{
    protected BlockTFRipeTorchCluster() {
        this.func_149658_d("TwilightForest:ripe_torch_cluster");
        this.func_149715_a(1.0f);
    }
    
    public Item func_149650_a(final int meta, final Random rand, final int fortune) {
        return TFItems.torchberries;
    }
    
    @Override
    public int quantityDropped(final int meta, final int fortune, final Random random) {
        return this.func_149679_a(fortune, random);
    }
    
    public int func_149745_a(final Random rand) {
        return 4 + rand.nextInt(5);
    }
    
    public int func_149679_a(final int bonus, final Random rand) {
        if (bonus > 0 && Item.func_150898_a((Block)this) != this.func_149650_a(0, rand, bonus)) {
            int j = rand.nextInt(bonus + 2) - 1;
            if (j < 0) {
                j = 0;
            }
            return this.func_149745_a(rand) * (j + 1);
        }
        return this.func_149745_a(rand);
    }
    
    public void func_149636_a(final World world, final EntityPlayer player, final int x, final int y, final int z, final int meta) {
        if (world.field_72995_K || player.func_71045_bC() == null || player.func_71045_bC().func_77973_b() != Items.field_151097_aZ) {
            super.func_149636_a(world, player, x, y, z, meta);
        }
    }
}
