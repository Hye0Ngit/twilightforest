// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.item;

import java.util.Iterator;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraft.client.renderer.block.model.BakedQuad;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.Direction;
import net.minecraft.client.resources.model.BakedModel;

public class TintIndexAwareFullbrightBakedModel extends FullbrightBakedModel
{
    public TintIndexAwareFullbrightBakedModel(final BakedModel delegate) {
        super(delegate);
    }
    
    @Override
    protected List<BakedQuad> getQuads(@Nullable final Direction face, final List<BakedQuad> quads) {
        for (final BakedQuad quad : quads) {
            if (quad.m_111304_()) {
                LightUtil.setLightData(quad, 15728880);
            }
        }
        return quads;
    }
}
