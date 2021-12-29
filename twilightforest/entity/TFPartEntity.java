// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.Pose;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.client.renderer.entity.NoopRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.EntitySize;
import net.minecraftforge.entity.PartEntity;
import net.minecraft.entity.Entity;

public abstract class TFPartEntity<T extends Entity> extends PartEntity<T>
{
    protected EntitySize realSize;
    protected int newPosRotationIncrements;
    protected double interpTargetX;
    protected double interpTargetY;
    protected double interpTargetZ;
    protected double interpTargetYaw;
    protected double interpTargetPitch;
    public float renderYawOffset;
    public float prevRenderYawOffset;
    public int deathTime;
    public int hurtTime;
    
    public TFPartEntity(final T parent) {
        super((Entity)parent);
    }
    
    @OnlyIn(Dist.CLIENT)
    public EntityRenderer<?> renderer(final EntityRendererManager manager) {
        return new NoopRenderer<Object>(manager);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void setPositionAndRotationDirect(final double x, final double y, final double z, final float yaw, final float pitch, final int posRotationIncrements) {
        this.interpTargetX = x;
        this.interpTargetY = y;
        this.interpTargetZ = z;
        this.interpTargetYaw = yaw;
        this.interpTargetPitch = pitch;
        this.newPosRotationIncrements = posRotationIncrements;
    }
    
    public void func_70071_h_() {
        this.updateLastPos();
        super.func_70071_h_();
        if (this.newPosRotationIncrements > 0) {
            final double d0 = this.func_226277_ct_() + (this.interpTargetX - this.func_226277_ct_()) / this.newPosRotationIncrements;
            final double d2 = this.func_226278_cu_() + (this.interpTargetY - this.func_226278_cu_()) / this.newPosRotationIncrements;
            final double d3 = this.func_226281_cx_() + (this.interpTargetZ - this.func_226281_cx_()) / this.newPosRotationIncrements;
            final double d4 = MathHelper.func_76138_g(this.interpTargetYaw - this.field_70177_z);
            this.field_70177_z += (float)(d4 / this.newPosRotationIncrements);
            this.field_70125_A += (float)((this.interpTargetPitch - this.field_70125_A) / this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.func_70107_b(d0, d2, d3);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
        }
        while (this.field_70177_z - this.field_70126_B < -180.0f) {
            this.field_70126_B -= 360.0f;
        }
        while (this.field_70177_z - this.field_70126_B >= 180.0f) {
            this.field_70126_B += 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset < -180.0f) {
            this.prevRenderYawOffset -= 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset >= 180.0f) {
            this.prevRenderYawOffset += 360.0f;
        }
        while (this.field_70125_A - this.field_70127_C < -180.0f) {
            this.field_70127_C -= 360.0f;
        }
        while (this.field_70125_A - this.field_70127_C >= 180.0f) {
            this.field_70127_C += 360.0f;
        }
    }
    
    public final void updateLastPos() {
        this.func_226286_f_(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_());
        this.field_70126_B = this.field_70177_z;
        this.field_70127_C = this.field_70125_A;
        ++this.field_70173_aa;
    }
    
    protected void setSize(final EntitySize size) {
        this.realSize = size;
        this.func_213323_x_();
    }
    
    public EntitySize func_213305_a(final Pose poseIn) {
        return this.realSize;
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public void func_145769_d(final int id) {
        super.func_145769_d(id + 1);
    }
    
    public void writeData(final PacketBuffer buffer) {
        buffer.writeDouble(this.func_226277_ct_());
        buffer.writeDouble(this.func_226278_cu_());
        buffer.writeDouble(this.func_226281_cx_());
        buffer.writeFloat(this.field_70177_z);
        buffer.writeFloat(this.field_70125_A);
        buffer.writeFloat(this.field_213325_aI.field_220315_a);
        buffer.writeFloat(this.field_213325_aI.field_220316_b);
        buffer.writeBoolean(this.field_213325_aI.field_220317_c);
    }
    
    public void readData(final PacketBuffer buffer) {
        final Vector3d vec = new Vector3d(buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
        this.setPositionAndRotationDirect(vec.field_72450_a, vec.field_72448_b, vec.field_72449_c, buffer.readFloat(), buffer.readFloat(), 3);
        final float w = buffer.readFloat();
        final float h = buffer.readFloat();
        this.setSize(buffer.readBoolean() ? EntitySize.func_220311_c(w, h) : EntitySize.func_220314_b(w, h));
        this.func_213323_x_();
    }
}
