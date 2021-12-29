// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFDarkTowerEntrance extends ComponentTFDarkTowerWing
{
    public ComponentTFDarkTowerEntrance() {
    }
    
    protected ComponentTFDarkTowerEntrance(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        super.func_74861_a(parent, list, rand);
        this.addOpening(this.size / 2, 1, 0, Rotation.CLOCKWISE_90, EnumDarkTowerDoor.REAPPEARING);
        this.addOpening(this.size / 2, 1, this.size - 1, Rotation.COUNTERCLOCKWISE_90, EnumDarkTowerDoor.REAPPEARING);
    }
    
    @Override
    public void makeABeard(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
    }
    
    @Override
    public void makeARoof(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.func_175811_a(world, this.deco.accentState, x, -1, z, sbb);
            }
        }
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.nullifySkyLightForBoundingBox(world);
        this.makeOpenings(world, sbb);
        return true;
    }
}
