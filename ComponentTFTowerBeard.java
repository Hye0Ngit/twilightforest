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
        this.f = wing.f;
        this.size = wing.size - 2;
        this.height = this.size / 2;
        this.e = new nl(wing.e.a + 1, wing.e.b - this.height - 1, wing.e.c + 1, wing.e.d - 1, wing.e.b - 1, wing.e.f - 1);
    }
    
    public boolean a(final ry world, final Random rand, final nl sbb) {
        return this.makePyramidBeard(world, sbb);
    }
    
    private boolean makePyramidBeard(final ry world, final nl sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            for (int max = this.size - y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    this.a(world, yy.bm.bM, 0, x, this.height - y, z, sbb);
                }
            }
        }
        return true;
    }
}
