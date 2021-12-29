// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.structures.StructureTFComponent;
import twilightforest.structures.StructureTFDecorator;

public class StructureTFDecoratorStronghold extends StructureTFDecorator
{
    public StructureTFDecoratorStronghold() {
        this.blockID = aqw.br.cF;
        this.blockMeta = 0;
        this.accentID = aqw.br.cF;
        this.accentMeta = 3;
        this.fenceID = aqw.cg.cF;
        this.stairID = aqw.bC.cF;
        this.pillarID = aqw.br.cF;
        this.pillarMeta = 1;
        this.platformID = aqw.ap.cF;
        this.platformMeta = 13;
        this.randomBlocks = StructureTFComponent.getStrongholdStones();
    }
}
