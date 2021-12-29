// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import java.util.Objects;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Pose;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.entity.PartEntity;
import net.minecraft.world.entity.Entity;

public abstract class TFPart<T extends Entity> extends PartEntity<T>
{
    public static final ResourceLocation RENDERER;
    protected EntityDimensions realSize;
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
    
    public TFPart(final T parent) {
        super((Entity)parent);
    }
    
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation renderer() {
        return TFPart.RENDERER;
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
    
    public void m_8119_() {
        this.updateLastPos();
        super.m_8119_();
        if (this.newPosRotationIncrements > 0) {
            final double d0 = this.m_20185_() + (this.interpTargetX - this.m_20185_()) / this.newPosRotationIncrements;
            final double d2 = this.m_20186_() + (this.interpTargetY - this.m_20186_()) / this.newPosRotationIncrements;
            final double d3 = this.m_20189_() + (this.interpTargetZ - this.m_20189_()) / this.newPosRotationIncrements;
            final double d4 = Mth.m_14175_(this.interpTargetYaw - this.m_146908_());
            this.m_146922_((float)(this.m_146908_() + d4 / this.newPosRotationIncrements));
            this.m_146926_((float)(this.m_146909_() + (this.interpTargetPitch - this.m_146909_()) / this.newPosRotationIncrements));
            --this.newPosRotationIncrements;
            this.m_6034_(d0, d2, d3);
            this.m_19915_(this.m_146908_(), this.m_146909_());
        }
        while (this.m_146908_() - this.f_19859_ < -180.0f) {
            this.f_19859_ -= 360.0f;
        }
        while (this.m_146908_() - this.f_19859_ >= 180.0f) {
            this.f_19859_ += 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset < -180.0f) {
            this.prevRenderYawOffset -= 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset >= 180.0f) {
            this.prevRenderYawOffset += 360.0f;
        }
        while (this.m_146909_() - this.f_19860_ < -180.0f) {
            this.f_19860_ -= 360.0f;
        }
        while (this.m_146909_() - this.f_19860_ >= 180.0f) {
            this.f_19860_ += 360.0f;
        }
    }
    
    public final void updateLastPos() {
        this.m_6027_(this.m_20185_(), this.m_20186_(), this.m_20189_());
        this.f_19859_ = this.m_146908_();
        this.f_19860_ = this.m_146909_();
        ++this.f_19797_;
    }
    
    protected void setSize(final EntityDimensions size) {
        this.realSize = size;
        this.m_6210_();
    }
    
    public EntityDimensions m_6972_(final Pose poseIn) {
        return this.realSize;
    }
    
    public boolean m_6087_() {
        return true;
    }
    
    public void m_20234_(final int id) {
        super.m_20234_(id + 1);
    }
    
    public void writeData(final FriendlyByteBuf buffer) {
        buffer.writeDouble(this.m_20185_());
        buffer.writeDouble(this.m_20186_());
        buffer.writeDouble(this.m_20189_());
        buffer.writeFloat(this.m_146908_());
        buffer.writeFloat(this.m_146909_());
        buffer.writeFloat(this.f_19815_.f_20377_);
        buffer.writeFloat(this.f_19815_.f_20378_);
        buffer.writeBoolean(this.f_19815_.f_20379_);
    }
    
    public void readData(final FriendlyByteBuf buffer) {
        final Vec3 vec = new Vec3(buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
        this.setPositionAndRotationDirect(vec.f_82479_, vec.f_82480_, vec.f_82481_, buffer.readFloat(), buffer.readFloat(), 3);
        final float w = buffer.readFloat();
        final float h = buffer.readFloat();
        this.setSize(buffer.readBoolean() ? EntityDimensions.m_20398_(w, h) : EntityDimensions.m_20395_(w, h));
        this.m_6210_();
    }
    
    public static void assignPartIDs(final Entity parent) {
        final PartEntity<?>[] parts = (PartEntity<?>[])parent.getParts();
        for (int i = 0, partsLength = Objects.requireNonNull(parts).length; i < partsLength; ++i) {
            final PartEntity<?> part = parts[i];
            part.m_20234_(parent.m_142049_() + i);
        }
    }
    
    static {
        RENDERER = TwilightForestMod.prefix("noop");
    }
}
