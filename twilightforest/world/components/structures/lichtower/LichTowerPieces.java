// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public class LichTowerPieces
{
    public static final StructurePieceType TFLTBea;
    public static final StructurePieceType TFLTBA;
    public static final StructurePieceType TFLTBri;
    public static final StructurePieceType TFLTMai;
    public static final StructurePieceType TFLTOut;
    public static final StructurePieceType TFLTRoo;
    public static final StructurePieceType TFLTRAS;
    public static final StructurePieceType TFLTRF;
    public static final StructurePieceType TFLTRGF;
    public static final StructurePieceType TFLTRP;
    public static final StructurePieceType TFLTRPO;
    public static final StructurePieceType TFLTRS;
    public static final StructurePieceType TFLTRSF;
    public static final StructurePieceType TFLTRSt;
    public static final StructurePieceType TFLTRStO;
    public static final StructurePieceType TFLTWin;
    
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
