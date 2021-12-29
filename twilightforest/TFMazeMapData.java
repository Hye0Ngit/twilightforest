// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TFMazeMapData extends ahg
{
    public int yCenter;
    
    public TFMazeMapData(final String par1Str) {
        super(par1Str);
    }
    
    public void a(final bq par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.yCenter = par1NBTTagCompound.e("yCenter");
    }
    
    public void b(final bq par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("yCenter", this.yCenter);
    }
    
    public void loadDataFromByteArray(final byte[] par1ArrayOfByte) {
        if (par1ArrayOfByte[0] == 19) {
            par1ArrayOfByte[0] = 0;
            super.a(par1ArrayOfByte);
        }
        else if (par1ArrayOfByte[0] == 20) {
            par1ArrayOfByte[0] = 1;
            super.a(par1ArrayOfByte);
        }
    }
}
