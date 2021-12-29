// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFItems
{
    public static hg nagaScale;
    
    public TFItems() {
        TFItems.nagaScale = new hg(mod_TwilightForest.idItemNagaScale).d(this.override("nagascale.png")).a("nagaScale");
    }
    
    public int override(final String s) {
        return ModLoader.addOverride("/gui/items.png", "/twilightforest/items/" + s);
    }
}
