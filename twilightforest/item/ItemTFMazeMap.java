// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.StatCollector;
import twilightforest.TFMapPacketHandler;
import net.minecraft.network.Packet;
import net.minecraft.item.EnumRarity;
import net.minecraft.block.Block;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.MapData;
import net.minecraft.block.material.MapColor;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.WorldSavedData;
import twilightforest.TFMazeMapData;
import net.minecraft.world.World;
import net.minecraft.item.ItemMap;

public class ItemTFMazeMap extends ItemMap
{
    public static final String STR_ID = "mazemap";
    private static final int YSEARCH = 3;
    protected boolean mapOres;
    
    protected ItemTFMazeMap(final boolean par2MapOres) {
        this.mapOres = par2MapOres;
    }
    
    @SideOnly(Side.CLIENT)
    public static TFMazeMapData getMPMapData(final int par0, final World par1World) {
        final String mapName = "mazemap_" + par0;
        TFMazeMapData mapData = (TFMazeMapData)par1World.func_72943_a((Class)TFMazeMapData.class, mapName);
        if (mapData == null) {
            mapData = new TFMazeMapData(mapName);
            par1World.func_72823_a(mapName, (WorldSavedData)mapData);
        }
        return mapData;
    }
    
    public TFMazeMapData getMapData(final ItemStack par1ItemStack, final World par2World) {
        TFMazeMapData mapData = (TFMazeMapData)par2World.func_72943_a((Class)TFMazeMapData.class, "mazemap_" + par1ItemStack.func_77960_j());
        if (mapData == null && !par2World.field_72995_K) {
            par1ItemStack.func_77964_b(par2World.func_72841_b("mazemap"));
            final String mapName = "mazemap_" + par1ItemStack.func_77960_j();
            mapData = new TFMazeMapData(mapName);
            mapData.field_76201_a = par2World.func_72912_H().func_76079_c();
            mapData.field_76199_b = par2World.func_72912_H().func_76074_e();
            mapData.field_76197_d = 0;
            mapData.field_76200_c = par2World.field_73011_w.field_76574_g;
            mapData.func_76185_a();
            par2World.func_72823_a(mapName, (WorldSavedData)mapData);
        }
        return mapData;
    }
    
    public void updateMapData(final World par1World, final Entity par2Entity, final TFMazeMapData par3MapData) {
        final int yDraw = MathHelper.func_76128_c(par2Entity.field_70163_u - par3MapData.yCenter);
        if (par1World.field_73011_w.field_76574_g == par3MapData.field_76200_c && yDraw > -3 && yDraw < 3) {
            final short xSize = 128;
            final short zSize = 128;
            final int xCenter = par3MapData.field_76201_a;
            final int zCenter = par3MapData.field_76199_b;
            final int xDraw = MathHelper.func_76128_c(par2Entity.field_70165_t - xCenter) + xSize / 2;
            final int zDraw = MathHelper.func_76128_c(par2Entity.field_70161_v - zCenter) + zSize / 2;
            final int drawSize = 16;
            final MapData.MapInfo func_82568_a;
            final MapData.MapInfo mapInfo = func_82568_a = par3MapData.func_82568_a((EntityPlayer)par2Entity);
            ++func_82568_a.field_82569_d;
            for (int xStep = xDraw - drawSize + 1; xStep < xDraw + drawSize; ++xStep) {
                if ((xStep & 0xF) == (mapInfo.field_82569_d & 0xF)) {
                    int highNumber = 255;
                    int lowNumber = 0;
                    for (int zStep = zDraw - drawSize - 1; zStep < zDraw + drawSize; ++zStep) {
                        if (xStep >= 0 && zStep >= -1 && xStep < xSize && zStep < zSize) {
                            final int xOffset = xStep - xDraw;
                            final int zOffset = zStep - zDraw;
                            final boolean var20 = xOffset * xOffset + zOffset * zOffset > (drawSize - 2) * (drawSize - 2);
                            final int xDraw2 = xCenter + xStep - xSize / 2;
                            final int zDraw2 = zCenter + zStep - zSize / 2;
                            final Chunk chunk = par1World.func_72938_d(xDraw2, zDraw2);
                            final int x15 = xDraw2 & 0xF;
                            final int z15 = zDraw2 & 0xF;
                            final int heightValue = par3MapData.yCenter;
                            Block blockID = chunk.func_150810_a(x15, heightValue, z15);
                            byte tint = 1;
                            int colorIndex = 0;
                            if (blockID == Blocks.field_150348_b && this.mapOres) {
                                int i = -3;
                                while (i <= 3) {
                                    final Block searchID = chunk.func_150810_a(x15, heightValue + i, z15);
                                    if (searchID != Blocks.field_150348_b) {
                                        blockID = searchID;
                                        if (i > 0) {
                                            tint = 2;
                                        }
                                        if (i < 0) {
                                            tint = 0;
                                            break;
                                        }
                                        break;
                                    }
                                    else {
                                        ++i;
                                    }
                                }
                            }
                            if (blockID != Blocks.field_150350_a) {
                                final MapColor mapColor = blockID.func_149688_o().func_151565_r();
                                colorIndex = mapColor.field_76290_q;
                            }
                            if (this.mapOres) {
                                if (blockID == Blocks.field_150365_q) {
                                    colorIndex = MapColor.field_151654_J.field_76290_q;
                                }
                                else if (blockID == Blocks.field_150352_o) {
                                    colorIndex = MapColor.field_151647_F.field_76290_q;
                                }
                                else if (blockID == Blocks.field_150366_p) {
                                    colorIndex = MapColor.field_151668_h.field_76290_q;
                                }
                                else if (blockID == Blocks.field_150369_x) {
                                    colorIndex = MapColor.field_151652_H.field_76290_q;
                                }
                                else if (blockID == Blocks.field_150450_ax || blockID == Blocks.field_150439_ay) {
                                    colorIndex = MapColor.field_151645_D.field_76290_q;
                                }
                                else if (blockID == Blocks.field_150482_ag) {
                                    colorIndex = MapColor.field_151648_G.field_76290_q;
                                }
                                else if (blockID == Blocks.field_150412_bA) {
                                    colorIndex = MapColor.field_151653_I.field_76290_q;
                                }
                                else if (blockID != Blocks.field_150350_a && blockID.func_149739_a().toLowerCase().contains("ore")) {
                                    colorIndex = MapColor.field_151671_v.field_76290_q;
                                }
                            }
                            if (zStep >= 0 && xOffset * xOffset + zOffset * zOffset < drawSize * drawSize && (!var20 || (xStep + zStep & 0x1) != 0x0)) {
                                final byte existingColor = par3MapData.field_76198_e[xStep + zStep * xSize];
                                final byte tintedColor = (byte)(colorIndex * 4 + tint);
                                if (existingColor != tintedColor) {
                                    if (highNumber > zStep) {
                                        highNumber = zStep;
                                    }
                                    if (lowNumber < zStep) {
                                        lowNumber = zStep;
                                    }
                                    par3MapData.field_76198_e[xStep + zStep * xSize] = tintedColor;
                                }
                            }
                        }
                    }
                    if (highNumber <= lowNumber) {
                        par3MapData.func_76194_a(xStep, highNumber, lowNumber);
                    }
                }
            }
        }
    }
    
