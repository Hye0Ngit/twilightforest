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
    
    public boolean generate(final fq world, final Random rand, final int cx, final int cy, final int cz) {
        boolean flag = true;
        world.e(cx, cy, cz, ud.aw.bO);
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
    
    public jm getCommonItem(final Random rand) {
        if (rand.nextInt(4) == 0) {
            return this.useless.getRandomItem(rand);
        }
        return this.common.getRandomItem(rand);
    }
    
    public jm getUncommonItem(final Random rand) {
        return this.uncommon.getRandomItem(rand);
    }
    
    public jm getRareItem(final Random rand) {
        if (rand.nextInt(4) == 0) {
            return this.ultrarare.getRandomItem(rand);
        }
        return this.rare.getRandomItem(rand);
    }
    
    protected boolean addItemToChest(final fq world, final Random rand, final int cx, final int cy, final int cz, final jm itemStack) {
        final kd chest = (kd)world.b(cx, cy, cz);
        if (chest != null) {
            final int slot = this.findRandomInventorySlot(chest, rand);
            if (slot != -1) {
                chest.a(slot, itemStack);
                return true;
            }
        }
        return false;
    }
    
    protected int findRandomInventorySlot(final kd chest, final Random rand) {
        for (int i = 0; i < 100; ++i) {
            final int slot = rand.nextInt(chest.c());
            if (chest.c_(slot) == null) {
                return slot;
            }
        }
        return -1;
    }
    
    protected void fill(final int i) {
        this.useless.add((ud)ud.ag, 4);
        this.useless.add((ud)ud.af, 4);
        this.useless.add(hg.K, 3);
        this.useless.add(hg.R, 2);
        this.useless.add(hg.ao, 2);
        this.useless.add(ud.aX, 2);
        this.useless.add(ud.aZ, 4);
        this.useless.add(ud.G, 4);
        if (i == 1 || i == 2 || i == 3) {
            this.common.add(hg.n, 4);
            this.common.add(hg.S, 4);
            this.common.add(hg.J, 4);
            this.common.add(hg.av, 1);
            this.uncommon.add(hg.T, 1);
            this.uncommon.add(hg.L, 4);
            this.uncommon.add(hg.k, 12);
            this.uncommon.add(ud.as, 12);
            this.rare.add(hg.o, 3);
            this.rare.add(hg.f, 1);
            this.rare.add(hg.az, 1);
            this.ultrarare.add(hg.aP, 1);
            this.ultrarare.add(hg.bD, 1);
            this.ultrarare.add(hg.m, 1);
        }
        if (i == 4) {
            this.common.add(ud.z, 4);
            this.common.add((ud)ud.ah, 4);
            this.common.add((ud)ud.ai, 4);
            this.common.add(hg.S, 4);
            this.common.add(hg.J, 4);
            this.common.add(hg.C, 6);
            this.uncommon.add(hg.be, 4);
            this.uncommon.add(hg.bg, 4);
            this.uncommon.add(hg.bf, 4);
            this.uncommon.add(hg.k, 12);
            this.uncommon.add(TFBlocks.firefly, 4);
            this.rare.add(ud.Y, 3);
            this.rare.add((hg)hg.bd, 1);
            this.rare.add(hg.az, 1);
            this.rare.add(hg.j, 1);
            this.rare.add(hg.i, 2);
            this.ultrarare.add(hg.P, 1);
            this.ultrarare.add(hg.m, 1);
            this.ultrarare.add(hg.E, 1);
            this.ultrarare.add(hg.as, 1);
        }
        if (i == 5) {
            this.common.add(hg.n, 4);
            this.common.add(hg.T, 1);
            this.common.add(hg.S, 6);
            this.common.add(hg.L, 4);
            this.common.add(hg.W, 1);
            this.common.add(hg.U, 1);
            this.common.add(hg.X, 1);
            this.common.add(hg.V, 1);
            this.uncommon.add(hg.ae, 1);
            this.uncommon.add(hg.ac, 1);
            this.uncommon.add(hg.af, 1);
            this.uncommon.add(hg.ad, 1);
            this.uncommon.add(hg.p, 1);
            this.uncommon.add(hg.g, 1);
            this.uncommon.add(hg.j, 1);
            this.rare.add(hg.aB, 6);
            this.rare.add(hg.aS, 4);
            this.rare.add(ud.ao, 3);
            this.rare.add(hg.bi, 1);
            this.ultrarare.add(hg.az, 1);
            this.ultrarare.add(hg.aK, 1);
            this.ultrarare.add(hg.ar, 1);
            this.ultrarare.add(hg.as, 1);
            this.ultrarare.add(hg.bD, 1);
        }
        if (i == 6) {
            this.common.add(hg.C, 12);
            this.common.add(hg.l, 12);
            this.common.add(hg.k, 12);
            this.common.add(hg.S, 4);
            this.uncommon.add(hg.L, 4);
            this.uncommon.add(ud.z, 6);
            this.uncommon.add(hg.aE, 4);
            this.uncommon.add(hg.J, 4);
            this.uncommon.add(hg.aJ, 3);
            this.uncommon.add(hg.T, 1);
            this.rare.add(hg.n, 3);
            this.rare.add(hg.aB, 6);
            this.rare.add(hg.aS, 4);
            this.ultrarare.add(hg.aK, 1);
            this.ultrarare.add(hg.n, 10);
            this.ultrarare.add(hg.bb, 1);
        }
        if (i == 7) {
            this.common.add(hg.aC, 6);
            this.common.add(hg.aJ, 4);
            this.common.add(hg.k, 12);
            this.common.add(hg.K, 11);
            this.uncommon.add(hg.F, 1);
            this.uncommon.add(hg.H, 1);
            this.uncommon.add(ud.aS, 4);
            this.uncommon.add(hg.J, 4);
            this.uncommon.add(hg.aK, 1);
            this.uncommon.add(hg.T, 1);
            this.rare.add(hg.aL, 3);
            this.rare.add(hg.aB, 6);
            this.rare.add(hg.aP, 1);
            this.ultrarare.add(hg.bm, 1);
            this.ultrarare.add(ud.ar, 4);
            this.ultrarare.add(hg.m, 1);
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
