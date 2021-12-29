// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.block.Blocks;
import net.minecraft.nbt.NBTUtil;
import java.util.function.Consumer;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import twilightforest.world.feature.TFGenCaveStalactite;
import com.google.common.collect.ImmutableMultimap;
import net.minecraft.item.ItemStack;
import net.minecraft.block.BlockState;
import com.google.common.collect.ImmutableList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD)
public class IMCHandler
{
    private static final ImmutableList.Builder<BlockState> ORE_BLOCKS_BUILDER;
    private static final ImmutableList.Builder<ItemStack> LOADING_ICONS_BUILDER;
    private static final ImmutableMultimap.Builder<BlockState, BlockState> CRUMBLE_BLOCKS_BUILDER;
    private static final ImmutableMultimap.Builder<Integer, TFGenCaveStalactite.StalactiteEntry> STALACTITE_BUILDER;
    
    @SubscribeEvent
    public static void onIMC(final InterModProcessEvent event) {
        InterModComms.getMessages("twilightforest").forEach(message -> {
            final Object thing = message.getMessageSupplier().get();
            if (thing instanceof CompoundNBT) {
                final CompoundNBT imcCompound = (CompoundNBT)thing;
                readFromTagList(imcCompound.func_150295_c("Ore_Blocks", 10), IMCHandler::handleOre);
                readFromTagList(imcCompound.func_150295_c("Crumbling", 10), IMCHandler::handleCrumble);
            }
            if (thing instanceof ItemStack && message.getMethod().equals("Loading_Icon")) {
                IMCHandler.LOADING_ICONS_BUILDER.add((Object)thing);
            }
        });
    }
    
    private static void readFromTagList(final ListNBT list, final Consumer<CompoundNBT> consumer) {
        for (int i = 0; i < list.size(); ++i) {
            consumer.accept(list.func_150305_b(i));
        }
    }
    
    private static void readStatesFromTagList(final ListNBT list, final Consumer<BlockState> consumer) {
        for (int i = 0; i < list.size(); ++i) {
            final BlockState state = NBTUtil.func_190008_d(list.func_150305_b(i));
            if (state.func_177230_c() != Blocks.field_150350_a) {
                consumer.accept(state);
            }
        }
    }
    
    private static void handleCrumble(final CompoundNBT nbt) {
        final BlockState key = NBTUtil.func_190008_d(nbt);
        if (key.func_177230_c() != Blocks.field_150350_a) {
            readStatesFromTagList(nbt.func_150295_c("Crumbling", 10), value -> IMCHandler.CRUMBLE_BLOCKS_BUILDER.put((Object)key, (Object)value));
        }
    }
    
    private static void handleOre(final CompoundNBT nbt) {
        final BlockState nbtState = NBTUtil.func_190008_d(nbt);
        if (nbtState.func_177230_c() != Blocks.field_150350_a) {
            IMCHandler.ORE_BLOCKS_BUILDER.add((Object)nbtState);
            if (nbt.func_150297_b("Stalactite_Settings", 10)) {
                final CompoundNBT settings = nbt.func_74775_l("Stalactite_Settings");
                final int weight = readInt(settings, "Weight", 15);
                final int hillSize = readInt(settings, "Hill_Size", 3);
                final float size = readFloat(settings, "Size", 0.7f);
                final int maxLength = readInt(settings, "Max_Length", 8);
                final int minHeight = readInt(settings, "Min_Height", 1);
                IMCHandler.STALACTITE_BUILDER.put((Object)hillSize, (Object)new TFGenCaveStalactite.StalactiteEntry(nbtState, size, maxLength, minHeight, weight));
            }
        }
    }
    
    private static int readInt(final CompoundNBT tag, final String key, final int defaultValue) {
        return tag.func_150297_b(key, 99) ? tag.func_74762_e(key) : defaultValue;
    }
    
    private static float readFloat(final CompoundNBT tag, final String key, final float defaultValue) {
        return tag.func_150297_b(key, 99) ? tag.func_74760_g(key) : defaultValue;
    }
    
    public static ImmutableList<ItemStack> getLoadingIconStacks() {
        return (ImmutableList<ItemStack>)IMCHandler.LOADING_ICONS_BUILDER.build();
    }
    
    public static ImmutableMultimap<Integer, TFGenCaveStalactite.StalactiteEntry> getStalactites() {
        return (ImmutableMultimap<Integer, TFGenCaveStalactite.StalactiteEntry>)IMCHandler.STALACTITE_BUILDER.build();
    }
    
    static {
        ORE_BLOCKS_BUILDER = ImmutableList.builder();
        LOADING_ICONS_BUILDER = ImmutableList.builder();
        CRUMBLE_BLOCKS_BUILDER = ImmutableMultimap.builder();
        STALACTITE_BUILDER = ImmutableMultimap.builder();
    }
}
