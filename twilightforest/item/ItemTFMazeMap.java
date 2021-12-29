// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TFPacketHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFMazeMapData;

public class ItemTFMazeMap extends wi
{
    protected static final String STR_ID = "mazemap";
    private static final int YSEARCH = 3;
    protected boolean mapOres;
    
    protected ItemTFMazeMap(final int par1, final boolean par2MapOres) {
        super(par1);
        this.mapOres = par2MapOres;
    }
    
    @SideOnly(Side.CLIENT)
    public static TFMazeMapData getMPMapData(final short par0, final zv par1World) {
        final String mapName = "mazemap_" + par0;
        TFMazeMapData mapData = (TFMazeMapData)par1World.a((Class)TFMazeMapData.class, mapName);
        if (mapData == null) {
            mapData = new TFMazeMapData(mapName);
            par1World.a(mapName, (aji)mapData);
        }
        return mapData;
    }
    
    public TFMazeMapData getMapData(final wg par1ItemStack, final zv par2World) {
        TFMazeMapData mapData = (TFMazeMapData)par2World.a((Class)TFMazeMapData.class, "mazemap_" + par1ItemStack.k());
        if (mapData == null && !par2World.I) {
            par1ItemStack.b(par2World.b("mazemap"));
            final String mapName = "mazemap_" + par1ItemStack.k();
            mapData = new TFMazeMapData(mapName);
            mapData.a = par2World.L().c();
            mapData.b = par2World.L().e();
            mapData.d = 0;
            mapData.c = par2World.t.h;
            mapData.c();
            par2World.a(mapName, (aji)mapData);
        }
        return mapData;
    }
    
    public void updateMapData(final zv par1World, final mp par2Entity, final TFMazeMapData par3MapData) {
        final int yDraw = kx.c(par2Entity.v - par3MapData.yCenter);
        if (par1World.t.h == par3MapData.c && yDraw > -3 && yDraw < 3) {
            final short xSize = 128;
            final short zSize = 128;
            final int xCenter = par3MapData.a;
            final int zCenter = par3MapData.b;
            final int xDraw = kx.c(par2Entity.u - xCenter) + xSize / 2;
            final int zDraw = kx.c(par2Entity.w - zCenter) + zSize / 2;
            final int drawSize = 16;
            final ajg a;
            final ajg mapInfo = a = par3MapData.a((sk)par2Entity);
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
                            final abq chunk = par1World.d(xDraw2, zDraw2);
                            final int x15 = xDraw2 & 0xF;
                            final int z15 = zDraw2 & 0xF;
                            final int var24 = 0;
                            final double currentElevation = 0.0;
                            final int heightValue = par3MapData.yCenter;
                            int blockID = chunk.a(x15, heightValue, z15);
                            final double elevationChange = currentElevation - lastElevation + ((xStep + zStep & 0x1) - 0.5) * 0.4;
                            byte tint = 1;
                            int colorIndex = 0;
                            if (blockID == aou.x.cz && this.mapOres) {
                                int i = -3;
                                while (i <= 3) {
                                    final int searchID = chunk.a(x15, heightValue + i, z15);
                                    if (searchID != aou.x.cz) {
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
                                final aib mapColor = aou.r[blockID].cO.G;
                                colorIndex = mapColor.q;
                            }
                            if (this.mapOres) {
                                if (blockID == aou.M.cz) {
                                    colorIndex = aib.o.q;
                                }
                                else if (blockID == aou.K.cz) {
                                    colorIndex = aib.i.q;
                                }
                                else if (blockID == aou.L.cz) {
                                    colorIndex = aib.h.q;
                                }
                                else if (blockID == aou.R.cz) {
                                    colorIndex = aib.n.q;
                                }
                                else if (blockID == aou.aR.cz || blockID == aou.aS.cz) {
                                    colorIndex = aib.f.q;
                                }
                                else if (blockID == aou.aA.cz) {
                                    colorIndex = aib.g.q;
                                }
                                else if (blockID == aou.bV.cz) {
                                    colorIndex = aib.i.q;
                                }
                                else if (blockID > 0 && aou.r[blockID].a().toLowerCase().contains("ore")) {
                                    colorIndex = aib.f.q;
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
    
    public void a(final wg par1ItemStack, final zv par2World, final mp par3Entity, final int par4, final boolean isActiveItem) {
        if (!par2World.I) {
            final TFMazeMapData mapData = this.getMapData(par1ItemStack, par2World);
            if (par3Entity instanceof sk) {
                final sk player = (sk)par3Entity;
                mapData.a(player, par1ItemStack);
                final int yProximity = kx.c(player.v - mapData.yCenter);
                if (yProximity < -3 || yProximity > 3) {
                    final ajh mapCoord = mapData.g.get(player.c_());
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
    
    public void d(final wg par1ItemStack, final zv par2World, final sk par3EntityPlayer) {
    }
    
    public wr f(final wg par1ItemStack) {
        return this.mapOres ? wr.d : wr.b;
    }
    
    public boolean e(final wg par1ItemStack) {
        return false;
    }
    
    public ei c(final wg par1ItemStack, final zv par2World, final sk par3EntityPlayer) {
        final byte[] mapBytes = this.getMapData(par1ItemStack, par2World).a(par1ItemStack, par2World, par3EntityPlayer);
        if (mapBytes == null) {
            return null;
        }
        final short mapItemID = (short)par1ItemStack.c;
        final short uniqueID = (short)par1ItemStack.k();
        return TFPacketHandler.makeMagicMapPacket("tfmazemap", mapItemID, uniqueID, mapBytes);
    }
    
    public String l(final wg par1ItemStack) {
        return ("" + bp.a().c(this.i(par1ItemStack)) + " #" + par1ItemStack.k()).trim();
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
