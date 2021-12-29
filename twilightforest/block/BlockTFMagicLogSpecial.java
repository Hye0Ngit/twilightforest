// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import java.util.Iterator;
import java.util.ArrayList;
import twilightforest.item.ItemTFOreMagnet;
import java.nio.ByteBuffer;
import twilightforest.biomes.TFBiomeBase;
import java.util.Random;
import twilightforest.item.TFItems;

public class BlockTFMagicLogSpecial extends BlockTFMagicLog
{
    protected BlockTFMagicLogSpecial(final int i) {
        super(i);
        this.a((wv)TFItems.creativeTab);
    }
    
    public int a(final abv par1World) {
        return 20;
    }
    
    public void a(final abv par1World, final int par2, final int par3, final int par4) {
        par1World.a(par2, par3, par4, this.cF, this.a(par1World));
    }
    
    @Override
    public int a(final int par1, final Random par2Random, final int par3) {
        return TFBlocks.magicLog.cF;
    }
    
    @Override
    public mr a(final int side, final int meta) {
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
    
    public void a(final abv world, final int x, final int y, final int z, final Random rand) {
        final int meta = world.h(x, y, z);
        if ((meta & 0xC) == 0xC) {
            return;
        }
        if ((meta & 0x3) == 0x0 && !world.I) {
            world.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.1f, 0.5f);
            this.doTreeOfTimeEffect(world, x, y, z, rand);
        }
        else if ((meta & 0x3) == 0x1 && !world.I) {
            this.doTreeOfTransformationEffect(world, x, y, z, rand);
        }
        else if ((meta & 0x3) == 0x2 && !world.I) {
            this.doMinersTreeEffect(world, x, y, z, rand);
        }
        else if ((meta & 0x3) == 0x3 && !world.I) {
            this.doSortingTreeEffect(world, x, y, z, rand);
        }
        world.a(x, y, z, this.cF, this.a(world));
    }
    
    public boolean a(final abv world, final int x, final int y, final int z, final ue par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        final int meta = world.h(x, y, z);
        final int orient = meta & 0xC;
        final int woodType = meta & 0x3;
        if (orient == 0) {
            world.b(x, y, z, woodType | 0xC, 3);
            return true;
        }
        if (orient == 12) {
            world.b(x, y, z, woodType | 0x0, 3);
            world.a(x, y, z, this.cF, this.a(world));
            return true;
        }
        return false;
    }
    
    private void doTreeOfTimeEffect(final abv world, final int x, final int y, final int z, final Random rand) {
        final int numticks = 24 * this.a(world);
        int successes = 0;
        for (int i = 0; i < numticks; ++i) {
            final int dx = rand.nextInt(32) - 16;
            final int dy = rand.nextInt(32) - 16;
            final int dz = rand.nextInt(32) - 16;
            final int thereID = world.a(x + dx, y + dy, z + dz);
            if (thereID > 0 && aqw.s[thereID].s()) {
                aqw.s[thereID].a(world, x + dx, y + dy, z + dz, rand);
                ++successes;
            }
        }
    }
    
    private void doTreeOfTransformationEffect(final abv world, final int x, final int y, final int z, final Random rand) {
        for (int i = 0; i < 1; ++i) {
            final int dx = rand.nextInt(32) - 16;
            final int dz = rand.nextInt(32) - 16;
            world.a(x + 0.5, y + 0.5, z + 0.5, "note.harp", 0.1f, rand.nextFloat() * 2.0f);
            if (Math.sqrt(dx * dx + dz * dz) < 16.0) {
                final acp biomeAt = world.a(x + dx, z + dz);
                if (biomeAt != TFBiomeBase.enchantedForest) {
                    final adq chunkAt = world.d(x + dx, z + dz);
                    chunkAt.m()[(z + dz & 0xF) << 4 | (x + dx & 0xF)] = (byte)TFBiomeBase.enchantedForest.N;
                    world.j(x + dx, y, z + dz);
                    if (world instanceof jr) {
                        this.sendChangedBiome(world, x + dx, z + dz, chunkAt);
                    }
                }
            }
        }
    }
    
    private void sendChangedBiome(final abv world, final int x, final int z, final adq chunkAt) {
        final ByteBuffer bBuffer = ByteBuffer.allocate(10);
        bBuffer.put((byte)2);
        bBuffer.putInt(x);
        bBuffer.putInt(z);
        bBuffer.put((byte)TFBiomeBase.enchantedForest.N);
        final dz packet = new dz("TwilightForest", bBuffer.array());
        final jp chunkWatch = ((jr)world).s().a(x >> 4, z >> 4, false);
        if (chunkWatch != null) {
            chunkWatch.a((ex)packet);
        }
    }
    
