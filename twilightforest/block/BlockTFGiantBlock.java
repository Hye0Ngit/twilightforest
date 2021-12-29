// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import java.util.Iterator;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public abstract class BlockTFGiantBlock extends Block implements ModelRegisterCallback
{
    private boolean isSelfDestructing;
    
    public BlockTFGiantBlock(final IBlockState state) {
        super(state.func_185904_a());
        this.func_149672_a(state.func_177230_c().func_185467_w());
    }
    
    public boolean func_176196_c(final World world, final BlockPos pos) {
        for (final BlockPos dPos : getVolume(pos)) {
            final IBlockState state = world.func_180495_p(dPos);
            if (!state.func_177230_c().func_176200_f((IBlockAccess)world, dPos)) {
                return false;
            }
        }
        return super.func_176196_c(world, pos);
    }
    
    public void func_180633_a(final World world, final BlockPos pos, final IBlockState state, final EntityLivingBase player, final ItemStack itemStack) {
        if (!world.field_72995_K) {
            for (final BlockPos dPos : getVolume(pos)) {
                world.func_180501_a(dPos, this.func_176223_P(), 2);
            }
        }
    }
    
    public void func_180663_b(final World world, final BlockPos pos, final IBlockState state) {
        super.func_180663_b(world, pos, state);
        if (!this.isSelfDestructing && !this.canBlockStay(world, pos)) {
            this.setGiantBlockToAir(world, pos);
        }
    }
    
    private void setGiantBlockToAir(final World world, final BlockPos pos) {
        this.isSelfDestructing = true;
        for (final BlockPos iterPos : getVolume(pos)) {
            if (!pos.equals((Object)iterPos) && world.func_180495_p(iterPos).func_177230_c() == this) {
                world.func_175655_b(iterPos, false);
            }
        }
        this.isSelfDestructing = false;
    }
    
    private boolean canBlockStay(final World world, final BlockPos pos) {
        for (final BlockPos dPos : getVolume(pos)) {
            if (world.func_180495_p(dPos).func_177230_c() != this) {
                return false;
            }
        }
        return true;
    }
    
    @Deprecated
    public EnumPushReaction func_149656_h(final IBlockState state) {
        return EnumPushReaction.BLOCK;
    }
    
    public static BlockPos roundCoords(final BlockPos pos) {
        return new BlockPos(pos.func_177958_n() & 0xFFFFFFFC, pos.func_177956_o() & 0xFFFFFFFC, pos.func_177952_p() & 0xFFFFFFFC);
    }
    
    public static Iterable<BlockPos> getVolume(final BlockPos pos) {
        return BlockPos.func_191532_a(pos.func_177958_n() & 0xFFFFFFFC, pos.func_177956_o() & 0xFFFFFFFC, pos.func_177952_p() & 0xFFFFFFFC, pos.func_177958_n() | 0x3, pos.func_177956_o() | 0x3, pos.func_177952_p() | 0x3);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
}
