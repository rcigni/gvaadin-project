package com.bytecode.vaadin.builder

import com.bytecode.vaadin.builder.factory.ComponentContainerFactory
import com.bytecode.vaadin.builder.factory.EventListenerFactory
import com.bytecode.vaadin.builder.factory.LeafComponentFactory
import com.bytecode.vaadin.builder.factory.NamedComponentHandler
import com.bytecode.vaadin.builder.factory.SingleComponentFactory
import com.vaadin.event.FieldEvents
import com.vaadin.ui.*

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/18/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class VaadinBuilder extends FactoryBuilderSupport implements NamedComponentHandler {

    def registry = [:]

    public VaadinBuilder(boolean init = true) {
        super(init);
        registerFactories();
    }

    private void registerFactories() {

        // layouts
        registerFactory "verticalLayout", new ComponentContainerFactory(VerticalLayout.class);
        registerFactory "horizontalLayout", new ComponentContainerFactory(HorizontalLayout.class);

        registerFactory "panel", new SingleComponentFactory(Panel.class);

        // simple leafs
        registerFactory "button", new LeafComponentFactory(Button.class);
        registerFactory "label", new LeafComponentFactory(Label.class);

        // inputs
        registerFactory "textField", new LeafComponentFactory(TextField.class);
        registerFactory "textArea", new LeafComponentFactory(TextArea.class);

        // events
//        registerFactory("onClick", new EventListenerFactory(Button.ClickListener, "addClickListener"))
//        registerFactory("onFocus", new EventListenerFactory(FieldEvents.FocusListener, "addFocusListener"))
//        registerFactory("onBlur", new EventListenerFactory(FieldEvents.BlurListener, "addBlurListener"))

    }

    @Override
    void notify(String name, Component component) {
        if (registry.containsKey(name)) {
            throw new IllegalStateException("The name '${name}' has been used by ${registry[name]} component");
        } else {
            registry[name] = component
        }
    }

}