// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.advancements;

import net.minecraft.init.Blocks;
import com.google.common.collect.UnmodifiableIterator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.google.common.base.Optional;
import net.minecraft.block.properties.IProperty;
import java.util.Iterator;
import net.minecraft.block.state.BlockStateContainer;
import com.google.gson.JsonObject;
import java.util.HashSet;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.JsonUtils;
import javax.annotation.Nullable;
import com.google.gson.JsonElement;
import net.minecraft.advancements.critereon.NBTPredicate;
import net.minecraft.block.Block;
import com.google.common.collect.ImmutableSet;

public class BlockPredicate
{
    public static final BlockPredicate ANY;
    private ImmutableSet<PropertyPredicate> propertyPredicates;
    private final Block block;
    private final NBTPredicate nbtPredicate;
    
    private BlockPredicate(final ImmutableSet<PropertyPredicate> propertyPredicates, final Block block, final NBTPredicate nbt) {
        this.propertyPredicates = propertyPredicates;
        this.block = block;
        this.nbtPredicate = nbt;
    }
    
    public static BlockPredicate deserialize(@Nullable final JsonElement element) {
        if (element == null || element.isJsonNull()) {
            return BlockPredicate.ANY;
        }
        final JsonObject json = element.getAsJsonObject();
        final Block block = (Block)Block.field_149771_c.func_82594_a((Object)new ResourceLocation(JsonUtils.func_151200_h(json, "block")));
        final BlockStateContainer container = block.func_176194_O();
        final HashSet<PropertyPredicate<?>> properties = new HashSet<PropertyPredicate<?>>();
        if (json.has("properties")) {
            for (final JsonElement propertyRawGroup : JsonUtils.func_151214_t(json, "properties")) {
                final JsonObject propertyGroup = propertyRawGroup.getAsJsonObject();
                final IProperty<?> propertyKey = (IProperty<?>)container.func_185920_a(JsonUtils.func_151200_h(propertyGroup, "property"));
                if (propertyKey != null) {
                    createPropertyPredicateAndAddToSet(properties, propertyKey, JsonUtils.func_151200_h(propertyGroup, "value"), JsonUtils.func_151200_h(propertyGroup, "comparator"));
                }
            }
        }
        final NBTPredicate nbtPredicate = json.has("nbt") ? NBTPredicate.func_193476_a(json.get("nbt")) : NBTPredicate.field_193479_a;
        return new BlockPredicate((ImmutableSet<PropertyPredicate>)new ImmutableSet.Builder().addAll((Iterable)properties).build(), block, nbtPredicate);
    }
    
    private static <T extends Comparable<T>> void createPropertyPredicateAndAddToSet(final HashSet<PropertyPredicate<?>> predicateSet, final IProperty<T> key, final String value, final String comparisonType) {
        final Optional<T> schrodingersVar = (Optional<T>)key.func_185929_b(value);
        final PropertyPredicate.ComparisonType predicateComparator = get(comparisonType);
        if (predicateComparator == null || !schrodingersVar.isPresent()) {
            return;
        }
        predicateSet.add(new PropertyPredicate<Object>((IProperty)key, (Comparable)schrodingersVar.get(), predicateComparator));
    }
    
    public boolean test(final World world, final BlockPos pos) {
        if (!this.test(world.func_180495_p(pos))) {
            return false;
        }
        if (this.nbtPredicate == NBTPredicate.field_193479_a) {
            return true;
        }
        final TileEntity te = world.func_175625_s(pos);
        return te != null && this.nbtPredicate.func_193477_a((NBTBase)te.serializeNBT());
    }
    
    private boolean test(final IBlockState state) {
        if (this.block != state.func_177230_c()) {
            return false;
        }
        for (final PropertyPredicate propertyPredicate : this.propertyPredicates) {
            if (!propertyPredicate.test(state)) {
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
        private final IProperty<T> property;
        private final T value;
        private ComparisonType comparisonType;
        
        private PropertyPredicate(final IProperty<T> key, final T value, final ComparisonType comparisonType) {
            this.property = key;
            this.value = value;
            this.comparisonType = comparisonType;
        }
        
        private boolean test(final IBlockState state) {
            return state.func_177227_a().contains(this.property) && this.comparisonType.test(this.value, state.func_177229_b((IProperty)this.property));
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
