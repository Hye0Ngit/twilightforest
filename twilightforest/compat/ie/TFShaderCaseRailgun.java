// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import net.minecraft.item.ItemStack;
import blusunrize.immersiveengineering.api.shader.ShaderCase;
import java.util.Collection;
import blusunrize.immersiveengineering.api.shader.ShaderCaseRailgun;

public class TFShaderCaseRailgun extends ShaderCaseRailgun
{
    private final int STACK_BREAK;
    
    public TFShaderCaseRailgun(final int stackBreak, final Collection<ShaderCase.ShaderLayer> layers) {
        super((Collection)layers);
        this.STACK_BREAK = stackBreak;
    }
    
    public boolean renderModelPartForPass(final ItemStack shader, final ItemStack item, final String part, final int pass) {
        if ("sled".equals(part) || "wires".equals(part) || "tubes".equals(part)) {
            return pass >= this.STACK_BREAK - 1;
        }
        if ("grip".equals(part)) {
            return pass == 0;
        }
        return pass != 0;
    }
}
