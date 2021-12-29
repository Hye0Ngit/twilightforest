import java.util.Random;
import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerOutbuilding extends ComponentTFTowerWing
{
    protected ComponentTFTowerOutbuilding(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void makeABeard(final ln parent, final List list, final Random rand) {
    }
    
    @Override
    public boolean makeTowerWing(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int direction) {
        return y > 7 && super.makeTowerWing(list, rand, index, x, y, z, wingSize, wingHeight, direction);
    }
}
