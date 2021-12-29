// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Rotation;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFYetiCave extends ComponentTFHollowHill
{
    public ComponentTFYetiCave() {
    }
    
    public ComponentTFYetiCave(final TFFeature feature, final World world, final Random rand, final int i, final int x, final int y, final int z) {
        super(feature, world, rand, i, 2, x, y + 2, z);
    }
    
    @Override
    boolean isInHill(final int cx, final int cz) {
        return cx < this.radius * 2 && cx > 0 && cz < this.radius * 2 && cz > 0;
    }
    
    @Override
    boolean isInHill(final int mapX, final int mapY, final int mapZ) {
        return mapX < this.radius * 2 && mapX > 0 && mapZ < this.radius * 2 && mapZ > 0 && mapY > 31 && mapY < 51;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int sn = 128;
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, Blocks.field_150348_b, 1.0f, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, Blocks.field_150432_aD, 1.0f, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, Blocks.field_150403_cj, 0.9f, true, dest[0], 1, dest[1], sbb);
        }
        final IBlockState yetiSpawner = TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.ALPHA_YETI);
        this.setBlockStateRotated(world, yetiSpawner, this.radius, 1, this.radius, Rotation.NONE, sbb);
        return true;
    }
}
