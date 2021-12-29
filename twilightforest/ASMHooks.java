// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import twilightforest.world.components.structures.start.TFStructureStart;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import twilightforest.entity.TFEntities;
import net.minecraft.client.renderer.entity.EntityRenderer;
import twilightforest.network.UpdateTFMultipartPacket;
import net.minecraftforge.fmllegacy.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import java.util.Iterator;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.entity.PartEntity;
import net.minecraft.world.entity.Entity;
import java.util.stream.Stream;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.Collection;
import java.util.Arrays;
import java.util.Objects;
import java.util.ArrayList;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.world.registration.TFGenerationSettings;
import net.minecraft.sounds.Musics;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.Music;
import net.minecraft.world.item.MapItem;
import javax.annotation.Nullable;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import twilightforest.item.TFItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import com.mojang.serialization.Dynamic;
import twilightforest.world.registration.TFDimensions;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import twilightforest.entity.TFPart;
import java.util.List;
import net.minecraft.world.level.Level;
import java.util.WeakHashMap;

public class ASMHooks
{
    private static final WeakHashMap<Level, List<TFPart<?>>> cache;
    private static final Int2ObjectMap<TFPart<?>> multiparts;
    
    public static long seed(final long seed) {
        return TFDimensions.seed = seed;
    }
    
    public static Dynamic<Tag> seed(final Dynamic<Tag> seed) {
        TFDimensions.seed = ((CompoundTag)seed.getValue()).m_128454_("seed");
        return seed;
    }
    
    public static void mapRenderContext(final PoseStack stack, final MultiBufferSource buffer, final int light) {
        TFMagicMapData.TFMapDecoration.RenderContext.stack = stack;
        TFMagicMapData.TFMapDecoration.RenderContext.buffer = buffer;
        TFMagicMapData.TFMapDecoration.RenderContext.light = light;
    }
    
    private static boolean isOurMap(final ItemStack stack) {
        return stack.m_150930_((Item)TFItems.FILLED_MAGIC_MAP.get()) || stack.m_150930_((Item)TFItems.FILLED_MAZE_MAP.get()) || stack.m_150930_((Item)TFItems.FILLED_ORE_MAP.get());
    }
    
    public static boolean shouldMapRender(final boolean o, final ItemStack stack) {
        return o || isOurMap(stack);
    }
    
