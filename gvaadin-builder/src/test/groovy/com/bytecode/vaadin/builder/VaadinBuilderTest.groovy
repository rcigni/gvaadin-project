package com.bytecode.vaadin.builder

import com.vaadin.ui.*
import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/18/13
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
class VaadinBuilderTest extends GroovyTestCase{

    @Test
    public void testBuilder1() {

        def builder = new VaadinBuilder();

        def view = builder.verticalLayout {
            label(caption: 'label')
            button(caption: "click me")
            button('luigi', caption: 'luigi caption')
        }

        assert view instanceof VerticalLayout
        def expectLabel = view.iterator()[0]
        assert expectLabel instanceof Label
        assert expectLabel.caption == 'label'
        assert view.iterator()[1].caption == 'click me'

        builder.registry.size() == 1
        builder.registry.luigi.caption == 'luigi caption'
    }

    @Test
    public void testBuilderDoubleName() {

        def builder = new VaadinBuilder();

        shouldFail(RuntimeException) {
            builder.verticalLayout {
                button('luigi', caption: 'luigi1')
                button('luigi', caption: 'luigi2')
            }
        }


    }
}
