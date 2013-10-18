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
            label(value: 'label')
            button(caption: "click me")
            button('luigi', caption: 'luigi caption')
        }

        assert view instanceof VerticalLayout
        def expectLabel = view.iterator()[0]
        assert expectLabel instanceof Label
        assert expectLabel.value == 'label'
        assert view.iterator()[1].caption == 'click me'

        assert builder.registry.size() == 1
        assert builder.registry.luigi.caption == 'luigi caption'
    }

    @Test
    public void testPanels() {

        def builder = new VaadinBuilder();

        def view = builder.panel {
            verticalLayout {
                horizontalLayout()
                horizontalLayout()
                horizontalLayout()
            }
        }

    }

    @Test
    public void testClick() {

        def builder = new VaadinBuilder();

        def view = builder.verticalLayout {
            button('click1')
        }

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
