// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class BlockTFFrog extends BlockTFCritter
{
    public static int sprFrog;
    private Class frogEntityClass;
    
    protected BlockTFFrog(final int i) {
        super(i);
        this.frogEntityClass = TileEntityTFFirefly.class;
        this.cl = BlockTFFrog.sprFrog;
    }
    
    @Override
    public boolean canPlaceAt(final xv world, final int x, final int y, final int z) {
        return world.t(x, y, z);
    }
    
    public anq getBlockEntity() {
        try {
            return this.frogEntityClass.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
    
    @Override
    public anq createTileEntity(final xv world, final int metadata) {
        return new TileEntityTFFirefly();
    }
    
    static {
        BlockTFFrog.sprFrog = ModLoader.addOverride("/terrain.png", "/twilightforest/blocks/firefly-tiny.png");
    }
}
