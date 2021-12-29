// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.capabilities;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nonnull;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraft.entity.EntityLivingBase;
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
        if (e.getObject() instanceof EntityLivingBase) {
            e.addCapability(IShieldCapability.ID, (ICapabilityProvider)new ICapabilitySerializable<NBTTagCompound>() {
                IShieldCapability inst;
                
                {
                    (this.inst = (IShieldCapability)CapabilityList.SHIELDS.getDefaultInstance()).setEntity((EntityLivingBase)e.getObject());
                }
                
                public boolean hasCapability(@Nonnull final Capability<?> capability, final EnumFacing facing) {
                    return capability == CapabilityList.SHIELDS;
                }
                
                public <T> T getCapability(@Nonnull final Capability<T> capability, final EnumFacing facing) {
                    return (T)((capability == CapabilityList.SHIELDS) ? CapabilityList.SHIELDS.cast((Object)this.inst) : null);
                }
                
                public NBTTagCompound serializeNBT() {
                    return (NBTTagCompound)CapabilityList.SHIELDS.getStorage().writeNBT((Capability)CapabilityList.SHIELDS, (Object)this.inst, (EnumFacing)null);
                }
                
                public void deserializeNBT(final NBTTagCompound nbt) {
                    CapabilityList.SHIELDS.getStorage().readNBT((Capability)CapabilityList.SHIELDS, (Object)this.inst, (EnumFacing)null, (NBTBase)nbt);
                }
            });
        }
    }
    
    static {
        SHIELDS = null;
    }
}
