import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeSwamp extends TFBiomeBase
{
    public TFBiomeSwamp(final int i) {
        super(i);
        this.w = -0.25f;
        this.x = 0.0f;
        this.y = 0.8f;
        this.z = 0.9f;
        this.B.C = 1;
        this.B.D = 8;
        this.B.E = 10;
        this.B.I = 1;
        this.B.z = 1;
        this.B.y = 4;
        this.A = 14745456;
        ((TFBiomeDecorator)this.B).canopyPerChunk = -999;
        ((TFBiomeDecorator)this.B).lakesPerChunk = 2;
        ((TFBiomeDecorator)this.B).mangrovesPerChunk = 3;
    }
    
    @Override
    public ig a(final Random random) {
        return (ig)this.J;
    }
    
    public int a(final kq iblockaccess, final int i, final int j, final int k) {
        final double d = iblockaccess.a().a(i, j, k);
        final double d2 = iblockaccess.a().b(i, k);
        return (int)(((ha.a(d, d2) & 0xFCFCFC) + 2886700) * 0.75);
    }
    
    public int b(final kq iblockaccess, final int i, final int j, final int k) {
        final double d = iblockaccess.a().a(i, j, k);
        final double d2 = iblockaccess.a().b(i, k);
        return (int)(((ha.a(d, d2) & 0xFCFCFC) + 2886700) * 0.75);
    }
}
