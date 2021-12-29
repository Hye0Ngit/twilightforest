// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import twilightforest.TwilightForestMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;
import net.minecraftforge.common.IShearable;

public class BlockTFPlant extends alb implements IShearable
{
    boolean[] isGrassColor;
    int[] lightValue;
    private lx[] icons;
    private String[] iconNames;
    static int texRottenRight;
    static int texRottenLeft;
    public static final int TORCHBERRY_META = 13;
    public static final int ROOT_STRAND_META = 14;
    
    protected BlockTFPlant(final int par1) {
        super(par1, ahz.k);
        this.isGrassColor = new boolean[] { false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false };
        this.lightValue = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 8, 5, 0, 8, 0, 0 };
        this.iconNames = new String[] { null, null, null, null, null, null, null, null, "fiddlehead", "mushgloom", null, null, null, "torchberry", "rootstrand", null };
        this.b(true);
        final float var3 = 0.4f;
        this.a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 0.8f, 0.5f + var3);
        this.c(0.0f);
        this.a(aou.i);
        this.a((uy)TFItems.creativeTab);
    }
    
    public lx a(final int side, final int metadata) {
        return this.icons[metadata];
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.icons = new lx[this.iconNames.length];
        for (int i = 0; i < this.icons.length; ++i) {
            if (this.iconNames[i] != null) {
                this.icons[i] = par1IconRegister.a("twilightforest:" + this.iconNames[i]);
            }
        }
    }
    
    public int o() {
        final double var1 = 0.5;
        final double var2 = 1.0;
        return zu.a(var1, var2);
    }
    
    public void a(final zv world, final int i, final int j, final int k) {
        super.a(world, i, j, k);
        world.a(i, j, k, this.cz, world.s.nextInt(50) + 20);
    }
    
    public boolean f(final zv world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        return this.canBlockStay(world, x, y, z, meta);
    }
    
    public boolean canBlockStay(final zv world, final int x, final int y, final int z, final int meta) {
        switch (meta) {
            case 13:
            case 14: {
                return canPlaceRootBelow(world, x, y + 1, z);
            }
            case 15: {
                return world.a(x + 1, y, z) == TFBlocks.log.cz || world.a(x - 1, y, z) == TFBlocks.log.cz || world.a(x, y + 1, z) == TFBlocks.log.cz || world.a(x, y - 1, z) == TFBlocks.log.cz || world.a(x, y, z + 1) == TFBlocks.log.cz || world.a(x, y, z - 1) == TFBlocks.log.cz;
            }
            default: {
                return this.f_(world.a(x, y - 1, z));
            }
        }
    }
    
    protected boolean f_(final int underBlock) {
        return underBlock == aou.y.cz || underBlock == aou.z.cz || underBlock == aou.aE.cz;
    }
    
    public int b(final int par1) {
        return this.isGrassColor[par1] ? zr.c() : 16777215;
    }
    
    public int c(final aae par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int meta = par1IBlockAccess.h(par2, par3, par4);
        return this.isGrassColor[meta] ? par1IBlockAccess.a(par2, par4).k() : 16777215;
    }
    
    public aqr b(final zv par1World, final int x, final int y, final int z) {
        final int meta = par1World.h(x, y, z);
        switch (meta) {
            case 15: {
                return aqr.a().a(x + 0.0625, y + 0.0625, z + 0.0625, x + 0.9375, y + 0.9375, z + 0.9375);
            }
            default: {
                return null;
            }
        }
    }
    
    public boolean c() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public int d() {
        return TwilightForestMod.proxy.getPlantBlockRenderID();
    }
    
    public void a(final zv par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.h(x, y, z);
        if (par1World.n(x, y, z) < this.lightValue[meta]) {
            par1World.c(aag.b, x, y, z);
            par1World.j(x, y, z);
        }
    }
    
    public int getLightValue(final aae world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        return this.lightValue[meta];
    }
    
    public static boolean canPlaceRootBelow(final zv world, final int x, final int y, final int z) {
        final int blockID = world.a(x, y, z);
        if (aou.r[blockID] != null && (aou.r[blockID].cO == ahz.c || aou.r[blockID].cO == ahz.b)) {
            return true;
        }
        final int blockMeta = world.h(x, y, z);
        return (blockID == TFBlocks.plant.cz && blockMeta == 14) || (blockID == TFBlocks.root.cz && blockMeta == 0);
    }
    
    public ArrayList getBlockDropped(final zv world, final int x, final int y, final int z, final int meta, final int fortune) {
        final ArrayList ret = new ArrayList();
        switch (meta) {
            case 13: {
                ret.add(new wg(TFItems.torchberries));
                break;
            }
            case 14: {
                break;
            }
            default: {
                ret.add(new wg((aou)this, 1, meta));
                break;
            }
        }
        return ret;
    }
    
    public int a(final int par1) {
        return par1;
    }
    
    public boolean isShearable(final wg item, final zv world, final int x, final int y, final int z) {
        return true;
    }
    
    public ArrayList onSheared(final wg item, final zv world, final int x, final int y, final int z, final int fortune) {
        final ArrayList ret = new ArrayList();
        ret.add(new wg((aou)this, 1, world.h(x, y, z)));
        world.f(x, y, z, 0, 0, 4);
        return ret;
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        par3List.add(new wg((aou)this, 1, 8));
        par3List.add(new wg((aou)this, 1, 9));
        par3List.add(new wg((aou)this, 1, 13));
        par3List.add(new wg((aou)this, 1, 14));
    }
    
    public void g() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    static {
        BlockTFPlant.texRottenRight = 31;
        BlockTFPlant.texRottenLeft = 47;
    }
}
