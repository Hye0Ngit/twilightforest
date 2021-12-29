// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayer;
import javax.annotation.Nullable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.Entity;
import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;

public class EntityAITFFindEntityNearestPlayer extends EntityAIFindEntityNearestPlayer
{
    private final EntityLiving entityLiving;
    private final Predicate<Entity> predicate;
    private final EntityAINearestAttackableTarget.Sorter sorter;
    private EntityLivingBase entityTarget;
    
    public EntityAITFFindEntityNearestPlayer(final EntityLiving entityLivingIn) {
        super(entityLivingIn);
        this.entityLiving = entityLivingIn;
        this.predicate = (Predicate<Entity>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity entity) {
                if (!(entity instanceof EntityPlayer)) {
                    return false;
                }
                if (((EntityPlayer)entity).field_71075_bZ.field_75102_a) {
                    return false;
                }
                final double maxRange = EntityAITFFindEntityNearestPlayer.access$000(EntityAITFFindEntityNearestPlayer.this);
                return entity.func_70032_d((Entity)EntityAITFFindEntityNearestPlayer.this.entityLiving) <= maxRange && EntityAITarget.func_179445_a(EntityAITFFindEntityNearestPlayer.this.entityLiving, (EntityLivingBase)entity, false, false);
            }
        };
        this.sorter = new EntityAINearestAttackableTarget.Sorter((Entity)entityLivingIn);
    }
    
    public boolean func_75250_a() {
        final double maxRange = this.func_179431_f();
        final List<EntityPlayer> list = this.entityLiving.field_70170_p.func_175647_a((Class)EntityPlayer.class, this.entityLiving.func_174813_aQ().func_186662_g(maxRange), (Predicate)this.predicate);
        Collections.sort(list, (Comparator<? super EntityPlayer>)this.sorter);
        if (list.isEmpty()) {
            return false;
        }
        this.entityTarget = (EntityLivingBase)list.get(0);
        return true;
    }
    
    public void func_75249_e() {
        this.entityLiving.func_70624_b(this.entityTarget);
    }
    
    public void func_75251_c() {
        this.entityTarget = null;
        super.func_75251_c();
    }
    
    static /* synthetic */ double access$000(final EntityAITFFindEntityNearestPlayer x0) {
        return x0.func_179431_f();
    }
}
