// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFDarkTowerRoofRings extends ComponentTFDarkTowerRoof
{
    public ComponentTFDarkTowerRoofRings() {
    }
    
    public ComponentTFDarkTowerRoofRings(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        for (int y = 1; y < 10; ++y) {
            this.func_151550_a(world, this.deco.blockID, this.deco.blockMeta, this.size / 2, y, this.size / 2, sbb);
        }
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, 10, this.size / 2, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, 1, this.size / 2, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, 1, this.size / 2, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, 1, this.size / 2 - 1, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, 1, this.size / 2 + 1, sbb);
        this.makeARing(world, 6, sbb);
        this.makeARing(world, 8, sbb);
        return true;
    }
    
    protected void makeARing(final World world, final int y, final StructureBoundingBox sbb) {
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 2, y, this.size / 2 + 1, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 2, y, this.size / 2 + 0, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 2, y, this.size / 2 - 1, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 2, y, this.size / 2 + 1, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 2, y, this.size / 2 + 0, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 2, y, this.size / 2 - 1, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, y, this.size / 2 - 2, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 0, y, this.size / 2 - 2, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, y, this.size / 2 - 2, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, y, this.size / 2 + 2, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 0, y, this.size / 2 + 2, sbb);
        this.func_151550_a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, y, this.size / 2 + 2, sbb);
    }
}
