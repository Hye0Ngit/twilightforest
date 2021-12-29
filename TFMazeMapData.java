// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFMazeMapData extends km
{
    public int yCenter;
    
    public TFMazeMapData(final String par1Str) {
        super(par1Str);
    }
    
    public void a(final ph par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.yCenter = par1NBTTagCompound.f("yCenter");
    }
    
    public void b(final ph par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("yCenter", this.yCenter);
    }
}
