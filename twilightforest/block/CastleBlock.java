// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import twilightforest.item.MazebreakerPickItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.Block;

public class CastleBlock extends Block
{
    public CastleBlock(final MaterialColor color) {
        super(AbstractBlock.Properties.func_200949_a(Material.field_151576_e, color).func_235861_h_().func_200948_a(100.0f, 35.0f).func_200947_a(SoundType.field_185851_d));
    }
    
    public void func_180657_a(final World world, final PlayerEntity player, final BlockPos pos, final BlockState state, @Nullable final TileEntity te, final ItemStack stack) {
        final ItemStack cei = player.func_184614_ca();
        if (cei.func_77973_b() instanceof ToolItem && !(cei.func_77973_b() instanceof MazebreakerPickItem)) {
            cei.func_222118_a(16, (LivingEntity)player, user -> user.func_213334_d(Hand.MAIN_HAND));
        }
        super.func_180657_a(world, player, pos, state, te, stack);
    }
}
