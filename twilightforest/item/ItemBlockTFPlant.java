// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.BlockTFPlant;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.block.TFBlocks;

public class ItemBlockTFPlant extends xh
{
    public ItemBlockTFPlant(final int par1) {
        super(par1);
        this.a(true);
        this.e(0);
    }
    
    public lx a_(final int par1) {
        return TFBlocks.plant.a(2, par1);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_82790_a(final wg par1ItemStack, final int par2) {
        return TFBlocks.plant.b(par1ItemStack.k());
    }
    
    public String d(final wg itemstack) {
        final int meta = itemstack.k();
        return super.a() + "." + meta;
    }
    
    public int a(final int i) {
        return i;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean a(final zv par1World, final int x, final int y, final int z, final int direction, final sk par6EntityPlayer, final wg par7ItemStack) {
        final int meta = par7ItemStack.k();
        return ((meta == 14 || meta == 13) && direction == 0 && BlockTFPlant.canPlaceRootBelow(par1World, x, y, z)) || super.a(par1World, x, y, z, direction, par6EntityPlayer, par7ItemStack);
    }
    
    public boolean a(final wg itemStack, final sk player, final zv world, final int x, final int y, final int z, final int direction, final float par8, final float par9, final float par10) {
        final int meta = itemStack.k();
        if (meta == 14 || meta == 13) {
            return this.onItemUseRoot(itemStack, player, world, x, y, z, direction);
        }
        return super.a(itemStack, player, world, x, y, z, direction, par8, par9, par10);
    }
    
    public boolean onItemUseRoot(final wg itemStack, final sk player, final zv world, int x, int y, int z, int direction) {
        final int blockThereId = world.a(x, y, z);
        if (blockThereId == aou.aW.cz) {
            direction = 1;
        }
        else if (!aou.r[blockThereId].cO.j()) {
            x += s.b[direction];
            y += s.c[direction];
            z += s.d[direction];
        }
        if (!player.a(x, y, z, direction, itemStack)) {
            return false;
        }
        if (itemStack.a == 0) {
            return false;
        }
        if (BlockTFPlant.canPlaceRootBelow(world, x, y + 1, z)) {
            final aou plantBlock = TFBlocks.plant;
            if (world.f(x, y, z, plantBlock.cz, itemStack.b().a(itemStack.k()), 3)) {
                if (world.a(x, y, z) == plantBlock.cz) {
                    plantBlock.a(world, x, y, z, (ng)player, itemStack);
                }
                world.a((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), plantBlock.cM.e(), (plantBlock.cM.c() + 1.0f) / 2.0f, plantBlock.cM.d() * 0.8f);
                --itemStack.a;
            }
        }
        return true;
    }
}
