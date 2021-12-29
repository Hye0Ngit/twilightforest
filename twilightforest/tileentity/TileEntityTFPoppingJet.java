// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFFireJet;
import twilightforest.block.TFBlocks;
import twilightforest.enums.FireJetVariant;
import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFPoppingJet extends TileEntity implements ITickable
{
    private int counter;
    private FireJetVariant nextVariant;
    
    public TileEntityTFPoppingJet(final FireJetVariant variant) {
        this.counter = 0;
        this.nextVariant = variant;
    }
    
    public TileEntityTFPoppingJet() {
        this.counter = 0;
    }
    
    public void func_73660_a() {
        if (++this.counter >= 80) {
            this.counter = 0;
            if (!this.field_145850_b.field_72995_K && this.field_145850_b.func_180495_p(this.field_174879_c).func_177230_c() == TFBlocks.fire_jet) {
                this.field_145850_b.func_180501_a(this.field_174879_c, TFBlocks.fire_jet.func_176223_P().func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)this.nextVariant), 3);
            }
        }
        else if (this.counter % 20 == 0) {
            for (int i = 0; i < 8; ++i) {
                this.field_145850_b.func_175688_a(EnumParticleTypes.LAVA, this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 1.5, this.field_174879_c.func_177952_p() + 0.5, 0.0, 0.0, 0.0, new int[0]);
            }
            this.field_145850_b.func_184133_a((EntityPlayer)null, this.field_174879_c, SoundEvents.field_187662_cZ, SoundCategory.BLOCKS, 0.2f + this.field_145850_b.field_73012_v.nextFloat() * 0.2f, 0.9f + this.field_145850_b.field_73012_v.nextFloat() * 0.15f);
        }
    }
    
    public void func_145839_a(final NBTTagCompound compound) {
        super.func_145839_a(compound);
        this.nextVariant = FireJetVariant.values()[compound.func_74762_e("NextMeta")];
    }
    
    public NBTTagCompound func_189515_b(final NBTTagCompound compound) {
        final NBTTagCompound ret = super.func_189515_b(compound);
        ret.func_74768_a("NextMeta", this.nextVariant.ordinal());
        return ret;
    }
}
