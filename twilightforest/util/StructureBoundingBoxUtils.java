// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.MutableBoundingBox;

public class StructureBoundingBoxUtils
{
    public static Vector3i getCenter(final MutableBoundingBox sbb) {
        return (Vector3i)new BlockPos(sbb.field_78897_a + (sbb.field_78893_d - sbb.field_78897_a + 1) / 2, sbb.field_78895_b + (sbb.field_78894_e - sbb.field_78895_b + 1) / 2, sbb.field_78896_c + (sbb.field_78892_f - sbb.field_78896_c + 1) / 2);
    }
    
    @Nullable
    public static MutableBoundingBox getUnionOfSBBs(final MutableBoundingBox sbbIn, final MutableBoundingBox sbbMask) {
        if (!sbbIn.func_78884_a(sbbMask)) {
            return null;
        }
        return new MutableBoundingBox(Math.max(sbbIn.field_78897_a, sbbMask.field_78897_a), Math.max(sbbIn.field_78895_b, sbbMask.field_78895_b), Math.max(sbbIn.field_78896_c, sbbMask.field_78896_c), Math.min(sbbIn.field_78893_d, sbbMask.field_78893_d), Math.min(sbbIn.field_78894_e, sbbMask.field_78894_e), Math.min(sbbIn.field_78892_f, sbbMask.field_78892_f));
    }
}
