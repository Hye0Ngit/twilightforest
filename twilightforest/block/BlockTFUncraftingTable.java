// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraft.stats.StatList;
import twilightforest.TwilightForestMod;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFUncraftingTable extends Block implements ModelRegisterCallback
{
    protected BlockTFUncraftingTable() {
        super(Material.field_151575_d);
        this.func_149711_c(2.5f);
        this.func_149672_a(SoundType.field_185848_a);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_180639_a(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player, final EnumHand hand, final EnumFacing side, final float hitX, final float hitY, final float hitZ) {
        if (world.field_72995_K) {
            return true;
        }
        player.openGui((Object)TwilightForestMod.instance, 1, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        player.func_71029_a(StatList.field_188062_ab);
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final ModelResourceLocation mrl = new ModelResourceLocation(this.getRegistryName(), Loader.isModLoaded("ctm") ? "ctm" : "normal");
        ModelLoader.setCustomStateMapper((Block)this, (IStateMapper)new SingleStateMapper(mrl));
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), 0, mrl);
    }
}
