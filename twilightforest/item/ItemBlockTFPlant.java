// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.BlockTFPlant;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.block.TFBlocks;

public class ItemBlockTFPlant extends vq
{
    public ItemBlockTFPlant(final int par1) {
        super(par1);
        this.a(true);
        this.e(0);
    }
    
    public int b(final int i) {
        final int j = ke.a(i, 0, 15);
        return TFBlocks.plant.a(2, j);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_82790_a(final ur par1ItemStack, final int par2) {
        return TFBlocks.plant.g_(par1ItemStack.j());
    }
    
    public String d(final ur itemstack) {
        final int meta = itemstack.j();
        return super.a() + "." + meta;
    }
    
    public int a(final int i) {
        return i;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean a(final yc par1World, final int x, final int y, final int z, final int direction, final qx par6EntityPlayer, final ur par7ItemStack) {
        final int meta = par7ItemStack.j();
        return ((meta == 14 || meta == 13) && direction == 0 && BlockTFPlant.canPlaceRootBelow(par1World, x, y, z)) || super.a(par1World, x, y, z, direction, par6EntityPlayer, par7ItemStack);
    }
    
    public boolean a(final ur itemStack, final qx player, final yc world, final int x, final int y, final int z, final int direction, final float par8, final float par9, final float par10) {
        final int meta = itemStack.j();
        if (meta == 14 || meta == 13) {
            return this.onItemUseRoot(itemStack, player, world, x, y, z, direction);
        }
        return super.a(itemStack, player, world, x, y, z, direction, par8, par9, par10);
    }
    
    public boolean onItemUseRoot(final ur itemStack, final qx player, final yc world, int x, int y, int z, int direction) {
        final int blockThereId = world.a(x, y, z);
        if (blockThereId == amq.aV.cm) {
            direction = 1;
        }
        else if (!amq.p[blockThereId].cB.j()) {
            x += r.b[direction];
            y += r.c[direction];
            z += r.d[direction];
        }
        if (!player.a(x, y, z, direction, itemStack)) {
            return false;
        }
        if (itemStack.a == 0) {
            return false;
        }
        if (BlockTFPlant.canPlaceRootBelow(world, x, y + 1, z)) {
            final amq plantBlock = TFBlocks.plant;
            if (world.d(x, y, z, plantBlock.cm, itemStack.b().a(itemStack.j()))) {
                if (world.a(x, y, z) == plantBlock.cm) {
                    plantBlock.a(world, x, y, z, (md)player);
                }
                world.a((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), plantBlock.cz.e(), (plantBlock.cz.c() + 1.0f) / 2.0f, plantBlock.cz.d() * 0.8f);
                --itemStack.a;
            }
        }
        return true;
    }
}
