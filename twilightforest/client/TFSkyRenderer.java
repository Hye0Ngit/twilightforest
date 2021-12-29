// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import java.util.Random;
import net.minecraft.util.Vec3;
import twilightforest.world.TFWorld;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraftforge.client.IRenderHandler;

public class TFSkyRenderer extends IRenderHandler
{
    private int starGLCallList;
    private int glSkyList;
    private int glSkyList2;
    
    @SideOnly(Side.CLIENT)
    public TFSkyRenderer() {
        this.starGLCallList = GLAllocation.func_74526_a(3);
        GL11.glPushMatrix();
        GL11.glNewList(this.starGLCallList, 4864);
        this.renderStars();
        GL11.glEndList();
        GL11.glPopMatrix();
        final Tessellator var5 = Tessellator.field_78398_a;
        GL11.glNewList(this.glSkyList = this.starGLCallList + 1, 4864);
        final byte var6 = 64;
        final int var7 = 256 / var6 + 2;
        float var8 = 16.0f;
        for (int var9 = -var6 * var7; var9 <= var6 * var7; var9 += var6) {
            for (int var10 = -var6 * var7; var10 <= var6 * var7; var10 += var6) {
                var5.func_78382_b();
                var5.func_78377_a((double)(var9 + 0), (double)var8, (double)(var10 + 0));
                var5.func_78377_a((double)(var9 + var6), (double)var8, (double)(var10 + 0));
                var5.func_78377_a((double)(var9 + var6), (double)var8, (double)(var10 + var6));
                var5.func_78377_a((double)(var9 + 0), (double)var8, (double)(var10 + var6));
                var5.func_78381_a();
            }
        }
        GL11.glEndList();
        GL11.glNewList(this.glSkyList2 = this.starGLCallList + 2, 4864);
        var8 = -16.0f;
        var5.func_78382_b();
        for (int var9 = -var6 * var7; var9 <= var6 * var7; var9 += var6) {
            for (int var10 = -var6 * var7; var10 <= var6 * var7; var10 += var6) {
                var5.func_78377_a((double)(var9 + var6), (double)var8, (double)(var10 + 0));
                var5.func_78377_a((double)(var9 + 0), (double)var8, (double)(var10 + 0));
                var5.func_78377_a((double)(var9 + 0), (double)var8, (double)(var10 + var6));
                var5.func_78377_a((double)(var9 + var6), (double)var8, (double)(var10 + var6));
            }
        }
        var5.func_78381_a();
        GL11.glEndList();
    }
    
