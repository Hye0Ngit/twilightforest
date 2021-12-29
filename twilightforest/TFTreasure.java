// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

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
    
    public boolean generate(final xv world, final Random rand, final int cx, final int cy, final int cz) {
        boolean flag = true;
        this.treasureRNG.setSeed(world.E() * cx + cy ^ (long)cz);
        world.e(cx, cy, cz, amj.ax.cm);
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
    
    public um getCommonItem(final Random rand) {
        if (!this.useless.isEmpty() && rand.nextInt(4) == 0) {
            return this.useless.getRandomItem(rand);
        }
        return this.common.getRandomItem(rand);
    }
    
    public um getUncommonItem(final Random rand) {
        return this.uncommon.getRandomItem(rand);
    }
    
    public um getRareItem(final Random rand) {
        if (!this.ultrarare.isEmpty() && rand.nextInt(4) == 0) {
            return this.ultrarare.getRandomItem(rand);
        }
        return this.rare.getRandomItem(rand);
    }
    
    protected boolean addItemToChest(final xv world, final Random rand, final int cx, final int cy, final int cz, final um itemStack) {
        final anf chest = (anf)world.q(cx, cy, cz);
        if (chest != null) {
            final int slot = this.findRandomInventorySlot(chest, rand);
            if (slot != -1) {
                chest.a(slot, itemStack);
                return true;
            }
        }
        return false;
    }
    
    protected int findRandomInventorySlot(final anf chest, final Random rand) {
        for (int i = 0; i < 100; ++i) {
            final int slot = rand.nextInt(chest.k_());
            if (chest.a(slot) == null) {
                return slot;
            }
        }
        return -1;
    }
    
    protected void fill(final int i) {
        this.useless.add((amj)amj.ah, 4);
        this.useless.add((amj)amj.ag, 4);
        this.useless.add(uk.L, 3);
        this.useless.add(uk.S, 2);
        this.useless.add(uk.ap, 2);
        this.useless.add(amj.aY, 2);
        this.useless.add(uk.aJ, 4);
        this.useless.add(amj.H, 4);
        this.useless.add(uk.bJ, 1);
        if (i == 1) {
            this.common.add(uk.o, 4);
            this.common.add(uk.T, 4);
            this.common.add(uk.K, 4);
            this.common.add(uk.aw, 1);
            this.uncommon.add(uk.U, 1);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(uk.M, 4);
            this.uncommon.add(uk.l, 12);
            this.uncommon.add(amj.at, 12);
            this.rare.add(uk.p, 3);
            this.rare.add(uk.g, 1);
            this.rare.add(TFItems.liveRoot, 3);
            this.ultrarare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(uk.n, 1);
            this.ultrarare.add(TFItems.steeleafIngot, 3);
        }
        if (i == 2) {
            this.common.add(uk.o, 4);
            this.common.add(uk.bK, 4);
            this.common.add(amj.aI, 6);
            this.common.add(uk.aw, 1);
            this.uncommon.add(uk.bM, 2);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(TFItems.ironwoodIngot, 4);
            this.uncommon.add(uk.l, 12);
            this.uncommon.add(amj.at, 12);
            this.rare.add(TFItems.nagaScale, 1);
            this.rare.add(TFBlocks.uncraftingTable, 1);
            this.rare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(TFItems.peacockFan, 1);
            this.ultrarare.add(uk.bH, 6);
            this.ultrarare.add(uk.n, 1);
            this.ultrarare.add(TFItems.charmOfLife1, 1);
        }
        if (i == 3) {
            this.common.add(uk.bq, 9);
            this.common.add(uk.bL, 4);
            this.common.add(uk.aU, 4);
            this.common.add(TFItems.torchberries, 5);
            this.uncommon.add(uk.bT, 1);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(uk.M, 4);
            this.uncommon.add(uk.l, 12);
            this.uncommon.add(amj.at, 12);
            this.uncommon.add(TFItems.steeleafIngot, 4);
            this.rare.add(TFItems.nagaScale, 1);
            this.rare.addEnchanted(new um(TFItems.ironwoodPick, 1), ww.p, 1, ww.s, 1);
            this.rare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(TFItems.moonwormQueen, 1);
            this.ultrarare.add(TFBlocks.sapling, 1, 4);
            this.ultrarare.add(uk.n, 2);
            this.ultrarare.add(TFItems.charmOfLife1, 1);
            this.ultrarare.add(TFItems.charmOfKeeping1, 1);
        }
        if (i == 4) {
            this.common.add(amj.A, 4);
            this.common.add((amj)amj.ai, 4);
            this.common.add((amj)amj.aj, 4);
            this.common.add(uk.T, 4);
            this.common.add(uk.K, 4);
            this.common.add(uk.D, 6);
            this.uncommon.add(uk.bf, 4);
            this.uncommon.add(uk.bh, 4);
            this.uncommon.add(uk.bg, 4);
            this.uncommon.add(uk.l, 12);
            this.uncommon.add(TFBlocks.firefly, 4);
            this.rare.add(amj.Z, 3);
            this.rare.add((uk)uk.be, 1);
            this.rare.add(uk.aA, 1);
            this.rare.add(uk.k, 1);
            this.rare.add(uk.j, 2);
            this.ultrarare.add(uk.Q, 1);
            this.ultrarare.add(uk.n, 1);
            this.ultrarare.add(uk.F, 1);
            this.ultrarare.add(uk.at, 1);
        }
        if (i == 5) {
            this.useless.clear();
            this.common.add(uk.o, 4);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(uk.M, 4);
            this.common.add(TFItems.ironwoodIngot, 4);
            this.common.add(TFBlocks.firefly, 5);
            this.common.add(uk.aG, 1);
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
            this.rare.add(amj.ap, 3);
            this.rare.add(new um((uk)uk.bs, 1, 16373));
        }
        if (i == 6) {
            this.common.add(uk.D, 12);
            this.common.add(uk.m, 12);
            this.common.add(uk.l, 12);
            this.common.add(TFItems.mazeWafer, 9);
            this.common.add(uk.aK, 12);
            this.common.add(uk.aF, 4);
            this.common.add(uk.F, 1);
            this.uncommon.add(uk.aG, 1);
            this.uncommon.add(uk.aK, 5);
            this.uncommon.add(uk.o, 6);
            this.uncommon.add(TFItems.ironwoodIngot, 8);
            this.uncommon.add(TFBlocks.firefly, 5);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.steeleafIngot, 8);
            this.rare.add(uk.at, 1);
            this.rare.add(uk.bo, 2);
        }
        if (i == 10) {
            this.useless.clear();
            this.common.add(uk.o, 9);
            this.common.add(uk.bH, 5);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(TFItems.ironwoodIngot, 9);
            this.common.add(new um((uk)uk.bs, 1, 16369));
            this.common.add(new um((uk)uk.bs, 1, 16373));
            this.common.add(new um((uk)uk.bs, 1, 16370));
            this.uncommon.addEnchanted(new um(uk.k), ww.w, 1, ww.u, 2);
            this.uncommon.addEnchanted(new um(uk.k), ww.t, 3, ww.v, 1);
            this.uncommon.addEnchanted(new um(TFItems.steeleafShovel), ww.p, 4, ww.r, 2);
            this.uncommon.addEnchanted(new um(TFItems.steeleafAxe), ww.p, 5);
            this.uncommon.add(TFItems.steeleafIngot, 12);
            this.uncommon.addEnchanted(new um(TFItems.steeleafPlate), ww.c, 3);
            this.uncommon.addEnchanted(new um(TFItems.steeleafLegs), ww.d, 4);
            this.uncommon.addEnchanted(new um(TFItems.steeleafBoots), ww.c, 2);
            this.uncommon.addEnchanted(new um(TFItems.steeleafHelm), ww.h, 3);
            this.rare.add(amj.bY, 1);
            this.rare.add(amj.bV, 1);
            this.rare.addEnchanted(new um(TFItems.steeleafPick), ww.p, 4, ww.q, 1);
            this.rare.addEnchanted(new um(TFItems.steeleafSword), ww.j, 4, ww.m, 2);
            this.rare.addEnchanted(new um(TFItems.steeleafSword), ww.l, 5, ww.n, 2);
            this.rare.addEnchanted(new um(TFItems.mazebreakerPick), ww.p, 4, ww.r, 3, ww.s, 2);
        }
        if (i == 7) {
            this.common.add(uk.bt, 6);
            this.common.add(new um((uk)uk.bs, 1, 0));
            this.common.add(uk.aY, 5);
            this.common.add(uk.bu, 3);
            this.common.add(uk.bp, 1);
            this.common.add(uk.bx, 2);
            this.common.add(uk.bv, 1);
            this.common.add(uk.bB, 2);
            this.common.add(uk.bw, 3);
            this.common.add(uk.aK, 6);
            this.uncommon.addRandomEnchanted(uk.G, 10);
            this.uncommon.addRandomEnchanted(uk.ao, 7);
            this.uncommon.add(new um((uk)uk.bs, 1, 16274));
            this.uncommon.add(new um((uk)uk.bs, 1, 16341));
            this.uncommon.add(new um((uk)uk.bs, 1, 16307));
            this.uncommon.add(new um((uk)uk.bs, 1, 16348));
            this.rare.addRandomEnchanted(uk.al, 18);
            this.rare.add(new um((uk)uk.bs, 1, 16306));
            this.rare.add(new um((uk)uk.bs, 1, 16305));
            this.rare.add(new um((uk)uk.bs, 1, 32725));
            this.rare.add(new um((uk)uk.bs, 1, 32764));
            this.rare.add(TFItems.transformPowder, 12);
            this.rare.add(TFItems.charmOfLife1, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.addRandomEnchanted(uk.J, 20);
            this.ultrarare.add(uk.bn, 1);
            this.ultrarare.add(amj.as, 4);
            this.ultrarare.add(uk.n, 1);
            this.ultrarare.add(TFItems.moonwormQueen, 1);
            this.ultrarare.add(TFItems.peacockFan, 1);
        }
        if (i == 8) {
            this.common.add(uk.bt, 6);
            this.common.add(new um((uk)uk.bs, 1, 0));
            this.common.add(amj.aI, 6);
            this.common.add(uk.aK, 6);
            this.common.add(uk.aX, 6);
            this.common.add(uk.bq, 6);
            this.common.add(uk.aI, 12);
            this.uncommon.addRandomEnchanted(uk.af, 5);
            this.uncommon.add(uk.bE, 3);
            this.uncommon.add(uk.aL, 5);
            this.uncommon.add((uk)uk.bO, 1);
            this.uncommon.add(new um((uk)uk.bs, 1, 16));
            this.uncommon.add(new um((uk)uk.bs, 1, 16276));
            this.uncommon.add(new um((uk)uk.bs, 1, 16312));
            this.rare.addRandomEnchanted(uk.k, 5);
            this.rare.addRandomEnchanted(uk.v, 10);
            this.rare.addRandomEnchanted(uk.r, 15);
            this.rare.add(new um((uk)uk.bs, 1, 32696));
            this.rare.add(new um((uk)uk.bs, 1, 16369));
            this.rare.add(new um((uk)uk.bs, 1, 16373));
            this.rare.add(new um((uk)uk.bs, 1, 16370));
            this.rare.add(TFItems.transformPowder, 12);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.addRandomEnchanted(uk.I, 10);
            this.ultrarare.addRandomEnchanted(uk.q, 20);
            this.ultrarare.addRandomEnchanted(uk.k, 30);
            this.ultrarare.add(amj.aq, 5);
            this.ultrarare.add(uk.bn, 2);
            this.ultrarare.add(uk.bD, 6);
        }
        if (i == 9) {
            this.common.add(new um((uk)uk.bs, 1, 0));
            this.common.add(uk.bm, 6);
            this.common.add(uk.bN, 2);
            this.common.add(uk.T, 6);
            this.common.add(uk.bL, 6);
            this.common.add(uk.bK, 6);
            this.common.add(uk.bf, 6);
            this.common.add(uk.ax, 1);
            this.common.add(amj.at, 12);
            this.common.add(uk.F, 1);
            this.common.add(uk.aG, 1);
            this.common.add(uk.bh, 5);
            this.uncommon.add(uk.U, 8);
            this.uncommon.add(uk.bj, 6);
            this.uncommon.add(uk.ar, 8);
            this.uncommon.add(uk.bM, 8);
            this.uncommon.add(uk.bl, 10);
            this.uncommon.add(uk.aV, 8);
            this.rare.add(uk.bB, 12);
            this.rare.add(uk.j, 12);
            this.rare.add((uk)uk.bO, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.add(uk.at, 2);
            this.ultrarare.add(uk.bP, 2);
            this.ultrarare.add(uk.aZ, 1);
            this.ultrarare.add(uk.aE, 1);
            this.ultrarare.add(TFBlocks.sapling, 1, 4);
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
    }
}
