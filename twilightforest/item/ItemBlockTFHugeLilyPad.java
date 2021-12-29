// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.material.Material;
import twilightforest.block.TFBlocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.item.ItemLilyPad;

public class ItemBlockTFHugeLilyPad extends ItemLilyPad
{
    Random rand;
    
    public ItemBlockTFHugeLilyPad(final Block block) {
        super(block);
        this.rand = new Random();
    }
    
    public ItemStack func_77659_a(final ItemStack itemStack, final World world, final EntityPlayer player) {
        final MovingObjectPosition movingobjectposition = this.func_77621_a(world, player, true);
        if (movingobjectposition == null) {
            return itemStack;
        }
        if (movingobjectposition.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
            final int x = movingobjectposition.field_72311_b;
            final int y = movingobjectposition.field_72312_c;
            final int z = movingobjectposition.field_72309_d;
            final int bx = x >> 1 << 1;
            final int by = y;
            final int bz = z >> 1 << 1;
            if (this.canPlacePadOn(itemStack, world, player, bx, by, bz) && this.canPlacePadOn(itemStack, world, player, bx + 1, by, bz) && this.canPlacePadOn(itemStack, world, player, bx, by, bz + 1) && this.canPlacePadOn(itemStack, world, player, bx + 1, by, bz + 1)) {
                this.rand.setSeed(8890919293L);
                this.rand.setSeed(bx * this.rand.nextLong() ^ bz * this.rand.nextLong() ^ 0x211F0A97DL);
                final int orient = this.rand.nextInt(4) << 2;
                world.func_147465_d(bx, by + 1, bz, TFBlocks.hugeLilyPad, 0x0 | orient, 2);
                world.func_147465_d(bx + 1, by + 1, bz, TFBlocks.hugeLilyPad, 0x1 | orient, 2);
                world.func_147465_d(bx + 1, by + 1, bz + 1, TFBlocks.hugeLilyPad, 0x2 | orient, 2);
                world.func_147465_d(bx, by + 1, bz + 1, TFBlocks.hugeLilyPad, 0x3 | orient, 2);
                if (!player.field_71075_bZ.field_75098_d) {
                    --itemStack.field_77994_a;
                }
            }
        }
        return itemStack;
    }
    
    public boolean canPlacePadOn(final ItemStack itemStack, final World world, final EntityPlayer player, final int x, final int y, final int z) {
        return world.func_72962_a(player, x, y, z) && player.func_82247_a(x, y, z, 1, itemStack) && world.func_147439_a(x, y, z).func_149688_o() == Material.field_151586_h && world.func_72805_g(x, y, z) == 0 && world.func_147437_c(x, y + 1, z);
    }
}
