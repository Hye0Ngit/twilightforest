// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;
import javax.annotation.Nonnull;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.entity.animal.Animal;

public abstract class Bird extends Animal
{
    protected static final Ingredient SEEDS;
    public float flapLength;
    public float flapIntensity;
    public float lastFlapIntensity;
    public float lastFlapLength;
    public float flapSpeed;
    
    public Bird(final EntityType<? extends Bird> entity, final Level world) {
        super((EntityType)entity, world);
        this.flapLength = 0.0f;
        this.flapIntensity = 0.0f;
        this.flapSpeed = 1.0f;
    }
    
    public void m_8107_() {
        super.m_8107_();
        this.lastFlapLength = this.flapLength;
        this.lastFlapIntensity = this.flapIntensity;
        this.flapIntensity += (float)((this.f_19861_ ? -1 : 4) * 0.3);
        if (this.flapIntensity < 0.0f) {
            this.flapIntensity = 0.0f;
        }
        if (this.flapIntensity > 1.0f) {
            this.flapIntensity = 1.0f;
        }
        if (!this.f_19861_ && this.flapSpeed < 1.0f) {
            this.flapSpeed = 1.0f;
        }
        this.flapSpeed *= (float)0.9;
        if (!this.f_19861_ && this.m_20184_().m_7098_() < 0.0) {
            this.m_20256_(new Vec3(this.m_20184_().m_7096_(), this.m_20184_().m_7098_() * 0.6, this.m_20184_().m_7094_()));
        }
        this.flapLength += this.flapSpeed * 2.0f;
    }
    
    protected void m_7840_(final double y, final boolean onGroundIn, @Nonnull final BlockState state, @Nonnull final BlockPos pos) {
    }
    
    public boolean m_142535_(final float dist, final float damageMultiplier, final DamageSource source) {
        return false;
    }
    
    public boolean m_20161_() {
        return false;
    }
    
    public Animal getBreedOffspring(final ServerLevel world, final AgeableMob entityanimal) {
        return null;
    }
    
    public boolean isBirdLanded() {
        return true;
    }
    
    static {
        SEEDS = Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42404_, (ItemLike)Items.f_42578_, (ItemLike)Items.f_42577_, (ItemLike)Items.f_42733_ });
    }
}
