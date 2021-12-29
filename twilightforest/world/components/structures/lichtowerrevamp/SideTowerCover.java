// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtowerrevamp;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.Util;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.resources.ResourceLocation;
import twilightforest.TwilightForestMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import java.util.List;
import twilightforest.world.components.structures.TwilightTemplateStructurePiece;

public final class SideTowerCover extends TwilightTemplateStructurePiece
{
    private static final List<String> SMALL_COVERS;
    private static final List<String> MEDIUM_COVERS;
    private static final List<String> LARGE_COVERS;
    private final int width;
    private final int thickness = 2;
    
    public SideTowerCover(final ServerLevel serverLevel, final CompoundTag compoundTag) {
        super(LichTowerRevampPieces.CENTRAL_TO_SIDE_TOWER, compoundTag, serverLevel, TwilightTemplateStructurePiece.readSettings(compoundTag));
        this.width = compoundTag.m_128451_("width");
    }
    
    private SideTowerCover(final StructureManager structureManager, final Rotation rotation, final String name, final BlockPos startPosition, final int width) {
        this(structureManager, TwilightForestMod.prefix("lich_tower/side_tower_covers/" + name), TwilightTemplateStructurePiece.makeSettings(rotation), startPosition, width);
    }
    
    private SideTowerCover(final StructureManager structureManager, final ResourceLocation templateLocation, final StructurePlaceSettings placeSettings, final BlockPos startPosition, final int width) {
        super(LichTowerRevampPieces.CENTRAL_TO_SIDE_TOWER, 0, structureManager, templateLocation, placeSettings, startPosition);
        this.width = width;
    }
    
    public static SideTowerCover smallCover(final StructureManager structureManager, final Rotation rotation, final BlockPos startPosition, final Random random) {
        return new SideTowerCover(structureManager, rotation, "small/" + (String)Util.m_143804_((List)SideTowerCover.SMALL_COVERS, random), startPosition, 5);
    }
    
    public static SideTowerCover mediumCover(final StructureManager structureManager, final Rotation rotation, final BlockPos startPosition, final Random random) {
        return new SideTowerCover(structureManager, rotation, "medium/" + (String)Util.m_143804_((List)SideTowerCover.MEDIUM_COVERS, random), startPosition, 7);
    }
    
    public static SideTowerCover largeCover(final StructureManager structureManager, final Rotation rotation, final BlockPos startPosition, final Random random) {
        return new SideTowerCover(structureManager, rotation, "large/" + (String)Util.m_143804_((List)SideTowerCover.LARGE_COVERS, random), startPosition, 9);
    }
    
    protected void m_7756_(final String pFunction, final BlockPos pPos, final ServerLevelAccessor pLevel, final Random pRandom, final BoundingBox pSbb) {
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag structureTag) {
        super.m_142347_(level, structureTag);
        structureTag.m_128405_("width", this.width);
    }
    
    static {
        SMALL_COVERS = (List)ImmutableList.of((Object)"cobbled_small");
        MEDIUM_COVERS = (List)ImmutableList.of((Object)"cobbled_medium");
        LARGE_COVERS = (List)ImmutableList.of((Object)"cobbled_large");
    }
}
