// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.Direction;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.util.math.BlockRayTraceResult;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.RayTraceResult;
import twilightforest.util.EntityUtil;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.Random;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathNodeType;
import javax.annotation.Nullable;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.block.Block;

public class HedgeBlock extends Block
{
    private static final VoxelShape HEDGE_BB;
    private static final int DAMAGE = 3;
    
    protected HedgeBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Deprecated
    public VoxelShape func_220071_b(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        return HedgeBlock.HEDGE_BB;
    }
    
    @Nullable
    public PathNodeType getAiPathNodeType(final BlockState state, final IBlockReader world, final BlockPos pos, @Nullable final MobEntity entity) {
        return (entity != null && this.shouldDamage((Entity)entity)) ? PathNodeType.DAMAGE_CACTUS : null;
    }
    
    @Deprecated
    public void func_196262_a(final BlockState state, final World worldIn, final BlockPos pos, final Entity entity) {
        if (this.shouldDamage(entity)) {
            entity.func_70097_a(DamageSource.field_76367_g, 3.0f);
        }
    }
    
    public void func_176199_a(final World world, final BlockPos pos, final Entity entity) {
        if (this.shouldDamage(entity)) {
            entity.func_70097_a(DamageSource.field_76367_g, 3.0f);
        }
    }
    
    public void func_196270_a(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player) {
        if (!world.field_72995_K) {
            world.func_205220_G_().func_205360_a(pos, (Object)this, 10);
        }
    }
    
    public void func_180657_a(final World world, final PlayerEntity player, final BlockPos pos, final BlockState state, @Nullable final TileEntity te, final ItemStack stack) {
        super.func_180657_a(world, player, pos, state, te, stack);
        player.func_70097_a(DamageSource.field_76367_g, 3.0f);
    }
    
    @Deprecated
    public void func_225534_a_(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        final List<PlayerEntity> nearbyPlayers = world.func_217357_a((Class)PlayerEntity.class, new AxisAlignedBB(pos).func_186662_g(8.0));
        for (final PlayerEntity player : nearbyPlayers) {
            if (player.field_82175_bq) {
                final BlockRayTraceResult ray = EntityUtil.rayTrace(player);
                if (ray.func_216346_c() != RayTraceResult.Type.BLOCK || !pos.equals((Object)ray.func_216350_a())) {
                    continue;
                }
                player.func_70097_a(DamageSource.field_76367_g, 3.0f);
                world.func_205220_G_().func_205360_a(pos, (Object)this, 10);
            }
        }
    }
    
    private boolean shouldDamage(final Entity entity) {
        return !(entity instanceof SpiderEntity) && !(entity instanceof ItemEntity) && !entity.func_145773_az();
    }
    
    public int getFlammability(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
        return 0;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
        return 0;
    }
    
    static {
        HEDGE_BB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.9375, 1.0));
    }
}
