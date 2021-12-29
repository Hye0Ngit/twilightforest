// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.ArrayList;
import twilightforest.item.ItemTFOreMagnet;
import twilightforest.biomes.TFBiomeBase;
import java.util.Random;
import twilightforest.item.TFItems;

public class BlockTFMagicLogSpecial extends BlockTFMagicLog
{
    protected BlockTFMagicLogSpecial(final int i) {
        super(i);
        this.a((uy)TFItems.creativeTab);
    }
    
    public int a(final zv par1World) {
        return 20;
    }
    
    public void a(final zv par1World, final int par2, final int par3, final int par4) {
        par1World.a(par2, par3, par4, this.cz, this.a(par1World));
    }
    
    @Override
    public lx a(final int side, final int meta) {
        final int orient = meta & 0xC;
        final int woodType = meta & 0x3;
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
    
    public void a(final zv world, final int x, final int y, final int z, final Random rand) {
        final int meta = world.h(x, y, z);
        if (meta == 0 && !world.I) {
            world.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.1f, 0.5f);
            this.doTreeOfTimeEffect(world, x, y, z, rand);
        }
        else if (meta == 1 && !world.I) {
            this.doTreeOfTransformationEffect(world, x, y, z, rand);
        }
        else if (meta == 2 && !world.I) {
            this.doMinersTreeEffect(world, x, y, z, rand);
        }
        else if (meta == 3 && !world.I) {
            this.doSortingTreeEffect(world, x, y, z, rand);
        }
        world.a(x, y, z, this.cz, this.a(world));
    }
    
    private void doTreeOfTimeEffect(final zv world, final int x, final int y, final int z, final Random rand) {
        final int numticks = 24 * this.a(world);
        int successes = 0;
        for (int i = 0; i < numticks; ++i) {
            final int dx = rand.nextInt(32) - 16;
            final int dy = rand.nextInt(32) - 16;
            final int dz = rand.nextInt(32) - 16;
            final int thereID = world.a(x + dx, y + dy, z + dz);
            if (thereID > 0 && aou.r[thereID].s()) {
                aou.r[thereID].a(world, x + dx, y + dy, z + dz, rand);
                ++successes;
            }
        }
    }
    
