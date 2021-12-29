// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.state.properties.BlockStateProperties;
import java.util.Random;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.util.IItemProvider;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.state.StateContainer;
import net.minecraft.pathfinding.PathType;
import twilightforest.tileentity.TrophyTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;
import twilightforest.enums.BossVariant;
import net.minecraft.block.ContainerBlock;

public abstract class AbstractTrophyBlock extends ContainerBlock
{
    private final BossVariant variant;
    private final int comparatorValue;
    public static final BooleanProperty POWERED;
    
    protected AbstractTrophyBlock(final BossVariant variant, final int value, final AbstractBlock.Properties builder) {
        super(builder);
        this.variant = variant;
        this.comparatorValue = value;
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)AbstractTrophyBlock.POWERED, (Comparable)false));
    }
    
    public int getComparatorValue() {
        return this.comparatorValue;
    }
    
    public void func_220069_a(final BlockState state, final World worldIn, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        if (!worldIn.field_72995_K) {
            final boolean flag = worldIn.func_175640_z(pos);
            if (flag != (boolean)state.func_177229_b((Property)AbstractTrophyBlock.POWERED)) {
                if (flag) {
                    this.playSound(worldIn, pos);
                }
                worldIn.func_175656_a(pos, (BlockState)state.func_206870_a((Property)AbstractTrophyBlock.POWERED, (Comparable)flag));
            }
        }
    }
    
    public ActionResultType func_225533_a_(final BlockState state, final World worldIn, final BlockPos pos, final PlayerEntity playerIn, final Hand handIn, final BlockRayTraceResult hit) {
        this.playSound(worldIn, pos);
        this.createParticle(worldIn, pos);
        return ActionResultType.SUCCESS;
    }
    
    public TileEntity func_196283_a_(final IBlockReader worldIn) {
        return new TrophyTileEntity();
    }
    
    public BossVariant getVariant() {
        return this.variant;
    }
    
    public boolean func_196266_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final PathType type) {
        return false;
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        builder.func_206894_a(new Property[] { (Property)AbstractTrophyBlock.POWERED });
    }
    
    public void playSound(final World world, final BlockPos pos) {
        final TileEntity te = world.func_175625_s(pos);
        if (!world.field_72995_K && te instanceof TrophyTileEntity) {
            SoundEvent sound = null;
            float volume = 1.0f;
            float pitch = 0.9f;
            switch (this.variant) {
                case NAGA: {
                    sound = TFSounds.NAGA_RATTLE;
                    volume = 1.25f;
                    pitch = 1.2f;
                    break;
                }
                case LICH: {
                    sound = TFSounds.LICH_AMBIENT;
                    volume = 0.35f;
                    pitch = 1.1f;
                    break;
                }
                case HYDRA: {
                    sound = TFSounds.HYDRA_GROWL;
                    pitch = 1.2f;
                    break;
                }
                case UR_GHAST: {
                    sound = TFSounds.URGHAST_AMBIENT;
                    pitch = 0.6f;
                    break;
                }
                case SNOW_QUEEN: {
                    sound = TFSounds.SNOW_QUEEN_AMBIENT;
                    break;
                }
                case KNIGHT_PHANTOM: {
                    sound = TFSounds.PHANTOM_AMBIENT;
                    pitch = 1.1f;
                    break;
                }
                case MINOSHROOM: {
                    sound = TFSounds.MINOSHROOM_AMBIENT;
                    volume = 0.75f;
                    pitch = 0.7f;
                    break;
                }
                case ALPHA_YETI: {
                    sound = ((world.field_73012_v.nextInt(50) == 0) ? TFSounds.ALPHAYETI_ROAR : TFSounds.ALPHAYETI_GROWL);
                    volume = 0.75f;
                    pitch = 0.75f;
                    break;
                }
                case QUEST_RAM: {
                    sound = TFSounds.QUEST_RAM_AMBIENT;
                    pitch = 0.7f;
                    break;
                }
            }
            if (sound != null) {
                world.func_184133_a((PlayerEntity)null, pos, sound, SoundCategory.BLOCKS, volume, world.field_73012_v.nextFloat() * 0.1f + pitch);
            }
        }
    }
    
    public void createParticle(final World world, final BlockPos pos) {
        final TileEntity te = world.func_175625_s(pos);
        if (te instanceof TrophyTileEntity) {
            final Random rand = world.func_201674_k();
            if (world instanceof ServerWorld) {
                switch (this.variant) {
                    case NAGA: {
                        for (int daze = 0; daze < 10; ++daze) {
                            ((ServerWorld)world).func_195598_a((IParticleData)ParticleTypes.field_197614_g, pos.func_177958_n() + rand.nextFloat() * 0.5 * 2.0, pos.func_177956_o() + 0.25, pos.func_177952_p() + rand.nextFloat() * 0.5 * 2.0, 1, 0.0, 0.0, 0.0, rand.nextGaussian() * 0.02);
                        }
                        break;
                    }
                    case LICH: {
                        for (int a = 0; a < 5; ++a) {
                            ((ServerWorld)world).func_195598_a((IParticleData)ParticleTypes.field_197609_b, pos.func_177958_n() + rand.nextFloat() * 0.5 * 2.0, pos.func_177956_o() + 0.5 + rand.nextFloat() * 0.25, pos.func_177952_p() + rand.nextFloat() * 0.5 * 2.0, 1, rand.nextGaussian() * 0.02, rand.nextGaussian() * 0.02, rand.nextGaussian() * 0.02, 0.0);
                        }
                        break;
                    }
                    case MINOSHROOM: {
                        for (int g = 0; g < 10; ++g) {
                            ((ServerWorld)world).func_195598_a((IParticleData)new BlockParticleData(ParticleTypes.field_197611_d, world.func_180495_p(pos.func_177977_b())), pos.func_177958_n() + (double)(rand.nextFloat() * 10.0f) - 5.0, pos.func_177956_o() + 0.10000000149011612 + rand.nextFloat() * 0.3f, pos.func_177952_p() + (double)(rand.nextFloat() * 10.0f) - 5.0, 1, 0.0, 0.0, 0.0, 0.0);
                        }
                        break;
                    }
                    case KNIGHT_PHANTOM: {
                        for (int brek = 0; brek < 10; ++brek) {
                            ((ServerWorld)world).func_195598_a((IParticleData)new ItemParticleData(ParticleTypes.field_197591_B, new ItemStack((IItemProvider)TFItems.knightmetal_sword.get())), pos.func_177958_n() + 0.5 + (rand.nextFloat() - 0.5), pos.func_177956_o() + rand.nextFloat() + 0.5, pos.func_177952_p() + 0.5 + (rand.nextFloat() - 0.5), 1, 0.0, 0.25, 0.0, 0.0);
                        }
                        break;
                    }
                    case UR_GHAST: {
                        for (int red = 0; red < 10; ++red) {
                            ((ServerWorld)world).func_195598_a((IParticleData)RedstoneParticleData.field_197564_a, pos.func_177958_n() + rand.nextDouble() * 1.0 - 0.25, pos.func_177956_o() + rand.nextDouble() * 0.5 + 0.5, pos.func_177952_p() + rand.nextDouble() * 1.0, 1, 0.0, 0.0, 0.0, 0.0);
                        }
                        break;
                    }
                    case ALPHA_YETI: {
                        for (int sweat = 0; sweat < 10; ++sweat) {
                            ((ServerWorld)world).func_195598_a((IParticleData)ParticleTypes.field_218422_X, pos.func_177958_n() + rand.nextDouble() * 1.0 - 0.25, pos.func_177956_o() + rand.nextDouble() * 0.5 + 0.5, pos.func_177952_p() + rand.nextDouble() * 1.0, 1, 0.0, 0.0, 0.0, 0.0);
                        }
                        break;
                    }
                    case SNOW_QUEEN: {
                        for (int b = 0; b < 20; ++b) {
                            ((ServerWorld)world).func_195598_a((IParticleData)TFParticleType.SNOW_WARNING.get(), pos.func_177958_n() - 1.0 + rand.nextDouble() * 3.25, pos.func_177956_o() + 5.0, pos.func_177952_p() - 1.0 + rand.nextDouble() * 3.25, 1, 0.0, 1.0, 0.0, 0.0);
                        }
                        break;
                    }
                    case QUEST_RAM: {
                        for (int p = 0; p < 10; ++p) {
                            ((ServerWorld)world).func_195598_a((IParticleData)ParticleTypes.field_197625_r, pos.func_177958_n() + 0.5 + (rand.nextDouble() - 0.5), pos.func_177956_o() + (rand.nextDouble() - 0.5), pos.func_177952_p() + 0.5 + (rand.nextDouble() - 0.5), 1, (double)rand.nextFloat(), (double)rand.nextFloat(), (double)rand.nextFloat(), 1.0);
                        }
                        break;
                    }
                }
            }
        }
    }
    
    static {
        POWERED = BlockStateProperties.field_208194_u;
    }
}
