import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerRoofAttachedSlab extends ComponentTFTowerRoofSlab
{
    public ComponentTFTowerRoofAttachedSlab(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
    }
    
    @Override
    public boolean a(final wz world, final Random rand, final qc sbb) {
        return this.makeConnectedCap(world, sbb);
    }
}
