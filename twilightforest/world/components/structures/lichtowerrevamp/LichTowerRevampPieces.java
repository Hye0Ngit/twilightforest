// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtowerrevamp;

import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public final class LichTowerRevampPieces
{
    public static final StructurePieceType TOWER_FOYER;
    public static final StructurePieceType CENTRAL_TOWER;
    public static final StructurePieceType CENTRAL_TO_SIDE_TOWER;
    public static final StructurePieceType SIDE_TOWER_ROOM;
    
    static {
        TOWER_FOYER = TFFeature.registerPiece("TFLTTFoy", TowerFoyer::new);
        CENTRAL_TOWER = TFFeature.registerPiece("TFLTCTSeg", CentralTowerSegment::new);
        CENTRAL_TO_SIDE_TOWER = TFFeature.registerPiece("TFLTC2ST", CentralTowerAttachment::new);
        SIDE_TOWER_ROOM = TFFeature.registerPiece("TFLTSTRm", SideTowerRoom::new);
    }
}
