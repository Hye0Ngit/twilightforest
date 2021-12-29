// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class TFLocalization
{
    public static void loadLocalizations() {
        loadLanguage("en_US");
        loadLanguage("ru_RU");
        loadLanguage("de_DE");
    }
    
    protected static void loadLanguage(final String langString) {
        LanguageRegistry.instance().loadLocalization(String.format("/twilightforest/lang/%s.xml", langString), langString, true);
    }
}
