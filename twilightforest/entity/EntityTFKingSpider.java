// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntitySpider;

public class EntityTFKingSpider extends EntitySpider
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFKingSpider(final World world) {
        super(world);
        this.func_70105_a(1.6f, 1.6f);
    }
    
    protected void func_184651_r() {
        super.func_184651_r();
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0);
    }
    
    public float func_70603_bj() {
        return 2.0f;
    }
    
    public boolean func_70617_f_() {
        return false;
    }
    
    public IEntityLivingData func_180482_a(final DifficultyInstance difficulty, IEntityLivingData livingData) {
        livingData = super.func_180482_a(difficulty, livingData);
        final EntityTFSkeletonDruid druid = new EntityTFSkeletonDruid(this.field_70170_p);
        druid.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0f);
        druid.func_180482_a(difficulty, (IEntityLivingData)null);
        this.field_70170_p.func_72838_d((Entity)druid);
        Entity lastRider;
        for (lastRider = (Entity)this; !lastRider.func_184188_bt().isEmpty(); lastRider = lastRider.func_184188_bt().get(0)) {}
        druid.func_184220_m(lastRider);
        return livingData;
    }
    
    public double func_70042_X() {
        return this.field_70131_O * 0.75;
    }
    
    protected ResourceLocation func_184647_J() {
        return EntityTFKingSpider.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/king_spider");
    }
}
