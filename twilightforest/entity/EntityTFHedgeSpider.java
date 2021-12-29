// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.ai.EntityAITasks;
import twilightforest.TFFeature;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntitySpider;

public class EntityTFHedgeSpider extends EntitySpider
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFHedgeSpider(final World world) {
        super(world);
    }
    
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.field_75782_a.removeIf(t -> t.field_75733_a instanceof EntityAIAttackMelee);
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackMelee(this, 1.0, true) {
            protected double func_179512_a(final EntityLivingBase attackTarget) {
                return 4.0f + attackTarget.field_70130_N;
            }
        });
        this.field_70715_bh.field_75782_a.removeIf(t -> t.field_75731_b == 2 && t.field_75733_a instanceof EntityAINearestAttackableTarget);
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected boolean func_70814_o() {
        final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
        final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p) == TFFeature.HEDGE_MAZE || super.func_70814_o();
    }
    
    protected ResourceLocation func_184647_J() {
        return EntityTFHedgeSpider.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/hedge_spider");
    }
}
