// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.MultiPartEntityPart;
import twilightforest.item.TFItems;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import java.util.Iterator;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFChainBlock extends EntityThrowable implements IEntityMultiPart, IEntityAdditionalSpawnData
{
    private static final int MAX_SMASH = 12;
    private static final int MAX_CHAIN = 16;
    private EnumHand hand;
    private boolean isReturning;
    private int blocksSmashed;
    private double velX;
    private double velY;
    private double velZ;
    public final EntityTFGoblinChain chain1;
    public final EntityTFGoblinChain chain2;
    public final EntityTFGoblinChain chain3;
    public final EntityTFGoblinChain chain4;
    public final EntityTFGoblinChain chain5;
    private final Entity[] partsArray;
    
    public EntityTFChainBlock(final World world) {
        super(world);
        this.hand = EnumHand.MAIN_HAND;
        this.isReturning = false;
        this.blocksSmashed = 0;
        this.chain1 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.chain2 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.chain3 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.chain4 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.chain5 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.partsArray = new Entity[] { (Entity)this.chain1, (Entity)this.chain2, (Entity)this.chain3, (Entity)this.chain4, (Entity)this.chain5 };
        this.func_70105_a(0.6f, 0.6f);
    }
    
    public EntityTFChainBlock(final World world, final EntityLivingBase thrower, final EnumHand hand) {
        super(world, thrower);
        this.hand = EnumHand.MAIN_HAND;
        this.isReturning = false;
        this.blocksSmashed = 0;
        this.chain1 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.chain2 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.chain3 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.chain4 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.chain5 = new EntityTFGoblinChain((IEntityMultiPart)this);
        this.partsArray = new Entity[] { (Entity)this.chain1, (Entity)this.chain2, (Entity)this.chain3, (Entity)this.chain4, (Entity)this.chain5 };
        this.func_70105_a(0.6f, 0.6f);
        this.isReturning = false;
        this.hand = hand;
        this.func_184538_a((Entity)thrower, thrower.field_70125_A, thrower.field_70177_z, 0.0f, 1.5f, 1.0f);
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
    
    protected void func_70184_a(final RayTraceResult ray) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (ray.field_72308_g instanceof EntityLivingBase && ray.field_72308_g != this.func_85052_h() && ray.field_72308_g.func_70097_a(this.getDamageSource(), 10.0f)) {
            this.field_70173_aa += 60;
        }
        if (ray.func_178782_a() != null && !this.field_70170_p.func_175623_d(ray.func_178782_a())) {
            if (!this.isReturning) {
                this.func_184185_a(SoundEvents.field_187689_f, 0.125f, this.field_70146_Z.nextFloat());
            }
            if (this.blocksSmashed < 12) {
                if (this.field_70170_p.func_180495_p(ray.func_178782_a()).func_185887_b(this.field_70170_p, ray.func_178782_a()) > 0.3f) {
                    final double bounce = 0.6;
                    this.velX *= bounce;
                    this.velY *= bounce;
                    this.velZ *= bounce;
                    switch (ray.field_178784_b) {
                        case DOWN: {
                            if (this.velY > 0.0) {
                                this.velY *= -bounce;
                                break;
                            }
                            break;
                        }
                        case UP: {
                            if (this.velY < 0.0) {
                                this.velY *= -bounce;
                                break;
                            }
                            break;
                        }
                        case NORTH: {
                            if (this.velZ > 0.0) {
                                this.velZ *= -bounce;
                                break;
                            }
                            break;
                        }
                        case SOUTH: {
                            if (this.velZ < 0.0) {
                                this.velZ *= -bounce;
                                break;
                            }
                            break;
                        }
                        case WEST: {
                            if (this.velX > 0.0) {
                                this.velX *= -bounce;
                                break;
                            }
                            break;
                        }
                        case EAST: {
                            if (this.velX < 0.0) {
                                this.velX *= -bounce;
                                break;
                            }
                            break;
                        }
                    }
                }
                this.affectBlocksInAABB(this.func_174813_aQ());
            }
            this.isReturning = true;
            if (this.blocksSmashed > 12 && this.field_70173_aa < 60) {
                this.field_70173_aa += 60;
            }
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
            final Block block = state.func_177230_c();
            if (!block.isAir(state, (IBlockAccess)this.field_70170_p, pos) && block.func_149638_a((Entity)this) < 7.0f && state.func_185887_b(this.field_70170_p, pos) >= 0.0f && block.canEntityDestroy(state, (IBlockAccess)this.field_70170_p, pos, (Entity)this)) {
                if (this.func_85052_h() instanceof EntityPlayer) {
                    final EntityPlayer player = (EntityPlayer)this.func_85052_h();
                    if (block.canHarvestBlock((IBlockAccess)this.field_70170_p, pos, player)) {
                        block.func_180657_a(this.field_70170_p, player, pos, state, this.field_70170_p.func_175625_s(pos), player.func_184586_b(this.hand));
                    }
                }
                this.field_70170_p.func_175655_b(pos, false);
                ++this.blocksSmashed;
            }
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.chain1.func_70071_h_();
            this.chain2.func_70071_h_();
            this.chain3.func_70071_h_();
            this.chain4.func_70071_h_();
            this.chain5.func_70071_h_();
            if (this.func_85052_h() != null) {
                final Vec3d handVec = this.func_85052_h().func_70040_Z().func_178785_b((this.hand == EnumHand.MAIN_HAND) ? -0.4f : 0.4f);
                final double sx = this.func_85052_h().field_70165_t + handVec.field_72450_a;
                final double sy = this.func_85052_h().field_70163_u + handVec.field_72448_b - 0.4000000059604645 + this.func_85052_h().func_70047_e();
                final double sz = this.func_85052_h().field_70161_v + handVec.field_72449_c;
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
        else if (this.func_85052_h() == null) {
            this.func_70106_y();
        }
        else {
            final double distToPlayer = this.func_70011_f(this.func_85052_h().field_70165_t, this.func_85052_h().field_70163_u + this.func_85052_h().func_70047_e(), this.func_85052_h().field_70161_v);
            if (!this.isReturning && distToPlayer > 16.0) {
                this.isReturning = true;
            }
            if (this.isReturning) {
                if (distToPlayer < 2.0) {
                    this.func_70106_y();
                }
                final EntityLivingBase returnTo = this.func_85052_h();
                final Vec3d back = new Vec3d(returnTo.field_70165_t, returnTo.field_70163_u + returnTo.func_70047_e(), returnTo.field_70161_v).func_178788_d(this.func_174791_d()).func_72432_b();
                final float age = Math.min(this.field_70173_aa * 0.03f, 1.0f);
                this.field_70159_w = this.velX * (1.0 - age) + back.field_72450_a * 2.0 * age;
                this.field_70181_x = this.velY * (1.0 - age) + back.field_72448_b * 2.0 * age - this.func_70185_h();
                this.field_70179_y = this.velZ * (1.0 - age) + back.field_72449_c * 2.0 * age;
            }
        }
    }
    
    public void func_70106_y() {
        super.func_70106_y();
        final EntityLivingBase thrower = this.func_85052_h();
        if (thrower != null && thrower.func_184607_cu().func_77973_b() == TFItems.block_and_chain) {
            thrower.func_184602_cy();
        }
    }
    
    public World func_82194_d() {
        return this.field_70170_p;
    }
    
    public boolean func_70965_a(final MultiPartEntityPart part, final DamageSource source, final float damage) {
        return false;
    }
    
    public Entity[] func_70021_al() {
        return this.partsArray;
    }
    
    public void writeSpawnData(final ByteBuf buffer) {
        buffer.writeInt((this.func_85052_h() != null) ? this.func_85052_h().func_145782_y() : -1);
        buffer.writeBoolean(this.hand == EnumHand.MAIN_HAND);
    }
    
    public void readSpawnData(final ByteBuf additionalData) {
        final Entity e = this.field_70170_p.func_73045_a(additionalData.readInt());
        if (e instanceof EntityLivingBase) {
            this.field_70192_c = (EntityLivingBase)e;
        }
        this.hand = (additionalData.readBoolean() ? EnumHand.MAIN_HAND : EnumHand.OFF_HAND);
    }
}
