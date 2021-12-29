// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.world.TFWorld;
import twilightforest.world.TFGenPenguins;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Random;
import net.minecraft.world.biome.SpawnListEntry;
import twilightforest.entity.passive.EntityTFPenguin;

public class TFBiomeGlacier extends TFBiomeBase
{
    public TFBiomeGlacier(final int i) {
        super(i);
        this.getTFBiomeDecorator().setTreesPerChunk(1);
        this.getTFBiomeDecorator().setGrassPerChunk(0);
        this.field_76750_F = 0.0f;
        this.field_76751_G = 0.1f;
        this.getTFBiomeDecorator().canopyPerChunk = -999;
        this.field_76762_K.add(new SpawnListEntry((Class)EntityTFPenguin.class, 10, 4, 4));
    }
    
    @Override
    public WorldGenerator func_76740_a(final Random random) {
        if (random.nextInt(3) == 0) {
            return (WorldGenerator)new WorldGenTaiga1();
        }
        return (WorldGenerator)new WorldGenTaiga2(true);
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
}
