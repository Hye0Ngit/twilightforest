import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class ComponentTFTowerRoof extends StructureTFComponent
{
    int size;
    int height;
    
    public ComponentTFTowerRoof(final int i, final ComponentTFTowerWing wing) {
        super(i);
    }
    
    protected void makeAttachedOverhangBB(final ComponentTFTowerWing wing) {
        switch (this.h) {
            case 0: {
                this.g = new xv(wing.g.a, wing.g.e, wing.g.c - 1, wing.g.d + 1, wing.g.e + this.height - 1, wing.g.f + 1);
                break;
            }
            case 1: {
                this.g = new xv(wing.g.a - 1, wing.g.e, wing.g.c, wing.g.d + 1, wing.g.e + this.height - 1, wing.g.f + 1);
                break;
            }
            case 2: {
                this.g = new xv(wing.g.a - 1, wing.g.e, wing.g.c - 1, wing.g.d, wing.g.e + this.height - 1, wing.g.f + 1);
                break;
            }
            case 3: {
                this.g = new xv(wing.g.a - 1, wing.g.e, wing.g.c - 1, wing.g.d + 1, wing.g.e + this.height - 1, wing.g.f);
                break;
            }
        }
    }
    
    protected void makeCapBB(final ComponentTFTowerWing wing) {
        this.g = new xv(wing.g.a, wing.g.e, wing.g.c, wing.g.d, wing.g.e + this.height, wing.g.f);
    }
    
    protected void makeOverhangBB(final ComponentTFTowerWing wing) {
        this.g = new xv(wing.g.a - 1, wing.g.e, wing.g.c - 1, wing.g.d + 1, wing.g.e + this.height - 1, wing.g.f + 1);
    }
    
    public boolean a(final ge world, final Random random, final xv structureboundingbox) {
        return false;
    }
    
    public boolean fits(final ComponentTFTowerWing parent, final List list, final Random rand) {
        return a(list, this.g) == parent;
    }
}
