package org.sqteam.ocrisk;

import li.cil.oc.api.machine.Architecture;
import li.cil.oc.api.machine.ExecutionResult;
import li.cil.oc.api.machine.Machine;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Architecture.Name("OCRisk")
public class OCRiskArchitecture implements Architecture {

    private static final Logger logger =  LogManager.getLogger(OCRiskArchitecture.class);
    private final Machine machine;

    public OCRiskArchitecture(Machine machine) {
        this.machine = machine;
    }

    @Override
    public boolean isInitialized() {
        logger.debug("isInitialized");
        return true;
    }

    @Override
    public boolean recomputeMemory(Iterable<ItemStack> iterable) {
        return true;
    }

    @Override
    public boolean initialize() {
        logger.debug("init");
        return true;
    }

    @Override
    public void close() {

    }

    @Override
    public void runSynchronized() {

    }

    @Override
    public ExecutionResult runThreaded(boolean b) {
        return new ExecutionResult.Error("Not implemented");
    }

    @Override
    public void onSignal() {
        logger.debug("signal");
    }

    @Override
    public void onConnect() {
        new Main().print();
        logger.debug("connect");
    }

    @Override
    public void load(NBTTagCompound nbtTagCompound) {

    }

    @Override
    public void save(NBTTagCompound nbtTagCompound) {

    }
}
