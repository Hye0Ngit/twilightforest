// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.HashMap;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import net.minecraftforge.fmllegacy.network.NetworkDirection;
import twilightforest.network.MagicMapPacket;
import twilightforest.network.TFPacketHandler;
import net.minecraft.network.protocol.game.ClientboundMapItemDataPacket;
import net.minecraft.network.protocol.Packet;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import twilightforest.world.registration.biomes.BiomeKeys;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import twilightforest.world.registration.TFGenerationSettings;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.entity.Entity;
import javax.annotation.Nullable;
import twilightforest.TFMagicMapData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.resources.ResourceLocation;
import java.util.Map;
import net.minecraft.world.item.MapItem;

public class MagicMapItem extends MapItem
{
    public static final String STR_ID = "magicmap";
    private static final Map<ResourceLocation, MapColorBrightness> BIOME_COLORS;
    private static final Map<ChunkPos, Biome[]> CACHE;
    
    protected MagicMapItem(final Item.Properties props) {
        super(props);
    }
    
    public static ItemStack setupNewMap(final Level world, final int worldX, final int worldZ, final byte scale, final boolean trackingPosition, final boolean unlimitedTracking) {
        final ItemStack itemstack = new ItemStack((ItemLike)TFItems.FILLED_MAGIC_MAP.get());
        createMapData(itemstack, world, worldX, worldZ, scale, trackingPosition, unlimitedTracking, (ResourceKey<Level>)world.m_46472_());
        return itemstack;
    }
    
    @Nullable
    public static TFMagicMapData getData(final ItemStack stack, final Level world) {
        final Integer id = m_151131_(stack);
        return (id == null) ? null : TFMagicMapData.getMagicMapData(world, getMapName(id));
    }
    
    @Nullable
    protected TFMagicMapData getCustomMapData(final ItemStack stack, final Level world) {
        TFMagicMapData mapdata = getData(stack, world);
        if (mapdata == null && !world.f_46443_) {
            mapdata = createMapData(stack, world, world.m_6106_().m_6789_(), world.m_6106_().m_6526_(), 3, false, false, (ResourceKey<Level>)world.m_46472_());
        }
        return mapdata;
    }
    
    private static TFMagicMapData createMapData(final ItemStack stack, final Level world, final int x, final int z, final int scale, final boolean trackingPosition, final boolean unlimitedTracking, final ResourceKey<Level> dimension) {
        final int i = world.m_7354_();
        final int mapSize = 2048;
        final int roundX = (int)Math.round(x / (double)mapSize);
        final int roundZ = (int)Math.round(z / (double)mapSize);
        final int scaledX = roundX * mapSize + 1024;
        final int scaledZ = roundZ * mapSize + 1024;
        final TFMagicMapData mapdata = new TFMagicMapData(scaledX, scaledZ, (byte)scale, trackingPosition, unlimitedTracking, false, dimension);
        TFMagicMapData.registerMagicMapData(world, mapdata, getMapName(i));
        stack.m_41784_().m_128405_("map", i);
        return mapdata;
    }
    
    public static String getMapName(final int id) {
        return "magicmap_" + id;
    }
    
