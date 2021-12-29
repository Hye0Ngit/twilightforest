// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import twilightforest.network.PacketSpawnEntityParticles;
import twilightforest.network.TFPacketHandler;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.entity.Entity;
import net.minecraft.world.WorldServer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ParticleHelper
{
    public static void spawnParticles(final World world, final BlockPos pos, final EnumParticleTypes type, final int count, final double speed, final int... particleArgs) {
        if (world instanceof WorldServer) {
            ((WorldServer)world).func_175739_a(type, pos.func_177958_n() + 0.5, pos.func_177956_o() + 0.5, pos.func_177952_p() + 0.5, count, 0.5, 0.5, 0.5, speed, particleArgs);
        }
    }
    
    public static void spawnParticles(final Entity entity, final EnumParticleTypes type, final int count, final double speed, final int... particleArgs) {
        if (entity.field_70170_p instanceof WorldServer) {
            ((WorldServer)entity.field_70170_p).func_175739_a(type, entity.field_70165_t, entity.field_70163_u + entity.field_70131_O * 0.5, entity.field_70161_v, count, entity.field_70130_N * 0.5, entity.field_70131_O * 0.5, entity.field_70130_N * 0.5, speed, particleArgs);
        }
    }
    
    public static void spawnParticles(final Entity entity, final TFParticleType type, final int count) {
        if (!entity.field_70170_p.field_72995_K) {
            TFPacketHandler.CHANNEL.sendToAllAround((IMessage)new PacketSpawnEntityParticles(type, entity, count), new NetworkRegistry.TargetPoint(entity.field_70170_p.field_73011_w.getDimension(), entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 32.0));
        }
    }
}
