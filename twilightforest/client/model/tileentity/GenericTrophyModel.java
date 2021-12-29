// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.Model;

public abstract class GenericTrophyModel extends Model
{
    public GenericTrophyModel() {
        super((Function)RenderType::m_110473_);
    }
    
    public abstract void setRotations(final float p0, final float p1, final float p2);
    
    public void renderHelmToBuffer(final PoseStack matrix, final VertexConsumer buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
    }
    
    public void openMouthForTrophy(final float mouthOpen) {
    }
}
