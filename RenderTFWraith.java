import org.lwjgl.opengl.GL11;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class RenderTFWraith extends tp
{
    public RenderTFWraith(final fa modelbiped, final float f) {
        super(modelbiped, f);
        this.a((al)new ModelTFWraith());
    }
    
    protected int a(final nq entityliving, final int i, final float f) {
        if (i == 2) {
            this.a("/twilightforest/ghost.png");
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            return 2;
        }
        return 0;
    }
}
