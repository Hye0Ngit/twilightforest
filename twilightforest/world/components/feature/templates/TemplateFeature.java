// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.templates;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import com.google.common.math.StatsAccumulator;
import javax.annotation.Nullable;
import java.util.Iterator;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.properties.StructureMode;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.Util;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public abstract class TemplateFeature<T extends FeatureConfiguration> extends Feature<T>
{
    public TemplateFeature(final Codec<T> config) {
        super((Codec)config);
    }
    
    public final boolean m_142674_(final FeaturePlaceContext<T> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random random = world.m_5822_();
        final StructureManager templateManager = world.m_6018_().m_142572_().m_129909_();
        final StructureTemplate template = this.getTemplate(templateManager, random);
        if (template == null) {
            return false;
        }
        final Rotation rotation = Rotation.m_55956_(random);
        final Mirror mirror = (Mirror)Util.m_137545_((Object[])Mirror.values(), random);
        final ChunkPos chunkpos = new ChunkPos(pos);
        final BoundingBox structureMask = new BoundingBox(chunkpos.m_45604_(), world.m_141937_(), chunkpos.m_45605_(), chunkpos.m_45608_(), world.m_151558_(), chunkpos.m_45609_());
        BlockPos posSnap = chunkpos.m_45615_().m_142082_(0, pos.m_123342_(), 0);
        final Vec3i transformedSize = template.m_163808_(rotation);
        final int dx = random.nextInt(16 - transformedSize.m_123341_());
        final int dz = random.nextInt(16 - transformedSize.m_123343_());
        posSnap = posSnap.m_142082_(dx, 0, dz);
        final BlockPos.MutableBlockPos startPos = new BlockPos.MutableBlockPos(posSnap.m_123341_(), posSnap.m_123342_(), posSnap.m_123343_());
        if (!offsetToAverageGroundLevel(world, startPos, transformedSize)) {
            return false;
        }
        startPos.m_122184_(0, this.yLevelOffset(), 0);
        final BlockPos placementPos = template.m_74583_((BlockPos)startPos, mirror, rotation);
        final StructurePlaceSettings placementSettings = new StructurePlaceSettings().m_74377_(mirror).m_74379_(rotation).m_74381_(structureMask).m_74390_(random);
        this.modifySettings(placementSettings.m_74394_(), random);
        template.m_74536_((ServerLevelAccessor)world, placementPos, placementPos, placementSettings, random, 20);
        for (final StructureTemplate.StructureBlockInfo info : template.m_74603_(placementPos, placementSettings, Blocks.f_50677_)) {
            if (info.f_74677_ != null && StructureMode.valueOf(info.f_74677_.m_128461_("mode")) == StructureMode.DATA) {
                this.processMarkers(info, world, rotation, mirror, random);
            }
        }
        this.postPlacement(world, random, templateManager, rotation, mirror, placementSettings, placementPos);
        return true;
    }
    
    @Nullable
    protected abstract StructureTemplate getTemplate(final StructureManager p0, final Random p1);
    
    protected void modifySettings(final StructurePlaceSettings settings, final Random random) {
    }
    
    protected void processMarkers(final StructureTemplate.StructureBlockInfo info, final WorldGenLevel world, final Rotation rotation, final Mirror mirror, final Random random) {
    }
    
    protected void postPlacement(final WorldGenLevel world, final Random random, final StructureManager templateManager, final Rotation rotation, final Mirror mirror, final StructurePlaceSettings placementSettings, final BlockPos placementPos) {
    }
    
    protected int yLevelOffset() {
        return 0;
    }
    
    private static boolean offsetToAverageGroundLevel(final WorldGenLevel world, final BlockPos.MutableBlockPos startPos, final Vec3i size) {
        final StatsAccumulator heights = new StatsAccumulator();
        for (int dx = 0; dx < size.m_123341_(); ++dx) {
            for (int dz = 0; dz < size.m_123343_(); ++dz) {
                final int x = startPos.m_123341_() + dx;
                final int z = startPos.m_123343_() + dz;
                int y;
                for (y = world.m_6924_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z); y >= 0; --y) {
                    final BlockState state = world.m_8055_(new BlockPos(x, y, z));
                    if (isBlockNotOk(state)) {
                        return false;
                    }
                    if (isBlockOk(state)) {
                        break;
                    }
                }
                if (y < 0) {
                    return false;
                }
                heights.add((double)y);
            }
        }
        if (heights.populationStandardDeviation() > 2.0) {
            return false;
        }
        final int baseY = (int)(heights.mean() + 0.5);
        final int maxY = (int)heights.max();
        startPos.m_142448_(baseY);
        return isAreaClear((LevelAccessor)world, startPos.m_6630_(maxY - baseY + 1), startPos.m_141952_(size));
    }
    
    private static boolean isAreaClear(final LevelAccessor world, final BlockPos min, final BlockPos max) {
        for (final BlockPos pos : BlockPos.m_121940_(min, max)) {
            if (!world.m_8055_(pos).m_60767_().m_76336_()) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isBlockOk(final BlockState state) {
        final Material material = state.m_60767_();
        return material == Material.f_76278_ || material == Material.f_76314_ || material == Material.f_76315_ || material == Material.f_76317_;
    }
    
    private static boolean isBlockNotOk(final BlockState state) {
        final Material material = state.m_60767_();
        return material == Material.f_76305_ || material == Material.f_76307_ || state.m_60734_() == Blocks.f_50752_;
    }
    
    private static boolean isDataBlock(final StructureTemplate.StructureBlockInfo info) {
        return StructureMode.DATA.name().equals(info.f_74677_.m_128461_("mode"));
    }
}
