// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import twilightforest.block.TFBlocks;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFPoppingJet extends TileEntity
{
    int counter;
    int nextMeta;
    
    public TileEntityTFPoppingJet() {
        this(10);
    }
    
    public TileEntityTFPoppingJet(final int parNextMeta) {
        this.counter = 0;
        this.nextMeta = parNextMeta;
    }
    
    public void func_70316_g() {
        if (++this.counter >= 80) {
            this.counter = 0;
            if (!this.field_70331_k.field_72995_K && this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n) == TFBlocks.fireJet.field_71990_ca) {
                this.field_70331_k.func_72832_d(this.field_70329_l, this.field_70330_m, this.field_70327_n, TFBlocks.fireJet.field_71990_ca, this.nextMeta, 3);
            }
            this.func_70313_j();
        }
        else if (this.counter % 20 == 0) {
            this.field_70331_k.func_72869_a("lava", this.field_70329_l + 0.5, this.field_70330_m + 1.5, this.field_70327_n + 0.5, 0.0, 0.0, 0.0);
            this.field_70331_k.func_72908_a((double)this.field_70329_l, (double)this.field_70330_m, (double)this.field_70327_n, "liquid.lavapop", 0.2f + this.field_70331_k.field_73012_v.nextFloat() * 0.2f, 0.9f + this.field_70331_k.field_73012_v.nextFloat() * 0.15f);
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
