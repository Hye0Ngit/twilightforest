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

public class BlockTFFireflyJar extends aou
{
    public static lx jarTop;
    public static lx jarSide;
    public static lx jarCork;
    
    protected BlockTFFireflyJar(final int par1) {
        super(par1, ahz.r);
        this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
        this.c(0.3f);
        this.a(aou.g);
        this.a((uy)TFItems.creativeTab);
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
    
    public int getLightValue(final aae world, final int x, final int y, final int z) {
        return 8;
    }
    
    public boolean isBlockNormalCube(final zv world, final int x, final int y, final int z) {
        return false;
    }
    
    public void a(final aae world, final int x, final int y, final int z) {
        this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
    }
    
    public void g() {
        this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
    }
    
    @SideOnly(Side.CLIENT)
    public void b(final zv world, final int x, final int y, final int z, final Random rand) {
        double dx = x + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        double dy = y - 0.1f + (rand.nextFloat() - rand.nextFloat()) * 0.4f;
        double dz = z + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        EntityTFTinyFirefly tinyfly = new EntityTFTinyFirefly(world, dx, dy, dz);
        world.c((mp)tinyfly);
        dx = x + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        dy = y - 0.1f + (rand.nextFloat() - rand.nextFloat()) * 0.4f;
        dz = z + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        tinyfly = new EntityTFTinyFirefly(world, dx, dy, dz);
        world.c((mp)tinyfly);
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        par3List.add(new wg(par1, 1, 0));
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        BlockTFFireflyJar.jarTop = par1IconRegister.a("twilightforest:fireflyjar_top");
        BlockTFFireflyJar.jarSide = par1IconRegister.a("twilightforest:fireflyjar_side");
        BlockTFFireflyJar.jarCork = par1IconRegister.a("twilightforest:fireflyjar_cork");
    }
}
