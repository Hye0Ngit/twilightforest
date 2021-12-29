// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.world.ChunkProviderTwilightForest;
import twilightforest.TFFeature;
import twilightforest.world.TFWorldChunkManager;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.item.Item;
import twilightforest.item.TFItems;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import twilightforest.entity.ai.EntityAITFYetiRampage;
import twilightforest.entity.ai.EntityAIStayNearHome;
import net.minecraft.entity.EntityCreature;
import twilightforest.entity.ai.EntityAITFThrowRider;
import net.minecraft.entity.ai.EntityAIBase;
import twilightforest.entity.ai.EntityAITFYetiTired;
import net.minecraft.world.World;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFYetiAlpha extends EntityMob implements IRangedAttackMob
{
    private static final int RAMPAGE_FLAG = 16;
    private static final int TIRED_FLAG = 17;
    private int collisionCounter;
    private boolean canRampage;
    
    public EntityTFYetiAlpha(final World par1World) {
        super(par1World);
        this.func_70105_a(3.8f, 5.0f);
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITFYetiTired(this, 100));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFThrowRider((EntityCreature)this, 1.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIStayNearHome((EntityCreature)this, 2.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITFYetiRampage(this, 10, 180));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 40, 40, 40.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 2.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, false));
        this.field_70728_aV = 317;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, (Object)0);
        this.field_70180_af.func_75682_a(17, (Object)0);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.38);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0);
    }
    
    public void func_70636_d() {
        if (this.field_70153_n != null && this.field_70153_n.func_70093_af()) {
            this.field_70153_n.func_70095_a(false);
        }
        super.func_70636_d();
        if (this.field_70153_n != null) {
            this.func_70671_ap().func_75651_a(this.field_70153_n, 100.0f, 100.0f);
        }
        if (this.field_70132_H) {
            ++this.collisionCounter;
        }
        if (this.collisionCounter >= 15) {
            if (!this.field_70170_p.field_72995_K) {
                this.destroyBlocksInAABB(this.field_70121_D);
            }
            this.collisionCounter = 0;
        }
        if (this.isRampaging()) {
            final float rotation = this.field_70173_aa / 10.0f;
            for (int i = 0; i < 20; ++i) {
                this.addSnowEffect(rotation + i * 50, i + rotation);
            }
            this.field_70721_aZ += (float)0.6;
        }
        if (this.isTired()) {
            for (int j = 0; j < 20; ++j) {
                this.field_70170_p.func_72869_a("splash", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 0.5, this.field_70163_u + this.func_70047_e(), this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 0.5, (double)((this.field_70146_Z.nextFloat() - 0.5f) * 0.75f), 0.0, (double)((this.field_70146_Z.nextFloat() - 0.5f) * 0.75f));
            }
        }
    }
    
    private void addSnowEffect(final float rotation, final float hgt) {
        final double px = 3.0 * Math.cos(rotation);
        final double py = hgt % 5.0f;
        final double pz = 3.0 * Math.sin(rotation);
        TwilightForestMod.proxy.spawnParticle(this.field_70170_p, "snowstuff", this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        if (super.func_70085_c(par1EntityPlayer)) {
            return true;
        }
        if (!this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n == par1EntityPlayer)) {
            par1EntityPlayer.func_70078_a((Entity)this);
            return true;
        }
        return false;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        if (this.field_70153_n == null && par1Entity.field_70154_o == null) {
            par1Entity.func_70078_a((Entity)this);
        }
        return super.func_70652_k(par1Entity);
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        if (!this.canRampage && !this.isTired() && par1DamageSource.func_76352_a()) {
            return false;
        }
        final boolean success = super.func_70097_a(par1DamageSource, par2);
        this.canRampage = true;
        return success;
    }
    
    protected void func_70628_a(final boolean flag, final int looting) {
        final Item fur = this.func_146068_u();
        if (fur != null) {
            for (int drops = 6 + this.field_70146_Z.nextInt(6 + looting), d = 0; d < drops; ++d) {
                this.func_145779_a(fur, 1);
            }
        }
        final Item bombs = TFItems.iceBomb;
        for (int drops2 = 6 + this.field_70146_Z.nextInt(6 + looting), d2 = 0; d2 < drops2; ++d2) {
            this.func_145779_a(bombs, 1);
        }
    }
    
    protected Item func_146068_u() {
        return TFItems.alphaFur;
    }
    
    public void func_70043_V() {
        if (this.field_70153_n != null) {
            final Vec3 riderPos = this.getRiderPosition();
            this.field_70153_n.func_70107_b(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
        }
    }
    
    public double func_70042_X() {
        return 5.75;
    }
    
    public Vec3 getRiderPosition() {
        if (this.field_70153_n != null) {
            final float distance = 0.4f;
            final double var1 = Math.cos((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double var2 = Math.sin((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return Vec3.func_72443_a(this.field_70165_t + var1, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + var2);
        }
        return Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }
    
    public boolean canRiderInteract() {
        return true;
    }
    
    public boolean destroyBlocksInAABB(final AxisAlignedBB par1AxisAlignedBB) {
        final int minX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72340_a);
        final int minY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72338_b);
        final int minZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72339_c);
        final int maxX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72336_d);
        final int maxY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72337_e);
        final int maxZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72334_f);
        boolean wasBlocked = false;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    final Block currentID = this.field_70170_p.func_147439_a(dx, dy, dz);
                    if (currentID != Blocks.field_150350_a) {
                        final int currentMeta = this.field_70170_p.func_72805_g(dx, dy, dz);
                        if (currentID != Blocks.field_150343_Z && currentID != Blocks.field_150377_bs && currentID != Blocks.field_150357_h) {
                            this.field_70170_p.func_147465_d(dx, dy, dz, Blocks.field_150350_a, 0, 2);
                            this.field_70170_p.func_72926_e(2001, dx, dy, dz, Block.func_149682_b(currentID) + (currentMeta << 12));
                        }
                        else {
                            wasBlocked = true;
                        }
                    }
                }
            }
        }
        return wasBlocked;
    }
    
    public void makeRandomBlockFall() {
        this.makeRandomBlockFall(30);
    }
    
    private void makeRandomBlockFall(final int range) {
        final int bx = MathHelper.func_76128_c(this.field_70165_t) + this.func_70681_au().nextInt(range) - this.func_70681_au().nextInt(range);
        final int bz = MathHelper.func_76128_c(this.field_70161_v) + this.func_70681_au().nextInt(range) - this.func_70681_au().nextInt(range);
        final int by = MathHelper.func_76128_c(this.field_70163_u + this.func_70047_e());
        this.makeBlockFallAbove(bx, bz, by);
    }
    
    private void makeBlockFallAbove(final int bx, final int bz, final int by) {
        if (this.field_70170_p.func_147437_c(bx, by, bz)) {
            for (int i = 1; i < 30; ++i) {
                if (!this.field_70170_p.func_147437_c(bx, by + i, bz)) {
                    this.makeBlockFall(bx, by + i, bz);
                    break;
                }
            }
        }
    }
    
    public void makeNearbyBlockFall() {
        this.makeRandomBlockFall(15);
    }
    
    public void makeBlockAboveTargetFall() {
        if (this.func_70638_az() != null) {
            final int bx = MathHelper.func_76128_c(this.func_70638_az().field_70165_t);
            final int bz = MathHelper.func_76128_c(this.func_70638_az().field_70161_v);
            final int by = MathHelper.func_76128_c(this.func_70638_az().field_70163_u + this.func_70638_az().func_70047_e());
            this.makeBlockFallAbove(bx, bz, by);
        }
    }
    
    private void makeBlockFall(final int bx, final int by, final int bz) {
        final Block currentID = this.field_70170_p.func_147439_a(bx, by, bz);
        final int currentMeta = this.field_70170_p.func_72805_g(bx, by, bz);
        this.field_70170_p.func_147449_b(bx, by, bz, Blocks.field_150403_cj);
        this.field_70170_p.func_72926_e(2001, bx, by, bz, Block.func_149682_b(currentID) + (currentMeta << 12));
        final EntityTFFallingIce ice = new EntityTFFallingIce(this.field_70170_p, bx, by - 3, bz);
        this.field_70170_p.func_72838_d((Entity)ice);
    }
    
    public void func_82196_d(final EntityLivingBase target, final float par2) {
        if (!this.canRampage) {
            final EntityTFIceBomb ice = new EntityTFIceBomb(this.field_70170_p, (EntityLivingBase)this);
            final double d0 = target.field_70165_t - this.field_70165_t;
            final double d2 = target.field_70163_u + target.func_70047_e() - 1.100000023841858 - target.field_70163_u;
            final double d3 = target.field_70161_v - this.field_70161_v;
            final float f1 = MathHelper.func_76133_a(d0 * d0 + d3 * d3) * 0.2f;
            ice.func_70186_c(d0, d2 + f1, d3, 0.75f, 12.0f);
            this.func_85030_a("random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.field_70170_p.func_72838_d((Entity)ice);
        }
    }
    
    public boolean func_70692_ba() {
        return false;
    }
    
    public boolean canRampage() {
        return this.canRampage;
    }
    
    public void setRampaging(final boolean par1) {
        this.func_70096_w().func_75692_b(16, (Object)(byte)(par1 ? 1 : 0));
    }
    
    public boolean isRampaging() {
        return this.func_70096_w().func_75683_a(16) == 1;
    }
    
    public void setTired(final boolean par1) {
        this.func_70096_w().func_75692_b(17, (Object)(byte)(par1 ? 1 : 0));
        this.canRampage = false;
    }
    
    public boolean isTired() {
        return this.func_70096_w().func_75683_a(17) == 1;
    }
    
    protected void func_70069_a(final float par1) {
        super.func_70069_a(par1);
        if (this.isRampaging()) {
            this.func_85030_a("random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            final int i = MathHelper.func_76128_c(this.field_70165_t);
            final int j = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224 - this.field_70129_M);
            final int k = MathHelper.func_76128_c(this.field_70161_v);
            this.field_70170_p.func_72926_e(2006, i, j, k, 20);
            this.field_70170_p.func_72926_e(2006, i, j, k, 30);
            if (!this.field_70170_p.field_72995_K) {
                this.hitNearbyEntities();
            }
        }
    }
    
    private void hitNearbyEntities() {
        final ArrayList<Entity> nearby = new ArrayList<Entity>(this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(5.0, 0.0, 5.0)));
        for (final Entity entity : nearby) {
            if (entity instanceof EntityLivingBase) {
                final boolean hit = entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 5.0f);
                if (!hit) {
                    continue;
                }
                final Entity entity2 = entity;
                entity2.field_70181_x += 0.4000000059604645;
            }
        }
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightProgressYeti);
        }
        if (!this.field_70170_p.field_72995_K) {
            final int dx = MathHelper.func_76128_c(this.field_70165_t);
            final int dy = MathHelper.func_76128_c(this.field_70163_u);
            final int dz = MathHelper.func_76128_c(this.field_70161_v);
            if (this.field_70170_p.field_73011_w instanceof WorldProviderTwilightForest) {
                final ChunkProviderTwilightForest chunkProvider = ((WorldProviderTwilightForest)this.field_70170_p.field_73011_w).getChunkProvider();
                final TFFeature nearbyFeature = ((TFWorldChunkManager)this.field_70170_p.field_73011_w.field_76578_c).getFeatureAt(dx, dz, this.field_70170_p);
                if (nearbyFeature == TFFeature.yetiCave) {
                    chunkProvider.setStructureConquered(dx, dy, dz, true);
                }
            }
        }
    }
    
    public void func_70014_b(final NBTTagCompound nbttagcompound) {
        final ChunkCoordinates home = this.func_110172_bL();
        nbttagcompound.func_74782_a("Home", (NBTBase)this.func_70087_a(new double[] { home.field_71574_a, home.field_71572_b, home.field_71573_c }));
        nbttagcompound.func_74757_a("HasHome", this.func_110175_bO());
        super.func_70014_b(nbttagcompound);
    }
    
    public void func_70037_a(final NBTTagCompound nbttagcompound) {
        super.func_70037_a(nbttagcompound);
        if (nbttagcompound.func_150297_b("Home", 9)) {
            final NBTTagList nbttaglist = nbttagcompound.func_150295_c("Home", 6);
            final int hx = (int)nbttaglist.func_150309_d(0);
            final int hy = (int)nbttaglist.func_150309_d(1);
            final int hz = (int)nbttaglist.func_150309_d(2);
            this.func_110171_b(hx, hy, hz, 30);
        }
        if (!nbttagcompound.func_74767_n("HasHome")) {
            this.func_110177_bN();
        }
    }
}
