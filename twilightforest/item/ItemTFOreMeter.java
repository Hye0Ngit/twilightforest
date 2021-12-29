// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import twilightforest.block.TFBlocks;

public class ItemTFOreMeter extends ItemTF
{
    protected ItemTFOreMeter(final int par1) {
        super(par1);
        this.a((wv)TFItems.creativeTab);
    }
    
    public yd a(final yd par1ItemStack, final abv world, final ue player) {
        final int useX = lr.c(player.u);
        final int useZ = lr.c(player.w);
        if (!world.I) {
            this.countOreInArea(player, world, useX, useZ, 3);
        }
        return super.a(par1ItemStack, world, player);
    }
    
    private void countOreInChunk(final ue player, final abv world, final int useX, final int useZ) {
        final int chunkX = useX >> 4;
        final int chunkZ = useZ >> 4;
        final int countStone = this.countBlockInChunk(world, aqw.y.cF, chunkX, chunkZ);
        final int countDirt = this.countBlockInChunk(world, aqw.A.cF, chunkX, chunkZ);
        final int countGravel = this.countBlockInChunk(world, aqw.K.cF, chunkX, chunkZ);
        final int countCoal = this.countBlockInChunk(world, aqw.N.cF, chunkX, chunkZ);
        final int countIron = this.countBlockInChunk(world, aqw.M.cF, chunkX, chunkZ);
        final int countGold = this.countBlockInChunk(world, aqw.L.cF, chunkX, chunkZ);
        final int countDiamond = this.countBlockInChunk(world, aqw.aB.cF, chunkX, chunkZ);
        final int countLapis = this.countBlockInChunk(world, aqw.S.cF, chunkX, chunkZ);
        final int countRedstone = this.countBlockInChunk(world, aqw.aS.cF, chunkX, chunkZ);
        final int countRoots = this.countBlockInChunk(world, TFBlocks.root.cF, 0, chunkX, chunkZ);
        final int countOreRoots = this.countBlockInChunk(world, TFBlocks.root.cF, 1, chunkX, chunkZ);
        final int total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone + countRoots + countOreRoots;
        player.a("Ore Meter!");
        player.a("Metering chunk  [" + chunkX + ", " + chunkZ + "]");
        player.a("Coal - " + countCoal + " " + this.percent(countCoal, total));
        player.a("Iron - " + countIron + " " + this.percent(countIron, total));
        player.a("Gold - " + countGold + " " + this.percent(countGold, total));
        player.a("Diamond - " + countDiamond + " " + this.percent(countDiamond, total));
        player.a("Lapis - " + countLapis + " " + this.percent(countLapis, total));
        player.a("Redstone - " + countRedstone + " " + this.percent(countRedstone, total));
        player.a("Roots - " + countRoots + " " + this.percent(countRoots, total));
        player.a("Ore Roots - " + countOreRoots + " " + this.percent(countOreRoots, total));
    }
    
    private void countOreInArea(final ue player, final abv world, final int useX, final int useZ, final int radius) {
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
        int countExposedDiamond = 0;
        int countRoots = 0;
        int countOreRoots = 0;
        int total = 0;
        for (int cx = chunkX - radius; cx <= chunkX + radius; ++cx) {
            for (int cz = chunkZ - radius; cz <= chunkZ + radius; ++cz) {
                countStone += this.countBlockInChunk(world, aqw.y.cF, cx, cz);
                countDirt += this.countBlockInChunk(world, aqw.A.cF, cx, cz);
                countGravel += this.countBlockInChunk(world, aqw.K.cF, cx, cz);
                countCoal += this.countBlockInChunk(world, aqw.N.cF, cx, cz);
                countIron += this.countBlockInChunk(world, aqw.M.cF, cx, cz);
                countGold += this.countBlockInChunk(world, aqw.L.cF, cx, cz);
                countDiamond += this.countBlockInChunk(world, aqw.aB.cF, cx, cz);
                countLapis += this.countBlockInChunk(world, aqw.S.cF, cx, cz);
                countRedstone += this.countBlockInChunk(world, aqw.aS.cF, cx, cz);
                countExposedDiamond += this.countExposedBlockInChunk(world, aqw.aB.cF, cx, cz);
                countRoots += this.countBlockInChunk(world, TFBlocks.root.cF, 0, cx, cz);
                countOreRoots += this.countBlockInChunk(world, TFBlocks.root.cF, 1, cx, cz);
            }
        }
        total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone + countRoots + countOreRoots;
        player.a("Ore Meter!");
        player.a("Metering chunks in radius " + radius + " around chunk [" + chunkX + ", " + chunkZ + "]");
        player.a("Coal - " + countCoal + " " + this.percent(countCoal, total));
        player.a("Iron - " + countIron + " " + this.percent(countIron, total));
        player.a("Gold - " + countGold + " " + this.percent(countGold, total));
        player.a("Diamond - " + countDiamond + " " + this.percent(countDiamond, total) + ", exposed - " + countExposedDiamond);
        player.a("Lapis - " + countLapis + " " + this.percent(countLapis, total));
        player.a("Redstone - " + countRedstone + " " + this.percent(countRedstone, total));
        player.a("Roots - " + countRoots + " " + this.percent(countRoots, total));
        player.a("Ore Roots - " + countOreRoots + " " + this.percent(countOreRoots, total));
    }
    
    public float percent(final int count, final int total) {
        return count / (float)total * 100.0f;
    }
    
    public int countBlockInChunk(final abv world, final int blockID, final int cx, final int cz) {
        final adq chunk = world.e(cx, cz);
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
    
    public int countBlockInChunk(final abv world, final int blockID, final int meta, final int cx, final int cz) {
        final adq chunk = world.e(cx, cz);
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
    
    private int countExposedBlockInChunk(final abv world, final int blockID, final int cx, final int cz) {
        int count = 0;
        for (int x = cx << 4; x < (cx << 4) + 16; ++x) {
            for (int z = cz << 4; z < (cz << 4) + 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    if (world.a(x, y, z) == blockID && (world.c(x + 1, y, z) || world.c(x - 1, y, z) || world.c(x, y + 1, z) || world.c(x, y - 1, z) || world.c(x, y + 1, z) || world.c(x, y - 1, z))) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    public void a(final yd par1ItemStack, final ue par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
