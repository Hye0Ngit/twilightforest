// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.fml.network.NetworkDirection;
import twilightforest.network.MazeMapPacket;
import twilightforest.network.TFPacketHandler;
import net.minecraft.network.play.server.SMapDataPacket;
import net.minecraft.network.IPacket;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.storage.MapDecoration;
import net.minecraft.block.BlockState;
import net.minecraft.world.chunk.Chunk;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import com.google.common.collect.HashMultiset;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.storage.MapData;
import net.minecraft.entity.Entity;
import javax.annotation.Nullable;
import twilightforest.TFMazeMapData;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.item.FilledMapItem;

public class MazeMapItem extends FilledMapItem
{
    public static final String STR_ID = "mazemap";
    private static final int YSEARCH = 3;
    protected final boolean mapOres;
    
    protected MazeMapItem(final boolean mapOres, final Item.Properties props) {
        super(props);
        this.mapOres = mapOres;
    }
    
    public static ItemStack setupNewMap(final World world, final int worldX, final int worldZ, final byte scale, final boolean trackingPosition, final boolean unlimitedTracking, final int worldY, final boolean mapOres) {
        final ItemStack itemstack = new ItemStack(mapOres ? ((IItemProvider)TFItems.ore_map.get()) : ((IItemProvider)TFItems.maze_map.get()));
        createMapData(itemstack, world, worldX, worldZ, scale, trackingPosition, unlimitedTracking, (RegistryKey<World>)world.func_234923_W_(), worldY);
        return itemstack;
    }
    
    @Nullable
    public static TFMazeMapData getData(final ItemStack stack, final World world) {
        return TFMazeMapData.getMazeMapData(world, getMapName(func_195949_f(stack)));
    }
    
    @Nullable
    protected TFMazeMapData getCustomMapData(final ItemStack stack, final World world) {
        TFMazeMapData mapdata = getData(stack, world);
        if (mapdata == null && !world.field_72995_K) {
            mapdata = createMapData(stack, world, world.func_72912_H().func_76079_c(), world.func_72912_H().func_76074_e(), 0, false, false, (RegistryKey<World>)world.func_234923_W_(), world.func_72912_H().func_76075_d());
        }
        return mapdata;
    }
    
    private static TFMazeMapData createMapData(final ItemStack stack, final World world, final int x, final int z, final int scale, final boolean trackingPosition, final boolean unlimitedTracking, final RegistryKey<World> dimension, final int y) {
        final int i = world.func_217395_y();
        final TFMazeMapData mapdata = new TFMazeMapData(getMapName(i));
        mapdata.func_237241_a_(x, z, scale, trackingPosition, unlimitedTracking, (RegistryKey)dimension);
        mapdata.calculateMapCenter(world, x, y, z, scale);
        TFMazeMapData.registerMazeMapData(world, mapdata);
        stack.func_196082_o().func_74768_a("map", i);
        return mapdata;
    }
    
    public static String getMapName(final int id) {
        return "mazemap_" + id;
    }
    
