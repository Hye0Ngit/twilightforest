// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.storage.MapDecoration;
import java.util.WeakHashMap;
import net.minecraft.world.storage.WorldSavedData;
import java.util.HashMap;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.function.Consumer;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.server.ServerWorld;
import java.util.ArrayList;
import net.minecraft.nbt.CompoundNBT;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.world.World;
import java.util.Map;
import net.minecraft.world.storage.MapData;

public class TFMagicMapData extends MapData
{
    private static final Map<World, Map<String, TFMagicMapData>> CLIENT_DATA;
    public final Set<TFMapDecoration> tfDecorations;
    
    public TFMagicMapData(final String name) {
        super(name);
        this.tfDecorations = new HashSet<TFMapDecoration>();
    }
    
    public void func_76184_a(final CompoundNBT cmp) {
        super.func_76184_a(cmp);
        final byte[] featureStorage = cmp.func_74770_j("features");
        if (featureStorage.length > 0) {
            this.deserializeFeatures(featureStorage);
        }
    }
    
    public CompoundNBT func_189551_b(CompoundNBT cmp) {
        cmp = super.func_189551_b(cmp);
        if (this.tfDecorations.size() > 0) {
            cmp.func_74773_a("features", this.serializeFeatures());
        }
        return cmp;
    }
    
    public void checkExistingFeatures(final World world) {
        final List<TFMapDecoration> toRemove = new ArrayList<TFMapDecoration>();
        final List<TFMapDecoration> toAdd = new ArrayList<TFMapDecoration>();
        for (final TFMapDecoration coord : this.tfDecorations) {
            final int worldX = (coord.func_176112_b() << this.field_76197_d - 1) + this.field_76201_a;
            final int worldZ = (coord.func_176113_c() << this.field_76197_d - 1) + this.field_76199_b;
            final int trueId = TFFeature.getFeatureID(worldX, worldZ, (ISeedReader)world);
            if (coord.featureId != trueId) {
                toRemove.add(coord);
                toAdd.add(new TFMapDecoration(trueId, coord.func_176112_b(), coord.func_176113_c(), coord.func_176111_d()));
            }
        }
        toRemove.forEach(this.tfDecorations::remove);
        this.tfDecorations.addAll(toAdd);
    }
    
    public void deserializeFeatures(final byte[] arr) {
        this.tfDecorations.clear();
        for (int i = 0; i < arr.length / 3; ++i) {
            final byte featureId = arr[i * 3];
            final byte mapX = arr[i * 3 + 1];
            final byte mapZ = arr[i * 3 + 2];
            final byte mapRotation = 8;
            this.tfDecorations.add(new TFMapDecoration(featureId, mapX, mapZ, mapRotation));
        }
    }
    
    public byte[] serializeFeatures() {
        final byte[] storage = new byte[this.tfDecorations.size() * 3];
        int i = 0;
        for (final TFMapDecoration featureCoord : this.tfDecorations) {
            storage[i * 3] = (byte)featureCoord.featureId;
            storage[i * 3 + 1] = featureCoord.func_176112_b();
            storage[i * 3 + 2] = featureCoord.func_176113_c();
            ++i;
        }
        return storage;
    }
    
    public void func_176054_a(final double x, final double z, final int mapScale) {
        final int mapSize = 128 * (1 << mapScale);
        final int roundX = (int)Math.round(x / mapSize);
        final int roundZ = (int)Math.round(z / mapSize);
        this.field_76201_a = roundX * mapSize;
        this.field_76199_b = roundZ * mapSize;
    }
    
    @Nullable
    public static TFMagicMapData getMagicMapData(final World world, final String name) {
        if (world.field_72995_K) {
            return TFMagicMapData.CLIENT_DATA.getOrDefault(world, Collections.emptyMap()).get(name);
        }
        return (TFMagicMapData)world.func_73046_m().func_71218_a(World.field_234918_g_).func_217481_x().func_215753_b(() -> new TFMagicMapData(name), name);
    }
    
