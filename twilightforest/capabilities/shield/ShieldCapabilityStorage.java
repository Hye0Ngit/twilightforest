// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.capabilities.shield;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class ShieldCapabilityStorage implements Capability.IStorage<IShieldCapability>
{
    public CompoundNBT writeNBT(final Capability<IShieldCapability> capability, final IShieldCapability instance, final Direction side) {
        final CompoundNBT tag = new CompoundNBT();
        tag.func_74768_a("tempshields", instance.temporaryShieldsLeft());
        tag.func_74768_a("permshields", instance.permanentShieldsLeft());
        return tag;
    }
    
    public void readNBT(final Capability<IShieldCapability> capability, final IShieldCapability instance, final Direction side, final INBT nbt) {
        if (nbt instanceof CompoundNBT && instance instanceof ShieldCapabilityHandler) {
            final CompoundNBT tag = (CompoundNBT)nbt;
            ((ShieldCapabilityHandler)instance).initShields(tag.func_74762_e("tempshields"), tag.func_74762_e("permshields"));
        }
    }
}
