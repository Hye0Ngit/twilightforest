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
    
    public boolean generate(final ry world, final Random rand, final int cx, final int cy, final int cz) {
        boolean flag = true;
        world.g(cx, cy, cz, yy.au.bM);
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
    
    public dk getCommonItem(final Random rand) {
        if (rand.nextInt(4) == 0) {
            return this.useless.getRandomItem(rand);
        }
        return this.common.getRandomItem(rand);
    }
    
    public dk getUncommonItem(final Random rand) {
        return this.uncommon.getRandomItem(rand);
    }
    
    public dk getRareItem(final Random rand) {
        if (rand.nextInt(4) == 0) {
            return this.ultrarare.getRandomItem(rand);
        }
        return this.rare.getRandomItem(rand);
    }
    
    protected boolean addItemToChest(final ry world, final Random rand, final int cx, final int cy, final int cz, final dk itemStack) {
        final tu chest = (tu)world.b(cx, cy, cz);
        if (chest != null) {
            final int slot = this.findRandomInventorySlot(chest, rand);
            if (slot != -1) {
                chest.a(slot, itemStack);
                return true;
            }
        }
        return false;
    }
    
    protected int findRandomInventorySlot(final tu chest, final Random rand) {
        for (int i = 0; i < 100; ++i) {
            final int slot = rand.nextInt(chest.c());
            if (chest.d(slot) == null) {
                return slot;
            }
        }
        return -1;
    }
    
    protected void fill(final int i) {
        this.useless.add((yy)yy.ae, 4);
        this.useless.add((yy)yy.ad, 4);
        this.useless.add(acy.K, 3);
        this.useless.add(acy.R, 2);
        this.useless.add(acy.ao, 2);
        this.useless.add(yy.aV, 2);
        this.useless.add(yy.aX, 4);
        this.useless.add(yy.E, 4);
        if (i == 1 || i == 2 || i == 3) {
            this.common.add(acy.n, 4);
            this.common.add(acy.S, 4);
            this.common.add(acy.J, 4);
            this.common.add(acy.av, 1);
            this.uncommon.add(acy.T, 1);
            this.uncommon.add(acy.L, 4);
            this.uncommon.add(acy.k, 12);
            this.uncommon.add(yy.aq, 12);
            this.rare.add(acy.o, 3);
            this.rare.add(acy.f, 1);
            this.rare.add(acy.az, 1);
            this.ultrarare.add(acy.aP, 1);
            this.ultrarare.add(acy.bC, 1);
            this.ultrarare.add(acy.m, 1);
        }
        if (i == 4) {
            this.common.add(yy.x, 4);
            this.common.add((yy)yy.af, 4);
            this.common.add((yy)yy.ag, 4);
            this.common.add(acy.S, 4);
            this.common.add(acy.J, 4);
            this.common.add(acy.C, 6);
            this.uncommon.add(acy.be, 4);
            this.uncommon.add(acy.bg, 4);
            this.uncommon.add(acy.bf, 4);
            this.uncommon.add(acy.k, 12);
            this.uncommon.add(TFBlocks.firefly, 4);
            this.rare.add(yy.W, 3);
            this.rare.add((acy)acy.bd, 1);
            this.rare.add(acy.az, 1);
            this.rare.add(acy.j, 1);
            this.rare.add(acy.i, 2);
            this.ultrarare.add(acy.P, 1);
            this.ultrarare.add(acy.m, 1);
            this.ultrarare.add(acy.E, 1);
            this.ultrarare.add(acy.as, 1);
        }
        if (i == 5) {
            this.common.add(acy.n, 4);
            this.common.add(acy.T, 1);
            this.common.add(acy.S, 6);
            this.common.add(acy.L, 4);
            this.common.add(acy.W, 1);
            this.common.add(acy.U, 1);
            this.common.add(acy.X, 1);
            this.common.add(acy.V, 1);
            this.uncommon.add(acy.ae, 1);
            this.uncommon.add(acy.ac, 1);
            this.uncommon.add(acy.af, 1);
            this.uncommon.add(acy.ad, 1);
            this.uncommon.add(acy.p, 1);
            this.uncommon.add(acy.g, 1);
            this.uncommon.add(acy.j, 1);
            this.rare.add(acy.aB, 6);
            this.rare.add(acy.aS, 4);
            this.rare.add(yy.am, 3);
            this.rare.add(acy.bi, 1);
            this.ultrarare.add(acy.az, 1);
            this.ultrarare.add(acy.aK, 1);
            this.ultrarare.add(acy.ar, 1);
            this.ultrarare.add(acy.as, 1);
            this.ultrarare.add(acy.bC, 1);
        }
        if (i == 6) {
            this.common.add(acy.C, 12);
            this.common.add(acy.l, 12);
            this.common.add(acy.k, 12);
            this.common.add(acy.S, 4);
            this.uncommon.add(acy.L, 4);
            this.uncommon.add(yy.x, 6);
            this.uncommon.add(acy.aE, 4);
            this.uncommon.add(acy.J, 4);
            this.uncommon.add(acy.aJ, 3);
            this.uncommon.add(acy.T, 1);
            this.rare.add(acy.n, 3);
            this.rare.add(acy.aB, 6);
            this.rare.add(acy.aS, 4);
            this.ultrarare.add(acy.aK, 1);
            this.ultrarare.add(acy.n, 10);
            this.ultrarare.add(acy.bb, 1);
        }
        if (i == 7) {
            this.common.add(acy.aC, 6);
            this.common.add(acy.aJ, 4);
            this.common.add(acy.k, 12);
            this.common.add(acy.K, 11);
            this.uncommon.add(acy.F, 1);
            this.uncommon.add(acy.H, 1);
            this.uncommon.add(yy.aQ, 4);
            this.uncommon.add(acy.J, 4);
            this.uncommon.add(acy.aK, 1);
            this.uncommon.add(acy.T, 1);
            this.rare.add(acy.aL, 3);
            this.rare.add(acy.aB, 6);
            this.rare.add(acy.aP, 1);
            this.ultrarare.add(acy.bm, 1);
            this.ultrarare.add(yy.ap, 4);
            this.ultrarare.add(acy.m, 1);
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
