// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import blusunrize.immersiveengineering.api.shader.ShaderLayer;
import java.util.Collection;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseShield;

public class TFShaderCaseShield extends ShaderCaseShield
{
    private final int STACK_BREAK;
    
    public TFShaderCaseShield(final int stackBreak, final Collection<ShaderLayer> layers) {
        super((Collection)layers);
        this.STACK_BREAK = stackBreak;
    }
    
    public boolean shouldRenderGroupForPass(final String part, final int pass) {
        return (!"flash".equals(part) && !"shock".equals(part)) || pass >= this.STACK_BREAK - 1;
    }
}
