// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.registry.LanguageRegistry;
import java.net.URL;
import java.util.Iterator;
import net.minecraft.util.StringTranslate;

public class TFLocalization
{
    public static void loadLocalizations() {
        for (final Object langObj : StringTranslate.func_74808_a().func_74806_b().keySet()) {
            if (langObj instanceof String) {
                final URL urlResource = TFLocalization.class.getResource(String.format("/twilightforest/lang/%s.xml", langObj));
                if (urlResource == null) {
                    continue;
                }
                loadLanguageURL(urlResource, (String)langObj);
            }
        }
    }
    
    private static void loadLanguageURL(final URL urlResource, final String langObj) {
        LanguageRegistry.instance().loadLocalization(urlResource, langObj, true);
    }
    
    protected static void loadLanguage(final String langString) {
        LanguageRegistry.instance().loadLocalization(String.format("/twilightforest/lang/%s.xml", langString), langString, true);
    }
}
