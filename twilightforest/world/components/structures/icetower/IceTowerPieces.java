// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.icetower;

import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public class IceTowerPieces
{
    public static final StructurePieceType TFITMai;
    public static final StructurePieceType TFITWin;
    public static final StructurePieceType TFITRoof;
    public static final StructurePieceType TFITBea;
    public static final StructurePieceType TFITBoss;
    public static final StructurePieceType TFITEnt;
    public static final StructurePieceType TFITBri;
    public static final StructurePieceType TFITSt;
    
    static {
        TFITMai = TFFeature.registerPiece("TFITMai", IceTowerMainComponent::new);
        TFITWin = TFFeature.registerPiece("TFITWin", IceTowerWingComponent::new);
        TFITRoof = TFFeature.registerPiece("TFITRoof", IceTowerRoofComponent::new);
        TFITBea = TFFeature.registerPiece("TFITBea", IceTowerBeardComponent::new);
        TFITBoss = TFFeature.registerPiece("TFITBoss", IceTowerBossWingComponent::new);
        TFITEnt = TFFeature.registerPiece("TFITEnt", IceTowerEntranceComponent::new);
        TFITBri = TFFeature.registerPiece("TFITBri", IceTowerBridgeComponent::new);
        TFITSt = TFFeature.registerPiece("TFITSt", IceTowerStairsComponent::new);
    }
}
