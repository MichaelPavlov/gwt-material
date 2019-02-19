package gwt.material.design.client.js;

import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class JsMaterial
{
    @JsMethod ( namespace = "M" )
    public static native void textareaAutoResize(JQueryElement element);

    @JsMethod ( namespace = "M" )
    public static native void validate_field(JQueryElement element);
}
