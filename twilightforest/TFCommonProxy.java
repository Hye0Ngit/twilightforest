// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import javax.annotation.Nullable;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.Entity;

public class TFCommonProxy
{
    @Nullable
    public static Iterable<Entity> getEntityListForASM() {
        return (ASMHooks.world instanceof ServerWorld) ? ((ServerWorld)ASMHooks.world).func_241136_z_() : null;
    }
    
    public void init() {
    }
}
