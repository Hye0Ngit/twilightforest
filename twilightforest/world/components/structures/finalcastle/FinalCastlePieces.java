// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public class FinalCastlePieces
{
    public static final StructurePieceType TFFCMain;
    public static final StructurePieceType TFFCStTo;
    public static final StructurePieceType TFFCLaTo;
    public static final StructurePieceType TFFCMur;
    public static final StructurePieceType TFFCToF48;
    public static final StructurePieceType TFFCRo48Cr;
    public static final StructurePieceType TFFCBoGaz;
    public static final StructurePieceType TFFCSiTo;
    public static final StructurePieceType TFFCDunSt;
    public static final StructurePieceType TFFCDunEn;
    public static final StructurePieceType TFFCDunR31;
    public static final StructurePieceType TFFCDunEx;
    public static final StructurePieceType TFFCDunBoR;
    public static final StructurePieceType TFFCRo9Cr;
    public static final StructurePieceType TFFCRo13Cr;
    public static final StructurePieceType TFFCRo13Con;
    public static final StructurePieceType TFFCRo13Pk;
    public static final StructurePieceType TFFCEnTo;
    public static final StructurePieceType TFFCEnSiTo;
    public static final StructurePieceType TFFCEnBoTo;
    public static final StructurePieceType TFFCEnSt;
    public static final StructurePieceType TFFCBelTo;
    public static final StructurePieceType TFFCBri;
    public static final StructurePieceType TFFCToF13;
    public static final StructurePieceType TFFCBeF21;
    public static final StructurePieceType TFFCFTh21;
    public static final StructurePieceType TFFCDamT;
    public static final StructurePieceType TFFCWrT;
    
    static {
        TFFCMain = TFFeature.registerPiece("TFFCMain", FinalCastleMainComponent::new);
        TFFCStTo = TFFeature.registerPiece("TFFCStTo", FinalCastleStairTowerComponent::new);
        TFFCLaTo = TFFeature.registerPiece("TFFCLaTo", FinalCastleLargeTowerComponent::new);
        TFFCMur = TFFeature.registerPiece("TFFCMur", FinalCastleMuralComponent::new);
        TFFCToF48 = TFFeature.registerPiece("TFFCToF48", FinalCastleFoundation48Component::new);
        TFFCRo48Cr = TFFeature.registerPiece("TFFCRo48Cr", FinalCastleRoof48CrenellatedComponent::new);
        TFFCBoGaz = TFFeature.registerPiece("TFFCBoGaz", FinalCastleBossGazeboComponent::new);
        TFFCSiTo = TFFeature.registerPiece("TFFCSiTo", FinalCastleMazeTower13Component::new);
        TFFCDunSt = TFFeature.registerPiece("TFFCDunSt", FinalCastleDungeonStepsComponent::new);
        TFFCDunEn = TFFeature.registerPiece("TFFCDunEn", FinalCastleDungeonEntranceComponent::new);
        TFFCDunR31 = TFFeature.registerPiece("TFFCDunR31", FinalCastleDungeonRoom31Component::new);
        TFFCDunEx = TFFeature.registerPiece("TFFCDunEx", FinalCastleDungeonExitComponent::new);
        TFFCDunBoR = TFFeature.registerPiece("TFFCDunBoR", FinalCastleDungeonForgeRoomComponent::new);
        TFFCRo9Cr = TFFeature.registerPiece("TFFCRo9Cr", FinalCastleRoof9CrenellatedComponent::new);
        TFFCRo13Cr = TFFeature.registerPiece("TFFCRo13Cr", FinalCastleRoof13CrenellatedComponent::new);
        TFFCRo13Con = TFFeature.registerPiece("TFFCRo13Con", FinalCastleRoof13ConicalComponent::new);
        TFFCRo13Pk = TFFeature.registerPiece("TFFCRo13Pk", FinalCastleRoof13PeakedComponent::new);
        TFFCEnTo = TFFeature.registerPiece("TFFCEnTo", FinalCastleEntranceTowerComponent::new);
        TFFCEnSiTo = TFFeature.registerPiece("TFFCEnSiTo", FinalCastleEntranceSideTowerComponent::new);
        TFFCEnBoTo = TFFeature.registerPiece("TFFCEnBoTo", FinalCastleEntranceBottomTowerComponent::new);
        TFFCEnSt = TFFeature.registerPiece("TFFCEnSt", FinalCastleEntranceStairsComponent::new);
        TFFCBelTo = TFFeature.registerPiece("TFFCBelTo", FinalCastleBellTower21Component::new);
        TFFCBri = TFFeature.registerPiece("TFFCBri", FinalCastleBridgeComponent::new);
        TFFCToF13 = TFFeature.registerPiece("TFFCToF13", FinalCastleFoundation13Component::new);
        TFFCBeF21 = TFFeature.registerPiece("TFFCBeF21", FinalCastleBellFoundation21Component::new);
        TFFCFTh21 = TFFeature.registerPiece("TFFCFTh21", FinalCastleFoundation13ComponentThorns::new);
        TFFCDamT = TFFeature.registerPiece("TFFCDamT", FinalCastleDamagedTowerComponent::new);
        TFFCWrT = TFFeature.registerPiece("TFFCWrT", FinalCastleWreckedTowerComponent::new);
    }
}
