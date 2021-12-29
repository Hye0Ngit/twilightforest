// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.item;

import net.minecraftforge.client.ForgeHooksClient;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import java.util.Iterator;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraftforge.client.model.data.IModelData;
import javax.annotation.Nonnull;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.block.BlockState;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.model.BakedQuad;
import java.util.List;
import net.minecraft.util.Direction;
import java.util.Map;
import net.minecraft.client.renderer.model.IBakedModel;

public class FullbrightBakedModel implements IBakedModel
{
    private final IBakedModel delegate;
    private Map<Direction, List<BakedQuad>> cachedQuads;
    
    public FullbrightBakedModel(final IBakedModel delegate) {
        this.cachedQuads = Maps.newHashMap();
        this.delegate = delegate;
    }
    
    public IBakedModel getBakedModel() {
        return this.delegate;
    }
    
    @Nonnull
    public List<BakedQuad> getQuads(@Nullable final BlockState state, @Nullable final Direction side, @Nonnull final Random rand, @Nonnull final IModelData extraData) {
        return this.func_200117_a(state, side, rand);
    }
    
    public List<BakedQuad> func_200117_a(@Nullable final BlockState state, @Nullable final Direction side, final Random rand) {
        return this.cachedQuads.computeIfAbsent(side, face -> {
            final List quads = this.delegate.func_200117_a(state, side, rand);
            quads.iterator();
            final Iterator iterator;
            while (iterator.hasNext()) {
                final BakedQuad quad = iterator.next();
                LightUtil.setLightData(quad, 15728880);
            }
            return quads;
        });
    }
    
    public boolean func_177555_b() {
        return this.delegate.func_177555_b();
    }
    
    public boolean func_177556_c() {
        return this.delegate.func_177556_c();
    }
    
    public boolean func_230044_c_() {
        return this.delegate.func_230044_c_();
    }
    
    public boolean func_188618_c() {
        return this.delegate.func_188618_c();
    }
    
    public TextureAtlasSprite func_177554_e() {
        return this.delegate.func_177554_e();
    }
    
    public ItemCameraTransforms func_177552_f() {
        return this.delegate.func_177552_f();
    }
    
    public ItemOverrideList func_188617_f() {
        return this.delegate.func_188617_f();
    }
    
    public IBakedModel handlePerspective(final ItemCameraTransforms.TransformType cameraTransformType, final MatrixStack mat) {
        return ForgeHooksClient.handlePerspective((IBakedModel)this, cameraTransformType, mat);
    }
}
