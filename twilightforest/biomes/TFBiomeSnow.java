// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.TFAchievementPage;
import net.minecraft.stats.Achievement;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import twilightforest.world.TFGenLargeWinter;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import twilightforest.entity.EntityTFWinterWolf;
import twilightforest.entity.EntityTFYeti;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.ArrayList;
import java.util.Random;

public class TFBiomeSnow extends TFBiomeBase
{
    private static final int MONSTER_SPAWN_RATE = 10;
    Random monsterRNG;
    ArrayList<BiomeGenBase.SpawnListEntry> emptyList;
    
    public TFBiomeSnow(final int i) {
        super(i);
        this.monsterRNG = new Random(53439L);
        this.emptyList = new ArrayList<BiomeGenBase.SpawnListEntry>();
        this.getTFBiomeDecorator().setTreesPerChunk(7);
        this.getTFBiomeDecorator().setGrassPerChunk(1);
        this.field_76750_F = 0.125f;
        this.field_76751_G = 0.9f;
        this.getTFBiomeDecorator().canopyPerChunk = -999.0f;
        this.getTFBiomeDecorator().field_76808_K = false;
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFYeti.class, 20, 4, 4));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFWinterWolf.class, 5, 1, 4));
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (WorldGenAbstractTree)new WorldGenTaiga1();
        }
        if (random.nextInt(8) == 0) {
            return new TFGenLargeWinter();
        }
        return (WorldGenAbstractTree)new WorldGenTaiga2(true);
    }
    
    public boolean func_76746_c() {
        return true;
    }
    
    public boolean func_76738_d() {
        return false;
    }
    
    public List func_76747_a(final EnumCreatureType par1EnumCreatureType) {
        if (par1EnumCreatureType == EnumCreatureType.monster) {
            return (this.monsterRNG.nextInt(10) == 0) ? this.field_76761_J : this.emptyList;
        }
        return (par1EnumCreatureType == EnumCreatureType.creature) ? this.field_76762_K : ((par1EnumCreatureType == EnumCreatureType.waterCreature) ? this.field_76755_L : ((par1EnumCreatureType == EnumCreatureType.ambient) ? this.field_82914_M : null));
    }
    
    @Override
    protected Achievement getRequiredAchievement() {
        return TFAchievementPage.twilightProgressUrghast;
    }
    
    @Override
    public void enforceProgession(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && world.func_72820_D() % 60L == 0L) {
            player.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 100, 2));
            if (world.field_73012_v.nextInt(4) == 0) {
                TFFeature.yetiCave.trySpawnHintMonster(world, player);
            }
        }
    }
}
