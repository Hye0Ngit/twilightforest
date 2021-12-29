// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import twilightforest.network.PacketMazeMap;
import twilightforest.network.TFPacketHandler;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraft.network.Packet;
import net.minecraft.item.EnumRarity;
import net.minecraft.world.storage.MapDecoration;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.chunk.Chunk;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.BlockStone;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import com.google.common.collect.HashMultiset;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.storage.MapData;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import javax.annotation.Nullable;
import net.minecraft.world.storage.WorldSavedData;
import twilightforest.TFMazeMapData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemMap;

public class ItemTFMazeMap extends ItemMap implements ModelRegisterCallback
{
    public static final String STR_ID = "mazemap";
    private static final int YSEARCH = 3;
    protected final boolean mapOres;
    
    protected ItemTFMazeMap(final boolean mapOres) {
        this.mapOres = mapOres;
    }
    
    public static ItemStack setupNewMap(final World world, final double worldX, final double worldZ, final byte scale, final boolean trackingPosition, final boolean unlimitedTracking, final double worldY, final boolean mapOres) {
        final ItemStack itemstack = new ItemStack(mapOres ? TFItems.ore_map : TFItems.maze_map, 1, world.func_72841_b("mazemap"));
        final String s = "mazemap_" + itemstack.func_77960_j();
        final TFMazeMapData mapdata = new TFMazeMapData(s);
        world.func_72823_a(s, (WorldSavedData)mapdata);
        mapdata.calculateMapCenter(world, worldX, worldY, worldZ, mapdata.field_76197_d = scale);
        mapdata.field_76200_c = world.field_73011_w.getDimension();
        mapdata.field_186210_e = trackingPosition;
        mapdata.field_191096_f = unlimitedTracking;
        mapdata.func_76185_a();
        return itemstack;
    }
    
    @Nullable
    @SideOnly(Side.CLIENT)
    public static TFMazeMapData loadMapData(final int mapId, final World world) {
        final String s = "mazemap_" + mapId;
        return (TFMazeMapData)world.func_72943_a((Class)TFMazeMapData.class, s);
    }
    
    public TFMazeMapData getMapData(final ItemStack stack, final World worldIn) {
        String s = "mazemap_" + stack.func_77960_j();
        TFMazeMapData mapdata = (TFMazeMapData)worldIn.func_72943_a((Class)TFMazeMapData.class, s);
        if (mapdata == null && !worldIn.field_72995_K) {
            stack.func_77964_b(worldIn.func_72841_b("mazemap"));
            s = "mazemap_" + stack.func_77960_j();
            mapdata = new TFMazeMapData(s);
            mapdata.field_76197_d = 0;
            mapdata.func_176054_a((double)worldIn.func_72912_H().func_76079_c(), (double)worldIn.func_72912_H().func_76074_e(), (int)mapdata.field_76197_d);
            mapdata.field_76200_c = worldIn.field_73011_w.getDimension();
            mapdata.func_76185_a();
            worldIn.func_72823_a(s, (WorldSavedData)mapdata);
        }
        return mapdata;
    }
    
