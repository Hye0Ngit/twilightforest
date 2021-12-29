// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.IBlockAccess;
import twilightforest.block.TFBlocks;
import net.minecraftforge.common.util.ForgeDirection;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenThorns extends TFGenerator
{
    private static final int MAX_SPREAD = 7;
    private static final int CHANCE_OF_BRANCH = 3;
    private static final int CHANCE_OF_LEAF = 3;
    private static final int CHANCE_LEAF_IS_ROSE = 50;
    
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        final int nextLength = 2 + rand.nextInt(4);
        final int maxLength = 2 + rand.nextInt(4) + rand.nextInt(4) + rand.nextInt(4);
        this.placeThorns(world, rand, x, y, z, nextLength, ForgeDirection.UP, maxLength, x, y, z);
        return true;
    }
    
    private void placeThorns(final World world, final Random rand, final int x, final int y, final int z, final int length, final ForgeDirection dir, final int maxLength, final int ox, final int oy, final int oz) {
        boolean complete = false;
        for (int i = 0; i < length; ++i) {
            final int dx = x + dir.offsetX * i;
            final int dy = y + dir.offsetY * i;
            final int dz = z + dir.offsetZ * i;
            if (Math.abs(dx - ox) >= 7 || Math.abs(dz - oz) >= 7 || !this.canPlaceThorns(world, dx, dy, dz)) {
                break;
            }
            this.setBlockAndMetadata(world, dx, dy, dz, TFBlocks.thorns, this.getMetaFor(dir));
            if (i == length - 1) {
                complete = true;
                if (rand.nextInt(3) == 0 && world.func_147437_c(dx + dir.offsetX, dy + dir.offsetY, dz + dir.offsetZ)) {
                    if (rand.nextInt(50) > 0) {
                        this.setBlockAndMetadata(world, dx + dir.offsetX, dy + dir.offsetY, dz + dir.offsetZ, TFBlocks.leaves3, 0);
                    }
                    else {
                        this.setBlock(world, dx + dir.offsetX, dy + dir.offsetY, dz + dir.offsetZ, TFBlocks.thornRose);
                    }
                }
            }
        }
        if (complete && maxLength > 1) {
            final ForgeDirection nextDir = ForgeDirection.VALID_DIRECTIONS[rand.nextInt(ForgeDirection.VALID_DIRECTIONS.length)];
            final int nextX = x + dir.offsetX * (length - 1) + nextDir.offsetX;
            final int nextY = y + dir.offsetY * (length - 1) + nextDir.offsetY;
            final int nextZ = z + dir.offsetZ * (length - 1) + nextDir.offsetZ;
            final int nextLength = 1 + rand.nextInt(maxLength);
            this.placeThorns(world, rand, nextX, nextY, nextZ, nextLength, nextDir, maxLength - 1, ox, oy, oz);
        }
        if (complete && length > 3 && rand.nextInt(3) == 0) {
            final int middle = rand.nextInt(length);
            final ForgeDirection nextDir2 = ForgeDirection.VALID_DIRECTIONS[rand.nextInt(ForgeDirection.VALID_DIRECTIONS.length)];
            final int nextX2 = x + dir.offsetX * middle + nextDir2.offsetX;
            final int nextY2 = y + dir.offsetY * middle + nextDir2.offsetY;
            final int nextZ2 = z + dir.offsetZ * middle + nextDir2.offsetZ;
            final int nextLength2 = 1 + rand.nextInt(maxLength);
            this.placeThorns(world, rand, nextX2, nextY2, nextZ2, nextLength2, nextDir2, maxLength - 1, ox, oy, oz);
        }
        if (complete && length > 3 && rand.nextInt(3) == 0) {
            final int middle = rand.nextInt(length);
            final ForgeDirection nextDir2 = ForgeDirection.VALID_DIRECTIONS[rand.nextInt(ForgeDirection.VALID_DIRECTIONS.length)];
            final int nextX2 = x + dir.offsetX * middle + nextDir2.offsetX;
            final int nextY2 = y + dir.offsetY * middle + nextDir2.offsetY;
            final int nextZ2 = z + dir.offsetZ * middle + nextDir2.offsetZ;
            if (world.func_147437_c(nextX2, nextY2, nextZ2)) {
                this.setBlockAndMetadata(world, nextX2, nextY2, nextZ2, TFBlocks.leaves3, 0);
            }
        }
    }
    
    private boolean canPlaceThorns(final World world, final int dx, final int dy, final int dz) {
        return world.func_147437_c(dx, dy, dz) || world.func_147439_a(dx, dy, dz).isLeaves((IBlockAccess)world, dx, dy, dz);
    }
    
    private int getMetaFor(final ForgeDirection dir) {
        switch (dir) {
            default: {
                return 0;
            }
            case EAST:
            case WEST: {
                return 4;
            }
            case NORTH:
            case SOUTH: {
                return 8;
            }
        }
    }
}
