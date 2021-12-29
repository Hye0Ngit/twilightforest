import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeSwamp extends TFBiomeBase
{
    public TFBiomeSwamp(final int i) {
        super(i);
        this.B = -0.25f;
        this.C = 0.0f;
        this.D = 0.8f;
        this.E = 0.9f;
        this.G.C = 1;
        this.G.D = 8;
        this.G.E = 10;
        this.G.I = 1;
        this.G.z = 1;
        this.G.y = 4;
        this.F = 14745456;
        ((TFBiomeDecorator)this.G).canopyPerChunk = -999;
        ((TFBiomeDecorator)this.G).lakesPerChunk = 2;
        ((TFBiomeDecorator)this.G).mangrovesPerChunk = 3;
    }
    
    @Override
    public pg a(final Random random) {
        return (pg)this.O;
    }
}
