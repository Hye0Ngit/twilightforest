// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TFMazeMapData extends ajf
{
    public int yCenter;
    
    public TFMazeMapData(final String par1Str) {
        super(par1Str);
    }
    
    public void a(final bs par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.yCenter = par1NBTTagCompound.e("yCenter");
    }
    
    public void b(final bs par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("yCenter", this.yCenter);
    }
}