    public void func_77872_a(final World world, final Entity viewer, final MapData data) {
        if (world.func_234923_W_() == data.field_76200_c && viewer instanceof PlayerEntity) {
            final int blocksPerPixel = 1 << data.field_76197_d;
            final int centerX = data.field_76201_a;
            final int centerZ = data.field_76199_b;
            final int viewerX = MathHelper.func_76128_c(viewer.func_226277_ct_() - centerX) / blocksPerPixel + 64;
            final int viewerZ = MathHelper.func_76128_c(viewer.func_226281_cx_() - centerZ) / blocksPerPixel + 64;
            int viewRadiusPixels = 16;
            if (world.func_230315_m_().func_236037_d_()) {
                viewRadiusPixels /= 2;
            }
            final MapData.MapInfo func_82568_a;
            final MapData.MapInfo mapdata$mapinfo = func_82568_a = data.func_82568_a((PlayerEntity)viewer);
            ++func_82568_a.field_82569_d;
            boolean flag = false;
            for (int xPixel = viewerX - viewRadiusPixels + 1; xPixel < viewerX + viewRadiusPixels; ++xPixel) {
                if ((xPixel & 0xF) == (mapdata$mapinfo.field_82569_d & 0xF) || flag) {
                    flag = false;
                    final double d0 = 0.0;
                    for (int zPixel = viewerZ - viewRadiusPixels - 1; zPixel < viewerZ + viewRadiusPixels; ++zPixel) {
                        if (xPixel >= 0 && zPixel >= -1 && xPixel < 128 && zPixel < 128) {
                            final int xPixelDist = xPixel - viewerX;
                            final int zPixelDist = zPixel - viewerZ;
                            final boolean shouldFuzz = xPixelDist * xPixelDist + zPixelDist * zPixelDist > (viewRadiusPixels - 2) * (viewRadiusPixels - 2);
                            final int worldX = (centerX / blocksPerPixel + xPixel - 64) * blocksPerPixel;
                            final int worldZ = (centerZ / blocksPerPixel + zPixel - 64) * blocksPerPixel;
                            final Multiset<MaterialColor> multiset = (Multiset<MaterialColor>)HashMultiset.create();
                            final Chunk chunk = world.func_175726_f(new BlockPos(worldX, 0, worldZ));
                            int brightness = 1;
                            if (!chunk.func_76621_g()) {
                                final int worldXRounded = worldX & 0xF;
                                final int worldZRounded = worldZ & 0xF;
                                final int numLiquid = 0;
                                final double d2 = 0.0;
                                if (world.func_230315_m_().func_236037_d_()) {
                                    int l3 = worldX + worldZ * 231871;
                                    l3 = l3 * l3 * 31287121 + l3 * 11;
                                    if ((l3 >> 20 & 0x1) == 0x0) {
                                        multiset.add((Object)Blocks.field_150346_d.func_176223_P().func_185909_g((IBlockReader)world, BlockPos.field_177992_a), 10);
                                    }
                                    else {
                                        multiset.add((Object)Blocks.field_150348_b.func_176223_P().func_185909_g((IBlockReader)world, BlockPos.field_177992_a), 100);
                                    }
                                }
                                else {
                                    final int yCenter = ((TFMazeMapData)data).yCenter;
                                    final BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable(worldXRounded, yCenter, worldZRounded);
                                    BlockState state = chunk.func_180495_p((BlockPos)blockpos$mutableblockpos);
                                    multiset.add((Object)state.func_185909_g((IBlockReader)world, (BlockPos)blockpos$mutableblockpos));
                                    if (state.func_177230_c() == Blocks.field_150348_b || state.func_177230_c() == Blocks.field_150350_a) {
                                        int i = -3;
                                        while (i <= 3) {
                                            blockpos$mutableblockpos.func_185336_p(yCenter + i);
                                            final BlockState searchID = chunk.func_180495_p((BlockPos)blockpos$mutableblockpos);
                                            if (searchID.func_177230_c() != Blocks.field_150348_b && searchID.func_177230_c() != Blocks.field_150350_a) {
                                                state = searchID;
                                                if (i > 0) {
                                                    brightness = 2;
                                                }
                                                if (i < 0) {
                                                    brightness = 0;
                                                    break;
                                                }
                                                break;
                                            }
                                            else {
                                                ++i;
                                            }
                                        }
                                    }
                                    if (this.mapOres) {
                                        if (state.func_177230_c() == Blocks.field_150365_q) {
                                            multiset.add((Object)MaterialColor.field_151646_E, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150352_o) {
                                            multiset.add((Object)MaterialColor.field_151647_F, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150366_p) {
                                            multiset.add((Object)MaterialColor.field_151668_h, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150369_x) {
                                            multiset.add((Object)MaterialColor.field_151652_H, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150450_ax) {
                                            multiset.add((Object)MaterialColor.field_151645_D, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150482_ag) {
                                            multiset.add((Object)MaterialColor.field_151648_G, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150412_bA) {
                                            multiset.add((Object)MaterialColor.field_151653_I, 1000);
                                        }
                                        else if (state.func_177230_c() != Blocks.field_150350_a && state.func_235714_a_((ITag)Tags.Blocks.ORES)) {
                                            multiset.add((Object)MaterialColor.field_151671_v, 1000);
                                        }
                                    }
                                }
                                final MaterialColor mapcolor = (MaterialColor)Iterables.getFirst((Iterable)Multisets.copyHighestCountFirst((Multiset)multiset), (Object)MaterialColor.field_151660_b);
                                if (zPixel >= 0 && xPixelDist * xPixelDist + zPixelDist * zPixelDist < viewRadiusPixels * viewRadiusPixels && (!shouldFuzz || (xPixel + zPixel & 0x1) != 0x0)) {
                                    final byte b0 = data.field_76198_e[xPixel + zPixel * 128];
                                    final byte b2 = (byte)(mapcolor.field_76290_q * 4 + brightness);
                                    if (b0 != b2) {
                                        data.field_76198_e[xPixel + zPixel * 128] = b2;
                                        data.func_176053_a(xPixel, zPixel);
                                        flag = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void func_77663_a(final ItemStack stack, final World worldIn, final Entity entityIn, final int slot, final boolean isSelected) {
        if (!worldIn.field_72995_K) {
            final TFMazeMapData mapdata = this.getCustomMapData(stack, worldIn);
            if (mapdata != null) {
                if (entityIn instanceof PlayerEntity) {
                    final PlayerEntity entityplayer = (PlayerEntity)entityIn;
                    mapdata.func_76191_a(entityplayer, stack);
                    final int yProximity = MathHelper.func_76128_c(entityplayer.func_226278_cu_() - mapdata.yCenter);
                    if (yProximity < -3 || yProximity > 3) {
                        final MapDecoration decoration = mapdata.field_76203_h.get(entityplayer.func_200200_C_().getString());
                        if (decoration != null) {
                            mapdata.field_76203_h.put(entityplayer.func_200200_C_().getString(), new MapDecoration(MapDecoration.Type.PLAYER_OFF_MAP, decoration.func_176112_b(), decoration.func_176113_c(), decoration.func_176111_d(), (ITextComponent)null));
                        }
                    }
                }
                if (!mapdata.field_215161_h && (isSelected || (entityIn instanceof PlayerEntity && ((PlayerEntity)entityIn).func_184592_cb() == stack))) {
                    this.func_77872_a(worldIn, entityIn, mapdata);
                }
            }
        }
    }
    
    public void func_77622_d(final ItemStack stack, final World world, final PlayerEntity player) {
    }
    
    @Nullable
    public IPacket<?> func_150911_c(final ItemStack stack, final World worldIn, final PlayerEntity player) {
        final IPacket<?> p = (IPacket<?>)super.func_150911_c(stack, worldIn, player);
        if (p instanceof SMapDataPacket) {
            return (IPacket<?>)TFPacketHandler.CHANNEL.toVanillaPacket((Object)new MazeMapPacket((SMapDataPacket)p), NetworkDirection.PLAY_TO_CLIENT);
        }
        return p;
    }
}
