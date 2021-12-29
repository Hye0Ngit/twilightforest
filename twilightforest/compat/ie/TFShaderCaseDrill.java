// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import blusunrize.immersiveengineering.api.shader.ShaderLayer;
import java.util.Collection;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseDrill;

public class TFShaderCaseDrill extends ShaderCaseDrill
{
    private final int STACK_BREAK;
    private int headLayers;
    
    public TFShaderCaseDrill(final int stackBreak, final Collection<ShaderLayer> layers) {
        super((Collection)layers);
        this.headLayers = 1;
        this.STACK_BREAK = stackBreak;
    }
    
    public boolean shouldRenderGroupForPass(final String modelPart, final int pass) {
        if ("drill_head".equals(modelPart) || "upgrade_damage0".equals(modelPart) || "upgrade_damage1".equals(modelPart) || "upgrade_damage2".equals(modelPart) || "upgrade_damage3".equals(modelPart) || "upgrade_damage4".equals(modelPart)) {
            return pass >= this.STACK_BREAK - 1;
        }
        if (pass == this.STACK_BREAK - 1) {
            return false;
        }
        if ("upgrade_speed".equals(modelPart) || "upgrade_waterproof".equals(modelPart)) {
            return pass < this.STACK_BREAK - 2;
        }
        if ("drill_grip".equals(modelPart)) {
            return pass == 0;
        }
        return pass != 0;
    }
    
    public ShaderCaseDrill addHeadLayers(final ShaderLayer... addedLayers) {
        this.headLayers += addedLayers.length;
        return super.addHeadLayers(new ShaderLayer[0]);
    }
}
