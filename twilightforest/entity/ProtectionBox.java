// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.protocol.Packet;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.entity.Entity;

public class ProtectionBox extends Entity
{
    public int lifeTime;
    public final int sizeX;
    public final int sizeY;
    public final int sizeZ;
    private final BoundingBox sbb;
    
    public ProtectionBox(final EntityType<?> type, final Level world) {
        super((EntityType)type, world);
        final int sizeX = 0;
        this.sizeZ = sizeX;
        this.sizeY = sizeX;
        this.sizeX = sizeX;
        this.sbb = null;
    }
    
    public ProtectionBox(final Level world, final BoundingBox sbb) {
        super((EntityType)TFEntities.PROTECTION_BOX, world);
        this.sbb = new BoundingBox(sbb.m_162394_());
        this.m_7678_((double)sbb.m_162395_(), (double)sbb.m_162396_(), (double)sbb.m_162398_(), 0.0f, 0.0f);
        this.sizeX = sbb.m_71056_();
        this.sizeY = sbb.m_71057_();
        this.sizeZ = sbb.m_71058_();
        this.f_19815_ = EntityDimensions.m_20398_((float)Math.max(this.sizeX, this.sizeZ), (float)this.sizeY);
        this.lifeTime = 60;
    }
    
    public void m_8119_() {
        super.m_8119_();
        if (this.lifeTime <= 1) {
            this.m_146870_();
        }
        else {
            --this.lifeTime;
        }
    }
    
    public boolean matches(final BoundingBox sbb) {
        return this.sbb.m_162395_() == sbb.m_162395_() && this.sbb.m_162396_() == sbb.m_162396_() && this.sbb.m_162398_() == sbb.m_162398_() && this.sbb.m_162399_() == sbb.m_162399_() && this.sbb.m_162400_() == sbb.m_162400_() && this.sbb.m_162401_() == sbb.m_162401_();
    }
    
    public void resetLifetime() {
        this.lifeTime = 60;
    }
    
    public float m_6073_() {
        return 1.0f;
    }
    
    protected void m_8097_() {
    }
    
    protected void m_7378_(final CompoundTag compound) {
    }
    
    protected void m_7380_(final CompoundTag compound) {
    }
    
    @OnlyIn(Dist.CLIENT)
    public boolean m_6051_() {
        return false;
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public Packet<?> m_5654_() {
        throw new IllegalStateException("should never be spawned on server");
    }
}
