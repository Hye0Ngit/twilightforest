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
    public static TFTreasure tree_cache;
    public static TFTreasure stronghold_cache;
    public static TFTreasure stronghold_room;
    
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
    
    public boolean generate(final abv world, final Random rand, final int cx, final int cy, final int cz) {
        return this.generate(world, rand, cx, cy, cz, aqw.az.cF);
    }
    
    public boolean generate(final abv world, final Random rand, final int cx, final int cy, final int cz, final int chestBlock) {
        boolean flag = true;
        this.treasureRNG.setSeed(world.H() * cx + cy ^ (long)cz);
        world.f(cx, cy, cz, chestBlock, 0, 2);
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
    
    public yd getCommonItem(final Random rand) {
        if (!this.useless.isEmpty() && rand.nextInt(4) == 0) {
            return this.useless.getRandomItem(rand);
        }
        return this.common.getRandomItem(rand);
    }
    
    public yd getUncommonItem(final Random rand) {
        return this.uncommon.getRandomItem(rand);
    }
    
    public yd getRareItem(final Random rand) {
        if (!this.ultrarare.isEmpty() && rand.nextInt(4) == 0) {
            return this.ultrarare.getRandomItem(rand);
        }
        return this.rare.getRandomItem(rand);
    }
    
    protected boolean addItemToChest(final abv world, final Random rand, final int cx, final int cy, final int cz, final yd itemStack) {
        final arv chest = (arv)world.r(cx, cy, cz);
        if (chest != null) {
            final int slot = this.findRandomInventorySlot(chest, rand);
            if (slot != -1) {
                chest.a(slot, itemStack);
                return true;
            }
        }
        return false;
    }
    
    protected int findRandomInventorySlot(final arv chest, final Random rand) {
        for (int i = 0; i < 100; ++i) {
            final int slot = rand.nextInt(chest.j_());
            if (chest.a(slot) == null) {
                return slot;
            }
        }
        return -1;
    }
    
    protected void fill(final int i) {
        this.useless.add((aqw)aqw.aj, 4);
        this.useless.add((aqw)aqw.ai, 4);
        this.useless.add(yb.N, 3);
        this.useless.add(yb.U, 2);
        this.useless.add(yb.ar, 2);
        this.useless.add(aqw.ba, 2);
        this.useless.add(yb.aL, 4);
        this.useless.add(aqw.J, 4);
        this.useless.add(yb.bL, 1);
        this.useless.add(new yd(yb.aY, 1, 0));
        if (i == 1) {
            this.common.add(yb.q, 4);
            this.common.add(yb.V, 4);
            this.common.add(yb.M, 4);
            this.common.add(yb.ay, 1);
            this.uncommon.add(yb.W, 1);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(yb.O, 4);
            this.uncommon.add(yb.n, 12);
            this.uncommon.add(aqw.av, 12);
            this.rare.add(yb.r, 3);
            this.rare.add(yb.i, 1);
            this.rare.add(TFItems.liveRoot, 3);
            this.ultrarare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(yb.p, 1);
            this.ultrarare.add(TFItems.steeleafIngot, 3);
        }
        if (i == 2) {
            this.common.add(yb.q, 4);
            this.common.add(yb.bM, 4);
            this.common.add(aqw.aK, 6);
            this.common.add(yb.ay, 1);
            this.uncommon.add(yb.bO, 2);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(TFItems.ironwoodIngot, 4);
            this.uncommon.add(yb.n, 12);
            this.uncommon.add(aqw.av, 12);
            this.rare.add(TFItems.nagaScale, 1);
            this.rare.add(TFBlocks.uncraftingTable, 1);
            this.rare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(TFItems.peacockFan, 1);
            this.ultrarare.add(yb.bJ, 6);
            this.ultrarare.add(yb.p, 1);
            this.ultrarare.add(TFItems.charmOfLife1, 1);
        }
        if (i == 3) {
            this.common.add(yb.bs, 9);
            this.common.add(yb.bN, 4);
            this.common.add(yb.aW, 4);
            this.common.add(TFItems.torchberries, 5);
            this.uncommon.add(yb.bV, 1);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(yb.O, 4);
            this.uncommon.add(yb.n, 12);
            this.uncommon.add(aqw.av, 12);
            this.uncommon.add(TFItems.steeleafIngot, 4);
            this.rare.add(TFItems.nagaScale, 1);
            this.rare.addEnchanted(new yd(TFItems.ironwoodPick, 1), aat.r, 1, aat.u, 1);
            this.rare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(TFItems.moonwormQueen, 1);
            this.ultrarare.add(TFBlocks.sapling, 1, 4);
            this.ultrarare.add(yb.p, 2);
            this.ultrarare.add(TFItems.charmOfLife1, 1);
            this.ultrarare.add(TFItems.charmOfKeeping1, 1);
        }
        if (i == 4) {
            this.common.add(aqw.C, 4);
            this.common.add((aqw)aqw.ak, 4);
            this.common.add((aqw)aqw.al, 4);
            this.common.add(yb.V, 4);
            this.common.add(yb.M, 4);
            this.common.add(yb.F, 6);
            this.uncommon.add(yb.bh, 4);
            this.uncommon.add(yb.bj, 4);
            this.uncommon.add(yb.bi, 4);
            this.uncommon.add(yb.n, 12);
            this.uncommon.add(TFBlocks.firefly, 4);
            this.rare.add(aqw.ab, 3);
            this.rare.add((yb)yb.bg, 1);
            this.rare.add(yb.aC, 1);
            this.rare.add((yb)yb.m, 1);
            this.rare.add(yb.l, 2);
            this.ultrarare.add(yb.S, 1);
            this.ultrarare.add(yb.p, 1);
            this.ultrarare.add(yb.H, 1);
            this.ultrarare.add(yb.av, 1);
        }
        if (i == 5) {
            this.useless.clear();
            this.common.add(yb.q, 4);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(yb.O, 4);
            this.common.add(TFItems.ironwoodIngot, 4);
            this.common.add(TFBlocks.firefly, 5);
            this.common.add(yb.aI, 1);
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
            this.rare.add(aqw.ar, 3);
            this.rare.add(new yd((yb)yb.bu, 1, 16373));
        }
        if (i == 6) {
            this.common.add(yb.F, 12);
            this.common.add(yb.o, 12);
            this.common.add(yb.n, 12);
            this.common.add(TFItems.mazeWafer, 9);
            this.common.add(yb.aM, 12);
            this.common.add(yb.aH, 4);
            this.common.add(yb.H, 1);
            this.uncommon.add(yb.aI, 1);
            this.uncommon.add(yb.aM, 5);
            this.uncommon.add(yb.q, 6);
            this.uncommon.add(TFItems.ironwoodIngot, 8);
            this.uncommon.add(TFBlocks.firefly, 5);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.steeleafIngot, 8);
            this.rare.add(yb.av, 1);
            this.rare.add(yb.bq, 2);
        }
        if (i == 10) {
            this.useless.clear();
            this.common.add(yb.q, 9);
            this.common.add(yb.bJ, 5);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(TFItems.ironwoodIngot, 9);
            this.common.add(new yd((yb)yb.bu, 1, 16369));
            this.common.add(new yd((yb)yb.bu, 1, 16373));
            this.common.add(new yd((yb)yb.bu, 1, 16370));
            this.uncommon.addEnchanted(new yd((yb)yb.m), aat.y, 1, aat.w, 2);
            this.uncommon.addEnchanted(new yd((yb)yb.m), aat.v, 3, aat.x, 1);
            this.uncommon.addEnchanted(new yd(TFItems.steeleafShovel), aat.r, 4, aat.t, 2);
            this.uncommon.addEnchanted(new yd(TFItems.steeleafAxe), aat.r, 5);
            this.uncommon.add(TFItems.steeleafIngot, 12);
            this.uncommon.addEnchanted(new yd(TFItems.steeleafPlate), aat.d, 3);
            this.uncommon.addEnchanted(new yd(TFItems.steeleafLegs), aat.e, 4);
            this.uncommon.addEnchanted(new yd(TFItems.steeleafBoots), aat.d, 2);
            this.uncommon.addEnchanted(new yd(TFItems.steeleafHelm), aat.i, 3);
            this.rare.add(aqw.ca, 1);
            this.rare.add(aqw.bX, 1);
            this.rare.addEnchanted(new yd(TFItems.steeleafPick), aat.r, 4, aat.s, 1);
            this.rare.addEnchanted(new yd(TFItems.steeleafSword), aat.l, 4, aat.o, 2);
            this.rare.addEnchanted(new yd(TFItems.steeleafSword), aat.n, 5, aat.p, 2);
            this.rare.addEnchanted(new yd(TFItems.mazebreakerPick), aat.r, 4, aat.t, 3, aat.u, 2);
        }
        if (i == 7) {
            this.common.add(yb.bv, 6);
            this.common.add(new yd((yb)yb.bu, 1, 0));
            this.common.add(yb.ba, 5);
            this.common.add(yb.bw, 3);
            this.common.add(yb.br, 1);
            this.common.add(yb.bz, 2);
            this.common.add(yb.bx, 1);
            this.common.add(yb.bD, 2);
            this.common.add(yb.by, 3);
            this.common.add(yb.aM, 6);
            this.uncommon.addRandomEnchanted(yb.I, 10);
            this.uncommon.addRandomEnchanted((yb)yb.aq, 7);
            this.uncommon.add(new yd((yb)yb.bu, 1, 16274));
            this.uncommon.add(new yd((yb)yb.bu, 1, 16341));
            this.uncommon.add(new yd((yb)yb.bu, 1, 16307));
            this.uncommon.add(new yd((yb)yb.bu, 1, 16348));
            this.rare.addRandomEnchanted((yb)yb.an, 18);
            this.rare.add(new yd((yb)yb.bu, 1, 16306));
            this.rare.add(new yd((yb)yb.bu, 1, 16305));
            this.rare.add(new yd((yb)yb.bu, 1, 32725));
            this.rare.add(new yd((yb)yb.bu, 1, 32764));
            this.rare.add(TFItems.transformPowder, 12);
            this.rare.add(TFItems.charmOfLife1, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.addRandomEnchanted(yb.L, 20);
            this.ultrarare.add(yb.bp, 1);
            this.ultrarare.add(aqw.au, 4);
            this.ultrarare.add(yb.p, 1);
            this.ultrarare.add(TFItems.moonwormQueen, 1);
            this.ultrarare.add(TFItems.peacockFan, 1);
        }
        if (i == 8) {
            this.common.add(yb.bv, 6);
            this.common.add(new yd((yb)yb.bu, 1, 0));
            this.common.add(aqw.aK, 6);
            this.common.add(yb.aM, 6);
            this.common.add(yb.aZ, 6);
            this.common.add(yb.bs, 6);
            this.common.add(yb.aK, 12);
            this.uncommon.addRandomEnchanted((yb)yb.ah, 5);
            this.uncommon.add(yb.bG, 3);
            this.uncommon.add(yb.aN, 5);
            this.uncommon.add((yb)yb.bQ, 1);
            this.uncommon.add(new yd((yb)yb.bu, 1, 16));
            this.uncommon.add(new yd((yb)yb.bu, 1, 16276));
            this.uncommon.add(new yd((yb)yb.bu, 1, 16312));
            this.rare.addRandomEnchanted((yb)yb.m, 5);
            this.rare.addRandomEnchanted(yb.x, 10);
            this.rare.addRandomEnchanted(yb.t, 15);
            this.rare.add(new yd((yb)yb.bu, 1, 32696));
            this.rare.add(new yd((yb)yb.bu, 1, 16369));
            this.rare.add(new yd((yb)yb.bu, 1, 16373));
            this.rare.add(new yd((yb)yb.bu, 1, 16370));
            this.rare.add(TFItems.transformPowder, 12);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.addRandomEnchanted(yb.K, 10);
            this.ultrarare.addRandomEnchanted(yb.s, 20);
            this.ultrarare.addRandomEnchanted((yb)yb.m, 30);
            this.ultrarare.add(aqw.as, 5);
            this.ultrarare.add(yb.bp, 2);
            this.ultrarare.add(yb.bF, 6);
        }
        if (i == 9) {
            this.common.add(new yd((yb)yb.bu, 1, 0));
            this.common.add(yb.bo, 6);
            this.common.add(yb.bP, 2);
            this.common.add(yb.V, 6);
            this.common.add(yb.bN, 6);
            this.common.add(yb.bM, 6);
            this.common.add(yb.bh, 6);
            this.common.add(yb.az, 1);
            this.common.add(aqw.av, 12);
            this.common.add(yb.H, 1);
            this.common.add(yb.aI, 1);
            this.common.add(yb.bj, 5);
            this.uncommon.add(yb.W, 8);
            this.uncommon.add(yb.bl, 6);
            this.uncommon.add(yb.at, 8);
            this.uncommon.add(yb.bO, 8);
            this.uncommon.add(yb.bn, 10);
            this.uncommon.add(yb.aX, 8);
            this.rare.add(yb.bD, 12);
            this.rare.add(yb.l, 12);
            this.rare.add((yb)yb.bQ, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.add(yb.av, 2);
            this.ultrarare.add(yb.bR, 2);
            this.ultrarare.add(yb.bb, 1);
            this.ultrarare.add(yb.aG, 1);
            this.ultrarare.add(new yd(TFBlocks.sapling, 1, 4));
        }
        if (i == 11) {
            this.common.add(yb.F, 12);
            this.common.add(new yd(yb.o, 12, 1));
            this.common.add(yb.n, 12);
            this.common.add(TFItems.experiment115, 9);
            this.common.add(new yd(aqw.ag, 1, 14));
            this.common.add(yb.aE, 6);
            this.uncommon.add(aqw.bQ, 3);
            this.uncommon.add(yb.q, 6);
            this.uncommon.add(TFItems.ironwoodIngot, 8);
            this.uncommon.add(TFBlocks.firefly, 5);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.steeleafIngot, 8);
            this.rare.add(yb.p, 2);
        }
        if (i == 12) {
            this.useless.clear();
            this.common.add(yb.q, 4);
            this.common.add(TFItems.experiment115, 12);
            this.common.add(yb.O, 4);
            this.common.add(TFItems.ironwoodIngot, 4);
            this.common.add(TFBlocks.firefly, 5);
            this.common.add(yb.aE, 12);
            this.common.add(yb.aV, 12);
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
            this.rare.addEnchantedBook(aat.f, 3);
            this.rare.addEnchantedBook(aat.o, 2);
            this.rare.addEnchantedBook(aat.r, 3);
        }
        if (i == 13) {
            this.useless.clear();
            this.common.add(TFItems.carminite, 3);
            this.uncommon.add(TFItems.fieryBlood, 5);
            this.rare.add(new yd(TFItems.trophy, 1, 3));
        }
        if (i == 14) {
            this.common.add(yb.bP, 2);
            this.common.add(yb.V, 6);
            this.common.add(yb.bN, 6);
            this.common.add(yb.bM, 6);
            this.common.add(yb.bh, 6);
            this.common.add(yb.az, 1);
            this.common.add(yb.aI, 1);
            this.common.add(yb.bj, 5);
            this.uncommon.add(new yd(TFBlocks.firefly, 12));
            this.uncommon.add(new yd(TFBlocks.sapling, 4, 0));
            this.uncommon.add(new yd(TFBlocks.sapling, 4, 1));
            this.uncommon.add(new yd(TFBlocks.sapling, 4, 2));
            this.uncommon.add(new yd(TFBlocks.sapling, 4, 3));
            this.rare.add(yb.bV, 12);
            this.rare.add(yb.l, 12);
            this.rare.add(TFItems.charmOfLife1, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.add(new yd(TFBlocks.sapling, 1, 4));
            this.ultrarare.add(new yd(TFBlocks.sapling, 1, 5));
            this.ultrarare.add(new yd(TFBlocks.sapling, 1, 6));
            this.ultrarare.add(new yd(TFBlocks.sapling, 1, 7));
            this.ultrarare.add(new yd(TFBlocks.sapling, 1, 8));
        }
        if (i == 15) {
            this.common.add(yb.F, 12);
            this.common.add(new yd(yb.o, 12));
            this.common.add(yb.n, 12);
            this.common.add(TFItems.mazeWafer, 9);
            this.common.add(new yd(aqw.ag, 1, 11));
            this.common.add(yb.q, 2);
            this.uncommon.add(yb.ay, 1);
            this.uncommon.add(yb.q, 6);
            this.uncommon.add(TFItems.ironwoodIngot, 6);
            this.uncommon.add(TFBlocks.firefly, 5);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.uncommon.add(TFItems.armorShard, 3);
            this.rare.add(TFItems.knightMetal, 8);
            this.rare.addRandomEnchanted((yb)yb.m, 20);
            this.rare.addRandomEnchanted(yb.s, 20);
            this.rare.addRandomEnchanted(TFItems.ironwoodSword, 15);
            this.rare.addRandomEnchanted(TFItems.steeleafSword, 10);
            this.ultrarare.addEnchantedBook(aat.n, 4);
            this.ultrarare.addEnchantedBook(aat.l, 4);
            this.ultrarare.addEnchantedBook(aat.m, 4);
            this.ultrarare.addEnchantedBook(aat.t, 2);
            this.ultrarare.addEnchantedBook(aat.t, 2);
            this.ultrarare.addEnchantedBook(aat.d, 3);
            this.ultrarare.addEnchantedBook(aat.h, 3);
            this.ultrarare.addEnchantedBook(aat.f, 3);
        }
        if (i == 16) {
            this.useless.clear();
            this.common.add(yb.q, 4);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(yb.O, 4);
            this.common.add(TFItems.ironwoodIngot, 4);
            this.common.add(TFBlocks.firefly, 5);
            this.common.add(yb.aI, 1);
            this.uncommon.add(TFItems.steeleafIngot, 6);
            this.uncommon.add(TFItems.steeleafLegs, 1);
            this.uncommon.add(TFItems.steeleafPlate, 1);
            this.uncommon.add(TFItems.steeleafHelm, 1);
            this.uncommon.add(TFItems.steeleafBoots, 1);
            this.uncommon.add(TFItems.steeleafPick, 1);
            this.uncommon.add(TFItems.ironwoodPlate, 1);
            this.uncommon.add(TFItems.ironwoodSword, 1);
            this.uncommon.add(TFItems.charmOfLife1, 1);
            this.rare.add(TFItems.mazeMapFocus, 1);
            this.rare.addRandomEnchanted((yb)yb.m, 30);
            this.rare.addRandomEnchanted(yb.s, 30);
            this.rare.addRandomEnchanted(TFItems.ironwoodSword, 25);
            this.rare.addRandomEnchanted(TFItems.steeleafSword, 20);
            this.rare.addRandomEnchanted(yb.B, 15);
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
        TFTreasure.tree_cache = new TFTreasure(14);
        TFTreasure.stronghold_cache = new TFTreasure(15);
        TFTreasure.stronghold_room = new TFTreasure(16);
    }
}
