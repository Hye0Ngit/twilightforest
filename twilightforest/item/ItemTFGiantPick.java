// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import com.google.common.collect.Multimap;
import net.minecraft.inventory.EntityEquipmentSlot;
import twilightforest.block.BlockTFGiantBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemPickaxe;

public class ItemTFGiantPick extends ItemPickaxe implements ModelRegisterCallback
{
    protected ItemTFGiantPick(final Item.ToolMaterial material) {
        super(material);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.field_77865_bY = 8.0f + material.func_78000_c();
        this.field_185065_c = -3.5f;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add(I18n.func_135052_a(this.func_77658_a() + ".tooltip", new Object[0]));
    }
    
    public float func_150893_a(final ItemStack stack, final IBlockState state) {
        float destroySpeed = super.func_150893_a(stack, state);
        destroySpeed *= ((state.func_177230_c() == TFBlocks.giant_obsidian) ? 64.0f : 1.0f);
        return (state.func_177230_c() instanceof BlockTFGiantBlock) ? (destroySpeed * 64.0f) : destroySpeed;
    }
    
    public Multimap<String, AttributeModifier> func_111205_h(final EntityEquipmentSlot equipmentSlot) {
        final Multimap<String, AttributeModifier> multimap = (Multimap<String, AttributeModifier>)super.func_111205_h(equipmentSlot);
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put((Object)EntityPlayer.REACH_DISTANCE.func_111108_a(), (Object)new AttributeModifier(TFItems.GIANT_REACH_MODIFIER, "Tool modifier", 2.5, 0));
        }
        return multimap;
    }
}
