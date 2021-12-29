// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.util.ResourceLocation;

public class ItemTFMoonDial extends ItemTF
{
    public ItemTFMoonDial() {
        this.func_185043_a(new ResourceLocation("phase"), (IItemPropertyGetter)new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            double rotation;
            @SideOnly(Side.CLIENT)
            double rota;
            @SideOnly(Side.CLIENT)
            long lastUpdateTick;
            
            @SideOnly(Side.CLIENT)
            public float func_185085_a(final ItemStack stack, @Nullable World world, @Nullable final EntityLivingBase entityBase) {
                final boolean flag = entityBase != null;
                final Entity entity = (Entity)(flag ? entityBase : stack.func_82836_z());
                if (world == null && entity != null) {
                    world = entity.field_70170_p;
                }
                return (world == null) ? 0.0f : ((float)(world.field_73011_w.func_76569_d() ? MathHelper.func_181162_h((double)(world.func_72853_d() / 8.0f)) : this.wobble(world, Math.random())));
            }
            
            @SideOnly(Side.CLIENT)
            private double wobble(final World world, final double rotation) {
                if (world.func_82737_E() != this.lastUpdateTick) {
                    this.lastUpdateTick = world.func_82737_E();
                    double delta = rotation - this.rotation;
                    delta = MathHelper.func_191273_b(delta + 0.5, 1.0) - 0.5;
                    this.rota += delta * 0.1;
                    this.rota *= 0.9;
                    this.rotation = MathHelper.func_191273_b(this.rotation + this.rota, 1.0);
                }
                return this.rotation;
            }
        });
    }
}
