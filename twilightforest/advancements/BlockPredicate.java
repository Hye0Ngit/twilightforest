// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import net.minecraft.block.Blocks;
import com.google.common.collect.UnmodifiableIterator;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.INBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Optional;
import net.minecraft.state.Property;
import java.util.Iterator;
import net.minecraft.state.StateContainer;
import com.google.gson.JsonObject;
import java.util.HashSet;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.JSONUtils;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nullable;
import com.google.gson.JsonElement;
import net.minecraft.advancements.criterion.NBTPredicate;
import net.minecraft.block.Block;
import com.google.common.collect.ImmutableSet;

public class BlockPredicate
{
    public static final BlockPredicate ANY;
    private ImmutableSet<PropertyPredicate<?>> propertyPredicates;
    private final Block block;
    private final NBTPredicate nbtPredicate;
    
    private BlockPredicate(final ImmutableSet<PropertyPredicate<?>> propertyPredicates, final Block block, final NBTPredicate nbt) {
        this.propertyPredicates = propertyPredicates;
        this.block = block;
        this.nbtPredicate = nbt;
    }
    
    public static BlockPredicate deserialize(@Nullable final JsonElement element) {
        if (element == null || element.isJsonNull()) {
            return BlockPredicate.ANY;
        }
        final JsonObject json = element.getAsJsonObject();
        final Block block = (Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation(JSONUtils.func_151200_h(json, "block")));
        final StateContainer<?, ?> container = (StateContainer<?, ?>)block.func_176194_O();
        final HashSet<PropertyPredicate<?>> properties = new HashSet<PropertyPredicate<?>>();
        if (json.has("properties")) {
            for (final JsonElement propertyRawGroup : JSONUtils.func_151214_t(json, "properties")) {
                final JsonObject propertyGroup = propertyRawGroup.getAsJsonObject();
                final Property<?> propertyKey = (Property<?>)container.func_185920_a(JSONUtils.func_151200_h(propertyGroup, "property"));
                if (propertyKey != null) {
                    createPropertyPredicateAndAddToSet(properties, propertyKey, JSONUtils.func_151200_h(propertyGroup, "value"), JSONUtils.func_151200_h(propertyGroup, "comparator"));
                }
            }
        }
        final NBTPredicate nbtPredicate = json.has("nbt") ? NBTPredicate.func_193476_a(json.get("nbt")) : NBTPredicate.field_193479_a;
        return new BlockPredicate((ImmutableSet<PropertyPredicate<?>>)new ImmutableSet.Builder().addAll((Iterable)properties).build(), block, nbtPredicate);
    }
    
    private static <T extends Comparable<T>> void createPropertyPredicateAndAddToSet(final HashSet<PropertyPredicate<?>> predicateSet, final Property<T> key, final String value, final String comparisonType) {
        final Optional<T> schrodingersVar = key.func_185929_b(value);
        final PropertyPredicate.ComparisonType predicateComparator = get(comparisonType);
        if (predicateComparator == null || !schrodingersVar.isPresent()) {
            return;
        }
        predicateSet.add(new PropertyPredicate<Object>((Property)key, (Comparable)schrodingersVar.get(), predicateComparator));
    }
    
    public boolean test(final World world, final BlockPos pos) {
        if (!this.test(world.func_180495_p(pos))) {
            return false;
        }
        if (this.nbtPredicate == NBTPredicate.field_193479_a) {
            return true;
        }
        final TileEntity te = world.func_175625_s(pos);
        return te != null && this.nbtPredicate.func_193477_a((INBT)te.serializeNBT());
    }
    
    private boolean test(final BlockState state) {
        if (this.block != state.func_177230_c()) {
            return false;
        }
        for (final PropertyPredicate<?> propertyPredicate : this.propertyPredicates) {
            if (!((PropertyPredicate<Comparable>)propertyPredicate).test(state)) {
                return false;
            }
        }
        return true;
    }
    
    static {
        ANY = new BlockPredicate(ImmutableSet.of(), Blocks.field_150350_a, NBTPredicate.field_193479_a) {
            @Override
            public boolean test(final World world, final BlockPos pos) {
                return true;
            }
        };
    }
    
    private static class PropertyPredicate<T extends Comparable<T>>
    {
        private final Property<T> property;
        private final T value;
        private ComparisonType comparisonType;
        
        private PropertyPredicate(final Property<T> key, final T value, final ComparisonType comparisonType) {
            this.property = key;
            this.value = value;
            this.comparisonType = comparisonType;
        }
        
        private boolean test(final BlockState state) {
            return state.func_235904_r_().contains(this.property) && this.comparisonType.test(this.value, state.func_177229_b((Property)this.property));
        }
        
        private enum ComparisonType
        {
            EQUAL {
                @Override
                 <T extends Comparable<T>> boolean test(final T k, final T v) {
                    return k.compareTo(v) == 0;
                }
            }, 
            NOT {
                @Override
                 <T extends Comparable<T>> boolean test(final T k, final T v) {
                    return k.compareTo(v) != 0;
                }
            }, 
            LESSER {
                @Override
                 <T extends Comparable<T>> boolean test(final T k, final T v) {
                    return k.compareTo(v) < 0;
                }
            }, 
            GREATER {
                @Override
                 <T extends Comparable<T>> boolean test(final T k, final T v) {
                    return k.compareTo(v) > 0;
                }
            };
            
            abstract <T extends Comparable<T>> boolean test(final T p0, final T p1);
            
            @Nullable
            private static ComparisonType get(final String type) {
                switch (type) {
                    case "equal":
                    case "same": {
                        return ComparisonType.EQUAL;
                    }
                    case "not":
                    case "different":
                    case "equaln't": {
                        return ComparisonType.NOT;
                    }
                    case "lesser":
                    case "lesser_than": {
                        return ComparisonType.LESSER;
                    }
                    case "greater":
                    case "greater_than": {
                        return ComparisonType.GREATER;
                    }
                    default: {
                        return null;
                    }
                }
            }
        }
    }
}
