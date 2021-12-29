// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.BlockTFPlant;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.block.TFBlocks;

public class ItemBlockTFPlant extends zg
{
    public ItemBlockTFPlant(final int par1) {
        super(par1);
        this.a(true);
        this.e(0);
    }
    
    public mr b_(final int par1) {
        return TFBlocks.plant.a(2, par1);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_82790_a(final yd par1ItemStack, final int par2) {
        return TFBlocks.plant.b(par1ItemStack.k());
    }
    
    public String d(final yd itemstack) {
        final int meta = itemstack.k();
        return super.a() + "." + meta;
    }
    
    public int a(final int i) {
        return i;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean a(final abv par1World, final int x, final int y, final int z, final int direction, final ue par6EntityPlayer, final yd par7ItemStack) {
        final int meta = par7ItemStack.k();
        return ((meta == 14 || meta == 13) && direction == 0 && BlockTFPlant.canPlaceRootBelow(par1World, x, y, z)) || super.a(par1World, x, y, z, direction, par6EntityPlayer, par7ItemStack);
    }
    
    public boolean a(final yd itemStack, final ue player, final abv world, final int x, final int y, final int z, final int direction, final float par8, final float par9, final float par10) {
        final int meta = itemStack.k();
        if (meta == 14 || meta == 13) {
            return this.onItemUseRoot(itemStack, player, world, x, y, z, direction);
        }
        return super.a(itemStack, player, world, x, y, z, direction, par8, par9, par10);
    }
    
    public boolean onItemUseRoot(final yd itemStack, final ue player, final abv world, int x, int y, int z, int direction) {
        final int blockThereId = world.a(x, y, z);
        if (blockThereId == aqw.aX.cF) {
            direction = 1;
        }
        else if (!aqw.s[blockThereId].cU.j()) {
            x += s.b[direction];
            y += s.c[direction];
            z += s.d[direction];
        }
        if (!player.a(x, y, z, direction, itemStack)) {
            return false;
        }
        if (itemStack.b == 0) {
            return false;
        }
        if (BlockTFPlant.canPlaceRootBelow(world, x, y + 1, z)) {
            final aqw plantBlock = TFBlocks.plant;
            if (world.f(x, y, z, plantBlock.cF, itemStack.b().a(itemStack.k()), 3)) {
                if (world.a(x, y, z) == plantBlock.cF) {
                    plantBlock.a(world, x, y, z, (oe)player, itemStack);
                }
                world.a((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), plantBlock.cS.e(), (plantBlock.cS.c() + 1.0f) / 2.0f, plantBlock.cS.d() * 0.8f);
                --itemStack.b;
            }
        }
        return true;
    }
}
