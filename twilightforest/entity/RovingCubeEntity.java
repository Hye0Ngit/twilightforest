// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import twilightforest.entity.ai.CubeCenterOnSymbolGoal;
import net.minecraft.entity.ai.goal.Goal;
import twilightforest.entity.ai.CubeMoveToRedstoneSymbolsGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;

public class RovingCubeEntity extends MonsterEntity
{
    public boolean hasFoundSymbol;
    public int symbolX;
    public int symbolY;
    public int symbolZ;
    
    public RovingCubeEntity(final EntityType<? extends RovingCubeEntity> type, final World world) {
        super((EntityType)type, world);
        this.hasFoundSymbol = false;
        this.symbolX = 0;
        this.symbolY = 0;
        this.symbolZ = 0;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new CubeMoveToRedstoneSymbolsGoal(this, 1.0));
        this.field_70714_bg.func_75776_a(1, (Goal)new CubeCenterOnSymbolGoal(this, 1.0));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 10.0).func_233815_a_(Attributes.field_233821_d_, 0.23000000417232513).func_233815_a_(Attributes.field_233823_f_, 5.0);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K) {
            for (int i = 0; i < 3; ++i) {
                final float px = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.75f;
                final float py = this.func_70047_e() - 0.25f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.75f;
                final float pz = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.75f;
                this.field_70170_p.func_195594_a((IParticleData)TFParticleType.ANNIHILATE.get(), this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
            }
        }
    }
}
