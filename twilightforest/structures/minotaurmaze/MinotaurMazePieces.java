// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class MinotaurMazePieces
{
    public static final IStructurePieceType TFMMC;
    public static final IStructurePieceType TFMMCIF;
    public static final IStructurePieceType TFMMCR;
    public static final IStructurePieceType TFMMCS;
    public static final IStructurePieceType TFMMDE;
    public static final IStructurePieceType TFMMDEC;
    public static final IStructurePieceType TFMMDEF;
    public static final IStructurePieceType TFMMDEFL;
    public static final IStructurePieceType TFMMDEP;
    public static final IStructurePieceType TFMMDER;
    public static final IStructurePieceType TFMMDES;
    public static final IStructurePieceType TFMMDET;
    public static final IStructurePieceType TFMMDETrC;
    public static final IStructurePieceType TFMMDETC;
    public static final IStructurePieceType TFMMES;
    public static final IStructurePieceType TFMMMound;
    public static final IStructurePieceType TFMMMR;
    public static final IStructurePieceType TFMMR;
    public static final IStructurePieceType TFMMRB;
    public static final IStructurePieceType TFMMRC;
    public static final IStructurePieceType TFMMRE;
    public static final IStructurePieceType TFMMRF;
    public static final IStructurePieceType TFMMRSC;
    public static final IStructurePieceType TFMMRV;
    public static final IStructurePieceType TFMMRuins;
    public static final IStructurePieceType TFMMUE;
    public static final IStructurePieceType TFMMaze;
    
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
