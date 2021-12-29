// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFQuestRam extends bc
{
    private int randomTickDivider;
    
    public EntityTFQuestRam(final xd par1World) {
        super(par1World);
        this.bm = "/twilightforest/questram.png";
        this.a(1.25f, 2.9f);
        this.randomTickDivider = 0;
        this.aM().a(true);
        this.bT.a(0, (rc)new aje((acq)this));
        this.bT.a(1, (rc)new ke((aaa)this, 0.38f));
        this.bT.a(2, (rc)new akz((aaa)this, 0.25f, pb.ab.bO, false));
        this.bT.a(3, (rc)new acu((aaa)this, 0.25f));
        this.bT.a(5, (rc)new bd((acq)this));
    }
    
    public bc a(final bc var1) {
        return null;
    }
    
    public int d() {
        return 7;
    }
    
    protected void b() {
        super.b();
        this.ac.a(16, (Object)0);
    }
    
    public boolean b_() {
        return true;
    }
    
    protected boolean c_() {
        return false;
    }
    
    protected void g() {
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            this.randomTickDivider = 70 + this.U.nextInt(50);
            final int chunkX = gk.c(this.o) / 16;
            final int chunkZ = gk.c(this.q) / 16;
            final TFFeature nearFeature = TFFeature.getNearestFeature(chunkX, chunkZ, this.k);
            if (nearFeature != TFFeature.questGrove) {
                this.aX();
            }
        }
        super.g();
    }
    
    public boolean c(final yw par1EntityPlayer) {
        final aan currentItem = par1EntityPlayer.ap.b();
        if (currentItem != null && currentItem.c == pb.ab.bO && !this.isColorPresent(currentItem.i())) {
            this.setColorPresent(currentItem.i());
            par1EntityPlayer.b("Successfully used color " + currentItem.i());
            par1EntityPlayer.b("Color flags are now " + Integer.toBinaryString(this.getColorFlags()));
            return true;
        }
        return super.c(par1EntityPlayer);
    }
    
    public void e() {
        super.e();
    }
    
    public void b(final ady par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("ColorFlags", this.getColorFlags());
    }
    
    public void a(final ady par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setColorFlags(par1NBTTagCompound.f("ColorFlags"));
    }
    
    public int getColorFlags() {
        return this.ac.c(16);
    }
    
    public void setColorFlags(final int par1) {
        this.ac.b(16, (Object)par1);
    }
    
    public boolean isColorPresent(final int color) {
        final int flags = this.getColorFlags();
        return (flags & (int)Math.pow(2.0, color)) > 0;
    }
    
    public void setColorPresent(final int color) {
        final int flags = this.getColorFlags();
        System.out.println("Setting color flag for color " + color);
        System.out.println("Color int is " + flags);
        System.out.println("ORing that with " + Math.pow(2.0, color) + " which is " + Integer.toBinaryString((int)Math.pow(2.0, color)));
        this.setColorFlags(flags | (int)Math.pow(2.0, color));
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
}
