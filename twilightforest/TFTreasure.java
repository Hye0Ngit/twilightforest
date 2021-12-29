// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;
import java.util.Random;

public class TFTreasure
{
    int type;
    Random treasureRNG;
    protected TFTreasureTable useless;
    protected TFTreasureTable common;
    protected TFTreasureTable uncommon;
    protected TFTreasureTable rare;
    protected TFTreasureTable ultrarare;
    public static TFTreasure hill1;
    public static TFTreasure hill2;
    public static TFTreasure hill3;
    public static TFTreasure hedgemaze;
    public static TFTreasure labyrinth_room;
    public static TFTreasure labyrinth_deadend;
    public static TFTreasure tower_room;
    public static TFTreasure tower_library;
    public static TFTreasure basement;
    public static TFTreasure labyrinth_vault;
    public static TFTreasure darktower_cache;
    public static TFTreasure darktower_key;
    public static TFTreasure darktower_boss;
    
    public TFTreasure(final int i) {
        this.type = i;
        this.useless = new TFTreasureTable();
        this.common = new TFTreasureTable();
        this.uncommon = new TFTreasureTable();
        this.rare = new TFTreasureTable();
        this.ultrarare = new TFTreasureTable();
        this.treasureRNG = new Random();
        this.fill(i);
    }
    
    public boolean generate(final zv world, final Random rand, final int cx, final int cy, final int cz) {
        boolean flag = true;
        this.treasureRNG.setSeed(world.F() * cx + cy ^ (long)cz);
        world.f(cx, cy, cz, aou.ay.cz, 0, 2);
        for (int i = 0; i < 4; ++i) {
            flag &= this.addItemToChest(world, this.treasureRNG, cx, cy, cz, this.getCommonItem(this.treasureRNG));
        }
        for (int i = 0; i < 2; ++i) {
            flag &= this.addItemToChest(world, this.treasureRNG, cx, cy, cz, this.getUncommonItem(this.treasureRNG));
        }
        for (int i = 0; i < 1; ++i) {
            flag &= this.addItemToChest(world, this.treasureRNG, cx, cy, cz, this.getRareItem(this.treasureRNG));
        }
        return flag;
    }
    
    public wg getCommonItem(final Random rand) {
        if (!this.useless.isEmpty() && rand.nextInt(4) == 0) {
            return this.useless.getRandomItem(rand);
        }
        return this.common.getRandomItem(rand);
    }
    
    public wg getUncommonItem(final Random rand) {
        return this.uncommon.getRandomItem(rand);
    }
    
    public wg getRareItem(final Random rand) {
        if (!this.ultrarare.isEmpty() && rand.nextInt(4) == 0) {
            return this.ultrarare.getRandomItem(rand);
        }
        return this.rare.getRandomItem(rand);
    }
    
    protected boolean addItemToChest(final zv world, final Random rand, final int cx, final int cy, final int cz, final wg itemStack) {
        final aps chest = (aps)world.r(cx, cy, cz);
        if (chest != null) {
            final int slot = this.findRandomInventorySlot(chest, rand);
            if (slot != -1) {
                chest.a(slot, itemStack);
                return true;
            }
        }
        return false;
    }
    
    protected int findRandomInventorySlot(final aps chest, final Random rand) {
        for (int i = 0; i < 100; ++i) {
            final int slot = rand.nextInt(chest.j_());
            if (chest.a(slot) == null) {
                return slot;
            }
        }
        return -1;
    }
    
