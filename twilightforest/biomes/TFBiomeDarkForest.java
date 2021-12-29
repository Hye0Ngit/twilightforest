// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.TFAchievementPage;
import net.minecraft.stats.Achievement;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.entity.monster.EntityWitch;
import twilightforest.entity.EntityTFKobold;
import twilightforest.entity.EntityTFKingSpider;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.EntityTFMistWolf;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.ArrayList;
import java.util.Random;

public class TFBiomeDarkForest extends TFBiomeBase
{
    private static final int MONSTER_SPAWN_RATE = 20;
    Random monsterRNG;
    ArrayList<BiomeGenBase.SpawnListEntry> emptyList;
    
    public TFBiomeDarkForest(final int i) {
        super(i);
        this.emptyList = new ArrayList<BiomeGenBase.SpawnListEntry>();
        this.field_76750_F = 0.7f;
        this.field_76751_G = 0.8f;
        this.getTFBiomeDecorator().canopyPerChunk = 5.5f;
        this.getTFBiomeDecorator().setTreesPerChunk(10);
        this.getTFBiomeDecorator().setGrassPerChunk(-99);
        this.getTFBiomeDecorator().setFlowersPerChunk(-99);
        this.getTFBiomeDecorator().setMushroomsPerChunk(2);
        this.getTFBiomeDecorator().setDeadBushPerChunk(10);
        this.field_76748_D = 0.05f;
        this.field_76749_E = 0.05f;
        this.monsterRNG = new Random();
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityEnderman.class, 1, 1, 4));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityZombie.class, 5, 1, 4));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntitySkeleton.class, 5, 1, 4));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFMistWolf.class, 10, 1, 4));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFSkeletonDruid.class, 10, 1, 4));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFKingSpider.class, 10, 1, 4));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFKobold.class, 10, 4, 8));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry((Class)EntityWitch.class, 1, 1, 1));
    }
    
    @Override
    public BiomeDecorator func_76729_a() {
        return new TFDarkForestBiomeDecorator();
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(5) == 0) {
            return (WorldGenAbstractTree)new WorldGenShrub(3, 0);
        }
        if (random.nextInt(8) == 0) {
            return (WorldGenAbstractTree)this.birchGen;
        }
        return (WorldGenAbstractTree)this.field_76757_N;
    }
    
    @Override
    public int func_150558_b(final int x, final int y, final int z) {
        final double var1 = this.func_150564_a(x, y, z);
        final double var2 = this.func_76727_i();
        return ((ColorizerGrass.func_77480_a(var1, var2) & 0xFEFEFE) + 1969742) / 2;
    }
    
    @Override
    public int func_150571_c(final int x, final int y, final int z) {
        final double var1 = this.func_150564_a(x, y, z);
        final double var2 = this.func_76727_i();
        return ((ColorizerFoliage.func_77470_a(var1, var2) & 0xFEFEFE) + 1969742) / 2;
    }
    
    public List func_76747_a(final EnumCreatureType par1EnumCreatureType) {
        if (par1EnumCreatureType == EnumCreatureType.monster) {
            return (this.monsterRNG.nextInt(20) == 0) ? this.field_76761_J : this.emptyList;
        }
        return (par1EnumCreatureType == EnumCreatureType.creature) ? this.field_76762_K : ((par1EnumCreatureType == EnumCreatureType.waterCreature) ? this.field_76755_L : ((par1EnumCreatureType == EnumCreatureType.ambient) ? this.field_82914_M : null));
    }
    
    public boolean func_76736_e() {
        return true;
    }
    
    @Override
    protected Achievement getRequiredAchievement() {
        return TFAchievementPage.twilightProgressHydra;
    }
    
    @Override
    public void enforceProgession(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && world.func_72820_D() % 60L == 0L) {
            player.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 100, 0));
        }
    }
}
