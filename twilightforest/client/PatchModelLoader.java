// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraftforge.client.model.geometry.IModelGeometry;
import net.minecraft.server.packs.resources.ResourceManager;
import com.mojang.realmsclient.util.JsonUtils;
import net.minecraft.resources.ResourceLocation;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializationContext;
import net.minecraftforge.client.model.IModelLoader;

public final class PatchModelLoader implements IModelLoader<UnbakedPatchModel>
{
    public static final PatchModelLoader INSTANCE;
    
    private PatchModelLoader() {
    }
    
    public UnbakedPatchModel read(final JsonDeserializationContext deserializationContext, final JsonObject modelContents) {
        if (!modelContents.has("texture")) {
            throw new RuntimeException("Patch model missing value for 'texture'.");
        }
        return new UnbakedPatchModel(new ResourceLocation(modelContents.get("texture").getAsString()), JsonUtils.m_90165_("shaggify", modelContents, false));
    }
    
    public void m_6213_(final ResourceManager pResourceManager) {
    }
    
    static {
        INSTANCE = new PatchModelLoader();
    }
}
