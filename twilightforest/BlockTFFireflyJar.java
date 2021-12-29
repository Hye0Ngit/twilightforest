// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.Random;

public class BlockTFFireflyJar extends amj
{
    public static int jarTop;
    public static int jarSide;
    public static int jarLid;
    
    protected BlockTFFireflyJar(final int par1) {
        super(par1, BlockTFFireflyJar.jarSide, agb.r);
        this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
        this.c(0.3f);
        this.a(amj.e);
        this.a(th.c);
        this.b(true);
    }
    
    public boolean b() {
        return false;
    }
    
    public boolean c() {
        return false;
    }
    
    public int d() {
        return TwilightForestMod.proxy.getComplexBlockRenderID();
    }
    
    public int a(final int side, final int meta) {
        return (side == 1 || side == 0) ? BlockTFFireflyJar.jarTop : BlockTFFireflyJar.jarSide;
    }
    
    public int getLightValue(final yf world, final int x, final int y, final int z) {
        return 8;
    }
    
    public boolean isBlockNormalCube(final xv world, final int x, final int y, final int z) {
        return false;
    }
    
    public void a(final yf world, final int x, final int y, final int z) {
        this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
    }
    
    public void f() {
        this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final xv world, final int x, final int y, final int z, final Random rand) {
        double dx = x + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
        double dy = y - 0.1f + (rand.nextFloat() - rand.nextFloat()) * 0.4f;
        double dz = z + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
        EntityTFTinyFirefly tinyfly = new EntityTFTinyFirefly(world, dx, dy, dz);
        world.c((lq)tinyfly);
        dx = x + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
        dy = y - 0.1f + (rand.nextFloat() - rand.nextFloat()) * 0.4f;
        dz = z + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
        tinyfly = new EntityTFTinyFirefly(world, dx, dy, dz);
        world.c((lq)tinyfly);
    }
    
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        par3List.add(new um(par1, 1, 0));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    static {
        BlockTFFireflyJar.jarTop = 7;
        BlockTFFireflyJar.jarSide = 8;
        BlockTFFireflyJar.jarLid = 9;
    }
}
