// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.BlockTFGiantBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import com.google.common.collect.Multimap;
import net.minecraft.util.StatCollector;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Items;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ItemTFGiantPick extends ItemPickaxe
{
    private float damageVsEntity;
    private GiantItemIcon giantIcon;
    
    protected ItemTFGiantPick(final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.damageVsEntity = 4.0f + par2EnumToolMaterial.func_78000_c();
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.func_77973_b() == TFItems.knightMetal || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = Items.field_151050_s.func_77617_a(0);
        this.giantIcon = new GiantItemIcon(this.field_77791_bV, 0.4375f, 0.125f);
    }
    
    public IIcon getIcon(final ItemStack stack, final int pass) {
        if (pass == -1) {
            return (IIcon)this.giantIcon;
        }
        return super.getIcon(stack, pass);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(StatCollector.func_74838_a(this.func_77658_a() + ".tooltip"));
    }
    
    public Multimap func_111205_h() {
        final Multimap multimap = super.func_111205_h();
        multimap.removeAll((Object)SharedMonsterAttributes.field_111264_e.func_111108_a());
        multimap.put((Object)SharedMonsterAttributes.field_111264_e.func_111108_a(), (Object)new AttributeModifier(ItemTFGiantPick.field_111210_e, "Tool modifier", (double)this.damageVsEntity, 0));
        return multimap;
    }
    
    public float func_150893_a(final ItemStack par1ItemStack, final Block par2Block) {
        float strVsBlock = super.func_150893_a(par1ItemStack, par2Block);
        strVsBlock *= ((par2Block == TFBlocks.giantObsidian) ? 64.0f : 1.0f);
        return this.isGiantBlock(par2Block) ? (strVsBlock * 64.0f) : strVsBlock;
    }
    
    private boolean isGiantBlock(final Block block) {
        return block instanceof BlockTFGiantBlock;
    }
}
