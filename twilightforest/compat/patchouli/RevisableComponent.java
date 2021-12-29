// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.patchouli;

import vazkii.patchouli.client.base.ClientAdvancements;
import vazkii.patchouli.common.base.PatchouliConfig;
import vazkii.patchouli.client.book.gui.GuiBook;
import vazkii.patchouli.api.IComponentRenderContext;
import vazkii.patchouli.client.book.gui.BookTextRenderer;
import vazkii.patchouli.api.VariableHolder;
import com.google.gson.annotations.SerializedName;
import vazkii.patchouli.api.ICustomComponent;

public class RevisableComponent implements ICustomComponent
{
    int x;
    int y;
    @SerializedName("advancement_key")
    @VariableHolder
    public String advancementKey;
    @SerializedName("locked_text")
    @VariableHolder
    public String oldText;
    @VariableHolder
    @SerializedName("unlocked_text")
    public String newText;
    @SerializedName("max_width")
    int maxWidth;
    @SerializedName("line_height")
    int lineHeight;
    transient BookTextRenderer textRenderer;
    
    public RevisableComponent() {
        this.maxWidth = 116;
        this.lineHeight = 9;
    }
    
    public void build(final int x, final int y, final int pageNum) {
    }
    
    public void onDisplayed(final IComponentRenderContext context) {
        this.textRenderer = new BookTextRenderer((GuiBook)context.getGui(), (PatchouliConfig.disableAdvancementLocking || this.advancementKey == null || this.advancementKey.isEmpty() || ClientAdvancements.hasDone(this.advancementKey)) ? this.newText : this.oldText, this.x, this.y, this.maxWidth, this.lineHeight, -16777216);
    }
    
    public void render(final IComponentRenderContext context, final float pTicks, final int mouseX, final int mouseY) {
        this.textRenderer.render(mouseX, mouseY);
    }
    
    public void mouseClicked(final IComponentRenderContext context, final int mouseX, final int mouseY, final int mouseButton) {
        this.textRenderer.click(mouseX, mouseY, mouseButton);
    }
}
