// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.util.ChunkCoordinates;
import twilightforest.TFFeature;
import net.minecraft.world.ChunkPosition;
import java.util.Random;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.World;
import twilightforest.world.layer.GenLayerTF;
import twilightforest.TwilightForestMod;
import net.minecraft.world.WorldType;
import twilightforest.biomes.TFBiomeBase;
import java.util.ArrayList;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.List;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.biome.WorldChunkManager;

public class TFWorldChunkManager extends WorldChunkManager
{
    private GenLayer unzoomedBiomes;
    private GenLayer zoomedBiomes;
    private BiomeCache myBiomeCache;
    private List<BiomeGenBase> myBiomesToSpawnIn;
    
    protected TFWorldChunkManager() {
        this.myBiomeCache = new BiomeCache((WorldChunkManager)this);
        (this.myBiomesToSpawnIn = new ArrayList<BiomeGenBase>()).add(TFBiomeBase.twilightForest);
        this.myBiomesToSpawnIn.add(TFBiomeBase.twilightForest2);
        this.myBiomesToSpawnIn.add(TFBiomeBase.clearing);
        this.myBiomesToSpawnIn.add(TFBiomeBase.tfSwamp);
        this.myBiomesToSpawnIn.add(TFBiomeBase.mushrooms);
    }
    
    public TFWorldChunkManager(final long par1, final WorldType par3WorldType) {
        this();
        GenLayer[] agenlayer;
        if (TwilightForestMod.oldMapGen) {
            agenlayer = GenLayerTF.makeTheWorldOldMapGen(par1);
        }
        else {
            agenlayer = GenLayerTF.makeTheWorld(par1);
        }
        this.unzoomedBiomes = agenlayer[0];
        this.zoomedBiomes = agenlayer[1];
    }
    
    public TFWorldChunkManager(final World par1World) {
        this(par1World.func_72905_C(), par1World.func_72912_H().func_76067_t());
    }
    
    public List func_76932_a() {
        return this.myBiomesToSpawnIn;
    }
    
    public BiomeGenBase func_76935_a(final int par1, final int par2) {
        final BiomeGenBase biome = this.myBiomeCache.func_76837_b(par1, par2);
        if (biome == null) {
            return TFBiomeBase.twilightForest;
        }
        return biome;
    }
    