    public void func_77872_a(final World world, final Entity viewer, final MapData data) {
        if (world.field_73011_w.getDimension() == data.field_76200_c && viewer instanceof EntityPlayer) {
            final int blocksPerPixel = 1 << data.field_76197_d;
            final int centerX = data.field_76201_a;
            final int centerZ = data.field_76199_b;
            final int viewerX = MathHelper.func_76128_c(viewer.field_70165_t - centerX) / blocksPerPixel + 64;
            final int viewerZ = MathHelper.func_76128_c(viewer.field_70161_v - centerZ) / blocksPerPixel + 64;
            int viewRadiusPixels = 16;
            if (world.field_73011_w.func_177495_o()) {
                viewRadiusPixels /= 2;
            }
            final MapData.MapInfo func_82568_a;
            final MapData.MapInfo mapdata$mapinfo = func_82568_a = data.func_82568_a((EntityPlayer)viewer);
            ++func_82568_a.field_82569_d;
            boolean flag = false;
            for (int xPixel = viewerX - viewRadiusPixels + 1; xPixel < viewerX + viewRadiusPixels; ++xPixel) {
                if ((xPixel & 0xF) == (mapdata$mapinfo.field_82569_d & 0xF) || flag) {
                    flag = false;
                    double d0 = 0.0;
                    for (int zPixel = viewerZ - viewRadiusPixels - 1; zPixel < viewerZ + viewRadiusPixels; ++zPixel) {
                        if (xPixel >= 0 && zPixel >= -1 && xPixel < 128 && zPixel < 128) {
                            final int xPixelDist = xPixel - viewerX;
                            final int zPixelDist = zPixel - viewerZ;
                            final boolean shouldFuzz = xPixelDist * xPixelDist + zPixelDist * zPixelDist > (viewRadiusPixels - 2) * (viewRadiusPixels - 2);
                            final int worldX = (centerX / blocksPerPixel + xPixel - 64) * blocksPerPixel;
                            final int worldZ = (centerZ / blocksPerPixel + zPixel - 64) * blocksPerPixel;
                            final Multiset<MapColor> multiset = (Multiset<MapColor>)HashMultiset.create();
                            final Chunk chunk = world.func_175726_f(new BlockPos(worldX, 0, worldZ));
                            int brightness = 1;
                            if (!chunk.func_76621_g()) {
                                final int worldXRounded = worldX & 0xF;
                                final int worldZRounded = worldZ & 0xF;
                                final int numLiquid = 0;
                                double d2 = 0.0;
                                if (world.field_73011_w.func_177495_o()) {
                                    int l3 = worldX + worldZ * 231871;
                                    l3 = l3 * l3 * 31287121 + l3 * 11;
                                    if ((l3 >> 20 & 0x1) == 0x0) {
                                        multiset.add((Object)Blocks.field_150346_d.func_176223_P().func_177226_a((IProperty)BlockDirt.field_176386_a, (Comparable)BlockDirt.DirtType.DIRT).func_185909_g((IBlockAccess)world, BlockPos.field_177992_a), 10);
                                    }
                                    else {
                                        multiset.add((Object)Blocks.field_150348_b.func_176223_P().func_177226_a((IProperty)BlockStone.field_176247_a, (Comparable)BlockStone.EnumType.STONE).func_185909_g((IBlockAccess)world, BlockPos.field_177992_a), 100);
                                    }
                                    d2 = 100.0;
                                }
                                else {
                                    final int yCenter = ((TFMazeMapData)data).yCenter;
                                    final BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(worldXRounded, yCenter, worldZRounded);
                                    IBlockState state = chunk.func_177435_g((BlockPos)blockpos$mutableblockpos);
                                    multiset.add((Object)state.func_185909_g((IBlockAccess)world, (BlockPos)blockpos$mutableblockpos));
                                    if (state.func_177230_c() == Blocks.field_150348_b || state.func_177230_c() == Blocks.field_150350_a) {
                                        int i = -3;
                                        while (i <= 3) {
                                            blockpos$mutableblockpos.func_185336_p(yCenter + i);
                                            final IBlockState searchID = chunk.func_177435_g((BlockPos)blockpos$mutableblockpos);
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
                                            multiset.add((Object)MapColor.field_151646_E, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150352_o) {
                                            multiset.add((Object)MapColor.field_151647_F, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150366_p) {
                                            multiset.add((Object)MapColor.field_151668_h, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150369_x) {
                                            multiset.add((Object)MapColor.field_151652_H, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150450_ax || state.func_177230_c() == Blocks.field_150439_ay) {
                                            multiset.add((Object)MapColor.field_151645_D, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150482_ag) {
                                            multiset.add((Object)MapColor.field_151648_G, 1000);
                                        }
                                        else if (state.func_177230_c() == Blocks.field_150412_bA) {
                                            multiset.add((Object)MapColor.field_151653_I, 1000);
                                        }
                                        else if (state.func_177230_c() != Blocks.field_150350_a && state.func_177230_c().getRegistryName().func_110623_a().contains("ore")) {
                                            multiset.add((Object)MapColor.field_151671_v, 1000);
                                        }
                                    }
                                }
                                final MapColor mapcolor = (MapColor)Iterables.getFirst((Iterable)Multisets.copyHighestCountFirst((Multiset)multiset), (Object)MapColor.field_151660_b);
                                d0 = d2;
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
            final TFMazeMapData mapdata = this.getMapData(stack, worldIn);
            if (entityIn instanceof EntityPlayer) {
                final EntityPlayer entityplayer = (EntityPlayer)entityIn;
                mapdata.func_76191_a(entityplayer, stack);
                final int yProximity = MathHelper.func_76128_c(entityplayer.field_70163_u - mapdata.yCenter);
                if (yProximity < -3 || yProximity > 3) {
                    final MapDecoration decoration = mapdata.field_76203_h.get(entityplayer.func_70005_c_());
                    if (decoration != null) {
                        mapdata.field_76203_h.put(entityplayer.func_70005_c_(), new MapDecoration(MapDecoration.Type.PLAYER_OFF_MAP, decoration.func_176112_b(), decoration.func_176113_c(), decoration.func_176111_d()));
                    }
                }
            }
            if (isSelected || (entityIn instanceof EntityPlayer && ((EntityPlayer)entityIn).func_184592_cb() == stack)) {
                this.func_77872_a(worldIn, entityIn, mapdata);
            }
        }
    }
    
    public void func_77622_d(final ItemStack stack, final World world, final EntityPlayer player) {
    }
    
    public EnumRarity func_77613_e(final ItemStack stack) {
        return this.mapOres ? EnumRarity.UNCOMMON : EnumRarity.COMMON;
    }
    
    @Nullable
    public Packet<?> func_150911_c(final ItemStack stack, final World worldIn, final EntityPlayer player) {
        final Packet<?> p = (Packet<?>)super.func_150911_c(stack, worldIn, player);
        if (p instanceof SPacketMaps) {
            return (Packet<?>)TFPacketHandler.CHANNEL.getPacketFrom((IMessage)new PacketMazeMap((SPacketMaps)p));
        }
        return p;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelLoader.setCustomMeshDefinition((Item)this, stack -> new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
}
