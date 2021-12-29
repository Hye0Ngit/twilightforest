// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.TwilightForestMod;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.client.event.sound.SoundLoadEvent;

public class TFSounds
{
    @ForgeSubscribe
    public void loadSounds(final SoundLoadEvent event) {
        final bev manager = event.manager;
        this.addSound(manager, "mob/tf/cicada2.ogg", "cicada2.ogg");
        this.addSound(manager, "mob/tf/cicada3.ogg", "cicada3.ogg");
        this.addSound(manager, "mob/tf/tinybird/chirp0.ogg", "tinybird/tinybirdchirp0.ogg");
        this.addSound(manager, "mob/tf/tinybird/chirp1.ogg", "tinybird/tinybirdchirp1.ogg");
        this.addSound(manager, "mob/tf/tinybird/chirp2.ogg", "tinybird/tinybirdchirp2.ogg");
        this.addSound(manager, "mob/tf/tinybird/song0.ogg", "tinybird/tinybirdsong0.ogg");
        this.addSound(manager, "mob/tf/tinybird/song1.ogg", "tinybird/tinybirdsong1.ogg");
        this.addSound(manager, "mob/tf/tinybird/hurt0.ogg", "tinybird/tinybirdhurt0.ogg");
        this.addSound(manager, "mob/tf/tinybird/hurt1.ogg", "tinybird/tinybirdhurt1.ogg");
        this.addSound(manager, "mob/tf/raven/caw0.ogg", "raven/ravencaw0.ogg");
        this.addSound(manager, "mob/tf/raven/caw1.ogg", "raven/ravencaw1.ogg");
        this.addSound(manager, "mob/tf/raven/squawk0.ogg", "raven/ravensquawk0.ogg");
        this.addSound(manager, "mob/tf/raven/squawk1.ogg", "raven/ravensquawk1.ogg");
        this.addSound(manager, "mob/tf/naga/hiss0.ogg", "naga/nagahiss0.ogg");
        this.addSound(manager, "mob/tf/naga/hiss1.ogg", "naga/nagahiss1.ogg");
        this.addSound(manager, "mob/tf/naga/hiss1.ogg", "naga/nagahiss2.ogg");
        this.addSound(manager, "mob/tf/naga/hurt0.ogg", "naga/nagahurt0.ogg");
        this.addSound(manager, "mob/tf/naga/hurt1.ogg", "naga/nagahurt1.ogg");
        this.addSound(manager, "mob/tf/naga/hurt2.ogg", "naga/nagahurt2.ogg");
        this.addSound(manager, "mob/tf/naga/rattle0.ogg", "naga/nagarattle0.ogg");
        this.addSound(manager, "mob/tf/naga/rattle1.ogg", "naga/nagarattle1.ogg");
        this.addSound(manager, "mob/tf/redcap/redcap0.ogg", "redcap/redcap0.ogg");
        this.addSound(manager, "mob/tf/redcap/redcap1.ogg", "redcap/redcap1.ogg");
        this.addSound(manager, "mob/tf/redcap/redcap2.ogg", "redcap/redcap2.ogg");
        this.addSound(manager, "mob/tf/redcap/redcap3.ogg", "redcap/redcap3.ogg");
        this.addSound(manager, "mob/tf/redcap/redcap4.ogg", "redcap/redcap4.ogg");
        this.addSound(manager, "mob/tf/redcap/redcap5.ogg", "redcap/redcap5.ogg");
        this.addSound(manager, "mob/tf/redcap/hurt0.ogg", "redcap/redcaphurt0.ogg");
        this.addSound(manager, "mob/tf/redcap/hurt1.ogg", "redcap/redcaphurt1.ogg");
        this.addSound(manager, "mob/tf/redcap/hurt2.ogg", "redcap/redcaphurt2.ogg");
        this.addSound(manager, "mob/tf/redcap/hurt3.ogg", "redcap/redcaphurt3.ogg");
        this.addSound(manager, "mob/tf/redcap/die0.ogg", "redcap/redcapdie0.ogg");
        this.addSound(manager, "mob/tf/redcap/die1.ogg", "redcap/redcapdie1.ogg");
        this.addSound(manager, "mob/tf/redcap/die2.ogg", "redcap/redcapdie2.ogg");
        this.addSound(manager, "mob/tf/wraith/wraith0.ogg", "wraith/wraith0.ogg");
        this.addSound(manager, "mob/tf/wraith/wraith1.ogg", "wraith/wraith1.ogg");
        this.addSound(manager, "mob/tf/wraith/wraith2.ogg", "wraith/wraith2.ogg");
        this.addSound(manager, "mob/tf/wraith/wraith3.ogg", "wraith/wraith3.ogg");
        this.addSound(manager, "mob/tf/kobold/kobold0.ogg", "kobold/kobold growl 1.ogg");
        this.addSound(manager, "mob/tf/kobold/kobold1.ogg", "kobold/kobold growl 2.ogg");
        this.addSound(manager, "mob/tf/kobold/kobold2.ogg", "kobold/kobold growl 3.ogg");
        this.addSound(manager, "mob/tf/kobold/kobold3.ogg", "kobold/kobold sniff 1.ogg");
        this.addSound(manager, "mob/tf/kobold/kobold4.ogg", "kobold/kobold snort 1.ogg");
        this.addSound(manager, "mob/tf/kobold/kobold5.ogg", "kobold/kobold snort 2.ogg");
        this.addSound(manager, "mob/tf/kobold/hurt0.ogg", "kobold/kobold hurt 1.ogg");
        this.addSound(manager, "mob/tf/kobold/hurt1.ogg", "kobold/kobold hurt 2.ogg");
        this.addSound(manager, "mob/tf/kobold/hurt2.ogg", "kobold/kobold hurt 3.ogg");
        this.addSound(manager, "mob/tf/kobold/die0.ogg", "kobold/kobold die 1.ogg");
        this.addSound(manager, "mob/tf/kobold/die1.ogg", "kobold/kobold die 2.ogg");
        this.addSound(manager, "mob/tf/kobold/die2.ogg", "kobold/kobold die 3.ogg");
        this.addSound(manager, "mob/tf/hydra/roar0.ogg", "hydra/roar3.ogg");
        this.addSound(manager, "mob/tf/hydra/roar1.ogg", "hydra/roar4.ogg");
        this.addSound(manager, "mob/tf/hydra/hurt0.ogg", "hydra/hurt5.ogg");
        this.addSound(manager, "mob/tf/hydra/hurt1.ogg", "hydra/hurt2.ogg");
        this.addSound(manager, "mob/tf/hydra/hurt2.ogg", "hydra/hurt6.ogg");
        this.addSound(manager, "mob/tf/hydra/hurt3.ogg", "hydra/hurt4.ogg");
        this.addSound(manager, "mob/tf/hydra/growl0.ogg", "hydra/growl1.ogg");
        this.addSound(manager, "mob/tf/hydra/growl1.ogg", "hydra/growl2.ogg");
        this.addSound(manager, "mob/tf/hydra/growl2.ogg", "hydra/growl3.ogg");
        this.addSound(manager, "mob/tf/hydra/warn0.ogg", "hydra/warn1.ogg");
        this.addSound(manager, "mob/tf/hydra/death0.ogg", "hydra/death.ogg");
        this.addSound(manager, "mob/tf/mosquito/mosquito0.wav", "mosquito/animals132.wav");
    }
    
    public void addSound(final bev manager, final String soundName, final String URL) {
        manager.b.addSound(soundName, TwilightForestMod.class.getResource("/twilightforest/sounds/" + URL));
    }
}
