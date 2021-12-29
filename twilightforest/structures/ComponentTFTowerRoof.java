// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.List;
import java.util.Random;

public abstract class ComponentTFTowerRoof extends StructureTFComponent
{
    protected int size;
    protected int height;
    
    public ComponentTFTowerRoof(final int i, final ComponentTFTowerWing wing) {
        super(i);
        this.spawnListIndex = -1;
    }
    
    protected void makeAttachedOverhangBB(final ComponentTFTowerWing wing) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                this.f = new age(wing.b().a, wing.b().e, wing.b().c - 1, wing.b().d + 1, wing.b().e + this.height - 1, wing.b().f + 1);
                break;
            }
            case 1: {
                this.f = new age(wing.b().a - 1, wing.b().e, wing.b().c, wing.b().d + 1, wing.b().e + this.height - 1, wing.b().f + 1);
                break;
            }
            case 2: {
                this.f = new age(wing.b().a - 1, wing.b().e, wing.b().c - 1, wing.b().d, wing.b().e + this.height - 1, wing.b().f + 1);
                break;
            }
            case 3: {
                this.f = new age(wing.b().a - 1, wing.b().e, wing.b().c - 1, wing.b().d + 1, wing.b().e + this.height - 1, wing.b().f);
                break;
            }
        }
    }
    
    protected void makeCapBB(final ComponentTFTowerWing wing) {
        this.f = new age(wing.b().a, wing.b().e, wing.b().c, wing.b().d, wing.b().e + this.height, wing.b().f);
    }
    
    protected void makeOverhangBB(final ComponentTFTowerWing wing) {
        this.f = new age(wing.b().a - 1, wing.b().e, wing.b().c - 1, wing.b().d + 1, wing.b().e + this.height - 1, wing.b().f + 1);
    }
    
    public boolean a(final abv world, final Random random, final age structureboundingbox) {
        return false;
    }
    
    public boolean fits(final ComponentTFTowerWing parent, final List list, final Random rand) {
        return a(list, this.f) == parent;
    }
}
