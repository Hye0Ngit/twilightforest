// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import java.util.List;
import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;

public class EntityTFBlockGoblin extends tl implements sg
{
    private static final float CHAIN_SPEED = 16.0f;
    private static final int DATA_CHAINLENGTH = 17;
    private static final int DATA_CHAINPOS = 18;
    int recoilCounter;
    float chainAngle;
    public EntityTFSpikeBlock block;
    public EntityTFGoblinChain chain1;
    public EntityTFGoblinChain chain2;
    public EntityTFGoblinChain chain3;
    public nm[] partsArray;
    
    public EntityTFBlockGoblin(final abv world) {
        super(world);
        this.a(0.9f, 1.4f);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(1, (pr)new pf((om)this, (Class)tb.class, 2.0f, 0.2800000011920929, 0.5));
        this.c.a(5, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(6, (pr)new ql((om)this, 1.0));
        this.c.a(7, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(7, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, false));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
        this.recoilCounter = 0;
        this.partsArray = new nm[] { this.block = new EntityTFSpikeBlock(this), this.chain1 = new EntityTFGoblinChain(this), this.chain2 = new EntityTFGoblinChain(this), this.chain3 = new EntityTFGoblinChain(this) };
    }
    
    protected void a() {
        super.a();
        this.ah.a(17, (Object)0);
        this.ah.a(18, (Object)0);
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(20.0);
        this.a(to.d).a(0.28);
        this.a(to.e).a(8.0);
    }
    
    protected String r() {
        return "TwilightForest:mob.redcap.redcap";
    }
    
    protected String aN() {
        return "TwilightForest:mob.redcap.hurt";
    }
    
    protected String aO() {
        return "TwilightForest:mob.redcap.die";
    }
    
    protected int s() {
        return TFItems.armorShard.cv;
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
    
    public double getChainYOffset() {
        return 1.5 - this.getChainLength() / 4.0;
    }
    
    public asz getChainPosition() {
        return this.getChainPosition(this.getChainAngle(), this.getChainLength());
    }
    
    public asz getChainPosition(final float angle, final float distance) {
        final double var1 = Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double var2 = Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return this.q.V().a(this.u + var1, this.v + this.getChainYOffset(), this.w + var2);
    }
    
    public boolean isSwingingChain() {
        return this.au || (this.m() != null && this.recoilCounter == 0);
    }
    
    public boolean m(final nm par1Entity) {
        this.aU();
        return false;
    }
    
    public void l_() {
        super.l_();
        this.block.l_();
        this.chain1.l_();
        this.chain2.l_();
        this.chain3.l_();
        if (this.recoilCounter > 0) {
            --this.recoilCounter;
        }
        this.chainAngle += 16.0f;
        this.chainAngle %= 360.0f;
        if (!this.q.I) {
            this.ah.b(17, (Object)(byte)Math.floor(this.getChainLength() * 127.0f));
            this.ah.b(18, (Object)(byte)Math.floor(this.getChainAngle() / 360.0f * 255.0f));
        }
        else if (Math.abs(this.chainAngle - this.getChainAngle()) > 32.0f) {
            this.chainAngle = this.getChainAngle();
        }
        final asz blockPos = this.getChainPosition();
        this.block.b(blockPos.c, blockPos.d, blockPos.e);
        this.block.A = this.getChainAngle();
        final double sx = this.u;
        final double sy = this.v + this.P - 0.1;
        final double sz = this.w;
        final double ox = sx - blockPos.c;
        final double oy = sy - blockPos.d - this.block.P / 3.0;
        final double oz = sz - blockPos.e;
        this.chain1.b(sx - ox * 0.4, sy - oy * 0.4, sz - oz * 0.4);
        this.chain2.b(sx - ox * 0.5, sy - oy * 0.5, sz - oz * 0.5);
        this.chain3.b(sx - ox * 0.6, sy - oy * 0.6, sz - oz * 0.6);
        if (!this.q.I && this.isSwingingChain()) {
            this.applyBlockCollisions(this.block);
        }
    }
    
    protected void applyBlockCollisions(final nm collider) {
        final List list = this.q.b(collider, collider.E.b(0.20000000298023224, 0.0, 0.20000000298023224));
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                final nm entity = list.get(i);
                if (entity.L()) {
                    this.applyBlockCollision(collider, entity);
                }
            }
        }
    }
    
    protected void applyBlockCollision(final nm collider, final nm collided) {
        if (collided != this) {
            collided.f(collider);
            if (collided instanceof oe) {
                final boolean attackSuccess = super.m(collided);
                if (attackSuccess) {
                    collided.y += 0.4000000059604645;
                    this.a("mob.irongolem.throw", 1.0f, 1.0f);
                    this.recoilCounter = 40;
                }
            }
        }
    }
    
    public float getChainAngle() {
        if (!this.q.I) {
            return this.chainAngle;
        }
        return (this.ah.a(18) & 0xFF) / 255.0f * 360.0f;
    }
    
    public float getChainLength() {
        if (this.q.I) {
            return (this.ah.a(17) & 0xFF) / 127.0f;
        }
        if (this.isSwingingChain()) {
            return 0.9f;
        }
        return 0.3f;
    }
    
    public abv b() {
        return this.q;
    }
    
    public boolean a(final sh entitydragonpart, final na damagesource, final float i) {
        return false;
    }
    
    public nm[] an() {
        return this.partsArray;
    }
    
    public int aP() {
        int i = super.aP() + 11;
        if (i > 20) {
            i = 20;
        }
        return i;
    }
}
