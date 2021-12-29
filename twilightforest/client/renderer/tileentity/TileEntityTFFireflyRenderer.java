// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import twilightforest.TwilightForestMod;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.renderer.GlStateManager;
import twilightforest.client.BugModelAnimationHelper;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.ModelTFFirefly;
import twilightforest.tileentity.critters.TileEntityTFFireflyTicking;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class TileEntityTFFireflyRenderer extends TileEntitySpecialRenderer<TileEntityTFFireflyTicking>
{
    private final ModelTFFirefly fireflyModel;
    private static final ResourceLocation textureLoc;
    
    public TileEntityTFFireflyRenderer() {
        this.fireflyModel = new ModelTFFirefly();
    }
    
    public void render(@Nullable final TileEntityTFFireflyTicking te, final double x, final double y, final double z, final float partialTicks, final int destroyStage, final float alpha) {
        final int yaw = (te != null) ? te.currentYaw : BugModelAnimationHelper.currentYaw;
        final float glow = (te != null) ? te.glowIntensity : BugModelAnimationHelper.glowIntensity;
        GlStateManager.func_179094_E();
        final EnumFacing facing = EnumFacing.func_82600_a((te != null) ? te.func_145832_p() : 0);
        float rotX = 90.0f;
        float rotZ = 0.0f;
        if (facing == EnumFacing.SOUTH) {
            rotZ = 0.0f;
        }
        else if (facing == EnumFacing.NORTH) {
            rotZ = 180.0f;
        }
        else if (facing == EnumFacing.EAST) {
            rotZ = -90.0f;
        }
        else if (facing == EnumFacing.WEST) {
            rotZ = 90.0f;
        }
        else if (facing == EnumFacing.UP) {
            rotX = 0.0f;
        }
        else if (facing == EnumFacing.DOWN) {
            rotX = 180.0f;
        }
        GlStateManager.func_179109_b((float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
        GlStateManager.func_179114_b(rotX, 1.0f, 0.0f, 0.0f);
        GlStateManager.func_179114_b(rotZ, 0.0f, 0.0f, 1.0f);
        GlStateManager.func_179114_b((float)yaw, 0.0f, 1.0f, 0.0f);
        this.func_147499_a(TileEntityTFFireflyRenderer.textureLoc);
        GlStateManager.func_179094_E();
        GlStateManager.func_179152_a(1.0f, -1.0f, -1.0f);
        GlStateManager.func_179135_a(true, true, true, true);
        GlStateManager.func_179084_k();
        this.fireflyModel.render(0.0625f);
        GlStateManager.func_179147_l();
        GlStateManager.func_179118_c();
        GlStateManager.func_179140_f();
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, glow);
        GlStateManager.func_179112_b(770, 1);
        this.fireflyModel.glow.func_78785_a(0.0625f);
        GlStateManager.func_179112_b(770, 771);
        GlStateManager.func_179084_k();
        GlStateManager.func_179141_d();
        GlStateManager.func_179145_e();
        GlStateManager.func_179121_F();
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.func_179121_F();
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("firefly-tiny.png");
    }
}
