// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.tileentity.TileEntitySkull;

public class TileEntityTFTrophy extends TileEntitySkull
{
    public int ticksExisted;
    
    public void func_70316_g() {
        super.func_70316_g();
        ++this.ticksExisted;
    }
}
