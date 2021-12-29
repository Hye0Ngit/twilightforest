// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import twilightforest.item.TFItems;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import java.util.Iterator;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IBlockReader;
import twilightforest.TFSounds;
import net.minecraft.util.math.BlockRayTraceResult;
import twilightforest.util.TFDamageSources;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.projectile.ThrowableEntity;

public class ChainBlockEntity extends ThrowableEntity implements IEntityAdditionalSpawnData
{
    private static final int MAX_SMASH = 12;
    private static final int MAX_CHAIN = 16;
    private static DataParameter<Boolean> HAND;
    private boolean isReturning;
    private int blocksSmashed;
    private double velX;
    private double velY;
    private double velZ;
    public final ChainEntity chain1;
    public final ChainEntity chain2;
    public final ChainEntity chain3;
    public final ChainEntity chain4;
    public final ChainEntity chain5;
    private BlockChainGoblinEntity.MultipartGenericsAreDumb[] partsArray;
    
    public ChainBlockEntity(final EntityType<? extends ChainBlockEntity> type, final World world) {
        super((EntityType)type, world);
        this.isReturning = false;
        this.blocksSmashed = 0;
        this.chain1 = new ChainEntity((Entity)this);
        this.chain2 = new ChainEntity((Entity)this);
        this.chain3 = new ChainEntity((Entity)this);
        this.chain4 = new ChainEntity((Entity)this);
        this.chain5 = new ChainEntity((Entity)this);
        this.partsArray = new BlockChainGoblinEntity.MultipartGenericsAreDumb[] { this.chain1, this.chain2, this.chain3, this.chain4, this.chain5 };
    }
    
    public ChainBlockEntity(final EntityType<? extends ChainBlockEntity> type, final World world, final LivingEntity thrower, final Hand hand) {
        super((EntityType)type, thrower, world);
        this.isReturning = false;
        this.blocksSmashed = 0;
        this.isReturning = false;
        this.setHand(hand);
        this.chain1 = new ChainEntity((Entity)this);
        this.chain2 = new ChainEntity((Entity)this);
        this.chain3 = new ChainEntity((Entity)this);
        this.chain4 = new ChainEntity((Entity)this);
        this.chain5 = new ChainEntity((Entity)this);
        this.partsArray = new BlockChainGoblinEntity.MultipartGenericsAreDumb[] { this.chain1, this.chain2, this.chain3, this.chain4, this.chain5 };
        this.func_234612_a_((Entity)thrower, thrower.field_70125_A, thrower.field_70177_z, 0.0f, 1.5f, 1.0f);
    }
    
    private void setHand(final Hand hand) {
        this.field_70180_af.func_187227_b((DataParameter)ChainBlockEntity.HAND, (Object)(hand == Hand.MAIN_HAND));
    }
    
    public Hand getHand() {
        return this.field_70180_af.func_187225_a((DataParameter)ChainBlockEntity.HAND) ? Hand.MAIN_HAND : Hand.OFF_HAND;
    }
    
    public void func_70186_c(final double x, final double y, final double z, final float speed, final float accuracy) {
        super.func_70186_c(x, y, z, speed, accuracy);
        this.velX = this.func_213322_ci().func_82615_a();
        this.velY = this.func_213322_ci().func_82617_b();
        this.velZ = this.func_213322_ci().func_82616_c();
    }
    
    protected float func_70185_h() {
        return 0.05f;
    }
    
