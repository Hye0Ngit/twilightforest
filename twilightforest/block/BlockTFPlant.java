// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;
import net.minecraftforge.common.IShearable;

public class BlockTFPlant extends aje implements IShearable
{
    boolean[] isGrassColor;
    int[] lightValue;
    static int texRottenRight;
    static int texRottenLeft;
    public static final int TORCHBERRY_META = 13;
    public static final int ROOT_STRAND_META = 14;
    
    protected BlockTFPlant(final int par1) {
        super(par1, 16, agi.k);
        this.isGrassColor = new boolean[] { false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false };
        this.lightValue = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 8, 5, 0, 8, 0, 0 };
        this.cl = 16;
        this.b(true);
        final float var3 = 0.4f;
        this.a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 0.8f, 0.5f + var3);
        this.c(0.0f);
        this.a(amq.g);
        this.a((tj)TFItems.creativeTab);
    }
    
    public int a(final int par1, final int par2) {
        return 16 + par2;
    }
    
    public int o() {
        final double var1 = 0.5;
        final double var2 = 1.0;
        return yb.a(var1, var2);
    }
    
    public void g(final yc world, final int i, final int j, final int k) {
        super.g(world, i, j, k);
        world.a(i, j, k, this.cm, world.t.nextInt(50) + 20);
    }
    
    public boolean d(final yc world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        return this.canBlockStay(world, x, y, z, meta);
    }
    
    public boolean canBlockStay(final yc world, final int x, final int y, final int z, final int meta) {
        switch (meta) {
            case 13:
            case 14: {
                return canPlaceRootBelow(world, x, y + 1, z);
            }
            case 15: {
                return world.a(x + 1, y, z) == TFBlocks.log.cm || world.a(x - 1, y, z) == TFBlocks.log.cm || world.a(x, y + 1, z) == TFBlocks.log.cm || world.a(x, y - 1, z) == TFBlocks.log.cm || world.a(x, y, z + 1) == TFBlocks.log.cm || world.a(x, y, z - 1) == TFBlocks.log.cm;
            }
            default: {
                return this.d_(world.a(x, y - 1, z));
            }
        }
    }
    
    protected boolean d_(final int underBlock) {
        return underBlock == amq.x.cm || underBlock == amq.y.cm || underBlock == amq.aD.cm;
    }
    
    public int g_(final int par1) {
        return this.isGrassColor[par1] ? xy.c() : 16777215;
    }
    
    public int b(final ym par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int meta = par1IBlockAccess.h(par2, par3, par4);
        return this.isGrassColor[meta] ? par1IBlockAccess.a(par2, par4).k() : 16777215;
    }
    
    public aoe e(final yc par1World, final int x, final int y, final int z) {
        final int meta = par1World.h(x, y, z);
        switch (meta) {
            case 15: {
                return aoe.a().a(x + 0.0625, y + 0.0625, z + 0.0625, x + 0.9375, y + 0.9375, z + 0.9375);
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
    
    public void b(final yc par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.h(x, y, z);
        if (par1World.m(x, y, z) < this.lightValue[meta]) {
            par1World.c(yo.b, x, y, z);
            par1World.i(x, y, z);
        }
    }
    
    public int getLightValue(final ym world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        return this.lightValue[meta];
    }
    
    public static boolean canPlaceRootBelow(final yc world, final int x, final int y, final int z) {
        final int blockID = world.a(x, y, z);
        if (amq.p[blockID] != null && (amq.p[blockID].cB == agi.c || amq.p[blockID].cB == agi.b)) {
            return true;
        }
        final int blockMeta = world.h(x, y, z);
        return (blockID == TFBlocks.plant.cm && blockMeta == 14) || (blockID == TFBlocks.root.cm && blockMeta == 0);
    }
    
    public ArrayList getBlockDropped(final yc world, final int x, final int y, final int z, final int meta, final int fortune) {
        final ArrayList ret = new ArrayList();
        switch (meta) {
            case 13: {
                ret.add(new ur(TFItems.torchberries));
                break;
            }
            case 14: {
                break;
            }
            default: {
                ret.add(new ur((amq)this, 1, meta));
                break;
            }
        }
        return ret;
    }
    
    public boolean isShearable(final ur item, final yc world, final int x, final int y, final int z) {
        return true;
    }
    
    public ArrayList onSheared(final ur item, final yc world, final int x, final int y, final int z, final int fortune) {
        final ArrayList ret = new ArrayList();
        ret.add(new ur((amq)this, 1, world.h(x, y, z)));
        world.b(x, y, z, 0);
        return ret;
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        par3List.add(new ur((amq)this, 1, 8));
        par3List.add(new ur((amq)this, 1, 9));
        par3List.add(new ur((amq)this, 1, 13));
        par3List.add(new ur((amq)this, 1, 14));
    }
    
    public void f() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    static {
        BlockTFPlant.texRottenRight = 31;
        BlockTFPlant.texRottenLeft = 47;
    }
}
