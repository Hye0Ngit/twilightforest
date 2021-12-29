import forge.NetworkMod;
import forge.MinecraftForge;
import forge.ITextureProvider;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ItemTFMazeMap extends yy implements ITextureProvider
{
    private static final int YSEARCH = 3;
    protected boolean mapOres;
    
    protected ItemTFMazeMap(final int par1, final boolean par2MapOres) {
        super(par1);
        this.e(1);
        this.mapOres = par2MapOres;
    }
    
    public static TFMazeMapData getMPMapData(final short par0, final ge par1World) {
        TFMazeMapData mapData = (TFMazeMapData)par1World.a((Class)TFMazeMapData.class, "mazemap_" + par0);
        if (mapData == null) {
            final int mapID = par1World.b("mazemap");
            final String mapName = "mazemap_" + mapID;
            mapData = new TFMazeMapData(mapName);
            par1World.a(mapName, (jd)mapData);
        }
        return mapData;
    }
    
    public TFMazeMapData getMapData(final kp par1ItemStack, final ge par2World) {
        TFMazeMapData mapData = (TFMazeMapData)par2World.a((Class)TFMazeMapData.class, "mazemap_" + par1ItemStack.h());
        if (mapData == null) {
            par1ItemStack.b(par2World.b("mazemap"));
            final String mapName = "mazemap_" + par1ItemStack.h();
            mapData = new TFMazeMapData(mapName);
            mapData.b = par2World.s().c();
            mapData.c = par2World.s().e();
            mapData.e = 0;
            mapData.d = (byte)par2World.t.g;
            mapData.a();
            par2World.a(mapName, (jd)mapData);
        }
        return mapData;
    }
    
    public void updateMapData(final ge par1World, final tv par2Entity, final TFMazeMapData par3MapData) {
        final int yDraw = kb.b(par2Entity.bn - par3MapData.yCenter);
        if (par1World.t.g == par3MapData.d && yDraw > -3 && yDraw < 3) {
            final short xSize = 128;
            final short zSize = 128;
            final int xCenter = par3MapData.b;
            final int zCenter = par3MapData.c;
            final int xDraw = kb.b(par2Entity.bm - xCenter) + xSize / 2;
            final int zDraw = kb.b(par2Entity.bo - zCenter) + zSize / 2;
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
                            final my chunk = par1World.c(xDraw2, zDraw2);
                            final int x15 = xDraw2 & 0xF;
                            final int z15 = zDraw2 & 0xF;
                            final int var24 = 0;
                            final double currentElevation = 0.0;
                            final int heightValue = par3MapData.yCenter;
                            int blockID = chunk.a(x15, heightValue, z15);
                            final double elevationChange = currentElevation - lastElevation + ((xStep + zStep & 0x1) - 0.5) * 0.4;
                            byte tint = 1;
                            int colorIndex = 0;
                            if (blockID == vz.t.bO && this.mapOres) {
                                int i = -3;
                                while (i <= 3) {
                                    final int searchID = chunk.a(x15, heightValue + i, z15);
                                    if (searchID != vz.t.bO) {
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
                                final ey mapColor = vz.m[blockID].cd.F;
                                colorIndex = mapColor.q;
                            }
                            if (this.mapOres) {
                                if (blockID == vz.I.bO) {
                                    colorIndex = ey.o.q;
                                }
                                if (blockID == vz.G.bO) {
                                    colorIndex = ey.i.q;
                                }
                                if (blockID == vz.H.bO) {
                                    colorIndex = ey.h.q;
                                }
                                if (blockID == vz.N.bO) {
                                    colorIndex = ey.n.q;
                                }
                                if (blockID == vz.aN.bO || blockID == vz.aO.bO) {
                                    colorIndex = ey.f.q;
                                }
                                if (blockID == vz.aw.bO) {
                                    colorIndex = ey.g.q;
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
    
    public void a(final kp par1ItemStack, final ge par2World, final tv par3Entity, final int par4, final boolean isActiveItem) {
        if (!par2World.F) {
            final TFMazeMapData mapData = this.getMapData(par1ItemStack, par2World);
            if (par3Entity instanceof ih) {
                final ih player = (ih)par3Entity;
                final int yProximity = kb.b(player.bn - mapData.yCenter);
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
    
    public void d(final kp par1ItemStack, final ge par2World, final ih par3EntityPlayer) {
        par1ItemStack.b(par2World.b("mazemap"));
        final String mapName = "mazemap_" + par1ItemStack.h();
        final TFMazeMapData mapData = new TFMazeMapData(mapName);
        par2World.a(mapName, (jd)mapData);
        mapData.b = kb.b(par3EntityPlayer.bm);
        mapData.yCenter = kb.b(par3EntityPlayer.bn);
        mapData.c = kb.b(par3EntityPlayer.bo);
        mapData.e = 0;
        mapData.d = (byte)par2World.t.g;
        mapData.a();
    }
    
    public lx c(final kp par1ItemStack, final ge par2World, final ih par3EntityPlayer) {
        final byte[] dataBytes = this.getMapData(par1ItemStack, par2World).a(par1ItemStack, par2World, par3EntityPlayer);
        if (dataBytes != null) {
            if (dataBytes[0] == 0) {
                dataBytes[0] = 19;
            }
            if (dataBytes[0] == 1) {
                dataBytes[0] = 20;
            }
            return (lx)new ao((short)MinecraftForge.getModID((NetworkMod)mod_TwilightForest.instance), (short)par1ItemStack.h(), dataBytes);
        }
        return null;
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
}
