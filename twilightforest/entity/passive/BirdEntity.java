// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nonnull;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.entity.passive.AnimalEntity;

public abstract class BirdEntity extends AnimalEntity
{
    protected static final Ingredient SEEDS;
    public float flapLength;
    public float flapIntensity;
    public float lastFlapIntensity;
    public float lastFlapLength;
    public float flapSpeed;
    
    public BirdEntity(final EntityType<? extends BirdEntity> entity, final World world) {
        super((EntityType)entity, world);
        this.flapLength = 0.0f;
        this.flapIntensity = 0.0f;
        this.flapSpeed = 1.0f;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        this.lastFlapLength = this.flapLength;
        this.lastFlapIntensity = this.flapIntensity;
        this.flapIntensity += (float)((this.field_70122_E ? -1 : 4) * 0.3);
        if (this.flapIntensity < 0.0f) {
            this.flapIntensity = 0.0f;
        }
        if (this.flapIntensity > 1.0f) {
            this.flapIntensity = 1.0f;
        }
        if (!this.field_70122_E && this.flapSpeed < 1.0f) {
            this.flapSpeed = 1.0f;
        }
        this.flapSpeed *= (float)0.9;
        if (!this.field_70122_E && this.func_213322_ci().func_82617_b() < 0.0) {
            this.func_213317_d(new Vector3d(this.func_213322_ci().func_82615_a(), this.func_213322_ci().func_82617_b() * 0.6, this.func_213322_ci().func_82616_c()));
        }
        this.flapLength += this.flapSpeed * 2.0f;
    }
    
    protected void func_184231_a(final double y, final boolean onGroundIn, @Nonnull final BlockState state, @Nonnull final BlockPos pos) {
    }
    
    public boolean func_225503_b_(final float dist, final float damageMultiplier) {
        return false;
    }
    
    public boolean func_226271_bk_() {
        return false;
    }
    
    public AnimalEntity createChild(final ServerWorld world, final AgeableEntity entityanimal) {
        return null;
    }
    
    public boolean isBirdLanded() {
        return true;
    }
    
    static {
        SEEDS = Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151014_N, (IItemProvider)Items.field_151081_bc, (IItemProvider)Items.field_151080_bb, (IItemProvider)Items.field_185163_cU });
    }
}
