// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;

public class StructureDecoratorDarkTower extends StructureTFDecorator
{
    public StructureDecoratorDarkTower() {
        this.blockID = TFBlocks.towerWood.cF;
        this.blockMeta = 0;
        this.accentID = TFBlocks.towerWood.cF;
        this.accentMeta = 1;
        this.fenceID = aqw.be.cF;
        this.stairID = aqw.cb.cF;
        this.pillarID = TFBlocks.towerWood.cF;
        this.pillarMeta = 1;
        this.platformID = TFBlocks.towerWood.cF;
        this.platformMeta = 1;
        this.randomBlocks = StructureTFComponent.getTowerWoods();
    }
}
