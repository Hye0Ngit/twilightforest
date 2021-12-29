import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerMain extends ComponentTFTowerWing
{
    public ComponentTFTowerMain(final wz world, final Random rand, final int index, final int x, final int y, final int z) {
        super(index, x, y, z, 15, 45 + rand.nextInt(TFWorld.WORLDHEIGHT - TFWorld.SEALEVEL - 56), 0);
    }
    
    @Override
    public void a(final hb parent, final List list, final Random rand) {
        this.makeARoof(parent, list, rand);
        for (int i = 0; i < 4; ++i) {
            final int[] dest = this.getValidOpening(rand, i);
            final int childHeight = Math.min(21 + rand.nextInt(10), this.height - dest[1] - 3);
            if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 9, childHeight, i)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 7, childHeight, i);
            }
        }
        for (int i = 0; i < 4; ++i) {
            final int[] dest = this.getValidOpening(rand, i);
            final int childHeight = Math.min(7 + rand.nextInt(6), this.height - dest[1] - 3);
            if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 5, childHeight, i)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 3, childHeight, i);
            }
        }
        for (int i = 0; i < 4; ++i) {
            final int[] dest = this.getOutbuildingOpening(rand, i);
            final int childHeight = 11 + rand.nextInt(10);
            final int childSize = 7 + rand.nextInt(2) * 2;
            this.makeTowerOutbuilding(list, rand, 1, dest[0], dest[1], dest[2], childSize, childHeight, i);
        }
        for (int i = 0; i < 16; ++i) {
            final int[] dest = this.getValidOpening(rand, i % 4);
            final int childHeight = 6 + rand.nextInt(5);
            if (rand.nextInt(3) == 0 || !this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 5, childHeight, i % 4)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 3, childHeight, i % 4);
            }
        }
    }
    
    public int[] getOutbuildingOpening(final Random rand, final int rotation) {
        int rx = 0;
        final int ry = 1;
        int rz = 0;
        switch (rotation) {
            case 0: {
                rx = this.size - 1;
                rz = 6 + rand.nextInt(8);
                break;
            }
            case 1: {
                rx = 1 + rand.nextInt(11);
                rz = this.size - 1;
                break;
            }
            case 2: {
                rx = 0;
                rz = 1 + rand.nextInt(8);
                break;
            }
            case 3: {
                rx = 3 + rand.nextInt(11);
                rz = 0;
                break;
            }
        }
        return new int[] { rx, ry, rz };
    }
    
    public boolean makeTowerOutbuilding(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        final int direction = (this.h + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        final ComponentTFTowerOutbuilding outbuilding = new ComponentTFTowerOutbuilding(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final hb intersect = hb.a(list, outbuilding.g);
        if (intersect == null || intersect == this) {
            list.add(outbuilding);
            outbuilding.a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean a(final wz world, final Random rand, final qc sbb) {
        this.a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, (ul)aaw.b());
        this.makeStairs(world, rand, sbb);
        this.makeOpenings(world, sbb);
        this.decorateThisTower(world, rand, sbb);
        return true;
    }
}
