package com.example.beans.primitives;

import org.pitest.quickbuilder.Builder;
import org.pitest.quickbuilder.QuickBuilderError;
import org.pitest.quickbuilder.internal.StoredValueBuilder;

public class PrimitiveBeanBuilderImpl implements PrimitiveBeanBuilder {
  
  private Builder<Integer> i;
  private Builder<Boolean> b;
  private Builder<Byte> by;
  private Builder<Character> c;
  private Builder<Double> d;
  private Builder<Float> f;
  private Builder<Long> l;
  private Builder<Short> s;
  private Builder<byte[]> ba;

  @Override
  public PrimitiveBean build() {
    PrimitiveBean pb = new PrimitiveBean();
    if ( i != null ) {
      pb.setI(i.build());
    }
    
    if ( l != null ) {
      pb.setL(l.build());
    }
    return pb;
  }

  @Override
  public Builder<PrimitiveBean> but() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PrimitiveBeanBuilder withI(int i) {
    this.i = new StoredValueBuilder<Integer>(i);
    return this;
  }
  
  public int _I() {
    if ( this.i == null ) {
      throw new QuickBuilderError("Trying to access property but no value has been set"  );
    }
    return i.build();
  }
  
  public byte[] _B() {
    return this.ba.build();
  }

  @Override
  public PrimitiveBeanBuilder withL(long l) {
    this.l = new StoredValueBuilder<Long>(l);
    return this;
  }

  @Override
  public PrimitiveBeanBuilder withF(float f) {
    this.f = new StoredValueBuilder<Float>(f);
    return this;
  }

  @Override
  public PrimitiveBeanBuilder withD(double f) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PrimitiveBeanBuilder withS(short s) {
    this.s = new StoredValueBuilder<Short>(s);
    return this;
  }

  @Override
  public PrimitiveBeanBuilder withC(char c) {
    this.c = new StoredValueBuilder<Character>(c);
    return this; 
  }

  @Override
  public PrimitiveBeanBuilder withB(boolean b) {
    this.b = new StoredValueBuilder<Boolean>(b);
    return this;
  }

  @Override
  public PrimitiveBeanBuilder withBy(byte by) {
    this.by = new StoredValueBuilder<Byte>(by);
    return this;
  }
  
  public PrimitiveBeanBuilder withBa(byte[] ba) {
    this.ba = new StoredValueBuilder<byte[]>(ba);
    return this;
  }

}
