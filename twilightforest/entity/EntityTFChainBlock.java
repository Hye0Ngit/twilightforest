// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.boss.EntityDragonPart;
import java.util.List;
import net.minecraft.util.Vec3;
import twilightforest.item.ItemTFChainBlock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFChainBlock extends EntityThrowable implements IEntityMultiPart
{
    private static final int MAX_SMASH = 12;
    private static final int MAX_CHAIN = 16;
    private boolean isReturning;
    private int blocksSmashed;
    private double velX;
    private double velY;
    private double velZ;
    private boolean isAttached;
    private EntityLivingBase attachedTo;
    public EntityTFGoblinChain chain1;
    public EntityTFGoblinChain chain2;
    public EntityTFGoblinChain chain3;
    public EntityTFGoblinChain chain4;
    public EntityTFGoblinChain chain5;
    public Entity[] partsArray;
    
    public EntityTFChainBlock(final World par1World) {
        super(par1World);
        this.isReturning = false;
        this.blocksSmashed = 0;
        this.func_70105_a(0.6f, 0.6f);
        this.partsArray = new Entity[] { this.chain1 = new EntityTFGoblinChain((Entity)this), this.chain2 = new EntityTFGoblinChain((Entity)this), this.chain3 = new EntityTFGoblinChain((Entity)this), this.chain4 = new EntityTFGoblinChain((Entity)this), this.chain5 = new EntityTFGoblinChain((Entity)this) };
    }
    
    public EntityTFChainBlock(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.isReturning = false;
        this.blocksSmashed = 0;
    }
    
    public EntityTFChainBlock(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.isReturning = false;
        this.blocksSmashed = 0;
        this.func_70105_a(0.6f, 0.6f);
        this.isReturning = false;
    }
    
    public void func_70186_c(final double x, final double y, final double z, final float speed, final float accuracy) {
        super.func_70186_c(x, y, z, speed, accuracy);
        this.velX = this.field_70159_w;
        this.velY = this.field_70181_x;
        this.velZ = this.field_70179_y;
    }
    
    protected float func_70185_h() {
        return 0.05f;
    }
    
    protected void func_70184_a(final MovingObjectPosition mop) {
        if (mop.field_72308_g != null && mop.field_72308_g instanceof EntityLivingBase && mop.field_72308_g != this.func_85052_h() && mop.field_72308_g.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.func_85052_h()), 10.0f)) {
            this.field_70173_aa += 60;
        }
        if (!this.field_70170_p.func_147437_c(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d)) {
            if (!this.isReturning) {
                this.field_70170_p.func_72956_a((Entity)this, "random.anvil_land", 0.125f, this.field_70146_Z.nextFloat());
            }
            if (!this.field_70170_p.field_72995_K && this.blocksSmashed < 12) {
                if (this.field_70170_p.func_147439_a(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d).func_149712_f(this.field_70170_p, mop.field_72311_b, mop.field_72312_c, mop.field_72309_d) > 0.3f) {
                    final double bounce = 0.6;
                    this.velX *= bounce;
                    this.velY *= bounce;
                    this.velZ *= bounce;
                    switch (mop.field_72310_e) {
                        case 0: {
                            if (this.velY > 0.0) {
                                this.velY *= -bounce;
                                break;
                            }
                            break;
                        }
                        case 1: {
                            if (this.velY < 0.0) {
                                this.velY *= -bounce;
                                break;
                            }
                            break;
                        }
                        case 2: {
                            if (this.velZ > 0.0) {
                                this.velZ *= -bounce;
                                break;
                            }
                            break;
                        }
                        case 3: {
                            if (this.velZ < 0.0) {
                                this.velZ *= -bounce;
                                break;
                            }
                            break;
                        }
                        case 4: {
                            if (this.velX > 0.0) {
                                this.velX *= -bounce;
                                break;
                            }
                            break;
                        }
                        case 5: {
                            if (this.velX < 0.0) {
                                this.velX *= -bounce;
                                break;
                            }
                            break;
                        }
                    }
                }
                this.affectBlocksInAABB(this.field_70121_D, this.func_85052_h());
            }
            if (!this.field_70170_p.field_72995_K) {
                this.isReturning = true;
            }
            if (this.blocksSmashed > 12 && this.field_70173_aa < 60) {
                this.field_70173_aa += 60;
            }
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
                    if (block != Blocks.field_150350_a && block.func_149638_a((Entity)this) < 7.0f && block.func_149712_f(this.field_70170_p, dx, dy, dz) >= 0.0f) {
                        if (entity != null && entity instanceof EntityPlayer) {
                            final EntityPlayer player = (EntityPlayer)entity;
                            if (block.canHarvestBlock(player, currentMeta)) {
                                block.func_149636_a(this.field_70170_p, player, dx, dy, dz, currentMeta);
                            }
                        }
                        this.field_70170_p.func_147468_f(dx, dy, dz);
                        this.field_70170_p.func_72926_e(2001, dx, dy, dz, Block.func_149682_b(block) + (currentMeta << 12));
                        ++this.blocksSmashed;
                        hitBlock = true;
                    }
                }
            }
        }
        return hitBlock;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.chain1 != null) {
            this.chain1.func_70071_h_();
            this.chain2.func_70071_h_();
            this.chain3.func_70071_h_();
            this.chain4.func_70071_h_();
            this.chain5.func_70071_h_();
        }
        if (this.func_85052_h() == null && !this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
        if (this.func_85052_h() != null) {
            final float distToPlayer = this.func_70032_d((Entity)this.func_85052_h());
            if (!this.isReturning && distToPlayer > 16.0f) {
                this.isReturning = true;
            }
            if (this.isReturning && distToPlayer < 1.0f) {
                if (this.func_85052_h() instanceof EntityPlayer) {
                    ItemTFChainBlock.setChainAsReturned((EntityPlayer)this.func_85052_h());
                }
                this.func_70106_y();
            }
        }
        if (this.isReturning && !this.field_70170_p.field_72995_K && this.func_85052_h() != null) {
            final EntityLivingBase returnTo = this.func_85052_h();
            final Vec3 back = Vec3.func_72443_a(returnTo.field_70165_t - this.field_70165_t, returnTo.field_70163_u + returnTo.func_70047_e() - 1.200000023841858 - this.field_70163_u, returnTo.field_70161_v - this.field_70161_v).func_72432_b();
            final float age = Math.min(this.field_70173_aa * 0.03f, 1.0f);
            this.field_70159_w = this.velX * (1.0 - age) + back.field_72450_a * 2.0 * age;
            this.field_70181_x = this.velY * (1.0 - age) + back.field_72448_b * 2.0 * age - this.func_70185_h();
            this.field_70179_y = this.velZ * (1.0 - age) + back.field_72449_c * 2.0 * age;
        }
        if (this.field_70170_p.field_72995_K && !this.isAttached) {
            final List nearbyEntities = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72321_a(-this.field_70159_w, -this.field_70181_x, -this.field_70179_y).func_72314_b(2.0, 2.0, 2.0));
            for (int i = 0; i < nearbyEntities.size(); ++i) {
                final Entity nearby = nearbyEntities.get(i);
                if (nearby instanceof EntityPlayer) {
                    this.attachedTo = (EntityLivingBase)nearby;
                }
            }
            this.isAttached = true;
        }
        if (this.attachedTo != null) {
            final Vec3 handVec = this.attachedTo.func_70040_Z();
            handVec.func_72442_b(-0.4f);
            final double sx = this.attachedTo.field_70165_t + handVec.field_72450_a;
            final double sy = this.attachedTo.field_70163_u + handVec.field_72448_b - 0.6000000238418579;
            final double sz = this.attachedTo.field_70161_v + handVec.field_72449_c;
            final double ox = sx - this.field_70165_t;
            final double oy = sy - this.field_70163_u - 0.25;
            final double oz = sz - this.field_70161_v;
            this.chain1.func_70107_b(sx - ox * 0.05, sy - oy * 0.05, sz - oz * 0.05);
            this.chain2.func_70107_b(sx - ox * 0.25, sy - oy * 0.25, sz - oz * 0.25);
            this.chain3.func_70107_b(sx - ox * 0.45, sy - oy * 0.45, sz - oz * 0.45);
            this.chain4.func_70107_b(sx - ox * 0.65, sy - oy * 0.65, sz - oz * 0.65);
            this.chain5.func_70107_b(sx - ox * 0.85, sy - oy * 0.85, sz - oz * 0.85);
        }
    }
    
    protected float func_70182_d() {
        return 1.5f;
    }
    
    public World func_82194_d() {
        return this.field_70170_p;
    }
    
    public boolean func_70965_a(final EntityDragonPart p_70965_1_, final DamageSource p_70965_2_, final float p_70965_3_) {
        return false;
    }
    
    public Entity[] func_70021_al() {
        return this.partsArray;
    }
}
