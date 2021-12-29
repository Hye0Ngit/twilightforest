// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import twilightforest.entity.passive.RavenEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.block.Blocks;
import net.minecraft.world.IWorld;
import twilightforest.util.FeatureUtil;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenMonolith extends Feature<NoFeatureConfig>
{
    public TFGenMonolith(final Codec<NoFeatureConfig> configIn) {
        super((Codec)configIn);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        final int ht = rand.nextInt(10) + 10;
        final int dir = rand.nextInt(4);
        if (!FeatureUtil.isAreaSuitable((IWorld)world, pos, 2, ht, 2)) {
            return false;
        }
        int h0 = 0;
        int h2 = 0;
        int h3 = 0;
        int h4 = 0;
        switch (dir) {
            case 0: {
                h0 = ht;
                h2 = (int)(ht * 0.75);
                h3 = (int)(ht * 0.75);
                h4 = (int)(ht * 0.5);
                break;
            }
            case 1: {
                h0 = (int)(ht * 0.5);
                h2 = ht;
                h3 = (int)(ht * 0.75);
                h4 = (int)(ht * 0.75);
                break;
            }
            case 2: {
                h0 = (int)(ht * 0.75);
                h2 = (int)(ht * 0.5);
                h3 = ht;
                h4 = (int)(ht * 0.75);
                break;
            }
            default: {
                h0 = (int)(ht * 0.75);
                h2 = (int)(ht * 0.75);
                h3 = (int)(ht * 0.5);
                h4 = ht;
                break;
            }
        }
        for (int cy = 0; cy <= h0; ++cy) {
            world.func_180501_a(pos.func_177982_a(0, cy - 1, 0), (cy == ht) ? Blocks.field_150368_y.func_176223_P() : Blocks.field_150343_Z.func_176223_P(), 3);
        }
        for (int cy = 0; cy <= h2; ++cy) {
            world.func_180501_a(pos.func_177982_a(1, cy - 1, 0), (cy == ht) ? Blocks.field_150368_y.func_176223_P() : Blocks.field_150343_Z.func_176223_P(), 3);
        }
        for (int cy = 0; cy <= h3; ++cy) {
            world.func_180501_a(pos.func_177982_a(0, cy - 1, 1), (cy == ht) ? Blocks.field_150368_y.func_176223_P() : Blocks.field_150343_Z.func_176223_P(), 3);
        }
        for (int cy = 0; cy <= h4; ++cy) {
            world.func_180501_a(pos.func_177982_a(1, cy - 1, 1), (cy == ht) ? Blocks.field_150368_y.func_176223_P() : Blocks.field_150343_Z.func_176223_P(), 3);
        }
        for (int i = 0; i < 2; ++i) {
            BlockPos dPos = pos.func_177982_a(rand.nextInt(8) - rand.nextInt(8), 0, rand.nextInt(8) - rand.nextInt(8));
            dPos = world.func_205770_a(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, dPos);
            if (dPos.func_177956_o() > 0) {
                final RavenEntity raven = new RavenEntity(TFEntities.raven, (World)world.func_201672_e());
                raven.func_174828_a(dPos, rand.nextFloat() * 360.0f, 0.0f);
                world.func_217376_c((Entity)raven);
            }
        }
        return true;
    }
}
