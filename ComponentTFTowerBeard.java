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
        this.g = new qc(wing.g.a + 1, wing.g.b - this.height - 1, wing.g.c + 1, wing.g.d - 1, wing.g.b - 1, wing.g.f - 1);
    }
    
    public boolean a(final wz world, final Random rand, final qc sbb) {
        return this.makePyramidBeard(world, sbb);
    }
    
    private boolean makePyramidBeard(final wz world, final qc sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            for (int max = this.size - y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    this.a(world, ox.bm.bO, 0, x, this.height - y, z, sbb);
                }
            }
        }
        return true;
    }
}
