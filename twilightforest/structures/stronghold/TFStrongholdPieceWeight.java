// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

public class TFStrongholdPieceWeight
{
    public Class pieceClass;
    public final int pieceWeight;
    public int instancesSpawned;
    public int instancesLimit;
    public int minimumDepth;
    
    public TFStrongholdPieceWeight(final Class par1Class, final int weight, final int limit) {
        this(par1Class, weight, limit, 0);
    }
    
    public TFStrongholdPieceWeight(final Class par1Class, final int weight, final int limit, final int minDepth) {
        this.pieceClass = par1Class;
        this.pieceWeight = weight;
        this.instancesLimit = limit;
        this.minimumDepth = minDepth;
    }
    
    public boolean isDeepEnough(final int par1) {
        return this.canSpawnMoreStructures() && par1 >= this.minimumDepth;
    }
    
    public boolean canSpawnMoreStructures() {
        return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
    }
}
