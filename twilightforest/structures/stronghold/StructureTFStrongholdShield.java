// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class StructureTFStrongholdShield extends StructureTFStrongholdComponent
{
    public StructureTFStrongholdShield(final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        super(0, 0, minX, minY, minZ);
        this.f = new age(minX, minY, minZ, maxX, maxY, maxZ);
        this.spawnListIndex = -1;
    }
    
    @Override
    public age generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return null;
    }
    
    public boolean a(final abv world, final Random random, final age sbb) {
        final int shieldBlock = TFBlocks.shield.cF;
        this.a(world, sbb, this.f.b(), 0, 0, this.f.b(), this.f.c(), this.f.d(), shieldBlock, 4, shieldBlock, 4, false);
        this.a(world, sbb, 0, 0, 0, 0, this.f.c(), this.f.d(), shieldBlock, 5, shieldBlock, 5, false);
        this.a(world, sbb, 0, 0, this.f.d(), this.f.b(), this.f.c(), this.f.d(), shieldBlock, 2, shieldBlock, 2, false);
        this.a(world, sbb, 0, 0, 0, this.f.b(), this.f.c(), 0, shieldBlock, 3, shieldBlock, 3, false);
        this.a(world, sbb, 0, 0, 0, this.f.b(), 0, this.f.d(), shieldBlock, 1, shieldBlock, 1, false);
        this.a(world, sbb, 0, this.f.c(), 0, this.f.b(), this.f.c(), this.f.d(), shieldBlock, 0, shieldBlock, 0, false);
        return true;
    }
}
