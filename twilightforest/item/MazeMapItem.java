// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.fmllegacy.network.NetworkDirection;
import twilightforest.network.MazeMapPacket;
import twilightforest.network.TFPacketHandler;
import net.minecraft.network.protocol.game.ClientboundMapItemDataPacket;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import net.minecraft.tags.Tag;
import net.minecraftforge.common.Tags;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import com.google.common.collect.HashMultiset;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import javax.annotation.Nullable;
import twilightforest.TFMazeMapData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MapItem;

public class MazeMapItem extends MapItem
{
    public static final String STR_ID = "mazemap";
    private static final int YSEARCH = 3;
    protected final boolean mapOres;
    
    protected MazeMapItem(final boolean mapOres, final Item.Properties props) {
        super(props);
        this.mapOres = mapOres;
    }
    
    public static ItemStack setupNewMap(final Level world, final int worldX, final int worldZ, final byte scale, final boolean trackingPosition, final boolean unlimitedTracking, final int worldY, final boolean mapOres) {
        final ItemStack itemstack = new ItemStack(mapOres ? ((ItemLike)TFItems.FILLED_ORE_MAP.get()) : ((ItemLike)TFItems.FILLED_MAZE_MAP.get()));
        createMapData(itemstack, world, worldX, worldZ, scale, trackingPosition, unlimitedTracking, (ResourceKey<Level>)world.m_46472_(), worldY);
        return itemstack;
    }
    
    @Nullable
    public static TFMazeMapData getData(final ItemStack stack, final Level world) {
        final Integer id = m_151131_(stack);
        return (id == null) ? null : TFMazeMapData.getMazeMapData(world, getMapName(id));
    }
    
    @Nullable
    protected TFMazeMapData getCustomMapData(final ItemStack stack, final Level world) {
        TFMazeMapData mapdata = getData(stack, world);
        if (mapdata == null && !world.f_46443_) {
            mapdata = createMapData(stack, world, world.m_6106_().m_6789_(), world.m_6106_().m_6526_(), 0, false, false, (ResourceKey<Level>)world.m_46472_(), world.m_6106_().m_6527_());
        }
        return mapdata;
    }
    
    private static TFMazeMapData createMapData(final ItemStack stack, final Level world, final int x, final int z, final int scale, final boolean trackingPosition, final boolean unlimitedTracking, final ResourceKey<Level> dimension, final int y) {
        final int i = world.m_7354_();
        final int mapSize = 128 * (1 << scale);
        final int roundX = Mth.m_14107_((x + 64.0) / mapSize);
        final int roundZ = Mth.m_14107_((z + 64.0) / mapSize);
        final int scaledX = roundX * mapSize + mapSize / 2 - 64;
        final int scaledZ = roundZ * mapSize + mapSize / 2 - 64;
        final TFMazeMapData mapdata = new TFMazeMapData(scaledX, scaledZ, (byte)scale, trackingPosition, unlimitedTracking, false, dimension);
        mapdata.calculateMapCenter(world, x, y, z);
        TFMazeMapData.registerMazeMapData(world, mapdata, getMapName(i));
        stack.m_41784_().m_128405_("map", i);
        return mapdata;
    }
    
    public static String getMapName(final int id) {
        return "mazemap_" + id;
    }
    
