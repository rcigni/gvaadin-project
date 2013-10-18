package com.bytecode.vaadin.builder

import com.bytecode.vaadin.builder.factory.ButtonFactory
import com.bytecode.vaadin.builder.factory.ComponentContainerFactory
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.VerticalLayout

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/18/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class VaadinBuilder extends FactoryBuilderSupport {

    public VaadinBuilder(init = true) {
        super(init);
        registerFactories();
    }

    private void registerFactories() {
        registerFactory "verticalLayout", new ComponentContainerFactory(VerticalLayout.class);
        registerFactory "horizontalLayout", new ComponentContainerFactory(HorizontalLayout.class);
        registerFactory "button", new ButtonFactory();
    }

}