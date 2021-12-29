// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import twilightforest.block.TFBlocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentTFHollowTreeSmallBranch extends ComponentTFHollowTreeMedBranch
{
    public ComponentTFHollowTreeSmallBranch() {
    }
    
    protected ComponentTFHollowTreeSmallBranch(final int i, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        super(i, sx, sy, sz, length, angle, tilt, leafy);
    }
    
    @Override
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random rand) {
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox sbb) {
        final ChunkCoordinates rSrc = new ChunkCoordinates(this.src.field_71574_a - this.field_74887_e.field_78897_a, this.src.field_71572_b - this.field_74887_e.field_78895_b, this.src.field_71573_c - this.field_74887_e.field_78896_c);
        final ChunkCoordinates rDest = new ChunkCoordinates(this.dest.field_71574_a - this.field_74887_e.field_78897_a, this.dest.field_71572_b - this.field_74887_e.field_78895_b, this.dest.field_71573_c - this.field_74887_e.field_78896_c);
        this.drawBresehnam(world, sbb, rSrc.field_71574_a, rSrc.field_71572_b, rSrc.field_71573_c, rDest.field_71574_a, rDest.field_71572_b, rDest.field_71573_c, TFBlocks.log, 12);
        if (this.leafy) {
            final int leafRad = random.nextInt(2) + 1;
            this.makeLeafBlob(world, sbb, rDest.field_71574_a, rDest.field_71572_b, rDest.field_71573_c, leafRad);
        }
        return true;
    }
}
