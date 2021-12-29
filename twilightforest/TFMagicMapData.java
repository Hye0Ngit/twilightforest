// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import java.util.HashMap;
import net.minecraft.world.level.saveddata.SavedData;
import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.Objects;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import net.minecraft.server.level.ServerLevel;
import java.util.ArrayList;
import net.minecraft.nbt.CompoundTag;
import java.util.HashSet;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceKey;
import java.util.Set;
import java.util.Map;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;

public class TFMagicMapData extends MapItemSavedData
{
    private static final Map<String, TFMagicMapData> CLIENT_DATA;
    public final Set<TFMapDecoration> tfDecorations;
    
    public TFMagicMapData(final int x, final int z, final byte scale, final boolean trackpos, final boolean unlimited, final boolean locked, final ResourceKey<Level> dim) {
        super(x, z, scale, trackpos, unlimited, locked, (ResourceKey)dim);
        this.tfDecorations = new HashSet<TFMapDecoration>();
    }
    
    public static TFMagicMapData load(final CompoundTag nbt) {
        final MapItemSavedData data = MapItemSavedData.m_164807_(nbt);
        final boolean trackingPosition = !nbt.m_128425_("trackingPosition", 1) || nbt.m_128471_("trackingPosition");
        final boolean unlimitedTracking = nbt.m_128471_("unlimitedTracking");
        final boolean locked = nbt.m_128471_("locked");
        final TFMagicMapData tfdata = new TFMagicMapData(data.f_77885_, data.f_77886_, data.f_77890_, trackingPosition, unlimitedTracking, locked, (ResourceKey<Level>)data.f_77887_);
        tfdata.f_77891_ = data.f_77891_;
        tfdata.f_77897_.putAll(data.f_77897_);
        tfdata.f_77894_.putAll(data.f_77894_);
        tfdata.f_77898_.putAll(data.f_77898_);
        tfdata.f_181308_ = data.f_181308_;
        final byte[] featureStorage = nbt.m_128463_("features");
        if (featureStorage.length > 0) {
            tfdata.deserializeFeatures(featureStorage);
        }
        return tfdata;
    }
    
    public CompoundTag m_7176_(CompoundTag cmp) {
        cmp = super.m_7176_(cmp);
        if (this.tfDecorations.size() > 0) {
            cmp.m_128382_("features", this.serializeFeatures());
        }
        return cmp;
    }
    
