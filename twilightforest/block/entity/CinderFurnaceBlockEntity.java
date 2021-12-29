// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraftforge.common.Tags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import java.util.Random;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import twilightforest.block.TFBlocks;
import java.util.function.Function;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.CinderFurnaceBlock;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;

public class CinderFurnaceBlockEntity extends FurnaceBlockEntity
{
    private static final int SMELT_LOG_FACTOR = 10;
    
    public CinderFurnaceBlockEntity(final BlockPos p_155545_, final BlockState p_155546_) {
        super(p_155545_, p_155546_);
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final CinderFurnaceBlockEntity te) {
        final boolean flag = te.isBurning();
        boolean flag2 = false;
        if (te.isBurning()) {
            --te.f_58316_;
        }
        if (!level.f_46443_) {
            final ItemStack itemstack = (ItemStack)te.f_58310_.get(1);
            if (te.isBurning() || (!itemstack.m_41619_() && !((ItemStack)te.f_58310_.get(0)).m_41619_())) {
                final Recipe<?> irecipe = (Recipe<?>)level.m_7465_().m_44015_(RecipeType.f_44108_, (Container)te, level).orElse(null);
                if (!te.isBurning() && te.canBurn(irecipe)) {
                    te.f_58316_ = te.m_7743_(itemstack);
                    te.f_58317_ = te.f_58316_;
                    if (te.isBurning()) {
                        flag2 = true;
                        if (!itemstack.m_41619_()) {
                            final Item item = itemstack.m_41720_();
                            itemstack.m_41774_(1);
                            if (itemstack.m_41619_()) {
                                final ItemStack item2 = item.getContainerItem(itemstack);
                                te.f_58310_.set(1, (Object)item2);
                            }
                        }
                    }
                }
                if (te.isBurning() && te.canBurn(irecipe)) {
                    te.f_58318_ += te.getCurrentSpeedMultiplier();
                    if (te.f_58318_ >= te.f_58319_) {
                        te.f_58318_ = 0;
                        te.f_58319_ = te.getRecipeBurnTime();
                        te.smeltItem(irecipe);
                        flag2 = true;
                    }
                }
                else {
                    te.f_58318_ = 0;
                }
            }
            else if (!te.isBurning() && te.f_58318_ > 0) {
                te.f_58318_ = Mth.m_14045_(te.f_58318_ - 2, 0, te.f_58319_);
            }
            if (flag != te.isBurning()) {
                flag2 = true;
                level.m_7731_(pos, (BlockState)level.m_8055_(pos).m_61124_((Property)CinderFurnaceBlock.LIT, (Comparable)te.isBurning()), 3);
            }
            if (te.isBurning() && te.f_58316_ % 5 == 0) {
                te.cinderizeNearbyLog();
            }
        }
        if (flag2) {
            te.m_6596_();
        }
    }
    
    private boolean isBurning() {
        return this.f_58316_ > 0;
    }
    
    protected int getRecipeBurnTime() {
        return this.f_58857_.m_7465_().m_44015_(RecipeType.f_44108_, (Container)this, this.f_58857_).map(AbstractCookingRecipe::m_43753_).orElse(200);
    }
    
