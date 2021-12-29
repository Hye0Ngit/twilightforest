// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import java.util.List;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import twilightforest.network.TFPacketHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import twilightforest.network.PacketAnnihilateBlock;
import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFCastleMagic;
import twilightforest.block.TFBlocks;
import net.minecraft.block.state.IBlockState;
import java.util.Iterator;
import net.minecraft.init.SoundEvents;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFCubeOfAnnihilation extends EntityThrowable
{
    private boolean hasHitObstacle;
    
    public EntityTFCubeOfAnnihilation(final World world) {
        super(world);
        this.hasHitObstacle = false;
        this.func_70105_a(1.0f, 1.0f);
        this.field_70178_ae = true;
    }
    
    public EntityTFCubeOfAnnihilation(final World world, final EntityLivingBase thrower) {
        super(world, thrower);
        this.hasHitObstacle = false;
        this.func_70105_a(1.0f, 1.0f);
        this.field_70178_ae = true;
        this.func_184538_a((Entity)thrower, thrower.field_70125_A, thrower.field_70177_z, 0.0f, 1.5f, 1.0f);
    }
    
    protected float func_70185_h() {
        return 0.0f;
    }
    
    protected void func_70184_a(final RayTraceResult ray) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (ray.field_72308_g instanceof EntityLivingBase && ray.field_72308_g.func_70097_a(this.getDamageSource(), 10.0f)) {
            this.field_70173_aa += 60;
        }
        if (ray.func_178782_a() != null && !this.field_70170_p.func_175623_d(ray.func_178782_a())) {
            this.affectBlocksInAABB(this.func_174813_aQ().func_72314_b(0.20000000298023224, 0.20000000298023224, 0.20000000298023224));
        }
    }
    
    private DamageSource getDamageSource() {
        final EntityLivingBase thrower = this.func_85052_h();
        if (thrower instanceof EntityPlayer) {
            return DamageSource.func_76365_a((EntityPlayer)thrower);
        }
        if (thrower != null) {
            return DamageSource.func_76358_a(thrower);
        }
        return DamageSource.func_76356_a((Entity)this, (Entity)null);
    }
    
    private void affectBlocksInAABB(final AxisAlignedBB box) {
        for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
            final IBlockState state = this.field_70170_p.func_180495_p(pos);
            if (!state.func_177230_c().isAir(state, (IBlockAccess)this.field_70170_p, pos)) {
                if (this.canAnnihilate(pos, state)) {
                    this.field_70170_p.func_175698_g(pos);
                    this.func_184185_a(SoundEvents.field_187541_bC, 0.125f, this.field_70146_Z.nextFloat() * 0.25f + 0.75f);
                    this.sendAnnihilateBlockPacket(this.field_70170_p, pos);
                }
                else {
                    this.hasHitObstacle = true;
                }
            }
        }
    }
    
    private boolean canAnnihilate(final BlockPos pos, final IBlockState state) {
        final Block block = state.func_177230_c();
        return block == TFBlocks.deadrock || block == TFBlocks.castle_brick || (block == TFBlocks.castle_rune_brick && state.func_177229_b((IProperty)BlockTFCastleMagic.COLOR) != EnumDyeColor.PURPLE) || block == TFBlocks.force_field || block == TFBlocks.thorns || (block.func_149638_a((Entity)this) < 8.0f && state.func_185887_b(this.field_70170_p, pos) >= 0.0f);
    }
    
    private void sendAnnihilateBlockPacket(final World world, final BlockPos pos) {
        final IMessage message = (IMessage)new PacketAnnihilateBlock(pos);
        final NetworkRegistry.TargetPoint targetPoint = new NetworkRegistry.TargetPoint(world.field_73011_w.getDimension(), (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), 64.0);
        TFPacketHandler.CHANNEL.sendToAllAround(message, targetPoint);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() == null) {
                this.func_70106_y();
                return;
            }
            Vec3d destPoint = new Vec3d(this.func_85052_h().field_70165_t, this.func_85052_h().field_70163_u + this.func_85052_h().func_70047_e(), this.func_85052_h().field_70161_v);
            if (this.isReturning()) {
                final List<EntityLivingBase> list = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.func_174813_aQ().func_72317_d(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0));
                if (list.contains(this.func_85052_h())) {
                    this.func_70106_y();
                }
            }
            else {
                destPoint = destPoint.func_178787_e(this.func_85052_h().func_70040_Z().func_186678_a(16.0));
            }
            final Vec3d velocity = new Vec3d(this.field_70165_t - destPoint.field_72450_a, this.field_70163_u + this.field_70131_O / 2.0f - destPoint.field_72448_b, this.field_70161_v - destPoint.field_72449_c);
            this.field_70159_w -= velocity.field_72450_a;
            this.field_70181_x -= velocity.field_72448_b;
            this.field_70179_y -= velocity.field_72449_c;
            final float currentSpeed = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
            final float maxSpeed = 0.5f;
            if (currentSpeed > maxSpeed) {
                this.field_70159_w /= currentSpeed / maxSpeed;
                this.field_70181_x /= currentSpeed / maxSpeed;
                this.field_70179_y /= currentSpeed / maxSpeed;
            }
            else {
                final float slow = 0.5f;
                this.field_70159_w *= slow;
                this.field_70181_x *= slow;
                this.field_70179_y *= slow;
            }
            this.affectBlocksInAABB(this.func_174813_aQ().func_72314_b(0.20000000298023224, 0.20000000298023224, 0.20000000298023224));
        }
    }
    
    public void func_70106_y() {
        super.func_70106_y();
        final EntityLivingBase thrower = this.func_85052_h();
        if (thrower != null && thrower.func_184607_cu().func_77973_b() == TFItems.cube_of_annihilation) {
            thrower.func_184602_cy();
        }
    }
    
    private boolean isReturning() {
        if (this.hasHitObstacle || this.func_85052_h() == null || !(this.func_85052_h() instanceof EntityPlayer)) {
            return true;
        }
        final EntityPlayer player = (EntityPlayer)this.func_85052_h();
        return !player.func_184587_cr();
    }
}
