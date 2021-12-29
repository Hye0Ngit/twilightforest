// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockDirectional;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityTFMoonwormShot extends EntityTFThrowable
{
    public EntityTFMoonwormShot(final World world) {
        super(world);
    }
    
    public EntityTFMoonwormShot(final World world, final EntityLivingBase thrower) {
        super(world, thrower);
        this.func_184538_a((Entity)thrower, thrower.field_70125_A, thrower.field_70177_z, 0.0f, 1.5f, 1.0f);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    public float func_70013_c() {
        return 1.0f;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_70070_b() {
        return 15728880;
    }
    
    private void makeTrail() {
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.0f;
    }
    
    protected float func_70185_h() {
        return 0.03f;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            final int stateId = Block.func_176210_f(TFBlocks.moonworm.func_176223_P());
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.BLOCK_CRACK, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[] { stateId });
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70184_a(final RayTraceResult ray) {
        if (!this.field_70170_p.field_72995_K) {
            if (ray.field_72313_a == RayTraceResult.Type.BLOCK) {
                final BlockPos pos = ray.func_178782_a().func_177972_a(ray.field_178784_b);
                final IBlockState currentState = this.field_70170_p.func_180495_p(pos);
                if (currentState.func_177230_c().func_176200_f((IBlockAccess)this.field_70170_p, pos)) {
                    this.field_70170_p.func_175656_a(pos, TFBlocks.moonworm.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)ray.field_178784_b));
                }
            }
            if (ray.field_72308_g != null) {
                ray.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), 0.0f);
            }
            this.field_70170_p.func_72960_a((Entity)this, (byte)3);
            this.func_70106_y();
        }
    }
}
