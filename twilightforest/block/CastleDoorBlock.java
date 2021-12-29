// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.Direction;
import java.util.Random;
import net.minecraft.world.server.ServerWorld;
import twilightforest.world.TFGenerationSettings;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.Block;

public class CastleDoorBlock extends Block
{
    public static final BooleanProperty ACTIVE;
    public static final BooleanProperty VANISHED;
    private static final VoxelShape REAPPEARING_BB;
    
    public CastleDoorBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)CastleDoorBlock.ACTIVE, (Comparable)false)).func_206870_a((Property)CastleDoorBlock.VANISHED, (Comparable)false));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)CastleDoorBlock.ACTIVE, (Property)CastleDoorBlock.VANISHED });
    }
    
    @Deprecated
    public VoxelShape func_220071_b(final BlockState state, final IBlockReader world, final BlockPos pos, final ISelectionContext context) {
        return state.func_177229_b((Property)CastleDoorBlock.VANISHED) ? VoxelShapes.func_197880_a() : super.func_220071_b(state, world, pos, context);
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader world, final BlockPos pos, final ISelectionContext context) {
        return state.func_177229_b((Property)CastleDoorBlock.VANISHED) ? CastleDoorBlock.REAPPEARING_BB : super.func_220053_a(state, world, pos, context);
    }
    
    @Deprecated
    public ActionResultType func_225533_a_(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {
        return this.onActivation(world, pos, state);
    }
    
    @Deprecated
    public void func_220069_a(final BlockState state, final World world, final BlockPos pos, final Block block, final BlockPos fromPos, final boolean isMoving) {
        if (!(block instanceof CastleDoorBlock) && world.func_175640_z(pos)) {
            this.onActivation(world, pos, state);
        }
    }
    
    private ActionResultType onActivation(final World world, final BlockPos pos, final BlockState state) {
        if ((boolean)state.func_177229_b((Property)CastleDoorBlock.VANISHED) || (boolean)state.func_177229_b((Property)CastleDoorBlock.ACTIVE)) {
            return ActionResultType.FAIL;
        }
        if (isBlockLocked(world, pos)) {
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.DOOR_ACTIVATED, SoundCategory.BLOCKS, 1.0f, 0.3f);
            return ActionResultType.PASS;
        }
        changeToActiveBlock(world, pos, state);
        return ActionResultType.SUCCESS;
    }
    
    private static void changeToActiveBlock(final World world, final BlockPos pos, final BlockState originState) {
        if (originState.func_177230_c() instanceof CastleDoorBlock) {
            world.func_175656_a(pos, (BlockState)originState.func_206870_a((Property)CastleDoorBlock.ACTIVE, (Comparable)true));
        }
        world.func_205220_G_().func_205360_a(pos, (Object)originState.func_177230_c(), 2 + world.field_73012_v.nextInt(5));
    }
    
    private static boolean isBlockLocked(final World world, final BlockPos pos) {
        if (!world.field_72995_K) {
            TFGenerationSettings.getChunkGenerator(world);
        }
        return false;
    }
    
    @Deprecated
    public void func_225534_a_(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        if (state.func_177229_b((Property)CastleDoorBlock.VANISHED)) {
            if (state.func_177229_b((Property)CastleDoorBlock.ACTIVE)) {
                world.func_175656_a(pos, (BlockState)((BlockState)state.func_206870_a((Property)CastleDoorBlock.VANISHED, (Comparable)false)).func_206870_a((Property)CastleDoorBlock.ACTIVE, (Comparable)false));
            }
            else {
                changeToActiveBlock((World)world, pos, state);
            }
            playReappearSound((World)world, pos);
        }
        else if (state.func_177229_b((Property)CastleDoorBlock.ACTIVE)) {
            world.func_175656_a(pos, (BlockState)((BlockState)state.func_206870_a((Property)CastleDoorBlock.VANISHED, (Comparable)true)).func_206870_a((Property)CastleDoorBlock.ACTIVE, (Comparable)false));
            world.func_205220_G_().func_205360_a(pos, (Object)this, 80);
            playVanishSound((World)world, pos);
            vanishParticles((World)world, pos);
            for (final Direction e : Direction.values()) {
                checkAndActivateCastleDoor((World)world, pos.func_177972_a(e));
            }
        }
    }
    
    private static void playVanishSound(final World world, final BlockPos pos) {
        world.func_184133_a((PlayerEntity)null, pos, TFSounds.DOOR_VANISH, SoundCategory.BLOCKS, 0.125f, world.field_73012_v.nextFloat() * 0.25f + 1.75f);
    }
    
    private static void playReappearSound(final World world, final BlockPos pos) {
        world.func_184133_a((PlayerEntity)null, pos, TFSounds.DOOR_REAPPEAR, SoundCategory.BLOCKS, 0.125f, world.field_73012_v.nextFloat() * 0.25f + 1.25f);
    }
    
    public static void checkAndActivateCastleDoor(final World world, final BlockPos pos) {
        final BlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() instanceof CastleDoorBlock && !(boolean)state.func_177229_b((Property)CastleDoorBlock.VANISHED) && !(boolean)state.func_177229_b((Property)CastleDoorBlock.ACTIVE) && !isBlockLocked(world, pos)) {
            changeToActiveBlock(world, pos, state);
        }
    }
    
    private static void vanishParticles(final World world, final BlockPos pos) {
        final Random rand = world.func_201674_k();
        if (world instanceof ServerWorld) {
            for (int dx = 0; dx < 4; ++dx) {
                for (int dy = 0; dy < 4; ++dy) {
                    for (int dz = 0; dz < 4; ++dz) {
                        final double x = pos.func_177958_n() + (dx + 0.5) / 4.0;
                        final double y = pos.func_177956_o() + (dy + 0.5) / 4.0;
                        final double z = pos.func_177952_p() + (dz + 0.5) / 4.0;
                        final double speed = rand.nextGaussian() * 0.2;
                        ((ServerWorld)world).func_195598_a((IParticleData)TFParticleType.ANNIHILATE.get(), x, y, z, 1, 0.0, 0.0, 0.0, speed);
                    }
                }
            }
        }
    }
    
    static {
        ACTIVE = BooleanProperty.func_177716_a("active");
        VANISHED = BooleanProperty.func_177716_a("vanish");
        REAPPEARING_BB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.375, 0.375, 0.375, 0.625, 0.625, 0.625));
    }
}
