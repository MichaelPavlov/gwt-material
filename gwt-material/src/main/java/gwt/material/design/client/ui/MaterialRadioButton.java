/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RadioButton;
import gwt.material.design.client.base.BaseCheckBox;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.TypeWidget;
import gwt.material.design.client.base.mixin.CssTypeMixin;
import gwt.material.design.client.constants.RadioButtonType;

//@formatter:off

/**
 * Material Radio button has two types
 * - NO-GAP <br>
 * - GAP
 * <h3>UiBinder Usage:</h3>
 * <p>
 * <pre>
 * {@code
 * <m:MaterialRadioButton text="Sample"/>
 * <m:MaterialRadioButton type="GAP"/>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#radiobutton">Material Radio Button</a>
 * @see <a href="https://material.io/guidelines/components/selection-controls.html#selection-controls-radio-button">Material Design Specification</a>
 */
public class MaterialRadioButton extends BaseCheckBox implements HasType<RadioButtonType> {

    private CssTypeMixin<RadioButtonType, TypeWidget<RadioButtonType>> typeMixin;

    public MaterialRadioButton() {
        super(Document.get().createRadioInputElement(""));
    }

    public MaterialRadioButton(String name) {
        super(Document.get().createRadioInputElement(name));
    }

    /**
     * Creates a check box with the specified text label.
     *
     * @param label the check box's label
     * @param dir   the text's direction. Note that {@code DEFAULT} means direction
     *              should be inherited from the widget's parent element.
     */
    public MaterialRadioButton(String name, SafeHtml label, Direction dir) {
        this(name);

        setHTML(label, dir);
    }

    /**
     * Creates a label with the specified text and a default direction estimator.
     *
     * @param label              the check box's label
     * @param directionEstimator A DirectionEstimator object used for automatic
     *                           direction adjustment. For convenience,
     *                           {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
     */
    public MaterialRadioButton(String name, SafeHtml label, DirectionEstimator directionEstimator) {
        this(name);

        setDirectionEstimator(directionEstimator);
        setHTML(label.asString());
    }

    /**
     * Creates a material check box with the specified text label.
     *
     * @param label the check box's label
     */
    public MaterialRadioButton(String name, SafeHtml label) {
        this(name);

        setHTML(label.asString());
    }

    /**
     * Creates a check box with the specified text label.
     *
     * @param label  the check box's label
     * @param asHTML <code>true</code> to treat the specified label as html
     */
    public MaterialRadioButton(String name, String label, boolean asHTML) {
        this(name);

        if (asHTML) {
            setHTML(label);
        } else {
            setText(label);
        }
    }

    /**
     * Creates a check box with the specified text label.
     *
     * @param label the check box's label
     * @param dir   the text's direction. Note that {@code DEFAULT} means direction
     *              should be inherited from the widget's parent element.
     */
    public MaterialRadioButton(String name, String label, Direction dir) {
        this(name);

        setText(label, dir);
    }

    /**
     * Creates a label with the specified text and a default direction estimator.
     *
     * @param label              the check box's label
     * @param directionEstimator A DirectionEstimator object used for automatic
     *                           direction adjustment. For convenience,
     *                           {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
     */
    public MaterialRadioButton(String name, String label, DirectionEstimator directionEstimator) {
        this(name);

        setDirectionEstimator(directionEstimator);
        setText(label);
    }

    /**
     * Creates a check box with the specified text label.
     *
     * @param label the check box's label
     */
    public MaterialRadioButton(String name, String label) {
        this(name);

        setText(label);
    }

    public MaterialRadioButton(String name, String label, RadioButtonType type) {
        this(name, label);

        setType(type);
    }


    @Override
    public RadioButtonType getType() {
        return getTypeMixin().getType();
    }

    @Override
    public void setType(RadioButtonType type) {
        getTypeMixin().setType(type);
    }

    protected CssTypeMixin<RadioButtonType, TypeWidget<RadioButtonType>> getTypeMixin() {
        if (typeMixin == null) {
            typeMixin = new CssTypeMixin<>(new TypeWidget<>(DOM.getChild(getElement(), 0)));
        }
        return typeMixin;
    }
}
