// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

public class StrongholdPieceWeight
{
    public final StructureTFStrongholdComponent.Factory<? extends StructureTFStrongholdComponent> factory;
    public final int pieceWeight;
    public int instancesSpawned;
    public int instancesLimit;
    public int minimumDepth;
    
    public <T extends StructureTFStrongholdComponent> StrongholdPieceWeight(final StructureTFStrongholdComponent.Factory<T> factory, final int weight, final int limit) {
        this(factory, weight, limit, 0);
    }
    
    public <T extends StructureTFStrongholdComponent> StrongholdPieceWeight(final StructureTFStrongholdComponent.Factory<T> factory, final int weight, final int limit, final int minDepth) {
        this.factory = factory;
        this.pieceWeight = weight;
        this.instancesLimit = limit;
        this.minimumDepth = minDepth;
    }
    
    public boolean isDeepEnough(final int depth) {
        return this.canSpawnMoreStructures() && depth >= this.minimumDepth;
    }
    
    public boolean canSpawnMoreStructures() {
        return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
    }
}
