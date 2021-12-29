// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import twilightforest.capabilities.shield.IShieldCapability;
import twilightforest.entity.boss.EntityTFLich;
import twilightforest.client.renderer.entity.LayerShields;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import twilightforest.potions.PotionFrosted;
import net.minecraft.entity.SharedMonsterAttributes;
import java.util.Random;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;

public enum RenderEffect
{
    ICE {
        private final Random random;
        
        {
            this.random = new Random();
        }
        
        @Override
        public boolean shouldRender(final EntityLivingBase entity, final boolean firstPerson) {
            return !firstPerson && entity.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111127_a(PotionFrosted.MODIFIER_UUID) != null;
        }
        
        @Override
        public void render(final EntityLivingBase entity, final RenderLivingBase<? extends EntityLivingBase> renderer, final double x, final double y, final double z, final float partialTicks, final boolean firstPerson) {
            GlStateManager.func_179147_l();
            GlStateManager.func_179112_b(770, 771);
            Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
            this.random.setSeed(entity.func_145782_y() * entity.func_145782_y() * 3121 + entity.func_145782_y() * 45238971);
            for (int numCubes = (int)(entity.field_70131_O / 0.4f), i = 0; i < numCubes; ++i) {
                GlStateManager.func_179094_E();
                final float dx = (float)(x + this.random.nextGaussian() * 0.20000000298023224 * entity.field_70130_N);
                final float dy = (float)(y + this.random.nextGaussian() * 0.20000000298023224 * entity.field_70131_O) + entity.field_70131_O / 2.0f;
                final float dz = (float)(z + this.random.nextGaussian() * 0.20000000298023224 * entity.field_70130_N);
                GlStateManager.func_179109_b(dx, dy, dz);
                GlStateManager.func_179152_a(0.5f, 0.5f, 0.5f);
                GlStateManager.func_179114_b(this.random.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.func_179114_b(this.random.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.func_179114_b(this.random.nextFloat() * 360.0f, 0.0f, 0.0f, 1.0f);
                Minecraft.func_71410_x().func_175602_ab().func_175016_a(Blocks.field_150432_aD.func_176223_P(), 1.0f);
                GlStateManager.func_179121_F();
            }
            GlStateManager.func_179084_k();
        }
    }, 
    SHIELDS {
        private final LayerRenderer<EntityLivingBase> layer;
        
        {
            this.layer = (LayerRenderer<EntityLivingBase>)new LayerShields();
        }
        
        @Override
        public boolean shouldRender(final EntityLivingBase entity, final boolean firstPerson) {
            if (entity instanceof EntityTFLich) {
                return false;
            }
            final IShieldCapability cap = (IShieldCapability)entity.getCapability((Capability)CapabilityList.SHIELDS, (EnumFacing)null);
            return cap != null && cap.shieldsLeft() > 0;
        }
        
        @Override
        public void render(final EntityLivingBase entity, final RenderLivingBase<? extends EntityLivingBase> renderer, final double x, final double y, final double z, final float partialTicks, final boolean firstPerson) {
            GlStateManager.func_179094_E();
            GlStateManager.func_179137_b(x, y, z);
            GlStateManager.func_179114_b(180.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.func_179109_b(0.0f, 0.5f - entity.func_70047_e(), 0.0f);
            GlStateManager.func_179147_l();
            GlStateManager.func_179129_p();
            GlStateManager.func_179112_b(770, 771);
            this.layer.func_177141_a(entity, 0.0f, 0.0f, partialTicks, 0.0f, 0.0f, 0.0f, 0.0625f);
            GlStateManager.func_179089_o();
            GlStateManager.func_179084_k();
            GlStateManager.func_179121_F();
        }
    };
    
    static final RenderEffect[] VALUES;
    
    public boolean shouldRender(final EntityLivingBase entity, final boolean firstPerson) {
        return false;
    }
    
    public void render(final EntityLivingBase entity, final RenderLivingBase<? extends EntityLivingBase> renderer, final double x, final double y, final double z, final float partialTicks, final boolean firstPerson) {
    }
    
    static {
        VALUES = values();
    }
}
