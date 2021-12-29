// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.tileentity;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Collection;
import net.minecraft.client.resources.model.ModelBakery;
import twilightforest.block.TFBlocks;
import com.google.common.collect.ImmutableMap;
import java.util.stream.Stream;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.state.properties.ChestType;
import java.util.EnumMap;
import net.minecraft.world.level.block.Block;
import java.util.Map;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import twilightforest.block.entity.TwilightChestEntity;

public class TwilightChestRenderer<T extends TwilightChestEntity> extends ChestRenderer<T>
{
    public static final Map<Block, EnumMap<ChestType, Material>> MATERIALS;
    
    public TwilightChestRenderer(final BlockEntityRendererProvider.Context context) {
        super(context);
    }
    
    protected Material getMaterial(final T blockEntity, final ChestType chestType) {
        final EnumMap<ChestType, Material> b = TwilightChestRenderer.MATERIALS.get(blockEntity.m_58900_().m_60734_());
        if (b == null) {
            return super.getMaterial((BlockEntity)blockEntity, chestType);
        }
        final Material material = b.get(chestType);
        return (material != null) ? material : super.getMaterial((BlockEntity)blockEntity, chestType);
    }
    
    private static EnumMap<ChestType, Material> chestMaterial(final String type) {
        final EnumMap<ChestType, Material> map = new EnumMap<ChestType, Material>(ChestType.class);
        map.put(ChestType.SINGLE, new Material(Sheets.f_110740_, TwilightForestMod.prefix("model/chest/" + type + "/" + type)));
        map.put(ChestType.LEFT, new Material(Sheets.f_110740_, TwilightForestMod.prefix("model/chest/" + type + "/left")));
        map.put(ChestType.RIGHT, new Material(Sheets.f_110740_, TwilightForestMod.prefix("model/chest/" + type + "/right")));
        return map;
    }
    
    static {
        final ImmutableMap.Builder<Block, EnumMap<ChestType, Material>> builder = (ImmutableMap.Builder<Block, EnumMap<ChestType, Material>>)ImmutableMap.builder();
        builder.put((Object)TFBlocks.TWILIGHT_OAK_CHEST.get(), (Object)chestMaterial("twilight"));
        builder.put((Object)TFBlocks.CANOPY_CHEST.get(), (Object)chestMaterial("canopy"));
        builder.put((Object)TFBlocks.MANGROVE_CHEST.get(), (Object)chestMaterial("mangrove"));
        builder.put((Object)TFBlocks.DARKWOOD_CHEST.get(), (Object)chestMaterial("darkwood"));
        builder.put((Object)TFBlocks.TIME_CHEST.get(), (Object)chestMaterial("time"));
        builder.put((Object)TFBlocks.TRANSFORMATION_CHEST.get(), (Object)chestMaterial("trans"));
        builder.put((Object)TFBlocks.MINING_CHEST.get(), (Object)chestMaterial("mining"));
        builder.put((Object)TFBlocks.SORTING_CHEST.get(), (Object)chestMaterial("sort"));
        MATERIALS = (Map)builder.build();
        ModelBakery.f_119234_.addAll(TwilightChestRenderer.MATERIALS.values().stream().flatMap(e -> e.values().stream()).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()));
    }
}
