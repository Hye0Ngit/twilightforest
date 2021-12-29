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
    
    public void func_145845_h() {
        if (++this.counter > 60) {
            this.counter = 0;
            if (!this.field_145850_b.field_72995_K && this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e) == TFBlocks.fireJet) {
                this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d, this.field_145849_e, TFBlocks.fireJet, this.nextMeta, 3);
            }
            this.func_145843_s();
        }
        else if (this.counter % 2 == 0) {
            this.field_145850_b.func_72869_a("largesmoke", this.field_145851_c + 0.5, this.field_145848_d + 1.0, this.field_145849_e + 0.5, 0.0, 0.0, 0.0);
            TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "largeflame", this.field_145851_c + 0.5, this.field_145848_d + 1.0, this.field_145849_e + 0.5, 0.0, 0.5, 0.0);
            TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "largeflame", this.field_145851_c - 0.5, this.field_145848_d + 1.0, this.field_145849_e + 0.5, 0.05, 0.5, 0.0);
            TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "largeflame", this.field_145851_c + 0.5, this.field_145848_d + 1.0, this.field_145849_e - 0.5, 0.0, 0.5, 0.05);
            TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "largeflame", this.field_145851_c + 1.5, this.field_145848_d + 1.0, this.field_145849_e + 0.5, -0.05, 0.5, 0.0);
            TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "largeflame", this.field_145851_c + 0.5, this.field_145848_d + 1.0, this.field_145849_e + 1.5, 0.0, 0.5, -0.05);
        }
        if (this.counter % 4 == 0) {
            this.field_145850_b.func_72908_a(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5, "mob.ghast.fireball", 1.0f + this.field_145850_b.field_73012_v.nextFloat(), this.field_145850_b.field_73012_v.nextFloat() * 0.7f + 0.3f);
        }
        else if (this.counter == 1) {
            this.field_145850_b.func_72908_a(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5, "fire.ignite", 1.0f + this.field_145850_b.field_73012_v.nextFloat(), this.field_145850_b.field_73012_v.nextFloat() * 0.7f + 0.3f);
        }
        if (!this.field_145850_b.field_72995_K && this.counter % 5 == 0) {
            final List<Entity> entitiesInRange = this.field_145850_b.func_72872_a((Class)Entity.class, AxisAlignedBB.func_72330_a((double)(this.field_145851_c - 2), (double)this.field_145848_d, (double)(this.field_145849_e - 2), (double)(this.field_145851_c + 2), (double)(this.field_145848_d + 4), (double)(this.field_145849_e + 2)));
            for (final Entity entity : entitiesInRange) {
                if (!entity.func_70045_F()) {
                    entity.func_70097_a(DamageSource.field_76372_a, 2.0f);
                    entity.func_70015_d(15);
                }
            }
        }
    }
    
    public void func_145839_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_145839_a(par1NBTTagCompound);
        this.nextMeta = par1NBTTagCompound.func_74762_e("NextMeta");
    }
    
    public void func_145841_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_145841_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("NextMeta", this.nextMeta);
    }
}
