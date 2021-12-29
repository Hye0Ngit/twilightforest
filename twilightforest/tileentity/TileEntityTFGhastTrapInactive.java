// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import java.util.Iterator;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import twilightforest.block.TFBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.ArrayList;
import twilightforest.entity.EntityTFMiniGhast;
import java.util.List;
import java.util.Random;
import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFGhastTrapInactive extends TileEntity implements ITickable
{
    private int counter;
    private final Random rand;
    private final List<EntityTFMiniGhast> dyingGhasts;
    
    public TileEntityTFGhastTrapInactive() {
        this.rand = new Random();
        this.dyingGhasts = new ArrayList<EntityTFMiniGhast>();
    }
    
    public void func_73660_a() {
        final AxisAlignedBB aabb = new AxisAlignedBB(this.field_174879_c).func_72314_b(10.0, 16.0, 10.0);
        final List<EntityTFMiniGhast> nearbyGhasts = this.field_145850_b.func_72872_a((Class)EntityTFMiniGhast.class, aabb);
        for (final EntityTFMiniGhast ghast : nearbyGhasts) {
            if (ghast.field_70725_aQ > 0) {
                this.makeParticlesTo((Entity)ghast);
                if (this.dyingGhasts.contains(ghast)) {
                    continue;
                }
                this.dyingGhasts.add(ghast);
            }
        }
        final int chargeLevel = Math.min(3, this.dyingGhasts.size());
        ++this.counter;
        if (this.field_145850_b.field_72995_K) {
            if (this.counter % 20 == 0 && nearbyGhasts.size() > 0) {
                final EntityTFMiniGhast highlight = nearbyGhasts.get(this.rand.nextInt(nearbyGhasts.size()));
                this.makeParticlesTo((Entity)highlight);
            }
            if (chargeLevel >= 1 && this.counter % 10 == 0) {
                TFBlocks.tower_device.sparkle(this.field_145850_b, this.field_174879_c);
                this.field_145850_b.func_184134_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 1.5, this.field_174879_c.func_177952_p() + 0.5, SoundEvents.field_187682_dG, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
            }
            if (chargeLevel >= 2) {
                this.field_145850_b.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, this.field_174879_c.func_177958_n() + 0.1 + this.rand.nextFloat() * 0.8, this.field_174879_c.func_177956_o() + 1.05, this.field_174879_c.func_177952_p() + 0.1 + this.rand.nextFloat() * 0.8, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, 0.0, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, new int[0]);
                if (this.counter % 10 == 0) {
                    this.field_145850_b.func_184134_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 1.5, this.field_174879_c.func_177952_p() + 0.5, SoundEvents.field_187682_dG, SoundCategory.BLOCKS, 1.2f, 0.8f, false);
                }
            }
            if (chargeLevel >= 3) {
                this.field_145850_b.func_175688_a(EnumParticleTypes.SMOKE_LARGE, this.field_174879_c.func_177958_n() + 0.1 + this.rand.nextFloat() * 0.8, this.field_174879_c.func_177956_o() + 1.05, this.field_174879_c.func_177952_p() + 0.1 + this.rand.nextFloat() * 0.8, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, 0.05, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, new int[0]);
                TFBlocks.tower_device.sparkle(this.field_145850_b, this.field_174879_c);
                if (this.counter % 5 == 0) {
                    this.field_145850_b.func_184134_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 1.5, this.field_174879_c.func_177952_p() + 0.5, SoundEvents.field_187682_dG, SoundCategory.BLOCKS, 1.5f, 2.0f, false);
                }
            }
        }
    }
    
    private void makeParticlesTo(final Entity highlight) {
        final double sx = this.field_174879_c.func_177958_n() + 0.5;
        final double sy = this.field_174879_c.func_177956_o() + 1.0;
        final double sz = this.field_174879_c.func_177952_p() + 0.5;
        final double dx = sx - highlight.field_70165_t;
        final double dy = sy - highlight.field_70163_u - highlight.func_70047_e();
        final double dz = sz - highlight.field_70161_v;
        for (int i = 0; i < 5; ++i) {
            TwilightForestMod.proxy.spawnParticle(TFParticleType.GHAST_TRAP, sx, sy, sz, -dx, -dy, -dz);
        }
    }
    
    public boolean isCharged() {
        return this.dyingGhasts.size() >= 3;
    }
}
