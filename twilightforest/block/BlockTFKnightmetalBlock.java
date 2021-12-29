// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFKnightmetalBlock extends Block implements ModelRegisterCallback
{
    private static final AxisAlignedBB AABB;
    private static final float BLOCK_DAMAGE = 4.0f;
    
    public BlockTFKnightmetalBlock() {
        super(Material.field_151573_f);
        this.func_149711_c(5.0f);
        this.func_149752_b(41.0f);
        this.func_149672_a(SoundType.field_185852_e);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Deprecated
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess source, final BlockPos pos) {
        return BlockTFKnightmetalBlock.AABB;
    }
    
    public PathNodeType getAiPathNodeType(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return PathNodeType.DAMAGE_CACTUS;
    }
    
    public void func_180634_a(final World world, final BlockPos pos, final IBlockState state, final Entity entity) {
        entity.func_70097_a(DamageSource.field_76367_g, 4.0f);
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    @Deprecated
    public boolean func_176225_a(final IBlockState state, final IBlockAccess access, final BlockPos pos, final EnumFacing side) {
        return !access.func_180495_p(pos.func_177972_a(side)).doesSideBlockRendering(access, pos.func_177972_a(side), side.func_176734_d());
    }
    
    static {
        AABB = new AxisAlignedBB(0.0625, 0.0625, 0.0625, 0.9375, 0.9375, 0.9375);
    }
}
