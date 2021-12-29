// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.processors;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import twilightforest.world.registration.TFStructureProcessors;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import java.util.Random;
import twilightforest.util.ArrayUtil;
import com.mojang.serialization.Codec;
import twilightforest.enums.StructureWoodVariant;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public final class CobblePlankSwizzler extends StructureProcessor
{
    private final StructureWoodVariant OAK_SWIZZLE;
    private final StructureWoodVariant SPRUCE_SWIZZLE;
    private final StructureWoodVariant BIRCH_SWIZZLE;
    public static final Codec<CobblePlankSwizzler> CODEC;
    
    private CobblePlankSwizzler(final int oakSwizzle, final int spruceSwizzle, final int birchSwizzle) {
        this.OAK_SWIZZLE = ArrayUtil.wrapped(StructureWoodVariant.values(), oakSwizzle);
        this.SPRUCE_SWIZZLE = ArrayUtil.wrapped(StructureWoodVariant.values(), spruceSwizzle);
        this.BIRCH_SWIZZLE = ArrayUtil.wrapped(StructureWoodVariant.values(), birchSwizzle);
    }
    
    public CobblePlankSwizzler(final Random random) {
        this.OAK_SWIZZLE = StructureWoodVariant.getRandomWeighted(random);
        this.SPRUCE_SWIZZLE = StructureWoodVariant.getRandomWeighted(random);
        this.BIRCH_SWIZZLE = StructureWoodVariant.getRandomWeighted(random);
    }
    
    @Nullable
    public StructureTemplate.StructureBlockInfo process(final LevelReader worldIn, final BlockPos pos, final BlockPos piecepos, final StructureTemplate.StructureBlockInfo p_215194_3_, final StructureTemplate.StructureBlockInfo blockInfo, final StructurePlaceSettings settings, @Nullable final StructureTemplate template) {
        final BlockState state = blockInfo.f_74676_;
        final Block block = state.m_60734_();
        final StructureWoodVariant type = StructureWoodVariant.getVariantFromBlock(block);
        if (type != null) {
            return switch (type) {
                case OAK -> new StructureTemplate.StructureBlockInfo(blockInfo.f_74675_, StructureWoodVariant.modifyBlockWithType(state, this.OAK_SWIZZLE), (CompoundTag)null);
                case SPRUCE -> new StructureTemplate.StructureBlockInfo(blockInfo.f_74675_, StructureWoodVariant.modifyBlockWithType(state, this.SPRUCE_SWIZZLE), (CompoundTag)null);
                case BIRCH -> new StructureTemplate.StructureBlockInfo(blockInfo.f_74675_, StructureWoodVariant.modifyBlockWithType(state, this.BIRCH_SWIZZLE), (CompoundTag)null);
                default -> blockInfo;
            };
        }
        return blockInfo;
    }
    
    protected StructureProcessorType<?> m_6953_() {
        return TFStructureProcessors.COBBLE_PLANK_SWIZZLER;
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, StructureWoodVariant.values().length).fieldOf("oak_to_type").orElse((Object)0).forGetter(s -> s.OAK_SWIZZLE.ordinal()), (App)Codec.intRange(0, StructureWoodVariant.values().length).fieldOf("spruce_to_type").orElse((Object)1).forGetter(s -> s.SPRUCE_SWIZZLE.ordinal()), (App)Codec.intRange(0, StructureWoodVariant.values().length).fieldOf("birch_to_type").orElse((Object)2).forGetter(s -> s.BIRCH_SWIZZLE.ordinal())).apply((Applicative)instance, CobblePlankSwizzler::new));
    }
}
