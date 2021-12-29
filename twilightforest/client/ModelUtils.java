// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import com.google.common.collect.UnmodifiableIterator;
import net.minecraft.util.ResourceLocation;
import java.util.Iterator;
import java.util.Set;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import net.minecraft.init.Items;
import net.minecraft.client.renderer.block.statemap.StateMap;
import java.util.HashSet;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import net.minecraft.block.properties.IProperty;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;

public class ModelUtils
{
    public static void registerToState(final Block b, final int itemMeta, final IBlockState state) {
        registerToState(b, itemMeta, state, (IStateMapper)new DefaultStateMapper());
    }
    
    public static void registerToState(final Block b, final int itemMeta, final IBlockState state, final IStateMapper stateMapper) {
        final ModelResourceLocation mrl = stateMapper.func_178130_a(state.func_177230_c()).get(state);
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(b), itemMeta, mrl);
    }
    
    public static <T extends Comparable<T>> void registerToStateSingleVariant(final Block b, final IProperty<T> variant) {
        registerToStateSingleVariant(b, variant, (IStateMapper)new DefaultStateMapper());
    }
    
    public static <T extends Comparable<T>> void registerToStateSingleVariant(final Block b, final IProperty<T> variant, final IStateMapper stateMapper) {
        final List<T> variants = new ArrayList<T>(variant.func_177700_c());
        for (int i = 0; i < variants.size(); ++i) {
            registerToState(b, i, b.func_176223_P().func_177226_a((IProperty)variant, (Comparable)variants.get(i)), stateMapper);
        }
    }
    
    public static void registerIncludingItemModels(final Block b, final String inventoryPrefix, final IProperty<?>... blockIgnorables) {
        registerIncludingItemModels(b, inventoryPrefix, blockIgnorables, (IProperty<?>[])new IProperty[0]);
    }
    
    public static void registerIncludingItemModels(final Block b, final String inventoryPrefix, final IProperty<?>[] blockIgnorables, final IProperty<?>[] itemIgnorables) {
        final Set<IProperty<?>> properties = new HashSet<IProperty<?>>(b.func_176194_O().func_177623_d());
        final Item item = Item.func_150898_a(b);
        ModelLoader.setCustomStateMapper(b, (IStateMapper)new StateMap.Builder().func_178442_a((IProperty[])blockIgnorables).func_178441_a());
        if (item != Items.field_190931_a) {
            if (itemIgnorables.length > 0) {
                for (final IProperty<?> ignore : itemIgnorables) {
                    properties.remove(ignore);
                }
                final Set<IBlockState> states = new HashSet<IBlockState>();
                final IBlockState defaultState = b.func_176223_P();
                states.add(defaultState);
                for (final IProperty<?> prop : properties) {
                    final ImmutableSet.Builder<IBlockState> statesIn = (ImmutableSet.Builder<IBlockState>)ImmutableSet.builder();
                    statesIn.addAll((Iterable)states);
                    swizzleStatesWithPropertyKey(defaultState, states, (ImmutableCollection<IBlockState>)statesIn.build(), prop);
                }
                final ResourceLocation rl = item.getRegistryName();
                if (rl != null) {
                    for (final IBlockState state : states) {
                        final int meta = b.func_176201_c(state);
                        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(rl, inventoryPrefix + "_" + meta));
                    }
                }
            }
            else {
                final ResourceLocation rl2 = item.getRegistryName();
                if (rl2 != null) {
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(rl2, inventoryPrefix));
                }
            }
        }
    }
    
    private static <T extends Comparable<T>> void swizzleStatesWithPropertyKey(final IBlockState defaultState, final Collection<IBlockState> target, final ImmutableCollection<IBlockState> statesIn, final IProperty<T> property) {
        final Set<T> values = new HashSet<T>(property.func_177700_c());
        values.remove(defaultState.func_177229_b((IProperty)property));
        for (final T value : values) {
            for (final IBlockState state : statesIn) {
                target.add(state.func_177226_a((IProperty)property, (Comparable)value));
            }
        }
    }
}
