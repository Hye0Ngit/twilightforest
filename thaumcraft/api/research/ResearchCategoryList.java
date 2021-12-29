// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api.research;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.ResourceLocation;

public class ResearchCategoryList
{
    public int minDisplayColumn;
    public int minDisplayRow;
    public int maxDisplayColumn;
    public int maxDisplayRow;
    public ResourceLocation icon;
    public ResourceLocation background;
    public Map<String, ResearchItem> research;
    
    public ResearchCategoryList(final ResourceLocation icon, final ResourceLocation background) {
        this.research = new HashMap<String, ResearchItem>();
        this.icon = icon;
        this.background = background;
    }
}
