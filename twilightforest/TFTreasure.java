// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFTreasure
{
    int type;
    protected TFTreasureTable useless;
    protected TFTreasureTable common;
    protected TFTreasureTable uncommon;
    protected TFTreasureTable rare;
    protected TFTreasureTable ultrarare;
    public static TFTreasure hill1;
    public static TFTreasure hill2;
    public static TFTreasure hill3;
    public static TFTreasure hedgemaze;
    public static TFTreasure underhill_room;
    public static TFTreasure underhill_deadend;
    public static TFTreasure tower_room;
    public static TFTreasure tower_library;
    public static TFTreasure basement;
    
    public TFTreasure(final int i) {
        this.type = i;
        this.useless = new TFTreasureTable();
        this.common = new TFTreasureTable();
        this.uncommon = new TFTreasureTable();
        this.rare = new TFTreasureTable();
        this.ultrarare = new TFTreasureTable();
        this.fill(i);
    }
    
    public boolean generate(final xd world, final Random rand, final int cx, final int cy, final int cz) {
        boolean flag = true;
        world.g(cx, cy, cz, pb.au.bO);
        for (int i = 0; i < 4; ++i) {
            flag &= this.addItemToChest(world, rand, cx, cy, cz, this.getCommonItem(rand));
        }
        for (int i = 0; i < 2; ++i) {
            flag &= this.addItemToChest(world, rand, cx, cy, cz, this.getUncommonItem(rand));
        }
        for (int i = 0; i < 1; ++i) {
            flag &= this.addItemToChest(world, rand, cx, cy, cz, this.getRareItem(rand));
        }
        return flag;
    }
    
    public aan getCommonItem(final Random rand) {
        if (rand.nextInt(4) == 0) {
            return this.useless.getRandomItem(rand);
        }
        return this.common.getRandomItem(rand);
    }
    
    public aan getUncommonItem(final Random rand) {
        return this.uncommon.getRandomItem(rand);
    }
    
    public aan getRareItem(final Random rand) {
        if (rand.nextInt(4) == 0) {
            return this.ultrarare.getRandomItem(rand);
        }
        return this.rare.getRandomItem(rand);
    }
    
    protected boolean addItemToChest(final xd world, final Random rand, final int cx, final int cy, final int cz, final aan itemStack) {
        final hb chest = (hb)world.b(cx, cy, cz);
        if (chest != null) {
            final int slot = this.findRandomInventorySlot(chest, rand);
            if (slot != -1) {
                chest.a(slot, itemStack);
                return true;
            }
        }
        return false;
    }
    
    protected int findRandomInventorySlot(final hb chest, final Random rand) {
        for (int i = 0; i < 100; ++i) {
            final int slot = rand.nextInt(chest.a());
            if (chest.k_(slot) == null) {
                return slot;
            }
        }
        return -1;
    }
    
    protected void fill(final int i) {
        this.useless.add((pb)pb.ae, 4);
        this.useless.add((pb)pb.ad, 4);
        this.useless.add(yr.L, 3);
        this.useless.add(yr.S, 2);
        this.useless.add(yr.ap, 2);
        this.useless.add(pb.aV, 2);
        this.useless.add(yr.aJ, 4);
        this.useless.add(pb.E, 4);
        if (i == 1 || i == 2 || i == 3) {
            this.common.add(yr.o, 4);
            this.common.add(yr.T, 4);
            this.common.add(yr.K, 4);
            this.common.add(yr.aw, 1);
            this.uncommon.add(yr.U, 1);
            this.uncommon.add(yr.M, 4);
            this.uncommon.add(yr.l, 12);
            this.uncommon.add(pb.aq, 12);
            this.rare.add(yr.p, 3);
            this.rare.add(yr.g, 1);
            this.rare.add(yr.aA, 1);
            this.ultrarare.add(yr.aQ, 1);
            this.ultrarare.add(yr.bG, 1);
            this.ultrarare.add(yr.n, 1);
        }
        if (i == 4) {
            this.common.add(pb.x, 4);
            this.common.add((pb)pb.af, 4);
            this.common.add((pb)pb.ag, 4);
            this.common.add(yr.T, 4);
            this.common.add(yr.K, 4);
            this.common.add(yr.D, 6);
            this.uncommon.add(yr.bf, 4);
            this.uncommon.add(yr.bh, 4);
            this.uncommon.add(yr.bg, 4);
            this.uncommon.add(yr.l, 12);
            this.uncommon.add(TFBlocks.critter, 4);
            this.rare.add(pb.W, 3);
            this.rare.add((yr)yr.be, 1);
            this.rare.add(yr.aA, 1);
            this.rare.add(yr.k, 1);
            this.rare.add(yr.j, 2);
            this.ultrarare.add(yr.Q, 1);
            this.ultrarare.add(yr.n, 1);
            this.ultrarare.add(yr.F, 1);
            this.ultrarare.add(yr.at, 1);
        }
        if (i == 5) {
            this.common.add(yr.o, 4);
            this.common.add(yr.U, 1);
            this.common.add(yr.T, 6);
            this.common.add(yr.M, 4);
            this.common.add(yr.X, 1);
            this.common.add(yr.V, 1);
            this.common.add(yr.Y, 1);
            this.common.add(yr.W, 1);
            this.uncommon.add(yr.af, 1);
            this.uncommon.add(yr.ad, 1);
            this.uncommon.add(yr.ag, 1);
            this.uncommon.add(yr.ae, 1);
            this.uncommon.add(yr.q, 1);
            this.uncommon.add(yr.h, 1);
            this.uncommon.add(yr.k, 1);
            this.rare.add(yr.aC, 6);
            this.rare.add(yr.aT, 4);
            this.rare.add(pb.am, 3);
            this.rare.add(yr.bj, 1);
            this.ultrarare.add(yr.aA, 1);
            this.ultrarare.add(yr.aL, 1);
            this.ultrarare.add(yr.as, 1);
            this.ultrarare.add(yr.at, 1);
            this.ultrarare.add(yr.bG, 1);
        }
        if (i == 6) {
            this.common.add(yr.D, 12);
            this.common.add(yr.m, 12);
            this.common.add(yr.l, 12);
            this.common.add(yr.T, 4);
            this.uncommon.add(yr.M, 4);
            this.uncommon.add(pb.x, 6);
            this.uncommon.add(yr.aF, 4);
            this.uncommon.add(yr.K, 4);
            this.uncommon.add(yr.aK, 3);
            this.uncommon.add(yr.U, 1);
            this.rare.add(yr.o, 3);
            this.rare.add(yr.aC, 6);
            this.rare.add(yr.aT, 4);
            this.ultrarare.add(yr.aL, 1);
            this.ultrarare.add(yr.o, 10);
            this.ultrarare.add(yr.bc, 1);
        }
        if (i == 7) {
            this.common.add(yr.bt, 6);
            this.common.add(new aan((yr)yr.bs, 1, 0));
            this.common.add(yr.aY, 5);
            this.common.add(yr.bu, 3);
            this.common.add(yr.bp, 1);
            this.common.add(yr.bx, 2);
            this.common.add(yr.bv, 1);
            this.common.add(yr.bB, 2);
            this.common.add(yr.bw, 3);
            this.common.add(yr.aK, 6);
            final aan goldSword = new aan(yr.G);
            goldSword.a(jt.m, 2);
            this.uncommon.add(goldSword);
            final aan goldBoots = new aan(yr.ao);
            goldBoots.a(jt.d, 3);
            this.uncommon.add(goldBoots);
            this.uncommon.add(new aan((yr)yr.bs, 1, 8194));
            this.uncommon.add(new aan((yr)yr.bs, 1, 8197));
            this.uncommon.add(new aan((yr)yr.bs, 1, 8195));
            this.uncommon.add(new aan((yr)yr.bs, 1, 8204));
            final aan goldHelm = new aan(yr.al);
            goldHelm.a(jt.h, 3);
            this.rare.add(goldHelm);
            this.rare.add(new aan((yr)yr.bs, 1, 8226));
            this.rare.add(new aan((yr)yr.bs, 1, 8225));
            this.rare.add(new aan((yr)yr.bs, 1, 16389));
            this.rare.add(new aan((yr)yr.bs, 1, 16428));
            final aan goldAxe = new aan(yr.J);
            goldAxe.a(jt.r, 2);
            this.ultrarare.add(goldAxe);
            this.ultrarare.add(yr.bn, 1);
            this.ultrarare.add(pb.ap, 4);
            this.ultrarare.add(yr.n, 1);
            this.ultrarare.add(yr.aG, 1);
        }
        if (i == 8) {
            this.common.add(yr.bt, 6);
            this.common.add(new aan((yr)yr.bs, 1, 0));
            this.common.add(yr.aK, 6);
            this.common.add(yr.aX, 6);
            this.common.add(yr.bq, 6);
            this.common.add(yr.aI, 12);
            final aan steelLegs = new aan(yr.af);
            steelLegs.a(jt.f, 2);
            this.uncommon.add(steelLegs);
            this.uncommon.add(yr.bE, 3);
            this.uncommon.add(yr.aL, 5);
            this.uncommon.add((yr)yr.bd, 1);
            this.uncommon.add(new aan((yr)yr.bs, 1, 16));
            this.uncommon.add(new aan((yr)yr.bs, 1, 8196));
            this.uncommon.add(new aan((yr)yr.bs, 1, 8200));
            final aan bow = new aan(yr.k);
            bow.a(jt.u, 1);
            this.rare.add(bow);
            final aan stoneSword = new aan(yr.v);
            stoneSword.a(jt.l, 2);
            stoneSword.a(jt.j, 3);
            this.rare.add(stoneSword);
            final aan woodSword = new aan(yr.r);
            woodSword.a(jt.m, 2);
            woodSword.a(jt.k, 4);
            woodSword.a(jt.l, 1);
            this.rare.add(woodSword);
            this.rare.add(new aan((yr)yr.bs, 1, 16392));
            this.rare.add(new aan((yr)yr.bs, 1, 8225));
            this.rare.add(new aan((yr)yr.bs, 1, 8229));
            this.rare.add(new aan((yr)yr.bs, 1, 8258));
            final aan goldPick = new aan(yr.I);
            goldPick.a(jt.r, 2);
            this.ultrarare.add(goldPick);
            final aan steelSword = new aan(yr.q);
            steelSword.a(jt.n, 2);
            final aan bow2 = new aan(yr.k);
            bow2.a(jt.v, 1);
            this.ultrarare.add(bow2);
            this.ultrarare.add(steelSword);
            this.ultrarare.add(pb.an, 5);
            this.ultrarare.add(yr.bn, 2);
            this.ultrarare.add(yr.aZ, 1);
        }
        if (i == 9) {
            this.common.add(new aan((yr)yr.bs, 1, 0));
            this.common.add(yr.bm, 6);
            this.common.add(yr.T, 6);
            this.common.add(yr.bf, 6);
            this.common.add(yr.ax, 1);
            this.common.add(pb.aq, 12);
            this.common.add(yr.F, 1);
            this.common.add(yr.aG, 1);
            this.common.add(yr.bh, 5);
            this.uncommon.add(yr.U, 8);
            this.uncommon.add(yr.bj, 6);
            this.uncommon.add(yr.ar, 8);
            this.uncommon.add(yr.bl, 10);
            this.uncommon.add(yr.aV, 8);
            this.rare.add(yr.bB, 12);
            this.rare.add(yr.j, 12);
            this.rare.add((yr)yr.bd, 1);
            this.ultrarare.add(yr.at, 2);
            this.ultrarare.add(yr.aZ, 1);
            this.ultrarare.add(yr.aE, 1);
        }
    }
    
    static {
        TFTreasure.hill1 = new TFTreasure(1);
        TFTreasure.hill2 = new TFTreasure(2);
        TFTreasure.hill3 = new TFTreasure(3);
        TFTreasure.hedgemaze = new TFTreasure(4);
        TFTreasure.underhill_room = new TFTreasure(5);
        TFTreasure.underhill_deadend = new TFTreasure(6);
        TFTreasure.tower_room = new TFTreasure(7);
        TFTreasure.tower_library = new TFTreasure(8);
        TFTreasure.basement = new TFTreasure(9);
    }
}
