// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.item;

import net.minecraftforge.client.ForgeHooksClient;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import java.util.Iterator;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraftforge.client.model.data.IModelData;
import javax.annotation.Nonnull;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.block.model.BakedQuad;
import java.util.List;
import net.minecraft.core.Direction;
import java.util.Map;
import net.minecraft.client.resources.model.BakedModel;

public class FullbrightBakedModel implements BakedModel
{
    protected final BakedModel delegate;
    protected final Map<Direction, List<BakedQuad>> cachedQuads;
    protected boolean cache;
    
    public FullbrightBakedModel(final BakedModel delegate) {
        this.cachedQuads = Maps.newHashMap();
        this.cache = true;
        this.delegate = delegate;
    }
    
    public final FullbrightBakedModel disableCache() {
        this.cache = false;
        return this;
    }
    
    @Nonnull
    public List<BakedQuad> getQuads(@Nullable final BlockState state, @Nullable final Direction side, @Nonnull final Random rand, @Nonnull final IModelData extraData) {
        return this.m_6840_(state, side, rand);
    }
    
    public List<BakedQuad> m_6840_(@Nullable final BlockState state, @Nullable final Direction side, final Random rand) {
        return this.cache ? this.cachedQuads.computeIfAbsent(side, face -> {
            final List quads = this.delegate.m_6840_(state, side, rand);
            return this.getQuads(face, quads);
        }) : this.getQuads(side, this.delegate.m_6840_(state, side, rand));
    }
    
    protected List<BakedQuad> getQuads(@Nullable final Direction face, final List<BakedQuad> quads) {
        for (final BakedQuad quad : quads) {
            LightUtil.setLightData(quad, 15728880);
        }
        return quads;
    }
    
    public boolean m_7541_() {
        return this.delegate.m_7541_();
    }
    
    public boolean m_7539_() {
        return this.delegate.m_7539_();
    }
    
    public boolean m_7547_() {
        return this.delegate.m_7547_();
    }
    
    public boolean m_7521_() {
        return this.delegate.m_7521_();
    }
    
    public TextureAtlasSprite m_6160_() {
        return this.delegate.m_6160_();
    }
    
    public ItemTransforms m_7442_() {
        return this.delegate.m_7442_();
    }
    
    public ItemOverrides m_7343_() {
        return this.delegate.m_7343_();
    }
    
    public BakedModel handlePerspective(final ItemTransforms.TransformType cameraTransformType, final PoseStack mat) {
        return ForgeHooksClient.handlePerspective((BakedModel)this, cameraTransformType, mat);
    }
}
