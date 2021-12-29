// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import java.util.List;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFOreMeter extends ItemTF
{
    protected ItemTFOreMeter() {
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
        final int countStone = this.countBlockInChunk(world, Blocks.field_150348_b, chunkX, chunkZ);
        final int countDirt = this.countBlockInChunk(world, Blocks.field_150346_d, chunkX, chunkZ);
        final int countGravel = this.countBlockInChunk(world, Blocks.field_150351_n, chunkX, chunkZ);
        final int countCoal = this.countBlockInChunk(world, Blocks.field_150365_q, chunkX, chunkZ);
        final int countIron = this.countBlockInChunk(world, Blocks.field_150366_p, chunkX, chunkZ);
        final int countGold = this.countBlockInChunk(world, Blocks.field_150352_o, chunkX, chunkZ);
        final int countDiamond = this.countBlockInChunk(world, Blocks.field_150482_ag, chunkX, chunkZ);
        final int countLapis = this.countBlockInChunk(world, Blocks.field_150369_x, chunkX, chunkZ);
        final int countRedstone = this.countBlockInChunk(world, Blocks.field_150450_ax, chunkX, chunkZ);
        final int countRoots = this.countBlockInChunk(world, TFBlocks.root, 0, chunkX, chunkZ);
        final int countOreRoots = this.countBlockInChunk(world, TFBlocks.root, 1, chunkX, chunkZ);
        final int total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone + countRoots + countOreRoots;
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
                countStone += this.countBlockInChunk(world, Blocks.field_150348_b, cx, cz);
                countDirt += this.countBlockInChunk(world, Blocks.field_150346_d, cx, cz);
                countGravel += this.countBlockInChunk(world, Blocks.field_150351_n, cx, cz);
                countCoal += this.countBlockInChunk(world, Blocks.field_150365_q, cx, cz);
                countIron += this.countBlockInChunk(world, Blocks.field_150366_p, cx, cz);
                countGold += this.countBlockInChunk(world, Blocks.field_150352_o, cx, cz);
                countDiamond += this.countBlockInChunk(world, Blocks.field_150482_ag, cx, cz);
                countLapis += this.countBlockInChunk(world, Blocks.field_150369_x, cx, cz);
                countRedstone += this.countBlockInChunk(world, Blocks.field_150450_ax, cx, cz);
                countExposedDiamond += this.countExposedBlockInChunk(world, Blocks.field_150482_ag, cx, cz);
                countRoots += this.countBlockInChunk(world, TFBlocks.root, 0, cx, cz);
                countOreRoots += this.countBlockInChunk(world, TFBlocks.root, 1, cx, cz);
            }
        }
        total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone + countRoots + countOreRoots;
    }
    
    public float percent(final int count, final int total) {
        return count / (float)total * 100.0f;
    }
    
    public int countBlockInChunk(final World world, final Block stone, final int cx, final int cz) {
        final Chunk chunk = world.func_72964_e(cx, cz);
        int count = 0;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    if (chunk.func_150810_a(x, y, z) == stone) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    public int countBlockInChunk(final World world, final Block blockID, final int meta, final int cx, final int cz) {
        final Chunk chunk = world.func_72964_e(cx, cz);
        int count = 0;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    if (chunk.func_150810_a(x, y, z) == blockID && chunk.func_76628_c(x, y, z) == meta) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    private int countExposedBlockInChunk(final World world, final Block blockID, final int cx, final int cz) {
        int count = 0;
        for (int x = cx << 4; x < (cx << 4) + 16; ++x) {
            for (int z = cz << 4; z < (cz << 4) + 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    if (world.func_147439_a(x, y, z) == blockID && (world.func_147437_c(x + 1, y, z) || world.func_147437_c(x - 1, y, z) || world.func_147437_c(x, y + 1, z) || world.func_147437_c(x, y - 1, z) || world.func_147437_c(x, y + 1, z) || world.func_147437_c(x, y - 1, z))) {
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
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
