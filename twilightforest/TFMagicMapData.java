// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapDecoration;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.world.storage.MapData;

public class TFMagicMapData extends MapData
{
    public final Set<TFMapDecoration> tfDecorations;
    
    public TFMagicMapData(final String name) {
        super(name);
        this.tfDecorations = new HashSet<TFMapDecoration>();
    }
    
    public void func_76184_a(final NBTTagCompound cmp) {
        super.func_76184_a(cmp);
        final byte[] featureStorage = cmp.func_74770_j("features");
        if (featureStorage.length > 0) {
            this.deserializeFeatures(featureStorage);
        }
    }
    
    public NBTTagCompound func_189551_b(NBTTagCompound cmp) {
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
            final int trueId = TFFeature.getFeatureID(worldX, worldZ, world);
            if (coord.featureId != trueId) {
                toRemove.add(coord);
                toAdd.add(new TFMapDecoration(trueId, coord.func_176112_b(), coord.func_176113_c(), coord.func_176111_d()));
            }
        }
        this.tfDecorations.removeAll(toRemove);
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
    
    public static class TFMapDecoration extends MapDecoration
    {
        private static final ResourceLocation MAP_ICONS;
        final int featureId;
        
        public TFMapDecoration(final int featureId, final byte xIn, final byte yIn, final byte rotationIn) {
            super(MapDecoration.Type.TARGET_X, xIn, yIn, rotationIn);
            this.featureId = featureId;
        }
        
        @SideOnly(Side.CLIENT)
        public boolean render(final int idx) {
            if (TFFeature.getFeatureByID(this.featureId).isStructureEnabled) {
                Minecraft.func_71410_x().field_71446_o.func_110577_a(TFMapDecoration.MAP_ICONS);
                GlStateManager.func_179094_E();
                GlStateManager.func_179109_b(0.0f + this.func_176112_b() / 2.0f + 64.0f, 0.0f + this.func_176113_c() / 2.0f + 64.0f, -0.02f);
                GlStateManager.func_179114_b(this.func_176111_d() * 360 / 16.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.func_179152_a(4.0f, 4.0f, 3.0f);
                GlStateManager.func_179109_b(-0.125f, 0.125f, 0.0f);
                final float f1 = this.featureId % 8 / 8.0f;
                final float f2 = this.featureId / 8 / 8.0f;
                final float f3 = (this.featureId % 8 + 1) / 8.0f;
                final float f4 = (this.featureId / 8 + 1) / 8.0f;
                final Tessellator tessellator = Tessellator.func_178181_a();
                final BufferBuilder bufferbuilder = tessellator.func_178180_c();
                bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
                bufferbuilder.func_181662_b(-1.0, 1.0, (double)(idx * -0.001f)).func_187315_a((double)f1, (double)f2).func_181675_d();
                bufferbuilder.func_181662_b(1.0, 1.0, (double)(idx * -0.001f)).func_187315_a((double)f3, (double)f2).func_181675_d();
                bufferbuilder.func_181662_b(1.0, -1.0, (double)(idx * -0.001f)).func_187315_a((double)f3, (double)f4).func_181675_d();
                bufferbuilder.func_181662_b(-1.0, -1.0, (double)(idx * -0.001f)).func_187315_a((double)f1, (double)f4).func_181675_d();
                tessellator.func_78381_a();
                GlStateManager.func_179121_F();
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
        
        static {
            MAP_ICONS = TwilightForestMod.prefix("textures/gui/mapicons.png");
        }
    }
}
