// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFFinalCastleDungeonForgeRoom extends StructureTFComponentOld
{
    public ComponentTFFinalCastleDungeonForgeRoom() {
    }
    
    public ComponentTFFinalCastleDungeonForgeRoom(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final EnumFacing direction) {
        super(feature, i);
        this.spawnListIndex = 3;
        this.func_186164_a(direction);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox2(x, y, z, -15, 0, -15, 50, 30, 50, direction);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74878_a(world, sbb, 0, 0, 0, 50, 30, 50);
        this.placeSignAtCurrentPosition(world, 25, 0, 25, "Mini-boss 2", "Gives talisman", sbb);
        return true;
    }
}
