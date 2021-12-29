// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFCicada extends BlockTFCritter
{
    public static int sprCicada;
    private Class cicadaEntityClass;
    
    protected BlockTFCicada(final int i) {
        super(i, ls.p);
        this.cicadaEntityClass = TileEntityTFCicada.class;
        this.bN = BlockTFCicada.sprCicada;
    }
    
    public int c() {
        return mod_TwilightForest.cicadaRenderID;
    }
    
    @Override
    protected boolean canPlaceAt(final fq world, final int x, final int y, final int z) {
        return world.e(x, y, z) || world.d(x, y, z) == ls.i;
    }
    
    public ow a_() {
        try {
            return this.cicadaEntityClass.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
    
    static {
        BlockTFCicada.sprCicada = ModLoader.addOverride("/terrain.png", "/twilightforest/blocks/cicada-tiny.png");
    }
}
