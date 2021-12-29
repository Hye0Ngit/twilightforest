// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFQuestRam extends ox
{
    private int randomTickDivider;
    
    public EntityTFQuestRam(final xv par1World) {
        super(par1World);
        this.aF = "/twilightforest/questram.png";
        this.a(1.25f, 2.9f);
        this.randomTickDivider = 0;
        this.az().a(true);
        this.bm.a(0, (nc)new mz((md)this));
        this.bm.a(1, (nc)new nt((mi)this, 0.38f));
        this.bm.a(2, (nc)new od((mi)this, 0.25f, amj.ae.cm, false));
        this.bm.a(3, (nc)new EntityAITFEatLoose(this, amj.ae.cm));
        this.bm.a(4, (nc)new EntityAITFFindLoose(this, 0.25f, amj.ae.cm));
        this.bm.a(5, (nc)new nw((mi)this, 0.25f));
        this.bm.a(6, (nc)new nv((md)this));
    }
    
    public ox func_90011_a(final ln entityanimal) {
        return null;
    }
    
    public int aT() {
        return 7;
    }
    
    protected void a() {
        super.a();
        this.ag.a(16, (Object)0);
        this.ag.a(17, (Object)0);
    }
    
    public boolean be() {
        return true;
    }
    
    protected boolean bj() {
        return false;
    }
    
    protected void bm() {
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            this.randomTickDivider = 70 + this.aa.nextInt(50);
            final int chunkX = ke.c(this.t) / 16;
            final int chunkZ = ke.c(this.v) / 16;
            final TFFeature nearFeature = TFFeature.getNearestFeature(chunkX, chunkZ, this.p);
            if (nearFeature != TFFeature.questGrove) {
                this.aL();
            }
            else {
                final s cc = TFFeature.getNearestCenterXYZ(ke.c(this.t), ke.c(this.v), this.p);
                this.b(cc.a, cc.b, cc.c, 13);
            }
            if (this.countColorsSet() > 15 && !this.getRewarded()) {
                this.rewardQuest();
                this.setRewarded(true);
            }
        }
        super.bm();
    }
    
    private void rewardQuest() {
        this.a(amj.aA.cm, 1, 1.0f);
        this.a(amj.al.cm, 1, 1.0f);
        this.a(amj.bY.cm, 1, 1.0f);
        this.a(amj.ak.cm, 1, 1.0f);
        this.a(amj.R.cm, 1, 1.0f);
        this.a(TFItems.crumbleHorn.cg, 1, 1.0f);
    }
    
    public boolean a(final qx par1EntityPlayer) {
        final um currentItem = par1EntityPlayer.bI.g();
        if (currentItem != null && currentItem.c == amj.ae.cm && !this.isColorPresent(currentItem.j())) {
            this.setColorPresent(currentItem.j());
            this.animateAddColor(currentItem.j(), 50);
            if (!par1EntityPlayer.cc.d) {
                final um um = currentItem;
                --um.a;
                if (currentItem.a <= 0) {
                    par1EntityPlayer.bI.a(par1EntityPlayer.bI.c, (um)null);
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
            this.animateAddColor(this.aa.nextInt(16), 5);
        }
    }
    
    public void b(final bq par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("ColorFlags", this.getColorFlags());
        par1NBTTagCompound.a("Rewarded", this.getRewarded());
    }
    
    public void a(final bq par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setColorFlags(par1NBTTagCompound.e("ColorFlags"));
        this.setRewarded(par1NBTTagCompound.n("Rewarded"));
    }
    
    public int getColorFlags() {
        return this.ag.c(16);
    }
    
    public void setColorFlags(final int par1) {
        this.ag.b(16, (Object)par1);
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
        return this.ag.a(17) != 0;
    }
    
    public void setRewarded(final boolean par1) {
        this.ag.b(17, (Object)(par1 ? 1 : ((Byte)0)));
    }
    
    public void animateAddColor(final int color, final int iterations) {
        for (int i = 0; i < iterations; ++i) {
            this.p.a("mobSpell", this.t + (this.aa.nextDouble() - 0.5) * this.N * 1.5, this.u + this.aa.nextDouble() * this.O * 1.5, this.v + (this.aa.nextDouble() - 0.5) * this.N * 1.5, (double)pe.d[color][0], (double)pe.d[color][1], (double)pe.d[color][2]);
        }
        this.aO();
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
    
    public void aO() {
        this.p.a((lq)this, "mob.sheep", this.aX(), this.aV());
    }
    
    protected float aX() {
        return 5.0f;
    }
    
    protected float aV() {
        return (this.aa.nextFloat() - this.aa.nextFloat()) * 0.2f + 0.7f;
    }
    
    protected String aZ() {
        return "mob.sheep";
    }
    
    protected String ba() {
        return "mob.sheep";
    }
}
