// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFProtectionBox;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.FMLNetworkEvent;

public class TFGenericPacketHandler
{
    public static final byte CHANGE_DIM_ID = 1;
    public static final byte TRANSFORM_BIOME = 2;
    public static final byte THROW_PLAYER = 3;
    public static final byte AREA_PROTECTION = 4;
    public static final byte STRUCTURE_PROTECTION = 5;
    public static final byte STRUCTURE_PROTECTION_CLEAR = 6;
    public static final byte ENFORCED_PROGRESSION_STATUS = 7;
    public static final byte ANNIHILATE_BLOCK = 8;
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void incomingPacket(final FMLNetworkEvent.ClientCustomPacketEvent event) {
        final ByteBuf buf = event.packet.payload();
        final int discriminatorByte = buf.readByte();
        if (discriminatorByte == 2) {
            this.processTransformBiomeData(buf);
        }
        if (discriminatorByte == 3) {
            this.processThrowPlayerData(buf);
        }
        if (discriminatorByte == 4) {
            this.processAreaProtectionData(buf);
        }
        if (discriminatorByte == 5) {
            this.processStructureProtectionData(buf);
        }
        if (discriminatorByte == 6) {
            this.processStructureProtectionClearData(buf);
        }
        if (discriminatorByte == 7) {
            this.processEnforcedProgressionStatusData(buf);
        }
        if (discriminatorByte == 8) {
            this.processAnnihilateBlock(buf);
        }
    }
    
    @SideOnly(Side.CLIENT)
    private void processTransformBiomeData(final ByteBuf buf) {
        final int x = buf.readInt();
        final int z = buf.readInt();
        final byte biomeID = buf.readByte();
        final World worldObj = (World)Minecraft.func_71410_x().field_71441_e;
        final Chunk chunkAt = worldObj.func_72938_d(x, z);
        chunkAt.func_76605_m()[(z & 0xF) << 4 | (x & 0xF)] = biomeID;
        worldObj.func_147458_c(x, 0, z, x, 255, z);
    }
    
    @SideOnly(Side.CLIENT)
    private void processThrowPlayerData(final ByteBuf buf) {
        final float motionX = buf.readFloat();
        final float motionY = buf.readFloat();
        final float motionZ = buf.readFloat();
        Minecraft.func_71410_x().field_71439_g.func_70024_g((double)motionX, (double)motionY, (double)motionZ);
    }
    
    @SideOnly(Side.CLIENT)
    private void processAreaProtectionData(final ByteBuf buf) {
        final int minX = buf.readInt();
        final int minY = buf.readInt();
        final int minZ = buf.readInt();
        final int maxX = buf.readInt();
        final int maxY = buf.readInt();
        final int maxZ = buf.readInt();
        final int blockX = buf.readInt();
        final int blockY = buf.readInt();
        final int blockZ = buf.readInt();
        final World worldObj = (World)Minecraft.func_71410_x().field_71441_e;
        final EntityTFProtectionBox box = new EntityTFProtectionBox(worldObj, minX, minY, minZ, maxX, maxY, maxZ);
        worldObj.func_72942_c((Entity)box);
        for (int i = 0; i < 20; ++i) {
            final double d0 = worldObj.field_73012_v.nextGaussian() * 0.02;
            final double d2 = worldObj.field_73012_v.nextGaussian() * 0.02;
            final double d3 = worldObj.field_73012_v.nextGaussian() * 0.02;
            final float dx = blockX + 0.5f + worldObj.field_73012_v.nextFloat() - worldObj.field_73012_v.nextFloat();
            final float dy = blockY + 0.5f + worldObj.field_73012_v.nextFloat() - worldObj.field_73012_v.nextFloat();
            final float dz = blockZ + 0.5f + worldObj.field_73012_v.nextFloat() - worldObj.field_73012_v.nextFloat();
            TwilightForestMod.proxy.spawnParticle(worldObj, "protection", dx, dy, dz, d0, d2, d3);
        }
    }
    
    @SideOnly(Side.CLIENT)
    private void processStructureProtectionData(final ByteBuf buf) {
        final int minX = buf.readInt();
        final int minY = buf.readInt();
        final int minZ = buf.readInt();
        final int maxX = buf.readInt();
        final int maxY = buf.readInt();
        final int maxZ = buf.readInt();
        final StructureBoundingBox sbb = new StructureBoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
        final World worldObj = (World)Minecraft.func_71410_x().field_71441_e;
        if (worldObj.field_73011_w instanceof WorldProviderTwilightForest) {
            final TFWeatherRenderer weatherRenderer = (TFWeatherRenderer)worldObj.field_73011_w.getWeatherRenderer();
            weatherRenderer.setProtectedBox(sbb);
        }
    }
    
