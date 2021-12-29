// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TFPacketHandler;
import twilightforest.TFFeature;
import twilightforest.world.TFWorldChunkManager;
import twilightforest.biomes.TFBiomeBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFMagicMapData;

public class ItemTFMagicMap extends wi
{
    protected static final String STR_ID = "magicmap";
    
    protected ItemTFMagicMap(final int par1) {
        super(par1);
    }
    
    @SideOnly(Side.CLIENT)
    public static TFMagicMapData getMPMapData(final short par0, final zv par1World) {
        final String mapName = "magicmap_" + par0;
        TFMagicMapData mapData = (TFMagicMapData)par1World.a((Class)TFMagicMapData.class, mapName);
        if (mapData == null) {
            mapData = new TFMagicMapData(mapName);
            par1World.a(mapName, (aji)mapData);
        }
        return mapData;
    }
    
    public TFMagicMapData getMapData(final wg par1ItemStack, final zv par2World) {
        String mapName = "magicmap_" + par1ItemStack.k();
        TFMagicMapData mapData = (TFMagicMapData)par2World.a((Class)TFMagicMapData.class, mapName);
        if (mapData == null && !par2World.I) {
            par1ItemStack.b(par2World.b("magicmap"));
            mapName = "magicmap_" + par1ItemStack.k();
            mapData = new TFMagicMapData(mapName);
            mapData.a = par2World.L().c();
            mapData.b = par2World.L().e();
            mapData.d = 4;
            mapData.c = par2World.t.h;
            mapData.c();
            par2World.a(mapName, (aji)mapData);
        }
        return mapData;
    }
    
