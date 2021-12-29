// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import twilightforest.world.TFGenerator;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentTFHollowTreeLargeBranch extends ComponentTFHollowTreeMedBranch
{
    private static final int LEAF_DUNGEON_CHANCE = 8;
    public boolean hasLeafDungeon;
    
    public ComponentTFHollowTreeLargeBranch() {
        this.hasLeafDungeon = false;
    }
    
    protected ComponentTFHollowTreeLargeBranch(final int i, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        super(i, sx, sy, sz, length, angle, tilt, leafy);
        this.hasLeafDungeon = false;
    }
    
    @Override
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random rand) {
        final int index = this.func_74877_c();
        for (int numMedBranches = rand.nextInt((int)(this.length / 6.0)) + (int)(this.length / 8.0), i = 0; i <= numMedBranches; ++i) {
            final double outVar = rand.nextDouble() * 0.3 + 0.3;
            final double angleVar = rand.nextDouble() * 0.225 * (((i & 0x1) == 0x0) ? 1.0 : -1.0);
            final ChunkCoordinates bsrc = TFGenerator.translateCoords(this.src.field_71574_a, this.src.field_71572_b, this.src.field_71573_c, this.length * outVar, this.angle, this.tilt);
            this.makeMedBranch(list, rand, index + 2 + i, bsrc.field_71574_a, bsrc.field_71572_b, bsrc.field_71573_c, this.length * 0.6, this.angle + angleVar, this.tilt, this.leafy);
        }
        this.hasLeafDungeon = (rand.nextInt(8) == 0);
        if (this.hasLeafDungeon) {
            this.makeLeafDungeon(list, rand, index + 1, this.dest.field_71574_a, this.dest.field_71572_b, this.dest.field_71573_c);
        }
    }
    
    public void makeLeafDungeon(final List list, final Random rand, final int index, final int x, final int y, final int z) {
        final ComponentTFHollowTreeLeafDungeon dungeon = new ComponentTFHollowTreeLeafDungeon(index, x, y, z, 4);
        list.add(dungeon);
        dungeon.func_74861_a(this, list, rand);
    }
    
    public void makeMedBranch(final List list, final Random rand, final int index, final int x, final int y, final int z, final double branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final ComponentTFHollowTreeMedBranch branch = new ComponentTFHollowTreeMedBranch(index, x, y, z, branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.func_74861_a(this, list, rand);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final ChunkCoordinates rsrc = new ChunkCoordinates(this.src.field_71574_a - this.field_74887_e.field_78897_a, this.src.field_71572_b - this.field_74887_e.field_78895_b, this.src.field_71573_c - this.field_74887_e.field_78896_c);
        final ChunkCoordinates rdest = new ChunkCoordinates(this.dest.field_71574_a - this.field_74887_e.field_78897_a, this.dest.field_71572_b - this.field_74887_e.field_78895_b, this.dest.field_71573_c - this.field_74887_e.field_78896_c);
        this.drawBresehnam(world, sbb, rsrc.field_71574_a, rsrc.field_71572_b, rsrc.field_71573_c, rdest.field_71574_a, rdest.field_71572_b, rdest.field_71573_c, TFBlocks.log.field_71990_ca, 12);
        for (int reinforcements = 4, i = 0; i <= reinforcements; ++i) {
            final int vx = ((i & 0x2) == 0x0) ? 1 : 0;
            final int vy = ((i & 0x1) == 0x0) ? 1 : -1;
            final int vz = ((i & 0x2) != 0x0) ? 1 : 0;
            this.drawBresehnam(world, sbb, rsrc.field_71574_a + vx, rsrc.field_71572_b + vy, rsrc.field_71573_c + vz, rdest.field_71574_a, rdest.field_71572_b, rdest.field_71573_c, TFBlocks.log.field_71990_ca, 12);
        }
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        for (int numSmallBranches = decoRNG.nextInt(2) + 1, j = 0; j <= numSmallBranches; ++j) {
            final double outVar = decoRNG.nextFloat() * 0.25f + 0.25f;
            final double angleVar = decoRNG.nextFloat() * 0.25f * (((j & 0x1) == 0x0) ? 1.0f : -1.0f);
            final ChunkCoordinates bsrc = TFGenerator.translateCoords(rsrc.field_71574_a, rsrc.field_71572_b, rsrc.field_71573_c, this.length * outVar, this.angle, this.tilt);
            this.drawSmallBranch(world, sbb, bsrc.field_71574_a, bsrc.field_71572_b, bsrc.field_71573_c, Math.max(this.length * 0.30000001192092896, 2.0), this.angle + angleVar, this.tilt, this.leafy);
        }
        if (this.leafy && !this.hasLeafDungeon) {
            this.makeLeafBlob(world, sbb, rdest.field_71574_a, rdest.field_71572_b, rdest.field_71573_c, 3);
        }
        return true;
    }
}
