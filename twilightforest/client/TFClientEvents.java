// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.entity.RenderManager;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.item.ItemTFBowBase;
import net.minecraftforge.client.event.FOVUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.event.RenderLivingEvent;
import java.util.Random;

public class TFClientEvents
{
    private Random random;
    
    public TFClientEvents() {
        this.random = new Random();
    }
    
    @SubscribeEvent
    public void renderLivingPost(final RenderLivingEvent.Post event) {
        if (event.entity.func_70096_w().func_75679_c(7) == Potion.field_76425_a[Potion.field_76421_d.func_76396_c()].func_76401_j() && event.entity.func_70096_w().func_75683_a(8) > 0) {
            this.renderIcedEntity(event.entity, event.renderer, event.x, event.y, event.z);
        }
    }
    
    @SubscribeEvent
    public void fovUpdate(final FOVUpdateEvent event) {
        if (event.entity.func_71039_bw() && event.entity.func_71011_bu().func_77973_b() instanceof ItemTFBowBase) {
            final int i = event.entity.func_71057_bx();
            float f1 = i / 20.0f;
            if (f1 > 1.0f) {
                f1 = 1.0f;
            }
            else {
                f1 *= f1;
            }
            event.newfov *= 1.0f - f1 * 0.15f;
        }
    }
    
    private void renderIcedEntity(final EntityLivingBase entity, final RendererLivingEntity renderer, final double x, final double y, final double z) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        RenderManager.field_78727_a.field_78724_e.func_110577_a(TextureMap.field_110575_b);
        this.random.setSeed(entity.func_145782_y() * entity.func_145782_y() * 3121 + entity.func_145782_y() * 45238971);
        for (int numCubes = (int)(entity.field_70131_O / 0.4f), i = 0; i < numCubes; ++i) {
            GL11.glPushMatrix();
            final float dx = (float)(x + this.random.nextGaussian() * 0.20000000298023224 * entity.field_70130_N);
            final float dy = (float)(y + this.random.nextGaussian() * 0.20000000298023224 * entity.field_70131_O) + entity.field_70131_O / 2.0f;
            final float dz = (float)(z + this.random.nextGaussian() * 0.20000000298023224 * entity.field_70130_N);
            GL11.glTranslatef(dx, dy, dz);
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            GL11.glRotatef(this.random.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(this.random.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(this.random.nextFloat() * 360.0f, 0.0f, 0.0f, 1.0f);
            RenderBlocks.getInstance().func_147800_a(Blocks.field_150432_aD, 0, 1.0f);
            GL11.glPopMatrix();
        }
        GL11.glDisable(3042);
    }
}
