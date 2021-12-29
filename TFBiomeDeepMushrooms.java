// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeDeepMushrooms extends TFBiomeBase
{
    public TFBiomeDeepMushrooms(final int i) {
        super(i);
        this.F = 0.8f;
        this.G = 1.0f;
        this.D = 0.15f;
        this.E = 0.4f;
        this.I.z = 1;
        this.I.D = 12;
        this.I.J = 8;
        ((TFBiomeDecorator)this.I).myceliumPerChunk = 3;
        ((TFBiomeDecorator)this.I).chanceCanopyIsMushroom = 0.9f;
    }
}
