// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import twilightforest.client.ModelUtils;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import twilightforest.enums.BossVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFBossSpawner extends Block implements ModelRegisterCallback
{
    public static final IProperty<BossVariant> VARIANT;
    
    protected BlockTFBossSpawner() {
        super(Material.field_151576_e);
        this.func_149711_c(20.0f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.NAGA));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFBossSpawner.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((BossVariant)state.func_177229_b((IProperty)BlockTFBossSpawner.VARIANT)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.getVariant(meta));
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        for (final BossVariant variant : BossVariant.values()) {
            if (variant.hasSpawner()) {
                list.add((Object)new ItemStack((Block)this, 1, variant.ordinal()));
            }
        }
    }
    
    public boolean hasTileEntity(final IBlockState state) {
        return ((BossVariant)state.func_177229_b((IProperty)BlockTFBossSpawner.VARIANT)).hasSpawner();
    }
    
    @Nullable
    public TileEntity createTileEntity(final World world, final IBlockState state) {
        return ((BossVariant)state.func_177229_b((IProperty)BlockTFBossSpawner.VARIANT)).getSpawner();
    }
    
    public Item func_180660_a(final IBlockState state, final Random random, final int fortune) {
        return Items.field_190931_a;
    }
    
    public int func_149745_a(final Random random) {
        return 0;
    }
    
    public boolean canEntityDestroy(final IBlockState state, final IBlockAccess world, final BlockPos pos, final Entity entity) {
        return this.field_149782_v >= 0.0f;
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final IStateMapper stateMapper = (IStateMapper)new StateMap.Builder().func_178442_a(new IProperty[] { BlockTFBossSpawner.VARIANT }).func_178441_a();
        ModelLoader.setCustomStateMapper((Block)this, stateMapper);
        ModelUtils.registerToStateSingleVariant(this, BlockTFBossSpawner.VARIANT, stateMapper);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("boss", (Class)BossVariant.class);
    }
}
