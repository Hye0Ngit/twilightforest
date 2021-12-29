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
        this.a((uy)TFItems.creativeTab);
    }
    
    public wg a(final wg par1ItemStack, final zv world, final sk player) {
        final int useX = kx.c(player.u);
        final int useZ = kx.c(player.w);
        if (!world.I) {
            this.countOreInArea(player, world, useX, useZ, 3);
        }
        return super.a(par1ItemStack, world, player);
    }
    
    private void countOreInChunk(final sk player, final zv world, final int useX, final int useZ) {
        final int chunkX = useX >> 4;
        final int chunkZ = useZ >> 4;
        final int countStone = this.countBlockInChunk(world, aou.x.cz, chunkX, chunkZ);
        final int countDirt = this.countBlockInChunk(world, aou.z.cz, chunkX, chunkZ);
        final int countGravel = this.countBlockInChunk(world, aou.J.cz, chunkX, chunkZ);
        final int countCoal = this.countBlockInChunk(world, aou.M.cz, chunkX, chunkZ);
        final int countIron = this.countBlockInChunk(world, aou.L.cz, chunkX, chunkZ);
        final int countGold = this.countBlockInChunk(world, aou.K.cz, chunkX, chunkZ);
        final int countDiamond = this.countBlockInChunk(world, aou.aA.cz, chunkX, chunkZ);
        final int countLapis = this.countBlockInChunk(world, aou.R.cz, chunkX, chunkZ);
        final int countRedstone = this.countBlockInChunk(world, aou.aR.cz, chunkX, chunkZ);
        final int countRoots = this.countBlockInChunk(world, TFBlocks.log.cz, 5, chunkX, chunkZ);
        final int countOreRoots = this.countBlockInChunk(world, TFBlocks.log.cz, 6, chunkX, chunkZ);
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
    
    private void countOreInArea(final sk player, final zv world, final int useX, final int useZ, final int radius) {
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
                countStone += this.countBlockInChunk(world, aou.x.cz, chunkX, chunkZ);
                countDirt += this.countBlockInChunk(world, aou.z.cz, chunkX, chunkZ);
                countGravel += this.countBlockInChunk(world, aou.J.cz, chunkX, chunkZ);
                countCoal += this.countBlockInChunk(world, aou.M.cz, chunkX, chunkZ);
                countIron += this.countBlockInChunk(world, aou.L.cz, chunkX, chunkZ);
                countGold += this.countBlockInChunk(world, aou.K.cz, chunkX, chunkZ);
                countDiamond += this.countBlockInChunk(world, aou.aA.cz, chunkX, chunkZ);
                countLapis += this.countBlockInChunk(world, aou.R.cz, chunkX, chunkZ);
                countRedstone += this.countBlockInChunk(world, aou.aR.cz, chunkX, chunkZ);
                countRoots += this.countBlockInChunk(world, TFBlocks.log.cz, 5, chunkX, chunkZ);
                countOreRoots += this.countBlockInChunk(world, TFBlocks.log.cz, 6, chunkX, chunkZ);
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
    
    public int countBlockInChunk(final zv world, final int blockID, final int cx, final int cz) {
        final abq chunk = world.e(cx, cz);
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
    
    public int countBlockInChunk(final zv world, final int blockID, final int meta, final int cx, final int cz) {
        final abq chunk = world.e(cx, cz);
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
    
    public void a(final wg par1ItemStack, final sk par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
