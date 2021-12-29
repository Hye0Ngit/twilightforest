// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.patchouli;

import vazkii.patchouli.api.IComponentRenderContext;
import net.minecraft.util.math.MathHelper;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.function.Function;
import vazkii.patchouli.common.util.ItemStackUtil;
import java.util.Arrays;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import java.util.List;
import vazkii.patchouli.api.VariableHolder;
import com.google.gson.annotations.SerializedName;
import vazkii.patchouli.api.ICustomComponent;

public class GalleryComponent implements ICustomComponent
{
    int x;
    int y;
    @SerializedName("table_x")
    int xCount;
    @VariableHolder
    public String items;
    private transient List<ItemStack> stacks;
    private static final transient Minecraft mc;
    
    public GalleryComponent() {
        this.xCount = 6;
    }
    
    public void build(final int x, final int y, final int pageNum) {
        this.stacks = Arrays.stream(this.items.split("\\|")).map((Function<? super String, ?>)ItemStackUtil::loadStackFromString).filter(i -> !i.func_190926_b()).collect((Collector<? super Object, ?, List<ItemStack>>)Collectors.toList());
        if (this.xCount <= 0 || this.xCount > 6) {
            this.xCount = MathHelper.func_76125_a(this.stacks.size(), 1, 6);
        }
    }
    
    public void render(final IComponentRenderContext context, final float pTicks, final int mouseX, final int mouseY) {
        final int x = this.x + 5;
        final int y = this.y;
        final int listSize = this.stacks.size();
        final int extras = Math.floorMod(listSize, this.xCount);
        final int listBlock = listSize - extras;
        for (int c = 0; c < listSize; ++c) {
            final ItemStack stack = this.stacks.get(c);
            final int column = Math.floorMod(c, this.xCount);
            final int row = c / this.xCount;
            if (c < listBlock) {
                context.renderItemStack(column * 18 + x, row * 18 + y, mouseX, mouseY, stack);
            }
            else {
                final int columnPushed = column * 18 + 54 - extras * 9;
                context.renderItemStack(columnPushed + x, row * 18 + y, mouseX, mouseY, stack);
            }
        }
    }
    
    static {
        mc = Minecraft.func_71410_x();
    }
}
