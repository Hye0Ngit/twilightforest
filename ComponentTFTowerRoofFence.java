import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerRoofFence extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofFence(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.f = wing.f;
        this.size = wing.size;
        this.height = 0;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean a(final ry world, final Random rand, final nl sbb) {
        final int y = this.height + 1;
        for (int x = 0; x <= this.size - 1; ++x) {
            for (int z = 0; z <= this.size - 1; ++z) {
                if (x == 0 || x == this.size - 1 || z == 0 || z == this.size - 1) {
                    this.a(world, yy.aZ.bM, 0, x, y, z, sbb);
                }
            }
        }
        return true;
    }
}
