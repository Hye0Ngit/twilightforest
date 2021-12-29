// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.entity.EntityList;
import twilightforest.entity.EntityTFSkeletonDruid;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenWitchHut extends TFGenerator
{
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        return this.generateTinyHut(world, rand, pos);
    }
    
    public boolean generateTinyHut(final World world, final Random rand, final BlockPos pos) {
        if (!TFGenerator.isAreaSuitable(world, rand, pos, 5, 7, 6)) {
            return false;
        }
        this.func_175903_a(world, pos.func_177982_a(1, 0, 1), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(2, 0, 1), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(3, 0, 1), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(5, 0, 1), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(0, 0, 2), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 0, 2), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 0, 2), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(0, 0, 3), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 0, 3), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(0, 0, 4), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 0, 4), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 0, 4), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(1, 0, 5), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(2, 0, 5), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(3, 0, 5), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(5, 0, 5), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(1, 1, 1), TFGenerator.randStone(rand, 2));
        this.func_175903_a(world, pos.func_177982_a(3, 1, 1), TFGenerator.randStone(rand, 2));
        this.func_175903_a(world, pos.func_177982_a(5, 1, 1), TFGenerator.randStone(rand, 2));
        this.func_175903_a(world, pos.func_177982_a(0, 1, 2), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 1, 2), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 1, 2), TFGenerator.randStone(rand, 2));
        this.func_175903_a(world, pos.func_177982_a(0, 1, 3), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 1, 4), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 1, 4), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 1, 4), TFGenerator.randStone(rand, 2));
        this.func_175903_a(world, pos.func_177982_a(1, 1, 5), TFGenerator.randStone(rand, 2));
        this.func_175903_a(world, pos.func_177982_a(3, 1, 5), TFGenerator.randStone(rand, 2));
        this.func_175903_a(world, pos.func_177982_a(5, 1, 5), TFGenerator.randStone(rand, 2));
        this.func_175903_a(world, pos.func_177982_a(1, 2, 1), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(2, 2, 1), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(3, 2, 1), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(4, 2, 1), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(5, 2, 1), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(0, 2, 2), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 2, 2), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 2, 2), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(0, 2, 3), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 2, 3), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(0, 2, 4), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 2, 4), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 2, 4), TFGenerator.randStone(rand, 1));
        this.func_175903_a(world, pos.func_177982_a(1, 2, 5), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(2, 2, 5), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(3, 2, 5), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(4, 2, 5), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(5, 2, 5), TFGenerator.randStone(rand, 3));
        this.func_175903_a(world, pos.func_177982_a(0, 3, 2), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 3, 3), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 3, 4), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 3, 1), TFGenerator.randStone(rand, 4));
        this.func_175903_a(world, pos.func_177982_a(3, 3, 1), TFGenerator.randStone(rand, 4));
        this.func_175903_a(world, pos.func_177982_a(4, 3, 1), TFGenerator.randStone(rand, 4));
        this.func_175903_a(world, pos.func_177982_a(2, 3, 5), TFGenerator.randStone(rand, 4));
        this.func_175903_a(world, pos.func_177982_a(3, 3, 5), TFGenerator.randStone(rand, 4));
        this.func_175903_a(world, pos.func_177982_a(4, 3, 5), TFGenerator.randStone(rand, 4));
        this.func_175903_a(world, pos.func_177982_a(0, 4, 3), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 4, 1), TFGenerator.randStone(rand, 5));
        this.func_175903_a(world, pos.func_177982_a(3, 4, 5), TFGenerator.randStone(rand, 5));
        this.func_175903_a(world, pos.func_177982_a(0, 5, 3), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 6, 3), Blocks.field_150336_V.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 2, 0), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 2, 1), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 2, 5), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 2, 6), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(6, 2, 0), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(6, 2, 1), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(6, 2, 2), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(6, 2, 3), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(6, 2, 4), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(6, 2, 5), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(6, 2, 6), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 0), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 1), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 2), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 4), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 5), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 6), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 3, 0), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 3, 1), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 3, 2), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 3, 3), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 3, 4), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 3, 5), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 3, 6), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 4, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 4, 0), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 4, 1), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 4, 2), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 4, 3), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 4, 4), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 4, 5), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 4, 6), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 4, 6), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 4, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(4, 4, 0), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(4, 4, 1), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(4, 4, 2), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(4, 4, 3), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(4, 4, 4), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(4, 4, 5), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(4, 4, 6), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(5, 4, 6), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 5, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 5, 1), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(4, 5, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(4, 5, 1), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 5, 0), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 5, 1), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 5, 2), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 5, 3), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 5, 4), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 5, 5), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 5, 6), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 5, 5), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 5, 6), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(4, 5, 5), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(4, 5, 6), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 6, 0), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 6, 1), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 6, 2), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 6, 4), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 6, 5), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 6, 6), Blocks.field_150373_bw.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 7, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 7, 6), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, -1, 3), Blocks.field_150424_aL.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 0, 3), Blocks.field_150480_ab.func_176223_P());
        world.func_180501_a(pos.func_177982_a(3, 1, 3), Blocks.field_150474_ac.func_176223_P(), 18);
        final TileEntityMobSpawner ms = (TileEntityMobSpawner)world.func_175625_s(pos.func_177982_a(3, 1, 3));
        if (ms != null) {
            ms.func_145881_a().func_190894_a(EntityList.func_191306_a((Class)EntityTFSkeletonDruid.class));
        }
        return true;
    }
}
