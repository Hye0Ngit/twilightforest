// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import forge.MinecraftForge;
import forge.MinecraftForgeClient;
import forge.ISoundHandler;

public class TFSounds implements ISoundHandler
{
    public static void registerYourself() {
        if (doesInterfaceExist()) {
            MinecraftForgeClient.registerSoundHandler((ISoundHandler)new TFSounds());
        }
    }
    
    public static boolean doesInterfaceExist() {
        try {
            Class.forName(MinecraftForge.class.getCanonicalName().replace("MinecraftForge", "ISoundHandler"));
            return true;
        }
        catch (ClassNotFoundException exception) {
            return false;
        }
    }
    
    public void onSetupAudio(final sd soundManager) {
    }
    
    public void onLoadSoundSettings(final sd soundManager) {
        soundManager.getSoundsPool().addSound("mob/tf/cicada2.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/cicada2.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/cicada3.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/cicada3.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/tinybird/chirp0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/tinybird/tinybirdchirp0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/tinybird/chirp1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/tinybird/tinybirdchirp1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/tinybird/chirp2.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/tinybird/tinybirdchirp2.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/tinybird/song0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/tinybird/tinybirdsong0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/tinybird/song1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/tinybird/tinybirdsong1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/tinybird/hurt0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/tinybird/tinybirdhurt0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/tinybird/hurt1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/tinybird/tinybirdhurt1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/raven/caw0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/raven/ravencaw0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/raven/caw1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/raven/ravencaw1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/raven/squawk0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/raven/ravensquawk0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/raven/squawk1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/raven/ravensquawk1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/naga/hiss0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/naga/nagahiss0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/naga/hiss1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/naga/nagahiss1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/naga/hiss1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/naga/nagahiss2.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/naga/hurt0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/naga/nagahurt0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/naga/hurt1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/naga/nagahurt1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/naga/hurt2.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/naga/nagahurt2.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/naga/rattle0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/naga/nagarattle0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/naga/rattle1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/naga/nagarattle1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/redcap0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcap0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/redcap1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcap1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/redcap2.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcap2.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/redcap3.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcap3.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/redcap4.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcap4.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/redcap5.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcap5.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/hurt0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcaphurt0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/hurt1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcaphurt1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/hurt2.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcaphurt2.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/hurt3.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcaphurt3.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/die0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcapdie0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/die1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcapdie1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/redcap/die2.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/redcap/redcapdie2.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/wraith/wraith0.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/wraith/wraith0.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/wraith/wraith1.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/wraith/wraith1.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/wraith/wraith2.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/wraith/wraith2.ogg"));
        soundManager.getSoundsPool().addSound("mob/tf/wraith/wraith3.ogg", mod_TwilightForest.class.getResource("/twilightforest/sounds/wraith/wraith3.ogg"));
    }
    
    public ub onPlayBackgroundMusic(final sd soundManager, final ub entry) {
        return entry;
    }
    
    public ub onPlayStreaming(final sd soundManager, final ub entry, final String soundName, final float x, final float y, final float z) {
        return entry;
    }
    
    public ub onPlaySound(final sd soundManager, final ub entry, final String soundName, final float x, final float y, final float z, final float volume, final float pitch) {
        return entry;
    }
    
    public ub onPlaySoundEffect(final sd soundManager, final ub entry, final String soundName, final float volume, final float pitch) {
        return entry;
    }
}
