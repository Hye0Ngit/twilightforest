// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.EntityTFBlockGoblin;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFBlockGoblin extends RenderBiped
{
    public RenderTFBlockGoblin(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
    }
    
    public void func_76986_a(final Entity entity, final double d, final double d1, final double d2, final float f, final float f1) {
        final EntityTFBlockGoblin goblin = (EntityTFBlockGoblin)entity;
        super.func_76986_a(entity, d, d1, d2, f, f1);
        RenderManager.field_78727_a.func_78720_a((Entity)goblin.block, f1);
        RenderManager.field_78727_a.func_78720_a((Entity)goblin.chain1, f1);
        RenderManager.field_78727_a.func_78720_a((Entity)goblin.chain2, f1);
        RenderManager.field_78727_a.func_78720_a((Entity)goblin.chain3, f1);
    }
}
