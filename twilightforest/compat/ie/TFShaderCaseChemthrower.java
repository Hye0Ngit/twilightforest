// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import net.minecraft.item.ItemStack;
import blusunrize.immersiveengineering.api.shader.ShaderCase;
import java.util.Collection;
import blusunrize.immersiveengineering.api.shader.ShaderCaseChemthrower;

public class TFShaderCaseChemthrower extends ShaderCaseChemthrower
{
    private final int STACK_BREAK;
    
    public TFShaderCaseChemthrower(final int stackBreak, final Collection<ShaderCase.ShaderLayer> layers) {
        super((Collection)layers);
        this.STACK_BREAK = stackBreak;
    }
    
    public boolean renderModelPartForPass(final ItemStack shader, final ItemStack item, final String part, final int pass) {
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
