// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFHydraHead extends EntityTFHydraPart
{
    public EntityTFHydraHead(final xv world) {
        super(world);
        this.aF = "/twilightforest/hydra4.png";
        this.al = true;
    }
    
    public EntityTFHydraHead(final EntityTFHydra hydra, final String s, final float f, final float f1) {
        super(hydra, s, f, f1);
    }
    
    public int bp() {
        return 500;
    }
    
    protected void aP() {
        ++this.aX;
    }
    
    @Override
    protected void a() {
        super.a();
        this.ag.a(18, (Object)0);
        this.ag.a(19, (Object)0);
    }
    
    public float getMouthOpen() {
        return (this.ag.a(18) & 0xFF) / 255.0f;
    }
    
    public int getState() {
        return this.ag.a(19) & 0xFF;
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
        this.ag.b(18, (Object)(byte)openByte);
    }
    
    public void setState(int state) {
        state &= 0xFF;
        this.ag.b(19, (Object)(byte)state);
    }
}
