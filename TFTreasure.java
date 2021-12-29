import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

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
    
    public TFTreasure(final int i) {
        this.type = i;
        this.useless = new TFTreasureTable();
        this.common = new TFTreasureTable();
        this.uncommon = new TFTreasureTable();
        this.rare = new TFTreasureTable();
        this.ultrarare = new TFTreasureTable();
        this.fill(i);
    }
    
    public boolean generate(final wz world, final Random rand, final int cx, final int cy, final int cz) {
        boolean flag = true;
        world.g(cx, cy, cz, ox.au.bO);
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
    
    public aai getCommonItem(final Random rand) {
        if (rand.nextInt(4) == 0) {
            return this.useless.getRandomItem(rand);
        }
        return this.common.getRandomItem(rand);
    }
    
    public aai getUncommonItem(final Random rand) {
        return this.uncommon.getRandomItem(rand);
    }
    
    public aai getRareItem(final Random rand) {
        if (rand.nextInt(4) == 0) {
            return this.ultrarare.getRandomItem(rand);
        }
        return this.rare.getRandomItem(rand);
    }
    
    protected boolean addItemToChest(final wz world, final Random rand, final int cx, final int cy, final int cz, final aai itemStack) {
        final gy chest = (gy)world.b(cx, cy, cz);
        if (chest != null) {
            final int slot = this.findRandomInventorySlot(chest, rand);
            if (slot != -1) {
                chest.a(slot, itemStack);
                return true;
            }
        }
        return false;
    }
    
    protected int findRandomInventorySlot(final gy chest, final Random rand) {
        for (int i = 0; i < 100; ++i) {
            final int slot = rand.nextInt(chest.a());
            if (chest.k_(slot) == null) {
                return slot;
            }
        }
        return -1;
    }
    
    protected void fill(final int i) {
        this.useless.add((ox)ox.ae, 4);
        this.useless.add((ox)ox.ad, 4);
        this.useless.add(ym.L, 3);
        this.useless.add(ym.S, 2);
        this.useless.add(ym.ap, 2);
        this.useless.add(ox.aV, 2);
        this.useless.add(ym.aJ, 4);
        this.useless.add(ox.E, 4);
        if (i == 1 || i == 2 || i == 3) {
            this.common.add(ym.o, 4);
            this.common.add(ym.T, 4);
            this.common.add(ym.K, 4);
            this.common.add(ym.aw, 1);
            this.uncommon.add(ym.U, 1);
            this.uncommon.add(ym.M, 4);
            this.uncommon.add(ym.l, 12);
            this.uncommon.add(ox.aq, 12);
            this.rare.add(ym.p, 3);
            this.rare.add(ym.g, 1);
            this.rare.add(ym.aA, 1);
            this.ultrarare.add(ym.aQ, 1);
            this.ultrarare.add(ym.bG, 1);
            this.ultrarare.add(ym.n, 1);
        }
        if (i == 4) {
            this.common.add(ox.x, 4);
            this.common.add((ox)ox.af, 4);
            this.common.add((ox)ox.ag, 4);
            this.common.add(ym.T, 4);
            this.common.add(ym.K, 4);
            this.common.add(ym.D, 6);
            this.uncommon.add(ym.bf, 4);
            this.uncommon.add(ym.bh, 4);
            this.uncommon.add(ym.bg, 4);
            this.uncommon.add(ym.l, 12);
            this.uncommon.add(TFBlocks.firefly, 4);
            this.rare.add(ox.W, 3);
            this.rare.add((ym)ym.be, 1);
            this.rare.add(ym.aA, 1);
            this.rare.add(ym.k, 1);
            this.rare.add(ym.j, 2);
            this.ultrarare.add(ym.Q, 1);
            this.ultrarare.add(ym.n, 1);
            this.ultrarare.add(ym.F, 1);
            this.ultrarare.add(ym.at, 1);
        }
        if (i == 5) {
            this.common.add(ym.o, 4);
            this.common.add(ym.U, 1);
            this.common.add(ym.T, 6);
            this.common.add(ym.M, 4);
            this.common.add(ym.X, 1);
            this.common.add(ym.V, 1);
            this.common.add(ym.Y, 1);
            this.common.add(ym.W, 1);
            this.uncommon.add(ym.af, 1);
            this.uncommon.add(ym.ad, 1);
            this.uncommon.add(ym.ag, 1);
            this.uncommon.add(ym.ae, 1);
            this.uncommon.add(ym.q, 1);
            this.uncommon.add(ym.h, 1);
            this.uncommon.add(ym.k, 1);
            this.rare.add(ym.aC, 6);
            this.rare.add(ym.aT, 4);
            this.rare.add(ox.am, 3);
            this.rare.add(ym.bj, 1);
            this.ultrarare.add(ym.aA, 1);
            this.ultrarare.add(ym.aL, 1);
            this.ultrarare.add(ym.as, 1);
            this.ultrarare.add(ym.at, 1);
            this.ultrarare.add(ym.bG, 1);
        }
        if (i == 6) {
            this.common.add(ym.D, 12);
            this.common.add(ym.m, 12);
            this.common.add(ym.l, 12);
            this.common.add(ym.T, 4);
            this.uncommon.add(ym.M, 4);
            this.uncommon.add(ox.x, 6);
            this.uncommon.add(ym.aF, 4);
            this.uncommon.add(ym.K, 4);
            this.uncommon.add(ym.aK, 3);
            this.uncommon.add(ym.U, 1);
            this.rare.add(ym.o, 3);
            this.rare.add(ym.aC, 6);
            this.rare.add(ym.aT, 4);
            this.ultrarare.add(ym.aL, 1);
            this.ultrarare.add(ym.o, 10);
            this.ultrarare.add(ym.bc, 1);
        }
        if (i == 7) {
            this.common.add(ym.aD, 6);
            this.common.add(ym.aK, 4);
            this.common.add(ym.l, 12);
            this.common.add(ym.L, 11);
            this.uncommon.add(ym.G, 1);
            this.uncommon.add(ym.I, 1);
            this.uncommon.add(ox.aQ, 4);
            this.uncommon.add(ym.K, 4);
            this.uncommon.add(ym.aL, 1);
            this.uncommon.add(ym.U, 1);
            this.rare.add(ym.aM, 3);
            this.rare.add(ym.aC, 6);
            this.rare.add(ym.aQ, 1);
            this.ultrarare.add(ym.bn, 1);
            this.ultrarare.add(ox.ap, 4);
            this.ultrarare.add(ym.n, 1);
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
    }
}
