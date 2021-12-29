// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import net.minecraft.entity.player.InventoryPlayer;
import twilightforest.tileentity.TileEntityTFCinderFurnace;
import net.minecraft.inventory.Container;

public class ContainerTFCinderFurnace extends Container
{
    private TileEntityTFCinderFurnace tileFurnace;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
    
    public ContainerTFCinderFurnace(final InventoryPlayer inventory, final World world, final int x, final int y, final int z) {
        this(inventory, (TileEntityTFCinderFurnace)world.func_147438_o(x, y, z));
    }
    
    public ContainerTFCinderFurnace(final InventoryPlayer p_i1812_1_, final TileEntityTFCinderFurnace p_i1812_2_) {
        this.tileFurnace = p_i1812_2_;
        this.func_75146_a(new Slot((IInventory)p_i1812_2_, 0, 56, 17));
        this.func_75146_a(new Slot((IInventory)p_i1812_2_, 1, 56, 53));
        this.func_75146_a((Slot)new SlotFurnace(p_i1812_1_.field_70458_d, (IInventory)p_i1812_2_, 2, 116, 35));
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.func_75146_a(new Slot((IInventory)p_i1812_1_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            this.func_75146_a(new Slot((IInventory)p_i1812_1_, i, 8 + i * 18, 142));
        }
    }
    
    public void func_75132_a(final ICrafting p_75132_1_) {
        super.func_75132_a(p_75132_1_);
        p_75132_1_.func_71112_a((Container)this, 0, this.tileFurnace.furnaceCookTime);
        p_75132_1_.func_71112_a((Container)this, 1, this.tileFurnace.furnaceBurnTime);
        p_75132_1_.func_71112_a((Container)this, 2, this.tileFurnace.currentItemBurnTime);
    }
    
    public void func_75142_b() {
        super.func_75142_b();
        for (int i = 0; i < this.field_75149_d.size(); ++i) {
            final ICrafting icrafting = this.field_75149_d.get(i);
            if (this.lastCookTime != this.tileFurnace.furnaceCookTime) {
                icrafting.func_71112_a((Container)this, 0, this.tileFurnace.furnaceCookTime);
            }
            if (this.lastBurnTime != this.tileFurnace.furnaceBurnTime) {
                icrafting.func_71112_a((Container)this, 1, this.tileFurnace.furnaceBurnTime);
            }
            if (this.lastItemBurnTime != this.tileFurnace.currentItemBurnTime) {
                icrafting.func_71112_a((Container)this, 2, this.tileFurnace.currentItemBurnTime);
            }
        }
        this.lastCookTime = this.tileFurnace.furnaceCookTime;
        this.lastBurnTime = this.tileFurnace.furnaceBurnTime;
        this.lastItemBurnTime = this.tileFurnace.currentItemBurnTime;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_75137_b(final int p_75137_1_, final int p_75137_2_) {
        if (p_75137_1_ == 0) {
            this.tileFurnace.furnaceCookTime = p_75137_2_;
        }
        if (p_75137_1_ == 1) {
            this.tileFurnace.furnaceBurnTime = p_75137_2_;
        }
        if (p_75137_1_ == 2) {
            this.tileFurnace.currentItemBurnTime = p_75137_2_;
        }
    }
    
    public boolean func_75145_c(final EntityPlayer p_75145_1_) {
        return this.tileFurnace.func_70300_a(p_75145_1_);
    }
    
    public ItemStack func_82846_b(final EntityPlayer p_82846_1_, final int p_82846_2_) {
        ItemStack itemstack = null;
        final Slot slot = this.field_75151_b.get(p_82846_2_);
        if (slot != null && slot.func_75216_d()) {
            final ItemStack itemstack2 = slot.func_75211_c();
            itemstack = itemstack2.func_77946_l();
            if (p_82846_2_ == 2) {
                if (!this.func_75135_a(itemstack2, 3, 39, true)) {
                    return null;
                }
                slot.func_75220_a(itemstack2, itemstack);
            }
            else if (p_82846_2_ != 1 && p_82846_2_ != 0) {
                if (FurnaceRecipes.func_77602_a().func_151395_a(itemstack2) != null) {
                    if (!this.func_75135_a(itemstack2, 0, 1, false)) {
                        return null;
                    }
                }
                else if (TileEntityFurnace.func_145954_b(itemstack2)) {
                    if (!this.func_75135_a(itemstack2, 1, 2, false)) {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 3 && p_82846_2_ < 30) {
                    if (!this.func_75135_a(itemstack2, 30, 39, false)) {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && !this.func_75135_a(itemstack2, 3, 30, false)) {
                    return null;
                }
            }
            else if (!this.func_75135_a(itemstack2, 3, 39, false)) {
                return null;
            }
            if (itemstack2.field_77994_a == 0) {
                slot.func_75215_d((ItemStack)null);
            }
            else {
                slot.func_75218_e();
            }
            if (itemstack2.field_77994_a == itemstack.field_77994_a) {
                return null;
            }
            slot.func_82870_a(p_82846_1_, itemstack2);
        }
        return itemstack;
    }
}
