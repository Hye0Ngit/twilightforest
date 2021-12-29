// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.courtyard;

import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public class NagaCourtyardPieces
{
    public static final StructurePieceType TFNCMn;
    public static final StructurePieceType TFNCCp;
    public static final StructurePieceType TFNCCpP;
    public static final StructurePieceType TFNCCr;
    public static final StructurePieceType TFNCLn;
    public static final StructurePieceType TFNCT;
    public static final StructurePieceType TFNCIs;
    public static final StructurePieceType TFNCPd;
    public static final StructurePieceType TFNCTr;
    public static final StructurePieceType TFNCDu;
    public static final StructurePieceType TFNCSt;
    public static final StructurePieceType TFNCPa;
    public static final StructurePieceType TFNCWl;
    public static final StructurePieceType TFNCWP;
    public static final StructurePieceType TFNCWC;
    public static final StructurePieceType TFNCWA;
    
    static {
        TFNCMn = TFFeature.registerPiece("TFNCMn", CourtyardMain::new);
        TFNCCp = TFFeature.registerPiece("TFNCCp", NagaCourtyardHedgeCapComponent::new);
        TFNCCpP = TFFeature.registerPiece("TFNCCpP", NagaCourtyardHedgeCapPillarComponent::new);
        TFNCCr = TFFeature.registerPiece("TFNCCr", NagaCourtyardHedgeCornerComponent::new);
        TFNCLn = TFFeature.registerPiece("TFNCLn", NagaCourtyardHedgeLineComponent::new);
        TFNCT = TFFeature.registerPiece("TFNCT", NagaCourtyardHedgeTJunctionComponent::new);
        TFNCIs = TFFeature.registerPiece("TFNCIs", NagaCourtyardHedgeIntersectionComponent::new);
        TFNCPd = TFFeature.registerPiece("TFNCPd", NagaCourtyardHedgePadderComponent::new);
        TFNCTr = TFFeature.registerPiece("TFNCTr", CourtyardTerraceBrazier::new);
        TFNCDu = TFFeature.registerPiece("TFNCDu", CourtyardTerraceDuct::new);
        TFNCSt = TFFeature.registerPiece("TFNCSt", CourtyardTerraceStatue::new);
        TFNCPa = TFFeature.registerPiece("TFNCPa", CourtyardPathPiece::new);
        TFNCWl = TFFeature.registerPiece("TFNCWl", CourtyardWall::new);
        TFNCWP = TFFeature.registerPiece("TFNCWP", CourtyardWallPadder::new);
        TFNCWC = TFFeature.registerPiece("TFNCWC", CourtyardWallCornerOuter::new);
        TFNCWA = TFFeature.registerPiece("TFNCWA", CourtyardWallCornerInner::new);
    }
}
