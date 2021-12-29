// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.WeakHashMap;
import net.minecraft.world.storage.WorldSavedData;
import java.util.HashMap;
import javax.annotation.Nullable;
import java.util.Collections;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import twilightforest.world.TFGenerationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;
import java.util.Map;
import net.minecraft.world.storage.MapData;

public class TFMazeMapData extends MapData
{
    private static final Map<World, Map<String, TFMazeMapData>> CLIENT_DATA;
    public int yCenter;
    
    public TFMazeMapData(final String name) {
        super(name);
    }
    
    public void func_76184_a(final CompoundNBT nbt) {
        super.func_76184_a(nbt);
        this.yCenter = nbt.func_74762_e("yCenter");
    }
    
    public CompoundNBT func_189551_b(final CompoundNBT nbt) {
        final CompoundNBT ret = super.func_189551_b(nbt);
        ret.func_74768_a("yCenter", this.yCenter);
        return ret;
    }
    
    public void calculateMapCenter(final World world, final int x, final int y, final int z, final int mapScale) {
        super.func_176054_a((double)x, (double)z, mapScale);
        this.yCenter = y;
        if (world instanceof ServerWorld && TFGenerationSettings.isTwilightChunk((ServerWorld)world) && TFFeature.getFeatureForRegion(x >> 4, z >> 4, (ISeedReader)world) == TFFeature.LABYRINTH) {
            final BlockPos mc = TFFeature.getNearestCenterXYZ(x >> 4, z >> 4);
            this.field_76201_a = mc.func_177958_n();
            this.field_76199_b = mc.func_177952_p();
        }
    }
    
    @Nullable
    public static TFMazeMapData getMazeMapData(final World world, final String name) {
        if (world.field_72995_K) {
            return TFMazeMapData.CLIENT_DATA.getOrDefault(world, Collections.emptyMap()).get(name);
        }
        return (TFMazeMapData)world.func_73046_m().func_71218_a(World.field_234918_g_).func_217481_x().func_215753_b(() -> new TFMazeMapData(name), name);
    }
    
    public static void registerMazeMapData(final World world, final TFMazeMapData data) {
        if (world.field_72995_K) {
            TFMazeMapData.CLIENT_DATA.computeIfAbsent(world, k -> new HashMap()).put(data.func_195925_e(), data);
        }
        else {
            world.func_73046_m().func_71218_a(World.field_234918_g_).func_217481_x().func_215757_a((WorldSavedData)data);
        }
    }
    
    static {
        CLIENT_DATA = new WeakHashMap<World, Map<String, TFMazeMapData>>();
    }
}
