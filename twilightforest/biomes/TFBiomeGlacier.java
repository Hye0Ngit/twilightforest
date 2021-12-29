// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.TFAchievementPage;
import net.minecraft.stats.Achievement;
import twilightforest.world.TFWorld;
import twilightforest.world.TFGenPenguins;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import net.minecraft.world.biome.BiomeGenBase;
import twilightforest.entity.passive.EntityTFPenguin;

public class TFBiomeGlacier extends TFBiomeBase
{
    public TFBiomeGlacier(final int i) {
        super(i);
        this.getTFBiomeDecorator().setTreesPerChunk(1);
        this.getTFBiomeDecorator().setGrassPerChunk(0);
        this.field_76750_F = 0.0f;
        this.field_76751_G = 0.1f;
        this.getTFBiomeDecorator().canopyPerChunk = -999.0f;
        this.field_76762_K.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFPenguin.class, 10, 4, 4));
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
    
    public void func_76728_a(final World par1World, final Random par2Random, final int par3, final int par4) {
        super.func_76728_a(par1World, par2Random, par3, par4);
        final TFGenPenguins penguins = new TFGenPenguins();
        if (par2Random.nextInt(4) == 0) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            penguins.func_76484_a(par1World, par2Random, j, byte0, k);
        }
    }
    
    @Override
    protected Achievement getRequiredAchievement() {
        return TFAchievementPage.twilightProgressUrghast;
    }
    
    @Override
    public void enforceProgession(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && world.func_72820_D() % 60L == 0L) {
            player.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 100, 3));
        }
        if (world.field_73012_v.nextInt(4) == 0) {
            TFFeature.iceTower.trySpawnHintMonster(world, player);
        }
    }
}
