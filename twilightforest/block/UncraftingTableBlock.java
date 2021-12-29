// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.inventory.UncraftingContainer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class UncraftingTableBlock extends Block
{
    protected UncraftingTableBlock() {
        super(AbstractBlock.Properties.func_200945_a(Material.field_151575_d).func_200943_b(2.5f).func_200947_a(SoundType.field_185848_a));
    }
    
    @Deprecated
    public ActionResultType func_225533_a_(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {
        if (!world.field_72995_K) {
            player.func_213829_a(state.func_215699_b(world, pos));
            player.func_195066_a(Stats.field_188062_ab);
        }
        return ActionResultType.SUCCESS;
    }
    
    @Nullable
    public INamedContainerProvider func_220052_b(final BlockState state, final World world, final BlockPos pos) {
        return (INamedContainerProvider)new SimpleNamedContainerProvider((id, inv, player) -> new UncraftingContainer(id, inv, player.field_70170_p, IWorldPosCallable.func_221488_a(world, pos)), (ITextComponent)new TranslationTextComponent(this.func_149739_a()));
    }
}
