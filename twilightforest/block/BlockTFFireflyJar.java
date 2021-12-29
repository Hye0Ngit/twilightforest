// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.entity.EntityTFTinyFirefly;
import java.util.Random;
import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;

public class BlockTFFireflyJar extends amq
{
    public static int jarTop;
    public static int jarSide;
    public static int jarLid;
    
    protected BlockTFFireflyJar(final int par1) {
        super(par1, BlockTFFireflyJar.jarSide, agi.r);
        this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
        this.c(0.3f);
        this.a(amq.e);
        this.a((tj)TFItems.creativeTab);
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
    
    public int getLightValue(final ym world, final int x, final int y, final int z) {
        return 8;
    }
    
    public boolean isBlockNormalCube(final yc world, final int x, final int y, final int z) {
        return false;
    }
    
    public void a(final ym world, final int x, final int y, final int z) {
        this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
    }
    
    public void f() {
        this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final yc world, final int x, final int y, final int z, final Random rand) {
        double dx = x + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        double dy = y - 0.1f + (rand.nextFloat() - rand.nextFloat()) * 0.4f;
        double dz = z + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        EntityTFTinyFirefly tinyfly = new EntityTFTinyFirefly(world, dx, dy, dz);
        world.c((lq)tinyfly);
        dx = x + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        dy = y - 0.1f + (rand.nextFloat() - rand.nextFloat()) * 0.4f;
        dz = z + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        tinyfly = new EntityTFTinyFirefly(world, dx, dy, dz);
        world.c((lq)tinyfly);
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        par3List.add(new ur(par1, 1, 0));
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
