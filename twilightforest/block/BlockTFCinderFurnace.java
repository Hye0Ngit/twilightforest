// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.RayTraceResult;
import net.minecraft.item.Item;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.TwilightForestMod;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import twilightforest.tileentity.TileEntityTFCinderFurnace;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockFurnace;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFCinderFurnace extends Block implements ModelRegisterCallback
{
    private static boolean keepInventory;
    private final boolean isBurning;
    
    BlockTFCinderFurnace(final boolean isLit) {
        super(Material.field_151575_d);
        this.isBurning = isLit;
        this.func_149711_c(7.0f);
        this.func_149715_a(isLit ? 1.0f : 0.0f);
        if (!isLit) {
            this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        }
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockFurnace.field_176447_a, (Comparable)EnumFacing.NORTH));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockFurnace.field_176447_a });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((EnumFacing)state.func_177229_b((IProperty)BlockFurnace.field_176447_a)).func_176736_b();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockFurnace.field_176447_a, (Comparable)EnumFacing.func_176731_b(meta));
    }
    
    public TileEntity createTileEntity(final World world, final IBlockState state) {
        return (TileEntity)new TileEntityTFCinderFurnace();
    }
    
    public boolean func_180639_a(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player, final EnumHand hand, final EnumFacing side, final float hitX, final float hitY, final float hitZ) {
        if (!world.field_72995_K && world.func_175625_s(pos) instanceof TileEntityTFCinderFurnace) {
            player.openGui((Object)TwilightForestMod.instance, 2, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        }
        return true;
    }
    
    public void func_180633_a(final World world, final BlockPos pos, final IBlockState state, final EntityLivingBase placer, final ItemStack itemStack) {
        if (itemStack.func_82837_s()) {
            ((TileEntityFurnace)world.func_175625_s(pos)).func_145951_a(itemStack.func_82833_r());
        }
    }
    
    public static void setState(final boolean active, final World worldIn, final BlockPos pos) {
        final IBlockState iblockstate = worldIn.func_180495_p(pos);
        final TileEntity tileentity = worldIn.func_175625_s(pos);
        BlockTFCinderFurnace.keepInventory = true;
        if (active) {
            worldIn.func_180501_a(pos, TFBlocks.cinder_furnace_lit.func_176223_P().func_177226_a((IProperty)BlockFurnace.field_176447_a, iblockstate.func_177229_b((IProperty)BlockFurnace.field_176447_a)), 3);
        }
        else {
            worldIn.func_180501_a(pos, TFBlocks.cinder_furnace.func_176223_P().func_177226_a((IProperty)BlockFurnace.field_176447_a, iblockstate.func_177229_b((IProperty)BlockFurnace.field_176447_a)), 3);
        }
        BlockTFCinderFurnace.keepInventory = false;
        if (tileentity != null) {
            tileentity.func_145829_t();
            worldIn.func_175690_a(pos, tileentity);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_180655_c(final IBlockState state, final World world, final BlockPos pos, final Random random) {
        if (this.isBurning) {
            Blocks.field_150470_am.func_180655_c(state, world, pos, random);
        }
    }
    
    public void func_180663_b(final World world, final BlockPos pos, final IBlockState state) {
        if (!BlockTFCinderFurnace.keepInventory) {
            final TileEntity tileentity = world.func_175625_s(pos);
            if (tileentity instanceof TileEntityFurnace) {
                InventoryHelper.func_180175_a(world, pos, (IInventory)tileentity);
                world.func_175666_e(pos, (Block)this);
            }
        }
        super.func_180663_b(world, pos, state);
    }
    
    public Item func_180660_a(final IBlockState state, final Random rand, final int fortune) {
        return Item.func_150898_a(TFBlocks.cinder_furnace);
    }
    
    public ItemStack getPickBlock(final IBlockState state, final RayTraceResult target, final World world, final BlockPos pos, final EntityPlayer player) {
        return new ItemStack(Item.func_150898_a(TFBlocks.cinder_furnace));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        if (!this.isBurning) {
            super.registerModel();
        }
    }
}
