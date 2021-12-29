// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import twilightforest.TwilightForestMod;
import net.minecraft.nbt.CompoundTag;
import twilightforest.TFSounds;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import twilightforest.entity.TFPart;

public class SnowQueenIceShield extends TFPart<SnowQueen>
{
    public static final ResourceLocation RENDERER;
    
    public SnowQueenIceShield(final SnowQueen parent) {
        super((Entity)parent);
        this.f_19815_ = EntityDimensions.m_20395_(0.75f, 0.75f);
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public ResourceLocation renderer() {
        return SnowQueenIceShield.RENDERER;
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        this.m_5496_(TFSounds.SNOW_QUEEN_BREAK, 1.0f, ((this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        return false;
    }
    
    protected void m_7378_(final CompoundTag compound) {
    }
    
    protected void m_7380_(final CompoundTag compound) {
    }
    
    protected void m_8097_() {
    }
    
    static {
        RENDERER = TwilightForestMod.prefix("snowqueen_iceshield");
    }
}
