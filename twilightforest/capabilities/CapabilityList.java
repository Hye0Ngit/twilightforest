// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.capabilities;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraft.nbt.INBT;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraft.util.Direction;
import javax.annotation.Nonnull;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.MinecraftForge;
import java.util.concurrent.Callable;
import twilightforest.capabilities.shield.ShieldCapabilityHandler;
import twilightforest.capabilities.shield.ShieldCapabilityStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.common.capabilities.Capability;

public class CapabilityList
{
    @CapabilityInject(IShieldCapability.class)
    public static final Capability<IShieldCapability> SHIELDS;
    
    public static void registerCapabilities() {
        CapabilityManager.INSTANCE.register((Class)IShieldCapability.class, (Capability.IStorage)new ShieldCapabilityStorage(), (Callable)ShieldCapabilityHandler::new);
        MinecraftForge.EVENT_BUS.register((Object)CapabilityList.class);
    }
    
    @SubscribeEvent
    public static void attachEntityCapability(final AttachCapabilitiesEvent<Entity> e) {
        if (e.getObject() instanceof LivingEntity) {
            e.addCapability(IShieldCapability.ID, (ICapabilityProvider)new ICapabilitySerializable<CompoundNBT>() {
                IShieldCapability inst;
                
                {
                    (this.inst = (IShieldCapability)CapabilityList.SHIELDS.getDefaultInstance()).setEntity((LivingEntity)e.getObject());
                }
                
                @Nonnull
                public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> capability, final Direction facing) {
                    return (LazyOptional<T>)CapabilityList.SHIELDS.orEmpty((Capability)capability, LazyOptional.of(() -> this.inst));
                }
                
                public CompoundNBT serializeNBT() {
                    return (CompoundNBT)CapabilityList.SHIELDS.getStorage().writeNBT((Capability)CapabilityList.SHIELDS, (Object)this.inst, (Direction)null);
                }
                
                public void deserializeNBT(final CompoundNBT nbt) {
                    CapabilityList.SHIELDS.getStorage().readNBT((Capability)CapabilityList.SHIELDS, (Object)this.inst, (Direction)null, (INBT)nbt);
                }
            });
        }
    }
    
    static {
        SHIELDS = null;
    }
}
