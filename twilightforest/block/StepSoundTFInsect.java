// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.Block;

public class StepSoundTFInsect extends Block.SoundType
{
    public StepSoundTFInsect(final String par1Str, final float par2, final float par3) {
        super(par1Str, par2, par3);
    }
    
    public String func_150495_a() {
        return "mob.slime.big";
    }
    
    public String getStepSound() {
        return "mob.slime.big";
    }
    
    public String getPlaceSound() {
        return "mob.slime.big";
    }
}
