// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api.aspects;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.tileentity.TileEntity;
import java.lang.reflect.Method;

public class AspectSourceHelper
{
    static Method drainEssentia;
    static Method findEssentia;
    
    public static boolean drainEssentia(final TileEntity tile, final Aspect aspect, final ForgeDirection direction, final int range) {
        try {
            if (AspectSourceHelper.drainEssentia == null) {
                final Class fake = Class.forName("thaumcraft.common.lib.events.EssentiaHandler");
                AspectSourceHelper.drainEssentia = fake.getMethod("drainEssentia", TileEntity.class, Aspect.class, ForgeDirection.class, Integer.TYPE);
            }
            return (boolean)AspectSourceHelper.drainEssentia.invoke(null, tile, aspect, direction, range);
        }
        catch (Exception ex) {
            FMLLog.warning("[Thaumcraft API] Could not invoke thaumcraft.common.lib.events.EssentiaHandler method drainEssentia", new Object[0]);
            return false;
        }
    }
    
    public static boolean findEssentia(final TileEntity tile, final Aspect aspect, final ForgeDirection direction, final int range) {
        try {
            if (AspectSourceHelper.findEssentia == null) {
                final Class fake = Class.forName("thaumcraft.common.lib.events.EssentiaHandler");
                AspectSourceHelper.findEssentia = fake.getMethod("findEssentia", TileEntity.class, Aspect.class, ForgeDirection.class, Integer.TYPE);
            }
            return (boolean)AspectSourceHelper.findEssentia.invoke(null, tile, aspect, direction, range);
        }
        catch (Exception ex) {
            FMLLog.warning("[Thaumcraft API] Could not invoke thaumcraft.common.lib.events.EssentiaHandler method findEssentia", new Object[0]);
            return false;
        }
    }
}
