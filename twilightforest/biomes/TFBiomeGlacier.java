// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import net.minecraft.potion.PotionEffect;
import twilightforest.potions.TFPotions;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.WorldGenerator;
import twilightforest.world.feature.TFGenPenguins;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import twilightforest.entity.passive.EntityTFPenguin;
import net.minecraft.world.biome.Biome;

public class TFBiomeGlacier extends TFBiomeBase
{
    public TFBiomeGlacier(final Biome.BiomeProperties props) {
        super(props);
        this.getTFBiomeDecorator().setTreesPerChunk(1);
        this.getTFBiomeDecorator().setGrassPerChunk(0);
        this.getTFBiomeDecorator().hasCanopy = false;
        this.field_76762_K.clear();
        this.field_76762_K.add(new Biome.SpawnListEntry((Class)EntityTFPenguin.class, 10, 4, 4));
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (WorldGenAbstractTree)new WorldGenTaiga1();
        }
        return (WorldGenAbstractTree)new WorldGenTaiga2(true);
    }
    
    public boolean func_76746_c() {
        return true;
    }
    
    public boolean func_76738_d() {
        return false;
    }
    
    public void func_180624_a(final World world, final Random random, final BlockPos pos) {
        super.func_180624_a(world, random, pos);
        final WorldGenerator penguins = new TFGenPenguins();
        if (random.nextInt(4) == 0) {
            final int x = pos.func_177958_n() + random.nextInt(16) + 8;
            final int y = 31;
            final int z = pos.func_177952_p() + random.nextInt(16) + 8;
            penguins.func_180709_b(world, random, new BlockPos(x, y, z));
        }
    }
    
    @Override
    protected ResourceLocation[] getRequiredAdvancements() {
        return new ResourceLocation[] { TwilightForestMod.prefix("progress_yeti") };
    }
    
    @Override
    public void enforceProgression(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && player.field_70173_aa % 60 == 0) {
            player.func_70690_d(new PotionEffect(TFPotions.frosty, 100, 3));
        }
        this.trySpawnHintMonster(player, world);
    }
    
    @Override
    protected TFFeature getContainedFeature() {
        return TFFeature.ICE_TOWER;
    }
}
