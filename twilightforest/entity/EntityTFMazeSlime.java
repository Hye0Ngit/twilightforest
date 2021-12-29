// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.util.MathHelper;
import twilightforest.block.TFBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntitySlime;

public class EntityTFMazeSlime extends EntitySlime
{
    private String slimeParticleString;
    
    public EntityTFMazeSlime(final World par1World) {
        super(par1World);
        this.field_70750_az = "/mods/twilightforest/textures/model/mazeslime.png";
        this.func_70799_a(1 << 1 + this.field_70146_Z.nextInt(2));
    }
    
    protected EntitySlime func_70802_j() {
        return new EntityTFMazeSlime(this.field_70170_p);
    }
    
    public void func_70799_a(final int par1) {
        super.func_70799_a(par1);
        this.field_70728_aV = par1 + 3;
    }
    
    public boolean func_70601_bi() {
        return this.field_70170_p.field_73013_u > 0 && this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D) && this.isValidLightLevel();
    }
    
    public int func_70667_aM() {
        final int size = this.func_70809_q();
        return 2 * size * size;
    }
    
    protected boolean func_70800_m() {
        return true;
    }
    
    protected int func_70805_n() {
        return super.func_70805_n() + 3;
    }
    
    protected String func_70801_i() {
        if (this.slimeParticleString == null) {
            this.slimeParticleString = "tilecrack_" + TFBlocks.mazestone.field_71990_ca + "_1";
        }
        return this.slimeParticleString;
    }
    
    protected boolean isValidLightLevel() {
        final int var1 = MathHelper.func_76128_c(this.field_70165_t);
        final int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
        final int var3 = MathHelper.func_76128_c(this.field_70161_v);
        if (this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, var1, var2, var3) > this.field_70146_Z.nextInt(32)) {
            return false;
        }
        int var4 = this.field_70170_p.func_72957_l(var1, var2, var3);
        if (this.field_70170_p.func_72911_I()) {
            final int var5 = this.field_70170_p.field_73008_k;
            this.field_70170_p.field_73008_k = 10;
            var4 = this.field_70170_p.func_72957_l(var1, var2, var3);
            this.field_70170_p.field_73008_k = var5;
        }
        return var4 <= this.field_70146_Z.nextInt(8);
    }
    
    protected float func_70599_aP() {
        return 0.1f * this.func_70809_q();
    }
    
    protected void func_70600_l(final int par1) {
        this.func_70025_b(TFItems.charmOfKeeping1.field_77779_bT, 1);
    }
}
