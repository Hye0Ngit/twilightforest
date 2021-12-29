// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.potions;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.effect.MobEffectCategory;
import java.util.UUID;
import net.minecraft.world.effect.MobEffect;

public class FrostedEffect extends MobEffect
{
    public static final UUID MODIFIER_UUID;
    
    public FrostedEffect(final MobEffectCategory typeIn, final int liquidColorIn) {
        super(typeIn, liquidColorIn);
        this.m_19472_(Attributes.f_22279_, FrostedEffect.MODIFIER_UUID.toString(), -0.15000000596046448, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
    
    static {
        MODIFIER_UUID = UUID.fromString("CE9DBC2A-EE3F-43F5-9DF7-F7F1EE4915A9");
    }
}
