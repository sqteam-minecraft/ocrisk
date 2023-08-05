package org.sqteam.ocrisk;

import li.cil.oc.api.machine.*;
import li.cil.oc.api.network.Component;
import li.cil.oc.api.network.Node;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

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
        logger.info("recompute: {}", new ArrayList<>((Collection) iterable));
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
        Signal signal = machine.popSignal();
        //
        if (signal != null) {
            Iterable<Node> nodes = machine.node().reachableNodes();
            logger.info("{} - {}", signal.name(), signal.args());
            //machine.node().sendToAddress("b793c238-6e5d-4a64-b438-ca3a3cb4b061", "print", );
            final Node node = machine.node().network().node("495f2bc7-7c83-403b-88f5-3ed44e90e454");
            if (node instanceof Component) {
                final Component component = (Component) node;
                if (component.canBeSeenFrom(machine.node())) {
                    Map<String, Callback> functions =  machine.methods(node.host());
                    logger.info("components: {}", functions.get("bind"));
                }
            }
            try {
                if(signal.name().equals("drop") || signal.name().equals("drag") ) {
                    logger.info("bind => {}", machine.invoke("495f2bc7-7c83-403b-88f5-3ed44e90e454", "bind", new Object[]{"67459401-8235-46e3-bc56-f124dd26a6ed"}));
                    logger.info("setForeground => {}", machine.invoke("495f2bc7-7c83-403b-88f5-3ed44e90e454", "setBackground", new Object[]{0x00AA00, false}));
                    logger.info("fill => {}", machine.invoke("495f2bc7-7c83-403b-88f5-3ed44e90e454", "fill", new Object[]{signal.args()[1], signal.args()[2], 1, 1, " "}));
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            //logger.info("status:", );
            logger.info("nodes: {}", machine.node().reachableNodes());
        }
        return new ExecutionResult.Sleep(0);
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
