// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.storage.MapData;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.StatCollector;
import twilightforest.TFPacketHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.item.EnumRarity;
import net.minecraft.world.storage.MapCoord;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.MapInfo;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.Block;
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
    protected static final String STR_ID = "mazemap";
    private static final int YSEARCH = 3;
    protected boolean mapOres;
    
    protected ItemTFMazeMap(final int par1, final boolean par2MapOres) {
        super(par1);
        this.mapOres = par2MapOres;
    }
    
    @SideOnly(Side.CLIENT)
    public static TFMazeMapData getMPMapData(final short par0, final World par1World) {
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
            final MapInfo func_82568_a;
            final MapInfo mapInfo = func_82568_a = par3MapData.func_82568_a((EntityPlayer)par2Entity);
            ++func_82568_a.field_82569_d;
            for (int xStep = xDraw - drawSize + 1; xStep < xDraw + drawSize; ++xStep) {
                if ((xStep & 0xF) == (mapInfo.field_82569_d & 0xF)) {
                    int highNumber = 255;
                    int lowNumber = 0;
                    final double lastElevation = 0.0;
                    for (int zStep = zDraw - drawSize - 1; zStep < zDraw + drawSize; ++zStep) {
                        if (xStep >= 0 && zStep >= -1 && xStep < xSize && zStep < zSize) {
                            final int xOffset = xStep - xDraw;
                            final int zOffset = zStep - zDraw;
                            final boolean var20 = xOffset * xOffset + zOffset * zOffset > (drawSize - 2) * (drawSize - 2);
                            final int xDraw2 = xCenter + xStep - xSize / 2;
                            final int zDraw2 = zCenter + zStep - zSize / 2;
                            final byte var21 = 0;
                            final byte var22 = 0;
                            final byte var23 = 0;
                            final int[] intarray = new int[256];
                            final Chunk chunk = par1World.func_72938_d(xDraw2, zDraw2);
                            final int x15 = xDraw2 & 0xF;
                            final int z15 = zDraw2 & 0xF;
                            final int var24 = 0;
                            final double currentElevation = 0.0;
                            final int heightValue = par3MapData.yCenter;
                            int blockID = chunk.func_76610_a(x15, heightValue, z15);
                            final double elevationChange = currentElevation - lastElevation + ((xStep + zStep & 0x1) - 0.5) * 0.4;
                            byte tint = 1;
                            int colorIndex = 0;
                            if (blockID == Block.field_71981_t.field_71990_ca && this.mapOres) {
                                int i = -3;
                                while (i <= 3) {
                                    final int searchID = chunk.func_76610_a(x15, heightValue + i, z15);
                                    if (searchID != Block.field_71981_t.field_71990_ca) {
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
                            if (blockID > 0) {
                                final MapColor mapColor = Block.field_71973_m[blockID].field_72018_cp.field_76234_F;
                                colorIndex = mapColor.field_76290_q;
                            }
                            if (this.mapOres) {
                                if (blockID == Block.field_71950_I.field_71990_ca) {
                                    colorIndex = MapColor.field_76283_o.field_76290_q;
                                }
                                else if (blockID == Block.field_71941_G.field_71990_ca) {
                                    colorIndex = MapColor.field_76289_i.field_76290_q;
                                }
                                else if (blockID == Block.field_71949_H.field_71990_ca) {
                                    colorIndex = MapColor.field_76288_h.field_76290_q;
                                }
                                else if (blockID == Block.field_71947_N.field_71990_ca) {
                                    colorIndex = MapColor.field_76282_n.field_76290_q;
                                }
                                else if (blockID == Block.field_72047_aN.field_71990_ca || blockID == Block.field_72048_aO.field_71990_ca) {
                                    colorIndex = MapColor.field_76275_f.field_76290_q;
                                }
                                else if (blockID == Block.field_72073_aw.field_71990_ca) {
                                    colorIndex = MapColor.field_76276_g.field_76290_q;
                                }
                                else if (blockID == Block.field_72068_bR.field_71990_ca) {
                                    colorIndex = MapColor.field_76289_i.field_76290_q;
                                }
                                else if (blockID > 0 && Block.field_71973_m[blockID].func_71917_a().toLowerCase().contains("ore")) {
                                    colorIndex = MapColor.field_76275_f.field_76290_q;
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
                    final MapCoord mapCoord = mapData.field_76203_h.get(player.func_70005_c_());
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
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return this.mapOres ? EnumRarity.epic : EnumRarity.uncommon;
    }
    
    public boolean func_77636_d(final ItemStack par1ItemStack) {
        return false;
    }
    
    public Packet func_77871_c(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final byte[] mapBytes = this.getMapData(par1ItemStack, par2World).func_76193_a(par1ItemStack, par2World, par3EntityPlayer);
        if (mapBytes == null) {
            return null;
        }
        final short mapItemID = (short)par1ItemStack.field_77993_c;
        final short uniqueID = (short)par1ItemStack.func_77960_j();
        return TFPacketHandler.makeMagicMapPacket("tfmazemap", mapItemID, uniqueID, mapBytes);
    }
    
    public String func_77628_j(final ItemStack par1ItemStack) {
        return ("" + StatCollector.func_74838_a(this.func_77657_g(par1ItemStack) + ".name") + " #" + par1ItemStack.func_77960_j()).trim();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