    public void m_42893_(final Level world, final Entity viewer, final MapItemSavedData data) {
        if (world.m_46472_() == data.f_77887_ && viewer instanceof Player) {
            final int blocksPerPixel = 1 << data.f_77890_;
            final int centerX = data.f_77885_;
            final int centerZ = data.f_77886_;
            final int viewerX = Mth.m_14107_(viewer.m_20185_() - centerX) / blocksPerPixel + 64;
            final int viewerZ = Mth.m_14107_(viewer.m_20189_() - centerZ) / blocksPerPixel + 64;
            int viewRadiusPixels = 16;
            if (world.m_6042_().m_63946_()) {
                viewRadiusPixels /= 2;
            }
            final MapItemSavedData.HoldingPlayer 77916_;
            final MapItemSavedData.HoldingPlayer mapdata$mapinfo = 77916_ = data.m_77916_((Player)viewer);
            ++77916_.f_77960_;
            boolean flag = false;
            for (int xPixel = viewerX - viewRadiusPixels + 1; xPixel < viewerX + viewRadiusPixels; ++xPixel) {
                if ((xPixel & 0xF) == (mapdata$mapinfo.f_77960_ & 0xF) || flag) {
                    flag = false;
                    for (int zPixel = viewerZ - viewRadiusPixels - 1; zPixel < viewerZ + viewRadiusPixels; ++zPixel) {
                        if (xPixel >= 0 && zPixel >= -1 && xPixel < 128 && zPixel < 128) {
                            final int xPixelDist = xPixel - viewerX;
                            final int zPixelDist = zPixel - viewerZ;
                            final boolean shouldFuzz = xPixelDist * xPixelDist + zPixelDist * zPixelDist > (viewRadiusPixels - 2) * (viewRadiusPixels - 2);
                            final int worldX = (centerX / blocksPerPixel + xPixel - 64) * blocksPerPixel;
                            final int worldZ = (centerZ / blocksPerPixel + zPixel - 64) * blocksPerPixel;
                            final Multiset<MaterialColor> multiset = (Multiset<MaterialColor>)HashMultiset.create();
                            final LevelChunk chunk = world.m_46745_(new BlockPos(worldX, 0, worldZ));
                            int brightness = 1;
                            if (!chunk.m_6430_()) {
                                final int worldXRounded = worldX & 0xF;
                                final int worldZRounded = worldZ & 0xF;
                                if (world.m_6042_().m_63946_()) {
                                    int l3 = worldX + worldZ * 231871;
                                    l3 = l3 * l3 * 31287121 + l3 * 11;
                                    if ((l3 >> 20 & 0x1) == 0x0) {
                                        multiset.add((Object)Blocks.f_50493_.m_49966_().m_60780_((BlockGetter)world, BlockPos.f_121853_), 10);
                                    }
                                    else {
                                        multiset.add((Object)Blocks.f_50069_.m_49966_().m_60780_((BlockGetter)world, BlockPos.f_121853_), 100);
                                    }
                                }
                                else {
                                    final int yCenter = ((TFMazeMapData)data).yCenter;
                                    final BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(worldXRounded, yCenter, worldZRounded);
                                    BlockState state = chunk.m_8055_((BlockPos)blockpos$mutableblockpos);
                                    multiset.add((Object)state.m_60780_((BlockGetter)world, (BlockPos)blockpos$mutableblockpos));
                                    if (state.m_60734_() == Blocks.f_50069_ || state.m_60734_() == Blocks.f_50016_) {
                                        int i = -3;
                                        while (i <= 3) {
                                            blockpos$mutableblockpos.m_142448_(yCenter + i);
                                            final BlockState searchID = chunk.m_8055_((BlockPos)blockpos$mutableblockpos);
                                            if (searchID.m_60734_() != Blocks.f_50069_ && searchID.m_60734_() != Blocks.f_50016_) {
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
                                        if (state.m_60734_() == BlockTags.f_144262_) {
                                            multiset.add((Object)MaterialColor.f_76365_, 1000);
                                        }
                                        else if (state.m_60734_() == BlockTags.f_13043_) {
                                            multiset.add((Object)MaterialColor.f_76366_, 1000);
                                        }
                                        else if (state.m_60734_() == BlockTags.f_144258_) {
                                            multiset.add((Object)MaterialColor.f_76404_, 1000);
                                        }
                                        else if (state.m_60734_() == BlockTags.f_144261_) {
                                            multiset.add((Object)MaterialColor.f_76368_, 1000);
                                        }
                                        else if (state.m_60734_() == BlockTags.f_144260_) {
                                            multiset.add((Object)MaterialColor.f_76364_, 1000);
                                        }
                                        else if (state.m_60734_() == BlockTags.f_144259_) {
                                            multiset.add((Object)MaterialColor.f_76367_, 1000);
                                        }
                                        else if (state.m_60734_() == BlockTags.f_144263_) {
                                            multiset.add((Object)MaterialColor.f_76369_, 1000);
                                        }
                                        else if (state.m_60734_() == BlockTags.f_144264_) {
                                            multiset.add((Object)MaterialColor.f_76413_, 1000);
                                        }
                                        else if (state.m_60734_() != Blocks.f_50016_ && state.m_60620_((Tag)Tags.Blocks.ORES)) {
                                            multiset.add((Object)MaterialColor.f_76418_, 1000);
                                        }
                                    }
                                }
                                final MaterialColor mapcolor = (MaterialColor)Iterables.getFirst((Iterable)Multisets.copyHighestCountFirst((Multiset)multiset), (Object)MaterialColor.f_76398_);
                                if (zPixel >= 0 && xPixelDist * xPixelDist + zPixelDist * zPixelDist < viewRadiusPixels * viewRadiusPixels && (!shouldFuzz || (xPixel + zPixel & 0x1) != 0x0)) {
                                    final byte b0 = data.f_77891_[xPixel + zPixel * 128];
                                    final byte b2 = (byte)(mapcolor.f_76397_ * 4 + brightness);
                                    if (b0 != b2) {
                                        data.m_164803_(xPixel, zPixel, b2);
                                        data.m_77762_();
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
    
    public void m_6883_(final ItemStack stack, final Level worldIn, final Entity entityIn, final int slot, final boolean isSelected) {
        if (!worldIn.f_46443_) {
            final TFMazeMapData mapdata = this.getCustomMapData(stack, worldIn);
            if (mapdata != null) {
                if (entityIn instanceof final Player entityplayer) {
                    mapdata.m_77918_(entityplayer, stack);
                    final int yProximity = Mth.m_14107_(entityplayer.m_20186_() - mapdata.yCenter);
                    if (yProximity < -3 || yProximity > 3) {
                        final MapDecoration decoration = mapdata.f_77894_.get(entityplayer.m_7755_().getString());
                        if (decoration != null) {
                            mapdata.f_77894_.put(entityplayer.m_7755_().getString(), new MapDecoration(MapDecoration.Type.PLAYER_OFF_MAP, decoration.m_77804_(), decoration.m_77805_(), decoration.m_77806_(), (Component)null));
                        }
                    }
                }
                if (!mapdata.f_77892_) {
                    if (!isSelected) {
                        if (!(entityIn instanceof Player)) {
                            return;
                        }
                        final Player player = (Player)entityIn;
                        if (player.m_21206_() != stack) {
                            return;
                        }
                    }
                    this.m_42893_(worldIn, entityIn, mapdata);
                }
            }
        }
    }
    
    public void m_7836_(final ItemStack stack, final Level world, final Player player) {
    }
    
    @Nullable
    public Packet<?> m_7233_(final ItemStack stack, final Level worldIn, final Player player) {
        final Integer id = m_151131_(stack);
        final TFMazeMapData mapdata = this.getCustomMapData(stack, worldIn);
        final Packet<?> p = (Packet<?>)((id == null || mapdata == null) ? null : mapdata.m_164796_((int)id, player));
        return (p instanceof ClientboundMapItemDataPacket) ? TFPacketHandler.CHANNEL.toVanillaPacket((Object)new MazeMapPacket((ClientboundMapItemDataPacket)p), NetworkDirection.PLAY_TO_CLIENT) : p;
    }
}
