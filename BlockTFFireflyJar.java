import java.util.ArrayList;
import java.util.Random;
import forge.ITextureProvider;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFFireflyJar extends vz implements ITextureProvider
{
    public static int sprTop;
    public static int sprSide;
    public static int sprLid;
    
    protected BlockTFFireflyJar(final int par1) {
        super(par1, BlockTFFireflyJar.sprSide, na.q);
        this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public int a(final int par1, final int par2) {
        return (par1 == 1 || par1 == 0) ? BlockTFFireflyJar.sprTop : BlockTFFireflyJar.sprSide;
    }
    
    public void f() {
        this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
    }
    
    public void randomDisplayTick(final ge par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        double dx = par2 + (par5Random.nextFloat() - par5Random.nextFloat()) * 0.3f;
        double dy = par3 - 0.1f + (par5Random.nextFloat() - par5Random.nextFloat()) * 0.4f;
        double dz = par4 + (par5Random.nextFloat() - par5Random.nextFloat()) * 0.3f;
        EntityTFTinyFirefly tinyfly = new EntityTFTinyFirefly(par1World, dx, dy, dz);
        par1World.a((tv)tinyfly);
        dx = par2 + (par5Random.nextFloat() - par5Random.nextFloat()) * 0.3f;
        dy = par3 - 0.1f + (par5Random.nextFloat() - par5Random.nextFloat()) * 0.4f;
        dz = par4 + (par5Random.nextFloat() - par5Random.nextFloat()) * 0.3f;
        tinyfly = new EntityTFTinyFirefly(par1World, dx, dy, dz);
        par1World.a((tv)tinyfly);
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new kp((vz)this));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    static {
        BlockTFFireflyJar.sprTop = 7;
        BlockTFFireflyJar.sprSide = 8;
        BlockTFFireflyJar.sprLid = 9;
    }
}
