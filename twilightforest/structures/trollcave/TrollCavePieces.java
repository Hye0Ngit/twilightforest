// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class TrollCavePieces
{
    public static final IStructurePieceType TFTCMai;
    public static final IStructurePieceType TFTCCon;
    public static final IStructurePieceType TFTCGard;
    public static final IStructurePieceType TFTCloud;
    public static final IStructurePieceType TFClCa;
    public static final IStructurePieceType TFClTr;
    public static final IStructurePieceType TFTCVa;
    
    static {
        TFTCMai = TFFeature.registerPiece("TFTCMai", TrollCaveMainComponent::new);
        TFTCCon = TFFeature.registerPiece("TFTCCon", TrollCaveConnectComponent::new);
        TFTCGard = TFFeature.registerPiece("TFTCGard", TrollCaveGardenComponent::new);
        TFTCloud = TFFeature.registerPiece("TFTCloud", TrollCloudComponent::new);
        TFClCa = TFFeature.registerPiece("TFClCa", CloudCastleComponent::new);
        TFClTr = TFFeature.registerPiece("TFClTr", CloudTreeComponent::new);
        TFTCVa = TFFeature.registerPiece("TFTCVa", TrollVaultComponent::new);
    }
}
