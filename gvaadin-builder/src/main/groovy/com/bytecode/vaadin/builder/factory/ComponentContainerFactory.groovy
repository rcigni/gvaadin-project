package com.bytecode.vaadin.builder.factory

import com.vaadin.ui.ComponentContainer
import com.vaadin.ui.VerticalLayout

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/18/13
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
class ComponentContainerFactory extends AbstractFactory {

    Class componentContainerClass

    ComponentContainerFactory(Class component) {
        assert ComponentContainer.class.isAssignableFrom(component)
        componentContainerClass = component
    }

    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        def subject = componentContainerClass.newInstance();
        attributes.each {
            subject[it.key] = it.value
        }
        subject
    }

    @Override
    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        parent.addComponent child
    }
}
