// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.DamageSource;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.Entity;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFFlameJet extends TileEntity
{
    int counter;
    private int nextMeta;
    
    public TileEntityTFFlameJet() {
        this(8);
    }
    
    public TileEntityTFFlameJet(final int parNextMeta) {
        this.counter = 0;
        this.nextMeta = parNextMeta;
    }
    
    public void func_70316_g() {
        if (++this.counter > 60) {
            this.counter = 0;
            if (!this.field_70331_k.field_72995_K && this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n) == TFBlocks.fireJet.field_71990_ca) {
                this.field_70331_k.func_72832_d(this.field_70329_l, this.field_70330_m, this.field_70327_n, TFBlocks.fireJet.field_71990_ca, this.nextMeta, 3);
            }
            this.func_70313_j();
        }
        else if (this.counter % 2 == 0) {
            this.field_70331_k.func_72869_a("largesmoke", this.field_70329_l + 0.5, this.field_70330_m + 1.0, this.field_70327_n + 0.5, 0.0, 0.0, 0.0);
            TwilightForestMod.proxy.spawnParticle("largeflame", this.field_70329_l + 0.5, this.field_70330_m + 1.0, this.field_70327_n + 0.5, 0.0, 0.5, 0.0);
            TwilightForestMod.proxy.spawnParticle("largeflame", this.field_70329_l - 0.5, this.field_70330_m + 1.0, this.field_70327_n + 0.5, 0.05, 0.5, 0.0);
            TwilightForestMod.proxy.spawnParticle("largeflame", this.field_70329_l + 0.5, this.field_70330_m + 1.0, this.field_70327_n - 0.5, 0.0, 0.5, 0.05);
            TwilightForestMod.proxy.spawnParticle("largeflame", this.field_70329_l + 1.5, this.field_70330_m + 1.0, this.field_70327_n + 0.5, -0.05, 0.5, 0.0);
            TwilightForestMod.proxy.spawnParticle("largeflame", this.field_70329_l + 0.5, this.field_70330_m + 1.0, this.field_70327_n + 1.5, 0.0, 0.5, -0.05);
        }
        if (this.counter % 4 == 0) {
            this.field_70331_k.func_72908_a(this.field_70329_l + 0.5, this.field_70330_m + 0.5, this.field_70327_n + 0.5, "mob.ghast.fireball", 1.0f + this.field_70331_k.field_73012_v.nextFloat(), this.field_70331_k.field_73012_v.nextFloat() * 0.7f + 0.3f);
        }
        else if (this.counter == 1) {
            this.field_70331_k.func_72908_a(this.field_70329_l + 0.5, this.field_70330_m + 0.5, this.field_70327_n + 0.5, "fire.ignite", 1.0f + this.field_70331_k.field_73012_v.nextFloat(), this.field_70331_k.field_73012_v.nextFloat() * 0.7f + 0.3f);
        }
        if (!this.field_70331_k.field_72995_K && this.counter % 5 == 0) {
            final List entitiesInRange = this.field_70331_k.func_72872_a((Class)Entity.class, AxisAlignedBB.func_72332_a().func_72299_a((double)(this.field_70329_l - 2), (double)this.field_70330_m, (double)(this.field_70327_n - 2), (double)(this.field_70329_l + 2), (double)(this.field_70330_m + 4), (double)(this.field_70327_n + 2)));
            for (final Entity entity : entitiesInRange) {
                if (!entity.func_70045_F()) {
                    entity.func_70097_a(DamageSource.field_76372_a, 2);
                    entity.func_70015_d(15);
                }
            }
        }
    }
    
    public void func_70307_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70307_a(par1NBTTagCompound);
        this.nextMeta = par1NBTTagCompound.func_74762_e("NextMeta");
    }
    
    public void func_70310_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70310_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("NextMeta", this.nextMeta);
    }
}
