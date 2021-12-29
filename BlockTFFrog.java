// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFFrog extends BlockTFCritter
{
    public static int sprFrog;
    private Class frogEntityClass;
    
    protected BlockTFFrog(final int i) {
        super(i, na.p);
        this.frogEntityClass = TileEntityTFFirefly.class;
        this.bN = BlockTFFrog.sprFrog;
    }
    
    public boolean canPlaceAt(final ge world, final int x, final int y, final int z) {
        return world.e(x, y, z);
    }
    
    public qj a_() {
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
