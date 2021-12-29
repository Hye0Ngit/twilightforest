// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public class MinotaurMazePieces
{
    public static final StructurePieceType TFMMC;
    public static final StructurePieceType TFMMCIF;
    public static final StructurePieceType TFMMCR;
    public static final StructurePieceType TFMMCS;
    public static final StructurePieceType TFMMDE;
    public static final StructurePieceType TFMMDEC;
    public static final StructurePieceType TFMMDEF;
    public static final StructurePieceType TFMMDEFL;
    public static final StructurePieceType TFMMDEP;
    public static final StructurePieceType TFMMDER;
    public static final StructurePieceType TFMMDES;
    public static final StructurePieceType TFMMDET;
    public static final StructurePieceType TFMMDETrC;
    public static final StructurePieceType TFMMDETC;
    public static final StructurePieceType TFMMES;
    public static final StructurePieceType TFMMMound;
    public static final StructurePieceType TFMMMR;
    public static final StructurePieceType TFMMR;
    public static final StructurePieceType TFMMRB;
    public static final StructurePieceType TFMMRC;
    public static final StructurePieceType TFMMRE;
    public static final StructurePieceType TFMMRF;
    public static final StructurePieceType TFMMRSC;
    public static final StructurePieceType TFMMRV;
    public static final StructurePieceType TFMMRuins;
    public static final StructurePieceType TFMMUE;
    public static final StructurePieceType TFMMaze;
    
    static {
        TFMMC = TFFeature.registerPiece("TFMMC", MazeCorridorComponent::new);
        TFMMCIF = TFFeature.registerPiece("TFMMCIF", MazeCorridorIronFenceComponent::new);
        TFMMCR = TFFeature.registerPiece("TFMMCR", MazeCorridorRootsComponent::new);
        TFMMCS = TFFeature.registerPiece("TFMMCS", MazeCorridorShroomsComponent::new);
        TFMMDE = TFFeature.registerPiece("TFMMDE", MazeDeadEndComponent::new);
        TFMMDEC = TFFeature.registerPiece("TFMMDEC", MazeDeadEndChestComponent::new);
        TFMMDEF = TFFeature.registerPiece("TFMMDEF", MazeDeadEndFountainComponent::new);
        TFMMDEFL = TFFeature.registerPiece("TFMMDEFL", MazeDeadEndFountainLavaComponent::new);
        TFMMDEP = TFFeature.registerPiece("TFMMDEP", MazeDeadEndPaintingComponent::new);
        TFMMDER = TFFeature.registerPiece("TFMMDER", MazeDeadEndRootsComponent::new);
        TFMMDES = TFFeature.registerPiece("TFMMDES", MazeDeadEndShroomsComponent::new);
        TFMMDET = TFFeature.registerPiece("TFMMDET", MazeDeadEndTorchesComponent::new);
        TFMMDETrC = TFFeature.registerPiece("TFMMDETrC", MazeDeadEndTrappedChestComponent::new);
        TFMMDETC = TFFeature.registerPiece("TFMMDETC", MazeDeadEndTripwireChestComponent::new);
        TFMMES = TFFeature.registerPiece("TFMMES", MazeEntranceShaftComponent::new);
        TFMMMound = TFFeature.registerPiece("TFMMMound", MazeMoundComponent::new);
        TFMMMR = TFFeature.registerPiece("TFMMMR", MazeMushRoomComponent::new);
        TFMMR = TFFeature.registerPiece("TFMMR", MazeRoomComponent::new);
        TFMMRB = TFFeature.registerPiece("TFMMRB", MazeRoomBossComponent::new);
        TFMMRC = TFFeature.registerPiece("TFMMRC", MazeRoomCollapseComponent::new);
        TFMMRE = TFFeature.registerPiece("TFMMRE", MazeRoomExitComponent::new);
        TFMMRF = TFFeature.registerPiece("TFMMRF", MazeRoomFountainComponent::new);
        TFMMRSC = TFFeature.registerPiece("TFMMRSC", MazeRoomSpawnerChestsComponent::new);
        TFMMRV = TFFeature.registerPiece("TFMMRV", MazeRoomVaultComponent::new);
        TFMMRuins = TFFeature.registerPiece("TFMMRuins", MazeRuinsComponent::new);
        TFMMUE = TFFeature.registerPiece("TFMMUE", MazeUpperEntranceComponent::new);
        TFMMaze = TFFeature.registerPiece("TFMMaze", MinotaurMazeComponent::new);
    }
}
