// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import net.minecraft.potion.PotionEffect;
import twilightforest.potions.TFPotions;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import twilightforest.world.feature.TFGenLargeWinter;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import twilightforest.entity.EntityTFWinterWolf;
import twilightforest.entity.EntityTFYeti;
import net.minecraft.world.biome.Biome;
import java.util.Random;

public class TFBiomeSnow extends TFBiomeBase
{
    private static final int MONSTER_SPAWN_RATE = 10;
    private final Random monsterRNG;
    
    public TFBiomeSnow(final Biome.BiomeProperties props) {
        super(props);
        this.monsterRNG = new Random(53439L);
        this.getTFBiomeDecorator().setTreesPerChunk(7);
        this.getTFBiomeDecorator().setGrassPerChunk(1);
        this.getTFBiomeDecorator().hasCanopy = false;
        this.getTFBiomeDecorator().field_76808_K = false;
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityTFYeti.class, 20, 4, 4));
        this.field_76761_J.add(new Biome.SpawnListEntry((Class)EntityTFWinterWolf.class, 5, 1, 4));
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
    
    public List<Biome.SpawnListEntry> func_76747_a(final EnumCreatureType creatureType) {
        if (creatureType == EnumCreatureType.MONSTER) {
            return (this.monsterRNG.nextInt(10) == 0) ? this.field_76761_J : new ArrayList<Biome.SpawnListEntry>();
        }
        return super.func_76747_a(creatureType);
    }
    
    @Override
    protected ResourceLocation[] getRequiredAdvancements() {
        return new ResourceLocation[] { TwilightForestMod.prefix("progress_lich") };
    }
    
    @Override
    public void enforceProgression(final EntityPlayer player, final World world) {
        if (!world.field_72995_K && player.field_70173_aa % 60 == 0) {
            player.func_70690_d(new PotionEffect(TFPotions.frosty, 100, 2));
            this.trySpawnHintMonster(player, world);
        }
    }
    
    @Override
    protected TFFeature getContainedFeature() {
        return TFFeature.YETI_CAVE;
    }
}
