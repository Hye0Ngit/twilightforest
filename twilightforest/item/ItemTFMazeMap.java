// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TFPacketHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFMazeMapData;

public class ItemTFMazeMap extends yg
{
    protected static final String STR_ID = "mazemap";
    private static final int YSEARCH = 3;
    protected boolean mapOres;
    
    protected ItemTFMazeMap(final int par1, final boolean par2MapOres) {
        super(par1);
        this.mapOres = par2MapOres;
    }
    
    @SideOnly(Side.CLIENT)
    public static TFMazeMapData getMPMapData(final short par0, final abv par1World) {
        final String mapName = "mazemap_" + par0;
        TFMazeMapData mapData = (TFMazeMapData)par1World.a((Class)TFMazeMapData.class, mapName);
        if (mapData == null) {
            mapData = new TFMazeMapData(mapName);
            par1World.a(mapName, (ali)mapData);
        }
        return mapData;
    }
    
    public TFMazeMapData getMapData(final yd par1ItemStack, final abv par2World) {
        TFMazeMapData mapData = (TFMazeMapData)par2World.a((Class)TFMazeMapData.class, "mazemap_" + par1ItemStack.k());
        if (mapData == null && !par2World.I) {
            par1ItemStack.b(par2World.b("mazemap"));
            final String mapName = "mazemap_" + par1ItemStack.k();
            mapData = new TFMazeMapData(mapName);
            mapData.a = par2World.N().c();
            mapData.b = par2World.N().e();
            mapData.d = 0;
            mapData.c = par2World.t.i;
            mapData.c();
            par2World.a(mapName, (ali)mapData);
        }
        return mapData;
    }
    
    public void updateMapData(final abv par1World, final nm par2Entity, final TFMazeMapData par3MapData) {
        final int yDraw = lr.c(par2Entity.v - par3MapData.yCenter);
        if (par1World.t.i == par3MapData.c && yDraw > -3 && yDraw < 3) {
            final short xSize = 128;
            final short zSize = 128;
            final int xCenter = par3MapData.a;
            final int zCenter = par3MapData.b;
            final int xDraw = lr.c(par2Entity.u - xCenter) + xSize / 2;
            final int zDraw = lr.c(par2Entity.w - zCenter) + zSize / 2;
            final int drawSize = 16;
            final alg a;
            final alg mapInfo = a = par3MapData.a((ue)par2Entity);
            ++a.d;
            for (int xStep = xDraw - drawSize + 1; xStep < xDraw + drawSize; ++xStep) {
                if ((xStep & 0xF) == (mapInfo.d & 0xF)) {
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
                            final adq chunk = par1World.d(xDraw2, zDraw2);
                            final int x15 = xDraw2 & 0xF;
                            final int z15 = zDraw2 & 0xF;
                            final int var24 = 0;
                            final double currentElevation = 0.0;
                            final int heightValue = par3MapData.yCenter;
                            int blockID = chunk.a(x15, heightValue, z15);
                            final double elevationChange = currentElevation - lastElevation + ((xStep + zStep & 0x1) - 0.5) * 0.4;
                            byte tint = 1;
                            int colorIndex = 0;
                            if (blockID == aqw.y.cF && this.mapOres) {
                                int i = -3;
                                while (i <= 3) {
                                    final int searchID = chunk.a(x15, heightValue + i, z15);
                                    if (searchID != aqw.y.cF) {
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
                                final akb mapColor = aqw.s[blockID].cU.H;
                                colorIndex = mapColor.q;
                            }
                            if (this.mapOres) {
                                if (blockID == aqw.N.cF) {
                                    colorIndex = akb.o.q;
                                }
                                else if (blockID == aqw.L.cF) {
                                    colorIndex = akb.i.q;
                                }
                                else if (blockID == aqw.M.cF) {
                                    colorIndex = akb.h.q;
                                }
                                else if (blockID == aqw.S.cF) {
                                    colorIndex = akb.n.q;
                                }
                                else if (blockID == aqw.aS.cF || blockID == aqw.aT.cF) {
                                    colorIndex = akb.f.q;
                                }
                                else if (blockID == aqw.aB.cF) {
                                    colorIndex = akb.g.q;
                                }
                                else if (blockID == aqw.bW.cF) {
                                    colorIndex = akb.i.q;
                                }
                                else if (blockID > 0 && aqw.s[blockID].a().toLowerCase().contains("ore")) {
                                    colorIndex = akb.f.q;
                                }
                            }
                            if (zStep >= 0 && xOffset * xOffset + zOffset * zOffset < drawSize * drawSize && (!var20 || (xStep + zStep & 0x1) != 0x0)) {
                                final byte existingColor = par3MapData.e[xStep + zStep * xSize];
                                final byte tintedColor = (byte)(colorIndex * 4 + tint);
                                if (existingColor != tintedColor) {
                                    if (highNumber > zStep) {
                                        highNumber = zStep;
                                    }
                                    if (lowNumber < zStep) {
                                        lowNumber = zStep;
                                    }
                                    par3MapData.e[xStep + zStep * xSize] = tintedColor;
                                }
                            }
                        }
                    }
                    if (highNumber <= lowNumber) {
                        par3MapData.a(xStep, highNumber, lowNumber);
                    }
                }
            }
        }
    }
    
    public void a(final yd par1ItemStack, final abv par2World, final nm par3Entity, final int par4, final boolean isActiveItem) {
        if (!par2World.I) {
            final TFMazeMapData mapData = this.getMapData(par1ItemStack, par2World);
            if (par3Entity instanceof ue) {
                final ue player = (ue)par3Entity;
                mapData.a(player, par1ItemStack);
                final int yProximity = lr.c(player.v - mapData.yCenter);
                if (yProximity < -3 || yProximity > 3) {
                    final alh mapCoord = mapData.g.get(player.c_());
                    if (mapCoord != null) {
                        mapCoord.a = 6;
                    }
                }
            }
            if (isActiveItem) {
                this.updateMapData(par2World, par3Entity, mapData);
            }
        }
    }
    
    public void d(final yd par1ItemStack, final abv par2World, final ue par3EntityPlayer) {
    }
    
    public yp f(final yd par1ItemStack) {
        return this.mapOres ? yp.d : yp.b;
    }
    
    public boolean e(final yd par1ItemStack) {
        return false;
    }
    
    public ex c(final yd par1ItemStack, final abv par2World, final ue par3EntityPlayer) {
        final byte[] mapBytes = this.getMapData(par1ItemStack, par2World).a(par1ItemStack, par2World, par3EntityPlayer);
        if (mapBytes == null) {
            return null;
        }
        final short mapItemID = (short)par1ItemStack.d;
        final short uniqueID = (short)par1ItemStack.k();
        return TFPacketHandler.makeMagicMapPacket("tfmazemap", mapItemID, uniqueID, mapBytes);
    }
    
    public String l(final yd par1ItemStack) {
        return ("" + bt.a(this.i(par1ItemStack) + ".name") + " #" + par1ItemStack.k()).trim();
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
