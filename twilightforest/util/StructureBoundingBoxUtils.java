// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.util.math.AxisAlignedBB;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class StructureBoundingBoxUtils
{
    public static Vec3i getCenter(final StructureBoundingBox sbb) {
        return (Vec3i)new BlockPos(sbb.field_78897_a + (sbb.field_78893_d - sbb.field_78897_a + 1) / 2, sbb.field_78895_b + (sbb.field_78894_e - sbb.field_78895_b + 1) / 2, sbb.field_78896_c + (sbb.field_78892_f - sbb.field_78896_c + 1) / 2);
    }
    
    @Nullable
    public static StructureBoundingBox getUnionOfSBBs(final StructureBoundingBox sbbIn, final StructureBoundingBox sbbMask) {
        if (!sbbIn.func_78884_a(sbbMask)) {
            return null;
        }
        return new StructureBoundingBox((sbbIn.field_78897_a > sbbMask.field_78897_a) ? sbbIn.field_78897_a : sbbMask.field_78897_a, (sbbIn.field_78895_b > sbbMask.field_78895_b) ? sbbIn.field_78895_b : sbbMask.field_78895_b, (sbbIn.field_78896_c > sbbMask.field_78896_c) ? sbbIn.field_78896_c : sbbMask.field_78896_c, (sbbIn.field_78893_d < sbbMask.field_78893_d) ? sbbIn.field_78893_d : sbbMask.field_78893_d, (sbbIn.field_78894_e < sbbMask.field_78894_e) ? sbbIn.field_78894_e : sbbMask.field_78894_e, (sbbIn.field_78892_f < sbbMask.field_78892_f) ? sbbIn.field_78892_f : sbbMask.field_78892_f);
    }
    
    public static AxisAlignedBB toAABB(final StructureBoundingBox sbb) {
        return new AxisAlignedBB((double)sbb.field_78897_a, (double)sbb.field_78895_b, (double)sbb.field_78896_c, (double)(sbb.field_78893_d + 1), (double)(sbb.field_78894_e + 1), (double)(sbb.field_78892_f + 1));
    }
}
