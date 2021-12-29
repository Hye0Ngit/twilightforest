// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;

public class EntityTFMinoshroom extends EntityTFMinotaur
{
    public EntityTFMinoshroom(final yc par1World) {
        super(par1World);
        this.aG = "/twilightforest/minoshroomtaur.png";
        this.a(1.49f, 2.9f);
        this.bd = 100;
        this.b(0, new ur(TFItems.minotaurAxe));
        this.bp[0] = 1.0f;
    }
    
    @Override
    public int aT() {
        return 120;
    }
    
    @Override
    protected int bb() {
        return TFItems.meefStroganoff.cj;
    }
    
    @Override
    protected void a(final boolean par1, final int par2) {
        for (int numDrops = this.aa.nextInt(4) + 2 + this.aa.nextInt(1 + par2), i = 0; i < numDrops; ++i) {
            this.b(TFItems.meefStroganoff.cj, 1);
        }
    }
    
    protected boolean bj() {
        return false;
    }
}
