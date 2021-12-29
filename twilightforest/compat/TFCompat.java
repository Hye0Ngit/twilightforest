// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat;

import java.util.HashSet;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import java.util.Iterator;
import twilightforest.TwilightForestMod;
import net.minecraftforge.fml.ModList;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public abstract class TFCompat
{
    public static HashMap<String, Class<? extends TFCompat>> classes;
    public static Set<TFCompat> modules;
    public final String modName;
    private boolean isActivated;
    
    protected TFCompat(final String modName) {
        this.isActivated = false;
        this.modName = modName;
    }
    
    public static void preInitCompat() {
        for (final Map.Entry<String, Class<? extends TFCompat>> entry : TFCompat.classes.entrySet()) {
            if (ModList.get().isLoaded((String)entry.getKey())) {
                try {
                    final TFCompat compat = entry.getValue().newInstance();
                    TFCompat.modules.add(compat);
                    compat.isActivated = compat.preInit();
                    if (compat.isActivated) {
                        TwilightForestMod.LOGGER.info("Loaded compatibility for mod {}.", (Object)compat.modName);
                    }
                    else {
                        TwilightForestMod.LOGGER.warn("Couldn't activate compatibility for mod {}!", (Object)compat.modName);
                    }
                }
                catch (Exception e) {
                    TwilightForestMod.LOGGER.error("Had a {} error loading {} compatibility in preInit!", (Object)e.getLocalizedMessage(), (Object)entry.getKey());
                    TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
                }
            }
            else {
                TwilightForestMod.LOGGER.info("Skipped compatibility for mod {}.", (Object)entry.getKey());
            }
        }
    }
    
    public static void initCompat() {
        for (final TFCompat compat : TFCompat.modules) {
            if (compat.isActivated) {
                try {
                    compat.init();
                }
                catch (Exception e) {
                    compat.isActivated = false;
                    TwilightForestMod.LOGGER.error("Had a {} error loading {} compatibility in init!", (Object)e.getLocalizedMessage(), (Object)compat.modName);
                    TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
                }
            }
        }
    }
    
    public static void initCompatItems(final RegistryEvent.Register<Item> evt) {
        for (final TFCompat compat : TFCompat.modules) {
            if (compat.isActivated) {
                try {
                    compat.initItems(evt);
                }
                catch (Exception e) {
                    compat.isActivated = false;
                    TwilightForestMod.LOGGER.error("Had a {} error loading {} compatibility in initializing items!", (Object)e.getLocalizedMessage(), (Object)compat.modName);
                    TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
                }
            }
        }
    }
    
    public static void postInitCompat() {
        for (final TFCompat compat : TFCompat.modules) {
            if (compat.isActivated) {
                try {
                    compat.postInit();
                }
                catch (Exception e) {
                    compat.isActivated = false;
                    TwilightForestMod.LOGGER.error("Had a {} error loading {} compatibility in postInit!", (Object)e.getLocalizedMessage(), (Object)compat.modName);
                    TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
                }
            }
        }
    }
    
    public static void IMCSender() {
        for (final TFCompat compat : TFCompat.modules) {
            if (compat.isActivated) {
                try {
                    compat.sendIMCs();
                }
                catch (Exception e) {
                    compat.isActivated = false;
                    TwilightForestMod.LOGGER.error("Had a {} error loading {} compatibility in sending IMCs!", (Object)e.getLocalizedMessage(), (Object)compat.modName);
                    TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
                }
            }
        }
    }
    
    protected abstract boolean preInit();
    
    protected abstract void init();
    
    protected abstract void postInit();
    
    protected abstract void sendIMCs();
    
    protected abstract void initItems(final RegistryEvent.Register<Item> p0);
    
    static {
        TFCompat.classes = new HashMap<String, Class<? extends TFCompat>>();
        TFCompat.modules = new HashSet<TFCompat>();
        TFCompat.classes.put("immersiveengineering", IECompat.class);
    }
}