    public void m_42893_(final Level world, final Entity viewer, final MapItemSavedData data) {
        if (world.m_46472_() == data.f_77887_ && viewer instanceof Player && world instanceof ServerLevel) {
            final ServerLevel serverLevel = (ServerLevel)world;
            if (TFGenerationSettings.usesTwilightChunkGenerator(serverLevel)) {
                final int biomesPerPixel = 4;
                final int blocksPerPixel = 16;
                final int centerX = data.f_77885_;
                final int centerZ = data.f_77886_;
                final int viewerX = Mth.m_14107_(viewer.m_20185_() - centerX) / blocksPerPixel + 64;
                final int viewerZ = Mth.m_14107_(viewer.m_20189_() - centerZ) / blocksPerPixel + 64;
                final int viewRadiusPixels = 512 / blocksPerPixel;
                final int startX = (centerX / blocksPerPixel - 64) * biomesPerPixel;
                final int startZ = (centerZ / blocksPerPixel - 64) * biomesPerPixel;
                final Biome[] biomes = MagicMapItem.CACHE.computeIfAbsent(new ChunkPos(startX, startZ), pos -> {
                    final Biome[] array = new Biome[128 * biomesPerPixel * 128 * biomesPerPixel];
                    for (int l = 0; l < 128 * biomesPerPixel; ++l) {
                        for (int i1 = 0; i1 < 128 * biomesPerPixel; ++i1) {
                            array[l * 128 * biomesPerPixel + i1] = world.m_46857_(new BlockPos(startX * biomesPerPixel + i1 * biomesPerPixel, 0, startZ * biomesPerPixel + l * biomesPerPixel));
                        }
                    }
                    return array;
                });
                for (int xPixel = viewerX - viewRadiusPixels + 1; xPixel < viewerX + viewRadiusPixels; ++xPixel) {
                    for (int zPixel = viewerZ - viewRadiusPixels - 1; zPixel < viewerZ + viewRadiusPixels; ++zPixel) {
                        if (xPixel >= 0 && zPixel >= 0 && xPixel < 128 && zPixel < 128) {
                            final int xPixelDist = xPixel - viewerX;
                            final int zPixelDist = zPixel - viewerZ;
                            final boolean shouldFuzz = xPixelDist * xPixelDist + zPixelDist * zPixelDist > (viewRadiusPixels - 2) * (viewRadiusPixels - 2);
                            Biome biome = biomes[xPixel * biomesPerPixel + zPixel * biomesPerPixel * 128 * biomesPerPixel];
                            final Biome overBiome = biomes[xPixel * biomesPerPixel + zPixel * biomesPerPixel * 128 * biomesPerPixel + 1];
                            final Biome downBiome = biomes[xPixel * biomesPerPixel + (zPixel * biomesPerPixel + 1) * 128 * biomesPerPixel];
                            biome = ((overBiome != null && BiomeKeys.STREAM.m_135782_().equals((Object)overBiome.getRegistryName())) ? overBiome : ((downBiome != null && BiomeKeys.STREAM.m_135782_().equals((Object)downBiome.getRegistryName())) ? downBiome : biome));
                            final MapColorBrightness colorBrightness = this.getMapColorPerBiome(world, biome);
                            final MaterialColor mapcolor = colorBrightness.color;
                            final int brightness = colorBrightness.brightness;
                            if (zPixel >= 0 && xPixelDist * xPixelDist + zPixelDist * zPixelDist < viewRadiusPixels * viewRadiusPixels && (!shouldFuzz || (xPixel + zPixel & 0x1) != 0x0)) {
                                final byte orgPixel = data.f_77891_[xPixel + zPixel * 128];
                                final byte ourPixel = (byte)(mapcolor.f_76397_ * 4 + brightness);
                                if (orgPixel != ourPixel) {
                                    data.m_164803_(xPixel, zPixel, ourPixel);
                                    data.m_77762_();
                                }
                                final int worldX = (centerX / blocksPerPixel + xPixel - 64) * blocksPerPixel;
                                final int worldZ = (centerZ / blocksPerPixel + zPixel - 64) * blocksPerPixel;
                                if (TFFeature.isInFeatureChunk(worldX, worldZ)) {
                                    final byte mapX = (byte)((worldX - centerX) / (float)blocksPerPixel * 2.0f);
                                    final byte mapZ = (byte)((worldZ - centerZ) / (float)blocksPerPixel * 2.0f);
                                    final TFFeature feature = TFFeature.getFeatureAt(worldX, worldZ, (WorldGenLevel)world);
                                    final TFMagicMapData tfData = (TFMagicMapData)data;
                                    tfData.tfDecorations.add(new TFMagicMapData.TFMapDecoration(feature, mapX, mapZ, (byte)8));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private MapColorBrightness getMapColorPerBiome(final Level world, final Biome biome) {
        if (MagicMapItem.BIOME_COLORS.isEmpty()) {
            setupBiomeColors();
        }
        if (biome == null) {
            return new MapColorBrightness(MaterialColor.f_76365_);
        }
        final ResourceLocation key = biome.getRegistryName();
        final MapColorBrightness color = MagicMapItem.BIOME_COLORS.get(key);
        if (color != null) {
            return color;
        }
        return new MapColorBrightness(biome.m_47536_().m_47824_().m_6743_().m_60780_((BlockGetter)world, BlockPos.f_121853_));
    }
    
    private static void setupBiomeColors() {
        putBiomeColor(BiomeKeys.FOREST, new MapColorBrightness(MaterialColor.f_76405_, 1));
        putBiomeColor(BiomeKeys.DENSE_FOREST, new MapColorBrightness(MaterialColor.f_76405_, 0));
        putBiomeColor(BiomeKeys.LAKE, new MapColorBrightness(MaterialColor.f_76410_, 3));
        putBiomeColor(BiomeKeys.STREAM, new MapColorBrightness(MaterialColor.f_76410_, 1));
        putBiomeColor(BiomeKeys.SWAMP, new MapColorBrightness(MaterialColor.f_76367_, 3));
        putBiomeColor(BiomeKeys.FIRE_SWAMP, new MapColorBrightness(MaterialColor.f_76371_, 1));
        putBiomeColor(BiomeKeys.CLEARING, new MapColorBrightness(MaterialColor.f_76399_, 2));
        putBiomeColor(BiomeKeys.OAK_SAVANNAH, new MapColorBrightness(MaterialColor.f_76399_, 0));
        putBiomeColor(BiomeKeys.HIGHLANDS, new MapColorBrightness(MaterialColor.f_76408_, 0));
        putBiomeColor(BiomeKeys.THORNLANDS, new MapColorBrightness(MaterialColor.f_76411_, 3));
        putBiomeColor(BiomeKeys.FINAL_PLATEAU, new MapColorBrightness(MaterialColor.f_76420_, 2));
        putBiomeColor(BiomeKeys.FIREFLY_FOREST, new MapColorBrightness(MaterialColor.f_76369_, 1));
        putBiomeColor(BiomeKeys.DARK_FOREST, new MapColorBrightness(MaterialColor.f_76363_, 3));
        putBiomeColor(BiomeKeys.DARK_FOREST_CENTER, new MapColorBrightness(MaterialColor.f_76413_, 3));
        putBiomeColor(BiomeKeys.SNOWY_FOREST, new MapColorBrightness(MaterialColor.f_76406_, 1));
        putBiomeColor(BiomeKeys.GLACIER, new MapColorBrightness(MaterialColor.f_76403_, 1));
        putBiomeColor(BiomeKeys.MUSHROOM_FOREST, new MapColorBrightness(MaterialColor.f_76413_, 0));
        putBiomeColor(BiomeKeys.DENSE_MUSHROOM_FOREST, new MapColorBrightness(MaterialColor.f_76418_, 0));
        putBiomeColor(BiomeKeys.ENCHANTED_FOREST, new MapColorBrightness(MaterialColor.f_76421_, 2));
        putBiomeColor(BiomeKeys.SPOOKY_FOREST, new MapColorBrightness(MaterialColor.f_76422_, 0));
    }
    
    private static void putBiomeColor(final ResourceKey<Biome> biome, final MapColorBrightness color) {
        MagicMapItem.BIOME_COLORS.put(biome.m_135782_(), color);
    }
    
    public static int getBiomeColor(final Biome biome) {
        if (MagicMapItem.BIOME_COLORS.isEmpty()) {
            setupBiomeColors();
        }
        final MapColorBrightness c = MagicMapItem.BIOME_COLORS.get(ForgeRegistries.BIOMES.getKey((IForgeRegistryEntry)biome));
        return (c != null) ? getMapColor(c) : -16777216;
    }
    
    public static int getMapColor(final MapColorBrightness mcb) {
        int n = switch (mcb.color.f_76397_) {
            case 3 -> 135;
            case 2 -> 255;
            case 0 -> 180;
            default -> 220;
        };
        final int i = n;
        final int j = (mcb.color.f_76396_ >> 16 & 0xFF) * i / 255;
        final int k = (mcb.color.f_76396_ >> 8 & 0xFF) * i / 255;
        final int l = (mcb.color.f_76396_ & 0xFF) * i / 255;
        return 0xFF000000 | l << 16 | k << 8 | j;
    }
    
    public void m_7836_(final ItemStack stack, final Level world, final Player player) {
    }
    
    @Nullable
    public Packet<?> m_7233_(final ItemStack stack, final Level world, final Player player) {
        final Integer id = m_151131_(stack);
        final TFMagicMapData mapdata = this.getCustomMapData(stack, world);
        final Packet<?> p = (Packet<?>)((id == null || mapdata == null) ? null : mapdata.m_164796_((int)id, player));
        return (p instanceof ClientboundMapItemDataPacket) ? TFPacketHandler.CHANNEL.toVanillaPacket((Object)new MagicMapPacket(mapdata, (ClientboundMapItemDataPacket)p), NetworkDirection.PLAY_TO_CLIENT) : p;
    }
    
    public void m_7373_(final ItemStack stack, @Nullable final Level pLevel, final List<Component> pTooltip, final TooltipFlag pFlag) {
        final Integer integer = m_151131_(stack);
        final TFMagicMapData mapitemsaveddata = (pLevel == null) ? null : getData(stack, pLevel);
        if (pFlag.m_7050_()) {
            if (mapitemsaveddata != null) {
                pTooltip.add((Component)new TranslatableComponent("filled_map.id", new Object[] { integer }).m_130940_(ChatFormatting.GRAY));
                pTooltip.add((Component)new TranslatableComponent("filled_map.scale", new Object[] { 1 << mapitemsaveddata.f_77890_ }).m_130940_(ChatFormatting.GRAY));
                pTooltip.add((Component)new TranslatableComponent("filled_map.level", new Object[] { mapitemsaveddata.f_77890_, 4 }).m_130940_(ChatFormatting.GRAY));
            }
            else {
                pTooltip.add((Component)new TranslatableComponent("filled_map.unknown").m_130940_(ChatFormatting.GRAY));
            }
        }
        else if (integer != null) {
            pTooltip.add((Component)new TextComponent("#" + integer).m_130940_(ChatFormatting.GRAY));
        }
    }
    
    static {
        BIOME_COLORS = new HashMap<ResourceLocation, MapColorBrightness>();
        CACHE = new HashMap<ChunkPos, Biome[]>();
    }
    
    private static class MapColorBrightness
    {
        public MaterialColor color;
        public int brightness;
        
        public MapColorBrightness(final MaterialColor color, final int brightness) {
            this.color = color;
            this.brightness = brightness;
        }
        
        public MapColorBrightness(final MaterialColor color) {
            this.color = color;
            this.brightness = 1;
        }
    }
}
