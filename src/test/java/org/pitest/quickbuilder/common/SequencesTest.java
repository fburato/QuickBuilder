package org.pitest.quickbuilder.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.Test;
import org.pitest.quickbuilder.Builder;
import org.pitest.quickbuilder.SequenceBuilder;
import org.pitest.quickbuilder.builders.Builders;
import org.pitest.quickbuilder.builders.QB;
import org.pitest.quickbuilder.common.Sequences;

import com.example.beans.FruitBean;
import com.example.beans.FruitBuilder;

public class SequencesTest {
  
  @Test
  public void shouldReturnValuesOnlyOnce() {
    final SequenceBuilder<String> builder = Builders.once("foo");
    assertThat(builder.buildAll()).containsExactly("foo");
  }
  
  @Test
  public void shouldRepeatBuilders() {
    final SequenceBuilder<String> builder = Builders.repeat(Builders.constant("foo"), 2);
    assertThat(builder.buildAll()).containsExactly("foo", "foo");
  }

  @Test
  public void shouldReturnSameInstanceOnRepeatedRequests() {
    final Builder<FruitBean> builder = Builders.theSame(QB.builder(FruitBuilder.class));
    assertThat(builder.build()).isSameAs(builder.build());
  }

  @Test
  public void shouldAllowUserToBuildNulls() {
    final SequenceBuilder<String> builder = Builders.once(Builders.<String>nullValue());
    assertThat(builder.build()).isNull();
  }
  
  @Test
  public void shouldAllowUserToBuildSequencesOfIntegers() {
    final SequenceBuilder<Integer> builder = Builders.integersFrom(2);
    assertThat(builder.build(3)).containsExactly(2,3,4);
  }
  
  
  @Test
  public void shouldConvertValuesToStrings() {
    final SequenceBuilder<String> builder = Builders.asString(Builders.integersFrom(1));
    assertThat(builder.build(3)).containsExactly("1","2","3");
  }
  
  @Test
  public void shouldCreateIterators() {
    Iterator<Integer> it = Sequences.iterator(Builders.integersFrom(1));
    assertThat(it.next()).isEqualTo(1);
    assertThat(it.next()).isEqualTo(2);    
  }
  
  @Test
  public void shouldComposeBuilder() {
    @SuppressWarnings("unchecked")
    SequenceBuilder<String> actual = Builders.compose(Builders.once("foo"), Builders.once("bar"));
    assertThat(actual.buildAll()).containsExactly("foo", "bar");
  }

}
