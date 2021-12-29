// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.util.Mth;

public final class ArrayUtil
{
    private ArrayUtil() {
    }
    
    public static <T> T clamped(final T[] array, final int index) {
        return array[Mth.m_14045_(index, 0, array.length)];
    }
    
    public static <T> T wrapped(final T[] array, final int index) {
        return array[index % array.length];
    }
}
