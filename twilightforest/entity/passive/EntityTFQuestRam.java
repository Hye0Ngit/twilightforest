// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.item.TFItems;
import twilightforest.TFFeature;
import twilightforest.entity.ai.EntityAITFFindLoose;
import twilightforest.entity.ai.EntityAITFEatLoose;

public class EntityTFQuestRam extends ro
{
    private int randomTickDivider;
    
    public EntityTFQuestRam(final abv par1World) {
        super(par1World);
        this.a(1.25f, 2.9f);
        this.randomTickDivider = 0;
        this.k().a(true);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(1, (pr)new qi((om)this, 1.3799999952316284));
        this.c.a(2, (pr)new qt((om)this, 1.0, aqw.ag.cF, false));
        this.c.a(3, (pr)new EntityAITFEatLoose(this, aqw.ag.cF));
        this.c.a(4, (pr)new EntityAITFFindLoose(this, 1.0f, aqw.ag.cF));
        this.c.a(5, (pr)new ql((om)this, 1.0));
        this.c.a(6, (pr)new qk((of)this));
    }
    
    public ro createChild(final nj entityanimal) {
        return null;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(70.0);
        this.a(to.d).a(0.10000001192092896);
    }
    
    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
        this.ah.a(17, (Object)0);
    }
    
    public boolean be() {
        return true;
    }
    
    protected boolean t() {
        return false;
    }
    
    protected void bj() {
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            this.randomTickDivider = 70 + this.ab.nextInt(50);
            final int chunkX = lr.c(this.u) / 16;
            final int chunkZ = lr.c(this.w) / 16;
            final TFFeature nearFeature = TFFeature.getNearestFeature(chunkX, chunkZ, this.q);
            if (nearFeature != TFFeature.questGrove) {
                this.detachHome();
            }
            else {
                final t cc = TFFeature.getNearestCenterXYZ(lr.c(this.u), lr.c(this.w), this.q);
                this.setHomeArea(cc.a, cc.b, cc.c, 13);
            }
            if (this.countColorsSet() > 15 && !this.getRewarded()) {
                this.rewardQuest();
                this.setRewarded(true);
            }
        }
        super.bj();
    }
    
    private void rewardQuest() {
        this.a(aqw.aC.cF, 1, 1.0f);
        this.a(aqw.an.cF, 1, 1.0f);
        this.a(aqw.ca.cF, 1, 1.0f);
        this.a(aqw.am.cF, 1, 1.0f);
        this.a(aqw.T.cF, 1, 1.0f);
        this.a(TFItems.crumbleHorn.cv, 1, 1.0f);
    }
    
    public boolean a(final ue par1EntityPlayer) {
        final yd currentItem = par1EntityPlayer.bn.h();
        if (currentItem != null && currentItem.d == aqw.ag.cF && !this.isColorPresent(currentItem.k())) {
            this.setColorPresent(currentItem.k());
            this.animateAddColor(currentItem.k(), 50);
            if (!par1EntityPlayer.bG.d) {
                final yd yd = currentItem;
                --yd.b;
                if (currentItem.b <= 0) {
                    par1EntityPlayer.bn.a(par1EntityPlayer.bn.c, (yd)null);
                }
            }
            return true;
        }
        return super.a(par1EntityPlayer);
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
    
    public void b(final bx par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("ColorFlags", this.getColorFlags());
        par1NBTTagCompound.a("Rewarded", this.getRewarded());
    }
    
    public void a(final bx par1NBTTagCompound) {
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
            this.q.a("mobSpell", this.u + (this.ab.nextDouble() - 0.5) * this.O * 1.5, this.v + this.ab.nextDouble() * this.P * 1.5, this.w + (this.ab.nextDouble() - 0.5) * this.O * 1.5, (double)ry.bp[color][0], (double)ry.bp[color][1], (double)ry.bp[color][2]);
        }
        this.p();
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
    
    public void p() {
        this.q.a((nm)this, "mob.sheep", this.aZ(), this.ba());
    }
    
    protected float aZ() {
        return 5.0f;
    }
    
    protected float ba() {
        return (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f + 0.7f;
    }
    
    protected String r() {
        return "mob.sheep.say";
    }
    
    protected String aN() {
        return "mob.sheep.say";
    }
    
    protected String aO() {
        return "mob.sheep.say";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.a("mob.sheep.step", 0.15f, 1.0f);
    }
    
    public void setHomeArea(final int par1, final int par2, final int par3, final int par4) {
        this.b(par1, par2, par3, par4);
    }
    
    public t getHomePosition() {
        return this.bP();
    }
    
    public float getMaximumHomeDistance() {
        return this.bQ();
    }
    
    public void detachHome() {
        this.bR();
    }
    
    public boolean hasHome() {
        return this.bS();
    }
}
