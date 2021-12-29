// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import java.util.Iterator;
import java.util.List;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;

public class TileEntityTFFlameJet extends aqj
{
    int counter;
    
    public TileEntityTFFlameJet() {
        this.counter = 0;
    }
    
    public void h() {
        if (++this.counter > 60) {
            this.counter = 0;
            if (!this.k.I && this.k.a(this.l, this.m, this.n) == TFBlocks.fireJet.cz) {
                this.k.f(this.l, this.m, this.n, TFBlocks.fireJet.cz, 8, 3);
            }
            this.w_();
        }
        else if (this.counter % 2 == 0) {
            this.k.a("largesmoke", this.l + 0.5, this.m + 1.0, this.n + 0.5, 0.0, 0.0, 0.0);
            TwilightForestMod.proxy.spawnParticle("largeflame", this.l + 0.5, this.m + 1.0, this.n + 0.5, 0.0, 0.5, 0.0);
            TwilightForestMod.proxy.spawnParticle("largeflame", this.l - 0.5, this.m + 1.0, this.n + 0.5, 0.05, 0.5, 0.0);
            TwilightForestMod.proxy.spawnParticle("largeflame", this.l + 0.5, this.m + 1.0, this.n - 0.5, 0.0, 0.5, 0.05);
            TwilightForestMod.proxy.spawnParticle("largeflame", this.l + 1.5, this.m + 1.0, this.n + 0.5, -0.05, 0.5, 0.0);
            TwilightForestMod.proxy.spawnParticle("largeflame", this.l + 0.5, this.m + 1.0, this.n + 1.5, 0.0, 0.5, -0.05);
        }
        if (this.counter % 4 == 0) {
            this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, "mob.ghast.fireball", 1.0f + this.k.s.nextFloat(), this.k.s.nextFloat() * 0.7f + 0.3f);
        }
        else if (this.counter == 1) {
            this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, "fire.ignite", 1.0f + this.k.s.nextFloat(), this.k.s.nextFloat() * 0.7f + 0.3f);
        }
        if (!this.k.I && this.counter % 5 == 0) {
            final List entitiesInRange = this.k.a((Class)mp.class, aqr.a().a((double)(this.l - 2), (double)this.m, (double)(this.n - 2), (double)(this.l + 2), (double)(this.m + 4), (double)(this.n + 2)));
            for (final mp entity : entitiesInRange) {
                if (!entity.E()) {
                    entity.a(mg.a, 2);
                    entity.d(15);
                }
            }
        }
    }
}
