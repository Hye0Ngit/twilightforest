// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

public class TileEntityTFTrophy extends ask
{
    public int ticksExisted;
    
    public void h() {
        super.h();
        ++this.ticksExisted;
    }
}
