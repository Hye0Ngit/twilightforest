// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

public class GenLayerTF6x6Preset extends GenLayerTF7x7Preset
{
    public GenLayerTF6x6Preset(final long par1) {
        super(par1);
        this.initPresets();
    }
    
    private void initPresets() {
        final char[][] map = { { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' }, { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' }, { 'P', 'P', 'H', 'H', 'H', 'D', 'D', 'D', 'P' }, { 'P', 'P', 'H', 'H', 'H', 'M', 'D', 'D', 'P' }, { 'P', 'P', 'F', 'F', 'C', 'm', 'm', 'D', 'P' }, { 'P', 'P', 'f', 'f', 'F', 'E', 'F', 'O', 'P' }, { 'P', 'P', 'S', 'S', 'f', 'f', 'O', 'G', 'P' }, { 'P', 'P', 'Y', 'S', 'f', 'L', 'O', 'G', 'P' }, { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' } };
        for (int x = 0; x < map.length; ++x) {
            for (int z = 0; z < map[x].length; ++z) {
                this.preset[x][z] = this.getBiomeFor(map[z][x]);
            }
        }
    }
}
