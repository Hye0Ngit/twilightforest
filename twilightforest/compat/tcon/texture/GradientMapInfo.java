// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.tcon.texture;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.texture.GradientNode;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;

public class GradientMapInfo extends MaterialRenderInfo.AbstractMaterialRenderInfo
{
    private GradientNode[] gradientMap;
    private boolean shouldStretchMinimumMaximum;
    
    public GradientMapInfo(final boolean shouldStretchMinimumMaximum, final GradientNode... gradientMap) {
        this.gradientMap = gradientMap;
        this.shouldStretchMinimumMaximum = shouldStretchMinimumMaximum;
    }
    
    public TextureAtlasSprite getTexture(final ResourceLocation baseTexture, final String location) {
        return (TextureAtlasSprite)new GradientMappedTConTexture(baseTexture, location, this.shouldStretchMinimumMaximum, this.gradientMap);
    }
}
