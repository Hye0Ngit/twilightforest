// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import forge.ITextureProvider;

public class ItemTFMazeMap extends ra implements ITextureProvider
{
    private static final int YSEARCH = 3;
    protected boolean mapOres;
    
    protected ItemTFMazeMap(final int par1, final boolean par2MapOres) {
        super(par1);
        this.f(1);
        this.mapOres = par2MapOres;
    }
    
    public static TFMazeMapData getMPMapData(final short par0, final xd par1World) {
        TFMazeMapData mapData = (TFMazeMapData)par1World.a((Class)TFMazeMapData.class, "mazemap_" + par0);
        if (mapData == null) {
            final int mapID = par1World.b("mazemap");
            final String mapName = "mazemap_" + mapID;
            mapData = new TFMazeMapData(mapName);
            par1World.a(mapName, (zk)mapData);
        }
        return mapData;
    }
    
    public TFMazeMapData getMapData(final aan par1ItemStack, final xd par2World) {
        TFMazeMapData mapData = (TFMazeMapData)par2World.a((Class)TFMazeMapData.class, "mazemap_" + par1ItemStack.i());
        if (mapData == null) {
            par1ItemStack.b(par2World.b("mazemap"));
            final String mapName = "mazemap_" + par1ItemStack.i();
            mapData = new TFMazeMapData(mapName);
            mapData.b = par2World.B().c();
            mapData.c = par2World.B().e();
            mapData.e = 0;
            mapData.d = (byte)par2World.t.g;
            mapData.a();
            par2World.a(mapName, (zk)mapData);
        }
        return mapData;
    }
    
    public void updateMapData(final xd par1World, final nn par2Entity, final TFMazeMapData par3MapData) {
        final int yDraw = gk.c(par2Entity.p - par3MapData.yCenter);
        if (par1World.t.g == par3MapData.d && yDraw > -3 && yDraw < 3) {
            final short xSize = 128;
            final short zSize = 128;
            final int xCenter = par3MapData.b;
            final int zCenter = par3MapData.c;
            final int xDraw = gk.c(par2Entity.o - xCenter) + xSize / 2;
            final int zDraw = gk.c(par2Entity.q - zCenter) + zSize / 2;
            final int drawSize = 16;
            ++par3MapData.g;
            for (int xStep = xDraw - drawSize + 1; xStep < xDraw + drawSize; ++xStep) {
                if ((xStep & 0xF) == (par3MapData.g & 0xF)) {
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
                            final ack chunk = par1World.c(xDraw2, zDraw2);
                            final int x15 = xDraw2 & 0xF;
                            final int z15 = zDraw2 & 0xF;
                            final int var24 = 0;
                            final double currentElevation = 0.0;
                            final int heightValue = par3MapData.yCenter;
                            int blockID = chunk.a(x15, heightValue, z15);
                            final double elevationChange = currentElevation - lastElevation + ((xStep + zStep & 0x1) - 0.5) * 0.4;
                            byte tint = 1;
                            int colorIndex = 0;
                            if (blockID == pb.t.bO && this.mapOres) {
                                int i = -3;
                                while (i <= 3) {
                                    final int searchID = chunk.a(x15, heightValue + i, z15);
                                    if (searchID != pb.t.bO) {
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
                                final wh mapColor = pb.m[blockID].cd.F;
                                colorIndex = mapColor.q;
                            }
                            if (this.mapOres) {
                                if (blockID == pb.I.bO) {
                                    colorIndex = wh.o.q;
                                }
                                if (blockID == pb.G.bO) {
                                    colorIndex = wh.i.q;
                                }
                                if (blockID == pb.H.bO) {
                                    colorIndex = wh.h.q;
                                }
                                if (blockID == pb.N.bO) {
                                    colorIndex = wh.n.q;
                                }
                                if (blockID == pb.aN.bO || blockID == pb.aO.bO) {
                                    colorIndex = wh.f.q;
                                }
                                if (blockID == pb.aw.bO) {
                                    colorIndex = wh.g.q;
                                }
                            }
                            if (zStep >= 0 && xOffset * xOffset + zOffset * zOffset < drawSize * drawSize && (!var20 || (xStep + zStep & 0x1) != 0x0)) {
                                final byte existingColor = par3MapData.f[xStep + zStep * xSize];
                                final byte tintedColor = (byte)(colorIndex * 4 + tint);
                                if (existingColor != tintedColor) {
                                    if (highNumber > zStep) {
                                        highNumber = zStep;
                                    }
                                    if (lowNumber < zStep) {
                                        lowNumber = zStep;
                                    }
                                    par3MapData.f[xStep + zStep * xSize] = tintedColor;
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
    
    public void a(final aan par1ItemStack, final xd par2World, final nn par3Entity, final int par4, final boolean isActiveItem) {
        if (!par2World.F) {
            final TFMazeMapData mapData = this.getMapData(par1ItemStack, par2World);
            if (par3Entity instanceof yw) {
                final yw player = (yw)par3Entity;
                final int yProximity = gk.c(player.p - mapData.yCenter);
                if (yProximity > -3 && yProximity < 3) {
                    mapData.a(player, par1ItemStack);
                }
                else {
                    mapData.i.clear();
                }
            }
            if (isActiveItem) {
                this.updateMapData(par2World, par3Entity, mapData);
            }
        }
    }
    
    public void c(final aan par1ItemStack, final xd par2World, final yw par3EntityPlayer) {
        par1ItemStack.b(par2World.b("mazemap"));
        final String mapName = "mazemap_" + par1ItemStack.i();
        final TFMazeMapData mapData = new TFMazeMapData(mapName);
        par2World.a(mapName, (zk)mapData);
        mapData.b = gk.c(par3EntityPlayer.o);
        mapData.yCenter = gk.c(par3EntityPlayer.p);
        mapData.c = gk.c(par3EntityPlayer.q);
        mapData.e = 0;
        mapData.d = (byte)par2World.t.g;
        mapData.a();
    }
    
    public fo f(final aan par1ItemStack) {
        return this.mapOres ? fo.d : fo.b;
    }
    
    public boolean e(final aan par1ItemStack) {
        return this.mapOres;
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
}
