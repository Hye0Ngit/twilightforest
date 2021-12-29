// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import twilightforest.TwilightForestMod;
import net.minecraft.tags.FluidTags;
import javax.annotation.Nullable;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.ITag;
import net.minecraft.data.FluidTagsProvider;

public class FluidTagGenerator extends FluidTagsProvider
{
    public static final ITag.INamedTag<Fluid> FIRE_JET_FUEL;
    public static final ITag.INamedTag<Fluid> PORTAL_FLUID;
    
    public FluidTagGenerator(final DataGenerator generatorIn, @Nullable final ExistingFileHelper existingFileHelper) {
        super(generatorIn, "twilightforest", existingFileHelper);
    }
    
    protected void func_200432_c() {
        this.func_240522_a_((ITag.INamedTag)FluidTagGenerator.FIRE_JET_FUEL).func_240531_a_(FluidTags.field_206960_b);
        this.func_240522_a_((ITag.INamedTag)FluidTagGenerator.PORTAL_FLUID).func_240531_a_(FluidTags.field_206959_a);
    }
    
    static {
        FIRE_JET_FUEL = FluidTags.func_206956_a(TwilightForestMod.prefix("fire_jet_fuel").toString());
        PORTAL_FLUID = FluidTags.func_206956_a(TwilightForestMod.prefix("portal_fluid").toString());
    }
}
