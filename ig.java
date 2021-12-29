import java.util.Iterator;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.ArrayList;
import java.io.File;
import java.util.Set;
import net.minecraft.server.MinecraftServer;
import java.util.List;
import java.util.logging.Logger;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ig
{
    public static Logger a;
    public List b;
    private MinecraftServer c;
    private xf[] d;
    private int e;
    private Set f;
    private Set g;
    private Set h;
    private Set i;
    private File j;
    private File k;
    private File l;
    private File m;
    private it n;
    private boolean o;
    private int p;
    
    public ig(final MinecraftServer minecraftserver) {
        this.b = new ArrayList();
        this.f = new HashSet();
        this.g = new HashSet();
        this.h = new HashSet();
        this.i = new HashSet();
        this.p = 0;
        this.d = new xf[4];
        this.c = minecraftserver;
        this.j = minecraftserver.a("banned-players.txt");
        this.k = minecraftserver.a("banned-ips.txt");
        this.l = minecraftserver.a("ops.txt");
        this.m = minecraftserver.a("white-list.txt");
        final int i = minecraftserver.d.a("view-distance", 10);
        this.d[0] = new xf(minecraftserver, 0, i);
        this.d[1] = new xf(minecraftserver, -1, i);
        this.d[2] = new xf(minecraftserver, 1, i);
        this.d[3] = new xf(minecraftserver, 7, i);
        this.e = minecraftserver.d.a("max-players", 20);
        this.o = minecraftserver.d.a("white-list", false);
        this.l();
        this.n();
        this.p();
        this.r();
        this.m();
        this.o();
        this.q();
        this.s();
    }
    
    public void a(final fy[] aworldserver) {
        this.n = aworldserver[0].q().d();
    }
    
    public void a(final ft entityplayermp) {
        this.d[0].b(entityplayermp);
        this.d[1].b(entityplayermp);
        this.d[2].b(entityplayermp);
        this.d[3].b(entityplayermp);
        this.a(entityplayermp.w).a(entityplayermp);
        final fy worldserver = this.c.a(entityplayermp.w);
        worldserver.J.c((int)entityplayermp.bm >> 4, (int)entityplayermp.bo >> 4);
    }
    
    public int a() {
        return this.d[0].c();
    }
    
    private xf a(final int i) {
        if (i == -1) {
            return this.d[1];
        }
        if (i == 0) {
            return this.d[0];
        }
        if (i == 1) {
            return this.d[2];
        }
        if (i == 7) {
            return this.d[3];
        }
        return null;
    }
    
    public void b(final ft entityplayermp) {
        this.n.b((hk)entityplayermp);
    }
    
    public void c(final ft entityplayermp) {
        this.a((kq)new em(entityplayermp.v, true, 1000));
        this.b.add(entityplayermp);
        final fy worldserver = this.c.a(entityplayermp.w);
        worldserver.J.c((int)entityplayermp.bm >> 4, (int)entityplayermp.bo >> 4);
        while (worldserver.a((se)entityplayermp, entityplayermp.bw).size() != 0) {
            entityplayermp.c(entityplayermp.bm, entityplayermp.bn + 1.0, entityplayermp.bo);
        }
        worldserver.b((se)entityplayermp);
        this.a(entityplayermp.w).a(entityplayermp);
        for (int i = 0; i < this.b.size(); ++i) {
            final ft entityplayermp2 = this.b.get(i);
            entityplayermp.a.b((kq)new em(entityplayermp2.v, true, entityplayermp2.i));
        }
    }
    
    public void d(final ft entityplayermp) {
        this.a(entityplayermp.w).c(entityplayermp);
    }
    
    public void e(final ft entityplayermp) {
        this.n.a((hk)entityplayermp);
        this.c.a(entityplayermp.w).e((se)entityplayermp);
        this.b.remove(entityplayermp);
        this.a(entityplayermp.w).b(entityplayermp);
        this.a((kq)new em(entityplayermp.v, false, 9999));
    }
    
    public ft a(final gz netloginhandler, final String s) {
        if (this.f.contains(s.trim().toLowerCase())) {
            netloginhandler.a("You are banned from this server!");
            return null;
        }
        if (!this.g(s)) {
            netloginhandler.a("You are not white-listed on this server!");
            return null;
        }
        String s2 = netloginhandler.b.c().toString();
        s2 = s2.substring(s2.indexOf("/") + 1);
        s2 = s2.substring(0, s2.indexOf(":"));
        if (this.g.contains(s2)) {
            netloginhandler.a("Your IP address is banned from this server!");
            return null;
        }
        if (this.b.size() >= this.e) {
            netloginhandler.a("The server is full!");
            return null;
        }
        for (int i = 0; i < this.b.size(); ++i) {
            final ft entityplayermp = this.b.get(i);
            if (entityplayermp.v.equalsIgnoreCase(s)) {
                entityplayermp.a.a("You logged in from another location");
            }
        }
        return new ft(this.c, (fq)this.c.a(0), s, new ug((fq)this.c.a(0)));
    }
    
    public ft a(final ft entityplayermp, final int i, final boolean flag) {
        this.c.b(entityplayermp.w).a(entityplayermp);
        this.c.b(entityplayermp.w).b((se)entityplayermp);
        this.a(entityplayermp.w).b(entityplayermp);
        this.b.remove(entityplayermp);
        this.c.a(entityplayermp.w).f((se)entityplayermp);
        final bz chunkcoordinates = entityplayermp.X();
        entityplayermp.w = i;
        final ft entityplayermp2 = new ft(this.c, (fq)this.c.a(entityplayermp.w), entityplayermp.v, new ug((fq)this.c.a(entityplayermp.w)));
        if (flag) {
            entityplayermp2.c((hk)entityplayermp);
        }
        entityplayermp2.bd = entityplayermp.bd;
        entityplayermp2.a = entityplayermp.a;
        final fy worldserver = this.c.a(entityplayermp.w);
        entityplayermp2.w = entityplayermp.w;
        entityplayermp2.c.a(entityplayermp.c.a());
        entityplayermp2.c.b(worldserver.r().n());
        if (chunkcoordinates != null) {
            final bz chunkcoordinates2 = hk.a((fq)this.c.a(entityplayermp.w), chunkcoordinates);
            if (chunkcoordinates2 != null) {
                entityplayermp2.c((double)(chunkcoordinates2.a + 0.5f), (double)(chunkcoordinates2.b + 0.1f), (double)(chunkcoordinates2.c + 0.5f), 0.0f, 0.0f);
                entityplayermp2.a(chunkcoordinates);
            }
            else {
                entityplayermp2.a.b((kq)new cj(0, 0));
            }
        }
        worldserver.J.c((int)entityplayermp2.bm >> 4, (int)entityplayermp2.bo >> 4);
        while (worldserver.a((se)entityplayermp2, entityplayermp2.bw).size() != 0) {
            entityplayermp2.c(entityplayermp2.bm, entityplayermp2.bn + 1.0, entityplayermp2.bo);
        }
        entityplayermp2.a.b((kq)new ox((byte)entityplayermp2.w, (byte)entityplayermp2.bi.v, entityplayermp2.bi.m(), entityplayermp2.bi.r().q(), entityplayermp2.bi.c, entityplayermp2.c.a()));
        entityplayermp2.a.a(entityplayermp2.bm, entityplayermp2.bn, entityplayermp2.bo, entityplayermp2.bs, entityplayermp2.bt);
        this.a(entityplayermp2, worldserver);
        this.a(entityplayermp2.w).a(entityplayermp2);
        worldserver.b((se)entityplayermp2);
        this.b.add(entityplayermp2);
        entityplayermp2.v();
        entityplayermp2.B();
        return entityplayermp2;
    }
    
    public void a(final ft entityplayermp, final int i) {
        final int j = entityplayermp.w;
        final fy worldserver = this.c.a(entityplayermp.w);
        entityplayermp.w = i;
        final fy worldserver2 = this.c.a(entityplayermp.w);
        entityplayermp.a.b((kq)new ox((byte)entityplayermp.w, (byte)entityplayermp.bi.v, worldserver2.m(), worldserver2.r().q(), worldserver2.c, entityplayermp.c.a()));
        worldserver.f((se)entityplayermp);
        entityplayermp.bE = false;
        double d = entityplayermp.bm;
        double d2 = entityplayermp.bo;
        final double d3 = 8.0;
        if (i == 7) {
            entityplayermp.c(d, entityplayermp.bn / 2.0, d2, entityplayermp.bs, entityplayermp.bt);
            if (entityplayermp.aq()) {
                worldserver.a((se)entityplayermp, false);
            }
        }
        else if (j == 7) {
            entityplayermp.c(d, entityplayermp.bn * 2.0, d2, entityplayermp.bs, entityplayermp.bt);
            if (entityplayermp.aq()) {
                worldserver.a((se)entityplayermp, false);
            }
        }
        else if (entityplayermp.w == -1) {
            d /= d3;
            d2 /= d3;
            entityplayermp.c(d, entityplayermp.bn, d2, entityplayermp.bs, entityplayermp.bt);
            if (entityplayermp.aq()) {
                worldserver.a((se)entityplayermp, false);
            }
        }
        else if (entityplayermp.w == 0) {
            d *= d3;
            d2 *= d3;
            entityplayermp.c(d, entityplayermp.bn, d2, entityplayermp.bs, entityplayermp.bt);
            if (entityplayermp.aq()) {
                worldserver.a((se)entityplayermp, false);
            }
        }
        else {
            final bz chunkcoordinates = worldserver2.d();
            d = chunkcoordinates.a;
            entityplayermp.bn = chunkcoordinates.b;
            d2 = chunkcoordinates.c;
            entityplayermp.c(d, entityplayermp.bn, d2, 90.0f, 0.0f);
            if (entityplayermp.aq()) {
                worldserver.a((se)entityplayermp, false);
            }
        }
        if (j != 1 && entityplayermp.aq()) {
            worldserver2.b((se)entityplayermp);
            entityplayermp.c(d, entityplayermp.bn, d2, entityplayermp.bs, entityplayermp.bt);
            worldserver2.a((se)entityplayermp, false);
            worldserver2.J.a = true;
            if (i == 7 || j == 7) {
                new TFTeleporter().a((fq)worldserver2, (se)entityplayermp);
            }
            else {
                new ua().a((fq)worldserver2, (se)entityplayermp);
            }
            worldserver2.J.a = false;
        }
        this.a(entityplayermp);
        entityplayermp.a.a(entityplayermp.bm, entityplayermp.bn, entityplayermp.bo, entityplayermp.bs, entityplayermp.bt);
        entityplayermp.a((fq)worldserver2);
        entityplayermp.c.a(worldserver2);
        this.a(entityplayermp, worldserver2);
        this.f(entityplayermp);
    }
    
    public void b() {
        if (++this.p > 200) {
            this.p = 0;
        }
        if (this.p < this.b.size()) {
            final ft entityplayermp = this.b.get(this.p);
            this.a((kq)new em(entityplayermp.v, true, entityplayermp.i));
        }
        for (int i = 0; i < this.d.length; ++i) {
            this.d[i].b();
        }
    }
    
    public void a(final int i, final int j, final int k, final int l) {
        this.a(l).a(i, j, k);
    }
    
    public void a(final kq packet) {
        for (int i = 0; i < this.b.size(); ++i) {
            final ft entityplayermp = this.b.get(i);
            entityplayermp.a.b(packet);
        }
    }
    
    public void a(final kq packet, final int i) {
        for (int j = 0; j < this.b.size(); ++j) {
            final ft entityplayermp = this.b.get(j);
            if (entityplayermp.w == i) {
                entityplayermp.a.b(packet);
            }
        }
    }
    
    public String c() {
        String s = "";
        for (int i = 0; i < this.b.size(); ++i) {
            if (i > 0) {
                s += ", ";
            }
            s += this.b.get(i).v;
        }
        return s;
    }
    
    public String[] d() {
        final String[] as = new String[this.b.size()];
        for (int i = 0; i < this.b.size(); ++i) {
            as[i] = this.b.get(i).v;
        }
        return as;
    }
    
    public void a(final String s) {
        this.f.add(s.toLowerCase());
        this.m();
    }
    
    public void b(final String s) {
        this.f.remove(s.toLowerCase());
        this.m();
    }
    
    private void l() {
        try {
            this.f.clear();
            final BufferedReader bufferedreader = new BufferedReader(new FileReader(this.j));
            String s = "";
            while ((s = bufferedreader.readLine()) != null) {
                this.f.add(s.trim().toLowerCase());
            }
            bufferedreader.close();
        }
        catch (Exception exception) {
            ig.a.warning("Failed to load ban list: " + exception);
        }
    }
    
    private void m() {
        try {
            final PrintWriter printwriter = new PrintWriter(new FileWriter(this.j, false));
            for (final String s : this.f) {
                printwriter.println(s);
            }
            printwriter.close();
        }
        catch (Exception exception) {
            ig.a.warning("Failed to save ban list: " + exception);
        }
    }
    
    public Set e() {
        return this.f;
    }
    
    public Set f() {
        return this.g;
    }
    
    public void c(final String s) {
        this.g.add(s.toLowerCase());
        this.o();
    }
    
    public void d(final String s) {
        this.g.remove(s.toLowerCase());
        this.o();
    }
    
    private void n() {
        try {
            this.g.clear();
            final BufferedReader bufferedreader = new BufferedReader(new FileReader(this.k));
            String s = "";
            while ((s = bufferedreader.readLine()) != null) {
                this.g.add(s.trim().toLowerCase());
            }
            bufferedreader.close();
        }
        catch (Exception exception) {
            ig.a.warning("Failed to load ip ban list: " + exception);
        }
    }
    
    private void o() {
        try {
            final PrintWriter printwriter = new PrintWriter(new FileWriter(this.k, false));
            for (final String s : this.g) {
                printwriter.println(s);
            }
            printwriter.close();
        }
        catch (Exception exception) {
            ig.a.warning("Failed to save ip ban list: " + exception);
        }
    }
    
    public void e(final String s) {
        this.h.add(s.toLowerCase());
        this.q();
    }
    
    public void f(final String s) {
        this.h.remove(s.toLowerCase());
        this.q();
    }
    
    private void p() {
        try {
            this.h.clear();
            final BufferedReader bufferedreader = new BufferedReader(new FileReader(this.l));
            String s = "";
            while ((s = bufferedreader.readLine()) != null) {
                this.h.add(s.trim().toLowerCase());
            }
            bufferedreader.close();
        }
        catch (Exception exception) {
            ig.a.warning("Failed to load operators list: " + exception);
        }
    }
    
    private void q() {
        try {
            final PrintWriter printwriter = new PrintWriter(new FileWriter(this.l, false));
            for (final String s : this.h) {
                printwriter.println(s);
            }
            printwriter.close();
        }
        catch (Exception exception) {
            ig.a.warning("Failed to save operators list: " + exception);
        }
    }
    
    private void r() {
        try {
            this.i.clear();
            final BufferedReader bufferedreader = new BufferedReader(new FileReader(this.m));
            String s = "";
            while ((s = bufferedreader.readLine()) != null) {
                this.i.add(s.trim().toLowerCase());
            }
            bufferedreader.close();
        }
        catch (Exception exception) {
            ig.a.warning("Failed to load white-list: " + exception);
        }
    }
    
    private void s() {
        try {
            final PrintWriter printwriter = new PrintWriter(new FileWriter(this.m, false));
            for (final String s : this.i) {
                printwriter.println(s);
            }
            printwriter.close();
        }
        catch (Exception exception) {
            ig.a.warning("Failed to save white-list: " + exception);
        }
    }
    
    public boolean g(String s) {
        s = s.trim().toLowerCase();
        return !this.o || this.h.contains(s) || this.i.contains(s);
    }
    
    public boolean h(final String s) {
        return this.h.contains(s.trim().toLowerCase());
    }
    
    public ft i(final String s) {
        for (int i = 0; i < this.b.size(); ++i) {
            final ft entityplayermp = this.b.get(i);
            if (entityplayermp.v.equalsIgnoreCase(s)) {
                return entityplayermp;
            }
        }
        return null;
    }
    
    public void a(final String s, final String s1) {
        final ft entityplayermp = this.i(s);
        if (entityplayermp != null) {
            entityplayermp.a.b((kq)new pe(s1));
        }
    }
    
    public void a(final double d, final double d1, final double d2, final double d3, final int i, final kq packet) {
        this.a(null, d, d1, d2, d3, i, packet);
    }
    
    public void a(final hk entityplayer, final double d, final double d1, final double d2, final double d3, final int i, final kq packet) {
        for (int j = 0; j < this.b.size(); ++j) {
            final ft entityplayermp = this.b.get(j);
            if (entityplayermp != entityplayer) {
                if (entityplayermp.w == i) {
                    final double d4 = d - entityplayermp.bm;
                    final double d5 = d1 - entityplayermp.bn;
                    final double d6 = d2 - entityplayermp.bo;
                    if (d4 * d4 + d5 * d5 + d6 * d6 < d3 * d3) {
                        entityplayermp.a.b(packet);
                    }
                }
            }
        }
    }
    
    public void j(final String s) {
        final pe packet3chat = new pe(s);
        for (int i = 0; i < this.b.size(); ++i) {
            final ft entityplayermp = this.b.get(i);
            if (this.h(entityplayermp.v)) {
                entityplayermp.a.b((kq)packet3chat);
            }
        }
    }
    
    public boolean a(final String s, final kq packet) {
        final ft entityplayermp = this.i(s);
        if (entityplayermp != null) {
            entityplayermp.a.b(packet);
            return true;
        }
        return false;
    }
    
    public void g() {
        for (int i = 0; i < this.b.size(); ++i) {
            this.n.a((hk)this.b.get(i));
        }
    }
    
    public void a(final int i, final int j, final int k, final ow tileentity) {
    }
    
    public void k(final String s) {
        this.i.add(s);
        this.s();
    }
    
    public void l(final String s) {
        this.i.remove(s);
        this.s();
    }
    
    public Set h() {
        return this.i;
    }
    
    public void i() {
        this.r();
    }
    
    public void a(final ft entityplayermp, final fy worldserver) {
        entityplayermp.a.b((kq)new hy(worldserver.n()));
        if (worldserver.w()) {
            entityplayermp.a.b((kq)new cj(1, 0));
        }
    }
    
    public void f(final ft entityplayermp) {
        entityplayermp.a(entityplayermp.l);
        entityplayermp.t_();
    }
    
    public int j() {
        return this.b.size();
    }
    
    public int k() {
        return this.e;
    }
    
    static {
        ig.a = Logger.getLogger("Minecraft");
    }
}
