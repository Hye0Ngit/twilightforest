import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;
import net.minecraft.server.MinecraftServer;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ft extends hk implements eq
{
    public lf a;
    public MinecraftServer b;
    public ug c;
    public double d;
    public double e;
    public List f;
    public Set g;
    private int cf;
    private int cg;
    private boolean ch;
    private int ci;
    private int cj;
    private jm[] ck;
    private int cl;
    public boolean h;
    public int i;
    public boolean j;
    
    public ft(final MinecraftServer minecraftserver, final fq world, final String s, final ug iteminworldmanager) {
        super(world);
        this.ck = new jm[] { null, null, null, null, null };
        this.f = new LinkedList();
        this.g = new HashSet();
        this.cf = -99999999;
        this.cg = -99999999;
        this.ch = true;
        this.ci = -99999999;
        this.cj = 60;
        this.cl = 0;
        this.j = false;
        iteminworldmanager.b = this;
        this.c = iteminworldmanager;
        final bz chunkcoordinates = world.o();
        int i = chunkcoordinates.a;
        int j = chunkcoordinates.c;
        int k = chunkcoordinates.b;
        if (!world.y.f) {
            i += this.bS.nextInt(20) - 10;
            k = world.f(i, j);
            j += this.bS.nextInt(20) - 10;
        }
        this.c(i + 0.5, (double)k, j + 0.5, 0.0f, 0.0f);
        this.b = minecraftserver;
        this.bP = 0.0f;
        this.v = s;
        this.bF = 0.0f;
    }
    
    public void a(final nu nbttagcompound) {
        super.a(nbttagcompound);
        if (nbttagcompound.c("playerGameType")) {
            this.c.a(nbttagcompound.f("playerGameType"));
        }
    }
    
    public void b(final nu nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("playerGameType", this.c.a());
    }
    
    public void a(final fq world) {
        super.a(world);
    }
    
    public void b(final int i) {
        super.b(i);
        this.ci = -1;
    }
    
    public void v() {
        this.m.a((eq)this);
    }
    
    public jm[] q_() {
        return this.ck;
    }
    
    protected void r_() {
        this.bF = 0.0f;
    }
    
    public float y() {
        return 1.62f;
    }
    
    public void y_() {
        this.c.c();
        --this.cj;
        this.m.a();
        for (int i = 0; i < 5; ++i) {
            final jm itemstack = this.c(i);
            if (itemstack != this.ck[i]) {
                this.b.b(this.w).a((se)this, (kq)new s(this.bd, i, itemstack));
                this.ck[i] = itemstack;
            }
        }
    }
    
    public jm c(final int i) {
        if (i == 0) {
            return this.k.d();
        }
        return this.k.b[i - 1];
    }
    
    public void a(final qc damagesource) {
        this.b.h.a((kq)new pe(damagesource.a((hk)this)));
        this.k.k();
    }
    
    public boolean a(final qc damagesource, final int i) {
        if (this.cj > 0) {
            return false;
        }
        if (!this.b.q && damagesource instanceof ht) {
            final se entity = damagesource.a();
            if (entity instanceof hk) {
                return false;
            }
            if (entity instanceof sb) {
                final sb entityarrow = (sb)entity;
                if (entityarrow.c instanceof hk) {
                    return false;
                }
            }
        }
        return super.a(damagesource, i);
    }
    
    protected boolean z() {
        return this.b.q;
    }
    
    public void d(final int i) {
        super.d(i);
    }
    
    public void a(final boolean flag) {
        super.y_();
        for (int i = 0; i < this.k.c(); ++i) {
            final jm itemstack = this.k.c_(i);
            if (itemstack != null && hg.d[itemstack.c].n_()) {
                if (this.a.b() <= 2) {
                    final kq packet = ((cw)hg.d[itemstack.c]).c(itemstack, this.bi, (hk)this);
                    if (packet != null) {
                        this.a.b(packet);
                    }
                }
            }
        }
        if (flag && !this.f.isEmpty()) {
            final zg chunkcoordintpair = this.f.get(0);
            if (chunkcoordintpair != null) {
                boolean flag2 = false;
                if (this.a.b() < 4) {
                    flag2 = true;
                }
                if (flag2) {
                    final fy worldserver = this.b.a(this.w);
                    this.f.remove(chunkcoordintpair);
                    this.a.b((kq)new et(chunkcoordintpair.a * 16, 0, chunkcoordintpair.b * 16, 16, worldserver.c, 16, (fq)worldserver));
                    final List list = worldserver.d(chunkcoordintpair.a * 16, 0, chunkcoordintpair.b * 16, chunkcoordintpair.a * 16 + 16, worldserver.c, chunkcoordintpair.b * 16 + 16);
                    for (int j = 0; j < list.size(); ++j) {
                        this.a(list.get(j));
                    }
                }
            }
        }
        if (this.J) {
            if (this.b.d.a("allow-nether", true)) {
                if (this.m != this.l) {
                    this.C();
                }
                if (this.bh != null) {
                    this.b(this.bh);
                }
                else {
                    this.K += 0.0125f;
                    if (this.K >= 1.0f) {
                        this.K = 1.0f;
                        this.I = 10;
                        byte byte0 = 0;
                        if (this.w == -1 || this.w == 7) {
                            byte0 = 0;
                        }
                        else {
                            byte0 = -1;
                        }
                        this.b.h.a(this, byte0);
                        this.ci = -1;
                        this.cf = -1;
                        this.cg = -1;
                        this.a((vp)fa.x);
                    }
                }
                this.J = false;
            }
        }
        else {
            if (this.K > 0.0f) {
                this.K -= 0.05f;
            }
            if (this.K < 0.0f) {
                this.K = 0.0f;
            }
        }
        if (this.I > 0) {
            --this.I;
        }
        if (this.ap() != this.cf || this.cg != this.n.a() || this.n.c() == 0.0f != this.ch) {
            this.a.b((kq)new fd(this.ap(), this.n.a(), this.n.c()));
            this.cf = this.ap();
            this.cg = this.n.a();
            this.ch = (this.n.c() == 0.0f);
        }
        if (this.N != this.ci) {
            this.ci = this.N;
            this.a.b((kq)new lk(this.O, this.N, this.M));
        }
    }
    
    public void e(final int i) {
        if (this.w == 1 && i == 1) {
            this.a((vp)fa.C);
            this.bi.e((se)this);
            this.j = true;
            this.a.b((kq)new cj(4, 0));
        }
        else {
            this.a((vp)fa.B);
            final bz chunkcoordinates = this.b.a(i).d();
            if (chunkcoordinates != null) {
                this.a.a(chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, 0.0f, 0.0f);
            }
            this.b.h.a(this, 1);
            this.ci = -1;
            this.cf = -1;
            this.cg = -1;
        }
    }
    
    private void a(final ow tileentity) {
        if (tileentity != null) {
            final kq packet = tileentity.k();
            if (packet != null) {
                this.a.b(packet);
            }
        }
    }
    
    public void a(final se entity, final int i) {
        if (!entity.bE) {
            final vb entitytracker = this.b.b(this.w);
            if (entity instanceof ia) {
                entitytracker.a(entity, (kq)new dq(entity.bd, this.bd));
            }
            if (entity instanceof sb) {
                entitytracker.a(entity, (kq)new dq(entity.bd, this.bd));
            }
            if (entity instanceof ct) {
                entitytracker.a(entity, (kq)new dq(entity.bd, this.bd));
            }
        }
        super.a(entity, i);
        this.m.a();
    }
    
    public void s_() {
        if (!this.t) {
            this.u = -1;
            this.t = true;
            final vb entitytracker = this.b.b(this.w);
            entitytracker.a((se)this, (kq)new no((se)this, 1));
        }
    }
    
    public void B() {
    }
    
    public dh a(final int i, final int j, final int k) {
        final dh enumstatus = super.a(i, j, k);
        if (enumstatus == dh.a) {
            final vb entitytracker = this.b.b(this.w);
            final kk packet17sleep = new kk((se)this, 0, i, j, k);
            entitytracker.a((se)this, (kq)packet17sleep);
            this.a.a(this.bm, this.bn, this.bo, this.bs, this.bt);
            this.a.b((kq)packet17sleep);
        }
        return enumstatus;
    }
    
    public void a(final boolean flag, final boolean flag1, final boolean flag2) {
        if (this.V()) {
            final vb entitytracker = this.b.b(this.w);
            entitytracker.b((se)this, (kq)new no((se)this, 3));
        }
        super.a(flag, flag1, flag2);
        if (this.a != null) {
            this.a.a(this.bm, this.bn, this.bo, this.bs, this.bt);
        }
    }
    
    public void b(final se entity) {
        super.b(entity);
        this.a.b((kq)new nq((se)this, this.bh));
        this.a.a(this.bm, this.bn, this.bo, this.bs, this.bt);
    }
    
    protected void a(final double d, final boolean flag) {
    }
    
    public void b(final double d, final boolean flag) {
        super.a(d, flag);
    }
    
    private void aS() {
        this.cl = this.cl % 100 + 1;
    }
    
    public void b(final int i, final int j, final int k) {
        this.aS();
        this.a.b((kq)new jk(this.cl, 1, "Crafting", 9));
        this.m = (eh)new jh(this.k, this.bi, i, j, k);
        this.m.f = this.cl;
        this.m.a((eq)this);
    }
    
    public void c(final int i, final int j, final int k) {
        this.aS();
        this.a.b((kq)new jk(this.cl, 4, "Enchanting", 9));
        this.m = (eh)new jb(this.k, this.bi, i, j, k);
        this.m.f = this.cl;
        this.m.a((eq)this);
    }
    
    public void a(final mb iinventory) {
        this.aS();
        this.a.b((kq)new jk(this.cl, 0, iinventory.e(), iinventory.c()));
        this.m = (eh)new ck((mb)this.k, iinventory);
        this.m.f = this.cl;
        this.m.a((eq)this);
    }
    
    public void a(final sa tileentityfurnace) {
        this.aS();
        this.a.b((kq)new jk(this.cl, 2, tileentityfurnace.e(), tileentityfurnace.c()));
        this.m = (eh)new bt(this.k, tileentityfurnace);
        this.m.f = this.cl;
        this.m.a((eq)this);
    }
    
    public void a(final bi tileentitydispenser) {
        this.aS();
        this.a.b((kq)new jk(this.cl, 3, tileentitydispenser.e(), tileentitydispenser.c()));
        this.m = (eh)new ry((mb)this.k, tileentitydispenser);
        this.m.f = this.cl;
        this.m.a((eq)this);
    }
    
    public void a(final yv tileentitybrewingstand) {
        this.aS();
        this.a.b((kq)new jk(this.cl, 5, tileentitybrewingstand.e(), tileentitybrewingstand.c()));
        this.m = (eh)new jp(this.k, tileentitybrewingstand);
        this.m.f = this.cl;
        this.m.a((eq)this);
    }
    
    public void a(final eh container, final int i, final jm itemstack) {
        if (container.b(i) instanceof ze) {
            return;
        }
        if (this.h) {
            return;
        }
        this.a.b((kq)new ii(container.f, i, itemstack));
    }
    
    public void a(final eh container) {
        this.a(container, container.b());
    }
    
    public void a(final eh container, final List list) {
        this.a.b((kq)new kl(container.f, list));
        this.a.b((kq)new ii(-1, -1, this.k.l()));
    }
    
    public void a(final eh container, final int i, final int j) {
        this.a.b((kq)new mx(container.f, i, j));
    }
    
    public void a(final jm itemstack) {
    }
    
    public void C() {
        this.a.b((kq)new mm(this.m.f));
        this.E();
    }
    
    public void D() {
        if (this.h) {
            return;
        }
        this.a.b((kq)new ii(-1, -1, this.k.l()));
    }
    
    public void E() {
        this.m.a((hk)this);
        this.m = this.l;
    }
    
    public void a(final vp statbase, int i) {
        if (statbase == null) {
            return;
        }
        if (!statbase.f) {
            while (i > 100) {
                this.a.b((kq)new of(statbase.e, 100));
                i -= 100;
            }
            this.a.b((kq)new of(statbase.e, i));
        }
    }
    
    public void F() {
        if (this.bh != null) {
            this.b(this.bh);
        }
        if (this.bg != null) {
            this.bg.b((se)this);
        }
        if (this.E) {
            this.a(true, false, false);
        }
    }
    
    public void t_() {
        this.cf = -99999999;
    }
    
    public void a(final String s) {
        final nf stringtranslate = nf.a();
        final String s2 = stringtranslate.b(s);
        this.a.b((kq)new pe(s2));
    }
    
    protected void H() {
        this.a.b((kq)new jr(this.bd, (byte)9));
        super.H();
    }
    
    public void a(final jm itemstack, final int i) {
        super.a(itemstack, i);
        if (itemstack != null && itemstack.a() != null && itemstack.a().d(itemstack) == jq.b) {
            final vb entitytracker = this.b.b(this.w);
            entitytracker.b((se)this, (kq)new no((se)this, 5));
        }
    }
    
    protected void b(final xu potioneffect) {
        super.b(potioneffect);
        this.a.b((kq)new ee(this.bd, potioneffect));
    }
    
    protected void c(final xu potioneffect) {
        super.c(potioneffect);
        this.a.b((kq)new ee(this.bd, potioneffect));
    }
    
    protected void d(final xu potioneffect) {
        super.d(potioneffect);
        this.a.b((kq)new nl(this.bd, potioneffect));
    }
    
    public void a_(final double d, final double d1, final double d2) {
        this.a.a(d, d1, d2, this.bs, this.bt);
    }
    
    public void c(final se entity) {
        final vb entitytracker = this.b.b(this.w);
        entitytracker.b((se)this, (kq)new no(entity, 6));
    }
    
    public void d(final se entity) {
        final vb entitytracker = this.b.b(this.w);
        entitytracker.b((se)this, (kq)new no(entity, 7));
    }
}
