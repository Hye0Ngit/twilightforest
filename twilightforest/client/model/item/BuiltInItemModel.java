// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import java.util.Collections;
import net.minecraft.client.renderer.model.BakedQuad;
import java.util.List;
import java.util.Random;
import net.minecraft.util.Direction;
import javax.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.model.IBakedModel;

public abstract class BuiltInItemModel implements IBakedModel
{
    private final TextureAtlasSprite particleTexture;
    private final ItemOverrideList overrides;
    
    protected BuiltInItemModel(final String particleTextureName) {
        this.overrides = new Overrides();
        this.particleTexture = Minecraft.func_71410_x().func_228015_a_(AtlasTexture.field_110575_b).apply(new ResourceLocation(particleTextureName));
    }
    
    public List<BakedQuad> func_200117_a(@Nullable final BlockState state, @Nullable final Direction side, final Random rand) {
        return Collections.emptyList();
    }
    
    public boolean func_177555_b() {
        return true;
    }
    
    public boolean func_177556_c() {
        return true;
    }
    
    public boolean func_188618_c() {
        return true;
    }
    
    public TextureAtlasSprite func_177554_e() {
        return this.particleTexture;
    }
    
    public boolean func_230044_c_() {
        return true;
    }
    
    public ItemOverrideList func_188617_f() {
        return this.overrides;
    }
    
    public IBakedModel handlePerspective(final ItemCameraTransforms.TransformType cameraTransformType, final MatrixStack mat) {
        this.setTransform(cameraTransformType);
        return (IBakedModel)this;
    }
    
    protected abstract void setItemStack(final ItemStack p0);
    
    protected abstract void setTransform(final ItemCameraTransforms.TransformType p0);
    
    private class Overrides extends ItemOverrideList
    {
        Overrides() {
        }
        
        @Nullable
        public IBakedModel func_239290_a_(final IBakedModel originalModel, final ItemStack stack, @Nullable final ClientWorld world, @Nullable final LivingEntity entity) {
            BuiltInItemModel.this.setItemStack(stack);
            return (IBakedModel)BuiltInItemModel.this;
        }
    }
}
