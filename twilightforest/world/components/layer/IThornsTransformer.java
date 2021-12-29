// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.layer;

import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.traits.DimensionOffset1Transformer;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer1;

public interface IThornsTransformer extends AreaTransformer1, DimensionOffset1Transformer
{
    int apply(final Context p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6, final int p7, final int p8, final int p9);
    
    default int m_7591_(final BigContext<?> noise, final Area area, final int width, final int depth) {
        return this.apply((Context)noise, area.m_7929_(this.m_6320_(width + 1), this.m_6317_(depth)), area.m_7929_(this.m_6320_(width + 2), this.m_6317_(depth + 1)), area.m_7929_(this.m_6320_(width + 1), this.m_6317_(depth + 2)), area.m_7929_(this.m_6320_(width), this.m_6317_(depth + 1)), area.m_7929_(this.m_6320_(width + 1), this.m_6317_(depth + 1)), area.m_7929_(this.m_6320_(width + 2), this.m_6317_(depth)), area.m_7929_(this.m_6320_(width + 2), this.m_6317_(depth + 2)), area.m_7929_(this.m_6320_(width), this.m_6317_(depth + 2)), area.m_7929_(this.m_6320_(width), this.m_6317_(depth)));
    }
}