    public void checkExistingFeatures(final Level world) {
        final List<TFMapDecoration> toRemove = new ArrayList<TFMapDecoration>();
        final List<TFMapDecoration> toAdd = new ArrayList<TFMapDecoration>();
        for (final TFMapDecoration coord : this.tfDecorations) {
            final int worldX = (coord.m_77804_() << this.f_77890_ - 1) + this.f_77885_;
            final int worldZ = (coord.m_77805_() << this.f_77890_ - 1) + this.f_77886_;
            final int trueId = TFMapDecoration.ICONS_FLIPPED.getInt((Object)TFFeature.getFeatureAt(worldX, worldZ, (WorldGenLevel)world));
            if (coord.featureId != trueId) {
                toRemove.add(coord);
                toAdd.add(new TFMapDecoration(trueId, coord.m_77804_(), coord.m_77805_(), coord.m_77806_()));
            }
        }
        final List<TFMapDecoration> list = toRemove;
        final Set<TFMapDecoration> tfDecorations = this.tfDecorations;
        Objects.requireNonNull(tfDecorations);
        list.forEach(tfDecorations::remove);
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
            storage[i * 3 + 1] = featureCoord.m_77804_();
            storage[i * 3 + 2] = featureCoord.m_77805_();
            ++i;
        }
        return storage;
    }
    
    @Nullable
    public static TFMagicMapData getMagicMapData(final Level world, final String name) {
        if (world.f_46443_) {
            return TFMagicMapData.CLIENT_DATA.get(name);
        }
        return (TFMagicMapData)world.m_142572_().m_129783_().m_8895_().m_164858_((Function)TFMagicMapData::load, name);
    }
    
    public static void registerMagicMapData(final Level world, final TFMagicMapData data, final String id) {
        if (world.f_46443_) {
            TFMagicMapData.CLIENT_DATA.put(id, data);
        }
        else {
            world.m_142572_().m_129783_().m_8895_().m_164855_(id, (SavedData)data);
        }
    }
    
    static {
        CLIENT_DATA = new HashMap<String, TFMagicMapData>();
    }
    
    public static class TFMapDecoration extends MapDecoration
    {
        private static final Int2ObjectArrayMap<TFFeature> ICONS;
        private static final Object2IntArrayMap<TFFeature> ICONS_FLIPPED;
        final int featureId;
        
        public TFMapDecoration(final TFFeature featureId, final byte xIn, final byte yIn, final byte rotationIn) {
            this(TFMapDecoration.ICONS_FLIPPED.getInt((Object)featureId), xIn, yIn, rotationIn);
        }
        
        public TFMapDecoration(final int featureId, final byte xIn, final byte yIn, final byte rotationIn) {
            super(MapDecoration.Type.TARGET_X, xIn, yIn, rotationIn, (Component)new TranslatableComponent("map.magic.text"));
            this.featureId = featureId;
        }
        
        @OnlyIn(Dist.CLIENT)
        public boolean render(final int idx) {
            if (((TFFeature)TFMapDecoration.ICONS.get(this.featureId)).isStructureEnabled) {
                RenderContext.stack.m_85836_();
                RenderContext.stack.m_85837_((double)(0.0f + this.m_77804_() / 2.0f + 64.0f), (double)(0.0f + this.m_77805_() / 2.0f + 64.0f), -0.019999999552965164);
                RenderContext.stack.m_85845_(Vector3f.f_122227_.m_122240_(this.m_77806_() * 360 / 16.0f));
                RenderContext.stack.m_85841_(4.0f, 4.0f, 3.0f);
                RenderContext.stack.m_85837_(-0.125, 0.125, 0.0);
                final float f1 = this.featureId % 8 / 8.0f;
                final float f2 = this.featureId / 8 / 8.0f;
                final float f3 = (this.featureId % 8 + 1) / 8.0f;
                final float f4 = (this.featureId / 8 + 1) / 8.0f;
                final Matrix4f matrix4f1 = RenderContext.stack.m_85850_().m_85861_();
                final VertexConsumer ivertexbuilder1 = RenderContext.buffer.m_6299_(RenderContext.MAP_ICONS);
                ivertexbuilder1.m_85982_(matrix4f1, -1.0f, 1.0f, idx * -0.001f).m_6122_(255, 255, 255, 255).m_7421_(f1, f2).m_85969_(RenderContext.light).m_5752_();
                ivertexbuilder1.m_85982_(matrix4f1, 1.0f, 1.0f, idx * -0.001f).m_6122_(255, 255, 255, 255).m_7421_(f3, f2).m_85969_(RenderContext.light).m_5752_();
                ivertexbuilder1.m_85982_(matrix4f1, 1.0f, -1.0f, idx * -0.001f).m_6122_(255, 255, 255, 255).m_7421_(f3, f4).m_85969_(RenderContext.light).m_5752_();
                ivertexbuilder1.m_85982_(matrix4f1, -1.0f, -1.0f, idx * -0.001f).m_6122_(255, 255, 255, 255).m_7421_(f1, f4).m_85969_(RenderContext.light).m_5752_();
                RenderContext.stack.m_85849_();
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
            ICONS = new Int2ObjectArrayMap<TFFeature>() {
                {
                    this.defaultReturnValue((Object)TFFeature.NOTHING);
                    this.put(0, (Object)TFFeature.NOTHING);
                    this.put(1, (Object)TFFeature.SMALL_HILL);
                    this.put(2, (Object)TFFeature.MEDIUM_HILL);
                    this.put(3, (Object)TFFeature.LARGE_HILL);
                    this.put(4, (Object)TFFeature.HEDGE_MAZE);
                    this.put(5, (Object)TFFeature.NAGA_COURTYARD);
                    this.put(6, (Object)TFFeature.LICH_TOWER);
                    this.put(7, (Object)TFFeature.ICE_TOWER);
                    this.put(9, (Object)TFFeature.QUEST_GROVE);
                    this.put(12, (Object)TFFeature.HYDRA_LAIR);
                    this.put(13, (Object)TFFeature.LABYRINTH);
                    this.put(14, (Object)TFFeature.DARK_TOWER);
                    this.put(15, (Object)TFFeature.KNIGHT_STRONGHOLD);
                    this.put(17, (Object)TFFeature.YETI_CAVE);
                    this.put(18, (Object)TFFeature.TROLL_CAVE);
                    this.put(19, (Object)TFFeature.FINAL_CASTLE);
                }
            };
            ICONS_FLIPPED = new Object2IntArrayMap<TFFeature>() {
                {
                    TFMapDecoration.ICONS.forEach((k, v) -> this.put((Object)v, (int)k));
                }
            };
        }
        
        @OnlyIn(Dist.CLIENT)
        public static class RenderContext
        {
            private static final RenderType MAP_ICONS;
            public static PoseStack stack;
            public static MultiBufferSource buffer;
            public static int light;
            
            static {
                MAP_ICONS = RenderType.m_110497_(TwilightForestMod.prefix("textures/gui/mapicons.png"));
            }
        }
    }
}