    protected void func_70227_a(final RayTraceResult ray) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (ray instanceof EntityRayTraceResult) {
            final EntityRayTraceResult entityRay = (EntityRayTraceResult)ray;
            if (entityRay.func_216348_a() instanceof LivingEntity && entityRay.func_216348_a() != this.func_234616_v_() && entityRay.func_216348_a().func_70097_a(TFDamageSources.SPIKED((Entity)this, (LivingEntity)this.func_234616_v_()), 10.0f)) {
                this.field_70173_aa += 60;
            }
        }
        if (ray instanceof BlockRayTraceResult) {
            final BlockRayTraceResult blockRay = (BlockRayTraceResult)ray;
            if (blockRay.func_216350_a() != null && !this.field_70170_p.func_175623_d(blockRay.func_216350_a())) {
                if (!this.isReturning) {
                    this.func_184185_a(TFSounds.BLOCKCHAIN_COLLIDE, 0.125f, this.field_70146_Z.nextFloat());
                }
                if (this.blocksSmashed < 12) {
                    if (this.field_70170_p.func_180495_p(blockRay.func_216350_a()).func_185887_b((IBlockReader)this.field_70170_p, blockRay.func_216350_a()) > 0.3f) {
                        final double bounce = 0.6;
                        this.velX *= bounce;
                        this.velY *= bounce;
                        this.velZ *= bounce;
                        switch (blockRay.func_216354_b()) {
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
    }
    
    private void affectBlocksInAABB(final AxisAlignedBB box) {
        for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
            final BlockState state = this.field_70170_p.func_180495_p(pos);
            final Block block = state.func_177230_c();
            if (!block.isAir(state, (IBlockReader)this.field_70170_p, pos) && block.getExplosionResistance(state, (IBlockReader)this.field_70170_p, pos, (Explosion)null) < 7.0f && state.func_185887_b((IBlockReader)this.field_70170_p, pos) >= 0.0f && block.canEntityDestroy(state, (IBlockReader)this.field_70170_p, pos, (Entity)this) && this.func_234616_v_() instanceof PlayerEntity) {
                final PlayerEntity player = (PlayerEntity)this.func_234616_v_();
                if (MinecraftForge.EVENT_BUS.post((Event)new BlockEvent.BreakEvent(this.field_70170_p, pos, state, player)) || !block.canHarvestBlock(state, (IBlockReader)this.field_70170_p, pos, player)) {
                    continue;
                }
                block.func_180657_a(this.field_70170_p, player, pos, state, this.field_70170_p.func_175625_s(pos), player.func_184586_b(this.getHand()));
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
            if (this.func_234616_v_() != null) {
                final Vector3d handVec = this.func_234616_v_().func_70040_Z().func_178785_b((this.getHand() == Hand.MAIN_HAND) ? -0.4f : 0.4f);
                final double sx = this.func_234616_v_().func_226277_ct_() + handVec.field_72450_a;
                final double sy = this.func_234616_v_().func_226278_cu_() + handVec.field_72448_b - 0.4000000059604645 + this.func_234616_v_().func_70047_e();
                final double sz = this.func_234616_v_().func_226281_cx_() + handVec.field_72449_c;
                final double ox = sx - this.func_226277_ct_();
                final double oy = sy - this.func_226278_cu_() - 0.25;
                final double oz = sz - this.func_226281_cx_();
                this.chain1.func_70107_b(sx - ox * 0.05, sy - oy * 0.05, sz - oz * 0.05);
                this.chain2.func_70107_b(sx - ox * 0.25, sy - oy * 0.25, sz - oz * 0.25);
                this.chain3.func_70107_b(sx - ox * 0.45, sy - oy * 0.45, sz - oz * 0.45);
                this.chain4.func_70107_b(sx - ox * 0.65, sy - oy * 0.65, sz - oz * 0.65);
                this.chain5.func_70107_b(sx - ox * 0.85, sy - oy * 0.85, sz - oz * 0.85);
            }
        }
        else if (this.func_234616_v_() == null) {
            this.func_70106_y();
        }
        else {
            final double distToPlayer = this.func_70032_d(this.func_234616_v_());
            if (!this.isReturning && distToPlayer > 16.0) {
                this.isReturning = true;
            }
            if (this.isReturning) {
                if (distToPlayer < 2.0) {
                    this.func_70106_y();
                }
                final LivingEntity returnTo = (LivingEntity)this.func_234616_v_();
                final Vector3d back = new Vector3d(returnTo.func_226277_ct_(), returnTo.func_226278_cu_() + returnTo.func_70047_e(), returnTo.func_226281_cx_()).func_178788_d(this.func_213303_ch()).func_72432_b();
                final float age = Math.min(this.field_70173_aa * 0.03f, 1.0f);
                this.func_213317_d(new Vector3d(this.velX * (1.0 - age) + back.field_72450_a * 2.0 * age, this.velY * (1.0 - age) + back.field_72448_b * 2.0 * age - this.func_70185_h(), this.velZ * (1.0 - age) + back.field_72449_c * 2.0 * age));
            }
        }
    }
    
    protected void func_70088_a() {
        this.field_70180_af.func_187214_a((DataParameter)ChainBlockEntity.HAND, (Object)true);
    }
    
    public void func_70106_y() {
        super.func_70106_y();
        final LivingEntity thrower = (LivingEntity)this.func_234616_v_();
        if (thrower != null && thrower.func_184607_cu().func_77973_b() == TFItems.block_and_chain.get()) {
            thrower.func_184602_cy();
        }
    }
    
    public void writeSpawnData(final PacketBuffer buffer) {
        buffer.writeInt((this.func_234616_v_() != null) ? this.func_234616_v_().func_145782_y() : -1);
        buffer.writeBoolean(this.getHand() == Hand.MAIN_HAND);
    }
    
    public void readSpawnData(final PacketBuffer additionalData) {
        final Entity e = this.field_70170_p.func_73045_a(additionalData.readInt());
        if (e instanceof LivingEntity) {
            this.func_212361_a(e);
        }
        this.setHand(additionalData.readBoolean() ? Hand.MAIN_HAND : Hand.OFF_HAND);
    }
    
    public IPacket<?> func_213297_N() {
        return (IPacket<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
    
    static {
        ChainBlockEntity.HAND = (DataParameter<Boolean>)EntityDataManager.func_187226_a((Class)ChainBlockEntity.class, DataSerializers.field_187198_h);
    }
}
