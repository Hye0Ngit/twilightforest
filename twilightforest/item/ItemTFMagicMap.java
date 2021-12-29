// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.StringTranslate;
import twilightforest.TFPacketHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.item.EnumRarity;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.Block;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapInfo;
import twilightforest.TFFeature;
import twilightforest.world.TFWorldChunkManager;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.WorldSavedData;
import twilightforest.TFMagicMapData;
import net.minecraft.world.World;
import net.minecraft.item.ItemMap;

public class ItemTFMagicMap extends ItemMap
{
    protected static final String STR_ID = "magicmap";
    
    protected ItemTFMagicMap(final int par1) {
        super(par1);
    }
    
    @SideOnly(Side.CLIENT)
    public static TFMagicMapData getMPMapData(final short par0, final World par1World) {
        final String mapName = "magicmap_" + par0;
        TFMagicMapData mapData = (TFMagicMapData)par1World.func_72943_a((Class)TFMagicMapData.class, mapName);
        if (mapData == null) {
            mapData = new TFMagicMapData(mapName);
            par1World.func_72823_a(mapName, (WorldSavedData)mapData);
        }
        return mapData;
    }
    
    public TFMagicMapData getMapData(final ItemStack par1ItemStack, final World par2World) {
        String mapName = "magicmap_" + par1ItemStack.func_77960_j();
        TFMagicMapData mapData = (TFMagicMapData)par2World.func_72943_a((Class)TFMagicMapData.class, mapName);
        if (mapData == null && !par2World.field_72995_K) {
            par1ItemStack.func_77964_b(par2World.func_72841_b("magicmap"));
            mapName = "magicmap_" + par1ItemStack.func_77960_j();
            mapData = new TFMagicMapData(mapName);
            mapData.field_76201_a = par2World.func_72912_H().func_76079_c();
            mapData.field_76199_b = par2World.func_72912_H().func_76074_e();
            mapData.field_76197_d = 4;
            mapData.field_76200_c = par2World.field_73011_w.field_76574_g;
            mapData.func_76185_a();
            par2World.func_72823_a(mapName, (WorldSavedData)mapData);
        }
        return mapData;
    }
    
