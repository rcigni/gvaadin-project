package com.bytecode.vaadin.builder

import com.vaadin.shared.ui.MarginInfo
import com.vaadin.ui.*
import org.codehaus.groovy.runtime.typehandling.GroovyCastException
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

        def view = builder.verticalLayout(id: 'outher') {
            label(value: 'label')
            button(caption: "click me")

            shouldFail {
                assert inner
            }

            verticalLayout(id: 'inner') {
                assert inner
                assert outher
            }

            assert inner
            assert outher
        }

        assert view instanceof VerticalLayout
        def expectLabel = view.iterator()[0]
        assert expectLabel instanceof Label
        assert expectLabel.value == 'label'
        assert view.iterator()[1].caption == 'click me'

    }

    @Test
    public void testBuilderExpand() {

        def builder = new VaadinBuilder();
        def v0, v1, v2

        def view = builder.verticalLayout() {
            v0 = button(caption: "click me")
            v1 = button(caption: "click me", expandRatio: 10f)
            v2 = button(caption: "click me")

        }
        assert view.getExpandRatio(v0) == 0f
        assert view.getExpandRatio(v1) == 10f
        assert view.getExpandRatio(v2) == 0f
    }


    @Test
    public void testMargins() {

        VerticalLayout layout = new VaadinBuilder().verticalLayout(margin: new MarginInfo(true));
        assertTrueMargin(layout.margin)

        shouldFail(GroovyCastException.class) {
            new VaadinBuilder().verticalLayout(margin: true);
        }

    }

    static assertTrueMargin(MarginInfo mi) {
        assert mi.hasLeft() && mi.hasRight() && mi.hasTop() && mi.hasBottom()
    }

}