    public void updateMapData(final zv par1World, final mp par2Entity, final TFMagicMapData par3MapData) {
        if (par1World.t.h == par3MapData.c && par2Entity instanceof sk) {
            final short xSize = 128;
            final short zSize = 128;
            final int scaleFactor = 1 << par3MapData.d;
            final int xCenter = par3MapData.a;
            final int zCenter = par3MapData.b;
            final int xDraw = kx.c(par2Entity.u - xCenter) / scaleFactor + xSize / 2;
            final int zDraw = kx.c(par2Entity.w - zCenter) / scaleFactor + zSize / 2;
            final int drawSize = 512 / scaleFactor;
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
                            final int xDraw2 = (xCenter / scaleFactor + xStep - xSize / 2) * scaleFactor;
                            final int zDraw2 = (zCenter / scaleFactor + zStep - zSize / 2) * scaleFactor;
                            final int[] biomeFrequencies = new int[256];
                            for (int xStep2 = 0; xStep2 < scaleFactor; ++xStep2) {
                                for (int zStep2 = 0; zStep2 < scaleFactor; ++zStep2) {
                                    final int biomeID = par1World.a(xDraw2 + xStep2, zDraw2 + zStep2).N;
                                    final int[] array = biomeFrequencies;
                                    final int n = biomeID;
                                    ++array[n];
                                    if (biomeID == aap.i.N || biomeID == TFBiomeBase.stream.N) {
                                        final int[] array2 = biomeFrequencies;
                                        final int n2 = biomeID;
                                        array2[n2] += 2;
                                    }
                                    if (par1World.t() instanceof TFWorldChunkManager) {
                                        final TFWorldChunkManager tfManager = (TFWorldChunkManager)par1World.t();
                                        if (tfManager.isInFeatureChunk(xDraw2 + xStep2, zDraw2 + zStep2) && zStep >= 0 && xOffset * xOffset + zOffset * zOffset < drawSize * drawSize) {
                                            par3MapData.addFeatureToMap(TFFeature.getNearestFeature(xDraw2 + xStep2 >> 4, zDraw2 + zStep2 >> 4, par1World), xDraw2, zDraw2);
                                        }
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
                                final byte existingColor = par3MapData.e[xStep + zStep * xSize];
                                if (existingColor != biomeIDToShow) {
                                    if (highNumber > zStep) {
                                        highNumber = zStep;
                                    }
                                    if (lowNumber < zStep) {
                                        lowNumber = zStep;
                                    }
                                    par3MapData.e[xStep + zStep * xSize] = biomeIDToShow;
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
    
    public void updateMapDataOld(final zv par1World, final mp par2Entity, final ajf par3MapData) {
        if (par1World.t.h == par3MapData.c) {
            final short xSize = 128;
            final short zSize = 128;
            final int scaleFactor = 1 << par3MapData.d;
            final int xCenter = par3MapData.a;
            final int zCenter = par3MapData.b;
            final int xDraw = kx.c(par2Entity.u - xCenter) / scaleFactor + xSize / 2;
            final int zDraw = kx.c(par2Entity.w - zCenter) / scaleFactor + zSize / 2;
            final int drawSize = 512 / scaleFactor;
            final ajg a;
            final ajg mapInfo = a = par3MapData.a((sk)par2Entity);
            ++a.d;
            for (int xStep = xDraw - drawSize + 1; xStep < xDraw + drawSize; ++xStep) {
                if ((xStep & 0xF) == (mapInfo.d & 0xF)) {
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
                            final abq chunk = par1World.d(xDraw2, zDraw2);
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
                                            else if (heightValue > 0 && blockID > 0 && aou.r[blockID].cO.G == aib.b) {
                                                foundSolidBlock = false;
                                            }
                                            if (!foundSolidBlock) {
                                                --heightValue;
                                                blockID = chunk.a(xStep2 + x15, heightValue - 1, zStep2 + z15);
                                            }
                                        } while (heightValue > 0 && !foundSolidBlock);
                                        if (heightValue > 0 && blockID != 0 && aou.r[blockID].cO.d()) {
                                            int belowValue = heightValue - 1;
                                            final boolean foundBottom = false;
                                            int belowBlockID;
                                            do {
                                                belowBlockID = chunk.a(xStep2 + x15, belowValue--, zStep2 + z15);
                                                ++var24;
                                            } while (belowValue > 0 && belowBlockID != 0 && aou.r[belowBlockID].cO.d());
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
                                final aib mapColor = aou.r[zStep2].cO.G;
                                if (mapColor == aib.n) {
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
                                final byte existingColor = par3MapData.e[xStep + zStep * xSize];
                                final byte tintedColor = (byte)(belowValue * 4 + tint);
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
    
    public void a(final wg par1ItemStack, final zv par2World, final mp par3Entity, final int par4, final boolean par5) {
        if (!par2World.I) {
            final TFMagicMapData mapData = this.getMapData(par1ItemStack, par2World);
            if (par3Entity instanceof sk) {
                final sk var7 = (sk)par3Entity;
                mapData.a(var7, par1ItemStack);
            }
            if (par5) {
                this.updateMapData(par2World, par3Entity, mapData);
            }
        }
    }
    
    public void d(final wg par1ItemStack, final zv par2World, final sk par3EntityPlayer) {
    }
    
    public wr f(final wg par1ItemStack) {
        return wr.b;
    }
    
    public boolean e(final wg par1ItemStack) {
        return false;
    }
    
    public ei c(final wg par1ItemStack, final zv par2World, final sk par3EntityPlayer) {
        byte[] mapBytes = this.getMapData(par1ItemStack, par2World).a(par1ItemStack, par2World, par3EntityPlayer);
        if (mapBytes == null) {
            return null;
        }
        if (mapBytes[0] == 1 && par2World.s.nextInt(4) == 0) {
            this.getMapData(par1ItemStack, par2World).checkExistingFeatures(par2World);
            mapBytes = this.getMapData(par1ItemStack, par2World).makeFeatureStorageArray();
        }
        final short mapItemID = (short)TFItems.magicMap.cp;
        final short uniqueID = (short)par1ItemStack.k();
        return TFPacketHandler.makeMagicMapPacket("tfmagicmap", mapItemID, uniqueID, mapBytes);
    }
    
    public String l(final wg par1ItemStack) {
        return ("" + bp.a().c(this.i(par1ItemStack)) + " #" + par1ItemStack.k()).trim();
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