    public float[] func_76936_a(float[] par1ArrayOfFloat, final int par2, final int par3, final int par4, final int par5) {
        IntCache.func_76446_a();
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
            par1ArrayOfFloat = new float[par4 * par5];
        }
        final int[] ai = this.zoomedBiomes.func_75904_a(par2, par3, par4, par5);
        for (int i = 0; i < par4 * par5; ++i) {
            if (ai[i] >= 0 && BiomeGenBase.func_150568_d(ai[i]) != null) {
                float f = BiomeGenBase.func_150568_d(ai[i]).func_76744_g() / 65536.0f;
                if (f > 1.0f) {
                    f = 1.0f;
                }
                par1ArrayOfFloat[i] = f;
            }
        }
        return par1ArrayOfFloat;
    }
    
    public float func_76939_a(final float par1, final int par2) {
        return par1;
    }
    
    public BiomeGenBase[] func_76937_a(BiomeGenBase[] par1ArrayOfBiomeGenBase, final int x, final int z, final int length, final int width) {
        IntCache.func_76446_a();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < length * width) {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[length * width];
        }
        final int[] arrayOfInts = this.unzoomedBiomes.func_75904_a(x, z, length, width);
        for (int i = 0; i < length * width; ++i) {
            if (arrayOfInts[i] >= 0) {
                par1ArrayOfBiomeGenBase[i] = BiomeGenBase.func_150568_d(arrayOfInts[i]);
            }
            else {
                par1ArrayOfBiomeGenBase[i] = TFBiomeBase.twilightForest;
            }
        }
        return par1ArrayOfBiomeGenBase;
    }
    
    public BiomeGenBase[] func_76933_b(final BiomeGenBase[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        return this.func_76931_a(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
    }
    
    public BiomeGenBase[] func_76931_a(BiomeGenBase[] par1ArrayOfBiomeGenBase, final int x, final int y, final int width, final int length, final boolean cacheFlag) {
        IntCache.func_76446_a();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < width * length) {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[width * length];
        }
        if (cacheFlag && width == 16 && length == 16 && (x & 0xF) == 0x0 && (y & 0xF) == 0x0) {
            final BiomeGenBase[] abiomegenbase = this.myBiomeCache.func_76839_e(x, y);
            System.arraycopy(abiomegenbase, 0, (Object)par1ArrayOfBiomeGenBase, 0, width * length);
            return par1ArrayOfBiomeGenBase;
        }
        final int[] ai = this.zoomedBiomes.func_75904_a(x, y, width, length);
        for (int i = 0; i < width * length; ++i) {
            if (ai[i] >= 0) {
                par1ArrayOfBiomeGenBase[i] = BiomeGenBase.func_150568_d(ai[i]);
            }
            else {
                par1ArrayOfBiomeGenBase[i] = TFBiomeBase.twilightForest;
            }
        }
        return par1ArrayOfBiomeGenBase;
    }
    
    public boolean func_76940_a(final int par1, final int par2, final int par3, final List par4List) {
        final int i = par1 - par3 >> 2;
        final int j = par2 - par3 >> 2;
        final int k = par1 + par3 >> 2;
        final int l = par2 + par3 >> 2;
        final int i2 = k - i + 1;
        final int j2 = l - j + 1;
        final int[] ai = this.unzoomedBiomes.func_75904_a(i, j, i2, j2);
        for (int k2 = 0; k2 < i2 * j2; ++k2) {
            final BiomeGenBase biomegenbase = BiomeGenBase.func_150568_d(ai[k2]);
            if (!par4List.contains(biomegenbase)) {
                return false;
            }
        }
        return true;
    }
    
    public ChunkPosition func_150795_a(final int par1, final int par2, final int par3, final List par4List, final Random par5Random) {
        final int i = par1 - par3 >> 2;
        final int j = par2 - par3 >> 2;
        final int k = par1 + par3 >> 2;
        final int l = par2 + par3 >> 2;
        final int i2 = k - i + 1;
        final int j2 = l - j + 1;
        final int[] ai = this.unzoomedBiomes.func_75904_a(i, j, i2, j2);
        ChunkPosition chunkposition = null;
        int k2 = 0;
        for (int l2 = 0; l2 < ai.length; ++l2) {
            final int i3 = i + l2 % i2 << 2;
            final int j3 = j + l2 / i2 << 2;
            final BiomeGenBase biomegenbase = BiomeGenBase.func_150568_d(ai[l2]);
            if (par4List.contains(biomegenbase) && (chunkposition == null || par5Random.nextInt(k2 + 1) == 0)) {
                chunkposition = new ChunkPosition(i3, 0, j3);
                ++k2;
            }
        }
        return chunkposition;
    }
    
    public void func_76938_b() {
        this.myBiomeCache.func_76838_a();
    }
    
    public int getFeatureID(final int mapX, final int mapZ, final World world) {
        return this.getFeatureAt(mapX, mapZ, world).featureID;
    }
    
    public TFFeature getFeatureAt(final int mapX, final int mapZ, final World world) {
        return TFFeature.generateFeatureFor1Point7(mapX >> 4, mapZ >> 4, world);
    }
    
    public boolean isInFeatureChunk(final World world, final int mapX, final int mapZ) {
        if (TwilightForestMod.oldMapGen) {
            return this.isInFeatureChunkOld(world, mapX, mapZ);
        }
        final int chunkX = mapX >> 4;
        final int chunkZ = mapZ >> 4;
        final ChunkCoordinates cc = TFFeature.getNearestCenterXYZ(chunkX, chunkZ, world);
        return chunkX == cc.field_71574_a >> 4 && chunkZ == cc.field_71573_c >> 4;
    }
    
    public boolean isInFeatureChunkOld(final World world, final int mapX, final int mapZ) {
        final int chunkX = mapX >> 4;
        final int chunkZ = mapZ >> 4;
        return chunkX % 16 == 0 && chunkZ % 16 == 0;
    }
}