    @Nullable
    public static MapItemSavedData renderMapData(@Nullable final MapItemSavedData o, final ItemStack stack, final Level level) {
        return (o == null && isOurMap(stack)) ? MapItem.m_42853_(stack, level) : o;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static Music music(final Music music) {
        if (Minecraft.m_91087_().f_91073_ != null && Minecraft.m_91087_().f_91074_ != null && (music == Musics.f_11646_ || music == Musics.f_11650_) && TFGenerationSettings.isTwilightWorldOnClient((Level)Minecraft.m_91087_().f_91073_)) {
            return Minecraft.m_91087_().f_91073_.m_7062_().m_47883_(Minecraft.m_91087_().f_91074_.m_142538_()).m_47566_().orElse(Musics.f_11651_);
        }
        return music;
    }
    
    public static void registerMultipartEvents(final IEventBus bus) {
        bus.addListener(event -> {
            if (event.getWorld().m_5776_() && event.getEntity().isMultipartEntity()) {
                synchronized (ASMHooks.cache) {
                    ASMHooks.cache.computeIfAbsent(event.getWorld(), w -> new ArrayList());
                    final List list = ASMHooks.cache.get(event.getWorld());
                    Arrays.stream((Object[])Objects.requireNonNull((T[])event.getEntity().getParts()));
                    final Class obj;
                    Objects.requireNonNull(obj);
                    final Stream<Object> stream;
                    list.addAll(stream.filter(obj::isInstance).map(obj -> (TFPart)obj).collect((Collector<? super Object, ?, List<Object>>)Collectors.toList()));
                }
            }
            return;
        });
        bus.addListener(event -> {
            if (event.getWorld().m_5776_() && event.getEntity().isMultipartEntity()) {
                synchronized (ASMHooks.cache) {
                    ASMHooks.cache.computeIfPresent(event.getWorld(), (world, list) -> {
                        Arrays.stream((Object[])Objects.requireNonNull((T[])event.getEntity().getParts()));
                        final Class obj2;
                        Objects.requireNonNull(obj2);
                        final Stream<Object> stream2;
                        list.removeAll(stream2.filter(obj2::isInstance).map(obj -> (TFPart)obj).collect((Collector<? super Object, ?, List<Object>>)Collectors.toList()));
                        return list;
                    });
                }
            }
        });
    }
    
    public static void trackingStart(final Entity entity) {
        if (entity.isMultipartEntity()) {
            final Stream<Object> stream = Arrays.stream((Object[])Objects.requireNonNull((T[])entity.getParts()));
            final Class<TFPart> obj = TFPart.class;
            Objects.requireNonNull(obj);
            final List<TFPart<?>> list = stream.filter(obj::isInstance).map(obj -> obj).collect((Collector<? super Object, ?, List<TFPart<?>>>)Collectors.toList());
            list.forEach(part -> ASMHooks.multiparts.put(part.m_142049_(), (Object)part));
            synchronized (ASMHooks.cache) {
                ASMHooks.cache.computeIfAbsent(entity.f_19853_, w -> new ArrayList());
                ASMHooks.cache.get(entity.f_19853_).addAll(list);
            }
        }
    }
    
    public static void trackingEnd(final Entity entity) {
        if (entity.isMultipartEntity()) {
            final Stream<Object> stream = Arrays.stream((Object[])Objects.requireNonNull((T[])entity.getParts()));
            final Class<TFPart> obj = TFPart.class;
            Objects.requireNonNull(obj);
            final List<TFPart<?>> list = stream.filter(obj::isInstance).map(obj -> obj).collect((Collector<? super Object, ?, List<TFPart<?>>>)Collectors.toList());
            list.forEach(part -> ASMHooks.multiparts.remove(part.m_142049_()));
            synchronized (ASMHooks.cache) {
                ASMHooks.cache.computeIfPresent(entity.f_19853_, (world, parts) -> {
                    parts.removeAll(list);
                    return parts;
                });
            }
        }
    }
    
    public static synchronized List<Entity> multipartHitbox(final List<Entity> list, final Level world, @Nullable final Entity entityIn, final AABB boundingBox, @Nullable final Predicate<? super Entity> predicate) {
        synchronized (ASMHooks.cache) {
            final List<TFPart<?>> parts = ASMHooks.cache.get(world);
            if (parts != null) {
                for (final TFPart<?> part : parts) {
                    if (part != entityIn && part.m_142469_().m_82381_(boundingBox) && (predicate == null || predicate.test((Object)part)) && !list.contains(part)) {
                        list.add((Entity)part);
                    }
                }
            }
            return list;
        }
    }
    
    public static Entity multipartFromID(@Nullable final Entity o, final int id) {
        return (Entity)((o == null) ? ASMHooks.multiparts.get(id) : o);
    }
    
    public static Entity updateMultiparts(final Entity entity) {
        if (entity.isMultipartEntity()) {
            TFPacketHandler.CHANNEL.send(PacketDistributor.TRACKING_ENTITY.with(() -> entity), (Object)new UpdateTFMultipartPacket(entity));
        }
        return entity;
    }
    
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public static EntityRenderer<?> getMultipartRenderer(@Nullable final EntityRenderer<?> renderer, final Entity entity) {
        if (entity instanceof final TFPart tfPart) {
            return TFEntities.BakedMultiPartRenderers.lookup(tfPart.renderer());
        }
        return renderer;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static EntityRendererProvider.Context bakeMultipartRenders(final EntityRendererProvider.Context context) {
        TFEntities.BakedMultiPartRenderers.bakeMultiPartRenderers(context);
        return context;
    }
    
    public static Iterable<Entity> renderMutiparts(final Iterable<Entity> iter) {
        final List<Entity> list = new ArrayList<Entity>();
        iter.forEach(entity -> {
            list.add(entity);
            if (entity.isMultipartEntity() && entity.getParts() != null) {
                entity.getParts();
                final PartEntity[] array;
                int i = 0;
                for (int length = array.length; i < length; ++i) {
                    final PartEntity<?> part = (PartEntity<?>)array[i];
                    if (part instanceof TFPart) {
                        list.add(part);
                    }
                }
            }
            return;
        });
        return list;
    }
    
    public static Minecraft.ExperimentalDialogType dragons(final Minecraft.ExperimentalDialogType type) {
        return TFConfig.CLIENT_CONFIG.disableHereBeDragons.get() ? Minecraft.ExperimentalDialogType.NONE : type;
    }
    
    public static int foliage(final int o, final Biome biome, final double x, final double z) {
        return FoliageColorHandler.get(o, biome, x, z);
    }
    
    public static StructureStart<?> conquered(final StructureStart<?> start, final CompoundTag nbt) {
        if (start instanceof final TFStructureStart.Start s) {
            s.load(nbt);
        }
        return start;
    }
    
    public static boolean mountFix(final boolean o, final boolean wantsToStopRiding, final boolean isPassenger) {
        return (!wantsToStopRiding || !isPassenger) && o;
    }
    
    static {
        cache = new WeakHashMap<Level, List<TFPart<?>>>();
        multiparts = (Int2ObjectMap)new Int2ObjectOpenHashMap();
    }
}
