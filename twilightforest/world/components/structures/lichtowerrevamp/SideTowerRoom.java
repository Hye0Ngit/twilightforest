// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtowerrevamp;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.Util;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Vec3i;
import twilightforest.TwilightForestMod;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import twilightforest.util.ArrayUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import java.util.EnumMap;
import java.util.List;
import twilightforest.world.components.structures.TwilightTemplateStructurePiece;

public final class SideTowerRoom extends TwilightTemplateStructurePiece
{
    private static final List<String> SMALL_ROOMS;
    private static final List<String> MEDIUM_ROOMS;
    private static final List<String> LARGE_ROOMS;
    private static final EnumMap<Rotation, BlockPos> OFFSETS;
    private final int squareDiameter;
    private final Rotation externalRotation;
    
    public SideTowerRoom(final ServerLevel serverLevel, final CompoundTag compoundTag) {
        super(LichTowerRevampPieces.SIDE_TOWER_ROOM, compoundTag, serverLevel, TwilightTemplateStructurePiece.readSettings(compoundTag));
        this.squareDiameter = compoundTag.m_128451_("square_diameter");
        this.externalRotation = ArrayUtil.wrapped(Rotation.values(), compoundTag.m_128451_("ext_rotation"));
    }
    
    private SideTowerRoom(final StructureManager structureManager, final Rotation roomRotation, final Rotation exteriorRotation, final String name, final BlockPos startPosition, final int squareDiameter) {
        this(structureManager, TwilightForestMod.prefix("lich_tower/side_tower_rooms/" + name), TwilightTemplateStructurePiece.makeSettings(roomRotation), startPosition.m_141952_((Vec3i)SideTowerRoom.OFFSETS.get(roomRotation).m_142393_(squareDiameter - 1)).m_141952_((Vec3i)SideTowerRoom.OFFSETS.get(exteriorRotation).m_142393_(1 - squareDiameter)), squareDiameter, exteriorRotation);
    }
    
    private SideTowerRoom(final StructureManager structureManager, final ResourceLocation templateLocation, final StructurePlaceSettings placeSettings, final BlockPos startPosition, final int squareDiameter, final Rotation externalRotation) {
        super(LichTowerRevampPieces.SIDE_TOWER_ROOM, 0, structureManager, templateLocation, placeSettings, startPosition);
        this.squareDiameter = squareDiameter;
        this.externalRotation = externalRotation;
    }
    
    public static SideTowerRoom smallRoom(final StructureManager structureManager, final Rotation exteriorRotation, final BlockPos startPosition, final Random random) {
        return new SideTowerRoom(structureManager, Rotation.m_55956_(random), exteriorRotation, "small/" + (String)Util.m_143804_((List)SideTowerRoom.SMALL_ROOMS, random), startPosition, 5);
    }
    
    public static SideTowerRoom mediumRoom(final StructureManager structureManager, final Rotation exteriorRotation, final BlockPos startPosition, final Random random) {
        return new SideTowerRoom(structureManager, Rotation.m_55956_(random), exteriorRotation, "medium/" + (String)Util.m_143804_((List)SideTowerRoom.MEDIUM_ROOMS, random), startPosition, 7);
    }
    
    public static SideTowerRoom largeRoom(final StructureManager structureManager, final Rotation exteriorRotation, final BlockPos startPosition, final Random random) {
        return new SideTowerRoom(structureManager, Rotation.m_55956_(random), exteriorRotation, "large/" + (String)Util.m_143804_((List)SideTowerRoom.LARGE_ROOMS, random), startPosition, 9);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor structureStart, final Random random) {
        super.m_142537_(parent, structureStart, random);
        final BlockPos center = this.f_73383_.m_162394_();
        final BlockPos offset = new BlockPos(-(this.squareDiameter - 1 >> 1), -4, (this.squareDiameter - 1 >> 1) + 1);
        this.placeCover(structureStart, center, offset, random, Rotation.COUNTERCLOCKWISE_90);
        this.placeCover(structureStart, center, offset, random, Rotation.NONE);
        this.placeCover(structureStart, center, offset, random, Rotation.CLOCKWISE_90);
    }
    
    private void placeCover(final StructurePieceAccessor structureStart, final BlockPos center, final BlockPos offset, final Random random, final Rotation rotation) {
        final Rotation relativeRotation = this.externalRotation.m_55952_(rotation);
        final BlockPos pos = center.m_141952_((Vec3i)offset.m_7954_(relativeRotation));
        switch (this.squareDiameter) {
            case 9: {
                final SideTowerCover largeCover = SideTowerCover.largeCover(this.structureManager, relativeRotation, pos, random);
                largeCover.m_142537_((StructurePiece)this, structureStart, random);
                structureStart.m_142679_((StructurePiece)largeCover);
                break;
            }
            case 7: {
                final SideTowerCover mediumCover = SideTowerCover.mediumCover(this.structureManager, relativeRotation, pos, random);
                mediumCover.m_142537_((StructurePiece)this, structureStart, random);
                structureStart.m_142679_((StructurePiece)mediumCover);
                break;
            }
            case 5: {
                final SideTowerCover smallCover = SideTowerCover.smallCover(this.structureManager, relativeRotation, pos, random);
                smallCover.m_142537_((StructurePiece)this, structureStart, random);
                structureStart.m_142679_((StructurePiece)smallCover);
                break;
            }
        }
    }
    
    protected void m_7756_(final String label, final BlockPos pPos, final ServerLevelAccessor pLevel, final Random pRandom, final BoundingBox pSbb) {
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag structureTag) {
        super.m_142347_(level, structureTag);
        structureTag.m_128405_("square_diameter", this.squareDiameter);
        structureTag.m_128405_("ext_rotation", this.externalRotation.ordinal());
    }
    
    static {
        SMALL_ROOMS = (List)ImmutableList.of((Object)"empty_small", (Object)"library_steps_small");
        MEDIUM_ROOMS = (List)ImmutableList.of((Object)"empty_medium", (Object)"stacked_library_elbow_medium");
        LARGE_ROOMS = (List)ImmutableList.of((Object)"empty_large", (Object)"illegal_blockstate_kitchen", (Object)"library_plus_large");
        (OFFSETS = new EnumMap<Rotation, BlockPos>(Rotation.class)).put(Rotation.NONE, BlockPos.f_121853_);
        SideTowerRoom.OFFSETS.put(Rotation.CLOCKWISE_90, new BlockPos(1, 0, 0));
        SideTowerRoom.OFFSETS.put(Rotation.CLOCKWISE_180, new BlockPos(1, 0, 1));
        SideTowerRoom.OFFSETS.put(Rotation.COUNTERCLOCKWISE_90, new BlockPos(0, 0, 1));
    }
}
