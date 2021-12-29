// 
// Decompiled by Procyon v0.6-prerelease
// 

package net.minecraft.server;

import java.awt.GraphicsEnvironment;
import java.util.Iterator;
import java.net.UnknownHostException;
import java.util.Random;
import java.io.IOException;
import java.util.logging.Level;
import java.net.InetAddress;
import java.io.File;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.logging.Logger;

public class MinecraftServer implements Runnable, st, wl
{
    public static Logger a;
    public static HashMap b;
    private String t;
    private int u;
    public ew c;
    public rh d;
    public fy[] e;
    public long[] f;
    public long[][] g;
    public ig h;
    private su v;
    private boolean w;
    public boolean i;
    int j;
    public String k;
    public int l;
    private List x;
    private List y;
    public vb[] m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public String s;
    private tn z;
    private ps A;
    
    public MinecraftServer() {
        this.f = new long[100];
        this.w = true;
        this.i = false;
        this.j = 0;
        this.x = new ArrayList();
        this.y = Collections.synchronizedList(new ArrayList<Object>());
        this.m = new vb[4];
        new de(this);
    }
    
    private boolean s() throws UnknownHostException {
        this.v = new su(this);
        final dd threadcommandreader = new dd(this);
        threadcommandreader.setDaemon(true);
        threadcommandreader.start();
        hx.a();
        ModLoader.Init(this);
        MinecraftServer.a.info("Starting minecraft server version 1.1");
        if (Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
            MinecraftServer.a.warning("**** NOT ENOUGH RAM!");
            MinecraftServer.a.warning("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
        }
        MinecraftServer.a.info("Loading properties");
        this.d = new rh(new File("server.properties"));
        this.t = this.d.a("server-ip", "");
        this.n = this.d.a("online-mode", true);
        this.o = this.d.a("spawn-animals", true);
        this.p = this.d.a("spawn-npcs", true);
        this.q = this.d.a("pvp", true);
        this.r = this.d.a("allow-flight", false);
        (this.s = this.d.a("motd", "A Minecraft Server")).replace('¡×', '$');
        InetAddress inetaddress = null;
        if (this.t.length() > 0) {
            inetaddress = InetAddress.getByName(this.t);
        }
        this.u = this.d.a("server-port", 25565);
        MinecraftServer.a.info("Starting Minecraft server on " + ((this.t.length() == 0) ? "*" : this.t) + ":" + this.u);
        try {
            this.c = new ew(this, inetaddress, this.u);
        }
        catch (IOException ioexception) {
            MinecraftServer.a.warning("**** FAILED TO BIND TO PORT!");
            MinecraftServer.a.log(Level.WARNING, "The exception was: " + ioexception.toString());
            MinecraftServer.a.warning("Perhaps a server is already running on that port?");
            return false;
        }
        if (!this.n) {
            MinecraftServer.a.warning("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
            MinecraftServer.a.warning("The server will make no attempt to authenticate usernames. Beware.");
            MinecraftServer.a.warning("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
            MinecraftServer.a.warning("To change this, set \"online-mode\" to \"true\" in the server.settings file.");
        }
        this.h = new ig(this);
        this.m[0] = new vb(this, 0);
        this.m[1] = new vb(this, -1);
        this.m[2] = new vb(this, 1);
        this.m[3] = new vb(this, 7);
        final long l = System.nanoTime();
        final String s = this.d.a("level-name", "world");
        final String s2 = this.d.a("level-seed", "");
        final String s3 = this.d.a("level-type", "DEFAULT");
        long l2 = new Random().nextLong();
        if (s2.length() > 0) {
            try {
                final long l3 = Long.parseLong(s2);
                if (l3 != 0L) {
                    l2 = l3;
                }
            }
            catch (NumberFormatException numberformatexception) {
                l2 = s2.hashCode();
            }
        }
        du enumworldtype = du.a(s3);
        if (enumworldtype == null) {
            enumworldtype = du.a;
        }
        MinecraftServer.a.info("Preparing level \"" + s + "\"");
        this.a((nn)new hz(new File(".")), s, l2, enumworldtype);
        MinecraftServer.a.info("Done (" + (System.nanoTime() - l) + "ns)! For help, type \"help\" or \"?\"");
        if (this.d.a("enable-query", false)) {
            MinecraftServer.a.info("Starting GS4 status listener");
            (this.z = new tn((wl)this)).a();
        }
        if (this.d.a("enable-rcon", false)) {
            MinecraftServer.a.info("Starting remote control listener");
            (this.A = new ps((wl)this)).a();
        }
        return true;
    }
    
    private void a(final nn isaveformat, final String s, final long l, final du enumworldtype) {
        if (isaveformat.a(s)) {
            MinecraftServer.a.info("Converting map!");
            isaveformat.a(s, (yi)new da(this));
        }
        this.e = new fy[4];
        this.g = new long[this.e.length][100];
        int i = this.d.a("gamemode", 0);
        i = hr.a(i);
        MinecraftServer.a.info("Default game type: " + i);
        final boolean flag = this.d.a("generate-structures", true);
        final hr worldsettings = new hr(l, i, flag, false, enumworldtype);
        final mw saveolddir = new mw(new File("."), s, true);
        for (int j = 0; j < this.e.length; ++j) {
            byte byte0 = 0;
            if (j == 3) {
                byte0 = 7;
            }
            if (j == 1) {
                byte0 = -1;
            }
            if (j == 2) {
                byte0 = 1;
            }
            if (j == 0) {
                this.e[j] = new fy(this, (xc)saveolddir, s, (int)byte0, worldsettings);
            }
            else {
                this.e[j] = (fy)new hd(this, (xc)saveolddir, s, (int)byte0, worldsettings, this.e[0]);
            }
            this.e[j].a((pl)new fv(this, this.e[j]));
            this.e[j].v = this.d.a("difficulty", 1);
            this.e[j].a(this.d.a("spawn-monsters", true), this.o);
            this.e[j].r().d(i);
            this.h.a(this.e);
        }
        final char c = '\u00c4';
        long l2 = System.currentTimeMillis();
        for (int k = 0; k < 1; ++k) {
            MinecraftServer.a.info("Preparing start region for level " + k);
            final fy worldserver = this.e[k];
            final bz chunkcoordinates = worldserver.o();
            for (int i2 = -c; i2 <= c && this.w; i2 += 16) {
                for (int j2 = -c; j2 <= c && this.w; j2 += 16) {
                    final long l3 = System.currentTimeMillis();
                    if (l3 < l2) {
                        l2 = l3;
                    }
                    if (l3 > l2 + 1000L) {
                        final int k2 = (c * '\u0002' + 1) * (c * '\u0002' + 1);
                        final int i3 = (i2 + c) * (c * '\u0002' + 1) + (j2 + 1);
                        this.b("Preparing spawn area", i3 * 100 / k2);
                        l2 = l3;
                    }
                    worldserver.J.c(chunkcoordinates.a + i2 >> 4, chunkcoordinates.c + j2 >> 4);
                    while (worldserver.x() && this.w) {}
                }
            }
        }
        this.t();
    }
    
    private void b(final String s, final int i) {
        this.k = s;
        this.l = i;
        MinecraftServer.a.info(s + ": " + i + "%");
    }
    
    private void t() {
        this.k = null;
        this.l = 0;
    }
    
    private void u() {
        MinecraftServer.a.info("Saving chunks");
        for (int i = 0; i < this.e.length; ++i) {
            final fy worldserver = this.e[i];
            worldserver.a(true, (yi)null);
            worldserver.y();
        }
    }
    
    private void v() {
        MinecraftServer.a.info("Stopping server");
        if (this.h != null) {
            this.h.g();
        }
        for (int i = 0; i < this.e.length; ++i) {
            final fy worldserver = this.e[i];
            if (worldserver != null) {
                this.u();
            }
        }
    }
    
    public void a() {
        this.w = false;
    }
    
    @Override
    public void run() {
        try {
            if (this.s()) {
                long l = System.currentTimeMillis();
                long l2 = 0L;
                while (this.w) {
                    ModLoader.OnTick(this);
                    final long l3 = System.currentTimeMillis();
                    long l4 = l3 - l;
                    if (l4 > 2000L) {
                        MinecraftServer.a.warning("Can't keep up! Did the system time change, or is the server overloaded?");
                        l4 = 2000L;
                    }
                    if (l4 < 0L) {
                        MinecraftServer.a.warning("Time ran backwards! Did the system time change?");
                        l4 = 0L;
                    }
                    l2 += l4;
                    l = l3;
                    if (this.e[0].u()) {
                        this.w();
                        l2 = 0L;
                    }
                    else {
                        while (l2 > 50L) {
                            l2 -= 50L;
                            this.w();
                        }
                    }
                    Thread.sleep(1L);
                }
            }
            else {
                while (this.w) {
                    this.b();
                    try {
                        Thread.sleep(10L);
                    }
                    catch (InterruptedException interruptedexception) {
                        interruptedexception.printStackTrace();
                    }
                }
            }
        }
        catch (Throwable throwable1) {
            throwable1.printStackTrace();
            MinecraftServer.a.log(Level.SEVERE, "Unexpected exception", throwable1);
            while (this.w) {
                this.b();
                try {
                    Thread.sleep(10L);
                }
                catch (InterruptedException interruptedexception2) {
                    interruptedexception2.printStackTrace();
                }
            }
            try {
                this.v();
                this.i = true;
            }
            catch (Throwable throwable2) {
                throwable2.printStackTrace();
            }
            finally {
                System.exit(0);
            }
        }
        finally {
            try {
                this.v();
                this.i = true;
            }
            catch (Throwable throwable3) {
                throwable3.printStackTrace();
                System.exit(0);
            }
            finally {
                System.exit(0);
            }
        }
    }
    
    private void w() {
        final long l = System.nanoTime();
        final ArrayList arraylist = new ArrayList();
        for (final String s : MinecraftServer.b.keySet()) {
            final int j1 = MinecraftServer.b.get(s);
            if (j1 > 0) {
                MinecraftServer.b.put(s, j1 - 1);
            }
            else {
                arraylist.add(s);
            }
        }
        for (int i = 0; i < arraylist.size(); ++i) {
            MinecraftServer.b.remove(arraylist.get(i));
        }
        fb.a();
        cc.a();
        ++this.j;
        for (int k = 0; k < this.e.length; ++k) {
            final long l2 = System.nanoTime();
            if (k == 0 || this.d.a("allow-nether", true)) {
                final fy worldserver = this.e[k];
                if (this.j % 20 == 0) {
                    this.h.a((kq)new hy(worldserver.n()), worldserver.y.h);
                }
                worldserver.h();
                while (worldserver.x()) {}
                worldserver.f();
            }
            this.g[k][this.j % 100] = System.nanoTime() - l2;
        }
        this.c.a();
        this.h.b();
        for (int m = 0; m < this.m.length; ++m) {
            this.m[m].a();
        }
        for (int i2 = 0; i2 < this.x.size(); ++i2) {
            this.x.get(i2).a();
        }
        try {
            this.b();
        }
        catch (Exception exception) {
            MinecraftServer.a.log(Level.WARNING, "Unexpected exception while parsing console command", exception);
        }
        this.f[this.j % 100] = System.nanoTime() - l;
    }
    
    public void a(final String s, final st icommandlistener) {
        this.y.add(new bb(s, icommandlistener));
    }
    
    public void b() {
        while (this.y.size() > 0) {
            final bb servercommand = this.y.remove(0);
            this.v.a(servercommand);
        }
    }
    
    public void a(final fl iupdateplayerlistbox) {
        this.x.add(iupdateplayerlistbox);
    }
    
    public static void main(final String[] args) {
        jv.a();
        try {
            final MinecraftServer minecraftserver = new MinecraftServer();
            if (!GraphicsEnvironment.isHeadless() && (args.length <= 0 || !args[0].equals("nogui"))) {
                up.a(minecraftserver);
            }
            new cz("Server thread", minecraftserver).start();
        }
        catch (Exception exception) {
            MinecraftServer.a.log(Level.SEVERE, "Failed to start the minecraft server", exception);
        }
    }
    
    public File a(final String s) {
        return new File(s);
    }
    
    public void b(final String s) {
        MinecraftServer.a.info(s);
    }
    
    public void c(final String s) {
        MinecraftServer.a.warning(s);
    }
    
    public String d() {
        return "CONSOLE";
    }
    
    public fy a(final int i) {
        if (i == 7) {
            return this.e[3];
        }
        if (i == -1) {
            return this.e[1];
        }
        if (i == 1) {
            return this.e[2];
        }
        return this.e[0];
    }
    
    public vb b(final int i) {
        if (i == 7) {
            return this.m[3];
        }
        if (i == -1) {
            return this.m[1];
        }
        if (i == 1) {
            return this.m[2];
        }
        return this.m[0];
    }
    
    public int a(final String s, final int i) {
        return this.d.a(s, i);
    }
    
    public String a(final String s, final String s1) {
        return this.d.a(s, s1);
    }
    
    public void a(final String s, final Object obj) {
        this.d.a(s, obj);
    }
    
    public void c() {
        this.d.b();
    }
    
    public String e() {
        final File file = this.d.c();
        if (file != null) {
            return file.getAbsolutePath();
        }
        return "No settings file";
    }
    
    public String f() {
        return this.t;
    }
    
    public int g() {
        return this.u;
    }
    
    public String h() {
        return this.s;
    }
    
    public String i() {
        return "1.1";
    }
    
    public int j() {
        return this.h.j();
    }
    
    public int k() {
        return this.h.k();
    }
    
    public String[] l() {
        return this.h.d();
    }
    
    public String m() {
        return this.d.a("level-name", "world");
    }
    
    public String n() {
        return "";
    }
    
    public void o() {
    }
    
    public String d(final String s) {
        wf.a.a();
        this.v.a(new bb(s, (st)wf.a));
        return wf.a.b();
    }
    
    public boolean p() {
        return false;
    }
    
    public void e(final String s) {
        MinecraftServer.a.log(Level.SEVERE, s);
    }
    
    public void f(final String s) {
        if (this.p()) {
            MinecraftServer.a.log(Level.INFO, s);
        }
    }
    
    public String[] q() {
        return this.h.f().toArray(new String[0]);
    }
    
    public String[] r() {
        return this.h.e().toArray(new String[0]);
    }
    
    public static boolean a(final MinecraftServer minecraftserver) {
        return minecraftserver.w;
    }
    
    static {
        MinecraftServer.a = Logger.getLogger("Minecraft");
        MinecraftServer.b = new HashMap();
    }
}
