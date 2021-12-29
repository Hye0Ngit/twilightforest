// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import java.util.Collections;
import java.util.Collection;
import com.mojang.datafixers.util.Pair;
import java.util.Set;
import net.minecraft.client.resources.model.UnbakedModel;
import twilightforest.client.model.PatchModel;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import java.util.function.Function;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraftforge.client.model.IModelConfiguration;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.resources.model.Material;
import net.minecraftforge.client.model.geometry.IModelGeometry;

record UnbakedPatchModel(Material material, boolean shaggify) implements IModelGeometry<UnbakedPatchModel> {
    public UnbakedPatchModel(final ResourceLocation texture, final boolean shaggify) {
        this(new Material(InventoryMenu.f_39692_, texture), shaggify);
    }
    
    public BakedModel bake(final IModelConfiguration owner, final ModelBakery bakery, final Function<Material, TextureAtlasSprite> spriteGetter, final ModelState modelTransform, final ItemOverrides overrides, final ResourceLocation modelLocation) {
        return (BakedModel)new PatchModel(modelLocation, spriteGetter.apply(this.material()), this.shaggify());
    }
    
    public Collection<Material> getTextures(final IModelConfiguration owner, final Function<ResourceLocation, UnbakedModel> modelGetter, final Set<Pair<String, String>> missingTextureErrors) {
        return Collections.singleton(this.material());
    }
}
