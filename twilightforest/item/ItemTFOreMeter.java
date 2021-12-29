// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import java.util.List;
import net.minecraft.world.chunk.Chunk;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFOreMeter extends ItemTF
{
    protected ItemTFOreMeter(final int par1) {
        super(par1);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World world, final EntityPlayer player) {
        final int useX = MathHelper.func_76128_c(player.field_70165_t);
        final int useZ = MathHelper.func_76128_c(player.field_70161_v);
        if (!world.field_72995_K) {
            this.countOreInArea(player, world, useX, useZ, 3);
        }
        return super.func_77659_a(par1ItemStack, world, player);
    }
    
    private void countOreInChunk(final EntityPlayer player, final World world, final int useX, final int useZ) {
        final int chunkX = useX >> 4;
        final int chunkZ = useZ >> 4;
        final int countStone = this.countBlockInChunk(world, Block.field_71981_t.field_71990_ca, chunkX, chunkZ);
        final int countDirt = this.countBlockInChunk(world, Block.field_71979_v.field_71990_ca, chunkX, chunkZ);
        final int countGravel = this.countBlockInChunk(world, Block.field_71940_F.field_71990_ca, chunkX, chunkZ);
        final int countCoal = this.countBlockInChunk(world, Block.field_71950_I.field_71990_ca, chunkX, chunkZ);
        final int countIron = this.countBlockInChunk(world, Block.field_71949_H.field_71990_ca, chunkX, chunkZ);
        final int countGold = this.countBlockInChunk(world, Block.field_71941_G.field_71990_ca, chunkX, chunkZ);
        final int countDiamond = this.countBlockInChunk(world, Block.field_72073_aw.field_71990_ca, chunkX, chunkZ);
        final int countLapis = this.countBlockInChunk(world, Block.field_71947_N.field_71990_ca, chunkX, chunkZ);
        final int countRedstone = this.countBlockInChunk(world, Block.field_72047_aN.field_71990_ca, chunkX, chunkZ);
        final int countRoots = this.countBlockInChunk(world, TFBlocks.root.field_71990_ca, 0, chunkX, chunkZ);
        final int countOreRoots = this.countBlockInChunk(world, TFBlocks.root.field_71990_ca, 1, chunkX, chunkZ);
        final int total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone + countRoots + countOreRoots;
        player.func_71035_c("Ore Meter!");
        player.func_71035_c("Metering chunk  [" + chunkX + ", " + chunkZ + "]");
        player.func_71035_c("Coal - " + countCoal + " " + this.percent(countCoal, total));
        player.func_71035_c("Iron - " + countIron + " " + this.percent(countIron, total));
        player.func_71035_c("Gold - " + countGold + " " + this.percent(countGold, total));
        player.func_71035_c("Diamond - " + countDiamond + " " + this.percent(countDiamond, total));
        player.func_71035_c("Lapis - " + countLapis + " " + this.percent(countLapis, total));
        player.func_71035_c("Redstone - " + countRedstone + " " + this.percent(countRedstone, total));
        player.func_71035_c("Roots - " + countRoots + " " + this.percent(countRoots, total));
        player.func_71035_c("Ore Roots - " + countOreRoots + " " + this.percent(countOreRoots, total));
    }
    
    private void countOreInArea(final EntityPlayer player, final World world, final int useX, final int useZ, final int radius) {
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
                countStone += this.countBlockInChunk(world, Block.field_71981_t.field_71990_ca, cx, cz);
                countDirt += this.countBlockInChunk(world, Block.field_71979_v.field_71990_ca, cx, cz);
                countGravel += this.countBlockInChunk(world, Block.field_71940_F.field_71990_ca, cx, cz);
                countCoal += this.countBlockInChunk(world, Block.field_71950_I.field_71990_ca, cx, cz);
                countIron += this.countBlockInChunk(world, Block.field_71949_H.field_71990_ca, cx, cz);
                countGold += this.countBlockInChunk(world, Block.field_71941_G.field_71990_ca, cx, cz);
                countDiamond += this.countBlockInChunk(world, Block.field_72073_aw.field_71990_ca, cx, cz);
                countLapis += this.countBlockInChunk(world, Block.field_71947_N.field_71990_ca, cx, cz);
                countRedstone += this.countBlockInChunk(world, Block.field_72047_aN.field_71990_ca, cx, cz);
                countExposedDiamond += this.countExposedBlockInChunk(world, Block.field_72073_aw.field_71990_ca, cx, cz);
                countRoots += this.countBlockInChunk(world, TFBlocks.root.field_71990_ca, 0, cx, cz);
                countOreRoots += this.countBlockInChunk(world, TFBlocks.root.field_71990_ca, 1, cx, cz);
            }
        }
        total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone + countRoots + countOreRoots;
        player.func_71035_c("Ore Meter!");
        player.func_71035_c("Metering chunks in radius " + radius + " around chunk [" + chunkX + ", " + chunkZ + "]");
        player.func_71035_c("Coal - " + countCoal + " " + this.percent(countCoal, total));
        player.func_71035_c("Iron - " + countIron + " " + this.percent(countIron, total));
        player.func_71035_c("Gold - " + countGold + " " + this.percent(countGold, total));
        player.func_71035_c("Diamond - " + countDiamond + " " + this.percent(countDiamond, total) + ", exposed - " + countExposedDiamond);
        player.func_71035_c("Lapis - " + countLapis + " " + this.percent(countLapis, total));
        player.func_71035_c("Redstone - " + countRedstone + " " + this.percent(countRedstone, total));
        player.func_71035_c("Roots - " + countRoots + " " + this.percent(countRoots, total));
        player.func_71035_c("Ore Roots - " + countOreRoots + " " + this.percent(countOreRoots, total));
    }
    
    public float percent(final int count, final int total) {
        return count / (float)total * 100.0f;
    }
    
    public int countBlockInChunk(final World world, final int blockID, final int cx, final int cz) {
        final Chunk chunk = world.func_72964_e(cx, cz);
        int count = 0;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    if (chunk.func_76610_a(x, y, z) == blockID) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    public int countBlockInChunk(final World world, final int blockID, final int meta, final int cx, final int cz) {
        final Chunk chunk = world.func_72964_e(cx, cz);
        int count = 0;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    if (chunk.func_76610_a(x, y, z) == blockID && chunk.func_76628_c(x, y, z) == meta) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    private int countExposedBlockInChunk(final World world, final int blockID, final int cx, final int cz) {
        int count = 0;
        for (int x = cx << 4; x < (cx << 4) + 16; ++x) {
            for (int z = cz << 4; z < (cz << 4) + 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    if (world.func_72798_a(x, y, z) == blockID && (world.func_72799_c(x + 1, y, z) || world.func_72799_c(x - 1, y, z) || world.func_72799_c(x, y + 1, z) || world.func_72799_c(x, y - 1, z) || world.func_72799_c(x, y + 1, z) || world.func_72799_c(x, y - 1, z))) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
    }
}
