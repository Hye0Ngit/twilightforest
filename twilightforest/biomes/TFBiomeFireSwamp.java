// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.entity.player.EntityPlayer;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.gen.feature.WorldGenerator;
import twilightforest.world.feature.TFGenFireJet;
import twilightforest.enums.FireJetVariant;
import twilightforest.world.feature.TFGenVines;
import twilightforest.TFFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import net.minecraft.world.biome.Biome;

public class TFBiomeFireSwamp extends TFBiomeBase
{
    public TFBiomeFireSwamp(final Biome.BiomeProperties props) {
        super(props);
        this.getTFBiomeDecorator().setDeadBushPerChunk(2);
        this.getTFBiomeDecorator().setMushroomsPerChunk(8);
        this.getTFBiomeDecorator().setReedsPerChunk(4);
        this.getTFBiomeDecorator().setClayPerChunk(1);
        this.getTFBiomeDecorator().setTreesPerChunk(3);
        this.getTFBiomeDecorator().setWaterlilyPerChunk(6);
        this.getTFBiomeDecorator().hasCanopy = false;
        this.getTFBiomeDecorator().lavaPoolChance = 0.125f;
        this.getTFBiomeDecorator().mangrovesPerChunk = 3;
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (WorldGenAbstractTree)new WorldGenShrub(Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.JUNGLE), Blocks.field_150362_t.func_176223_P().func_177226_a((IProperty)BlockOldLeaf.field_176239_P, (Comparable)BlockPlanks.EnumType.OAK).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false));
        }
        return (WorldGenAbstractTree)TFBiomeFireSwamp.field_76763_Q;
    }
    
    public void func_180624_a(final World world, final Random rand, final BlockPos pos) {
        super.func_180624_a(world, rand, pos);
        final TFFeature nearFeature = TFFeature.getNearestFeature(pos.func_177958_n() >> 4, pos.func_177952_p() >> 4, world);
        if (nearFeature.areChunkDecorationsEnabled) {
            final BlockPos.MutableBlockPos mutPos = new BlockPos.MutableBlockPos();
            final WorldGenerator vines = new TFGenVines();
            for (int i = 0; i < 20; ++i) {
                final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
                final int ry = 159;
                final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
                vines.func_180709_b(world, rand, (BlockPos)mutPos.func_181079_c(rx, ry, rz));
            }
            final WorldGenerator genSmoker = new TFGenFireJet(FireJetVariant.SMOKER);
            if (rand.nextInt(4) == 0) {
                final int rx = pos.func_177958_n() + rand.nextInt(14) + 8;
                final int ry = 31;
                final int rz = pos.func_177952_p() + rand.nextInt(14) + 8;
                genSmoker.func_180709_b(world, rand, (BlockPos)mutPos.func_181079_c(rx, ry, rz));
            }
            final WorldGenerator genFireJet = new TFGenFireJet(FireJetVariant.JET_IDLE);
            for (int j = 0; j < 1; ++j) {
                final int rx2 = pos.func_177958_n() + rand.nextInt(14) + 8;
                final int ry2 = 31;
                final int rz2 = pos.func_177952_p() + rand.nextInt(14) + 8;
                genFireJet.func_180709_b(world, rand, (BlockPos)mutPos.func_181079_c(rx2, ry2, rz2));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int func_180627_b(final BlockPos pos) {
        return 5713443;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_180625_c(final BlockPos pos) {
        return 6563343;
    }
    
    @Override
    protected ResourceLocation[] getRequiredAdvancements() {
        return new ResourceLocation[] { TwilightForestMod.prefix("progress_labyrinth") };
    }
    
    @Override
    public void enforceProgression(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && player.field_70173_aa % 60 == 0) {
            player.func_70015_d(8);
        }
        this.trySpawnHintMonster(player, world);
    }
    
    @Override
    protected TFFeature getContainedFeature() {
        return TFFeature.HYDRA_LAIR;
    }
}
