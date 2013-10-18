package com.bytecode.vaadin.builder.factory

import com.vaadin.ui.Component
import com.vaadin.ui.ComponentContainer

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/18/13
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
class ComponentContainerFactory extends NamedComponentFactory {

    Class clazz

    ComponentContainerFactory(Class component) {
        assert ComponentContainer.class.isAssignableFrom(component)
        clazz = component
    }

    @Override
    Component newInstance(FactoryBuilderSupport builder, Object name, Map attributes) throws InstantiationException, IllegalAccessException {
        clazz.newInstance();
    }



    @Override
    boolean isLeaf() {false}

    @Override
    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        parent.addComponent child
    }
}
