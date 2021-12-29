// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.potions;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.EffectType;
import java.util.UUID;
import net.minecraft.potion.Effect;

public class FrostedPotion extends Effect
{
    public static final UUID MODIFIER_UUID;
    
    public FrostedPotion(final EffectType typeIn, final int liquidColorIn) {
        super(typeIn, liquidColorIn);
        this.func_220304_a(Attributes.field_233821_d_, FrostedPotion.MODIFIER_UUID.toString(), -0.15000000596046448, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
    
    static {
        MODIFIER_UUID = UUID.fromString("CE9DBC2A-EE3F-43F5-9DF7-F7F1EE4915A9");
    }
}
