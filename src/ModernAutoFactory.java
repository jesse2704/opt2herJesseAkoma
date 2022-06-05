package src;

public class ModernAutoFactory implements AbstractCarFactory {

    @Override
    public ModernAuto createAuto() {
        ModernAuto newModernAuto = new ModernAuto();
        return newModernAuto;
    }
}
