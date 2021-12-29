// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.EntityTFCharmEffect;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class RenderTFCharm extends RenderSnowball<EntityTFCharmEffect>
{
    public RenderTFCharm(final RenderManager manager, final RenderItem itemRenderer) {
        super(manager, Item.func_150898_a(Blocks.field_180401_cv), itemRenderer);
    }
    
    public ItemStack getStackToRender(final EntityTFCharmEffect charm) {
        if (charm.getItemID() > -1) {
            return new ItemStack(Item.func_150899_d(charm.getItemID()));
        }
        return ItemStack.field_190927_a;
    }
}
