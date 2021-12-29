// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.SoundType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockSlab;

public abstract class BlockTFSlab<T extends Enum<T>> extends BlockSlab implements ModelRegisterCallback
{
    private final Comparable<T> propertyValue;
    
    BlockTFSlab(final Material material, final MapColor mapColor, final T propertyValue) {
        super(material, mapColor);
        this.propertyValue = propertyValue;
        if (this.func_176552_j()) {
            this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)this.func_176551_l(), (Comparable)propertyValue));
        }
        else {
            this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)this.func_176551_l(), (Comparable)propertyValue).func_177226_a((IProperty)BlockTFSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.BOTTOM));
        }
    }
    
    protected BlockStateContainer func_180661_e() {
        return this.func_176552_j() ? new BlockStateContainer((Block)this, new IProperty[] { this.func_176551_l() }) : new BlockStateContainer((Block)this, new IProperty[] { this.func_176551_l(), (IProperty)BlockTFSlab.field_176554_a });
    }
    
    public Item func_180660_a(final IBlockState state, final Random rand, final int fortune) {
        return Item.func_150898_a(this.getSingle());
    }
    
    public ItemStack func_185473_a(final World worldIn, final BlockPos pos, final IBlockState state) {
        return new ItemStack(Item.func_150898_a(this.getSingle()));
    }
    
    public IBlockState func_176203_a(final int meta) {
        return this.func_176552_j() ? this.func_176223_P() : this.func_176223_P().func_177226_a((IProperty)BlockTFSlab.field_176554_a, (Comparable)((meta == 0) ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP));
    }
    
    public int func_176201_c(final IBlockState state) {
        return (!this.func_176552_j() && state.func_177229_b((IProperty)BlockTFSlab.field_176554_a) != BlockSlab.EnumBlockHalf.BOTTOM) ? 1 : 0;
    }
    
    public String func_150002_b(final int meta) {
        return this.func_149739_a();
    }
    
    public abstract boolean func_176552_j();
    
    public abstract IProperty<T> func_176551_l();
    
    public Comparable<T> func_185674_a(final ItemStack stack) {
        return this.propertyValue;
    }
    
    protected abstract Block getSingle();
    
    public Block func_149672_a(final SoundType sound) {
        return super.func_149672_a(sound);
    }
}
