import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.MinecraftServer;
import java.util.logging.Logger;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class lf extends sv implements st
{
    public static Logger a;
    public pd b;
    public boolean c;
    private MinecraftServer d;
    private ft e;
    private int f;
    private int g;
    private boolean h;
    private int i;
    private long j;
    private static Random k;
    private long l;
    private int m;
    private double n;
    private double o;
    private double p;
    private boolean q;
    private kh r;
    
    public lf(final MinecraftServer minecraftserver, final pd networkmanager, final ft entityplayermp) {
        this.c = false;
        this.m = 0;
        this.q = true;
        this.r = new kh();
        this.d = minecraftserver;
        (this.b = networkmanager).a((sv)this);
        this.e = entityplayermp;
        entityplayermp.a = this;
    }
    
    public void a() {
        this.h = false;
        ++this.f;
        this.b.b();
        if (this.f - this.l > 20L) {
            this.l = this.f;
            this.j = System.nanoTime() / 1000000L;
            this.i = lf.k.nextInt();
            this.b((kq)new mg(this.i));
        }
        if (this.m > 0) {
            --this.m;
        }
    }
    
    public void a(final String s) {
        if (this.c) {
            return;
        }
        this.e.F();
        this.b((kq)new yx(s));
        this.b.d();
        this.d.h.a((kq)new pe("」e" + this.e.v + " left the game."));
        this.d.h.e(this.e);
        this.c = true;
    }
    
    public void a(final iu packet10flying) {
        final fy worldserver = this.d.a(this.e.w);
        this.h = true;
        if (this.e.j) {
            return;
        }
        if (!this.q) {
            final double d = packet10flying.b - this.o;
            if (packet10flying.a == this.n && d * d < 0.01 && packet10flying.c == this.p) {
                this.q = true;
            }
        }
        if (this.q) {
            if (this.e.bh != null) {
                float f = this.e.bs;
                float f2 = this.e.bt;
                this.e.bh.i();
                final double d2 = this.e.bm;
                final double d3 = this.e.bn;
                final double d4 = this.e.bo;
                double d5 = 0.0;
                double d6 = 0.0;
                if (packet10flying.i) {
                    f = packet10flying.e;
                    f2 = packet10flying.f;
                }
                if (packet10flying.h && packet10flying.b == -999.0 && packet10flying.d == -999.0) {
                    d5 = packet10flying.a;
                    d6 = packet10flying.c;
                }
                this.e.bx = packet10flying.g;
                this.e.a(true);
                this.e.a(d5, 0.0, d6);
                this.e.b(d2, d3, d4, f, f2);
                this.e.bp = d5;
                this.e.br = d6;
                if (this.e.bh != null) {
                    worldserver.b(this.e.bh, true);
                }
                if (this.e.bh != null) {
                    this.e.bh.i();
                }
                this.d.h.d(this.e);
                this.n = this.e.bm;
                this.o = this.e.bn;
                this.p = this.e.bo;
                worldserver.g((se)this.e);
                return;
            }
            if (this.e.V()) {
                this.e.a(true);
                this.e.b(this.n, this.o, this.p, this.e.bs, this.e.bt);
                worldserver.g((se)this.e);
                return;
            }
            final double d7 = this.e.bn;
            this.n = this.e.bm;
            this.o = this.e.bn;
            this.p = this.e.bo;
            double d8 = this.e.bm;
            double d9 = this.e.bn;
            double d10 = this.e.bo;
            float f3 = this.e.bs;
            float f4 = this.e.bt;
            if (packet10flying.h && packet10flying.b == -999.0 && packet10flying.d == -999.0) {
                packet10flying.h = false;
            }
            if (packet10flying.h) {
                d8 = packet10flying.a;
                d9 = packet10flying.b;
                d10 = packet10flying.c;
                final double d11 = packet10flying.d - packet10flying.b;
                if (!this.e.V() && (d11 > 1.65 || d11 < 0.1)) {
                    this.a("Illegal stance");
                    lf.a.warning(this.e.v + " had an illegal stance: " + d11);
                    return;
                }
                if (Math.abs(packet10flying.a) > 3.2E7 || Math.abs(packet10flying.c) > 3.2E7) {
                    this.a("Illegal position");
                    return;
                }
            }
            if (packet10flying.i) {
                f3 = packet10flying.e;
                f4 = packet10flying.f;
            }
            this.e.a(true);
            this.e.bO = 0.0f;
            this.e.b(this.n, this.o, this.p, f3, f4);
            if (!this.q) {
                return;
            }
            double d12 = d8 - this.e.bm;
            double d13 = d9 - this.e.bn;
            double d14 = d10 - this.e.bo;
            double d15 = d12 * d12 + d13 * d13 + d14 * d14;
            if (d15 > 100.0) {
                lf.a.warning(this.e.v + " moved too quickly!");
                this.a("You moved too quickly :( (Hacking?)");
                return;
            }
            final float f5 = 0.0625f;
            final boolean flag = worldserver.a((se)this.e, this.e.bw.b().e((double)f5, (double)f5, (double)f5)).size() == 0;
            if (this.e.bx && !packet10flying.g && d13 > 0.0) {
                this.e.c(0.2f);
            }
            this.e.a(d12, d13, d14);
            this.e.bx = packet10flying.g;
            this.e.b(d12, d13, d14);
            final double d16 = d13;
            d12 = d8 - this.e.bm;
            d13 = d9 - this.e.bn;
            if (d13 > -0.5 || d13 < 0.5) {
                d13 = 0.0;
            }
            d14 = d10 - this.e.bo;
            d15 = d12 * d12 + d13 * d13 + d14 * d14;
            boolean flag2 = false;
            if (d15 > 0.0625 && !this.e.V() && !this.e.c.b()) {
                flag2 = true;
                lf.a.warning(this.e.v + " moved wrongly!");
                System.out.println("Got position " + d8 + ", " + d9 + ", " + d10);
                System.out.println("Expected " + this.e.bm + ", " + this.e.bn + ", " + this.e.bo);
            }
            this.e.b(d8, d9, d10, f3, f4);
            final boolean flag3 = worldserver.a((se)this.e, this.e.bw.b().e((double)f5, (double)f5, (double)f5)).size() == 0;
            if (flag && (flag2 || !flag3) && !this.e.V()) {
                this.a(this.n, this.o, this.p, f3, f4);
                return;
            }
            final fb axisalignedbb = this.e.bw.b().b((double)f5, (double)f5, (double)f5).a(0.0, -0.55, 0.0);
            if (!this.d.r && !this.e.c.b() && !worldserver.b(axisalignedbb)) {
                if (d16 >= -0.03125) {
                    ++this.g;
                    if (this.g > 80) {
                        lf.a.warning(this.e.v + " was kicked for floating too long!");
                        this.a("Flying is not enabled on this server");
                        return;
                    }
                }
            }
            else {
                this.g = 0;
            }
            this.e.bx = packet10flying.g;
            this.d.h.d(this.e);
            this.e.b(this.e.bn - d7, packet10flying.g);
        }
    }
    
    public void a(final double d, final double d1, final double d2, final float f, final float f1) {
        this.q = false;
        this.n = d;
        this.o = d1;
        this.p = d2;
        this.e.b(d, d1, d2, f, f1);
        this.e.a.b((kq)new ff(d, d1 + 1.6200000047683716, d1, d2, f, f1, false));
    }
    
    public void a(final kf packet14blockdig) {
        final fy worldserver = this.d.a(this.e.w);
        if (packet14blockdig.e == 4) {
            this.e.O();
            return;
        }
        if (packet14blockdig.e == 5) {
            this.e.J();
            return;
        }
        final fy fy = worldserver;
        final boolean m = worldserver.y.h != 0 || this.d.h.h(this.e.v);
        fy.K = m;
        final boolean flag = m;
        boolean flag2 = false;
        if (packet14blockdig.e == 0) {
            flag2 = true;
        }
        if (packet14blockdig.e == 2) {
            flag2 = true;
        }
        final int i = packet14blockdig.a;
        final int j = packet14blockdig.b;
        final int k = packet14blockdig.c;
        if (flag2) {
            final double d = this.e.bm - (i + 0.5);
            final double d2 = this.e.bn - (j + 0.5) + 1.5;
            final double d3 = this.e.bo - (k + 0.5);
            final double d4 = d * d + d2 * d2 + d3 * d3;
            if (d4 > 36.0) {
                return;
            }
        }
        final bz chunkcoordinates = worldserver.o();
        final int l = iy.a(i - chunkcoordinates.a);
        int i2 = iy.a(k - chunkcoordinates.c);
        if (l > i2) {
            i2 = l;
        }
        if (packet14blockdig.e == 0) {
            if (i2 > 16 || flag) {
                this.e.c.a(i, j, k, packet14blockdig.d);
            }
            else {
                this.e.a.b((kq)new tk(i, j, k, (fq)worldserver));
            }
        }
        else if (packet14blockdig.e == 2) {
            this.e.c.a(i, j, k);
            if (worldserver.a(i, j, k) != 0) {
                this.e.a.b((kq)new tk(i, j, k, (fq)worldserver));
            }
        }
        else if (packet14blockdig.e == 3) {
            final double d5 = this.e.bm - (i + 0.5);
            final double d6 = this.e.bn - (j + 0.5);
            final double d7 = this.e.bo - (k + 0.5);
            final double d8 = d5 * d5 + d6 * d6 + d7 * d7;
            if (d8 < 256.0) {
                this.e.a.b((kq)new tk(i, j, k, (fq)worldserver));
            }
        }
        worldserver.K = false;
    }
    
    public void a(final hl packet15place) {
        final fy worldserver = this.d.a(this.e.w);
        jm itemstack = this.e.k.d();
        final fy fy = worldserver;
        final boolean m = worldserver.y.h != 0 || this.d.h.h(this.e.v);
        fy.K = m;
        final boolean flag = m;
        if (packet15place.d == 255) {
            if (itemstack == null) {
                return;
            }
            this.e.c.a((hk)this.e, (fq)worldserver, itemstack);
        }
        else {
            int i = packet15place.a;
            int j = packet15place.b;
            int k = packet15place.c;
            final int l = packet15place.d;
            final bz chunkcoordinates = worldserver.o();
            final int i2 = iy.a(i - chunkcoordinates.a);
            int j2 = iy.a(k - chunkcoordinates.c);
            if (i2 > j2) {
                j2 = i2;
            }
            if (this.q && this.e.e(i + 0.5, j + 0.5, k + 0.5) < 64.0 && (j2 > 16 || flag)) {
                this.e.c.a((hk)this.e, (fq)worldserver, itemstack, i, j, k, l);
            }
            this.e.a.b((kq)new tk(i, j, k, (fq)worldserver));
            if (l == 0) {
                --j;
            }
            if (l == 1) {
                ++j;
            }
            if (l == 2) {
                --k;
            }
            if (l == 3) {
                ++k;
            }
            if (l == 4) {
                --i;
            }
            if (l == 5) {
                ++i;
            }
            this.e.a.b((kq)new tk(i, j, k, (fq)worldserver));
        }
        itemstack = this.e.k.d();
        if (itemstack != null && itemstack.a == 0) {
            this.e.k.a[this.e.k.c] = null;
            itemstack = null;
        }
        if (itemstack == null || itemstack.l() == 0) {
            this.e.h = true;
            this.e.k.a[this.e.k.c] = jm.b(this.e.k.a[this.e.k.c]);
            final hj slot = this.e.m.a((mb)this.e.k, this.e.k.c);
            this.e.m.a();
            this.e.h = false;
            if (!jm.b(this.e.k.d(), packet15place.e)) {
                this.b((kq)new ii(this.e.m.f, slot.c, this.e.k.d()));
            }
        }
        worldserver.K = false;
    }
    
    public void a(final String s, final Object[] aobj) {
        lf.a.info(this.e.v + " lost connection: " + s);
        this.d.h.a((kq)new pe("」e" + this.e.v + " left the game."));
        this.d.h.e(this.e);
        this.c = true;
    }
    
    public void a(final kq packet) {
        lf.a.warning(this.getClass() + " wasn't prepared to deal with a " + packet.getClass());
        this.a("Protocol error, unexpected packet");
    }
    
    public void b(final kq packet) {
        this.b.a(packet);
    }
    
    public void a(final ih packet16blockitemswitch) {
        if (packet16blockitemswitch.a < 0 || packet16blockitemswitch.a >= jl.h()) {
            lf.a.warning(this.e.v + " tried to set an invalid carried item");
            return;
        }
        this.e.k.c = packet16blockitemswitch.a;
    }
    
    public void a(final pe packet3chat) {
        String s = packet3chat.a;
        if (s.length() > 100) {
            this.a("Chat message too long");
            return;
        }
        s = s.trim();
        for (int i = 0; i < s.length(); ++i) {
            if (gg.a.indexOf(s.charAt(i)) < 0 && s.charAt(i) < ' ') {
                this.a("Illegal characters in chat");
                return;
            }
        }
        if (s.startsWith("/")) {
            this.c(s);
        }
        else {
            s = "<" + this.e.v + "> " + s;
            lf.a.info(s);
            this.d.h.a((kq)new pe(s));
        }
        this.m += 20;
        if (this.m > 200) {
            this.a("disconnect.spam");
        }
    }
    
    private void c(String s) {
        if (s.toLowerCase().startsWith("/me ")) {
            s = "* " + this.e.v + " " + s.substring(s.indexOf(" ")).trim();
            lf.a.info(s);
            this.d.h.a((kq)new pe(s));
        }
        else if (s.toLowerCase().startsWith("/kill")) {
            this.e.a(qc.k, 1000);
        }
        else if (s.toLowerCase().startsWith("/tell ")) {
            final String[] as = s.split(" ");
            if (as.length >= 3) {
                s = s.substring(s.indexOf(" ")).trim();
                s = s.substring(s.indexOf(" ")).trim();
                s = "」7" + this.e.v + " whispers " + s;
                lf.a.info(s + " to " + as[1]);
                if (!this.d.h.a(as[1], (kq)new pe(s))) {
                    this.b((kq)new pe("」cThere's no player by that name online."));
                }
            }
        }
        else if (ModLoaderMp.HandleCommand(s.substring(1), this.e.v, lf.a, this.d.h.h(this.e.v))) {
            lf.a.info("ModLoaderMP : " + this.e.v + " issued command: " + s.substring(1));
        }
        else if (this.d.h.h(this.e.v)) {
            final String s2 = s.substring(1);
            lf.a.info(this.e.v + " issued server command: " + s2);
            this.d.a(s2, (st)this);
        }
        else {
            final String s3 = s.substring(1);
            lf.a.info(this.e.v + " tried command: " + s3);
        }
    }
    
    public void a(final no packet18animation) {
        if (packet18animation.b == 1) {
            this.e.s_();
        }
    }
    
    public void a(final ti packet19entityaction) {
        if (packet19entityaction.b == 1) {
            this.e.f(true);
        }
        else if (packet19entityaction.b == 2) {
            this.e.f(false);
        }
        else if (packet19entityaction.b == 4) {
            this.e.g(true);
        }
        else if (packet19entityaction.b == 5) {
            this.e.g(false);
        }
        else if (packet19entityaction.b == 3) {
            this.e.a(false, true, true);
            this.q = false;
        }
    }
    
    public void a(final yx packet255kickdisconnect) {
        this.b.a("disconnect.quitting", new Object[0]);
    }
    
    public int b() {
        return this.b.e();
    }
    
    public void b(final String s) {
        this.b((kq)new pe("」7" + s));
    }
    
    public String d() {
        return this.e.v;
    }
    
    public void a(final a packet7useentity) {
        final fy worldserver = this.d.a(this.e.w);
        final se entity = worldserver.a(packet7useentity.b);
        if (entity != null && this.e.g(entity) && this.e.i(entity) < 36.0) {
            if (packet7useentity.c == 0) {
                this.e.e(entity);
            }
            else if (packet7useentity.c == 1) {
                this.e.f(entity);
            }
        }
    }
    
    public void a(final ox packet9respawn) {
        int respawnDimension = packet9respawn.b;
        if (respawnDimension == -1 || respawnDimension == 1) {
            respawnDimension = 0;
        }
        if (this.e.j) {
            this.e = this.d.h.a(this.e, respawnDimension, true);
        }
        else {
            if (this.e.ap() > 0) {
                return;
            }
            this.e = this.d.h.a(this.e, respawnDimension, false);
        }
    }
    
    public void a(final mm packet101closewindow) {
        this.e.E();
    }
    
    public void a(final qk packet102windowclick) {
        if (this.e.m.f == packet102windowclick.a && this.e.m.c((hk)this.e)) {
            final jm itemstack = this.e.m.a(packet102windowclick.b, packet102windowclick.c, packet102windowclick.f, (hk)this.e);
            if (jm.b(packet102windowclick.e, itemstack)) {
                this.e.a.b((kq)new oi(packet102windowclick.a, packet102windowclick.d, true));
                this.e.h = true;
                this.e.m.a();
                this.e.D();
                this.e.h = false;
            }
            else {
                this.r.a(this.e.m.f, (Object)packet102windowclick.d);
                this.e.a.b((kq)new oi(packet102windowclick.a, packet102windowclick.d, false));
                this.e.m.a((hk)this.e, false);
                final ArrayList arraylist = new ArrayList();
                for (int i = 0; i < this.e.m.e.size(); ++i) {
                    arraylist.add(this.e.m.e.get(i).b());
                }
                this.e.a(this.e.m, arraylist);
            }
        }
    }
    
    public void a(final pf packet108enchantitem) {
        if (this.e.m.f == packet108enchantitem.a && this.e.m.c((hk)this.e)) {
            this.e.m.a((hk)this.e, packet108enchantitem.b);
            this.e.m.a();
        }
    }
    
    public void a(final ef packet107creativesetslot) {
        if (this.e.c.b()) {
            final boolean flag = packet107creativesetslot.a < 0;
            final jm itemstack = packet107creativesetslot.b;
            final boolean flag2 = packet107creativesetslot.a >= 36 && packet107creativesetslot.a < 36 + jl.h();
            final boolean flag3 = itemstack == null || (itemstack.c < hg.d.length && itemstack.c >= 0 && hg.d[itemstack.c] != null);
            final boolean flag4 = itemstack == null || (itemstack.h() >= 0 && itemstack.h() >= 0 && itemstack.a <= 64 && itemstack.a > 0);
            if (flag2 && flag3 && flag4) {
                if (itemstack == null) {
                    this.e.l.a(packet107creativesetslot.a, (jm)null);
                }
                else {
                    this.e.l.a(packet107creativesetslot.a, itemstack);
                }
                this.e.l.a((hk)this.e, true);
            }
            else if (flag && flag3 && flag4) {
                this.e.b(itemstack);
            }
        }
    }
    
    public void a(final oi packet106transaction) {
        final Short short1 = (Short)this.r.a(this.e.m.f);
        if (short1 != null && packet106transaction.b == short1 && this.e.m.f == packet106transaction.a && !this.e.m.c((hk)this.e)) {
            this.e.m.a((hk)this.e, true);
        }
    }
    
    public void a(final tv packet130updatesign) {
        final fy worldserver = this.d.a(this.e.w);
        if (worldserver.g(packet130updatesign.a, packet130updatesign.b, packet130updatesign.c)) {
            final ow tileentity = worldserver.b(packet130updatesign.a, packet130updatesign.b, packet130updatesign.c);
            if (tileentity instanceof ys) {
                final ys tileentitysign = (ys)tileentity;
                if (!tileentitysign.c()) {
                    this.d.c("Player " + this.e.v + " just tried to change non-editable sign");
                    return;
                }
            }
            for (int i = 0; i < 4; ++i) {
                boolean flag = true;
                if (packet130updatesign.d[i].length() > 15) {
                    flag = false;
                }
                else {
                    for (int l = 0; l < packet130updatesign.d[i].length(); ++l) {
                        if (gg.a.indexOf(packet130updatesign.d[i].charAt(l)) < 0) {
                            flag = false;
                        }
                    }
                }
                if (!flag) {
                    packet130updatesign.d[i] = "!?";
                }
            }
            if (tileentity instanceof ys) {
                final int j = packet130updatesign.a;
                final int k = packet130updatesign.b;
                final int i2 = packet130updatesign.c;
                final ys tileentitysign2 = (ys)tileentity;
                for (int j2 = 0; j2 < 4; ++j2) {
                    tileentitysign2.a[j2] = packet130updatesign.d[j2];
                }
                tileentitysign2.z_();
                worldserver.h(j, k, i2);
            }
        }
    }
    
    public void a(final mg packet0keepalive) {
        if (packet0keepalive.a == this.i) {
            final int i = (int)(System.nanoTime() / 1000000L - this.j);
            this.e.i = (this.e.i * 3 + i) / 4;
        }
    }
    
    public boolean c() {
        return true;
    }
    
    static {
        lf.a = Logger.getLogger("Minecraft");
        lf.k = new Random();
    }
}
