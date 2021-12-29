// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.structures.ComponentTFTowerWing;

public class ComponentTFDarkTowerRoofAntenna extends ComponentTFDarkTowerRoof
{
    public ComponentTFDarkTowerRoofAntenna(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        for (int y = 1; y < 10; ++y) {
            this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, y, this.size / 2, sbb);
        }
        this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, 1, this.size / 2, sbb);
        this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, 1, this.size / 2, sbb);
        this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, 1, this.size / 2 - 1, sbb);
        this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, 1, this.size / 2 + 1, sbb);
        for (int y = 7; y < 10; ++y) {
            this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, y, this.size / 2, sbb);
            this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, y, this.size / 2, sbb);
            this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, y, this.size / 2 - 1, sbb);
            this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, y, this.size / 2 + 1, sbb);
        }
        this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, 8, this.size / 2 - 1, sbb);
        this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, 8, this.size / 2 + 1, sbb);
        this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, 8, this.size / 2 - 1, sbb);
        this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, 8, this.size / 2 + 1, sbb);
        return true;
    }
}
