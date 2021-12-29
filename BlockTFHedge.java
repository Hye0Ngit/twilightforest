// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFHedge extends ud
{
    public int damageDone;
    public static int sprite;
    
    protected BlockTFHedge(final int i) {
        super(i, ls.w);
        this.bN = BlockTFHedge.sprite;
        this.damageDone = 3;
    }
    
    public fb e(final fq world, final int i, final int j, final int k) {
        final float f = 0.0625f;
        return fb.b((double)(float)i, (double)j, (double)(float)k, (double)(float)(i + 1), (double)(j + 1 - f), (double)(float)(k + 1));
    }
    
    public void a(final fq world, final int i, final int j, final int k, final se entity) {
        if (this.shouldDamage(entity)) {
            entity.a(qc.h, this.damageDone);
        }
    }
    
    public void b(final fq world, final int i, final int j, final int k, final se entity) {
        if (this.shouldDamage(entity)) {
            entity.a(qc.h, this.damageDone);
        }
    }
    
    public void b(final fq world, final int i, final int j, final int k, final hk entityplayer) {
        entityplayer.a(qc.h, this.damageDone);
    }
    
    public void a(final fq world, final hk entityplayer, final int i, final int j, final int k, final int l) {
        super.a(world, entityplayer, i, j, k, l);
        entityplayer.a(qc.h, this.damageDone);
    }
    
    private boolean shouldDamage(final se entity) {
        return !(entity instanceof cu) && !(entity instanceof ia);
    }
    
    static {
        BlockTFHedge.sprite = ModLoader.addOverride("/terrain.png", "/twilightforest/blocks/hedgemaze.png");
    }
}
