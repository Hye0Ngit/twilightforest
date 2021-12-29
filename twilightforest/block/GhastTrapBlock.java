// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import javax.annotation.Nullable;
import java.util.Random;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.world.IBlockReader;
import twilightforest.tileentity.ActiveGhastTrapTileEntity;
import net.minecraft.tileentity.TileEntity;
import java.util.Iterator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.Block;

public class GhastTrapBlock extends Block
{
    public static final int ACTIVATE_EVENT = 0;
    public static final int DEACTIVATE_EVENT = 1;
    public static final BooleanProperty ACTIVE;
    
    public GhastTrapBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)GhastTrapBlock.ACTIVE, (Comparable)false));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)GhastTrapBlock.ACTIVE });
    }
    
    @Deprecated
    public void func_220069_a(final BlockState state, final World world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (world.field_72995_K) {
            return;
        }
        if (!(boolean)state.func_177229_b((Property)GhastTrapBlock.ACTIVE) && this.isInactiveTrapCharged(world, pos) && world.func_175640_z(pos)) {
            for (final ServerPlayerEntity player : world.func_217357_a((Class)ServerPlayerEntity.class, new AxisAlignedBB(pos).func_186662_g(6.0))) {
                TFAdvancements.ACTIVATED_GHAST_TRAP.trigger(player);
            }
            world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)GhastTrapBlock.ACTIVE, (Comparable)true));
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.JET_START, SoundCategory.BLOCKS, 0.3f, 0.6f);
            world.func_175641_c(pos, (Block)this, 0, 0);
        }
    }
    
    public boolean func_189539_a(final BlockState state, final World world, final BlockPos pos, final int event, final int payload) {
        final TileEntity te = world.func_175625_s(pos);
        return te != null && te.func_145842_c(event, payload);
    }
    
    private boolean isInactiveTrapCharged(final World world, final BlockPos pos) {
        final TileEntity tileEntity = world.func_175625_s(pos);
        return tileEntity instanceof ActiveGhastTrapTileEntity && ((ActiveGhastTrapTileEntity)tileEntity).isCharged();
    }
    
    public void sparkle(final World worldIn, final BlockPos pos) {
        final Random random = worldIn.field_73012_v;
        final double d0 = 0.0625;
        for (int i = 0; i < 6; ++i) {
            double d2 = pos.func_177958_n() + random.nextFloat();
            double d3 = pos.func_177956_o() + random.nextFloat();
            double d4 = pos.func_177952_p() + random.nextFloat();
            if (i == 0 && !worldIn.func_180495_p(pos.func_177984_a()).func_200015_d((IBlockReader)worldIn, pos)) {
                d3 = pos.func_177956_o() + d0 + 1.0;
            }
            if (i == 1 && !worldIn.func_180495_p(pos.func_177977_b()).func_200015_d((IBlockReader)worldIn, pos)) {
                d3 = pos.func_177956_o() - d0;
            }
            if (i == 2 && !worldIn.func_180495_p(pos.func_177968_d()).func_200015_d((IBlockReader)worldIn, pos)) {
                d4 = pos.func_177952_p() + d0 + 1.0;
            }
            if (i == 3 && !worldIn.func_180495_p(pos.func_177978_c()).func_200015_d((IBlockReader)worldIn, pos)) {
                d4 = pos.func_177952_p() - d0;
            }
            if (i == 4 && !worldIn.func_180495_p(pos.func_177974_f()).func_200015_d((IBlockReader)worldIn, pos)) {
                d2 = pos.func_177958_n() + d0 + 1.0;
            }
            if (i == 5 && !worldIn.func_180495_p(pos.func_177976_e()).func_200015_d((IBlockReader)worldIn, pos)) {
                d2 = pos.func_177958_n() - d0;
            }
            if (d2 < pos.func_177958_n() || d2 > pos.func_177958_n() + 1 || d3 < 0.0 || d3 > pos.func_177956_o() + 1 || d4 < pos.func_177952_p() || d4 > pos.func_177952_p() + 1) {
                worldIn.func_195594_a((IParticleData)RedstoneParticleData.field_197564_a, d2, d3, d4, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public boolean hasTileEntity(final BlockState state) {
        return true;
    }
    
    @Nullable
    public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
        return new ActiveGhastTrapTileEntity();
    }
    
    static {
        ACTIVE = BooleanProperty.func_177716_a("active");
    }
}
