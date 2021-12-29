// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.layer;

public class GenLayerTF5x5Preset extends GenLayerTF7x7Preset
{
    public GenLayerTF5x5Preset(final long seed) {
        super(seed);
        this.initPresets();
    }
    
    private void initPresets() {
        final char[][] map = { { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' }, { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' }, { 'P', 'P', 'H', 'H', 'L', 'D', 'D', 'P', 'P' }, { 'P', 'P', 'H', 'H', 'm', 'M', 'D', 'P', 'P' }, { 'P', 'P', 'F', 'F', 'F', 'C', 'E', 'P', 'P' }, { 'P', 'P', 'S', 'f', 'F', 'F', 'O', 'P', 'P' }, { 'P', 'P', 'Y', 'S', 'F', 'O', 'G', 'P', 'P' }, { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' }, { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' } };
        for (int x = 0; x < map.length; ++x) {
            for (int z = 0; z < map[x].length; ++z) {
                this.preset[x][z] = map[z][x];
            }
        }
    }
}
