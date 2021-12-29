// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.EntityTFBlockGoblin;

public class RenderTFBlockGoblin extends bgr
{
    private static final bjl textureLoc;
    
    public RenderTFBlockGoblin(final bbg par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
    }
    
    public void a(final nm entity, final double d, final double d1, final double d2, final float f, final float f1) {
        final EntityTFBlockGoblin goblin = (EntityTFBlockGoblin)entity;
        super.a(entity, d, d1, d2, f, f1);
        bgi.a.a((nm)goblin.block, f1);
        bgi.a.a((nm)goblin.chain1, f1);
        bgi.a.a((nm)goblin.chain2, f1);
        bgi.a.a((nm)goblin.chain3, f1);
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFBlockGoblin.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/blockgoblin.png");
    }
}
