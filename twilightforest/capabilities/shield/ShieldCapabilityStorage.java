// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.capabilities.shield;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class ShieldCapabilityStorage implements Capability.IStorage<IShieldCapability>
{
    public NBTTagCompound writeNBT(final Capability<IShieldCapability> capability, final IShieldCapability instance, final EnumFacing side) {
        final NBTTagCompound tag = new NBTTagCompound();
        tag.func_74768_a("tempshields", instance.temporaryShieldsLeft());
        tag.func_74768_a("permshields", instance.permanentShieldsLeft());
        return tag;
    }
    
    public void readNBT(final Capability<IShieldCapability> capability, final IShieldCapability instance, final EnumFacing side, final NBTBase nbt) {
        if (nbt instanceof NBTTagCompound && instance instanceof ShieldCapabilityHandler) {
            final NBTTagCompound tag = (NBTTagCompound)nbt;
            ((ShieldCapabilityHandler)instance).initShields(tag.func_74762_e("tempshields"), tag.func_74762_e("permshields"));
        }
    }
}
