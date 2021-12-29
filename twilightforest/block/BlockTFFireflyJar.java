// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.Optional;
import thaumcraft.api.crafting.IInfusionStabiliser;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

@Optional.Interface(modid = "thaumcraft", iface = "thaumcraft.api.crafting.IInfusionStabiliser")
public class BlockTFFireflyJar extends Block implements ModelRegisterCallback, IInfusionStabiliser
{
    private static final AxisAlignedBB AABB;
    
    protected BlockTFFireflyJar() {
        super(Material.field_151592_s);
        this.func_149711_c(0.3f);
        this.func_149672_a(SoundType.field_185848_a);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149715_a(1.0f);
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public BlockFaceShape func_193383_a(final IBlockAccess worldIn, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    public boolean func_149721_r(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess source, final BlockPos pos) {
        return BlockTFFireflyJar.AABB;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_180655_c(final IBlockState state, final World world, final BlockPos pos, final Random rand) {
        for (int i = 0; i < 2; ++i) {
            final double dx = pos.func_177958_n() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
            final double dy = pos.func_177956_o() + 0.4f + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
            final double dz = pos.func_177952_p() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
            TwilightForestMod.proxy.spawnParticle(TFParticleType.FIREFLY, dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    public boolean canStabaliseInfusion(final World world, final BlockPos blockPos) {
        return true;
    }
    
    static {
        AABB = new AxisAlignedBB(0.1875, 0.0, 0.1875, 0.8125, 1.0, 0.8125);
    }
}
