// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ItemTFMazeMap extends uo
{
    private static final int YSEARCH = 3;
    protected boolean mapOres;
    
    protected ItemTFMazeMap(final int par1, final boolean par2MapOres) {
        super(par1);
        this.mapOres = par2MapOres;
    }
    
    public static TFMazeMapData getMPMapData(final short par0, final xv par1World) {
        TFMazeMapData mapData = (TFMazeMapData)par1World.a((Class)TFMazeMapData.class, "mazemap_" + par0);
        if (mapData == null) {
            final int mapID = par1World.b("mazemap");
            final String mapName = "mazemap_" + mapID;
            mapData = new TFMazeMapData(mapName);
            par1World.a(mapName, (ahj)mapData);
        }
        return mapData;
    }
    
    public TFMazeMapData getMapData(final um par1ItemStack, final xv par2World) {
        TFMazeMapData mapData = (TFMazeMapData)par2World.a((Class)TFMazeMapData.class, "mazemap_" + par1ItemStack.j());
        if (mapData == null) {
            par1ItemStack.b(par2World.b("mazemap"));
            final String mapName = "mazemap_" + par1ItemStack.j();
            mapData = new TFMazeMapData(mapName);
            mapData.a = par2World.K().c();
            mapData.b = par2World.K().e();
            mapData.d = 0;
            mapData.c = par2World.v.h;
            mapData.c();
            par2World.a(mapName, (ahj)mapData);
        }
        return mapData;
    }
    
    public void updateMapData(final xv par1World, final lq par2Entity, final TFMazeMapData par3MapData) {
        final int yDraw = ke.c(par2Entity.u - par3MapData.yCenter);
        if (par1World.v.h == par3MapData.c && yDraw > -3 && yDraw < 3) {
            final short xSize = 128;
            final short zSize = 128;
            final int xCenter = par3MapData.a;
            final int zCenter = par3MapData.b;
            final int xDraw = ke.c(par2Entity.t - xCenter) + xSize / 2;
            final int zDraw = ke.c(par2Entity.v - zCenter) + zSize / 2;
            final int drawSize = 16;
            final ahh a;
            final ahh mapInfo = a = par3MapData.a((qx)par2Entity);
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
                            final zs chunk = par1World.d(xDraw2, zDraw2);
                            final int x15 = xDraw2 & 0xF;
                            final int z15 = zDraw2 & 0xF;
                            final int var24 = 0;
                            final double currentElevation = 0.0;
                            final int heightValue = par3MapData.yCenter;
                            int blockID = chunk.a(x15, heightValue, z15);
                            final double elevationChange = currentElevation - lastElevation + ((xStep + zStep & 0x1) - 0.5) * 0.4;
                            byte tint = 1;
                            int colorIndex = 0;
                            if (blockID == amj.w.cm && this.mapOres) {
                                int i = -3;
                                while (i <= 3) {
                                    final int searchID = chunk.a(x15, heightValue + i, z15);
                                    if (searchID != amj.w.cm) {
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
                                final agd mapColor = amj.p[blockID].cB.G;
                                colorIndex = mapColor.q;
                            }
                            if (this.mapOres) {
                                if (blockID == amj.L.cm) {
                                    colorIndex = agd.o.q;
                                }
                                else if (blockID == amj.J.cm) {
                                    colorIndex = agd.i.q;
                                }
                                else if (blockID == amj.K.cm) {
                                    colorIndex = agd.h.q;
                                }
                                else if (blockID == amj.Q.cm) {
                                    colorIndex = agd.n.q;
                                }
                                else if (blockID == amj.aQ.cm || blockID == amj.aR.cm) {
                                    colorIndex = agd.f.q;
                                }
                                else if (blockID == amj.az.cm) {
                                    colorIndex = agd.g.q;
                                }
                                else if (blockID == amj.bU.cm) {
                                    colorIndex = agd.i.q;
                                }
                                else if (blockID > 0 && amj.p[blockID].B().contains("Ore")) {
                                    colorIndex = agd.f.q;
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
    
    public void a(final um par1ItemStack, final xv par2World, final lq par3Entity, final int par4, final boolean isActiveItem) {
        if (!par2World.J) {
            final TFMazeMapData mapData = this.getMapData(par1ItemStack, par2World);
            if (par3Entity instanceof qx) {
                final qx player = (qx)par3Entity;
                mapData.a(player, par1ItemStack);
                final int yProximity = ke.c(player.u - mapData.yCenter);
                if (yProximity < -3 || yProximity > 3) {
                    final ahi mapCoord = mapData.g.get(player.c_());
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
    
    public void d(final um par1ItemStack, final xv par2World, final qx par3EntityPlayer) {
        par1ItemStack.b(par2World.b("mazemap"));
        final String mapName = "mazemap_" + par1ItemStack.j();
        final TFMazeMapData mapData = new TFMazeMapData(mapName);
        par2World.a(mapName, (ahj)mapData);
        mapData.a = ke.c(par3EntityPlayer.t);
        mapData.yCenter = ke.c(par3EntityPlayer.u);
        mapData.b = ke.c(par3EntityPlayer.v);
        mapData.d = 0;
        mapData.c = par2World.v.h;
        mapData.c();
    }
    
    public uw e(final um par1ItemStack) {
        return this.mapOres ? uw.d : uw.b;
    }
    
    public boolean d(final um par1ItemStack) {
        return false;
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public eg c(final um par1ItemStack, final xv par2World, final qx par3EntityPlayer) {
        final byte[] mapBytes = this.getMapData(par1ItemStack, par2World).a(par1ItemStack, par2World, par3EntityPlayer);
        if (mapBytes == null) {
            return null;
        }
        final short mapItemID = (short)TFItems.magicMap.cg;
        final short uniqueID = (short)par1ItemStack.j();
        return TFPacketHandler.makeMagicMapPacket("tfmazemap", mapItemID, uniqueID, mapBytes);
    }
    
    public String j(final um par1ItemStack) {
        return ("" + bn.a().c(this.g(par1ItemStack)) + " #" + par1ItemStack.j()).trim();
    }
}
