// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.entity.effect.EntityWeatherEffect;

public class EntityTFTinyFirefly extends EntityWeatherEffect
{
    int lifeTime;
    int halfLife;
    public float glowSize;
    
    public EntityTFTinyFirefly(final World world, final double d, final double d1, final double d2) {
        super(world);
        this.func_70012_b(d, d1, d2, 0.0f, 0.0f);
        this.lifeTime = 10 + this.field_70146_Z.nextInt(21);
        this.halfLife = this.lifeTime / 2;
        this.glowSize = 0.2f + this.field_70146_Z.nextFloat() * 0.6f;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.lifeTime <= 1) {
            this.func_70106_y();
        }
        else {
            --this.lifeTime;
        }
    }
    
    public float getGlowBrightness() {
        if (this.lifeTime <= this.halfLife) {
            return this.lifeTime / (float)this.halfLife;
        }
        return 1.0f - (this.lifeTime - (float)this.halfLife) / this.halfLife;
    }
    
    protected void func_70088_a() {
    }
    
    protected void func_70037_a(final NBTTagCompound nbttagcompound) {
    }
    
    protected void func_70014_b(final NBTTagCompound nbttagcompound) {
    }
}