    public static void registerMagicMapData(final World world, final TFMagicMapData data) {
        if (world.field_72995_K) {
            TFMagicMapData.CLIENT_DATA.computeIfAbsent(world, k -> new HashMap()).put(data.func_195925_e(), data);
        }
        else {
            world.func_73046_m().func_71218_a(World.field_234918_g_).func_217481_x().func_215757_a((WorldSavedData)data);
        }
    }
    
    static {
        CLIENT_DATA = new WeakHashMap<World, Map<String, TFMagicMapData>>();
    }
    
    public static class TFMapDecoration extends MapDecoration
    {
        final int featureId;
        
        public TFMapDecoration(final int featureId, final byte xIn, final byte yIn, final byte rotationIn) {
            super(MapDecoration.Type.TARGET_X, xIn, yIn, rotationIn, (ITextComponent)new TranslationTextComponent("map.magic.text"));
            this.featureId = featureId;
        }
        
        @OnlyIn(Dist.CLIENT)
        public boolean render(final int idx) {
            if (TFFeature.getFeatureByID(this.featureId).isStructureEnabled) {
                RenderContext.stack.func_227860_a_();
                RenderContext.stack.func_227861_a_((double)(0.0f + this.func_176112_b() / 2.0f + 64.0f), (double)(0.0f + this.func_176113_c() / 2.0f + 64.0f), -0.019999999552965164);
                RenderContext.stack.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(this.func_176111_d() * 360 / 16.0f));
                RenderContext.stack.func_227862_a_(4.0f, 4.0f, 3.0f);
                RenderContext.stack.func_227861_a_(-0.125, 0.125, 0.0);
                final float f1 = this.featureId % 8 / 8.0f;
                final float f2 = this.featureId / 8 / 8.0f;
                final float f3 = (this.featureId % 8 + 1) / 8.0f;
                final float f4 = (this.featureId / 8 + 1) / 8.0f;
                final Matrix4f matrix4f1 = RenderContext.stack.func_227866_c_().func_227870_a_();
                final IVertexBuilder ivertexbuilder1 = RenderContext.buffer.getBuffer(RenderContext.MAP_ICONS);
                ivertexbuilder1.func_227888_a_(matrix4f1, -1.0f, 1.0f, idx * -0.001f).func_225586_a_(255, 255, 255, 255).func_225583_a_(f1, f2).func_227886_a_(RenderContext.light).func_181675_d();
                ivertexbuilder1.func_227888_a_(matrix4f1, 1.0f, 1.0f, idx * -0.001f).func_225586_a_(255, 255, 255, 255).func_225583_a_(f3, f2).func_227886_a_(RenderContext.light).func_181675_d();
                ivertexbuilder1.func_227888_a_(matrix4f1, 1.0f, -1.0f, idx * -0.001f).func_225586_a_(255, 255, 255, 255).func_225583_a_(f3, f4).func_227886_a_(RenderContext.light).func_181675_d();
                ivertexbuilder1.func_227888_a_(matrix4f1, -1.0f, -1.0f, idx * -0.001f).func_225586_a_(255, 255, 255, 255).func_225583_a_(f1, f4).func_227886_a_(RenderContext.light).func_181675_d();
                RenderContext.stack.func_227865_b_();
            }
            return true;
        }
        
        public boolean equals(final Object o) {
            if (super.equals(o) && o instanceof TFMapDecoration) {
                final TFMapDecoration other = (TFMapDecoration)o;
                return this.featureId == other.featureId;
            }
            return false;
        }
        
        public int hashCode() {
            return super.hashCode() * 31 + this.featureId;
        }
        
        @OnlyIn(Dist.CLIENT)
        public static class RenderContext
        {
            private static final RenderType MAP_ICONS;
            public static MatrixStack stack;
            public static IRenderTypeBuffer buffer;
            public static int light;
            
            static {
                MAP_ICONS = RenderType.func_228658_l_(TwilightForestMod.prefix("textures/gui/mapicons.png"));
            }
        }
    }
}
