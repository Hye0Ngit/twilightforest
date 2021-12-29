// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class DarkTowerPieces
{
    public static final IStructurePieceType TFDTBal;
    public static final IStructurePieceType TFDTBea;
    public static final IStructurePieceType TFDTBB;
    public static final IStructurePieceType TFDTBT;
    public static final IStructurePieceType TFDTBri;
    public static final IStructurePieceType TFDTEnt;
    public static final IStructurePieceType TFDTEB;
    public static final IStructurePieceType TFDTMai;
    public static final IStructurePieceType TFDTMB;
    public static final IStructurePieceType TFDTRooS;
    public static final IStructurePieceType TFDTRA;
    public static final IStructurePieceType TFDTRC;
    public static final IStructurePieceType TFDTRFP;
    public static final IStructurePieceType TFDTRR;
    public static final IStructurePieceType TFDTWin;
    
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