    @SideOnly(Side.CLIENT)
    public void render(final float partialTicks, final WorldClient world, final Minecraft mc) {
        GL11.glDisable(3553);
        final Vec3 var2 = this.getTwilightSkyColor((World)world);
        float var3 = (float)var2.field_72450_a;
        float var4 = (float)var2.field_72448_b;
        float var5 = (float)var2.field_72449_c;
        if (mc.field_71474_y.field_74337_g) {
            final float var6 = (var3 * 30.0f + var4 * 59.0f + var5 * 11.0f) / 100.0f;
            final float var7 = (var3 * 30.0f + var4 * 70.0f) / 100.0f;
            final float var8 = (var3 * 30.0f + var5 * 70.0f) / 100.0f;
            var3 = var6;
            var4 = var7;
            var5 = var8;
        }
        GL11.glColor3f(var3, var4, var5);
        final Tessellator var9 = Tessellator.field_78398_a;
        GL11.glDepthMask(false);
        GL11.glEnable(2912);
        GL11.glColor3f(var3, var4, var5);
        GL11.glCallList(this.glSkyList);
        GL11.glDisable(2912);
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        RenderHelper.func_74518_a();
        GL11.glEnable(3553);
        GL11.glBlendFunc(770, 1);
        GL11.glPushMatrix();
        final float var8 = 1.0f - world.func_72867_j(partialTicks);
        final float var10 = 0.0f;
        float var11 = 0.0f;
        float var12 = 0.0f;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, var8);
        GL11.glTranslatef(var10, var11, var12);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(this.getRealCelestialAngle((World)world, partialTicks) * 360.0f, 1.0f, 0.0f, 0.0f);
        float var13 = 30.0f;
        GL11.glDisable(3553);
        final float var14 = 1.0f;
        if (var14 > 0.0f) {
            GL11.glColor4f(var14, var14, var14, var14);
            GL11.glCallList(this.starGLCallList);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(2912);
        GL11.glPopMatrix();
        GL11.glDisable(3553);
        GL11.glColor3f(0.0f, 0.0f, 0.0f);
        final double var15 = mc.field_71439_g.func_70666_h(partialTicks).field_72448_b - TFWorld.SEALEVEL;
        if (var15 < 0.0) {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 12.0f, 0.0f);
            GL11.glCallList(this.glSkyList2);
            GL11.glPopMatrix();
            var11 = 1.0f;
            var12 = -(float)(var15 + 65.0);
            var13 = -var11;
            var9.func_78382_b();
            var9.func_78384_a(0, 255);
            var9.func_78377_a((double)(-var11), (double)var12, (double)var11);
            var9.func_78377_a((double)var11, (double)var12, (double)var11);
            var9.func_78377_a((double)var11, (double)var13, (double)var11);
            var9.func_78377_a((double)(-var11), (double)var13, (double)var11);
            var9.func_78377_a((double)(-var11), (double)var13, (double)(-var11));
            var9.func_78377_a((double)var11, (double)var13, (double)(-var11));
            var9.func_78377_a((double)var11, (double)var12, (double)(-var11));
            var9.func_78377_a((double)(-var11), (double)var12, (double)(-var11));
            var9.func_78377_a((double)var11, (double)var13, (double)(-var11));
            var9.func_78377_a((double)var11, (double)var13, (double)var11);
            var9.func_78377_a((double)var11, (double)var12, (double)var11);
            var9.func_78377_a((double)var11, (double)var12, (double)(-var11));
            var9.func_78377_a((double)(-var11), (double)var12, (double)(-var11));
            var9.func_78377_a((double)(-var11), (double)var12, (double)var11);
            var9.func_78377_a((double)(-var11), (double)var13, (double)var11);
            var9.func_78377_a((double)(-var11), (double)var13, (double)(-var11));
            var9.func_78377_a((double)(-var11), (double)var13, (double)(-var11));
            var9.func_78377_a((double)(-var11), (double)var13, (double)var11);
            var9.func_78377_a((double)var11, (double)var13, (double)var11);
            var9.func_78377_a((double)var11, (double)var13, (double)(-var11));
            var9.func_78381_a();
        }
        if (world.field_73011_w.func_76561_g()) {
            GL11.glColor3f(var3 * 0.2f + 0.04f, var4 * 0.2f + 0.04f, var5 * 0.6f + 0.1f);
        }
        else {
            GL11.glColor3f(var3, var4, var5);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, -(float)(var15 - 16.0), 0.0f);
        GL11.glCallList(this.glSkyList2);
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDepthMask(true);
    }
    
    private float getRealCelestialAngle(final World world, final float partialTicks) {
        final int var4 = (int)(world.func_72820_D() % 24000L);
        float var5 = (var4 + partialTicks) / 24000.0f - 0.25f;
        if (var5 < 0.0f) {
            ++var5;
        }
        if (var5 > 1.0f) {
            --var5;
        }
        final float var6 = var5;
        var5 = 1.0f - (float)((Math.cos(var5 * 3.141592653589793) + 1.0) / 2.0);
        var5 = var6 + (var5 - var6) / 3.0f;
        return var5;
    }
    
    private Vec3 getTwilightSkyColor(final World world) {
        return world.func_82732_R().func_72345_a(0.125, 0.1328125, 0.2890625);
    }
    
    private void renderStars() {
        final Random var1 = new Random(10842L);
        final Tessellator var2 = Tessellator.field_78398_a;
        var2.func_78382_b();
        for (int var3 = 0; var3 < 3000; ++var3) {
            double var4 = var1.nextFloat() * 2.0f - 1.0f;
            double var5 = var1.nextFloat() * 2.0f - 1.0f;
            double var6 = var1.nextFloat() * 2.0f - 1.0f;
            final double size = 0.1f + var1.nextFloat() * 0.25f;
            double var7 = var4 * var4 + var5 * var5 + var6 * var6;
            if (var7 < 1.0 && var7 > 0.01) {
                var7 = 1.0 / Math.sqrt(var7);
                var4 *= var7;
                var5 *= var7;
                var6 *= var7;
                final double var8 = var4 * 100.0;
                final double var9 = var5 * 100.0;
                final double var10 = var6 * 100.0;
                final double var11 = Math.atan2(var4, var6);
                final double var12 = Math.sin(var11);
                final double var13 = Math.cos(var11);
                final double var14 = Math.atan2(Math.sqrt(var4 * var4 + var6 * var6), var5);
                final double var15 = Math.sin(var14);
                final double var16 = Math.cos(var14);
                final double var17 = var1.nextDouble() * 3.141592653589793 * 2.0;
                final double var18 = Math.sin(var17);
                final double var19 = Math.cos(var17);
                for (int var20 = 0; var20 < 4; ++var20) {
                    final double var21 = 0.0;
                    final double var22 = ((var20 & 0x2) - 1) * size;
                    final double var23 = ((var20 + 1 & 0x2) - 1) * size;
                    final double var24 = var22 * var19 - var23 * var18;
                    final double var25 = var23 * var19 + var22 * var18;
                    final double var26 = var24 * var15 + var21 * var16;
                    final double var27 = var21 * var15 - var24 * var16;
                    final double var28 = var27 * var12 - var25 * var13;
                    final double var29 = var25 * var12 + var27 * var13;
                    var2.func_78377_a(var8 + var28, var9 + var26, var10 + var29);
                }
            }
        }
        var2.func_78381_a();
    }
}
