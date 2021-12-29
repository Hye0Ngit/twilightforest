// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import twilightforest.structures.EnumDarkTowerDoor;
import java.util.Random;
import java.util.List;

public class ComponentTFDarkTowerEntrance extends ComponentTFDarkTowerWing
{
    protected ComponentTFDarkTowerEntrance(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void a(final agq parent, final List list, final Random rand) {
        super.a(parent, list, rand);
        this.addOpening(this.size / 2, 1, 0, 1, EnumDarkTowerDoor.REAPPEARING);
        this.addOpening(this.size / 2, 1, this.size - 1, 3, EnumDarkTowerDoor.REAPPEARING);
    }
    
    @Override
    public void makeABeard(final agq parent, final List list, final Random rand) {
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        final Random decoRNG = new Random(world.F() + this.e.a * 321534781 ^ (long)(this.e.c * 756839));
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.b(world, this.deco.accentID, this.deco.accentMeta, x, -1, z, sbb);
            }
        }
        this.a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.nullifySkyLightForBoundingBox(world);
        this.makeOpenings(world, sbb);
        return true;
    }
}
