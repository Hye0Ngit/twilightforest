// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemTFMagicBeans extends ItemTF
{
    public ItemTFMagicBeans() {
        this.makeRare();
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer player, final World world, final int x, final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ) {
        final Block blockAt = world.func_147439_a(x, y, z);
        final int minY = y + 1;
        final int maxY = Math.max(y + 100, (int)(this.getCloudHeight(world) + 25.0f));
        if (y < maxY && blockAt == TFBlocks.uberousSoil) {
            if (!world.field_72995_K) {
                this.makeHugeStalk(world, x, z, minY, maxY);
            }
            return true;
        }
        return false;
    }
    
    private float getCloudHeight(final World world) {
        if (world.field_73011_w instanceof WorldProviderTwilightForest) {
            return ((WorldProviderTwilightForest)world.field_73011_w).func_76571_f();
        }
        try {
            return world.field_73011_w.func_76571_f();
        }
        catch (NoSuchMethodError nsme) {
            return world.field_73011_w.field_76577_b.getCloudHeight();
        }
    }
    
    private void makeHugeStalk(final World world, int x, int z, final int minY, final int maxY) {
        final int yOffset = world.field_73012_v.nextInt(100);
        final float cScale = world.field_73012_v.nextFloat() * 0.25f + 0.125f;
        final float rScale = world.field_73012_v.nextFloat() * 0.25f + 0.125f;
        float radius = 4.0f + MathHelper.func_76126_a((minY + yOffset) * rScale) * 3.0f;
        x -= (int)(MathHelper.func_76126_a((minY + yOffset) * cScale) * radius);
        z -= (int)(MathHelper.func_76134_b((minY + yOffset) * cScale) * radius);
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
                        isClear &= this.tryToPlaceStalk(world, dx, dy, dz);
                    }
                }
            }
            if (dy == nextLeafY) {
                final int lx = (int)(x + MathHelper.func_76126_a((dy + yOffset) * cScale) * (radius + stalkThickness));
                final int lz = (int)(z + MathHelper.func_76134_b((dy + yOffset) * cScale) * (radius + stalkThickness));
                this.placeLeaves(world, lx, dy, lz);
                nextLeafY = dy + 5 + world.field_73012_v.nextInt(10);
            }
        }
    }
    
    private void placeLeaves(final World world, final int x, final int y, final int z) {
        world.func_147449_b(x, y, z, TFBlocks.hugeStalk);
        for (int dx = -1; dx <= 1; ++dx) {
            for (int dz = -1; dz <= 1; ++dz) {
                this.tryToPlaceLeaves(world, x + dx, y - 1, z + dz);
                this.tryToPlaceLeaves(world, x + dx, y + 1, z + dz);
            }
        }
        for (int dx = -2; dx <= 2; ++dx) {
            for (int dz = -2; dz <= 2; ++dz) {
                if ((dx != 2 && dx != -2) || (dz != 2 && dz != -2)) {
                    this.tryToPlaceLeaves(world, x + dx, y + 0, z + dz);
                }
            }
        }
    }
    
    private boolean tryToPlaceStalk(final World world, final int x, final int y, final int z) {
        final Block blockThere = world.func_147439_a(x, y, z);
        if (blockThere == Blocks.field_150350_a || blockThere.isReplaceable((IBlockAccess)world, x, y, z) || blockThere.canBeReplacedByLeaves((IBlockAccess)world, x, y, z) || blockThere.isLeaves((IBlockAccess)world, x, y, z) || blockThere.canSustainLeaves((IBlockAccess)world, x, y, z)) {
            world.func_147449_b(x, y, z, TFBlocks.hugeStalk);
            return true;
        }
        return false;
    }
    
    private void tryToPlaceLeaves(final World world, final int x, final int y, final int z) {
        final Block blockThere = world.func_147439_a(x, y, z);
        if (blockThere == Blocks.field_150350_a || blockThere.canBeReplacedByLeaves((IBlockAccess)world, x, y, z)) {
            world.func_147465_d(x, y, z, TFBlocks.leaves3, 1, 2);
        }
    }
}
