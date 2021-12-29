// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import twilightforest.world.TFGenerationSettings;
import twilightforest.TFFeature;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.entity.monster.MonsterEntity;

public class PlateauBossEntity extends MonsterEntity
{
    private final ServerBossInfo bossInfo;
    
    public PlateauBossEntity(final EntityType<? extends PlateauBossEntity> type, final World world) {
        super((EntityType)type, world);
        this.bossInfo = new ServerBossInfo(this.func_145748_c_(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS);
        this.field_70728_aV = 647;
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_();
    }
    
    protected void func_184651_r() {
    }
    
    public void func_70636_d() {
        if (!this.field_70170_p.field_72995_K) {
            this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
        }
    }
    
    public boolean func_213397_c(final double p_213397_1_) {
        return false;
    }
    
    public void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) {
            if (!this.func_213394_dL()) {
                this.field_70170_p.func_175656_a(this.func_213384_dI(), ((Block)TFBlocks.boss_spawner_final_boss.get()).func_176223_P());
            }
            this.func_70106_y();
        }
        else {
            super.func_70623_bb();
        }
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            TFGenerationSettings.markStructureConquered(this.field_70170_p, new BlockPos((Vector3i)this.func_233580_cy_()), TFFeature.FINAL_CASTLE);
        }
    }
    
    public void func_200203_b(@Nullable final ITextComponent name) {
        super.func_200203_b(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }
    
    public void func_184178_b(final ServerPlayerEntity player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }
    
    public void func_184203_c(final ServerPlayerEntity player) {
        super.func_184203_c(player);
        this.bossInfo.func_186761_b(player);
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        final BlockPos home = this.func_213384_dI();
        compound.func_218657_a("Home", (INBT)this.func_70087_a(new double[] { home.func_177958_n(), home.func_177956_o(), home.func_177952_p() }));
        compound.func_74757_a("HasHome", this.func_213394_dL());
        super.func_213281_b(compound);
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        if (compound.func_150297_b("Home", 9)) {
            final ListNBT nbttaglist = compound.func_150295_c("Home", 6);
            final int hx = (int)nbttaglist.func_150309_d(0);
            final int hy = (int)nbttaglist.func_150309_d(1);
            final int hz = (int)nbttaglist.func_150309_d(2);
            this.func_213390_a(new BlockPos(hx, hy, hz), 30);
        }
        if (!compound.func_74767_n("HasHome")) {
            this.func_213394_dL();
        }
        if (this.func_145818_k_()) {
            this.bossInfo.func_186739_a(this.func_145748_c_());
        }
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
}
