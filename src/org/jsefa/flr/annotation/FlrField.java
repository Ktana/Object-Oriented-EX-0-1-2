/*
 * Copyright 2007 the original author or authors.
 *
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
 */

package org.jsefa.flr.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.jsefa.SerializationException;
import org.jsefa.common.annotation.NoConverterType;
import org.jsefa.common.annotation.NoValidatorType;
import org.jsefa.common.annotation.SimpleListItem;
import org.jsefa.common.converter.SimpleTypeConverter;
import org.jsefa.common.util.GeneralConstants;
import org.jsefa.common.validator.Validator;
import org.jsefa.flr.lowlevel.Align;

/**
 * FLR field annotation.
 * 
 * @author Norman Lahme-Huetig
 * 
 */
@Retention(RUNTIME)
@Target({FIELD})
public @interface FlrField {
    /**
     * The position of the field with the following semantic:
     * <p>
     * If the position of a field A is less than the position of a field B, than field A comes (not necessarily
     * directly) before field B.<br>
     * The positions of all fields must specify a total order.
     */
    int pos();

    /**
     * The name of the data type of the FLR field this annotation describes. If not set, it must be determinable
     * from the type of the annotated java field.
     * <p>
     * It should be explicitly set if the type mapping should not be created from the annotations given in the
     * class of the annotated field. This is useful when mixing explicit type mapping creation with annotation
     * based type mapping creation.
     */
    String dataTypeName() default "";

    /**
     * The format to be used to construct a <code>SimpleTypeConverter</code> for this field. The
     * <code>SimpleTypeConverter</code> class will be determined using the type of the annotated java field.
     */
    String[] format() default {};

    /**
     * The length of the field in characters. If not specified the field type must be complex.
     */
    int length() default -1;
    
	/**
	 * Relevant for the serializing operation. If set to <code>true</code> an overlong field value will 
	 * be cropped to the specified length (column width). Default behavior until JSefa version 0.9.4. 
	 * If set to <code>false</code> a {@link SerializationException} is thrown in case of an overlong value 
	 * length (default behavior now).
	 * <p />
	 * Remind that configuring this setting to <code>true</code> generally may suit to string fields but 
	 * is less favorable for {@link java.util.Date} and other data types. By setting to <code>true</code> you
	 * may loose information while serializing. 
	 */
	boolean crop() default false;

    /**
     * The pad character used to fill empty space.
     */
    char padCharacter() default GeneralConstants.DEFAULT_CHARACTER;

    /**
     * The alignment of values which length is less than the required fixed length.
     */
    Align align() default Align.LEFT;

    /**
     * Specifies the converter type to be used. In the default case the converter type is determined using the type
     * of the annotated java field.
     */
    Class<? extends SimpleTypeConverter> converterType() default NoConverterType.class;

    /**
     * In case of a simple type list this annotation parameter provides details about the list items.
     */
    SimpleListItem listItem() default @SimpleListItem();
    
    /**
     * True, if a value is required; false otherwise.
     */
    boolean required() default false;

    /**
     * Specifies the validator type to be used. In the default case the validator type is determined using the type
     * of the java field with this annotation.
     */
    Class<? extends Validator> validatorType() default NoValidatorType.class;

    /**
     * The constraints to validate. Each constraint is a String of the form 'name=value' where name is the name of
     * the constraint and value is its value. The allowed set of constraints depend on the validator type. 
     */
    String[] constraints() default {};    
    
}
