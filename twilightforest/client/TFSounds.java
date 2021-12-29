// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;

public class TFSounds
{
    @ForgeSubscribe
    public void loadSounds(final SoundLoadEvent event) {
        final SoundManager manager = event.manager;
        this.addSound(manager, "mob/cicada0.ogg");
        this.addSound(manager, "mob/cicada1.ogg");
        this.addSound(manager, "mob/tinybird/chirp0.ogg");
        this.addSound(manager, "mob/tinybird/chirp1.ogg");
        this.addSound(manager, "mob/tinybird/chirp2.ogg");
        this.addSound(manager, "mob/tinybird/song0.ogg");
        this.addSound(manager, "mob/tinybird/song1.ogg");
        this.addSound(manager, "mob/tinybird/hurt0.ogg");
        this.addSound(manager, "mob/tinybird/hurt1.ogg");
        this.addSound(manager, "mob/raven/caw0.ogg");
        this.addSound(manager, "mob/raven/caw1.ogg");
        this.addSound(manager, "mob/raven/squawk0.ogg");
        this.addSound(manager, "mob/raven/squawk1.ogg");
        this.addSound(manager, "mob/naga/hiss0.ogg");
        this.addSound(manager, "mob/naga/hiss1.ogg");
        this.addSound(manager, "mob/naga/hiss2.ogg");
        this.addSound(manager, "mob/naga/hurt0.ogg");
        this.addSound(manager, "mob/naga/hurt1.ogg");
        this.addSound(manager, "mob/naga/hurt2.ogg");
        this.addSound(manager, "mob/naga/rattle0.ogg");
        this.addSound(manager, "mob/naga/rattle1.ogg");
        this.addSound(manager, "mob/redcap/redcap0.ogg");
        this.addSound(manager, "mob/redcap/redcap1.ogg");
        this.addSound(manager, "mob/redcap/redcap2.ogg");
        this.addSound(manager, "mob/redcap/redcap3.ogg");
        this.addSound(manager, "mob/redcap/redcap4.ogg");
        this.addSound(manager, "mob/redcap/redcap5.ogg");
        this.addSound(manager, "mob/redcap/hurt0.ogg");
        this.addSound(manager, "mob/redcap/hurt1.ogg");
        this.addSound(manager, "mob/redcap/hurt2.ogg");
        this.addSound(manager, "mob/redcap/hurt3.ogg");
        this.addSound(manager, "mob/redcap/die0.ogg");
        this.addSound(manager, "mob/redcap/die1.ogg");
        this.addSound(manager, "mob/redcap/die2.ogg");
        this.addSound(manager, "mob/wraith/wraith0.ogg");
        this.addSound(manager, "mob/wraith/wraith1.ogg");
        this.addSound(manager, "mob/wraith/wraith2.ogg");
        this.addSound(manager, "mob/wraith/wraith3.ogg");
        this.addSound(manager, "mob/kobold/kobold0.ogg");
        this.addSound(manager, "mob/kobold/kobold1.ogg");
        this.addSound(manager, "mob/kobold/kobold2.ogg");
        this.addSound(manager, "mob/kobold/kobold3.ogg");
        this.addSound(manager, "mob/kobold/kobold4.ogg");
        this.addSound(manager, "mob/kobold/kobold5.ogg");
        this.addSound(manager, "mob/kobold/hurt0.ogg");
        this.addSound(manager, "mob/kobold/hurt1.ogg");
        this.addSound(manager, "mob/kobold/hurt2.ogg");
        this.addSound(manager, "mob/kobold/die0.ogg");
        this.addSound(manager, "mob/kobold/die1.ogg");
        this.addSound(manager, "mob/kobold/die2.ogg");
        this.addSound(manager, "mob/hydra/roar0.ogg");
        this.addSound(manager, "mob/hydra/roar1.ogg");
        this.addSound(manager, "mob/hydra/hurt0.ogg");
        this.addSound(manager, "mob/hydra/hurt1.ogg");
        this.addSound(manager, "mob/hydra/hurt2.ogg");
        this.addSound(manager, "mob/hydra/hurt3.ogg");
        this.addSound(manager, "mob/hydra/growl0.ogg");
        this.addSound(manager, "mob/hydra/growl1.ogg");
        this.addSound(manager, "mob/hydra/growl2.ogg");
        this.addSound(manager, "mob/hydra/warn0.ogg");
        this.addSound(manager, "mob/hydra/death0.ogg");
        this.addSound(manager, "mob/mosquito/mosquito0.wav", "mosquito/animals132.wav");
        this.addSound(manager, "mob/urghast/trapactive.ogg", "urghast/trapactive.ogg");
        this.addSound(manager, "mob/urghast/trapwarmup.ogg", "urghast/trapwarmup.ogg");
        this.addSound(manager, "mob/urghast/trapon0.ogg", "urghast/trapon0.ogg");
        this.addSound(manager, "mob/urghast/trapon1.ogg", "urghast/trapon1.ogg");
        this.addSound(manager, "mob/urghast/trapon2.ogg", "urghast/trapon2.ogg");
        this.addSound(manager, "mob/urghast/trapon3.ogg", "urghast/trapon3.ogg");
        this.addSound(manager, "mob/urghast/trapon4.ogg", "urghast/trapon4.ogg");
        this.addSound(manager, "mob/urghast/trapspindown.ogg", "urghast/trapspindown.ogg");
    }
    
    public void addSound(final SoundManager manager, final String soundName) {
        manager.func_77372_a("TwilightForest:" + soundName);
    }
    
    public void addSound(final SoundManager manager, final String soundName, final String URL) {
        manager.func_77372_a("TwilightForest:" + soundName);
    }
}