    public void updateMapData(final World par1World, final Entity par2Entity, final TFMagicMapData par3MapData) {
        if (par1World.field_73011_w.field_76574_g == par3MapData.field_76200_c && par2Entity instanceof EntityPlayer) {
            final short xSize = 128;
            final short zSize = 128;
            final int scaleFactor = 1 << par3MapData.field_76197_d;
            final int xCenter = par3MapData.field_76201_a;
            final int zCenter = par3MapData.field_76199_b;
            final int xDraw = MathHelper.func_76128_c(par2Entity.field_70165_t - xCenter) / scaleFactor + xSize / 2;
            final int zDraw = MathHelper.func_76128_c(par2Entity.field_70161_v - zCenter) / scaleFactor + zSize / 2;
            final int drawSize = 512 / scaleFactor;
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
                            final int xDraw2 = (xCenter / scaleFactor + xStep - xSize / 2) * scaleFactor;
                            final int zDraw2 = (zCenter / scaleFactor + zStep - zSize / 2) * scaleFactor;
                            final int[] biomeFrequencies = new int[256];
                            for (int xStep2 = 0; xStep2 < scaleFactor; ++xStep2) {
                                for (int zStep2 = 0; zStep2 < scaleFactor; ++zStep2) {
                                    final int biomeID = par1World.func_72807_a(xDraw2 + xStep2, zDraw2 + zStep2).field_76756_M;
                                    final int[] array = biomeFrequencies;
                                    final int n = biomeID;
                                    ++array[n];
                                    if (biomeID == BiomeGenBase.field_76781_i.field_76756_M || biomeID == TFBiomeBase.stream.field_76756_M) {
                                        final int[] array2 = biomeFrequencies;
                                        final int n2 = biomeID;
                                        array2[n2] += 2;
                                    }
                                    if (par1World.func_72959_q() instanceof TFWorldChunkManager) {
                                        final TFWorldChunkManager tfManager = (TFWorldChunkManager)par1World.func_72959_q();
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
                                final byte existingColor = par3MapData.field_76198_e[xStep + zStep * xSize];
                                if (existingColor != biomeIDToShow) {
                                    if (highNumber > zStep) {
                                        highNumber = zStep;
                                    }
                                    if (lowNumber < zStep) {
                                        lowNumber = zStep;
                                    }
                                    par3MapData.field_76198_e[xStep + zStep * xSize] = biomeIDToShow;
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
    
    public void updateMapDataOld(final World par1World, final Entity par2Entity, final MapData par3MapData) {
        if (par1World.field_73011_w.field_76574_g == par3MapData.field_76200_c) {
            final short xSize = 128;
            final short zSize = 128;
            final int scaleFactor = 1 << par3MapData.field_76197_d;
            final int xCenter = par3MapData.field_76201_a;
            final int zCenter = par3MapData.field_76199_b;
            final int xDraw = MathHelper.func_76128_c(par2Entity.field_70165_t - xCenter) / scaleFactor + xSize / 2;
            final int zDraw = MathHelper.func_76128_c(par2Entity.field_70161_v - zCenter) / scaleFactor + zSize / 2;
            final int drawSize = 512 / scaleFactor;
            final MapInfo func_82568_a;
            final MapInfo mapInfo = func_82568_a = par3MapData.func_82568_a((EntityPlayer)par2Entity);
            ++func_82568_a.field_82569_d;
            for (int xStep = xDraw - drawSize + 1; xStep < xDraw + drawSize; ++xStep) {
                if ((xStep & 0xF) == (mapInfo.field_82569_d & 0xF)) {
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
                            final Chunk chunk = par1World.func_72938_d(xDraw2, zDraw2);
                            final int x15 = xDraw2 & 0xF;
                            final int z15 = zDraw2 & 0xF;
                            int var24 = 0;
                            double currentElevation = 0.0;
                            for (int xStep2 = 0; xStep2 < scaleFactor; ++xStep2) {
                                for (int zStep2 = 0; zStep2 < scaleFactor; ++zStep2) {
                                    int heightValue = chunk.func_76611_b(xStep2 + x15, zStep2 + z15) + 1;
                                    int blockID = 0;
                                    if (heightValue > 1) {
                                        boolean foundSolidBlock = false;
                                        do {
                                            foundSolidBlock = true;
                                            blockID = chunk.func_76610_a(xStep2 + x15, heightValue - 1, zStep2 + z15);
                                            if (blockID == 0) {
                                                foundSolidBlock = false;
                                            }
                                            else if (heightValue > 0 && blockID > 0 && Block.field_71973_m[blockID].field_72018_cp.field_76234_F == MapColor.field_76279_b) {
                                                foundSolidBlock = false;
                                            }
                                            if (!foundSolidBlock) {
                                                --heightValue;
                                                blockID = chunk.func_76610_a(xStep2 + x15, heightValue - 1, zStep2 + z15);
                                            }
                                        } while (heightValue > 0 && !foundSolidBlock);
                                        if (heightValue > 0 && blockID != 0 && Block.field_71973_m[blockID].field_72018_cp.func_76224_d()) {
                                            int belowValue = heightValue - 1;
                                            final boolean foundBottom = false;
                                            int belowBlockID;
                                            do {
                                                belowBlockID = chunk.func_76610_a(xStep2 + x15, belowValue--, zStep2 + z15);
                                                ++var24;
                                            } while (belowValue > 0 && belowBlockID != 0 && Block.field_71973_m[belowBlockID].field_72018_cp.func_76224_d());
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
                                final MapColor mapColor = Block.field_71973_m[zStep2].field_72018_cp.field_76234_F;
                                if (mapColor == MapColor.field_76282_n) {
                                    elevationChange = var24 * 0.1 + (xStep + zStep & 0x1) * 0.2;
                                    tint = 1;
                                    if (elevationChange < 0.5) {
                                        tint = 2;
                                    }
                                    if (elevationChange > 0.9) {
                                        tint = 0;
                                    }
                                }
                                belowValue = mapColor.field_76290_q;
                            }
                            lastElevation = currentElevation;
                            if (zStep >= 0 && xOffset * xOffset + zOffset * zOffset < drawSize * drawSize && (!var20 || (xStep + zStep & 0x1) != 0x0)) {
                                final byte existingColor = par3MapData.field_76198_e[xStep + zStep * xSize];
                                final byte tintedColor = (byte)(belowValue * 4 + tint);
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
    
    public void func_77663_a(final ItemStack par1ItemStack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        if (!par2World.field_72995_K) {
            final TFMagicMapData mapData = this.getMapData(par1ItemStack, par2World);
            if (par3Entity instanceof EntityPlayer) {
                final EntityPlayer var7 = (EntityPlayer)par3Entity;
                mapData.func_76191_a(var7, par1ItemStack);
            }
            if (par5) {
                this.updateMapData(par2World, par3Entity, mapData);
            }
        }
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.uncommon;
    }
    
    public boolean func_77636_d(final ItemStack par1ItemStack) {
        return false;
    }
    
    public Packet func_77871_c(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        byte[] mapBytes = this.getMapData(par1ItemStack, par2World).func_76193_a(par1ItemStack, par2World, par3EntityPlayer);
        if (mapBytes == null) {
            return null;
        }
        if (mapBytes[0] == 1 && par2World.field_73012_v.nextInt(4) == 0) {
            this.getMapData(par1ItemStack, par2World).checkExistingFeatures(par2World);
            mapBytes = this.getMapData(par1ItemStack, par2World).makeFeatureStorageArray();
        }
        final short mapItemID = (short)TFItems.magicMap.field_77779_bT;
        final short uniqueID = (short)par1ItemStack.func_77960_j();
        return TFPacketHandler.makeMagicMapPacket("tfmagicmap", mapItemID, uniqueID, mapBytes);
    }
    
    public String func_77628_j(final ItemStack par1ItemStack) {
        return ("" + StringTranslate.func_74808_a().func_74809_c(this.func_77657_g(par1ItemStack)) + " #" + par1ItemStack.func_77960_j()).trim();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
    }
}
