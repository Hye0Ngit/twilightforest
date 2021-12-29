// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class StructureTFStrongholdShield extends StructureTFStrongholdComponent
{
    public StructureTFStrongholdShield(final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        super(0, 0, minX, minY, minZ);
        this.field_74887_e = new StructureBoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
        this.spawnListIndex = -1;
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final int facing, final int x, final int y, final int z) {
        return null;
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox sbb) {
        final int shieldBlock = TFBlocks.shield.field_71990_ca;
        this.func_74872_a(world, sbb, this.field_74887_e.func_78883_b(), 0, 0, this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), shieldBlock, 4, shieldBlock, 4, false);
        this.func_74872_a(world, sbb, 0, 0, 0, 0, this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), shieldBlock, 5, shieldBlock, 5, false);
        this.func_74872_a(world, sbb, 0, 0, this.field_74887_e.func_78880_d(), this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), shieldBlock, 2, shieldBlock, 2, false);
        this.func_74872_a(world, sbb, 0, 0, 0, this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), 0, shieldBlock, 3, shieldBlock, 3, false);
        this.func_74872_a(world, sbb, 0, 0, 0, this.field_74887_e.func_78883_b(), 0, this.field_74887_e.func_78880_d(), shieldBlock, 1, shieldBlock, 1, false);
        this.func_74872_a(world, sbb, 0, this.field_74887_e.func_78882_c(), 0, this.field_74887_e.func_78883_b(), this.field_74887_e.func_78882_c(), this.field_74887_e.func_78880_d(), shieldBlock, 0, shieldBlock, 0, false);
        return true;
    }
}
