// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.LinkedHashMap;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import java.util.HashMap;

public class TFCreatures
{
    public static HashMap entityEggs;
    
    public static void registerTFCreature(final Class entityClass, final String entityName, final int id, final int backgroundEggColour, final int foregroundEggColour) {
        if (TwilightForestMod.creatureCompatibility) {
            EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
        }
        EntityRegistry.registerModEntity(entityClass, entityName, id, (Object)TwilightForestMod.instance, 80, 3, true);
        TFCreatures.entityEggs.put(id, new lw(id, backgroundEggColour, foregroundEggColour));
    }
    
    public static void registerTFCreature(final Class entityClass, final String entityName, final int id) {
        if (TwilightForestMod.creatureCompatibility) {
            EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
        }
        EntityRegistry.registerModEntity(entityClass, entityName, id, (Object)TwilightForestMod.instance, 80, 3, true);
    }
    
    public static lq createEntityByID(final int entityID, final xv par1World) {
        lq entity = null;
        try {
            final ModContainer mc = FMLCommonHandler.instance().findContainerFor((Object)TwilightForestMod.instance);
            final EntityRegistry.EntityRegistration er = EntityRegistry.instance().lookupModSpawn(mc, entityID);
            final Class clazz = er.getEntityClass();
            if (clazz != null) {
                entity = clazz.getConstructor(xv.class).newInstance(par1World);
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
        final lq entity = null;
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
        TFCreatures.entityEggs = new LinkedHashMap();
    }
}
