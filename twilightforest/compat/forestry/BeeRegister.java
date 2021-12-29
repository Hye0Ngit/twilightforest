// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.forestry;

import forestry.api.genetics.IGenome;
import forestry.api.genetics.ISpeciesType;
import forestry.api.genetics.IIndividual;
import net.minecraft.item.ItemStack;
import forestry.api.apiculture.EnumBeeType;
import forestry.apiculture.genetics.Bee;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IAlleleBeeSpeciesBuilder;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.api.apiculture.BeeManager;
import java.util.Locale;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.genetics.IAllele;
import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.core.genetics.IBranchDefinition;
import forestry.apiculture.genetics.IBeeDefinition;

public enum BeeRegister implements IBeeDefinition
{
    TWILIT((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Crepusculum"), 
    ENSORCELIZED((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Carminibus"), 
    MIRY((IBranchDefinition)BeeBranchRegister.SWAMP, "Paluster"), 
    OMINOUS((IBranchDefinition)BeeBranchRegister.DARK_FOREST, "Minaces"), 
    FRIGID((IBranchDefinition)BeeBranchRegister.SNOWY_FOREST, "Frigidus"), 
    DRAINED((IBranchDefinition)BeeBranchRegister.HIGHLANDS, "Adficio"), 
    CONFUSED((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Confusus"), 
    ENLIGHTENED((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Cultus"), 
    HERBAL((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Herba"), 
    TREE((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Arboreal"), 
    DRUIDIC((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Druidae"), 
    RHYTHMIC((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Tempus"), 
    TRANSFIGURATIVE((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Transformato"), 
    EXCAVATOR((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Tergeo"), 
    CATEGORICAL((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Catalogus"), 
    ENTANGLED((IBranchDefinition)BeeBranchRegister.SWAMP, "Capti"), 
    LABYRINTHINE((IBranchDefinition)BeeBranchRegister.SWAMP, "Labyrinthus"), 
    MISTY((IBranchDefinition)BeeBranchRegister.DARK_FOREST, "Caliginosus"), 
    PIERCING((IBranchDefinition)BeeBranchRegister.DARK_FOREST, "Penetralis"), 
    FROZEN((IBranchDefinition)BeeBranchRegister.SNOWY_FOREST, "Glacialis"), 
    GELID((IBranchDefinition)BeeBranchRegister.SNOWY_FOREST, "Gelida"), 
    ANIMATED((IBranchDefinition)BeeBranchRegister.HIGHLANDS, "Vividus"), 
    SENTINEL((IBranchDefinition)BeeBranchRegister.HIGHLANDS, "Excubitor"), 
    MYTHOLOGICAL((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Fabulares"), 
    ENTROPHIED((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Champion"), 
    SHEEPISH((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Modestus"), 
    SERPENTINE((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Anguis"), 
    NECROMANTIC((IBranchDefinition)BeeBranchRegister.TWILIGHT, "Necromantiae"), 
    MINOTAUR((IBranchDefinition)BeeBranchRegister.SWAMP, "Minotaurus"), 
    DUPLICATIVE((IBranchDefinition)BeeBranchRegister.SWAMP, "Capitibus"), 
    PHANTASMAGORICAL((IBranchDefinition)BeeBranchRegister.DARK_FOREST, "Inconcilio"), 
    CARMINIATED((IBranchDefinition)BeeBranchRegister.DARK_FOREST, "Vis"), 
    CRYPTID((IBranchDefinition)BeeBranchRegister.SNOWY_FOREST, "Creatura"), 
    MONARCHICAL((IBranchDefinition)BeeBranchRegister.SNOWY_FOREST, "Monarchica"), 
    ONTOMANTIC((IBranchDefinition)BeeBranchRegister.HIGHLANDS, "Rego");
    
    private final IBranchDefinition branch;
    private final IAlleleBeeSpecies species;
    private IAllele[] template;
    private IBeeGenome genome;
    
    private BeeRegister(final IBranchDefinition branch, final String species) {
        this.branch = branch;
        final String lowerCase = this.toString().toLowerCase(Locale.ROOT);
        final IAlleleBeeSpeciesBuilder speciesBuilder = BeeManager.beeFactory.createSpecies("twilightforest", "twilightforest:" + lowerCase, true, "Drullkus", "twilightforest.bee." + lowerCase, "twilightforest.bee." + lowerCase + ".desc", branch.getBranch(), species.toLowerCase(Locale.ROOT), 16777215, 16777215);
        this.setSpeciesProperties(speciesBuilder);
        this.species = speciesBuilder.build();
        this.template = this.branch.getTemplate();
        AlleleHelper.getInstance().set(this.template, (Enum)EnumBeeChromosome.SPECIES, (IAllele)this.species);
        this.setAlleles(this.template);
        this.genome = BeeManager.beeRoot.templateAsGenome(this.template);
        BeeManager.beeRoot.registerTemplate(this.template);
    }
    
    public IAllele[] getTemplate() {
        final IAllele[] copiedAlleles = new IAllele[this.template.length];
        System.arraycopy(this.template, 0, (Object)copiedAlleles, 0, this.template.length);
        return copiedAlleles;
    }
    
    public final IBeeGenome getGenome() {
        return this.genome;
    }
    
    public final IBee getIndividual() {
        return (IBee)new Bee(this.genome);
    }
    
    public ItemStack getMemberStack(final EnumBeeType enumBeeType) {
        final IBee bee = this.getIndividual();
        return BeeManager.beeRoot.getMemberStack((IIndividual)bee, (ISpeciesType)enumBeeType);
    }
    
    private void setSpeciesProperties(final IAlleleBeeSpeciesBuilder speciesProperties) {
    }
    
    private void setAlleles(final IAllele[] alleles) {
    }
}