    private void doTreeOfTransformationEffect(final zv world, final int x, final int y, final int z, final Random rand) {
        for (int i = 0; i < 1; ++i) {
            final int dx = rand.nextInt(32) - 16;
            final int dz = rand.nextInt(32) - 16;
            world.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.1f, 0.5f);
            if (Math.sqrt(dx * dx + dz * dz) < 16.0) {
                final aap biomeAt = world.a(x + dx, z + dz);
                if (biomeAt != TFBiomeBase.enchantedForest) {
                    final abq chunkAt = world.d(x + dx, z + dz);
                    chunkAt.m()[(z + dz & 0xF) << 4 | (x + dx & 0xF)] = (byte)TFBiomeBase.enchantedForest.N;
                    world.j(x + dx, y, z + dz);
                    if (world instanceof iz) {
                        final ix chunkWatch = ((iz)world).r().a(x + dx >> 4, z + dz >> 4, false);
                        if (chunkWatch != null) {
                            chunkWatch.a((ei)new dt(chunkAt, true, 255));
                        }
                    }
                }
            }
        }
    }
    
    private void doMinersTreeEffect(final zv world, final int x, final int y, final int z, final Random rand) {
        final int dx = rand.nextInt(64) - 32;
        final int dy = rand.nextInt(64) - 32;
        final int dz = rand.nextInt(64) - 32;
        final int moved = ItemTFOreMagnet.doMagnet(world, x, y, z, x + dx, y + dy, z + dz);
        if (moved > 0) {
            world.a(x + 0.5, y + 0.5, z + 0.5, "mob.endermen.portal", 0.1f, 1.0f);
        }
    }
    
    private void doSortingTreeEffect(final zv world, final int x, final int y, final int z, final Random rand) {
        final int XSEARCH = 16;
        final int YSEARCH = 16;
        final int ZSEARCH = 16;
        final ArrayList chests = new ArrayList();
        int itemCount = 0;
        for (int sx = x - XSEARCH; sx < x + XSEARCH; ++sx) {
            for (int sy = y - YSEARCH; sy < y + YSEARCH; ++sy) {
                for (int sz = z - ZSEARCH; sz < z + ZSEARCH; ++sz) {
                    if (world.a(sx, sy, sz) == aou.ay.cz) {
                        final lt thisChest = (lt)world.r(sx, sy, sz);
                        int itemsInChest = 0;
                        for (int i = 0; i < thisChest.j_(); ++i) {
                            if (thisChest.a(i) != null) {
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
        System.out.println("Found " + chests.size() + " non-empty chests, containing " + itemCount + " items");
        wg beingSorted = null;
        int sortedChestNum = -1;
        int sortedSlotNum = -1;
        if (itemCount > 0) {
            final int itemNumber = rand.nextInt(itemCount);
            int currentNumber = 0;
            for (int i = 0; i < chests.size(); ++i) {
                final lt chest = chests.get(i);
                for (int slotNum = 0; slotNum < chest.j_(); ++slotNum) {
                    final wg currentItem = chest.a(slotNum);
                    if (currentItem != null && currentNumber++ == itemNumber) {
                        beingSorted = currentItem;
                        sortedChestNum = i;
                        sortedSlotNum = slotNum;
                    }
                }
            }
        }
        System.out.println("Decided to sort item " + beingSorted);
        if (beingSorted != null) {
            int matchChestNum = -1;
            int matchCount = 0;
            for (int chestNum = 0; chestNum < chests.size(); ++chestNum) {
                final lt chest = chests.get(chestNum);
                int currentChestMatches = 0;
                for (int slotNum2 = 0; slotNum2 < chest.j_(); ++slotNum2) {
                    final wg currentItem2 = chest.a(slotNum2);
                    if (currentItem2 != null && currentItem2.b().getCreativeTabs()[0] == beingSorted.b().x()) {
                        currentChestMatches += currentItem2.a;
                    }
                }
                if (currentChestMatches > matchCount) {
                    matchCount = currentChestMatches;
                    matchChestNum = chestNum;
                }
            }
            if (matchChestNum >= 0 && matchChestNum != sortedChestNum) {
                final lt moveChest = chests.get(matchChestNum);
                final lt oldChest = chests.get(sortedChestNum);
                final int moveSlot = this.getEmptySlotIn(moveChest);
                if (moveSlot >= 0) {
                    oldChest.a(sortedSlotNum, (wg)null);
                    moveChest.a(moveSlot, beingSorted);
                    System.out.println("Moved sorted item " + beingSorted + " to chest " + matchChestNum + ", slot " + moveSlot);
                }
            }
            if (beingSorted.a < beingSorted.e()) {
                for (final lt chest : chests) {
                    for (int slotNum = 0; slotNum < chest.j_(); ++slotNum) {
                        final wg currentItem = chest.a(slotNum);
                        if (currentItem != null && currentItem != beingSorted && beingSorted.a(currentItem) && currentItem.a < beingSorted.e() - beingSorted.a) {
                            chest.a(slotNum, (wg)null);
                            final wg wg = beingSorted;
                            wg.a += currentItem.a;
                            currentItem.a = 0;
                        }
                    }
                }
            }
        }
    }
    
    private int getEmptySlotIn(final lt chest) {
        for (int i = 0; i < chest.j_(); ++i) {
            if (chest.a(i) == null) {
                return i;
            }
        }
        return -1;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void b(final zv world, final int x, final int y, final int z, final Random rand) {
    }
    
    public int getLightValue(final aae world, final int x, final int y, final int z) {
        return 15;
    }
    
    @Override
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        par3List.add(new wg(par1, 1, 0));
        par3List.add(new wg(par1, 1, 1));
        par3List.add(new wg(par1, 1, 2));
        par3List.add(new wg(par1, 1, 3));
    }
}
