import forge.NetworkMod;
import forge.MinecraftForge;
import forge.ITextureProvider;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ItemTFMagicMap extends yy implements ITextureProvider
{
    protected ItemTFMagicMap(final int par1) {
        super(par1);
        this.e(1);
    }
    
    public static TFMagicMapData getMPMapData(final short par0, final ge par1World) {
        TFMagicMapData var3 = (TFMagicMapData)par1World.a((Class)TFMagicMapData.class, "magicmap_" + par0);
        if (var3 == null) {
            final int var4 = par1World.b("magicmap");
            final String var5 = "magicmap_" + var4;
            var3 = new TFMagicMapData(var5);
            par1World.a(var5, (jd)var3);
        }
        return var3;
    }
    
    public TFMagicMapData getMapData(final kp par1ItemStack, final ge par2World) {
        TFMagicMapData mapData = (TFMagicMapData)par2World.a((Class)TFMagicMapData.class, "magicmap_" + par1ItemStack.h());
        if (mapData == null) {
            par1ItemStack.b(par2World.b("magicmap"));
            final String var3 = "magicmap_" + par1ItemStack.h();
            mapData = new TFMagicMapData(var3);
            mapData.b = par2World.s().c();
            mapData.c = par2World.s().e();
            mapData.e = 4;
            mapData.d = (byte)par2World.t.g;
            mapData.a();
            par2World.a(var3, (jd)mapData);
        }
        return mapData;
    }
    
    public void updateMapData(final ge par1World, final tv par2Entity, final TFMagicMapData par3MapData) {
        if (par1World.t.g == par3MapData.d) {
            final short xSize = 128;
            final short zSize = 128;
            final int scaleFactor = 1 << par3MapData.e;
            final int xCenter = par3MapData.b;
            final int zCenter = par3MapData.c;
            final int xDraw = kb.b(par2Entity.bm - xCenter) / scaleFactor + xSize / 2;
            final int zDraw = kb.b(par2Entity.bo - zCenter) / scaleFactor + zSize / 2;
            final int drawSize = 512 / scaleFactor;
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
                            final int xDraw2 = (xCenter / scaleFactor + xStep - xSize / 2) * scaleFactor;
                            final int zDraw2 = (zCenter / scaleFactor + zStep - zSize / 2) * scaleFactor;
                            final int[] biomeFrequencies = new int[256];
                            for (int xStep2 = 0; xStep2 < scaleFactor; ++xStep2) {
                                for (int zStep2 = 0; zStep2 < scaleFactor; ++zStep2) {
                                    final int biomeID = par1World.a(xDraw2 + xStep2, zDraw2 + zStep2).M;
                                    final int[] array = biomeFrequencies;
                                    final int n = biomeID;
                                    ++array[n];
                                    if (biomeID == lt.i.M || biomeID == TFBiomeBase.stream.M) {
                                        final int[] array2 = biomeFrequencies;
                                        final int n2 = biomeID;
                                        array2[n2] += 2;
                                    }
                                    if (biomeID == TFBiomeBase.largeFeature.M && zStep >= 0 && xOffset * xOffset + zOffset * zOffset < drawSize * drawSize) {
                                        par3MapData.addFeatureToMap(TFFeature.getNearestFeature(xDraw2 + xStep2 >> 4, zDraw2 + zStep2 >> 4, par1World), xDraw2, zDraw2);
                                    }
                                }
                            }
                            byte biomeIDToShow = 0;
                            int highestFrequency = 0;
                            for (int i = 0; i < 256; ++i) {
                                if (biomeFrequencies[i] > highestFrequency) {
                                    biomeIDToShow = (byte)i;
                                    highestFrequency = biomeFrequencies[i];
                                }
                            }
                            ++biomeIDToShow;
                            if (zStep >= 0 && xOffset * xOffset + zOffset * zOffset < drawSize * drawSize && (!var20 || (xStep + zStep & 0x1) != 0x0)) {
                                final byte existingColor = par3MapData.f[xStep + zStep * xSize];
                                if (existingColor != biomeIDToShow) {
                                    if (highNumber > zStep) {
                                        highNumber = zStep;
                                    }
                                    if (lowNumber < zStep) {
                                        lowNumber = zStep;
                                    }
                                    par3MapData.f[xStep + zStep * xSize] = biomeIDToShow;
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
    
    public void updateMapDataOld(final ge par1World, final tv par2Entity, final km par3MapData) {
        if (par1World.t.g == par3MapData.d) {
            final short xSize = 128;
            final short zSize = 128;
            final int scaleFactor = 1 << par3MapData.e;
            final int xCenter = par3MapData.b;
            final int zCenter = par3MapData.c;
            final int xDraw = kb.b(par2Entity.bm - xCenter) / scaleFactor + xSize / 2;
            final int zDraw = kb.b(par2Entity.bo - zCenter) / scaleFactor + zSize / 2;
            final int drawSize = 512 / scaleFactor;
            ++par3MapData.g;
            for (int xStep = xDraw - drawSize + 1; xStep < xDraw + drawSize; ++xStep) {
                if ((xStep & 0xF) == (par3MapData.g & 0xF)) {
                    int highNumber = 255;
                    int lowNumber = 0;
                    double lastElevation = 0.0;
                    for (int zStep = zDraw - drawSize - 1; zStep < zDraw + drawSize; ++zStep) {
                        if (xStep >= 0 && zStep >= -1 && xStep < xSize && zStep < zSize) {
                            final int xOffset = xStep - xDraw;
                            final int zOffset = zStep - zDraw;
                            final boolean var20 = xOffset * xOffset + zOffset * zOffset > (drawSize - 2) * (drawSize - 2);
                            final int xDraw2 = (xCenter / scaleFactor + xStep - xSize / 2) * scaleFactor;
                            final int zDraw2 = (zCenter / scaleFactor + zStep - zSize / 2) * scaleFactor;
                            final byte var21 = 0;
                            final byte var22 = 0;
                            final byte var23 = 0;
                            final int[] intarray = new int[256];
                            final my chunk = par1World.c(xDraw2, zDraw2);
                            final int x15 = xDraw2 & 0xF;
                            final int z15 = zDraw2 & 0xF;
                            int var24 = 0;
                            double currentElevation = 0.0;
                            for (int xStep2 = 0; xStep2 < scaleFactor; ++xStep2) {
                                for (int zStep2 = 0; zStep2 < scaleFactor; ++zStep2) {
                                    int heightValue = chunk.b(xStep2 + x15, zStep2 + z15) + 1;
                                    int blockID = 0;
                                    if (heightValue > 1) {
                                        boolean foundSolidBlock = false;
                                        do {
                                            foundSolidBlock = true;
                                            blockID = chunk.a(xStep2 + x15, heightValue - 1, zStep2 + z15);
                                            if (blockID == 0) {
                                                foundSolidBlock = false;
                                            }
                                            else if (heightValue > 0 && blockID > 0 && vz.m[blockID].cd.F == ey.b) {
                                                foundSolidBlock = false;
                                            }
                                            if (!foundSolidBlock) {
                                                --heightValue;
                                                blockID = chunk.a(xStep2 + x15, heightValue - 1, zStep2 + z15);
                                            }
                                        } while (heightValue > 0 && !foundSolidBlock);
                                        if (heightValue > 0 && blockID != 0 && vz.m[blockID].cd.d()) {
                                            int belowValue = heightValue - 1;
                                            final boolean foundBottom = false;
                                            int belowBlockID;
                                            do {
                                                belowBlockID = chunk.a(xStep2 + x15, belowValue--, zStep2 + z15);
                                                ++var24;
                                            } while (belowValue > 0 && belowBlockID != 0 && vz.m[belowBlockID].cd.d());
                                        }
                                    }
                                    currentElevation += heightValue / (double)(scaleFactor * scaleFactor);
                                    final int[] array = intarray;
                                    final int n = blockID;
                                    ++array[n];
                                }
                            }
                            var24 /= scaleFactor * scaleFactor;
                            int var25 = var21 / (scaleFactor * scaleFactor);
                            var25 = var22 / (scaleFactor * scaleFactor);
                            var25 = var23 / (scaleFactor * scaleFactor);
                            int xStep2 = 0;
                            int zStep2 = 0;
                            for (int heightValue = 0; heightValue < 256; ++heightValue) {
                                if (intarray[heightValue] > xStep2) {
                                    zStep2 = heightValue;
                                    xStep2 = intarray[heightValue];
                                }
                            }
                            double elevationChange = (currentElevation - lastElevation) * 4.0 / (scaleFactor + 4) + ((xStep + zStep & 0x1) - 0.5) * 0.4;
                            byte tint = 1;
                            if (elevationChange > 0.6) {
                                tint = 2;
                            }
                            if (elevationChange < -0.6) {
                                tint = 0;
                            }
                            int belowValue = 0;
                            if (zStep2 > 0) {
                                final ey mapColor = vz.m[zStep2].cd.F;
                                if (mapColor == ey.n) {
                                    elevationChange = var24 * 0.1 + (xStep + zStep & 0x1) * 0.2;
                                    tint = 1;
                                    if (elevationChange < 0.5) {
                                        tint = 2;
                                    }
                                    if (elevationChange > 0.9) {
                                        tint = 0;
                                    }
                                }
                                belowValue = mapColor.q;
                            }
                            lastElevation = currentElevation;
                            if (zStep >= 0 && xOffset * xOffset + zOffset * zOffset < drawSize * drawSize && (!var20 || (xStep + zStep & 0x1) != 0x0)) {
                                final byte existingColor = par3MapData.f[xStep + zStep * xSize];
                                final byte tintedColor = (byte)(belowValue * 4 + tint);
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
    
    public void a(final kp par1ItemStack, final ge par2World, final tv par3Entity, final int par4, final boolean par5) {
        if (!par2World.F) {
            final TFMagicMapData mapData = this.getMapData(par1ItemStack, par2World);
            if (par3Entity instanceof ih) {
                final ih var7 = (ih)par3Entity;
                mapData.a(var7, par1ItemStack);
            }
            if (par5) {
                this.updateMapData(par2World, par3Entity, mapData);
            }
        }
    }
    
    public void d(final kp par1ItemStack, final ge par2World, final ih par3EntityPlayer) {
        par1ItemStack.b(par2World.b("magicmap"));
        final String mapName = "magicmap_" + par1ItemStack.h();
        final TFMagicMapData mapData = new TFMagicMapData(mapName);
        par2World.a(mapName, (jd)mapData);
        mapData.b = kb.b(par3EntityPlayer.bm);
        mapData.c = kb.b(par3EntityPlayer.bo);
        mapData.e = 4;
        mapData.d = (byte)par2World.t.g;
        mapData.a();
    }
    
    public lx c(final kp par1ItemStack, final ge par2World, final ih par3EntityPlayer) {
        byte[] dataBytes = this.getMapData(par1ItemStack, par2World).a(par1ItemStack, par2World, par3EntityPlayer);
        if (dataBytes != null) {
            if (dataBytes[0] == 0) {
                dataBytes[0] = 16;
            }
            if (dataBytes[0] == 1) {
                dataBytes[0] = 17;
                if (par2World.r.nextInt(4) == 0) {
                    dataBytes = this.getMapData(par1ItemStack, par2World).makeFeatureStorageArray();
                }
            }
            return (lx)new ao((short)MinecraftForge.getModID((NetworkMod)mod_TwilightForest.instance), (short)par1ItemStack.h(), dataBytes);
        }
        return null;
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
}
