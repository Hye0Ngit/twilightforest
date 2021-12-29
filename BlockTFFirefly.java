import java.util.ArrayList;
import java.util.Random;
import forge.ITextureProvider;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFFirefly extends BlockTFCritter implements ITextureProvider
{
    public static int sprFirefly;
    private Class fireflyEntityClass;
    
    protected BlockTFFirefly(final int i) {
        super(i, na.p);
        this.fireflyEntityClass = TileEntityTFFirefly.class;
        this.bN = BlockTFFirefly.sprFirefly;
    }
    
    @Override
    public boolean a() {
        return false;
    }
    
    @Override
    public boolean b() {
        return false;
    }
    
    public int c() {
        return mod_TwilightForest.fireflyRenderID;
    }
    
    @Override
    public void e(final ge world, final int i, final int j, final int k, final int l) {
        super.e(world, i, j, k, l);
        world.c(i, j, k, this.bO, this.d());
    }
    
    @Override
    public void a(final ge world, final int i, final int j, final int k) {
        super.a(world, i, j, k);
        world.c(i, j, k, this.bO, this.d());
    }
    
    public void a(final ge world, final int x, final int y, final int z, final Random random) {
        if (world.n(x, y, z) < 12) {
            world.b(fe.b, x, y, z);
            world.c(x, y, z, this.bO, this.d());
        }
    }
    
    public boolean canPlaceAt(final ge world, final int x, final int y, final int z) {
        return world.e(x, y, z) || world.d(x, y, z) == na.i || world.d(x, y, z) == na.x;
    }
    
    public qj a_() {
        try {
            return this.fireflyEntityClass.newInstance();
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
        BlockTFFirefly.sprFirefly = 4;
    }
}