    public void func_77663_a(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean isActiveItem) {
        if (!par2World.field_72995_K) {
            final TFMazeMapData mapData = this.getMapData(par1ItemStack, par2World);
            if (par3Entity instanceof EntityPlayer) {
                final EntityPlayer player = (EntityPlayer)par3Entity;
                mapData.func_76191_a(player, par1ItemStack);
                final int yProximity = MathHelper.func_76128_c(player.field_70163_u - mapData.yCenter);
                if (yProximity < -3 || yProximity > 3) {
                    final MapData.MapCoord mapCoord = mapData.field_76203_h.get(player.func_70005_c_());
                    if (mapCoord != null) {
                        mapCoord.field_76216_a = 6;
                    }
                }
            }
            if (isActiveItem) {
                this.updateMapData(par2World, par3Entity, mapData);
            }
        }
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.func_77964_b(par2World.func_72841_b("mazemap"));
        final String mapName = "mazemap_" + par1ItemStack.func_77960_j();
        final TFMazeMapData mapData = new TFMazeMapData(mapName);
        par2World.func_72823_a(mapName, (WorldSavedData)mapData);
        mapData.field_76201_a = MathHelper.func_76128_c(par3EntityPlayer.field_70165_t);
        mapData.yCenter = MathHelper.func_76128_c(par3EntityPlayer.field_70163_u);
        mapData.field_76199_b = MathHelper.func_76128_c(par3EntityPlayer.field_70161_v);
        mapData.field_76197_d = 0;
        mapData.field_76200_c = par2World.field_73011_w.field_76574_g;
        mapData.func_76185_a();
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return this.mapOres ? EnumRarity.epic : EnumRarity.uncommon;
    }
    
    public boolean func_77636_d(final ItemStack par1ItemStack) {
        return false;
    }
    
    public Packet func_150911_c(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final byte[] mapBytes = this.getMapData(par1ItemStack, par2World).func_76193_a(par1ItemStack, par2World, par3EntityPlayer);
        if (mapBytes == null) {
            return null;
        }
        final short uniqueID = (short)par1ItemStack.func_77960_j();
        return TFMapPacketHandler.makeMagicMapPacket("mazemap", uniqueID, mapBytes);
    }
    
    public String func_77653_i(final ItemStack par1ItemStack) {
        return ("" + StatCollector.func_74838_a(this.func_77657_g(par1ItemStack) + ".name") + " #" + par1ItemStack.func_77960_j()).trim();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
