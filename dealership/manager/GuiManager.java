package dealership.manager;

import dealership.messages.Messages;

@FunctionalInterface
public interface GuiManager {
    void show(Messages messages, int err);
}
