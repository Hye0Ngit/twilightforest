// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import java.util.List;
import net.minecraft.util.Vec3;
import twilightforest.item.ItemTFCubeOfAnnihilation;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import twilightforest.TwilightForestMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import twilightforest.TFGenericPacketHandler;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFCubeOfAnnihilation extends EntityThrowable
{
    boolean hasHitObstacle;
    
    public EntityTFCubeOfAnnihilation(final World par1World) {
        super(par1World);
        this.hasHitObstacle = false;
        this.func_70105_a(1.1f, 1.0f);
        this.field_70178_ae = true;
    }
    
    public EntityTFCubeOfAnnihilation(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.hasHitObstacle = false;
        this.func_70105_a(1.0f, 1.0f);
        this.field_70178_ae = true;
    }
    
    public EntityTFCubeOfAnnihilation(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.hasHitObstacle = false;
        this.func_70105_a(1.0f, 1.0f);
        this.field_70178_ae = true;
    }
    
    protected float func_70185_h() {
        return 0.0f;
    }
    
    protected void func_70184_a(final MovingObjectPosition mop) {
        if (mop.field_72308_g != null && mop.field_72308_g instanceof EntityLivingBase && mop.field_72308_g.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 10.0f)) {
            this.field_70173_aa += 60;
        }
        if (!this.field_70170_p.func_147437_c(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d) && !this.field_70170_p.field_72995_K) {
            this.affectBlocksInAABB(this.field_70121_D.func_72314_b(0.20000000298023224, 0.20000000298023224, 0.20000000298023224), this.func_85052_h());
        }
    }
    
    private boolean affectBlocksInAABB(final AxisAlignedBB par1AxisAlignedBB, final EntityLivingBase entity) {
        final int minX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72340_a);
        final int minY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72338_b);
        final int minZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72339_c);
        final int maxX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72336_d);
        final int maxY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72337_e);
        final int maxZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72334_f);
        boolean hitBlock = false;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    final Block block = this.field_70170_p.func_147439_a(dx, dy, dz);
                    final int currentMeta = this.field_70170_p.func_72805_g(dx, dy, dz);
                    if (block != Blocks.field_150350_a) {
                        if (this.canAnnihilate(dx, dy, dz, block, currentMeta)) {
                            this.field_70170_p.func_147468_f(dx, dy, dz);
                            this.field_70170_p.func_72956_a((Entity)this, "random.fizz", 0.125f, this.field_70146_Z.nextFloat() * 0.25f + 0.75f);
                            this.sendAnnihilateBlockPacket(this.field_70170_p, dx, dy, dz);
                        }
                        else {
                            this.hasHitObstacle = true;
                        }
                        hitBlock = true;
                    }
                }
            }
        }
        return hitBlock;
    }
    
    private boolean canAnnihilate(final int dx, final int dy, final int dz, final Block block, final int meta) {
        return block == TFBlocks.deadrock || block == TFBlocks.castleBlock || (block == TFBlocks.castleMagic && meta != 3) || block == TFBlocks.forceField || block == TFBlocks.thorns || (block.func_149638_a((Entity)this) < 8.0f && block.func_149712_f(this.field_70170_p, dx, dy, dz) >= 0.0f);
    }
    
    private void sendAnnihilateBlockPacket(final World world, final int x, final int y, final int z) {
        final FMLProxyPacket message = TFGenericPacketHandler.makeAnnihilateBlockPacket(x, y, z);
        final NetworkRegistry.TargetPoint targetPoint = new NetworkRegistry.TargetPoint(world.field_73011_w.field_76574_g, (double)x, (double)y, (double)z, 64.0);
        TwilightForestMod.genericChannel.sendToAllAround(message, targetPoint);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() == null) {
                this.func_70106_y();
                return;
            }
            if (this.isReturning()) {
                final List list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0, 1.0, 1.0));
                if (list.contains(this.func_85052_h()) && !this.field_70170_p.field_72995_K) {
                    if (this.func_85052_h() instanceof EntityPlayer) {
                        ItemTFCubeOfAnnihilation.setCubeAsReturned((EntityPlayer)this.func_85052_h());
                    }
                    this.func_70106_y();
                }
            }
            final Vec3 destPoint = Vec3.func_72443_a(this.func_85052_h().field_70165_t, this.func_85052_h().field_70163_u + this.func_85052_h().func_70047_e(), this.func_85052_h().field_70161_v);
            if (!this.isReturning()) {
                final Vec3 look = this.func_85052_h().func_70040_Z();
                final float dist = 16.0f;
                final Vec3 vec3 = look;
                vec3.field_72450_a *= dist;
                final Vec3 vec4 = look;
                vec4.field_72448_b *= dist;
                final Vec3 vec5 = look;
                vec5.field_72449_c *= dist;
                final Vec3 vec6 = destPoint;
                vec6.field_72450_a += look.field_72450_a;
                final Vec3 vec7 = destPoint;
                vec7.field_72448_b += look.field_72448_b;
                final Vec3 vec8 = destPoint;
                vec8.field_72449_c += look.field_72449_c;
            }
            final Vec3 velocity = Vec3.func_72443_a(this.field_70165_t - destPoint.field_72450_a, this.field_70163_u + this.field_70131_O / 2.0f - destPoint.field_72448_b, this.field_70161_v - destPoint.field_72449_c);
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
            this.affectBlocksInAABB(this.field_70121_D.func_72314_b(0.20000000298023224, 0.20000000298023224, 0.20000000298023224), this.func_85052_h());
        }
    }
    
    public boolean isReturning() {
        if (this.hasHitObstacle || this.func_85052_h() == null || !(this.func_85052_h() instanceof EntityPlayer)) {
            return true;
        }
        final EntityPlayer player = (EntityPlayer)this.func_85052_h();
        return !player.func_71039_bw();
    }
    
    protected float func_70182_d() {
        return 1.5f;
    }
}
