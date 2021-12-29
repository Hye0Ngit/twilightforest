// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFMinoshroom extends EntityTFMinotaur
{
    public EntityTFMinoshroom(final xv par1World) {
        super(par1World);
        this.aF = "/twilightforest/minoshroomtaur.png";
        this.a(1.49f, 2.9f);
        this.bc = 100;
        this.b(0, new um(TFItems.minotaurAxe));
        this.bo[0] = 1.0f;
    }
    
    @Override
    public int aT() {
        return 120;
    }
    
    @Override
    protected int bb() {
        return TFItems.meefStroganoff.cg;
    }
    
    @Override
    protected void a(final boolean par1, final int par2) {
        for (int numDrops = this.aa.nextInt(4) + 2 + this.aa.nextInt(1 + par2), i = 0; i < numDrops; ++i) {
            this.b(TFItems.meefStroganoff.cg, 1);
        }
    }
    
    protected boolean bj() {
        return false;
    }
}
