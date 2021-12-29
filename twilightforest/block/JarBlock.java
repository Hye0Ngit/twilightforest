// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.particles.ParticleTypes;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.world.GameRules;
import twilightforest.TFConfig;
import java.util.Random;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.block.Block;

public class JarBlock extends Block
{
    private static final VoxelShape JAR;
    private static final VoxelShape LID;
    private static final VoxelShape AABB;
    
    protected JarBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        return JarBlock.AABB;
    }
    
    public ActionResultType func_225533_a_(final BlockState state, final World worldIn, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {
        final ItemEntity jarStuff = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p());
        if (player.func_225608_bj_()) {
            worldIn.func_175656_a(pos, Blocks.field_150350_a.func_176223_P());
            jarStuff.func_199703_a((this == TFBlocks.firefly_jar.get()) ? ((IItemProvider)TFBlocks.firefly.get()) : ((IItemProvider)TFBlocks.cicada.get()));
            jarStuff.func_199703_a((IItemProvider)Items.field_151069_bo);
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }
    
    public void func_225542_b_(final BlockState state, final ServerWorld worldIn, final BlockPos pos, final Random random) {
        super.func_225542_b_(state, worldIn, pos, random);
        if (!(boolean)TFConfig.CLIENT_CONFIG.silentCicadas.get() && random.nextInt(((GameRules.IntegerValue)worldIn.func_82736_K().func_223585_a(GameRules.field_223610_m)).func_223560_a()) <= 3) {
            worldIn.func_184133_a((PlayerEntity)null, pos, TFSounds.CICADA, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_180655_c(final BlockState state, final World world, final BlockPos pos, final Random rand) {
        if (this == TFBlocks.firefly_jar.get()) {
            for (int i = 0; i < 2; ++i) {
                final double dx = pos.func_177958_n() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
                final double dy = pos.func_177956_o() + 0.4f + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
                final double dz = pos.func_177952_p() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
                world.func_195594_a((IParticleData)TFParticleType.FIREFLY.get(), dx, dy, dz, 0.0, 0.0, 0.0);
            }
        }
        else {
            final double dx2 = pos.func_177958_n() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
            final double dy2 = pos.func_177956_o() + 0.4f + (rand.nextFloat() - rand.nextFloat()) * 0.2f;
            final double dz2 = pos.func_177952_p() + ((rand.nextFloat() - rand.nextFloat()) * 0.2f + 0.5f);
            world.func_195594_a((IParticleData)ParticleTypes.field_197597_H, dx2, dy2, dz2, 0.0, 0.0, 0.0);
        }
    }
    
    static {
        JAR = Block.func_208617_a(3.0, 0.0, 3.0, 13.0, 14.0, 13.0);
        LID = Block.func_208617_a(4.0, 14.0, 4.0, 12.0, 16.0, 12.0);
        AABB = VoxelShapes.func_197872_a(JarBlock.JAR, JarBlock.LID);
    }
}
