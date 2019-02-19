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
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;
import gwt.material.design.client.base.BaseCheckBox;
import gwt.material.design.client.base.HasGrid;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.mixin.GridMixin;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.CheckBoxType;
import gwt.material.design.client.constants.CssName;

import static gwt.material.design.jquery.client.api.JQuery.$;

//@formatter:off

/**
 * Checkbox component provides two types
 * - FILLED
 * - INTERMEDIATE
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 * // Default
 * <m:MaterialCheckBox text="Option 1"/>
 *
 * // Filled
 * <m:MaterialCheckBox text="Option 1" type="FILLED"/>
 * }
 * </pre>
 * </p>
 *
 * @author kevzlou7979
 * @author Ben Dol
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#checkbox">CheckBox</a>
 * @see <a href="https://material.io/guidelines/components/selection-controls.html#selection-controls-checkbox">Material Design Specification</a>
 */
public class MaterialCheckBox extends BaseCheckBox implements HasType<CheckBoxType>, HasGrid {

    private Object object;

    private GridMixin<MaterialCheckBox> gridMixin;
    private ToggleStyleMixin<MaterialCheckBox> toggleOldMixin;

    private CheckBoxType type;

    /**
     * Creates a check box with no label.
     */
    public MaterialCheckBox() {
        super(Document.get().createCheckInputElement());
    }

    /**
     * Creates a check box with the specified text label.
     *
     * @param label the check box's label
     * @param dir   the text's direction. Note that {@code DEFAULT} means direction
     *              should be inherited from the widget's parent element.
     */
    public MaterialCheckBox(SafeHtml label, Direction dir) {
        this();

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
    public MaterialCheckBox(SafeHtml label, DirectionEstimator directionEstimator) {
        this();

        setDirectionEstimator(directionEstimator);
        setHTML(label.asString());
    }

    /**
     * Creates a material check box with the specified text label.
     *
     * @param label the check box's label
     */
    public MaterialCheckBox(SafeHtml label) {
        this();

        setHTML(label.asString());
    }

    /**
     * Creates a check box with the specified text label.
     *
     * @param label  the check box's label
     * @param asHTML <code>true</code> to treat the specified label as html
     */
    public MaterialCheckBox(String label, boolean asHTML) {
        this();

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
    public MaterialCheckBox(String label, Direction dir) {
        this();

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
    public MaterialCheckBox(String label, DirectionEstimator directionEstimator) {
        this();

        setDirectionEstimator(directionEstimator);
        setText(label);
    }

    /**
     * Creates a check box with the specified text label.
     *
     * @param label the check box's label
     */
    public MaterialCheckBox(String label) {
        this();

        setText(label);
    }

    public MaterialCheckBox(String label, CheckBoxType type) {
        this(label);
        
        setType(type);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        getElement().getStyle().setDisplay(isVisible() ? Display.BLOCK : Display.NONE);
    }

    @Override
    public void setGrid(String grid) {
        getGridMixin().setGrid(grid);
    }

    @Override
    public void setOffset(String offset) {
        getGridMixin().setOffset(offset);
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * Used the old checkbox.
     */
    public void setOld(boolean old) {
        getToggleOldMixin().setOn(old);
    }

    public boolean isOld() {
        return getToggleOldMixin().isOn();
    }

    /**
     * Setting the type of Checkbox.
     */
    public void setType(CheckBoxType type) {
        this.type = type;
        switch (type) {
            case FILLED:
                $(inputElem).addClass(CssName.FILLED_IN);
                break;
            case INTERMEDIATE:
                $(inputElem).prop("indeterminate", true);
                break;
            default:
                addStyleName(type.getCssName());
                break;
        }
    }

    public CheckBoxType getType() {
        return type;
    }

    public GridMixin<MaterialCheckBox> getGridMixin() {
        if (gridMixin == null) {
            gridMixin = new GridMixin<>(this);
        }
        return gridMixin;
    }

    public ToggleStyleMixin<MaterialCheckBox> getToggleOldMixin() {
        if (toggleOldMixin == null) {
            toggleOldMixin = new ToggleStyleMixin<>(this, CssName.OLD_CHECKBOX);
        }
        return toggleOldMixin;
    }
}
