// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.Minecraft;
import twilightforest.TFAchievementPage;
import cpw.mods.fml.client.FMLClientHandler;

public class TFWorldClient extends ayh
{
    public TFWorldClient(final ayh oldWorld) {
        super(FMLClientHandler.instance().getClient().r(), new yd(oldWorld.K()), 7, oldWorld.t, oldWorld.E);
    }
    
    public static void sendToTwilightForestMulti() {
        final Minecraft mc = FMLClientHandler.instance().getClient();
        final TFWorldClient tfWorld = new TFWorldClient(mc.e);
        tfWorld.J = true;
        mc.a((ayh)tfWorld, "Entering the Twilight Forest");
        mc.g.p = (xv)mc.e;
        mc.g.ap = 7;
        setWorldClient(mc, (TFWorldClient)mc.e);
        mc.g.a((jl)TFAchievementPage.twilightPortal);
        mc.g.a((jl)TFAchievementPage.twilightArrival);
    }
    
    private static void setWorldClient(final Minecraft mc, final TFWorldClient newWorld) {
        final axz nch = mc.r();
        for (int i = 0; i < axz.class.getDeclaredFields().length; ++i) {
            try {
                if (ModLoader.getPrivateValue((Class)axz.class, (Object)nch, i) instanceof ayh) {
                    ModLoader.setPrivateValue((Class)axz.class, (Object)nch, i, (Object)newWorld);
                }
            }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            catch (SecurityException e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public void f() {
    }
    
    public int a(final float f) {
        float f2 = 0.5f;
        f2 *= (float)(1.0 - this.j(f) * 5.0f / 16.0);
        f2 *= (float)(1.0 - this.i(f) * 5.0f / 16.0);
        f2 = 1.0f - f2;
        return (int)(f2 * 11.0f);
    }
    
    public float b(final float f) {
        float f2 = 0.2f;
        f2 *= (float)(1.0 - this.j(f) * 5.0f / 16.0);
        f2 *= (float)(1.0 - this.i(f) * 5.0f / 16.0);
        return f2 * 0.8f + 0.2f;
    }
    
    public aob a(final lq entity, final float f) {
        final float f2 = 0.25f;
        float f3 = ke.b(f2 * 3.141593f * 2.0f) * 2.0f + 0.5f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        final int i = ke.c(entity.t);
        final int j = ke.c(entity.v);
        final int k = this.a(i, j).a(0.5f);
        float f4 = (k >> 16 & 0xFF) / 255.0f;
        float f5 = (k >> 8 & 0xFF) / 255.0f;
        float f6 = (k & 0xFF) / 255.0f;
        f4 *= f3;
        f5 *= f3;
        f6 *= f3;
        final float f7 = this.j(f);
        if (f7 > 0.0f) {
            final float f8 = (f4 * 0.3f + f5 * 0.59f + f6 * 0.11f) * 0.6f;
            final float f9 = 1.0f - f7 * 0.75f;
            f4 = f4 * f9 + f8 * (1.0f - f9);
            f5 = f5 * f9 + f8 * (1.0f - f9);
            f6 = f6 * f9 + f8 * (1.0f - f9);
        }
        final float f10 = this.i(f);
        if (f10 > 0.0f) {
            final float f11 = (f4 * 0.3f + f5 * 0.59f + f6 * 0.11f) * 0.2f;
            final float f12 = 1.0f - f10 * 0.75f;
            f4 = f4 * f12 + f11 * (1.0f - f12);
            f5 = f5 * f12 + f11 * (1.0f - f12);
            f6 = f6 * f12 + f11 * (1.0f - f12);
        }
        if (this.r > 0) {
            float f13 = this.r - f;
            if (f13 > 1.0f) {
                f13 = 1.0f;
            }
            f13 *= 0.45f;
            f4 = f4 * (1.0f - f13) + 0.8f * f13;
            f5 = f5 * (1.0f - f13) + 0.8f * f13;
            f6 = f6 * (1.0f - f13) + 1.0f * f13;
        }
        return this.S().a((double)f4, (double)f5, (double)f6);
    }
    
    public float h(final float f) {
        return 1.5f;
    }
    
    public double R() {
        return 32.0;
    }
}
