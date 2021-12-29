// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.registry.LanguageRegistry;
import java.net.URL;

public class TFLocalization
{
    public static void loadLocalizations() {
        final String[] arr$;
        final String[] langList = arr$ = new String[] { "en_US", "de_DE", "ru_RU", "zh_CN" };
        for (final Object langObj : arr$) {
            if (langObj instanceof String) {
                final URL urlResource = TFLocalization.class.getResource(String.format("/assets/twilightforest/lang/%s.xml", langObj));
                if (urlResource != null) {
                    loadLanguageURL(urlResource, (String)langObj);
                }
            }
        }
    }
    
    private static void loadLanguageURL(final URL urlResource, final String langObj) {
        LanguageRegistry.instance().loadLocalization(urlResource, langObj, true);
    }
}
