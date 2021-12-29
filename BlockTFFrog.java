// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFFrog extends BlockTFCritter
{
    public static int sprFrog;
    private Class frogEntityClass;
    
    protected BlockTFFrog(final int i) {
        super(i, aci.p);
        this.frogEntityClass = TileEntityTFFirefly.class;
        this.bN = BlockTFFrog.sprFrog;
    }
    
    public boolean canPlaceAt(final wz world, final int x, final int y, final int z) {
        return world.h(x, y, z);
    }
    
    public kt u_() {
        try {
            return this.frogEntityClass.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
    
    static {
        BlockTFFrog.sprFrog = ModLoader.addOverride("/terrain.png", "/twilightforest/blocks/firefly-tiny.png");
    }
}
