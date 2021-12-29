// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.tileentity.CarminiteBuilderTileEntity;
import net.minecraft.util.Direction;
import java.util.Random;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import twilightforest.enums.TowerDeviceVariant;
import net.minecraft.state.EnumProperty;
import net.minecraft.block.Block;

public class BuilderBlock extends Block
{
    public static final EnumProperty<TowerDeviceVariant> STATE;
    
    public BuilderBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)BuilderBlock.STATE });
    }
    
    @Deprecated
    public void func_220082_b(final BlockState state, final World world, final BlockPos pos, final BlockState oldState, final boolean isMoving) {
        if (!world.field_72995_K && state.func_177229_b((Property)BuilderBlock.STATE) == TowerDeviceVariant.BUILDER_INACTIVE && world.func_175640_z(pos)) {
            world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_ACTIVE));
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.BUILDER_ON, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
    }
    
    @Deprecated
    public void func_220069_a(final BlockState state, final World world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (world.field_72995_K) {
            return;
        }
        final TowerDeviceVariant variant = (TowerDeviceVariant)state.func_177229_b((Property)BuilderBlock.STATE);
        if (variant == TowerDeviceVariant.BUILDER_INACTIVE && world.func_175640_z(pos)) {
            world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_ACTIVE));
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.BUILDER_ON, SoundCategory.BLOCKS, 0.3f, 0.6f);
            world.func_205220_G_().func_205360_a(pos, (Object)this, 4);
        }
        if (variant == TowerDeviceVariant.BUILDER_ACTIVE && !world.func_175640_z(pos)) {
            world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE));
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.BUILDER_OFF, SoundCategory.BLOCKS, 0.3f, 0.6f);
            world.func_205220_G_().func_205360_a(pos, (Object)this, 4);
        }
        if (variant == TowerDeviceVariant.BUILDER_TIMEOUT && !world.func_175640_z(pos)) {
            world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE));
        }
    }
    
    @Deprecated
    public void func_225534_a_(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        final TowerDeviceVariant variant = (TowerDeviceVariant)state.func_177229_b((Property)BuilderBlock.STATE);
        if (variant == TowerDeviceVariant.BUILDER_ACTIVE && world.func_175640_z(pos)) {
            this.letsBuild((World)world, pos);
        }
        if (variant == TowerDeviceVariant.BUILDER_INACTIVE || variant == TowerDeviceVariant.BUILDER_TIMEOUT) {
            for (final Direction e : Direction.values()) {
                activateBuiltBlocks((World)world, pos.func_177972_a(e));
            }
        }
    }
    
    private void letsBuild(final World world, final BlockPos pos) {
        final CarminiteBuilderTileEntity tileEntity = (CarminiteBuilderTileEntity)world.func_175625_s(pos);
        if (tileEntity != null && !tileEntity.makingBlocks) {
            tileEntity.startBuilding();
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_180655_c(final BlockState state, final World world, final BlockPos pos, final Random random) {
        if (state.func_177229_b((Property)BuilderBlock.STATE) == TowerDeviceVariant.BUILDER_ACTIVE) {
            this.sparkle(world, pos);
        }
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
            final float f1 = 1.0f;
            final float f2 = Math.max(0.0f, 0.19999999f);
            final float f3 = Math.max(0.0f, -0.099999964f);
            if (d2 < pos.func_177958_n() || d2 > pos.func_177958_n() + 1 || d3 < 0.0 || d3 > pos.func_177956_o() + 1 || d4 < pos.func_177952_p() || d4 > pos.func_177952_p() + 1) {
                worldIn.func_195594_a((IParticleData)new RedstoneParticleData(f1, f2, f3, 1.0f), d2, d3, d4, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public static void activateBuiltBlocks(final World world, final BlockPos pos) {
        final BlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() == TFBlocks.built_block.get() && !(boolean)state.func_177229_b((Property)TranslucentBuiltBlock.ACTIVE)) {
            world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)TranslucentBuiltBlock.ACTIVE, (Comparable)true));
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.BUILDER_REPLACE, SoundCategory.BLOCKS, 0.3f, 0.6f);
            world.func_205220_G_().func_205360_a(pos, (Object)state.func_177230_c(), 15);
        }
    }
    
    public boolean hasTileEntity(final BlockState state) {
        return state.func_177229_b((Property)BuilderBlock.STATE) == TowerDeviceVariant.BUILDER_ACTIVE;
    }
    
    @Nullable
    public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
        return (state.func_177229_b((Property)BuilderBlock.STATE) == TowerDeviceVariant.BUILDER_ACTIVE) ? new CarminiteBuilderTileEntity() : null;
    }
    
    static {
        STATE = EnumProperty.func_177709_a("state", (Class)TowerDeviceVariant.class);
    }
}
