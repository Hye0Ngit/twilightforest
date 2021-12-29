// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.tcon.texture;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.client.material.deserializers.AbstractRenderInfoDeserializer;

public class FieryInfoDeserializer extends AbstractRenderInfoDeserializer
{
    public MaterialRenderInfo getMaterialRenderInfo() {
        return (MaterialRenderInfo)new MaterialRenderInfo.AbstractMaterialRenderInfo() {
            public TextureAtlasSprite getTexture(final ResourceLocation baseTexture, final String location) {
                return (TextureAtlasSprite)new FieryTConTexture(baseTexture, location);
            }
        };
    }
}
