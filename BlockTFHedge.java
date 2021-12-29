// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFHedge extends yy
{
    public int damageDone;
    public static int sprite;
    
    protected BlockTFHedge(final int i) {
        super(i, p.w);
        this.bL = BlockTFHedge.sprite;
        this.damageDone = 3;
    }
    
    public c b(final ry world, final int i, final int j, final int k) {
        final float f = 0.0625f;
        return c.b((double)(float)i, (double)j, (double)(float)k, (double)(float)(i + 1), (double)(j + 1 - f), (double)(float)(k + 1));
    }
    
    public void a(final ry world, final int i, final int j, final int k, final ia entity) {
        if (this.shouldDamage(entity)) {
            entity.a(pm.g, this.damageDone);
        }
    }
    
    public void b(final ry world, final int i, final int j, final int k, final ia entity) {
        if (this.shouldDamage(entity)) {
            entity.a(pm.g, this.damageDone);
        }
    }
    
    public void b(final ry world, final int i, final int j, final int k, final vi entityplayer) {
        entityplayer.a(pm.g, this.damageDone);
    }
    
    public void a(final ry world, final vi entityplayer, final int i, final int j, final int k, final int l) {
        super.a(world, entityplayer, i, j, k, l);
        entityplayer.a(pm.g, this.damageDone);
    }
    
    private boolean shouldDamage(final ia entity) {
        return !(entity instanceof vq) && !(entity instanceof ih);
    }
    
    static {
        BlockTFHedge.sprite = ModLoader.addOverride("/terrain.png", "/twilightforest/blocks/hedgemaze.png");
    }
}
