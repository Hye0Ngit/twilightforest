// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import net.minecraft.advancements.RequirementsStrategy;

record CountRequirementsStrategy(int... sizes) implements RequirementsStrategy {
    public String[][] m_15985_(final Collection<String> strings) {
        final String[][] requirements = new String[this.sizes.length][];
        final List<String> list = new ArrayList<String>(strings);
        int nextIndex = 0;
        for (int i = 0; i < this.sizes.length; ++i) {
            requirements[i] = new String[this.sizes[i]];
            for (int j = 0; j < this.sizes[i]; ++j) {
                requirements[i][j] = list.get(nextIndex);
                ++nextIndex;
            }
        }
        return requirements;
    }
}
