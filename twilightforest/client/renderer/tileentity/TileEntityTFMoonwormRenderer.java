// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import twilightforest.TwilightForestMod;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import twilightforest.client.BugModelAnimationHelper;
import javax.annotation.Nullable;
import twilightforest.client.model.entity.ModelTFMoonworm;
import net.minecraft.util.ResourceLocation;
import twilightforest.tileentity.critters.TileEntityTFMoonwormTicking;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class TileEntityTFMoonwormRenderer extends TileEntitySpecialRenderer<TileEntityTFMoonwormTicking>
{
    private static final ResourceLocation textureLoc;
    private final ModelTFMoonworm moonwormModel;
    
    public TileEntityTFMoonwormRenderer() {
        this.moonwormModel = new ModelTFMoonworm();
    }
    
    public void render(@Nullable final TileEntityTFMoonwormTicking te, final double x, final double y, final double z, float partialTicks, final int destroyStage, final float alpha) {
        final int yaw = (te != null) ? te.currentYaw : BugModelAnimationHelper.currentRotation;
        if (te == null) {
            partialTicks = Minecraft.func_71410_x().func_184121_ak();
        }
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
        GlStateManager.func_179137_b(x + 0.5, y + 0.5, z + 0.5);
        GlStateManager.func_179114_b(rotX, 1.0f, 0.0f, 0.0f);
        GlStateManager.func_179114_b(rotZ, 0.0f, 0.0f, 1.0f);
        GlStateManager.func_179114_b((float)yaw, 0.0f, 1.0f, 0.0f);
        this.func_147499_a(TileEntityTFMoonwormRenderer.textureLoc);
        GlStateManager.func_179152_a(1.0f, -1.0f, -1.0f);
        this.moonwormModel.setLivingAnimations(te, partialTicks);
        this.moonwormModel.render(0.0625f);
        GlStateManager.func_179121_F();
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("moonworm.png");
    }
}
