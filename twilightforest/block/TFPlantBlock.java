// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.item.ItemStack;
import twilightforest.network.SpawnFallenLeafFromPacket;
import net.minecraftforge.fml.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.client.particle.data.LeafParticleData;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraftforge.common.PlantType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraftforge.common.IPlantable;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import twilightforest.enums.PlantVariant;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.block.BushBlock;

public class TFPlantBlock extends BushBlock
{
    private static final VoxelShape MAYAPPLE_SHAPE;
    private static final VoxelShape FALLEN_LEAVES_SHAPE;
    public final PlantVariant plantVariant;
    
    protected TFPlantBlock(final PlantVariant plant, final AbstractBlock.Properties props) {
        super(props);
        this.plantVariant = plant;
    }
    
    public boolean func_196260_a(final BlockState state, final IWorldReader world, final BlockPos pos) {
        final BlockState soil = world.func_180495_p(pos.func_177977_b());
        switch (this.plantVariant) {
            case TORCHBERRY:
            case ROOT_STRAND: {
                return canPlaceRootAt(world, pos);
            }
            case FALLEN_LEAVES:
            case MUSHGLOOM:
            case MOSSPATCH: {
                return soil.func_224755_d((IBlockReader)world, pos, Direction.UP);
            }
            default: {
                return (world.func_201696_r(pos) >= 3 || world.func_175710_j(pos)) && soil.canSustainPlant((IBlockReader)world, pos.func_177977_b(), Direction.UP, (IPlantable)this);
            }
        }
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader access, final BlockPos pos, final ISelectionContext context) {
        long seed = (long)(pos.func_177958_n() * 3129871) ^ pos.func_177956_o() * 116129781L ^ (long)pos.func_177952_p();
        seed = seed * seed * 42317861L + seed * 11L;
        if (this.plantVariant == PlantVariant.MOSSPATCH) {
            final int xOff0 = (int)(seed >> 12 & 0x3L);
            final int xOff2 = (int)(seed >> 15 & 0x3L);
            final int zOff0 = (int)(seed >> 18 & 0x3L);
            final int zOff2 = (int)(seed >> 21 & 0x3L);
            final boolean xConnect0 = access.func_180495_p(pos.func_177974_f()).func_177230_c() == this && access.func_180495_p(pos.func_177974_f()).func_177230_c() == TFBlocks.moss_patch.get();
            final boolean xConnect2 = access.func_180495_p(pos.func_177976_e()).func_177230_c() == this && access.func_180495_p(pos.func_177976_e()).func_177230_c() == TFBlocks.moss_patch.get();
            final boolean zConnect0 = access.func_180495_p(pos.func_177968_d()).func_177230_c() == this && access.func_180495_p(pos.func_177978_c()).func_177230_c() == TFBlocks.moss_patch.get();
            final boolean zConnect2 = access.func_180495_p(pos.func_177978_c()).func_177230_c() == this && access.func_180495_p(pos.func_177968_d()).func_177230_c() == TFBlocks.moss_patch.get();
            return VoxelShapes.func_197881_a(new AxisAlignedBB(xConnect2 ? 0.0 : ((double)((1.0f + xOff2) / 16.0f)), 0.0, zConnect2 ? 0.0 : ((double)((1.0f + zOff2) / 16.0f)), xConnect0 ? 1.0 : ((double)((15.0f - xOff0) / 16.0f)), 0.0625, zConnect0 ? 1.0 : ((double)((15.0f - zOff0) / 16.0f))));
        }
        if (this.plantVariant == PlantVariant.CLOVERPATCH) {
            final int xOff0 = (int)(seed >> 12 & 0x3L);
            final int xOff2 = (int)(seed >> 15 & 0x3L);
            final int zOff0 = (int)(seed >> 18 & 0x3L);
            final int zOff2 = (int)(seed >> 21 & 0x3L);
            final int yOff0 = (int)(seed >> 24 & 0x1L);
            final int yOff2 = (int)(seed >> 27 & 0x1L);
            final boolean xConnect3 = access.func_180495_p(pos.func_177974_f()).func_177230_c() == this && access.func_180495_p(pos.func_177974_f()).func_177230_c() == TFBlocks.clover_patch.get();
            final boolean xConnect4 = access.func_180495_p(pos.func_177976_e()).func_177230_c() == this && access.func_180495_p(pos.func_177976_e()).func_177230_c() == TFBlocks.clover_patch.get();
            final boolean zConnect3 = access.func_180495_p(pos.func_177968_d()).func_177230_c() == this && access.func_180495_p(pos.func_177978_c()).func_177230_c() == TFBlocks.clover_patch.get();
            final boolean zConnect4 = access.func_180495_p(pos.func_177978_c()).func_177230_c() == this && access.func_180495_p(pos.func_177968_d()).func_177230_c() == TFBlocks.clover_patch.get();
            return VoxelShapes.func_197881_a(new AxisAlignedBB(xConnect4 ? 0.0 : ((double)((1.0f + xOff2) / 16.0f)), 0.0, zConnect4 ? 0.0 : ((double)((1.0f + zOff2) / 16.0f)), xConnect3 ? 1.0 : ((double)((15.0f - xOff0) / 16.0f)), (double)((1.0f + yOff0 + yOff2) / 16.0f), zConnect3 ? 1.0 : ((double)((15.0f - zOff0) / 16.0f))));
        }
        if (this.plantVariant == PlantVariant.MAYAPPLE) {
            return TFPlantBlock.MAYAPPLE_SHAPE;
        }
        if (this.plantVariant == PlantVariant.FALLEN_LEAVES) {
            return TFPlantBlock.FALLEN_LEAVES_SHAPE;
        }
        return VoxelShapes.func_197868_b();
    }
    
