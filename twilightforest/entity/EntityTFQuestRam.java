// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import twilightforest.TFFeature;
import twilightforest.entity.ai.EntityAITFFindLoose;
import twilightforest.entity.ai.EntityAITFEatLoose;

public class EntityTFQuestRam extends qb
{
    private int randomTickDivider;
    
    public EntityTFQuestRam(final zv par1World) {
        super(par1World);
        this.aH = "/mods/twilightforest/textures/model/questram.png";
        this.a(1.25f, 2.9f);
        this.randomTickDivider = 0;
        this.aC().a(true);
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(1, (og)new ox((nl)this, 0.38f));
        this.bo.a(2, (og)new ph((nl)this, 0.25f, aou.af.cz, false));
        this.bo.a(3, (og)new EntityAITFEatLoose(this, aou.af.cz));
        this.bo.a(4, (og)new EntityAITFFindLoose(this, 0.25f, aou.af.cz));
        this.bo.a(5, (og)new pa((nl)this, 0.25f));
        this.bo.a(6, (og)new oz((ng)this));
    }
    
    public qb createChild(final mm entityanimal) {
        return null;
    }
    
    public int aW() {
        return 7;
    }
    
    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
        this.ah.a(17, (Object)0);
    }
    
    public boolean bh() {
        return true;
    }
    
    protected boolean bm() {
        return false;
    }
    
    protected void bp() {
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            this.randomTickDivider = 70 + this.ab.nextInt(50);
            final int chunkX = kx.c(this.u) / 16;
            final int chunkZ = kx.c(this.w) / 16;
            final TFFeature nearFeature = TFFeature.getNearestFeature(chunkX, chunkZ, this.q);
            if (nearFeature != TFFeature.questGrove) {
                this.aO();
            }
            else {
                final t cc = TFFeature.getNearestCenterXYZ(kx.c(this.u), kx.c(this.w), this.q);
                this.b(cc.a, cc.b, cc.c, 13);
            }
            if (this.countColorsSet() > 15 && !this.getRewarded()) {
                this.rewardQuest();
                this.setRewarded(true);
            }
        }
        super.bp();
    }
    
    private void rewardQuest() {
        this.a(aou.aB.cz, 1, 1.0f);
        this.a(aou.am.cz, 1, 1.0f);
        this.a(aou.bZ.cz, 1, 1.0f);
        this.a(aou.al.cz, 1, 1.0f);
        this.a(aou.S.cz, 1, 1.0f);
        this.a(TFItems.crumbleHorn.cp, 1, 1.0f);
    }
    
    public boolean a_(final sk par1EntityPlayer) {
        final wg currentItem = par1EntityPlayer.bK.h();
        if (currentItem != null && currentItem.c == aou.af.cz && !this.isColorPresent(currentItem.k())) {
            this.setColorPresent(currentItem.k());
            this.animateAddColor(currentItem.k(), 50);
            if (!par1EntityPlayer.ce.d) {
                final wg wg = currentItem;
                --wg.a;
                if (currentItem.a <= 0) {
                    par1EntityPlayer.bK.a(par1EntityPlayer.bK.c, (wg)null);
                }
            }
            return true;
        }
        return super.a_(par1EntityPlayer);
    }
    
    public void c() {
        super.c();
        this.checkAndAnimateColors();
    }
    
    public void checkAndAnimateColors() {
        if (this.countColorsSet() > 15 && !this.getRewarded()) {
            this.animateAddColor(this.ab.nextInt(16), 5);
        }
    }
    
    public void b(final bs par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("ColorFlags", this.getColorFlags());
        par1NBTTagCompound.a("Rewarded", this.getRewarded());
    }
    
    public void a(final bs par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setColorFlags(par1NBTTagCompound.e("ColorFlags"));
        this.setRewarded(par1NBTTagCompound.n("Rewarded"));
    }
    
    public int getColorFlags() {
        return this.ah.c(16);
    }
    
    public void setColorFlags(final int par1) {
        this.ah.b(16, (Object)par1);
    }
    
    public boolean isColorPresent(final int color) {
        final int flags = this.getColorFlags();
        return (flags & (int)Math.pow(2.0, color)) > 0;
    }
    
    public void setColorPresent(final int color) {
        final int flags = this.getColorFlags();
        this.setColorFlags(flags | (int)Math.pow(2.0, color));
    }
    
    public boolean getRewarded() {
        return this.ah.a(17) != 0;
    }
    
    public void setRewarded(final boolean par1) {
        this.ah.b(17, (Object)(par1 ? 1 : ((Byte)0)));
    }
    
    public void animateAddColor(final int color, final int iterations) {
        for (int i = 0; i < iterations; ++i) {
            this.q.a("mobSpell", this.u + (this.ab.nextDouble() - 0.5) * this.O * 1.5, this.v + this.ab.nextDouble() * this.P * 1.5, this.w + (this.ab.nextDouble() - 0.5) * this.O * 1.5, (double)qi.d[color][0], (double)qi.d[color][1], (double)qi.d[color][2]);
        }
        this.aR();
    }
    
    public int countColorsSet() {
        int count = 0;
        for (int i = 0; i < 16; ++i) {
            if (this.isColorPresent(i)) {
                ++count;
            }
        }
        return count;
    }
    
    public void aR() {
        this.q.a((mp)this, "mob.sheep", this.ba(), this.aY());
    }
    
    protected float ba() {
        return 5.0f;
    }
    
    protected float aY() {
        return (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 0.7f;
    }
    
    protected String bb() {
        return "mob.sheep.say";
    }
    
    protected String bc() {
        return "mob.sheep.say";
    }
    
    protected String bd() {
        return "mob.sheep.say";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.a("mob.sheep.step", 0.15f, 1.0f);
    }
}
