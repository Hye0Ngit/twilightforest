// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.block.Block;
import java.util.Random;
import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTFCinderFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFCinderFurnace extends TileEntity implements ISidedInventory
{
    private static final int SMELT_LOG_FACTOR = 10;
    private static final int SLOT_INPUT = 0;
    private static final int SLOT_FUEL = 1;
    private static final int SLOT_OUTPUT = 2;
    private static final int[] slotsTop;
    private static final int[] slotsBottom;
    private static final int[] slotsSides;
    private ItemStack[] furnaceItemStacks;
    public int furnaceBurnTime;
    public int currentItemBurnTime;
    public int furnaceCookTime;
    private String customName;
    
    public TileEntityTFCinderFurnace() {
        this.furnaceItemStacks = new ItemStack[3];
    }
    
    public int func_70302_i_() {
        return this.furnaceItemStacks.length;
    }
    
    public ItemStack func_70301_a(final int slot) {
        return this.furnaceItemStacks[slot];
    }
    
    public ItemStack func_70298_a(final int slot, final int amount) {
        if (this.furnaceItemStacks[slot] == null) {
            return null;
        }
        if (this.furnaceItemStacks[slot].field_77994_a <= amount) {
            final ItemStack itemstack = this.furnaceItemStacks[slot];
            this.furnaceItemStacks[slot] = null;
            return itemstack;
        }
        final ItemStack itemstack = this.furnaceItemStacks[slot].func_77979_a(amount);
        if (this.furnaceItemStacks[slot].field_77994_a == 0) {
            this.furnaceItemStacks[slot] = null;
        }
        return itemstack;
    }
    
    public ItemStack func_70304_b(final int slot) {
        if (this.furnaceItemStacks[slot] != null) {
            final ItemStack itemstack = this.furnaceItemStacks[slot];
            this.furnaceItemStacks[slot] = null;
            return itemstack;
        }
        return null;
    }
    
    public void func_70299_a(final int slot, final ItemStack itemStack) {
        this.furnaceItemStacks[slot] = itemStack;
        if (itemStack != null && itemStack.field_77994_a > this.func_70297_j_()) {
            itemStack.field_77994_a = this.func_70297_j_();
        }
    }
    
    public String func_145825_b() {
        return this.func_145818_k_() ? this.customName : "twilightforest.container.furnace";
    }
    
    public boolean func_145818_k_() {
        return this.customName != null && this.customName.length() > 0;
    }
    
    public void func_145839_a(final NBTTagCompound nbtTags) {
        super.func_145839_a(nbtTags);
        final NBTTagList nbttaglist = nbtTags.func_150295_c("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.func_70302_i_()];
        for (int i = 0; i < nbttaglist.func_74745_c(); ++i) {
            final NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
            final byte slot = nbttagcompound1.func_74771_c("Slot");
            if (slot >= 0 && slot < this.furnaceItemStacks.length) {
                this.furnaceItemStacks[slot] = ItemStack.func_77949_a(nbttagcompound1);
            }
        }
        this.furnaceBurnTime = nbtTags.func_74765_d("BurnTime");
        this.furnaceCookTime = nbtTags.func_74765_d("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
        if (nbtTags.func_150297_b("CustomName", 8)) {
            this.customName = nbtTags.func_74779_i("CustomName");
        }
    }
    
    public void func_145841_b(final NBTTagCompound nbtTags) {
        super.func_145841_b(nbtTags);
        nbtTags.func_74777_a("BurnTime", (short)this.furnaceBurnTime);
        nbtTags.func_74777_a("CookTime", (short)this.furnaceCookTime);
        final NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.furnaceItemStacks.length; ++i) {
            if (this.furnaceItemStacks[i] != null) {
                final NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.func_74774_a("Slot", (byte)i);
                this.furnaceItemStacks[i].func_77955_b(nbttagcompound1);
                nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
            }
        }
        nbtTags.func_74782_a("Items", (NBTBase)nbttaglist);
        if (this.func_145818_k_()) {
            nbtTags.func_74778_a("CustomName", this.customName);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(final int p_145953_1_) {
        return this.furnaceCookTime * p_145953_1_ / 200;
    }
    
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(final int p_145955_1_) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 200;
        }
        return this.furnaceBurnTime * p_145955_1_ / this.currentItemBurnTime;
    }
    
    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }
    
    public void func_145845_h() {
        final boolean flag = this.furnaceBurnTime > 0;
        boolean flag2 = false;
        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }
        if (!this.field_145850_b.field_72995_K) {
            if (this.furnaceBurnTime != 0 || (this.furnaceItemStacks[1] != null && this.furnaceItemStacks[0] != null)) {
                if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                    final int itemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
                    this.furnaceBurnTime = itemBurnTime;
                    this.currentItemBurnTime = itemBurnTime;
                    if (this.furnaceBurnTime > 0) {
                        flag2 = true;
                        if (this.furnaceItemStacks[1] != null) {
                            final ItemStack itemStack = this.furnaceItemStacks[1];
                            --itemStack.field_77994_a;
                            if (this.furnaceItemStacks[1].field_77994_a == 0) {
                                this.furnaceItemStacks[1] = this.furnaceItemStacks[1].func_77973_b().getContainerItem(this.furnaceItemStacks[1]);
                            }
                        }
                    }
                }
                if (this.isBurning() && this.canSmelt()) {
                    final int speedMultiplier = this.getCurrentSpeedMultiplier();
                    this.furnaceCookTime += speedMultiplier;
                    if (this.furnaceCookTime >= 200) {
                        this.furnaceCookTime = 0;
                        this.smeltItem();
                        flag2 = true;
                    }
                }
                else {
                    this.furnaceCookTime = 0;
                }
            }
            if (flag != this.furnaceBurnTime > 0) {
                flag2 = true;
                BlockTFCinderFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
            }
            if (this.isBurning() && this.furnaceBurnTime % 5 == 0) {
                this.cinderizeNearbyLog();
            }
        }
        if (flag2) {
            this.func_70296_d();
        }
    }
    
    private void cinderizeNearbyLog() {
        final Random rand = this.func_145831_w().field_73012_v;
        final int dx = rand.nextInt(2) - rand.nextInt(2);
        final int dy = rand.nextInt(2) - rand.nextInt(2);
        final int dz = rand.nextInt(2) - rand.nextInt(2);
        if (this.field_145850_b.func_72899_e(this.field_145851_c + dx, this.field_145848_d + dy, this.field_145849_e + dz)) {
            final Block nearbyBlock = this.func_145831_w().func_147439_a(this.field_145851_c + dx, this.field_145848_d + dy, this.field_145849_e + dz);
            if (nearbyBlock != TFBlocks.cinderLog && this.isLog(nearbyBlock)) {
                this.func_145831_w().func_147465_d(this.field_145851_c + dx, this.field_145848_d + dy, this.field_145849_e + dz, TFBlocks.cinderLog, this.getCinderMetaFor(dx, dy, dz), 2);
                this.func_145831_w().func_72926_e(2004, this.field_145851_c + dx, this.field_145848_d + dy, this.field_145849_e + dz, 0);
                this.func_145831_w().func_72926_e(2004, this.field_145851_c + dx, this.field_145848_d + dy, this.field_145849_e + dz, 0);
                this.func_145831_w().func_72908_a((double)(this.field_145851_c + dx + 0.5f), (double)(this.field_145848_d + dy + 0.5f), (double)(this.field_145849_e + dz + 0.5f), "fire.fire", 1.0f, 1.0f);
            }
        }
    }
    
    private int getCinderMetaFor(final int dx, final int dy, final int dz) {
        if (dz == 0 && dx != 0) {
            return (dy == 0) ? 4 : 8;
        }
        if (dx == 0 && dz != 0) {
            return (dy == 0) ? 8 : 4;
        }
        if (dx == 0 && dz == 0) {
            return 0;
        }
        return (dy == 0) ? 0 : 12;
    }
    
    private boolean isLog(final Block nearbyBlock) {
        final int[] oreIDs2;
        final int[] oreIDs = oreIDs2 = OreDictionary.getOreIDs(new ItemStack(nearbyBlock));
        for (final int id : oreIDs2) {
            if (id == OreDictionary.getOreID("logWood")) {
                return true;
            }
        }
        return false;
    }
    
    private int getCurrentSpeedMultiplier() {
        return this.getCurrentMultiplier(2);
    }
    
    private int getCurrentMultiplier(final int factor) {
        final int logs = this.countNearbyLogs();
        if (logs < factor) {
            return 1;
        }
        return logs / factor + ((this.field_145850_b.field_73012_v.nextInt(factor) < logs % factor) ? 1 : 0);
    }
    
    private int countNearbyLogs() {
        int count = 0;
        for (int dx = -1; dx <= 1; ++dx) {
            for (int dy = -1; dy <= 1; ++dy) {
                for (int dz = -1; dz <= 1; ++dz) {
                    if (this.field_145850_b.func_72899_e(this.field_145851_c + dx, this.field_145848_d + dy, this.field_145849_e + dz) && this.func_145831_w().func_147439_a(this.field_145851_c + dx, this.field_145848_d + dy, this.field_145849_e + dz) == TFBlocks.cinderLog) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    
    private boolean canSmelt() {
        if (this.furnaceItemStacks[0] == null) {
            return false;
        }
        final ItemStack outputStack = FurnaceRecipes.func_77602_a().func_151395_a(this.furnaceItemStacks[0]);
        if (outputStack == null) {
            return false;
        }
        if (this.furnaceItemStacks[2] == null) {
            return true;
        }
        if (!this.furnaceItemStacks[2].func_77969_a(outputStack)) {
            return false;
        }
        final int resultStackSize = this.furnaceItemStacks[2].field_77994_a + this.getMaxOutputStacks(this.furnaceItemStacks[0], outputStack);
        return resultStackSize <= this.func_70297_j_() && resultStackSize <= this.furnaceItemStacks[2].func_77976_d();
    }
    
    public int getMaxOutputStacks(final ItemStack input, final ItemStack output) {
        if (this.canMultiply(input, output)) {
            return output.field_77994_a * this.getCurrentMaxSmeltMultiplier();
        }
        return output.field_77994_a;
    }
    
    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack outputStack = FurnaceRecipes.func_77602_a().func_151395_a(this.furnaceItemStacks[0]);
            if (this.canMultiply(this.furnaceItemStacks[0], outputStack)) {
                final int smeltMultiplier = this.getCurrentSmeltMultiplier();
                if (smeltMultiplier > 1) {
                    final ItemStack func_77946_l;
                    outputStack = (func_77946_l = outputStack.func_77946_l());
                    func_77946_l.field_77994_a *= smeltMultiplier;
                }
            }
            if (this.furnaceItemStacks[2] == null) {
                this.furnaceItemStacks[2] = outputStack.func_77946_l();
            }
            else if (this.furnaceItemStacks[2].func_77973_b() == outputStack.func_77973_b()) {
                final ItemStack itemStack = this.furnaceItemStacks[2];
                itemStack.field_77994_a += outputStack.field_77994_a;
            }
            final ItemStack itemStack2 = this.furnaceItemStacks[0];
            --itemStack2.field_77994_a;
            if (this.furnaceItemStacks[0].field_77994_a <= 0) {
                this.furnaceItemStacks[0] = null;
            }
        }
    }
    
    public boolean canMultiply(final ItemStack input, final ItemStack output) {
        final int[] oreIDs2;
        final int[] oreIDs = oreIDs2 = OreDictionary.getOreIDs(input);
        for (final int id : oreIDs2) {
            if (OreDictionary.getOreName(id).startsWith("ore")) {
                return true;
            }
            if (id == OreDictionary.getOreID("logWood")) {
                return true;
            }
        }
        return false;
    }
    
    private int getCurrentSmeltMultiplier() {
        return this.getCurrentMultiplier(10);
    }
    
    private int getCurrentMaxSmeltMultiplier() {
        return (int)Math.ceil(this.countNearbyLogs() / 10.0f);
    }
    
    public static int getItemBurnTime(final ItemStack p_145952_0_) {
        if (p_145952_0_ == null) {
            return 0;
        }
        final Item item = p_145952_0_.func_77973_b();
        if (item instanceof ItemBlock && Block.func_149634_a(item) != Blocks.field_150350_a) {
            final Block block = Block.func_149634_a(item);
            if (block == Blocks.field_150376_bx) {
                return 150;
            }
            if (block.func_149688_o() == Material.field_151575_d) {
                return 300;
            }
            if (block == Blocks.field_150402_ci) {
                return 16000;
            }
        }
        if (item instanceof ItemTool && ((ItemTool)item).func_77861_e().equals("WOOD")) {
            return 200;
        }
        if (item instanceof ItemSword && ((ItemSword)item).func_150932_j().equals("WOOD")) {
            return 200;
        }
        if (item instanceof ItemHoe && ((ItemHoe)item).func_77842_f().equals("WOOD")) {
            return 200;
        }
        if (item == Items.field_151055_y) {
            return 100;
        }
        if (item == Items.field_151044_h) {
            return 1600;
        }
        if (item == Items.field_151129_at) {
            return 20000;
        }
        if (item == Item.func_150898_a(Blocks.field_150345_g)) {
            return 100;
        }
        if (item == Items.field_151072_bj) {
            return 2400;
        }
        return GameRegistry.getFuelValue(p_145952_0_);
    }
    
    public static boolean isItemFuel(final ItemStack p_145954_0_) {
        return getItemBurnTime(p_145954_0_) > 0;
    }
    
    public int func_70297_j_() {
        return 64;
    }
    
    public boolean func_70300_a(final EntityPlayer player) {
        return this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) == this && player.func_70092_e(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5) <= 64.0;
    }
    
    public void func_70295_k_() {
    }
    
    public void func_70305_f() {
    }
    
    public boolean func_94041_b(final int slot, final ItemStack itemStack) {
        return slot != 2 && (slot != 1 || TileEntityFurnace.func_145954_b(itemStack));
    }
    
    public int[] func_94128_d(final int p_94128_1_) {
        return (p_94128_1_ == 0) ? TileEntityTFCinderFurnace.slotsBottom : ((p_94128_1_ == 1) ? TileEntityTFCinderFurnace.slotsTop : TileEntityTFCinderFurnace.slotsSides);
    }
    
    public boolean func_102007_a(final int slot, final ItemStack itemStack, final int side) {
        return this.func_94041_b(slot, itemStack);
    }
    
    public boolean func_102008_b(final int slot, final ItemStack itemStack, final int side) {
        return side != 0 || slot != 1 || itemStack.func_77973_b() == Items.field_151133_ar;
    }
    
    static {
        slotsTop = new int[] { 0 };
        slotsBottom = new int[] { 2, 1 };
        slotsSides = new int[] { 1 };
    }
}
