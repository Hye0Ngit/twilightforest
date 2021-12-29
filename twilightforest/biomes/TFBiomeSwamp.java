// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import twilightforest.world.TFWorld;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.world.biome.SpawnListEntry;
import twilightforest.entity.EntityTFMosquitoSwarm;
import java.util.ArrayList;
import java.util.Random;

public class TFBiomeSwamp extends TFBiomeBase
{
    private static final int MONSTER_SPAWN_RATE = 20;
    Random monsterRNG;
    ArrayList emptyList;
    
    public TFBiomeSwamp(final int i) {
        super(i);
        this.monsterRNG = new Random(53439L);
        this.emptyList = new ArrayList();
        this.field_76748_D = -0.25f;
        this.field_76749_E = 0.0f;
        this.field_76750_F = 0.8f;
        this.field_76751_G = 0.9f;
        this.getTFBiomeDecorator().setDeadBushPerChunk(1);
        this.getTFBiomeDecorator().setMushroomsPerChunk(8);
        this.getTFBiomeDecorator().setReedsPerChunk(10);
        this.getTFBiomeDecorator().setClayPerChunk(1);
        this.getTFBiomeDecorator().setTreesPerChunk(2);
        this.getTFBiomeDecorator().setWaterlilyPerChunk(6);
        this.field_76759_H = 14745518;
        this.getTFBiomeDecorator().canopyPerChunk = -999;
        this.getTFBiomeDecorator().lakesPerChunk = 2;
        this.getTFBiomeDecorator().mangrovesPerChunk = 3;
        this.field_76761_J.add(new SpawnListEntry((Class)EntityTFMosquitoSwarm.class, 10, 1, 1));
        this.field_76761_J.add(new SpawnListEntry((Class)EntityCreeper.class, 10, 4, 4));
        this.field_76761_J.add(new SpawnListEntry((Class)EntityZombie.class, 10, 4, 4));
    }
    
    @Override
    public WorldGenerator func_76740_a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (WorldGenerator)new WorldGenShrub(3, 0);
        }
        return (WorldGenerator)this.field_76763_Q;
    }
    
    @Override
    public WorldGenerator func_76730_b(final Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return (WorldGenerator)new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 2);
        }
        if (par1Random.nextInt(4) == 0) {
            return (WorldGenerator)new WorldGenTallGrass(TFBlocks.plant.field_71990_ca, 4);
        }
        return (WorldGenerator)new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
    }
    
    public void func_76728_a(final World par1World, final Random par2Random, final int par3, final int par4) {
        super.func_76728_a(par1World, par2Random, par3, par4);
        final WorldGenVines worldgenvines = new WorldGenVines();
        for (int i = 0; i < 50; ++i) {
            final int j = par3 + par2Random.nextInt(16) + 8;
            final byte byte0 = (byte)TFWorld.SEALEVEL;
            final int k = par4 + par2Random.nextInt(16) + 8;
            worldgenvines.func_76484_a(par1World, par2Random, j, (int)byte0, k);
        }
    }
    
    @Override
    public int func_76737_k() {
        final double var1 = this.func_76743_j();
        final double var2 = this.func_76727_i();
        return ((ColorizerGrass.func_77480_a(var1, var2) & 0xFEFEFE) + 5115470) / 2;
    }
    
    @Override
    public int func_76726_l() {
        final double var1 = this.func_76743_j();
        final double var2 = this.func_76727_i();
        return ((ColorizerFoliage.func_77470_a(var1, var2) & 0xFEFEFE) + 5115470) / 2;
    }
    
    public List func_76747_a(final EnumCreatureType par1EnumCreatureType) {
        if (par1EnumCreatureType == EnumCreatureType.monster) {
            return (this.monsterRNG.nextInt(20) == 0) ? this.field_76761_J : this.emptyList;
        }
        return (par1EnumCreatureType == EnumCreatureType.creature) ? this.field_76762_K : ((par1EnumCreatureType == EnumCreatureType.waterCreature) ? this.field_76755_L : ((par1EnumCreatureType == EnumCreatureType.ambient) ? this.field_82914_M : null));
    }
}