    protected void fill(final int i) {
        this.useless.add((aou)aou.ai, 4);
        this.useless.add((aou)aou.ah, 4);
        this.useless.add(we.M, 3);
        this.useless.add(we.T, 2);
        this.useless.add(we.aq, 2);
        this.useless.add(aou.aZ, 2);
        this.useless.add(we.aK, 4);
        this.useless.add(aou.I, 4);
        this.useless.add(we.bK, 1);
        this.useless.add(new wg(we.aX, 1, 0));
        if (i == 1) {
            this.common.add(we.p, 4);
            this.common.add(we.U, 4);
            this.common.add(we.L, 4);
            this.common.add(we.ax, 1);
            this.uncommon.add(we.V, 1);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(we.N, 4);
            this.uncommon.add(we.m, 12);
            this.uncommon.add(aou.au, 12);
            this.rare.add(we.q, 3);
            this.rare.add(we.h, 1);
            this.rare.add(TFItems.liveRoot, 3);
            this.ultrarare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(we.o, 1);
            this.ultrarare.add(TFItems.steeleafIngot, 3);
        }
        if (i == 2) {
            this.common.add(we.p, 4);
            this.common.add(we.bL, 4);
            this.common.add(aou.aJ, 6);
            this.common.add(we.ax, 1);
            this.uncommon.add(we.bN, 2);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(TFItems.ironwoodIngot, 4);
            this.uncommon.add(we.m, 12);
            this.uncommon.add(aou.au, 12);
            this.rare.add(TFItems.nagaScale, 1);
            this.rare.add(TFBlocks.uncraftingTable, 1);
            this.rare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(TFItems.peacockFan, 1);
            this.ultrarare.add(we.bI, 6);
            this.ultrarare.add(we.o, 1);
            this.ultrarare.add(TFItems.charmOfLife1, 1);
        }
        if (i == 3) {
            this.common.add(we.br, 9);
            this.common.add(we.bM, 4);
            this.common.add(we.aV, 4);
            this.common.add(TFItems.torchberries, 5);
            this.uncommon.add(we.bU, 1);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(we.N, 4);
            this.uncommon.add(we.m, 12);
            this.uncommon.add(aou.au, 12);
            this.uncommon.add(TFItems.steeleafIngot, 4);
            this.rare.add(TFItems.nagaScale, 1);
            this.rare.addEnchanted(new wg(TFItems.ironwoodPick, 1), yt.r, 1, yt.u, 1);
            this.rare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(TFItems.moonwormQueen, 1);
            this.ultrarare.add(TFBlocks.sapling, 1, 4);
            this.ultrarare.add(we.o, 2);
            this.ultrarare.add(TFItems.charmOfLife1, 1);
            this.ultrarare.add(TFItems.charmOfKeeping1, 1);
        }
        if (i == 4) {
            this.common.add(aou.B, 4);
            this.common.add((aou)aou.aj, 4);
            this.common.add((aou)aou.ak, 4);
            this.common.add(we.U, 4);
            this.common.add(we.L, 4);
            this.common.add(we.E, 6);
            this.uncommon.add(we.bg, 4);
            this.uncommon.add(we.bi, 4);
            this.uncommon.add(we.bh, 4);
            this.uncommon.add(we.m, 12);
            this.uncommon.add(TFBlocks.firefly, 4);
            this.rare.add(aou.aa, 3);
            this.rare.add((we)we.bf, 1);
            this.rare.add(we.aB, 1);
            this.rare.add((we)we.l, 1);
            this.rare.add(we.k, 2);
            this.ultrarare.add(we.R, 1);
            this.ultrarare.add(we.o, 1);
            this.ultrarare.add(we.G, 1);
            this.ultrarare.add(we.au, 1);
        }
        if (i == 5) {
            this.useless.clear();
            this.common.add(we.p, 4);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(we.N, 4);
            this.common.add(TFItems.ironwoodIngot, 4);
            this.common.add(TFBlocks.firefly, 5);
            this.common.add(we.aH, 1);
            this.uncommon.add(TFItems.steeleafIngot, 6);
            this.uncommon.add(TFItems.steeleafLegs, 1);
            this.uncommon.add(TFItems.steeleafPlate, 1);
            this.uncommon.add(TFItems.steeleafHelm, 1);
            this.uncommon.add(TFItems.steeleafBoots, 1);
            this.uncommon.add(TFItems.steeleafPick, 1);
            this.uncommon.add(TFItems.ironwoodPlate, 1);
            this.uncommon.add(TFItems.ironwoodSword, 1);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.mazeMapFocus, 1);
            this.rare.add(aou.aq, 3);
            this.rare.add(new wg((we)we.bt, 1, 16373));
        }
        if (i == 6) {
            this.common.add(we.E, 12);
            this.common.add(we.n, 12);
            this.common.add(we.m, 12);
            this.common.add(TFItems.mazeWafer, 9);
            this.common.add(we.aL, 12);
            this.common.add(we.aG, 4);
            this.common.add(we.G, 1);
            this.uncommon.add(we.aH, 1);
            this.uncommon.add(we.aL, 5);
            this.uncommon.add(we.p, 6);
            this.uncommon.add(TFItems.ironwoodIngot, 8);
            this.uncommon.add(TFBlocks.firefly, 5);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.steeleafIngot, 8);
            this.rare.add(we.au, 1);
            this.rare.add(we.bp, 2);
        }
        if (i == 10) {
            this.useless.clear();
            this.common.add(we.p, 9);
            this.common.add(we.bI, 5);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(TFItems.ironwoodIngot, 9);
            this.common.add(new wg((we)we.bt, 1, 16369));
            this.common.add(new wg((we)we.bt, 1, 16373));
            this.common.add(new wg((we)we.bt, 1, 16370));
            this.uncommon.addEnchanted(new wg((we)we.l), yt.y, 1, yt.w, 2);
            this.uncommon.addEnchanted(new wg((we)we.l), yt.v, 3, yt.x, 1);
            this.uncommon.addEnchanted(new wg(TFItems.steeleafShovel), yt.r, 4, yt.t, 2);
            this.uncommon.addEnchanted(new wg(TFItems.steeleafAxe), yt.r, 5);
            this.uncommon.add(TFItems.steeleafIngot, 12);
            this.uncommon.addEnchanted(new wg(TFItems.steeleafPlate), yt.d, 3);
            this.uncommon.addEnchanted(new wg(TFItems.steeleafLegs), yt.e, 4);
            this.uncommon.addEnchanted(new wg(TFItems.steeleafBoots), yt.d, 2);
            this.uncommon.addEnchanted(new wg(TFItems.steeleafHelm), yt.i, 3);
            this.rare.add(aou.bZ, 1);
            this.rare.add(aou.bW, 1);
            this.rare.addEnchanted(new wg(TFItems.steeleafPick), yt.r, 4, yt.s, 1);
            this.rare.addEnchanted(new wg(TFItems.steeleafSword), yt.l, 4, yt.o, 2);
            this.rare.addEnchanted(new wg(TFItems.steeleafSword), yt.n, 5, yt.p, 2);
            this.rare.addEnchanted(new wg(TFItems.mazebreakerPick), yt.r, 4, yt.t, 3, yt.u, 2);
        }
        if (i == 7) {
            this.common.add(we.bu, 6);
            this.common.add(new wg((we)we.bt, 1, 0));
            this.common.add(we.aZ, 5);
            this.common.add(we.bv, 3);
            this.common.add(we.bq, 1);
            this.common.add(we.by, 2);
            this.common.add(we.bw, 1);
            this.common.add(we.bC, 2);
            this.common.add(we.bx, 3);
            this.common.add(we.aL, 6);
            this.uncommon.addRandomEnchanted(we.H, 10);
            this.uncommon.addRandomEnchanted((we)we.ap, 7);
            this.uncommon.add(new wg((we)we.bt, 1, 16274));
            this.uncommon.add(new wg((we)we.bt, 1, 16341));
            this.uncommon.add(new wg((we)we.bt, 1, 16307));
            this.uncommon.add(new wg((we)we.bt, 1, 16348));
            this.rare.addRandomEnchanted((we)we.am, 18);
            this.rare.add(new wg((we)we.bt, 1, 16306));
            this.rare.add(new wg((we)we.bt, 1, 16305));
            this.rare.add(new wg((we)we.bt, 1, 32725));
            this.rare.add(new wg((we)we.bt, 1, 32764));
            this.rare.add(TFItems.transformPowder, 12);
            this.rare.add(TFItems.charmOfLife1, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.addRandomEnchanted(we.K, 20);
            this.ultrarare.add(we.bo, 1);
            this.ultrarare.add(aou.at, 4);
            this.ultrarare.add(we.o, 1);
            this.ultrarare.add(TFItems.moonwormQueen, 1);
            this.ultrarare.add(TFItems.peacockFan, 1);
        }
        if (i == 8) {
            this.common.add(we.bu, 6);
            this.common.add(new wg((we)we.bt, 1, 0));
            this.common.add(aou.aJ, 6);
            this.common.add(we.aL, 6);
            this.common.add(we.aY, 6);
            this.common.add(we.br, 6);
            this.common.add(we.aJ, 12);
            this.uncommon.addRandomEnchanted((we)we.ag, 5);
            this.uncommon.add(we.bF, 3);
            this.uncommon.add(we.aM, 5);
            this.uncommon.add((we)we.bP, 1);
            this.uncommon.add(new wg((we)we.bt, 1, 16));
            this.uncommon.add(new wg((we)we.bt, 1, 16276));
            this.uncommon.add(new wg((we)we.bt, 1, 16312));
            this.rare.addRandomEnchanted((we)we.l, 5);
            this.rare.addRandomEnchanted(we.w, 10);
            this.rare.addRandomEnchanted(we.s, 15);
            this.rare.add(new wg((we)we.bt, 1, 32696));
            this.rare.add(new wg((we)we.bt, 1, 16369));
            this.rare.add(new wg((we)we.bt, 1, 16373));
            this.rare.add(new wg((we)we.bt, 1, 16370));
            this.rare.add(TFItems.transformPowder, 12);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.addRandomEnchanted(we.J, 10);
            this.ultrarare.addRandomEnchanted(we.r, 20);
            this.ultrarare.addRandomEnchanted((we)we.l, 30);
            this.ultrarare.add(aou.ar, 5);
            this.ultrarare.add(we.bo, 2);
            this.ultrarare.add(we.bE, 6);
        }
        if (i == 9) {
            this.common.add(new wg((we)we.bt, 1, 0));
            this.common.add(we.bn, 6);
            this.common.add(we.bO, 2);
            this.common.add(we.U, 6);
            this.common.add(we.bM, 6);
            this.common.add(we.bL, 6);
            this.common.add(we.bg, 6);
            this.common.add(we.ay, 1);
            this.common.add(aou.au, 12);
            this.common.add(we.G, 1);
            this.common.add(we.aH, 1);
            this.common.add(we.bi, 5);
            this.uncommon.add(we.V, 8);
            this.uncommon.add(we.bk, 6);
            this.uncommon.add(we.as, 8);
            this.uncommon.add(we.bN, 8);
            this.uncommon.add(we.bm, 10);
            this.uncommon.add(we.aW, 8);
            this.rare.add(we.bC, 12);
            this.rare.add(we.k, 12);
            this.rare.add((we)we.bP, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.add(we.au, 2);
            this.ultrarare.add(we.bQ, 2);
            this.ultrarare.add(we.ba, 1);
            this.ultrarare.add(we.aF, 1);
            this.ultrarare.add(TFBlocks.sapling, 1, 4);
        }
        if (i == 11) {
            this.common.add(we.E, 12);
            this.common.add(new wg(we.n, 12, 1));
            this.common.add(we.m, 12);
            this.common.add(TFItems.mazeWafer, 9);
            this.common.add(new wg(aou.af, 1, 14));
            this.common.add(we.aD, 6);
            this.uncommon.add(aou.bP, 3);
            this.uncommon.add(we.p, 6);
            this.uncommon.add(TFItems.ironwoodIngot, 8);
            this.uncommon.add(TFBlocks.firefly, 5);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.steeleafIngot, 8);
            this.rare.add(we.o, 2);
        }
        if (i == 12) {
            this.useless.clear();
            this.common.add(we.p, 4);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(we.N, 4);
            this.common.add(TFItems.ironwoodIngot, 4);
            this.common.add(TFBlocks.firefly, 5);
            this.common.add(we.aD, 12);
            this.common.add(we.aU, 12);
            this.uncommon.add(TFItems.steeleafIngot, 6);
            this.uncommon.add(TFItems.steeleafLegs, 1);
            this.uncommon.add(TFItems.steeleafPlate, 1);
            this.uncommon.add(TFItems.steeleafHelm, 1);
            this.uncommon.add(TFItems.steeleafBoots, 1);
            this.uncommon.add(TFItems.steeleafPick, 1);
            this.uncommon.add(TFItems.ironwoodPlate, 1);
            this.uncommon.add(TFItems.ironwoodSword, 1);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.charmOfLife1, 1);
            this.rare.addEnchantedBook(yt.f, 3);
            this.rare.addEnchantedBook(yt.o, 2);
            this.rare.addEnchantedBook(yt.r, 3);
        }
        if (i == 13) {
            this.useless.clear();
            this.common.add(TFItems.carminite, 3);
            this.uncommon.add(TFItems.fieryBlood, 5);
            this.rare.add(new wg(TFItems.trophy, 1, 3));
        }
    }
    
    static {
        TFTreasure.hill1 = new TFTreasure(1);
        TFTreasure.hill2 = new TFTreasure(2);
        TFTreasure.hill3 = new TFTreasure(3);
        TFTreasure.hedgemaze = new TFTreasure(4);
        TFTreasure.labyrinth_room = new TFTreasure(5);
        TFTreasure.labyrinth_deadend = new TFTreasure(6);
        TFTreasure.tower_room = new TFTreasure(7);
        TFTreasure.tower_library = new TFTreasure(8);
        TFTreasure.basement = new TFTreasure(9);
        TFTreasure.labyrinth_vault = new TFTreasure(10);
        TFTreasure.darktower_cache = new TFTreasure(11);
        TFTreasure.darktower_key = new TFTreasure(12);
        TFTreasure.darktower_boss = new TFTreasure(13);
    }
}
