// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class LichTowerPieces
{
    public static final IStructurePieceType TFLTBea;
    public static final IStructurePieceType TFLTBA;
    public static final IStructurePieceType TFLTBri;
    public static final IStructurePieceType TFLTMai;
    public static final IStructurePieceType TFLTOut;
    public static final IStructurePieceType TFLTRoo;
    public static final IStructurePieceType TFLTRAS;
    public static final IStructurePieceType TFLTRF;
    public static final IStructurePieceType TFLTRGF;
    public static final IStructurePieceType TFLTRP;
    public static final IStructurePieceType TFLTRPO;
    public static final IStructurePieceType TFLTRS;
    public static final IStructurePieceType TFLTRSF;
    public static final IStructurePieceType TFLTRSt;
    public static final IStructurePieceType TFLTRStO;
    public static final IStructurePieceType TFLTWin;
    
    static {
        TFLTBea = TFFeature.registerPiece("TFLTBea", TowerBeardComponent::new);
        TFLTBA = TFFeature.registerPiece("TFLTBA", TowerBeardAttachedComponent::new);
        TFLTBri = TFFeature.registerPiece("TFLTBri", TowerBridgeComponent::new);
        TFLTMai = TFFeature.registerPiece("TFLTMai", TowerMainComponent::new);
        TFLTOut = TFFeature.registerPiece("TFLTOut", TowerOutbuildingComponent::new);
        TFLTRoo = TFFeature.registerPiece("TFLTRoo", TowerRoofComponent::new);
        TFLTRAS = TFFeature.registerPiece("TFLTRAS", TowerRoofAttachedSlabComponent::new);
        TFLTRF = TFFeature.registerPiece("TFLTRF", TowerRoofFenceComponent::new);
        TFLTRGF = TFFeature.registerPiece("TFLTRGF", TowerRoofGableForwardsComponent::new);
        TFLTRP = TFFeature.registerPiece("TFLTRP", TowerRoofPointyComponent::new);
        TFLTRPO = TFFeature.registerPiece("TFLTRPO", TowerRoofPointyOverhangComponent::new);
        TFLTRS = TFFeature.registerPiece("TFLTRS", TowerRoofSlabComponent::new);
        TFLTRSF = TFFeature.registerPiece("TFLTRSF", TowerRoofSlabForwardsComponent::new);
        TFLTRSt = TFFeature.registerPiece("TFLTRSt", TowerRoofStairsComponent::new);
        TFLTRStO = TFFeature.registerPiece("TFLTRStO", TowerRoofStairsOverhangComponent::new);
        TFLTWin = TFFeature.registerPiece("TFLTWin", TowerWingComponent::new);
    }
}
