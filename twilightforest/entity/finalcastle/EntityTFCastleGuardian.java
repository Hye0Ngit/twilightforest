// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.finalcastle;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.EntityCreature;

public class EntityTFCastleGuardian extends EntityCreature
{
    public EntityTFCastleGuardian(final World worldIn) {
        super(worldIn);
        this.func_70105_a(1.8f, 2.4f);
    }
    
    protected void func_184651_r() {
    }
    
    protected float func_110146_f(final float renderYawOffset, float p_110146_2_) {
        final float f = MathHelper.func_76142_g(renderYawOffset - this.field_70761_aq);
        this.field_70761_aq += f * 0.5f;
        float f2 = MathHelper.func_76142_g(this.field_70177_z - this.field_70761_aq);
        final boolean flag = f2 < -90.0f || f2 >= 90.0f;
        if (f2 < -75.0f) {
            f2 = -75.0f;
        }
        if (f2 >= 75.0f) {
            f2 = 75.0f;
        }
        this.field_70761_aq = this.field_70177_z - f2;
        if (f2 * f2 > 2500.0f) {
            this.field_70761_aq += f2 * 0.5f;
        }
        if (flag) {
            p_110146_2_ *= -1.0f;
        }
        return p_110146_2_;
    }
    
    public AxisAlignedBB func_70046_E() {
        return this.func_174813_aQ();
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    public boolean func_96092_aw() {
        return false;
    }
    
    public float func_70047_e() {
        return 1.865f;
    }
    
    public boolean func_70648_aU() {
        return false;
    }
}
