// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import twilightforest.entity.EntityTFTroll;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.entity.monster.EntitySkeleton;

public class TFBiomeHighlands extends TFBiomeBase
{
    public TFBiomeHighlands(final int i) {
        super(i);
        this.field_76750_F = 0.3f;
        this.field_76751_G = 0.7f;
        ((TFBiomeDecorator)this.field_76760_I).canopyPerChunk = -999.0f;
        this.undergroundMonsterList.clear();
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntitySkeleton.class, 10, 4, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityCreeper.class, 1, 4, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntitySlime.class, 10, 4, 4));
        this.undergroundMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFTroll.class, 10, 4, 4));
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(final Random random) {
        if (random.nextInt(4) == 0) {
            return (WorldGenAbstractTree)new WorldGenBigTree(false);
        }
        if (random.nextInt(10) == 0) {
            return (WorldGenAbstractTree)new WorldGenTaiga2(true);
        }
        return (WorldGenAbstractTree)this.birchGen;
    }
    
    @Override
    public void func_150573_a(final World world, final Random rand, final Block[] blockStorage, final byte[] metaStorage, final int x, final int z, final double noiseVal) {
        this.genTwilightBiomeTerrain(world, rand, blockStorage, metaStorage, x, z, noiseVal);
    }
}
