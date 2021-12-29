// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.nbt.NbtUtils;
import java.util.function.Consumer;
import net.minecraft.nbt.ListTag;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import twilightforest.world.components.feature.BlockSpikeFeature;
import com.google.common.collect.ImmutableMultimap;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import com.google.common.collect.ImmutableList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD)
public class IMCHandler
{
    private static final ImmutableList.Builder<BlockState> ORE_BLOCKS_BUILDER;
    private static final ImmutableList.Builder<ItemStack> LOADING_ICONS_BUILDER;
    private static final ImmutableMultimap.Builder<BlockState, BlockState> CRUMBLE_BLOCKS_BUILDER;
    private static final ImmutableMultimap.Builder<Integer, BlockSpikeFeature.StalactiteEntry> STALACTITE_BUILDER;
    
    @SubscribeEvent
    public static void onIMC(final InterModProcessEvent event) {
        InterModComms.getMessages("twilightforest").forEach(message -> {
            final Object thing = message.getMessageSupplier().get();
            if (thing instanceof final CompoundTag imcCompound) {
                readFromTagList(imcCompound.m_128437_("Ore_Blocks", 10), IMCHandler::handleOre);
                readFromTagList(imcCompound.m_128437_("Crumbling", 10), IMCHandler::handleCrumble);
            }
            if (thing instanceof ItemStack && message.getMethod().equals("Loading_Icon")) {
                IMCHandler.LOADING_ICONS_BUILDER.add((Object)thing);
            }
        });
    }
    
    private static void readFromTagList(final ListTag list, final Consumer<CompoundTag> consumer) {
        for (int i = 0; i < list.size(); ++i) {
            consumer.accept(list.m_128728_(i));
        }
    }
    
    private static void readStatesFromTagList(final ListTag list, final Consumer<BlockState> consumer) {
        for (int i = 0; i < list.size(); ++i) {
            final BlockState state = NbtUtils.m_129241_(list.m_128728_(i));
            if (state.m_60734_() != Blocks.f_50016_) {
                consumer.accept(state);
            }
        }
    }
    
    private static void handleCrumble(final CompoundTag nbt) {
        final BlockState key = NbtUtils.m_129241_(nbt);
        if (key.m_60734_() != Blocks.f_50016_) {
            readStatesFromTagList(nbt.m_128437_("Crumbling", 10), value -> IMCHandler.CRUMBLE_BLOCKS_BUILDER.put((Object)key, (Object)value));
        }
    }
    
    private static void handleOre(final CompoundTag nbt) {
        final BlockState nbtState = NbtUtils.m_129241_(nbt);
        if (nbtState.m_60734_() != Blocks.f_50016_) {
            IMCHandler.ORE_BLOCKS_BUILDER.add((Object)nbtState);
            if (nbt.m_128425_("Stalactite_Settings", 10)) {
                final CompoundTag settings = nbt.m_128469_("Stalactite_Settings");
                final int weight = readInt(settings, "Weight", 15);
                final int hillSize = readInt(settings, "Hill_Size", 3);
                final float size = readFloat(settings, "Size", 0.7f);
                final int maxLength = readInt(settings, "Max_Length", 8);
                final int minHeight = readInt(settings, "Min_Height", 1);
                IMCHandler.STALACTITE_BUILDER.put((Object)hillSize, (Object)new BlockSpikeFeature.StalactiteEntry(nbtState, size, maxLength, weight));
            }
        }
    }
    
    private static int readInt(final CompoundTag tag, final String key, final int defaultValue) {
        return tag.m_128425_(key, 99) ? tag.m_128451_(key) : defaultValue;
    }
    
    private static float readFloat(final CompoundTag tag, final String key, final float defaultValue) {
        return tag.m_128425_(key, 99) ? tag.m_128457_(key) : defaultValue;
    }
    
    public static ImmutableList<ItemStack> getLoadingIconStacks() {
        return (ImmutableList<ItemStack>)IMCHandler.LOADING_ICONS_BUILDER.build();
    }
    
    public static ImmutableMultimap<Integer, BlockSpikeFeature.StalactiteEntry> getStalactites() {
        return (ImmutableMultimap<Integer, BlockSpikeFeature.StalactiteEntry>)IMCHandler.STALACTITE_BUILDER.build();
    }
    
    static {
        ORE_BLOCKS_BUILDER = ImmutableList.builder();
        LOADING_ICONS_BUILDER = ImmutableList.builder();
        CRUMBLE_BLOCKS_BUILDER = ImmutableMultimap.builder();
        STALACTITE_BUILDER = ImmutableMultimap.builder();
    }
}
