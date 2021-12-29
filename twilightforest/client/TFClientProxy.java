// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import javax.annotation.Nullable;
import net.minecraft.client.world.ClientWorld;
import twilightforest.ASMHooks;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.Entity;
import twilightforest.TFCommonProxy;

public class TFClientProxy extends TFCommonProxy
{
    private boolean isDangerOverlayShown;
    
    @Nullable
    public static Iterable<Entity> getEntityListForASM() {
        return (ASMHooks.world instanceof ServerWorld) ? ((ServerWorld)ASMHooks.world).func_241136_z_() : ((ASMHooks.world instanceof ClientWorld) ? ((ClientWorld)ASMHooks.world).func_217416_b() : null);
    }
    
    @Override
    public void init() {
    }
}
