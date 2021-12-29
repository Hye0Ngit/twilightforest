// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFFireJet;
import twilightforest.block.TFBlocks;
import twilightforest.enums.FireJetVariant;
import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFFlameJet extends TileEntity implements ITickable
{
    private int counter;
    private FireJetVariant nextVariant;
    
    public TileEntityTFFlameJet(final FireJetVariant variant) {
        this.counter = 0;
        this.nextVariant = variant;
    }
    
    public TileEntityTFFlameJet() {
        this.counter = 0;
    }
    
    public void func_73660_a() {
        final double x = this.field_174879_c.func_177958_n();
        final double y = this.field_174879_c.func_177956_o();
        final double z = this.field_174879_c.func_177952_p();
        if (++this.counter > 60) {
            this.counter = 0;
            if (!this.field_145850_b.field_72995_K && this.field_145850_b.func_180495_p(this.field_174879_c).func_177230_c() == TFBlocks.fire_jet) {
                this.field_145850_b.func_175656_a(this.field_174879_c, TFBlocks.fire_jet.func_176223_P().func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)this.nextVariant));
            }
        }
        if (this.field_145850_b.field_72995_K) {
            if (this.counter % 2 == 0) {
                this.field_145850_b.func_175688_a(EnumParticleTypes.SMOKE_LARGE, x + 0.5, y + 1.0, z + 0.5, 0.0, 0.0, 0.0, new int[0]);
                TwilightForestMod.proxy.spawnParticle(TFParticleType.LARGE_FLAME, x + 0.5, y + 1.0, z + 0.5, 0.0, 0.5, 0.0);
                TwilightForestMod.proxy.spawnParticle(TFParticleType.LARGE_FLAME, x - 0.5, y + 1.0, z + 0.5, 0.05, 0.5, 0.0);
                TwilightForestMod.proxy.spawnParticle(TFParticleType.LARGE_FLAME, x + 0.5, y + 1.0, z - 0.5, 0.0, 0.5, 0.05);
                TwilightForestMod.proxy.spawnParticle(TFParticleType.LARGE_FLAME, x + 1.5, y + 1.0, z + 0.5, -0.05, 0.5, 0.0);
                TwilightForestMod.proxy.spawnParticle(TFParticleType.LARGE_FLAME, x + 0.5, y + 1.0, z + 1.5, 0.0, 0.5, -0.05);
            }
            if (this.counter % 4 == 0) {
                this.field_145850_b.func_184134_a(x + 0.5, y + 0.5, z + 0.5, SoundEvents.field_187557_bK, SoundCategory.BLOCKS, 1.0f + this.field_145850_b.field_73012_v.nextFloat(), this.field_145850_b.field_73012_v.nextFloat() * 0.7f + 0.3f, false);
            }
            else if (this.counter == 1) {
                this.field_145850_b.func_184134_a(x + 0.5, y + 0.5, z + 0.5, SoundEvents.field_187649_bu, SoundCategory.BLOCKS, 1.0f + this.field_145850_b.field_73012_v.nextFloat(), this.field_145850_b.field_73012_v.nextFloat() * 0.7f + 0.3f, false);
            }
        }
        if (!this.field_145850_b.field_72995_K && this.counter % 5 == 0) {
            final List<Entity> entitiesInRange = this.field_145850_b.func_72872_a((Class)Entity.class, new AxisAlignedBB(this.field_174879_c.func_177982_a(-2, 0, -2), this.field_174879_c.func_177982_a(2, 4, 2)));
            for (final Entity entity : entitiesInRange) {
                if (!entity.func_70045_F()) {
                    entity.func_70097_a(DamageSource.field_76372_a, 2.0f);
                    entity.func_70015_d(15);
                }
            }
        }
    }
    
    public void func_145839_a(final NBTTagCompound compound) {
        super.func_145839_a(compound);
        this.nextVariant = FireJetVariant.values()[compound.func_74762_e("NextMeta")];
    }
    
    public NBTTagCompound func_189515_b(final NBTTagCompound compound) {
        super.func_189515_b(compound);
        compound.func_74768_a("NextMeta", this.nextVariant.ordinal());
        return compound;
    }
}
