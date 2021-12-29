// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.SharedMonsterAttributes;
import twilightforest.entity.ai.EntityAICubeCenterOnSymbol;
import net.minecraft.entity.ai.EntityAIBase;
import twilightforest.entity.ai.EntityAICubeMoveToRedstoneSymbols;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFRovingCube extends EntityMob
{
    public static final ResourceLocation LOOT_TABLE;
    public boolean hasFoundSymbol;
    public int symbolX;
    public int symbolY;
    public int symbolZ;
    
    public EntityTFRovingCube(final World world) {
        super(world);
        this.hasFoundSymbol = false;
        this.symbolX = 0;
        this.symbolY = 0;
        this.symbolZ = 0;
        this.func_70105_a(1.2f, 2.1f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAICubeMoveToRedstoneSymbols(this, 1.0));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAICubeCenterOnSymbol(this, 1.0));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K) {
            for (int i = 0; i < 3; ++i) {
                final float px = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.75f;
                final float py = this.func_70047_e() - 0.25f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.75f;
                final float pz = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.75f;
                TwilightForestMod.proxy.spawnParticle(TFParticleType.ANNIHILATE, this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
            }
        }
    }
    
    protected ResourceLocation func_184647_J() {
        return EntityTFRovingCube.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/roving_cube");
    }
}
