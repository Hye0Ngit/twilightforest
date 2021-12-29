// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.world.TFGenCaveStalactite;
import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.world.TFWorld;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFYetiCave extends ComponentTFHollowHill
{
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
            this.generateStoneStalactite(world, 1.0f, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateIceStalactite(world, 1.0f, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateIceStalactite(world, 0.9f, false, dest[0], 1, dest[1], sbb);
        }
        return true;
    }
    
    protected void generateIceStalactite(final World world, float length, final boolean up, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (sbb.func_78890_b(dx, dy, dz) && world.func_72798_a(dx, dy, dz) != Block.field_72065_as.field_71990_ca) {
            final Random stalRNG = new Random(world.func_72905_C() + dx * dz);
            if (this.hillSize == 1) {
                length *= 1.9f;
            }
            new TFGenCaveStalactite(Block.field_72036_aT.field_71990_ca, length, up).func_76484_a(world, stalRNG, dx, dy, dz);
        }
    }
}
