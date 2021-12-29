// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import twilightforest.TwilightForestMod;
import net.minecraft.tags.FluidTags;
import javax.annotation.Nullable;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.tags.Tag;
import net.minecraft.data.tags.FluidTagsProvider;

public class FluidTagGenerator extends FluidTagsProvider
{
    public static final Tag.Named<Fluid> FIRE_JET_FUEL;
    
    public FluidTagGenerator(final DataGenerator generatorIn, @Nullable final ExistingFileHelper existingFileHelper) {
        super(generatorIn, "twilightforest", existingFileHelper);
    }
    
    protected void m_6577_() {
        this.m_126548_((Tag.Named)FluidTagGenerator.FIRE_JET_FUEL).m_126580_(FluidTags.f_13132_);
    }
    
    static {
        FIRE_JET_FUEL = FluidTags.m_13134_(TwilightForestMod.prefix("fire_jet_fuel").toString());
    }
}
