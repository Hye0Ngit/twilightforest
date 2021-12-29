// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.particles.IParticleData;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Random;
import net.minecraft.world.server.ServerWorld;
import java.util.Set;
import java.util.Deque;
import net.minecraft.util.Direction;
import java.util.HashSet;
import java.util.ArrayDeque;
import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
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

public class VanishingBlock extends Block
{
    public static final BooleanProperty ACTIVE;
    public static final BooleanProperty VANISHED;
    private static final VoxelShape VANISHED_SHAPE;
    
    public VanishingBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)VanishingBlock.ACTIVE, (Comparable)false));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)VanishingBlock.ACTIVE });
    }
    
    private boolean isVanished(final BlockState state) {
        return state.func_235901_b_((Property)VanishingBlock.VANISHED) && (boolean)state.func_177229_b((Property)VanishingBlock.VANISHED);
    }
    
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader world, final BlockPos pos, final ISelectionContext ctx) {
        return this.isVanished(state) ? VanishingBlock.VANISHED_SHAPE : super.func_220053_a(state, world, pos, ctx);
    }
    
    public VoxelShape func_220071_b(final BlockState state, final IBlockReader world, final BlockPos pos, final ISelectionContext ctx) {
        return this.isVanished(state) ? VoxelShapes.func_197880_a() : super.func_220071_b(state, world, pos, ctx);
    }
    
    @Deprecated
    public ActionResultType func_225533_a_(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {
        if (!this.isVanished(state) && !(boolean)state.func_177229_b((Property)VanishingBlock.ACTIVE)) {
            if (areBlocksLocked((IBlockReader)world, pos)) {
                world.func_184133_a((PlayerEntity)null, pos, TFSounds.LOCKED_VANISHING_BLOCK, SoundCategory.BLOCKS, 1.0f, 0.3f);
            }
            else {
                this.activate(world, pos);
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }
    
    public float getExplosionResistance(final BlockState state, final IBlockReader world, final BlockPos pos, final Explosion explosion) {
        return state.func_177229_b((Property)VanishingBlock.ACTIVE) ? super.getExplosionResistance(state, world, pos, explosion) : 6000.0f;
    }
    
    public boolean canEntityDestroy(final BlockState state, final IBlockReader world, final BlockPos pos, final Entity entity) {
        return state.func_177229_b((Property)VanishingBlock.ACTIVE) ? super.canEntityDestroy(state, world, pos, entity) : (!areBlocksLocked(world, pos));
    }
    
    private static boolean areBlocksLocked(final IBlockReader world, final BlockPos start) {
        final int limit = 512;
        final Deque<BlockPos> queue = new ArrayDeque<BlockPos>();
        final Set<BlockPos> checked = new HashSet<BlockPos>();
        queue.offer(start);
        for (int iter = 0; !queue.isEmpty() && iter < limit; ++iter) {
            final BlockPos cur = queue.pop();
            final BlockState state = world.func_180495_p(cur);
            if (state.func_177230_c() == TFBlocks.locked_vanishing_block.get() && (boolean)state.func_177229_b((Property)LockedVanishingBlock.LOCKED)) {
                return true;
            }
            checked.add(cur);
            if (state.func_177230_c() instanceof VanishingBlock) {
                for (final Direction facing : Direction.values()) {
                    final BlockPos neighbor = cur.func_177972_a(facing);
                    if (!checked.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return false;
    }
    
    @Deprecated
    public void func_220069_a(final BlockState state, final World world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (world.field_72995_K) {
            return;
        }
        if (!this.isVanished(state) && !(boolean)state.func_177229_b((Property)VanishingBlock.ACTIVE) && world.func_175640_z(pos) && !areBlocksLocked((IBlockReader)world, pos)) {
            this.activate(world, pos);
        }
    }
    
    @Deprecated
    public void func_225534_a_(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        if (world.field_72995_K) {
            return;
        }
        if (this.isVanished(state)) {
            if (state.func_177229_b((Property)VanishingBlock.ACTIVE)) {
                world.func_175656_a(pos, (BlockState)((BlockState)state.func_206870_a((Property)VanishingBlock.VANISHED, (Comparable)false)).func_206870_a((Property)VanishingBlock.ACTIVE, (Comparable)false));
            }
            else {
                world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)VanishingBlock.ACTIVE, (Comparable)true));
                world.func_205220_G_().func_205360_a(pos, (Object)this, 15);
            }
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.REAPPEAR_BLOCK, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
        else if (state.func_177229_b((Property)VanishingBlock.ACTIVE)) {
            if (state.func_235901_b_((Property)VanishingBlock.VANISHED)) {
                world.func_175656_a(pos, (BlockState)((BlockState)state.func_206870_a((Property)VanishingBlock.ACTIVE, (Comparable)false)).func_206870_a((Property)VanishingBlock.VANISHED, (Comparable)true));
                world.func_205220_G_().func_205360_a(pos, (Object)this, 80);
            }
            else {
                world.func_217377_a(pos, false);
            }
            world.func_184133_a((PlayerEntity)null, pos, (state.func_177230_c() == TFBlocks.reappearing_block.get()) ? TFSounds.REAPPEAR_POOF : TFSounds.VANISHING_BLOCK, SoundCategory.BLOCKS, 0.3f, 0.5f);
            for (final Direction e : Direction.values()) {
                this.activate((World)world, pos.func_177972_a(e));
            }
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_180655_c(final BlockState state, final World world, final BlockPos pos, final Random random) {
        if (state.func_177229_b((Property)VanishingBlock.ACTIVE)) {
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
    
    private void activate(final World world, final BlockPos pos) {
        final BlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() instanceof VanishingBlock && !this.isVanished(state) && !(boolean)state.func_177229_b((Property)VanishingBlock.ACTIVE)) {
            world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)VanishingBlock.ACTIVE, (Comparable)true));
            world.func_205220_G_().func_205360_a(pos, (Object)state.func_177230_c(), 2 + world.field_73012_v.nextInt(5));
        }
    }
    
    static {
        ACTIVE = BooleanProperty.func_177716_a("active");
        VANISHED = BooleanProperty.func_177716_a("vanished");
        VANISHED_SHAPE = func_208617_a(6.0, 6.0, 6.0, 10.0, 10.0, 10.0);
    }
}
