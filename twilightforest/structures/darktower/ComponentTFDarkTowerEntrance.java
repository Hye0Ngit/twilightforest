// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentTFDarkTowerEntrance extends ComponentTFDarkTowerWing
{
    public ComponentTFDarkTowerEntrance() {
    }
    
    protected ComponentTFDarkTowerEntrance(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        super.func_74861_a(parent, list, rand);
        this.addOpening(this.size / 2, 1, 0, 1, EnumDarkTowerDoor.REAPPEARING);
        this.addOpening(this.size / 2, 1, this.size - 1, 3, EnumDarkTowerDoor.REAPPEARING);
    }
    
    @Override
    public void makeABeard(final StructureComponent parent, final List list, final Random rand) {
    }
    
    @Override
    public void makeARoof(final StructureComponent parent, final List list, final Random rand) {
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.func_74870_b(world, this.deco.accentID, this.deco.accentMeta, x, -1, z, sbb);
            }
        }
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.nullifySkyLightForBoundingBox(world);
        this.makeOpenings(world, sbb);
        return true;
    }
}
