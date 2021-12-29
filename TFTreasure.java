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
    
    public boolean generate(final ge world, final Random rand, final int cx, final int cy, final int cz) {
        boolean flag = true;
        world.e(cx, cy, cz, vz.au.bO);
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
    
    public kp getCommonItem(final Random rand) {
        if (rand.nextInt(4) == 0) {
            return this.useless.getRandomItem(rand);
        }
        return this.common.getRandomItem(rand);
    }
    
    public kp getUncommonItem(final Random rand) {
        return this.uncommon.getRandomItem(rand);
    }
    
    public kp getRareItem(final Random rand) {
        if (rand.nextInt(4) == 0) {
            return this.ultrarare.getRandomItem(rand);
        }
        return this.rare.getRandomItem(rand);
    }
    
    protected boolean addItemToChest(final ge world, final Random rand, final int cx, final int cy, final int cz, final kp itemStack) {
        final lh chest = (lh)world.b(cx, cy, cz);
        if (chest != null) {
            final int slot = this.findRandomInventorySlot(chest, rand);
            if (slot != -1) {
                chest.a(slot, itemStack);
                return true;
            }
        }
        return false;
    }
    
    protected int findRandomInventorySlot(final lh chest, final Random rand) {
        for (int i = 0; i < 100; ++i) {
            final int slot = rand.nextInt(chest.c());
            if (chest.g_(slot) == null) {
                return slot;
            }
        }
        return -1;
    }
    
    protected void fill(final int i) {
        this.useless.add((vz)vz.ae, 4);
        this.useless.add((vz)vz.ad, 4);
        this.useless.add(id.K, 3);
        this.useless.add(id.R, 2);
        this.useless.add(id.ao, 2);
        this.useless.add(vz.aV, 2);
        this.useless.add(id.aI, 4);
        this.useless.add(vz.E, 4);
        if (i == 1 || i == 2 || i == 3) {
            this.common.add(id.n, 4);
            this.common.add(id.S, 4);
            this.common.add(id.J, 4);
            this.common.add(id.av, 1);
            this.uncommon.add(id.T, 1);
            this.uncommon.add(id.L, 4);
            this.uncommon.add(id.k, 12);
            this.uncommon.add(vz.aq, 12);
            this.rare.add(id.o, 3);
            this.rare.add(id.f, 1);
            this.rare.add(id.az, 1);
            this.ultrarare.add(id.aP, 1);
            this.ultrarare.add(id.bF, 1);
            this.ultrarare.add(id.m, 1);
        }
        if (i == 4) {
            this.common.add(vz.x, 4);
            this.common.add((vz)vz.af, 4);
            this.common.add((vz)vz.ag, 4);
            this.common.add(id.S, 4);
            this.common.add(id.J, 4);
            this.common.add(id.C, 6);
            this.uncommon.add(id.be, 4);
            this.uncommon.add(id.bg, 4);
            this.uncommon.add(id.bf, 4);
            this.uncommon.add(id.k, 12);
            this.uncommon.add(TFBlocks.firefly, 4);
            this.rare.add(vz.W, 3);
            this.rare.add((id)id.bd, 1);
            this.rare.add(id.az, 1);
            this.rare.add(id.j, 1);
            this.rare.add(id.i, 2);
            this.ultrarare.add(id.P, 1);
            this.ultrarare.add(id.m, 1);
            this.ultrarare.add(id.E, 1);
            this.ultrarare.add(id.as, 1);
        }
        if (i == 5) {
            this.common.add(id.n, 4);
            this.common.add(id.T, 1);
            this.common.add(id.S, 6);
            this.common.add(id.L, 4);
            this.common.add(id.W, 1);
            this.common.add(id.U, 1);
            this.common.add(id.X, 1);
            this.common.add(id.V, 1);
            this.uncommon.add(id.ae, 1);
            this.uncommon.add(id.ac, 1);
            this.uncommon.add(id.af, 1);
            this.uncommon.add(id.ad, 1);
            this.uncommon.add(id.p, 1);
            this.uncommon.add(id.g, 1);
            this.uncommon.add(id.j, 1);
            this.rare.add(id.aB, 6);
            this.rare.add(id.aS, 4);
            this.rare.add(vz.am, 3);
            this.rare.add(id.bi, 1);
            this.ultrarare.add(id.az, 1);
            this.ultrarare.add(id.aK, 1);
            this.ultrarare.add(id.ar, 1);
            this.ultrarare.add(id.as, 1);
            this.ultrarare.add(id.bF, 1);
        }
        if (i == 6) {
            this.common.add(id.C, 12);
            this.common.add(id.l, 12);
            this.common.add(id.k, 12);
            this.common.add(id.S, 4);
            this.uncommon.add(id.L, 4);
            this.uncommon.add(vz.x, 6);
            this.uncommon.add(id.aE, 4);
            this.uncommon.add(id.J, 4);
            this.uncommon.add(id.aJ, 3);
            this.uncommon.add(id.T, 1);
            this.rare.add(id.n, 3);
            this.rare.add(id.aB, 6);
            this.rare.add(id.aS, 4);
            this.ultrarare.add(id.aK, 1);
            this.ultrarare.add(id.n, 10);
            this.ultrarare.add(id.bb, 1);
        }
        if (i == 7) {
            this.common.add(id.bs, 6);
            this.common.add(new kp((id)id.br, 1, 0));
            this.common.add(id.aX, 5);
            this.common.add(id.bt, 3);
            this.common.add(id.bo, 1);
            this.common.add(id.bw, 2);
            this.common.add(id.bu, 1);
            this.common.add(id.bA, 2);
            this.common.add(id.bv, 3);
            this.common.add(id.aJ, 6);
            final kp goldSword = new kp(id.F);
            goldSword.a(on.n, 2);
            this.uncommon.add(goldSword);
            final kp goldBoots = new kp(id.an);
            goldBoots.a(on.e, 3);
            this.uncommon.add(goldBoots);
            this.uncommon.add(new kp((id)id.br, 1, 8194));
            this.uncommon.add(new kp((id)id.br, 1, 8197));
            this.uncommon.add(new kp((id)id.br, 1, 8195));
            this.uncommon.add(new kp((id)id.br, 1, 8204));
            final kp goldHelm = new kp(id.ak);
            goldHelm.a(on.i, 3);
            this.rare.add(goldHelm);
            this.rare.add(new kp((id)id.br, 1, 8226));
            this.rare.add(new kp((id)id.br, 1, 8225));
            this.rare.add(new kp((id)id.br, 1, 16389));
            this.rare.add(new kp((id)id.br, 1, 16428));
            final kp goldAxe = new kp(id.I);
            goldAxe.a(on.s, 2);
            this.ultrarare.add(goldAxe);
            this.ultrarare.add(id.bm, 1);
            this.ultrarare.add(vz.ap, 4);
            this.ultrarare.add(id.m, 1);
            this.ultrarare.add(id.aF, 1);
        }
        if (i == 8) {
            this.common.add(id.bs, 6);
            this.common.add(new kp((id)id.br, 1, 0));
            this.common.add(id.aJ, 6);
            this.common.add(id.aW, 6);
            this.common.add(id.bp, 6);
            this.common.add(id.aH, 12);
            final kp steelLegs = new kp(id.ae);
            steelLegs.a(on.g, 2);
            this.uncommon.add(steelLegs);
            this.uncommon.add(id.bD, 3);
            this.uncommon.add(id.aK, 5);
            this.uncommon.add((id)id.bc, 1);
            this.uncommon.add(new kp((id)id.br, 1, 16));
            this.uncommon.add(new kp((id)id.br, 1, 8196));
            this.uncommon.add(new kp((id)id.br, 1, 8200));
            final kp bow = new kp(id.j);
            bow.a(on.v, 1);
            this.rare.add(bow);
            final kp stoneSword = new kp(id.u);
            stoneSword.a(on.m, 2);
            stoneSword.a(on.k, 3);
            this.rare.add(stoneSword);
            final kp woodSword = new kp(id.q);
            woodSword.a(on.n, 2);
            woodSword.a(on.l, 4);
            woodSword.a(on.m, 1);
            this.rare.add(woodSword);
            this.rare.add(new kp((id)id.br, 1, 16392));
            this.rare.add(new kp((id)id.br, 1, 8225));
            this.rare.add(new kp((id)id.br, 1, 8229));
            this.rare.add(new kp((id)id.br, 1, 8258));
            final kp goldPick = new kp(id.H);
            goldPick.a(on.s, 2);
            this.ultrarare.add(goldPick);
            final kp steelSword = new kp(id.p);
            steelSword.a(on.o, 2);
            final kp bow2 = new kp(id.j);
            bow2.a(on.w, 1);
            this.ultrarare.add(bow2);
            this.ultrarare.add(steelSword);
            this.ultrarare.add(vz.an, 5);
            this.ultrarare.add(id.bm, 2);
            this.ultrarare.add(id.aY, 1);
        }
        if (i == 9) {
            this.common.add(new kp((id)id.br, 1, 0));
            this.common.add(id.bl, 6);
            this.common.add(id.S, 6);
            this.common.add(id.be, 6);
            this.common.add(id.aw, 1);
            this.common.add(vz.aq, 12);
            this.common.add(id.E, 1);
            this.common.add(id.aF, 1);
            this.common.add(id.bg, 5);
            this.uncommon.add(id.T, 8);
            this.uncommon.add(id.bi, 6);
            this.uncommon.add(id.aq, 8);
            this.uncommon.add(id.bk, 10);
            this.uncommon.add(id.aU, 8);
            this.rare.add(id.bA, 12);
            this.rare.add(id.i, 12);
            this.rare.add((id)id.bc, 1);
            this.ultrarare.add(id.as, 2);
            this.ultrarare.add(id.aY, 1);
            this.ultrarare.add(id.aD, 1);
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
