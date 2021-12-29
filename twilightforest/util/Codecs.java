// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import java.util.function.Function;
import net.minecraft.core.Vec3i;
import net.minecraft.Util;
import java.util.function.ToIntFunction;
import java.util.Arrays;
import com.mojang.serialization.DataResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import com.mojang.serialization.Codec;

public final class Codecs
{
    public static final Codec<BlockPos> STRING_POS;
    public static final Codec<Direction> ONLY_HORIZONTAL;
    
    private static DataResult<BlockPos> parseString2BlockPos(final String string) {
        try {
            return (DataResult<BlockPos>)Util.m_137539_(Arrays.stream(string.split(" *, *")).mapToInt(Integer::parseInt), 3).map(arr -> new BlockPos(arr[0], arr[1], arr[2]));
        }
        catch (Throwable e) {
            return (DataResult<BlockPos>)DataResult.error(e.getMessage());
        }
    }
    
    private Codecs() {
    }
    
    static {
        STRING_POS = Codec.STRING.comapFlatMap((Function)Codecs::parseString2BlockPos, (Function)Vec3i::m_123344_);
        ONLY_HORIZONTAL = Direction.f_175356_.comapFlatMap(direction -> (direction.m_122434_() != Direction.Axis.Y) ? DataResult.success((Object)direction) : DataResult.error("Horizontal direction only!", (Object)direction), (Function)Function.identity());
    }
}
