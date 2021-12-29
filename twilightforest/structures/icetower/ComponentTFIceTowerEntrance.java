// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import twilightforest.structures.StructureTFComponent;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;

public class ComponentTFIceTowerEntrance extends ComponentTFIceTowerWing
{
    public ComponentTFIceTowerEntrance() {
    }
    
    public ComponentTFIceTowerEntrance(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    protected boolean shouldHaveBase(final Random rand) {
        return true;
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, 2);
        this.addOpening(this.size - 1, 1, this.size / 2, 0);
        this.addOpening(this.size / 2, 1, 0, 1);
        this.addOpening(this.size / 2, 1, this.size - 1, 3);
        this.hasBase = this.shouldHaveBase(rand);
        this.makeARoof(parent, list, rand);
    }
    
    @Override
    public boolean makeTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        return false;
    }
    
    @Override
    protected void makeFloorsForTower(final World world, final Random decoRNG, final StructureBoundingBox sbb) {
    }
}
