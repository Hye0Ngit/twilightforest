// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import java.util.Iterator;
import java.util.List;
import twilightforest.util.TFDamageSources;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.Entity;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.block.BlockState;
import net.minecraft.state.Property;
import twilightforest.block.FireJetBlock;
import twilightforest.enums.FireJetVariant;
import twilightforest.block.TFBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class FireJetTileEntity extends TileEntity implements ITickableTileEntity
{
    private int counter;
    
    public FireJetTileEntity() {
        super((TileEntityType)TFTileEntities.FLAME_JET.get());
        this.counter = 0;
    }
    
    public void func_73660_a() {
        if (this.func_195044_w().func_177230_c() == TFBlocks.fire_jet.get() || this.func_195044_w().func_177230_c() == TFBlocks.encased_fire_jet.get()) {
            switch ((FireJetVariant)this.func_195044_w().func_177229_b((Property)FireJetBlock.STATE)) {
                case POPPING: {
                    this.tickPopping();
                    break;
                }
                case FLAME: {
                    this.tickFlame();
                    break;
                }
            }
        }
    }
    
    private void tickPopping() {
        if (++this.counter >= 80) {
            this.counter = 0;
            if (!this.field_145850_b.field_72995_K) {
                if (this.func_195044_w().func_177230_c() == TFBlocks.fire_jet.get() || this.func_195044_w().func_177230_c() == TFBlocks.encased_fire_jet.get()) {
                    this.field_145850_b.func_175656_a(this.field_174879_c, (BlockState)this.func_195044_w().func_206870_a((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.FLAME));
                }
                else {
                    this.field_145850_b.func_217377_a(this.field_174879_c, false);
                }
            }
        }
        else if (this.counter % 20 == 0) {
            for (int i = 0; i < 8; ++i) {
                this.field_145850_b.func_195594_a((IParticleData)ParticleTypes.field_197595_F, this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 1.5, this.field_174879_c.func_177952_p() + 0.5, 0.0, 0.0, 0.0);
            }
            this.field_145850_b.func_184133_a((PlayerEntity)null, this.field_174879_c, TFSounds.JET_POP, SoundCategory.BLOCKS, 0.2f + this.field_145850_b.field_73012_v.nextFloat() * 0.2f, 0.9f + this.field_145850_b.field_73012_v.nextFloat() * 0.15f);
        }
    }
    
    private void tickFlame() {
        final double x = this.field_174879_c.func_177958_n();
        final double y = this.field_174879_c.func_177956_o();
        final double z = this.field_174879_c.func_177952_p();
        if (++this.counter > 60) {
            this.counter = 0;
            if (!this.field_145850_b.field_72995_K) {
                if (this.func_195044_w().func_177230_c() == TFBlocks.fire_jet.get() || this.func_195044_w().func_177230_c() == TFBlocks.encased_fire_jet.get()) {
                    this.field_145850_b.func_175656_a(this.field_174879_c, (BlockState)this.func_195044_w().func_206870_a((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.IDLE));
                }
                else {
                    this.field_145850_b.func_217377_a(this.field_174879_c, false);
                }
            }
        }
        if (this.field_145850_b.field_72995_K) {
            if (this.counter % 2 == 0) {
                this.field_145850_b.func_195594_a((IParticleData)ParticleTypes.field_197594_E, x + 0.5, y + 1.0, z + 0.5, 0.0, 0.0, 0.0);
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.LARGE_FLAME.get(), x + 0.5, y + 1.0, z + 0.5, 0.0, 0.5, 0.0);
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.LARGE_FLAME.get(), x - 0.5, y + 1.0, z + 0.5, 0.05, 0.5, 0.0);
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.LARGE_FLAME.get(), x + 0.5, y + 1.0, z - 0.5, 0.0, 0.5, 0.05);
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.LARGE_FLAME.get(), x + 1.5, y + 1.0, z + 0.5, -0.05, 0.5, 0.0);
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.LARGE_FLAME.get(), x + 0.5, y + 1.0, z + 1.5, 0.0, 0.5, -0.05);
            }
            if (this.counter % 4 == 0) {
                this.field_145850_b.func_184134_a(x + 0.5, y + 0.5, z + 0.5, TFSounds.JET_ACTIVE, SoundCategory.BLOCKS, 1.0f + this.field_145850_b.field_73012_v.nextFloat(), this.field_145850_b.field_73012_v.nextFloat() * 0.7f + 0.3f, false);
            }
            else if (this.counter == 1) {
                this.field_145850_b.func_184134_a(x + 0.5, y + 0.5, z + 0.5, TFSounds.JET_START, SoundCategory.BLOCKS, 1.0f + this.field_145850_b.field_73012_v.nextFloat(), this.field_145850_b.field_73012_v.nextFloat() * 0.7f + 0.3f, false);
            }
        }
        if (!this.field_145850_b.field_72995_K && this.counter % 5 == 0) {
            final List<Entity> entitiesInRange = this.field_145850_b.func_217357_a((Class)Entity.class, new AxisAlignedBB(this.field_174879_c.func_177982_a(-2, 0, -2), this.field_174879_c.func_177982_a(2, 4, 2)));
            for (final Entity entity : entitiesInRange) {
                if (!entity.func_230279_az_()) {
                    entity.func_70097_a(TFDamageSources.FIRE_JET, 2.0f);
                    entity.func_70015_d(15);
                }
            }
        }
    }
}