    public static boolean canPlaceRootAt(final IWorldReader world, final BlockPos pos) {
        final BlockState state = world.func_180495_p(pos.func_177984_a());
        return state.func_185904_a() == Material.field_151578_c || state.func_185904_a() == Material.field_151577_b || state.func_177230_c() == TFBlocks.root_strand.get() || state == ((Block)TFBlocks.root.get()).func_176223_P();
    }
    
    public PlantType getPlantType(final IBlockReader world, final BlockPos pos) {
        final BlockState blockState = world.func_180495_p(pos);
        if (blockState.func_177230_c() != this) {
            return PlantType.PLAINS;
        }
        switch (this.plantVariant) {
            case MUSHGLOOM:
            case MOSSPATCH: {
                return PlantType.CAVE;
            }
            default: {
                return PlantType.PLAINS;
            }
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_180655_c(final BlockState state, final World world, final BlockPos pos, final Random random) {
        super.func_180655_c(state, world, pos, random);
        if (state.func_177230_c() == TFBlocks.moss_patch.get() && random.nextInt(10) == 0) {
            world.func_195594_a((IParticleData)ParticleTypes.field_197596_G, (double)(pos.func_177958_n() + random.nextFloat()), (double)(pos.func_177956_o() + 0.1f), (double)(pos.func_177952_p() + random.nextFloat()), 0.0, 0.0, 0.0);
        }
        else if (state.func_177230_c() == TFBlocks.fallen_leaves.get() && random.nextInt(50) == 0) {
            float dist = 10.0f;
            if (!world.func_175710_j(pos)) {
                for (int y = 0; y <= dist; ++y) {
                    if (world.func_180495_p(pos.func_177981_b(y)).func_185904_a() == Material.field_151584_j) {
                        dist = (float)y;
                        break;
                    }
                }
                if (dist > 10.0f) {
                    return;
                }
            }
            final int color = Minecraft.func_71410_x().func_184125_al().func_228054_a_(Blocks.field_196642_W.func_176223_P(), (IBlockDisplayReader)world, pos, 0);
            final int r = MathHelper.func_76125_a((color >> 16 & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
            final int g = MathHelper.func_76125_a((color >> 8 & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
            final int b = MathHelper.func_76125_a((color & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
            world.func_195594_a((IParticleData)new LeafParticleData(r, g, b), (double)(pos.func_177958_n() + random.nextFloat()), (double)(pos.func_177956_o() + dist - 0.25f), (double)(pos.func_177952_p() + random.nextFloat()), 0.0, 0.0, 0.0);
        }
    }
    
    @Deprecated
    public void func_196262_a(final BlockState state, final World world, final BlockPos pos, final Entity entityIn) {
        super.func_196262_a(state, world, pos, entityIn);
        if (state.func_177230_c() == TFBlocks.fallen_leaves.get() && entityIn instanceof LivingEntity && (entityIn.func_213322_ci().func_82615_a() != 0.0 || entityIn.func_213322_ci().func_82616_c() != 0.0) && this.RANDOM.nextBoolean()) {
            if (world.field_72995_K) {
                final int color = Minecraft.func_71410_x().func_184125_al().func_228054_a_(Blocks.field_196642_W.func_176223_P(), (IBlockDisplayReader)world, pos, 0);
                final int r = MathHelper.func_76125_a((color >> 16 & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
                final int g = MathHelper.func_76125_a((color >> 8 & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
                final int b = MathHelper.func_76125_a((color & 0xFF) + this.RANDOM.nextInt(34) - 17, 0, 255);
                world.func_195594_a((IParticleData)new LeafParticleData(r, g, b), (double)(pos.func_177958_n() + world.field_73012_v.nextFloat()), (double)pos.func_177956_o(), (double)(pos.func_177952_p() + world.field_73012_v.nextFloat()), world.field_73012_v.nextFloat() * -0.5f * entityIn.func_213322_ci().func_82615_a(), (double)(world.field_73012_v.nextFloat() * 0.5f + 0.25f), world.field_73012_v.nextFloat() * -0.5f * entityIn.func_213322_ci().func_82616_c());
            }
            else if (world instanceof ServerWorld) {
                TFPacketHandler.CHANNEL.send(PacketDistributor.TRACKING_ENTITY.with(() -> entityIn), (Object)new SpawnFallenLeafFromPacket(pos, entityIn.func_213322_ci()));
            }
        }
    }
    
    public void func_190948_a(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        if (stack.func_77973_b() == ((Block)TFBlocks.clover_patch.get()).func_199767_j()) {
            tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.nyi"));
        }
        else if (stack.func_77973_b() == ((Block)TFBlocks.moss_patch.get()).func_199767_j()) {
            tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.wip0"));
            tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.wip1"));
        }
        super.func_190948_a(stack, worldIn, (List)tooltip, flagIn);
    }
    
    static {
        MAYAPPLE_SHAPE = func_208617_a(4.0, 0.0, 4.0, 13.0, 6.0, 13.0);
        FALLEN_LEAVES_SHAPE = func_208617_a(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    }
}
