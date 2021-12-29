// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.mushroomtower;

import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public class MushroomTowerPieces
{
    public static final StructurePieceType TFMTMai;
    public static final StructurePieceType TFMTWin;
    public static final StructurePieceType TFMTBri;
    public static final StructurePieceType TFMTMB;
    public static final StructurePieceType TFMTRoofMush;
    
    static {
        TFMTMai = TFFeature.registerPiece("TFMTMai", MushroomTowerMainComponent::new);
        TFMTWin = TFFeature.registerPiece("TFMTWin", MushroomTowerWingComponent::new);
        TFMTBri = TFFeature.registerPiece("TFMTBri", MushroomTowerBridgeComponent::new);
        TFMTMB = TFFeature.registerPiece("TFMTMB", MushroomTowerMainBridgeComponent::new);
        TFMTRoofMush = TFFeature.registerPiece("TFMTRoofMush", TowerRoofMushroomComponent::new);
    }
}
