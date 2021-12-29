// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;

public class EntityTFMinoshroom extends EntityTFMinotaur
{
    public EntityTFMinoshroom(final zv par1World) {
        super(par1World);
        this.aH = "/mods/twilightforest/textures/model/minoshroomtaur.png";
        this.a(1.49f, 2.9f);
        this.be = 100;
        this.c(0, new wg(TFItems.minotaurAxe));
        this.bq[0] = 1.0f;
    }
    
    @Override
    public int aW() {
        return 120;
    }
    
    @Override
    protected int be() {
        return TFItems.meefStroganoff.cp;
    }
    
    @Override
    protected void a(final boolean par1, final int par2) {
        for (int numDrops = this.ab.nextInt(4) + 2 + this.ab.nextInt(1 + par2), i = 0; i < numDrops; ++i) {
            this.b(TFItems.meefStroganoff.cp, 1);
        }
    }
    
    protected boolean bm() {
        return false;
    }
}
