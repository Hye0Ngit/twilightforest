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
    
    public boolean generate(final yc world, final Random rand, final int cx, final int cy, final int cz) {
        boolean flag = true;
        this.treasureRNG.setSeed(world.E() * cx + cy ^ (long)cz);
        world.e(cx, cy, cz, amq.ax.cm);
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
    
    public ur getCommonItem(final Random rand) {
        if (!this.useless.isEmpty() && rand.nextInt(4) == 0) {
            return this.useless.getRandomItem(rand);
        }
        return this.common.getRandomItem(rand);
    }
    
    public ur getUncommonItem(final Random rand) {
        return this.uncommon.getRandomItem(rand);
    }
    
    public ur getRareItem(final Random rand) {
        if (!this.ultrarare.isEmpty() && rand.nextInt(4) == 0) {
            return this.ultrarare.getRandomItem(rand);
        }
        return this.rare.getRandomItem(rand);
    }
    
    protected boolean addItemToChest(final yc world, final Random rand, final int cx, final int cy, final int cz, final ur itemStack) {
        final anm chest = (anm)world.q(cx, cy, cz);
        if (chest != null) {
            final int slot = this.findRandomInventorySlot(chest, rand);
            if (slot != -1) {
                chest.a(slot, itemStack);
                return true;
            }
        }
        return false;
    }
    
    protected int findRandomInventorySlot(final anm chest, final Random rand) {
        for (int i = 0; i < 100; ++i) {
            final int slot = rand.nextInt(chest.k_());
            if (chest.a(slot) == null) {
                return slot;
            }
        }
        return -1;
    }
    
    protected void fill(final int i) {
        this.useless.add((amq)amq.ah, 4);
        this.useless.add((amq)amq.ag, 4);
        this.useless.add(up.L, 3);
        this.useless.add(up.S, 2);
        this.useless.add(up.ap, 2);
        this.useless.add(amq.aY, 2);
        this.useless.add(up.aJ, 4);
        this.useless.add(amq.H, 4);
        this.useless.add(up.bJ, 1);
        if (i == 1) {
            this.common.add(up.o, 4);
            this.common.add(up.T, 4);
            this.common.add(up.K, 4);
            this.common.add(up.aw, 1);
            this.uncommon.add(up.U, 1);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(up.M, 4);
            this.uncommon.add(up.l, 12);
            this.uncommon.add(amq.at, 12);
            this.rare.add(up.p, 3);
            this.rare.add(up.g, 1);
            this.rare.add(TFItems.liveRoot, 3);
            this.ultrarare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(up.n, 1);
            this.ultrarare.add(TFItems.steeleafIngot, 3);
        }
        if (i == 2) {
            this.common.add(up.o, 4);
            this.common.add(up.bK, 4);
            this.common.add(amq.aI, 6);
            this.common.add(up.aw, 1);
            this.uncommon.add(up.bM, 2);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(TFItems.ironwoodIngot, 4);
            this.uncommon.add(up.l, 12);
            this.uncommon.add(amq.at, 12);
            this.rare.add(TFItems.nagaScale, 1);
            this.rare.add(TFBlocks.uncraftingTable, 1);
            this.rare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(TFItems.peacockFan, 1);
            this.ultrarare.add(up.bH, 6);
            this.ultrarare.add(up.n, 1);
            this.ultrarare.add(TFItems.charmOfLife1, 1);
        }
        if (i == 3) {
            this.common.add(up.bq, 9);
            this.common.add(up.bL, 4);
            this.common.add(up.aU, 4);
            this.common.add(TFItems.torchberries, 5);
            this.uncommon.add(up.bT, 1);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(up.M, 4);
            this.uncommon.add(up.l, 12);
            this.uncommon.add(amq.at, 12);
            this.uncommon.add(TFItems.steeleafIngot, 4);
            this.rare.add(TFItems.nagaScale, 1);
            this.rare.addEnchanted(new ur(TFItems.ironwoodPick, 1), xc.r, 1, xc.u, 1);
            this.rare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(TFItems.moonwormQueen, 1);
            this.ultrarare.add(TFBlocks.sapling, 1, 4);
            this.ultrarare.add(up.n, 2);
            this.ultrarare.add(TFItems.charmOfLife1, 1);
            this.ultrarare.add(TFItems.charmOfKeeping1, 1);
        }
        if (i == 4) {
            this.common.add(amq.A, 4);
            this.common.add((amq)amq.ai, 4);
            this.common.add((amq)amq.aj, 4);
            this.common.add(up.T, 4);
            this.common.add(up.K, 4);
            this.common.add(up.D, 6);
            this.uncommon.add(up.bf, 4);
            this.uncommon.add(up.bh, 4);
            this.uncommon.add(up.bg, 4);
            this.uncommon.add(up.l, 12);
            this.uncommon.add(TFBlocks.firefly, 4);
            this.rare.add(amq.Z, 3);
            this.rare.add((up)up.be, 1);
            this.rare.add(up.aA, 1);
            this.rare.add(up.k, 1);
            this.rare.add(up.j, 2);
            this.ultrarare.add(up.Q, 1);
            this.ultrarare.add(up.n, 1);
            this.ultrarare.add(up.F, 1);
            this.ultrarare.add(up.at, 1);
        }
        if (i == 5) {
            this.useless.clear();
            this.common.add(up.o, 4);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(up.M, 4);
            this.common.add(TFItems.ironwoodIngot, 4);
            this.common.add(TFBlocks.firefly, 5);
            this.common.add(up.aG, 1);
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
            this.rare.add(amq.ap, 3);
            this.rare.add(new ur((up)up.bs, 1, 16373));
        }
        if (i == 6) {
            this.common.add(up.D, 12);
            this.common.add(up.m, 12);
            this.common.add(up.l, 12);
            this.common.add(TFItems.mazeWafer, 9);
            this.common.add(up.aK, 12);
            this.common.add(up.aF, 4);
            this.common.add(up.F, 1);
            this.uncommon.add(up.aG, 1);
            this.uncommon.add(up.aK, 5);
            this.uncommon.add(up.o, 6);
            this.uncommon.add(TFItems.ironwoodIngot, 8);
            this.uncommon.add(TFBlocks.firefly, 5);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.steeleafIngot, 8);
            this.rare.add(up.at, 1);
            this.rare.add(up.bo, 2);
        }
        if (i == 10) {
            this.useless.clear();
            this.common.add(up.o, 9);
            this.common.add(up.bH, 5);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(TFItems.ironwoodIngot, 9);
            this.common.add(new ur((up)up.bs, 1, 16369));
            this.common.add(new ur((up)up.bs, 1, 16373));
            this.common.add(new ur((up)up.bs, 1, 16370));
            this.uncommon.addEnchanted(new ur(up.k), xc.y, 1, xc.w, 2);
            this.uncommon.addEnchanted(new ur(up.k), xc.v, 3, xc.x, 1);
            this.uncommon.addEnchanted(new ur(TFItems.steeleafShovel), xc.r, 4, xc.t, 2);
            this.uncommon.addEnchanted(new ur(TFItems.steeleafAxe), xc.r, 5);
            this.uncommon.add(TFItems.steeleafIngot, 12);
            this.uncommon.addEnchanted(new ur(TFItems.steeleafPlate), xc.d, 3);
            this.uncommon.addEnchanted(new ur(TFItems.steeleafLegs), xc.e, 4);
            this.uncommon.addEnchanted(new ur(TFItems.steeleafBoots), xc.d, 2);
            this.uncommon.addEnchanted(new ur(TFItems.steeleafHelm), xc.i, 3);
            this.rare.add(amq.bY, 1);
            this.rare.add(amq.bV, 1);
            this.rare.addEnchanted(new ur(TFItems.steeleafPick), xc.r, 4, xc.s, 1);
            this.rare.addEnchanted(new ur(TFItems.steeleafSword), xc.l, 4, xc.o, 2);
            this.rare.addEnchanted(new ur(TFItems.steeleafSword), xc.n, 5, xc.p, 2);
            this.rare.addEnchanted(new ur(TFItems.mazebreakerPick), xc.r, 4, xc.t, 3, xc.u, 2);
        }
        if (i == 7) {
            this.common.add(up.bt, 6);
            this.common.add(new ur((up)up.bs, 1, 0));
            this.common.add(up.aY, 5);
            this.common.add(up.bu, 3);
            this.common.add(up.bp, 1);
            this.common.add(up.bx, 2);
            this.common.add(up.bv, 1);
            this.common.add(up.bB, 2);
            this.common.add(up.bw, 3);
            this.common.add(up.aK, 6);
            this.uncommon.addRandomEnchanted(up.G, 10);
            this.uncommon.addRandomEnchanted(up.ao, 7);
            this.uncommon.add(new ur((up)up.bs, 1, 16274));
            this.uncommon.add(new ur((up)up.bs, 1, 16341));
            this.uncommon.add(new ur((up)up.bs, 1, 16307));
            this.uncommon.add(new ur((up)up.bs, 1, 16348));
            this.rare.addRandomEnchanted(up.al, 18);
            this.rare.add(new ur((up)up.bs, 1, 16306));
            this.rare.add(new ur((up)up.bs, 1, 16305));
            this.rare.add(new ur((up)up.bs, 1, 32725));
            this.rare.add(new ur((up)up.bs, 1, 32764));
            this.rare.add(TFItems.transformPowder, 12);
            this.rare.add(TFItems.charmOfLife1, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.addRandomEnchanted(up.J, 20);
            this.ultrarare.add(up.bn, 1);
            this.ultrarare.add(amq.as, 4);
            this.ultrarare.add(up.n, 1);
            this.ultrarare.add(TFItems.moonwormQueen, 1);
            this.ultrarare.add(TFItems.peacockFan, 1);
        }
        if (i == 8) {
            this.common.add(up.bt, 6);
            this.common.add(new ur((up)up.bs, 1, 0));
            this.common.add(amq.aI, 6);
            this.common.add(up.aK, 6);
            this.common.add(up.aX, 6);
            this.common.add(up.bq, 6);
            this.common.add(up.aI, 12);
            this.uncommon.addRandomEnchanted(up.af, 5);
            this.uncommon.add(up.bE, 3);
            this.uncommon.add(up.aL, 5);
            this.uncommon.add((up)up.bO, 1);
            this.uncommon.add(new ur((up)up.bs, 1, 16));
            this.uncommon.add(new ur((up)up.bs, 1, 16276));
            this.uncommon.add(new ur((up)up.bs, 1, 16312));
            this.rare.addRandomEnchanted(up.k, 5);
            this.rare.addRandomEnchanted(up.v, 10);
            this.rare.addRandomEnchanted(up.r, 15);
            this.rare.add(new ur((up)up.bs, 1, 32696));
            this.rare.add(new ur((up)up.bs, 1, 16369));
            this.rare.add(new ur((up)up.bs, 1, 16373));
            this.rare.add(new ur((up)up.bs, 1, 16370));
            this.rare.add(TFItems.transformPowder, 12);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.addRandomEnchanted(up.I, 10);
            this.ultrarare.addRandomEnchanted(up.q, 20);
            this.ultrarare.addRandomEnchanted(up.k, 30);
            this.ultrarare.add(amq.aq, 5);
            this.ultrarare.add(up.bn, 2);
            this.ultrarare.add(up.bD, 6);
        }
        if (i == 9) {
            this.common.add(new ur((up)up.bs, 1, 0));
            this.common.add(up.bm, 6);
            this.common.add(up.bN, 2);
            this.common.add(up.T, 6);
            this.common.add(up.bL, 6);
            this.common.add(up.bK, 6);
            this.common.add(up.bf, 6);
            this.common.add(up.ax, 1);
            this.common.add(amq.at, 12);
            this.common.add(up.F, 1);
            this.common.add(up.aG, 1);
            this.common.add(up.bh, 5);
            this.uncommon.add(up.U, 8);
            this.uncommon.add(up.bj, 6);
            this.uncommon.add(up.ar, 8);
            this.uncommon.add(up.bM, 8);
            this.uncommon.add(up.bl, 10);
            this.uncommon.add(up.aV, 8);
            this.rare.add(up.bB, 12);
            this.rare.add(up.j, 12);
            this.rare.add((up)up.bO, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.add(up.at, 2);
            this.ultrarare.add(up.bP, 2);
            this.ultrarare.add(up.aZ, 1);
            this.ultrarare.add(up.aE, 1);
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
