// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.trollcave;

import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public class TrollCavePieces
{
    public static final StructurePieceType TFTCMai;
    public static final StructurePieceType TFTCCon;
    public static final StructurePieceType TFTCGard;
    public static final StructurePieceType TFTCloud;
    public static final StructurePieceType TFClCa;
    public static final StructurePieceType TFClTr;
    public static final StructurePieceType TFTCVa;
    
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
