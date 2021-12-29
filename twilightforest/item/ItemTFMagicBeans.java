// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.Leaves3Variant;
import twilightforest.block.BlockTFLeaves3;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.MathHelper;
import twilightforest.world.WorldProviderTwilightForest;
import javax.annotation.Nonnull;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.entity.player.EntityPlayerMP;
import twilightforest.block.TFBlocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;

public class ItemTFMagicBeans extends ItemTF
{
    @Nonnull
    public EnumActionResult func_180614_a(final EntityPlayer player, final World world, final BlockPos pos, final EnumHand hand, final EnumFacing side, final float hitX, final float hitY, final float hitZ) {
        final Block blockAt = world.func_180495_p(pos).func_177230_c();
        final int minY = pos.func_177956_o() + 1;
        final int maxY = Math.max(pos.func_177956_o() + 100, (int)(this.getCloudHeight(world) + 25.0f));
        if (pos.func_177956_o() < maxY && blockAt == TFBlocks.uberous_soil) {
            if (!world.field_72995_K) {
                final ItemStack is = player.func_184586_b(hand);
                is.func_190918_g(1);
                this.makeHugeStalk(world, pos, minY, maxY);
                if (player instanceof EntityPlayerMP) {
                    TFAdvancements.ITEM_USE_TRIGGER.trigger((EntityPlayerMP)player, is, world, pos);
                }
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
    
    private float getCloudHeight(final World world) {
        if (world.field_73011_w instanceof WorldProviderTwilightForest) {
            return ((WorldProviderTwilightForest)world.field_73011_w).func_76571_f();
        }
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
        world.func_175656_a(pos, TFBlocks.huge_stalk.func_176223_P());
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
        final IBlockState state = world.func_180495_p(pos);
        if (state.func_177230_c().isAir(state, (IBlockAccess)world, pos) || state.func_177230_c().func_176200_f((IBlockAccess)world, pos) || state.func_177230_c().canBeReplacedByLeaves(state, (IBlockAccess)world, pos) || state.func_177230_c().isLeaves(state, (IBlockAccess)world, pos) || state.func_177230_c().canSustainLeaves(state, (IBlockAccess)world, pos)) {
            world.func_175656_a(pos, TFBlocks.huge_stalk.func_176223_P());
            return true;
        }
        return false;
    }
    
    private void tryToPlaceLeaves(final World world, final BlockPos pos) {
        final IBlockState state = world.func_180495_p(pos);
        if (state.func_177230_c().isAir(state, (IBlockAccess)world, pos) || state.func_177230_c().canBeReplacedByLeaves(state, (IBlockAccess)world, pos)) {
            world.func_180501_a(pos, TFBlocks.twilight_leaves_3.func_176223_P().func_177226_a((IProperty)BlockTFLeaves3.VARIANT, (Comparable)Leaves3Variant.BEANSTALK).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false), 2);
        }
    }
}
