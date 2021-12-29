// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class MushroomTowerPieces
{
    public static final IStructurePieceType TFMTMai;
    public static final IStructurePieceType TFMTWin;
    public static final IStructurePieceType TFMTBri;
    public static final IStructurePieceType TFMTMB;
    public static final IStructurePieceType TFMTRoofMush;
    
    static {
        TFMTMai = TFFeature.registerPiece("TFMTMai", MushroomTowerMainComponent::new);
        TFMTWin = TFFeature.registerPiece("TFMTWin", MushroomTowerWingComponent::new);
        TFMTBri = TFFeature.registerPiece("TFMTBri", MushroomTowerBridgeComponent::new);
        TFMTMB = TFFeature.registerPiece("TFMTMB", MushroomTowerMainBridgeComponent::new);
        TFMTRoofMush = TFFeature.registerPiece("TFMTRoofMush", TowerRoofMushroomComponent::new);
    }
}
