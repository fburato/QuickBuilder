package org.pitest.quickbuilder.common;

import org.pitest.quickbuilder.Builder;
import org.pitest.quickbuilder.Maybe;

/**
 * Builds a constant value
 *
 * @param <T> Type to build
 */
public class ConstantBuilder<T> implements Builder<T> {

  private final T value;

  public ConstantBuilder(final T value) {
    this.value = value;
  }

  public static <T> ConstantBuilder<T> constant(T value) {
    return new ConstantBuilder<T>(value);
  }
  
  @Override
  public T build() {
    return this.value;
  }

  @Override
  public Maybe<Builder<T>> next() {
    return Maybe.<Builder<T>> some(this);
  }

}
