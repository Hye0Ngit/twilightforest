// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.HashMap;
import net.minecraftforge.fml.network.NetworkDirection;
import twilightforest.network.MagicMapPacket;
import twilightforest.network.TFPacketHandler;
import net.minecraft.network.play.server.SMapDataPacket;
import net.minecraft.network.IPacket;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.server.ServerWorld;
import twilightforest.TFFeature;
import twilightforest.worldgen.biomes.BiomeKeys;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.storage.MapData;
import net.minecraft.entity.Entity;
import javax.annotation.Nullable;
import twilightforest.TFMagicMapData;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import net.minecraft.item.FilledMapItem;

public class MagicMapItem extends FilledMapItem
{
    public static final String STR_ID = "magicmap";
    private static final Map<ResourceLocation, MapColorBrightness> BIOME_COLORS;
    private static final Map<ChunkPos, Biome[]> CACHE;
    
    protected MagicMapItem(final Item.Properties props) {
        super(props);
    }
    
    public static ItemStack setupNewMap(final World world, final int worldX, final int worldZ, final byte scale, final boolean trackingPosition, final boolean unlimitedTracking) {
        final ItemStack itemstack = new ItemStack((IItemProvider)TFItems.magic_map.get());
        createMapData(itemstack, world, worldX, worldZ, scale, trackingPosition, unlimitedTracking, (RegistryKey<World>)world.func_234923_W_());
        return itemstack;
    }
    
    @Nullable
    public static TFMagicMapData getData(final ItemStack stack, final World world) {
        return TFMagicMapData.getMagicMapData(world, getMapName(func_195949_f(stack)));
    }
    
    @Nullable
    protected TFMagicMapData getCustomMapData(final ItemStack stack, final World world) {
        TFMagicMapData mapdata = getData(stack, world);
        if (mapdata == null && !world.field_72995_K) {
            mapdata = createMapData(stack, world, world.func_72912_H().func_76079_c(), world.func_72912_H().func_76074_e(), 3, false, false, (RegistryKey<World>)world.func_234923_W_());
        }
        return mapdata;
    }
    
    private static TFMagicMapData createMapData(final ItemStack stack, final World world, final int x, final int z, final int scale, final boolean trackingPosition, final boolean unlimitedTracking, final RegistryKey<World> dimension) {
        final int i = world.func_217395_y();
        final TFMagicMapData mapdata = new TFMagicMapData(getMapName(i));
        mapdata.func_237241_a_(x, z, scale, trackingPosition, unlimitedTracking, (RegistryKey)dimension);
        TFMagicMapData.registerMagicMapData(world, mapdata);
        stack.func_196082_o().func_74768_a("map", i);
        return mapdata;
    }
    
    public static String getMapName(final int id) {
        return "magicmap_" + id;
    }
    
