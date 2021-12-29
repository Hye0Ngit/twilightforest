// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import twilightforest.tileentity.TileEntityTFTrophy;
import net.minecraft.tileentity.TileEntity;
import twilightforest.client.model.ModelTFTowerBoss;
import twilightforest.client.model.ModelTFLich;
import twilightforest.client.model.ModelTFNaga;
import twilightforest.client.model.ModelTFHydraHead;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class TileEntityTFTrophyRenderer extends TileEntitySpecialRenderer
{
    private ModelTFHydraHead hydraHeadModel;
    private ModelTFNaga nagaHeadModel;
    private ModelTFLich lichModel;
    private ModelTFTowerBoss urGhastModel;
    
    public TileEntityTFTrophyRenderer() {
        this.hydraHeadModel = new ModelTFHydraHead();
        this.nagaHeadModel = new ModelTFNaga();
        this.lichModel = new ModelTFLich();
        this.urGhastModel = new ModelTFTowerBoss();
    }
    
    public void func_76894_a(final TileEntity tileentity, final double x, final double y, final double z, final float partialTime) {
        final TileEntityTFTrophy trophy = (TileEntityTFTrophy)tileentity;
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        final int meta = trophy.func_70322_n() & 0x7;
        float rotation = trophy.func_82119_b() * 360 / 16.0f;
        boolean onGround = true;
        if (meta != 1) {
            switch (meta) {
                case 2: {
                    onGround = false;
                    break;
                }
                case 3: {
                    onGround = false;
                    rotation = 180.0f;
                    break;
                }
                case 4: {
                    onGround = false;
                    rotation = 270.0f;
                    break;
                }
                default: {
                    onGround = false;
                    rotation = 90.0f;
                    break;
                }
            }
        }
        GL11.glTranslatef((float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
        switch (trophy.func_82117_a()) {
            case 0: {
                this.renderHydraHead(rotation, onGround);
                break;
            }
            case 1: {
                this.renderNagaHead(rotation, onGround);
                break;
            }
            case 2: {
                this.renderLichHead(rotation, onGround);
                break;
            }
            case 3: {
                this.renderUrGhastHead(trophy, rotation, onGround, partialTime);
                break;
            }
        }
        GL11.glPopMatrix();
    }
    
    private void renderHydraHead(final float rotation, final boolean onGround) {
        GL11.glScalef(0.25f, 0.25f, 0.25f);
        this.func_76897_a("/mods/twilightforest/textures/model/hydra4.png");
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glRotatef(rotation, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, onGround ? 1.0f : -0.0f, 1.5f);
        this.hydraHeadModel.openMouthForTrophy(onGround ? 0.0f : 0.25f);
        this.hydraHeadModel.func_78088_a(null, 0.0f, 0.0f, 0.0f, rotation, 0.0f, 0.0625f);
    }
    
    private void renderNagaHead(final float rotation, final boolean onGround) {
        GL11.glTranslatef(0.0f, -0.125f, 0.0f);
        GL11.glScalef(0.25f, 0.25f, 0.25f);
        this.func_76897_a("/mods/twilightforest/textures/model/nagahead.png");
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glRotatef(rotation, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, onGround ? 1.0f : -0.0f, onGround ? 0.0f : 1.0f);
        this.nagaHeadModel.func_78088_a(null, 0.0f, 0.0f, 0.0f, rotation, 0.0f, 0.0625f);
    }
    
    private void renderLichHead(final float rotation, final boolean onGround) {
        GL11.glTranslatef(0.0f, 1.0f, 0.0f);
        this.func_76897_a("/mods/twilightforest/textures/model/twilightlich64.png");
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glRotatef(rotation, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, onGround ? 1.75f : 1.5f, onGround ? 0.0f : 0.24f);
        this.lichModel.field_78116_c.func_78785_a(0.0625f);
        this.lichModel.field_78114_d.func_78785_a(0.0625f);
    }
    
    private void renderUrGhastHead(final TileEntityTFTrophy trophy, final float rotation, final boolean onGround, final float partialTime) {
        GL11.glTranslatef(0.0f, 1.0f, 0.0f);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.func_76897_a("/mods/twilightforest/textures/model/towerboss.png");
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glRotatef(rotation, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, onGround ? 1.0f : 1.0f, onGround ? 0.0f : 0.0f);
        this.urGhastModel.func_78088_a(null, 0.0f, 0.0f, trophy.ticksExisted + partialTime, 0.0f, 0.0f, 0.0625f);
    }
}
