package com.bytecode.vaadin.builder.factory

import com.vaadin.ui.SingleComponentContainer

/**
 * User: rcigni
 */
class SingleComponentFactory extends AbstractFactory {

    Class clazz

    SingleComponentFactory(Class aClass) {
        assert SingleComponentContainer.isAssignableFrom(aClass)
        this.clazz = aClass
    }

    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        clazz.newInstance()
    }

    @Override
    boolean isLeaf() {false}


    @Override
    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        ((SingleComponentContainer) parent).setContent(child);
    }
}