    @SideOnly(Side.CLIENT)
    private void processStructureProtectionClearData(final ByteBuf buf) {
        final World worldObj = (World)Minecraft.func_71410_x().field_71441_e;
        if (worldObj.field_73011_w instanceof WorldProviderTwilightForest) {
            final TFWeatherRenderer weatherRenderer = (TFWeatherRenderer)worldObj.field_73011_w.getWeatherRenderer();
            weatherRenderer.setProtectedBox(null);
        }
    }
    
    @SideOnly(Side.CLIENT)
    private void processEnforcedProgressionStatusData(final ByteBuf buf) {
        final World worldObj = (World)Minecraft.func_71410_x().field_71441_e;
        final boolean isEnforced = buf.readBoolean();
        worldObj.func_82736_K().func_82764_b("tfEnforcedProgression", Boolean.valueOf(isEnforced).toString());
    }
    
    @SideOnly(Side.CLIENT)
    private void processAnnihilateBlock(final ByteBuf buf) {
        final int blockX = buf.readInt();
        final int blockY = buf.readInt();
        final int blockZ = buf.readInt();
        final World worldObj = (World)Minecraft.func_71410_x().field_71441_e;
        TwilightForestMod.proxy.doBlockAnnihilateEffect(worldObj, blockX, blockY, blockZ);
    }
    
    public static FMLProxyPacket makeBiomeChangePacket(final int x, final int z, final byte biomeID) {
        final PacketBuffer payload = new PacketBuffer(Unpooled.buffer());
        payload.writeByte(2);
        payload.writeInt(x);
        payload.writeInt(z);
        payload.writeByte((int)biomeID);
        final FMLProxyPacket pkt = new FMLProxyPacket((ByteBuf)payload, "TwilightForest");
        return pkt;
    }
    
    public static FMLProxyPacket makeThrowPlayerPacket(final float motionX, final float motionY, final float motionZ) {
        final PacketBuffer payload = new PacketBuffer(Unpooled.buffer());
        payload.writeByte(3);
        payload.writeFloat(motionX);
        payload.writeFloat(motionY);
        payload.writeFloat(motionZ);
        final FMLProxyPacket pkt = new FMLProxyPacket((ByteBuf)payload, "TwilightForest");
        return pkt;
    }
    
    public static FMLProxyPacket makeAreaProtectionPacket(final StructureBoundingBox sbb, final int blockX, final int blockY, final int blockZ) {
        final PacketBuffer payload = new PacketBuffer(Unpooled.buffer());
        payload.writeByte(4);
        payload.writeInt(sbb.field_78897_a);
        payload.writeInt(sbb.field_78895_b);
        payload.writeInt(sbb.field_78896_c);
        payload.writeInt(sbb.field_78893_d);
        payload.writeInt(sbb.field_78894_e);
        payload.writeInt(sbb.field_78892_f);
        payload.writeInt(blockX);
        payload.writeInt(blockY);
        payload.writeInt(blockZ);
        final FMLProxyPacket pkt = new FMLProxyPacket((ByteBuf)payload, "TwilightForest");
        return pkt;
    }
    
    public static FMLProxyPacket makeStructureProtectionPacket(final StructureBoundingBox sbb) {
        final PacketBuffer payload = new PacketBuffer(Unpooled.buffer());
        payload.writeByte(5);
        payload.writeInt(sbb.field_78897_a);
        payload.writeInt(sbb.field_78895_b);
        payload.writeInt(sbb.field_78896_c);
        payload.writeInt(sbb.field_78893_d);
        payload.writeInt(sbb.field_78894_e);
        payload.writeInt(sbb.field_78892_f);
        final FMLProxyPacket pkt = new FMLProxyPacket((ByteBuf)payload, "TwilightForest");
        return pkt;
    }
    
    public static FMLProxyPacket makeStructureProtectionClearPacket() {
        final PacketBuffer payload = new PacketBuffer(Unpooled.buffer());
        payload.writeByte(6);
        final FMLProxyPacket pkt = new FMLProxyPacket((ByteBuf)payload, "TwilightForest");
        return pkt;
    }
    
    public static FMLProxyPacket makeEnforcedProgressionStatusPacket(final boolean isEnforced) {
        final PacketBuffer payload = new PacketBuffer(Unpooled.buffer());
        payload.writeByte(7);
        payload.writeBoolean(isEnforced);
        final FMLProxyPacket pkt = new FMLProxyPacket((ByteBuf)payload, "TwilightForest");
        return pkt;
    }
    
    public static FMLProxyPacket makeAnnihilateBlockPacket(final int blockX, final int blockY, final int blockZ) {
        final PacketBuffer payload = new PacketBuffer(Unpooled.buffer());
        payload.writeByte(8);
        payload.writeInt(blockX);
        payload.writeInt(blockY);
        payload.writeInt(blockZ);
        final FMLProxyPacket pkt = new FMLProxyPacket((ByteBuf)payload, "TwilightForest");
        return pkt;
    }
}
