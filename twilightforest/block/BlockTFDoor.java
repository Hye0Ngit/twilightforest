// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.init.Items;
import net.minecraft.block.properties.IProperty;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.material.MapColor;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockDoor;

public class BlockTFDoor extends BlockDoor implements ModelRegisterCallback
{
    private final MapColor mapColor;
    private final ResourceLocation itemLocation;
    private Item item;
    
    protected BlockTFDoor(final Material material, final MapColor mapColor, final ResourceLocation itemLocation) {
        super(material);
        this.mapColor = mapColor;
        this.itemLocation = itemLocation;
    }
    
    public Block func_149672_a(final SoundType sound) {
        return super.func_149672_a(sound);
    }
    
    public MapColor func_180659_g(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return this.mapColor;
    }
    
    public Item func_180660_a(final IBlockState state, final Random rand, final int fortune) {
        return (state.func_177229_b((IProperty)BlockTFDoor.field_176523_O) == BlockDoor.EnumDoorHalf.UPPER) ? Items.field_190931_a : this.getItem();
    }
    
    public ItemStack func_185473_a(final World worldIn, final BlockPos pos, final IBlockState state) {
        return new ItemStack(this.getItem());
    }
    
    private Item getItem() {
        if (this.item == null) {
            this.item = (Item)Item.field_150901_e.func_82594_a((Object)this.itemLocation);
        }
        return this.item;
    }
}
