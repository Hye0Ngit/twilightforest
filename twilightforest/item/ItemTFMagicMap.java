// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.HashMap;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import twilightforest.network.PacketMagicMap;
import twilightforest.network.TFPacketHandler;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraft.network.Packet;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.material.MapColor;
import twilightforest.TFFeature;
import twilightforest.biomes.TFBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import javax.annotation.Nullable;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.WorldSavedData;
import twilightforest.TFMagicMapData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemMap;

public class ItemTFMagicMap extends ItemMap implements ModelRegisterCallback
{
    public static final String STR_ID = "magicmap";
    private static final Map<ResourceLocation, MapColorBrightness> BIOME_COLORS;
    
    public static ItemStack setupNewMap(final World world, final double worldX, final double worldZ, final byte scale, final boolean trackingPosition, final boolean unlimitedTracking) {
        final ItemStack itemstack = new ItemStack(TFItems.magic_map, 1, world.func_72841_b("magicmap"));
        final String s = "magicmap_" + itemstack.func_77960_j();
        final MapData mapdata = new TFMagicMapData(s);
        world.func_72823_a(s, (WorldSavedData)mapdata);
        mapdata.func_176054_a(worldX, worldZ, (int)(mapdata.field_76197_d = scale));
        mapdata.field_76200_c = world.field_73011_w.getDimension();
        mapdata.field_186210_e = trackingPosition;
        mapdata.field_191096_f = unlimitedTracking;
        mapdata.func_76185_a();
        return itemstack;
    }
    
    @Nullable
    @SideOnly(Side.CLIENT)
    public static TFMagicMapData loadMapData(final int mapId, final World worldIn) {
        final String s = "magicmap_" + mapId;
        return (TFMagicMapData)worldIn.func_72943_a((Class)TFMagicMapData.class, s);
    }
    
    public TFMagicMapData getMapData(final ItemStack stack, final World worldIn) {
        String s = "magicmap_" + stack.func_77960_j();
        TFMagicMapData mapdata = (TFMagicMapData)worldIn.func_72943_a((Class)TFMagicMapData.class, s);
        if (mapdata == null && !worldIn.field_72995_K) {
            stack.func_77964_b(worldIn.func_72841_b("magicmap"));
            s = "magicmap_" + stack.func_77960_j();
            mapdata = new TFMagicMapData(s);
            mapdata.field_76197_d = 3;
            mapdata.func_176054_a(worldIn.func_72912_H().func_76079_c(), worldIn.func_72912_H().func_76074_e(), mapdata.field_76197_d);
            mapdata.field_76200_c = worldIn.field_73011_w.getDimension();
            mapdata.func_76185_a();
            worldIn.func_72823_a(s, (WorldSavedData)mapdata);
        }
        return mapdata;
    }
    
