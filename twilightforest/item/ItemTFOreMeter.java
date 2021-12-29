// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.List;
import twilightforest.block.TFBlocks;

public class ItemTFOreMeter extends ItemTF
{
    protected ItemTFOreMeter(final int par1) {
        super(par1);
        this.a((tj)TFItems.creativeTab);
    }
    
    public ur a(final ur par1ItemStack, final yc world, final qx player) {
        final int useX = ke.c(player.t);
        final int useZ = ke.c(player.v);
        if (!world.I) {
            this.countOreInArea(player, world, useX, useZ, 3);
        }
        return super.a(par1ItemStack, world, player);
    }
    
    private void countOreInChunk(final qx player, final yc world, final int useX, final int useZ) {
        final int chunkX = useX >> 4;
        final int chunkZ = useZ >> 4;
        final int countStone = this.countBlockInChunk(world, amq.w.cm, chunkX, chunkZ);
        final int countDirt = this.countBlockInChunk(world, amq.y.cm, chunkX, chunkZ);
        final int countGravel = this.countBlockInChunk(world, amq.I.cm, chunkX, chunkZ);
        final int countCoal = this.countBlockInChunk(world, amq.L.cm, chunkX, chunkZ);
        final int countIron = this.countBlockInChunk(world, amq.K.cm, chunkX, chunkZ);
        final int countGold = this.countBlockInChunk(world, amq.J.cm, chunkX, chunkZ);
        final int countDiamond = this.countBlockInChunk(world, amq.az.cm, chunkX, chunkZ);
        final int countLapis = this.countBlockInChunk(world, amq.Q.cm, chunkX, chunkZ);
        final int countRedstone = this.countBlockInChunk(world, amq.aQ.cm, chunkX, chunkZ);
        final int countRoots = this.countBlockInChunk(world, TFBlocks.log.cm, 5, chunkX, chunkZ);
        final int countOreRoots = this.countBlockInChunk(world, TFBlocks.log.cm, 6, chunkX, chunkZ);
        final int total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone + countRoots + countOreRoots;
        player.b("Ore Meter!");
        player.b("Metering chunk  [" + chunkX + ", " + chunkZ + "]");
        player.b("Coal - " + countCoal + " " + this.percent(countCoal, total));
        player.b("Iron - " + countIron + " " + this.percent(countIron, total));
        player.b("Gold - " + countGold + " " + this.percent(countGold, total));
        player.b("Diamond - " + countDiamond + " " + this.percent(countDiamond, total));
        player.b("Lapis - " + countLapis + " " + this.percent(countLapis, total));
        player.b("Redstone - " + countRedstone + " " + this.percent(countRedstone, total));
        player.b("Roots - " + countRoots + " " + this.percent(countRoots, total));
        player.b("Ore Roots - " + countOreRoots + " " + this.percent(countOreRoots, total));
    }
    
    private void countOreInArea(final qx player, final yc world, final int useX, final int useZ, final int radius) {
        final int chunkX = useX >> 4;
        final int chunkZ = useZ >> 4;
        int countStone = 0;
        int countDirt = 0;
        int countGravel = 0;
        int countCoal = 0;
        int countIron = 0;
        int countGold = 0;
        int countDiamond = 0;
        int countLapis = 0;
        int countRedstone = 0;
        int countRoots = 0;
        int countOreRoots = 0;
        int total = 0;
        for (int cx = chunkX - radius; cx <= chunkX + radius; ++cx) {
            for (int cz = chunkZ - radius; cz <= chunkZ + radius; ++cz) {
                countStone += this.countBlockInChunk(world, amq.w.cm, chunkX, chunkZ);
                countDirt += this.countBlockInChunk(world, amq.y.cm, chunkX, chunkZ);
                countGravel += this.countBlockInChunk(world, amq.I.cm, chunkX, chunkZ);
                countCoal += this.countBlockInChunk(world, amq.L.cm, chunkX, chunkZ);
                countIron += this.countBlockInChunk(world, amq.K.cm, chunkX, chunkZ);
                countGold += this.countBlockInChunk(world, amq.J.cm, chunkX, chunkZ);
                countDiamond += this.countBlockInChunk(world, amq.az.cm, chunkX, chunkZ);
                countLapis += this.countBlockInChunk(world, amq.Q.cm, chunkX, chunkZ);
                countRedstone += this.countBlockInChunk(world, amq.aQ.cm, chunkX, chunkZ);
                countRoots += this.countBlockInChunk(world, TFBlocks.log.cm, 5, chunkX, chunkZ);
                countOreRoots += this.countBlockInChunk(world, TFBlocks.log.cm, 6, chunkX, chunkZ);
            }
        }
        total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone + countRoots + countOreRoots;
        player.b("Ore Meter!");
        player.b("Metering chunks in radius " + radius + " around chunk [" + chunkX + ", " + chunkZ + "]");
        player.b("Coal - " + countCoal + " " + this.percent(countCoal, total));
        player.b("Iron - " + countIron + " " + this.percent(countIron, total));
        player.b("Gold - " + countGold + " " + this.percent(countGold, total));
        player.b("Diamond - " + countDiamond + " " + this.percent(countDiamond, total));
        player.b("Lapis - " + countLapis + " " + this.percent(countLapis, total));
        player.b("Redstone - " + countRedstone + " " + this.percent(countRedstone, total));
        player.b("Roots - " + countRoots + " " + this.percent(countRoots, total));
        player.b("Ore Roots - " + countOreRoots + " " + this.percent(countOreRoots, total));
    }
    
    public float percent(final int count, final int total) {
        return count / (float)total * 100.0f;
    }
    
    public int countBlockInChunk(final yc world, final int blockID, final int cx, final int cz) {
        final zz chunk = world.e(cx, cz);
        int count = 0;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    if (chunk.a(x, y, z) == blockID) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    public int countBlockInChunk(final yc world, final int blockID, final int meta, final int cx, final int cz) {
        final zz chunk = world.e(cx, cz);
        int count = 0;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    if (chunk.a(x, y, z) == blockID && chunk.c(x, y, z) == meta) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    public void a(final ur par1ItemStack, final qx par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
    }
}
