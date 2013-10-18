package com.bytecode.vaadin.builder.factory

import com.vaadin.ui.Component
import com.vaadin.ui.SingleComponentContainer

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/18/13
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
class SingleComponentFactory extends NamedComponentFactory {

    Class clazz

    SingleComponentFactory(Class aClass) {
        assert SingleComponentContainer.isAssignableFrom(aClass)
        this.clazz = aClass
    }

    @Override
    Component newInstance(FactoryBuilderSupport builder, Object name, Map attributes) throws InstantiationException, IllegalAccessException {
        clazz.newInstance()
    }

    @Override
    boolean isLeaf() {false}

    @Override
    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        ((SingleComponentContainer) parent).setContent(child);
    }
}
