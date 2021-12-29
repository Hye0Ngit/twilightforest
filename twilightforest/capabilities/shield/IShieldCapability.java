// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.capabilities.shield;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IShieldCapability extends INBTSerializable<CompoundTag>
{
    public static final ResourceLocation ID = TwilightForestMod.prefix("cap_shield");
    
    void setEntity(final LivingEntity p0);
    
    void update();
    
    int shieldsLeft();
    
    int temporaryShieldsLeft();
    
    int permanentShieldsLeft();
    
    void breakShield();
    
    void replenishShields();
    
    void setShields(final int p0, final boolean p1);
    
    void addShields(final int p0, final boolean p1);
}
