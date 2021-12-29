// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.MathHelper;
import javax.annotation.Nonnull;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.entity.player.ServerPlayerEntity;
import twilightforest.block.TFBlocks;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Item;

public class MagicBeansItem extends Item
{
    protected MagicBeansItem(final Item.Properties props) {
        super(props);
    }
    
    @Nonnull
    public ActionResultType func_195939_a(final ItemUseContext context) {
        final World world = context.func_195991_k();
        final BlockPos pos = context.func_195995_a();
        final PlayerEntity player = context.func_195999_j();
        final Block blockAt = world.func_180495_p(pos).func_177230_c();
        final int minY = pos.func_177956_o() + 1;
        final int maxY = Math.max(pos.func_177956_o() + 100, (int)(this.getCloudHeight() + 40.0f));
        if (pos.func_177956_o() < maxY && blockAt == TFBlocks.uberous_soil.get()) {
            if (!world.field_72995_K) {
                final ItemStack is = player.func_184586_b(context.func_221531_n());
                is.func_190918_g(1);
                this.makeHugeStalk(world, pos, minY, maxY);
                if (player instanceof ServerPlayerEntity) {
                    TFAdvancements.ITEM_USE_TRIGGER.trigger((ServerPlayerEntity)player, is, world, pos);
                }
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }
    
    private float getCloudHeight() {
        return 128.0f;
    }
    
    private void makeHugeStalk(final World world, final BlockPos pos, final int minY, final int maxY) {
        float x = (float)pos.func_177958_n();
        float z = (float)pos.func_177952_p();
        final int yOffset = world.field_73012_v.nextInt(100);
        final float cScale = world.field_73012_v.nextFloat() * 0.25f + 0.125f;
        final float rScale = world.field_73012_v.nextFloat() * 0.25f + 0.125f;
        float radius = 4.0f + MathHelper.func_76126_a((minY + yOffset) * rScale) * 3.0f;
        x -= MathHelper.func_76126_a((minY + yOffset) * cScale) * radius;
        z -= MathHelper.func_76134_b((minY + yOffset) * cScale) * radius;
        int nextLeafY = minY + 10 + world.field_73012_v.nextInt(20);
        boolean isClear = true;
        for (int dy = minY; dy < maxY && isClear; ++dy) {
            radius = 5.0f + MathHelper.func_76126_a((dy + yOffset) * rScale) * 2.5f;
            final float cx = x + MathHelper.func_76126_a((dy + yOffset) * cScale) * radius;
            final float cz = z + MathHelper.func_76134_b((dy + yOffset) * cScale) * radius;
            float stalkThickness = 2.5f;
            if (maxY - dy < 5) {
                stalkThickness *= (maxY - dy) / 5.0f;
            }
            final int minX = MathHelper.func_76141_d(x - radius - stalkThickness);
            final int maxX = MathHelper.func_76123_f(x + radius + stalkThickness);
            final int minZ = MathHelper.func_76141_d(z - radius - stalkThickness);
            final int maxZ = MathHelper.func_76123_f(z + radius + stalkThickness);
            for (int dx = minX; dx < maxX; ++dx) {
                for (int dz = minZ; dz < maxZ; ++dz) {
                    if ((dx - cx) * (dx - cx) + (dz - cz) * (dz - cz) < stalkThickness * stalkThickness) {
                        isClear &= this.tryToPlaceStalk(world, new BlockPos(dx, dy, dz));
                    }
                }
            }
            if (dy == nextLeafY) {
                final int lx = (int)(x + MathHelper.func_76126_a((dy + yOffset) * cScale) * (radius + stalkThickness));
                final int lz = (int)(z + MathHelper.func_76134_b((dy + yOffset) * cScale) * (radius + stalkThickness));
                this.placeLeaves(world, new BlockPos(lx, dy, lz));
                nextLeafY = dy + 5 + world.field_73012_v.nextInt(10);
            }
        }
    }
    
    private void placeLeaves(final World world, final BlockPos pos) {
        world.func_175656_a(pos, ((Block)TFBlocks.huge_stalk.get()).func_176223_P());
        for (int dx = -1; dx <= 1; ++dx) {
            for (int dz = -1; dz <= 1; ++dz) {
                this.tryToPlaceLeaves(world, pos.func_177982_a(dx, -1, dz));
                this.tryToPlaceLeaves(world, pos.func_177982_a(dx, 1, dz));
            }
        }
        for (int dx = -2; dx <= 2; ++dx) {
            for (int dz = -2; dz <= 2; ++dz) {
                if ((dx != 2 && dx != -2) || (dz != 2 && dz != -2)) {
                    this.tryToPlaceLeaves(world, pos.func_177982_a(dx, 0, dz));
                }
            }
        }
    }
    
    private boolean tryToPlaceStalk(final World world, final BlockPos pos) {
        final BlockState state = world.func_180495_p(pos);
        if (state.func_177230_c().isAir(state, (IBlockReader)world, pos) || state.func_185904_a().func_76222_j() || state.func_177230_c().canBeReplacedByLeaves(state, (IWorldReader)world, pos) || BlockTags.field_206952_E.func_230235_a_((Object)state.func_177230_c())) {
            world.func_175656_a(pos, ((Block)TFBlocks.huge_stalk.get()).func_176223_P());
            return true;
        }
        return false;
    }
    
    private void tryToPlaceLeaves(final World world, final BlockPos pos) {
        final BlockState state = world.func_180495_p(pos);
        if (state.func_177230_c().canBeReplacedByLeaves(state, (IWorldReader)world, pos)) {
            world.func_180501_a(pos, ((Block)TFBlocks.beanstalk_leaves.get()).func_176223_P(), 2);
        }
    }
}
