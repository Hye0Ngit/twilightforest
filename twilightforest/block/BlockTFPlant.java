// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.common.EnumPlantType;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import twilightforest.TwilightForestMod;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;
import net.minecraftforge.common.IShearable;

public class BlockTFPlant extends anb implements IShearable
{
    boolean[] isGrassColor;
    int[] w;
    private mr[] icons;
    private String[] iconNames;
    public static mr mayappleSide;
    public static final int META_MOSSPATCH = 3;
    public static final int META_MAYAPPLE = 4;
    public static final int META_CLOVERPATCH = 5;
    public static final int META_FIDDLEHEAD = 8;
    public static final int META_MUSHGLOOM = 9;
    public static final int META_TORCHBERRY = 13;
    public static final int META_ROOT_STRAND = 14;
    
    protected BlockTFPlant(final int par1) {
        super(par1, ajz.k);
        this.isGrassColor = new boolean[] { false, false, false, false, true, true, false, false, true, false, false, true, false, false, false, false };
        this.w = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 8, 5, 0, 8, 0, 0 };
        this.iconNames = new String[] { null, null, null, "mosspatch", "mayapple", "cloverpatch", null, null, "fiddlehead", "mushgloom", null, null, null, "torchberry", "rootstrand", null };
        this.b(true);
        final float var3 = 0.4f;
        this.a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 0.8f, 0.5f + var3);
        this.c(0.0f);
        this.a(aqw.j);
        this.a((wv)TFItems.creativeTab);
    }
    
    public mr a(final int side, final int metadata) {
        return this.icons[metadata];
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.icons = new mr[this.iconNames.length];
        for (int i = 0; i < this.icons.length; ++i) {
            if (this.iconNames[i] != null) {
                this.icons[i] = par1IconRegister.a("TwilightForest:" + this.iconNames[i]);
            }
        }
        BlockTFPlant.mayappleSide = par1IconRegister.a("TwilightForest:mayapple_side");
    }
    
    public int o() {
        final double var1 = 0.5;
        final double var2 = 1.0;
        return abu.a(var1, var2);
    }
    
    public void a(final abv world, final int i, final int j, final int k) {
        super.a(world, i, j, k);
        world.a(i, j, k, this.cF, world.s.nextInt(50) + 20);
    }
    
    public boolean a(final abv par1World, final int par2, final int par3, final int par4, final int par5, final yd par6ItemStack) {
        final int blockAt = par1World.a(par2, par3, par4);
        return (blockAt == 0 || BlockTFPlant.s[blockAt].cU.j()) && this.canBlockStay(par1World, par2, par3, par4, par6ItemStack.k());
    }
    
    public boolean f(final abv world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        return this.canBlockStay(world, x, y, z, meta);
    }
    
    public boolean canBlockStay(final abv world, final int x, final int y, final int z, final int meta) {
        final aqw soil = BlockTFPlant.s[world.a(x, y - 1, z)];
        switch (meta) {
            case 13:
            case 14: {
                return canPlaceRootBelow(world, x, y + 1, z);
            }
            case 3:
            case 9: {
                return soil != null && soil.isBlockSolidOnSide(world, x, y, z, ForgeDirection.UP);
            }
            default: {
                return (world.m(x, y, z) >= 3 || world.l(x, y, z)) && soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (IPlantable)this);
            }
        }
    }
    
    public void a(final ace par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.h(x, y, z);
        if (meta == 3) {
            long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
            seed = seed * seed * 42317861L + seed * 11L;
            final int xOff0 = (int)(seed >> 12 & 0x3L);
            final int xOff2 = (int)(seed >> 15 & 0x3L);
            final int zOff0 = (int)(seed >> 18 & 0x3L);
            final int zOff2 = (int)(seed >> 21 & 0x3L);
            final int yOff0 = (int)(seed >> 24 & 0x1L);
            final int yOff2 = (int)(seed >> 27 & 0x1L);
            final boolean xConnect0 = par1IBlockAccess.a(x + 1, y, z) == this.cF && par1IBlockAccess.h(x + 1, y, z) == 3;
            final boolean xConnect2 = par1IBlockAccess.a(x - 1, y, z) == this.cF && par1IBlockAccess.h(x - 1, y, z) == 3;
            final boolean zConnect0 = par1IBlockAccess.a(x, y, z + 1) == this.cF && par1IBlockAccess.h(x, y, z + 1) == 3;
            final boolean zConnect2 = par1IBlockAccess.a(x, y, z - 1) == this.cF && par1IBlockAccess.h(x, y, z - 1) == 3;
            this.a(xConnect2 ? 0.0f : ((1.0f + xOff2) / 16.0f), 0.0f, zConnect2 ? 0.0f : ((1.0f + zOff2) / 16.0f), xConnect0 ? 1.0f : ((15.0f - xOff0) / 16.0f), 0.0625f, zConnect0 ? 1.0f : ((15.0f - zOff0) / 16.0f));
        }
        else if (meta == 5) {
            long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
            seed = seed * seed * 42317861L + seed * 11L;
            final int xOff0 = (int)(seed >> 12 & 0x3L);
            final int xOff2 = (int)(seed >> 15 & 0x3L);
            final int zOff0 = (int)(seed >> 18 & 0x3L);
            final int zOff2 = (int)(seed >> 21 & 0x3L);
            final int yOff0 = (int)(seed >> 24 & 0x1L);
            final int yOff2 = (int)(seed >> 27 & 0x1L);
            final boolean xConnect0 = par1IBlockAccess.a(x + 1, y, z) == this.cF && par1IBlockAccess.h(x + 1, y, z) == 5;
            final boolean xConnect2 = par1IBlockAccess.a(x - 1, y, z) == this.cF && par1IBlockAccess.h(x - 1, y, z) == 5;
            final boolean zConnect0 = par1IBlockAccess.a(x, y, z + 1) == this.cF && par1IBlockAccess.h(x, y, z + 1) == 5;
            final boolean zConnect2 = par1IBlockAccess.a(x, y, z - 1) == this.cF && par1IBlockAccess.h(x, y, z - 1) == 5;
            this.a(xConnect2 ? 0.0f : ((1.0f + xOff2) / 16.0f), 0.0f, zConnect2 ? 0.0f : ((1.0f + zOff2) / 16.0f), xConnect0 ? 1.0f : ((15.0f - xOff0) / 16.0f), (1.0f + yOff0 + yOff2) / 16.0f, zConnect0 ? 1.0f : ((15.0f - zOff0) / 16.0f));
        }
        else if (meta == 4) {
            this.a(0.25f, 0.0f, 0.25f, 0.8125f, 0.375f, 0.8125f);
        }
        else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    public int b(final int par1) {
        return this.isGrassColor[par1] ? abr.c() : 16777215;
    }
    
    public int c(final ace par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int meta = par1IBlockAccess.h(par2, par3, par4);
        return this.isGrassColor[meta] ? par1IBlockAccess.a(par2, par4).k() : 16777215;
    }
    
    public asu b(final abv par1World, final int x, final int y, final int z) {
        final int meta = par1World.h(x, y, z);
        return null;
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
    
    public void a(final abv par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.h(x, y, z);
        if (par1World.n(x, y, z) < this.w[meta]) {
            par1World.c(acg.b, x, y, z);
            par1World.j(x, y, z);
        }
    }
    
    public int getLightValue(final ace world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        return this.w[meta];
    }
    
    public static boolean canPlaceRootBelow(final abv world, final int x, final int y, final int z) {
        final int blockID = world.a(x, y, z);
        if (aqw.s[blockID] != null && (aqw.s[blockID].cU == ajz.c || aqw.s[blockID].cU == ajz.b)) {
            return true;
        }
        final int blockMeta = world.h(x, y, z);
        return (blockID == TFBlocks.plant.cF && blockMeta == 14) || (blockID == TFBlocks.root.cF && blockMeta == 0);
    }
    
    public ArrayList<yd> getBlockDropped(final abv world, final int x, final int y, final int z, final int meta, final int fortune) {
        final ArrayList<yd> ret = new ArrayList<yd>();
        switch (meta) {
            case 13: {
                ret.add(new yd(TFItems.torchberries));
                break;
            }
            case 3:
            case 4:
            case 5:
            case 14: {
                break;
            }
            default: {
                ret.add(new yd((aqw)this, 1, meta));
                break;
            }
        }
        return ret;
    }
    
    public int a(final int par1) {
        return par1;
    }
    
    public boolean isShearable(final yd item, final abv world, final int x, final int y, final int z) {
        return true;
    }
    
    public ArrayList<yd> onSheared(final yd item, final abv world, final int x, final int y, final int z, final int fortune) {
        final ArrayList<yd> ret = new ArrayList<yd>();
        ret.add(new yd((aqw)this, 1, world.h(x, y, z)));
        world.i(x, y, z);
        return ret;
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd((aqw)this, 1, 3));
        par3List.add(new yd((aqw)this, 1, 4));
        par3List.add(new yd((aqw)this, 1, 8));
        par3List.add(new yd((aqw)this, 1, 9));
        par3List.add(new yd((aqw)this, 1, 13));
        par3List.add(new yd((aqw)this, 1, 14));
    }
    
    public void g() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public EnumPlantType getPlantType(final abv world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        switch (meta) {
            case 3:
            case 9: {
                return EnumPlantType.Cave;
            }
            default: {
                return EnumPlantType.Plains;
            }
        }
    }
    
    public int getPlantID(final abv world, final int x, final int y, final int z) {
        return this.cF;
    }
    
    public int getPlantMetadata(final abv world, final int x, final int y, final int z) {
        return world.h(x, y, z);
    }
    
    @SideOnly(Side.CLIENT)
    public void b(final abv par1World, final int x, final int y, final int z, final Random par5Random) {
        super.b(par1World, x, y, z, par5Random);
        final int meta = par1World.h(x, y, z);
        if (meta == 3 && par5Random.nextInt(10) == 0) {
            par1World.a("townaura", (double)(x + par5Random.nextFloat()), (double)(y + 0.1f), (double)(z + par5Random.nextFloat()), 0.0, 0.0, 0.0);
        }
    }
}
