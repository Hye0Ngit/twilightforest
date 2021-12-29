// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.entity.PartEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import twilightforest.network.UpdateTFMultipartPacket;
import net.minecraftforge.fml.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import java.util.Iterator;
import net.minecraft.util.math.AxisAlignedBB;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Collection;
import java.util.ArrayList;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import twilightforest.world.TFDimensions;
import twilightforest.entity.TFPartEntity;
import java.util.List;
import java.util.WeakHashMap;
import net.minecraft.world.World;

public class ASMHooks
{
    public static volatile World world;
    private static final WeakHashMap<World, List<TFPartEntity<?>>> cache;
    
    public static long seed(final long seed) {
        return TFDimensions.seed = seed;
    }
    
    public static void mapRenderContext(final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        TFMagicMapData.TFMapDecoration.RenderContext.stack = stack;
        TFMagicMapData.TFMapDecoration.RenderContext.buffer = buffer;
        TFMagicMapData.TFMapDecoration.RenderContext.light = light;
    }
    
    public static BackgroundMusicSelector music(final BackgroundMusicSelector music) {
        if (Minecraft.func_71410_x().field_71441_e != null && Minecraft.func_71410_x().field_71439_g != null && (music == BackgroundMusicTracks.field_232671_b_ || music == BackgroundMusicTracks.field_232675_f_) && Minecraft.func_71410_x().field_71441_e.func_234923_W_().func_240901_a_().toString().equals(TFConfig.COMMON_CONFIG.DIMENSION.twilightForestID.get())) {
            return Minecraft.func_71410_x().field_71441_e.func_225523_d_().func_235201_b_(Minecraft.func_71410_x().field_71439_g.func_233580_cy_()).func_235094_x_().orElse(BackgroundMusicTracks.field_232676_g_);
        }
        return music;
    }
    
    public static void registerMultipartEvents(final IEventBus bus) {
        bus.addListener(event -> {
            if (event.getEntity().isMultipartEntity()) {
                synchronized (ASMHooks.cache) {
                    ASMHooks.cache.computeIfAbsent(event.getWorld(), w -> new ArrayList());
                    ASMHooks.cache.get(event.getWorld()).addAll(Arrays.stream((Object[])Objects.requireNonNull((T[])event.getEntity().getParts())).filter(TFPartEntity.class::isInstance).map(obj -> (TFPartEntity)obj).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()));
                }
            }
            return;
        });
        bus.addListener(event -> {
            if (event.getEntity().isMultipartEntity()) {
                synchronized (ASMHooks.cache) {
                    ASMHooks.cache.computeIfPresent(event.getWorld(), (world, list) -> {
                        list.removeAll(Arrays.stream((Object[])Objects.requireNonNull((T[])event.getEntity().getParts())).filter(TFPartEntity.class::isInstance).map((Function<? super Object, ?>)TFPartEntity.class::cast).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()));
                        return list;
                    });
                }
            }
        });
    }
    
    public static synchronized List<Entity> multipartHitbox(final List<Entity> list, final World world, @Nullable final Entity entityIn, final AxisAlignedBB boundingBox, @Nullable final Predicate<? super Entity> predicate) {
        synchronized (ASMHooks.cache) {
            final List<TFPartEntity<?>> parts = ASMHooks.cache.get(world);
            if (parts != null) {
                for (final TFPartEntity<?> part : parts) {
                    if (part != entityIn && part.func_174813_aQ().func_72326_a(boundingBox) && (predicate == null || predicate.test((Object)part)) && !list.contains(part)) {
                        list.add((Entity)part);
                    }
                }
            }
            return list;
        }
    }
    
    public static Entity updateMultiparts(final Entity entity) {
        if (entity.isMultipartEntity()) {
            TFPacketHandler.CHANNEL.send(PacketDistributor.TRACKING_ENTITY.with(() -> entity), (Object)new UpdateTFMultipartPacket(entity));
        }
        return entity;
    }
    
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public static EntityRenderer<?> getMultipartRenderer(@Nullable final EntityRenderer<?> renderer, final Entity entity, final EntityRendererManager manager) {
        if (entity instanceof TFPartEntity) {
            return ((TFPartEntity)entity).renderer(manager);
        }
        return renderer;
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
                    if (part instanceof TFPartEntity) {
                        list.add(part);
                    }
                }
            }
            return;
        });
        return list;
    }
    
    static {
        cache = new WeakHashMap<World, List<TFPartEntity<?>>>();
    }
}
