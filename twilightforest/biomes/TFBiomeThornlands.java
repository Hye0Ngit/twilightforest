// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.state.IBlockState;
import twilightforest.world.TFWorld;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.DeadrockVariant;
import twilightforest.block.BlockTFDeadrock;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import twilightforest.world.feature.TFGenThorns;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.Block;
import java.util.function.Predicate;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFBiomeThornlands extends TFBiomeBase
{
    private final WorldGenerator tfGenThorns;
    private final Predicate<Block> otherGround;
    
    public TFBiomeThornlands(final Biome.BiomeProperties props) {
        super(props);
        this.tfGenThorns = new TFGenThorns();
        this.otherGround = (block -> block == Blocks.field_150322_A || block == Blocks.field_150354_m || block == Blocks.field_150435_aG || block == TFBlocks.deadrock);
        this.field_76752_A = TFBlocks.deadrock.func_176223_P().func_177226_a((IProperty)BlockTFDeadrock.VARIANT, (Comparable)DeadrockVariant.SURFACE);
        this.field_76753_B = TFBlocks.deadrock.func_176223_P().func_177226_a((IProperty)BlockTFDeadrock.VARIANT, (Comparable)DeadrockVariant.CRACKED);
        this.getTFBiomeDecorator().hasCanopy = false;
        this.getTFBiomeDecorator().setTreesPerChunk(-999);
        this.field_76760_I.field_76804_C = 2;
        this.field_76760_I.field_76800_F = -9999;
        this.field_76762_K.clear();
        this.field_76760_I.field_76808_K = false;
    }
    
    public void func_180624_a(final World world, final Random rand, final BlockPos pos) {
        for (int i = 0; i < 128; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
            final int ry = TFWorld.getGroundLevel(world, rx, rz, this.otherGround);
            this.tfGenThorns.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
        }
    }
    
    @Override
    public IBlockState getStoneReplacementState() {
        return TFBlocks.deadrock.func_176223_P().func_177226_a((IProperty)BlockTFDeadrock.VARIANT, (Comparable)DeadrockVariant.SOLID);
    }
    
    @Override
    protected ResourceLocation[] getRequiredAdvancements() {
        return new ResourceLocation[] { TwilightForestMod.prefix("progress_troll") };
    }
    
    @Override
    public void enforceProgression(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && player.field_70173_aa % 5 == 0) {
            player.func_70097_a(DamageSource.field_76376_m, 1.0f);
            world.func_184148_a((EntityPlayer)null, player.field_70165_t, player.field_70163_u, player.field_70161_v, SoundEvents.field_187541_bC, SoundCategory.PLAYERS, 1.0f, 1.0f);
            if (world.field_73012_v.nextInt(4) == 0) {
                TFFeature.TROLL_CAVE.trySpawnHintMonster(world, player);
            }
        }
    }
}
