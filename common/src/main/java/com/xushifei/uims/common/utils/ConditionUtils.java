package com.xushifei.uims.common.utils;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * <p>
 * 条件控制
 * </p>
 *
 * @author xushifei
 * @date 2021/5/14
 */
public class ConditionUtils {
    /**
     * 非空，接收
     *
     * @param value
     * @param consumer
     * @param <T>
     */
    public static <T> void acceptIfNotNull(T value, Consumer<T> consumer) {
        if (Objects.nonNull(value)) {
            consumer.accept(value);
        }
    }
    /**
     * 属性非空，接收
     *
     * @param property
     * @param consumer
     * @param <T>
     */
    public static <T> void acceptPropertyIfNotNull(Boolean condition,T property, Consumer<T> consumer) {

        if (Objects.nonNull(property)) {
            consumer.accept(property);
        }
    }
    /**
     * 非空，接收
     *
     * @param value
     * @param consumer
     * @param <T>
     */
    public static <T> void acceptIfNotBlank(T value, Consumer<T> consumer) {
        if (Objects.nonNull(value)) {
            consumer.accept(value);
        }
    }
    /**
     * 非空，接收
     *
     * @param value
     * @param consumer
     * @param <T>
     */
    public static <T> void acceptIfNotEmpty(Collection<T> value, Consumer<Collection<T>> consumer) {
        if (Objects.nonNull(value)) {
            consumer.accept(value);
        }
    }
}
