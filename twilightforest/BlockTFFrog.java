// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class BlockTFFrog extends BlockTFCritter
{
    public static int sprFrog;
    private Class frogEntityClass;
    
    protected BlockTFFrog(final int i) {
        super(i, acn.p);
        this.frogEntityClass = TileEntityTFFirefly.class;
        this.bN = BlockTFFrog.sprFrog;
    }
    
    @Override
    public boolean canPlaceAt(final xd world, final int x, final int y, final int z) {
        return world.h(x, y, z);
    }
    
    public kw getBlockEntity() {
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