    private void doMinersTreeEffect(final abv world, final int x, final int y, final int z, final Random rand) {
        final int dx = rand.nextInt(64) - 32;
        final int dy = rand.nextInt(64) - 32;
        final int dz = rand.nextInt(64) - 32;
        final int moved = ItemTFOreMagnet.doMagnet(world, x, y, z, x + dx, y + dy, z + dz);
        if (moved > 0) {
            world.a(x + 0.5, y + 0.5, z + 0.5, "mob.endermen.portal", 0.1f, 1.0f);
        }
    }
    
    private void doSortingTreeEffect(final abv world, final int x, final int y, final int z, final Random rand) {
        final int XSEARCH = 16;
        final int YSEARCH = 16;
        final int ZSEARCH = 16;
        final ArrayList<mn> chests = new ArrayList<mn>();
        int itemCount = 0;
        for (int sx = x - XSEARCH; sx < x + XSEARCH; ++sx) {
            for (int sy = y - YSEARCH; sy < y + YSEARCH; ++sy) {
                for (int sz = z - ZSEARCH; sz < z + ZSEARCH; ++sz) {
                    if (world.a(sx, sy, sz) == aqw.az.cF) {
                        final mn thisChest = aqw.az.g_(world, sx, sy, sz);
                        if (!this.checkIfChestsContains(chests, (mn)world.r(sx, sy, sz))) {
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
        }
        yd beingSorted = null;
        int sortedChestNum = -1;
        int sortedSlotNum = -1;
        if (itemCount > 0) {
            final int itemNumber = rand.nextInt(itemCount);
            int currentNumber = 0;
            for (int i = 0; i < chests.size(); ++i) {
                final mn chest = chests.get(i);
                for (int slotNum = 0; slotNum < chest.j_(); ++slotNum) {
                    final yd currentItem = chest.a(slotNum);
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
                final mn chest = chests.get(chestNum);
                int currentChestMatches = 0;
                for (int slotNum2 = 0; slotNum2 < chest.j_(); ++slotNum2) {
                    final yd currentItem2 = chest.a(slotNum2);
                    if (currentItem2 != null && this.isSortingMatch(beingSorted, currentItem2)) {
                        currentChestMatches += currentItem2.b;
                    }
                }
                if (currentChestMatches > matchCount) {
                    matchCount = currentChestMatches;
                    matchChestNum = chestNum;
                }
            }
            if (matchChestNum >= 0 && matchChestNum != sortedChestNum) {
                final mn moveChest = chests.get(matchChestNum);
                final mn oldChest = chests.get(sortedChestNum);
                final int moveSlot = this.getEmptySlotIn(moveChest);
                if (moveSlot >= 0) {
                    oldChest.a(sortedSlotNum, (yd)null);
                    moveChest.a(moveSlot, beingSorted);
                }
            }
            if (beingSorted.b < beingSorted.e()) {
                for (final mn chest : chests) {
                    for (int slotNum = 0; slotNum < chest.j_(); ++slotNum) {
                        final yd currentItem = chest.a(slotNum);
                        if (currentItem != null && currentItem != beingSorted && beingSorted.a(currentItem) && currentItem.b <= beingSorted.e() - beingSorted.b) {
                            chest.a(slotNum, (yd)null);
                            final yd yd = beingSorted;
                            yd.b += currentItem.b;
                            currentItem.b = 0;
                        }
                    }
                }
            }
        }
    }
    
    private boolean isSortingMatch(final yd beingSorted, final yd currentItem) {
        return this.getCreativeTab(currentItem.b()) == this.getCreativeTab(beingSorted.b());
    }
    
    private Object getCreativeTab(final yb item) {
        try {
            return ObfuscationReflectionHelper.getPrivateValue((Class)yb.class, (Object)item, 0);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return null;
    }
    
    private boolean checkIfChestsContains(final ArrayList<mn> chests, final mn testChest) {
        for (final mn chest : chests) {
            if (chest == testChest) {
                return true;
            }
            if (chest instanceof mm && ((mm)chest).a(testChest)) {
                return true;
            }
        }
        return false;
    }
    
    private int getEmptySlotIn(final mn chest) {
        for (int i = 0; i < chest.j_(); ++i) {
            if (chest.a(i) == null) {
                return i;
            }
        }
        return -1;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void b(final abv world, final int x, final int y, final int z, final Random rand) {
    }
    
    public int getLightValue(final ace world, final int x, final int y, final int z) {
        return 15;
    }
    
    @Override
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
        par3List.add(new yd(par1, 1, 1));
        par3List.add(new yd(par1, 1, 2));
        par3List.add(new yd(par1, 1, 3));
    }
}
