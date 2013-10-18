package com.bytecode.vaadin.builder.factory

/**
 * User: rcigni
 */
class EventListenerFactory extends AbstractFactory {

    Class clazz
    String parentMethodName

    EventListenerFactory(Class clazz, String parentMethodName) {
        // todo handle assert
        this.clazz = clazz
        this.parentMethodName = parentMethodName
    }

    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        assert value instanceof Closure
        value.asType(clazz)

    }

    @Override
    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        parent."${parentMethodName}"(child)
    }
}
