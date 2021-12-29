// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import javax.annotation.Nonnull;
import net.minecraft.block.state.IBlockState;
import twilightforest.enums.TowerDeviceVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFTowerDevice;
import twilightforest.block.TFBlocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;

public class ItemTFTowerKey extends ItemTF
{
    ItemTFTowerKey(final EnumRarity rarity) {
        super(rarity);
    }
    
    @Nonnull
    public EnumActionResult func_180614_a(final EntityPlayer player, final World world, final BlockPos pos, final EnumHand hand, final EnumFacing side, final float fx, final float fy, final float fz) {
        final IBlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() == TFBlocks.tower_device && state.func_177229_b((IProperty)BlockTFTowerDevice.VARIANT) == TowerDeviceVariant.VANISH_LOCKED) {
            if (!world.field_72995_K) {
                BlockTFTowerDevice.unlockBlock(world, pos);
                player.func_184586_b(hand).func_190918_g(1);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
}
