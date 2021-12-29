// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Locale;
import net.minecraft.util.IStringSerializable;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockSlab;

public class BlockTFAuroraSlab extends BlockSlab implements ModelRegisterCallback
{
    private static final IProperty<AuroraSlabVariant> VARIANT;
    private final boolean isDouble;
    
    public BlockTFAuroraSlab(final boolean isDouble) {
        super(Material.field_151598_x);
        this.isDouble = isDouble;
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(2.0f);
        this.func_149752_b(10.0f);
        this.func_149713_g(isDouble ? 255 : 0);
        this.field_149783_u = !isDouble;
        IBlockState state = this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFAuroraSlab.VARIANT, (Comparable)AuroraSlabVariant.AURORA);
        if (!this.func_176552_j()) {
            state = state.func_177226_a((IProperty)BlockTFAuroraSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.BOTTOM);
        }
        this.func_180632_j(state);
    }
    
    protected BlockStateContainer func_180661_e() {
        return this.func_176552_j() ? new BlockStateContainer((Block)this, new IProperty[] { BlockTFAuroraSlab.VARIANT }) : new BlockStateContainer((Block)this, new IProperty[] { BlockTFAuroraSlab.VARIANT, (IProperty)BlockTFAuroraSlab.field_176554_a });
    }
    
    public String func_150002_b(final int meta) {
        return super.func_149739_a();
    }
    
    public boolean func_176552_j() {
        return this.isDouble;
    }
    
    public IProperty<?> func_176551_l() {
        return BlockTFAuroraSlab.VARIANT;
    }
    
    public Comparable<?> func_185674_a(final ItemStack stack) {
        return AuroraSlabVariant.AURORA;
    }
    
    public Item func_180660_a(final IBlockState state, final Random rand, final int fortune) {
        return Item.func_150898_a((Block)TFBlocks.aurora_slab);
    }
    
    public ItemStack func_185473_a(final World worldIn, final BlockPos pos, final IBlockState state) {
        return new ItemStack(Item.func_150898_a((Block)TFBlocks.aurora_slab));
    }
    
    protected ItemStack func_180643_i(final IBlockState state) {
        return new ItemStack(Item.func_150898_a((Block)TFBlocks.aurora_slab), this.func_176552_j() ? 2 : 1, 0);
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176552_j() ? this.func_176223_P() : this.func_176223_P().func_177226_a((IProperty)BlockTFAuroraSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.values()[meta % BlockSlab.EnumBlockHalf.values().length]);
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((BlockSlab.EnumBlockHalf)state.func_177229_b((IProperty)BlockTFAuroraSlab.field_176554_a)).ordinal();
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        if (this.func_176552_j()) {
            ModelLoader.setCustomStateMapper((Block)this, (IStateMapper)new StateMap.Builder().func_178442_a(new IProperty[] { BlockTFAuroraSlab.VARIANT, (IProperty)BlockTFAuroraSlab.field_176554_a }).func_178441_a());
        }
        else {
            final IStateMapper stateMapper = (IStateMapper)new StateMap.Builder().func_178442_a(new IProperty[] { BlockTFAuroraSlab.VARIANT }).func_178441_a();
            ModelLoader.setCustomStateMapper((Block)this, stateMapper);
            ModelUtils.registerToState((Block)this, 0, this.func_176223_P(), stateMapper);
        }
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)AuroraSlabVariant.class);
    }
    
    private enum AuroraSlabVariant implements IStringSerializable
    {
        AURORA;
        
        public String func_176610_l() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }
}
