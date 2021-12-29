// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.entity.Entity;
import twilightforest.entity.passive.EntityTFRaven;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenMonolith extends TFGenerator
{
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        final int ht = rand.nextInt(10) + 10;
        final int dir = rand.nextInt(4);
        if (!TFGenerator.isAreaSuitable(world, rand, pos, 2, ht, 2)) {
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
            this.func_175903_a(world, pos.func_177982_a(0, cy - 1, 0), (cy == ht) ? Blocks.field_150368_y.func_176223_P() : Blocks.field_150343_Z.func_176223_P());
        }
        for (int cy = 0; cy <= h2; ++cy) {
            this.func_175903_a(world, pos.func_177982_a(1, cy - 1, 0), (cy == ht) ? Blocks.field_150368_y.func_176223_P() : Blocks.field_150343_Z.func_176223_P());
        }
        for (int cy = 0; cy <= h3; ++cy) {
            this.func_175903_a(world, pos.func_177982_a(0, cy - 1, 1), (cy == ht) ? Blocks.field_150368_y.func_176223_P() : Blocks.field_150343_Z.func_176223_P());
        }
        for (int cy = 0; cy <= h4; ++cy) {
            this.func_175903_a(world, pos.func_177982_a(1, cy - 1, 1), (cy == ht) ? Blocks.field_150368_y.func_176223_P() : Blocks.field_150343_Z.func_176223_P());
        }
        for (int i = 0; i < 2; ++i) {
            BlockPos dPos = pos.func_177982_a(rand.nextInt(8) - rand.nextInt(8), 0, rand.nextInt(8) - rand.nextInt(8));
            dPos = world.func_175672_r(dPos);
            if (dPos.func_177956_o() > 0) {
                final EntityTFRaven raven = new EntityTFRaven(world);
                raven.func_174828_a(dPos, rand.nextFloat() * 360.0f, 0.0f);
                world.func_72838_d((Entity)raven);
            }
        }
        return true;
    }
}
