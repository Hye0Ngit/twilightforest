// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFWorldClient extends jb
{
    public static int SEALEVEL;
    
    public TFWorldClient(final jb oldWorld) {
        super(getNetClientHandler(oldWorld), new fg(oldWorld.v(), oldWorld.x.q(), false, false, vt.b), oldWorld.x.i(), oldWorld.q);
        this.copyAllParameters(oldWorld);
        this.y();
        this.d.clear();
    }
    
    public void clearAllButOnePlayer(final yr player) {
        while (this.b.contains(player)) {
            this.b.remove(player);
        }
        this.b.add(player);
    }
    
    private void copyAllParameters(final jb oldWorld) {
        try {
            for (int i = 0; i < jb.class.getDeclaredFields().length; ++i) {
                final Object o = ModLoader.getPrivateValue((Class)jb.class, (Object)oldWorld, i);
                ModLoader.setPrivateValue((Class)jb.class, (Object)this, i, o);
                System.out.println("Copying " + o);
            }
            for (int i = 0; i < wz.class.getDeclaredFields().length; ++i) {
                final Object o = ModLoader.getPrivateValue((Class)wz.class, (Object)oldWorld, i);
                ModLoader.setPrivateValue((Class)wz.class, (Object)this, i, o);
                System.out.println("Copying " + o);
            }
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }
    
    public TFWorldClient(final adg netClientHandler, final fg worldSettings, final int worldType, final int difficultySetting) {
        super(netClientHandler, worldSettings, worldType, difficultySetting);
    }
    
    public static adg getNetClientHandler(final jb oldWorld) {
        adg handler = null;
        int listIndexInClass = -1;
        try {
            for (int i = 0; i < jb.class.getDeclaredFields().length; ++i) {
                if (ModLoader.getPrivateValue((Class)jb.class, (Object)oldWorld, i) instanceof adg) {
                    listIndexInClass = i;
                    break;
                }
            }
            if (listIndexInClass > -1) {
                handler = (adg)ModLoader.getPrivateValue((Class)jb.class, (Object)oldWorld, listIndexInClass);
            }
            else {
                System.out.println("Could not locate the NetClientHandler.  That's weird.  I bet there will be an error soon.");
            }
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        return handler;
    }
    
    public static oy getChunkProviderClient(final jb oldWorld) {
        oy cpc = null;
        int listIndexInClass = -1;
        try {
            for (int i = 0; i < jb.class.getDeclaredFields().length; ++i) {
                if (ModLoader.getPrivateValue((Class)jb.class, (Object)oldWorld, i) instanceof oy) {
                    listIndexInClass = i;
                    break;
                }
            }
            if (listIndexInClass > -1) {
                cpc = (oy)ModLoader.getPrivateValue((Class)jb.class, (Object)oldWorld, listIndexInClass);
            }
            else {
                System.out.println("Could not locate the ChunkProviderClient.  That's weird.  I bet there will be an error soon.");
            }
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        return cpc;
    }
    
    private void setChunkProviderClient(final oy cpc) {
        int listIndexInClass = -1;
        try {
            for (int i = 0; i < jb.class.getDeclaredFields().length; ++i) {
                if (ModLoader.getPrivateValue((Class)jb.class, (Object)this, i) instanceof oy) {
                    listIndexInClass = i;
                    break;
                }
            }
            if (listIndexInClass > -1) {
                ModLoader.setPrivateValue((Class)jb.class, (Object)this, listIndexInClass, (Object)cpc);
            }
            else {
                System.out.println("Could not set the ChunkProviderClient.  That's weird.  I bet there will be an error soon.");
            }
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }
    
    public void e() {
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
    
    public bm a(final nk entity, final float f) {
        final float f2 = 0.25f;
        float f3 = gh.b(f2 * 3.141593f * 2.0f) * 2.0f + 0.5f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        final int i = gh.c(entity.o);
        final int j = gh.c(entity.q);
        final int k = this.i().a(i, j).a(0.5f);
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
        if (this.n > 0) {
            float f13 = this.n - f;
            if (f13 > 1.0f) {
                f13 = 1.0f;
            }
            f13 *= 0.45f;
            f4 = f4 * (1.0f - f13) + 0.8f * f13;
            f5 = f5 * (1.0f - f13) + 0.8f * f13;
            f6 = f6 * (1.0f - f13) + 1.0f * f13;
        }
        return bm.b((double)f4, (double)f5, (double)f6);
    }
    
    public float h(final float f) {
        return 0.5f;
    }
}
