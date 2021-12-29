// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLog;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import twilightforest.world.feature.TFGenerator;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.TFFeature;

public class ComponentTFHollowTreeLargeBranch extends ComponentTFHollowTreeMedBranch
{
    private static final int LEAF_DUNGEON_CHANCE = 8;
    public boolean hasLeafDungeon;
    
    public ComponentTFHollowTreeLargeBranch() {
        this.hasLeafDungeon = false;
    }
    
    protected ComponentTFHollowTreeLargeBranch(final TFFeature feature, final int i, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        super(feature, i, sx, sy, sz, length, angle, tilt, leafy);
        this.hasLeafDungeon = false;
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List<StructureComponent> list, final Random rand) {
        final int index = this.func_74877_c();
        this.hasLeafDungeon = (rand.nextInt(8) == 0);
        if (this.hasLeafDungeon) {
            final BlockPos dpos = TFGenerator.translate(this.dest, 2.0, this.angle, this.tilt);
            this.makeLeafDungeon(list, rand, index + 1, dpos);
        }
        for (int numMedBranches = rand.nextInt((int)(this.length / 6.0)) + (int)(this.length / 8.0), i = 0; i <= numMedBranches; ++i) {
            final double outVar = rand.nextDouble() * 0.3 + 0.3;
            final double angleVar = rand.nextDouble() * 0.225 * (((i & 0x1) == 0x0) ? 1.0 : -1.0);
            final BlockPos bsrc = TFGenerator.translate(this.src, this.length * outVar, this.angle, this.tilt);
            this.makeMedBranch(list, rand, index + 2 + i, bsrc.func_177958_n(), bsrc.func_177956_o(), bsrc.func_177952_p(), this.length * 0.6, this.angle + angleVar, this.tilt, this.leafy);
        }
    }
    
    public void makeLeafDungeon(final List<StructureComponent> list, final Random rand, final int index, final BlockPos pos) {
        final ComponentTFHollowTreeLeafDungeon dungeon = new ComponentTFHollowTreeLeafDungeon(this.getFeatureType(), index, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), 4);
        list.add(dungeon);
        dungeon.func_74861_a((StructureComponent)this, (List)list, rand);
    }
    
    public void makeMedBranch(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final double branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final ComponentTFHollowTreeMedBranch branch = new ComponentTFHollowTreeMedBranch(this.getFeatureType(), index, x, y, z, branchLength, branchRotation, branchAngle, leafy);
        if (!this.branchIntersectsDungeon(branch, list)) {
            list.add(branch);
            branch.func_74861_a((StructureComponent)this, (List)list, rand);
        }
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox sbb) {
        return this.addComponentParts(world, random, sbb, false);
    }
    
    @Override
    public boolean addComponentParts(final World world, final Random rand, final StructureBoundingBox sbb, final boolean drawLeaves) {
        final BlockPos rsrc = this.src.func_177982_a(-this.field_74887_e.field_78897_a, -this.field_74887_e.field_78895_b, -this.field_74887_e.field_78896_c);
        final BlockPos rdest = this.dest.func_177982_a(-this.field_74887_e.field_78897_a, -this.field_74887_e.field_78895_b, -this.field_74887_e.field_78896_c);
        if (!drawLeaves) {
            final IBlockState defaultState = TFBlocks.twilight_log.func_176223_P();
            this.drawBresehnam(world, sbb, rsrc.func_177958_n(), rsrc.func_177956_o(), rsrc.func_177952_p(), rdest.func_177958_n(), rdest.func_177956_o(), rdest.func_177952_p(), defaultState.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE));
            for (int reinforcements = 4, i = 0; i <= reinforcements; ++i) {
                final int vx = ((i & 0x2) == 0x0) ? 1 : 0;
                final int vy = ((i & 0x1) == 0x0) ? 1 : -1;
                final int vz = ((i & 0x2) != 0x0) ? 1 : 0;
                this.drawBresehnam(world, sbb, rsrc.func_177958_n() + vx, rsrc.func_177956_o() + vy, rsrc.func_177952_p() + vz, rdest.func_177958_n(), rdest.func_177956_o(), rdest.func_177952_p(), defaultState.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE));
            }
        }
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        for (int numSmallBranches = decoRNG.nextInt(2) + 1, i = 0; i <= numSmallBranches; ++i) {
            final double outVar = decoRNG.nextFloat() * 0.25f + 0.25f;
            final double angleVar = decoRNG.nextFloat() * 0.25f * (((i & 0x1) == 0x0) ? 1.0f : -1.0f);
            final BlockPos bsrc = TFGenerator.translate(rsrc, this.length * outVar, this.angle, this.tilt);
            this.drawSmallBranch(world, sbb, bsrc.func_177958_n(), bsrc.func_177956_o(), bsrc.func_177952_p(), Math.max(this.length * 0.30000001192092896, 2.0), this.angle + angleVar, this.tilt, drawLeaves);
        }
        if (drawLeaves && !this.hasLeafDungeon) {
            this.makeLeafBlob(world, sbb, rdest.func_177958_n(), rdest.func_177956_o(), rdest.func_177952_p(), 3);
        }
        return true;
    }
}
