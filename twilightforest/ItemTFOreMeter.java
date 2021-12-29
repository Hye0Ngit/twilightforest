// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public class ItemTFOreMeter extends ItemTF
{
    protected ItemTFOreMeter(final int par1) {
        super(par1);
    }
    
    public boolean a(final aan par1ItemStack, final yw player, final xd world, final int useX, final int useY, final int useZ, final int side) {
        if (!world.F) {
            this.countOreInArea(player, world, useX, useZ, 3);
        }
        return true;
    }
    
    private void countOreInChunk(final yw player, final xd world, final int useX, final int useZ) {
        final int chunkX = useX >> 4;
        final int chunkZ = useZ >> 4;
        final int countStone = this.countBlockInChunk(world, pb.t.bO, chunkX, chunkZ);
        final int countDirt = this.countBlockInChunk(world, pb.v.bO, chunkX, chunkZ);
        final int countGravel = this.countBlockInChunk(world, pb.F.bO, chunkX, chunkZ);
        final int countCoal = this.countBlockInChunk(world, pb.I.bO, chunkX, chunkZ);
        final int countIron = this.countBlockInChunk(world, pb.H.bO, chunkX, chunkZ);
        final int countGold = this.countBlockInChunk(world, pb.G.bO, chunkX, chunkZ);
        final int countDiamond = this.countBlockInChunk(world, pb.aw.bO, chunkX, chunkZ);
        final int countLapis = this.countBlockInChunk(world, pb.N.bO, chunkX, chunkZ);
        final int countRedstone = this.countBlockInChunk(world, pb.aN.bO, chunkX, chunkZ);
        final int countRoots = this.countBlockInChunk(world, TFBlocks.wood.bO, 5, chunkX, chunkZ);
        final int countOreRoots = this.countBlockInChunk(world, TFBlocks.wood.bO, 6, chunkX, chunkZ);
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
    
    private void countOreInArea(final yw player, final xd world, final int useX, final int useZ, final int radius) {
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
                countStone += this.countBlockInChunk(world, pb.t.bO, chunkX, chunkZ);
                countDirt += this.countBlockInChunk(world, pb.v.bO, chunkX, chunkZ);
                countGravel += this.countBlockInChunk(world, pb.F.bO, chunkX, chunkZ);
                countCoal += this.countBlockInChunk(world, pb.I.bO, chunkX, chunkZ);
                countIron += this.countBlockInChunk(world, pb.H.bO, chunkX, chunkZ);
                countGold += this.countBlockInChunk(world, pb.G.bO, chunkX, chunkZ);
                countDiamond += this.countBlockInChunk(world, pb.aw.bO, chunkX, chunkZ);
                countLapis += this.countBlockInChunk(world, pb.N.bO, chunkX, chunkZ);
                countRedstone += this.countBlockInChunk(world, pb.aN.bO, chunkX, chunkZ);
                countRoots += this.countBlockInChunk(world, TFBlocks.wood.bO, 5, chunkX, chunkZ);
                countOreRoots += this.countBlockInChunk(world, TFBlocks.wood.bO, 6, chunkX, chunkZ);
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
    
    public int countBlockInChunk(final xd world, final int blockID, final int cx, final int cz) {
        final ack chunk = world.d(cx, cz);
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
    
    public int countBlockInChunk(final xd world, final int blockID, final int meta, final int cx, final int cz) {
        final ack chunk = world.d(cx, cz);
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
    
    public void a(final aan par1ItemStack, final List par2List) {
        super.a(par1ItemStack, par2List);
    }
}
