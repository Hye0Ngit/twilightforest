// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import net.minecraft.item.ItemStack;
import blusunrize.immersiveengineering.api.shader.ShaderCase;
import java.util.Collection;
import blusunrize.immersiveengineering.api.shader.ShaderCaseShield;

public class TFShaderCaseShield extends ShaderCaseShield
{
    private final int STACK_BREAK;
    
    public TFShaderCaseShield(final int stackBreak, final Collection<ShaderCase.ShaderLayer> layers) {
        super((Collection)layers);
        this.STACK_BREAK = stackBreak;
    }
    
    public boolean renderModelPartForPass(final ItemStack shader, final ItemStack item, final String part, final int pass) {
        return (!"flash".equals(part) && !"shock".equals(part)) || pass >= this.STACK_BREAK - 1;
    }
}
