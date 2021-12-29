// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.structures.TFStructureComponentOld;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import java.util.Random;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import java.util.Iterator;
import java.util.ArrayList;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import java.util.List;

public class StrongholdPieces
{
    private static final StrongholdPieceWeight[] pieceWeightArray;
    private List<StrongholdPieceWeight> pieceList;
    static int totalWeight;
    private static StrongholdPieceWeight lastPieceMade;
    public static final IStructurePieceType TFSSH;
    public static final IStructurePieceType TFSLT;
    public static final IStructurePieceType TFSCr;
    public static final IStructurePieceType TFSRT;
    public static final IStructurePieceType TFSDE;
    public static final IStructurePieceType TFSBalR;
    public static final IStructurePieceType TFSTR;
    public static final IStructurePieceType TFSSS;
    public static final IStructurePieceType TFSTC;
    public static final IStructurePieceType TFSAt;
    public static final IStructurePieceType TFSFo;
    public static final IStructurePieceType TFTreaR;
    public static final IStructurePieceType TFSBR;
    public static final IStructurePieceType TFSAC;
    public static final IStructurePieceType TFSEnter;
    public static final IStructurePieceType TFSUA;
    public static final IStructurePieceType TFSULT;
    public static final IStructurePieceType TFSURT;
    public static final IStructurePieceType TFSUCo;
    public static final IStructurePieceType TFSUTI;
    public static final IStructurePieceType TFSShield;
    
    public void prepareStructurePieces() {
        this.pieceList = new ArrayList<StrongholdPieceWeight>();
        for (final StrongholdPieceWeight piece : StrongholdPieces.pieceWeightArray) {
            piece.instancesSpawned = 0;
            this.pieceList.add(piece);
        }
    }
    
    public void markBossRoomUsed() {
        this.pieceList.remove(this.pieceList.size() - 1);
    }
    
    private boolean hasMoreLimitedPieces() {
        boolean flag = false;
        StrongholdPieces.totalWeight = 0;
        for (final StrongholdPieceWeight piece : this.pieceList) {
            StrongholdPieces.totalWeight += piece.pieceWeight;
            if (piece.instancesLimit > 0 && piece.instancesSpawned < piece.instancesLimit) {
                flag = true;
            }
        }
        return flag;
    }
    
    public StructureTFStrongholdComponent getNextComponent(final StructurePiece parent, final List<StructurePiece> list, final Random random, final TFFeature feature, final int index, final Direction facing, final int x, final int y, final int z) {
        if (!this.hasMoreLimitedPieces()) {
            return null;
        }
        for (int i = 0; i < 5; ++i) {
            int counter = random.nextInt(StrongholdPieces.totalWeight);
            for (final StrongholdPieceWeight piece : this.pieceList) {
                counter -= piece.pieceWeight;
                if (counter < 0) {
                    if (!piece.isDeepEnough(index)) {
                        break;
                    }
                    if (piece == StrongholdPieces.lastPieceMade) {
                        break;
                    }
                    final StructureTFStrongholdComponent component = (StructureTFStrongholdComponent)piece.factory.newInstance(feature, index, facing, x, y, z);
                    if (StructurePiece.func_74883_a((List)list, component.func_74874_b()) == null) {
                        final StrongholdPieceWeight strongholdPieceWeight = piece;
                        ++strongholdPieceWeight.instancesSpawned;
                        if (!piece.canSpawnMoreStructures()) {
                            this.pieceList.remove(piece);
                        }
                        StrongholdPieces.lastPieceMade = piece;
                        return component;
                    }
                    continue;
                }
            }
        }
        final StructureTFStrongholdComponent deadEnd = new StrongholdDeadEndComponent((parent instanceof TFStructureComponentOld) ? ((TFStructureComponentOld)parent).getFeatureType() : TFFeature.NOTHING, index, facing, x, y, z);
        if (StructurePiece.func_74883_a((List)list, deadEnd.func_74874_b()) == null) {
            return deadEnd;
        }
        return null;
    }
    
    static {
        pieceWeightArray = new StrongholdPieceWeight[] { new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdSmallHallwayComponent::new, 40, 0), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdLeftTurnComponent::new, 20, 0), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdCrossingComponent::new, 10, 4), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdRightTurnComponent::new, 20, 0), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdDeadEndComponent::new, 5, 0), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdBalconyRoomComponent::new, 10, 3, 2), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdTrainingRoomComponent::new, 10, 2), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdSmallStairsComponent::new, 10, 0), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdTreasureCorridorComponent::new, 5, 0), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdAtriumComponent::new, 5, 2, 3), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdFoundryComponent::new, 5, 1, 4), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdTreasureRoomComponent::new, 5, 1, 4), new StrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)StrongholdBossRoomComponent::new, 10, 1, 4) };
        StrongholdPieces.totalWeight = 0;
        TFSSH = TFFeature.registerPiece("TFSSH", StrongholdSmallHallwayComponent::new);
        TFSLT = TFFeature.registerPiece("TFSLT", StrongholdLeftTurnComponent::new);
        TFSCr = TFFeature.registerPiece("TFSCr", StrongholdCrossingComponent::new);
        TFSRT = TFFeature.registerPiece("TFSRT", StrongholdRightTurnComponent::new);
        TFSDE = TFFeature.registerPiece("TFSDE", StrongholdDeadEndComponent::new);
        TFSBalR = TFFeature.registerPiece("TFSBalR", StrongholdBalconyRoomComponent::new);
        TFSTR = TFFeature.registerPiece("TFSTR", StrongholdTrainingRoomComponent::new);
        TFSSS = TFFeature.registerPiece("TFSSS", StrongholdSmallStairsComponent::new);
        TFSTC = TFFeature.registerPiece("TFSTC", StrongholdTreasureCorridorComponent::new);
        TFSAt = TFFeature.registerPiece("TFSAt", StrongholdAtriumComponent::new);
        TFSFo = TFFeature.registerPiece("TFSFo", StrongholdFoundryComponent::new);
        TFTreaR = TFFeature.registerPiece("TFTreaR", StrongholdTreasureRoomComponent::new);
        TFSBR = TFFeature.registerPiece("TFSBR", StrongholdBossRoomComponent::new);
        TFSAC = TFFeature.registerPiece("TFSAC", StrongholdAccessChamberComponent::new);
        TFSEnter = TFFeature.registerPiece("TFSEnter", StrongholdEntranceComponent::new);
        TFSUA = TFFeature.registerPiece("TFSUA", StrongholdUpperAscenderComponent::new);
        TFSULT = TFFeature.registerPiece("TFSULT", StrongholdUpperLeftTurnComponent::new);
        TFSURT = TFFeature.registerPiece("TFSURT", StrongholdUpperRightTurnComponent::new);
        TFSUCo = TFFeature.registerPiece("TFSUCo", StrongholdUpperCorridorComponent::new);
        TFSUTI = TFFeature.registerPiece("TFSUTI", StrongholdUpperTIntersectionComponent::new);
        TFSShield = TFFeature.registerPiece("TFSShield", StrongholdShieldStructure::new);
    }
}
