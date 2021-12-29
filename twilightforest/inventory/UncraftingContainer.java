// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import net.minecraft.core.BlockPos;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import java.util.Arrays;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.item.crafting.RecipeType;
import twilightforest.item.recipe.TFRecipes;
import twilightforest.TFConfig;
import java.util.List;
import net.minecraft.world.item.crafting.Recipe;
import java.util.ArrayList;
import twilightforest.util.TFItemStackUtils;
import net.minecraft.nbt.ByteTag;
import java.util.Iterator;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.enchantment.Enchantment;
import java.util.Map;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.crafting.IShapedRecipe;
import twilightforest.item.recipe.UncraftingRecipe;
import net.minecraft.tags.Tag;
import twilightforest.data.ItemTagGenerator;
import twilightforest.inventory.slot.AssemblySlot;
import twilightforest.inventory.slot.UncraftingSlot;
import twilightforest.inventory.slot.UncraftingResultSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class UncraftingContainer extends AbstractContainerMenu
{
    private static final String TAG_MARKER = "TwilightForestMarker";
    private final UncraftingInventory uncraftingMatrix;
    public final CraftingContainer assemblyMatrix;
    private final CraftingContainer combineMatrix;
    public final Container tinkerInput;
    private final ResultContainer tinkerResult;
    private final ContainerLevelAccess positionData;
    private final Level world;
    private final Player player;
    public int unrecipeInCycle;
    public int ingredientsInCycle;
    public int recipeInCycle;
    private static int customCost;
    
    public static UncraftingContainer fromNetwork(final int id, final Inventory inventory) {
        return new UncraftingContainer(id, inventory, inventory.f_35978_.f_19853_, ContainerLevelAccess.f_39287_);
    }
    
    public UncraftingContainer(final int id, final Inventory inventory, final Level world, final ContainerLevelAccess positionData) {
        super((MenuType)TFContainers.UNCRAFTING.get(), id);
        this.uncraftingMatrix = new UncraftingInventory();
        this.assemblyMatrix = new CraftingContainer((AbstractContainerMenu)this, 3, 3);
        this.combineMatrix = new CraftingContainer((AbstractContainerMenu)this, 3, 3);
        this.tinkerInput = (Container)new UncraftingInputInventory(this);
        this.tinkerResult = new ResultContainer();
        this.unrecipeInCycle = 0;
        this.ingredientsInCycle = 0;
        this.recipeInCycle = 0;
        this.positionData = positionData;
        this.world = world;
        this.player = inventory.f_35978_;
        this.m_38897_(new Slot(this.tinkerInput, 0, 13, 35));
        this.m_38897_((Slot)new UncraftingResultSlot(inventory.f_35978_, this.tinkerInput, (Container)this.uncraftingMatrix, (Container)this.assemblyMatrix, (Container)this.tinkerResult, 0, 147, 35));
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.m_38897_((Slot)new UncraftingSlot(inventory.f_35978_, this.tinkerInput, this.uncraftingMatrix, (Container)this.assemblyMatrix, invY + invX * 3, 300000 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 3; ++invY) {
                this.m_38897_((Slot)new AssemblySlot((Container)this.assemblyMatrix, invY + invX * 3, 62 + invY * 18, 17 + invX * 18));
            }
        }
        for (int invX = 0; invX < 3; ++invX) {
            for (int invY = 0; invY < 9; ++invY) {
                this.m_38897_(new Slot((Container)inventory, invY + invX * 9 + 9, 8 + invY * 18, 84 + invX * 18));
            }
        }
        for (int invX = 0; invX < 9; ++invX) {
            this.m_38897_(new Slot((Container)inventory, invX, 8 + invX * 18, 142));
        }
        this.m_6199_((Container)this.assemblyMatrix);
    }
    
    public void m_6199_(final Container inventory) {
        if (inventory == this.tinkerInput) {
            this.uncraftingMatrix.m_6211_();
            final ItemStack inputStack = this.tinkerInput.m_8020_(0);
            final CraftingRecipe[] recipes = getRecipesFor(inputStack, this.world);
            final int size = recipes.length;
            if (size > 0 && !inputStack.m_150922_((Tag)ItemTagGenerator.BANNED_UNCRAFTABLES)) {
                final CraftingRecipe recipe = recipes[Math.floorMod(this.unrecipeInCycle, size)];
                UncraftingContainer.customCost = ((recipe instanceof UncraftingRecipe) ? ((UncraftingRecipe)recipe).getCost() : -1);
                final ItemStack[] recipeItems = this.getIngredients(recipe);
                final CraftingRecipe craftingRecipe = recipe;
                if (craftingRecipe instanceof final IShapedRecipe rec) {
                    final int recipeWidth = rec.getRecipeWidth();
                    for (int recipeHeight = rec.getRecipeHeight(), invY = 0; invY < recipeHeight; ++invY) {
                        for (int invX = 0; invX < recipeWidth; ++invX) {
                            final int index = invX + invY * recipeWidth;
                            if (index < recipeItems.length) {
                                final ItemStack ingredient = normalizeIngredient(recipeItems[index].m_41777_());
                                this.uncraftingMatrix.m_6836_(invX + invY * 3, ingredient);
                            }
                        }
                    }
                }
                else {
                    for (int i = 0; i < this.uncraftingMatrix.m_6643_(); ++i) {
                        if (i < recipeItems.length) {
                            final ItemStack ingredient2 = normalizeIngredient(recipeItems[i].m_41777_());
                            this.uncraftingMatrix.m_6836_(i, ingredient2);
                        }
                    }
                }
                if (inputStack.m_41768_()) {
                    for (int damagedParts = this.countDamagedParts(inputStack), i = 0; i < 9 && damagedParts > 0; ++i) {
                        final ItemStack stack = this.uncraftingMatrix.m_8020_(i);
                        if (isDamageableComponent(stack)) {
                            markStack(stack);
                            --damagedParts;
                        }
                    }
                }
                for (int j = 0; j < 9; ++j) {
                    final ItemStack ingredient3 = this.uncraftingMatrix.m_8020_(j);
                    if (isIngredientProblematic(ingredient3)) {
                        markStack(ingredient3);
                    }
                }
                this.uncraftingMatrix.numberOfInputItems = recipe.m_8043_().m_41613_();
                if (recipe instanceof final UncraftingRecipe uncraftingRecipe) {
                    this.uncraftingMatrix.numberOfInputItems = uncraftingRecipe.getCount();
                }
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                UncraftingContainer.customCost = -1;
                this.uncraftingMatrix.numberOfInputItems = 0;
                this.uncraftingMatrix.uncraftingCost = 0;
            }
        }
        if (inventory == this.assemblyMatrix || inventory == this.tinkerInput) {
            if (this.tinkerInput.m_7983_()) {
                this.chooseRecipe(this.assemblyMatrix);
                this.uncraftingMatrix.recraftingCost = 0;
            }
            else {
                this.tinkerResult.m_6836_(0, ItemStack.f_41583_);
                this.uncraftingMatrix.uncraftingCost = this.calculateUncraftingCost();
                this.uncraftingMatrix.recraftingCost = 0;
            }
        }
        if (inventory != this.combineMatrix && !this.uncraftingMatrix.m_7983_() && !this.assemblyMatrix.m_7983_()) {
            for (int k = 0; k < 9; ++k) {
                final ItemStack assembly = this.assemblyMatrix.m_8020_(k);
                final ItemStack uncrafting = this.uncraftingMatrix.m_8020_(k);
                if (!assembly.m_41619_()) {
                    this.combineMatrix.m_6836_(k, assembly);
                }
                else if (!uncrafting.m_41619_() && !isMarked(uncrafting)) {
                    this.combineMatrix.m_6836_(k, uncrafting);
                }
                else {
                    this.combineMatrix.m_6836_(k, ItemStack.f_41583_);
                }
            }
            this.chooseRecipe(this.combineMatrix);
            final ItemStack input = this.tinkerInput.m_8020_(0);
            final ItemStack result = this.tinkerResult.m_8020_(0);
            if (!result.m_41619_() && isValidMatchForInput(input, result)) {
                CompoundTag inputTags = null;
                if (input.m_41783_() != null) {
                    inputTags = input.m_41783_().m_6426_();
                }
                final Map<Enchantment, Integer> resultInnateEnchantments = EnchantmentHelper.m_44831_(result);
                final Map<Enchantment, Integer> inputEnchantments = EnchantmentHelper.m_44831_(input);
                inputEnchantments.keySet().removeIf(enchantment -> enchantment == null || !enchantment.m_6081_(result));
                if (inputTags != null) {
                    inputTags.m_128473_("ench");
                    result.m_41751_(inputTags);
                    EnchantmentHelper.m_44865_((Map)inputEnchantments, result);
                }
                for (final Map.Entry<Enchantment, Integer> entry : resultInnateEnchantments.entrySet()) {
                    final Enchantment ench = entry.getKey();
                    final int level = entry.getValue();
                    if (EnchantmentHelper.m_44843_(ench, result) < level) {
                        result.m_41663_(ench, level);
                    }
                }
                this.tinkerResult.m_6836_(0, result);
                this.uncraftingMatrix.uncraftingCost = 0;
                this.uncraftingMatrix.recraftingCost = this.calculateRecraftingCost();
                if (this.uncraftingMatrix.recraftingCost > 0 && !result.m_41788_()) {
                    result.m_41742_(input.m_41610_() + 2);
                }
            }
        }
    }
    
    public static void markStack(final ItemStack stack) {
        stack.m_41700_("TwilightForestMarker", (net.minecraft.nbt.Tag)ByteTag.m_128266_((byte)1));
    }
    
    public static boolean isMarked(final ItemStack stack) {
        final CompoundTag stackTag = stack.m_41783_();
        return stackTag != null && stackTag.m_128471_("TwilightForestMarker");
    }
    
    public static void unmarkStack(final ItemStack stack) {
        TFItemStackUtils.clearInfoTag(stack, "TwilightForestMarker");
    }
    
    private static boolean isIngredientProblematic(final ItemStack ingredient) {
        return !ingredient.m_41619_() && ingredient.m_41720_().hasContainerItem(ingredient);
    }
    
    private static ItemStack normalizeIngredient(final ItemStack ingredient) {
        if (ingredient.m_41613_() > 1) {
            ingredient.m_41764_(1);
        }
        return ingredient;
    }
    
    private static CraftingRecipe[] getRecipesFor(final ItemStack inputStack, final Level world) {
        final List<CraftingRecipe> recipes = new ArrayList<CraftingRecipe>();
        if (!inputStack.m_41619_()) {
            for (final Recipe recipe2 : world.m_7465_().m_44051_()) {
                final Recipe<?> recipe = (Recipe<?>)recipe2;
                if (recipe2 instanceof final CraftingRecipe rec) {
                    if (!recipe.m_8004_(3, 3) || recipe.m_7527_().isEmpty() || !matches(inputStack, recipe.m_8043_()) || ((List)TFConfig.COMMON_CONFIG.UNCRAFTING_STUFFS.disableUncraftingRecipes.get()).contains(recipe.m_6423_().toString()) || (boolean)TFConfig.COMMON_CONFIG.UNCRAFTING_STUFFS.flipUncraftingModIdList.get() != ((List)TFConfig.COMMON_CONFIG.UNCRAFTING_STUFFS.blacklistedUncraftingModIds.get()).contains(recipe.m_6423_().m_135827_())) {
                        continue;
                    }
                    recipes.add(rec);
                }
            }
            for (final UncraftingRecipe uncraftingRecipe : world.m_7465_().m_44013_((RecipeType)TFRecipes.UNCRAFTING_RECIPE)) {
                if (uncraftingRecipe.isItemStackAnIngredient(inputStack)) {
                    recipes.add((CraftingRecipe)uncraftingRecipe);
                }
            }
        }
        return recipes.toArray(new CraftingRecipe[0]);
    }
    
    private static boolean matches(final ItemStack input, final ItemStack output) {
        return input.m_41720_() == output.m_41720_() && input.m_41613_() >= output.m_41613_();
    }
    
    private static CraftingRecipe[] getRecipesFor(final CraftingContainer matrix, final Level world) {
        return world.m_7465_().m_44056_(RecipeType.f_44107_, (Container)matrix, world).toArray(new CraftingRecipe[0]);
    }
    
    private void chooseRecipe(final CraftingContainer inventory) {
        final CraftingRecipe[] recipes = getRecipesFor(inventory, this.world);
        if (recipes.length == 0) {
            this.tinkerResult.m_6836_(0, ItemStack.f_41583_);
            return;
        }
        final CraftingRecipe recipe = recipes[Math.floorMod(this.recipeInCycle, recipes.length)];
        if (recipe != null && (recipe.m_5598_() || !this.world.m_46469_().m_46207_(GameRules.f_46151_) || ((ServerPlayer)this.player).m_8952_().m_12709_((Recipe)recipe))) {
            this.tinkerResult.m_6029_((Recipe)recipe);
            this.tinkerResult.m_6836_(0, recipe.m_5874_((Container)inventory));
        }
        else {
            this.tinkerResult.m_6836_(0, ItemStack.f_41583_);
        }
    }
    
    private static boolean isValidMatchForInput(final ItemStack inputStack, final ItemStack resultStack) {
        if (inputStack.m_41720_() instanceof PickaxeItem && resultStack.m_41720_() instanceof PickaxeItem) {
            return true;
        }
        if (inputStack.m_41720_() instanceof AxeItem && resultStack.m_41720_() instanceof AxeItem) {
            return true;
        }
        if (inputStack.m_41720_() instanceof ShovelItem && resultStack.m_41720_() instanceof ShovelItem) {
            return true;
        }
        if (inputStack.m_41720_() instanceof HoeItem && resultStack.m_41720_() instanceof HoeItem) {
            return true;
        }
        if (inputStack.m_41720_() instanceof SwordItem && resultStack.m_41720_() instanceof SwordItem) {
            return true;
        }
        if (inputStack.m_41720_() instanceof BowItem && resultStack.m_41720_() instanceof BowItem) {
            return true;
        }
        final Item 41720_ = inputStack.m_41720_();
        if (41720_ instanceof final ArmorItem inputArmor) {
            final Item 41720_2 = resultStack.m_41720_();
            if (41720_2 instanceof final ArmorItem resultArmor) {
                return inputArmor.m_40402_() == resultArmor.m_40402_();
            }
        }
        return false;
    }
    
    public int getUncraftingCost() {
        return this.uncraftingMatrix.uncraftingCost;
    }
    
    public int getRecraftingCost() {
        return this.uncraftingMatrix.recraftingCost;
    }
    
    private int calculateUncraftingCost() {
        if (this.assemblyMatrix.m_7983_()) {
            return (UncraftingContainer.customCost >= 0) ? UncraftingContainer.customCost : countDamageableParts((Container)this.uncraftingMatrix);
        }
        return 0;
    }
    
    private int calculateRecraftingCost() {
        final ItemStack input = this.tinkerInput.m_8020_(0);
        final ItemStack output = this.tinkerResult.m_8020_(0);
        if (input.m_41619_() || !input.m_41793_() || output.m_41619_()) {
            return 0;
        }
        int cost = 0;
        cost += input.m_41610_();
        final int enchantCost = countTotalEnchantmentCost(input);
        cost += enchantCost;
        final int damagedCost = (1 + this.countDamagedParts(input)) * EnchantmentHelper.m_44831_(output).size();
        cost += damagedCost;
        final int enchantabilityDifference = input.m_41720_().m_6473_() - output.m_41720_().m_6473_();
        cost += enchantabilityDifference;
        cost = Math.max(1, cost);
        return cost;
    }
    
    private static int countTotalEnchantmentCost(final ItemStack stack) {
        int count = 0;
        for (final Map.Entry<Enchantment, Integer> entry : EnchantmentHelper.m_44831_(stack).entrySet()) {
            final Enchantment ench = entry.getKey();
            final int level = entry.getValue();
            if (ench != null && level > 0) {
                count += getWeightModifier(ench) * level;
                ++count;
            }
        }
        return count;
    }
    
    private static int getWeightModifier(final Enchantment ench) {
        return switch (ench.m_44699_().m_44716_()) {
            case 1 -> 8;
            case 2 -> 4;
            case 3,  4,  5 -> 2;
            default -> 1;
        };
    }
    
    public void m_150399_(int slotNum, final int mouseButton, final ClickType clickType, final Player player) {
        if (slotNum > 0 && ((Slot)this.f_38839_.get(slotNum)).f_40218_ == this.assemblyMatrix && player.f_36096_.m_142621_().m_41619_() && !((Slot)this.f_38839_.get(slotNum)).m_6657_() && this.assemblyMatrix.m_7983_()) {
            slotNum -= 9;
        }
        if (slotNum > 0 && ((Slot)this.f_38839_.get(slotNum)).f_40218_ == this.tinkerResult && this.calculateRecraftingCost() > player.f_36078_ && !player.m_150110_().f_35937_) {
            return;
        }
        if (slotNum > 0 && ((Slot)this.f_38839_.get(slotNum)).f_40218_ == this.uncraftingMatrix) {
            if (this.calculateUncraftingCost() > player.f_36078_ && !player.m_150110_().f_35937_) {
                return;
            }
            if (TFConfig.COMMON_CONFIG.UNCRAFTING_STUFFS.disableUncrafting.get()) {
                return;
            }
            final ItemStack stackInSlot = ((Slot)this.f_38839_.get(slotNum)).m_7993_();
            if (stackInSlot.m_41619_() || isMarked(stackInSlot)) {
                return;
            }
        }
        super.m_150399_(slotNum, mouseButton, clickType, player);
        if (slotNum > 0 && ((Slot)this.f_38839_.get(slotNum)).f_40218_ == this.tinkerInput) {
            this.m_6199_(this.tinkerInput);
        }
    }
    
    private static boolean isDamageableComponent(final ItemStack itemStack) {
        return !itemStack.m_41619_() && itemStack.m_41720_() != Items.f_42398_;
    }
    
    private static int countDamageableParts(final Container matrix) {
        int count = 0;
        for (int i = 0; i < matrix.m_6643_(); ++i) {
            if (!matrix.m_8020_(i).m_41619_()) {
                ++count;
            }
            if (isIngredientProblematic(matrix.m_8020_(i)) || isMarked(matrix.m_8020_(i))) {
                --count;
            }
        }
        return count;
    }
    
    private int countDamagedParts(final ItemStack input) {
        final int totalMax4 = Math.max(4, countDamageableParts((Container)this.uncraftingMatrix));
        final float damage = input.m_41773_() / (float)input.m_41776_();
        return (int)Math.ceil(totalMax4 * damage);
    }
    
    public ItemStack m_7648_(final Player player, final int slotNum) {
        ItemStack itemstack = ItemStack.f_41583_;
        final Slot slot = (Slot)this.f_38839_.get(slotNum);
        if (slot != null && slot.m_6657_()) {
            final ItemStack itemstack2 = slot.m_7993_();
            itemstack = itemstack2.m_41777_();
            if (slotNum == 0) {
                if (!this.m_38903_(itemstack2, 20, 56, false)) {
                    return ItemStack.f_41583_;
                }
                slot.m_40234_(itemstack2, itemstack);
            }
            else if (slotNum == 1) {
                this.positionData.m_39292_((p_39378_, p_39379_) -> itemstack1.m_41720_().m_7836_(itemstack1, p_39378_, player));
                if (!this.m_38903_(itemstack2, 20, 56, true)) {
                    return ItemStack.f_41583_;
                }
                slot.m_40234_(itemstack2, itemstack);
            }
            else if (slotNum >= 20 && slotNum < 56) {
                if (!this.m_38903_(itemstack2, 0, 1, false)) {
                    return ItemStack.f_41583_;
                }
            }
            else if (slot.f_40218_ == this.assemblyMatrix) {
                if (!this.m_38903_(itemstack2, 20, 56, false)) {
                    return ItemStack.f_41583_;
                }
            }
            else if (this.m_38903_(itemstack2, 20, 56, false)) {
                slot.m_142406_(player, itemstack2);
                return ItemStack.f_41583_;
            }
            if (itemstack2.m_41619_()) {
                slot.m_5852_(ItemStack.f_41583_);
            }
            else {
                slot.m_6654_();
            }
            if (itemstack2.m_41613_() == itemstack.m_41613_()) {
                return ItemStack.f_41583_;
            }
            slot.m_142406_(player, itemstack2);
            if (slotNum == 1) {
                player.m_36176_(itemstack2, false);
            }
        }
        return itemstack;
    }
    
    public void m_6877_(final Player player) {
        super.m_6877_(player);
        this.positionData.m_39292_((world, pos) -> {
            this.m_150411_(player, (Container)this.assemblyMatrix);
            this.m_150411_(player, this.tinkerInput);
        });
    }
    
    private ItemStack[] getIngredients(final CraftingRecipe recipe) {
        final ItemStack[] stacks = new ItemStack[recipe.m_7527_().size()];
        for (int i = 0; i < recipe.m_7527_().size(); ++i) {
            final ItemStack[] matchingStacks = Arrays.stream(((Ingredient)recipe.m_7527_().get(i)).m_43908_()).filter(s -> !s.m_150922_((Tag)ItemTagGenerator.BANNED_UNCRAFTING_INGREDIENTS)).toArray(ItemStack[]::new);
            stacks[i] = ((matchingStacks.length > 0) ? matchingStacks[Math.floorMod(this.ingredientsInCycle, matchingStacks.length)] : ItemStack.f_41583_);
        }
        return stacks;
    }
    
    public boolean m_6875_(final Player player) {
        return m_38889_(this.positionData, player, (Block)TFBlocks.UNCRAFTING_TABLE.get());
    }
}
