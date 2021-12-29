// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.common.EnumPlantType;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import java.util.ArrayList;
import net.minecraft.world.EnumSkyBlock;
import java.util.Random;
import twilightforest.TwilightForestMod;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.ColorizerFoliage;
import net.minecraftforge.common.IPlantable;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.ColorizerGrass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.IShearable;
import net.minecraft.block.BlockBush;

public class BlockTFPlant extends BlockBush implements IShearable
{
    boolean[] isGrassColor;
    int[] field_149784_t;
    private IIcon[] icons;
    private String[] iconNames;
    public static IIcon mayappleSide;
    public static final int META_MOSSPATCH = 3;
    public static final int META_MAYAPPLE = 4;
    public static final int META_CLOVERPATCH = 5;
    public static final int META_FIDDLEHEAD = 8;
    public static final int META_MUSHGLOOM = 9;
    public static final int META_FORESTGRASS = 10;
    public static final int META_DEADBUSH = 11;
    public static final int META_TORCHBERRY = 13;
    public static final int META_ROOT_STRAND = 14;
    
    protected BlockTFPlant() {
        super(Material.field_151585_k);
        this.isGrassColor = new boolean[] { false, false, false, false, true, true, false, false, true, false, true, false, false, false, false, false };
        this.field_149784_t = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 8, 0, 0 };
        this.iconNames = new String[] { null, null, null, "mosspatch", "mayapple", "cloverpatch", null, null, "fiddlehead", "mushgloom", null, null, null, "torchberry", "rootstrand", null };
        this.func_149675_a(true);
        final float var3 = 0.4f;
        this.func_149676_a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 0.8f, 0.5f + var3);
        this.func_149711_c(0.0f);
        this.func_149672_a(Block.field_149779_h);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public IIcon func_149691_a(final int side, final int metadata) {
        return this.icons[metadata];
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.icons = new IIcon[this.iconNames.length];
        for (int i = 0; i < this.icons.length; ++i) {
            if (this.iconNames[i] != null) {
                this.icons[i] = par1IconRegister.func_94245_a("TwilightForest:" + this.iconNames[i]);
            }
        }
        this.icons[10] = Blocks.field_150329_H.func_149691_a(2, 1);
        this.icons[11] = Blocks.field_150330_I.func_149733_h(2);
        BlockTFPlant.mayappleSide = par1IconRegister.func_94245_a("TwilightForest:mayapple_side");
    }
    
    public int func_149635_D() {
        final double var1 = 0.5;
        final double var2 = 1.0;
        return ColorizerGrass.func_77480_a(var1, var2);
    }
    
    public void func_149726_b(final World world, final int i, final int j, final int k) {
        world.func_147464_a(i, j, k, (Block)this, world.field_73012_v.nextInt(50) + 20);
    }
    
    public boolean func_149705_a(final World par1World, final int x, final int y, final int z, final int par5, final ItemStack par6ItemStack) {
        final Block blockAt = par1World.func_147439_a(x, y, z);
        return (blockAt == Blocks.field_150350_a || blockAt.func_149688_o().func_76222_j()) && this.canBlockStay(par1World, x, y, z, par6ItemStack.func_77960_j());
    }
    
    public boolean func_149718_j(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        return this.canBlockStay(world, x, y, z, meta);
    }
    
    public boolean canBlockStay(final World world, final int x, final int y, final int z, final int meta) {
        final Block soil = world.func_147439_a(x, y - 1, z);
        switch (meta) {
            case 13:
            case 14: {
                return canPlaceRootBelow(world, x, y + 1, z);
            }
            case 0:
            case 10:
            case 11: {
                return soil != null && soil.canSustainPlant((IBlockAccess)world, x, y - 1, z, ForgeDirection.UP, (IPlantable)this);
            }
            case 3:
            case 9: {
                return soil != null && soil.isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.UP);
            }
            default: {
                return (world.func_72883_k(x, y, z) >= 3 || world.func_72937_j(x, y, z)) && soil != null && soil.canSustainPlant((IBlockAccess)world, x, y - 1, z, ForgeDirection.UP, (IPlantable)this);
            }
        }
    }
    
    public void func_149719_a(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.func_72805_g(x, y, z);
        if (meta == 3) {
            long seed = (long)(x * 3129871) ^ y * 116129781L ^ (long)z;
            seed = seed * seed * 42317861L + seed * 11L;
            final int xOff0 = (int)(seed >> 12 & 0x3L);
            final int xOff2 = (int)(seed >> 15 & 0x3L);
            final int zOff0 = (int)(seed >> 18 & 0x3L);
            final int zOff2 = (int)(seed >> 21 & 0x3L);
            final boolean xConnect0 = par1IBlockAccess.func_147439_a(x + 1, y, z) == this && par1IBlockAccess.func_72805_g(x + 1, y, z) == 3;
            final boolean xConnect2 = par1IBlockAccess.func_147439_a(x - 1, y, z) == this && par1IBlockAccess.func_72805_g(x - 1, y, z) == 3;
            final boolean zConnect0 = par1IBlockAccess.func_147439_a(x, y, z + 1) == this && par1IBlockAccess.func_72805_g(x, y, z + 1) == 3;
            final boolean zConnect2 = par1IBlockAccess.func_147439_a(x, y, z - 1) == this && par1IBlockAccess.func_72805_g(x, y, z - 1) == 3;
            this.func_149676_a(xConnect2 ? 0.0f : ((1.0f + xOff2) / 16.0f), 0.0f, zConnect2 ? 0.0f : ((1.0f + zOff2) / 16.0f), xConnect0 ? 1.0f : ((15.0f - xOff0) / 16.0f), 0.0625f, zConnect0 ? 1.0f : ((15.0f - zOff0) / 16.0f));
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
            final boolean xConnect3 = par1IBlockAccess.func_147439_a(x + 1, y, z) == this && par1IBlockAccess.func_72805_g(x + 1, y, z) == 5;
            final boolean xConnect4 = par1IBlockAccess.func_147439_a(x - 1, y, z) == this && par1IBlockAccess.func_72805_g(x - 1, y, z) == 5;
            final boolean zConnect3 = par1IBlockAccess.func_147439_a(x, y, z + 1) == this && par1IBlockAccess.func_72805_g(x, y, z + 1) == 5;
            final boolean zConnect4 = par1IBlockAccess.func_147439_a(x, y, z - 1) == this && par1IBlockAccess.func_72805_g(x, y, z - 1) == 5;
            this.func_149676_a(xConnect4 ? 0.0f : ((1.0f + xOff2) / 16.0f), 0.0f, zConnect4 ? 0.0f : ((1.0f + zOff2) / 16.0f), xConnect3 ? 1.0f : ((15.0f - xOff0) / 16.0f), (1.0f + yOff0 + yOff2) / 16.0f, zConnect3 ? 1.0f : ((15.0f - zOff0) / 16.0f));
        }
        else if (meta == 4) {
            this.func_149676_a(0.25f, 0.0f, 0.25f, 0.8125f, 0.375f, 0.8125f);
        }
        else {
            this.func_149676_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    public int func_149741_i(final int par1) {
        return this.isGrassColor[par1] ? ColorizerFoliage.func_77468_c() : 16777215;
    }
    
    public int func_149720_d(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.func_72805_g(x, y, z);
        return this.isGrassColor[meta] ? par1IBlockAccess.func_72807_a(x, z).func_150558_b(x, y, z) : 16777215;
    }
    
    public AxisAlignedBB func_149668_a(final World par1World, final int x, final int y, final int z) {
        par1World.func_72805_g(x, y, z);
        return null;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public int func_149645_b() {
        return TwilightForestMod.proxy.getPlantBlockRenderID();
    }
    
    public void func_149674_a(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (par1World.func_72957_l(x, y, z) < this.field_149784_t[meta]) {
            par1World.func_147463_c(EnumSkyBlock.Block, x, y, z);
        }
    }
    
    public int getLightValue(final IBlockAccess world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        return this.field_149784_t[meta];
    }
    
    public static boolean canPlaceRootBelow(final World world, final int x, final int y, final int z) {
        final Block blockID = world.func_147439_a(x, y, z);
        if (blockID != null && (blockID.func_149688_o() == Material.field_151578_c || blockID.func_149688_o() == Material.field_151577_b)) {
            return true;
        }
        final int blockMeta = world.func_72805_g(x, y, z);
        return (blockID == TFBlocks.plant && blockMeta == 14) || (blockID == TFBlocks.root && blockMeta == 0);
    }
    
    public ArrayList<ItemStack> getDrops(final World world, final int x, final int y, final int z, final int meta, final int fortune) {
        final ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        switch (meta) {
            case 13: {
                ret.add(new ItemStack(TFItems.torchberries));
                break;
            }
            case 3:
            case 4:
            case 5:
            case 10:
            case 11:
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
    
    public int func_149692_a(final int par1) {
        return par1;
    }
    
    public boolean isShearable(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public ArrayList<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z, final int fortune) {
        final ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack((Block)this, 1, world.func_72805_g(x, y, z)));
        return ret;
    }
    
    public void func_149636_a(final World world, final EntityPlayer player, final int x, final int y, final int z, final int meta) {
        if (world.field_72995_K || player.func_71045_bC() == null || player.func_71045_bC().func_77973_b() != Items.field_151097_aZ) {
            super.func_149636_a(world, player, x, y, z, meta);
        }
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack((Block)this, 1, 3));
        par3List.add(new ItemStack((Block)this, 1, 4));
        par3List.add(new ItemStack((Block)this, 1, 8));
        par3List.add(new ItemStack((Block)this, 1, 9));
        par3List.add(new ItemStack((Block)this, 1, 10));
        par3List.add(new ItemStack((Block)this, 1, 11));
        par3List.add(new ItemStack((Block)this, 1, 13));
        par3List.add(new ItemStack((Block)this, 1, 14));
    }
    
    public void func_149683_g() {
        this.func_149676_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public EnumPlantType getPlantType(final IBlockAccess world, final int x, final int y, final int z) {
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
    
    public Block getPlant(final IBlockAccess world, final int x, final int y, final int z) {
        return (Block)this;
    }
    
    public int getPlantMetadata(final IBlockAccess world, final int x, final int y, final int z) {
        return world.func_72805_g(x, y, z);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149734_b(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        super.func_149734_b(par1World, x, y, z, par5Random);
        final int meta = par1World.func_72805_g(x, y, z);
        if (meta == 3 && par5Random.nextInt(10) == 0) {
            par1World.func_72869_a("townaura", (double)(x + par5Random.nextFloat()), (double)(y + 0.1f), (double)(z + par5Random.nextFloat()), 0.0, 0.0, 0.0);
        }
    }
}
