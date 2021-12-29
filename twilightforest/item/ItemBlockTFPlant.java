// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Facing;
import net.minecraft.init.Blocks;
import twilightforest.block.BlockTFPlant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import twilightforest.block.TFBlocks;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockTFPlant extends ItemBlock
{
    public ItemBlockTFPlant(final Block block) {
        super(block);
        this.func_77627_a(true);
        this.func_77656_e(0);
    }
    
    public IIcon func_77617_a(final int par1) {
        return TFBlocks.plant.func_149691_a(2, par1);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_82790_a(final ItemStack par1ItemStack, final int par2) {
        return TFBlocks.plant.func_149741_i(par1ItemStack.func_77960_j());
    }
    
    public String func_77667_c(final ItemStack itemstack) {
        final int meta = itemstack.func_77960_j();
        return super.func_77658_a() + "." + meta;
    }
    
    public int func_77647_b(final int i) {
        return i;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_150936_a(final World par1World, final int x, final int y, final int z, final int direction, final EntityPlayer par6EntityPlayer, final ItemStack par7ItemStack) {
        final int meta = par7ItemStack.func_77960_j();
        return ((meta == 14 || meta == 13) && direction == 0 && BlockTFPlant.canPlaceRootBelow(par1World, x, y, z)) || super.func_150936_a(par1World, x, y, z, direction, par6EntityPlayer, par7ItemStack);
    }
    
    public boolean func_77648_a(final ItemStack itemStack, final EntityPlayer player, final World world, final int x, final int y, final int z, final int direction, final float par8, final float par9, final float par10) {
        final int meta = itemStack.func_77960_j();
        if (meta == 14 || meta == 13) {
            return this.onItemUseRoot(itemStack, player, world, x, y, z, direction);
        }
        return super.func_77648_a(itemStack, player, world, x, y, z, direction, par8, par9, par10);
    }
    
    public boolean onItemUseRoot(final ItemStack itemStack, final EntityPlayer player, final World world, int x, int y, int z, int direction) {
        final Block blockThereId = world.func_147439_a(x, y, z);
        if (blockThereId == Blocks.field_150433_aE) {
            direction = 1;
        }
        else if (!blockThereId.func_149688_o().func_76222_j()) {
            x += Facing.field_71586_b[direction];
            y += Facing.field_71587_c[direction];
            z += Facing.field_71585_d[direction];
        }
        if (!player.func_82247_a(x, y, z, direction, itemStack)) {
            return false;
        }
        if (itemStack.field_77994_a == 0) {
            return false;
        }
        if (BlockTFPlant.canPlaceRootBelow(world, x, y + 1, z)) {
            final Block plantBlock = TFBlocks.plant;
            if (world.func_147465_d(x, y, z, plantBlock, itemStack.func_77973_b().func_77647_b(itemStack.func_77960_j()), 3)) {
                if (world.func_147439_a(x, y, z) == plantBlock) {
                    plantBlock.func_149689_a(world, x, y, z, (EntityLivingBase)player, itemStack);
                }
                world.func_72908_a((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), plantBlock.field_149762_H.func_150495_a(), (plantBlock.field_149762_H.func_150497_c() + 1.0f) / 2.0f, plantBlock.field_149762_H.func_150494_d() * 0.8f);
                --itemStack.field_77994_a;
            }
        }
        return true;
    }
}
