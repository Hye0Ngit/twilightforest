import java.util.ArrayList;
import forge.ITextureProvider;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFHedge extends ox implements ITextureProvider
{
    public int damageDone;
    
    protected BlockTFHedge(final int i) {
        super(i, aci.x);
        this.bN = 6;
        this.damageDone = 3;
    }
    
    public wq c(final wz world, final int i, final int j, final int k) {
        final float f = 0.0625f;
        return wq.b((double)(float)i, (double)j, (double)(float)k, (double)(float)(i + 1), (double)(j + 1 - f), (double)(float)(k + 1));
    }
    
    public void a(final wz world, final int i, final int j, final int k, final nk entity) {
        if (this.shouldDamage(entity)) {
            entity.a(ma.h, this.damageDone);
        }
    }
    
    public void b(final wz world, final int i, final int j, final int k, final nk entity) {
        if (this.shouldDamage(entity)) {
            entity.a(ma.h, this.damageDone);
        }
    }
    
    public void a(final wz world, final int i, final int j, final int k, final yr entityplayer) {
        entityplayer.a(ma.h, this.damageDone);
    }
    
    public void a(final wz world, final yr entityplayer, final int i, final int j, final int k, final int l) {
        super.a(world, entityplayer, i, j, k, l);
        entityplayer.a(ma.h, this.damageDone);
    }
    
    private boolean shouldDamage(final nk entity) {
        return !(entity instanceof bz) && !(entity instanceof fn);
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new aai((ox)this));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
}
