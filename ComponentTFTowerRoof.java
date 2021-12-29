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
        switch (this.f) {
            case 0: {
                this.e = new nl(wing.e.a, wing.e.e, wing.e.c - 1, wing.e.d + 1, wing.e.e + this.height - 1, wing.e.f + 1);
                break;
            }
            case 1: {
                this.e = new nl(wing.e.a - 1, wing.e.e, wing.e.c, wing.e.d + 1, wing.e.e + this.height - 1, wing.e.f + 1);
                break;
            }
            case 2: {
                this.e = new nl(wing.e.a - 1, wing.e.e, wing.e.c - 1, wing.e.d, wing.e.e + this.height - 1, wing.e.f + 1);
                break;
            }
            case 3: {
                this.e = new nl(wing.e.a - 1, wing.e.e, wing.e.c - 1, wing.e.d + 1, wing.e.e + this.height - 1, wing.e.f);
                break;
            }
        }
    }
    
    protected void makeCapBB(final ComponentTFTowerWing wing) {
        this.e = new nl(wing.e.a, wing.e.e, wing.e.c, wing.e.d, wing.e.e + this.height, wing.e.f);
    }
    
    protected void makeOverhangBB(final ComponentTFTowerWing wing) {
        this.e = new nl(wing.e.a - 1, wing.e.e, wing.e.c - 1, wing.e.d + 1, wing.e.e + this.height - 1, wing.e.f + 1);
    }
    
    public boolean a(final ry world, final Random random, final nl structureboundingbox) {
        return false;
    }
    
    public boolean fits(final ComponentTFTowerWing parent, final List list, final Random rand) {
        return a(list, this.e) == parent;
    }
}
