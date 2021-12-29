// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.common.util.ForgeDirection;
import twilightforest.block.TFBlocks;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraft.block.material.Material;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockTFHugeWaterLily extends ItemBlock
{
    public ItemBlockTFHugeWaterLily(final Block block) {
        super(block);
    }
    
    public ItemStack func_77659_a(final ItemStack p_77659_1_, final World p_77659_2_, final EntityPlayer p_77659_3_) {
        final MovingObjectPosition movingobjectposition = this.func_77621_a(p_77659_2_, p_77659_3_, true);
        if (movingobjectposition == null) {
            return p_77659_1_;
        }
        if (movingobjectposition.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
            final int i = movingobjectposition.field_72311_b;
            final int j = movingobjectposition.field_72312_c;
            final int k = movingobjectposition.field_72309_d;
            if (!p_77659_2_.func_72962_a(p_77659_3_, i, j, k)) {
                return p_77659_1_;
            }
            if (!p_77659_3_.func_82247_a(i, j, k, movingobjectposition.field_72310_e, p_77659_1_)) {
                return p_77659_1_;
            }
            if (p_77659_2_.func_147439_a(i, j, k).func_149688_o() == Material.field_151586_h && p_77659_2_.func_72805_g(i, j, k) == 0 && p_77659_2_.func_147437_c(i, j + 1, k)) {
                final BlockSnapshot blocksnapshot = BlockSnapshot.getBlockSnapshot(p_77659_2_, i, j + 1, k);
                p_77659_2_.func_147449_b(i, j + 1, k, TFBlocks.hugeWaterLily);
                if (ForgeEventFactory.onPlayerBlockPlace(p_77659_3_, blocksnapshot, ForgeDirection.UP).isCanceled()) {
                    blocksnapshot.restore(true, false);
                    return p_77659_1_;
                }
                if (!p_77659_3_.field_71075_bZ.field_75098_d) {
                    --p_77659_1_.field_77994_a;
                }
            }
        }
        return p_77659_1_;
    }
}
