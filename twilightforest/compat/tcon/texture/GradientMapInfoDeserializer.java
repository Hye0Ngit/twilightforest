// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.tcon.texture;

import twilightforest.client.texture.GradientNode;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import com.google.gson.annotations.SerializedName;
import slimeknights.tconstruct.library.client.material.deserializers.AbstractRenderInfoDeserializer;

public class GradientMapInfoDeserializer extends AbstractRenderInfoDeserializer
{
    @SerializedName("gradient_map")
    protected SerializedGradientNode[] serializedGradientMap;
    @SerializedName("min_max_texture")
    protected boolean shouldStretchMinimumMaximum;
    
    public MaterialRenderInfo getMaterialRenderInfo() {
        final GradientNode[] gradientMap = new GradientNode[this.serializedGradientMap.length];
        for (int iteration = 0; iteration < this.serializedGradientMap.length - 1; ++iteration) {
            int minimumIndex = iteration;
            for (int search = iteration + 1; search < this.serializedGradientMap.length; ++search) {
                if (this.serializedGradientMap[search].node < this.serializedGradientMap[minimumIndex].node) {
                    minimumIndex = search;
                }
            }
            final SerializedGradientNode accumulator = this.serializedGradientMap[minimumIndex];
            this.serializedGradientMap[minimumIndex] = this.serializedGradientMap[iteration];
            this.serializedGradientMap[iteration] = accumulator;
        }
        for (int i = 0; i < this.serializedGradientMap.length; ++i) {
            gradientMap[i] = new GradientNode();
            gradientMap[i].node = this.serializedGradientMap[i].node;
            gradientMap[i].color = this.fromHex(this.serializedGradientMap[i].color);
        }
        return (MaterialRenderInfo)new GradientMapInfo(this.shouldStretchMinimumMaximum, gradientMap);
    }
    
    static class SerializedGradientNode
    {
        float node;
        String color;
    }
}
