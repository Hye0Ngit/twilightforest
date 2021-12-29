// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.capabilities;

import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import twilightforest.capabilities.shield.ShieldCapabilityHandler;
import net.minecraft.nbt.Tag;
import net.minecraft.core.Direction;
import javax.annotation.Nonnull;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.common.capabilities.Capability;

public class CapabilityList
{
    public static final Capability<IShieldCapability> SHIELDS;
    
    public static void registerCapabilities(final RegisterCapabilitiesEvent event) {
        event.register((Class)IShieldCapability.class);
    }
    
    public static void attachEntityCapability(final AttachCapabilitiesEvent<Entity> e) {
        if (e.getObject() instanceof final LivingEntity livingEntity) {
            e.addCapability(IShieldCapability.ID, (ICapabilityProvider)new ICapabilitySerializable<CompoundTag>() {
                LazyOptional<IShieldCapability> inst = LazyOptional.of(() -> {
                    final ShieldCapabilityHandler i = new ShieldCapabilityHandler();
                    i.setEntity(livingEntity);
                    return i;
                });
                
                @Nonnull
                public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> capability, final Direction facing) {
                    return (LazyOptional<T>)CapabilityList.SHIELDS.orEmpty((Capability)capability, this.inst.cast());
                }
                
                public CompoundTag serializeNBT() {
                    return (CompoundTag)((IShieldCapability)this.inst.orElseThrow(NullPointerException::new)).serializeNBT();
                }
                
                public void deserializeNBT(final CompoundTag nbt) {
                    ((IShieldCapability)this.inst.orElseThrow(NullPointerException::new)).deserializeNBT((Tag)nbt);
                }
            });
        }
    }
    
    static {
        SHIELDS = CapabilityManager.get((CapabilityToken)new CapabilityToken<IShieldCapability>() {});
    }
}
