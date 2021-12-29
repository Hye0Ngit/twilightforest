// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class NagaCourtyardPieces
{
    public static final IStructurePieceType TFNCMn;
    public static final IStructurePieceType TFNCCp;
    public static final IStructurePieceType TFNCCpP;
    public static final IStructurePieceType TFNCCr;
    public static final IStructurePieceType TFNCLn;
    public static final IStructurePieceType TFNCT;
    public static final IStructurePieceType TFNCIs;
    public static final IStructurePieceType TFNCPd;
    public static final IStructurePieceType TFNCTr;
    public static final IStructurePieceType TFNCDu;
    public static final IStructurePieceType TFNCSt;
    public static final IStructurePieceType TFNCPa;
    public static final IStructurePieceType TFNCWl;
    public static final IStructurePieceType TFNCWP;
    public static final IStructurePieceType TFNCWC;
    public static final IStructurePieceType TFNCWA;
    
    static {
        TFNCMn = TFFeature.registerPiece("TFNCMn", NagaCourtyardMainComponent::new);
        TFNCCp = TFFeature.registerPiece("TFNCCp", NagaCourtyardHedgeCapComponent::new);
        TFNCCpP = TFFeature.registerPiece("TFNCCpP", NagaCourtyardHedgeCapPillarComponent::new);
        TFNCCr = TFFeature.registerPiece("TFNCCr", NagaCourtyardHedgeCornerComponent::new);
        TFNCLn = TFFeature.registerPiece("TFNCLn", NagaCourtyardHedgeLineComponent::new);
        TFNCT = TFFeature.registerPiece("TFNCT", NagaCourtyardHedgeTJunctionComponent::new);
        TFNCIs = TFFeature.registerPiece("TFNCIs", NagaCourtyardHedgeIntersectionComponent::new);
        TFNCPd = TFFeature.registerPiece("TFNCPd", NagaCourtyardHedgePadderComponent::new);
        TFNCTr = TFFeature.registerPiece("TFNCTr", NagaCourtyardTerraceBrazierComponent::new);
        TFNCDu = TFFeature.registerPiece("TFNCDu", NagaCourtyardTerraceDuctComponent::new);
        TFNCSt = TFFeature.registerPiece("TFNCSt", NagaCourtyardTerraceStatueComponent::new);
        TFNCPa = TFFeature.registerPiece("TFNCPa", NagaCourtyardPathComponent::new);
        TFNCWl = TFFeature.registerPiece("TFNCWl", NagaCourtyardWallComponent::new);
        TFNCWP = TFFeature.registerPiece("TFNCWP", NagaCourtyardWallPadderComponent::new);
        TFNCWC = TFFeature.registerPiece("TFNCWC", NagaCourtyardWallCornerComponent::new);
        TFNCWA = TFFeature.registerPiece("TFNCWA", NagaCourtyardWallCornerAltComponent::new);
    }
}
