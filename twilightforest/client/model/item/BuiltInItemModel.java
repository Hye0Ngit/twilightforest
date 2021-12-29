// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import javax.vecmath.Matrix4f;
import org.apache.commons.lang3.tuple.Pair;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import java.util.Collections;
import net.minecraft.client.renderer.block.model.BakedQuad;
import java.util.List;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.block.model.IBakedModel;

public abstract class BuiltInItemModel implements IBakedModel
{
    private final TextureAtlasSprite particleTexture;
    private final ItemOverrideList overrides;
    
    protected BuiltInItemModel(final String particleTextureName) {
        this.overrides = new Overrides();
        this.particleTexture = Minecraft.func_71410_x().func_147117_R().func_110572_b(particleTextureName);
    }
    
    public List<BakedQuad> func_188616_a(@Nullable final IBlockState state, @Nullable final EnumFacing side, final long rand) {
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
    
    public ItemOverrideList func_188617_f() {
        return this.overrides;
    }
    
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(final ItemCameraTransforms.TransformType cameraTransformType) {
        this.setTransform(cameraTransformType);
        return (Pair<? extends IBakedModel, Matrix4f>)Pair.of((Object)this, (Object)null);
    }
    
    protected abstract void setItemStack(final ItemStack p0);
    
    protected abstract void setTransform(final ItemCameraTransforms.TransformType p0);
    
    private class Overrides extends ItemOverrideList
    {
        Overrides() {
            super((List)Collections.emptyList());
        }
        
        public IBakedModel handleItemState(final IBakedModel originalModel, final ItemStack stack, @Nullable final World world, @Nullable final EntityLivingBase entity) {
            BuiltInItemModel.this.setItemStack(stack);
            return (IBakedModel)BuiltInItemModel.this;
        }
    }
}
