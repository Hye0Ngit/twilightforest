// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import java.util.Random;

public class ModelTFTowerBoss extends ModelTFGhast
{
    protected bdc[][] subTentacles;
    protected bdc[][] smallTentacles;
    
    public ModelTFTowerBoss() {
        this.smallTentacles = new bdc[2][3];
        for (int i = 0; i < this.smallTentacles.length; ++i) {
            this.makeSmallTentacle(i);
        }
    }
    
    @Override
    protected void makeTentacle(final byte yOffset, final Random random, final int num) {
        this.tentacles[num] = new bdc((bbx)this, num % 3, 0);
        int length = 5;
        this.tentacles[num].a(-1.5f, 0.0f, -1.5f, 3, length, 3);
        if (num == 0) {
            this.tentacles[num].c = 4.5f;
            this.tentacles[num].e = 4.5f;
            this.tentacles[num].d = (float)(23 + yOffset);
        }
        if (num == 1) {
            this.tentacles[num].c = -4.5f;
            this.tentacles[num].e = 4.5f;
            this.tentacles[num].d = (float)(23 + yOffset);
        }
        if (num == 2) {
            this.tentacles[num].c = 0.0f;
            this.tentacles[num].e = 0.0f;
            this.tentacles[num].d = (float)(23 + yOffset);
        }
        if (num == 3) {
            this.tentacles[num].c = 5.5f;
            this.tentacles[num].e = -4.5f;
            this.tentacles[num].d = (float)(23 + yOffset);
        }
        if (num == 4) {
            this.tentacles[num].c = -5.5f;
            this.tentacles[num].e = -4.5f;
            this.tentacles[num].d = (float)(23 + yOffset);
        }
        else if (num == 5) {
            this.tentacles[num].c = -7.5f;
            this.tentacles[num].d = 3.5f;
            this.tentacles[num].e = -1.0f;
            this.tentacles[num].h = 0.7853982f;
        }
        else if (num == 6) {
            this.tentacles[num].c = -7.5f;
            this.tentacles[num].d = -1.5f;
            this.tentacles[num].e = 3.5f;
            this.tentacles[num].h = 1.0471976f;
        }
        else if (num == 7) {
            this.tentacles[num].c = 7.5f;
            this.tentacles[num].d = 3.5f;
            this.tentacles[num].e = -1.0f;
            this.tentacles[num].h = -0.7853982f;
        }
        else if (num == 8) {
            this.tentacles[num].c = 7.5f;
            this.tentacles[num].d = -1.5f;
            this.tentacles[num].e = 3.5f;
            this.tentacles[num].h = -1.0471976f;
        }
        if (this.subTentacles == null) {
            this.subTentacles = new bdc[this.tentacles.length][3];
        }
        for (int i = 0; i < 3; ++i) {
            length = 4;
            (this.subTentacles[num][i] = new bdc((bbx)this, num % 4, i * 5 - 1)).a(-1.5f, -0.5f, -1.5f, 3, length, 3);
            this.subTentacles[num][i].c = 0.0f;
            this.subTentacles[num][i].e = 0.0f;
            this.subTentacles[num][i].d = (float)length;
            if (i == 0) {
                this.tentacles[num].a(this.subTentacles[num][i]);
            }
            else {
                this.subTentacles[num][i - 1].a(this.subTentacles[num][i]);
            }
        }
        this.body.a(this.tentacles[num]);
    }
    
    protected void makeSmallTentacle(final int num) {
    }
    
    @Override
    public void a(final float par1, final float par2, final float timeAlive, final float yaw, final float pitch, final float par6, final mp par7Entity) {
        super.a(par1, par2, timeAlive, yaw, pitch, par6, par7Entity);
        for (int i = 0; i < this.subTentacles.length; ++i) {
            final float wiggle = Math.min(par2, 0.6f);
            final float time = (timeAlive + i * 9) / 2.0f;
            this.subTentacles[i][0].f = (kx.b(time * 0.6662f) * 1.0f - 1.0471976f) * wiggle;
            this.subTentacles[i][1].f = kx.b(time * 0.7774f) * 1.2f * wiggle;
            this.subTentacles[i][2].f = kx.b(time * 0.8886f + 1.5707964f) * 1.4f * wiggle;
            this.subTentacles[i][0].f = 0.2f + kx.b(time * 0.3335f) * 0.15f;
            this.subTentacles[i][1].f = 0.1f + kx.b(time * 0.4445f) * 0.2f;
            this.subTentacles[i][2].f = 0.1f + kx.b(time * 0.5555f) * 0.25f;
            final float yTwist = 0.4f;
            this.tentacles[i].g = yTwist * kx.a(time * 0.3f);
        }
    }
}
