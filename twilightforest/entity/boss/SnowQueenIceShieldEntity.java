// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.nbt.CompoundNBT;
import twilightforest.TFSounds;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.client.renderer.entity.SnowQueenIceShieldLayer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Entity;
import twilightforest.entity.TFPartEntity;

public class SnowQueenIceShieldEntity extends TFPartEntity<SnowQueenEntity>
{
    public SnowQueenIceShieldEntity(final SnowQueenEntity parent) {
        super((Entity)parent);
        this.field_213325_aI = EntitySize.func_220314_b(0.75f, 0.75f);
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public EntityRenderer<?> renderer(final EntityRendererManager manager) {
        return new SnowQueenIceShieldLayer<Object>(manager);
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        this.func_184185_a(TFSounds.SNOW_QUEEN_BREAK, 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        return false;
    }
    
    protected void func_70037_a(final CompoundNBT compound) {
    }
    
    protected void func_213281_b(final CompoundNBT compound) {
    }
    
    protected void func_70088_a() {
    }
}
