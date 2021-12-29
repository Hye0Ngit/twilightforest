// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.block.Block;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.tileentity.TileEntitySkull;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.Item;
import java.util.Random;
import twilightforest.item.TFItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import twilightforest.TFSounds;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.tileentity.TileEntity;
import twilightforest.enums.BossVariant;
import twilightforest.tileentity.TileEntityTFTrophy;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.Optional;
import thaumcraft.api.crafting.IInfusionStabiliser;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockSkull;

@Optional.Interface(modid = "thaumcraft", iface = "thaumcraft.api.crafting.IInfusionStabiliser")
public class BlockTFTrophy extends BlockSkull implements ModelRegisterCallback, IInfusionStabiliser
{
    private static final AxisAlignedBB HYDRA_Y_BB;
    private static final AxisAlignedBB HYDRA_EAST_BB;
    private static final AxisAlignedBB HYDRA_WEST_BB;
    private static final AxisAlignedBB HYDRA_SOUTH_BB;
    private static final AxisAlignedBB HYDRA_NORTH_BB;
    private static final AxisAlignedBB URGHAST_BB;
    
    public BlockTFTrophy() {
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockSkull.field_176417_b, (Comparable)false).func_177226_a((IProperty)BlockSkull.field_176418_a, (Comparable)EnumFacing.UP));
    }
    
    public EnumBlockRenderType func_149645_b(final IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess access, final BlockPos pos) {
        final TileEntity te = access.func_175625_s(pos);
        if (te instanceof TileEntityTFTrophy) {
            switch (BossVariant.getVariant(((TileEntityTFTrophy)te).func_145904_a())) {
                case HYDRA: {
                    switch ((EnumFacing)state.func_177229_b((IProperty)BlockSkull.field_176418_a)) {
                        default: {
                            return BlockTFTrophy.HYDRA_Y_BB;
                        }
                        case NORTH: {
                            return BlockTFTrophy.HYDRA_NORTH_BB;
                        }
                        case SOUTH: {
                            return BlockTFTrophy.HYDRA_SOUTH_BB;
                        }
                        case WEST: {
                            return BlockTFTrophy.HYDRA_WEST_BB;
                        }
                        case EAST: {
                            return BlockTFTrophy.HYDRA_EAST_BB;
                        }
                    }
                    break;
                }
                case UR_GHAST: {
                    return BlockTFTrophy.URGHAST_BB;
                }
            }
        }
        return super.func_185496_a(state, access, pos);
    }
    
    public boolean func_180639_a(final World worldIn, final BlockPos pos, final IBlockState state, final EntityPlayer playerIn, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ) {
        final TileEntity te = worldIn.func_175625_s(pos);
        if (te instanceof TileEntityTFTrophy) {
            SoundEvent sound = null;
            float volume = 1.0f;
            switch (BossVariant.getVariant(((TileEntityTFTrophy)te).func_145904_a())) {
                case NAGA: {
                    sound = TFSounds.NAGA_RATTLE;
                    volume = 1.25f;
                    break;
                }
                case LICH: {
                    sound = SoundEvents.field_187594_A;
                    volume = 0.35f;
                    break;
                }
                case HYDRA: {
                    sound = TFSounds.HYDRA_GROWL;
                    break;
                }
                case UR_GHAST: {
                    sound = SoundEvents.field_187551_bH;
                    break;
                }
                case SNOW_QUEEN: {
                    sound = TFSounds.ICE_AMBIENT;
                    break;
                }
                case KNIGHT_PHANTOM: {
                    sound = TFSounds.WRAITH;
                    break;
                }
                case MINOSHROOM: {
                    sound = SoundEvents.field_187558_ak;
                    volume = 0.5f;
                    break;
                }
                case QUEST_RAM: {
                    sound = SoundEvents.field_187757_eG;
                    break;
                }
            }
            if (sound != null) {
                worldIn.func_184133_a(playerIn, pos, sound, SoundCategory.BLOCKS, volume, 16.0f);
            }
        }
        return true;
    }
    
    public TileEntity createTileEntity(final World world, final IBlockState state) {
        return (TileEntity)new TileEntityTFTrophy();
    }
    
    public ItemStack func_185473_a(final World world, final BlockPos pos, final IBlockState state) {
        final TileEntity te = world.func_175625_s(pos);
        if (te instanceof TileEntityTFTrophy) {
            return new ItemStack(TFItems.trophy, 1, ((TileEntityTFTrophy)te).func_145904_a());
        }
        return ItemStack.field_190927_a;
    }
    
    public Item func_180660_a(final IBlockState state, final Random rand, final int fortune) {
        return TFItems.trophy;
    }
    
    public List<ItemStack> getDrops(final IBlockAccess worldIn, final BlockPos pos, final IBlockState state, final int fortune) {
        final List<ItemStack> ret = new ArrayList<ItemStack>();
        if (!(boolean)state.func_177229_b((IProperty)BlockTFTrophy.field_176417_b)) {
            final TileEntity tileentity = worldIn.func_175625_s(pos);
            if (tileentity instanceof TileEntitySkull) {
                final TileEntitySkull tileentityskull = (TileEntitySkull)tileentity;
                final ItemStack itemstack = new ItemStack(TFItems.trophy, 1, tileentityskull.func_145904_a());
                ret.add(itemstack);
            }
        }
        return ret;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelLoader.setCustomStateMapper((Block)this, (IStateMapper)new StateMap.Builder().func_178442_a(new IProperty[] { (IProperty)BlockTFTrophy.field_176417_b }).func_178442_a(new IProperty[] { (IProperty)BlockTFTrophy.field_176418_a }).func_178441_a());
    }
    
    public boolean canStabaliseInfusion(final World world, final BlockPos blockPos) {
        return true;
    }
    
    static {
        HYDRA_Y_BB = new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 0.5, 0.75);
        HYDRA_EAST_BB = new AxisAlignedBB(0.0, 0.25, 0.25, 0.5, 0.75, 0.75);
        HYDRA_WEST_BB = new AxisAlignedBB(0.5, 0.25, 0.25, 1.0, 0.75, 0.75);
        HYDRA_SOUTH_BB = new AxisAlignedBB(0.25, 0.25, 0.0, 0.75, 0.75, 0.5);
        HYDRA_NORTH_BB = new AxisAlignedBB(0.25, 0.25, 0.5, 0.75, 0.75, 1.0);
        URGHAST_BB = new AxisAlignedBB(0.25, 0.5, 0.25, 0.75, 1.0, 0.75);
    }
}
