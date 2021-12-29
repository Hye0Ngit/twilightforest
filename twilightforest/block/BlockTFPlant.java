// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.common.EnumPlantType;
import java.util.List;
import java.util.ArrayList;
import net.minecraft.world.EnumSkyBlock;
import java.util.Random;
import twilightforest.TwilightForestMod;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ForgeDirection;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.ColorizerGrass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraftforge.common.IShearable;
import net.minecraft.block.BlockFlower;

public class BlockTFPlant extends BlockFlower implements IShearable
{
    boolean[] isGrassColor;
    int[] lightValue;
    private Icon[] icons;
    private String[] iconNames;
    public static Icon mayappleSide;
    public static final int META_MOSSPATCH = 3;
    public static final int META_MAYAPPLE = 4;
    public static final int META_CLOVERPATCH = 5;
    public static final int META_FIDDLEHEAD = 8;
    public static final int META_MUSHGLOOM = 9;
    public static final int META_TORCHBERRY = 13;
    public static final int META_ROOT_STRAND = 14;
    
    protected BlockTFPlant(final int par1) {
        super(par1, Material.field_76254_j);
        this.isGrassColor = new boolean[] { false, false, false, false, true, true, false, false, true, false, false, true, false, false, false, false };
        this.lightValue = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 8, 5, 0, 8, 0, 0 };
        this.iconNames = new String[] { null, null, null, "mosspatch", "mayapple", "cloverpatch", null, null, "fiddlehead", "mushgloom", null, null, null, "torchberry", "rootstrand", null };
        this.func_71907_b(true);
        final float var3 = 0.4f;
        this.func_71905_a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 0.8f, 0.5f + var3);
        this.func_71848_c(0.0f);
        this.func_71884_a(Block.field_71965_g);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public Icon func_71858_a(final int side, final int metadata) {
        return this.icons[metadata];
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        this.icons = new Icon[this.iconNames.length];
        for (int i = 0; i < this.icons.length; ++i) {
            if (this.iconNames[i] != null) {
                this.icons[i] = par1IconRegister.func_94245_a("twilightforest:" + this.iconNames[i]);
            }
        }
        BlockTFPlant.mayappleSide = par1IconRegister.func_94245_a("twilightforest:mayapple_side");
    }
    
    public int func_71933_m() {
        final double var1 = 0.5;
        final double var2 = 1.0;
        return ColorizerGrass.func_77480_a(var1, var2);
    }
    
    public void func_71861_g(final World world, final int i, final int j, final int k) {
        super.func_71861_g(world, i, j, k);
        world.func_72836_a(i, j, k, this.field_71990_ca, world.field_73012_v.nextInt(50) + 20);
    }
    
    public boolean func_94331_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final ItemStack par6ItemStack) {
        final int blockAt = par1World.func_72798_a(par2, par3, par4);
        return (blockAt == 0 || BlockTFPlant.field_71973_m[blockAt].field_72018_cp.func_76222_j()) && this.canBlockStay(par1World, par2, par3, par4, par6ItemStack.func_77960_j());
    }
    
    public boolean func_71854_d(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        return this.canBlockStay(world, x, y, z, meta);
    }
    
    public boolean canBlockStay(final World world, final int x, final int y, final int z, final int meta) {
        final Block soil = BlockTFPlant.field_71973_m[world.func_72798_a(x, y - 1, z)];
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
                return (world.func_72883_k(x, y, z) >= 3 || world.func_72937_j(x, y, z)) && soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (IPlantable)this);
            }
        }
    }
    
    public void func_71902_a(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.func_72805_g(x, y, z);
        if (meta == 3) {
            long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
            seed = seed * seed * 42317861L + seed * 11L;
            final int xOff0 = (int)(seed >> 12 & 0x3L);
            final int xOff2 = (int)(seed >> 15 & 0x3L);
            final int zOff0 = (int)(seed >> 18 & 0x3L);
            final int zOff2 = (int)(seed >> 21 & 0x3L);
            final int yOff0 = (int)(seed >> 24 & 0x1L);
            final int yOff2 = (int)(seed >> 27 & 0x1L);
            final boolean xConnect0 = par1IBlockAccess.func_72798_a(x + 1, y, z) == this.field_71990_ca && par1IBlockAccess.func_72805_g(x + 1, y, z) == 3;
            final boolean xConnect2 = par1IBlockAccess.func_72798_a(x - 1, y, z) == this.field_71990_ca && par1IBlockAccess.func_72805_g(x - 1, y, z) == 3;
            final boolean zConnect0 = par1IBlockAccess.func_72798_a(x, y, z + 1) == this.field_71990_ca && par1IBlockAccess.func_72805_g(x, y, z + 1) == 3;
            final boolean zConnect2 = par1IBlockAccess.func_72798_a(x, y, z - 1) == this.field_71990_ca && par1IBlockAccess.func_72805_g(x, y, z - 1) == 3;
            this.func_71905_a(xConnect2 ? 0.0f : ((1.0f + xOff2) / 16.0f), 0.0f, zConnect2 ? 0.0f : ((1.0f + zOff2) / 16.0f), xConnect0 ? 1.0f : ((15.0f - xOff0) / 16.0f), 0.0625f, zConnect0 ? 1.0f : ((15.0f - zOff0) / 16.0f));
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
            final boolean xConnect0 = par1IBlockAccess.func_72798_a(x + 1, y, z) == this.field_71990_ca && par1IBlockAccess.func_72805_g(x + 1, y, z) == 5;
            final boolean xConnect2 = par1IBlockAccess.func_72798_a(x - 1, y, z) == this.field_71990_ca && par1IBlockAccess.func_72805_g(x - 1, y, z) == 5;
            final boolean zConnect0 = par1IBlockAccess.func_72798_a(x, y, z + 1) == this.field_71990_ca && par1IBlockAccess.func_72805_g(x, y, z + 1) == 5;
            final boolean zConnect2 = par1IBlockAccess.func_72798_a(x, y, z - 1) == this.field_71990_ca && par1IBlockAccess.func_72805_g(x, y, z - 1) == 5;
            this.func_71905_a(xConnect2 ? 0.0f : ((1.0f + xOff2) / 16.0f), 0.0f, zConnect2 ? 0.0f : ((1.0f + zOff2) / 16.0f), xConnect0 ? 1.0f : ((15.0f - xOff0) / 16.0f), (1.0f + yOff0 + yOff2) / 16.0f, zConnect0 ? 1.0f : ((15.0f - zOff0) / 16.0f));
        }
        else if (meta == 4) {
            this.func_71905_a(0.25f, 0.0f, 0.25f, 0.8125f, 0.375f, 0.8125f);
        }
        else {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    public int func_71889_f_(final int par1) {
        return this.isGrassColor[par1] ? ColorizerFoliage.func_77468_c() : 16777215;
    }
    
    public int func_71920_b(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int meta = par1IBlockAccess.func_72805_g(par2, par3, par4);
        return this.isGrassColor[meta] ? par1IBlockAccess.func_72807_a(par2, par4).func_76737_k() : 16777215;
    }
    
    public AxisAlignedBB func_71872_e(final World par1World, final int x, final int y, final int z) {
        final int meta = par1World.func_72805_g(x, y, z);
        return null;
    }
    
    public boolean func_71926_d() {
        return false;
    }
    
    public boolean func_71886_c() {
        return false;
    }
    
    public int func_71857_b() {
        return TwilightForestMod.proxy.getPlantBlockRenderID();
    }
    
    public void func_71847_b(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (par1World.func_72957_l(x, y, z) < this.lightValue[meta]) {
            par1World.func_72936_c(EnumSkyBlock.Block, x, y, z);
            par1World.func_72845_h(x, y, z);
        }
    }
    
    public int getLightValue(final IBlockAccess world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        return this.lightValue[meta];
    }
    
    public static boolean canPlaceRootBelow(final World world, final int x, final int y, final int z) {
        final int blockID = world.func_72798_a(x, y, z);
        if (Block.field_71973_m[blockID] != null && (Block.field_71973_m[blockID].field_72018_cp == Material.field_76248_c || Block.field_71973_m[blockID].field_72018_cp == Material.field_76247_b)) {
            return true;
        }
        final int blockMeta = world.func_72805_g(x, y, z);
        return (blockID == TFBlocks.plant.field_71990_ca && blockMeta == 14) || (blockID == TFBlocks.root.field_71990_ca && blockMeta == 0);
    }
    
    public ArrayList getBlockDropped(final World world, final int x, final int y, final int z, final int meta, final int fortune) {
        final ArrayList ret = new ArrayList();
        switch (meta) {
            case 13: {
                ret.add(new ItemStack(TFItems.torchberries));
                break;
            }
            case 3:
            case 4:
            case 5:
            case 14: {
                break;
            }
            default: {
                ret.add(new ItemStack((Block)this, 1, meta));
                break;
            }
        }
        return ret;
    }
    
    public int func_71899_b(final int par1) {
        return par1;
    }
    
    public boolean isShearable(final ItemStack item, final World world, final int x, final int y, final int z) {
        return true;
    }
    
    public ArrayList onSheared(final ItemStack item, final World world, final int x, final int y, final int z, final int fortune) {
        final ArrayList ret = new ArrayList();
        ret.add(new ItemStack((Block)this, 1, world.func_72805_g(x, y, z)));
        world.func_94571_i(x, y, z);
        return ret;
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack((Block)this, 1, 3));
        par3List.add(new ItemStack((Block)this, 1, 4));
        par3List.add(new ItemStack((Block)this, 1, 8));
        par3List.add(new ItemStack((Block)this, 1, 9));
        par3List.add(new ItemStack((Block)this, 1, 13));
        par3List.add(new ItemStack((Block)this, 1, 14));
    }
    
    public void func_71919_f() {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public EnumPlantType getPlantType(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
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
    
    public int getPlantID(final World world, final int x, final int y, final int z) {
        return this.field_71990_ca;
    }
    
    public int getPlantMetadata(final World world, final int x, final int y, final int z) {
        return world.func_72805_g(x, y, z);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_71862_a(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        super.func_71862_a(par1World, x, y, z, par5Random);
        final int meta = par1World.func_72805_g(x, y, z);
        if (meta == 3 && par5Random.nextInt(10) == 0) {
            par1World.func_72869_a("townaura", (double)(x + par5Random.nextFloat()), (double)(y + 0.1f), (double)(z + par5Random.nextFloat()), 0.0, 0.0, 0.0);
        }
    }
}
