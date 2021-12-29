// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFSpikeBlock extends nm
{
    EntityTFBlockGoblin goblin;
    private String texture;
    
    public EntityTFSpikeBlock(final abv par1World) {
        super(par1World);
        this.a(0.75f, 0.75f);
    }
    
    public EntityTFSpikeBlock(final EntityTFBlockGoblin goblin) {
        this(goblin.b());
        this.goblin = goblin;
    }
    
    public boolean a(final na par1DamageSource, final float par2) {
        return false;
    }
    
    public void l_() {
        super.l_();
        ++this.ac;
        this.U = this.u;
        this.V = this.v;
        this.W = this.w;
        while (this.A - this.C < -180.0f) {
            this.C -= 360.0f;
        }
        while (this.A - this.C >= 180.0f) {
            this.C += 360.0f;
        }
        while (this.B - this.D < -180.0f) {
            this.D -= 360.0f;
        }
        while (this.B - this.D >= 180.0f) {
            this.D += 360.0f;
        }
    }
    
    public boolean K() {
        return false;
    }
    
    public boolean L() {
        return false;
    }
    
    public boolean h(final nm entity) {
        return this == entity || this.goblin == entity;
    }
    
    protected void a() {
    }
    
    protected void a(final bx nbttagcompound) {
    }
    
    protected void b(final bx nbttagcompound) {
    }
}
