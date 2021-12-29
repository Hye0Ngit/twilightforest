// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.properties.IProperty;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFHydraLair extends ComponentTFHollowHill
{
    public ComponentTFHydraLair() {
    }
    
    public ComponentTFHydraLair(final TFFeature feature, final World world, final Random rand, final int i, final int x, final int y, final int z) {
        super(feature, world, rand, i, 2, x, y + 2, z);
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List<StructureComponent> list, final Random random) {
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int stalacts = 64;
        final int stalags = 8;
        for (int i = 0; i < stalacts; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateOreStalactite(world, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < stalacts; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, Blocks.field_150348_b, 1.0f, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < stalags; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, Blocks.field_150348_b, 0.9f, false, dest[0], 1, dest[1], sbb);
        }
        this.func_175811_a(world, TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.HYDRA), 27, 3, 27, sbb);
        return true;
    }
}
