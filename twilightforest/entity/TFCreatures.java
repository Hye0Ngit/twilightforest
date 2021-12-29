// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import java.util.LinkedHashMap;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.EntityRegistry;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import java.util.HashMap;

public class TFCreatures
{
    public static HashMap<Integer, TFEntityEggInfo> entityEggs;
    
    public static void registerTFCreature(final Class<? extends Entity> entityClass, final String entityName, final int id, final int backgroundEggColour, final int foregroundEggColour) {
        registerTFCreature(entityClass, entityName, id, backgroundEggColour, foregroundEggColour, 80, 3, true);
    }
    
    public static void registerTFCreature(final Class<? extends Entity> entityClass, final String entityName, final int id, final int backgroundEggColour, final int foregroundEggColour, final int trackingRange, final int updateFrequency, final boolean sendsVelocityUpdates) {
        if (TwilightForestMod.creatureCompatibility) {
            EntityRegistry.registerGlobalEntityID((Class)entityClass, entityName, id);
        }
        EntityRegistry.registerModEntity((Class)entityClass, entityName, id, (Object)TwilightForestMod.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
        TFCreatures.entityEggs.put(id, new TFEntityEggInfo(id, backgroundEggColour, foregroundEggColour));
    }
    
    public static void registerTFCreature(final Class<? extends Entity> entityClass, final String entityName, final int id) {
        if (TwilightForestMod.creatureCompatibility) {
            EntityRegistry.registerGlobalEntityID((Class)entityClass, entityName, id);
        }
        EntityRegistry.registerModEntity((Class)entityClass, entityName, id, (Object)TwilightForestMod.instance, 80, 3, true);
    }
    
    public static Entity createEntityByID(final int entityID, final World par1World) {
        Entity entity = null;
        try {
            final ModContainer mc = FMLCommonHandler.instance().findContainerFor((Object)TwilightForestMod.instance);
            final EntityRegistry.EntityRegistration er = EntityRegistry.instance().lookupModSpawn(mc, entityID);
            final Class<?> clazz = er.getEntityClass();
            if (clazz != null) {
                entity = (Entity)clazz.getConstructor(World.class).newInstance(par1World);
            }
        }
        catch (Exception var4) {
            var4.printStackTrace();
        }
        if (entity == null) {
            System.out.println("Skipping Entity with id " + entityID);
        }
        return entity;
    }
    
    public static String getStringFromID(final int entityID) {
        final ModContainer mc = FMLCommonHandler.instance().findContainerFor((Object)TwilightForestMod.instance);
        final EntityRegistry.EntityRegistration er = EntityRegistry.instance().lookupModSpawn(mc, entityID);
        if (er != null) {
            return er.getEntityName();
        }
        return null;
    }
    
    public static String getSpawnerNameFor(final String baseName) {
        if (TwilightForestMod.creatureCompatibility) {
            return baseName;
        }
        return "TwilightForest." + baseName;
    }
    
    static {
        TFCreatures.entityEggs = new LinkedHashMap<Integer, TFEntityEggInfo>();
    }
}
