// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import twilightforest.client.ModelUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;

public class BlockTFBurntThorns extends BlockTFThorns
{
    protected BlockTFBurntThorns() {
        this.func_149711_c(0.01f);
        this.func_149752_b(0.0f);
        this.func_149672_a(SoundType.field_185855_h);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Override
    protected IProperty[] getAdditionalProperties() {
        return new IProperty[0];
    }
    
    @Override
    protected boolean hasVariant() {
        return false;
    }
    
    @Override
    public MapColor func_180659_g(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return MapColor.field_151665_m;
    }
    
    @Nullable
    @Override
    public PathNodeType getAiPathNodeType(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return null;
    }
    
    @Override
    public void func_180634_a(final World world, final BlockPos pos, final IBlockState state, final Entity entity) {
        if (!world.field_72995_K && entity instanceof EntityLivingBase) {
            world.func_175655_b(pos, false);
        }
    }
    
    @Override
    public boolean removedByPlayer(final IBlockState state, final World world, final BlockPos pos, final EntityPlayer player, final boolean harvest) {
        world.func_175698_g(pos);
        return true;
    }
    
    @Override
    public boolean canSustainLeaves(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return false;
    }
    
    @Override
    public void func_180663_b(final World world, final BlockPos pos, final IBlockState state) {
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel() {
        ModelUtils.registerToState((Block)this, 0, this.func_176223_P());
    }
}
