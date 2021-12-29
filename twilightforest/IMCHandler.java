// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTUtil;
import java.util.function.Consumer;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import com.google.common.collect.UnmodifiableIterator;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import twilightforest.world.feature.TFGenCaveStalactite;
import com.google.common.collect.ImmutableMultimap;
import net.minecraft.item.ItemStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.state.IBlockState;
import com.google.common.collect.ImmutableSet;

public class IMCHandler
{
    private static final ImmutableSet.Builder<IBlockState> BLACKLIST_BUILDER;
    private static final ImmutableList.Builder<IBlockState> ORE_BLOCKS_BUILDER;
    private static final ImmutableList.Builder<ItemStack> LOADING_ICONS_BUILDER;
    private static final ImmutableMultimap.Builder<IBlockState, IBlockState> CRUMBLE_BLOCKS_BUILDER;
    private static final ImmutableMultimap.Builder<Integer, TFGenCaveStalactite.StalactiteEntry> STALACTITE_BUILDER;
    
    static void onIMC(final FMLInterModComms.IMCEvent event) {
        for (final FMLInterModComms.IMCMessage message : event.getMessages()) {
            if (message.isNBTMessage()) {
                final NBTTagCompound imcCompound = message.getNBTValue();
                readStatesFromTagList(imcCompound.func_150295_c("Blacklist", 10), IMCHandler.BLACKLIST_BUILDER::add);
                readFromTagList(imcCompound.func_150295_c("Ore_Blocks", 10), IMCHandler::handleOre);
                readFromTagList(imcCompound.func_150295_c("Crumbling", 10), IMCHandler::handleCrumble);
            }
            if (message.isItemStackMessage() && message.key.equals("Loading_Icon")) {
                IMCHandler.LOADING_ICONS_BUILDER.add((Object)message.getItemStackValue());
            }
        }
    }
    
    private static void readFromTagList(final NBTTagList list, final Consumer<NBTTagCompound> consumer) {
        for (int i = 0; i < list.func_74745_c(); ++i) {
            consumer.accept(list.func_150305_b(i));
        }
    }
    
    private static void readStatesFromTagList(final NBTTagList list, final Consumer<IBlockState> consumer) {
        for (int i = 0; i < list.func_74745_c(); ++i) {
            final IBlockState state = NBTUtil.func_190008_d(list.func_150305_b(i));
            if (state.func_177230_c() != Blocks.field_150350_a) {
                consumer.accept(state);
            }
        }
    }
    
    private static void handleCrumble(final NBTTagCompound nbt) {
        final IBlockState key = NBTUtil.func_190008_d(nbt);
        if (key.func_177230_c() != Blocks.field_150350_a) {
            readStatesFromTagList(nbt.func_150295_c("Crumbling", 10), value -> IMCHandler.CRUMBLE_BLOCKS_BUILDER.put((Object)key, (Object)value));
        }
    }
    
    private static void handleOre(final NBTTagCompound nbt) {
        final IBlockState nbtState = NBTUtil.func_190008_d(nbt);
        if (nbtState.func_177230_c() != Blocks.field_150350_a) {
            IMCHandler.ORE_BLOCKS_BUILDER.add((Object)nbtState);
            if (nbt.func_150297_b("Stalactite_Settings", 10)) {
                final NBTTagCompound settings = nbt.func_74775_l("Stalactite_Settings");
                final int weight = readInt(settings, "Weight", 15);
                final int hillSize = readInt(settings, "Hill_Size", 3);
                final float size = readFloat(settings, "Size", 0.7f);
                final int maxLength = readInt(settings, "Max_Length", 8);
                final int minHeight = readInt(settings, "Min_Height", 1);
                IMCHandler.STALACTITE_BUILDER.put((Object)hillSize, (Object)new TFGenCaveStalactite.StalactiteEntry(nbtState, size, maxLength, minHeight, weight));
            }
        }
    }
    
    private static int readInt(final NBTTagCompound tag, final String key, final int defaultValue) {
        return tag.func_150297_b(key, 99) ? tag.func_74762_e(key) : defaultValue;
    }
    
    private static float readFloat(final NBTTagCompound tag, final String key, final float defaultValue) {
        return tag.func_150297_b(key, 99) ? tag.func_74760_g(key) : defaultValue;
    }
    
    public static ImmutableSet<IBlockState> getBlacklistedBlocks() {
        return (ImmutableSet<IBlockState>)IMCHandler.BLACKLIST_BUILDER.build();
    }
    
    public static ImmutableList<IBlockState> getOreBlocks() {
        return (ImmutableList<IBlockState>)IMCHandler.ORE_BLOCKS_BUILDER.build();
    }
    
    public static ImmutableList<ItemStack> getLoadingIconStacks() {
        return (ImmutableList<ItemStack>)IMCHandler.LOADING_ICONS_BUILDER.build();
    }
    
    public static ImmutableMultimap<IBlockState, IBlockState> getCrumblingBlocks() {
        return (ImmutableMultimap<IBlockState, IBlockState>)IMCHandler.CRUMBLE_BLOCKS_BUILDER.build();
    }
    
    public static ImmutableMultimap<Integer, TFGenCaveStalactite.StalactiteEntry> getStalactites() {
        return (ImmutableMultimap<Integer, TFGenCaveStalactite.StalactiteEntry>)IMCHandler.STALACTITE_BUILDER.build();
    }
    
    static {
        BLACKLIST_BUILDER = ImmutableSet.builder();
        ORE_BLOCKS_BUILDER = ImmutableList.builder();
        LOADING_ICONS_BUILDER = ImmutableList.builder();
        CRUMBLE_BLOCKS_BUILDER = ImmutableMultimap.builder();
        STALACTITE_BUILDER = ImmutableMultimap.builder();
    }
}
