// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import java.util.Random;
import net.minecraft.util.Mirror;

public class MirrorUtil
{
    private static final Mirror[] MIRRORS;
    
    public static Mirror getRandomMirror(final Random random) {
        return MirrorUtil.MIRRORS[random.nextInt(MirrorUtil.MIRRORS.length)];
    }
    
    static {
        MIRRORS = new Mirror[] { Mirror.NONE, Mirror.LEFT_RIGHT, Mirror.FRONT_BACK };
    }
}
