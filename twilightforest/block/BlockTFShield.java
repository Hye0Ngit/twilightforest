// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.init.Blocks;
import twilightforest.util.EntityUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockDirectional;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFShield extends Block implements ModelRegisterCallback
{
    public BlockTFShield() {
        super(Material.field_151576_e);
        this.func_149722_s();
        this.func_149752_b(6000000.0f);
        this.func_149672_a(SoundType.field_185852_e);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.DOWN));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockDirectional.field_176387_N });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((EnumFacing)state.func_177229_b((IProperty)BlockDirectional.field_176387_N)).func_176745_a();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.func_82600_a(meta));
    }
    
    public int func_149745_a(final Random random) {
        return 0;
    }
    
    @Deprecated
    public IBlockState func_180642_a(final World worldIn, final BlockPos pos, final EnumFacing facing, final float hitX, final float hitY, final float hitZ, final int meta, final EntityLivingBase placer) {
        return this.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.func_190914_a(pos, placer));
    }
    
    @Deprecated
    public float func_180647_a(final IBlockState state, final EntityPlayer player, final World world, final BlockPos pos) {
        final RayTraceResult ray = EntityUtil.rayTrace(player, range -> range + 1.0);
        final EnumFacing hitFace = (ray != null) ? ray.field_178784_b : null;
        final EnumFacing blockFace = (EnumFacing)state.func_177229_b((IProperty)BlockDirectional.field_176387_N);
        if (hitFace == blockFace) {
            return player.getDigSpeed(Blocks.field_150348_b.func_176223_P(), pos) / 1.5f / 100.0f;
        }
        return super.func_180647_a(state, player, world, pos);
    }
    
    protected boolean func_149700_E() {
        return false;
    }
    
    public boolean canSilkHarvest(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player) {
        return false;
    }
    
    public int func_180651_a(final IBlockState state) {
        return 0;
    }
    
    public boolean canEntityDestroy(final IBlockState state, final IBlockAccess world, final BlockPos pos, final Entity entity) {
        return false;
    }
}
