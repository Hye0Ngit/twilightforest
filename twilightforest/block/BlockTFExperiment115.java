// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.BlockStateContainer;
import java.util.Random;
import net.minecraft.stats.StatList;
import net.minecraft.init.Items;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumHand;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import twilightforest.item.TFItems;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFExperiment115 extends Block implements ModelRegisterCallback
{
    public static final IProperty<Integer> NOMS;
    public static final IProperty<Boolean> REGENERATE;
    private static final AxisAlignedBB[] AABB;
    
    public BlockTFExperiment115() {
        super(Material.field_151568_F, MapColor.field_151668_h);
        this.func_149675_a(true);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFExperiment115.NOMS, (Comparable)7).func_177226_a((IProperty)BlockTFExperiment115.REGENERATE, (Comparable)false));
        this.func_149672_a(SoundType.field_185854_g);
    }
    
    public ItemStack getPickBlock(final IBlockState state, final RayTraceResult target, final World world, final BlockPos pos, final EntityPlayer player) {
        return new ItemStack(TFItems.experiment_115);
    }
    
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess source, final BlockPos pos) {
        switch ((int)state.func_177229_b((IProperty)BlockTFExperiment115.NOMS)) {
            default: {
                return BlockTFExperiment115.AABB[0];
            }
            case 4:
            case 5: {
                return BlockTFExperiment115.AABB[1];
            }
            case 6:
            case 7: {
                return BlockTFExperiment115.AABB[2];
            }
        }
    }
    
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    public BlockFaceShape func_193383_a(final IBlockAccess worldIn, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }
    
    public boolean func_180639_a(final World worldIn, final BlockPos pos, final IBlockState state, final EntityPlayer player, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ) {
        final int bitesTaken = (int)state.func_177229_b((IProperty)BlockTFExperiment115.NOMS);
        final ItemStack stack = player.func_184586_b(hand);
        if (!player.func_70093_af()) {
            if (bitesTaken > 0 && stack.func_77973_b() == TFItems.experiment_115) {
                worldIn.func_175656_a(pos, state.func_177226_a((IProperty)BlockTFExperiment115.NOMS, (Comparable)(bitesTaken - 1)));
                if (!player.func_184812_l_()) {
                    stack.func_190918_g(1);
                }
                if (player instanceof EntityPlayerMP) {
                    CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)player, pos, stack);
                }
                return true;
            }
            if (!(boolean)state.func_177229_b((IProperty)BlockTFExperiment115.REGENERATE) && stack.func_77973_b() == Items.field_151137_ax && (player.func_184812_l_() || bitesTaken == 0)) {
                worldIn.func_175656_a(pos, state.func_177226_a((IProperty)BlockTFExperiment115.REGENERATE, (Comparable)true));
                if (!player.func_184812_l_()) {
                    stack.func_190918_g(1);
                }
                if (player instanceof EntityPlayerMP) {
                    CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)player, pos, stack);
                }
                return true;
            }
        }
        return this.eatCake(worldIn, pos, state, player) || stack.func_190926_b();
    }
    
    private boolean eatCake(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player) {
        if (!player.func_71043_e(false)) {
            return false;
        }
        player.func_71029_a(StatList.field_188076_J);
        player.func_71024_bL().func_75122_a(4, 0.3f);
        final int i = (int)state.func_177229_b((IProperty)BlockTFExperiment115.NOMS);
        if (i < 7) {
            world.func_180501_a(pos, state.func_177226_a((IProperty)BlockTFExperiment115.NOMS, (Comparable)(i + 1)), 3);
        }
        else {
            world.func_175698_g(pos);
        }
        if (player instanceof EntityPlayerMP) {
            CriteriaTriggers.field_193138_y.func_193148_a((EntityPlayerMP)player, new ItemStack(TFItems.experiment_115, 8 - i));
        }
        return true;
    }
    
    public void func_180650_b(final World worldIn, final BlockPos pos, final IBlockState state, final Random rand) {
        if ((boolean)state.func_177229_b((IProperty)BlockTFExperiment115.REGENERATE) && (int)state.func_177229_b((IProperty)BlockTFExperiment115.NOMS) != 0) {
            worldIn.func_175656_a(pos, state.func_177226_a((IProperty)BlockTFExperiment115.NOMS, (Comparable)((int)state.func_177229_b((IProperty)BlockTFExperiment115.NOMS) - 1)));
        }
    }
    
    public void func_189540_a(final IBlockState state, final World worldIn, final BlockPos pos, final Block blockIn, final BlockPos fromPos) {
        if (!this.canBlockStay(worldIn, pos)) {
            worldIn.func_175698_g(pos);
        }
    }
    
    private boolean canBlockStay(final World world, final BlockPos pos) {
        return world.func_180495_p(pos.func_177977_b()).func_185904_a().func_76220_a();
    }
    
    public boolean func_176196_c(final World world, final BlockPos pos) {
        return super.func_176196_c(world, pos) && this.canBlockStay(world, pos);
    }
    
    public int func_149745_a(final Random random) {
        return 0;
    }
    
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFExperiment115.NOMS, (Comparable)(meta & 0x7)).func_177226_a((IProperty)BlockTFExperiment115.REGENERATE, (Comparable)((meta & 0x8) == 0x8));
    }
    
    public int func_176201_c(final IBlockState state) {
        return (int)state.func_177229_b((IProperty)BlockTFExperiment115.NOMS) | (state.func_177229_b((IProperty)BlockTFExperiment115.REGENERATE) ? 8 : 0);
    }
    
    protected BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFExperiment115.NOMS, BlockTFExperiment115.REGENERATE });
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    public int func_180641_l(final IBlockState state, final World world, final BlockPos pos) {
        return 15 - (int)state.func_177229_b((IProperty)BlockTFExperiment115.NOMS) * 2;
    }
    
    public boolean func_149740_M(final IBlockState state) {
        return true;
    }
    
    public boolean func_149744_f(final IBlockState state) {
        return (boolean)state.func_177229_b((IProperty)BlockTFExperiment115.REGENERATE);
    }
    
    public int func_180656_a(final IBlockState state, final IBlockAccess blockAccess, final BlockPos pos, final EnumFacing side) {
        return state.func_177229_b((IProperty)BlockTFExperiment115.REGENERATE) ? (15 - (int)state.func_177229_b((IProperty)BlockTFExperiment115.NOMS) * 2) : 0;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelLoader.setCustomModelResourceLocation(TFItems.experiment_115, 0, new ModelResourceLocation("twilightforest:experiment_115", "inventory"));
        ModelLoader.setCustomModelResourceLocation(TFItems.experiment_115, 1, new ModelResourceLocation("twilightforest:experiment_115", "inventory_full"));
        ModelLoader.setCustomModelResourceLocation(TFItems.experiment_115, 2, new ModelResourceLocation("twilightforest:experiment_115", "inventory_think"));
        ModelLoader.setCustomModelResourceLocation(TFItems.experiment_115, 3, new ModelResourceLocation("twilightforest:shield", "inventory"));
    }
    
    static {
        NOMS = (IProperty)PropertyInteger.func_177719_a("omnomnom", 0, 7);
        REGENERATE = (IProperty)PropertyBool.func_177716_a("regenerate");
        AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.5, 0.5, 0.9375), new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.5, 0.5, 0.5) };
    }
}
