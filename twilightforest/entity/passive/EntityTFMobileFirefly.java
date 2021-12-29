// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.TwilightForestMod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.passive.EntityAmbientCreature;

public class EntityTFMobileFirefly extends EntityAmbientCreature
{
    private BlockPos spawnPosition;
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFMobileFirefly(final World world) {
        super(world);
        this.func_70105_a(0.5f, 0.5f);
    }
    
    protected float func_70599_aP() {
        return 0.1f;
    }
    
    protected float func_70647_i() {
        return super.func_70647_i() * 0.95f;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return SoundEvents.field_187743_y;
    }
    
    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187742_x;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected void func_82167_n(final Entity entity) {
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(6.0);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70181_x *= 0.6000000238418579;
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.spawnPosition != null && (!this.field_70170_p.func_175623_d(this.spawnPosition) || this.spawnPosition.func_177956_o() < 1)) {
            this.spawnPosition = null;
        }
        if (this.spawnPosition == null || this.field_70146_Z.nextInt(30) == 0 || this.spawnPosition.func_177954_c((double)(int)this.field_70165_t, (double)(int)this.field_70163_u, (double)(int)this.field_70161_v) < 4.0) {
            this.spawnPosition = new BlockPos((int)this.field_70165_t + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7), (int)this.field_70163_u + this.field_70146_Z.nextInt(6) - 2, (int)this.field_70161_v + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7));
        }
        final double d0 = this.spawnPosition.func_177958_n() + 0.5 - this.field_70165_t;
        final double d2 = this.spawnPosition.func_177956_o() + 0.1 - this.field_70163_u;
        final double d3 = this.spawnPosition.func_177952_p() + 0.5 - this.field_70161_v;
        this.field_70159_w += (Math.signum(d0) * 0.5 - this.field_70159_w) * 0.10000000149011612;
        this.field_70181_x += (Math.signum(d2) * 0.699999988079071 - this.field_70181_x) * 0.10000000149011612;
        this.field_70179_y += (Math.signum(d3) * 0.5 - this.field_70179_y) * 0.10000000149011612;
        final float f = (float)(MathHelper.func_181159_b(this.field_70179_y, this.field_70159_w) * 57.29577951308232) - 90.0f;
        final float f2 = MathHelper.func_76142_g(f - this.field_70177_z);
        this.field_191988_bg = 0.5f;
        this.field_70177_z += f2;
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    public void func_180430_e(final float dist, final float mult) {
    }
    
    protected void func_184231_a(final double y, final boolean onGround, final IBlockState state, final BlockPos pos) {
    }
    
    public boolean func_145773_az() {
        return true;
    }
    
    public boolean func_70601_bi() {
        final BlockPos blockpos = new BlockPos(this.field_70165_t, this.func_174813_aQ().field_72338_b, this.field_70161_v);
        return blockpos.func_177956_o() < this.field_70170_p.func_181545_F() && !this.field_70146_Z.nextBoolean() && this.field_70170_p.func_175671_l(blockpos) <= this.field_70146_Z.nextInt(4) && super.func_70601_bi();
    }
    
    @SideOnly(Side.CLIENT)
    public int func_70070_b() {
        return 15728880;
    }
    
    public float getGlowBrightness() {
        return (float)Math.sin(this.field_70173_aa / 7.0) + 1.0f;
    }
    
    protected ResourceLocation func_184647_J() {
        return EntityTFMobileFirefly.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/mobile_firefly");
    }
}
