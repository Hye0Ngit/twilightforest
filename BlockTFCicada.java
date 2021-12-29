import java.util.ArrayList;
import forge.ITextureProvider;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFCicada extends BlockTFCritter implements ITextureProvider
{
    public static int sprCicada;
    private Class cicadaEntityClass;
    
    protected BlockTFCicada(final int i) {
        super(i, na.p);
        this.cicadaEntityClass = TileEntityTFCicada.class;
        this.bN = BlockTFCicada.sprCicada;
    }
    
    public int c() {
        return mod_TwilightForest.cicadaRenderID;
    }
    
    @Override
    protected boolean canPlaceAt(final ge world, final int x, final int y, final int z) {
        return world.e(x, y, z) || world.d(x, y, z) == na.i;
    }
    
    public qj a_() {
        try {
            return this.cicadaEntityClass.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new kp((vz)this));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    static {
        BlockTFCicada.sprCicada = 5;
    }
}
