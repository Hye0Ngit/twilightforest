import forge.MinecraftForgeClient;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFItems
{
    public static ym nagaScale;
    
    public TFItems() {
        MinecraftForgeClient.preloadTexture("/twilightforest/terrain.png");
        ModLoader.addName((Object)(TFItems.nagaScale = new ItemTF(mod_TwilightForest.idItemNagaScale).e(0).a("nagaScale").b("+4+0+13")), "Naga Scale");
    }
}
