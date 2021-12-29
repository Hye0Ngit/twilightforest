// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFItems
{
    public static acy nagaScale;
    
    public TFItems() {
        ModLoader.AddName((Object)(TFItems.nagaScale = new acy(mod_TwilightForest.idItemNagaScale).g(this.override("nagascale.png")).a("nagaScale")), "Naga Scale");
    }
    
    public int override(final String s) {
        return ModLoader.addOverride("/gui/items.png", "/twilightforest/items/" + s);
    }
}
