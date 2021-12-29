// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ItemBlockTFPlant extends vd
{
    public ItemBlockTFPlant(final int par1) {
        super(par1);
        this.a(true);
        this.g(0);
    }
    
    public int b(final int i) {
        final int j = gk.a(i, 0, 15);
        return TFBlocks.plant.a(2, j);
    }
    
    public String a(final aan itemstack) {
        final int meta = itemstack.i();
        return super.e() + "." + meta;
    }
    
    public int a(final int i) {
        return i;
    }
    
    public boolean a(final aan itemStack, final yw player, final xd world, final int x, final int y, final int z, final int direction) {
        final int meta = itemStack.i();
        if (meta == 14 || meta == 13) {
            return this.onItemUseRoot(itemStack, player, world, x, y, z, direction);
        }
        return super.a(itemStack, player, world, x, y, z, direction);
    }
    
    public boolean onItemUseRoot(final aan itemStack, final yw player, final xd world, int x, int y, int z, int direction) {
        final int blockThereId = world.a(x, y, z);
        if (blockThereId == pb.aS.bO) {
            direction = 1;
        }
        else if (!pb.m[blockThereId].cd.i()) {
            if (direction == 0) {
                --y;
            }
            if (direction == 1) {
                ++y;
            }
            if (direction == 2) {
                --z;
            }
            if (direction == 3) {
                ++z;
            }
            if (direction == 4) {
                --x;
            }
            if (direction == 5) {
                ++x;
            }
        }
        if (!player.e(x, y, z)) {
            return false;
        }
        if (itemStack.a == 0) {
            return false;
        }
        if (BlockTFPlant.canPlaceRootBelow(world, x, y + 1, z)) {
            final pb plantBlock = TFBlocks.plant;
            if (world.d(x, y, z, plantBlock.bO, itemStack.a().a(itemStack.i()))) {
                if (world.a(x, y, z) == plantBlock.bO) {
                    plantBlock.c(world, x, y, z, direction);
                    plantBlock.a(world, x, y, z, (acq)player);
                }
                world.a((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), plantBlock.cb.d(), (plantBlock.cb.b() + 1.0f) / 2.0f, plantBlock.cb.c() * 0.8f);
                --itemStack.a;
            }
        }
        return true;
    }
}
