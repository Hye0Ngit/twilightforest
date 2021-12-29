// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import blusunrize.immersiveengineering.api.shader.ShaderLayer;
import java.util.Collection;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseChemthrower;

public class TFShaderCaseChemthrower extends ShaderCaseChemthrower
{
    private final int STACK_BREAK;
    
    public TFShaderCaseChemthrower(final int stackBreak, final Collection<ShaderLayer> layers) {
        super((Collection)layers);
        this.STACK_BREAK = stackBreak;
    }
    
    public boolean shouldRenderGroupForPass(final String part, final int pass) {
        if ("grip".equals(part)) {
            return pass == 0;
        }
        if (pass == 0) {
            return false;
        }
        if (pass == 1 && "cage".equals(part)) {
            return this.renderCageOnBase;
        }
        if (this.tanksUncoloured && "tanks".equals(part)) {
            return pass >= this.STACK_BREAK - 1;
        }
        return this.tanksUncoloured || !"tanks".equals(part) || pass < this.STACK_BREAK - 1;
    }
}
