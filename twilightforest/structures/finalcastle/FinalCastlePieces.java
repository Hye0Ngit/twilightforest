// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class FinalCastlePieces
{
    public static final IStructurePieceType TFFCMain;
    public static final IStructurePieceType TFFCStTo;
    public static final IStructurePieceType TFFCLaTo;
    public static final IStructurePieceType TFFCMur;
    public static final IStructurePieceType TFFCToF48;
    public static final IStructurePieceType TFFCRo48Cr;
    public static final IStructurePieceType TFFCBoGaz;
    public static final IStructurePieceType TFFCSiTo;
    public static final IStructurePieceType TFFCDunSt;
    public static final IStructurePieceType TFFCDunEn;
    public static final IStructurePieceType TFFCDunR31;
    public static final IStructurePieceType TFFCDunEx;
    public static final IStructurePieceType TFFCDunBoR;
    public static final IStructurePieceType TFFCRo9Cr;
    public static final IStructurePieceType TFFCRo13Cr;
    public static final IStructurePieceType TFFCRo13Con;
    public static final IStructurePieceType TFFCRo13Pk;
    public static final IStructurePieceType TFFCEnTo;
    public static final IStructurePieceType TFFCEnSiTo;
    public static final IStructurePieceType TFFCEnBoTo;
    public static final IStructurePieceType TFFCEnSt;
    public static final IStructurePieceType TFFCBelTo;
    public static final IStructurePieceType TFFCBri;
    public static final IStructurePieceType TFFCToF13;
    public static final IStructurePieceType TFFCBeF21;
    public static final IStructurePieceType TFFCFTh21;
    public static final IStructurePieceType TFFCDamT;
    public static final IStructurePieceType TFFCWrT;
    
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
