// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class IceTowerPieces
{
    public static final IStructurePieceType TFITMai;
    public static final IStructurePieceType TFITWin;
    public static final IStructurePieceType TFITRoof;
    public static final IStructurePieceType TFITBea;
    public static final IStructurePieceType TFITBoss;
    public static final IStructurePieceType TFITEnt;
    public static final IStructurePieceType TFITBri;
    public static final IStructurePieceType TFITSt;
    
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
