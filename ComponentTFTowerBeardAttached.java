import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerBeardAttached extends ComponentTFTowerBeard
{
    public ComponentTFTowerBeardAttached(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.g = new xv(wing.g.a, wing.g.b - this.height - 1, wing.g.c, wing.g.d, wing.g.b - 1, wing.g.f);
    }
    
    @Override
    public boolean a(final ge world, final Random rand, final xv sbb) {
        return this.makeAttachedBeard(world, rand, sbb);
    }
    
    private boolean makeAttachedBeard(final ge world, final Random rand, final xv sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y + 1;
            final int max = this.size - y;
            this.a(world, sbb, 0, this.height - y, min, max, this.height - y, max, false, rand, (cp)lb.b());
        }
        return true;
    }
}
