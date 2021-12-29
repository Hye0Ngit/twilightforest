// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.Vec3i;
import net.minecraft.block.state.IBlockState;
import java.util.Iterator;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.List;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public abstract class StructureTFTreeComponent extends StructureTFComponentOld
{
    public StructureTFTreeComponent() {
    }
    
    public StructureTFTreeComponent(final TFFeature feature, final int i) {
        super(feature, i);
    }
    
    public abstract boolean addComponentParts(final World p0, final Random p1, final StructureBoundingBox p2, final boolean p3);
    
    protected boolean branchIntersectsDungeon(final StructureTFTreeComponent branch, final List<StructureComponent> list) {
        for (final StructureComponent component : list) {
            if (component instanceof ComponentTFHollowTreeLeafDungeon && component.func_74874_b().func_78884_a(branch.func_74874_b())) {
                return true;
            }
        }
        return false;
    }
    
    protected void placeLeafBlock(final World world, final IBlockState blockState, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final BlockPos pos = this.getBlockPosWithOffset(x, y, z);
        if (sbb.func_175898_b((Vec3i)pos)) {
            final IBlockState whatsThere = world.func_180495_p(pos);
            if (whatsThere.func_177230_c().canBeReplacedByLeaves(whatsThere, (IBlockAccess)world, pos) && whatsThere.func_177230_c() != blockState.func_177230_c()) {
                world.func_180501_a(pos, blockState, 2);
            }
        }
    }
}
