// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.inventory.InventoryLargeChest;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import java.util.Iterator;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import java.util.ArrayList;
import twilightforest.item.ItemTFOreMagnet;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import twilightforest.TwilightForestMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import twilightforest.TFGenericPacketHandler;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.WorldServer;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;

public class BlockTFMagicLogSpecial extends BlockTFMagicLog
{
    protected BlockTFMagicLogSpecial() {
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int func_149738_a(final World par1World) {
        return 20;
    }
    
    public void func_149726_b(final World par1World, final int par2, final int par3, final int par4) {
        par1World.func_147464_a(par2, par3, par4, (Block)this, this.func_149738_a(par1World));
    }
    
    @Override
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return Item.func_150898_a(TFBlocks.magicLog);
    }
    
    @Override
    public IIcon func_149691_a(final int side, final int meta) {
        final int orient = meta & 0xC;
        final int woodType = meta & 0x3;
        if (orient == 12) {
            switch (woodType) {
                default: {
                    return (side == 1 || side == 0) ? BlockTFMagicLogSpecial.SPR_TIMETOP : BlockTFMagicLogSpecial.SPR_TIMECLOCKOFF;
                }
                case 1: {
                    return (side == 1 || side == 0) ? BlockTFMagicLogSpecial.SPR_TRANSTOP : BlockTFMagicLogSpecial.SPR_TRANSHEARTOFF;
                }
                case 2: {
                    return (side == 1 || side == 0) ? BlockTFMagicLogSpecial.SPR_MINETOP : BlockTFMagicLogSpecial.SPR_MINEGEMOFF;
                }
                case 3: {
                    return (side == 1 || side == 0) ? BlockTFMagicLogSpecial.SPR_SORTTOP : BlockTFMagicLogSpecial.SPR_SORTEYEOFF;
                }
            }
        }
        else {
            switch (woodType) {
                default: {
                    return (orient == 0 && (side == 1 || side == 0)) ? BlockTFMagicLogSpecial.SPR_TIMETOP : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFMagicLogSpecial.SPR_TIMETOP : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFMagicLogSpecial.SPR_TIMETOP : BlockTFMagicLogSpecial.SPR_TIMECLOCK));
                }
                case 1: {
                    return (orient == 0 && (side == 1 || side == 0)) ? BlockTFMagicLogSpecial.SPR_TRANSTOP : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFMagicLogSpecial.SPR_TRANSTOP : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFMagicLogSpecial.SPR_TRANSTOP : BlockTFMagicLogSpecial.SPR_TRANSHEART));
                }
                case 2: {
                    return (orient == 0 && (side == 1 || side == 0)) ? BlockTFMagicLogSpecial.SPR_MINETOP : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFMagicLogSpecial.SPR_MINETOP : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFMagicLogSpecial.SPR_MINETOP : BlockTFMagicLogSpecial.SPR_MINEGEM));
                }
                case 3: {
                    return (orient == 0 && (side == 1 || side == 0)) ? BlockTFMagicLogSpecial.SPR_SORTTOP : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFMagicLogSpecial.SPR_SORTTOP : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFMagicLogSpecial.SPR_SORTTOP : BlockTFMagicLogSpecial.SPR_SORTEYE));
                }
            }
        }
    }
    
    public void func_149674_a(final World world, final int x, final int y, final int z, final Random rand) {
        final int meta = world.func_72805_g(x, y, z);
        if ((meta & 0xC) == 0xC) {
            return;
        }
        if ((meta & 0x3) == 0x0 && !world.field_72995_K) {
            world.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.1f, 0.5f);
            this.doTreeOfTimeEffect(world, x, y, z, rand);
        }
        else if ((meta & 0x3) == 0x1 && !world.field_72995_K) {
            this.doTreeOfTransformationEffect(world, x, y, z, rand);
        }
        else if ((meta & 0x3) == 0x2 && !world.field_72995_K) {
            this.doMinersTreeEffect(world, x, y, z, rand);
        }
        else if ((meta & 0x3) == 0x3 && !world.field_72995_K) {
            this.doSortingTreeEffect(world, x, y, z, rand);
        }
        world.func_147464_a(x, y, z, (Block)this, this.func_149738_a(world));
    }
    
    public boolean func_149727_a(final World world, final int x, final int y, final int z, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        final int meta = world.func_72805_g(x, y, z);
        final int orient = meta & 0xC;
        final int woodType = meta & 0x3;
        if (orient == 0) {
            world.func_72921_c(x, y, z, woodType | 0xC, 3);
            return true;
        }
        if (orient == 12) {
            world.func_72921_c(x, y, z, woodType | 0x0, 3);
            world.func_147464_a(x, y, z, (Block)this, this.func_149738_a(world));
            return true;
        }
        return false;
    }
    
    private void doTreeOfTimeEffect(final World world, final int x, final int y, final int z, final Random rand) {
        final int numticks = 24 * this.func_149738_a(world);
        int successes = 0;
        for (int i = 0; i < numticks; ++i) {
            final int dx = rand.nextInt(32) - 16;
            final int dy = rand.nextInt(32) - 16;
            final int dz = rand.nextInt(32) - 16;
            final Block thereID = world.func_147439_a(x + dx, y + dy, z + dz);
            if (thereID != Blocks.field_150350_a && thereID.func_149653_t()) {
                thereID.func_149674_a(world, x + dx, y + dy, z + dz, rand);
                ++successes;
            }
        }
    }
    
    private void doTreeOfTransformationEffect(final World world, final int x, final int y, final int z, final Random rand) {
        for (int i = 0; i < 1; ++i) {
            final int dx = rand.nextInt(32) - 16;
            final int dz = rand.nextInt(32) - 16;
            world.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "note.harp", 0.1f, rand.nextFloat() * 2.0f);
            if (Math.sqrt(dx * dx + dz * dz) < 16.0) {
                final BiomeGenBase biomeAt = world.func_72807_a(x + dx, z + dz);
                if (biomeAt != TFBiomeBase.enchantedForest) {
                    final Chunk chunkAt = world.func_72938_d(x + dx, z + dz);
                    chunkAt.func_76605_m()[(z + dz & 0xF) << 4 | (x + dx & 0xF)] = (byte)TFBiomeBase.enchantedForest.field_76756_M;
                    world.func_147471_g(x + dx, y, z + dz);
                    if (world instanceof WorldServer) {
                        this.sendChangedBiome(world, x + dx, z + dz, chunkAt);
                    }
                }
            }
        }
    }
    
    private void sendChangedBiome(final World world, final int x, final int z, final Chunk chunkAt) {
        final FMLProxyPacket message = TFGenericPacketHandler.makeBiomeChangePacket(x, z, (byte)TFBiomeBase.enchantedForest.field_76756_M);
        final NetworkRegistry.TargetPoint targetPoint = new NetworkRegistry.TargetPoint(world.field_73011_w.field_76574_g, (double)x, 128.0, (double)z, 128.0);
        TwilightForestMod.genericChannel.sendToAllAround(message, targetPoint);
    }
    
    private void doMinersTreeEffect(final World world, final int x, final int y, final int z, final Random rand) {
        final int dx = rand.nextInt(64) - 32;
        final int dy = rand.nextInt(64) - 32;
        final int dz = rand.nextInt(64) - 32;
        final int moved = ItemTFOreMagnet.doMagnet(world, x, y, z, x + dx, y + dy, z + dz);
        if (moved > 0) {
            world.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "mob.endermen.portal", 0.1f, 1.0f);
        }
    }
    
    private void doSortingTreeEffect(final World world, final int x, final int y, final int z, final Random rand) {
        final int XSEARCH = 16;
        final int YSEARCH = 16;
        final int ZSEARCH = 16;
        final ArrayList<IInventory> chests = new ArrayList<IInventory>();
        int itemCount = 0;
        for (int sx = x - XSEARCH; sx < x + XSEARCH; ++sx) {
            for (int sy = y - YSEARCH; sy < y + YSEARCH; ++sy) {
                for (int sz = z - ZSEARCH; sz < z + ZSEARCH; ++sz) {
                    if (world.func_147439_a(sx, sy, sz) == Blocks.field_150486_ae) {
                        final IInventory thisChest = Blocks.field_150486_ae.func_149951_m(world, sx, sy, sz);
                        if (!this.checkIfChestsContains(chests, (IInventory)world.func_147438_o(sx, sy, sz))) {
                            int itemsInChest = 0;
                            for (int i = 0; i < thisChest.func_70302_i_(); ++i) {
                                if (thisChest.func_70301_a(i) != null) {
                                    ++itemsInChest;
                                    ++itemCount;
                                }
                            }
                            if (itemsInChest > 0) {
                                chests.add(thisChest);
                            }
                        }
                    }
                }
            }
        }
        ItemStack beingSorted = null;
        int sortedChestNum = -1;
        int sortedSlotNum = -1;
        if (itemCount > 0) {
            final int itemNumber = rand.nextInt(itemCount);
            int currentNumber = 0;
            for (int i = 0; i < chests.size(); ++i) {
                final IInventory chest = chests.get(i);
                for (int slotNum = 0; slotNum < chest.func_70302_i_(); ++slotNum) {
                    final ItemStack currentItem = chest.func_70301_a(slotNum);
                    if (currentItem != null && currentNumber++ == itemNumber) {
                        beingSorted = currentItem;
                        sortedChestNum = i;
                        sortedSlotNum = slotNum;
                    }
                }
            }
        }
        if (beingSorted != null) {
            int matchChestNum = -1;
            int matchCount = 0;
            for (int chestNum = 0; chestNum < chests.size(); ++chestNum) {
                final IInventory chest = chests.get(chestNum);
                int currentChestMatches = 0;
                for (int slotNum2 = 0; slotNum2 < chest.func_70302_i_(); ++slotNum2) {
                    final ItemStack currentItem2 = chest.func_70301_a(slotNum2);
                    if (currentItem2 != null && this.isSortingMatch(beingSorted, currentItem2)) {
                        currentChestMatches += currentItem2.field_77994_a;
                    }
                }
                if (currentChestMatches > matchCount) {
                    matchCount = currentChestMatches;
                    matchChestNum = chestNum;
                }
            }
            if (matchChestNum >= 0 && matchChestNum != sortedChestNum) {
                final IInventory moveChest = chests.get(matchChestNum);
                final IInventory oldChest = chests.get(sortedChestNum);
                final int moveSlot = this.getEmptySlotIn(moveChest);
                if (moveSlot >= 0) {
                    oldChest.func_70299_a(sortedSlotNum, (ItemStack)null);
                    moveChest.func_70299_a(moveSlot, beingSorted);
                }
            }
            if (beingSorted.field_77994_a < beingSorted.func_77976_d()) {
                for (final IInventory chest : chests) {
                    for (int slotNum = 0; slotNum < chest.func_70302_i_(); ++slotNum) {
                        final ItemStack currentItem = chest.func_70301_a(slotNum);
                        if (currentItem != null && currentItem != beingSorted && beingSorted.func_77969_a(currentItem) && currentItem.field_77994_a <= beingSorted.func_77976_d() - beingSorted.field_77994_a) {
                            chest.func_70299_a(slotNum, (ItemStack)null);
                            final ItemStack itemStack = beingSorted;
                            itemStack.field_77994_a += currentItem.field_77994_a;
                            currentItem.field_77994_a = 0;
                        }
                    }
                }
            }
        }
    }
    
    private boolean isSortingMatch(final ItemStack beingSorted, final ItemStack currentItem) {
        return this.getCreativeTab(currentItem.func_77973_b()) == this.getCreativeTab(beingSorted.func_77973_b());
    }
    
    private Object getCreativeTab(final Item item) {
        try {
            return ObfuscationReflectionHelper.getPrivateValue((Class)Item.class, (Object)item, 0);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return null;
    }
    
    private boolean checkIfChestsContains(final ArrayList<IInventory> chests, final IInventory testChest) {
        for (final IInventory chest : chests) {
            if (chest == testChest) {
                return true;
            }
            if (chest instanceof InventoryLargeChest && ((InventoryLargeChest)chest).func_90010_a(testChest)) {
                return true;
            }
        }
        return false;
    }
    
    private int getEmptySlotIn(final IInventory chest) {
        for (int i = 0; i < chest.func_70302_i_(); ++i) {
            if (chest.func_70301_a(i) == null) {
                return i;
            }
        }
        return -1;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_149734_b(final World world, final int x, final int y, final int z, final Random rand) {
    }
    
    public int getLightValue(final IBlockAccess world, final int x, final int y, final int z) {
        return 15;
    }
    
    @Override
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
    }
}
