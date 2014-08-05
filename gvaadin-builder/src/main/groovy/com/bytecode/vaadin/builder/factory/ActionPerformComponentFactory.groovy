package com.bytecode.vaadin.builder.factory

/**
 * Created by rcigni on 05/08/14.
 */
class ActionPerformComponentFactory extends AbstractFactory {

    Class clazz

    ActionPerformComponentFactory(Class clazz) {
        super()
        this.clazz = clazz
    }

    @Override
    boolean isLeaf() {false}

    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        clazz.newInstance()
    }

}
