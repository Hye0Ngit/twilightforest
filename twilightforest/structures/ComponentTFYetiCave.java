// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.entity.Entity;
import twilightforest.entity.boss.EntityTFYetiAlpha;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.world.TFWorld;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFYetiCave extends ComponentTFHollowHill
{
    private boolean yetiPlaced;
    
    public ComponentTFYetiCave() {
    }
    
    public ComponentTFYetiCave(final World world, final Random rand, final int i, final int x, final int y, final int z) {
        super(world, rand, i, 2, x, y + 2, z);
    }
    
    @Override
    boolean isInHill(final int cx, final int cz) {
        return cx < this.radius * 2 && cx > 0 && cz < this.radius * 2 && cz > 0;
    }
    
    @Override
    boolean isInHill(final int mapX, final int mapY, final int mapZ) {
        return mapX < this.radius * 2 && mapX > 0 && mapZ < this.radius * 2 && mapZ > 0 && mapY > TFWorld.SEALEVEL && mapY < TFWorld.SEALEVEL + 20;
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
        if (!this.yetiPlaced) {
            final int bx = this.func_74865_a(this.radius, this.radius);
            final int by = this.func_74862_a(0);
            final int bz = this.func_74873_b(this.radius, this.radius);
            if (sbb.func_78890_b(bx, by, bz)) {
                this.yetiPlaced = true;
                final EntityTFYetiAlpha yeti = new EntityTFYetiAlpha(world);
                yeti.func_70107_b((double)bx, (double)by, (double)bz);
                yeti.func_110171_b(bx, by, bz, 30);
                world.func_72838_d((Entity)yeti);
            }
        }
        return true;
    }
}
