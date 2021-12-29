// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFHydraHead extends EntityTFHydraPart
{
    public EntityTFHydraHead(final abv world) {
        super(world);
        this.am = true;
    }
    
    public EntityTFHydraHead(final EntityTFHydra hydra, final String s, final float f, final float f1) {
        super(hydra, s, f, f1);
    }
    
    public int bp() {
        return 500;
    }
    
    protected void aA() {
        ++this.aB;
    }
    
    @Override
    protected void a() {
        super.a();
        this.ah.a(18, (Object)0);
        this.ah.a(19, (Object)0);
    }
    
    public float getMouthOpen() {
        return (this.ah.a(18) & 0xFF) / 255.0f;
    }
    
    public int getState() {
        return this.ah.a(19) & 0xFF;
    }
    
    public void setMouthOpen(float openness) {
        if (openness < 0.0f) {
            openness = 0.0f;
        }
        if (openness > 1.0f) {
            openness = 1.0f;
        }
        int openByte = Math.round(openness * 255.0f);
        openByte &= 0xFF;
        this.ah.b(18, (Object)(byte)openByte);
    }
    
    public void setState(int state) {
        state &= 0xFF;
        this.ah.b(19, (Object)(byte)state);
    }
}
