// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.init.Blocks;
import twilightforest.world.feature.TFGenSmallTwilightOak;
import twilightforest.world.feature.TFGenSmallRainboak;
import twilightforest.world.feature.TFGenLargeRainboak;
import twilightforest.world.feature.TFGenSortingTree;
import twilightforest.world.feature.TFGenMinersTree;
import twilightforest.world.feature.TFGenTreeOfTransformation;
import twilightforest.world.feature.TFGenTreeOfTime;
import twilightforest.world.feature.TFGenHollowTree;
import twilightforest.world.feature.TFGenDarkCanopyTree;
import twilightforest.world.feature.TFGenMangroveTree;
import twilightforest.world.feature.TFGenCanopyTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.enums.SaplingVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.IGrowable;
import net.minecraft.block.BlockBush;

public class BlockTFSapling extends BlockBush implements IGrowable, ModelRegisterCallback
{
    public static final IProperty<SaplingVariant> TF_TYPE;
    protected static final AxisAlignedBB SAPLING_AABB;
    
    protected BlockTFSapling() {
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149672_a(SoundType.field_185850_c);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFSapling.TF_TYPE, (Comparable)SaplingVariant.OAK));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFSapling.TF_TYPE });
    }
    
    public void func_176474_b(final World world, final Random rand, final BlockPos pos, final IBlockState state) {
        WorldGenerator treeGenerator = null;
        switch ((SaplingVariant)state.func_177229_b((IProperty)BlockTFSapling.TF_TYPE)) {
            case CANOPY: {
                treeGenerator = (WorldGenerator)new TFGenCanopyTree(true);
                break;
            }
            case MANGROVE: {
                treeGenerator = (WorldGenerator)new TFGenMangroveTree(true);
                break;
            }
            case DARKWOOD: {
                treeGenerator = (WorldGenerator)new TFGenDarkCanopyTree(true);
                break;
            }
            case HOLLOW_OAK: {
                treeGenerator = new TFGenHollowTree(true);
                break;
            }
            case TIME: {
                treeGenerator = new TFGenTreeOfTime(true);
                break;
            }
            case TRANSFORMATION: {
                treeGenerator = (WorldGenerator)new TFGenTreeOfTransformation(true);
                break;
            }
            case MINING: {
                treeGenerator = (WorldGenerator)new TFGenMinersTree(true);
                break;
            }
            case SORTING: {
                treeGenerator = new TFGenSortingTree(true);
                break;
            }
            case RAINBOW: {
                treeGenerator = (WorldGenerator)((rand.nextInt(7) == 0) ? new TFGenLargeRainboak(true) : new TFGenSmallRainboak(true));
                break;
            }
            default: {
                treeGenerator = (WorldGenerator)new TFGenSmallTwilightOak(true);
                break;
            }
        }
        world.func_180501_a(pos, Blocks.field_150350_a.func_176223_P(), 4);
        if (!treeGenerator.func_180709_b(world, rand, pos)) {
            world.func_180501_a(pos, state, 4);
        }
    }
    
    public int func_180651_a(final IBlockState state) {
        return this.func_176201_c(state);
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        list.add((Object)new ItemStack((Block)this, 1, 0));
        list.add((Object)new ItemStack((Block)this, 1, 1));
        list.add((Object)new ItemStack((Block)this, 1, 2));
        list.add((Object)new ItemStack((Block)this, 1, 3));
        list.add((Object)new ItemStack((Block)this, 1, 4));
        list.add((Object)new ItemStack((Block)this, 1, 5));
        list.add((Object)new ItemStack((Block)this, 1, 6));
        list.add((Object)new ItemStack((Block)this, 1, 7));
        list.add((Object)new ItemStack((Block)this, 1, 8));
        list.add((Object)new ItemStack((Block)this, 1, 9));
    }
    
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess source, final BlockPos pos) {
        return BlockTFSapling.SAPLING_AABB;
    }
    
    public void func_180650_b(final World worldIn, final BlockPos pos, final IBlockState state, final Random rand) {
        if (!worldIn.field_72995_K) {
            super.func_180650_b(worldIn, pos, state, rand);
            if (worldIn.func_175671_l(pos.func_177984_a()) >= 9 && rand.nextInt(7) == 0) {
                this.func_176474_b(worldIn, rand, pos, state);
            }
        }
    }
    
    public boolean func_176473_a(final World worldIn, final BlockPos pos, final IBlockState state, final boolean isClient) {
        return true;
    }
    
    public boolean func_180670_a(final World worldIn, final Random rand, final BlockPos pos, final IBlockState state) {
        return worldIn.field_73012_v.nextFloat() < 0.45;
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((SaplingVariant)state.func_177229_b((IProperty)BlockTFSapling.TF_TYPE)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFSapling.TF_TYPE, (Comparable)SaplingVariant.values()[meta % SaplingVariant.values().length]);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        for (int i = 0; i < SaplingVariant.values().length; ++i) {
            final String variant = "inventory_" + SaplingVariant.values()[i].func_176610_l();
            final ModelResourceLocation mrl = new ModelResourceLocation(this.getRegistryName(), variant);
            ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), i, mrl);
        }
    }
    
    static {
        TF_TYPE = (IProperty)PropertyEnum.func_177709_a("tf_type", (Class)SaplingVariant.class);
        SAPLING_AABB = new AxisAlignedBB(0.09999999403953552, 0.0, 0.09999999403953552, 0.8999999761581421, 0.800000011920929, 0.8999999761581421);
    }
}
