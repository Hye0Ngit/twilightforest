// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.processors;

import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import net.minecraft.core.Direction;
import java.util.Map;
import twilightforest.TwilightForestMod;
import twilightforest.util.BoundingBoxUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import java.util.ArrayList;
import net.minecraft.nbt.ListTag;
import twilightforest.world.registration.TFStructureProcessors;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import java.util.Iterator;
import net.minecraft.core.Vec3i;
import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.List;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public final class BoxCuttingProcessor extends StructureProcessor
{
    public static final Codec<BoxCuttingProcessor> CODEC;
    public final List<BoundingBox> cutouts;
    
    public BoxCuttingProcessor(final List<BoundingBox> cutouts) {
        this.cutouts = cutouts;
    }
    
    @Nullable
    public StructureTemplate.StructureBlockInfo process(final LevelReader level, final BlockPos origin, final BlockPos centerBottom, final StructureTemplate.StructureBlockInfo originalBlockInfo, final StructureTemplate.StructureBlockInfo modifiedBlockInfo, final StructurePlaceSettings settings, @Nullable final StructureTemplate template) {
        for (final BoundingBox cutout : this.cutouts) {
            if (cutout.m_71051_((Vec3i)modifiedBlockInfo.f_74675_)) {
                return null;
            }
        }
        return modifiedBlockInfo;
    }
    
    protected StructureProcessorType<?> m_6953_() {
        return TFStructureProcessors.BOX_CUTTING_PROCESSOR;
    }
    
    public static BoxCuttingProcessor fromNBT(final ListTag tag) {
        final List<BoundingBox> boxes = new ArrayList<BoundingBox>();
        for (final Tag tag2 : tag) {
            final Tag tagElement = tag2;
            if (tag2 instanceof final CompoundTag boxCompound) {
                try {
                    boxes.add(BoundingBoxUtils.NBTToBoundingBox(boxCompound));
                }
                catch (Throwable e) {
                    TwilightForestMod.LOGGER.error("Invalid BoundingBox found in list", e);
                }
            }
        }
        return new BoxCuttingProcessor(boxes);
    }
    
    public static BoxCuttingProcessor forLichTower(final Map<BlockPos, Direction> sideTowerStarts) {
        return new BoxCuttingProcessor((List<BoundingBox>)sideTowerStarts.entrySet().stream().map(e -> BoundingBox.m_162375_((Vec3i)e.getKey(), (Vec3i)e.getKey().m_5484_((Direction)e.getValue(), 1).m_5484_(e.getValue().m_122427_(), 4).m_6630_(6))).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()));
    }
    
    static {
        CODEC = BoundingBox.f_162354_.listOf().xmap((Function)BoxCuttingProcessor::new, p -> p.cutouts);
    }
}