    public void func_77872_a(final World world, final Entity viewer, final MapData data) {
        if (world.field_73011_w.getDimension() == data.field_76200_c && viewer instanceof EntityPlayer) {
            final int biomesPerPixel = 4;
            final int blocksPerPixel = 16;
            final int centerX = data.field_76201_a;
            final int centerZ = data.field_76199_b;
            final int viewerX = MathHelper.func_76128_c(viewer.field_70165_t - centerX) / blocksPerPixel + 64;
            final int viewerZ = MathHelper.func_76128_c(viewer.field_70161_v - centerZ) / blocksPerPixel + 64;
            final int viewRadiusPixels = 512 / blocksPerPixel;
            final int startX = (centerX / blocksPerPixel - 64) * biomesPerPixel;
            final int startZ = (centerZ / blocksPerPixel - 64) * biomesPerPixel;
            final Biome[] biomes = world.func_72959_q().func_76937_a((Biome[])null, startX, startZ, 128 * biomesPerPixel, 128 * biomesPerPixel);
            for (int xPixel = viewerX - viewRadiusPixels + 1; xPixel < viewerX + viewRadiusPixels; ++xPixel) {
                for (int zPixel = viewerZ - viewRadiusPixels - 1; zPixel < viewerZ + viewRadiusPixels; ++zPixel) {
                    if (xPixel >= 0 && zPixel >= 0 && xPixel < 128 && zPixel < 128) {
                        final int xPixelDist = xPixel - viewerX;
                        final int zPixelDist = zPixel - viewerZ;
                        final boolean shouldFuzz = xPixelDist * xPixelDist + zPixelDist * zPixelDist > (viewRadiusPixels - 2) * (viewRadiusPixels - 2);
                        Biome biome = biomes[xPixel * biomesPerPixel + zPixel * biomesPerPixel * 128 * biomesPerPixel];
                        final Biome overBiome = biomes[xPixel * biomesPerPixel + zPixel * biomesPerPixel * 128 * biomesPerPixel + 1];
                        final Biome downBiome = biomes[xPixel * biomesPerPixel + (zPixel * biomesPerPixel + 1) * 128 * biomesPerPixel];
                        if (overBiome == TFBiomes.stream || downBiome == TFBiomes.stream) {
                            biome = TFBiomes.stream;
                        }
                        final MapColorBrightness colorBrightness = this.getMapColorPerBiome(world, biome);
                        final MapColor mapcolor = colorBrightness.color;
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
                            if (TFFeature.isInFeatureChunk(world, worldX, worldZ)) {
                                final byte mapX = (byte)((worldX - centerX) / (float)blocksPerPixel * 2.0f);
                                final byte mapZ = (byte)((worldZ - centerZ) / (float)blocksPerPixel * 2.0f);
                                final TFFeature feature = TFFeature.getFeatureAt(worldX, worldZ, world);
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
        if (ItemTFMagicMap.BIOME_COLORS.isEmpty()) {
            setupBiomeColors();
        }
        final MapColorBrightness color = ItemTFMagicMap.BIOME_COLORS.get(biome.getRegistryName());
        if (color != null) {
            return color;
        }
        return new MapColorBrightness(biome.field_76752_A.func_185909_g((IBlockAccess)world, BlockPos.field_177992_a));
    }
    
    private static void setupBiomeColors() {
        putBiomeColor(TFBiomes.twilightForest, new MapColorBrightness(MapColor.field_151669_i, 1));
        putBiomeColor(TFBiomes.denseTwilightForest, new MapColorBrightness(MapColor.field_151669_i, 0));
        putBiomeColor(TFBiomes.tfLake, new MapColorBrightness(MapColor.field_151662_n, 3));
        putBiomeColor(TFBiomes.stream, new MapColorBrightness(MapColor.field_151662_n, 1));
        putBiomeColor(TFBiomes.tfSwamp, new MapColorBrightness(MapColor.field_151648_G, 3));
        putBiomeColor(TFBiomes.fireSwamp, new MapColorBrightness(MapColor.field_151655_K, 1));
        putBiomeColor(TFBiomes.clearing, new MapColorBrightness(MapColor.field_151661_c, 2));
        putBiomeColor(TFBiomes.oakSavanna, new MapColorBrightness(MapColor.field_151661_c, 0));
        putBiomeColor(TFBiomes.highlands, new MapColorBrightness(MapColor.field_151664_l, 0));
        putBiomeColor(TFBiomes.thornlands, new MapColorBrightness(MapColor.field_151663_o, 3));
        putBiomeColor(TFBiomes.highlandsCenter, new MapColorBrightness(MapColor.field_151680_x, 2));
        putBiomeColor(TFBiomes.fireflyForest, new MapColorBrightness(MapColor.field_151653_I, 1));
        putBiomeColor(TFBiomes.darkForest, new MapColorBrightness(MapColor.field_151651_C, 3));
        putBiomeColor(TFBiomes.darkForestCenter, new MapColorBrightness(MapColor.field_151676_q, 3));
        putBiomeColor(TFBiomes.snowy_forest, new MapColorBrightness(MapColor.field_151666_j, 1));
        putBiomeColor(TFBiomes.glacier, new MapColorBrightness(MapColor.field_151657_g, 1));
        putBiomeColor(TFBiomes.mushrooms, new MapColorBrightness(MapColor.field_151676_q, 0));
        putBiomeColor(TFBiomes.deepMushrooms, new MapColorBrightness(MapColor.field_151671_v, 0));
        putBiomeColor(TFBiomes.enchantedForest, new MapColorBrightness(MapColor.field_151672_u, 2));
        putBiomeColor(TFBiomes.spookyForest, new MapColorBrightness(MapColor.field_151678_z, 0));
    }
    
    private static void putBiomeColor(final Biome biome, final MapColorBrightness color) {
        ItemTFMagicMap.BIOME_COLORS.put(biome.getRegistryName(), color);
    }
    
    public void func_77622_d(final ItemStack stack, final World world, final EntityPlayer player) {
    }
    
    @Nullable
    public Packet<?> func_150911_c(final ItemStack stack, final World world, final EntityPlayer player) {
        final Packet<?> p = (Packet<?>)super.func_150911_c(stack, world, player);
        if (p instanceof SPacketMaps) {
            final TFMagicMapData mapdata = this.getMapData(stack, world);
            return (Packet<?>)TFPacketHandler.CHANNEL.getPacketFrom((IMessage)new PacketMagicMap(stack.func_77952_i(), mapdata, (SPacketMaps)p));
        }
        return p;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelLoader.setCustomMeshDefinition((Item)this, stack -> new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
    
    static {
        BIOME_COLORS = new HashMap<ResourceLocation, MapColorBrightness>();
    }
    
    private static class MapColorBrightness
    {
        public MapColor color;
        public int brightness;
        
        public MapColorBrightness(final MapColor color, final int brightness) {
            this.color = color;
            this.brightness = brightness;
        }
        
        public MapColorBrightness(final MapColor color) {
            this.color = color;
            this.brightness = 1;
        }
    }
}
