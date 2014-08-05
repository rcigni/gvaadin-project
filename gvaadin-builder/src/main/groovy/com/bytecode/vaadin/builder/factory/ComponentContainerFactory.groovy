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
class ComponentContainerFactory extends AbstractFactory {

    Class clazz

    ComponentContainerFactory(Class component) {
        assert ComponentContainer.class.isAssignableFrom(component)
        clazz = component
    }

    @Override
    boolean onNodeChildren(FactoryBuilderSupport builder, Object node, Closure childContent) {
        return super.onNodeChildren(builder, node, childContent)
    }

    boolean isLeaf() {false}

    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        clazz.newInstance();
    }

    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        parent.addComponent child
    }
}
