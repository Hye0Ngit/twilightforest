// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.init.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.particle.Particle;

@SideOnly(Side.CLIENT)
public class ParticleGhastTear extends Particle
{
    public ParticleGhastTear(final World world, final double x, final double y, final double z, final Item item) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.func_187117_a(Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178082_a(item));
        final float field_70552_h = 1.0f;
        this.field_70551_j = field_70552_h;
        this.field_70553_i = field_70552_h;
        this.field_70552_h = field_70552_h;
        this.field_70545_g = Blocks.field_150433_aE.field_149763_I * 2.0f;
        this.field_70544_f = 16.0f;
        this.field_70547_e = 20 + this.field_187136_p.nextInt(40);
        this.field_190017_n = true;
    }
    
    public ParticleGhastTear(final World world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final Item item) {
        this(world, x, y, z, item);
        this.field_187129_i *= 0.10000000149011612;
        this.field_187130_j *= 0.10000000149011612;
        this.field_187131_k *= 0.10000000149011612;
        this.field_187129_i += vx;
        this.field_187130_j += vy;
        this.field_187131_k += vz;
    }
    
    public int func_70537_b() {
        return 1;
    }
    
    public void func_189213_a() {
        if (this.field_187132_l && this.field_187136_p.nextBoolean()) {
            this.field_187122_b.func_184148_a((EntityPlayer)null, this.field_187126_f, this.field_187127_g + 1.0, this.field_187128_h, SoundEvents.field_187561_bM, SoundCategory.HOSTILE, 0.5f, 1.0f);
            final int itemID = Item.func_150891_b(Items.field_151073_bk);
            for (int i = 0; i < 20; ++i) {
                final double gaussX = this.field_187136_p.nextGaussian() * 0.1;
                final double gaussY = this.field_187136_p.nextGaussian() * 0.2;
                final double gaussZ = this.field_187136_p.nextGaussian() * 0.1;
                this.field_187122_b.func_175688_a(EnumParticleTypes.ITEM_CRACK, this.field_187126_f + this.field_187136_p.nextFloat() - this.field_187136_p.nextFloat(), this.field_187127_g + 0.5, this.field_187128_h + this.field_187136_p.nextFloat(), gaussX, gaussY, gaussZ, new int[] { itemID });
                this.field_187122_b.func_175688_a(EnumParticleTypes.EXPLOSION_NORMAL, this.field_187126_f, this.field_187127_g, this.field_187128_h, 0.0, 0.0, 0.0, new int[0]);
            }
            this.func_187112_i();
        }
        super.func_189213_a();
    }
}
