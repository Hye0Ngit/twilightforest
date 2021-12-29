// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nonnull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityAnimal;

public abstract class EntityTFBird extends EntityAnimal
{
    public static final ResourceLocation LOOT_TABLE;
    protected static final Ingredient SEEDS;
    public float flapLength;
    public float flapIntensity;
    public float lastFlapIntensity;
    public float lastFlapLength;
    public float flapSpeed;
    
    public EntityTFBird(final World world) {
        super(world);
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
        if (!this.field_70122_E && this.field_70181_x < 0.0) {
            this.field_70181_x *= 0.6;
        }
        this.flapLength += this.flapSpeed * 2.0f;
    }
    
    protected void func_184231_a(final double y, final boolean onGroundIn, @Nonnull final IBlockState state, @Nonnull final BlockPos pos) {
    }
    
    public void func_180430_e(final float dist, final float damageMultiplier) {
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFBird.LOOT_TABLE;
    }
    
    public EntityAnimal createChild(final EntityAgeable entityanimal) {
        return null;
    }
    
    public boolean isBirdLanded() {
        return true;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/bird");
        SEEDS = Ingredient.func_193368_a(new Item[] { Items.field_151014_N, Items.field_151081_bc, Items.field_151080_bb, Items.field_185163_cU });
    }
}