    private void cinderizeNearbyLog() {
        final Random rand = this.m_58904_().f_46441_;
        final int dx = rand.nextInt(2) - rand.nextInt(2);
        final int dy = rand.nextInt(2) - rand.nextInt(2);
        final int dz = rand.nextInt(2) - rand.nextInt(2);
        final BlockPos pos = this.m_58899_().m_142082_(dx, dy, dz);
        if (this.f_58857_.m_46805_(pos)) {
            final Block nearbyBlock = this.m_58904_().m_8055_(pos).m_60734_();
            if (nearbyBlock != TFBlocks.CINDER_LOG.get() && BlockTags.f_13106_.m_8110_((Object)nearbyBlock)) {
                this.m_58904_().m_7731_(pos, this.getCinderLog(dx, dy, dz), 2);
                this.m_58904_().m_46796_(2004, pos, 0);
                this.m_58904_().m_46796_(2004, pos, 0);
                this.m_58904_().m_5594_((Player)null, pos, SoundEvents.f_11936_, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
        }
    }
    
    private BlockState getCinderLog(final int dx, final int dy, final int dz) {
        Direction.Axis direction;
        if (dz == 0 && dx != 0) {
            direction = ((dy == 0) ? Direction.Axis.X : Direction.Axis.Z);
        }
        else if (dx == 0 && dz != 0) {
            direction = ((dy == 0) ? Direction.Axis.Z : Direction.Axis.X);
        }
        else if (dx == 0 && dz == 0) {
            direction = Direction.Axis.Y;
        }
        else {
            direction = ((dy == 0) ? Direction.Axis.Y : null);
        }
        return (BlockState)((direction != null) ? ((RotatedPillarBlock)TFBlocks.CINDER_LOG.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)direction) : ((Block)TFBlocks.CINDER_WOOD.get()).m_49966_());
    }
    
    private int getCurrentSpeedMultiplier() {
        return this.getCurrentMultiplier(2);
    }
    
    private int getCurrentMultiplier(final int factor) {
        final int logs = this.countNearbyLogs();
        if (logs < factor) {
            return 1;
        }
        return logs / factor + ((this.f_58857_.f_46441_.nextInt(factor) < logs % factor) ? 1 : 0);
    }
    
    private int countNearbyLogs() {
        int count = 0;
        for (int dx = -1; dx <= 1; ++dx) {
            for (int dy = -1; dy <= 1; ++dy) {
                for (int dz = -1; dz <= 1; ++dz) {
                    final BlockPos pos = this.m_58899_().m_142082_(dx, dy, dz);
                    if (this.f_58857_.m_46805_(pos) && this.m_58904_().m_8055_(pos).m_60734_() == TFBlocks.CINDER_LOG.get()) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    protected boolean canBurn(final Recipe<?> recipe) {
        if (((ItemStack)this.f_58310_.get(0)).m_41619_()) {
            return false;
        }
        final ItemStack itemstack = recipe.m_8043_();
        if (itemstack.m_41619_()) {
            return false;
        }
        final ItemStack itemstack2 = (ItemStack)this.f_58310_.get(2);
        if (itemstack2.m_41619_()) {
            return true;
        }
        if (!itemstack2.m_41656_(itemstack)) {
            return false;
        }
        final int result = itemstack2.m_41613_() + this.getMaxOutputStacks((ItemStack)this.f_58310_.get(0), itemstack);
        return result <= this.m_6893_() && result <= itemstack2.m_41741_();
    }
    
    public int getMaxOutputStacks(final ItemStack input, final ItemStack output) {
        if (this.canMultiply(input, output)) {
            return output.m_41613_() * this.getCurrentMaxSmeltMultiplier();
        }
        return output.m_41613_();
    }
    
    public void smeltItem(final Recipe<?> recipe) {
        if (this.canBurn(recipe)) {
            final ItemStack itemstack = (ItemStack)this.f_58310_.get(0);
            final ItemStack itemstack2 = recipe.m_8043_();
            itemstack2.m_41764_(itemstack2.m_41613_() * this.getCurrentSmeltMultiplier());
            final ItemStack itemstack3 = (ItemStack)this.f_58310_.get(2);
            if (itemstack3.m_41619_()) {
                this.f_58310_.set(2, (Object)itemstack2.m_41777_());
            }
            else if (itemstack3.m_41720_() == itemstack2.m_41720_()) {
                itemstack3.m_41769_(itemstack2.m_41613_());
            }
            if (itemstack.m_41720_() == Blocks.f_50057_.m_5456_() && !((ItemStack)this.f_58310_.get(1)).m_41619_() && ((ItemStack)this.f_58310_.get(1)).m_41720_() == Items.f_42446_) {
                this.f_58310_.set(1, (Object)new ItemStack((ItemLike)Items.f_42447_));
            }
            itemstack.m_41774_(1);
        }
    }
    
    private boolean canMultiply(final ItemStack input, final ItemStack output) {
        return ItemTags.f_13182_.m_8110_((Object)input.m_41720_()) || Tags.Items.ORES.m_8110_((Object)input.m_41720_());
    }
    
    private int getCurrentSmeltMultiplier() {
        return this.getCurrentMultiplier(10);
    }
    
    private int getCurrentMaxSmeltMultiplier() {
        return (int)Math.ceil(this.countNearbyLogs() / 10.0f);
    }
}
