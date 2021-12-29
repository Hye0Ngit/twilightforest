// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.util.math.BlockPos;
import twilightforest.world.TFWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.MapData;

public class TFMazeMapData extends MapData
{
    public int yCenter;
    
    public TFMazeMapData(final String name) {
        super(name);
    }
    
    public void func_76184_a(final NBTTagCompound nbt) {
        super.func_76184_a(nbt);
        this.yCenter = nbt.func_74762_e("yCenter");
    }
    
    public NBTTagCompound func_189551_b(final NBTTagCompound nbt) {
        final NBTTagCompound ret = super.func_189551_b(nbt);
        ret.func_74768_a("yCenter", this.yCenter);
        return ret;
    }
    
    public void calculateMapCenter(final World world, final double x, final double y, final double z, final int mapScale) {
        super.func_176054_a(x, z, mapScale);
        this.yCenter = MathHelper.func_76128_c(y);
        if (TFWorld.isTwilightForest(world) && TFFeature.getFeatureForRegion(MathHelper.func_76128_c(x) >> 4, MathHelper.func_76128_c(z) >> 4, world) == TFFeature.LABYRINTH) {
            final BlockPos mc = TFFeature.getNearestCenterXYZ(MathHelper.func_76128_c(x) >> 4, MathHelper.func_76128_c(z) >> 4, world);
            this.field_76201_a = mc.func_177958_n();
            this.field_76199_b = mc.func_177952_p();
            this.yCenter = MathHelper.func_76128_c(y);
        }
    }
}
