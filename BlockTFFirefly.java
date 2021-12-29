// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFFirefly extends BlockTFCritter
{
    public static int sprFirefly;
    private Class fireflyEntityClass;
    
    protected BlockTFFirefly(final int i) {
        super(i, ls.p);
        this.fireflyEntityClass = TileEntityTFFirefly.class;
        this.bN = BlockTFFirefly.sprFirefly;
    }
    
    @Override
    public boolean a() {
        return false;
    }
    
    public int c() {
        return mod_TwilightForest.fireflyRenderID;
    }
    
    public boolean canPlaceAt(final fq world, final int x, final int y, final int z) {
        return world.e(x, y, z) || world.d(x, y, z) == ls.i || world.d(x, y, z) == ls.w;
    }
    
    public ow a_() {
        try {
            return this.fireflyEntityClass.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
    
    static {
        BlockTFFirefly.sprFirefly = ModLoader.addOverride("/terrain.png", "/twilightforest/blocks/firefly-tiny.png");
    }
}