    public void func_77872_a(final World world, final Entity viewer, final MapData data) {
        if (world.func_234923_W_() == data.field_76200_c && viewer instanceof PlayerEntity) {
            final int biomesPerPixel = 4;
            final int blocksPerPixel = 16;
            final int centerX = data.field_76201_a;
            final int centerZ = data.field_76199_b;
            final int viewerX = MathHelper.func_76128_c(viewer.func_226277_ct_() - centerX) / blocksPerPixel + 64;
            final int viewerZ = MathHelper.func_76128_c(viewer.func_226281_cx_() - centerZ) / blocksPerPixel + 64;
            final int viewRadiusPixels = 512 / blocksPerPixel;
            final int startX = (centerX / blocksPerPixel - 64) * biomesPerPixel;
            final int startZ = (centerZ / blocksPerPixel - 64) * biomesPerPixel;
            final Biome[] biomes = MagicMapItem.CACHE.computeIfAbsent(new ChunkPos(startX, startZ), pos -> {
                final Biome[] array = new Biome[128 * biomesPerPixel * 128 * biomesPerPixel];
                for (int l = 0; l < 128 * biomesPerPixel; ++l) {
                    for (int i1 = 0; i1 < 128 * biomesPerPixel; ++i1) {
                        array[l * 128 * biomesPerPixel + i1] = world.func_226691_t_(new BlockPos(startX * biomesPerPixel + i1 * biomesPerPixel, 0, startZ * biomesPerPixel + l * biomesPerPixel));
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
                        biome = ((overBiome != null && BiomeKeys.STREAM.func_240901_a_().equals((Object)overBiome.getRegistryName())) ? overBiome : ((downBiome != null && BiomeKeys.STREAM.func_240901_a_().equals((Object)downBiome.getRegistryName())) ? downBiome : biome));
                        final MapColorBrightness colorBrightness = this.getMapColorPerBiome(world, biome);
                        final MaterialColor mapcolor = colorBrightness.color;
                        final int brightness = colorBrightness.brightness;
                        if (zPixel >= 0 && xPixelDist * xPixelDist + zPixelDist * zPixelDist < viewRadiusPixels * viewRadiusPixels && (!shouldFuzz || (xPixel + zPixel & 0x1) != 0x0)) {
                            final byte orgPixel = data.field_76198_e[xPixel + zPixel * 128];
                            final byte ourPixel = (byte)(mapcolor.field_76290_q * 4 + brightness);
                            if (orgPixel != ourPixel) {
                                data.field_76198_e[xPixel + zPixel * 128] = ourPixel;
                                data.func_176053_a(xPixel, zPixel);
                            }
                            final int worldX = (centerX / blocksPerPixel + xPixel - 64) * blocksPerPixel;
                            final int worldZ = (centerZ / blocksPerPixel + zPixel - 64) * blocksPerPixel;
                            if (TFFeature.isInFeatureChunk(worldX, worldZ)) {
                                final byte mapX = (byte)((worldX - centerX) / (float)blocksPerPixel * 2.0f);
                                final byte mapZ = (byte)((worldZ - centerZ) / (float)blocksPerPixel * 2.0f);
                                final TFFeature feature = TFFeature.getFeatureAt(worldX, worldZ, (ISeedReader)world);
                                final TFMagicMapData tfData = (TFMagicMapData)data;
                                tfData.tfDecorations.add(new TFMagicMapData.TFMapDecoration(feature.ordinal(), mapX, mapZ, (byte)8));
                            }
                        }
                    }
                }
            }
        }
    }
    
    private MapColorBrightness getMapColorPerBiome(final World world, final Biome biome) {
        if (MagicMapItem.BIOME_COLORS.isEmpty()) {
            setupBiomeColors();
        }
        if (biome == null) {
            return new MapColorBrightness(MaterialColor.field_151646_E);
        }
        final ResourceLocation key = biome.getRegistryName();
        final MapColorBrightness color = MagicMapItem.BIOME_COLORS.get(key);
        if (color != null) {
            return color;
        }
        return new MapColorBrightness(biome.func_242440_e().func_242502_e().func_204108_a().func_185909_g((IBlockReader)world, BlockPos.field_177992_a));
    }
    
    private static void setupBiomeColors() {
        putBiomeColor(BiomeKeys.FOREST, new MapColorBrightness(MaterialColor.field_151669_i, 1));
        putBiomeColor(BiomeKeys.DENSE_FOREST, new MapColorBrightness(MaterialColor.field_151669_i, 0));
        putBiomeColor(BiomeKeys.LAKE, new MapColorBrightness(MaterialColor.field_151662_n, 3));
        putBiomeColor(BiomeKeys.STREAM, new MapColorBrightness(MaterialColor.field_151662_n, 1));
        putBiomeColor(BiomeKeys.SWAMP, new MapColorBrightness(MaterialColor.field_151648_G, 3));
        putBiomeColor(BiomeKeys.FIRE_SWAMP, new MapColorBrightness(MaterialColor.field_151655_K, 1));
        putBiomeColor(BiomeKeys.CLEARING, new MapColorBrightness(MaterialColor.field_151661_c, 2));
        putBiomeColor(BiomeKeys.OAK_SAVANNAH, new MapColorBrightness(MaterialColor.field_151661_c, 0));
        putBiomeColor(BiomeKeys.HIGHLANDS, new MapColorBrightness(MaterialColor.field_151664_l, 0));
        putBiomeColor(BiomeKeys.THORNLANDS, new MapColorBrightness(MaterialColor.field_151663_o, 3));
        putBiomeColor(BiomeKeys.FINAL_PLATEAU, new MapColorBrightness(MaterialColor.field_197656_x, 2));
        putBiomeColor(BiomeKeys.FIREFLY_FOREST, new MapColorBrightness(MaterialColor.field_151653_I, 1));
        putBiomeColor(BiomeKeys.DARK_FOREST, new MapColorBrightness(MaterialColor.field_151651_C, 3));
        putBiomeColor(BiomeKeys.DARK_FOREST_CENTER, new MapColorBrightness(MaterialColor.field_151676_q, 3));
        putBiomeColor(BiomeKeys.SNOWY_FOREST, new MapColorBrightness(MaterialColor.field_151666_j, 1));
        putBiomeColor(BiomeKeys.GLACIER, new MapColorBrightness(MaterialColor.field_151657_g, 1));
        putBiomeColor(BiomeKeys.MUSHROOM_FOREST, new MapColorBrightness(MaterialColor.field_151676_q, 0));
        putBiomeColor(BiomeKeys.DENSE_MUSHROOM_FOREST, new MapColorBrightness(MaterialColor.field_151671_v, 0));
        putBiomeColor(BiomeKeys.ENCHANTED_FOREST, new MapColorBrightness(MaterialColor.field_151679_y, 2));
        putBiomeColor(BiomeKeys.SPOOKY_FOREST, new MapColorBrightness(MaterialColor.field_151678_z, 0));
    }
    
    private static void putBiomeColor(final RegistryKey<Biome> biome, final MapColorBrightness color) {
        MagicMapItem.BIOME_COLORS.put(biome.func_240901_a_(), color);
    }
    
    public static int getBiomeColor(final Biome biome) {
        if (MagicMapItem.BIOME_COLORS.isEmpty()) {
            setupBiomeColors();
        }
        final MapColorBrightness c = MagicMapItem.BIOME_COLORS.get(ForgeRegistries.BIOMES.getKey((IForgeRegistryEntry)biome));
        return (c != null) ? getMapColor(c) : -16777216;
    }
    
    public static int getMapColor(final MapColorBrightness mcb) {
        int i = 220;
        switch (mcb.color.field_76290_q) {
            case 3: {
                i = 135;
                break;
            }
            case 2: {
                i = 255;
                break;
            }
            case 0: {
                i = 180;
                break;
            }
        }
        final int j = (mcb.color.field_76291_p >> 16 & 0xFF) * i / 255;
        final int k = (mcb.color.field_76291_p >> 8 & 0xFF) * i / 255;
        final int l = (mcb.color.field_76291_p & 0xFF) * i / 255;
        return 0xFF000000 | l << 16 | k << 8 | j;
    }
    
    public void func_77622_d(final ItemStack stack, final World world, final PlayerEntity player) {
    }
    
    @Nullable
    public IPacket<?> func_150911_c(final ItemStack stack, final World world, final PlayerEntity player) {
        final IPacket<?> p = (IPacket<?>)super.func_150911_c(stack, world, player);
        if (p instanceof SMapDataPacket) {
            final TFMagicMapData mapdata = this.getCustomMapData(stack, world);
            return (IPacket<?>)TFPacketHandler.CHANNEL.toVanillaPacket((Object)new MagicMapPacket(mapdata, (SMapDataPacket)p), NetworkDirection.PLAY_TO_CLIENT);
        }
        return p;
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
