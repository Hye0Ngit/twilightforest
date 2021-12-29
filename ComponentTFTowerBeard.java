import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerBeard extends StructureTFComponent
{
    int size;
    int height;
    
    public ComponentTFTowerBeard(final int i, final ComponentTFTowerWing wing) {
        super(i);
        this.h = wing.h;
        this.size = wing.size - 2;
        this.height = this.size / 2;
        this.g = new xv(wing.g.a + 1, wing.g.b - this.height - 1, wing.g.c + 1, wing.g.d - 1, wing.g.b - 1, wing.g.f - 1);
    }
    
    public boolean a(final ge world, final Random rand, final xv sbb) {
        return this.makePyramidBeard(world, rand, sbb);
    }
    
    private boolean makePyramidBeard(final ge world, final Random rand, final xv sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            final int max = this.size - y - 1;
            this.a(world, sbb, min, this.height - y, min, max, this.height - y, max, false, rand, (cp)lb.b());
        }
        return true;
    }
}
