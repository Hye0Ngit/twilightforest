// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.forestry;

import forestry.apiculture.genetics.alleles.AlleleEffects;
import forestry.core.genetics.alleles.IAlleleValue;
import forestry.core.genetics.alleles.EnumAllele;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.api.apiculture.EnumBeeChromosome;
import java.util.Locale;
import forestry.api.apiculture.BeeManager;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IClassification;
import forestry.core.genetics.IBranchDefinition;

public enum BeeBranchRegister implements IBranchDefinition
{
    TWILIGHT("Crepusculum"), 
    SWAMP("Palus"), 
    DARK_FOREST("Maestus"), 
    SNOWY_FOREST("Frigidus"), 
    HIGHLANDS("Superior");
    
    private final IClassification classification;
    private static IAllele[] defaultTemplate;
    
    private BeeBranchRegister(final String genus) {
        this.classification = BeeManager.beeFactory.createBranch(this.name().toLowerCase(Locale.ENGLISH), genus);
    }
    
    public IAllele[] getTemplate() {
        final IAllele[] template = copyDefaultTemplate();
        final IAllele[] copiedAlleles = new IAllele[template.length];
        System.arraycopy(template, 0, (Object)copiedAlleles, 0, template.length);
        return copiedAlleles;
    }
    
    public IClassification getBranch() {
        return this.classification;
    }
    
    private static IAllele[] copyDefaultTemplate() {
        if (BeeBranchRegister.defaultTemplate == null) {
            BeeBranchRegister.defaultTemplate = new IAllele[EnumBeeChromosome.values().length];
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.SPEED, (IAlleleValue)EnumAllele.Speed.NORMAL);
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.LIFESPAN, (IAlleleValue)EnumAllele.Lifespan.NORMAL);
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.FERTILITY, (IAlleleValue)EnumAllele.Fertility.NORMAL);
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.TEMPERATURE_TOLERANCE, (IAlleleValue)EnumAllele.Tolerance.NONE);
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.NEVER_SLEEPS, false);
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.HUMIDITY_TOLERANCE, (IAlleleValue)EnumAllele.Tolerance.NONE);
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.TOLERATES_RAIN, false);
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.CAVE_DWELLING, false);
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.FLOWER_PROVIDER, (IAlleleValue)EnumAllele.Flowers.VANILLA);
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.FLOWERING, (IAlleleValue)EnumAllele.Flowering.AVERAGE);
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.TERRITORY, (IAlleleValue)EnumAllele.Territory.AVERAGE);
            AlleleHelper.getInstance().set(BeeBranchRegister.defaultTemplate, (Enum)EnumBeeChromosome.EFFECT, (IAllele)AlleleEffects.effectNone);
        }
        final IAllele[] copiedAlleles = new IAllele[BeeBranchRegister.defaultTemplate.length];
        System.arraycopy(BeeBranchRegister.defaultTemplate, 0, (Object)copiedAlleles, 0, BeeBranchRegister.defaultTemplate.length);
        return copiedAlleles;
    }
}
