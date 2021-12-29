// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public class DarkTowerPieces
{
    public static final StructurePieceType TFDTBal;
    public static final StructurePieceType TFDTBea;
    public static final StructurePieceType TFDTBB;
    public static final StructurePieceType TFDTBT;
    public static final StructurePieceType TFDTBri;
    public static final StructurePieceType TFDTEnt;
    public static final StructurePieceType TFDTEB;
    public static final StructurePieceType TFDTMai;
    public static final StructurePieceType TFDTMB;
    public static final StructurePieceType TFDTRooS;
    public static final StructurePieceType TFDTRA;
    public static final StructurePieceType TFDTRC;
    public static final StructurePieceType TFDTRFP;
    public static final StructurePieceType TFDTRR;
    public static final StructurePieceType TFDTWin;
    
    static {
        TFDTBal = TFFeature.registerPiece("TFDTBal", DarkTowerBalconyComponent::new);
        TFDTBea = TFFeature.registerPiece("TFDTBea", DarkTowerBeardComponent::new);
        TFDTBB = TFFeature.registerPiece("TFDTBB", DarkTowerBossBridgeComponent::new);
        TFDTBT = TFFeature.registerPiece("TFDTBT", DarkTowerBossTrapComponent::new);
        TFDTBri = TFFeature.registerPiece("TFDTBri", DarkTowerBridgeComponent::new);
        TFDTEnt = TFFeature.registerPiece("TFDTEnt", DarkTowerEntranceComponent::new);
        TFDTEB = TFFeature.registerPiece("TFDTEB", DarkTowerEntranceBridgeComponent::new);
        TFDTMai = TFFeature.registerPiece("TFDTMai", DarkTowerMainComponent::new);
        TFDTMB = TFFeature.registerPiece("TFDTMB", DarkTowerMainBridgeComponent::new);
        TFDTRooS = TFFeature.registerPiece("TFDTRooS", DarkTowerRoofComponent::new);
        TFDTRA = TFFeature.registerPiece("TFDTRA", DarkTowerRoofAntennaComponent::new);
        TFDTRC = TFFeature.registerPiece("TFDTRC", DarkTowerRoofCactusComponent::new);
        TFDTRFP = TFFeature.registerPiece("TFDTRFP", DarkTowerRoofFourPostComponent::new);
        TFDTRR = TFFeature.registerPiece("TFDTRR", DarkTowerRoofRingsComponent::new);
        TFDTWin = TFFeature.registerPiece("TFDTWin", DarkTowerWingComponent::new);
    }
}
