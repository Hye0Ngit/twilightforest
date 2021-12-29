// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

public interface IThornsTransformer extends IAreaTransformer1, IDimOffset1Transformer
{
    int apply(final INoiseRandom p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6, final int p7, final int p8, final int p9);
    
    default int func_215728_a(final IExtendedNoiseRandom<?> noise, final IArea area, final int width, final int depth) {
        return this.apply((INoiseRandom)noise, area.func_202678_a(this.func_215721_a(width + 1), this.func_215722_b(depth)), area.func_202678_a(this.func_215721_a(width + 2), this.func_215722_b(depth + 1)), area.func_202678_a(this.func_215721_a(width + 1), this.func_215722_b(depth + 2)), area.func_202678_a(this.func_215721_a(width), this.func_215722_b(depth + 1)), area.func_202678_a(this.func_215721_a(width + 1), this.func_215722_b(depth + 1)), area.func_202678_a(this.func_215721_a(width + 2), this.func_215722_b(depth)), area.func_202678_a(this.func_215721_a(width + 2), this.func_215722_b(depth + 2)), area.func_202678_a(this.func_215721_a(width), this.func_215722_b(depth + 2)), area.func_202678_a(this.func_215721_a(width), this.func_215722_b(depth)));
    }
}
